package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Period43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Boolean43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50.Reference43_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableReference;

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
public class Schedule43_50 {

  public static org.hl7.fhir.r5.model.Schedule convertSchedule(org.hl7.fhir.r4b.model.Schedule src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Schedule tgt = new org.hl7.fhir.r5.model.Schedule();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasActive())
      tgt.setActiveElement(Boolean43_50.convertBoolean(src.getActiveElement()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getServiceCategory())
      tgt.addServiceCategory(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getServiceType())
      tgt.addServiceType(new CodeableReference().setConcept(CodeableConcept43_50.convertCodeableConcept(t)));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getSpecialty())
      tgt.addSpecialty(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getActor()) tgt.addActor(Reference43_50.convertReference(t));
    if (src.hasPlanningHorizon())
      tgt.setPlanningHorizon(Period43_50.convertPeriod(src.getPlanningHorizon()));
    if (src.hasComment())
      tgt.setCommentElement(String43_50.convertStringToMarkdown(src.getCommentElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Schedule convertSchedule(org.hl7.fhir.r5.model.Schedule src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Schedule tgt = new org.hl7.fhir.r4b.model.Schedule();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasActive())
      tgt.setActiveElement(Boolean43_50.convertBoolean(src.getActiveElement()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getServiceCategory())
      tgt.addServiceCategory(CodeableConcept43_50.convertCodeableConcept(t));
    for (CodeableReference t : src.getServiceType())
      if (t.hasConcept())
        tgt.addServiceType(CodeableConcept43_50.convertCodeableConcept(t.getConcept()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getSpecialty())
      tgt.addSpecialty(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getActor()) tgt.addActor(Reference43_50.convertReference(t));
    if (src.hasPlanningHorizon())
      tgt.setPlanningHorizon(Period43_50.convertPeriod(src.getPlanningHorizon()));
    if (src.hasComment())
      tgt.setCommentElement(String43_50.convertString(src.getCommentElement()));
    return tgt;
  }
}