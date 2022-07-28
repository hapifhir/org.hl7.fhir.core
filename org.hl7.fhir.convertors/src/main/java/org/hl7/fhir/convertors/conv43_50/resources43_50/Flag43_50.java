package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Period43_50;
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
public class Flag43_50 {

  public static org.hl7.fhir.r5.model.Flag convertFlag(org.hl7.fhir.r4b.model.Flag src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Flag tgt = new org.hl7.fhir.r5.model.Flag();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertFlagStatus(src.getStatusElement()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_50.convertCodeableConcept(src.getCode()));
    if (src.hasSubject())
      tgt.setSubject(Reference43_50.convertReference(src.getSubject()));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_50.convertPeriod(src.getPeriod()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference43_50.convertReference(src.getEncounter()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference43_50.convertReference(src.getAuthor()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Flag convertFlag(org.hl7.fhir.r5.model.Flag src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Flag tgt = new org.hl7.fhir.r4b.model.Flag();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertFlagStatus(src.getStatusElement()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_50.convertCodeableConcept(src.getCode()));
    if (src.hasSubject())
      tgt.setSubject(Reference43_50.convertReference(src.getSubject()));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_50.convertPeriod(src.getPeriod()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference43_50.convertReference(src.getEncounter()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference43_50.convertReference(src.getAuthor()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Flag.FlagStatus> convertFlagStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Flag.FlagStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Flag.FlagStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Flag.FlagStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r5.model.Flag.FlagStatus.ACTIVE);
        break;
      case INACTIVE:
        tgt.setValue(org.hl7.fhir.r5.model.Flag.FlagStatus.INACTIVE);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r5.model.Flag.FlagStatus.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Flag.FlagStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Flag.FlagStatus> convertFlagStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Flag.FlagStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Flag.FlagStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Flag.FlagStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r4b.model.Flag.FlagStatus.ACTIVE);
        break;
      case INACTIVE:
        tgt.setValue(org.hl7.fhir.r4b.model.Flag.FlagStatus.INACTIVE);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4b.model.Flag.FlagStatus.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.Flag.FlagStatus.NULL);
        break;
    }
    return tgt;
  }
}