package org.hl7.fhir.convertors.conv40_50.resources40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Address40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Attachment40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.CodeableConcept40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.ContactPoint40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.HumanName40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Identifier40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Period40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Boolean40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Date40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Reference40_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.Practitioner.PractitionerCommunicationComponent;

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
public class Practitioner40_50 {

  public static org.hl7.fhir.r5.model.Practitioner convertPractitioner(org.hl7.fhir.r4.model.Practitioner src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Practitioner tgt = new org.hl7.fhir.r5.model.Practitioner();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    if (src.hasActive())
      tgt.setActiveElement(Boolean40_50.convertBoolean(src.getActiveElement()));
    for (org.hl7.fhir.r4.model.HumanName t : src.getName()) tgt.addName(HumanName40_50.convertHumanName(t));
    for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint40_50.convertContactPoint(t));
    for (org.hl7.fhir.r4.model.Address t : src.getAddress()) tgt.addAddress(Address40_50.convertAddress(t));
    if (src.hasGender())
      tgt.setGenderElement(Enumerations40_50.convertAdministrativeGender(src.getGenderElement()));
    if (src.hasBirthDate())
      tgt.setBirthDateElement(Date40_50.convertDate(src.getBirthDateElement()));
    for (org.hl7.fhir.r4.model.Attachment t : src.getPhoto()) tgt.addPhoto(Attachment40_50.convertAttachment(t));
    for (org.hl7.fhir.r4.model.Practitioner.PractitionerQualificationComponent t : src.getQualification())
      tgt.addQualification(convertPractitionerQualificationComponent(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCommunication())
      tgt.addCommunication().setLanguage(CodeableConcept40_50.convertCodeableConcept(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Practitioner convertPractitioner(org.hl7.fhir.r5.model.Practitioner src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Practitioner tgt = new org.hl7.fhir.r4.model.Practitioner();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    if (src.hasActive())
      tgt.setActiveElement(Boolean40_50.convertBoolean(src.getActiveElement()));
    for (org.hl7.fhir.r5.model.HumanName t : src.getName()) tgt.addName(HumanName40_50.convertHumanName(t));
    for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint40_50.convertContactPoint(t));
    for (org.hl7.fhir.r5.model.Address t : src.getAddress()) tgt.addAddress(Address40_50.convertAddress(t));
    if (src.hasGender())
      tgt.setGenderElement(Enumerations40_50.convertAdministrativeGender(src.getGenderElement()));
    if (src.hasBirthDate())
      tgt.setBirthDateElement(Date40_50.convertDate(src.getBirthDateElement()));
    for (org.hl7.fhir.r5.model.Attachment t : src.getPhoto()) tgt.addPhoto(Attachment40_50.convertAttachment(t));
    for (org.hl7.fhir.r5.model.Practitioner.PractitionerQualificationComponent t : src.getQualification())
      tgt.addQualification(convertPractitionerQualificationComponent(t));
    for (PractitionerCommunicationComponent t : src.getCommunication())
      tgt.addCommunication(CodeableConcept40_50.convertCodeableConcept(t.getLanguage()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Practitioner.PractitionerQualificationComponent convertPractitionerQualificationComponent(org.hl7.fhir.r4.model.Practitioner.PractitionerQualificationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Practitioner.PractitionerQualificationComponent tgt = new org.hl7.fhir.r5.model.Practitioner.PractitionerQualificationComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_50.convertCodeableConcept(src.getCode()));
    if (src.hasPeriod())
      tgt.setPeriod(Period40_50.convertPeriod(src.getPeriod()));
    if (src.hasIssuer())
      tgt.setIssuer(Reference40_50.convertReference(src.getIssuer()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Practitioner.PractitionerQualificationComponent convertPractitionerQualificationComponent(org.hl7.fhir.r5.model.Practitioner.PractitionerQualificationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Practitioner.PractitionerQualificationComponent tgt = new org.hl7.fhir.r4.model.Practitioner.PractitionerQualificationComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_50.convertCodeableConcept(src.getCode()));
    if (src.hasPeriod())
      tgt.setPeriod(Period40_50.convertPeriod(src.getPeriod()));
    if (src.hasIssuer())
      tgt.setIssuer(Reference40_50.convertReference(src.getIssuer()));
    return tgt;
  }
}