package org.hl7.fhir.convertors.conv43_N.resources43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Address43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.CodeableConcept43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.ContactPoint43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.HumanName43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Identifier43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Boolean43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Reference43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.ExtendedContactDetail;

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

public class Organization43_N {

  public static org.hl7.fhir.model.core.Organization convertOrganization(org.hl7.fhir.r4b.model.Organization src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Organization tgt = new org.hl7.fhir.model.core.Organization();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasActive())
      tgt.setActiveElement(Boolean43_N.convertBoolean(src.getActiveElement()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasName())
      tgt.setNameElement(String43_N.convertString(src.getNameElement()));
    for (org.hl7.fhir.r4b.model.StringType t : src.getAlias()) tgt.getAliasList().add(String43_N.convertString(t));
    for (org.hl7.fhir.r4b.model.Address t : src.getAddress()) tgt.addContact().setAddress(Address43_N.convertAddress(t));
    for (org.hl7.fhir.r4b.model.ContactPoint t : src.getTelecom())
      tgt.getContactFirstRep().addTelecom(ContactPoint43_N.convertContactPoint(t));
    if (src.hasPartOf())
      tgt.setPartOf(Reference43_N.convertReference(src.getPartOf()));
    for (org.hl7.fhir.r4b.model.Organization.OrganizationContactComponent t : src.getContact())
      tgt.addContact(convertOrganizationContactComponent(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getEndpoint()) tgt.addEndpoint(Reference43_N.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Organization convertOrganization(org.hl7.fhir.model.core.Organization src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Organization tgt = new org.hl7.fhir.r4b.model.Organization();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasActive())
      tgt.setActiveElement(Boolean43_N.convertBoolean(src.getActiveElement()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getTypeList())
      tgt.addType(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasName())
      tgt.setNameElement(String43_N.convertString(src.getNameElement()));
    for (org.hl7.fhir.model.core.StringType t : src.getAliasList()) tgt.getAlias().add(String43_N.convertString(t));
    for (ExtendedContactDetail t1 : src.getContactList())
      for (org.hl7.fhir.model.core.ContactPoint t : t1.getTelecomList())
        tgt.addTelecom(ContactPoint43_N.convertContactPoint(t));
    for (ExtendedContactDetail t : src.getContactList())
      if (t.hasAddress())
        tgt.addAddress(Address43_N.convertAddress(t.getAddress()));
    if (src.hasPartOf())
      tgt.setPartOf(Reference43_N.convertReference(src.getPartOf()));
    for (org.hl7.fhir.model.core.ExtendedContactDetail t : src.getContactList())
      tgt.addContact(convertOrganizationContactComponent(t));
    for (org.hl7.fhir.model.core.Reference t : src.getEndpointList()) tgt.addEndpoint(Reference43_N.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ExtendedContactDetail convertOrganizationContactComponent(org.hl7.fhir.r4b.model.Organization.OrganizationContactComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExtendedContactDetail tgt = new org.hl7.fhir.model.core.ExtendedContactDetail();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasPurpose())
      tgt.setPurpose(CodeableConcept43_N.convertCodeableConcept(src.getPurpose()));
    if (src.hasName())
      tgt.addName(HumanName43_N.convertHumanName(src.getName()));
    for (org.hl7.fhir.r4b.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint43_N.convertContactPoint(t));
    if (src.hasAddress())
      tgt.setAddress(Address43_N.convertAddress(src.getAddress()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Organization.OrganizationContactComponent convertOrganizationContactComponent(org.hl7.fhir.model.core.ExtendedContactDetail src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Organization.OrganizationContactComponent tgt = new org.hl7.fhir.r4b.model.Organization.OrganizationContactComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasPurpose())
      tgt.setPurpose(CodeableConcept43_N.convertCodeableConcept(src.getPurpose()));
    for (org.hl7.fhir.model.core.HumanName t : src.getNameList())
      tgt.setName(HumanName43_N.convertHumanName(t));
    for (org.hl7.fhir.model.core.ContactPoint t : src.getTelecomList())
      tgt.addTelecom(ContactPoint43_N.convertContactPoint(t));
    if (src.hasAddress())
      tgt.setAddress(Address43_N.convertAddress(src.getAddress()));
    return tgt;
  }
}