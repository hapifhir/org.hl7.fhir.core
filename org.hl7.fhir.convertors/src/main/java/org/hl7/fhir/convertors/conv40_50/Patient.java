package org.hl7.fhir.convertors.conv40_50;

/*-
 * #%L
 * org.hl7.fhir.convertors
 * %%
 * Copyright (C) 2014 - 2019 Health Level 7
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


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


public class Patient extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.Patient convertPatient(org.hl7.fhir.r4.model.Patient src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Patient tgt = new org.hl7.fhir.r5.model.Patient();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasActive())
      tgt.setActiveElement(convertBoolean(src.getActiveElement()));
    for (org.hl7.fhir.r4.model.HumanName t : src.getName())
      tgt.addName(convertHumanName(t));
    for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(convertContactPoint(t));
    if (src.hasGender())
      tgt.setGender(Enumerations.convertAdministrativeGender(src.getGender()));
    if (src.hasBirthDate())
      tgt.setBirthDateElement(convertDate(src.getBirthDateElement()));
    if (src.hasDeceased())
      tgt.setDeceased(convertType(src.getDeceased()));
    for (org.hl7.fhir.r4.model.Address t : src.getAddress())
      tgt.addAddress(convertAddress(t));
    if (src.hasMaritalStatus())
      tgt.setMaritalStatus(convertCodeableConcept(src.getMaritalStatus()));
    if (src.hasMultipleBirth())
      tgt.setMultipleBirth(convertType(src.getMultipleBirth()));
    for (org.hl7.fhir.r4.model.Attachment t : src.getPhoto())
      tgt.addPhoto(convertAttachment(t));
    for (org.hl7.fhir.r4.model.Patient.ContactComponent t : src.getContact())
      tgt.addContact(convertContactComponent(t));
    for (org.hl7.fhir.r4.model.Patient.PatientCommunicationComponent t : src.getCommunication())
      tgt.addCommunication(convertPatientCommunicationComponent(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getGeneralPractitioner())
      tgt.addGeneralPractitioner(convertReference(t));
    if (src.hasManagingOrganization())
      tgt.setManagingOrganization(convertReference(src.getManagingOrganization()));
    for (org.hl7.fhir.r4.model.Patient.PatientLinkComponent t : src.getLink())
      tgt.addLink(convertPatientLinkComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Patient convertPatient(org.hl7.fhir.r5.model.Patient src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Patient tgt = new org.hl7.fhir.r4.model.Patient();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasActive())
      tgt.setActiveElement(convertBoolean(src.getActiveElement()));
    for (org.hl7.fhir.r5.model.HumanName t : src.getName())
      tgt.addName(convertHumanName(t));
    for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(convertContactPoint(t));
    if (src.hasGender())
      tgt.setGender(Enumerations.convertAdministrativeGender(src.getGender()));
    if (src.hasBirthDate())
      tgt.setBirthDateElement(convertDate(src.getBirthDateElement()));
    if (src.hasDeceased())
      tgt.setDeceased(convertType(src.getDeceased()));
    for (org.hl7.fhir.r5.model.Address t : src.getAddress())
      tgt.addAddress(convertAddress(t));
    if (src.hasMaritalStatus())
      tgt.setMaritalStatus(convertCodeableConcept(src.getMaritalStatus()));
    if (src.hasMultipleBirth())
      tgt.setMultipleBirth(convertType(src.getMultipleBirth()));
    for (org.hl7.fhir.r5.model.Attachment t : src.getPhoto())
      tgt.addPhoto(convertAttachment(t));
    for (org.hl7.fhir.r5.model.Patient.ContactComponent t : src.getContact())
      tgt.addContact(convertContactComponent(t));
    for (org.hl7.fhir.r5.model.Patient.PatientCommunicationComponent t : src.getCommunication())
      tgt.addCommunication(convertPatientCommunicationComponent(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getGeneralPractitioner())
      tgt.addGeneralPractitioner(convertReference(t));
    if (src.hasManagingOrganization())
      tgt.setManagingOrganization(convertReference(src.getManagingOrganization()));
    for (org.hl7.fhir.r5.model.Patient.PatientLinkComponent t : src.getLink())
      tgt.addLink(convertPatientLinkComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Patient.ContactComponent convertContactComponent(org.hl7.fhir.r4.model.Patient.ContactComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Patient.ContactComponent tgt = new org.hl7.fhir.r5.model.Patient.ContactComponent();
    copyElement(src, tgt);
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getRelationship())
      tgt.addRelationship(convertCodeableConcept(t));
    if (src.hasName())
      tgt.setName(convertHumanName(src.getName()));
    for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(convertContactPoint(t));
    if (src.hasAddress())
      tgt.setAddress(convertAddress(src.getAddress()));
    if (src.hasGender())
      tgt.setGender(Enumerations.convertAdministrativeGender(src.getGender()));
    if (src.hasOrganization())
      tgt.setOrganization(convertReference(src.getOrganization()));
    if (src.hasPeriod())
      tgt.setPeriod(convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Patient.ContactComponent convertContactComponent(org.hl7.fhir.r5.model.Patient.ContactComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Patient.ContactComponent tgt = new org.hl7.fhir.r4.model.Patient.ContactComponent();
    copyElement(src, tgt);
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getRelationship())
      tgt.addRelationship(convertCodeableConcept(t));
    if (src.hasName())
      tgt.setName(convertHumanName(src.getName()));
    for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(convertContactPoint(t));
    if (src.hasAddress())
      tgt.setAddress(convertAddress(src.getAddress()));
    if (src.hasGender())
      tgt.setGender(Enumerations.convertAdministrativeGender(src.getGender()));
    if (src.hasOrganization())
      tgt.setOrganization(convertReference(src.getOrganization()));
    if (src.hasPeriod())
      tgt.setPeriod(convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Patient.PatientCommunicationComponent convertPatientCommunicationComponent(org.hl7.fhir.r4.model.Patient.PatientCommunicationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Patient.PatientCommunicationComponent tgt = new org.hl7.fhir.r5.model.Patient.PatientCommunicationComponent();
    copyElement(src, tgt);
    if (src.hasLanguage())
      tgt.setLanguage(convertCodeableConcept(src.getLanguage()));
    if (src.hasPreferred())
      tgt.setPreferredElement(convertBoolean(src.getPreferredElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Patient.PatientCommunicationComponent convertPatientCommunicationComponent(org.hl7.fhir.r5.model.Patient.PatientCommunicationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Patient.PatientCommunicationComponent tgt = new org.hl7.fhir.r4.model.Patient.PatientCommunicationComponent();
    copyElement(src, tgt);
    if (src.hasLanguage())
      tgt.setLanguage(convertCodeableConcept(src.getLanguage()));
    if (src.hasPreferred())
      tgt.setPreferredElement(convertBoolean(src.getPreferredElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Patient.PatientLinkComponent convertPatientLinkComponent(org.hl7.fhir.r4.model.Patient.PatientLinkComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Patient.PatientLinkComponent tgt = new org.hl7.fhir.r5.model.Patient.PatientLinkComponent();
    copyElement(src, tgt);
    if (src.hasOther())
      tgt.setOther(convertReference(src.getOther()));
    if (src.hasType())
      tgt.setType(convertLinkType(src.getType()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Patient.PatientLinkComponent convertPatientLinkComponent(org.hl7.fhir.r5.model.Patient.PatientLinkComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Patient.PatientLinkComponent tgt = new org.hl7.fhir.r4.model.Patient.PatientLinkComponent();
    copyElement(src, tgt);
    if (src.hasOther())
      tgt.setOther(convertReference(src.getOther()));
    if (src.hasType())
      tgt.setType(convertLinkType(src.getType()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Patient.LinkType convertLinkType(org.hl7.fhir.r4.model.Patient.LinkType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case REPLACEDBY: return org.hl7.fhir.r5.model.Patient.LinkType.REPLACEDBY;
    case REPLACES: return org.hl7.fhir.r5.model.Patient.LinkType.REPLACES;
    case REFER: return org.hl7.fhir.r5.model.Patient.LinkType.REFER;
    case SEEALSO: return org.hl7.fhir.r5.model.Patient.LinkType.SEEALSO;
    default: return org.hl7.fhir.r5.model.Patient.LinkType.NULL;
  }
}

  public static org.hl7.fhir.r4.model.Patient.LinkType convertLinkType(org.hl7.fhir.r5.model.Patient.LinkType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case REPLACEDBY: return org.hl7.fhir.r4.model.Patient.LinkType.REPLACEDBY;
    case REPLACES: return org.hl7.fhir.r4.model.Patient.LinkType.REPLACES;
    case REFER: return org.hl7.fhir.r4.model.Patient.LinkType.REFER;
    case SEEALSO: return org.hl7.fhir.r4.model.Patient.LinkType.SEEALSO;
    default: return org.hl7.fhir.r4.model.Patient.LinkType.NULL;
  }
}


}
