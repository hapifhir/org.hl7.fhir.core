package org.hl7.fhir.convertors.conv10_40;


import org.hl7.fhir.convertors.VersionConvertor_10_40;
import org.hl7.fhir.exceptions.FHIRException;

import java.util.ArrayList;
import java.util.List;

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
public class PractitionerRole10_40 extends VersionConvertor_10_40 {

    public static List<org.hl7.fhir.r4.model.PractitionerRole> convertPractitionerRole(org.hl7.fhir.dstu2.model.Practitioner src) throws FHIRException {
        if (src == null || !src.hasPractitionerRole())
            return null;
            List<org.hl7.fhir.r4.model.PractitionerRole> roles = new ArrayList<org.hl7.fhir.r4.model.PractitionerRole>();
        for(org.hl7.fhir.dstu2.model.Practitioner.PractitionerPractitionerRoleComponent prc : src.getPractitionerRole()) {
            org.hl7.fhir.r4.model.PractitionerRole role = convertPractitionerRoleComponent(prc, src);
            if(role != null) {
                roles.add(role);
            }
        }
        return roles;
    }

    public static org.hl7.fhir.r4.model.PractitionerRole convertPractitionerRoleComponent(
            org.hl7.fhir.dstu2.model.Practitioner.PractitionerPractitionerRoleComponent src,
            org.hl7.fhir.dstu2.model.Practitioner  practitioner) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.PractitionerRole tgt = new org.hl7.fhir.r4.model.PractitionerRole();
        tgt.setId(src.getId());
        //copyDomainResource(src, tgt);
        if (src.hasPeriod())
            tgt.setPeriod(convertPeriod(src.getPeriod()));
        if (practitioner != null)
            tgt.setPractitioner(resourceToReference(practitioner));
        if (src.hasManagingOrganization())
            tgt.setOrganization(convertReference(src.getManagingOrganization()));
        if(src.hasRole())
            tgt.addCode(convertCodeableConcept(src.getRole()));          
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getSpecialty()) tgt.addSpecialty(convertCodeableConcept(t));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getLocation()) tgt.addLocation(convertReference(t));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getHealthcareService()) tgt.addHealthcareService(convertReference(t));
        return tgt;
    }

    private static org.hl7.fhir.r4.model.Reference resourceToReference(org.hl7.fhir.dstu2.model.Resource src) throws FHIRException {
        if (src == null || src.isEmpty()) return null;
        org.hl7.fhir.r4.model.Reference tgt = new org.hl7.fhir.r4.model.Reference();
        tgt.setId(src.getId());
        tgt.setType(src.getResourceType().name());
        tgt.setDisplay(src.getIdElement().asStringValue());
        return tgt;
    }
}