package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionElements40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Address40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.ContactPoint40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.HumanName40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Boolean40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
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

public class Organization40_N {

  public static org.hl7.fhir.model.core.Organization convertOrganization(org.hl7.fhir.r4.model.Organization src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Organization tgt = new org.hl7.fhir.model.core.Organization();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, CrossVersionElements40_N.urls("Organization", "5.0", new String[] {"description", "qualification"}, CrossVersionElements40_N.urls("Organization", "6.0", new String[] {})));
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "description", "qualification");
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasActive())
      tgt.setActiveElement(Boolean40_N.convertBoolean(src.getActiveElement()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    for (org.hl7.fhir.r4.model.StringType t : src.getAlias()) tgt.getAliasList().add(String40_N.convertString(t));
    // R4 telecom and address become contacts (R5 folded them into contact). With one address, it goes with the
    // telecoms in a single contact; otherwise, the telecoms get a contact of their own, and each address gets one
    if (src.getAddress().size() == 1) {
      ExtendedContactDetail c = tgt.addContact();
      for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom())
        c.addTelecom(ContactPoint40_N.convertContactPoint(t));
      c.setAddress(Address40_N.convertAddress(src.getAddressFirstRep()));
    } else {
      if (src.hasTelecom()) {
        ExtendedContactDetail c = tgt.addContact();
        for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom())
          c.addTelecom(ContactPoint40_N.convertContactPoint(t));
      }
      for (org.hl7.fhir.r4.model.Address t : src.getAddress())
        tgt.addContact().setAddress(Address40_N.convertAddress(t));
    }
    if (src.hasPartOf())
      tgt.setPartOf(Reference40_N.convertReference(src.getPartOf()));
    for (org.hl7.fhir.r4.model.Organization.OrganizationContactComponent t : src.getContact())
      tgt.addContact(convertOrganizationContactComponent(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getEndpoint()) tgt.addEndpoint(Reference40_N.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Organization convertOrganization(org.hl7.fhir.model.core.Organization src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Organization tgt = new org.hl7.fhir.r4.model.Organization();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "5.0", "description", "qualification");
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasActive())
      tgt.setActiveElement(Boolean40_N.convertBoolean(src.getActiveElement()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getTypeList())
      tgt.addType(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    for (org.hl7.fhir.model.core.StringType t : src.getAliasList()) tgt.getAlias().add(String40_N.convertString(t));
    // R5 folded R4 telecom and address into contact: the organization's own details are a contact that has
    // nothing but telecom and/or address. Those go back to telecom/address; the rest go to contact
    for (ExtendedContactDetail t : src.getContactList()) {
      if (isOrganizationsOwnContact(t)) {
        for (org.hl7.fhir.model.core.ContactPoint cp : t.getTelecomList())
          tgt.addTelecom(ContactPoint40_N.convertContactPoint(cp));
        if (t.hasAddress())
          tgt.addAddress(Address40_N.convertAddress(t.getAddress()));
      }
    }
    if (src.hasPartOf())
      tgt.setPartOf(Reference40_N.convertReference(src.getPartOf()));
    for (org.hl7.fhir.model.core.ExtendedContactDetail t : src.getContactList())
      if (!isOrganizationsOwnContact(t))
        tgt.addContact(convertOrganizationContactComponent(t));
    for (org.hl7.fhir.model.core.Reference t : src.getEndpointList()) tgt.addEndpoint(Reference40_N.convertReference(t));
    return tgt;
  }

  private static final String CONTACT_PATH = "Organization.contact";
  // ExtendedContactDetail elements R4 Organization.contact doesn't have (name: the 2nd+)
  private static final String[] CONTACT_R5_ELEMENTS = {"name", "organization", "period"};

  /**
   * a contact with nothing but telecom and/or address is the organization's own details (R4 Organization.telecom / address)
   */
  private static boolean isOrganizationsOwnContact(ExtendedContactDetail c) {
    return (c.hasTelecom() || c.hasAddress()) && !c.hasPurpose() && !c.hasName() && !c.hasOrganization() && !c.hasPeriod()
      && !c.hasId() && !c.hasExtension();
  }

  public static org.hl7.fhir.model.core.ExtendedContactDetail convertOrganizationContactComponent(org.hl7.fhir.r4.model.Organization.OrganizationContactComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExtendedContactDetail tgt = new org.hl7.fhir.model.core.ExtendedContactDetail();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt, CrossVersionElements40_N.urls(CONTACT_PATH, "5.0", CONTACT_R5_ELEMENTS));
    if (src.hasPurpose())
      tgt.setPurpose(CodeableConcept40_N.convertCodeableConcept(src.getPurpose()));
    if (src.hasName())
      tgt.addName(HumanName40_N.convertHumanName(src.getName()));
    CrossVersionElements40_N.extensionsToElementsForPath(src.getExtension(), tgt, CONTACT_PATH, "5.0", CONTACT_R5_ELEMENTS);
    for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint40_N.convertContactPoint(t));
    if (src.hasAddress())
      tgt.setAddress(Address40_N.convertAddress(src.getAddress()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Organization.OrganizationContactComponent convertOrganizationContactComponent(org.hl7.fhir.model.core.ExtendedContactDetail src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Organization.OrganizationContactComponent tgt = new org.hl7.fhir.r4.model.Organization.OrganizationContactComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasPurpose())
      tgt.setPurpose(CodeableConcept40_N.convertCodeableConcept(src.getPurpose()));
    // R4 has one name: the rest go in the cross-version extension (along with organization and period)
    for (org.hl7.fhir.model.core.HumanName t : src.getNameList()) {
      if (!tgt.hasName())
        tgt.setName(HumanName40_N.convertHumanName(t));
      else
        tgt.addExtension(CrossVersionElements40_N.url(CONTACT_PATH, "5.0", "name"), HumanName40_N.convertHumanName(t));
    }
    CrossVersionElements40_N.elementsToExtensionsForPath(src, CONTACT_PATH, tgt.getExtension(), "5.0", "organization", "period");
    for (org.hl7.fhir.model.core.ContactPoint t : src.getTelecomList())
      tgt.addTelecom(ContactPoint40_N.convertContactPoint(t));
    if (src.hasAddress())
      tgt.setAddress(Address40_N.convertAddress(src.getAddress()));
    return tgt;
  }
}