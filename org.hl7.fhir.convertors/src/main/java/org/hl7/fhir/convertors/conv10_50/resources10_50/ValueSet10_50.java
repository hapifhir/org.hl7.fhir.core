package org.hl7.fhir.convertors.conv10_50.resources10_50;

import java.util.List;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_10_50;
import org.hl7.fhir.convertors.context.ConversionContext10_50;
import org.hl7.fhir.convertors.conv10_50.VersionConvertor_10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.CodeableConcept10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Coding10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.ContactPoint10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Identifier10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Boolean10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Code10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.DateTime10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Integer10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.String10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Uri10_50;
import org.hl7.fhir.dstu2.model.ValueSet;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.BooleanType;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.Enumerations.CodeSystemContentMode;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.terminologies.CodeSystemUtilities;

public class ValueSet10_50 {

  public static org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent convertConceptReferenceComponent(org.hl7.fhir.dstu2.model.ValueSet.ConceptReferenceComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasCodeElement())
      tgt.setCodeElement(Code10_50.convertCode(src.getCodeElement()));
    if (src.hasDisplayElement())
      tgt.setDisplayElement(String10_50.convertString(src.getDisplayElement()));
    for (org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionDesignationComponent t : src.getDesignation())
      tgt.addDesignation(convertConceptReferenceDesignationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.ValueSet.ConceptReferenceComponent convertConceptReferenceComponent(org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.ValueSet.ConceptReferenceComponent tgt = new org.hl7.fhir.dstu2.model.ValueSet.ConceptReferenceComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasCodeElement())
      tgt.setCodeElement(Code10_50.convertCode(src.getCodeElement()));
    if (src.hasDisplayElement())
      tgt.setDisplayElement(String10_50.convertString(src.getDisplayElement()));
    for (org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent t : src.getDesignation())
      tgt.addDesignation(convertConceptReferenceDesignationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent convertConceptReferenceDesignationComponent(org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionDesignationComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasLanguageElement())
      tgt.setLanguageElement(Code10_50.convertCode(src.getLanguageElement()));
    if (src.hasUse())
      tgt.setUse(Coding10_50.convertCoding(src.getUse()));
    if (src.hasValueElement())
      tgt.setValueElement(String10_50.convertString(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionDesignationComponent convertConceptReferenceDesignationComponent(org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionDesignationComponent tgt = new org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionDesignationComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasLanguageElement())
      tgt.setLanguageElement(Code10_50.convertCode(src.getLanguageElement()));
    if (src.hasUse())
      tgt.setUse(Coding10_50.convertCoding(src.getUse()));
    if (src.hasValueElement())
      tgt.setValueElement(String10_50.convertString(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent convertConceptSetComponent(org.hl7.fhir.dstu2.model.ValueSet.ConceptSetComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasSystemElement())
      tgt.setSystemElement(Uri10_50.convertUri(src.getSystemElement()));
    if (src.hasVersionElement())
      tgt.setVersionElement(String10_50.convertString(src.getVersionElement()));
    for (org.hl7.fhir.dstu2.model.ValueSet.ConceptReferenceComponent t : src.getConcept())
      tgt.addConcept(convertConceptReferenceComponent(t));
    for (org.hl7.fhir.dstu2.model.ValueSet.ConceptSetFilterComponent t : src.getFilter())
      tgt.addFilter(convertConceptSetFilterComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.ValueSet.ConceptSetComponent convertConceptSetComponent(org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.ValueSet.ConceptSetComponent tgt = new org.hl7.fhir.dstu2.model.ValueSet.ConceptSetComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasSystemElement())
      tgt.setSystemElement(Uri10_50.convertUri(src.getSystemElement()));
    if (src.hasVersionElement())
      tgt.setVersionElement(String10_50.convertString(src.getVersionElement()));
    for (org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent t : src.getConcept())
      tgt.addConcept(convertConceptReferenceComponent(t));
    for (org.hl7.fhir.r5.model.ValueSet.ConceptSetFilterComponent t : src.getFilter())
      tgt.addFilter(convertConceptSetFilterComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.ValueSet.ConceptSetFilterComponent convertConceptSetFilterComponent(org.hl7.fhir.r5.model.ValueSet.ConceptSetFilterComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.ValueSet.ConceptSetFilterComponent tgt = new org.hl7.fhir.dstu2.model.ValueSet.ConceptSetFilterComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasPropertyElement())
      tgt.setPropertyElement(Code10_50.convertCode(src.getPropertyElement()));
    if (src.hasOp())
      tgt.setOpElement(convertFilterOperator(src.getOpElement()));
    if (src.hasValue())
      tgt.setValue(src.getValue());
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ValueSet.ConceptSetFilterComponent convertConceptSetFilterComponent(org.hl7.fhir.dstu2.model.ValueSet.ConceptSetFilterComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.ValueSet.ConceptSetFilterComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ConceptSetFilterComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasPropertyElement())
      tgt.setPropertyElement(Code10_50.convertCode(src.getPropertyElement()));
    if (src.hasOp())
      tgt.setOpElement(convertFilterOperator(src.getOpElement()));
    if (src.hasValue())
      tgt.setValue(src.getValue());
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ValueSet.FilterOperator> convertFilterOperator(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FilterOperator> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ValueSet.FilterOperator> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.ValueSet.FilterOperatorEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case EQUAL:
        tgt.setValue(org.hl7.fhir.dstu2.model.ValueSet.FilterOperator.EQUAL);
        break;
      case ISA:
        tgt.setValue(org.hl7.fhir.dstu2.model.ValueSet.FilterOperator.ISA);
        break;
      case ISNOTA:
        tgt.setValue(org.hl7.fhir.dstu2.model.ValueSet.FilterOperator.ISNOTA);
        break;
      case REGEX:
        tgt.setValue(org.hl7.fhir.dstu2.model.ValueSet.FilterOperator.REGEX);
        break;
      case IN:
        tgt.setValue(org.hl7.fhir.dstu2.model.ValueSet.FilterOperator.IN);
        break;
      case NOTIN:
        tgt.setValue(org.hl7.fhir.dstu2.model.ValueSet.FilterOperator.NOTIN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.ValueSet.FilterOperator.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FilterOperator> convertFilterOperator(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ValueSet.FilterOperator> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FilterOperator> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.FilterOperatorEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case EQUAL:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FilterOperator.EQUAL);
        break;
      case ISA:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FilterOperator.ISA);
        break;
      case ISNOTA:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FilterOperator.ISNOTA);
        break;
      case REGEX:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FilterOperator.REGEX);
        break;
      case IN:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FilterOperator.IN);
        break;
      case NOTIN:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FilterOperator.NOTIN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FilterOperator.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.ValueSet convertValueSet(org.hl7.fhir.r5.model.ValueSet src, BaseAdvisor_10_50 advisor) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.ValueSet tgt = new org.hl7.fhir.dstu2.model.ValueSet();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyDomainResource(src, tgt);
    if (src.hasUrlElement())
      tgt.setUrlElement(Uri10_50.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.r5.model.Identifier i : src.getIdentifier())
      tgt.setIdentifier(Identifier10_50.convertIdentifier(i));
    if (src.hasVersionElement())
      tgt.setVersionElement(String10_50.convertString(src.getVersionElement()));
    if (src.hasNameElement())
      tgt.setNameElement(String10_50.convertString(src.getNameElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations10_50.convertConformanceResourceStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean10_50.convertBoolean(src.getExperimentalElement()));
    if (src.hasPublisherElement())
      tgt.setPublisherElement(String10_50.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact()) tgt.addContact(convertValueSetContactComponent(t));
    if (src.hasDate())
      tgt.setDateElement(DateTime10_50.convertDateTime(src.getDateElement()));
    tgt.setLockedDate(src.getCompose().getLockedDate());
    if (src.hasDescription())
      tgt.setDescription(src.getDescription());
    for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext())
      if (t.hasValueCodeableConcept())
        tgt.addUseContext(CodeableConcept10_50.convertCodeableConcept(t.getValueCodeableConcept()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction())
      tgt.addUseContext(CodeableConcept10_50.convertCodeableConcept(t));
    if (src.hasImmutableElement())
      tgt.setImmutableElement(Boolean10_50.convertBoolean(src.getImmutableElement()));
    if (src.hasPurpose())
      tgt.setRequirements(src.getPurpose());
    if (src.hasCopyright())
      tgt.setCopyright(src.getCopyright());
    if (src.hasExtension("http://hl7.org/fhir/StructureDefinition/valueset-extensible"))
      tgt.setExtensible(((BooleanType) src.getExtensionByUrl("http://hl7.org/fhir/StructureDefinition/valueset-extensible").getValue()).booleanValue());
    org.hl7.fhir.r5.model.CodeSystem srcCS = (CodeSystem) src.getUserData("r2-cs");
    if (srcCS == null && advisor != null)
      srcCS = advisor.getCodeSystem(src);
    if (srcCS != null) {
      tgt.getCodeSystem().setSystem(srcCS.getUrl());
      tgt.getCodeSystem().setVersion(srcCS.getVersion());
      tgt.getCodeSystem().setCaseSensitive(srcCS.getCaseSensitive());
      for (org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent cs : srcCS.getConcept())
        processConcept(tgt.getCodeSystem().getConcept(), cs, srcCS);
    }
    if (src.hasCompose())
      tgt.setCompose(convertValueSetComposeComponent(src.getCompose(), srcCS == null ? null : srcCS.getUrl()));
    if (src.hasExpansion())
      tgt.setExpansion(convertValueSetExpansionComponent(src.getExpansion()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ValueSet convertValueSet(org.hl7.fhir.dstu2.model.ValueSet src) throws FHIRException {
    return convertValueSet(src, null);
  }

  public static org.hl7.fhir.r5.model.ValueSet convertValueSet(org.hl7.fhir.dstu2.model.ValueSet src, BaseAdvisor_10_50 advisor) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.ValueSet tgt = new org.hl7.fhir.r5.model.ValueSet();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyDomainResource(src, tgt);
    if (src.hasUrlElement())
      tgt.setUrlElement(Uri10_50.convertUri(src.getUrlElement()));
    if (src.hasIdentifier())
      tgt.addIdentifier(Identifier10_50.convertIdentifier(src.getIdentifier()));
    if (src.hasVersionElement())
      tgt.setVersionElement(String10_50.convertString(src.getVersionElement()));
    if (src.hasNameElement())
      tgt.setNameElement(String10_50.convertString(src.getNameElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations10_50.convertConformanceResourceStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean10_50.convertBoolean(src.getExperimentalElement()));
    if (src.hasPublisherElement())
      tgt.setPublisherElement(String10_50.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.dstu2.model.ValueSet.ValueSetContactComponent t : src.getContact())
      tgt.addContact(convertValueSetContactComponent(t));
    if (src.hasDate())
      tgt.setDateElement(DateTime10_50.convertDateTime(src.getDateElement()));
    if (src.hasDescription())
      tgt.setDescription(src.getDescription());
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getUseContext())
      if (VersionConvertor_10_50.isJurisdiction(t))
        tgt.addJurisdiction(CodeableConcept10_50.convertCodeableConcept(t));
      else
        tgt.addUseContext(CodeableConcept10_50.convertCodeableConceptToUsageContext(t));
    if (src.hasImmutableElement())
      tgt.setImmutableElement(Boolean10_50.convertBoolean(src.getImmutableElement()));
    if (src.hasRequirements())
      tgt.setPurpose(src.getRequirements());
    if (src.hasCopyright())
      tgt.setCopyright(src.getCopyright());
    if (src.hasExtensible())
      tgt.addExtension("http://hl7.org/fhir/StructureDefinition/valueset-extensible", new BooleanType(src.getExtensible()));
    if (src.hasCompose()) {
      if (src.hasCompose())
        tgt.setCompose(convertValueSetComposeComponent(src.getCompose()));
      tgt.getCompose().setLockedDate(src.getLockedDate());
    }
    if (src.hasCodeSystem() && advisor != null) {
      org.hl7.fhir.r5.model.CodeSystem tgtcs = new org.hl7.fhir.r5.model.CodeSystem();
      ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyDomainResource(src, tgtcs);
      tgtcs.setUrl(src.getCodeSystem().getSystem());
      tgtcs.addIdentifier(Identifier10_50.convertIdentifier(src.getIdentifier()));
      tgtcs.setVersion(src.getCodeSystem().getVersion());
      tgtcs.setName(src.getName() + " Code System");
      tgtcs.setStatusElement(Enumerations10_50.convertConformanceResourceStatus(src.getStatusElement()));
      if (src.hasExperimental())
        tgtcs.setExperimental(src.getExperimental());
      tgtcs.setPublisher(src.getPublisher());
      for (org.hl7.fhir.dstu2.model.ValueSet.ValueSetContactComponent t : src.getContact())
        tgtcs.addContact(convertValueSetContactComponent(t));
      if (src.hasDate())
        tgtcs.setDate(src.getDate());
      tgtcs.setDescription(src.getDescription());
      for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getUseContext())
        if (VersionConvertor_10_50.isJurisdiction(t))
          tgtcs.addJurisdiction(CodeableConcept10_50.convertCodeableConcept(t));
        else
          tgtcs.addUseContext(CodeableConcept10_50.convertCodeableConceptToUsageContext(t));
      tgtcs.setPurpose(src.getRequirements());
      tgtcs.setCopyright(src.getCopyright());
      tgtcs.setContent(CodeSystemContentMode.COMPLETE);
      tgtcs.setCaseSensitive(src.getCodeSystem().getCaseSensitive());
      for (org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionComponent cs : src.getCodeSystem().getConcept())
        processConcept(tgtcs.getConcept(), cs, tgtcs);
      advisor.handleCodeSystem(tgtcs, tgt);
      tgt.setUserData("r2-cs", tgtcs);
      tgt.getCompose().addInclude().setSystem(tgtcs.getUrl());
    }
    if (src.hasExpansion())
      tgt.setExpansion(convertValueSetExpansionComponent(src.getExpansion()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.ValueSet convertValueSet(org.hl7.fhir.r5.model.ValueSet src) throws FHIRException {
    return convertValueSet(src, null);
  }

  public static org.hl7.fhir.r5.model.ValueSet.ValueSetComposeComponent convertValueSetComposeComponent(org.hl7.fhir.dstu2.model.ValueSet.ValueSetComposeComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.ValueSet.ValueSetComposeComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ValueSetComposeComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    for (org.hl7.fhir.dstu2.model.UriType t : src.getImport()) tgt.addInclude().addValueSet(t.getValue());
    for (org.hl7.fhir.dstu2.model.ValueSet.ConceptSetComponent t : src.getInclude())
      tgt.addInclude(convertConceptSetComponent(t));
    for (org.hl7.fhir.dstu2.model.ValueSet.ConceptSetComponent t : src.getExclude())
      tgt.addExclude(convertConceptSetComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.ValueSet.ValueSetComposeComponent convertValueSetComposeComponent(org.hl7.fhir.r5.model.ValueSet.ValueSetComposeComponent src, String noSystem) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.ValueSet.ValueSetComposeComponent tgt = new org.hl7.fhir.dstu2.model.ValueSet.ValueSetComposeComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    for (org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent t : src.getInclude()) {
      for (org.hl7.fhir.r5.model.UriType ti : t.getValueSet()) tgt.addImport(ti.getValue());
      if (noSystem == null || !t.getSystem().equals(noSystem))
        tgt.addInclude(convertConceptSetComponent(t));
    }
    for (org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent t : src.getExclude())
      tgt.addExclude(convertConceptSetComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ContactDetail convertValueSetContactComponent(org.hl7.fhir.dstu2.model.ValueSet.ValueSetContactComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.ContactDetail tgt = new org.hl7.fhir.r5.model.ContactDetail();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    if (src.hasNameElement())
      tgt.setNameElement(String10_50.convertString(src.getNameElement()));
    for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint10_50.convertContactPoint(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.ValueSet.ValueSetContactComponent convertValueSetContactComponent(org.hl7.fhir.r5.model.ContactDetail src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.ValueSet.ValueSetContactComponent tgt = new org.hl7.fhir.dstu2.model.ValueSet.ValueSetContactComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    if (src.hasNameElement())
      tgt.setNameElement(String10_50.convertString(src.getNameElement()));
    for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint10_50.convertContactPoint(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionComponent convertValueSetExpansionComponent(org.hl7.fhir.dstu2.model.ValueSet.ValueSetExpansionComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasIdentifierElement())
      tgt.setIdentifierElement(Uri10_50.convertUri(src.getIdentifierElement()));
    if (src.hasTimestampElement())
      tgt.setTimestampElement(DateTime10_50.convertDateTime(src.getTimestampElement()));
    if (src.hasTotalElement())
      tgt.setTotalElement(Integer10_50.convertInteger(src.getTotalElement()));
    if (src.hasOffsetElement())
      tgt.setOffsetElement(Integer10_50.convertInteger(src.getOffsetElement()));
    for (org.hl7.fhir.dstu2.model.ValueSet.ValueSetExpansionParameterComponent t : src.getParameter())
      tgt.addParameter(convertValueSetExpansionParameterComponent(t));
    for (org.hl7.fhir.dstu2.model.ValueSet.ValueSetExpansionContainsComponent t : src.getContains())
      tgt.addContains(convertValueSetExpansionContainsComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.ValueSet.ValueSetExpansionComponent convertValueSetExpansionComponent(org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.ValueSet.ValueSetExpansionComponent tgt = new org.hl7.fhir.dstu2.model.ValueSet.ValueSetExpansionComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasIdentifierElement())
      tgt.setIdentifierElement(Uri10_50.convertUri(src.getIdentifierElement()));
    if (src.hasTimestampElement())
      tgt.setTimestampElement(DateTime10_50.convertDateTime(src.getTimestampElement()));
    if (src.hasTotalElement())
      tgt.setTotalElement(Integer10_50.convertInteger(src.getTotalElement()));
    if (src.hasOffsetElement())
      tgt.setOffsetElement(Integer10_50.convertInteger(src.getOffsetElement()));
    for (org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionParameterComponent t : src.getParameter())
      tgt.addParameter(convertValueSetExpansionParameterComponent(t));
    for (org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent t : src.getContains())
      tgt.addContains(convertValueSetExpansionContainsComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.ValueSet.ValueSetExpansionContainsComponent convertValueSetExpansionContainsComponent(org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.ValueSet.ValueSetExpansionContainsComponent tgt = new org.hl7.fhir.dstu2.model.ValueSet.ValueSetExpansionContainsComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasSystemElement())
      tgt.setSystemElement(Uri10_50.convertUri(src.getSystemElement()));
    if (src.hasAbstractElement())
      tgt.setAbstractElement(Boolean10_50.convertBoolean(src.getAbstractElement()));
    if (src.hasVersionElement())
      tgt.setVersionElement(String10_50.convertString(src.getVersionElement()));
    if (src.hasCodeElement())
      tgt.setCodeElement(Code10_50.convertCode(src.getCodeElement()));
    if (src.hasDisplayElement())
      tgt.setDisplayElement(String10_50.convertString(src.getDisplayElement()));
    for (org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent t : src.getContains())
      tgt.addContains(convertValueSetExpansionContainsComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent convertValueSetExpansionContainsComponent(org.hl7.fhir.dstu2.model.ValueSet.ValueSetExpansionContainsComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasSystemElement())
      tgt.setSystemElement(Uri10_50.convertUri(src.getSystemElement()));
    if (src.hasAbstractElement())
      tgt.setAbstractElement(Boolean10_50.convertBoolean(src.getAbstractElement()));
    if (src.hasVersionElement())
      tgt.setVersionElement(String10_50.convertString(src.getVersionElement()));
    if (src.hasCodeElement())
      tgt.setCodeElement(Code10_50.convertCode(src.getCodeElement()));
    if (src.hasDisplayElement())
      tgt.setDisplayElement(String10_50.convertString(src.getDisplayElement()));
    for (org.hl7.fhir.dstu2.model.ValueSet.ValueSetExpansionContainsComponent t : src.getContains())
      tgt.addContains(convertValueSetExpansionContainsComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.ValueSet.ValueSetExpansionParameterComponent convertValueSetExpansionParameterComponent(org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionParameterComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.ValueSet.ValueSetExpansionParameterComponent tgt = new org.hl7.fhir.dstu2.model.ValueSet.ValueSetExpansionParameterComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasNameElement())
      tgt.setNameElement(String10_50.convertString(src.getNameElement()));
    if (src.hasValue())
      tgt.setValue(ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionParameterComponent convertValueSetExpansionParameterComponent(org.hl7.fhir.dstu2.model.ValueSet.ValueSetExpansionParameterComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionParameterComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionParameterComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasNameElement())
      tgt.setNameElement(String10_50.convertString(src.getNameElement()));
    if (src.hasValue())
      tgt.setValue(ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().convertType(src.getValue()));
    return tgt;
  }

  static public void processConcept(List<ValueSet.ConceptDefinitionComponent> concepts, ConceptDefinitionComponent cs, CodeSystem srcCS) throws FHIRException {
    org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionComponent ct = new org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionComponent();
    concepts.add(ct);
    ct.setCode(cs.getCode());
    ct.setDisplay(cs.getDisplay());
    ct.setDefinition(cs.getDefinition());
    if (CodeSystemUtilities.isNotSelectable(srcCS, cs))
      ct.setAbstract(true);
    for (org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionDesignationComponent csd : cs.getDesignation()) {
      org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionDesignationComponent cst = new org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionDesignationComponent();
      cst.setLanguage(csd.getLanguage());
      cst.setUse(Coding10_50.convertCoding(csd.getUse()));
      cst.setValue(csd.getValue());
    }
    for (ConceptDefinitionComponent csc : cs.getConcept()) processConcept(ct.getConcept(), csc, srcCS);
  }

  static public void processConcept(List<ConceptDefinitionComponent> concepts, org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionComponent cs, CodeSystem tgtcs) throws FHIRException {
    org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent ct = new org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent();
    concepts.add(ct);
    ct.setCode(cs.getCode());
    ct.setDisplay(cs.getDisplay());
    ct.setDefinition(cs.getDefinition());
    if (cs.getAbstract())
      CodeSystemUtilities.setNotSelectable(tgtcs, ct);
    for (org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionDesignationComponent csd : cs.getDesignation()) {
      org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionDesignationComponent cst = new org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionDesignationComponent();
      cst.setLanguage(csd.getLanguage());
      cst.setUse(Coding10_50.convertCoding(csd.getUse()));
      cst.setValue(csd.getValue());
    }
    for (org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionComponent csc : cs.getConcept())
      processConcept(ct.getConcept(), csc, tgtcs);
  }

  public static ValueSet.ValueSetCodeSystemComponent convertCodeSystem(CodeSystem src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    ValueSet.ValueSetCodeSystemComponent tgt = new ValueSet.ValueSetCodeSystemComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    if (src.hasUrlElement()) tgt.setSystemElement(Uri10_50.convertUri(src.getUrlElement()));
    if (src.hasVersionElement()) tgt.setVersionElement(String10_50.convertString(src.getVersionElement()));
    if (src.hasCaseSensitiveElement())
      tgt.setCaseSensitiveElement(Boolean10_50.convertBoolean(src.getCaseSensitiveElement()));
    for (ConceptDefinitionComponent cc : src.getConcept()) tgt.addConcept(convertCodeSystemConcept(src, cc));
    return tgt;
  }

  public static ValueSet.ConceptDefinitionComponent convertCodeSystemConcept(CodeSystem cs, ConceptDefinitionComponent src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    ValueSet.ConceptDefinitionComponent tgt = new ValueSet.ConceptDefinitionComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    tgt.setAbstract(CodeSystemUtilities.isNotSelectable(cs, src));
    if (src.hasCode()) tgt.setCode(src.getCode());
    if (src.hasDefinition()) tgt.setDefinition(src.getDefinition());
    if (src.hasDisplay()) tgt.setDisplay(src.getDisplay());
    for (ConceptDefinitionComponent cc : src.getConcept()) tgt.addConcept(convertCodeSystemConcept(cs, cc));
    for (CodeSystem.ConceptDefinitionDesignationComponent cc : src.getDesignation())
      tgt.addDesignation(convertCodeSystemDesignation(cc));
    return tgt;
  }

  public static ValueSet.ConceptDefinitionDesignationComponent convertCodeSystemDesignation(CodeSystem.ConceptDefinitionDesignationComponent src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    ValueSet.ConceptDefinitionDesignationComponent tgt = new ValueSet.ConceptDefinitionDesignationComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasUse()) tgt.setUse(Coding10_50.convertCoding(src.getUse()));
    if (src.hasLanguage()) tgt.setLanguage(src.getLanguage());
    if (src.hasValue()) tgt.setValue(src.getValue());
    return tgt;
  }
}