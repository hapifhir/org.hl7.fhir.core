package org.hl7.fhir.convertors.conv30_40.resources30_40;

import org.hl7.fhir.convertors.context.ConversionContext30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.ContactDetail30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.CodeableConcept30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Timing30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.*;
import org.hl7.fhir.exceptions.FHIRException;

public class GraphDefinition30_40 {

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.GraphDefinition.CompartmentCode> convertCompartmentCode(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.GraphDefinition.CompartmentCode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.GraphDefinition.CompartmentCode> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.GraphDefinition.CompartmentCodeEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case PATIENT:
        tgt.setValue(org.hl7.fhir.r4.model.GraphDefinition.CompartmentCode.PATIENT);
        break;
      case ENCOUNTER:
        tgt.setValue(org.hl7.fhir.r4.model.GraphDefinition.CompartmentCode.ENCOUNTER);
        break;
      case RELATEDPERSON:
        tgt.setValue(org.hl7.fhir.r4.model.GraphDefinition.CompartmentCode.RELATEDPERSON);
        break;
      case PRACTITIONER:
        tgt.setValue(org.hl7.fhir.r4.model.GraphDefinition.CompartmentCode.PRACTITIONER);
        break;
      case DEVICE:
        tgt.setValue(org.hl7.fhir.r4.model.GraphDefinition.CompartmentCode.DEVICE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.GraphDefinition.CompartmentCode.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.GraphDefinition.CompartmentCode> convertCompartmentCode(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.GraphDefinition.CompartmentCode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.GraphDefinition.CompartmentCode> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.GraphDefinition.CompartmentCodeEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case PATIENT:
        tgt.setValue(org.hl7.fhir.dstu3.model.GraphDefinition.CompartmentCode.PATIENT);
        break;
      case ENCOUNTER:
        tgt.setValue(org.hl7.fhir.dstu3.model.GraphDefinition.CompartmentCode.ENCOUNTER);
        break;
      case RELATEDPERSON:
        tgt.setValue(org.hl7.fhir.dstu3.model.GraphDefinition.CompartmentCode.RELATEDPERSON);
        break;
      case PRACTITIONER:
        tgt.setValue(org.hl7.fhir.dstu3.model.GraphDefinition.CompartmentCode.PRACTITIONER);
        break;
      case DEVICE:
        tgt.setValue(org.hl7.fhir.dstu3.model.GraphDefinition.CompartmentCode.DEVICE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.GraphDefinition.CompartmentCode.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentRule> convertGraphCompartmentRule(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.GraphDefinition.GraphCompartmentRule> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentRule> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentRuleEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case IDENTICAL:
        tgt.setValue(org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentRule.IDENTICAL);
        break;
      case MATCHING:
        tgt.setValue(org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentRule.MATCHING);
        break;
      case DIFFERENT:
        tgt.setValue(org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentRule.DIFFERENT);
        break;
      case CUSTOM:
        tgt.setValue(org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentRule.CUSTOM);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentRule.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.GraphDefinition.GraphCompartmentRule> convertGraphCompartmentRule(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentRule> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.GraphDefinition.GraphCompartmentRule> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.GraphDefinition.GraphCompartmentRuleEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case IDENTICAL:
        tgt.setValue(org.hl7.fhir.dstu3.model.GraphDefinition.GraphCompartmentRule.IDENTICAL);
        break;
      case MATCHING:
        tgt.setValue(org.hl7.fhir.dstu3.model.GraphDefinition.GraphCompartmentRule.MATCHING);
        break;
      case DIFFERENT:
        tgt.setValue(org.hl7.fhir.dstu3.model.GraphDefinition.GraphCompartmentRule.DIFFERENT);
        break;
      case CUSTOM:
        tgt.setValue(org.hl7.fhir.dstu3.model.GraphDefinition.GraphCompartmentRule.CUSTOM);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.GraphDefinition.GraphCompartmentRule.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.GraphDefinition convertGraphDefinition(org.hl7.fhir.r4.model.GraphDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.GraphDefinition tgt = new org.hl7.fhir.dstu3.model.GraphDefinition();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri30_40.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String30_40.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String30_40.convertString(src.getNameElement()));
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
    for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(Timing30_40.convertUsageContext(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept30_40.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown30_40.convertMarkdown(src.getPurposeElement()));
    if (src.hasStart())
      tgt.setStartElement(Code30_40.convertCode(src.getStartElement()));
    if (src.hasProfile())
      tgt.setProfile(src.getProfile());
    for (org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkComponent t : src.getLink())
      tgt.addLink(convertGraphDefinitionLinkComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.GraphDefinition convertGraphDefinition(org.hl7.fhir.dstu3.model.GraphDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.GraphDefinition tgt = new org.hl7.fhir.r4.model.GraphDefinition();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri30_40.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String30_40.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String30_40.convertString(src.getNameElement()));
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
    for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(Timing30_40.convertUsageContext(t));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept30_40.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown30_40.convertMarkdown(src.getPurposeElement()));
    if (src.hasStart())
      tgt.setStartElement(Code30_40.convertCode(src.getStartElement()));
    if (src.hasProfile())
      tgt.setProfile(src.getProfile());
    for (org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkComponent t : src.getLink())
      tgt.addLink(convertGraphDefinitionLinkComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkComponent convertGraphDefinitionLinkComponent(org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkComponent tgt = new org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasPath())
      tgt.setPathElement(String30_40.convertString(src.getPathElement()));
    if (src.hasSliceName())
      tgt.setSliceNameElement(String30_40.convertString(src.getSliceNameElement()));
    if (src.hasMin())
      tgt.setMinElement(Integer30_40.convertInteger(src.getMinElement()));
    if (src.hasMax())
      tgt.setMaxElement(String30_40.convertString(src.getMaxElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String30_40.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkTargetComponent t : src.getTarget())
      tgt.addTarget(convertGraphDefinitionLinkTargetComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkComponent convertGraphDefinitionLinkComponent(org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkComponent tgt = new org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasPath())
      tgt.setPathElement(String30_40.convertString(src.getPathElement()));
    if (src.hasSliceName())
      tgt.setSliceNameElement(String30_40.convertString(src.getSliceNameElement()));
    if (src.hasMin())
      tgt.setMinElement(Integer30_40.convertInteger(src.getMinElement()));
    if (src.hasMax())
      tgt.setMaxElement(String30_40.convertString(src.getMaxElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String30_40.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkTargetComponent t : src.getTarget())
      tgt.addTarget(convertGraphDefinitionLinkTargetComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent convertGraphDefinitionLinkTargetCompartmentComponent(org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent tgt = new org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(convertCompartmentCode(src.getCodeElement()));
    if (src.hasRule())
      tgt.setRuleElement(convertGraphCompartmentRule(src.getRuleElement()));
    if (src.hasExpression())
      tgt.setExpressionElement(String30_40.convertString(src.getExpressionElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String30_40.convertString(src.getDescriptionElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent convertGraphDefinitionLinkTargetCompartmentComponent(org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent tgt = new org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(convertCompartmentCode(src.getCodeElement()));
    if (src.hasRule())
      tgt.setRuleElement(convertGraphCompartmentRule(src.getRuleElement()));
    if (src.hasExpression())
      tgt.setExpressionElement(String30_40.convertString(src.getExpressionElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String30_40.convertString(src.getDescriptionElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkTargetComponent convertGraphDefinitionLinkTargetComponent(org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkTargetComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkTargetComponent tgt = new org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkTargetComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(Code30_40.convertCode(src.getTypeElement()));
    if (src.hasProfile())
      tgt.setProfile(src.getProfile());
    for (org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent t : src.getCompartment())
      tgt.addCompartment(convertGraphDefinitionLinkTargetCompartmentComponent(t));
    for (org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkComponent t : src.getLink())
      tgt.addLink(convertGraphDefinitionLinkComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkTargetComponent convertGraphDefinitionLinkTargetComponent(org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkTargetComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkTargetComponent tgt = new org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkTargetComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(Code30_40.convertCode(src.getTypeElement()));
    if (src.hasProfile())
      tgt.setProfile(src.getProfile());
    for (org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent t : src.getCompartment())
      tgt.addCompartment(convertGraphDefinitionLinkTargetCompartmentComponent(t));
    for (org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkComponent t : src.getLink())
      tgt.addLink(convertGraphDefinitionLinkComponent(t));
    return tgt;
  }
}