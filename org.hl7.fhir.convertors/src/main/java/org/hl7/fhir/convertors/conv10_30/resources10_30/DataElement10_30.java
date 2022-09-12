package org.hl7.fhir.convertors.conv10_30.resources10_30;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.convertors.context.ConversionContext10_30;
import org.hl7.fhir.convertors.conv10_30.VersionConvertor_10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.ElementDefinition10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.CodeableConcept10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.ContactPoint10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Identifier10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.Boolean10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.DateTime10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.Id10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.String10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.Uri10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class DataElement10_30 {

  public static org.hl7.fhir.dstu2.model.DataElement convertDataElement(org.hl7.fhir.dstu3.model.DataElement src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.DataElement tgt = new org.hl7.fhir.dstu2.model.DataElement();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyDomainResource(src, tgt);
    if (src.hasUrlElement())
      tgt.setUrlElement(Uri10_30.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_30.convertIdentifier(t));
    if (src.hasVersionElement())
      tgt.setVersionElement(String10_30.convertString(src.getVersionElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations10_30.convertConformanceResourceStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean10_30.convertBoolean(src.getExperimentalElement()));
    if (src.hasPublisherElement())
      tgt.setPublisherElement(String10_30.convertString(src.getPublisherElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime10_30.convertDateTime(src.getDateElement()));
    if (src.hasNameElement())
      tgt.setNameElement(String10_30.convertString(src.getNameElement()));
    for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact())
      tgt.addContact(convertDataElementContactComponent(t));
    for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext())
      if (t.hasValueCodeableConcept())
        tgt.addUseContext(CodeableConcept10_30.convertCodeableConcept(t.getValueCodeableConcept()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction())
      tgt.addUseContext(CodeableConcept10_30.convertCodeableConcept(t));
    if (src.hasCopyright())
      tgt.setCopyright(src.getCopyright());
    if (src.hasStringency())
      tgt.setStringencyElement(convertDataElementStringency(src.getStringencyElement()));
    for (org.hl7.fhir.dstu3.model.DataElement.DataElementMappingComponent t : src.getMapping())
      tgt.addMapping(convertDataElementMappingComponent(t));
    for (org.hl7.fhir.dstu3.model.ElementDefinition t : src.getElement())
      tgt.addElement(ElementDefinition10_30.convertElementDefinition(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.DataElement convertDataElement(org.hl7.fhir.dstu2.model.DataElement src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.DataElement tgt = new org.hl7.fhir.dstu3.model.DataElement();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyDomainResource(src, tgt);
    if (src.hasUrlElement())
      tgt.setUrlElement(Uri10_30.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_30.convertIdentifier(t));
    if (src.hasVersionElement())
      tgt.setVersionElement(String10_30.convertString(src.getVersionElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations10_30.convertConformanceResourceStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean10_30.convertBoolean(src.getExperimentalElement()));
    if (src.hasPublisherElement())
      tgt.setPublisherElement(String10_30.convertString(src.getPublisherElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime10_30.convertDateTime(src.getDateElement()));
    if (src.hasNameElement())
      tgt.setNameElement(String10_30.convertString(src.getNameElement()));
    for (org.hl7.fhir.dstu2.model.DataElement.DataElementContactComponent t : src.getContact())
      tgt.addContact(convertDataElementContactComponent(t));
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getUseContext())
      if (VersionConvertor_10_30.isJurisdiction(t))
        tgt.addJurisdiction(CodeableConcept10_30.convertCodeableConcept(t));
      else
        tgt.addUseContext(CodeableConcept10_30.convertCodeableConceptToUsageContext(t));
    if (src.hasCopyright())
      tgt.setCopyright(src.getCopyright());
    if (src.hasStringency())
      tgt.setStringencyElement(convertDataElementStringency(src.getStringencyElement()));
    for (org.hl7.fhir.dstu2.model.DataElement.DataElementMappingComponent t : src.getMapping())
      tgt.addMapping(convertDataElementMappingComponent(t));
    List<String> slicePaths = new ArrayList<String>();
    for (org.hl7.fhir.dstu2.model.ElementDefinition t : src.getElement()) {
      if (t.hasSlicing())
        slicePaths.add(t.getPath());
      tgt.addElement(ElementDefinition10_30.convertElementDefinition(t, slicePaths));
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.ContactDetail convertDataElementContactComponent(org.hl7.fhir.dstu2.model.DataElement.DataElementContactComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.ContactDetail tgt = new org.hl7.fhir.dstu3.model.ContactDetail();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.hasNameElement())
      tgt.setNameElement(String10_30.convertString(src.getNameElement()));
    for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint10_30.convertContactPoint(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.DataElement.DataElementContactComponent convertDataElementContactComponent(org.hl7.fhir.dstu3.model.ContactDetail src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.DataElement.DataElementContactComponent tgt = new org.hl7.fhir.dstu2.model.DataElement.DataElementContactComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.hasNameElement())
      tgt.setNameElement(String10_30.convertString(src.getNameElement()));
    for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint10_30.convertContactPoint(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.DataElement.DataElementMappingComponent convertDataElementMappingComponent(org.hl7.fhir.dstu2.model.DataElement.DataElementMappingComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.DataElement.DataElementMappingComponent tgt = new org.hl7.fhir.dstu3.model.DataElement.DataElementMappingComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyBackboneElement(src,tgt);
    if (src.hasIdentityElement())
      tgt.setIdentityElement(Id10_30.convertId(src.getIdentityElement()));
    if (src.hasUriElement())
      tgt.setUriElement(Uri10_30.convertUri(src.getUriElement()));
    if (src.hasNameElement())
      tgt.setNameElement(String10_30.convertString(src.getNameElement()));
    if (src.hasCommentsElement())
      tgt.setCommentElement(String10_30.convertString(src.getCommentsElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.DataElement.DataElementMappingComponent convertDataElementMappingComponent(org.hl7.fhir.dstu3.model.DataElement.DataElementMappingComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.DataElement.DataElementMappingComponent tgt = new org.hl7.fhir.dstu2.model.DataElement.DataElementMappingComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyBackboneElement(src,tgt);
    if (src.hasIdentityElement())
      tgt.setIdentityElement(Id10_30.convertId(src.getIdentityElement()));
    if (src.hasUriElement())
      tgt.setUriElement(Uri10_30.convertUri(src.getUriElement()));
    if (src.hasNameElement())
      tgt.setNameElement(String10_30.convertString(src.getNameElement()));
    if (src.hasCommentElement())
      tgt.setCommentsElement(String10_30.convertString(src.getCommentElement()));
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.DataElement.DataElementStringency> convertDataElementStringency(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.DataElement.DataElementStringency> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.DataElement.DataElementStringency> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.DataElement.DataElementStringencyEnumFactory());
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    switch (src.getValue()) {
      case COMPARABLE:
        tgt.setValue(org.hl7.fhir.dstu2.model.DataElement.DataElementStringency.COMPARABLE);
        break;
      case FULLYSPECIFIED:
        tgt.setValue(org.hl7.fhir.dstu2.model.DataElement.DataElementStringency.FULLYSPECIFIED);
        break;
      case EQUIVALENT:
        tgt.setValue(org.hl7.fhir.dstu2.model.DataElement.DataElementStringency.EQUIVALENT);
        break;
      case CONVERTABLE:
        tgt.setValue(org.hl7.fhir.dstu2.model.DataElement.DataElementStringency.CONVERTABLE);
        break;
      case SCALEABLE:
        tgt.setValue(org.hl7.fhir.dstu2.model.DataElement.DataElementStringency.SCALEABLE);
        break;
      case FLEXIBLE:
        tgt.setValue(org.hl7.fhir.dstu2.model.DataElement.DataElementStringency.FLEXIBLE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.DataElement.DataElementStringency.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.DataElement.DataElementStringency> convertDataElementStringency(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.DataElement.DataElementStringency> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.DataElement.DataElementStringency> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.DataElement.DataElementStringencyEnumFactory());
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    switch (src.getValue()) {
      case COMPARABLE:
        tgt.setValue(org.hl7.fhir.dstu3.model.DataElement.DataElementStringency.COMPARABLE);
        break;
      case FULLYSPECIFIED:
        tgt.setValue(org.hl7.fhir.dstu3.model.DataElement.DataElementStringency.FULLYSPECIFIED);
        break;
      case EQUIVALENT:
        tgt.setValue(org.hl7.fhir.dstu3.model.DataElement.DataElementStringency.EQUIVALENT);
        break;
      case CONVERTABLE:
        tgt.setValue(org.hl7.fhir.dstu3.model.DataElement.DataElementStringency.CONVERTABLE);
        break;
      case SCALEABLE:
        tgt.setValue(org.hl7.fhir.dstu3.model.DataElement.DataElementStringency.SCALEABLE);
        break;
      case FLEXIBLE:
        tgt.setValue(org.hl7.fhir.dstu3.model.DataElement.DataElementStringency.FLEXIBLE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.DataElement.DataElementStringency.NULL);
        break;
    }
    return tgt;
  }
}