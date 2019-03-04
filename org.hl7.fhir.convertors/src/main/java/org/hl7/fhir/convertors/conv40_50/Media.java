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


public class Media extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.Media convertMedia(org.hl7.fhir.r4.model.Media src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Media tgt = new org.hl7.fhir.r5.model.Media();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn())
      tgt.addBasedOn(convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getPartOf())
      tgt.addPartOf(convertReference(t));
    if (src.hasStatus())
      tgt.setStatus(convertMediaStatus(src.getStatus()));
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    if (src.hasModality())
      tgt.setModality(convertCodeableConcept(src.getModality()));
    if (src.hasView())
      tgt.setView(convertCodeableConcept(src.getView()));
    if (src.hasSubject())
      tgt.setSubject(convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(convertReference(src.getEncounter()));
    if (src.hasCreated())
      tgt.setCreated(convertType(src.getCreated()));
    if (src.hasIssued())
      tgt.setIssuedElement(convertInstant(src.getIssuedElement()));
    if (src.hasOperator())
      tgt.setOperator(convertReference(src.getOperator()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode())
      tgt.addReasonCode(convertCodeableConcept(t));
    if (src.hasBodySite())
      tgt.setBodySite(convertCodeableConcept(src.getBodySite()));
    if (src.hasDeviceName())
      tgt.setDeviceNameElement(convertString(src.getDeviceNameElement()));
    if (src.hasDevice())
      tgt.setDevice(convertReference(src.getDevice()));
    if (src.hasHeight())
      tgt.setHeightElement(convertPositiveInt(src.getHeightElement()));
    if (src.hasWidth())
      tgt.setWidthElement(convertPositiveInt(src.getWidthElement()));
    if (src.hasFrames())
      tgt.setFramesElement(convertPositiveInt(src.getFramesElement()));
    if (src.hasDuration())
      tgt.setDurationElement(convertDecimal(src.getDurationElement()));
    if (src.hasContent())
      tgt.setContent(convertAttachment(src.getContent()));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote())
      tgt.addNote(convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Media convertMedia(org.hl7.fhir.r5.model.Media src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Media tgt = new org.hl7.fhir.r4.model.Media();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn())
      tgt.addBasedOn(convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getPartOf())
      tgt.addPartOf(convertReference(t));
    if (src.hasStatus())
      tgt.setStatus(convertMediaStatus(src.getStatus()));
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    if (src.hasModality())
      tgt.setModality(convertCodeableConcept(src.getModality()));
    if (src.hasView())
      tgt.setView(convertCodeableConcept(src.getView()));
    if (src.hasSubject())
      tgt.setSubject(convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(convertReference(src.getEncounter()));
    if (src.hasCreated())
      tgt.setCreated(convertType(src.getCreated()));
    if (src.hasIssued())
      tgt.setIssuedElement(convertInstant(src.getIssuedElement()));
    if (src.hasOperator())
      tgt.setOperator(convertReference(src.getOperator()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getReasonCode())
      tgt.addReasonCode(convertCodeableConcept(t));
    if (src.hasBodySite())
      tgt.setBodySite(convertCodeableConcept(src.getBodySite()));
    if (src.hasDeviceName())
      tgt.setDeviceNameElement(convertString(src.getDeviceNameElement()));
    if (src.hasDevice())
      tgt.setDevice(convertReference(src.getDevice()));
    if (src.hasHeight())
      tgt.setHeightElement(convertPositiveInt(src.getHeightElement()));
    if (src.hasWidth())
      tgt.setWidthElement(convertPositiveInt(src.getWidthElement()));
    if (src.hasFrames())
      tgt.setFramesElement(convertPositiveInt(src.getFramesElement()));
    if (src.hasDuration())
      tgt.setDurationElement(convertDecimal(src.getDurationElement()));
    if (src.hasContent())
      tgt.setContent(convertAttachment(src.getContent()));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote())
      tgt.addNote(convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Media.MediaStatus convertMediaStatus(org.hl7.fhir.r4.model.Media.MediaStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case PREPARATION: return org.hl7.fhir.r5.model.Media.MediaStatus.PREPARATION;
    case INPROGRESS: return org.hl7.fhir.r5.model.Media.MediaStatus.INPROGRESS;
    case NOTDONE: return org.hl7.fhir.r5.model.Media.MediaStatus.NOTDONE;
    case ONHOLD: return org.hl7.fhir.r5.model.Media.MediaStatus.ONHOLD;
    case STOPPED: return org.hl7.fhir.r5.model.Media.MediaStatus.STOPPED;
    case COMPLETED: return org.hl7.fhir.r5.model.Media.MediaStatus.COMPLETED;
    case ENTEREDINERROR: return org.hl7.fhir.r5.model.Media.MediaStatus.ENTEREDINERROR;
    case UNKNOWN: return org.hl7.fhir.r5.model.Media.MediaStatus.UNKNOWN;
    default: return org.hl7.fhir.r5.model.Media.MediaStatus.NULL;
  }
}

  public static org.hl7.fhir.r4.model.Media.MediaStatus convertMediaStatus(org.hl7.fhir.r5.model.Media.MediaStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case PREPARATION: return org.hl7.fhir.r4.model.Media.MediaStatus.PREPARATION;
    case INPROGRESS: return org.hl7.fhir.r4.model.Media.MediaStatus.INPROGRESS;
    case NOTDONE: return org.hl7.fhir.r4.model.Media.MediaStatus.NOTDONE;
    case ONHOLD: return org.hl7.fhir.r4.model.Media.MediaStatus.ONHOLD;
    case STOPPED: return org.hl7.fhir.r4.model.Media.MediaStatus.STOPPED;
    case COMPLETED: return org.hl7.fhir.r4.model.Media.MediaStatus.COMPLETED;
    case ENTEREDINERROR: return org.hl7.fhir.r4.model.Media.MediaStatus.ENTEREDINERROR;
    case UNKNOWN: return org.hl7.fhir.r4.model.Media.MediaStatus.UNKNOWN;
    default: return org.hl7.fhir.r4.model.Media.MediaStatus.NULL;
  }
}


}
