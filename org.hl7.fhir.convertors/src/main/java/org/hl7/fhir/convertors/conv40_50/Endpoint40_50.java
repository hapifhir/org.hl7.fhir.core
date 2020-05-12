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
public class Endpoint40_50 extends VersionConvertor_40_50 {

    public static org.hl7.fhir.r5.model.Endpoint convertEndpoint(org.hl7.fhir.r4.model.Endpoint src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Endpoint tgt = new org.hl7.fhir.r5.model.Endpoint();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertEndpointStatus(src.getStatusElement()));
        if (src.hasConnectionType())
            tgt.setConnectionType(convertCoding(src.getConnectionType()));
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        if (src.hasManagingOrganization())
            tgt.setManagingOrganization(convertReference(src.getManagingOrganization()));
        for (org.hl7.fhir.r4.model.ContactPoint t : src.getContact()) tgt.addContact(convertContactPoint(t));
        if (src.hasPeriod())
            tgt.setPeriod(convertPeriod(src.getPeriod()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getPayloadType()) tgt.addPayloadType(convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.CodeType t : src.getPayloadMimeType()) tgt.getPayloadMimeType().add(convertCode(t));
        if (src.hasAddress())
            tgt.setAddressElement(convertUrl(src.getAddressElement()));
        for (org.hl7.fhir.r4.model.StringType t : src.getHeader()) tgt.getHeader().add(convertString(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Endpoint convertEndpoint(org.hl7.fhir.r5.model.Endpoint src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Endpoint tgt = new org.hl7.fhir.r4.model.Endpoint();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertEndpointStatus(src.getStatusElement()));
        if (src.hasConnectionType())
            tgt.setConnectionType(convertCoding(src.getConnectionType()));
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        if (src.hasManagingOrganization())
            tgt.setManagingOrganization(convertReference(src.getManagingOrganization()));
        for (org.hl7.fhir.r5.model.ContactPoint t : src.getContact()) tgt.addContact(convertContactPoint(t));
        if (src.hasPeriod())
            tgt.setPeriod(convertPeriod(src.getPeriod()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getPayloadType()) tgt.addPayloadType(convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.CodeType t : src.getPayloadMimeType()) tgt.getPayloadMimeType().add(convertCode(t));
        if (src.hasAddress())
            tgt.setAddressElement(convertUrl(src.getAddressElement()));
        for (org.hl7.fhir.r5.model.StringType t : src.getHeader()) tgt.getHeader().add(convertString(t));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Endpoint.EndpointStatus> convertEndpointStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Endpoint.EndpointStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Endpoint.EndpointStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Endpoint.EndpointStatusEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.r5.model.Endpoint.EndpointStatus.ACTIVE);
                break;
            case SUSPENDED:
                tgt.setValue(org.hl7.fhir.r5.model.Endpoint.EndpointStatus.SUSPENDED);
                break;
            case ERROR:
                tgt.setValue(org.hl7.fhir.r5.model.Endpoint.EndpointStatus.ERROR);
                break;
            case OFF:
                tgt.setValue(org.hl7.fhir.r5.model.Endpoint.EndpointStatus.OFF);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r5.model.Endpoint.EndpointStatus.ENTEREDINERROR);
                break;
            case TEST:
                tgt.setValue(org.hl7.fhir.r5.model.Endpoint.EndpointStatus.TEST);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Endpoint.EndpointStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Endpoint.EndpointStatus> convertEndpointStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Endpoint.EndpointStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Endpoint.EndpointStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Endpoint.EndpointStatusEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.r4.model.Endpoint.EndpointStatus.ACTIVE);
                break;
            case SUSPENDED:
                tgt.setValue(org.hl7.fhir.r4.model.Endpoint.EndpointStatus.SUSPENDED);
                break;
            case ERROR:
                tgt.setValue(org.hl7.fhir.r4.model.Endpoint.EndpointStatus.ERROR);
                break;
            case OFF:
                tgt.setValue(org.hl7.fhir.r4.model.Endpoint.EndpointStatus.OFF);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r4.model.Endpoint.EndpointStatus.ENTEREDINERROR);
                break;
            case TEST:
                tgt.setValue(org.hl7.fhir.r4.model.Endpoint.EndpointStatus.TEST);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.Endpoint.EndpointStatus.NULL);
                break;
        }
        return tgt;
    }
}