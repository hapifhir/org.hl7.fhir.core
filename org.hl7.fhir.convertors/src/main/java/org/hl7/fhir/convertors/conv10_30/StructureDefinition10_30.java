package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.dstu2.model.BooleanType;
import org.hl7.fhir.dstu2.model.StringType;
import org.hl7.fhir.dstu2.model.UriType;
import org.hl7.fhir.dstu3.model.MarkdownType;
import org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.dstu3.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.Utilities;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class StructureDefinition10_30 {

    public static org.hl7.fhir.dstu3.model.StructureDefinition.ExtensionContext convertExtensionContext(org.hl7.fhir.dstu2.model.StructureDefinition.ExtensionContext src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case RESOURCE:
                return org.hl7.fhir.dstu3.model.StructureDefinition.ExtensionContext.RESOURCE;
            case DATATYPE:
                return org.hl7.fhir.dstu3.model.StructureDefinition.ExtensionContext.DATATYPE;
            case EXTENSION:
                return org.hl7.fhir.dstu3.model.StructureDefinition.ExtensionContext.EXTENSION;
            default:
                return org.hl7.fhir.dstu3.model.StructureDefinition.ExtensionContext.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.StructureDefinition.ExtensionContext convertExtensionContext(org.hl7.fhir.dstu3.model.StructureDefinition.ExtensionContext src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case RESOURCE:
                return org.hl7.fhir.dstu2.model.StructureDefinition.ExtensionContext.RESOURCE;
            case DATATYPE:
                return org.hl7.fhir.dstu2.model.StructureDefinition.ExtensionContext.DATATYPE;
            case EXTENSION:
                return org.hl7.fhir.dstu2.model.StructureDefinition.ExtensionContext.EXTENSION;
            default:
                return org.hl7.fhir.dstu2.model.StructureDefinition.ExtensionContext.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.StructureDefinition convertStructureDefinition(org.hl7.fhir.dstu3.model.StructureDefinition src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.StructureDefinition tgt = new org.hl7.fhir.dstu2.model.StructureDefinition();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.dstu2.model.UriType) VersionConvertor_10_30.convertType(src.getUrlElement()));
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        }
        if (src.hasVersionElement())
            tgt.setVersionElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_30.convertType(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_30.convertType(src.getNameElement()));
        if (src.hasTitleElement()) {
            tgt.setDisplayElement((StringType) VersionConvertor_10_30.convertType(src.getTitleElement()));
        }
        if (src.hasStatus()) {
            tgt.setStatus(VersionConvertor_10_30.convertConformanceResourceStatus(src.getStatus()));
        }
        if (src.hasExperimentalElement())
            tgt.setExperimentalElement((BooleanType) VersionConvertor_10_30.convertType(src.getExperimentalElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_30.convertType(src.getPublisherElement()));
        if (src.hasContact()) {
            for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(convertStructureDefinitionContactComponent(t));
        }
        if (src.hasDateElement())
            tgt.setDateElement((org.hl7.fhir.dstu2.model.DateTimeType) VersionConvertor_10_30.convertType(src.getDateElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_30.convertType(src.getDescriptionElement()));
        for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext()) if (t.hasValueCodeableConcept())
            tgt.addUseContext(VersionConvertor_10_30.convertCodeableConcept(t.getValueCodeableConcept()));
        if (src.hasJurisdiction()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addUseContext(VersionConvertor_10_30.convertCodeableConcept(t));
        }
        if (src.hasPurposeElement()) {
            tgt.setRequirementsElement((StringType) VersionConvertor_10_30.convertType(src.getPurposeElement()));
        }
        if (src.hasCopyrightElement())
            tgt.setCopyrightElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_30.convertType(src.getCopyrightElement()));
        if (src.hasKeyword()) {
            for (org.hl7.fhir.dstu3.model.Coding t : src.getKeyword()) tgt.addCode(VersionConvertor_10_30.convertCoding(t));
        }
        if (src.hasFhirVersionElement())
            tgt.setFhirVersionElement((org.hl7.fhir.dstu2.model.IdType) VersionConvertor_10_30.convertType(src.getFhirVersionElement()));
        if (src.hasMapping()) {
            for (org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionMappingComponent t : src.getMapping()) tgt.addMapping(convertStructureDefinitionMappingComponent(t));
        }
        if (src.hasKind()) {
            tgt.setKind(convertStructureDefinitionKind(src.getKind()));
        }
        if (src.hasAbstractElement()) {
            tgt.setAbstractElement((BooleanType) VersionConvertor_10_30.convertType(src.getAbstractElement()));
        }
        if (src.hasContextType()) {
            tgt.setContextType(convertExtensionContext(src.getContextType()));
        }
        if (src.hasContext()) {
            for (org.hl7.fhir.dstu3.model.StringType t : src.getContext()) tgt.addContext(t.getValue());
        }
        if (src.hasType()) {
            tgt.setConstrainedType(src.getType());
        }
        if (src.hasBaseDefinitionElement()) {
            tgt.setBaseElement((UriType) VersionConvertor_10_30.convertType(src.getBaseDefinitionElement()));
        }
        if (src.hasSnapshot()) {
            tgt.setSnapshot(convertStructureDefinitionSnapshotComponent(src.getSnapshot()));
        }
        if (src.hasDifferential()) {
            tgt.setDifferential(convertStructureDefinitionDifferentialComponent(src.getDifferential()));
        }
        if (tgt.hasBase()) {
            if (tgt.hasDifferential())
                tgt.getDifferential().getElement().get(0).addType().setCode(tail(tgt.getBase()));
            if (tgt.hasSnapshot())
                tgt.getSnapshot().getElement().get(0).addType().setCode(tail(tgt.getBase()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.StructureDefinition convertStructureDefinition(org.hl7.fhir.dstu2.model.StructureDefinition src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.StructureDefinition tgt = new org.hl7.fhir.dstu3.model.StructureDefinition();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.dstu3.model.UriType) VersionConvertor_10_30.convertType(src.getUrlElement()));
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        }
        if (src.hasVersionElement())
            tgt.setVersionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_10_30.convertType(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_10_30.convertType(src.getNameElement()));
        if (src.hasDisplayElement()) {
            tgt.setTitleElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_10_30.convertType(src.getDisplayElement()));
        }
        if (src.hasStatus()) {
            tgt.setStatus(VersionConvertor_10_30.convertConformanceResourceStatus(src.getStatus()));
        }
        if (src.hasExperimentalElement())
            tgt.setExperimentalElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_10_30.convertType(src.getExperimentalElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_10_30.convertType(src.getPublisherElement()));
        if (src.hasContact()) {
            for (org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionContactComponent t : src.getContact()) tgt.addContact(convertStructureDefinitionContactComponent(t));
        }
        if (src.hasDateElement())
            tgt.setDateElement((org.hl7.fhir.dstu3.model.DateTimeType) VersionConvertor_10_30.convertType(src.getDateElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu3.model.MarkdownType) VersionConvertor_10_30.convertType(src.getDescriptionElement()));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getUseContext()) if (VersionConvertor_10_30.isJurisdiction(t))
            tgt.addJurisdiction(VersionConvertor_10_30.convertCodeableConcept(t));
        else
            tgt.addUseContext(VersionConvertor_10_30.convertCodeableConceptToUsageContext(t));
        if (src.hasRequirementsElement()) {
            tgt.setPurposeElement((MarkdownType) VersionConvertor_10_30.convertType(src.getRequirementsElement()));
        }
        if (src.hasCopyrightElement())
            tgt.setCopyrightElement((org.hl7.fhir.dstu3.model.MarkdownType) VersionConvertor_10_30.convertType(src.getCopyrightElement()));
        if (src.hasCode()) {
            for (org.hl7.fhir.dstu2.model.Coding t : src.getCode()) tgt.addKeyword(VersionConvertor_10_30.convertCoding(t));
        }
        if (src.hasFhirVersionElement())
            tgt.setFhirVersionElement((org.hl7.fhir.dstu3.model.IdType) VersionConvertor_10_30.convertType(src.getFhirVersionElement()));
        if (src.hasMapping()) {
            for (org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionMappingComponent t : src.getMapping()) tgt.addMapping(convertStructureDefinitionMappingComponent(t));
        }
        if (src.hasKind()) {
            tgt.setKind(convertStructureDefinitionKind(src.getKind(), tgt.getId()));
        }
        if (src.hasAbstractElement()) {
            tgt.setAbstractElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_10_30.convertType(src.getAbstractElement()));
        }
        if (src.hasContextType()) {
            tgt.setContextType(convertExtensionContext(src.getContextType()));
        }
        if (src.hasContext()) {
            for (org.hl7.fhir.dstu2.model.StringType t : src.getContext()) tgt.addContext(t.getValue());
        }
        if (src.hasConstrainedType())
            tgt.setType(src.getConstrainedType());
        else if (src.getSnapshot().hasElement())
            tgt.setType(src.getSnapshot().getElement().get(0).getPath());
        else if (src.getDifferential().hasElement() && !src.getDifferential().getElement().get(0).getPath().contains("."))
            tgt.setType(src.getDifferential().getElement().get(0).getPath());
        else
            tgt.setType(src.getDifferential().getElement().get(0).getPath().substring(0, src.getDifferential().getElement().get(0).getPath().indexOf(".")));
        if (src.hasBase()) {
            tgt.setBaseDefinition(src.getBase());
        }
        tgt.setDerivation(src.hasConstrainedType() ? org.hl7.fhir.dstu3.model.StructureDefinition.TypeDerivationRule.CONSTRAINT : org.hl7.fhir.dstu3.model.StructureDefinition.TypeDerivationRule.SPECIALIZATION);
        if (src.hasSnapshot()) {
            tgt.setSnapshot(convertStructureDefinitionSnapshotComponent(src.getSnapshot()));
        }
        if (src.hasDifferential()) {
            tgt.setDifferential(convertStructureDefinitionDifferentialComponent(src.getDifferential()));
        }
        if (tgt.hasSnapshot())
            tgt.getSnapshot().getElementFirstRep().getType().clear();
        if (tgt.hasDifferential())
            tgt.getDifferential().getElementFirstRep().getType().clear();
        if (tgt.getKind() == StructureDefinitionKind.PRIMITIVETYPE && !tgt.getType().equals(tgt.getId())) {
            tgt.setDerivation(TypeDerivationRule.SPECIALIZATION);
            tgt.setBaseDefinition("http://hl7.org/fhir/StructureDefinition/" + tgt.getType());
            tgt.setType(tgt.getId());
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionContactComponent convertStructureDefinitionContactComponent(org.hl7.fhir.dstu3.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionContactComponent tgt = new org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionContactComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_30.convertType(src.getNameElement()));
        if (src.hasTelecom()) {
            for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_30.convertContactPoint(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ContactDetail convertStructureDefinitionContactComponent(org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ContactDetail tgt = new org.hl7.fhir.dstu3.model.ContactDetail();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_10_30.convertType(src.getNameElement()));
        if (src.hasTelecom()) {
            for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_30.convertContactPoint(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionDifferentialComponent convertStructureDefinitionDifferentialComponent(org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionDifferentialComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionDifferentialComponent tgt = new org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionDifferentialComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasElement()) {
            for (org.hl7.fhir.dstu3.model.ElementDefinition t : src.getElement()) tgt.addElement(VersionConvertor_10_30.convertElementDefinition(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionDifferentialComponent convertStructureDefinitionDifferentialComponent(org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionDifferentialComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionDifferentialComponent tgt = new org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionDifferentialComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        List<String> slicePaths = new ArrayList<String>();
        for (org.hl7.fhir.dstu2.model.ElementDefinition t : src.getElement()) {
            if (t.hasSlicing())
                slicePaths.add(t.getPath());
            tgt.addElement(VersionConvertor_10_30.convertElementDefinition(t, slicePaths));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionKind convertStructureDefinitionKind(org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionKind src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PRIMITIVETYPE:
                return org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionKind.DATATYPE;
            case COMPLEXTYPE:
                return org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionKind.DATATYPE;
            case RESOURCE:
                return org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionKind.RESOURCE;
            case LOGICAL:
                return org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionKind.LOGICAL;
            default:
                return org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionKind.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionKind convertStructureDefinitionKind(org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionKind src, String dtName) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case DATATYPE:
                if (Utilities.existsInList(dtName, "boolean", "integer", "decimal", "base64Binary", "instant", "string", "uri", "date", "dateTime", "time", "code", "oid", "uuid", "id", "unsignedInt", "positiveInt", "markdown", "xhtml", "url", "canonical"))
                    return org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionKind.PRIMITIVETYPE;
                else
                    return org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionKind.COMPLEXTYPE;
            case RESOURCE:
                return org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionKind.RESOURCE;
            case LOGICAL:
                return org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionKind.LOGICAL;
            default:
                return org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionKind.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionMappingComponent convertStructureDefinitionMappingComponent(org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionMappingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionMappingComponent tgt = new org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionMappingComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasIdentityElement())
            tgt.setIdentityElement((org.hl7.fhir.dstu2.model.IdType) VersionConvertor_10_30.convertType(src.getIdentityElement()));
        if (src.hasUriElement())
            tgt.setUriElement((org.hl7.fhir.dstu2.model.UriType) VersionConvertor_10_30.convertType(src.getUriElement()));
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_30.convertType(src.getNameElement()));
        if (src.hasCommentElement()) {
            tgt.setCommentsElement((StringType) VersionConvertor_10_30.convertType(src.getCommentElement()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionMappingComponent convertStructureDefinitionMappingComponent(org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionMappingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionMappingComponent tgt = new org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionMappingComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasIdentityElement())
            tgt.setIdentityElement((org.hl7.fhir.dstu3.model.IdType) VersionConvertor_10_30.convertType(src.getIdentityElement()));
        if (src.hasUriElement())
            tgt.setUriElement((org.hl7.fhir.dstu3.model.UriType) VersionConvertor_10_30.convertType(src.getUriElement()));
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_10_30.convertType(src.getNameElement()));
        if (src.hasCommentsElement()) {
            tgt.setCommentElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_10_30.convertType(src.getCommentsElement()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionSnapshotComponent convertStructureDefinitionSnapshotComponent(org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionSnapshotComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionSnapshotComponent tgt = new org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionSnapshotComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasElement()) {
            for (org.hl7.fhir.dstu3.model.ElementDefinition t : src.getElement()) tgt.addElement(VersionConvertor_10_30.convertElementDefinition(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionSnapshotComponent convertStructureDefinitionSnapshotComponent(org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionSnapshotComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionSnapshotComponent tgt = new org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionSnapshotComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        List<String> slicePaths = new ArrayList<String>();
        for (org.hl7.fhir.dstu2.model.ElementDefinition t : src.getElement()) {
            if (t.hasSlicing())
                slicePaths.add(t.getPath());
            tgt.addElement(VersionConvertor_10_30.convertElementDefinition(t, slicePaths));
        }
        return tgt;
    }

    static public String tail(String base) {
        return base.substring(base.lastIndexOf("/") + 1);
    }
}
