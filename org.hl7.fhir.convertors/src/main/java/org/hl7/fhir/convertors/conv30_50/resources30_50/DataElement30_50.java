package org.hl7.fhir.convertors.conv30_50.resources30_50;

import org.hl7.fhir.convertors.conv30_50.VersionConvertor_30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Element30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.CodeableConcept30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Identifier30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.ContactDetail30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.UsageContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.*;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.ElementDefinition30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class DataElement30_50 {

    public static org.hl7.fhir.r5.model.StructureDefinition convertDataElement(org.hl7.fhir.dstu3.model.DataElement src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.StructureDefinition tgt = new org.hl7.fhir.r5.model.StructureDefinition();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrl(src.getUrl().replace("/DataElement/", "/StructureDefinition/de-"));
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
        if (src.hasVersion())
            tgt.setVersionElement(String30_50.convertString(src.getVersionElement()));
        if (src.hasStatus())
            tgt.setStatusElement(Enumerations30_50.convertPublicationStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(Boolean30_50.convertBoolean(src.getExperimentalElement()));
        if (src.hasDate())
            tgt.setDateElement(DateTime30_50.convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(String30_50.convertString(src.getPublisherElement()));
        if (src.hasName())
            tgt.setNameElement(String30_50.convertString(src.getNameElement()));
        if (src.hasTitle())
            tgt.setTitleElement(String30_50.convertString(src.getTitleElement()));
        for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(ContactDetail30_50.convertContactDetail(t));
        for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext()) tgt.addUseContext(UsageContext30_50.convertUsageContext(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(CodeableConcept30_50.convertCodeableConcept(t));
        if (src.hasCopyright())
            tgt.setCopyrightElement(MarkDown30_50.convertMarkdown(src.getCopyrightElement()));
        for (org.hl7.fhir.dstu3.model.DataElement.DataElementMappingComponent t : src.getMapping()) tgt.addMapping(convertDataElementMappingComponent(t));
        for (org.hl7.fhir.dstu3.model.ElementDefinition t : src.getElement()) tgt.getSnapshot().addElement(ElementDefinition30_50.convertElementDefinition(t));
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
        Element30_50.copyElement(src, tgt);
        if (src.hasIdentity())
            tgt.setIdentityElement(Id30_50.convertId(src.getIdentityElement()));
        if (src.hasUri())
            tgt.setUriElement(Uri30_50.convertUri(src.getUriElement()));
        if (src.hasName())
            tgt.setNameElement(String30_50.convertString(src.getNameElement()));
        if (src.hasComment())
            tgt.setCommentElement(String30_50.convertString(src.getCommentElement()));
        return tgt;
    }
}