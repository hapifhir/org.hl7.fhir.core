package org.hl7.fhir.convertors.conv14_30.resources14_30;

import org.hl7.fhir.convertors.context.ConversionContext14_30;
import org.hl7.fhir.convertors.conv14_30.VersionConvertor_14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.ElementDefinition14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.complextypes14_30.CodeableConcept14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.complextypes14_30.ContactPoint14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.complextypes14_30.Identifier14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30.*;
import org.hl7.fhir.exceptions.FHIRException;

public class DataElement14_30 {

  public static org.hl7.fhir.dstu3.model.DataElement convertDataElement(org.hl7.fhir.dstu2016may.model.DataElement src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.DataElement tgt = new org.hl7.fhir.dstu3.model.DataElement();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri14_30.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.dstu2016may.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier14_30.convertIdentifier(t));
    if (src.hasVersion())
      tgt.setVersionElement(String14_30.convertString(src.getVersionElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations14_30.convertConformanceResourceStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean14_30.convertBoolean(src.getExperimentalElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String14_30.convertString(src.getPublisherElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime14_30.convertDateTime(src.getDateElement()));
    if (src.hasName())
      tgt.setNameElement(String14_30.convertString(src.getNameElement()));
    for (org.hl7.fhir.dstu2016may.model.DataElement.DataElementContactComponent t : src.getContact())
      tgt.addContact(convertDataElementContactComponent(t));
    for (org.hl7.fhir.dstu2016may.model.CodeableConcept t : src.getUseContext())
      if (VersionConvertor_14_30.isJurisdiction(t))
        tgt.addJurisdiction(CodeableConcept14_30.convertCodeableConcept(t));
      else
        tgt.addUseContext(CodeableConcept14_30.convertCodeableConceptToUsageContext(t));
    if (src.hasCopyright())
      tgt.setCopyright(src.getCopyright());
    if (src.hasStringency())
      tgt.setStringencyElement(convertDataElementStringency(src.getStringencyElement()));
    for (org.hl7.fhir.dstu2016may.model.DataElement.DataElementMappingComponent t : src.getMapping())
      tgt.addMapping(convertDataElementMappingComponent(t));
    for (org.hl7.fhir.dstu2016may.model.ElementDefinition t : src.getElement())
      tgt.addElement(ElementDefinition14_30.convertElementDefinition(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.DataElement convertDataElement(org.hl7.fhir.dstu3.model.DataElement src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.DataElement tgt = new org.hl7.fhir.dstu2016may.model.DataElement();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri14_30.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier14_30.convertIdentifier(t));
    if (src.hasVersion())
      tgt.setVersionElement(String14_30.convertString(src.getVersionElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations14_30.convertConformanceResourceStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean14_30.convertBoolean(src.getExperimentalElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String14_30.convertString(src.getPublisherElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime14_30.convertDateTime(src.getDateElement()));
    if (src.hasName())
      tgt.setNameElement(String14_30.convertString(src.getNameElement()));
    for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact())
      tgt.addContact(convertDataElementContactComponent(t));
    for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext())
      if (t.hasValueCodeableConcept())
        tgt.addUseContext(CodeableConcept14_30.convertCodeableConcept(t.getValueCodeableConcept()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction())
      tgt.addUseContext(CodeableConcept14_30.convertCodeableConcept(t));
    if (src.hasCopyright())
      tgt.setCopyright(src.getCopyright());
    if (src.hasStringency())
      tgt.setStringencyElement(convertDataElementStringency(src.getStringencyElement()));
    for (org.hl7.fhir.dstu3.model.DataElement.DataElementMappingComponent t : src.getMapping())
      tgt.addMapping(convertDataElementMappingComponent(t));
    for (org.hl7.fhir.dstu3.model.ElementDefinition t : src.getElement())
      tgt.addElement(ElementDefinition14_30.convertElementDefinition(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.ContactDetail convertDataElementContactComponent(org.hl7.fhir.dstu2016may.model.DataElement.DataElementContactComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.ContactDetail tgt = new org.hl7.fhir.dstu3.model.ContactDetail();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String14_30.convertString(src.getNameElement()));
    for (org.hl7.fhir.dstu2016may.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint14_30.convertContactPoint(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.DataElement.DataElementContactComponent convertDataElementContactComponent(org.hl7.fhir.dstu3.model.ContactDetail src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.DataElement.DataElementContactComponent tgt = new org.hl7.fhir.dstu2016may.model.DataElement.DataElementContactComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String14_30.convertString(src.getNameElement()));
    for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint14_30.convertContactPoint(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.DataElement.DataElementMappingComponent convertDataElementMappingComponent(org.hl7.fhir.dstu2016may.model.DataElement.DataElementMappingComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.DataElement.DataElementMappingComponent tgt = new org.hl7.fhir.dstu3.model.DataElement.DataElementMappingComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasIdentityElement())
      tgt.setIdentityElement(Id14_30.convertId(src.getIdentityElement()));
    if (src.hasUri())
      tgt.setUriElement(Uri14_30.convertUri(src.getUriElement()));
    if (src.hasName())
      tgt.setNameElement(String14_30.convertString(src.getNameElement()));
    if (src.hasComment())
      tgt.setCommentElement(String14_30.convertString(src.getCommentElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.DataElement.DataElementMappingComponent convertDataElementMappingComponent(org.hl7.fhir.dstu3.model.DataElement.DataElementMappingComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.DataElement.DataElementMappingComponent tgt = new org.hl7.fhir.dstu2016may.model.DataElement.DataElementMappingComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasIdentityElement())
      tgt.setIdentityElement(Id14_30.convertId(src.getIdentityElement()));
    if (src.hasUri())
      tgt.setUriElement(Uri14_30.convertUri(src.getUriElement()));
    if (src.hasName())
      tgt.setNameElement(String14_30.convertString(src.getNameElement()));
    if (src.hasComment())
      tgt.setCommentElement(String14_30.convertString(src.getCommentElement()));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.DataElement.DataElementStringency> convertDataElementStringency(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.DataElement.DataElementStringency> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.DataElement.DataElementStringency> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.DataElement.DataElementStringencyEnumFactory());
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    switch (src.getValue()) {
      case COMPARABLE:
        tgt.setValue(org.hl7.fhir.dstu3.model.DataElement.DataElementStringency.COMPARABLE);
        break;
      case FULLYSPECIFIED:
        tgt.setValue(org.hl7.fhir.dstu3.model.DataElement.DataElementStringency.FULLYSPECIFIED);
        break;
      case EQUIVALENT:
        tgt.setValue(org.hl7.fhir.dstu3.model.DataElement.DataElementStringency.EQUIVALENT);
        break;
      case CONVERTABLE:
        tgt.setValue(org.hl7.fhir.dstu3.model.DataElement.DataElementStringency.CONVERTABLE);
        break;
      case SCALEABLE:
        tgt.setValue(org.hl7.fhir.dstu3.model.DataElement.DataElementStringency.SCALEABLE);
        break;
      case FLEXIBLE:
        tgt.setValue(org.hl7.fhir.dstu3.model.DataElement.DataElementStringency.FLEXIBLE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.DataElement.DataElementStringency.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.DataElement.DataElementStringency> convertDataElementStringency(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.DataElement.DataElementStringency> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.DataElement.DataElementStringency> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.DataElement.DataElementStringencyEnumFactory());
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    switch (src.getValue()) {
      case COMPARABLE:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.DataElement.DataElementStringency.COMPARABLE);
        break;
      case FULLYSPECIFIED:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.DataElement.DataElementStringency.FULLYSPECIFIED);
        break;
      case EQUIVALENT:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.DataElement.DataElementStringency.EQUIVALENT);
        break;
      case CONVERTABLE:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.DataElement.DataElementStringency.CONVERTABLE);
        break;
      case SCALEABLE:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.DataElement.DataElementStringency.SCALEABLE);
        break;
      case FLEXIBLE:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.DataElement.DataElementStringency.FLEXIBLE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.DataElement.DataElementStringency.NULL);
        break;
    }
    return tgt;
  }
}