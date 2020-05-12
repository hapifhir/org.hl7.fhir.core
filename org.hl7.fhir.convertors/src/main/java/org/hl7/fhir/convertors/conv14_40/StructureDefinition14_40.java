package org.hl7.fhir.convertors.conv14_40;

import org.hl7.fhir.convertors.VersionConvertor_14_40;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.ElementDefinition;
import org.hl7.fhir.r4.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.utilities.Utilities;

public class StructureDefinition14_40 {

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureDefinition.ExtensionContextType> convertExtensionContext(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.StructureDefinition.ExtensionContext> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureDefinition.ExtensionContextType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.StructureDefinition.ExtensionContextTypeEnumFactory());
        VersionConvertor_14_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case RESOURCE:
                tgt.setValue(org.hl7.fhir.r4.model.StructureDefinition.ExtensionContextType.ELEMENT);
                break;
            case DATATYPE:
                tgt.setValue(org.hl7.fhir.r4.model.StructureDefinition.ExtensionContextType.ELEMENT);
                break;
            case EXTENSION:
                tgt.setValue(org.hl7.fhir.r4.model.StructureDefinition.ExtensionContextType.EXTENSION);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.StructureDefinition.ExtensionContextType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.StructureDefinition.ExtensionContext> convertExtensionContext(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureDefinition.ExtensionContextType> src, String expression) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.StructureDefinition.ExtensionContext> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.StructureDefinition.ExtensionContextEnumFactory());
        VersionConvertor_14_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case FHIRPATH:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.StructureDefinition.ExtensionContext.RESOURCE);
                break;
            case ELEMENT:
                String tn = expression.contains(".") ? expression.substring(0, expression.indexOf(".")) : expression;
                if (isResource140(tn)) {
                    tgt.setValue(org.hl7.fhir.dstu2016may.model.StructureDefinition.ExtensionContext.RESOURCE);
                } else {
                    tgt.setValue(org.hl7.fhir.dstu2016may.model.StructureDefinition.ExtensionContext.DATATYPE);
                }
                break;
            case EXTENSION:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.StructureDefinition.ExtensionContext.EXTENSION);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.StructureDefinition.ExtensionContext.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.StructureDefinition convertStructureDefinition(org.hl7.fhir.r4.model.StructureDefinition src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.StructureDefinition tgt = new org.hl7.fhir.dstu2016may.model.StructureDefinition();
        VersionConvertor_14_40.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(VersionConvertor_14_40.convertUri(src.getUrlElement()));
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_14_40.convertIdentifier(t));
        if (src.hasVersion())
            tgt.setVersionElement(VersionConvertor_14_40.convertString(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_14_40.convertString(src.getNameElement()));
        if (src.hasTitle())
            tgt.setDisplayElement(VersionConvertor_14_40.convertString(src.getTitleElement()));
        if (src.hasStatus())
            tgt.setStatusElement(VersionConvertor_14_40.convertConformanceResourceStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(VersionConvertor_14_40.convertBoolean(src.getExperimentalElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(VersionConvertor_14_40.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact()) tgt.addContact(convertStructureDefinitionContactComponent(t));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_14_40.convertDateTime(src.getDateElement()));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext()) if (t.hasValueCodeableConcept())
            tgt.addUseContext(VersionConvertor_14_40.convertCodeableConcept(t.getValueCodeableConcept()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction()) tgt.addUseContext(VersionConvertor_14_40.convertCodeableConcept(t));
        if (src.hasPurpose())
            tgt.setRequirements(src.getPurpose());
        if (src.hasCopyright())
            tgt.setCopyright(src.getCopyright());
        for (org.hl7.fhir.r4.model.Coding t : src.getKeyword()) tgt.addCode(VersionConvertor_14_40.convertCoding(t));
        if (src.hasFhirVersion())
            tgt.setFhirVersion(src.getFhirVersion().toCode());
        for (org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionMappingComponent t : src.getMapping()) tgt.addMapping(convertStructureDefinitionMappingComponent(t));
        if (src.hasKind())
            tgt.setKindElement(convertStructureDefinitionKind(src.getKindElement()));
        if (src.hasAbstractElement())
            tgt.setAbstractElement(VersionConvertor_14_40.convertBoolean(src.getAbstractElement()));
        for (org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionContextComponent t : src.getContext()) {
            if (!tgt.hasContextType())
                tgt.setContextTypeElement(convertExtensionContext(t.getTypeElement(), t.getExpression()));
            tgt.addContext("Element".equals(t.getExpression()) ? "*" : t.getExpression());
        }
        if (src.hasBaseDefinition())
            tgt.setBaseDefinition(src.getBaseDefinition());
        if (src.hasType() && src.getDerivation() == org.hl7.fhir.r4.model.StructureDefinition.TypeDerivationRule.CONSTRAINT)
            tgt.setBaseType(src.getType());
        if (src.hasDerivation())
            tgt.setDerivationElement(convertTypeDerivationRule(src.getDerivationElement()));
        if (src.hasSnapshot())
            tgt.setSnapshot(convertStructureDefinitionSnapshotComponent(src.getSnapshot()));
        if (src.hasDifferential())
            tgt.setDifferential(convertStructureDefinitionDifferentialComponent(src.getDifferential()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.StructureDefinition convertStructureDefinition(org.hl7.fhir.dstu2016may.model.StructureDefinition src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.StructureDefinition tgt = new org.hl7.fhir.r4.model.StructureDefinition();
        VersionConvertor_14_40.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(VersionConvertor_14_40.convertUri(src.getUrlElement()));
        for (org.hl7.fhir.dstu2016may.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_14_40.convertIdentifier(t));
        if (src.hasVersion())
            tgt.setVersionElement(VersionConvertor_14_40.convertString(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_14_40.convertString(src.getNameElement()));
        if (src.hasDisplay())
            tgt.setTitleElement(VersionConvertor_14_40.convertString(src.getDisplayElement()));
        if (src.hasStatus())
            tgt.setStatusElement(VersionConvertor_14_40.convertConformanceResourceStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(VersionConvertor_14_40.convertBoolean(src.getExperimentalElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(VersionConvertor_14_40.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionContactComponent t : src.getContact()) tgt.addContact(convertStructureDefinitionContactComponent(t));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_14_40.convertDateTime(src.getDateElement()));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu2016may.model.CodeableConcept t : src.getUseContext()) if (VersionConvertor_14_40.isJurisdiction(t))
            tgt.addJurisdiction(VersionConvertor_14_40.convertCodeableConcept(t));
        else
            tgt.addUseContext(VersionConvertor_14_40.convertCodeableConceptToUsageContext(t));
        if (src.hasRequirements())
            tgt.setPurpose(src.getRequirements());
        if (src.hasCopyright())
            tgt.setCopyright(src.getCopyright());
        for (org.hl7.fhir.dstu2016may.model.Coding t : src.getCode()) tgt.addKeyword(VersionConvertor_14_40.convertCoding(t));
        if (src.hasFhirVersion())
            tgt.setFhirVersion(org.hl7.fhir.r4.model.Enumerations.FHIRVersion.fromCode(src.getFhirVersion()));
        for (org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionMappingComponent t : src.getMapping()) tgt.addMapping(convertStructureDefinitionMappingComponent(t));
        if (src.hasKind())
            tgt.setKindElement(convertStructureDefinitionKind(src.getKindElement(), src.getName()));
        if (src.hasAbstractElement())
            tgt.setAbstractElement(VersionConvertor_14_40.convertBoolean(src.getAbstractElement()));
        for (org.hl7.fhir.dstu2016may.model.StringType t : src.getContext()) {
            org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionContextComponent ec = tgt.addContext();
            ec.setTypeElement(convertExtensionContext(src.getContextTypeElement()));
            ec.setExpression("*".equals(t.getValue()) ? "Element" : t.getValue());
        }
        if (src.getDerivation() == org.hl7.fhir.dstu2016may.model.StructureDefinition.TypeDerivationRule.CONSTRAINT)
            tgt.setType(src.getBaseType());
        else
            tgt.setType(src.getId());
        if (src.hasBaseDefinition())
            tgt.setBaseDefinition(src.getBaseDefinition());
        if (src.hasDerivation())
            tgt.setDerivationElement(convertTypeDerivationRule(src.getDerivationElement()));
        if (src.hasSnapshot()) {
            if (src.hasSnapshot())
                tgt.setSnapshot(convertStructureDefinitionSnapshotComponent(src.getSnapshot()));
            tgt.getSnapshot().getElementFirstRep().getType().clear();
        }
        if (src.hasDifferential()) {
            if (src.hasDifferential())
                tgt.setDifferential(convertStructureDefinitionDifferentialComponent(src.getDifferential()));
            tgt.getDifferential().getElementFirstRep().getType().clear();
        }
        if (tgt.getDerivation() == TypeDerivationRule.SPECIALIZATION) {
            for (ElementDefinition ed : tgt.getSnapshot().getElement()) {
                if (!ed.hasBase()) {
                    ed.getBase().setPath(ed.getPath()).setMin(ed.getMin()).setMax(ed.getMax());
                }
            }
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ContactDetail convertStructureDefinitionContactComponent(org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ContactDetail tgt = new org.hl7.fhir.r4.model.ContactDetail();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_14_40.convertString(src.getNameElement()));
        for (org.hl7.fhir.dstu2016may.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_14_40.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionContactComponent convertStructureDefinitionContactComponent(org.hl7.fhir.r4.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionContactComponent tgt = new org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionContactComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_14_40.convertString(src.getNameElement()));
        for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_14_40.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionDifferentialComponent convertStructureDefinitionDifferentialComponent(org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionDifferentialComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionDifferentialComponent tgt = new org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionDifferentialComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.ElementDefinition t : src.getElement()) tgt.addElement(VersionConvertor_14_40.convertElementDefinition(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionDifferentialComponent convertStructureDefinitionDifferentialComponent(org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionDifferentialComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionDifferentialComponent tgt = new org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionDifferentialComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        for (org.hl7.fhir.dstu2016may.model.ElementDefinition t : src.getElement()) tgt.addElement(VersionConvertor_14_40.convertElementDefinition(t, src.getElement(), src.getElement().indexOf(t)));
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionKind> convertStructureDefinitionKind(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionKind> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionKind> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionKindEnumFactory());
        VersionConvertor_14_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case PRIMITIVETYPE:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionKind.DATATYPE);
                break;
            case COMPLEXTYPE:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionKind.DATATYPE);
                break;
            case RESOURCE:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionKind.RESOURCE);
                break;
            case LOGICAL:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionKind.LOGICAL);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionKind.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionKind> convertStructureDefinitionKind(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionKind> src, String name) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionKind> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionKindEnumFactory());
        VersionConvertor_14_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case DATATYPE:
                if (name.substring(0, 1).toLowerCase().equals(name.substring(0, 1))) {
                    tgt.setValue(org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionKind.PRIMITIVETYPE);
                } else {
                    tgt.setValue(org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionKind.COMPLEXTYPE);
                }
                break;
            case RESOURCE:
                tgt.setValue(org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionKind.RESOURCE);
                break;
            case LOGICAL:
                tgt.setValue(org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionKind.LOGICAL);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionKind.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionMappingComponent convertStructureDefinitionMappingComponent(org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionMappingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionMappingComponent tgt = new org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionMappingComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasIdentityElement())
            tgt.setIdentityElement(VersionConvertor_14_40.convertId(src.getIdentityElement()));
        if (src.hasUri())
            tgt.setUriElement(VersionConvertor_14_40.convertUri(src.getUriElement()));
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_14_40.convertString(src.getNameElement()));
        if (src.hasComment())
            tgt.setCommentsElement(VersionConvertor_14_40.convertString(src.getCommentElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionMappingComponent convertStructureDefinitionMappingComponent(org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionMappingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionMappingComponent tgt = new org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionMappingComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasIdentityElement())
            tgt.setIdentityElement(VersionConvertor_14_40.convertId(src.getIdentityElement()));
        if (src.hasUri())
            tgt.setUriElement(VersionConvertor_14_40.convertUri(src.getUriElement()));
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_14_40.convertString(src.getNameElement()));
        if (src.hasComments())
            tgt.setCommentElement(VersionConvertor_14_40.convertString(src.getCommentsElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionSnapshotComponent convertStructureDefinitionSnapshotComponent(org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionSnapshotComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionSnapshotComponent tgt = new org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionSnapshotComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        for (org.hl7.fhir.dstu2016may.model.ElementDefinition t : src.getElement()) tgt.addElement(VersionConvertor_14_40.convertElementDefinition(t, src.getElement(), src.getElement().indexOf(t)));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionSnapshotComponent convertStructureDefinitionSnapshotComponent(org.hl7.fhir.r4.model.StructureDefinition.StructureDefinitionSnapshotComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionSnapshotComponent tgt = new org.hl7.fhir.dstu2016may.model.StructureDefinition.StructureDefinitionSnapshotComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.ElementDefinition t : src.getElement()) tgt.addElement(VersionConvertor_14_40.convertElementDefinition(t));
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.StructureDefinition.TypeDerivationRule> convertTypeDerivationRule(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureDefinition.TypeDerivationRule> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.StructureDefinition.TypeDerivationRule> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.StructureDefinition.TypeDerivationRuleEnumFactory());
        VersionConvertor_14_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case SPECIALIZATION:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.StructureDefinition.TypeDerivationRule.SPECIALIZATION);
                break;
            case CONSTRAINT:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.StructureDefinition.TypeDerivationRule.CONSTRAINT);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.StructureDefinition.TypeDerivationRule.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureDefinition.TypeDerivationRule> convertTypeDerivationRule(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.StructureDefinition.TypeDerivationRule> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureDefinition.TypeDerivationRule> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.StructureDefinition.TypeDerivationRuleEnumFactory());
        VersionConvertor_14_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case SPECIALIZATION:
                tgt.setValue(org.hl7.fhir.r4.model.StructureDefinition.TypeDerivationRule.SPECIALIZATION);
                break;
            case CONSTRAINT:
                tgt.setValue(org.hl7.fhir.r4.model.StructureDefinition.TypeDerivationRule.CONSTRAINT);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.StructureDefinition.TypeDerivationRule.NULL);
                break;
        }
        return tgt;
    }

    static public boolean isResource140(String tn) {
        return Utilities.existsInList(tn, "Account", "AllergyIntolerance", "Appointment", "AppointmentResponse", "AuditEvent", "Basic", "Binary", "BodySite", "Bundle", "CarePlan", "CareTeam", "Claim", "ClaimResponse", "ClinicalImpression", "CodeSystem", "Communication", "CommunicationRequest", "CompartmentDefinition", "Composition", "ConceptMap", "Condition", "Conformance", "Contract", "Coverage", "DataElement", "DecisionSupportRule", "DecisionSupportServiceModule", "DetectedIssue", "Device", "DeviceComponent", "DeviceMetric", "DeviceUseRequest", "DeviceUseStatement", "DiagnosticOrder", "DiagnosticReport", "DocumentManifest", "DocumentReference", "EligibilityRequest", "EligibilityResponse", "Encounter", "EnrollmentRequest", "EnrollmentResponse", "EpisodeOfCare", "ExpansionProfile", "ExplanationOfBenefit", "FamilyMemberHistory", "Flag", "Goal", "Group", "GuidanceResponse", "HealthcareService", "ImagingExcerpt", "ImagingObjectSelection", "ImagingStudy", "Immunization", "ImmunizationRecommendation", "ImplementationGuide", "Library", "Linkage", "List", "Location", "Measure", "MeasureReport", "Media", "Medication", "MedicationAdministration", "MedicationDispense", "MedicationOrder", "MedicationStatement", "MessageHeader", "ModuleDefinition", "NamingSystem", "NutritionOrder", "Observation", "OperationDefinition", "OperationOutcome", "Order", "OrderResponse", "OrderSet", "Organization", "Parameters", "Patient", "PaymentNotice", "PaymentReconciliation", "Person", "Practitioner", "PractitionerRole", "Procedure", "ProcedureRequest", "ProcessRequest", "ProcessResponse", "Protocol", "Provenance", "Questionnaire", "QuestionnaireResponse", "ReferralRequest", "RelatedPerson", "RiskAssessment", "Schedule", "SearchParameter", "Sequence", "Slot", "Sequence", "Specimen", "StructureDefinition", "StructureMap", "Subscription", "Substance", "SupplyDelivery", "SupplyRequest", "Task", "TestScript", "ValueSet", "VisionPrescription");
    }
}