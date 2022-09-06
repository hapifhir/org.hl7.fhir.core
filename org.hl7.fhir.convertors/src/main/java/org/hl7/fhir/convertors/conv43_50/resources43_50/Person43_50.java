package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Address43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Attachment43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.ContactPoint43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.HumanName43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
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
public class Person43_50 {

  public static org.hl7.fhir.r5.model.Person convertPerson(org.hl7.fhir.r4b.model.Person src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Person tgt = new org.hl7.fhir.r5.model.Person();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    for (org.hl7.fhir.r4b.model.HumanName t : src.getName()) tgt.addName(HumanName43_50.convertHumanName(t));
    for (org.hl7.fhir.r4b.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint43_50.convertContactPoint(t));
    if (src.hasGender())
      tgt.setGenderElement(Enumerations43_50.convertAdministrativeGender(src.getGenderElement()));
    if (src.hasBirthDate())
      tgt.setBirthDateElement(Date43_50.convertDate(src.getBirthDateElement()));
    for (org.hl7.fhir.r4b.model.Address t : src.getAddress()) tgt.addAddress(Address43_50.convertAddress(t));
    if (src.hasPhoto())
      tgt.addPhoto(Attachment43_50.convertAttachment(src.getPhoto()));
    if (src.hasManagingOrganization())
      tgt.setManagingOrganization(Reference43_50.convertReference(src.getManagingOrganization()));
    if (src.hasActive())
      tgt.setActiveElement(Boolean43_50.convertBoolean(src.getActiveElement()));
    for (org.hl7.fhir.r4b.model.Person.PersonLinkComponent t : src.getLink()) tgt.addLink(convertPersonLinkComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Person convertPerson(org.hl7.fhir.r5.model.Person src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Person tgt = new org.hl7.fhir.r4b.model.Person();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    for (org.hl7.fhir.r5.model.HumanName t : src.getName()) tgt.addName(HumanName43_50.convertHumanName(t));
    for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint43_50.convertContactPoint(t));
    if (src.hasGender())
      tgt.setGenderElement(Enumerations43_50.convertAdministrativeGender(src.getGenderElement()));
    if (src.hasBirthDate())
      tgt.setBirthDateElement(Date43_50.convertDate(src.getBirthDateElement()));
    for (org.hl7.fhir.r5.model.Address t : src.getAddress()) tgt.addAddress(Address43_50.convertAddress(t));
    if (src.hasPhoto())
      tgt.setPhoto(Attachment43_50.convertAttachment(src.getPhotoFirstRep()));
    if (src.hasManagingOrganization())
      tgt.setManagingOrganization(Reference43_50.convertReference(src.getManagingOrganization()));
    if (src.hasActive())
      tgt.setActiveElement(Boolean43_50.convertBoolean(src.getActiveElement()));
    for (org.hl7.fhir.r5.model.Person.PersonLinkComponent t : src.getLink()) tgt.addLink(convertPersonLinkComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Person.PersonLinkComponent convertPersonLinkComponent(org.hl7.fhir.r4b.model.Person.PersonLinkComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Person.PersonLinkComponent tgt = new org.hl7.fhir.r5.model.Person.PersonLinkComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasTarget())
      tgt.setTarget(Reference43_50.convertReference(src.getTarget()));
    if (src.hasAssurance())
      tgt.setAssuranceElement(convertIdentityAssuranceLevel(src.getAssuranceElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Person.PersonLinkComponent convertPersonLinkComponent(org.hl7.fhir.r5.model.Person.PersonLinkComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Person.PersonLinkComponent tgt = new org.hl7.fhir.r4b.model.Person.PersonLinkComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasTarget())
      tgt.setTarget(Reference43_50.convertReference(src.getTarget()));
    if (src.hasAssurance())
      tgt.setAssuranceElement(convertIdentityAssuranceLevel(src.getAssuranceElement()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Person.IdentityAssuranceLevel> convertIdentityAssuranceLevel(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Person.IdentityAssuranceLevel> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Person.IdentityAssuranceLevel> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Person.IdentityAssuranceLevelEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case LEVEL1:
        tgt.setValue(org.hl7.fhir.r5.model.Person.IdentityAssuranceLevel.LEVEL1);
        break;
      case LEVEL2:
        tgt.setValue(org.hl7.fhir.r5.model.Person.IdentityAssuranceLevel.LEVEL2);
        break;
      case LEVEL3:
        tgt.setValue(org.hl7.fhir.r5.model.Person.IdentityAssuranceLevel.LEVEL3);
        break;
      case LEVEL4:
        tgt.setValue(org.hl7.fhir.r5.model.Person.IdentityAssuranceLevel.LEVEL4);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Person.IdentityAssuranceLevel.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Person.IdentityAssuranceLevel> convertIdentityAssuranceLevel(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Person.IdentityAssuranceLevel> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Person.IdentityAssuranceLevel> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Person.IdentityAssuranceLevelEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case LEVEL1:
        tgt.setValue(org.hl7.fhir.r4b.model.Person.IdentityAssuranceLevel.LEVEL1);
        break;
      case LEVEL2:
        tgt.setValue(org.hl7.fhir.r4b.model.Person.IdentityAssuranceLevel.LEVEL2);
        break;
      case LEVEL3:
        tgt.setValue(org.hl7.fhir.r4b.model.Person.IdentityAssuranceLevel.LEVEL3);
        break;
      case LEVEL4:
        tgt.setValue(org.hl7.fhir.r4b.model.Person.IdentityAssuranceLevel.LEVEL4);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.Person.IdentityAssuranceLevel.NULL);
        break;
    }
    return tgt;
  }
}