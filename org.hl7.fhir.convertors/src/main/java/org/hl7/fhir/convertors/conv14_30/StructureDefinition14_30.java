package org.hl7.fhir.convertors.conv14_30;

import org.hl7.fhir.convertors.VersionConvertor_14_30;
import org.hl7.fhir.dstu2016may.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.exceptions.FHIRException;

public class StructureDefinition14_30 {

    static public org.hl7.fhir.dstu3.model.StructureDefinition.ExtensionContext convertExtensionContext(org.hl7.fhir.dstu2016may.model.StructureDefinition.ExtensionContext src) throws FHIRException {
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

    static public org.hl7.fhir.dstu2016may.model.StructureDefinition.ExtensionContext convertExtensionContext(org.hl7.fhir.dstu3.model.StructureDefinition.ExtensionContext src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case RESOURCE:
                return org.hl7.fhir.dstu2016may.model.StructureDefinition.ExtensionContext.RESOURCE;
            case DATATYPE:
                return org.hl7.fhir.dstu2016may.model.StructureDefinition.ExtensionContext.DATATYPE;
            case EXTENSION:
                return org.hl7.fhir.dstu2016may.model.StructureDefinition.ExtensionContext.EXTENSION;
            default:
                return org.hl7.fhir.dstu2016may.model.StructureDefinition.ExtensionContext.NULL;
        }
    }

    public static org.hl7.fhir.dstu2016may.model.StructureDefinition convertStructureDefinition(org.hl7.fhir.dstu3.model.StructureDefinition src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.StructureDefinition tgt = new org.hl7.fhir.dstu2016may.model.StructureDefinition();
        VersionConvertor_14_30.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrl(src.getUrl());
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_14_30.convertIdentifier(t));
        if (src.hasVersion())
            tgt.setVersion(src.getVersion());
        tgt.setName(src.getName());
        if (src.hasTitle())
            tgt.setDisplay(src.getTitle());
        tgt.setStatus(VersionConvertor_14_30.convertConformanceResourceStatus(src.getStatus()));
        if (src.hasExperimental())
            tgt.setExperimental(src.getExperimental());
        if (src.hasPublisher())
            tgt.setPublisher(src.getPublisher());
        for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(convertStructureDefinitionContactComponent(t));
        if (src.hasDate())
            tgt.setDate(src.getDate());
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext()) if (t.hasValueCodeableConcept())
            tgt.addUseContext(VersionConvertor_14_30.convertCodeableConcept(t.getValueCodeableConcept()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addUseContext(VersionConvertor_14_30.convertCodeableConcept(t));
        if (src.hasPurpose())
            tgt.setRequirements(src.getPurpose());
        if (src.hasCopyright())
            tgt.setCopyright(src.getCopyright());
        for (org.hl7.fhir.dstu3.model.Coding t : src.getKeyword()) tgt.addCode(VersionConvertor_14_30.convertCoding(t));
        if (src.hasFhirVersion())
            tgt.setFhirVersion(src.getFhirVersion());
        for (org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionMappingComponent t : src.getMapping()) tgt.addMapping(convertStructureDefinitionMappingComponent(t));
        tgt.setKind(convertStructureDefinitionKind(src.getKind()));
        tgt.setAbstract(src.getAbstract());
        tgt.setContextType(convertExtensionContext(src.getContextType()));
        for (org.hl7.fhir.dstu3.model.StringType t : src.getContext()) tgt.addContext(t.getValue());
        if (src.hasBaseDefinition())
            tgt.setBaseDefinition(src.getBaseDefinition());
        if (src.hasType() && src.getDerivation() == org.hl7.fhir.dstu3.model.StructureDefinition.TypeDerivationRule.CONSTRAINT)
            tgt.setBaseType(src.getType());
        tgt.setDerivation(convertTypeDerivationRule(src.getDerivation()));
        if (src.hasSnapshot())
            tgt.setSnapshot(convertStructureDefinitionSnapshotComponent(src.getSnapshot()));
        tgt.setDifferential(convertStructureDefinitionDifferentialComponent(src.getDifferential()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.StructureDefinition convertStructureDefinition(org.hl7.fhir.dstu2016may.model.StructureDefinition src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.StructureDefinition tgt = new org.hl7.fhir.dstu3.model.StructureDefinition();
        VersionConvertor_14_30.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrl(src.getUrl());
        for (org.hl7.fhir.dstu2016may.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_14_30.convertIdentifier(t));
        if (src.hasVersion())
            tgt.setVersion(src.getVersion());
        tgt.setName(src.getName());
        if (src.hasDisplay())
            tgt.setTitle(src.getDisplay());
        tgt.setStatus(VersionConvertor_14_30.convertConformanceResourceStatus(src.getStatus()));
        if (src.hasExperimental())
            tgt.setExperimental(src.getExperimental());
        if (src.hasPublisher())
            tgt.setPublisher(src.getPublisher());
        for (org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionContactComponent t : src.getContact()) tgt.addContact(convertStructureDefinitionContactComponent(t));
        if (src.hasDate())
            tgt.setDate(src.getDate());
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu2016may.model.CodeableConcept t : src.getUseContext()) if (VersionConvertor_14_30.isJurisdiction(t))
            tgt.addJurisdiction(VersionConvertor_14_30.convertCodeableConcept(t));
        else
            tgt.addUseContext(VersionConvertor_14_30.convertCodeableConceptToUsageContext(t));
        if (src.hasRequirements())
            tgt.setPurpose(src.getRequirements());
        if (src.hasCopyright())
            tgt.setCopyright(src.getCopyright());
        for (org.hl7.fhir.dstu2016may.model.Coding t : src.getCode()) tgt.addKeyword(VersionConvertor_14_30.convertCoding(t));
        if (src.hasFhirVersion())
            tgt.setFhirVersion(src.getFhirVersion());
        for (org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionMappingComponent t : src.getMapping()) tgt.addMapping(convertStructureDefinitionMappingComponent(t));
        tgt.setKind(convertStructureDefinitionKind(src.getKind()));
        tgt.setAbstract(src.getAbstract());
        tgt.setContextType(convertExtensionContext(src.getContextType()));
        for (org.hl7.fhir.dstu2016may.model.StringType t : src.getContext()) tgt.addContext(t.getValue());
        if (src.getDerivation() == TypeDerivationRule.CONSTRAINT)
            tgt.setType(src.getBaseType());
        else
            tgt.setType(src.getId());
        if (src.hasBaseDefinition())
            tgt.setBaseDefinition(src.getBaseDefinition());
        tgt.setDerivation(convertTypeDerivationRule(src.getDerivation()));
        if (src.hasSnapshot()) {
            tgt.setSnapshot(convertStructureDefinitionSnapshotComponent(src.getSnapshot()));
            tgt.getSnapshot().getElementFirstRep().getType().clear();
        }
        if (src.hasDifferential()) {
            tgt.setDifferential(convertStructureDefinitionDifferentialComponent(src.getDifferential()));
            tgt.getDifferential().getElementFirstRep().getType().clear();
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionContactComponent convertStructureDefinitionContactComponent(org.hl7.fhir.dstu3.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionContactComponent tgt = new org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionContactComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasName())
            tgt.setName(src.getName());
        for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_14_30.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ContactDetail convertStructureDefinitionContactComponent(org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ContactDetail tgt = new org.hl7.fhir.dstu3.model.ContactDetail();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasName())
            tgt.setName(src.getName());
        for (org.hl7.fhir.dstu2016may.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_14_30.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionDifferentialComponent convertStructureDefinitionDifferentialComponent(org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionDifferentialComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionDifferentialComponent tgt = new org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionDifferentialComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        for (org.hl7.fhir.dstu3.model.ElementDefinition t : src.getElement()) tgt.addElement(VersionConvertor_14_30.convertElementDefinition(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionDifferentialComponent convertStructureDefinitionDifferentialComponent(org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionDifferentialComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionDifferentialComponent tgt = new org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionDifferentialComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        for (org.hl7.fhir.dstu2016may.model.ElementDefinition t : src.getElement()) tgt.addElement(VersionConvertor_14_30.convertElementDefinition(t));
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionKind convertStructureDefinitionKind(org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionKind src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PRIMITIVETYPE:
                return org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionKind.DATATYPE;
            case COMPLEXTYPE:
                return org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionKind.DATATYPE;
            case RESOURCE:
                return org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionKind.RESOURCE;
            case LOGICAL:
                return org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionKind.LOGICAL;
            default:
                return org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionKind.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionKind convertStructureDefinitionKind(org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionKind src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case DATATYPE:
                return org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionKind.COMPLEXTYPE;
            case RESOURCE:
                return org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionKind.RESOURCE;
            case LOGICAL:
                return org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionKind.LOGICAL;
            default:
                return org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionKind.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionMappingComponent convertStructureDefinitionMappingComponent(org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionMappingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionMappingComponent tgt = new org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionMappingComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        tgt.setIdentity(src.getIdentity());
        if (src.hasUri())
            tgt.setUri(src.getUri());
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasComments())
            tgt.setComment(src.getComments());
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionMappingComponent convertStructureDefinitionMappingComponent(org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionMappingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionMappingComponent tgt = new org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionMappingComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        tgt.setIdentity(src.getIdentity());
        if (src.hasUri())
            tgt.setUri(src.getUri());
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasComment())
            tgt.setComments(src.getComment());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionSnapshotComponent convertStructureDefinitionSnapshotComponent(org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionSnapshotComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionSnapshotComponent tgt = new org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionSnapshotComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        for (org.hl7.fhir.dstu2016may.model.ElementDefinition t : src.getElement()) tgt.addElement(VersionConvertor_14_30.convertElementDefinition(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionSnapshotComponent convertStructureDefinitionSnapshotComponent(org.hl7.fhir.dstu3.model.StructureDefinition.StructureDefinitionSnapshotComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionSnapshotComponent tgt = new org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionSnapshotComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        for (org.hl7.fhir.dstu3.model.ElementDefinition t : src.getElement()) tgt.addElement(VersionConvertor_14_30.convertElementDefinition(t));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.StructureDefinition.TypeDerivationRule convertTypeDerivationRule(org.hl7.fhir.dstu2016may.model.StructureDefinition.TypeDerivationRule src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case SPECIALIZATION:
                return org.hl7.fhir.dstu3.model.StructureDefinition.TypeDerivationRule.SPECIALIZATION;
            case CONSTRAINT:
                return org.hl7.fhir.dstu3.model.StructureDefinition.TypeDerivationRule.CONSTRAINT;
            default:
                return org.hl7.fhir.dstu3.model.StructureDefinition.TypeDerivationRule.NULL;
        }
    }

    static public org.hl7.fhir.dstu2016may.model.StructureDefinition.TypeDerivationRule convertTypeDerivationRule(org.hl7.fhir.dstu3.model.StructureDefinition.TypeDerivationRule src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case SPECIALIZATION:
                return org.hl7.fhir.dstu2016may.model.StructureDefinition.TypeDerivationRule.SPECIALIZATION;
            case CONSTRAINT:
                return org.hl7.fhir.dstu2016may.model.StructureDefinition.TypeDerivationRule.CONSTRAINT;
            default:
                return org.hl7.fhir.dstu2016may.model.StructureDefinition.TypeDerivationRule.NULL;
        }
    }
}
