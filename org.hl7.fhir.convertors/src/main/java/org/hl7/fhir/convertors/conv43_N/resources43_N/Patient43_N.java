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

public class Patient43_N {

  public static org.hl7.fhir.model.core.Patient convertPatient(org.hl7.fhir.r4b.model.Patient src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Patient tgt = new org.hl7.fhir.model.core.Patient();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasActive())
      tgt.setActiveElement(Boolean43_N.convertBoolean(src.getActiveElement()));
    for (org.hl7.fhir.r4b.model.HumanName t : src.getName()) tgt.addName(HumanName43_N.convertHumanName(t));
    for (org.hl7.fhir.r4b.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint43_N.convertContactPoint(t));
    if (src.hasGender())
      tgt.setGenderElement(Enumerations43_N.convertAdministrativeGender(src.getGenderElement()));
    if (src.hasBirthDate())
      tgt.setBirthDateElement(Date43_N.convertDate(src.getBirthDateElement()));
    if (src.hasDeceased())
      tgt.setDeceased(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getDeceased()));
    for (org.hl7.fhir.r4b.model.Address t : src.getAddress()) tgt.addAddress(Address43_N.convertAddress(t));
    if (src.hasMaritalStatus())
      tgt.setMaritalStatus(CodeableConcept43_N.convertCodeableConcept(src.getMaritalStatus()));
    if (src.hasMultipleBirth())
      tgt.setMultipleBirth(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getMultipleBirth()));
    for (org.hl7.fhir.r4b.model.Attachment t : src.getPhoto()) tgt.addPhoto(Attachment43_N.convertAttachment(t));
    for (org.hl7.fhir.r4b.model.Patient.ContactComponent t : src.getContact())
      tgt.addContact(convertContactComponent(t));
    for (org.hl7.fhir.r4b.model.Patient.PatientCommunicationComponent t : src.getCommunication())
      tgt.addCommunication(convertPatientCommunicationComponent(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getGeneralPractitioner())
      tgt.addGeneralPractitioner(Reference43_N.convertReference(t));
    if (src.hasManagingOrganization())
      tgt.setManagingOrganization(Reference43_N.convertReference(src.getManagingOrganization()));
    for (org.hl7.fhir.r4b.model.Patient.PatientLinkComponent t : src.getLink())
      tgt.addLink(convertPatientLinkComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Patient convertPatient(org.hl7.fhir.model.core.Patient src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Patient tgt = new org.hl7.fhir.r4b.model.Patient();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasActive())
      tgt.setActiveElement(Boolean43_N.convertBoolean(src.getActiveElement()));
    for (org.hl7.fhir.model.core.HumanName t : src.getNameList()) tgt.addName(HumanName43_N.convertHumanName(t));
    for (org.hl7.fhir.model.core.ContactPoint t : src.getTelecomList())
      tgt.addTelecom(ContactPoint43_N.convertContactPoint(t));
    if (src.hasGender())
      tgt.setGenderElement(Enumerations43_N.convertAdministrativeGender(src.getGenderElement()));
    if (src.hasBirthDate())
      tgt.setBirthDateElement(Date43_N.convertDate(src.getBirthDateElement()));
    if (src.hasDeceased())
      tgt.setDeceased(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getDeceased()));
    for (org.hl7.fhir.model.core.Address t : src.getAddressList()) tgt.addAddress(Address43_N.convertAddress(t));
    if (src.hasMaritalStatus())
      tgt.setMaritalStatus(CodeableConcept43_N.convertCodeableConcept(src.getMaritalStatus()));
    if (src.hasMultipleBirth())
      tgt.setMultipleBirth(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getMultipleBirth()));
    for (org.hl7.fhir.model.core.Attachment t : src.getPhotoList()) tgt.addPhoto(Attachment43_N.convertAttachment(t));
    for (org.hl7.fhir.model.core.Patient.ContactComponent t : src.getContactList())
      tgt.addContact(convertContactComponent(t));
    for (org.hl7.fhir.model.core.Patient.PatientCommunicationComponent t : src.getCommunicationList())
      tgt.addCommunication(convertPatientCommunicationComponent(t));
    for (org.hl7.fhir.model.core.Reference t : src.getGeneralPractitionerList())
      tgt.addGeneralPractitioner(Reference43_N.convertReference(t));
    if (src.hasManagingOrganization())
      tgt.setManagingOrganization(Reference43_N.convertReference(src.getManagingOrganization()));
    for (org.hl7.fhir.model.core.Patient.PatientLinkComponent t : src.getLinkList())
      tgt.addLink(convertPatientLinkComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Patient.ContactComponent convertContactComponent(org.hl7.fhir.r4b.model.Patient.ContactComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Patient.ContactComponent tgt = new org.hl7.fhir.model.core.Patient.ContactComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getRelationship())
      tgt.addRelationship(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasName())
      tgt.setName(HumanName43_N.convertHumanName(src.getName()));
    for (org.hl7.fhir.r4b.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint43_N.convertContactPoint(t));
    if (src.hasAddress())
      tgt.setAddress(Address43_N.convertAddress(src.getAddress()));
    if (src.hasGender())
      tgt.setGenderElement(Enumerations43_N.convertAdministrativeGender(src.getGenderElement()));
    if (src.hasOrganization())
      tgt.setOrganization(Reference43_N.convertReference(src.getOrganization()));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_N.convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Patient.ContactComponent convertContactComponent(org.hl7.fhir.model.core.Patient.ContactComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Patient.ContactComponent tgt = new org.hl7.fhir.r4b.model.Patient.ContactComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getRelationshipList())
      tgt.addRelationship(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasName())
      tgt.setName(HumanName43_N.convertHumanName(src.getName()));
    for (org.hl7.fhir.model.core.ContactPoint t : src.getTelecomList())
      tgt.addTelecom(ContactPoint43_N.convertContactPoint(t));
    if (src.hasAddress())
      tgt.setAddress(Address43_N.convertAddress(src.getAddress()));
    if (src.hasGender())
      tgt.setGenderElement(Enumerations43_N.convertAdministrativeGender(src.getGenderElement()));
    if (src.hasOrganization())
      tgt.setOrganization(Reference43_N.convertReference(src.getOrganization()));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_N.convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Patient.PatientCommunicationComponent convertPatientCommunicationComponent(org.hl7.fhir.r4b.model.Patient.PatientCommunicationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Patient.PatientCommunicationComponent tgt = new org.hl7.fhir.model.core.Patient.PatientCommunicationComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasLanguage())
      tgt.setLanguage(CodeableConcept43_N.convertCodeableConcept(src.getLanguage()));
    if (src.hasPreferred())
      tgt.setPreferredElement(Boolean43_N.convertBoolean(src.getPreferredElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Patient.PatientCommunicationComponent convertPatientCommunicationComponent(org.hl7.fhir.model.core.Patient.PatientCommunicationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Patient.PatientCommunicationComponent tgt = new org.hl7.fhir.r4b.model.Patient.PatientCommunicationComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasLanguage())
      tgt.setLanguage(CodeableConcept43_N.convertCodeableConcept(src.getLanguage()));
    if (src.hasPreferred())
      tgt.setPreferredElement(Boolean43_N.convertBoolean(src.getPreferredElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Patient.PatientLinkComponent convertPatientLinkComponent(org.hl7.fhir.r4b.model.Patient.PatientLinkComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Patient.PatientLinkComponent tgt = new org.hl7.fhir.model.core.Patient.PatientLinkComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasOther())
      tgt.setOther(Reference43_N.convertReference(src.getOther()));
    if (src.hasType())
      tgt.setTypeElement(convertLinkType(src.getTypeElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Patient.PatientLinkComponent convertPatientLinkComponent(org.hl7.fhir.model.core.Patient.PatientLinkComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Patient.PatientLinkComponent tgt = new org.hl7.fhir.r4b.model.Patient.PatientLinkComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasOther())
      tgt.setOther(Reference43_N.convertReference(src.getOther()));
    if (src.hasType())
      tgt.setTypeElement(convertLinkType(src.getTypeElement()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Patient.LinkType> convertLinkType(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Patient.LinkType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Patient.LinkType> tgt = new Enumeration<>(new Patient.LinkTypeEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Patient.LinkType> convertLinkType(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Patient.LinkType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Patient.LinkType> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Patient.LinkTypeEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case REPLACEDBY:
                  tgt.setValue(org.hl7.fhir.r4b.model.Patient.LinkType.REPLACEDBY);
                  break;
              case REPLACES:
                  tgt.setValue(org.hl7.fhir.r4b.model.Patient.LinkType.REPLACES);
                  break;
              case REFER:
                  tgt.setValue(org.hl7.fhir.r4b.model.Patient.LinkType.REFER);
                  break;
              case SEEALSO:
                  tgt.setValue(org.hl7.fhir.r4b.model.Patient.LinkType.SEEALSO);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4b.model.Patient.LinkType.NULL);
                  break;
          }
      }
      return tgt;
  }
}