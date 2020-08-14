package org.hl7.fhir.convertors.conv10_30;

import java.util.ArrayList;
import java.util.List;
import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.dstu3.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.Utilities;

public class StructureDefinition10_30 {

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.StructureDefinition.ExtensionContext> convertExtensionContext(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.StructureDefinition.ExtensionContext> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.StructureDefinition.ExtensionContext> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.StructureDefinition.ExtensionContextEnumFactory());
        VersionConvertor_10_30.copyElement(src, tgt);
        switch(src.getValue()) {
            case RESOURCE:
                tgt.setValue(org.hl7.fhir.dstu3.model.StructureDefinition.ExtensionContext.RESOURCE);
                break;
            case DATATYPE:
                tgt.setValue(org.hl7.fhir.dstu3.model.StructureDefinition.ExtensionContext.DATATYPE);
                break;
            case EXTENSION:
                tgt.setValue(org.hl7.fhir.dstu3.model.StructureDefinition.ExtensionContext.EXTENSION);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.StructureDefinition.ExtensionContext.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.StructureDefinition.ExtensionContext> convertExtensionContext(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.StructureDefinition.ExtensionContext> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.StructureDefinition.ExtensionContext> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.StructureDefinition.ExtensionContextEnumFactory());
        VersionConvertor_10_30.copyElement(src, tgt);
        switch(src.getValue()) {
            case RESOURCE:
                tgt.setValue(org.hl7.fhir.dstu2.model.StructureDefinition.ExtensionContext.RESOURCE);
                break;
            case DATATYPE:
                tgt.setValue(org.hl7.fhir.dstu2.model.StructureDefinition.ExtensionContext.DATATYPE);
                break;
            case EXTENSION:
                tgt.setValue(org.hl7.fhir.dstu2.model.StructureDefinition.ExtensionContext.EXTENSION);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.StructureDefinition.ExtensionContext.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.StructureDefinition convertStructureDefinition(org.hl7.fhir.dstu3.model.StructureDefinition src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.StructureDefinition tgt = new org.hl7.fhir.dstu2.model.StructureDefinition();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement(VersionConvertor_10_30.convertUri(src.getUrlElement()));
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        if (src.hasVersionElement())
            tgt.setVersionElement(VersionConvertor_10_30.convertString(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_30.convertString(src.getNameElement()));
        if (src.hasTitleElement())
            tgt.setDisplayElement(VersionConvertor_10_30.convertString(src.getTitleElement()));
        if (src.hasStatus())
            tgt.setStatusElement(VersionConvertor_10_30.convertConformanceResourceStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(VersionConvertor_10_30.convertBoolean(src.getExperimentalElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement(VersionConvertor_10_30.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(convertStructureDefinitionContactComponent(t));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_10_30.convertDateTime(src.getDateElement()));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext()) if (t.hasValueCodeableConcept())
            tgt.addUseContext(VersionConvertor_10_30.convertCodeableConcept(t.getValueCodeableConcept()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addUseContext(VersionConvertor_10_30.convertCodeableConcept(t));
        if (src.hasPurpose())
            tgt.setRequirements(src.getPurpose());
        if (src.hasCopyright())
            tgt.setCopyright(src.getCopyright());
        for (org.hl7.fhir.dstu3.model.Coding t : src.getKeyword()) tgt.addCode(VersionConvertor_10_30.convertCoding(t));
        if (src.hasFhirVersionElement())
            tgt.setFhirVersionElement(VersionConvertor_10_30.convertId(src.getFhirVersionElement()));
        for (org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionMappingComponent t : src.getMapping()) tgt.addMapping(convertStructureDefinitionMappingComponent(t));
        if (src.hasKind())
            tgt.setKindElement(convertStructureDefinitionKind(src.getKindElement()));
        if (src.hasAbstractElement())
            tgt.setAbstractElement(VersionConvertor_10_30.convertBoolean(src.getAbstractElement()));
        if (src.hasContextType())
            tgt.setContextTypeElement(convertExtensionContext(src.getContextTypeElement()));
        for (org.hl7.fhir.dstu3.model.StringType t : src.getContext()) tgt.addContext(t.getValue());
        if (src.hasTypeElement())
            tgt.setConstrainedTypeElement(VersionConvertor_10_30.convertCode(src.getTypeElement()));
        if (src.hasBaseDefinitionElement())
            tgt.setBaseElement(VersionConvertor_10_30.convertUri(src.getBaseDefinitionElement()));
        if (src.hasSnapshot())
            tgt.setSnapshot(convertStructureDefinitionSnapshotComponent(src.getSnapshot()));
        if (src.hasDifferential())
            tgt.setDifferential(convertStructureDefinitionDifferentialComponent(src.getDifferential()));
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
            tgt.setUrlElement(VersionConvertor_10_30.convertUri(src.getUrlElement()));
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        if (src.hasVersionElement())
            tgt.setVersionElement(VersionConvertor_10_30.convertString(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_30.convertString(src.getNameElement()));
        if (src.hasDisplayElement())
            tgt.setTitleElement(VersionConvertor_10_30.convertString(src.getDisplayElement()));
        if (src.hasStatus())
            tgt.setStatusElement(VersionConvertor_10_30.convertConformanceResourceStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(VersionConvertor_10_30.convertBoolean(src.getExperimentalElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement(VersionConvertor_10_30.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionContactComponent t : src.getContact()) tgt.addContact(convertStructureDefinitionContactComponent(t));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_10_30.convertDateTime(src.getDateElement()));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getUseContext()) if (VersionConvertor_10_30.isJurisdiction(t))
            tgt.addJurisdiction(VersionConvertor_10_30.convertCodeableConcept(t));
        else
            tgt.addUseContext(VersionConvertor_10_30.convertCodeableConceptToUsageContext(t));
        if (src.hasRequirements())
            tgt.setPurpose(src.getRequirements());
        if (src.hasCopyright())
            tgt.setCopyright(src.getCopyright());
        for (org.hl7.fhir.dstu2.model.Coding t : src.getCode()) tgt.addKeyword(VersionConvertor_10_30.convertCoding(t));
        if (src.hasFhirVersionElement())
            tgt.setFhirVersionElement(VersionConvertor_10_30.convertId(src.getFhirVersionElement()));
        for (org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionMappingComponent t : src.getMapping()) tgt.addMapping(convertStructureDefinitionMappingComponent(t));
        if (src.hasKind())
            tgt.setKindElement(convertStructureDefinitionKind(src.getKindElement(), tgt.getId()));
        if (src.hasAbstractElement())
            tgt.setAbstractElement(VersionConvertor_10_30.convertBoolean(src.getAbstractElement()));
        if (src.hasContextType())
            tgt.setContextTypeElement(convertExtensionContext(src.getContextTypeElement()));
        for (org.hl7.fhir.dstu2.model.StringType t : src.getContext()) tgt.addContext(t.getValue());
        if (src.hasConstrainedType())
            tgt.setTypeElement(VersionConvertor_10_30.convertCode(src.getConstrainedTypeElement()));
        else if (src.getSnapshot().hasElement())
            tgt.setType(src.getSnapshot().getElement().get(0).getPath());
        else if (src.getDifferential().hasElement() && !src.getDifferential().getElement().get(0).getPath().contains("."))
            tgt.setType(src.getDifferential().getElement().get(0).getPath());
        else
            tgt.setType(src.getDifferential().getElement().get(0).getPath().substring(0, src.getDifferential().getElement().get(0).getPath().indexOf(".")));
        if (src.hasBaseElement())
            tgt.setBaseDefinitionElement(VersionConvertor_10_30.convertUri(src.getBaseElement()));
        tgt.setDerivation(src.hasConstrainedType() ? org.hl7.fhir.dstu3.model.StructureDefinition.TypeDerivationRule.CONSTRAINT : org.hl7.fhir.dstu3.model.StructureDefinition.TypeDerivationRule.SPECIALIZATION);
        if (src.hasSnapshot())
            tgt.setSnapshot(convertStructureDefinitionSnapshotComponent(src.getSnapshot()));
        if (src.hasDifferential())
            tgt.setDifferential(convertStructureDefinitionDifferentialComponent(src.getDifferential()));
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
            tgt.setNameElement(VersionConvertor_10_30.convertString(src.getNameElement()));
        for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_30.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ContactDetail convertStructureDefinitionContactComponent(org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ContactDetail tgt = new org.hl7.fhir.dstu3.model.ContactDetail();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_30.convertString(src.getNameElement()));
        for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_30.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionDifferentialComponent convertStructureDefinitionDifferentialComponent(org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionDifferentialComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionDifferentialComponent tgt = new org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionDifferentialComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        for (org.hl7.fhir.dstu3.model.ElementDefinition t : src.getElement()) tgt.addElement(VersionConvertor_10_30.convertElementDefinition(t));
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

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionKind> convertStructureDefinitionKind(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionKind> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionKind> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionKindEnumFactory());
        VersionConvertor_10_30.copyElement(src, tgt);
        switch(src.getValue()) {
            case PRIMITIVETYPE:
                tgt.setValue(org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionKind.DATATYPE);
                break;
            case COMPLEXTYPE:
                tgt.setValue(org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionKind.DATATYPE);
                break;
            case RESOURCE:
                tgt.setValue(org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionKind.RESOURCE);
                break;
            case LOGICAL:
                tgt.setValue(org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionKind.LOGICAL);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionKind.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionKind> convertStructureDefinitionKind(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionKind> src, String dtName) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionKind> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionKindEnumFactory());
        VersionConvertor_10_30.copyElement(src, tgt);
        switch(src.getValue()) {
            case DATATYPE:
                if (Utilities.existsInList(dtName, "boolean", "integer", "decimal", "base64Binary", "instant",
                        "string", "uri", "date", "dateTime", "time", "code", "oid", "uuid", "id", "unsignedInt",
                        "positiveInt", "markdown", "xhtml", "url", "canonical"))
                    tgt.setValue(org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionKind.PRIMITIVETYPE);
                else
                    tgt.setValue(org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionKind.COMPLEXTYPE);
                break;
            case RESOURCE:
                tgt.setValue(org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionKind.RESOURCE);
                break;
            case LOGICAL:
                tgt.setValue(org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionKind.LOGICAL);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionKind.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionMappingComponent convertStructureDefinitionMappingComponent(org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionMappingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionMappingComponent tgt = new org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionMappingComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasIdentityElement())
            tgt.setIdentityElement(VersionConvertor_10_30.convertId(src.getIdentityElement()));
        if (src.hasUriElement())
            tgt.setUriElement(VersionConvertor_10_30.convertUri(src.getUriElement()));
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_30.convertString(src.getNameElement()));
        if (src.hasCommentElement())
            tgt.setCommentsElement(VersionConvertor_10_30.convertString(src.getCommentElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionMappingComponent convertStructureDefinitionMappingComponent(org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionMappingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionMappingComponent tgt = new org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionMappingComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasIdentityElement())
            tgt.setIdentityElement(VersionConvertor_10_30.convertId(src.getIdentityElement()));
        if (src.hasUriElement())
            tgt.setUriElement(VersionConvertor_10_30.convertUri(src.getUriElement()));
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_30.convertString(src.getNameElement()));
        if (src.hasCommentsElement())
            tgt.setCommentElement(VersionConvertor_10_30.convertString(src.getCommentsElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionSnapshotComponent convertStructureDefinitionSnapshotComponent(org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionSnapshotComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionSnapshotComponent tgt = new org.hl7.fhir.dstu2.model.StructureDefinition.StructureDefinitionSnapshotComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        for (org.hl7.fhir.dstu3.model.ElementDefinition t : src.getElement()) tgt.addElement(VersionConvertor_10_30.convertElementDefinition(t));
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