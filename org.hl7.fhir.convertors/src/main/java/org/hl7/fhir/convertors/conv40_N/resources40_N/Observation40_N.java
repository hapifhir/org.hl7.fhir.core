package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Annotation40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Range40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.SimpleQuantity40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Instant40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.Enumerations;

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

public class Observation40_N {

  public static org.hl7.fhir.model.core.Observation convertObservation(org.hl7.fhir.r4.model.Observation src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Observation tgt = new org.hl7.fhir.model.core.Observation();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference40_N.convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getPartOf()) tgt.addPartOf(Reference40_N.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertObservationStatus(src.getStatusElement()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    if (src.hasSubject())
      tgt.setSubject(Reference40_N.convertReference(src.getSubject()));
    for (org.hl7.fhir.r4.model.Reference t : src.getFocus()) tgt.addFocus(Reference40_N.convertReference(t));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_N.convertReference(src.getEncounter()));
    if (src.hasEffective())
      tgt.setEffective(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getEffective()));
    if (src.hasIssued())
      tgt.setIssuedElement(Instant40_N.convertInstant(src.getIssuedElement()));
    for (org.hl7.fhir.r4.model.Reference t : src.getPerformer()) tgt.addPerformer(Reference40_N.convertReference(t));
    if (src.hasValue()) {
      tgt.setValue(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getValue()));
    }

    if (src.hasDataAbsentReason())
      tgt.setDataAbsentReason(CodeableConcept40_N.convertCodeableConcept(src.getDataAbsentReason()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getInterpretation())
      tgt.addInterpretation(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(Annotation40_N.convertAnnotation(t));
    if (src.hasBodySite())
      tgt.setBodySite(CodeableConcept40_N.convertCodeableConcept(src.getBodySite()));
    if (src.hasMethod())
      tgt.setMethod(CodeableConcept40_N.convertCodeableConcept(src.getMethod()));
    if (src.hasSpecimen())
      tgt.setSpecimen(Reference40_N.convertReference(src.getSpecimen()));
    if (src.hasDevice())
      tgt.setDevice(Reference40_N.convertReference(src.getDevice()));
    for (org.hl7.fhir.r4.model.Observation.ObservationReferenceRangeComponent t : src.getReferenceRange())
      tgt.addReferenceRange(convertObservationReferenceRangeComponent(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getHasMember()) tgt.addHasMember(Reference40_N.convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getDerivedFrom())
      tgt.addDerivedFrom(Reference40_N.convertReference(t));
    for (org.hl7.fhir.r4.model.Observation.ObservationComponentComponent t : src.getComponent())
      tgt.addComponent(convertObservationComponentComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Observation convertObservation(org.hl7.fhir.model.core.Observation src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Observation tgt = new org.hl7.fhir.r4.model.Observation();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    for (org.hl7.fhir.model.core.Reference t : src.getBasedOnList()) tgt.addBasedOn(Reference40_N.convertReference(t));
    for (org.hl7.fhir.model.core.Reference t : src.getPartOfList()) tgt.addPartOf(Reference40_N.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertObservationStatus(src.getStatusElement()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getCategoryList())
      tgt.addCategory(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    if (src.hasSubject())
      tgt.setSubject(Reference40_N.convertReference(src.getSubject()));
    for (org.hl7.fhir.model.core.Reference t : src.getFocusList()) tgt.addFocus(Reference40_N.convertReference(t));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_N.convertReference(src.getEncounter()));
    if (src.hasEffective())
      tgt.setEffective(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getEffective()));
    if (src.hasIssued())
      tgt.setIssuedElement(Instant40_N.convertInstant(src.getIssuedElement()));
    for (org.hl7.fhir.model.core.Reference t : src.getPerformerList()) tgt.addPerformer(Reference40_N.convertReference(t));
    if (src.hasValue()) {
      tgt.setValue(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getValue()));
    }
    if (src.hasDataAbsentReason())
      tgt.setDataAbsentReason(CodeableConcept40_N.convertCodeableConcept(src.getDataAbsentReason()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getInterpretationList())
      tgt.addInterpretation(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.Annotation t : src.getNoteList()) tgt.addNote(Annotation40_N.convertAnnotation(t));
    if (src.hasBodySite())
      tgt.setBodySite(CodeableConcept40_N.convertCodeableConcept(src.getBodySite()));
    if (src.hasMethod())
      tgt.setMethod(CodeableConcept40_N.convertCodeableConcept(src.getMethod()));
    if (src.hasSpecimen())
      tgt.setSpecimen(Reference40_N.convertReference(src.getSpecimen()));
    if (src.hasDevice())
      tgt.setDevice(Reference40_N.convertReference(src.getDevice()));
    for (org.hl7.fhir.model.core.Observation.ObservationReferenceRangeComponent t : src.getReferenceRangeList())
      tgt.addReferenceRange(convertObservationReferenceRangeComponent(t));
    for (org.hl7.fhir.model.core.Reference t : src.getHasMemberList()) tgt.addHasMember(Reference40_N.convertReference(t));
    for (org.hl7.fhir.model.core.Reference t : src.getDerivedFromList())
      tgt.addDerivedFrom(Reference40_N.convertReference(t));
    for (org.hl7.fhir.model.core.Observation.ObservationComponentComponent t : src.getComponentList())
      tgt.addComponent(convertObservationComponentComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ObservationStatus> convertObservationStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Observation.ObservationStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.ObservationStatus> tgt = new Enumeration<>(new Enumerations.ObservationStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case REGISTERED:
                  tgt.setValue(Enumerations.ObservationStatus.REGISTERED);
                  break;
              case PRELIMINARY:
                  tgt.setValue(Enumerations.ObservationStatus.PRELIMINARY);
                  break;
              case FINAL:
                  tgt.setValue(Enumerations.ObservationStatus.FINAL);
                  break;
              case AMENDED:
                  tgt.setValue(Enumerations.ObservationStatus.AMENDED);
                  break;
              case CORRECTED:
                  tgt.setValue(Enumerations.ObservationStatus.CORRECTED);
                  break;
              case CANCELLED:
                  tgt.setValue(Enumerations.ObservationStatus.CANCELLED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(Enumerations.ObservationStatus.ENTEREDINERROR);
                  break;
              case UNKNOWN:
                  tgt.setValue(Enumerations.ObservationStatus.UNKNOWN);
                  break;
              default:
                  tgt.setValue(Enumerations.ObservationStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Observation.ObservationStatus> convertObservationStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ObservationStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<Observation.ObservationStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new Observation.ObservationStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case REGISTERED:
                  tgt.setValue(Observation.ObservationStatus.REGISTERED);
                  break;
              case PRELIMINARY:
                  tgt.setValue(Observation.ObservationStatus.PRELIMINARY);
                  break;
              case FINAL:
                  tgt.setValue(Observation.ObservationStatus.FINAL);
                  break;
              case AMENDED:
                  tgt.setValue(Observation.ObservationStatus.AMENDED);
                  break;
              case CORRECTED:
                  tgt.setValue(Observation.ObservationStatus.CORRECTED);
                  break;
              case CANCELLED:
                  tgt.setValue(Observation.ObservationStatus.CANCELLED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(Observation.ObservationStatus.ENTEREDINERROR);
                  break;
              case UNKNOWN:
                  tgt.setValue(Observation.ObservationStatus.UNKNOWN);
                  break;
              default:
                  tgt.setValue(Observation.ObservationStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.Observation.ObservationReferenceRangeComponent convertObservationReferenceRangeComponent(org.hl7.fhir.r4.model.Observation.ObservationReferenceRangeComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Observation.ObservationReferenceRangeComponent tgt = new org.hl7.fhir.model.core.Observation.ObservationReferenceRangeComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasLow())
      tgt.setLow(SimpleQuantity40_N.convertSimpleQuantity(src.getLow()));
    if (src.hasHigh())
      tgt.setHigh(SimpleQuantity40_N.convertSimpleQuantity(src.getHigh()));
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getAppliesTo())
      tgt.addAppliesTo(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasAge())
      tgt.setAge(Range40_N.convertRange(src.getAge()));
    if (src.hasText())
      tgt.setTextElement(String40_N.convertStringToMarkdown(src.getTextElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Observation.ObservationReferenceRangeComponent convertObservationReferenceRangeComponent(org.hl7.fhir.model.core.Observation.ObservationReferenceRangeComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Observation.ObservationReferenceRangeComponent tgt = new org.hl7.fhir.r4.model.Observation.ObservationReferenceRangeComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasLow())
      tgt.setLow(SimpleQuantity40_N.convertSimpleQuantity(src.getLow()));
    if (src.hasHigh())
      tgt.setHigh(SimpleQuantity40_N.convertSimpleQuantity(src.getHigh()));
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getAppliesToList())
      tgt.addAppliesTo(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasAge())
      tgt.setAge(Range40_N.convertRange(src.getAge()));
    if (src.hasText())
      tgt.setTextElement(String40_N.convertString(src.getTextElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Observation.ObservationComponentComponent convertObservationComponentComponent(org.hl7.fhir.r4.model.Observation.ObservationComponentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Observation.ObservationComponentComponent tgt = new org.hl7.fhir.model.core.Observation.ObservationComponentComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    if (src.hasValue()) {
      tgt.setValue(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getValue()));
    }
    if (src.hasDataAbsentReason())
      tgt.setDataAbsentReason(CodeableConcept40_N.convertCodeableConcept(src.getDataAbsentReason()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getInterpretation())
      tgt.addInterpretation(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.Observation.ObservationReferenceRangeComponent t : src.getReferenceRange())
      tgt.addReferenceRange(convertObservationReferenceRangeComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Observation.ObservationComponentComponent convertObservationComponentComponent(org.hl7.fhir.model.core.Observation.ObservationComponentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Observation.ObservationComponentComponent tgt = new org.hl7.fhir.r4.model.Observation.ObservationComponentComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    if (src.hasValue()) {
      tgt.setValue(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getValue()));
    }
    if (src.hasDataAbsentReason())
      tgt.setDataAbsentReason(CodeableConcept40_N.convertCodeableConcept(src.getDataAbsentReason()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getInterpretationList())
      tgt.addInterpretation(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.Observation.ObservationReferenceRangeComponent t : src.getReferenceRangeList())
      tgt.addReferenceRange(convertObservationReferenceRangeComponent(t));
    return tgt;
  }
}