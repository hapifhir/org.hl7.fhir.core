package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionElements40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionDatatype40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Coding40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.ContactPoint40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Period40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Code40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Url40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
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

public class Endpoint40_N {

  public static org.hl7.fhir.model.core.Endpoint convertEndpoint(org.hl7.fhir.r4.model.Endpoint src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Endpoint tgt = new org.hl7.fhir.model.core.Endpoint();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, CrossVersionElements40_N.urls("Endpoint", "5.0", new String[] {"description", "environmentType", "connectionType", "payload"},
      CrossVersionElements40_N.urls("Endpoint", "6.0", new String[] {"availability"},
      CrossVersionElements40_N.urls("Endpoint.payload", "6.0", new String[] {"profileCanonical", "profileUri"}))));
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "description", "environmentType");
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "6.0", "availability");
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(CrossVersionElements40_N.toR6Code(src.getStatusElement(), convertEndpointStatus(src.getStatusElement()), src.fhirType(), "status"));
    // the full list, if R4 couldn't hold it, is in the extension
    if (src.hasExtension(CrossVersionElements40_N.url("Endpoint", "5.0", "connectionType")))
      CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "connectionType");
    else if (src.hasConnectionType())
      tgt.addConnectionType(Coding40_N.convertCodingToCodeableConcept(src.getConnectionType()));
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasManagingOrganization())
      tgt.setManagingOrganization(Reference40_N.convertReference(src.getManagingOrganization()));
    for (org.hl7.fhir.r4.model.ContactPoint t : src.getContact())
      tgt.addContact(ContactPoint40_N.convertContactPoint(t));
    if (src.hasPeriod())
      tgt.setPeriod(Period40_N.convertPeriod(src.getPeriod()));
    // R4 has one set of payload types and mime types: that's one payload. Any others are in the extension
    if (src.hasPayloadType() || src.hasPayloadMimeType() || src.hasExtension(CrossVersionElements40_N.url("Endpoint.payload", "6.0", "profileCanonical"))
      || src.hasExtension(CrossVersionElements40_N.url("Endpoint.payload", "6.0", "profileUri"))) {
      EndpointPayloadComponent p = tgt.addPayload();
      for (org.hl7.fhir.r4.model.CodeableConcept t : src.getPayloadType())
        p.addType(CodeableConcept40_N.convertCodeableConcept(t));
      for (org.hl7.fhir.r4.model.CodeType t : src.getPayloadMimeType())
        p.getMimeTypeList().add(Code40_N.convertCode(t));
      CrossVersionElements40_N.extensionsToElementsForPath(src.getExtension(), p, "Endpoint.payload", "6.0", "profileCanonical", "profileUri");
    }
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "payload");
    if (src.hasAddress())
      tgt.setAddressElement(Url40_N.convertUrl(src.getAddressElement()));
    for (org.hl7.fhir.r4.model.StringType t : src.getHeader()) tgt.getHeaderList().add(String40_N.convertString(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Endpoint convertEndpoint(org.hl7.fhir.model.core.Endpoint src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Endpoint tgt = new org.hl7.fhir.r4.model.Endpoint();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "5.0", "description", "environmentType");
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "6.0", "availability");
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(CrossVersionElements40_N.toR4Code(src.getStatusElement(), convertEndpointStatus(src.getStatusElement()), src.fhirType(), "status"));
    if (src.hasConnectionType()) {
      org.hl7.fhir.model.core.CodeableConcept ct = src.getConnectionTypeFirstRep();
      if (ct.hasCoding())
        tgt.setConnectionType(Coding40_N.convertCoding(ct.getCodingFirstRep()));
      // R4 only has room for one Coding: if there's more than that, the full list goes in the extension
      if (src.getConnectionTypeList().size() > 1 || ct.getCodingList().size() != 1 || ct.hasText() || ct.hasId() || ct.hasExtension())
        CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "5.0", "connectionType");
    }
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasManagingOrganization())
      tgt.setManagingOrganization(Reference40_N.convertReference(src.getManagingOrganization()));
    for (org.hl7.fhir.model.core.ContactPoint t : src.getContactList())
      tgt.addContact(ContactPoint40_N.convertContactPoint(t));
    if (src.hasPeriod())
      tgt.setPeriod(Period40_N.convertPeriod(src.getPeriod()));
    // R4 has one set of payload types and mime types: the first payload goes there, the rest in the extension
    boolean first = true;
    for (EndpointPayloadComponent t : src.getPayloadList()) {
      if (first) {
        for (org.hl7.fhir.model.core.CodeableConcept c : t.getTypeList())
          tgt.addPayloadType(CodeableConcept40_N.convertCodeableConcept(c));
        for (org.hl7.fhir.model.core.CodeType c : t.getMimeTypeList())
          tgt.getPayloadMimeType().add(Code40_N.convertCode(c));
        CrossVersionElements40_N.elementsToExtensionsForPath(t, "Endpoint.payload", tgt.getExtension(), "6.0", "profileCanonical", "profileUri");
        first = false;
      } else {
        tgt.addExtension(CrossVersionDatatype40_N.convertToExtension(CrossVersionElements40_N.url("Endpoint", "5.0", "payload"), t));
      }
    }
    if (src.hasAddress())
      tgt.setAddressElement(Url40_N.convertUrl(src.getAddressElement()));
    for (org.hl7.fhir.model.core.StringType t : src.getHeaderList()) tgt.getHeader().add(String40_N.convertString(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Endpoint.EndpointStatus> convertEndpointStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Endpoint.EndpointStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Endpoint.EndpointStatus> tgt = new Enumeration<>(new Endpoint.EndpointStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Endpoint.EndpointStatus> convertEndpointStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Endpoint.EndpointStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Endpoint.EndpointStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Endpoint.EndpointStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
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
              default:
                  tgt.setValue(org.hl7.fhir.r4.model.Endpoint.EndpointStatus.NULL);
                  break;
          }
      }
      return tgt;
  }
}