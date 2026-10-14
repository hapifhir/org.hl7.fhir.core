package org.hl7.fhir.convertors.conv43_N.resources43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.CodeableConcept43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Coding43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.ContactPoint43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Identifier43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Period43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Code43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Url43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Reference43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.Endpoint;
import org.hl7.fhir.model.core.Endpoint.EndpointPayloadComponent;
import org.hl7.fhir.model.core.Enumeration;

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

public class Endpoint43_N {

  public static org.hl7.fhir.model.core.Endpoint convertEndpoint(org.hl7.fhir.r4b.model.Endpoint src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Endpoint tgt = new org.hl7.fhir.model.core.Endpoint();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertEndpointStatus(src.getStatusElement()));
    if (src.hasConnectionType())
      tgt.addConnectionType(Coding43_N.convertCodingToCodeableConcept(src.getConnectionType()));
    if (src.hasName())
      tgt.setNameElement(String43_N.convertString(src.getNameElement()));
    if (src.hasManagingOrganization())
      tgt.setManagingOrganization(Reference43_N.convertReference(src.getManagingOrganization()));
    for (org.hl7.fhir.r4b.model.ContactPoint t : src.getContact())
      tgt.addContact(ContactPoint43_N.convertContactPoint(t));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_N.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getPayloadType())
      tgt.addPayload().addType(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.CodeType t : src.getPayloadMimeType())
      tgt.addPayload().getMimeTypeList().add(Code43_N.convertCode(t));
    if (src.hasAddress())
      tgt.setAddressElement(Url43_N.convertUrl(src.getAddressElement()));
    for (org.hl7.fhir.r4b.model.StringType t : src.getHeader()) tgt.getHeaderList().add(String43_N.convertString(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Endpoint convertEndpoint(org.hl7.fhir.model.core.Endpoint src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Endpoint tgt = new org.hl7.fhir.r4b.model.Endpoint();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertEndpointStatus(src.getStatusElement()));
    if (src.hasConnectionType())
      tgt.setConnectionType(Coding43_N.convertCoding(src.getConnectionTypeFirstRep()));
    if (src.hasName())
      tgt.setNameElement(String43_N.convertString(src.getNameElement()));
    if (src.hasManagingOrganization())
      tgt.setManagingOrganization(Reference43_N.convertReference(src.getManagingOrganization()));
    for (org.hl7.fhir.model.core.ContactPoint t : src.getContactList())
      tgt.addContact(ContactPoint43_N.convertContactPoint(t));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_N.convertPeriod(src.getPeriod()));
    for (EndpointPayloadComponent t : src.getPayloadList())
      if (t.hasType())
        tgt.addPayloadType(CodeableConcept43_N.convertCodeableConcept(t.getTypeFirstRep()));
    for (EndpointPayloadComponent t : src.getPayloadList())
      if (t.hasMimeType())
        tgt.getPayloadMimeType().add(Code43_N.convertCode(t.getMimeTypeList().get(0)));
    if (src.hasAddress())
      tgt.setAddressElement(Url43_N.convertUrl(src.getAddressElement()));
    for (org.hl7.fhir.model.core.StringType t : src.getHeaderList()) tgt.getHeader().add(String43_N.convertString(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Endpoint.EndpointStatus> convertEndpointStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Endpoint.EndpointStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Endpoint.EndpointStatus> tgt = new Enumeration<>(new Endpoint.EndpointStatusEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ACTIVE:
                  tgt.setValue(Endpoint.EndpointStatus.ACTIVE);
                  break;
              case SUSPENDED:
                  tgt.setValue(Endpoint.EndpointStatus.SUSPENDED);
                  break;
              case ERROR:
                  tgt.setValue(Endpoint.EndpointStatus.ERROR);
                  break;
              case OFF:
                  tgt.setValue(Endpoint.EndpointStatus.OFF);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(Endpoint.EndpointStatus.ENTEREDINERROR);
                  break;
              default:
                  tgt.setValue(Endpoint.EndpointStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Endpoint.EndpointStatus> convertEndpointStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Endpoint.EndpointStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Endpoint.EndpointStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Endpoint.EndpointStatusEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }
}