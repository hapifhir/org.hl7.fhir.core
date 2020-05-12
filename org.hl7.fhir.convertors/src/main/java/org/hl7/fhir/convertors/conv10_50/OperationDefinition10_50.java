package org.hl7.fhir.convertors.conv10_50;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.VersionConvertor_10_50;
import org.hl7.fhir.dstu2.model.Reference;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeType;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.Enumerations;
import org.hl7.fhir.r5.model.Enumerations.FHIRAllTypes;
import org.hl7.fhir.r5.model.Enumerations.SearchParamType;
import org.hl7.fhir.utilities.Utilities;

public class OperationDefinition10_50 {

    public static org.hl7.fhir.dstu2.model.OperationDefinition convertOperationDefinition(org.hl7.fhir.r5.model.OperationDefinition src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.OperationDefinition tgt = new org.hl7.fhir.dstu2.model.OperationDefinition();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement(VersionConvertor_10_50.convertUri(src.getUrlElement()));
        if (src.hasVersionElement())
            tgt.setVersionElement(VersionConvertor_10_50.convertString(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_50.convertString(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatusElement(VersionConvertor_10_50.convertConformanceResourceStatus(src.getStatusElement()));
        if (src.hasKind())
            tgt.setKindElement(convertOperationKind(src.getKindElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(VersionConvertor_10_50.convertBoolean(src.getExperimentalElement()));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_10_50.convertDateTime(src.getDateElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement(VersionConvertor_10_50.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact()) tgt.addContact(convertOperationDefinitionContactComponent(t));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        if (src.hasPurpose())
            tgt.setRequirements(src.getPurpose());
        tgt.setIdempotent(!src.getAffectsState());
        if (src.hasCodeElement())
            tgt.setCodeElement(VersionConvertor_10_50.convertCode(src.getCodeElement()));
        if (src.hasComment())
            tgt.setNotes(src.getComment());
        if (src.hasBase())
            tgt.setBase(VersionConvertor_10_50.convertCanonicalToReference(src.getBaseElement()));
        if (src.hasSystemElement())
            tgt.setSystemElement(VersionConvertor_10_50.convertBoolean(src.getSystemElement()));
        if (src.getType())
            for (CodeType t : src.getResource()) tgt.addType(t.getValue());
        if (src.hasInstanceElement())
            tgt.setInstanceElement(VersionConvertor_10_50.convertBoolean(src.getInstanceElement()));
        for (org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterComponent t : src.getParameter()) tgt.addParameter(convertOperationDefinitionParameterComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.OperationDefinition convertOperationDefinition(org.hl7.fhir.dstu2.model.OperationDefinition src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.OperationDefinition tgt = new org.hl7.fhir.r5.model.OperationDefinition();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement(VersionConvertor_10_50.convertUri(src.getUrlElement()));
        if (src.hasVersionElement())
            tgt.setVersionElement(VersionConvertor_10_50.convertString(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_50.convertString(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatusElement(VersionConvertor_10_50.convertConformanceResourceStatus(src.getStatusElement()));
        if (src.hasKind())
            tgt.setKindElement(convertOperationKind(src.getKindElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(VersionConvertor_10_50.convertBoolean(src.getExperimentalElement()));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_10_50.convertDateTime(src.getDateElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement(VersionConvertor_10_50.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionContactComponent t : src.getContact()) tgt.addContact(convertOperationDefinitionContactComponent(t));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        if (src.hasRequirements())
            tgt.setPurpose(src.getRequirements());
        if (src.hasIdempotent())
            tgt.setAffectsState(!src.getIdempotent());
        if (src.hasCodeElement())
            tgt.setCodeElement(VersionConvertor_10_50.convertCode(src.getCodeElement()));
        if (src.hasNotes())
            tgt.setComment(src.getNotes());
        if (src.hasBase())
            tgt.setBaseElement(VersionConvertor_10_50.convertReferenceToCanonical(src.getBase()));
        if (src.hasSystemElement())
            tgt.setSystemElement(VersionConvertor_10_50.convertBoolean(src.getSystemElement()));
        for (org.hl7.fhir.dstu2.model.CodeType t : src.getType()) tgt.addResource(t.getValue());
        tgt.setType(tgt.hasResource());
        if (src.hasInstanceElement())
            tgt.setInstanceElement(VersionConvertor_10_50.convertBoolean(src.getInstanceElement()));
        for (org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionParameterComponent t : src.getParameter()) tgt.addParameter(convertOperationDefinitionParameterComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionContactComponent convertOperationDefinitionContactComponent(org.hl7.fhir.r5.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionContactComponent tgt = new org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionContactComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_50.convertString(src.getNameElement()));
        for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_50.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ContactDetail convertOperationDefinitionContactComponent(org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ContactDetail tgt = new org.hl7.fhir.r5.model.ContactDetail();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_50.convertString(src.getNameElement()));
        for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_50.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionParameterBindingComponent convertOperationDefinitionParameterBindingComponent(org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterBindingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionParameterBindingComponent tgt = new org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionParameterBindingComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasStrength())
            tgt.setStrengthElement(VersionConvertor_10_50.convertBindingStrength(src.getStrengthElement()));
        if (src.hasValueSet()) {
            String vsr = VersionConvertorConstants.vsToRef(src.getValueSet());
            if (vsr != null)
                tgt.setValueSet(new org.hl7.fhir.dstu2.model.UriType(vsr));
            else
                tgt.setValueSet(new org.hl7.fhir.dstu2.model.Reference(src.getValueSet()));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterBindingComponent convertOperationDefinitionParameterBindingComponent(org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionParameterBindingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterBindingComponent tgt = new org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterBindingComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasStrength())
            tgt.setStrengthElement(VersionConvertor_10_50.convertBindingStrength(src.getStrengthElement()));
        DataType t = VersionConvertor_10_50.convertType(src.getValueSet());
        if (t != null) {
            if (t instanceof org.hl7.fhir.r5.model.Reference)
                tgt.setValueSet(((org.hl7.fhir.r5.model.Reference) t).getReference());
            else
                tgt.setValueSet(t.primitiveValue());
            tgt.setValueSet(VersionConvertorConstants.refToVS(tgt.getValueSet()));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterComponent convertOperationDefinitionParameterComponent(org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionParameterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterComponent tgt = new org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_50.convertCode(src.getNameElement()));
        if (src.hasUse())
            tgt.setUseElement(convertOperationParameterUse(src.getUseElement()));
        if (src.hasMinElement())
            tgt.setMinElement(VersionConvertor_10_50.convertInteger(src.getMinElement()));
        if (src.hasMaxElement())
            tgt.setMaxElement(VersionConvertor_10_50.convertString(src.getMaxElement()));
        if (src.hasDocumentationElement())
            tgt.setDocumentationElement(VersionConvertor_10_50.convertString(src.getDocumentationElement()));
        if (Utilities.existsInList(src.getType(), "token", "reference", "composite", "number", "date", "quantity", "uri")) {
            tgt.setType(FHIRAllTypes.STRING);
            if (src.hasType())
                tgt.setSearchType(SearchParamType.fromCode(src.getType()));
        } else {
            if (src.hasType())
                tgt.setType(Enumerations.FHIRAllTypes.fromCode(src.getType()));
        }
        tgt.addTargetProfile(src.getProfile().getReference());
        if (src.hasBinding())
            tgt.setBinding(convertOperationDefinitionParameterBindingComponent(src.getBinding()));
        for (org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionParameterComponent t : src.getPart()) tgt.addPart(convertOperationDefinitionParameterComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionParameterComponent convertOperationDefinitionParameterComponent(org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionParameterComponent tgt = new org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionParameterComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_50.convertCode(src.getNameElement()));
        if (src.hasUse())
            tgt.setUseElement(convertOperationParameterUse(src.getUseElement()));
        if (src.hasMinElement())
            tgt.setMinElement(VersionConvertor_10_50.convertInteger(src.getMinElement()));
        if (src.hasMaxElement())
            tgt.setMaxElement(VersionConvertor_10_50.convertString(src.getMaxElement()));
        if (src.hasDocumentationElement())
            tgt.setDocumentationElement(VersionConvertor_10_50.convertString(src.getDocumentationElement()));
        if (src.hasSearchType()) {
            tgt.setType(src.getSearchType().toCode());
        } else
            tgt.setType(src.getType().toCode());
        for (org.hl7.fhir.r5.model.UriType t : src.getTargetProfile()) tgt.setProfile(new Reference(t.getValue()));
        if (src.hasBinding())
            tgt.setBinding(convertOperationDefinitionParameterBindingComponent(src.getBinding()));
        for (org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterComponent t : src.getPart()) tgt.addPart(convertOperationDefinitionParameterComponent(t));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.OperationDefinition.OperationKind> convertOperationKind(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.OperationDefinition.OperationKind> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.OperationDefinition.OperationKind> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.OperationDefinition.OperationKindEnumFactory());
        VersionConvertor_10_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case OPERATION:
                tgt.setValue(org.hl7.fhir.r5.model.OperationDefinition.OperationKind.OPERATION);
                break;
            case QUERY:
                tgt.setValue(org.hl7.fhir.r5.model.OperationDefinition.OperationKind.QUERY);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.OperationDefinition.OperationKind.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.OperationDefinition.OperationKind> convertOperationKind(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.OperationDefinition.OperationKind> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.OperationDefinition.OperationKind> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.OperationDefinition.OperationKindEnumFactory());
        VersionConvertor_10_50.copyElement(src, tgt);
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

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.OperationParameterUse> convertOperationParameterUse(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.OperationDefinition.OperationParameterUse> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.OperationParameterUse> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.OperationParameterUseEnumFactory());
        VersionConvertor_10_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case IN:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.OperationParameterUse.IN);
                break;
            case OUT:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.OperationParameterUse.OUT);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.OperationParameterUse.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.OperationDefinition.OperationParameterUse> convertOperationParameterUse(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.OperationParameterUse> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.OperationDefinition.OperationParameterUse> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.OperationDefinition.OperationParameterUseEnumFactory());
        VersionConvertor_10_50.copyElement(src, tgt);
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
}