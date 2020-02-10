package org.hl7.fhir.convertors.conv14_50;

import org.hl7.fhir.convertors.VersionConvertor_14_50;
import org.hl7.fhir.dstu2016may.model.StructureMap;
import org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapContextType;
import org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapListMode;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.Enumeration;
import org.hl7.fhir.r5.model.StringType;

import java.util.Collections;

public class StructureMap14_50 {

    public static org.hl7.fhir.r5.model.StructureMap convertStructureMap(org.hl7.fhir.dstu2016may.model.StructureMap src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.StructureMap tgt = new org.hl7.fhir.r5.model.StructureMap();
        VersionConvertor_14_50.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.r5.model.UriType) VersionConvertor_14_50.convertType(src.getUrlElement()));
        if (src.hasVersionElement())
            tgt.setVersionElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_14_50.convertType(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_14_50.convertType(src.getNameElement()));
        if (src.hasStatus()) {
            tgt.setStatus(VersionConvertor_14_50.convertConformanceResourceStatus(src.getStatus()));
        }
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu2016may.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_14_50.convertIdentifier(t));
        }
        if (src.hasExperimentalElement())
            tgt.setExperimentalElement((org.hl7.fhir.r5.model.BooleanType) VersionConvertor_14_50.convertType(src.getExperimentalElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_14_50.convertType(src.getPublisherElement()));
        if (src.hasContact()) {
            for (org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapContactComponent t : src.getContact()) tgt.addContact(convertStructureMapContactComponent(t));
        }
        if (src.hasDateElement())
            tgt.setDateElement((org.hl7.fhir.r5.model.DateTimeType) VersionConvertor_14_50.convertType(src.getDateElement()));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu2016may.model.CodeableConcept t : src.getUseContext()) if (VersionConvertor_14_50.isJurisdiction(t))
            tgt.addJurisdiction(VersionConvertor_14_50.convertCodeableConcept(t));
        else
            tgt.addUseContext(VersionConvertor_14_50.convertCodeableConceptToUsageContext(t));
        if (src.hasRequirements())
            tgt.setPurpose(src.getRequirements());
        if (src.hasCopyright())
            tgt.setCopyright(src.getCopyright());
        if (src.hasStructure()) {
            for (org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapStructureComponent t : src.getStructure()) tgt.addStructure(convertStructureMapStructureComponent(t));
        }
        if (src.hasImport()) {
            for (org.hl7.fhir.dstu2016may.model.UriType t : src.getImport()) tgt.addImport(t.getValue());
        }
        if (src.hasGroup()) {
            for (org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupComponent t : src.getGroup()) tgt.addGroup(convertStructureMapGroupComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.StructureMap convertStructureMap(org.hl7.fhir.r5.model.StructureMap src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.StructureMap tgt = new org.hl7.fhir.dstu2016may.model.StructureMap();
        VersionConvertor_14_50.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.dstu2016may.model.UriType) VersionConvertor_14_50.convertType(src.getUrlElement()));
        if (src.hasVersionElement())
            tgt.setVersionElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_50.convertType(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_50.convertType(src.getNameElement()));
        if (src.hasStatus()) {
            tgt.setStatus(VersionConvertor_14_50.convertConformanceResourceStatus(src.getStatus()));
        }
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_14_50.convertIdentifier(t));
        }
        if (src.hasExperimentalElement())
            tgt.setExperimentalElement((org.hl7.fhir.dstu2016may.model.BooleanType) VersionConvertor_14_50.convertType(src.getExperimentalElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_50.convertType(src.getPublisherElement()));
        if (src.hasContact()) {
            for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact()) tgt.addContact(convertStructureMapContactComponent(t));
        }
        if (src.hasDateElement())
            tgt.setDateElement((org.hl7.fhir.dstu2016may.model.DateTimeType) VersionConvertor_14_50.convertType(src.getDateElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_50.convertType(src.getDescriptionElement()));
        for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext()) if (t.hasValueCodeableConcept())
            tgt.addUseContext(VersionConvertor_14_50.convertCodeableConcept(t.getValueCodeableConcept()));
        if (src.hasJurisdiction()) {
            for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction()) tgt.addUseContext(VersionConvertor_14_50.convertCodeableConcept(t));
        }
        if (src.hasPurpose())
            tgt.setRequirements(src.getPurpose());
        if (src.hasCopyrightElement())
            tgt.setCopyrightElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_50.convertType(src.getCopyrightElement()));
        if (src.hasStructure()) {
            for (org.hl7.fhir.r5.model.StructureMap.StructureMapStructureComponent t : src.getStructure()) tgt.addStructure(convertStructureMapStructureComponent(t));
        }
        if (src.hasImport()) {
            for (org.hl7.fhir.r5.model.UriType t : src.getImport()) tgt.addImport(t.getValue());
        }
        if (src.hasGroup()) {
            for (org.hl7.fhir.r5.model.StructureMap.StructureMapGroupComponent t : src.getGroup()) tgt.addGroup(convertStructureMapGroupComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ContactDetail convertStructureMapContactComponent(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ContactDetail tgt = new org.hl7.fhir.r5.model.ContactDetail();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((StringType) VersionConvertor_14_50.convertType(src.getNameElement()));
        if (src.hasTelecom()) {
            for (org.hl7.fhir.dstu2016may.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_14_50.convertContactPoint(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapContactComponent convertStructureMapContactComponent(org.hl7.fhir.r5.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapContactComponent tgt = new org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapContactComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_50.convertType(src.getNameElement()));
        if (src.hasTelecom()) {
            for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_14_50.convertContactPoint(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.StructureMap.StructureMapContextType convertStructureMapContextType(StructureMapContextType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case TYPE:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapContextType.TYPE;
            case VARIABLE:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapContextType.VARIABLE;
            default:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapContextType.NULL;
        }
    }

    public static org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapContextType convertStructureMapContextType(org.hl7.fhir.r5.model.StructureMap.StructureMapContextType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case TYPE:
                return org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapContextType.TYPE;
            case VARIABLE:
                return org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapContextType.VARIABLE;
            default:
                return org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapContextType.NULL;
        }
    }

    public static org.hl7.fhir.r5.model.StructureMap.StructureMapGroupComponent convertStructureMapGroupComponent(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.StructureMap.StructureMapGroupComponent tgt = new org.hl7.fhir.r5.model.StructureMap.StructureMapGroupComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.r5.model.IdType) VersionConvertor_14_50.convertType(src.getNameElement()));
        if (src.hasExtendsElement())
            tgt.setExtendsElement((org.hl7.fhir.r5.model.IdType) VersionConvertor_14_50.convertType(src.getExtendsElement()));
        tgt.setTypeMode(org.hl7.fhir.r5.model.StructureMap.StructureMapGroupTypeMode.NONE);
        if (src.hasDocumentationElement())
            tgt.setDocumentationElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_14_50.convertType(src.getDocumentationElement()));
        if (src.hasInput()) {
            for (org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupInputComponent t : src.getInput()) tgt.addInput(convertStructureMapGroupInputComponent(t));
        }
        if (src.hasRule()) {
            for (org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleComponent t : src.getRule()) tgt.addRule(convertStructureMapGroupRuleComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupComponent convertStructureMapGroupComponent(org.hl7.fhir.r5.model.StructureMap.StructureMapGroupComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupComponent tgt = new org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu2016may.model.IdType) VersionConvertor_14_50.convertType(src.getNameElement()));
        if (src.hasExtendsElement())
            tgt.setExtendsElement((org.hl7.fhir.dstu2016may.model.IdType) VersionConvertor_14_50.convertType(src.getExtendsElement()));
        if (!src.getTypeMode().equals(org.hl7.fhir.r5.model.StructureMap.StructureMapGroupTypeMode.NONE))
            throw new FHIRException("Unable to downgrade structure map with group.typeMode other than 'None': " + src.getTypeMode().getDisplay());
        if (src.hasDocumentationElement())
            tgt.setDocumentationElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_50.convertType(src.getDocumentationElement()));
        if (src.hasInput()) {
            for (org.hl7.fhir.r5.model.StructureMap.StructureMapGroupInputComponent t : src.getInput()) tgt.addInput(convertStructureMapGroupInputComponent(t));
        }
        if (src.hasRule()) {
            for (org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleComponent t : src.getRule()) tgt.addRule(convertStructureMapGroupRuleComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupInputComponent convertStructureMapGroupInputComponent(org.hl7.fhir.r5.model.StructureMap.StructureMapGroupInputComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupInputComponent tgt = new org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupInputComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu2016may.model.IdType) VersionConvertor_14_50.convertType(src.getNameElement()));
        if (src.hasTypeElement())
            tgt.setTypeElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_50.convertType(src.getTypeElement()));
        if (src.hasMode()) {
            tgt.setMode(convertStructureMapInputMode(src.getMode()));
        }
        if (src.hasDocumentationElement())
            tgt.setDocumentationElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_50.convertType(src.getDocumentationElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.StructureMap.StructureMapGroupInputComponent convertStructureMapGroupInputComponent(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupInputComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.StructureMap.StructureMapGroupInputComponent tgt = new org.hl7.fhir.r5.model.StructureMap.StructureMapGroupInputComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.r5.model.IdType) VersionConvertor_14_50.convertType(src.getNameElement()));
        if (src.hasTypeElement())
            tgt.setTypeElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_14_50.convertType(src.getTypeElement()));
        if (src.hasMode()) {
            tgt.setMode(convertStructureMapInputMode(src.getMode()));
        }
        if (src.hasDocumentationElement())
            tgt.setDocumentationElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_14_50.convertType(src.getDocumentationElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleComponent convertStructureMapGroupRuleComponent(org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleComponent tgt = new org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu2016may.model.IdType) VersionConvertor_14_50.convertType(src.getNameElement()));
        if (src.hasSource()) {
            for (org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleSourceComponent t : src.getSource()) tgt.addSource(convertStructureMapGroupRuleSourceComponent(t));
        }
        if (src.hasTarget()) {
            for (org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleTargetComponent t : src.getTarget()) tgt.addTarget(convertStructureMapGroupRuleTargetComponent(t));
        }
        if (src.hasRule()) {
            for (org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleComponent t : src.getRule()) tgt.addRule(convertStructureMapGroupRuleComponent(t));
        }
        if (src.hasDependent()) {
            for (org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleDependentComponent t : src.getDependent()) tgt.addDependent(convertStructureMapGroupRuleDependentComponent(t));
        }
        if (src.hasDocumentationElement())
            tgt.setDocumentationElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_50.convertType(src.getDocumentationElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleComponent convertStructureMapGroupRuleComponent(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleComponent tgt = new org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.r5.model.IdType) VersionConvertor_14_50.convertType(src.getNameElement()));
        if (src.hasSource()) {
            for (org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleSourceComponent t : src.getSource()) tgt.addSource(convertStructureMapGroupRuleSourceComponent(t));
        }
        if (src.hasTarget()) {
            for (org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleTargetComponent t : src.getTarget()) tgt.addTarget(convertStructureMapGroupRuleTargetComponent(t));
        }
        if (src.hasRule()) {
            for (org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleComponent t : src.getRule()) tgt.addRule(convertStructureMapGroupRuleComponent(t));
        }
        if (src.hasDependent()) {
            for (org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleDependentComponent t : src.getDependent()) tgt.addDependent(convertStructureMapGroupRuleDependentComponent(t));
        }
        if (src.hasDocumentationElement())
            tgt.setDocumentationElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_14_50.convertType(src.getDocumentationElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleDependentComponent convertStructureMapGroupRuleDependentComponent(org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleDependentComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleDependentComponent tgt = new org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleDependentComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu2016may.model.IdType) VersionConvertor_14_50.convertType(src.getNameElement()));
        if (src.hasVariable()) {
            for (org.hl7.fhir.r5.model.StringType t : src.getVariable()) tgt.addVariable(t.asStringValue());
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleDependentComponent convertStructureMapGroupRuleDependentComponent(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleDependentComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleDependentComponent tgt = new org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleDependentComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.r5.model.IdType) VersionConvertor_14_50.convertType(src.getNameElement()));
        if (src.hasVariable()) {
            for (org.hl7.fhir.dstu2016may.model.StringType t : src.getVariable()) tgt.addVariable(t.asStringValue());
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleSourceComponent convertStructureMapGroupRuleSourceComponent(org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleSourceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleSourceComponent tgt = new org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleSourceComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        tgt.setContextType(StructureMapContextType.TYPE);
        if (src.hasContextElement())
            tgt.setContextElement((org.hl7.fhir.dstu2016may.model.IdType) VersionConvertor_14_50.convertType(src.getContextElement()));
        if (src.hasElementElement())
            tgt.setElementElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_50.convertType(src.getElementElement()));
        if (src.hasListMode())
            tgt.setListMode(convertStructureMapSourceListMode(src.getListMode()));
        if (src.hasVariableElement())
            tgt.setVariableElement((org.hl7.fhir.dstu2016may.model.IdType) VersionConvertor_14_50.convertType(src.getVariableElement()));
        if (src.hasConditionElement())
            tgt.setConditionElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_50.convertType(src.getConditionElement()));
        if (src.hasCheckElement())
            tgt.setCheckElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_50.convertType(src.getCheckElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleSourceComponent convertStructureMapGroupRuleSourceComponent(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleSourceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleSourceComponent tgt = new org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleSourceComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasRequired()) {
            tgt.setMin(src.getRequired() ? 1 : 0);
        }
        if (src.getContextType().equals(StructureMap.StructureMapContextType.TYPE))
            tgt.setContextElement((org.hl7.fhir.r5.model.IdType) VersionConvertor_14_50.convertType(src.getContextElement()));
        if (src.hasElementElement())
            tgt.setElementElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_14_50.convertType(src.getElementElement()));
        if (src.hasListMode())
            tgt.setListMode(convertStructureMapSourceListMode(src.getListMode()));
        if (src.hasVariableElement())
            tgt.setVariableElement((org.hl7.fhir.r5.model.IdType) VersionConvertor_14_50.convertType(src.getVariableElement()));
        if (src.hasConditionElement())
            tgt.setConditionElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_14_50.convertType(src.getConditionElement()));
        if (src.hasCheckElement())
            tgt.setCheckElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_14_50.convertType(src.getCheckElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleTargetComponent convertStructureMapGroupRuleTargetComponent(org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleTargetComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleTargetComponent tgt = new org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleTargetComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasContextElement())
            tgt.setContextElement((org.hl7.fhir.dstu2016may.model.IdType) VersionConvertor_14_50.convertType(src.getContextElement()));
        if (src.hasContextType())
            tgt.setContextType(convertStructureMapContextType(src.getContextType()));
        if (src.hasElementElement())
            tgt.setElementElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_50.convertType(src.getElementElement()));
        if (src.hasVariableElement())
            tgt.setVariableElement((org.hl7.fhir.dstu2016may.model.IdType) VersionConvertor_14_50.convertType(src.getVariableElement()));
        if (src.hasListMode()) {
            for (Enumeration<org.hl7.fhir.r5.model.StructureMap.StructureMapTargetListMode> t : src.getListMode()) tgt.addListMode(convertStructureMapTargetListMode(t.getValue()));
        }
        if (src.hasListRuleIdElement())
            tgt.setListRuleIdElement((org.hl7.fhir.dstu2016may.model.IdType) VersionConvertor_14_50.convertType(src.getListRuleIdElement()));
        if (src.hasTransform())
            tgt.setTransform(convertStructureMapTransform(src.getTransform()));
        if (src.hasParameter()) {
            for (org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleTargetParameterComponent t : src.getParameter()) tgt.addParameter(convertStructureMapGroupRuleTargetParameterComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleTargetComponent convertStructureMapGroupRuleTargetComponent(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleTargetComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleTargetComponent tgt = new org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleTargetComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasContextElement())
            tgt.setContextElement((org.hl7.fhir.r5.model.IdType) VersionConvertor_14_50.convertType(src.getContextElement()));
        if (src.hasContextType())
            tgt.setContextType(convertStructureMapContextType(src.getContextType()));
        if (src.hasElementElement())
            tgt.setElementElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_14_50.convertType(src.getElementElement()));
        if (src.hasVariableElement())
            tgt.setVariableElement((org.hl7.fhir.r5.model.IdType) VersionConvertor_14_50.convertType(src.getVariableElement()));
        if (src.hasListMode()) {
            for (org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapListMode> t : src.getListMode()) VersionConvertor_14_50.copyElement(t, tgt.addListModeElement().setValue(convertStructureMapTargetListMode(t.getValue())));
        }
        if (src.hasListRuleIdElement())
            tgt.setListRuleIdElement((org.hl7.fhir.r5.model.IdType) VersionConvertor_14_50.convertType(src.getListRuleIdElement()));
        if (src.hasTransform())
            tgt.setTransform(convertStructureMapTransform(src.getTransform()));
        if (src.hasParameter()) {
            for (org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleTargetParameterComponent t : src.getParameter()) tgt.addParameter(convertStructureMapGroupRuleTargetParameterComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleTargetParameterComponent convertStructureMapGroupRuleTargetParameterComponent(org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleTargetParameterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleTargetParameterComponent tgt = new org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleTargetParameterComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasValue()) {
            tgt.setValue(VersionConvertor_14_50.convertType(src.getValue()));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleTargetParameterComponent convertStructureMapGroupRuleTargetParameterComponent(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleTargetParameterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleTargetParameterComponent tgt = new org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleTargetParameterComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasValue()) {
            tgt.setValue(VersionConvertor_14_50.convertType(src.getValue()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapInputMode convertStructureMapInputMode(org.hl7.fhir.r5.model.StructureMap.StructureMapInputMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case SOURCE:
                return org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapInputMode.SOURCE;
            case TARGET:
                return org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapInputMode.TARGET;
            default:
                return org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapInputMode.NULL;
        }
    }

    public static org.hl7.fhir.r5.model.StructureMap.StructureMapInputMode convertStructureMapInputMode(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapInputMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case SOURCE:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapInputMode.SOURCE;
            case TARGET:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapInputMode.TARGET;
            default:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapInputMode.NULL;
        }
    }

    public static org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapListMode convertStructureMapSourceListMode(org.hl7.fhir.r5.model.StructureMap.StructureMapSourceListMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case FIRST:
                return org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapListMode.FIRST;
            case LAST:
                return org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapListMode.LAST;
            default:
                return org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapListMode.NULL;
        }
    }

    public static org.hl7.fhir.r5.model.StructureMap.StructureMapSourceListMode convertStructureMapSourceListMode(StructureMapListMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case FIRST:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapSourceListMode.FIRST;
            case LAST:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapSourceListMode.LAST;
            default:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapSourceListMode.NULL;
        }
    }

    public static org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapStructureComponent convertStructureMapStructureComponent(org.hl7.fhir.r5.model.StructureMap.StructureMapStructureComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapStructureComponent tgt = new org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapStructureComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.dstu2016may.model.UriType) VersionConvertor_14_50.convertType(src.getUrlElement()));
        if (src.hasMode()) {
            tgt.setMode(convertStructureMapStructureMode(src.getMode()));
        }
        if (src.hasDocumentationElement())
            tgt.setDocumentationElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_50.convertType(src.getDocumentationElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.StructureMap.StructureMapStructureComponent convertStructureMapStructureComponent(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapStructureComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.StructureMap.StructureMapStructureComponent tgt = new org.hl7.fhir.r5.model.StructureMap.StructureMapStructureComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.r5.model.CanonicalType) VersionConvertor_14_50.convertType(src.getUrlElement()));
        if (src.hasMode()) {
            tgt.setMode(convertStructureMapStructureMode(src.getMode()));
        }
        if (src.hasDocumentationElement())
            tgt.setDocumentationElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_14_50.convertType(src.getDocumentationElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapModelMode convertStructureMapStructureMode(org.hl7.fhir.r5.model.StructureMap.StructureMapModelMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PRODUCED:
                return org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapModelMode.PRODUCED;
            case QUERIED:
                return org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapModelMode.QUERIED;
            case SOURCE:
                return org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapModelMode.SOURCE;
            case TARGET:
                return org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapModelMode.TARGET;
            default:
                return org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapModelMode.NULL;
        }
    }

    public static org.hl7.fhir.r5.model.StructureMap.StructureMapModelMode convertStructureMapStructureMode(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapModelMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PRODUCED:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapModelMode.PRODUCED;
            case QUERIED:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapModelMode.QUERIED;
            case SOURCE:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapModelMode.SOURCE;
            case TARGET:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapModelMode.TARGET;
            default:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapModelMode.NULL;
        }
    }

    public static org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapListMode convertStructureMapTargetListMode(org.hl7.fhir.r5.model.StructureMap.StructureMapTargetListMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case FIRST:
                return org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapListMode.FIRST;
            case LAST:
                return org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapListMode.LAST;
            case SHARE:
                return org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapListMode.SHARE;
            default:
                return org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapListMode.NULL;
        }
    }

    public static org.hl7.fhir.r5.model.StructureMap.StructureMapTargetListMode convertStructureMapTargetListMode(StructureMapListMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case FIRST:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapTargetListMode.FIRST;
            case LAST:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapTargetListMode.LAST;
            case SHARE:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapTargetListMode.SHARE;
            default:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapTargetListMode.NULL;
        }
    }

    public static org.hl7.fhir.r5.model.StructureMap.StructureMapTransform convertStructureMapTransform(StructureMap.StructureMapTransform src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case APPEND:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.APPEND;
            case CAST:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.CAST;
            case COPY:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.COPY;
            case CREATE:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.CREATE;
            case DATEOP:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.DATEOP;
            case ESCAPE:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.ESCAPE;
            case EVALUATE:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.EVALUATE;
            case POINTER:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.POINTER;
            case REFERENCE:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.REFERENCE;
            case TRANSLATE:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.TRANSLATE;
            case TRUNCATE:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.TRUNCATE;
            case UUID:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.UUID;
            default:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.NULL;
        }
    }

    public static org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapTransform convertStructureMapTransform(org.hl7.fhir.r5.model.StructureMap.StructureMapTransform src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case APPEND:
                return org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapTransform.APPEND;
            case CAST:
                return org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapTransform.CAST;
            case COPY:
                return org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapTransform.COPY;
            case CREATE:
                return org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapTransform.CREATE;
            case DATEOP:
                return org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapTransform.DATEOP;
            case ESCAPE:
                return org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapTransform.ESCAPE;
            case EVALUATE:
                return org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapTransform.EVALUATE;
            case POINTER:
                return org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapTransform.POINTER;
            case REFERENCE:
                return org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapTransform.REFERENCE;
            case TRANSLATE:
                return org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapTransform.TRANSLATE;
            case TRUNCATE:
                return org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapTransform.TRUNCATE;
            case UUID:
                return org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapTransform.UUID;
            default:
                return org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapTransform.NULL;
        }
    }
}
