package org.hl7.fhir.convertors.conv14_50.resources14_50;

import org.hl7.fhir.convertors.context.ConversionContext14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.ElementDefinition14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.complextypes14_50.CodeableConcept14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.complextypes14_50.ContactPoint14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.complextypes14_50.Identifier14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.*;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;

public class DataElement14_50 {

  public static org.hl7.fhir.r5.model.StructureDefinition convertDataElement(org.hl7.fhir.dstu2016may.model.DataElement src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.StructureDefinition tgt = new org.hl7.fhir.r5.model.StructureDefinition();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri14_50.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.dstu2016may.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier14_50.convertIdentifier(t));
    if (src.hasVersion())
      tgt.setVersionElement(String14_50.convertString(src.getVersionElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations14_50.convertConformanceResourceStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean14_50.convertBoolean(src.getExperimentalElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String14_50.convertString(src.getPublisherElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime14_50.convertDateTime(src.getDateElement()));
    if (src.hasName())
      tgt.setNameElement(String14_50.convertString(src.getNameElement()));
    for (org.hl7.fhir.dstu2016may.model.DataElement.DataElementContactComponent t : src.getContact())
      tgt.addContact(convertDataElementContactComponent(t));
    for (org.hl7.fhir.dstu2016may.model.CodeableConcept t : src.getUseContext())
      if (CodeableConcept14_50.isJurisdiction(t))
        tgt.addJurisdiction(CodeableConcept14_50.convertCodeableConcept(t));
      else
        tgt.addUseContext(CodeableConcept14_50.convertCodeableConceptToUsageContext(t));
    if (src.hasCopyright())
      tgt.setCopyright(src.getCopyright());
    for (org.hl7.fhir.dstu2016may.model.DataElement.DataElementMappingComponent t : src.getMapping())
      tgt.addMapping(convertDataElementMappingComponent(t));
    for (org.hl7.fhir.dstu2016may.model.ElementDefinition t : src.getElement())
      tgt.getSnapshot().addElement(ElementDefinition14_50.convertElementDefinition(t, src.getElement(), src.getElement().indexOf(t)));
    tgt.setKind(StructureDefinitionKind.COMPLEXTYPE);
    tgt.setAbstract(false);
    tgt.setType(tgt.getName());
    tgt.setBaseDefinition("http://hl7.org/fhir/StructureDefinition/Element");
    tgt.setDerivation(org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule.SPECIALIZATION);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ContactDetail convertDataElementContactComponent(org.hl7.fhir.dstu2016may.model.DataElement.DataElementContactComponent src) throws FHIRException {
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

  public static org.hl7.fhir.dstu2016may.model.DataElement.DataElementContactComponent convertDataElementContactComponent(org.hl7.fhir.r5.model.ContactDetail src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.DataElement.DataElementContactComponent tgt = new org.hl7.fhir.dstu2016may.model.DataElement.DataElementContactComponent();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String14_50.convertString(src.getNameElement()));
    for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint14_50.convertContactPoint(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionMappingComponent convertDataElementMappingComponent(org.hl7.fhir.dstu2016may.model.DataElement.DataElementMappingComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionMappingComponent tgt = new org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionMappingComponent();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    if (src.hasIdentityElement())
      tgt.setIdentityElement(Id14_50.convertId(src.getIdentityElement()));
    if (src.hasUri())
      tgt.setUriElement(Uri14_50.convertUri(src.getUriElement()));
    if (src.hasName())
      tgt.setNameElement(String14_50.convertString(src.getNameElement()));
    if (src.hasComment())
      tgt.setCommentElement(String14_50.convertString(src.getCommentElement()));
    return tgt;
  }
}