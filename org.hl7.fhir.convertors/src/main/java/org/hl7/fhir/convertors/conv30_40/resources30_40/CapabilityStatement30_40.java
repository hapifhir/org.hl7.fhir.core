package org.hl7.fhir.convertors.conv30_40.resources30_40;

import java.util.stream.Collectors;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.context.ConversionContext30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.ContactDetail30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Reference30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.CodeableConcept30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Coding30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Timing30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Boolean30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Code30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.DateTime30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.MarkDown30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.String30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.UnsignedInt30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Uri30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class CapabilityStatement30_40 {

  public static final String ACCEPT_UNKNOWN_EXTENSION_URL = "http://hl7.org/fhir/3.0/StructureDefinition/extension-CapabilityStatement.acceptUnknown";

  private static final String[] IGNORED_EXTENSION_URLS = new String[]{
    ACCEPT_UNKNOWN_EXTENSION_URL
  };

  public static org.hl7.fhir.dstu3.model.CapabilityStatement convertCapabilityStatement(org.hl7.fhir.r4.model.CapabilityStatement src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.CapabilityStatement tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt, IGNORED_EXTENSION_URLS);
    if (src.hasUrl())
      tgt.setUrlElement(Uri30_40.convertUri(src.getUrlElement()));
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
    if (src.hasKind())
      tgt.setKindElement(convertCapabilityStatementKind(src.getKindElement()));
    for (org.hl7.fhir.r4.model.UriType t : src.getInstantiates()) tgt.addInstantiates(t.getValue());
    if (src.hasSoftware())
      tgt.setSoftware(convertCapabilityStatementSoftwareComponent(src.getSoftware()));
    if (src.hasImplementation())
      tgt.setImplementation(convertCapabilityStatementImplementationComponent(src.getImplementation()));
    if (src.hasFhirVersion())
      tgt.setFhirVersion(src.getFhirVersion().toCode());
    if (src.hasExtension(ACCEPT_UNKNOWN_EXTENSION_URL))
      tgt.setAcceptUnknown(org.hl7.fhir.dstu3.model.CapabilityStatement.UnknownContentCode.fromCode(src.getExtensionByUrl(ACCEPT_UNKNOWN_EXTENSION_URL).getValue().primitiveValue()));
    for (org.hl7.fhir.r4.model.CodeType t : src.getFormat()) tgt.addFormat(t.getValue());
    for (org.hl7.fhir.r4.model.CodeType t : src.getPatchFormat()) tgt.addPatchFormat(t.getValue());
    for (org.hl7.fhir.r4.model.UriType t : src.getImplementationGuide()) tgt.addImplementationGuide(t.getValue());
    for (org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestComponent r : src.getRest())
      for (org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceComponent rr : r.getResource())
        for (org.hl7.fhir.r4.model.CanonicalType t : rr.getSupportedProfile())
          tgt.addProfile(Reference30_40.convertCanonicalToReference(t));
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtension()) {
      if ("http://hl7.org/fhir/3.0/StructureDefinition/extension-CapabilityStatement.profile".equals(ext.getUrl())) {
        tgt.addProfile(Reference30_40.convertReference((org.hl7.fhir.r4.model.Reference) ext.getValue()));
      }
    }
    for (org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestComponent t : src.getRest())
      tgt.addRest(convertCapabilityStatementRestComponent(t));
    for (org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingComponent t : src.getMessaging())
      tgt.addMessaging(convertCapabilityStatementMessagingComponent(t));
    for (org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementDocumentComponent t : src.getDocument())
      tgt.addDocument(convertCapabilityStatementDocumentComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CapabilityStatement convertCapabilityStatement(org.hl7.fhir.dstu3.model.CapabilityStatement src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CapabilityStatement tgt = new org.hl7.fhir.r4.model.CapabilityStatement();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri30_40.convertUri(src.getUrlElement()));
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
    if (src.hasKind())
      tgt.setKindElement(convertCapabilityStatementKind(src.getKindElement()));
    for (org.hl7.fhir.dstu3.model.UriType t : src.getInstantiates()) tgt.addInstantiates(t.getValue());
    if (src.hasSoftware())
      tgt.setSoftware(convertCapabilityStatementSoftwareComponent(src.getSoftware()));
    if (src.hasImplementation())
      tgt.setImplementation(convertCapabilityStatementImplementationComponent(src.getImplementation()));
    if (src.hasFhirVersion())
      tgt.setFhirVersion(org.hl7.fhir.r4.model.Enumerations.FHIRVersion.fromCode(src.getFhirVersion()));
    if (src.hasAcceptUnknown())
      tgt.addExtension().setUrl(ACCEPT_UNKNOWN_EXTENSION_URL).setValue(new org.hl7.fhir.r4.model.CodeType(src.getAcceptUnknownElement().asStringValue()));
    for (org.hl7.fhir.dstu3.model.CodeType t : src.getFormat()) tgt.addFormat(t.getValue());
    for (org.hl7.fhir.dstu3.model.CodeType t : src.getPatchFormat()) tgt.addPatchFormat(t.getValue());
    for (org.hl7.fhir.dstu3.model.UriType t : src.getImplementationGuide()) tgt.addImplementationGuide(t.getValue());
    for (org.hl7.fhir.dstu3.model.Reference t : src.getProfile())
      tgt.addExtension("http://hl7.org/fhir/3.0/StructureDefinition/extension-CapabilityStatement.profile", Reference30_40.convertReference(t));
    for (org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestComponent t : src.getRest())
      tgt.addRest(convertCapabilityStatementRestComponent(t));
    for (org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingComponent t : src.getMessaging())
      tgt.addMessaging(convertCapabilityStatementMessagingComponent(t));
    for (org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementDocumentComponent t : src.getDocument())
      tgt.addDocument(convertCapabilityStatementDocumentComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementDocumentComponent convertCapabilityStatementDocumentComponent(org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementDocumentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementDocumentComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementDocumentComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasMode())
      tgt.setModeElement(convertDocumentMode(src.getModeElement()));
    if (src.hasDocumentation())
      tgt.setDocumentation(src.getDocumentation());
    if (src.hasProfile())
      tgt.setProfile(Reference30_40.convertCanonicalToReference(src.getProfileElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementDocumentComponent convertCapabilityStatementDocumentComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementDocumentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementDocumentComponent tgt = new org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementDocumentComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasMode())
      tgt.setModeElement(convertDocumentMode(src.getModeElement()));
    if (src.hasDocumentation())
      tgt.setDocumentation(src.getDocumentation());
    if (src.hasProfile())
      tgt.setProfileElement(Reference30_40.convertReferenceToCanonical(src.getProfile()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementImplementationComponent convertCapabilityStatementImplementationComponent(org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementImplementationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementImplementationComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementImplementationComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasDescription())
      tgt.setDescriptionElement(String30_40.convertString(src.getDescriptionElement()));
    if (src.hasUrl())
      tgt.setUrl(src.getUrl());
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementImplementationComponent convertCapabilityStatementImplementationComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementImplementationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementImplementationComponent tgt = new org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementImplementationComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasDescription())
      tgt.setDescriptionElement(String30_40.convertString(src.getDescriptionElement()));
    if (src.hasUrl())
      tgt.setUrl(src.getUrl());
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementKind> convertCapabilityStatementKind(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementKind> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementKind> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementKindEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case INSTANCE:
        tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementKind.INSTANCE);
        break;
      case CAPABILITY:
        tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementKind.CAPABILITY);
        break;
      case REQUIREMENTS:
        tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementKind.REQUIREMENTS);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementKind.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementKind> convertCapabilityStatementKind(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementKind> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementKind> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementKindEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case INSTANCE:
        tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementKind.INSTANCE);
        break;
      case CAPABILITY:
        tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementKind.CAPABILITY);
        break;
      case REQUIREMENTS:
        tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementKind.REQUIREMENTS);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementKind.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingComponent convertCapabilityStatementMessagingComponent(org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    for (org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent t : src.getEndpoint())
      tgt.addEndpoint(convertCapabilityStatementMessagingEndpointComponent(t));
    if (src.hasReliableCache())
      tgt.setReliableCacheElement(UnsignedInt30_40.convertUnsignedInt(src.getReliableCacheElement()));
    if (src.hasDocumentation())
      tgt.setDocumentation(src.getDocumentation());
    for (org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingSupportedMessageComponent t : src.getSupportedMessage())
      tgt.addSupportedMessage(convertCapabilityStatementMessagingSupportedMessageComponent(t));
    for (org.hl7.fhir.r4.model.Extension e : src.getExtensionsByUrl(VersionConvertorConstants.IG_CONFORMANCE_MESSAGE_EVENT)) {
      org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingEventComponent event = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingEventComponent();
      tgt.addEvent(event);
      event.setCode(Coding30_40.convertCoding((org.hl7.fhir.r4.model.Coding) e.getExtensionByUrl("code").getValue()));
      if (e.hasExtension("category"))
        event.setCategory(org.hl7.fhir.dstu3.model.CapabilityStatement.MessageSignificanceCategory.fromCode(e.getExtensionByUrl("category").getValue().toString()));
      event.setMode(org.hl7.fhir.dstu3.model.CapabilityStatement.EventCapabilityMode.fromCode(e.getExtensionByUrl("mode").getValue().toString()));
      event.setCode(Coding30_40.convertCoding((org.hl7.fhir.r4.model.Coding) e.getExtensionByUrl("code").getValue()));
      if (e.hasExtension("category"))
        event.setCategory(org.hl7.fhir.dstu3.model.CapabilityStatement.MessageSignificanceCategory.fromCode(e.getExtensionByUrl("category").getValue().toString()));
      event.setMode(org.hl7.fhir.dstu3.model.CapabilityStatement.EventCapabilityMode.fromCode(e.getExtensionByUrl("mode").getValue().toString()));
      org.hl7.fhir.r4.model.Extension focusE = e.getExtensionByUrl("focus");
      if (focusE.getValue().hasPrimitiveValue())
        event.setFocus(focusE.getValue().toString());
      else {
        event.setFocusElement(new org.hl7.fhir.dstu3.model.CodeType());
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(focusE.getValue(), event.getFocusElement());
      }
      event.setRequest(Reference30_40.convertReference((org.hl7.fhir.r4.model.Reference) e.getExtensionByUrl("request").getValue()));
      event.setResponse(Reference30_40.convertReference((org.hl7.fhir.r4.model.Reference) e.getExtensionByUrl("response").getValue()));
      if (e.hasExtension("documentation"))
        event.setDocumentation(e.getExtensionByUrl("documentation").getValue().toString());
    }
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingComponent convertCapabilityStatementMessagingComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingComponent tgt = new org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    for (org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent t : src.getEndpoint())
      tgt.addEndpoint(convertCapabilityStatementMessagingEndpointComponent(t));
    if (src.hasReliableCache())
      tgt.setReliableCacheElement(UnsignedInt30_40.convertUnsignedInt(src.getReliableCacheElement()));
    if (src.hasDocumentation())
      tgt.setDocumentation(src.getDocumentation());
    for (org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingSupportedMessageComponent t : src.getSupportedMessage())
      tgt.addSupportedMessage(convertCapabilityStatementMessagingSupportedMessageComponent(t));
    for (org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingEventComponent t : src.getEvent()) {
      org.hl7.fhir.r4.model.Extension e = new org.hl7.fhir.r4.model.Extension(VersionConvertorConstants.IG_CONFORMANCE_MESSAGE_EVENT);
      e.addExtension(new org.hl7.fhir.r4.model.Extension("code", Coding30_40.convertCoding(t.getCode())));
      if (t.hasCategory())
        e.addExtension(new org.hl7.fhir.r4.model.Extension("category", new org.hl7.fhir.r4.model.CodeType(t.getCategory().toCode())));
      e.addExtension(new org.hl7.fhir.r4.model.Extension("mode", new org.hl7.fhir.r4.model.CodeType(t.getMode().toCode())));
      if (t.getFocusElement().hasValue())
        e.addExtension(new org.hl7.fhir.r4.model.Extension("focus", new org.hl7.fhir.r4.model.StringType(t.getFocus())));
      else {
        org.hl7.fhir.r4.model.CodeType focus = new org.hl7.fhir.r4.model.CodeType();
        org.hl7.fhir.r4.model.Extension focusE = new org.hl7.fhir.r4.model.Extension("focus", focus);
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(t.getFocusElement(), focus);
        e.addExtension(focusE);
      }
      e.addExtension(new org.hl7.fhir.r4.model.Extension("request", Reference30_40.convertReference(t.getRequest())));
      e.addExtension(new org.hl7.fhir.r4.model.Extension("response", Reference30_40.convertReference(t.getResponse())));
      if (t.hasDocumentation())
        e.addExtension(new org.hl7.fhir.r4.model.Extension("documentation", new org.hl7.fhir.r4.model.StringType(t.getDocumentation())));
      tgt.addExtension(e);
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent convertCapabilityStatementMessagingEndpointComponent(org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasProtocol())
      tgt.setProtocol(Coding30_40.convertCoding(src.getProtocol()));
    if (src.hasAddress())
      tgt.setAddress(src.getAddress());
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent convertCapabilityStatementMessagingEndpointComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent tgt = new org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasProtocol())
      tgt.setProtocol(Coding30_40.convertCoding(src.getProtocol()));
    if (src.hasAddress())
      tgt.setAddress(src.getAddress());
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingSupportedMessageComponent convertCapabilityStatementMessagingSupportedMessageComponent(org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingSupportedMessageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingSupportedMessageComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingSupportedMessageComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasMode())
      tgt.setModeElement(convertEventCapabilityMode(src.getModeElement()));
    if (src.hasDefinition())
      tgt.setDefinition(Reference30_40.convertCanonicalToReference(src.getDefinitionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingSupportedMessageComponent convertCapabilityStatementMessagingSupportedMessageComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingSupportedMessageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingSupportedMessageComponent tgt = new org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingSupportedMessageComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasMode())
      tgt.setModeElement(convertEventCapabilityMode(src.getModeElement()));
    if (src.hasDefinition())
      tgt.setDefinitionElement(Reference30_40.convertReferenceToCanonical(src.getDefinition()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestComponent convertCapabilityStatementRestComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestComponent tgt = new org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasMode())
      tgt.setModeElement(convertRestfulCapabilityMode(src.getModeElement()));
    if (src.hasDocumentation())
      tgt.setDocumentation(src.getDocumentation());
    if (src.hasSecurity())
      tgt.setSecurity(convertCapabilityStatementRestSecurityComponent(src.getSecurity()));
    for (org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestResourceComponent t : src.getResource())
      tgt.addResource(convertCapabilityStatementRestResourceComponent(t));
    for (org.hl7.fhir.dstu3.model.CapabilityStatement.SystemInteractionComponent t : src.getInteraction())
      tgt.addInteraction(convertSystemInteractionComponent(t));
    for (org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent t : src.getSearchParam())
      tgt.addSearchParam(convertCapabilityStatementRestResourceSearchParamComponent(t));
    for (org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestOperationComponent t : src.getOperation())
      tgt.addOperation(convertCapabilityStatementRestOperationComponent(t));
    for (org.hl7.fhir.dstu3.model.UriType t : src.getCompartment()) tgt.addCompartment(t.getValue());
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestComponent convertCapabilityStatementRestComponent(org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasMode())
      tgt.setModeElement(convertRestfulCapabilityMode(src.getModeElement()));
    if (src.hasDocumentation())
      tgt.setDocumentation(src.getDocumentation());
    if (src.hasSecurity())
      tgt.setSecurity(convertCapabilityStatementRestSecurityComponent(src.getSecurity()));
    for (org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceComponent t : src.getResource())
      tgt.addResource(convertCapabilityStatementRestResourceComponent(t));
    for (org.hl7.fhir.r4.model.CapabilityStatement.SystemInteractionComponent t : src.getInteraction())
      tgt.addInteraction(convertSystemInteractionComponent(t));
    for (org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent t : src.getSearchParam())
      tgt.addSearchParam(convertCapabilityStatementRestResourceSearchParamComponent(t));
    for (org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceOperationComponent t : src.getOperation())
      tgt.addOperation(convertCapabilityStatementRestOperationComponent(t));
    for (org.hl7.fhir.r4.model.UriType t : src.getCompartment()) tgt.addCompartment(t.getValue());
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestOperationComponent convertCapabilityStatementRestOperationComponent(org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceOperationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestOperationComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestOperationComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasName())
      tgt.setNameElement(String30_40.convertString(src.getNameElement()));
    if (src.hasDefinition())
      tgt.setDefinition(Reference30_40.convertCanonicalToReference(src.getDefinitionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceOperationComponent convertCapabilityStatementRestOperationComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestOperationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceOperationComponent tgt = new org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceOperationComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasName())
      tgt.setNameElement(String30_40.convertString(src.getNameElement()));
    if (src.hasDefinition())
      tgt.setDefinitionElement(Reference30_40.convertReferenceToCanonical(src.getDefinition()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceComponent convertCapabilityStatementRestResourceComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestResourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceComponent tgt = new org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasType())
      tgt.setTypeElement(Code30_40.convertCode(src.getTypeElement()));
    if (src.hasProfile())
      tgt.setProfileElement(Reference30_40.convertReferenceToCanonical(src.getProfile()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(MarkDown30_40.convertMarkdown(src.getDocumentationElement()));
    for (org.hl7.fhir.dstu3.model.CapabilityStatement.ResourceInteractionComponent t : src.getInteraction())
      tgt.addInteraction(convertResourceInteractionComponent(t));
    if (src.hasVersioning())
      tgt.setVersioningElement(convertResourceVersionPolicy(src.getVersioningElement()));
    if (src.hasReadHistory())
      tgt.setReadHistoryElement(Boolean30_40.convertBoolean(src.getReadHistoryElement()));
    if (src.hasUpdateCreate())
      tgt.setUpdateCreateElement(Boolean30_40.convertBoolean(src.getUpdateCreateElement()));
    if (src.hasConditionalCreate())
      tgt.setConditionalCreateElement(Boolean30_40.convertBoolean(src.getConditionalCreateElement()));
    if (src.hasConditionalRead())
      tgt.setConditionalReadElement(convertConditionalReadStatus(src.getConditionalReadElement()));
    if (src.hasConditionalUpdate())
      tgt.setConditionalUpdateElement(Boolean30_40.convertBoolean(src.getConditionalUpdateElement()));
    if (src.hasConditionalDelete())
      tgt.setConditionalDeleteElement(convertConditionalDeleteStatus(src.getConditionalDeleteElement()));
    tgt.setReferencePolicy(src.getReferencePolicy().stream()
      .map(CapabilityStatement30_40::convertReferenceHandlingPolicy)
      .collect(Collectors.toList()));
    for (org.hl7.fhir.dstu3.model.StringType t : src.getSearchInclude()) tgt.addSearchInclude(t.getValue());
    for (org.hl7.fhir.dstu3.model.StringType t : src.getSearchRevInclude()) tgt.addSearchRevInclude(t.getValue());
    for (org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent t : src.getSearchParam())
      tgt.addSearchParam(convertCapabilityStatementRestResourceSearchParamComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestResourceComponent convertCapabilityStatementRestResourceComponent(org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestResourceComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestResourceComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasType())
      tgt.setTypeElement(Code30_40.convertCode(src.getTypeElement()));
    if (src.hasProfile())
      tgt.setProfile(Reference30_40.convertCanonicalToReference(src.getProfileElement()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(MarkDown30_40.convertMarkdown(src.getDocumentationElement()));
    for (org.hl7.fhir.r4.model.CapabilityStatement.ResourceInteractionComponent t : src.getInteraction())
      tgt.addInteraction(convertResourceInteractionComponent(t));
    if (src.hasVersioning())
      tgt.setVersioningElement(convertResourceVersionPolicy(src.getVersioningElement()));
    if (src.hasReadHistory())
      tgt.setReadHistoryElement(Boolean30_40.convertBoolean(src.getReadHistoryElement()));
    if (src.hasUpdateCreate())
      tgt.setUpdateCreateElement(Boolean30_40.convertBoolean(src.getUpdateCreateElement()));
    if (src.hasConditionalCreate())
      tgt.setConditionalCreateElement(Boolean30_40.convertBoolean(src.getConditionalCreateElement()));
    if (src.hasConditionalRead())
      tgt.setConditionalReadElement(convertConditionalReadStatus(src.getConditionalReadElement()));
    if (src.hasConditionalUpdate())
      tgt.setConditionalUpdateElement(Boolean30_40.convertBoolean(src.getConditionalUpdateElement()));
    if (src.hasConditionalDelete())
      tgt.setConditionalDeleteElement(convertConditionalDeleteStatus(src.getConditionalDeleteElement()));
    tgt.setReferencePolicy(src.getReferencePolicy().stream()
      .map(CapabilityStatement30_40::convertReferenceHandlingPolicy)
      .collect(Collectors.toList()));
    for (org.hl7.fhir.r4.model.StringType t : src.getSearchInclude()) tgt.addSearchInclude(t.getValue());
    for (org.hl7.fhir.r4.model.StringType t : src.getSearchRevInclude()) tgt.addSearchRevInclude(t.getValue());
    for (org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent t : src.getSearchParam())
      tgt.addSearchParam(convertCapabilityStatementRestResourceSearchParamComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent convertCapabilityStatementRestResourceSearchParamComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent tgt = new org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasName())
      tgt.setNameElement(String30_40.convertString(src.getNameElement()));
    if (src.hasDefinition())
      tgt.setDefinition(src.getDefinition());
    if (src.hasType())
      tgt.setTypeElement(Enumerations30_40.convertSearchParamType(src.getTypeElement()));
    if (src.hasDocumentation())
      tgt.setDocumentation(src.getDocumentation());
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent convertCapabilityStatementRestResourceSearchParamComponent(org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasName())
      tgt.setNameElement(String30_40.convertString(src.getNameElement()));
    if (src.hasDefinition())
      tgt.setDefinition(src.getDefinition());
    if (src.hasType())
      tgt.setTypeElement(Enumerations30_40.convertSearchParamType(src.getTypeElement()));
    if (src.hasDocumentation())
      tgt.setDocumentation(src.getDocumentation());
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestSecurityComponent convertCapabilityStatementRestSecurityComponent(org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestSecurityComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestSecurityComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestSecurityComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasCors())
      tgt.setCorsElement(Boolean30_40.convertBoolean(src.getCorsElement()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getService())
      tgt.addService(CodeableConcept30_40.convertCodeableConcept(t));
    if (src.hasDescription())
      tgt.setDescription(src.getDescription());
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestSecurityComponent convertCapabilityStatementRestSecurityComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestSecurityComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestSecurityComponent tgt = new org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestSecurityComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasCors())
      tgt.setCorsElement(Boolean30_40.convertBoolean(src.getCorsElement()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getService())
      tgt.addService(CodeableConcept30_40.convertCodeableConcept(t));
    if (src.hasDescription())
      tgt.setDescription(src.getDescription());
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementSoftwareComponent convertCapabilityStatementSoftwareComponent(org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementSoftwareComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementSoftwareComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementSoftwareComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasName())
      tgt.setNameElement(String30_40.convertString(src.getNameElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String30_40.convertString(src.getVersionElement()));
    if (src.hasReleaseDate())
      tgt.setReleaseDateElement(DateTime30_40.convertDateTime(src.getReleaseDateElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementSoftwareComponent convertCapabilityStatementSoftwareComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementSoftwareComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementSoftwareComponent tgt = new org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementSoftwareComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasName())
      tgt.setNameElement(String30_40.convertString(src.getNameElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String30_40.convertString(src.getVersionElement()));
    if (src.hasReleaseDate())
      tgt.setReleaseDateElement(DateTime30_40.convertDateTime(src.getReleaseDateElement()));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.ConditionalDeleteStatus> convertConditionalDeleteStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.ConditionalDeleteStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.ConditionalDeleteStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.CapabilityStatement.ConditionalDeleteStatusEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case NOTSUPPORTED:
        tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.ConditionalDeleteStatus.NOTSUPPORTED);
        break;
      case SINGLE:
        tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.ConditionalDeleteStatus.SINGLE);
        break;
      case MULTIPLE:
        tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.ConditionalDeleteStatus.MULTIPLE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.ConditionalDeleteStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.ConditionalDeleteStatus> convertConditionalDeleteStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.ConditionalDeleteStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.ConditionalDeleteStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.CapabilityStatement.ConditionalDeleteStatusEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case NOTSUPPORTED:
        tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.ConditionalDeleteStatus.NOTSUPPORTED);
        break;
      case SINGLE:
        tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.ConditionalDeleteStatus.SINGLE);
        break;
      case MULTIPLE:
        tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.ConditionalDeleteStatus.MULTIPLE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.ConditionalDeleteStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.ConditionalReadStatus> convertConditionalReadStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.ConditionalReadStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.ConditionalReadStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.CapabilityStatement.ConditionalReadStatusEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case NOTSUPPORTED:
        tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.ConditionalReadStatus.NOTSUPPORTED);
        break;
      case MODIFIEDSINCE:
        tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.ConditionalReadStatus.MODIFIEDSINCE);
        break;
      case NOTMATCH:
        tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.ConditionalReadStatus.NOTMATCH);
        break;
      case FULLSUPPORT:
        tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.ConditionalReadStatus.FULLSUPPORT);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.ConditionalReadStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.ConditionalReadStatus> convertConditionalReadStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.ConditionalReadStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.ConditionalReadStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.CapabilityStatement.ConditionalReadStatusEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case NOTSUPPORTED:
        tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.ConditionalReadStatus.NOTSUPPORTED);
        break;
      case MODIFIEDSINCE:
        tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.ConditionalReadStatus.MODIFIEDSINCE);
        break;
      case NOTMATCH:
        tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.ConditionalReadStatus.NOTMATCH);
        break;
      case FULLSUPPORT:
        tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.ConditionalReadStatus.FULLSUPPORT);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.ConditionalReadStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.DocumentMode> convertDocumentMode(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.DocumentMode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.DocumentMode> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.CapabilityStatement.DocumentModeEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case PRODUCER:
        tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.DocumentMode.PRODUCER);
        break;
      case CONSUMER:
        tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.DocumentMode.CONSUMER);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.DocumentMode.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.DocumentMode> convertDocumentMode(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.DocumentMode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.DocumentMode> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.CapabilityStatement.DocumentModeEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case PRODUCER:
        tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.DocumentMode.PRODUCER);
        break;
      case CONSUMER:
        tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.DocumentMode.CONSUMER);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.DocumentMode.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.EventCapabilityMode> convertEventCapabilityMode(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.EventCapabilityMode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.EventCapabilityMode> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.CapabilityStatement.EventCapabilityModeEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case SENDER:
        tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.EventCapabilityMode.SENDER);
        break;
      case RECEIVER:
        tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.EventCapabilityMode.RECEIVER);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.EventCapabilityMode.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.EventCapabilityMode> convertEventCapabilityMode(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.EventCapabilityMode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.EventCapabilityMode> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.CapabilityStatement.EventCapabilityModeEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case SENDER:
        tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.EventCapabilityMode.SENDER);
        break;
      case RECEIVER:
        tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.EventCapabilityMode.RECEIVER);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.EventCapabilityMode.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.ReferenceHandlingPolicy> convertReferenceHandlingPolicy(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.ReferenceHandlingPolicy> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.ReferenceHandlingPolicy> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.CapabilityStatement.ReferenceHandlingPolicyEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case LITERAL:
        tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.ReferenceHandlingPolicy.LITERAL);
        break;
      case LOGICAL:
        tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.ReferenceHandlingPolicy.LOGICAL);
        break;
      case RESOLVES:
        tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.ReferenceHandlingPolicy.RESOLVES);
        break;
      case ENFORCED:
        tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.ReferenceHandlingPolicy.ENFORCED);
        break;
      case LOCAL:
        tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.ReferenceHandlingPolicy.LOCAL);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.ReferenceHandlingPolicy.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.ReferenceHandlingPolicy> convertReferenceHandlingPolicy(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.ReferenceHandlingPolicy> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.ReferenceHandlingPolicy> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.CapabilityStatement.ReferenceHandlingPolicyEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case LITERAL:
        tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.ReferenceHandlingPolicy.LITERAL);
        break;
      case LOGICAL:
        tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.ReferenceHandlingPolicy.LOGICAL);
        break;
      case RESOLVES:
        tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.ReferenceHandlingPolicy.RESOLVES);
        break;
      case ENFORCED:
        tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.ReferenceHandlingPolicy.ENFORCED);
        break;
      case LOCAL:
        tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.ReferenceHandlingPolicy.LOCAL);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.ReferenceHandlingPolicy.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.CapabilityStatement.ResourceInteractionComponent convertResourceInteractionComponent(org.hl7.fhir.r4.model.CapabilityStatement.ResourceInteractionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.CapabilityStatement.ResourceInteractionComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.ResourceInteractionComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasCode())
      tgt.setCodeElement(convertTypeRestfulInteraction(src.getCodeElement()));
    if (src.hasDocumentation())
      tgt.setDocumentation(src.getDocumentation());
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CapabilityStatement.ResourceInteractionComponent convertResourceInteractionComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.ResourceInteractionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CapabilityStatement.ResourceInteractionComponent tgt = new org.hl7.fhir.r4.model.CapabilityStatement.ResourceInteractionComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasCode())
      tgt.setCodeElement(convertTypeRestfulInteraction(src.getCodeElement()));
    if (src.hasDocumentation())
      tgt.setDocumentation(src.getDocumentation());
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.ResourceVersionPolicy> convertResourceVersionPolicy(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.ResourceVersionPolicy> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.ResourceVersionPolicy> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.CapabilityStatement.ResourceVersionPolicyEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case NOVERSION:
        tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.ResourceVersionPolicy.NOVERSION);
        break;
      case VERSIONED:
        tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.ResourceVersionPolicy.VERSIONED);
        break;
      case VERSIONEDUPDATE:
        tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.ResourceVersionPolicy.VERSIONEDUPDATE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.ResourceVersionPolicy.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.ResourceVersionPolicy> convertResourceVersionPolicy(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.ResourceVersionPolicy> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.ResourceVersionPolicy> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.CapabilityStatement.ResourceVersionPolicyEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case NOVERSION:
        tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.ResourceVersionPolicy.NOVERSION);
        break;
      case VERSIONED:
        tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.ResourceVersionPolicy.VERSIONED);
        break;
      case VERSIONEDUPDATE:
        tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.ResourceVersionPolicy.VERSIONEDUPDATE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.ResourceVersionPolicy.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.RestfulCapabilityMode> convertRestfulCapabilityMode(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.RestfulCapabilityMode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.RestfulCapabilityMode> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.CapabilityStatement.RestfulCapabilityModeEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case CLIENT:
        tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.RestfulCapabilityMode.CLIENT);
        break;
      case SERVER:
        tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.RestfulCapabilityMode.SERVER);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.RestfulCapabilityMode.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.RestfulCapabilityMode> convertRestfulCapabilityMode(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.RestfulCapabilityMode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.RestfulCapabilityMode> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.CapabilityStatement.RestfulCapabilityModeEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case CLIENT:
        tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.RestfulCapabilityMode.CLIENT);
        break;
      case SERVER:
        tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.RestfulCapabilityMode.SERVER);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.RestfulCapabilityMode.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.CapabilityStatement.SystemInteractionComponent convertSystemInteractionComponent(org.hl7.fhir.r4.model.CapabilityStatement.SystemInteractionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.CapabilityStatement.SystemInteractionComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.SystemInteractionComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasCode())
      tgt.setCodeElement(convertSystemRestfulInteraction(src.getCodeElement()));
    if (src.hasDocumentation())
      tgt.setDocumentation(src.getDocumentation());
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CapabilityStatement.SystemInteractionComponent convertSystemInteractionComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.SystemInteractionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CapabilityStatement.SystemInteractionComponent tgt = new org.hl7.fhir.r4.model.CapabilityStatement.SystemInteractionComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasCode())
      tgt.setCodeElement(convertSystemRestfulInteraction(src.getCodeElement()));
    if (src.hasDocumentation())
      tgt.setDocumentation(src.getDocumentation());
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.SystemRestfulInteraction> convertSystemRestfulInteraction(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.SystemRestfulInteraction> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.SystemRestfulInteraction> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.CapabilityStatement.SystemRestfulInteractionEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case TRANSACTION:
        tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.SystemRestfulInteraction.TRANSACTION);
        break;
      case BATCH:
        tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.SystemRestfulInteraction.BATCH);
        break;
      case SEARCHSYSTEM:
        tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.SystemRestfulInteraction.SEARCHSYSTEM);
        break;
      case HISTORYSYSTEM:
        tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.SystemRestfulInteraction.HISTORYSYSTEM);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.SystemRestfulInteraction.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.SystemRestfulInteraction> convertSystemRestfulInteraction(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.SystemRestfulInteraction> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.SystemRestfulInteraction> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.CapabilityStatement.SystemRestfulInteractionEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case TRANSACTION:
        tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.SystemRestfulInteraction.TRANSACTION);
        break;
      case BATCH:
        tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.SystemRestfulInteraction.BATCH);
        break;
      case SEARCHSYSTEM:
        tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.SystemRestfulInteraction.SEARCHSYSTEM);
        break;
      case HISTORYSYSTEM:
        tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.SystemRestfulInteraction.HISTORYSYSTEM);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.SystemRestfulInteraction.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.TypeRestfulInteraction> convertTypeRestfulInteraction(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.TypeRestfulInteraction> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.TypeRestfulInteraction> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.CapabilityStatement.TypeRestfulInteractionEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case READ:
        tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.TypeRestfulInteraction.READ);
        break;
      case VREAD:
        tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.TypeRestfulInteraction.VREAD);
        break;
      case UPDATE:
        tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.TypeRestfulInteraction.UPDATE);
        break;
      case PATCH:
        tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.TypeRestfulInteraction.PATCH);
        break;
      case DELETE:
        tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.TypeRestfulInteraction.DELETE);
        break;
      case HISTORYINSTANCE:
        tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.TypeRestfulInteraction.HISTORYINSTANCE);
        break;
      case HISTORYTYPE:
        tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.TypeRestfulInteraction.HISTORYTYPE);
        break;
      case CREATE:
        tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.TypeRestfulInteraction.CREATE);
        break;
      case SEARCHTYPE:
        tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.TypeRestfulInteraction.SEARCHTYPE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.TypeRestfulInteraction.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.TypeRestfulInteraction> convertTypeRestfulInteraction(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.TypeRestfulInteraction> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.TypeRestfulInteraction> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.CapabilityStatement.TypeRestfulInteractionEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case READ:
        tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.TypeRestfulInteraction.READ);
        break;
      case VREAD:
        tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.TypeRestfulInteraction.VREAD);
        break;
      case UPDATE:
        tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.TypeRestfulInteraction.UPDATE);
        break;
      case PATCH:
        tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.TypeRestfulInteraction.PATCH);
        break;
      case DELETE:
        tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.TypeRestfulInteraction.DELETE);
        break;
      case HISTORYINSTANCE:
        tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.TypeRestfulInteraction.HISTORYINSTANCE);
        break;
      case HISTORYTYPE:
        tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.TypeRestfulInteraction.HISTORYTYPE);
        break;
      case CREATE:
        tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.TypeRestfulInteraction.CREATE);
        break;
      case SEARCHTYPE:
        tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.TypeRestfulInteraction.SEARCHTYPE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.TypeRestfulInteraction.NULL);
        break;
    }
    return tgt;
  }
}