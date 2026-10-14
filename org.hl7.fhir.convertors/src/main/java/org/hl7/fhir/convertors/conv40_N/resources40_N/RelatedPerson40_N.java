package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Address40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Attachment40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.ContactPoint40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.HumanName40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Period40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Boolean40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Date40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
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

public class RelatedPerson40_N {

  public static org.hl7.fhir.model.core.RelatedPerson convertRelatedPerson(org.hl7.fhir.r4.model.RelatedPerson src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.RelatedPerson tgt = new org.hl7.fhir.model.core.RelatedPerson();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasActive())
      tgt.setActiveElement(Boolean40_N.convertBoolean(src.getActiveElement()));
    if (src.hasPatient())
      tgt.setPatient(Reference40_N.convertReference(src.getPatient()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getRelationship())
      tgt.addRelationship(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.HumanName t : src.getName()) tgt.addName(HumanName40_N.convertHumanName(t));
    for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint40_N.convertContactPoint(t));
    if (src.hasGender())
      tgt.setGenderElement(Enumerations40_N.convertAdministrativeGender(src.getGenderElement()));
    if (src.hasBirthDate())
      tgt.setBirthDateElement(Date40_N.convertDate(src.getBirthDateElement()));
    for (org.hl7.fhir.r4.model.Address t : src.getAddress()) tgt.addAddress(Address40_N.convertAddress(t));
    for (org.hl7.fhir.r4.model.Attachment t : src.getPhoto()) tgt.addPhoto(Attachment40_N.convertAttachment(t));
    if (src.hasPeriod())
      tgt.setPeriod(Period40_N.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.r4.model.RelatedPerson.RelatedPersonCommunicationComponent t : src.getCommunication())
      tgt.addCommunication(convertRelatedPersonCommunicationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.RelatedPerson convertRelatedPerson(org.hl7.fhir.model.core.RelatedPerson src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.RelatedPerson tgt = new org.hl7.fhir.r4.model.RelatedPerson();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasActive())
      tgt.setActiveElement(Boolean40_N.convertBoolean(src.getActiveElement()));
    if (src.hasPatient())
      tgt.setPatient(Reference40_N.convertReference(src.getPatient()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getRelationshipList())
      tgt.addRelationship(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.HumanName t : src.getNameList()) tgt.addName(HumanName40_N.convertHumanName(t));
    for (org.hl7.fhir.model.core.ContactPoint t : src.getTelecomList())
      tgt.addTelecom(ContactPoint40_N.convertContactPoint(t));
    if (src.hasGender())
      tgt.setGenderElement(Enumerations40_N.convertAdministrativeGender(src.getGenderElement()));
    if (src.hasBirthDate())
      tgt.setBirthDateElement(Date40_N.convertDate(src.getBirthDateElement()));
    for (org.hl7.fhir.model.core.Address t : src.getAddressList()) tgt.addAddress(Address40_N.convertAddress(t));
    for (org.hl7.fhir.model.core.Attachment t : src.getPhotoList()) tgt.addPhoto(Attachment40_N.convertAttachment(t));
    if (src.hasPeriod())
      tgt.setPeriod(Period40_N.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.model.core.RelatedPerson.RelatedPersonCommunicationComponent t : src.getCommunicationList())
      tgt.addCommunication(convertRelatedPersonCommunicationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.RelatedPerson.RelatedPersonCommunicationComponent convertRelatedPersonCommunicationComponent(org.hl7.fhir.r4.model.RelatedPerson.RelatedPersonCommunicationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.RelatedPerson.RelatedPersonCommunicationComponent tgt = new org.hl7.fhir.model.core.RelatedPerson.RelatedPersonCommunicationComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasLanguage())
      tgt.setLanguage(CodeableConcept40_N.convertCodeableConcept(src.getLanguage()));
    if (src.hasPreferred())
      tgt.setPreferredElement(Boolean40_N.convertBoolean(src.getPreferredElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.RelatedPerson.RelatedPersonCommunicationComponent convertRelatedPersonCommunicationComponent(org.hl7.fhir.model.core.RelatedPerson.RelatedPersonCommunicationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.RelatedPerson.RelatedPersonCommunicationComponent tgt = new org.hl7.fhir.r4.model.RelatedPerson.RelatedPersonCommunicationComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasLanguage())
      tgt.setLanguage(CodeableConcept40_N.convertCodeableConcept(src.getLanguage()));
    if (src.hasPreferred())
      tgt.setPreferredElement(Boolean40_N.convertBoolean(src.getPreferredElement()));
    return tgt;
  }
}