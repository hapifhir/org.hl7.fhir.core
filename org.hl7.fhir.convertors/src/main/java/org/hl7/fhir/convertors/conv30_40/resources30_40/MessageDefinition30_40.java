package org.hl7.fhir.convertors.conv30_40.resources30_40;

import org.hl7.fhir.convertors.context.ConversionContext30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.ContactDetail30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Reference30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.CodeableConcept30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Coding30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Identifier30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Timing30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.*;
import org.hl7.fhir.exceptions.FHIRException;

public class MessageDefinition30_40 {

  public static org.hl7.fhir.dstu3.model.MessageDefinition convertMessageDefinition(org.hl7.fhir.r4.model.MessageDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.MessageDefinition tgt = new org.hl7.fhir.dstu3.model.MessageDefinition();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri30_40.convertUri(src.getUrlElement()));
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier30_40.convertIdentifier(src.getIdentifierFirstRep()));
    if (src.hasVersion())
      tgt.setVersionElement(String30_40.convertString(src.getVersionElement()));
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
    for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(Timing30_40.convertUsageContext(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept30_40.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown30_40.convertMarkdown(src.getPurposeElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown30_40.convertMarkdown(src.getCopyrightElement()));
    if (src.hasBase())
      tgt.setBase(Reference30_40.convertCanonicalToReference(src.getBaseElement()));
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getParent())
      tgt.addParent(Reference30_40.convertCanonicalToReference(t));
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getReplaces())
      tgt.addReplaces(Reference30_40.convertCanonicalToReference(t));
    if (src.hasEventCoding())
      tgt.setEvent(Coding30_40.convertCoding(src.getEventCoding()));
    if (src.hasCategory())
      tgt.setCategoryElement(convertMessageSignificanceCategory(src.getCategoryElement()));
    for (org.hl7.fhir.r4.model.MessageDefinition.MessageDefinitionFocusComponent t : src.getFocus())
      tgt.addFocus(convertMessageDefinitionFocusComponent(t));
    if (src.hasResponseRequired())
      tgt.setResponseRequired(src.getResponseRequired() != org.hl7.fhir.r4.model.MessageDefinition.MessageheaderResponseRequest.NEVER);
    for (org.hl7.fhir.r4.model.MessageDefinition.MessageDefinitionAllowedResponseComponent t : src.getAllowedResponse())
      tgt.addAllowedResponse(convertMessageDefinitionAllowedResponseComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MessageDefinition convertMessageDefinition(org.hl7.fhir.dstu3.model.MessageDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MessageDefinition tgt = new org.hl7.fhir.r4.model.MessageDefinition();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri30_40.convertUri(src.getUrlElement()));
    if (src.hasIdentifier())
      tgt.addIdentifier(Identifier30_40.convertIdentifier(src.getIdentifier()));
    if (src.hasVersion())
      tgt.setVersionElement(String30_40.convertString(src.getVersionElement()));
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
    for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(Timing30_40.convertUsageContext(t));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept30_40.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown30_40.convertMarkdown(src.getPurposeElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown30_40.convertMarkdown(src.getCopyrightElement()));
    if (src.hasBase())
      tgt.setBaseElement(Reference30_40.convertReferenceToCanonical(src.getBase()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getParent())
      tgt.getParent().add(Reference30_40.convertReferenceToCanonical(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getReplaces())
      tgt.getReplaces().add(Reference30_40.convertReferenceToCanonical(t));
    if (src.hasEvent())
      tgt.setEvent(Coding30_40.convertCoding(src.getEvent()));
    if (src.hasCategory())
      tgt.setCategoryElement(convertMessageSignificanceCategory(src.getCategoryElement()));
    for (org.hl7.fhir.dstu3.model.MessageDefinition.MessageDefinitionFocusComponent t : src.getFocus())
      tgt.addFocus(convertMessageDefinitionFocusComponent(t));
    if (src.hasResponseRequired())
      tgt.setResponseRequired(src.getResponseRequired() ? org.hl7.fhir.r4.model.MessageDefinition.MessageheaderResponseRequest.ALWAYS : org.hl7.fhir.r4.model.MessageDefinition.MessageheaderResponseRequest.NEVER);
    for (org.hl7.fhir.dstu3.model.MessageDefinition.MessageDefinitionAllowedResponseComponent t : src.getAllowedResponse())
      tgt.addAllowedResponse(convertMessageDefinitionAllowedResponseComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.MessageDefinition.MessageDefinitionAllowedResponseComponent convertMessageDefinitionAllowedResponseComponent(org.hl7.fhir.r4.model.MessageDefinition.MessageDefinitionAllowedResponseComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.MessageDefinition.MessageDefinitionAllowedResponseComponent tgt = new org.hl7.fhir.dstu3.model.MessageDefinition.MessageDefinitionAllowedResponseComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasMessage())
      tgt.setMessage(Reference30_40.convertCanonicalToReference(src.getMessageElement()));
    if (src.hasSituation())
      tgt.setSituationElement(MarkDown30_40.convertMarkdown(src.getSituationElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MessageDefinition.MessageDefinitionAllowedResponseComponent convertMessageDefinitionAllowedResponseComponent(org.hl7.fhir.dstu3.model.MessageDefinition.MessageDefinitionAllowedResponseComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MessageDefinition.MessageDefinitionAllowedResponseComponent tgt = new org.hl7.fhir.r4.model.MessageDefinition.MessageDefinitionAllowedResponseComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasMessage())
      tgt.setMessageElement(Reference30_40.convertReferenceToCanonical(src.getMessage()));
    if (src.hasSituation())
      tgt.setSituationElement(MarkDown30_40.convertMarkdown(src.getSituationElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MessageDefinition.MessageDefinitionFocusComponent convertMessageDefinitionFocusComponent(org.hl7.fhir.dstu3.model.MessageDefinition.MessageDefinitionFocusComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MessageDefinition.MessageDefinitionFocusComponent tgt = new org.hl7.fhir.r4.model.MessageDefinition.MessageDefinitionFocusComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(Code30_40.convertCode(src.getCodeElement()));
    if (src.hasProfile())
      tgt.setProfileElement(Reference30_40.convertReferenceToCanonical(src.getProfile()));
    if (src.hasMin())
      tgt.setMinElement(UnsignedInt30_40.convertUnsignedInt(src.getMinElement()));
    if (src.hasMax())
      tgt.setMaxElement(String30_40.convertString(src.getMaxElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.MessageDefinition.MessageDefinitionFocusComponent convertMessageDefinitionFocusComponent(org.hl7.fhir.r4.model.MessageDefinition.MessageDefinitionFocusComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.MessageDefinition.MessageDefinitionFocusComponent tgt = new org.hl7.fhir.dstu3.model.MessageDefinition.MessageDefinitionFocusComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(Code30_40.convertCode(src.getCodeElement()));
    if (src.hasProfile())
      tgt.setProfile(Reference30_40.convertCanonicalToReference(src.getProfileElement()));
    if (src.hasMin())
      tgt.setMinElement(UnsignedInt30_40.convertUnsignedInt(src.getMinElement()));
    if (src.hasMax())
      tgt.setMaxElement(String30_40.convertString(src.getMaxElement()));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MessageDefinition.MessageSignificanceCategory> convertMessageSignificanceCategory(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MessageDefinition.MessageSignificanceCategory> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MessageDefinition.MessageSignificanceCategory> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.MessageDefinition.MessageSignificanceCategoryEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case CONSEQUENCE:
        tgt.setValue(org.hl7.fhir.dstu3.model.MessageDefinition.MessageSignificanceCategory.CONSEQUENCE);
        break;
      case CURRENCY:
        tgt.setValue(org.hl7.fhir.dstu3.model.MessageDefinition.MessageSignificanceCategory.CURRENCY);
        break;
      case NOTIFICATION:
        tgt.setValue(org.hl7.fhir.dstu3.model.MessageDefinition.MessageSignificanceCategory.NOTIFICATION);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.MessageDefinition.MessageSignificanceCategory.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MessageDefinition.MessageSignificanceCategory> convertMessageSignificanceCategory(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MessageDefinition.MessageSignificanceCategory> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MessageDefinition.MessageSignificanceCategory> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.MessageDefinition.MessageSignificanceCategoryEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case CONSEQUENCE:
        tgt.setValue(org.hl7.fhir.r4.model.MessageDefinition.MessageSignificanceCategory.CONSEQUENCE);
        break;
      case CURRENCY:
        tgt.setValue(org.hl7.fhir.r4.model.MessageDefinition.MessageSignificanceCategory.CURRENCY);
        break;
      case NOTIFICATION:
        tgt.setValue(org.hl7.fhir.r4.model.MessageDefinition.MessageSignificanceCategory.NOTIFICATION);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.MessageDefinition.MessageSignificanceCategory.NULL);
        break;
    }
    return tgt;
  }
}