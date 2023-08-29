package org.hl7.fhir.convertors.conv30_50.resources30_50;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Reference30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.CodeableConcept30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Coding30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.ContactPoint30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Identifier30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Period30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Code30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.String30_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.Endpoint.EndpointPayloadComponent;

public class Endpoint30_50 {

  public static org.hl7.fhir.dstu3.model.Endpoint convertEndpoint(org.hl7.fhir.r5.model.Endpoint src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Endpoint tgt = new org.hl7.fhir.dstu3.model.Endpoint();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertEndpointStatus(src.getStatusElement()));
    if (src.hasConnectionType())
      tgt.setConnectionType(Coding30_50.convertCoding(src.getConnectionTypeFirstRep()));
    if (src.hasName())
      tgt.setNameElement(String30_50.convertString(src.getNameElement()));
    if (src.hasManagingOrganization())
      tgt.setManagingOrganization(Reference30_50.convertReference(src.getManagingOrganization()));
    for (org.hl7.fhir.r5.model.ContactPoint t : src.getContact())
      tgt.addContact(ContactPoint30_50.convertContactPoint(t));
    if (src.hasPeriod())
      tgt.setPeriod(Period30_50.convertPeriod(src.getPeriod()));
    for (EndpointPayloadComponent t : src.getPayload())
      if (t.hasType())
        tgt.addPayloadType(CodeableConcept30_50.convertCodeableConcept(t.getTypeFirstRep()));
    for (EndpointPayloadComponent t : src.getPayload())
      if (t.hasMimeType())
        tgt.getPayloadMimeType().add(Code30_50.convertCode(t.getMimeType().get(0)));
    if (src.hasAddress())
      tgt.setAddress(src.getAddress());
    for (org.hl7.fhir.r5.model.StringType t : src.getHeader()) tgt.addHeader(t.getValue());
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Endpoint convertEndpoint(org.hl7.fhir.dstu3.model.Endpoint src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Endpoint tgt = new org.hl7.fhir.r5.model.Endpoint();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertEndpointStatus(src.getStatusElement()));
    if (src.hasConnectionType())
      tgt.addConnectionType(Coding30_50.convertCodingToCodeableConcept(src.getConnectionType()));
    if (src.hasName())
      tgt.setNameElement(String30_50.convertString(src.getNameElement()));
    if (src.hasManagingOrganization())
      tgt.setManagingOrganization(Reference30_50.convertReference(src.getManagingOrganization()));
    for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getContact())
      tgt.addContact(ContactPoint30_50.convertContactPoint(t));
    if (src.hasPeriod())
      tgt.setPeriod(Period30_50.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getPayloadType())
      tgt.addPayload().addType(CodeableConcept30_50.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu3.model.CodeType t : src.getPayloadMimeType()) tgt.addPayload().addMimeType(t.getValue());
    if (src.hasAddress())
      tgt.setAddress(src.getAddress());
    for (org.hl7.fhir.dstu3.model.StringType t : src.getHeader()) tgt.addHeader(t.getValue());
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Endpoint.EndpointStatus> convertEndpointStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Endpoint.EndpointStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Endpoint.EndpointStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Endpoint.EndpointStatusEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Endpoint.EndpointStatus> convertEndpointStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Endpoint.EndpointStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Endpoint.EndpointStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Endpoint.EndpointStatusEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.dstu3.model.Endpoint.EndpointStatus.ACTIVE);
        break;
      case SUSPENDED:
        tgt.setValue(org.hl7.fhir.dstu3.model.Endpoint.EndpointStatus.SUSPENDED);
        break;
      case ERROR:
        tgt.setValue(org.hl7.fhir.dstu3.model.Endpoint.EndpointStatus.ERROR);
        break;
      case OFF:
        tgt.setValue(org.hl7.fhir.dstu3.model.Endpoint.EndpointStatus.OFF);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.dstu3.model.Endpoint.EndpointStatus.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.Endpoint.EndpointStatus.NULL);
        break;
    }
    return tgt;
  }
}