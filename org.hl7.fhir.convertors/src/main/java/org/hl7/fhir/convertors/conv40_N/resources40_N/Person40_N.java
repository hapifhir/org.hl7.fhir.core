package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Address40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Attachment40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.ContactPoint40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.HumanName40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Boolean40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Date40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.Person;

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

public class Person40_N {

  public static org.hl7.fhir.model.core.Person convertPerson(org.hl7.fhir.r4.model.Person src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Person tgt = new org.hl7.fhir.model.core.Person();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    for (org.hl7.fhir.r4.model.HumanName t : src.getName()) tgt.addName(HumanName40_N.convertHumanName(t));
    for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint40_N.convertContactPoint(t));
    if (src.hasGender())
      tgt.setGenderElement(Enumerations40_N.convertAdministrativeGender(src.getGenderElement()));
    if (src.hasBirthDate())
      tgt.setBirthDateElement(Date40_N.convertDate(src.getBirthDateElement()));
    for (org.hl7.fhir.r4.model.Address t : src.getAddress()) tgt.addAddress(Address40_N.convertAddress(t));
    if (src.hasPhoto())
      tgt.addPhoto(Attachment40_N.convertAttachment(src.getPhoto()));
    if (src.hasManagingOrganization())
      tgt.setManagingOrganization(Reference40_N.convertReference(src.getManagingOrganization()));
    if (src.hasActive())
      tgt.setActiveElement(Boolean40_N.convertBoolean(src.getActiveElement()));
    for (org.hl7.fhir.r4.model.Person.PersonLinkComponent t : src.getLink()) tgt.addLink(convertPersonLinkComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Person convertPerson(org.hl7.fhir.model.core.Person src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Person tgt = new org.hl7.fhir.r4.model.Person();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    for (org.hl7.fhir.model.core.HumanName t : src.getNameList()) tgt.addName(HumanName40_N.convertHumanName(t));
    for (org.hl7.fhir.model.core.ContactPoint t : src.getTelecomList())
      tgt.addTelecom(ContactPoint40_N.convertContactPoint(t));
    if (src.hasGender())
      tgt.setGenderElement(Enumerations40_N.convertAdministrativeGender(src.getGenderElement()));
    if (src.hasBirthDate())
      tgt.setBirthDateElement(Date40_N.convertDate(src.getBirthDateElement()));
    for (org.hl7.fhir.model.core.Address t : src.getAddressList()) tgt.addAddress(Address40_N.convertAddress(t));
    if (src.hasPhoto())
      tgt.setPhoto(Attachment40_N.convertAttachment(src.getPhotoFirstRep()));
    if (src.hasManagingOrganization())
      tgt.setManagingOrganization(Reference40_N.convertReference(src.getManagingOrganization()));
    if (src.hasActive())
      tgt.setActiveElement(Boolean40_N.convertBoolean(src.getActiveElement()));
    for (org.hl7.fhir.model.core.Person.PersonLinkComponent t : src.getLinkList()) tgt.addLink(convertPersonLinkComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Person.PersonLinkComponent convertPersonLinkComponent(org.hl7.fhir.r4.model.Person.PersonLinkComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Person.PersonLinkComponent tgt = new org.hl7.fhir.model.core.Person.PersonLinkComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasTarget())
      tgt.setTarget(Reference40_N.convertReference(src.getTarget()));
    if (src.hasAssurance())
      tgt.setAssuranceElement(convertIdentityAssuranceLevel(src.getAssuranceElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Person.PersonLinkComponent convertPersonLinkComponent(org.hl7.fhir.model.core.Person.PersonLinkComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Person.PersonLinkComponent tgt = new org.hl7.fhir.r4.model.Person.PersonLinkComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasTarget())
      tgt.setTarget(Reference40_N.convertReference(src.getTarget()));
    if (src.hasAssurance())
      tgt.setAssuranceElement(convertIdentityAssuranceLevel(src.getAssuranceElement()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Person.IdentityAssuranceLevel> convertIdentityAssuranceLevel(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Person.IdentityAssuranceLevel> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Person.IdentityAssuranceLevel> tgt = new Enumeration<>(new Person.IdentityAssuranceLevelEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case LEVEL1:
                  tgt.setValue(Person.IdentityAssuranceLevel.LEVEL1);
                  break;
              case LEVEL2:
                  tgt.setValue(Person.IdentityAssuranceLevel.LEVEL2);
                  break;
              case LEVEL3:
                  tgt.setValue(Person.IdentityAssuranceLevel.LEVEL3);
                  break;
              case LEVEL4:
                  tgt.setValue(Person.IdentityAssuranceLevel.LEVEL4);
                  break;
              default:
                  tgt.setValue(Person.IdentityAssuranceLevel.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Person.IdentityAssuranceLevel> convertIdentityAssuranceLevel(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Person.IdentityAssuranceLevel> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Person.IdentityAssuranceLevel> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Person.IdentityAssuranceLevelEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case LEVEL1:
                  tgt.setValue(org.hl7.fhir.r4.model.Person.IdentityAssuranceLevel.LEVEL1);
                  break;
              case LEVEL2:
                  tgt.setValue(org.hl7.fhir.r4.model.Person.IdentityAssuranceLevel.LEVEL2);
                  break;
              case LEVEL3:
                  tgt.setValue(org.hl7.fhir.r4.model.Person.IdentityAssuranceLevel.LEVEL3);
                  break;
              case LEVEL4:
                  tgt.setValue(org.hl7.fhir.r4.model.Person.IdentityAssuranceLevel.LEVEL4);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4.model.Person.IdentityAssuranceLevel.NULL);
                  break;
          }
      }
      return tgt;
  }
}