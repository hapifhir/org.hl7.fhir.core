package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Address43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Attachment43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.ContactPoint43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.HumanName43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Period43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Boolean43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Date43_50;
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
public class RelatedPerson43_50 {

  public static org.hl7.fhir.r5.model.RelatedPerson convertRelatedPerson(org.hl7.fhir.r4b.model.RelatedPerson src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.RelatedPerson tgt = new org.hl7.fhir.r5.model.RelatedPerson();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasActive())
      tgt.setActiveElement(Boolean43_50.convertBoolean(src.getActiveElement()));
    if (src.hasPatient())
      tgt.setPatient(Reference43_50.convertReference(src.getPatient()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getRelationship())
      tgt.addRelationship(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.HumanName t : src.getName()) tgt.addName(HumanName43_50.convertHumanName(t));
    for (org.hl7.fhir.r4b.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint43_50.convertContactPoint(t));
    if (src.hasGender())
      tgt.setGenderElement(Enumerations43_50.convertAdministrativeGender(src.getGenderElement()));
    if (src.hasBirthDate())
      tgt.setBirthDateElement(Date43_50.convertDate(src.getBirthDateElement()));
    for (org.hl7.fhir.r4b.model.Address t : src.getAddress()) tgt.addAddress(Address43_50.convertAddress(t));
    for (org.hl7.fhir.r4b.model.Attachment t : src.getPhoto()) tgt.addPhoto(Attachment43_50.convertAttachment(t));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_50.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.r4b.model.RelatedPerson.RelatedPersonCommunicationComponent t : src.getCommunication())
      tgt.addCommunication(convertRelatedPersonCommunicationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.RelatedPerson convertRelatedPerson(org.hl7.fhir.r5.model.RelatedPerson src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.RelatedPerson tgt = new org.hl7.fhir.r4b.model.RelatedPerson();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasActive())
      tgt.setActiveElement(Boolean43_50.convertBoolean(src.getActiveElement()));
    if (src.hasPatient())
      tgt.setPatient(Reference43_50.convertReference(src.getPatient()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getRelationship())
      tgt.addRelationship(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.HumanName t : src.getName()) tgt.addName(HumanName43_50.convertHumanName(t));
    for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint43_50.convertContactPoint(t));
    if (src.hasGender())
      tgt.setGenderElement(Enumerations43_50.convertAdministrativeGender(src.getGenderElement()));
    if (src.hasBirthDate())
      tgt.setBirthDateElement(Date43_50.convertDate(src.getBirthDateElement()));
    for (org.hl7.fhir.r5.model.Address t : src.getAddress()) tgt.addAddress(Address43_50.convertAddress(t));
    for (org.hl7.fhir.r5.model.Attachment t : src.getPhoto()) tgt.addPhoto(Attachment43_50.convertAttachment(t));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_50.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.r5.model.RelatedPerson.RelatedPersonCommunicationComponent t : src.getCommunication())
      tgt.addCommunication(convertRelatedPersonCommunicationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.RelatedPerson.RelatedPersonCommunicationComponent convertRelatedPersonCommunicationComponent(org.hl7.fhir.r4b.model.RelatedPerson.RelatedPersonCommunicationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.RelatedPerson.RelatedPersonCommunicationComponent tgt = new org.hl7.fhir.r5.model.RelatedPerson.RelatedPersonCommunicationComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasLanguage())
      tgt.setLanguage(CodeableConcept43_50.convertCodeableConcept(src.getLanguage()));
    if (src.hasPreferred())
      tgt.setPreferredElement(Boolean43_50.convertBoolean(src.getPreferredElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.RelatedPerson.RelatedPersonCommunicationComponent convertRelatedPersonCommunicationComponent(org.hl7.fhir.r5.model.RelatedPerson.RelatedPersonCommunicationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.RelatedPerson.RelatedPersonCommunicationComponent tgt = new org.hl7.fhir.r4b.model.RelatedPerson.RelatedPersonCommunicationComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasLanguage())
      tgt.setLanguage(CodeableConcept43_50.convertCodeableConcept(src.getLanguage()));
    if (src.hasPreferred())
      tgt.setPreferredElement(Boolean43_50.convertBoolean(src.getPreferredElement()));
    return tgt;
  }
}