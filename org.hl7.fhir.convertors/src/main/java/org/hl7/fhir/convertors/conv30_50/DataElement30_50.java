package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.*;

import java.util.Collections;

public class DataElement30_50 {

    public static org.hl7.fhir.r5.model.StructureDefinition convertDataElement(org.hl7.fhir.dstu3.model.DataElement src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.StructureDefinition tgt = new org.hl7.fhir.r5.model.StructureDefinition();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrl(src.getUrl().replace("/DataElement/", "/StructureDefinition/de-"));
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        }
        if (src.hasVersionElement())
            tgt.setVersionElement((StringType) VersionConvertor_30_50.convertType(src.getVersionElement()));
        if (src.hasStatus())
            tgt.setStatus(VersionConvertor_30_50.convertPublicationStatus(src.getStatus()));
        if (src.hasExperimentalElement())
            tgt.setExperimentalElement((BooleanType) VersionConvertor_30_50.convertType(src.getExperimentalElement()));
        if (src.hasDateElement())
            tgt.setDateElement((DateTimeType) VersionConvertor_30_50.convertType(src.getDateElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement((StringType) VersionConvertor_30_50.convertType(src.getPublisherElement()));
        if (src.hasNameElement())
            tgt.setNameElement((StringType) VersionConvertor_30_50.convertType(src.getNameElement()));
        if (src.hasTitleElement())
            tgt.setTitleElement((StringType) VersionConvertor_30_50.convertType(src.getTitleElement()));
        if (src.hasContact()) {
            for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(VersionConvertor_30_50.convertContactDetail(t));
        }
        if (src.hasUseContext()) {
            for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_50.convertUsageContext(t));
        }
        if (src.hasJurisdiction()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_50.convertCodeableConcept(t));
        }
        if (src.hasCopyrightElement())
            tgt.setCopyrightElement((MarkdownType) VersionConvertor_30_50.convertType(src.getCopyrightElement()));
        if (src.hasMapping()) {
            for (org.hl7.fhir.dstu3.model.DataElement.DataElementMappingComponent t : src.getMapping()) tgt.addMapping(convertDataElementMappingComponent(t));
        }
        if (src.hasElement()) {
            for (org.hl7.fhir.dstu3.model.ElementDefinition t : src.getElement()) tgt.getSnapshot().addElement(VersionConvertor_30_50.convertElementDefinition(t));
        }
        tgt.setKind(org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind.COMPLEXTYPE);
        tgt.setAbstract(false);
        tgt.setType(tgt.getName());
        tgt.setBaseDefinition("http://hl7.org/fhir/StructureDefinition/Element");
        tgt.setDerivation(org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule.SPECIALIZATION);
        return tgt;
    }

    public static org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionMappingComponent convertDataElementMappingComponent(org.hl7.fhir.dstu3.model.DataElement.DataElementMappingComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionMappingComponent tgt = new org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionMappingComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasIdentityElement())
            tgt.setIdentityElement((IdType) VersionConvertor_30_50.convertType(src.getIdentityElement()));
        if (src.hasUriElement())
            tgt.setUriElement((UriType) VersionConvertor_30_50.convertType(src.getUriElement()));
        if (src.hasNameElement())
            tgt.setNameElement((StringType) VersionConvertor_30_50.convertType(src.getNameElement()));
        if (src.hasCommentElement())
            tgt.setCommentElement((StringType) VersionConvertor_30_50.convertType(src.getCommentElement()));
        return tgt;
    }
}
