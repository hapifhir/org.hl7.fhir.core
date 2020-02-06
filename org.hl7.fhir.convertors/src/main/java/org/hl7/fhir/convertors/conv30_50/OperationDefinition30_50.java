package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.Enumerations;

public class OperationDefinition30_50 {

    public static org.hl7.fhir.r5.model.OperationDefinition convertOperationDefinition(org.hl7.fhir.dstu3.model.OperationDefinition src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.OperationDefinition tgt = new org.hl7.fhir.r5.model.OperationDefinition();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrl(src.getUrl());
        if (src.hasVersion())
            tgt.setVersion(src.getVersion());
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasStatus())
            tgt.setStatus(VersionConvertor_30_50.convertPublicationStatus(src.getStatus()));
        if (src.hasKind())
            tgt.setKind(convertOperationKind(src.getKind()));
        if (src.hasExperimental())
            tgt.setExperimental(src.getExperimental());
        if (src.hasDate())
            tgt.setDate(src.getDate());
        if (src.hasPublisher())
            tgt.setPublisher(src.getPublisher());
        if (src.hasContact()) {
            for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(VersionConvertor_30_50.convertContactDetail(t));
        }
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        if (src.hasUseContext()) {
            for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_50.convertUsageContext(t));
        }
        if (src.hasJurisdiction()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_50.convertCodeableConcept(t));
        }
        if (src.hasPurpose())
            tgt.setPurpose(src.getPurpose());
        if (src.hasIdempotent())
            tgt.setAffectsState(!src.getIdempotent());
        if (src.hasCode())
            tgt.setCode(src.getCode());
        if (src.hasComment())
            tgt.setComment(src.getComment());
        if (src.hasBase())
            tgt.setBaseElement(VersionConvertor_30_50.convertReferenceToCanonical(src.getBase()));
        if (src.hasResource()) {
            for (org.hl7.fhir.dstu3.model.CodeType t : src.getResource()) tgt.addResource(t.getValue());
        }
        if (src.hasSystem())
            tgt.setSystem(src.getSystem());
        if (src.hasType())
            tgt.setType(src.getType());
        if (src.hasInstance())
            tgt.setInstance(src.getInstance());
        if (src.hasParameter()) {
            for (org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterComponent t : src.getParameter()) tgt.addParameter(convertOperationDefinitionParameterComponent(t));
        }
        if (src.hasOverload()) {
            for (org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionOverloadComponent t : src.getOverload()) tgt.addOverload(convertOperationDefinitionOverloadComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.OperationDefinition convertOperationDefinition(org.hl7.fhir.r5.model.OperationDefinition src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.OperationDefinition tgt = new org.hl7.fhir.dstu3.model.OperationDefinition();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrl(src.getUrl());
        if (src.hasVersion())
            tgt.setVersion(src.getVersion());
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasStatus())
            tgt.setStatus(VersionConvertor_30_50.convertPublicationStatus(src.getStatus()));
        if (src.hasKind())
            tgt.setKind(convertOperationKind(src.getKind()));
        if (src.hasExperimental())
            tgt.setExperimental(src.getExperimental());
        if (src.hasDate())
            tgt.setDate(src.getDate());
        if (src.hasPublisher())
            tgt.setPublisher(src.getPublisher());
        if (src.hasContact()) {
            for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact()) tgt.addContact(VersionConvertor_30_50.convertContactDetail(t));
        }
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        if (src.hasUseContext()) {
            for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_50.convertUsageContext(t));
        }
        if (src.hasJurisdiction()) {
            for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_50.convertCodeableConcept(t));
        }
        if (src.hasPurpose())
            tgt.setPurpose(src.getPurpose());
        if (src.hasAffectsState())
            tgt.setIdempotent(!src.getAffectsState());
        if (src.hasCode())
            tgt.setCode(src.getCode());
        if (src.hasComment())
            tgt.setComment(src.getComment());
        if (src.hasBase())
            tgt.setBase(VersionConvertor_30_50.convertCanonicalToReference(src.getBaseElement()));
        if (src.hasResource()) {
            for (org.hl7.fhir.r5.model.CodeType t : src.getResource()) tgt.addResource(t.getValue());
        }
        if (src.hasSystem())
            tgt.setSystem(src.getSystem());
        if (src.hasType())
            tgt.setType(src.getType());
        if (src.hasInstance())
            tgt.setInstance(src.getInstance());
        if (src.hasParameter()) {
            for (org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterComponent t : src.getParameter()) tgt.addParameter(convertOperationDefinitionParameterComponent(t));
        }
        if (src.hasOverload()) {
            for (org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionOverloadComponent t : src.getOverload()) tgt.addOverload(convertOperationDefinitionOverloadComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionOverloadComponent convertOperationDefinitionOverloadComponent(org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionOverloadComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionOverloadComponent tgt = new org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionOverloadComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasParameterName()) {
            for (org.hl7.fhir.r5.model.StringType t : src.getParameterName()) tgt.addParameterName(t.getValue());
        }
        if (src.hasComment())
            tgt.setComment(src.getComment());
        return tgt;
    }

    public static org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionOverloadComponent convertOperationDefinitionOverloadComponent(org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionOverloadComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionOverloadComponent tgt = new org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionOverloadComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasParameterName()) {
            for (org.hl7.fhir.dstu3.model.StringType t : src.getParameterName()) tgt.addParameterName(t.getValue());
        }
        if (src.hasComment())
            tgt.setComment(src.getComment());
        return tgt;
    }

    public static org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterBindingComponent convertOperationDefinitionParameterBindingComponent(org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterBindingComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterBindingComponent tgt = new org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterBindingComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasStrength())
            tgt.setStrength(VersionConvertor_30_50.convertBindingStrength(src.getStrength()));
        if (src.hasValueSet()) {
            DataType t = VersionConvertor_30_50.convertType(src.getValueSet());
            if (t instanceof org.hl7.fhir.r5.model.Reference)
                tgt.setValueSet(((org.hl7.fhir.r5.model.Reference) t).getReference());
            else
                tgt.setValueSet(t.primitiveValue());
            tgt.setValueSet(VersionConvertorConstants.refToVS(tgt.getValueSet()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterBindingComponent convertOperationDefinitionParameterBindingComponent(org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterBindingComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterBindingComponent tgt = new org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterBindingComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasStrength())
            tgt.setStrength(VersionConvertor_30_50.convertBindingStrength(src.getStrength()));
        if (src.hasValueSet()) {
            String vsr = VersionConvertorConstants.vsToRef(src.getValueSet());
            if (vsr != null)
                tgt.setValueSet(new org.hl7.fhir.dstu3.model.UriType(vsr));
            else
                tgt.setValueSet(new org.hl7.fhir.dstu3.model.Reference(src.getValueSet()));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterComponent convertOperationDefinitionParameterComponent(org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterComponent tgt = new org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasUse())
            tgt.setUse(convertOperationParameterUse(src.getUse()));
        if (src.hasMin())
            tgt.setMin(src.getMin());
        if (src.hasMax())
            tgt.setMax(src.getMax());
        if (src.hasDocumentation())
            tgt.setDocumentation(src.getDocumentation());
        if (src.hasType())
            tgt.setType(Enumerations.FHIRAllTypes.fromCode(src.getType()));
        if (src.hasSearchType())
            tgt.setSearchType(VersionConvertor_30_50.convertSearchParamType(src.getSearchType()));
        if (src.hasProfile())
            tgt.addTargetProfile(src.getProfile().getReference());
        if (src.hasBinding())
            tgt.setBinding(convertOperationDefinitionParameterBindingComponent(src.getBinding()));
        if (src.hasPart()) {
            for (org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterComponent t : src.getPart()) tgt.addPart(convertOperationDefinitionParameterComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterComponent convertOperationDefinitionParameterComponent(org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterComponent tgt = new org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasUse())
            tgt.setUse(convertOperationParameterUse(src.getUse()));
        if (src.hasMin())
            tgt.setMin(src.getMin());
        if (src.hasMax())
            tgt.setMax(src.getMax());
        if (src.hasDocumentation())
            tgt.setDocumentation(src.getDocumentation());
        if (src.hasType())
            tgt.setType(src.getType().toCode());
        if (src.hasSearchType())
            tgt.setSearchType(VersionConvertor_30_50.convertSearchParamType(src.getSearchType()));
        if (src.hasTargetProfile()) {
            for (org.hl7.fhir.r5.model.UriType t : src.getTargetProfile()) tgt.setProfile(new org.hl7.fhir.dstu3.model.Reference(t.getValue()));
        }
        if (src.hasBinding())
            tgt.setBinding(convertOperationDefinitionParameterBindingComponent(src.getBinding()));
        if (src.hasPart()) {
            for (org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterComponent t : src.getPart()) tgt.addPart(convertOperationDefinitionParameterComponent(t));
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.OperationDefinition.OperationKind convertOperationKind(org.hl7.fhir.r5.model.OperationDefinition.OperationKind src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case OPERATION:
                return org.hl7.fhir.dstu3.model.OperationDefinition.OperationKind.OPERATION;
            case QUERY:
                return org.hl7.fhir.dstu3.model.OperationDefinition.OperationKind.QUERY;
            default:
                return org.hl7.fhir.dstu3.model.OperationDefinition.OperationKind.NULL;
        }
    }

    static public org.hl7.fhir.r5.model.OperationDefinition.OperationKind convertOperationKind(org.hl7.fhir.dstu3.model.OperationDefinition.OperationKind src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case OPERATION:
                return org.hl7.fhir.r5.model.OperationDefinition.OperationKind.OPERATION;
            case QUERY:
                return org.hl7.fhir.r5.model.OperationDefinition.OperationKind.QUERY;
            default:
                return org.hl7.fhir.r5.model.OperationDefinition.OperationKind.NULL;
        }
    }

    static public org.hl7.fhir.r5.model.Enumerations.OperationParameterUse convertOperationParameterUse(org.hl7.fhir.dstu3.model.OperationDefinition.OperationParameterUse src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case IN:
                return org.hl7.fhir.r5.model.Enumerations.OperationParameterUse.IN;
            case OUT:
                return org.hl7.fhir.r5.model.Enumerations.OperationParameterUse.OUT;
            default:
                return org.hl7.fhir.r5.model.Enumerations.OperationParameterUse.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.OperationDefinition.OperationParameterUse convertOperationParameterUse(org.hl7.fhir.r5.model.Enumerations.OperationParameterUse src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case IN:
                return org.hl7.fhir.dstu3.model.OperationDefinition.OperationParameterUse.IN;
            case OUT:
                return org.hl7.fhir.dstu3.model.OperationDefinition.OperationParameterUse.OUT;
            default:
                return org.hl7.fhir.dstu3.model.OperationDefinition.OperationParameterUse.NULL;
        }
    }
}
