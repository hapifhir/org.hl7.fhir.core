package org.hl7.fhir.convertors.conv14_30.resources14_30;

import org.hl7.fhir.convertors.context.ConversionContext14_30;
import org.hl7.fhir.convertors.conv14_30.VersionConvertor_14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.ElementDefinition14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.complextypes14_30.CodeableConcept14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.complextypes14_30.ContactPoint14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.complextypes14_30.Identifier14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30.*;
import org.hl7.fhir.dstu2016may.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.exceptions.FHIRException;

public class StructureDefinition14_30 {

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.StructureDefinition.ExtensionContext> convertExtensionContext(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.StructureDefinition.ExtensionContext> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.StructureDefinition.ExtensionContext> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.StructureDefinition.ExtensionContextEnumFactory());
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    switch (src.getValue()) {
      case RESOURCE:
        tgt.setValue(org.hl7.fhir.dstu3.model.StructureDefinition.ExtensionContext.RESOURCE);
        break;
      case DATATYPE:
        tgt.setValue(org.hl7.fhir.dstu3.model.StructureDefinition.ExtensionContext.DATATYPE);
        break;
      case EXTENSION:
        tgt.setValue(org.hl7.fhir.dstu3.model.StructureDefinition.ExtensionContext.EXTENSION);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.StructureDefinition.ExtensionContext.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.StructureDefinition.ExtensionContext> convertExtensionContext(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.StructureDefinition.ExtensionContext> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.StructureDefinition.ExtensionContext> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.StructureDefinition.ExtensionContextEnumFactory());
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    switch (src.getValue()) {
      case RESOURCE:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.StructureDefinition.ExtensionContext.RESOURCE);
        break;
      case DATATYPE:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.StructureDefinition.ExtensionContext.DATATYPE);
        break;
      case EXTENSION:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.StructureDefinition.ExtensionContext.EXTENSION);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.StructureDefinition.ExtensionContext.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.StructureDefinition convertStructureDefinition(org.hl7.fhir.dstu3.model.StructureDefinition src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.StructureDefinition tgt = new org.hl7.fhir.dstu2016may.model.StructureDefinition();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri14_30.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier14_30.convertIdentifier(t));
    if (src.hasVersion())
      tgt.setVersionElement(String14_30.convertString(src.getVersionElement()));
    if (src.hasNameElement())
      tgt.setNameElement(String14_30.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setDisplayElement(String14_30.convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations14_30.convertConformanceResourceStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean14_30.convertBoolean(src.getExperimentalElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String14_30.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact())
      tgt.addContact(convertStructureDefinitionContactComponent(t));
    if (src.hasDate())
      tgt.setDateElement(DateTime14_30.convertDateTime(src.getDateElement()));
    if (src.hasDescription())
      tgt.setDescription(src.getDescription());
    for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext())
      if (t.hasValueCodeableConcept())
        tgt.addUseContext(CodeableConcept14_30.convertCodeableConcept(t.getValueCodeableConcept()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction())
      tgt.addUseContext(CodeableConcept14_30.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setRequirements(src.getPurpose());
    if (src.hasCopyright())
      tgt.setCopyright(src.getCopyright());
    for (org.hl7.fhir.dstu3.model.Coding t : src.getKeyword()) tgt.addCode(Code14_30.convertCoding(t));
    if (src.hasFhirVersion())
      tgt.setFhirVersionElement(Id14_30.convertId(src.getFhirVersionElement()));
    for (org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionMappingComponent t : src.getMapping())
      tgt.addMapping(convertStructureDefinitionMappingComponent(t));
    if (src.hasKind())
      tgt.setKindElement(convertStructureDefinitionKind(src.getKindElement()));
    if (src.hasAbstractElement())
      tgt.setAbstractElement(Boolean14_30.convertBoolean(src.getAbstractElement()));
    if (src.hasContextType())
      tgt.setContextTypeElement(convertExtensionContext(src.getContextTypeElement()));
    for (org.hl7.fhir.dstu3.model.StringType t : src.getContext()) tgt.addContext(t.getValue());
    if (src.hasBaseDefinition())
      tgt.setBaseDefinitionElement(Uri14_30.convertUri(src.getBaseDefinitionElement()));
    if (src.hasType() && src.getDerivation() == org.hl7.fhir.dstu3.model.StructureDefinition.TypeDerivationRule.CONSTRAINT)
      tgt.setBaseTypeElement(Code14_30.convertCode(src.getTypeElement()));
    if (src.hasDerivation())
      tgt.setDerivationElement(convertTypeDerivationRule(src.getDerivationElement()));
    if (src.hasSnapshot())
      tgt.setSnapshot(convertStructureDefinitionSnapshotComponent(src.getSnapshot()));
    if (src.hasDifferential())
      tgt.setDifferential(convertStructureDefinitionDifferentialComponent(src.getDifferential()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.StructureDefinition convertStructureDefinition(org.hl7.fhir.dstu2016may.model.StructureDefinition src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.StructureDefinition tgt = new org.hl7.fhir.dstu3.model.StructureDefinition();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri14_30.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.dstu2016may.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier14_30.convertIdentifier(t));
    if (src.hasVersion())
      tgt.setVersionElement(String14_30.convertString(src.getVersionElement()));
    if (src.hasNameElement())
      tgt.setNameElement(String14_30.convertString(src.getNameElement()));
    if (src.hasDisplay())
      tgt.setTitleElement(String14_30.convertString(src.getDisplayElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations14_30.convertConformanceResourceStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean14_30.convertBoolean(src.getExperimentalElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String14_30.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionContactComponent t : src.getContact())
      tgt.addContact(convertStructureDefinitionContactComponent(t));
    if (src.hasDate())
      tgt.setDateElement(DateTime14_30.convertDateTime(src.getDateElement()));
    if (src.hasDescription())
      tgt.setDescription(src.getDescription());
    for (org.hl7.fhir.dstu2016may.model.CodeableConcept t : src.getUseContext())
      if (VersionConvertor_14_30.isJurisdiction(t))
        tgt.addJurisdiction(CodeableConcept14_30.convertCodeableConcept(t));
      else
        tgt.addUseContext(CodeableConcept14_30.convertCodeableConceptToUsageContext(t));
    if (src.hasRequirements())
      tgt.setPurpose(src.getRequirements());
    if (src.hasCopyright())
      tgt.setCopyright(src.getCopyright());
    for (org.hl7.fhir.dstu2016may.model.Coding t : src.getCode()) tgt.addKeyword(Code14_30.convertCoding(t));
    if (src.hasFhirVersion())
      tgt.setFhirVersionElement(Id14_30.convertId(src.getFhirVersionElement()));
    for (org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionMappingComponent t : src.getMapping())
      tgt.addMapping(convertStructureDefinitionMappingComponent(t));
    if (src.hasKind())
      tgt.setKindElement(convertStructureDefinitionKind(src.getKindElement()));
    if (src.hasAbstractElement())
      tgt.setAbstractElement(Boolean14_30.convertBoolean(src.getAbstractElement()));
    if (src.hasContextType())
      tgt.setContextTypeElement(convertExtensionContext(src.getContextTypeElement()));
    for (org.hl7.fhir.dstu2016may.model.StringType t : src.getContext()) tgt.addContext(t.getValue());
    if (src.getDerivation() == TypeDerivationRule.CONSTRAINT)
      tgt.setTypeElement(Code14_30.convertCode(src.getBaseTypeElement()));
    else
      tgt.setType(src.getId());
    if (src.hasBaseDefinition())
      tgt.setBaseDefinitionElement(Uri14_30.convertUri(src.getBaseDefinitionElement()));
    if (src.hasDerivation())
      tgt.setDerivationElement(convertTypeDerivationRule(src.getDerivationElement()));
    if (src.hasSnapshot()) {
      if (src.hasSnapshot())
        tgt.setSnapshot(convertStructureDefinitionSnapshotComponent(src.getSnapshot()));
      tgt.getSnapshot().getElementFirstRep().getType().clear();
    }
    if (src.hasDifferential()) {
      if (src.hasDifferential())
        tgt.setDifferential(convertStructureDefinitionDifferentialComponent(src.getDifferential()));
      tgt.getDifferential().getElementFirstRep().getType().clear();
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionContactComponent convertStructureDefinitionContactComponent(org.hl7.fhir.dstu3.model.ContactDetail src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionContactComponent tgt = new org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionContactComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String14_30.convertString(src.getNameElement()));
    for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint14_30.convertContactPoint(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.ContactDetail convertStructureDefinitionContactComponent(org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionContactComponent src) throws FHIRException {
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

  public static org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionDifferentialComponent convertStructureDefinitionDifferentialComponent(org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionDifferentialComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionDifferentialComponent tgt = new org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionDifferentialComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    for (org.hl7.fhir.dstu3.model.ElementDefinition t : src.getElement())
      tgt.addElement(ElementDefinition14_30.convertElementDefinition(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionDifferentialComponent convertStructureDefinitionDifferentialComponent(org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionDifferentialComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionDifferentialComponent tgt = new org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionDifferentialComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    for (org.hl7.fhir.dstu2016may.model.ElementDefinition t : src.getElement())
      tgt.addElement(ElementDefinition14_30.convertElementDefinition(t));
    return tgt;
  }

  static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionKind> convertStructureDefinitionKind(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionKind> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionKind> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionKindEnumFactory());
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    switch (src.getValue()) {
      case PRIMITIVETYPE:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionKind.DATATYPE);
        break;
      case COMPLEXTYPE:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionKind.DATATYPE);
        break;
      case RESOURCE:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionKind.RESOURCE);
        break;
      case LOGICAL:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionKind.LOGICAL);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionKind.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionKind> convertStructureDefinitionKind(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionKind> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionKind> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionKindEnumFactory());
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    switch (src.getValue()) {
      case DATATYPE:
        tgt.setValue(org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionKind.COMPLEXTYPE);
        break;
      case RESOURCE:
        tgt.setValue(org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionKind.RESOURCE);
        break;
      case LOGICAL:
        tgt.setValue(org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionKind.LOGICAL);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionKind.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionMappingComponent convertStructureDefinitionMappingComponent(org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionMappingComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionMappingComponent tgt = new org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionMappingComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasIdentityElement())
      tgt.setIdentityElement(Id14_30.convertId(src.getIdentityElement()));
    if (src.hasUri())
      tgt.setUriElement(Uri14_30.convertUri(src.getUriElement()));
    if (src.hasName())
      tgt.setNameElement(String14_30.convertString(src.getNameElement()));
    if (src.hasComments())
      tgt.setCommentElement(String14_30.convertString(src.getCommentsElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionMappingComponent convertStructureDefinitionMappingComponent(org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionMappingComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionMappingComponent tgt = new org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionMappingComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasIdentityElement())
      tgt.setIdentityElement(Id14_30.convertId(src.getIdentityElement()));
    if (src.hasUri())
      tgt.setUriElement(Uri14_30.convertUri(src.getUriElement()));
    if (src.hasName())
      tgt.setNameElement(String14_30.convertString(src.getNameElement()));
    if (src.hasComment())
      tgt.setCommentsElement(String14_30.convertString(src.getCommentElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionSnapshotComponent convertStructureDefinitionSnapshotComponent(org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionSnapshotComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionSnapshotComponent tgt = new org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionSnapshotComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    for (org.hl7.fhir.dstu2016may.model.ElementDefinition t : src.getElement())
      tgt.addElement(ElementDefinition14_30.convertElementDefinition(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionSnapshotComponent convertStructureDefinitionSnapshotComponent(org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionSnapshotComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionSnapshotComponent tgt = new org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionSnapshotComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    for (org.hl7.fhir.dstu3.model.ElementDefinition t : src.getElement())
      tgt.addElement(ElementDefinition14_30.convertElementDefinition(t));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.StructureDefinition.TypeDerivationRule> convertTypeDerivationRule(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.StructureDefinition.TypeDerivationRule> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.StructureDefinition.TypeDerivationRule> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.StructureDefinition.TypeDerivationRuleEnumFactory());
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    switch (src.getValue()) {
      case SPECIALIZATION:
        tgt.setValue(org.hl7.fhir.dstu3.model.StructureDefinition.TypeDerivationRule.SPECIALIZATION);
        break;
      case CONSTRAINT:
        tgt.setValue(org.hl7.fhir.dstu3.model.StructureDefinition.TypeDerivationRule.CONSTRAINT);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.StructureDefinition.TypeDerivationRule.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.StructureDefinition.TypeDerivationRule> convertTypeDerivationRule(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.StructureDefinition.TypeDerivationRule> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.StructureDefinition.TypeDerivationRule> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.StructureDefinition.TypeDerivationRuleEnumFactory());
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    switch (src.getValue()) {
      case SPECIALIZATION:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.StructureDefinition.TypeDerivationRule.SPECIALIZATION);
        break;
      case CONSTRAINT:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.StructureDefinition.TypeDerivationRule.CONSTRAINT);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.StructureDefinition.TypeDerivationRule.NULL);
        break;
    }
    return tgt;
  }
}