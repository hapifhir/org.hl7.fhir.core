package org.hl7.fhir.convertors.conv14_30.resources14_30;

import org.hl7.fhir.convertors.context.ConversionContext14_30;
import org.hl7.fhir.convertors.conv14_30.VersionConvertor_14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.Reference14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.complextypes14_30.CodeableConcept14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.complextypes14_30.ContactPoint14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30.Boolean14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30.Code14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30.DateTime14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30.Integer14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30.String14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30.Uri14_30;
import org.hl7.fhir.dstu3.model.Enumerations.SearchParamType;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.Utilities;

public class OperationDefinition14_30 {

  public static org.hl7.fhir.dstu3.model.OperationDefinition convertOperationDefinition(org.hl7.fhir.dstu2016may.model.OperationDefinition src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.OperationDefinition tgt = new org.hl7.fhir.dstu3.model.OperationDefinition();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri14_30.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String14_30.convertString(src.getVersionElement()));
    if (src.hasNameElement())
      tgt.setNameElement(String14_30.convertString(src.getNameElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations14_30.convertConformanceResourceStatus(src.getStatusElement()));
    if (src.hasKind())
      tgt.setKindElement(convertOperationKind(src.getKindElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean14_30.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime14_30.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String14_30.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionContactComponent t : src.getContact())
      tgt.addContact(convertOperationDefinitionContactComponent(t));
    if (src.hasDescription())
      tgt.setDescription(src.getDescription());
    for (org.hl7.fhir.dstu2016may.model.CodeableConcept t : src.getUseContext())
      if (VersionConvertor_14_30.isJurisdiction(t))
        tgt.addJurisdiction(CodeableConcept14_30.convertCodeableConcept(t));
      else
        tgt.addUseContext(CodeableConcept14_30.convertCodeableConceptToUsageContext(t));
    if (src.hasRequirements())
      tgt.setPurpose(src.getRequirements());
    if (src.hasIdempotent())
      tgt.setIdempotentElement(Boolean14_30.convertBoolean(src.getIdempotentElement()));
    if (src.hasCodeElement())
      tgt.setCodeElement(Code14_30.convertCode(src.getCodeElement()));
    if (src.hasComment())
      tgt.setCommentElement(String14_30.convertString(src.getCommentElement()));
    if (src.hasBase())
      tgt.setBase(Reference14_30.convertReference(src.getBase()));
    if (src.hasSystemElement())
      tgt.setSystemElement(Boolean14_30.convertBoolean(src.getSystemElement()));
    for (org.hl7.fhir.dstu2016may.model.CodeType t : src.getType()) tgt.addResource(t.getValue());
    tgt.setType(tgt.hasResource());
    if (src.hasInstanceElement())
      tgt.setInstanceElement(Boolean14_30.convertBoolean(src.getInstanceElement()));
    for (org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionParameterComponent t : src.getParameter())
      tgt.addParameter(convertOperationDefinitionParameterComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.OperationDefinition convertOperationDefinition(org.hl7.fhir.dstu3.model.OperationDefinition src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.OperationDefinition tgt = new org.hl7.fhir.dstu2016may.model.OperationDefinition();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri14_30.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String14_30.convertString(src.getVersionElement()));
    if (src.hasNameElement())
      tgt.setNameElement(String14_30.convertString(src.getNameElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations14_30.convertConformanceResourceStatus(src.getStatusElement()));
    if (src.hasKind())
      tgt.setKindElement(convertOperationKind(src.getKindElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean14_30.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime14_30.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String14_30.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact())
      tgt.addContact(convertOperationDefinitionContactComponent(t));
    if (src.hasDescription())
      tgt.setDescription(src.getDescription());
    for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext())
      if (t.hasValueCodeableConcept())
        tgt.addUseContext(CodeableConcept14_30.convertCodeableConcept(t.getValueCodeableConcept()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction())
      tgt.addUseContext(CodeableConcept14_30.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setRequirements(src.getPurpose());
    if (src.hasIdempotent())
      tgt.setIdempotentElement(Boolean14_30.convertBoolean(src.getIdempotentElement()));
    if (src.hasCodeElement())
      tgt.setCodeElement(Code14_30.convertCode(src.getCodeElement()));
    if (src.hasComment())
      tgt.setCommentElement(String14_30.convertString(src.getCommentElement()));
    if (src.hasBase())
      tgt.setBase(Reference14_30.convertReference(src.getBase()));
    if (src.hasSystemElement())
      tgt.setSystemElement(Boolean14_30.convertBoolean(src.getSystemElement()));
    if (src.getType())
      for (org.hl7.fhir.dstu3.model.CodeType t : src.getResource()) tgt.addType(t.getValue());
    if (src.hasInstanceElement())
      tgt.setInstanceElement(Boolean14_30.convertBoolean(src.getInstanceElement()));
    for (org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterComponent t : src.getParameter())
      tgt.addParameter(convertOperationDefinitionParameterComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionContactComponent convertOperationDefinitionContactComponent(org.hl7.fhir.dstu3.model.ContactDetail src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionContactComponent tgt = new org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionContactComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String14_30.convertString(src.getNameElement()));
    for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint14_30.convertContactPoint(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.ContactDetail convertOperationDefinitionContactComponent(org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionContactComponent src) throws FHIRException {
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

  public static org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterBindingComponent convertOperationDefinitionParameterBindingComponent(org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionParameterBindingComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterBindingComponent tgt = new org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterBindingComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyBackboneElement(src,tgt);
    if (src.hasStrength())
      tgt.setStrengthElement(Enumerations14_30.convertBindingStrength(src.getStrengthElement()));
    if (src.hasValueSet())
      tgt.setValueSet(ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().convertType(src.getValueSet()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionParameterBindingComponent convertOperationDefinitionParameterBindingComponent(org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterBindingComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionParameterBindingComponent tgt = new org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionParameterBindingComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyBackboneElement(src,tgt);
    if (src.hasStrength())
      tgt.setStrengthElement(Enumerations14_30.convertBindingStrength(src.getStrengthElement()));
    if (src.hasValueSet())
      tgt.setValueSet(ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().convertType(src.getValueSet()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionParameterComponent convertOperationDefinitionParameterComponent(org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionParameterComponent tgt = new org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionParameterComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyBackboneElement(src,tgt);
    if (src.hasNameElement())
      tgt.setNameElement(Code14_30.convertCode(src.getNameElement()));
    if (src.hasUse())
      tgt.setUseElement(convertOperationParameterUse(src.getUseElement()));
    if (src.hasMinElement())
      tgt.setMinElement(Integer14_30.convertInteger(src.getMinElement()));
    if (src.hasMaxElement())
      tgt.setMaxElement(String14_30.convertString(src.getMaxElement()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(String14_30.convertString(src.getDocumentationElement()));
    if (src.hasType())
      tgt.setTypeElement(Code14_30.convertCode(src.getTypeElement()));
    if (src.hasSearchType())
      tgt.setSearchTypeElement(Enumerations14_30.convertSearchParamType(src.getSearchTypeElement()));
    if (src.hasProfile())
      tgt.setProfile(Reference14_30.convertReference(src.getProfile()));
    if (src.hasBinding())
      tgt.setBinding(convertOperationDefinitionParameterBindingComponent(src.getBinding()));
    for (org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterComponent t : src.getPart())
      tgt.addPart(convertOperationDefinitionParameterComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterComponent convertOperationDefinitionParameterComponent(org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionParameterComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterComponent tgt = new org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyBackboneElement(src,tgt);
    if (src.hasNameElement())
      tgt.setNameElement(Code14_30.convertCode(src.getNameElement()));
    if (src.hasUse())
      tgt.setUseElement(convertOperationParameterUse(src.getUseElement()));
    if (src.hasMinElement())
      tgt.setMinElement(Integer14_30.convertInteger(src.getMinElement()));
    if (src.hasMaxElement())
      tgt.setMaxElement(String14_30.convertString(src.getMaxElement()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(String14_30.convertString(src.getDocumentationElement()));
    if (Utilities.existsInList(src.getType(), "token", "reference", "composite", "number", "date", "quantity", "uri")) {
      tgt.setType("string");
      if (src.hasType())
        tgt.setSearchType(SearchParamType.fromCode(src.getType()));
    } else {
      if (src.hasTypeElement())
        tgt.setTypeElement(Code14_30.convertCode(src.getTypeElement()));
    }
    if (src.hasSearchType())
      tgt.setSearchTypeElement(Enumerations14_30.convertSearchParamType(src.getSearchTypeElement()));
    if (src.hasProfile())
      tgt.setProfile(Reference14_30.convertReference(src.getProfile()));
    if (src.hasBinding())
      tgt.setBinding(convertOperationDefinitionParameterBindingComponent(src.getBinding()));
    for (org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionParameterComponent t : src.getPart())
      tgt.addPart(convertOperationDefinitionParameterComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationKind> convertOperationKind(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.OperationDefinition.OperationKind> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationKind> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationKindEnumFactory());
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    switch (src.getValue()) {
      case OPERATION:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationKind.OPERATION);
        break;
      case QUERY:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationKind.QUERY);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationKind.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.OperationDefinition.OperationKind> convertOperationKind(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationKind> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.OperationDefinition.OperationKind> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.OperationDefinition.OperationKindEnumFactory());
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    switch (src.getValue()) {
      case OPERATION:
        tgt.setValue(org.hl7.fhir.dstu3.model.OperationDefinition.OperationKind.OPERATION);
        break;
      case QUERY:
        tgt.setValue(org.hl7.fhir.dstu3.model.OperationDefinition.OperationKind.QUERY);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.OperationDefinition.OperationKind.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.OperationDefinition.OperationParameterUse> convertOperationParameterUse(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationParameterUse> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.OperationDefinition.OperationParameterUse> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.OperationDefinition.OperationParameterUseEnumFactory());
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    switch (src.getValue()) {
      case IN:
        tgt.setValue(org.hl7.fhir.dstu3.model.OperationDefinition.OperationParameterUse.IN);
        break;
      case OUT:
        tgt.setValue(org.hl7.fhir.dstu3.model.OperationDefinition.OperationParameterUse.OUT);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.OperationDefinition.OperationParameterUse.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationParameterUse> convertOperationParameterUse(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.OperationDefinition.OperationParameterUse> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationParameterUse> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationParameterUseEnumFactory());
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    switch (src.getValue()) {
      case IN:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationParameterUse.IN);
        break;
      case OUT:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationParameterUse.OUT);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationParameterUse.NULL);
        break;
    }
    return tgt;
  }
}