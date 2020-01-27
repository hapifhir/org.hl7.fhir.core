package org.hl7.fhir.convertors.conv10_40;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.VersionConvertor_10_40;
import org.hl7.fhir.dstu2.model.Reference;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.Enumerations.SearchParamType;
import org.hl7.fhir.r4.model.Type;
import org.hl7.fhir.utilities.Utilities;

public class OperationDefinition10_40 {

    public static org.hl7.fhir.r4.model.OperationDefinition convertOperationDefinition(org.hl7.fhir.dstu2.model.OperationDefinition src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.OperationDefinition tgt = new org.hl7.fhir.r4.model.OperationDefinition();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        tgt.setUrl(src.getUrl());
        tgt.setVersion(src.getVersion());
        tgt.setName(src.getName());
        tgt.setStatus(VersionConvertor_10_40.convertConformanceResourceStatus(src.getStatus()));
        tgt.setKind(convertOperationKind(src.getKind()));
        if (src.hasExperimental())
            tgt.setExperimental(src.getExperimental());
        if (src.hasDate())
            tgt.setDate(src.getDate());
        tgt.setPublisher(src.getPublisher());
        for (org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionContactComponent t : src.getContact()) tgt.addContact(convertOperationDefinitionContactComponent(t));
        tgt.setDescription(src.getDescription());
        tgt.setPurpose(src.getRequirements());
        if (src.hasIdempotent())
            tgt.setAffectsState(!src.getIdempotent());
        tgt.setCode(src.getCode());
        tgt.setComment(src.getNotes());
        tgt.setBaseElement(VersionConvertor_10_40.convertReferenceToCanonical(src.getBase()));
        tgt.setSystem(src.getSystem());
        for (org.hl7.fhir.dstu2.model.CodeType t : src.getType()) tgt.addResource(t.getValue());
        tgt.setType(tgt.hasResource());
        tgt.setInstance(src.getInstance());
        for (org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionParameterComponent t : src.getParameter()) tgt.addParameter(convertOperationDefinitionParameterComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.OperationDefinition convertOperationDefinition(org.hl7.fhir.r4.model.OperationDefinition src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.OperationDefinition tgt = new org.hl7.fhir.dstu2.model.OperationDefinition();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        tgt.setUrl(src.getUrl());
        tgt.setVersion(src.getVersion());
        tgt.setName(src.getName());
        tgt.setStatus(VersionConvertor_10_40.convertConformanceResourceStatus(src.getStatus()));
        tgt.setKind(convertOperationKind(src.getKind()));
        if (src.hasExperimental())
            tgt.setExperimental(src.getExperimental());
        if (src.hasDate())
            tgt.setDate(src.getDate());
        tgt.setPublisher(src.getPublisher());
        for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact()) tgt.addContact(convertOperationDefinitionContactComponent(t));
        tgt.setDescription(src.getDescription());
        tgt.setRequirements(src.getPurpose());
        tgt.setIdempotent(!src.getAffectsState());
        tgt.setCode(src.getCode());
        tgt.setNotes(src.getComment());
        if (src.hasBase())
            tgt.setBase(VersionConvertor_10_40.convertCanonicalToReference(src.getBaseElement()));
        tgt.setSystem(src.getSystem());
        if (src.getType())
            for (org.hl7.fhir.r4.model.CodeType t : src.getResource()) tgt.addType(t.getValue());
        tgt.setInstance(src.getInstance());
        for (org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterComponent t : src.getParameter()) tgt.addParameter(convertOperationDefinitionParameterComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionContactComponent convertOperationDefinitionContactComponent(org.hl7.fhir.r4.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionContactComponent tgt = new org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionContactComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        tgt.setName(src.getName());
        for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_40.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ContactDetail convertOperationDefinitionContactComponent(org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ContactDetail tgt = new org.hl7.fhir.r4.model.ContactDetail();
        VersionConvertor_10_40.copyElement(src, tgt);
        tgt.setName(src.getName());
        for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_40.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterBindingComponent convertOperationDefinitionParameterBindingComponent(org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionParameterBindingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterBindingComponent tgt = new org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterBindingComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        tgt.setStrength(VersionConvertor_10_40.convertBindingStrength(src.getStrength()));
        Type t = VersionConvertor_10_40.convertType(src.getValueSet());
        if (t != null) {
            if (t instanceof org.hl7.fhir.r4.model.Reference)
                tgt.setValueSet(((org.hl7.fhir.r4.model.Reference) t).getReference());
            else
                tgt.setValueSet(t.primitiveValue());
            tgt.setValueSet(VersionConvertorConstants.refToVS(tgt.getValueSet()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionParameterBindingComponent convertOperationDefinitionParameterBindingComponent(org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterBindingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionParameterBindingComponent tgt = new org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionParameterBindingComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        tgt.setStrength(VersionConvertor_10_40.convertBindingStrength(src.getStrength()));
        if (src.hasValueSet()) {
            String vsr = VersionConvertorConstants.vsToRef(src.getValueSet());
            if (vsr != null)
                tgt.setValueSet(new org.hl7.fhir.dstu2.model.UriType(vsr));
            else
                tgt.setValueSet(new org.hl7.fhir.dstu2.model.Reference(src.getValueSet()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionParameterComponent convertOperationDefinitionParameterComponent(org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionParameterComponent tgt = new org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionParameterComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        tgt.setName(src.getName());
        tgt.setUse(convertOperationParameterUse(src.getUse()));
        tgt.setMin(src.getMin());
        tgt.setMax(src.getMax());
        tgt.setDocumentation(src.getDocumentation());
        if (src.hasSearchType()) {
            tgt.setType(src.getSearchType().toCode());
        } else
            tgt.setType(src.getType());
        for (org.hl7.fhir.r4.model.UriType t : src.getTargetProfile()) tgt.setProfile(new Reference(t.getValue()));
        if (src.hasBinding())
            tgt.setBinding(convertOperationDefinitionParameterBindingComponent(src.getBinding()));
        for (org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterComponent t : src.getPart()) tgt.addPart(convertOperationDefinitionParameterComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterComponent convertOperationDefinitionParameterComponent(org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionParameterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterComponent tgt = new org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        tgt.setName(src.getName());
        tgt.setUse(convertOperationParameterUse(src.getUse()));
        tgt.setMin(src.getMin());
        tgt.setMax(src.getMax());
        tgt.setDocumentation(src.getDocumentation());
        if (Utilities.existsInList(src.getType(), "token", "reference", "composite", "number", "date", "quantity", "uri")) {
            tgt.setType("string");
            tgt.setSearchType(SearchParamType.fromCode(src.getType()));
        } else {
            tgt.setType(src.getType());
        }
        tgt.addTargetProfile(src.getProfile().getReference());
        tgt.setBinding(convertOperationDefinitionParameterBindingComponent(src.getBinding()));
        for (org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionParameterComponent t : src.getPart()) tgt.addPart(convertOperationDefinitionParameterComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.OperationDefinition.OperationKind convertOperationKind(org.hl7.fhir.r4.model.OperationDefinition.OperationKind src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case OPERATION:
                return org.hl7.fhir.dstu2.model.OperationDefinition.OperationKind.OPERATION;
            case QUERY:
                return org.hl7.fhir.dstu2.model.OperationDefinition.OperationKind.QUERY;
            default:
                return org.hl7.fhir.dstu2.model.OperationDefinition.OperationKind.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.OperationDefinition.OperationKind convertOperationKind(org.hl7.fhir.dstu2.model.OperationDefinition.OperationKind src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case OPERATION:
                return org.hl7.fhir.r4.model.OperationDefinition.OperationKind.OPERATION;
            case QUERY:
                return org.hl7.fhir.r4.model.OperationDefinition.OperationKind.QUERY;
            default:
                return org.hl7.fhir.r4.model.OperationDefinition.OperationKind.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.OperationDefinition.OperationParameterUse convertOperationParameterUse(org.hl7.fhir.r4.model.OperationDefinition.OperationParameterUse src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case IN:
                return org.hl7.fhir.dstu2.model.OperationDefinition.OperationParameterUse.IN;
            case OUT:
                return org.hl7.fhir.dstu2.model.OperationDefinition.OperationParameterUse.OUT;
            default:
                return org.hl7.fhir.dstu2.model.OperationDefinition.OperationParameterUse.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.OperationDefinition.OperationParameterUse convertOperationParameterUse(org.hl7.fhir.dstu2.model.OperationDefinition.OperationParameterUse src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case IN:
                return org.hl7.fhir.r4.model.OperationDefinition.OperationParameterUse.IN;
            case OUT:
                return org.hl7.fhir.r4.model.OperationDefinition.OperationParameterUse.OUT;
            default:
                return org.hl7.fhir.r4.model.OperationDefinition.OperationParameterUse.NULL;
        }
    }
}
