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
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.Patient;

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

public class Patient40_N {

  public static org.hl7.fhir.model.core.Patient convertPatient(org.hl7.fhir.r4.model.Patient src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Patient tgt = new org.hl7.fhir.model.core.Patient();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasActive())
      tgt.setActiveElement(Boolean40_N.convertBoolean(src.getActiveElement()));
    for (org.hl7.fhir.r4.model.HumanName t : src.getName()) tgt.addName(HumanName40_N.convertHumanName(t));
    for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint40_N.convertContactPoint(t));
    if (src.hasGender())
      tgt.setGenderElement(Enumerations40_N.convertAdministrativeGender(src.getGenderElement()));
    if (src.hasBirthDate())
      tgt.setBirthDateElement(Date40_N.convertDate(src.getBirthDateElement()));
    if (src.hasDeceased())
      tgt.setDeceased(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getDeceased()));
    for (org.hl7.fhir.r4.model.Address t : src.getAddress()) tgt.addAddress(Address40_N.convertAddress(t));
    if (src.hasMaritalStatus())
      tgt.setMaritalStatus(CodeableConcept40_N.convertCodeableConcept(src.getMaritalStatus()));
    if (src.hasMultipleBirth())
      tgt.setMultipleBirth(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getMultipleBirth()));
    for (org.hl7.fhir.r4.model.Attachment t : src.getPhoto()) tgt.addPhoto(Attachment40_N.convertAttachment(t));
    for (org.hl7.fhir.r4.model.Patient.ContactComponent t : src.getContact())
      tgt.addContact(convertContactComponent(t));
    for (org.hl7.fhir.r4.model.Patient.PatientCommunicationComponent t : src.getCommunication())
      tgt.addCommunication(convertPatientCommunicationComponent(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getGeneralPractitioner())
      tgt.addGeneralPractitioner(Reference40_N.convertReference(t));
    if (src.hasManagingOrganization())
      tgt.setManagingOrganization(Reference40_N.convertReference(src.getManagingOrganization()));
    for (org.hl7.fhir.r4.model.Patient.PatientLinkComponent t : src.getLink())
      tgt.addLink(convertPatientLinkComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Patient convertPatient(org.hl7.fhir.model.core.Patient src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Patient tgt = new org.hl7.fhir.r4.model.Patient();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasActive())
      tgt.setActiveElement(Boolean40_N.convertBoolean(src.getActiveElement()));
    for (org.hl7.fhir.model.core.HumanName t : src.getNameList()) tgt.addName(HumanName40_N.convertHumanName(t));
    for (org.hl7.fhir.model.core.ContactPoint t : src.getTelecomList())
      tgt.addTelecom(ContactPoint40_N.convertContactPoint(t));
    if (src.hasGender())
      tgt.setGenderElement(Enumerations40_N.convertAdministrativeGender(src.getGenderElement()));
    if (src.hasBirthDate())
      tgt.setBirthDateElement(Date40_N.convertDate(src.getBirthDateElement()));
    if (src.hasDeceased())
      tgt.setDeceased(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getDeceased()));
    for (org.hl7.fhir.model.core.Address t : src.getAddressList()) tgt.addAddress(Address40_N.convertAddress(t));
    if (src.hasMaritalStatus())
      tgt.setMaritalStatus(CodeableConcept40_N.convertCodeableConcept(src.getMaritalStatus()));
    if (src.hasMultipleBirth())
      tgt.setMultipleBirth(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getMultipleBirth()));
    for (org.hl7.fhir.model.core.Attachment t : src.getPhotoList()) tgt.addPhoto(Attachment40_N.convertAttachment(t));
    for (org.hl7.fhir.model.core.Patient.ContactComponent t : src.getContactList())
      tgt.addContact(convertContactComponent(t));
    for (org.hl7.fhir.model.core.Patient.PatientCommunicationComponent t : src.getCommunicationList())
      tgt.addCommunication(convertPatientCommunicationComponent(t));
    for (org.hl7.fhir.model.core.Reference t : src.getGeneralPractitionerList())
      tgt.addGeneralPractitioner(Reference40_N.convertReference(t));
    if (src.hasManagingOrganization())
      tgt.setManagingOrganization(Reference40_N.convertReference(src.getManagingOrganization()));
    for (org.hl7.fhir.model.core.Patient.PatientLinkComponent t : src.getLinkList())
      tgt.addLink(convertPatientLinkComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Patient.ContactComponent convertContactComponent(org.hl7.fhir.r4.model.Patient.ContactComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Patient.ContactComponent tgt = new org.hl7.fhir.model.core.Patient.ContactComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getRelationship())
      tgt.addRelationship(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasName())
      tgt.setName(HumanName40_N.convertHumanName(src.getName()));
    for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint40_N.convertContactPoint(t));
    if (src.hasAddress())
      tgt.setAddress(Address40_N.convertAddress(src.getAddress()));
    if (src.hasGender())
      tgt.setGenderElement(Enumerations40_N.convertAdministrativeGender(src.getGenderElement()));
    if (src.hasOrganization())
      tgt.setOrganization(Reference40_N.convertReference(src.getOrganization()));
    if (src.hasPeriod())
      tgt.setPeriod(Period40_N.convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Patient.ContactComponent convertContactComponent(org.hl7.fhir.model.core.Patient.ContactComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Patient.ContactComponent tgt = new org.hl7.fhir.r4.model.Patient.ContactComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getRelationshipList())
      tgt.addRelationship(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasName())
      tgt.setName(HumanName40_N.convertHumanName(src.getName()));
    for (org.hl7.fhir.model.core.ContactPoint t : src.getTelecomList())
      tgt.addTelecom(ContactPoint40_N.convertContactPoint(t));
    if (src.hasAddress())
      tgt.setAddress(Address40_N.convertAddress(src.getAddress()));
    if (src.hasGender())
      tgt.setGenderElement(Enumerations40_N.convertAdministrativeGender(src.getGenderElement()));
    if (src.hasOrganization())
      tgt.setOrganization(Reference40_N.convertReference(src.getOrganization()));
    if (src.hasPeriod())
      tgt.setPeriod(Period40_N.convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Patient.PatientCommunicationComponent convertPatientCommunicationComponent(org.hl7.fhir.r4.model.Patient.PatientCommunicationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Patient.PatientCommunicationComponent tgt = new org.hl7.fhir.model.core.Patient.PatientCommunicationComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasLanguage())
      tgt.setLanguage(CodeableConcept40_N.convertCodeableConcept(src.getLanguage()));
    if (src.hasPreferred())
      tgt.setPreferredElement(Boolean40_N.convertBoolean(src.getPreferredElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Patient.PatientCommunicationComponent convertPatientCommunicationComponent(org.hl7.fhir.model.core.Patient.PatientCommunicationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Patient.PatientCommunicationComponent tgt = new org.hl7.fhir.r4.model.Patient.PatientCommunicationComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasLanguage())
      tgt.setLanguage(CodeableConcept40_N.convertCodeableConcept(src.getLanguage()));
    if (src.hasPreferred())
      tgt.setPreferredElement(Boolean40_N.convertBoolean(src.getPreferredElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Patient.PatientLinkComponent convertPatientLinkComponent(org.hl7.fhir.r4.model.Patient.PatientLinkComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Patient.PatientLinkComponent tgt = new org.hl7.fhir.model.core.Patient.PatientLinkComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasOther())
      tgt.setOther(Reference40_N.convertReference(src.getOther()));
    if (src.hasType())
      tgt.setTypeElement(convertLinkType(src.getTypeElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Patient.PatientLinkComponent convertPatientLinkComponent(org.hl7.fhir.model.core.Patient.PatientLinkComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Patient.PatientLinkComponent tgt = new org.hl7.fhir.r4.model.Patient.PatientLinkComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasOther())
      tgt.setOther(Reference40_N.convertReference(src.getOther()));
    if (src.hasType())
      tgt.setTypeElement(convertLinkType(src.getTypeElement()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Patient.LinkType> convertLinkType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Patient.LinkType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Patient.LinkType> tgt = new Enumeration<>(new Patient.LinkTypeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case REPLACEDBY:
                  tgt.setValue(Patient.LinkType.REPLACEDBY);
                  break;
              case REPLACES:
                  tgt.setValue(Patient.LinkType.REPLACES);
                  break;
              case REFER:
                  tgt.setValue(Patient.LinkType.REFER);
                  break;
              case SEEALSO:
                  tgt.setValue(Patient.LinkType.SEEALSO);
                  break;
              default:
                  tgt.setValue(Patient.LinkType.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Patient.LinkType> convertLinkType(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Patient.LinkType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Patient.LinkType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Patient.LinkTypeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }
}