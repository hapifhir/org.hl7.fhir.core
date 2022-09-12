package org.hl7.fhir.convertors.conv14_40.resources14_40;

import org.hl7.fhir.convertors.context.ConversionContext14_40;
import org.hl7.fhir.convertors.conv14_40.VersionConvertor_14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.ElementDefinition14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.complextypes14_40.CodeableConcept14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.complextypes14_40.ContactPoint14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.complextypes14_40.Identifier14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.Boolean14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.DateTime14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.Id14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.String14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.Uri14_40;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionKind;

public class DataElement14_40 {

  public static org.hl7.fhir.r4.model.StructureDefinition convertDataElement(org.hl7.fhir.dstu2016may.model.DataElement src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.StructureDefinition tgt = new org.hl7.fhir.r4.model.StructureDefinition();
    ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri14_40.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.dstu2016may.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier14_40.convertIdentifier(t));
    if (src.hasVersion())
      tgt.setVersionElement(String14_40.convertString(src.getVersionElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations14_40.convertConformanceResourceStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean14_40.convertBoolean(src.getExperimentalElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String14_40.convertString(src.getPublisherElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime14_40.convertDateTime(src.getDateElement()));
    if (src.hasName())
      tgt.setNameElement(String14_40.convertString(src.getNameElement()));
    for (org.hl7.fhir.dstu2016may.model.DataElement.DataElementContactComponent t : src.getContact())
      tgt.addContact(convertDataElementContactComponent(t));
    for (org.hl7.fhir.dstu2016may.model.CodeableConcept t : src.getUseContext())
      if (VersionConvertor_14_40.isJurisdiction(t))
        tgt.addJurisdiction(CodeableConcept14_40.convertCodeableConcept(t));
      else
        tgt.addUseContext(CodeableConcept14_40.convertCodeableConceptToUsageContext(t));
    if (src.hasCopyright())
      tgt.setCopyright(src.getCopyright());
    for (org.hl7.fhir.dstu2016may.model.DataElement.DataElementMappingComponent t : src.getMapping())
      tgt.addMapping(convertDataElementMappingComponent(t));
    for (org.hl7.fhir.dstu2016may.model.ElementDefinition t : src.getElement())
      tgt.getSnapshot().addElement(ElementDefinition14_40.convertElementDefinition(t, src.getElement(), src.getElement().indexOf(t)));
    tgt.setKind(StructureDefinitionKind.COMPLEXTYPE);
    tgt.setAbstract(false);
    tgt.setType(tgt.getName());
    tgt.setBaseDefinition("http://hl7.org/fhir/StructureDefinition/Element");
    tgt.setDerivation(org.hl7.fhir.r4.model.StructureDefinition.TypeDerivationRule.SPECIALIZATION);
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.DataElement.DataElementContactComponent convertDataElementContactComponent(org.hl7.fhir.r4.model.ContactDetail src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.DataElement.DataElementContactComponent tgt = new org.hl7.fhir.dstu2016may.model.DataElement.DataElementContactComponent();
    ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String14_40.convertString(src.getNameElement()));
    for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint14_40.convertContactPoint(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ContactDetail convertDataElementContactComponent(org.hl7.fhir.dstu2016may.model.DataElement.DataElementContactComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.ContactDetail tgt = new org.hl7.fhir.r4.model.ContactDetail();
    ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String14_40.convertString(src.getNameElement()));
    for (org.hl7.fhir.dstu2016may.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint14_40.convertContactPoint(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionMappingComponent convertDataElementMappingComponent(org.hl7.fhir.dstu2016may.model.DataElement.DataElementMappingComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionMappingComponent tgt = new org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionMappingComponent();
    ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyBackboneElement(src,tgt);
    if (src.hasIdentityElement())
      tgt.setIdentityElement(Id14_40.convertId(src.getIdentityElement()));
    if (src.hasUri())
      tgt.setUriElement(Uri14_40.convertUri(src.getUriElement()));
    if (src.hasName())
      tgt.setNameElement(String14_40.convertString(src.getNameElement()));
    if (src.hasComment())
      tgt.setCommentElement(String14_40.convertString(src.getCommentElement()));
    return tgt;
  }
}