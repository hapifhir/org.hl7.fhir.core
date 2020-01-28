package org.hl7.fhir.convertors.conv14_40;

import org.hl7.fhir.convertors.VersionConvertor_14_40;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionKind;

public class DataElement14_40 {

    public static org.hl7.fhir.r4.model.StructureDefinition convertDataElement(org.hl7.fhir.dstu2016may.model.DataElement src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.StructureDefinition tgt = new org.hl7.fhir.r4.model.StructureDefinition();
        VersionConvertor_14_40.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrl(src.getUrl());
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu2016may.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_14_40.convertIdentifier(t));
        }
        if (src.hasVersion())
            tgt.setVersion(src.getVersion());
        if (src.hasStatus()) {
            tgt.setStatus(VersionConvertor_14_40.convertConformanceResourceStatus(src.getStatus()));
        }
        if (src.hasExperimental())
            tgt.setExperimental(src.getExperimental());
        if (src.hasPublisher())
            tgt.setPublisher(src.getPublisher());
        if (src.hasDate())
            tgt.setDate(src.getDate());
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasContact()) {
            for (org.hl7.fhir.dstu2016may.model.DataElement.DataElementContactComponent t : src.getContact()) tgt.addContact(convertDataElementContactComponent(t));
        }
        for (org.hl7.fhir.dstu2016may.model.CodeableConcept t : src.getUseContext()) if (VersionConvertor_14_40.isJurisdiction(t))
            tgt.addJurisdiction(VersionConvertor_14_40.convertCodeableConcept(t));
        else
            tgt.addUseContext(VersionConvertor_14_40.convertCodeableConceptToUsageContext(t));
        if (src.hasCopyright())
            tgt.setCopyright(src.getCopyright());
        if (src.hasMapping()) {
            for (org.hl7.fhir.dstu2016may.model.DataElement.DataElementMappingComponent t : src.getMapping()) tgt.addMapping(convertDataElementMappingComponent(t));
        }
        for (org.hl7.fhir.dstu2016may.model.ElementDefinition t : src.getElement()) if (src.hasElement()) {
            tgt.getSnapshot().addElement(VersionConvertor_14_40.convertElementDefinition(t, src.getElement(), src.getElement().indexOf(t)));
        }
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
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasTelecom()) {
            for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_14_40.convertContactPoint(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ContactDetail convertDataElementContactComponent(org.hl7.fhir.dstu2016may.model.DataElement.DataElementContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ContactDetail tgt = new org.hl7.fhir.r4.model.ContactDetail();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasTelecom()) {
            for (org.hl7.fhir.dstu2016may.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_14_40.convertContactPoint(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionMappingComponent convertDataElementMappingComponent(org.hl7.fhir.dstu2016may.model.DataElement.DataElementMappingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionMappingComponent tgt = new org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionMappingComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasIdentity()) {
            tgt.setIdentity(src.getIdentity());
        }
        if (src.hasUri())
            tgt.setUri(src.getUri());
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasComment())
            tgt.setComment(src.getComment());
        return tgt;
    }
}
