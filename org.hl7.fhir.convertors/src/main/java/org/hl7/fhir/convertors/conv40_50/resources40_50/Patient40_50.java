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
public class Patient40_50 {

  public static org.hl7.fhir.r5.model.Patient convertPatient(org.hl7.fhir.r4.model.Patient src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Patient tgt = new org.hl7.fhir.r5.model.Patient();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    if (src.hasActive())
      tgt.setActiveElement(Boolean40_50.convertBoolean(src.getActiveElement()));
    for (org.hl7.fhir.r4.model.HumanName t : src.getName()) tgt.addName(HumanName40_50.convertHumanName(t));
    for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint40_50.convertContactPoint(t));
    if (src.hasGender())
      tgt.setGenderElement(Enumerations40_50.convertAdministrativeGender(src.getGenderElement()));
    if (src.hasBirthDate())
      tgt.setBirthDateElement(Date40_50.convertDate(src.getBirthDateElement()));
    if (src.hasDeceased())
      tgt.setDeceased(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getDeceased()));
    for (org.hl7.fhir.r4.model.Address t : src.getAddress()) tgt.addAddress(Address40_50.convertAddress(t));
    if (src.hasMaritalStatus())
      tgt.setMaritalStatus(CodeableConcept40_50.convertCodeableConcept(src.getMaritalStatus()));
    if (src.hasMultipleBirth())
      tgt.setMultipleBirth(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getMultipleBirth()));
    for (org.hl7.fhir.r4.model.Attachment t : src.getPhoto()) tgt.addPhoto(Attachment40_50.convertAttachment(t));
    for (org.hl7.fhir.r4.model.Patient.ContactComponent t : src.getContact())
      tgt.addContact(convertContactComponent(t));
    for (org.hl7.fhir.r4.model.Patient.PatientCommunicationComponent t : src.getCommunication())
      tgt.addCommunication(convertPatientCommunicationComponent(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getGeneralPractitioner())
      tgt.addGeneralPractitioner(Reference40_50.convertReference(t));
    if (src.hasManagingOrganization())
      tgt.setManagingOrganization(Reference40_50.convertReference(src.getManagingOrganization()));
    for (org.hl7.fhir.r4.model.Patient.PatientLinkComponent t : src.getLink())
      tgt.addLink(convertPatientLinkComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Patient convertPatient(org.hl7.fhir.r5.model.Patient src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Patient tgt = new org.hl7.fhir.r4.model.Patient();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    if (src.hasActive())
      tgt.setActiveElement(Boolean40_50.convertBoolean(src.getActiveElement()));
    for (org.hl7.fhir.r5.model.HumanName t : src.getName()) tgt.addName(HumanName40_50.convertHumanName(t));
    for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint40_50.convertContactPoint(t));
    if (src.hasGender())
      tgt.setGenderElement(Enumerations40_50.convertAdministrativeGender(src.getGenderElement()));
    if (src.hasBirthDate())
      tgt.setBirthDateElement(Date40_50.convertDate(src.getBirthDateElement()));
    if (src.hasDeceased())
      tgt.setDeceased(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getDeceased()));
    for (org.hl7.fhir.r5.model.Address t : src.getAddress()) tgt.addAddress(Address40_50.convertAddress(t));
    if (src.hasMaritalStatus())
      tgt.setMaritalStatus(CodeableConcept40_50.convertCodeableConcept(src.getMaritalStatus()));
    if (src.hasMultipleBirth())
      tgt.setMultipleBirth(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getMultipleBirth()));
    for (org.hl7.fhir.r5.model.Attachment t : src.getPhoto()) tgt.addPhoto(Attachment40_50.convertAttachment(t));
    for (org.hl7.fhir.r5.model.Patient.ContactComponent t : src.getContact())
      tgt.addContact(convertContactComponent(t));
    for (org.hl7.fhir.r5.model.Patient.PatientCommunicationComponent t : src.getCommunication())
      tgt.addCommunication(convertPatientCommunicationComponent(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getGeneralPractitioner())
      tgt.addGeneralPractitioner(Reference40_50.convertReference(t));
    if (src.hasManagingOrganization())
      tgt.setManagingOrganization(Reference40_50.convertReference(src.getManagingOrganization()));
    for (org.hl7.fhir.r5.model.Patient.PatientLinkComponent t : src.getLink())
      tgt.addLink(convertPatientLinkComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Patient.ContactComponent convertContactComponent(org.hl7.fhir.r4.model.Patient.ContactComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Patient.ContactComponent tgt = new org.hl7.fhir.r5.model.Patient.ContactComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getRelationship())
      tgt.addRelationship(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasName())
      tgt.setName(HumanName40_50.convertHumanName(src.getName()));
    for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint40_50.convertContactPoint(t));
    if (src.hasAddress())
      tgt.setAddress(Address40_50.convertAddress(src.getAddress()));
    if (src.hasGender())
      tgt.setGenderElement(Enumerations40_50.convertAdministrativeGender(src.getGenderElement()));
    if (src.hasOrganization())
      tgt.setOrganization(Reference40_50.convertReference(src.getOrganization()));
    if (src.hasPeriod())
      tgt.setPeriod(Period40_50.convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Patient.ContactComponent convertContactComponent(org.hl7.fhir.r5.model.Patient.ContactComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Patient.ContactComponent tgt = new org.hl7.fhir.r4.model.Patient.ContactComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getRelationship())
      tgt.addRelationship(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasName())
      tgt.setName(HumanName40_50.convertHumanName(src.getName()));
    for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint40_50.convertContactPoint(t));
    if (src.hasAddress())
      tgt.setAddress(Address40_50.convertAddress(src.getAddress()));
    if (src.hasGender())
      tgt.setGenderElement(Enumerations40_50.convertAdministrativeGender(src.getGenderElement()));
    if (src.hasOrganization())
      tgt.setOrganization(Reference40_50.convertReference(src.getOrganization()));
    if (src.hasPeriod())
      tgt.setPeriod(Period40_50.convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Patient.PatientCommunicationComponent convertPatientCommunicationComponent(org.hl7.fhir.r4.model.Patient.PatientCommunicationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Patient.PatientCommunicationComponent tgt = new org.hl7.fhir.r5.model.Patient.PatientCommunicationComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasLanguage())
      tgt.setLanguage(CodeableConcept40_50.convertCodeableConcept(src.getLanguage()));
    if (src.hasPreferred())
      tgt.setPreferredElement(Boolean40_50.convertBoolean(src.getPreferredElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Patient.PatientCommunicationComponent convertPatientCommunicationComponent(org.hl7.fhir.r5.model.Patient.PatientCommunicationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Patient.PatientCommunicationComponent tgt = new org.hl7.fhir.r4.model.Patient.PatientCommunicationComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasLanguage())
      tgt.setLanguage(CodeableConcept40_50.convertCodeableConcept(src.getLanguage()));
    if (src.hasPreferred())
      tgt.setPreferredElement(Boolean40_50.convertBoolean(src.getPreferredElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Patient.PatientLinkComponent convertPatientLinkComponent(org.hl7.fhir.r4.model.Patient.PatientLinkComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Patient.PatientLinkComponent tgt = new org.hl7.fhir.r5.model.Patient.PatientLinkComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasOther())
      tgt.setOther(Reference40_50.convertReference(src.getOther()));
    if (src.hasType())
      tgt.setTypeElement(convertLinkType(src.getTypeElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Patient.PatientLinkComponent convertPatientLinkComponent(org.hl7.fhir.r5.model.Patient.PatientLinkComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Patient.PatientLinkComponent tgt = new org.hl7.fhir.r4.model.Patient.PatientLinkComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasOther())
      tgt.setOther(Reference40_50.convertReference(src.getOther()));
    if (src.hasType())
      tgt.setTypeElement(convertLinkType(src.getTypeElement()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Patient.LinkType> convertLinkType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Patient.LinkType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Patient.LinkType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Patient.LinkTypeEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case REPLACEDBY:
        tgt.setValue(org.hl7.fhir.r5.model.Patient.LinkType.REPLACEDBY);
        break;
      case REPLACES:
        tgt.setValue(org.hl7.fhir.r5.model.Patient.LinkType.REPLACES);
        break;
      case REFER:
        tgt.setValue(org.hl7.fhir.r5.model.Patient.LinkType.REFER);
        break;
      case SEEALSO:
        tgt.setValue(org.hl7.fhir.r5.model.Patient.LinkType.SEEALSO);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Patient.LinkType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Patient.LinkType> convertLinkType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Patient.LinkType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Patient.LinkType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Patient.LinkTypeEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case REPLACEDBY:
        tgt.setValue(org.hl7.fhir.r4.model.Patient.LinkType.REPLACEDBY);
        break;
      case REPLACES:
        tgt.setValue(org.hl7.fhir.r4.model.Patient.LinkType.REPLACES);
        break;
      case REFER:
        tgt.setValue(org.hl7.fhir.r4.model.Patient.LinkType.REFER);
        break;
      case SEEALSO:
        tgt.setValue(org.hl7.fhir.r4.model.Patient.LinkType.SEEALSO);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.Patient.LinkType.NULL);
        break;
    }
    return tgt;
  }
}