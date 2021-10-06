package org.hl7.fhir.convertors.conv30_40.resources30_40;

import org.hl7.fhir.convertors.context.ConversionContext30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.ContactDetail30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.CodeableConcept30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Timing30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.*;
import org.hl7.fhir.exceptions.FHIRException;

public class CompartmentDefinition30_40 {

  public static org.hl7.fhir.dstu3.model.CompartmentDefinition convertCompartmentDefinition(org.hl7.fhir.r4.model.CompartmentDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.CompartmentDefinition tgt = new org.hl7.fhir.dstu3.model.CompartmentDefinition();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri30_40.convertUri(src.getUrlElement()));
    if (src.hasName())
      tgt.setNameElement(String30_40.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String30_40.convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations30_40.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean30_40.convertBoolean(src.getExperimentalElement()));
    if (src.hasDateElement())
      tgt.setDateElement(DateTime30_40.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String30_40.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail30_40.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown30_40.convertMarkdown(src.getDescriptionElement()));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown30_40.convertMarkdown(src.getPurposeElement()));
    for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(Timing30_40.convertUsageContext(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept30_40.convertCodeableConcept(t));
    if (src.hasCode())
      tgt.setCodeElement(convertCompartmentType(src.getCodeElement()));
    if (src.hasSearch())
      tgt.setSearchElement(Boolean30_40.convertBoolean(src.getSearchElement()));
    for (org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentDefinitionResourceComponent t : src.getResource())
      tgt.addResource(convertCompartmentDefinitionResourceComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CompartmentDefinition convertCompartmentDefinition(org.hl7.fhir.dstu3.model.CompartmentDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CompartmentDefinition tgt = new org.hl7.fhir.r4.model.CompartmentDefinition();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri30_40.convertUri(src.getUrlElement()));
    if (src.hasName())
      tgt.setNameElement(String30_40.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String30_40.convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations30_40.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean30_40.convertBoolean(src.getExperimentalElement()));
    if (src.hasDateElement())
      tgt.setDateElement(DateTime30_40.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String30_40.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail30_40.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown30_40.convertMarkdown(src.getDescriptionElement()));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown30_40.convertMarkdown(src.getPurposeElement()));
    for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(Timing30_40.convertUsageContext(t));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept30_40.convertCodeableConcept(t));
    if (src.hasCode())
      tgt.setCodeElement(convertCompartmentType(src.getCodeElement()));
    if (src.hasSearch())
      tgt.setSearchElement(Boolean30_40.convertBoolean(src.getSearchElement()));
    for (org.hl7.fhir.dstu3.model.CompartmentDefinition.CompartmentDefinitionResourceComponent t : src.getResource())
      tgt.addResource(convertCompartmentDefinitionResourceComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentDefinitionResourceComponent convertCompartmentDefinitionResourceComponent(org.hl7.fhir.dstu3.model.CompartmentDefinition.CompartmentDefinitionResourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentDefinitionResourceComponent tgt = new org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentDefinitionResourceComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(Code30_40.convertCode(src.getCodeElement()));
    for (org.hl7.fhir.dstu3.model.StringType t : src.getParam()) tgt.addParam(t.getValue());
    if (src.hasDocumentation())
      tgt.setDocumentationElement(String30_40.convertString(src.getDocumentationElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.CompartmentDefinition.CompartmentDefinitionResourceComponent convertCompartmentDefinitionResourceComponent(org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentDefinitionResourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.CompartmentDefinition.CompartmentDefinitionResourceComponent tgt = new org.hl7.fhir.dstu3.model.CompartmentDefinition.CompartmentDefinitionResourceComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(Code30_40.convertCode(src.getCodeElement()));
    for (org.hl7.fhir.r4.model.StringType t : src.getParam()) tgt.addParam(t.getValue());
    if (src.hasDocumentation())
      tgt.setDocumentationElement(String30_40.convertString(src.getDocumentationElement()));
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentType> convertCompartmentType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CompartmentDefinition.CompartmentType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentTypeEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
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
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CompartmentDefinition.CompartmentType> convertCompartmentType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CompartmentDefinition.CompartmentType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.CompartmentDefinition.CompartmentTypeEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case PATIENT:
        tgt.setValue(org.hl7.fhir.dstu3.model.CompartmentDefinition.CompartmentType.PATIENT);
        break;
      case ENCOUNTER:
        tgt.setValue(org.hl7.fhir.dstu3.model.CompartmentDefinition.CompartmentType.ENCOUNTER);
        break;
      case RELATEDPERSON:
        tgt.setValue(org.hl7.fhir.dstu3.model.CompartmentDefinition.CompartmentType.RELATEDPERSON);
        break;
      case PRACTITIONER:
        tgt.setValue(org.hl7.fhir.dstu3.model.CompartmentDefinition.CompartmentType.PRACTITIONER);
        break;
      case DEVICE:
        tgt.setValue(org.hl7.fhir.dstu3.model.CompartmentDefinition.CompartmentType.DEVICE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.CompartmentDefinition.CompartmentType.NULL);
        break;
    }
    return tgt;
  }
}