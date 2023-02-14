package org.hl7.fhir.convertors.conv30_50.resources30_50;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.ContactDetail30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.UsageContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Boolean30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Code30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.DateTime30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.MarkDown30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.String30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Uri30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class CompartmentDefinition30_50 {

  public static org.hl7.fhir.r5.model.CompartmentDefinition convertCompartmentDefinition(org.hl7.fhir.dstu3.model.CompartmentDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CompartmentDefinition tgt = new org.hl7.fhir.r5.model.CompartmentDefinition();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri30_50.convertUri(src.getUrlElement()));
    if (src.hasName())
      tgt.setNameElement(String30_50.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String30_50.convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations30_50.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean30_50.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime30_50.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String30_50.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail30_50.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown30_50.convertMarkdown(src.getDescriptionElement()));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown30_50.convertMarkdown(src.getPurposeElement()));
    for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext30_50.convertUsageContext(t));
    if (src.hasCode())
      tgt.setCodeElement(convertCompartmentType(src.getCodeElement()));
    if (src.hasSearch())
      tgt.setSearchElement(Boolean30_50.convertBoolean(src.getSearchElement()));
    for (org.hl7.fhir.dstu3.model.CompartmentDefinition.CompartmentDefinitionResourceComponent t : src.getResource())
      tgt.addResource(convertCompartmentDefinitionResourceComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.CompartmentDefinition convertCompartmentDefinition(org.hl7.fhir.r5.model.CompartmentDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.CompartmentDefinition tgt = new org.hl7.fhir.dstu3.model.CompartmentDefinition();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri30_50.convertUri(src.getUrlElement()));
    if (src.hasName())
      tgt.setNameElement(String30_50.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String30_50.convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations30_50.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean30_50.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime30_50.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String30_50.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail30_50.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown30_50.convertMarkdown(src.getDescriptionElement()));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown30_50.convertMarkdown(src.getPurposeElement()));
    for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext30_50.convertUsageContext(t));
    if (src.hasCode())
      tgt.setCodeElement(convertCompartmentType(src.getCodeElement()));
    if (src.hasSearch())
      tgt.setSearchElement(Boolean30_50.convertBoolean(src.getSearchElement()));
    for (org.hl7.fhir.r5.model.CompartmentDefinition.CompartmentDefinitionResourceComponent t : src.getResource())
      tgt.addResource(convertCompartmentDefinitionResourceComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CompartmentDefinition.CompartmentDefinitionResourceComponent convertCompartmentDefinitionResourceComponent(org.hl7.fhir.dstu3.model.CompartmentDefinition.CompartmentDefinitionResourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CompartmentDefinition.CompartmentDefinitionResourceComponent tgt = new org.hl7.fhir.r5.model.CompartmentDefinition.CompartmentDefinitionResourceComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasCode())
      tgt.setCodeElement(Code30_50.convertCode(src.getCodeElement()));
    for (org.hl7.fhir.dstu3.model.StringType t : src.getParam()) tgt.addParam(t.getValue());
    if (src.hasDocumentation())
      tgt.setDocumentationElement(String30_50.convertString(src.getDocumentationElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.CompartmentDefinition.CompartmentDefinitionResourceComponent convertCompartmentDefinitionResourceComponent(org.hl7.fhir.r5.model.CompartmentDefinition.CompartmentDefinitionResourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.CompartmentDefinition.CompartmentDefinitionResourceComponent tgt = new org.hl7.fhir.dstu3.model.CompartmentDefinition.CompartmentDefinitionResourceComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasCode())
      tgt.setCodeElement(Code30_50.convertCode(src.getCodeElement()));
    for (org.hl7.fhir.r5.model.StringType t : src.getParam()) tgt.addParam(t.getValue());
    if (src.hasDocumentation())
      tgt.setDocumentationElement(String30_50.convertString(src.getDocumentationElement()));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CompartmentDefinition.CompartmentType> convertCompartmentType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CompartmentType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CompartmentDefinition.CompartmentType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.CompartmentDefinition.CompartmentTypeEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CompartmentType> convertCompartmentType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CompartmentDefinition.CompartmentType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CompartmentType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.CompartmentTypeEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PATIENT:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CompartmentType.PATIENT);
        break;
      case ENCOUNTER:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CompartmentType.ENCOUNTER);
        break;
      case RELATEDPERSON:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CompartmentType.RELATEDPERSON);
        break;
      case PRACTITIONER:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CompartmentType.PRACTITIONER);
        break;
      case DEVICE:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CompartmentType.DEVICE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CompartmentType.NULL);
        break;
    }
    return tgt;
  }
}