package org.hl7.fhir.convertors.conv14_40;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.VersionConvertor_14_40;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.Type;

public class OperationDefinition14_40 {

    public static org.hl7.fhir.r4.model.OperationDefinition convertOperationDefinition(org.hl7.fhir.dstu2016may.model.OperationDefinition src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.OperationDefinition tgt = new org.hl7.fhir.r4.model.OperationDefinition();
        VersionConvertor_14_40.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrl(src.getUrl());
        if (src.hasVersion())
            tgt.setVersion(src.getVersion());
        tgt.setName(src.getName());
        tgt.setStatus(VersionConvertor_14_40.convertConformanceResourceStatus(src.getStatus()));
        tgt.setKind(convertOperationKind(src.getKind()));
        if (src.hasExperimental())
            tgt.setExperimental(src.getExperimental());
        if (src.hasDate())
            tgt.setDate(src.getDate());
        if (src.hasPublisher())
            tgt.setPublisher(src.getPublisher());
        for (org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionContactComponent t : src.getContact()) tgt.addContact(convertOperationDefinitionContactComponent(t));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu2016may.model.CodeableConcept t : src.getUseContext()) if (VersionConvertor_14_40.isJurisdiction(t))
            tgt.addJurisdiction(VersionConvertor_14_40.convertCodeableConcept(t));
        else
            tgt.addUseContext(VersionConvertor_14_40.convertCodeableConceptToUsageContext(t));
        if (src.hasRequirements())
            tgt.setPurpose(src.getRequirements());
        if (src.hasIdempotent())
            tgt.setAffectsState(!src.getIdempotent());
        tgt.setCode(src.getCode());
        if (src.hasComment())
            tgt.setComment(src.getComment());
        tgt.setBaseElement(VersionConvertor_14_40.convertReferenceToCanonical(src.getBase()));
        tgt.setSystem(src.getSystem());
        for (org.hl7.fhir.dstu2016may.model.CodeType t : src.getType()) tgt.addResource(t.getValue());
        tgt.setType(tgt.hasResource());
        tgt.setInstance(src.getInstance());
        for (org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionParameterComponent t : src.getParameter()) tgt.addParameter(convertOperationDefinitionParameterComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.OperationDefinition convertOperationDefinition(org.hl7.fhir.r4.model.OperationDefinition src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.OperationDefinition tgt = new org.hl7.fhir.dstu2016may.model.OperationDefinition();
        VersionConvertor_14_40.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrl(src.getUrl());
        if (src.hasVersion())
            tgt.setVersion(src.getVersion());
        tgt.setName(src.getName());
        tgt.setStatus(VersionConvertor_14_40.convertConformanceResourceStatus(src.getStatus()));
        tgt.setKind(convertOperationKind(src.getKind()));
        if (src.hasExperimental())
            tgt.setExperimental(src.getExperimental());
        if (src.hasDate())
            tgt.setDate(src.getDate());
        if (src.hasPublisher())
            tgt.setPublisher(src.getPublisher());
        for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact()) tgt.addContact(convertOperationDefinitionContactComponent(t));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext()) if (t.hasValueCodeableConcept())
            tgt.addUseContext(VersionConvertor_14_40.convertCodeableConcept(t.getValueCodeableConcept()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction()) tgt.addUseContext(VersionConvertor_14_40.convertCodeableConcept(t));
        if (src.hasPurpose())
            tgt.setRequirements(src.getPurpose());
        if (src.hasAffectsState())
            tgt.setIdempotent(!src.getAffectsState());
        tgt.setCode(src.getCode());
        if (src.hasComment())
            tgt.setComment(src.getComment());
        tgt.setBase(VersionConvertor_14_40.convertCanonicalToReference(src.getBaseElement()));
        tgt.setSystem(src.getSystem());
        if (src.getType())
            for (org.hl7.fhir.r4.model.CodeType t : src.getResource()) tgt.addType(t.getValue());
        tgt.setInstance(src.getInstance());
        for (org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterComponent t : src.getParameter()) tgt.addParameter(convertOperationDefinitionParameterComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionContactComponent convertOperationDefinitionContactComponent(org.hl7.fhir.r4.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionContactComponent tgt = new org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionContactComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasName())
            tgt.setName(src.getName());
        for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_14_40.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ContactDetail convertOperationDefinitionContactComponent(org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ContactDetail tgt = new org.hl7.fhir.r4.model.ContactDetail();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasName())
            tgt.setName(src.getName());
        for (org.hl7.fhir.dstu2016may.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_14_40.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterBindingComponent convertOperationDefinitionParameterBindingComponent(org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionParameterBindingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterBindingComponent tgt = new org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterBindingComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        tgt.setStrength(VersionConvertor_14_40.convertBindingStrength(src.getStrength()));
        Type t = VersionConvertor_14_40.convertType(src.getValueSet());
        if (t != null) {
            if (t instanceof org.hl7.fhir.r4.model.Reference)
                tgt.setValueSet(((org.hl7.fhir.r4.model.Reference) t).getReference());
            else
                tgt.setValueSet(t.primitiveValue());
            tgt.setValueSet(VersionConvertorConstants.refToVS(tgt.getValueSet()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionParameterBindingComponent convertOperationDefinitionParameterBindingComponent(org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterBindingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionParameterBindingComponent tgt = new org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionParameterBindingComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        tgt.setStrength(VersionConvertor_14_40.convertBindingStrength(src.getStrength()));
        if (src.hasValueSet()) {
            String vsr = VersionConvertorConstants.vsToRef(src.getValueSet());
            if (vsr != null)
                tgt.setValueSet(new org.hl7.fhir.dstu2016may.model.UriType(vsr));
            else
                tgt.setValueSet(new org.hl7.fhir.dstu2016may.model.Reference(src.getValueSet()));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterComponent convertOperationDefinitionParameterComponent(org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionParameterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterComponent tgt = new org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        tgt.setName(src.getName());
        tgt.setUse(convertOperationParameterUse(src.getUse()));
        tgt.setMin(src.getMin());
        tgt.setMax(src.getMax());
        if (src.hasDocumentation())
            tgt.setDocumentation(src.getDocumentation());
        if (src.hasType())
            tgt.setType(src.getType());
        tgt.setSearchType(VersionConvertor_14_40.convertSearchParamType(src.getSearchType()));
        tgt.addTargetProfile(src.getProfile().getReference());
        tgt.setBinding(convertOperationDefinitionParameterBindingComponent(src.getBinding()));
        for (org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionParameterComponent t : src.getPart()) tgt.addPart(convertOperationDefinitionParameterComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionParameterComponent convertOperationDefinitionParameterComponent(org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionParameterComponent tgt = new org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionParameterComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        tgt.setName(src.getName());
        tgt.setUse(convertOperationParameterUse(src.getUse()));
        tgt.setMin(src.getMin());
        tgt.setMax(src.getMax());
        if (src.hasDocumentation())
            tgt.setDocumentation(src.getDocumentation());
        if (src.hasType())
            tgt.setType(src.getType());
        tgt.setSearchType(VersionConvertor_14_40.convertSearchParamType(src.getSearchType()));
        for (org.hl7.fhir.r4.model.UriType t : src.getTargetProfile()) tgt.setProfile(new org.hl7.fhir.dstu2016may.model.Reference(t.getValue()));
        tgt.setBinding(convertOperationDefinitionParameterBindingComponent(src.getBinding()));
        for (org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterComponent t : src.getPart()) tgt.addPart(convertOperationDefinitionParameterComponent(t));
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationKind convertOperationKind(org.hl7.fhir.r4.model.OperationDefinition.OperationKind src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case OPERATION:
                return org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationKind.OPERATION;
            case QUERY:
                return org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationKind.QUERY;
            default:
                return org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationKind.NULL;
        }
    }

    static public org.hl7.fhir.r4.model.OperationDefinition.OperationKind convertOperationKind(org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationKind src) throws FHIRException {
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

    static public org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationParameterUse convertOperationParameterUse(org.hl7.fhir.r4.model.OperationDefinition.OperationParameterUse src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case IN:
                return org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationParameterUse.IN;
            case OUT:
                return org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationParameterUse.OUT;
            default:
                return org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationParameterUse.NULL;
        }
    }

    static public org.hl7.fhir.r4.model.OperationDefinition.OperationParameterUse convertOperationParameterUse(org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationParameterUse src) throws FHIRException {
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
