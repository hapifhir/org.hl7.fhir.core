package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.dstu3.model.Enumerations.SearchParamType;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.Utilities;

public class OperationDefinition10_30 {

    public static org.hl7.fhir.dstu2.model.OperationDefinition convertOperationDefinition(org.hl7.fhir.dstu3.model.OperationDefinition src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.OperationDefinition tgt = new org.hl7.fhir.dstu2.model.OperationDefinition();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement(VersionConvertor_10_30.convertUri(src.getUrlElement()));
        if (src.hasVersionElement())
            tgt.setVersionElement(VersionConvertor_10_30.convertString(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_30.convertString(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatusElement(VersionConvertor_10_30.convertConformanceResourceStatus(src.getStatusElement()));
        if (src.hasKind())
            tgt.setKindElement(convertOperationKind(src.getKindElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(VersionConvertor_10_30.convertBoolean(src.getExperimentalElement()));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_10_30.convertDateTime(src.getDateElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement(VersionConvertor_10_30.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(convertOperationDefinitionContactComponent(t));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        if (src.hasPurpose())
            tgt.setRequirements(src.getPurpose());
        if (src.hasIdempotentElement())
            tgt.setIdempotentElement(VersionConvertor_10_30.convertBoolean(src.getIdempotentElement()));
        if (src.hasCodeElement())
            tgt.setCodeElement(VersionConvertor_10_30.convertCode(src.getCodeElement()));
        if (src.hasCommentElement())
            tgt.setNotesElement(VersionConvertor_10_30.convertString(src.getCommentElement()));
        if (src.hasBase())
            tgt.setBase(VersionConvertor_10_30.convertReference(src.getBase()));
        if (src.hasSystemElement())
            tgt.setSystemElement(VersionConvertor_10_30.convertBoolean(src.getSystemElement()));
        if (src.getType())
            for (org.hl7.fhir.dstu3.model.CodeType t : src.getResource()) tgt.addType(t.getValue());
        if (src.hasInstanceElement())
            tgt.setInstanceElement(VersionConvertor_10_30.convertBoolean(src.getInstanceElement()));
        for (org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterComponent t : src.getParameter()) tgt.addParameter(convertOperationDefinitionParameterComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.OperationDefinition convertOperationDefinition(org.hl7.fhir.dstu2.model.OperationDefinition src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.OperationDefinition tgt = new org.hl7.fhir.dstu3.model.OperationDefinition();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement(VersionConvertor_10_30.convertUri(src.getUrlElement()));
        if (src.hasVersionElement())
            tgt.setVersionElement(VersionConvertor_10_30.convertString(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_30.convertString(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatusElement(VersionConvertor_10_30.convertConformanceResourceStatus(src.getStatusElement()));
        if (src.hasKind())
            tgt.setKindElement(convertOperationKind(src.getKindElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(VersionConvertor_10_30.convertBoolean(src.getExperimentalElement()));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_10_30.convertDateTime(src.getDateElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement(VersionConvertor_10_30.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionContactComponent t : src.getContact()) tgt.addContact(convertOperationDefinitionContactComponent(t));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        if (src.hasRequirements())
            tgt.setPurpose(src.getRequirements());
        if (src.hasIdempotent())
            tgt.setIdempotentElement(VersionConvertor_10_30.convertBoolean(src.getIdempotentElement()));
        if (src.hasCodeElement())
            tgt.setCodeElement(VersionConvertor_10_30.convertCode(src.getCodeElement()));
        if (src.hasNotesElement())
            tgt.setCommentElement(VersionConvertor_10_30.convertString(src.getNotesElement()));
        if (src.hasBase())
            tgt.setBase(VersionConvertor_10_30.convertReference(src.getBase()));
        if (src.hasSystemElement())
            tgt.setSystemElement(VersionConvertor_10_30.convertBoolean(src.getSystemElement()));
        for (org.hl7.fhir.dstu2.model.CodeType t : src.getType()) tgt.addResource(t.getValue());
        tgt.setType(tgt.hasResource());
        if (src.hasInstanceElement())
            tgt.setInstanceElement(VersionConvertor_10_30.convertBoolean(src.getInstanceElement()));
        for (org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionParameterComponent t : src.getParameter()) tgt.addParameter(convertOperationDefinitionParameterComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionContactComponent convertOperationDefinitionContactComponent(org.hl7.fhir.dstu3.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionContactComponent tgt = new org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionContactComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_30.convertString(src.getNameElement()));
        for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_30.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ContactDetail convertOperationDefinitionContactComponent(org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ContactDetail tgt = new org.hl7.fhir.dstu3.model.ContactDetail();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_30.convertString(src.getNameElement()));
        for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_30.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterBindingComponent convertOperationDefinitionParameterBindingComponent(org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionParameterBindingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterBindingComponent tgt = new org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterBindingComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasStrength())
            tgt.setStrengthElement(VersionConvertor_10_30.convertBindingStrength(src.getStrengthElement()));
        if (src.hasValueSet())
            tgt.setValueSet(VersionConvertor_10_30.convertType(src.getValueSet()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionParameterBindingComponent convertOperationDefinitionParameterBindingComponent(org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterBindingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionParameterBindingComponent tgt = new org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionParameterBindingComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasStrength())
            tgt.setStrengthElement(VersionConvertor_10_30.convertBindingStrength(src.getStrengthElement()));
        if (src.hasValueSet())
            tgt.setValueSet(VersionConvertor_10_30.convertType(src.getValueSet()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionParameterComponent convertOperationDefinitionParameterComponent(org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionParameterComponent tgt = new org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionParameterComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_30.convertCode(src.getNameElement()));
        if (src.hasUse())
            tgt.setUseElement(convertOperationParameterUse(src.getUseElement()));
        if (src.hasMinElement())
            tgt.setMinElement(VersionConvertor_10_30.convertInteger(src.getMinElement()));
        if (src.hasMaxElement())
            tgt.setMaxElement(VersionConvertor_10_30.convertString(src.getMaxElement()));
        if (src.hasDocumentationElement())
            tgt.setDocumentationElement(VersionConvertor_10_30.convertString(src.getDocumentationElement()));
        if (src.hasSearchType()) {
            tgt.setType(src.getSearchType().toCode());
        } else
            tgt.setTypeElement(VersionConvertor_10_30.convertCode(src.getTypeElement()));
        if (src.hasProfile())
            tgt.setProfile(VersionConvertor_10_30.convertReference(src.getProfile()));
        if (src.hasBinding())
            tgt.setBinding(convertOperationDefinitionParameterBindingComponent(src.getBinding()));
        for (org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterComponent t : src.getPart()) tgt.addPart(convertOperationDefinitionParameterComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterComponent convertOperationDefinitionParameterComponent(org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionParameterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterComponent tgt = new org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_30.convertCode(src.getNameElement()));
        if (src.hasUse())
            tgt.setUseElement(convertOperationParameterUse(src.getUseElement()));
        if (src.hasMinElement())
            tgt.setMinElement(VersionConvertor_10_30.convertInteger(src.getMinElement()));
        if (src.hasMaxElement())
            tgt.setMaxElement(VersionConvertor_10_30.convertString(src.getMaxElement()));
        if (src.hasDocumentationElement())
            tgt.setDocumentationElement(VersionConvertor_10_30.convertString(src.getDocumentationElement()));
        if (Utilities.existsInList(src.getType(), "token", "reference", "composite", "number", "date", "quantity", "uri")) {
            tgt.setType("string");
            if (src.hasType())
                tgt.setSearchType(SearchParamType.fromCode(src.getType()));
        } else {
            if (src.hasTypeElement())
                tgt.setTypeElement(VersionConvertor_10_30.convertCode(src.getTypeElement()));
        }
        if (src.hasProfile())
            tgt.setProfile(VersionConvertor_10_30.convertReference(src.getProfile()));
        if (src.hasBinding())
            tgt.setBinding(convertOperationDefinitionParameterBindingComponent(src.getBinding()));
        for (org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionParameterComponent t : src.getPart()) tgt.addPart(convertOperationDefinitionParameterComponent(t));
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.OperationDefinition.OperationKind> convertOperationKind(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.OperationDefinition.OperationKind> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.OperationDefinition.OperationKind> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.OperationDefinition.OperationKindEnumFactory());
        VersionConvertor_10_30.copyElement(src, tgt);
        switch(src.getValue()) {
            case OPERATION:
                tgt.setValue(org.hl7.fhir.dstu2.model.OperationDefinition.OperationKind.OPERATION);
                break;
            case QUERY:
                tgt.setValue(org.hl7.fhir.dstu2.model.OperationDefinition.OperationKind.QUERY);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.OperationDefinition.OperationKind.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.OperationDefinition.OperationKind> convertOperationKind(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.OperationDefinition.OperationKind> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.OperationDefinition.OperationKind> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.OperationDefinition.OperationKindEnumFactory());
        VersionConvertor_10_30.copyElement(src, tgt);
        switch(src.getValue()) {
            case OPERATION:
                tgt.setValue(org.hl7.fhir.dstu3.model.OperationDefinition.OperationKind.OPERATION);
                break;
            case QUERY:
                tgt.setValue(org.hl7.fhir.dstu3.model.OperationDefinition.OperationKind.QUERY);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.OperationDefinition.OperationKind.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.OperationDefinition.OperationParameterUse> convertOperationParameterUse(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.OperationDefinition.OperationParameterUse> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.OperationDefinition.OperationParameterUse> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.OperationDefinition.OperationParameterUseEnumFactory());
        VersionConvertor_10_30.copyElement(src, tgt);
        switch(src.getValue()) {
            case IN:
                tgt.setValue(org.hl7.fhir.dstu2.model.OperationDefinition.OperationParameterUse.IN);
                break;
            case OUT:
                tgt.setValue(org.hl7.fhir.dstu2.model.OperationDefinition.OperationParameterUse.OUT);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.OperationDefinition.OperationParameterUse.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.OperationDefinition.OperationParameterUse> convertOperationParameterUse(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.OperationDefinition.OperationParameterUse> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.OperationDefinition.OperationParameterUse> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.OperationDefinition.OperationParameterUseEnumFactory());
        VersionConvertor_10_30.copyElement(src, tgt);
        switch(src.getValue()) {
            case IN:
                tgt.setValue(org.hl7.fhir.dstu3.model.OperationDefinition.OperationParameterUse.IN);
                break;
            case OUT:
                tgt.setValue(org.hl7.fhir.dstu3.model.OperationDefinition.OperationParameterUse.OUT);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.OperationDefinition.OperationParameterUse.NULL);
                break;
        }
        return tgt;
    }
}