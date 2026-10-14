package org.hl7.fhir.convertors.conv43_N.resources43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Address43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Attachment43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.CodeableConcept43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.ContactPoint43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.HumanName43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Identifier43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Period43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Boolean43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Date43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Reference43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.Practitioner.PractitionerCommunicationComponent;

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

public class Practitioner43_N {

  public static org.hl7.fhir.model.core.Practitioner convertPractitioner(org.hl7.fhir.r4b.model.Practitioner src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Practitioner tgt = new org.hl7.fhir.model.core.Practitioner();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasActive())
      tgt.setActiveElement(Boolean43_N.convertBoolean(src.getActiveElement()));
    for (org.hl7.fhir.r4b.model.HumanName t : src.getName()) tgt.addName(HumanName43_N.convertHumanName(t));
    for (org.hl7.fhir.r4b.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint43_N.convertContactPoint(t));
    for (org.hl7.fhir.r4b.model.Address t : src.getAddress()) tgt.addAddress(Address43_N.convertAddress(t));
    if (src.hasGender())
      tgt.setGenderElement(Enumerations43_N.convertAdministrativeGender(src.getGenderElement()));
    if (src.hasBirthDate())
      tgt.setBirthDateElement(Date43_N.convertDate(src.getBirthDateElement()));
    for (org.hl7.fhir.r4b.model.Attachment t : src.getPhoto()) tgt.addPhoto(Attachment43_N.convertAttachment(t));
    for (org.hl7.fhir.r4b.model.Practitioner.PractitionerQualificationComponent t : src.getQualification())
      tgt.addQualification(convertPractitionerQualificationComponent(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getCommunication())
      tgt.addCommunication().setLanguage(CodeableConcept43_N.convertCodeableConcept(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Practitioner convertPractitioner(org.hl7.fhir.model.core.Practitioner src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Practitioner tgt = new org.hl7.fhir.r4b.model.Practitioner();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasActive())
      tgt.setActiveElement(Boolean43_N.convertBoolean(src.getActiveElement()));
    for (org.hl7.fhir.model.core.HumanName t : src.getNameList()) tgt.addName(HumanName43_N.convertHumanName(t));
    for (org.hl7.fhir.model.core.ContactPoint t : src.getTelecomList())
      tgt.addTelecom(ContactPoint43_N.convertContactPoint(t));
    for (org.hl7.fhir.model.core.Address t : src.getAddressList()) tgt.addAddress(Address43_N.convertAddress(t));
    if (src.hasGender())
      tgt.setGenderElement(Enumerations43_N.convertAdministrativeGender(src.getGenderElement()));
    if (src.hasBirthDate())
      tgt.setBirthDateElement(Date43_N.convertDate(src.getBirthDateElement()));
    for (org.hl7.fhir.model.core.Attachment t : src.getPhotoList()) tgt.addPhoto(Attachment43_N.convertAttachment(t));
    for (org.hl7.fhir.model.core.Practitioner.PractitionerQualificationComponent t : src.getQualificationList())
      tgt.addQualification(convertPractitionerQualificationComponent(t));
    for (PractitionerCommunicationComponent t : src.getCommunicationList())
      tgt.addCommunication(CodeableConcept43_N.convertCodeableConcept(t.getLanguage()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Practitioner.PractitionerQualificationComponent convertPractitionerQualificationComponent(org.hl7.fhir.r4b.model.Practitioner.PractitionerQualificationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Practitioner.PractitionerQualificationComponent tgt = new org.hl7.fhir.model.core.Practitioner.PractitionerQualificationComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_N.convertCodeableConcept(src.getCode()));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_N.convertPeriod(src.getPeriod()));
    if (src.hasIssuer())
      tgt.setIssuer(Reference43_N.convertReference(src.getIssuer()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Practitioner.PractitionerQualificationComponent convertPractitionerQualificationComponent(org.hl7.fhir.model.core.Practitioner.PractitionerQualificationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Practitioner.PractitionerQualificationComponent tgt = new org.hl7.fhir.r4b.model.Practitioner.PractitionerQualificationComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_N.convertCodeableConcept(src.getCode()));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_N.convertPeriod(src.getPeriod()));
    if (src.hasIssuer())
      tgt.setIssuer(Reference43_N.convertReference(src.getIssuer()));
    return tgt;
  }
}