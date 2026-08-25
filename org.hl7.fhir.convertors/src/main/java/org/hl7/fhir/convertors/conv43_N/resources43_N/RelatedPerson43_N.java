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

public class RelatedPerson43_N {

  public static org.hl7.fhir.model.core.RelatedPerson convertRelatedPerson(org.hl7.fhir.r4b.model.RelatedPerson src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.RelatedPerson tgt = new org.hl7.fhir.model.core.RelatedPerson();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasActive())
      tgt.setActiveElement(Boolean43_N.convertBoolean(src.getActiveElement()));
    if (src.hasPatient())
      tgt.setPatient(Reference43_N.convertReference(src.getPatient()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getRelationship())
      tgt.addRelationship(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.HumanName t : src.getName()) tgt.addName(HumanName43_N.convertHumanName(t));
    for (org.hl7.fhir.r4b.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint43_N.convertContactPoint(t));
    if (src.hasGender())
      tgt.setGenderElement(Enumerations43_N.convertAdministrativeGender(src.getGenderElement()));
    if (src.hasBirthDate())
      tgt.setBirthDateElement(Date43_N.convertDate(src.getBirthDateElement()));
    for (org.hl7.fhir.r4b.model.Address t : src.getAddress()) tgt.addAddress(Address43_N.convertAddress(t));
    for (org.hl7.fhir.r4b.model.Attachment t : src.getPhoto()) tgt.addPhoto(Attachment43_N.convertAttachment(t));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_N.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.r4b.model.RelatedPerson.RelatedPersonCommunicationComponent t : src.getCommunication())
      tgt.addCommunication(convertRelatedPersonCommunicationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.RelatedPerson convertRelatedPerson(org.hl7.fhir.model.core.RelatedPerson src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.RelatedPerson tgt = new org.hl7.fhir.r4b.model.RelatedPerson();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasActive())
      tgt.setActiveElement(Boolean43_N.convertBoolean(src.getActiveElement()));
    if (src.hasPatient())
      tgt.setPatient(Reference43_N.convertReference(src.getPatient()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getRelationshipList())
      tgt.addRelationship(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.HumanName t : src.getNameList()) tgt.addName(HumanName43_N.convertHumanName(t));
    for (org.hl7.fhir.model.core.ContactPoint t : src.getTelecomList())
      tgt.addTelecom(ContactPoint43_N.convertContactPoint(t));
    if (src.hasGender())
      tgt.setGenderElement(Enumerations43_N.convertAdministrativeGender(src.getGenderElement()));
    if (src.hasBirthDate())
      tgt.setBirthDateElement(Date43_N.convertDate(src.getBirthDateElement()));
    for (org.hl7.fhir.model.core.Address t : src.getAddressList()) tgt.addAddress(Address43_N.convertAddress(t));
    for (org.hl7.fhir.model.core.Attachment t : src.getPhotoList()) tgt.addPhoto(Attachment43_N.convertAttachment(t));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_N.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.model.core.RelatedPerson.RelatedPersonCommunicationComponent t : src.getCommunicationList())
      tgt.addCommunication(convertRelatedPersonCommunicationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.RelatedPerson.RelatedPersonCommunicationComponent convertRelatedPersonCommunicationComponent(org.hl7.fhir.r4b.model.RelatedPerson.RelatedPersonCommunicationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.RelatedPerson.RelatedPersonCommunicationComponent tgt = new org.hl7.fhir.model.core.RelatedPerson.RelatedPersonCommunicationComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasLanguage())
      tgt.setLanguage(CodeableConcept43_N.convertCodeableConcept(src.getLanguage()));
    if (src.hasPreferred())
      tgt.setPreferredElement(Boolean43_N.convertBoolean(src.getPreferredElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.RelatedPerson.RelatedPersonCommunicationComponent convertRelatedPersonCommunicationComponent(org.hl7.fhir.model.core.RelatedPerson.RelatedPersonCommunicationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.RelatedPerson.RelatedPersonCommunicationComponent tgt = new org.hl7.fhir.r4b.model.RelatedPerson.RelatedPersonCommunicationComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasLanguage())
      tgt.setLanguage(CodeableConcept43_N.convertCodeableConcept(src.getLanguage()));
    if (src.hasPreferred())
      tgt.setPreferredElement(Boolean43_N.convertBoolean(src.getPreferredElement()));
    return tgt;
  }
}