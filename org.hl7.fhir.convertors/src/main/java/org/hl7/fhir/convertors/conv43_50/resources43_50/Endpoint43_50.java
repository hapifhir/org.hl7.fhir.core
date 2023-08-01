package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Coding43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.ContactPoint43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Period43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Code43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Url43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50.Reference43_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.Endpoint.EndpointPayloadComponent;

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
public class Endpoint43_50 {

  public static org.hl7.fhir.r5.model.Endpoint convertEndpoint(org.hl7.fhir.r4b.model.Endpoint src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Endpoint tgt = new org.hl7.fhir.r5.model.Endpoint();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertEndpointStatus(src.getStatusElement()));
    if (src.hasConnectionType())
      tgt.addConnectionType(Coding43_50.convertCodingToCodeableConcept(src.getConnectionType()));
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    if (src.hasManagingOrganization())
      tgt.setManagingOrganization(Reference43_50.convertReference(src.getManagingOrganization()));
    for (org.hl7.fhir.r4b.model.ContactPoint t : src.getContact())
      tgt.addContact(ContactPoint43_50.convertContactPoint(t));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_50.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getPayloadType())
      tgt.addPayload().addType(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.CodeType t : src.getPayloadMimeType())
      tgt.addPayload().getMimeType().add(Code43_50.convertCode(t));
    if (src.hasAddress())
      tgt.setAddressElement(Url43_50.convertUrl(src.getAddressElement()));
    for (org.hl7.fhir.r4b.model.StringType t : src.getHeader()) tgt.getHeader().add(String43_50.convertString(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Endpoint convertEndpoint(org.hl7.fhir.r5.model.Endpoint src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Endpoint tgt = new org.hl7.fhir.r4b.model.Endpoint();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertEndpointStatus(src.getStatusElement()));
    if (src.hasConnectionType())
      tgt.setConnectionType(Coding43_50.convertCoding(src.getConnectionTypeFirstRep()));
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    if (src.hasManagingOrganization())
      tgt.setManagingOrganization(Reference43_50.convertReference(src.getManagingOrganization()));
    for (org.hl7.fhir.r5.model.ContactPoint t : src.getContact())
      tgt.addContact(ContactPoint43_50.convertContactPoint(t));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_50.convertPeriod(src.getPeriod()));
    for (EndpointPayloadComponent t : src.getPayload())
      if (t.hasType())
        tgt.addPayloadType(CodeableConcept43_50.convertCodeableConcept(t.getTypeFirstRep()));
    for (EndpointPayloadComponent t : src.getPayload())
      if (t.hasMimeType())
        tgt.getPayloadMimeType().add(Code43_50.convertCode(t.getMimeType().get(0)));
    if (src.hasAddress())
      tgt.setAddressElement(Url43_50.convertUrl(src.getAddressElement()));
    for (org.hl7.fhir.r5.model.StringType t : src.getHeader()) tgt.getHeader().add(String43_50.convertString(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Endpoint.EndpointStatus> convertEndpointStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Endpoint.EndpointStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Endpoint.EndpointStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Endpoint.EndpointStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
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
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Endpoint.EndpointStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Endpoint.EndpointStatus> convertEndpointStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Endpoint.EndpointStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Endpoint.EndpointStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Endpoint.EndpointStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r4b.model.Endpoint.EndpointStatus.ACTIVE);
        break;
      case SUSPENDED:
        tgt.setValue(org.hl7.fhir.r4b.model.Endpoint.EndpointStatus.SUSPENDED);
        break;
      case ERROR:
        tgt.setValue(org.hl7.fhir.r4b.model.Endpoint.EndpointStatus.ERROR);
        break;
      case OFF:
        tgt.setValue(org.hl7.fhir.r4b.model.Endpoint.EndpointStatus.OFF);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4b.model.Endpoint.EndpointStatus.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.Endpoint.EndpointStatus.NULL);
        break;
    }
    return tgt;
  }
}