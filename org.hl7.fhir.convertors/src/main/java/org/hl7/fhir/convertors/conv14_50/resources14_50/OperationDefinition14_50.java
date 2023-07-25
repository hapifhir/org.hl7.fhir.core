package org.hl7.fhir.convertors.conv14_50.resources14_50;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.context.ConversionContext14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.Reference14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.complextypes14_50.CodeableConcept14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.complextypes14_50.ContactPoint14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.Boolean14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.Code14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.DateTime14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.Integer14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.String14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.Uri14_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.Enumeration;
import org.hl7.fhir.r5.model.Enumerations;
import org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll;
import org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAllEnumFactory;

public class OperationDefinition14_50 {

  public static org.hl7.fhir.dstu2016may.model.OperationDefinition convertOperationDefinition(org.hl7.fhir.r5.model.OperationDefinition src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.OperationDefinition tgt = new org.hl7.fhir.dstu2016may.model.OperationDefinition();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri14_50.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String14_50.convertString(src.getVersionElement()));
    if (src.hasNameElement())
      tgt.setNameElement(String14_50.convertString(src.getNameElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations14_50.convertConformanceResourceStatus(src.getStatusElement()));
    if (src.hasKind())
      tgt.setKindElement(convertOperationKind(src.getKindElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean14_50.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime14_50.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String14_50.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact())
      tgt.addContact(convertOperationDefinitionContactComponent(t));
    if (src.hasDescription())
      tgt.setDescription(src.getDescription());
    for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext())
      if (t.hasValueCodeableConcept())
        tgt.addUseContext(CodeableConcept14_50.convertCodeableConcept(t.getValueCodeableConcept()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction())
      tgt.addUseContext(CodeableConcept14_50.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setRequirements(src.getPurpose());
    if (src.hasAffectsState())
      tgt.setIdempotent(!src.getAffectsState());
    if (src.hasCodeElement())
      tgt.setCodeElement(Code14_50.convertCode(src.getCodeElement()));
    if (src.hasComment())
      tgt.setComment(src.getComment());
    if (src.hasBaseElement())
      tgt.setBase(Reference14_50.convertCanonicalToReference(src.getBaseElement()));
    if (src.hasSystemElement())
      tgt.setSystemElement(Boolean14_50.convertBoolean(src.getSystemElement()));
    if (src.getType())
      for (Enumeration<VersionIndependentResourceTypesAll> t : src.getResource()) tgt.addType(t.getCode());
    if (src.hasInstanceElement())
      tgt.setInstanceElement(Boolean14_50.convertBoolean(src.getInstanceElement()));
    for (org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterComponent t : src.getParameter())
      tgt.addParameter(convertOperationDefinitionParameterComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.OperationDefinition convertOperationDefinition(org.hl7.fhir.dstu2016may.model.OperationDefinition src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.OperationDefinition tgt = new org.hl7.fhir.r5.model.OperationDefinition();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri14_50.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String14_50.convertString(src.getVersionElement()));
    if (src.hasNameElement())
      tgt.setNameElement(String14_50.convertString(src.getNameElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations14_50.convertConformanceResourceStatus(src.getStatusElement()));
    if (src.hasKind())
      tgt.setKindElement(convertOperationKind(src.getKindElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean14_50.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime14_50.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String14_50.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionContactComponent t : src.getContact())
      tgt.addContact(convertOperationDefinitionContactComponent(t));
    if (src.hasDescription())
      tgt.setDescription(src.getDescription());
    for (org.hl7.fhir.dstu2016may.model.CodeableConcept t : src.getUseContext())
      if (CodeableConcept14_50.isJurisdiction(t))
        tgt.addJurisdiction(CodeableConcept14_50.convertCodeableConcept(t));
      else
        tgt.addUseContext(CodeableConcept14_50.convertCodeableConceptToUsageContext(t));
    if (src.hasRequirements())
      tgt.setPurpose(src.getRequirements());
    if (src.hasIdempotent())
      tgt.setAffectsState(!src.getIdempotent());
    if (src.hasCodeElement())
      tgt.setCodeElement(Code14_50.convertCode(src.getCodeElement()));
    if (src.hasComment())
      tgt.setComment(src.getComment());
    if (src.hasBase())
      tgt.setBaseElement(Reference14_50.convertReferenceToCanonical(src.getBase()));
    if (src.hasSystemElement())
      tgt.setSystemElement(Boolean14_50.convertBoolean(src.getSystemElement()));
    for (org.hl7.fhir.dstu2016may.model.CodeType t : src.getType()) tgt.getResource().add(new Enumeration<VersionIndependentResourceTypesAll>(new VersionIndependentResourceTypesAllEnumFactory(), Code14_50.convertCode(t)));
    tgt.setType(tgt.hasResource());
    if (src.hasInstanceElement())
      tgt.setInstanceElement(Boolean14_50.convertBoolean(src.getInstanceElement()));
    for (org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionParameterComponent t : src.getParameter())
      tgt.addParameter(convertOperationDefinitionParameterComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionContactComponent convertOperationDefinitionContactComponent(org.hl7.fhir.r5.model.ContactDetail src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionContactComponent tgt = new org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionContactComponent();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String14_50.convertString(src.getNameElement()));
    for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint14_50.convertContactPoint(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ContactDetail convertOperationDefinitionContactComponent(org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionContactComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.ContactDetail tgt = new org.hl7.fhir.r5.model.ContactDetail();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String14_50.convertString(src.getNameElement()));
    for (org.hl7.fhir.dstu2016may.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint14_50.convertContactPoint(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterBindingComponent convertOperationDefinitionParameterBindingComponent(org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionParameterBindingComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterBindingComponent tgt = new org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterBindingComponent();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyBackboneElement(src,tgt);
    if (src.hasStrength())
      tgt.setStrengthElement(Enumerations14_50.convertBindingStrength(src.getStrengthElement()));
    DataType t = ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().convertType(src.getValueSet());
    if (t != null) {
      if (t instanceof org.hl7.fhir.r5.model.Reference)
        tgt.setValueSet(((org.hl7.fhir.r5.model.Reference) t).getReference());
      else
        tgt.setValueSet(t.primitiveValue());
      tgt.setValueSet(VersionConvertorConstants.refToVS(tgt.getValueSet()));
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionParameterBindingComponent convertOperationDefinitionParameterBindingComponent(org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterBindingComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionParameterBindingComponent tgt = new org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionParameterBindingComponent();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyBackboneElement(src,tgt);
    if (src.hasStrength())
      tgt.setStrengthElement(Enumerations14_50.convertBindingStrength(src.getStrengthElement()));
    if (src.hasValueSet()) {
      String vsr = VersionConvertorConstants.vsToRef(src.getValueSet());
      if (vsr != null)
        tgt.setValueSet(new org.hl7.fhir.dstu2016may.model.UriType(vsr));
      else
        tgt.setValueSet(new org.hl7.fhir.dstu2016may.model.Reference(src.getValueSet()));
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionParameterComponent convertOperationDefinitionParameterComponent(org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionParameterComponent tgt = new org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionParameterComponent();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyBackboneElement(src,tgt);
    if (src.hasNameElement())
      tgt.setNameElement(Code14_50.convertCode(src.getNameElement()));
    if (src.hasUse())
      tgt.setUseElement(convertOperationParameterUse(src.getUseElement()));
    if (src.hasMinElement())
      tgt.setMinElement(Integer14_50.convertInteger(src.getMinElement()));
    if (src.hasMaxElement())
      tgt.setMaxElement(String14_50.convertString(src.getMaxElement()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(String14_50.convertString(src.getDocumentationElement()));
    if (src.hasType()) {
      tgt.setType(src.getType().toCode());
    }
    if (src.hasSearchType())
      tgt.setSearchTypeElement(Enumerations14_50.convertSearchParamType(src.getSearchTypeElement()));
    for (org.hl7.fhir.r5.model.UriType t : src.getTargetProfile())
      tgt.setProfile(new org.hl7.fhir.dstu2016may.model.Reference(t.getValue()));
    if (src.hasBinding())
      tgt.setBinding(convertOperationDefinitionParameterBindingComponent(src.getBinding()));
    for (org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterComponent t : src.getPart())
      tgt.addPart(convertOperationDefinitionParameterComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterComponent convertOperationDefinitionParameterComponent(org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionParameterComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterComponent tgt = new org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterComponent();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyBackboneElement(src,tgt);
    if (src.hasNameElement())
      tgt.setNameElement(Code14_50.convertCode(src.getNameElement()));
    if (src.hasUse())
      tgt.setUseElement(convertOperationParameterUse(src.getUseElement()));
    if (src.hasMinElement())
      tgt.setMinElement(Integer14_50.convertInteger(src.getMinElement()));
    if (src.hasMaxElement())
      tgt.setMaxElement(String14_50.convertString(src.getMaxElement()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(String14_50.convertStringToMarkdown(src.getDocumentationElement()));
    if (src.hasType())
      tgt.setType(Enumerations.FHIRTypes.fromCode(fixTypeCode(src.getType())));
    if (src.hasSearchType())
      tgt.setSearchTypeElement(Enumerations14_50.convertSearchParamType(src.getSearchTypeElement()));
    tgt.addTargetProfile(src.getProfile().getReference());
    if (src.hasBinding())
      tgt.setBinding(convertOperationDefinitionParameterBindingComponent(src.getBinding()));
    for (org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionParameterComponent t : src.getPart())
      tgt.addPart(convertOperationDefinitionParameterComponent(t));
    return tgt;
  }

  private static String fixTypeCode(String type) {
    if ("Type".equals(type)) {
      return "DataType";
    } else {
      return type;
    }
  }

  static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationKind> convertOperationKind(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.OperationDefinition.OperationKind> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationKind> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationKindEnumFactory());
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.OperationDefinition.OperationKind> convertOperationKind(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationKind> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.OperationDefinition.OperationKind> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.OperationDefinition.OperationKindEnumFactory());
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case OPERATION:
        tgt.setValue(org.hl7.fhir.r5.model.OperationDefinition.OperationKind.OPERATION);
        break;
      case QUERY:
        tgt.setValue(org.hl7.fhir.r5.model.OperationDefinition.OperationKind.QUERY);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.OperationDefinition.OperationKind.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.OperationParameterUse> convertOperationParameterUse(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationParameterUse> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.OperationParameterUse> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.OperationParameterUseEnumFactory());
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case IN:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.OperationParameterUse.IN);
        break;
      case OUT:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.OperationParameterUse.OUT);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.OperationParameterUse.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationParameterUse> convertOperationParameterUse(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.OperationParameterUse> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationParameterUse> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationParameterUseEnumFactory());
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
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