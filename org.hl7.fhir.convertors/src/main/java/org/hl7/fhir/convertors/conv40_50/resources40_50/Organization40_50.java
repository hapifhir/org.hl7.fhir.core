package org.hl7.fhir.convertors.conv40_50.resources40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Address40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.CodeableConcept40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.ContactPoint40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.HumanName40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Identifier40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Boolean40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.String40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Reference40_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.ExtendedContactDetail;

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
public class Organization40_50 {

  public static org.hl7.fhir.r5.model.Organization convertOrganization(org.hl7.fhir.r4.model.Organization src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Organization tgt = new org.hl7.fhir.r5.model.Organization();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    if (src.hasActive())
      tgt.setActiveElement(Boolean40_50.convertBoolean(src.getActiveElement()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasName())
      tgt.setNameElement(String40_50.convertString(src.getNameElement()));
    for (org.hl7.fhir.r4.model.StringType t : src.getAlias()) tgt.getAlias().add(String40_50.convertString(t));
    for (org.hl7.fhir.r4.model.Address t : src.getAddress()) tgt.addContact().setAddress(Address40_50.convertAddress(t));
    for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom())
      tgt.getContactFirstRep().addTelecom(ContactPoint40_50.convertContactPoint(t));
    if (src.hasPartOf())
      tgt.setPartOf(Reference40_50.convertReference(src.getPartOf()));
    for (org.hl7.fhir.r4.model.Organization.OrganizationContactComponent t : src.getContact())
      tgt.addContact(convertOrganizationContactComponent(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getEndpoint()) tgt.addEndpoint(Reference40_50.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Organization convertOrganization(org.hl7.fhir.r5.model.Organization src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Organization tgt = new org.hl7.fhir.r4.model.Organization();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    if (src.hasActive())
      tgt.setActiveElement(Boolean40_50.convertBoolean(src.getActiveElement()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasName())
      tgt.setNameElement(String40_50.convertString(src.getNameElement()));
    for (org.hl7.fhir.r5.model.StringType t : src.getAlias()) tgt.getAlias().add(String40_50.convertString(t));
    for (ExtendedContactDetail t1 : src.getContact())
      for (org.hl7.fhir.r5.model.ContactPoint t : t1.getTelecom())
        tgt.addTelecom(ContactPoint40_50.convertContactPoint(t));
    for (ExtendedContactDetail t : src.getContact())
      if (t.hasAddress())
        tgt.addAddress(Address40_50.convertAddress(t.getAddress()));
    if (src.hasPartOf())
      tgt.setPartOf(Reference40_50.convertReference(src.getPartOf()));
    for (org.hl7.fhir.r5.model.ExtendedContactDetail t : src.getContact())
      tgt.addContact(convertOrganizationContactComponent(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getEndpoint()) tgt.addEndpoint(Reference40_50.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ExtendedContactDetail convertOrganizationContactComponent(org.hl7.fhir.r4.model.Organization.OrganizationContactComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ExtendedContactDetail tgt = new org.hl7.fhir.r5.model.ExtendedContactDetail();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasPurpose())
      tgt.setPurpose(CodeableConcept40_50.convertCodeableConcept(src.getPurpose()));
    if (src.hasName())
      tgt.addName(HumanName40_50.convertHumanName(src.getName()));
    for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint40_50.convertContactPoint(t));
    if (src.hasAddress())
      tgt.setAddress(Address40_50.convertAddress(src.getAddress()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Organization.OrganizationContactComponent convertOrganizationContactComponent(org.hl7.fhir.r5.model.ExtendedContactDetail src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Organization.OrganizationContactComponent tgt = new org.hl7.fhir.r4.model.Organization.OrganizationContactComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasPurpose())
      tgt.setPurpose(CodeableConcept40_50.convertCodeableConcept(src.getPurpose()));
    for (org.hl7.fhir.r5.model.HumanName t : src.getName())
      tgt.setName(HumanName40_50.convertHumanName(t));
    for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint40_50.convertContactPoint(t));
    if (src.hasAddress())
      tgt.setAddress(Address40_50.convertAddress(src.getAddress()));
    return tgt;
  }
}