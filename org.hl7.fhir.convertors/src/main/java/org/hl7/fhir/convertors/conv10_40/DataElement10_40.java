package org.hl7.fhir.convertors.conv10_40;

import org.hl7.fhir.convertors.VersionConvertor_10_40;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.*;
import org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r4.model.StructureDefinition.TypeDerivationRule;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class DataElement10_40 {

    public static org.hl7.fhir.r4.model.StructureDefinition convertDataElement(org.hl7.fhir.dstu2.model.DataElement src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.StructureDefinition tgt = new org.hl7.fhir.r4.model.StructureDefinition();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrl(src.getUrl().replace("/DataElement/", "/StructureDefinition/de-"));
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_40.convertIdentifier(t));
        }
        if (src.hasVersionElement()) {
            tgt.setVersionElement((StringType) VersionConvertor_10_40.convertType(src.getVersionElement()));
        }
        if (src.hasStatus()) {
            tgt.setStatus(VersionConvertor_10_40.convertConformanceResourceStatus(src.getStatus()));
        }
        if (src.hasExperimentalElement())
            tgt.setExperimentalElement((BooleanType) VersionConvertor_10_40.convertType(src.getExperimentalElement()));
        if (src.hasPublisherElement()) {
            tgt.setPublisherElement((StringType) VersionConvertor_10_40.convertType(src.getPublisherElement()));
        }
        if (src.hasDateElement())
            tgt.setDateElement((DateTimeType) VersionConvertor_10_40.convertType(src.getDateElement()));
        if (src.hasNameElement()) {
            tgt.setNameElement((StringType) VersionConvertor_10_40.convertType(src.getNameElement()));
        }
        if (src.hasContact()) {
            for (org.hl7.fhir.dstu2.model.DataElement.DataElementContactComponent t : src.getContact()) tgt.addContact(convertDataElementContactComponent(t));
        }
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getUseContext()) if (VersionConvertor_10_40.isJurisdiction(t))
            tgt.addJurisdiction(VersionConvertor_10_40.convertCodeableConcept(t));
        else
            tgt.addUseContext(VersionConvertor_10_40.convertCodeableConceptToUsageContext(t));
        if (src.hasCopyright()) {
            tgt.setCopyright(src.getCopyright());
        }
        if (src.hasMapping()) {
            for (org.hl7.fhir.dstu2.model.DataElement.DataElementMappingComponent t : src.getMapping()) tgt.addMapping(convertDataElementMappingComponent(t));
        }
        List<String> slicePaths = new ArrayList<String>();
        for (org.hl7.fhir.dstu2.model.ElementDefinition t : src.getElement()) {
            if (t.hasSlicing())
                slicePaths.add(t.getPath());
            if (src.hasElement()) {
                tgt.getSnapshot().addElement(VersionConvertor_10_40.convertElementDefinition(t, slicePaths, src.getElement(), src.getElement().indexOf(t)));
            }
        }
        tgt.setKind(StructureDefinitionKind.COMPLEXTYPE);
        tgt.setAbstract(false);
        tgt.setType(tgt.getName());
        tgt.setBaseDefinition("http://hl7.org/fhir/StructureDefinition/Element");
        tgt.setDerivation(TypeDerivationRule.SPECIALIZATION);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.DataElement.DataElementContactComponent convertDataElementContactComponent(org.hl7.fhir.r4.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.DataElement.DataElementContactComponent tgt = new org.hl7.fhir.dstu2.model.DataElement.DataElementContactComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasNameElement()) {
            tgt.setNameElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_40.convertType(src.getNameElement()));
        }
        if (src.hasTelecom()) {
            for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_40.convertContactPoint(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ContactDetail convertDataElementContactComponent(org.hl7.fhir.dstu2.model.DataElement.DataElementContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ContactDetail tgt = new org.hl7.fhir.r4.model.ContactDetail();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasNameElement()) {
            tgt.setNameElement((StringType) VersionConvertor_10_40.convertType(src.getNameElement()));
        }
        if (src.hasTelecom()) {
            for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_40.convertContactPoint(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionMappingComponent convertDataElementMappingComponent(org.hl7.fhir.dstu2.model.DataElement.DataElementMappingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionMappingComponent tgt = new org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionMappingComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasIdentityElement()) {
            tgt.setIdentityElement((IdType) VersionConvertor_10_40.convertType(src.getIdentityElement()));
        }
        if (src.hasUriElement()) {
            tgt.setUriElement((UriType) VersionConvertor_10_40.convertType(src.getUriElement()));
        }
        if (src.hasNameElement()) {
            tgt.setNameElement((StringType) VersionConvertor_10_40.convertType(src.getNameElement()));
        }
        if (src.hasCommentsElement()) {
            tgt.setCommentElement((StringType) VersionConvertor_10_40.convertType(src.getCommentsElement()));
        }
        return tgt;
    }
}
