package org.hl7.fhir.convertors.conv14_30.resources14_30;

import org.hl7.fhir.convertors.context.ConversionContext14_30;
import org.hl7.fhir.convertors.conv14_30.VersionConvertor_14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.Reference14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.complextypes14_30.CodeableConcept14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.complextypes14_30.ContactPoint14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30.*;
import org.hl7.fhir.exceptions.FHIRException;

public class ImplementationGuide14_30 {

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ImplementationGuide.GuideDependencyType> convertGuideDependencyType(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.ImplementationGuide.GuideDependencyType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ImplementationGuide.GuideDependencyType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.ImplementationGuide.GuideDependencyTypeEnumFactory());
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    switch (src.getValue()) {
      case REFERENCE:
        tgt.setValue(org.hl7.fhir.dstu3.model.ImplementationGuide.GuideDependencyType.REFERENCE);
        break;
      case INCLUSION:
        tgt.setValue(org.hl7.fhir.dstu3.model.ImplementationGuide.GuideDependencyType.INCLUSION);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.ImplementationGuide.GuideDependencyType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.ImplementationGuide.GuideDependencyType> convertGuideDependencyType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ImplementationGuide.GuideDependencyType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.ImplementationGuide.GuideDependencyType> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.ImplementationGuide.GuideDependencyTypeEnumFactory());
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    switch (src.getValue()) {
      case REFERENCE:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.ImplementationGuide.GuideDependencyType.REFERENCE);
        break;
      case INCLUSION:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.ImplementationGuide.GuideDependencyType.INCLUSION);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.ImplementationGuide.GuideDependencyType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ImplementationGuide.GuidePageKind> convertGuidePageKind(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.ImplementationGuide.GuidePageKind> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ImplementationGuide.GuidePageKind> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.ImplementationGuide.GuidePageKindEnumFactory());
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    switch (src.getValue()) {
      case PAGE:
        tgt.setValue(org.hl7.fhir.dstu3.model.ImplementationGuide.GuidePageKind.PAGE);
        break;
      case EXAMPLE:
        tgt.setValue(org.hl7.fhir.dstu3.model.ImplementationGuide.GuidePageKind.EXAMPLE);
        break;
      case LIST:
        tgt.setValue(org.hl7.fhir.dstu3.model.ImplementationGuide.GuidePageKind.LIST);
        break;
      case INCLUDE:
        tgt.setValue(org.hl7.fhir.dstu3.model.ImplementationGuide.GuidePageKind.INCLUDE);
        break;
      case DIRECTORY:
        tgt.setValue(org.hl7.fhir.dstu3.model.ImplementationGuide.GuidePageKind.DIRECTORY);
        break;
      case DICTIONARY:
        tgt.setValue(org.hl7.fhir.dstu3.model.ImplementationGuide.GuidePageKind.DICTIONARY);
        break;
      case TOC:
        tgt.setValue(org.hl7.fhir.dstu3.model.ImplementationGuide.GuidePageKind.TOC);
        break;
      case RESOURCE:
        tgt.setValue(org.hl7.fhir.dstu3.model.ImplementationGuide.GuidePageKind.RESOURCE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.ImplementationGuide.GuidePageKind.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.ImplementationGuide.GuidePageKind> convertGuidePageKind(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ImplementationGuide.GuidePageKind> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.ImplementationGuide.GuidePageKind> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.ImplementationGuide.GuidePageKindEnumFactory());
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    switch (src.getValue()) {
      case PAGE:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.ImplementationGuide.GuidePageKind.PAGE);
        break;
      case EXAMPLE:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.ImplementationGuide.GuidePageKind.EXAMPLE);
        break;
      case LIST:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.ImplementationGuide.GuidePageKind.LIST);
        break;
      case INCLUDE:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.ImplementationGuide.GuidePageKind.INCLUDE);
        break;
      case DIRECTORY:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.ImplementationGuide.GuidePageKind.DIRECTORY);
        break;
      case DICTIONARY:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.ImplementationGuide.GuidePageKind.DICTIONARY);
        break;
      case TOC:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.ImplementationGuide.GuidePageKind.TOC);
        break;
      case RESOURCE:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.ImplementationGuide.GuidePageKind.RESOURCE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.ImplementationGuide.GuidePageKind.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.ImplementationGuide convertImplementationGuide(org.hl7.fhir.dstu3.model.ImplementationGuide src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.ImplementationGuide tgt = new org.hl7.fhir.dstu2016may.model.ImplementationGuide();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyDomainResource(src, tgt);
    if (src.hasUrlElement())
      tgt.setUrlElement(Uri14_30.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String14_30.convertString(src.getVersionElement()));
    if (src.hasNameElement())
      tgt.setNameElement(String14_30.convertString(src.getNameElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations14_30.convertConformanceResourceStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean14_30.convertBoolean(src.getExperimentalElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String14_30.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact())
      tgt.addContact(convertImplementationGuideContactComponent(t));
    if (src.hasDate())
      tgt.setDateElement(DateTime14_30.convertDateTime(src.getDateElement()));
    if (src.hasDescription())
      tgt.setDescription(src.getDescription());
    for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext())
      if (t.hasValueCodeableConcept())
        tgt.addUseContext(CodeableConcept14_30.convertCodeableConcept(t.getValueCodeableConcept()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction())
      tgt.addUseContext(CodeableConcept14_30.convertCodeableConcept(t));
    if (src.hasCopyright())
      tgt.setCopyright(src.getCopyright());
    if (src.hasFhirVersion())
      tgt.setFhirVersionElement(Id14_30.convertId(src.getFhirVersionElement()));
    for (org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideDependencyComponent t : src.getDependency())
      tgt.addDependency(convertImplementationGuideDependencyComponent(t));
    for (org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageComponent t : src.getPackage())
      tgt.addPackage(convertImplementationGuidePackageComponent(t));
    for (org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideGlobalComponent t : src.getGlobal())
      tgt.addGlobal(convertImplementationGuideGlobalComponent(t));
    for (org.hl7.fhir.dstu3.model.UriType t : src.getBinary()) tgt.addBinary(t.getValue());
    if (src.hasPage())
      tgt.setPage(convertImplementationGuidePageComponent(src.getPage()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.ImplementationGuide convertImplementationGuide(org.hl7.fhir.dstu2016may.model.ImplementationGuide src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.ImplementationGuide tgt = new org.hl7.fhir.dstu3.model.ImplementationGuide();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyDomainResource(src, tgt);
    if (src.hasUrlElement())
      tgt.setUrlElement(Uri14_30.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String14_30.convertString(src.getVersionElement()));
    if (src.hasNameElement())
      tgt.setNameElement(String14_30.convertString(src.getNameElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations14_30.convertConformanceResourceStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean14_30.convertBoolean(src.getExperimentalElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String14_30.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideContactComponent t : src.getContact())
      tgt.addContact(convertImplementationGuideContactComponent(t));
    if (src.hasDate())
      tgt.setDateElement(DateTime14_30.convertDateTime(src.getDateElement()));
    if (src.hasDescription())
      tgt.setDescription(src.getDescription());
    for (org.hl7.fhir.dstu2016may.model.CodeableConcept t : src.getUseContext())
      if (VersionConvertor_14_30.isJurisdiction(t))
        tgt.addJurisdiction(CodeableConcept14_30.convertCodeableConcept(t));
      else
        tgt.addUseContext(CodeableConcept14_30.convertCodeableConceptToUsageContext(t));
    if (src.hasCopyright())
      tgt.setCopyright(src.getCopyright());
    if (src.hasFhirVersion())
      tgt.setFhirVersionElement(Id14_30.convertId(src.getFhirVersionElement()));
    for (org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideDependencyComponent t : src.getDependency())
      tgt.addDependency(convertImplementationGuideDependencyComponent(t));
    for (org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePackageComponent t : src.getPackage())
      tgt.addPackage(convertImplementationGuidePackageComponent(t));
    for (org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideGlobalComponent t : src.getGlobal())
      tgt.addGlobal(convertImplementationGuideGlobalComponent(t));
    for (org.hl7.fhir.dstu2016may.model.UriType t : src.getBinary()) tgt.addBinary(t.getValue());
    if (src.hasPage())
      tgt.setPage(convertImplementationGuidePageComponent(src.getPage()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideContactComponent convertImplementationGuideContactComponent(org.hl7.fhir.dstu3.model.ContactDetail src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideContactComponent tgt = new org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideContactComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String14_30.convertString(src.getNameElement()));
    for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint14_30.convertContactPoint(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.ContactDetail convertImplementationGuideContactComponent(org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideContactComponent src) throws FHIRException {
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

  public static org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideDependencyComponent convertImplementationGuideDependencyComponent(org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideDependencyComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideDependencyComponent tgt = new org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideDependencyComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(convertGuideDependencyType(src.getTypeElement()));
    if (src.hasUriElement())
      tgt.setUriElement(Uri14_30.convertUri(src.getUriElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideDependencyComponent convertImplementationGuideDependencyComponent(org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideDependencyComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideDependencyComponent tgt = new org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideDependencyComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(convertGuideDependencyType(src.getTypeElement()));
    if (src.hasUriElement())
      tgt.setUriElement(Uri14_30.convertUri(src.getUriElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideGlobalComponent convertImplementationGuideGlobalComponent(org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideGlobalComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideGlobalComponent tgt = new org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideGlobalComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasTypeElement())
      tgt.setTypeElement(Code14_30.convertCode(src.getTypeElement()));
    if (src.hasProfile())
      tgt.setProfile(Reference14_30.convertReference(src.getProfile()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideGlobalComponent convertImplementationGuideGlobalComponent(org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideGlobalComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideGlobalComponent tgt = new org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideGlobalComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasTypeElement())
      tgt.setTypeElement(Code14_30.convertCode(src.getTypeElement()));
    if (src.hasProfile())
      tgt.setProfile(Reference14_30.convertReference(src.getProfile()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePackageComponent convertImplementationGuidePackageComponent(org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePackageComponent tgt = new org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePackageComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasNameElement())
      tgt.setNameElement(String14_30.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String14_30.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageResourceComponent t : src.getResource())
      tgt.addResource(convertImplementationGuidePackageResourceComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageComponent convertImplementationGuidePackageComponent(org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePackageComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageComponent tgt = new org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasNameElement())
      tgt.setNameElement(String14_30.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String14_30.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePackageResourceComponent t : src.getResource())
      tgt.addResource(convertImplementationGuidePackageResourceComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePackageResourceComponent convertImplementationGuidePackageResourceComponent(org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageResourceComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePackageResourceComponent tgt = new org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePackageResourceComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasExampleElement())
      tgt.setExampleElement(Boolean14_30.convertBoolean(src.getExampleElement()));
    if (src.hasName())
      tgt.setNameElement(String14_30.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String14_30.convertString(src.getDescriptionElement()));
    if (src.hasAcronym())
      tgt.setAcronymElement(String14_30.convertString(src.getAcronymElement()));
    if (src.hasSource())
      tgt.setSource(ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().convertType(src.getSource()));
    if (src.hasExampleFor())
      tgt.setExampleFor(Reference14_30.convertReference(src.getExampleFor()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageResourceComponent convertImplementationGuidePackageResourceComponent(org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePackageResourceComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageResourceComponent tgt = new org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageResourceComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasExampleElement())
      tgt.setExampleElement(Boolean14_30.convertBoolean(src.getExampleElement()));
    if (src.hasName())
      tgt.setNameElement(String14_30.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String14_30.convertString(src.getDescriptionElement()));
    if (src.hasAcronym())
      tgt.setAcronymElement(String14_30.convertString(src.getAcronymElement()));
    if (src.hasSource())
      tgt.setSource(ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().convertType(src.getSource()));
    if (src.hasExampleFor())
      tgt.setExampleFor(Reference14_30.convertReference(src.getExampleFor()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePageComponent convertImplementationGuidePageComponent(org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePageComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePageComponent tgt = new org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePageComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasSourceElement())
      tgt.setSourceElement(Uri14_30.convertUri(src.getSourceElement()));
    if (src.hasNameElement())
      tgt.setTitleElement(String14_30.convertString(src.getNameElement()));
    if (src.hasKind())
      tgt.setKindElement(convertGuidePageKind(src.getKindElement()));
    for (org.hl7.fhir.dstu2016may.model.CodeType t : src.getType()) tgt.addType(t.getValue());
    for (org.hl7.fhir.dstu2016may.model.StringType t : src.getPackage()) tgt.addPackage(t.getValue());
    if (src.hasFormat())
      tgt.setFormatElement(Code14_30.convertCode(src.getFormatElement()));
    for (org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePageComponent t : src.getPage())
      tgt.addPage(convertImplementationGuidePageComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePageComponent convertImplementationGuidePageComponent(org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePageComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePageComponent tgt = new org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePageComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasSourceElement())
      tgt.setSourceElement(Uri14_30.convertUri(src.getSourceElement()));
    if (src.hasTitleElement())
      tgt.setNameElement(String14_30.convertString(src.getTitleElement()));
    if (src.hasKind())
      tgt.setKindElement(convertGuidePageKind(src.getKindElement()));
    for (org.hl7.fhir.dstu3.model.CodeType t : src.getType()) tgt.addType(t.getValue());
    for (org.hl7.fhir.dstu3.model.StringType t : src.getPackage()) tgt.addPackage(t.getValue());
    if (src.hasFormat())
      tgt.setFormatElement(Code14_30.convertCode(src.getFormatElement()));
    for (org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePageComponent t : src.getPage())
      tgt.addPage(convertImplementationGuidePageComponent(t));
    return tgt;
  }
}