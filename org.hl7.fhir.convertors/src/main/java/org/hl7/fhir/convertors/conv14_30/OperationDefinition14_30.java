package org.hl7.fhir.convertors.conv14_30;

import org.hl7.fhir.convertors.VersionConvertor_14_30;
import org.hl7.fhir.dstu3.model.Enumerations.SearchParamType;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.Utilities;

public class OperationDefinition14_30 {

    public static org.hl7.fhir.dstu3.model.OperationDefinition convertOperationDefinition(org.hl7.fhir.dstu2016may.model.OperationDefinition src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.OperationDefinition tgt = new org.hl7.fhir.dstu3.model.OperationDefinition();
        VersionConvertor_14_30.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrl(src.getUrl());
        if (src.hasVersion())
            tgt.setVersion(src.getVersion());
        if (src.hasName()) {
            tgt.setName(src.getName());
        }
        if (src.hasStatus()) {
            tgt.setStatus(VersionConvertor_14_30.convertConformanceResourceStatus(src.getStatus()));
        }
        if (src.hasKind()) {
            tgt.setKind(convertOperationKind(src.getKind()));
        }
        if (src.hasExperimental())
            tgt.setExperimental(src.getExperimental());
        if (src.hasDate())
            tgt.setDate(src.getDate());
        if (src.hasPublisher())
            tgt.setPublisher(src.getPublisher());
        if (src.hasContact()) {
            for (org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionContactComponent t : src.getContact()) tgt.addContact(convertOperationDefinitionContactComponent(t));
        }
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu2016may.model.CodeableConcept t : src.getUseContext()) if (VersionConvertor_14_30.isJurisdiction(t))
            tgt.addJurisdiction(VersionConvertor_14_30.convertCodeableConcept(t));
        else
            tgt.addUseContext(VersionConvertor_14_30.convertCodeableConceptToUsageContext(t));
        if (src.hasRequirements())
            tgt.setPurpose(src.getRequirements());
        if (src.hasIdempotent())
            tgt.setIdempotent(src.getIdempotent());
        if (src.hasCode()) {
            tgt.setCode(src.getCode());
        }
        if (src.hasComment())
            tgt.setComment(src.getComment());
        if (src.hasBase()) {
            tgt.setBase(VersionConvertor_14_30.convertReference(src.getBase()));
        }
        if (src.hasSystem()) {
            tgt.setSystem(src.getSystem());
        }
        if (src.hasType()) {
            for (org.hl7.fhir.dstu2016may.model.CodeType t : src.getType()) tgt.addResource(t.getValue());
        }
        tgt.setType(tgt.hasResource());
        if (src.hasInstance()) {
            tgt.setInstance(src.getInstance());
        }
        if (src.hasParameter()) {
            for (org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionParameterComponent t : src.getParameter()) tgt.addParameter(convertOperationDefinitionParameterComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.OperationDefinition convertOperationDefinition(org.hl7.fhir.dstu3.model.OperationDefinition src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.OperationDefinition tgt = new org.hl7.fhir.dstu2016may.model.OperationDefinition();
        VersionConvertor_14_30.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrl(src.getUrl());
        if (src.hasVersion())
            tgt.setVersion(src.getVersion());
        if (src.hasName()) {
            tgt.setName(src.getName());
        }
        if (src.hasStatus()) {
            tgt.setStatus(VersionConvertor_14_30.convertConformanceResourceStatus(src.getStatus()));
        }
        if (src.hasKind()) {
            tgt.setKind(convertOperationKind(src.getKind()));
        }
        if (src.hasExperimental())
            tgt.setExperimental(src.getExperimental());
        if (src.hasDate())
            tgt.setDate(src.getDate());
        if (src.hasPublisher())
            tgt.setPublisher(src.getPublisher());
        if (src.hasContact()) {
            for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(convertOperationDefinitionContactComponent(t));
        }
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext()) if (t.hasValueCodeableConcept())
            tgt.addUseContext(VersionConvertor_14_30.convertCodeableConcept(t.getValueCodeableConcept()));
        if (src.hasJurisdiction()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addUseContext(VersionConvertor_14_30.convertCodeableConcept(t));
        }
        if (src.hasPurpose())
            tgt.setRequirements(src.getPurpose());
        if (src.hasIdempotent())
            tgt.setIdempotent(src.getIdempotent());
        if (src.hasCode()) {
            tgt.setCode(src.getCode());
        }
        if (src.hasComment())
            tgt.setComment(src.getComment());
        if (src.hasBase()) {
            tgt.setBase(VersionConvertor_14_30.convertReference(src.getBase()));
        }
        if (src.hasSystem()) {
            tgt.setSystem(src.getSystem());
        }
        if (src.getType())
            if (src.hasResource()) {
                for (org.hl7.fhir.dstu3.model.CodeType t : src.getResource()) tgt.addType(t.getValue());
            }
        if (src.hasInstance()) {
            tgt.setInstance(src.getInstance());
        }
        if (src.hasParameter()) {
            for (org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterComponent t : src.getParameter()) tgt.addParameter(convertOperationDefinitionParameterComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionContactComponent convertOperationDefinitionContactComponent(org.hl7.fhir.dstu3.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionContactComponent tgt = new org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionContactComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasTelecom()) {
            for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_14_30.convertContactPoint(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ContactDetail convertOperationDefinitionContactComponent(org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ContactDetail tgt = new org.hl7.fhir.dstu3.model.ContactDetail();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasTelecom()) {
            for (org.hl7.fhir.dstu2016may.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_14_30.convertContactPoint(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterBindingComponent convertOperationDefinitionParameterBindingComponent(org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionParameterBindingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterBindingComponent tgt = new org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterBindingComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasStrength()) {
            tgt.setStrength(VersionConvertor_14_30.convertBindingStrength(src.getStrength()));
        }
        if (src.hasValueSet()) {
            tgt.setValueSet(VersionConvertor_14_30.convertType(src.getValueSet()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionParameterBindingComponent convertOperationDefinitionParameterBindingComponent(org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterBindingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionParameterBindingComponent tgt = new org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionParameterBindingComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasStrength()) {
            tgt.setStrength(VersionConvertor_14_30.convertBindingStrength(src.getStrength()));
        }
        if (src.hasValueSet()) {
            tgt.setValueSet(VersionConvertor_14_30.convertType(src.getValueSet()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionParameterComponent convertOperationDefinitionParameterComponent(org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionParameterComponent tgt = new org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionParameterComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasName()) {
            tgt.setName(src.getName());
        }
        if (src.hasUse()) {
            tgt.setUse(convertOperationParameterUse(src.getUse()));
        }
        if (src.hasMin()) {
            tgt.setMin(src.getMin());
        }
        if (src.hasMax()) {
            tgt.setMax(src.getMax());
        }
        if (src.hasDocumentation())
            tgt.setDocumentation(src.getDocumentation());
        if (src.hasType())
            tgt.setType(src.getType());
        if (src.hasSearchType()) {
            tgt.setSearchType(VersionConvertor_14_30.convertSearchParamType(src.getSearchType()));
        }
        if (src.hasProfile()) {
            tgt.setProfile(VersionConvertor_14_30.convertReference(src.getProfile()));
        }
        if (src.hasBinding()) {
            tgt.setBinding(convertOperationDefinitionParameterBindingComponent(src.getBinding()));
        }
        if (src.hasPart()) {
            for (org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterComponent t : src.getPart()) tgt.addPart(convertOperationDefinitionParameterComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterComponent convertOperationDefinitionParameterComponent(org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionParameterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterComponent tgt = new org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasName()) {
            tgt.setName(src.getName());
        }
        if (src.hasUse()) {
            tgt.setUse(convertOperationParameterUse(src.getUse()));
        }
        if (src.hasMin()) {
            tgt.setMin(src.getMin());
        }
        if (src.hasMax()) {
            tgt.setMax(src.getMax());
        }
        if (src.hasDocumentation())
            tgt.setDocumentation(src.getDocumentation());
        if (Utilities.existsInList(src.getType(), "token", "reference", "composite", "number", "date", "quantity", "uri")) {
            tgt.setType("string");
            if (src.hasType()) {
                tgt.setSearchType(SearchParamType.fromCode(src.getType()));
            }
        } else {
            if (src.hasType()) {
                tgt.setType(src.getType());
            }
        }
        if (src.hasSearchType()) {
            tgt.setSearchType(VersionConvertor_14_30.convertSearchParamType(src.getSearchType()));
        }
        if (src.hasProfile()) {
            tgt.setProfile(VersionConvertor_14_30.convertReference(src.getProfile()));
        }
        if (src.hasBinding()) {
            tgt.setBinding(convertOperationDefinitionParameterBindingComponent(src.getBinding()));
        }
        if (src.hasPart()) {
            for (org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationDefinitionParameterComponent t : src.getPart()) tgt.addPart(convertOperationDefinitionParameterComponent(t));
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationKind convertOperationKind(org.hl7.fhir.dstu3.model.OperationDefinition.OperationKind src) throws FHIRException {
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

    static public org.hl7.fhir.dstu3.model.OperationDefinition.OperationKind convertOperationKind(org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationKind src) throws FHIRException {
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

    static public org.hl7.fhir.dstu3.model.OperationDefinition.OperationParameterUse convertOperationParameterUse(org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationParameterUse src) throws FHIRException {
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

    static public org.hl7.fhir.dstu2016may.model.OperationDefinition.OperationParameterUse convertOperationParameterUse(org.hl7.fhir.dstu3.model.OperationDefinition.OperationParameterUse src) throws FHIRException {
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
}
