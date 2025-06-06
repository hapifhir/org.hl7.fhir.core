package org.hl7.fhir.convertors.conv14_40.resources14_40;

import org.hl7.fhir.convertors.context.ConversionContext14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.complextypes14_40.ContactPoint14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.Boolean14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.Code14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.DateTime14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.String14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.Uri14_40;
import org.hl7.fhir.dstu2016may.model.CompartmentDefinition;
import org.hl7.fhir.dstu2016may.model.Enumeration;
import org.hl7.fhir.exceptions.FHIRException;

public class CompartmentDefinition14_40 {

  public static org.hl7.fhir.r4.model.CompartmentDefinition convertCompartmentDefinition(org.hl7.fhir.dstu2016may.model.CompartmentDefinition src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.CompartmentDefinition tgt = new org.hl7.fhir.r4.model.CompartmentDefinition();
    ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyDomainResource(src, tgt);
    if (src.hasUrlElement())
      tgt.setUrlElement(Uri14_40.convertUri(src.getUrlElement()));
    if (src.hasNameElement())
      tgt.setNameElement(String14_40.convertString(src.getNameElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations14_40.convertConformanceResourceStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean14_40.convertBoolean(src.getExperimentalElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String14_40.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.dstu2016may.model.CompartmentDefinition.CompartmentDefinitionContactComponent t : src.getContact())
      tgt.addContact(convertCompartmentDefinitionContactComponent(t));
    if (src.hasDate())
      tgt.setDateElement(DateTime14_40.convertDateTime(src.getDateElement()));
    if (src.hasDescription())
      tgt.setDescription(src.getDescription());
    if (src.hasRequirements())
      tgt.setPurpose(src.getRequirements());
    if (src.hasCode())
      tgt.setCodeElement(convertCompartmentType(src.getCodeElement()));
    if (src.hasSearchElement())
      tgt.setSearchElement(Boolean14_40.convertBoolean(src.getSearchElement()));
    for (org.hl7.fhir.dstu2016may.model.CompartmentDefinition.CompartmentDefinitionResourceComponent t : src.getResource())
      tgt.addResource(convertCompartmentDefinitionResourceComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.CompartmentDefinition convertCompartmentDefinition(org.hl7.fhir.r4.model.CompartmentDefinition src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.CompartmentDefinition tgt = new org.hl7.fhir.dstu2016may.model.CompartmentDefinition();
    ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyDomainResource(src, tgt);
    if (src.hasUrlElement())
      tgt.setUrlElement(Uri14_40.convertUri(src.getUrlElement()));
    if (src.hasNameElement())
      tgt.setNameElement(String14_40.convertString(src.getNameElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations14_40.convertConformanceResourceStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean14_40.convertBoolean(src.getExperimentalElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String14_40.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact())
      tgt.addContact(convertCompartmentDefinitionContactComponent(t));
    if (src.hasDate())
      tgt.setDateElement(DateTime14_40.convertDateTime(src.getDateElement()));
    if (src.hasDescription())
      tgt.setDescription(src.getDescription());
    if (src.hasPurpose())
      tgt.setRequirements(src.getPurpose());
    if (src.hasCode())
      tgt.setCodeElement(convertCompartmentType(src.getCodeElement()));
    if (src.hasSearchElement())
      tgt.setSearchElement(Boolean14_40.convertBoolean(src.getSearchElement()));
    for (org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentDefinitionResourceComponent t : src.getResource())
      tgt.addResource(convertCompartmentDefinitionResourceComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ContactDetail convertCompartmentDefinitionContactComponent(org.hl7.fhir.dstu2016may.model.CompartmentDefinition.CompartmentDefinitionContactComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.ContactDetail tgt = new org.hl7.fhir.r4.model.ContactDetail();
    ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String14_40.convertString(src.getNameElement()));
    for (org.hl7.fhir.dstu2016may.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint14_40.convertContactPoint(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.CompartmentDefinition.CompartmentDefinitionContactComponent convertCompartmentDefinitionContactComponent(org.hl7.fhir.r4.model.ContactDetail src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.CompartmentDefinition.CompartmentDefinitionContactComponent tgt = new org.hl7.fhir.dstu2016may.model.CompartmentDefinition.CompartmentDefinitionContactComponent();
    ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String14_40.convertString(src.getNameElement()));
    for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint14_40.convertContactPoint(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentDefinitionResourceComponent convertCompartmentDefinitionResourceComponent(org.hl7.fhir.dstu2016may.model.CompartmentDefinition.CompartmentDefinitionResourceComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentDefinitionResourceComponent tgt = new org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentDefinitionResourceComponent();
    ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyBackboneElement(src,tgt);
    if (src.hasCodeElement())
      tgt.setCodeElement(Code14_40.convertCode(src.getCodeElement()));
    for (org.hl7.fhir.dstu2016may.model.StringType t : src.getParam()) tgt.addParam(t.getValue());
    if (src.hasDocumentation())
      tgt.setDocumentationElement(String14_40.convertString(src.getDocumentationElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.CompartmentDefinition.CompartmentDefinitionResourceComponent convertCompartmentDefinitionResourceComponent(org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentDefinitionResourceComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.CompartmentDefinition.CompartmentDefinitionResourceComponent tgt = new org.hl7.fhir.dstu2016may.model.CompartmentDefinition.CompartmentDefinitionResourceComponent();
    ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyBackboneElement(src,tgt);
    if (src.hasCodeElement())
      tgt.setCodeElement(Code14_40.convertCode(src.getCodeElement()));
    for (org.hl7.fhir.r4.model.StringType t : src.getParam()) tgt.addParam(t.getValue());
    if (src.hasDocumentation())
      tgt.setDocumentationElement(String14_40.convertString(src.getDocumentationElement()));
    return tgt;
  }

  static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.CompartmentDefinition.CompartmentType> convertCompartmentType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<CompartmentDefinition.CompartmentType> tgt = new Enumeration<>(new CompartmentDefinition.CompartmentTypeEnumFactory());
      ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PATIENT:
                  tgt.setValue(CompartmentDefinition.CompartmentType.PATIENT);
                  break;
              case ENCOUNTER:
                  tgt.setValue(CompartmentDefinition.CompartmentType.ENCOUNTER);
                  break;
              case RELATEDPERSON:
                  tgt.setValue(CompartmentDefinition.CompartmentType.RELATEDPERSON);
                  break;
              case PRACTITIONER:
                  tgt.setValue(CompartmentDefinition.CompartmentType.PRACTITIONER);
                  break;
              case DEVICE:
                  tgt.setValue(CompartmentDefinition.CompartmentType.DEVICE);
                  break;
              default:
                  tgt.setValue(CompartmentDefinition.CompartmentType.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentType> convertCompartmentType(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.CompartmentDefinition.CompartmentType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentTypeEnumFactory());
      ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PATIENT:
                  tgt.setValue(org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentType.PATIENT);
                  break;
              case ENCOUNTER:
                  tgt.setValue(org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentType.ENCOUNTER);
                  break;
              case RELATEDPERSON:
                  tgt.setValue(org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentType.RELATEDPERSON);
                  break;
              case PRACTITIONER:
                  tgt.setValue(org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentType.PRACTITIONER);
                  break;
              case DEVICE:
                  tgt.setValue(org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentType.DEVICE);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentType.NULL);
                  break;
          }
      }
      return tgt;
  }
}