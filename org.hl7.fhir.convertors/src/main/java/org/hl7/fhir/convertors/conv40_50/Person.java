package org.hl7.fhir.convertors.conv40_50;

import org.hl7.fhir.exceptions.FHIRException;

import org.hl7.fhir.convertors.VersionConvertor_40_50;


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


public class Person extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.Person convertPerson(org.hl7.fhir.r4.model.Person src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Person tgt = new org.hl7.fhir.r5.model.Person();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    for (org.hl7.fhir.r4.model.HumanName t : src.getName())
      tgt.addName(convertHumanName(t));
    for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(convertContactPoint(t));
    if (src.hasGender())
      tgt.setGender(Enumerations.convertAdministrativeGender(src.getGender()));
    if (src.hasBirthDate())
      tgt.setBirthDateElement(convertDate(src.getBirthDateElement()));
    for (org.hl7.fhir.r4.model.Address t : src.getAddress())
      tgt.addAddress(convertAddress(t));
    if (src.hasPhoto())
      tgt.setPhoto(convertAttachment(src.getPhoto()));
    if (src.hasManagingOrganization())
      tgt.setManagingOrganization(convertReference(src.getManagingOrganization()));
    if (src.hasActive())
      tgt.setActiveElement(convertBoolean(src.getActiveElement()));
    for (org.hl7.fhir.r4.model.Person.PersonLinkComponent t : src.getLink())
      tgt.addLink(convertPersonLinkComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Person convertPerson(org.hl7.fhir.r5.model.Person src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Person tgt = new org.hl7.fhir.r4.model.Person();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    for (org.hl7.fhir.r5.model.HumanName t : src.getName())
      tgt.addName(convertHumanName(t));
    for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(convertContactPoint(t));
    if (src.hasGender())
      tgt.setGender(Enumerations.convertAdministrativeGender(src.getGender()));
    if (src.hasBirthDate())
      tgt.setBirthDateElement(convertDate(src.getBirthDateElement()));
    for (org.hl7.fhir.r5.model.Address t : src.getAddress())
      tgt.addAddress(convertAddress(t));
    if (src.hasPhoto())
      tgt.setPhoto(convertAttachment(src.getPhoto()));
    if (src.hasManagingOrganization())
      tgt.setManagingOrganization(convertReference(src.getManagingOrganization()));
    if (src.hasActive())
      tgt.setActiveElement(convertBoolean(src.getActiveElement()));
    for (org.hl7.fhir.r5.model.Person.PersonLinkComponent t : src.getLink())
      tgt.addLink(convertPersonLinkComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Person.PersonLinkComponent convertPersonLinkComponent(org.hl7.fhir.r4.model.Person.PersonLinkComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Person.PersonLinkComponent tgt = new org.hl7.fhir.r5.model.Person.PersonLinkComponent();
    copyElement(src, tgt);
    if (src.hasTarget())
      tgt.setTarget(convertReference(src.getTarget()));
    if (src.hasAssurance())
      tgt.setAssurance(convertIdentityAssuranceLevel(src.getAssurance()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Person.PersonLinkComponent convertPersonLinkComponent(org.hl7.fhir.r5.model.Person.PersonLinkComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Person.PersonLinkComponent tgt = new org.hl7.fhir.r4.model.Person.PersonLinkComponent();
    copyElement(src, tgt);
    if (src.hasTarget())
      tgt.setTarget(convertReference(src.getTarget()));
    if (src.hasAssurance())
      tgt.setAssurance(convertIdentityAssuranceLevel(src.getAssurance()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Person.IdentityAssuranceLevel convertIdentityAssuranceLevel(org.hl7.fhir.r4.model.Person.IdentityAssuranceLevel src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case LEVEL1: return org.hl7.fhir.r5.model.Person.IdentityAssuranceLevel.LEVEL1;
    case LEVEL2: return org.hl7.fhir.r5.model.Person.IdentityAssuranceLevel.LEVEL2;
    case LEVEL3: return org.hl7.fhir.r5.model.Person.IdentityAssuranceLevel.LEVEL3;
    case LEVEL4: return org.hl7.fhir.r5.model.Person.IdentityAssuranceLevel.LEVEL4;
    default: return org.hl7.fhir.r5.model.Person.IdentityAssuranceLevel.NULL;
  }
}

  public static org.hl7.fhir.r4.model.Person.IdentityAssuranceLevel convertIdentityAssuranceLevel(org.hl7.fhir.r5.model.Person.IdentityAssuranceLevel src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case LEVEL1: return org.hl7.fhir.r4.model.Person.IdentityAssuranceLevel.LEVEL1;
    case LEVEL2: return org.hl7.fhir.r4.model.Person.IdentityAssuranceLevel.LEVEL2;
    case LEVEL3: return org.hl7.fhir.r4.model.Person.IdentityAssuranceLevel.LEVEL3;
    case LEVEL4: return org.hl7.fhir.r4.model.Person.IdentityAssuranceLevel.LEVEL4;
    default: return org.hl7.fhir.r4.model.Person.IdentityAssuranceLevel.NULL;
  }
}


}
