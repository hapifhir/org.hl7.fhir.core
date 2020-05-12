package org.hl7.fhir.convertors.conv40_50;


import org.hl7.fhir.convertors.VersionConvertor_40_50;
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
public class Practitioner40_50 extends VersionConvertor_40_50 {

    public static org.hl7.fhir.r5.model.Practitioner convertPractitioner(org.hl7.fhir.r4.model.Practitioner src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Practitioner tgt = new org.hl7.fhir.r5.model.Practitioner();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasActive())
            tgt.setActiveElement(convertBoolean(src.getActiveElement()));
        for (org.hl7.fhir.r4.model.HumanName t : src.getName()) tgt.addName(convertHumanName(t));
        for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(convertContactPoint(t));
        for (org.hl7.fhir.r4.model.Address t : src.getAddress()) tgt.addAddress(convertAddress(t));
        if (src.hasGender())
            tgt.setGenderElement(Enumerations40_50.convertAdministrativeGender(src.getGenderElement()));
        if (src.hasBirthDate())
            tgt.setBirthDateElement(convertDate(src.getBirthDateElement()));
        for (org.hl7.fhir.r4.model.Attachment t : src.getPhoto()) tgt.addPhoto(convertAttachment(t));
        for (org.hl7.fhir.r4.model.Practitioner.PractitionerQualificationComponent t : src.getQualification()) tgt.addQualification(convertPractitionerQualificationComponent(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCommunication()) tgt.addCommunication(convertCodeableConcept(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Practitioner convertPractitioner(org.hl7.fhir.r5.model.Practitioner src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Practitioner tgt = new org.hl7.fhir.r4.model.Practitioner();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasActive())
            tgt.setActiveElement(convertBoolean(src.getActiveElement()));
        for (org.hl7.fhir.r5.model.HumanName t : src.getName()) tgt.addName(convertHumanName(t));
        for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(convertContactPoint(t));
        for (org.hl7.fhir.r5.model.Address t : src.getAddress()) tgt.addAddress(convertAddress(t));
        if (src.hasGender())
            tgt.setGenderElement(Enumerations40_50.convertAdministrativeGender(src.getGenderElement()));
        if (src.hasBirthDate())
            tgt.setBirthDateElement(convertDate(src.getBirthDateElement()));
        for (org.hl7.fhir.r5.model.Attachment t : src.getPhoto()) tgt.addPhoto(convertAttachment(t));
        for (org.hl7.fhir.r5.model.Practitioner.PractitionerQualificationComponent t : src.getQualification()) tgt.addQualification(convertPractitionerQualificationComponent(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCommunication()) tgt.addCommunication(convertCodeableConcept(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Practitioner.PractitionerQualificationComponent convertPractitionerQualificationComponent(org.hl7.fhir.r4.model.Practitioner.PractitionerQualificationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Practitioner.PractitionerQualificationComponent tgt = new org.hl7.fhir.r5.model.Practitioner.PractitionerQualificationComponent();
        copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasCode())
            tgt.setCode(convertCodeableConcept(src.getCode()));
        if (src.hasPeriod())
            tgt.setPeriod(convertPeriod(src.getPeriod()));
        if (src.hasIssuer())
            tgt.setIssuer(convertReference(src.getIssuer()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Practitioner.PractitionerQualificationComponent convertPractitionerQualificationComponent(org.hl7.fhir.r5.model.Practitioner.PractitionerQualificationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Practitioner.PractitionerQualificationComponent tgt = new org.hl7.fhir.r4.model.Practitioner.PractitionerQualificationComponent();
        copyElement(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasCode())
            tgt.setCode(convertCodeableConcept(src.getCode()));
        if (src.hasPeriod())
            tgt.setPeriod(convertPeriod(src.getPeriod()));
        if (src.hasIssuer())
            tgt.setIssuer(convertReference(src.getIssuer()));
        return tgt;
    }
}