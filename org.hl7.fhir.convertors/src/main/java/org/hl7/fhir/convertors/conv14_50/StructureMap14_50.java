package org.hl7.fhir.convertors.conv14_50;

import org.hl7.fhir.convertors.VersionConvertor_14_50;
import org.hl7.fhir.dstu2016may.model.StructureMap;
import org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapContextType;
import org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapListMode;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.Enumeration;

import java.util.stream.Collectors;

public class StructureMap14_50 {

    public static org.hl7.fhir.r5.model.StructureMap convertStructureMap(org.hl7.fhir.dstu2016may.model.StructureMap src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.StructureMap tgt = new org.hl7.fhir.r5.model.StructureMap();
        VersionConvertor_14_50.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement(VersionConvertor_14_50.convertUri(src.getUrlElement()));
        if (src.hasVersion())
            tgt.setVersionElement(VersionConvertor_14_50.convertString(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_14_50.convertString(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatusElement(VersionConvertor_14_50.convertConformanceResourceStatus(src.getStatusElement()));
        for (org.hl7.fhir.dstu2016may.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_14_50.convertIdentifier(t));
        if (src.hasExperimental())
            tgt.setExperimentalElement(VersionConvertor_14_50.convertBoolean(src.getExperimentalElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(VersionConvertor_14_50.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapContactComponent t : src.getContact()) tgt.addContact(convertStructureMapContactComponent(t));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_14_50.convertDateTime(src.getDateElement()));
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
        for (org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapStructureComponent t : src.getStructure()) tgt.addStructure(convertStructureMapStructureComponent(t));
        for (org.hl7.fhir.dstu2016may.model.UriType t : src.getImport()) tgt.addImport(t.getValue());
        for (org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupComponent t : src.getGroup()) tgt.addGroup(convertStructureMapGroupComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.StructureMap convertStructureMap(org.hl7.fhir.r5.model.StructureMap src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.StructureMap tgt = new org.hl7.fhir.dstu2016may.model.StructureMap();
        VersionConvertor_14_50.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement(VersionConvertor_14_50.convertUri(src.getUrlElement()));
        if (src.hasVersion())
            tgt.setVersionElement(VersionConvertor_14_50.convertString(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_14_50.convertString(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatusElement(VersionConvertor_14_50.convertConformanceResourceStatus(src.getStatusElement()));
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_14_50.convertIdentifier(t));
        if (src.hasExperimental())
            tgt.setExperimentalElement(VersionConvertor_14_50.convertBoolean(src.getExperimentalElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(VersionConvertor_14_50.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact()) tgt.addContact(convertStructureMapContactComponent(t));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_14_50.convertDateTime(src.getDateElement()));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext()) if (t.hasValueCodeableConcept())
            tgt.addUseContext(VersionConvertor_14_50.convertCodeableConcept(t.getValueCodeableConcept()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction()) tgt.addUseContext(VersionConvertor_14_50.convertCodeableConcept(t));
        if (src.hasPurpose())
            tgt.setRequirements(src.getPurpose());
        if (src.hasCopyright())
            tgt.setCopyright(src.getCopyright());
        for (org.hl7.fhir.r5.model.StructureMap.StructureMapStructureComponent t : src.getStructure()) tgt.addStructure(convertStructureMapStructureComponent(t));
        for (org.hl7.fhir.r5.model.UriType t : src.getImport()) tgt.addImport(t.getValue());
        for (org.hl7.fhir.r5.model.StructureMap.StructureMapGroupComponent t : src.getGroup()) tgt.addGroup(convertStructureMapGroupComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ContactDetail convertStructureMapContactComponent(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ContactDetail tgt = new org.hl7.fhir.r5.model.ContactDetail();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_14_50.convertString(src.getNameElement()));
        for (org.hl7.fhir.dstu2016may.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_14_50.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapContactComponent convertStructureMapContactComponent(org.hl7.fhir.r5.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapContactComponent tgt = new org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapContactComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_14_50.convertString(src.getNameElement()));
        for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_14_50.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.StructureMap.StructureMapContextType> convertStructureMapContextType(org.hl7.fhir.dstu2016may.model.Enumeration<StructureMapContextType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.StructureMap.StructureMapContextType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.StructureMap.StructureMapContextTypeEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case TYPE:
                tgt.setValue(org.hl7.fhir.r5.model.StructureMap.StructureMapContextType.TYPE);
                break;
            case VARIABLE:
                tgt.setValue(org.hl7.fhir.r5.model.StructureMap.StructureMapContextType.VARIABLE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.StructureMap.StructureMapContextType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapContextType> convertStructureMapContextType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.StructureMap.StructureMapContextType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapContextType> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapContextTypeEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case TYPE:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapContextType.TYPE);
                break;
            case VARIABLE:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapContextType.VARIABLE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapContextType.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.StructureMap.StructureMapGroupComponent convertStructureMapGroupComponent(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.StructureMap.StructureMapGroupComponent tgt = new org.hl7.fhir.r5.model.StructureMap.StructureMapGroupComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_14_50.convertId(src.getNameElement()));
        if (src.hasExtends())
            tgt.setExtendsElement(VersionConvertor_14_50.convertId(src.getExtendsElement()));
        tgt.setTypeMode(org.hl7.fhir.r5.model.StructureMap.StructureMapGroupTypeMode.NONE);
        if (src.hasDocumentation())
            tgt.setDocumentationElement(VersionConvertor_14_50.convertString(src.getDocumentationElement()));
        for (org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupInputComponent t : src.getInput()) tgt.addInput(convertStructureMapGroupInputComponent(t));
        for (org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleComponent t : src.getRule()) tgt.addRule(convertStructureMapGroupRuleComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupComponent convertStructureMapGroupComponent(org.hl7.fhir.r5.model.StructureMap.StructureMapGroupComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupComponent tgt = new org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_14_50.convertId(src.getNameElement()));
        if (src.hasExtends())
            tgt.setExtendsElement(VersionConvertor_14_50.convertId(src.getExtendsElement()));
        if (!src.getTypeMode().equals(org.hl7.fhir.r5.model.StructureMap.StructureMapGroupTypeMode.NONE))
            throw new FHIRException("Unable to downgrade structure map with group.typeMode other than 'None': " + src.getTypeMode().getDisplay());
        if (src.hasDocumentation())
            tgt.setDocumentationElement(VersionConvertor_14_50.convertString(src.getDocumentationElement()));
        for (org.hl7.fhir.r5.model.StructureMap.StructureMapGroupInputComponent t : src.getInput()) tgt.addInput(convertStructureMapGroupInputComponent(t));
        for (org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleComponent t : src.getRule()) tgt.addRule(convertStructureMapGroupRuleComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupInputComponent convertStructureMapGroupInputComponent(org.hl7.fhir.r5.model.StructureMap.StructureMapGroupInputComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupInputComponent tgt = new org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupInputComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_14_50.convertId(src.getNameElement()));
        if (src.hasType())
            tgt.setTypeElement(VersionConvertor_14_50.convertString(src.getTypeElement()));
        if (src.hasMode())
            tgt.setModeElement(convertStructureMapInputMode(src.getModeElement()));
        if (src.hasDocumentation())
            tgt.setDocumentationElement(VersionConvertor_14_50.convertString(src.getDocumentationElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.StructureMap.StructureMapGroupInputComponent convertStructureMapGroupInputComponent(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupInputComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.StructureMap.StructureMapGroupInputComponent tgt = new org.hl7.fhir.r5.model.StructureMap.StructureMapGroupInputComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_14_50.convertId(src.getNameElement()));
        if (src.hasType())
            tgt.setTypeElement(VersionConvertor_14_50.convertString(src.getTypeElement()));
        if (src.hasMode())
            tgt.setModeElement(convertStructureMapInputMode(src.getModeElement()));
        if (src.hasDocumentation())
            tgt.setDocumentationElement(VersionConvertor_14_50.convertString(src.getDocumentationElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleComponent convertStructureMapGroupRuleComponent(org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleComponent tgt = new org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_14_50.convertId(src.getNameElement()));
        for (org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleSourceComponent t : src.getSource()) tgt.addSource(convertStructureMapGroupRuleSourceComponent(t));
        for (org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleTargetComponent t : src.getTarget()) tgt.addTarget(convertStructureMapGroupRuleTargetComponent(t));
        for (org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleComponent t : src.getRule()) tgt.addRule(convertStructureMapGroupRuleComponent(t));
        for (org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleDependentComponent t : src.getDependent()) tgt.addDependent(convertStructureMapGroupRuleDependentComponent(t));
        if (src.hasDocumentation())
            tgt.setDocumentationElement(VersionConvertor_14_50.convertString(src.getDocumentationElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleComponent convertStructureMapGroupRuleComponent(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleComponent tgt = new org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_14_50.convertId(src.getNameElement()));
        for (org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleSourceComponent t : src.getSource()) tgt.addSource(convertStructureMapGroupRuleSourceComponent(t));
        for (org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleTargetComponent t : src.getTarget()) tgt.addTarget(convertStructureMapGroupRuleTargetComponent(t));
        for (org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleComponent t : src.getRule()) tgt.addRule(convertStructureMapGroupRuleComponent(t));
        for (org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleDependentComponent t : src.getDependent()) tgt.addDependent(convertStructureMapGroupRuleDependentComponent(t));
        if (src.hasDocumentation())
            tgt.setDocumentationElement(VersionConvertor_14_50.convertString(src.getDocumentationElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleDependentComponent convertStructureMapGroupRuleDependentComponent(org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleDependentComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleDependentComponent tgt = new org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleDependentComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_14_50.convertId(src.getNameElement()));
        for (org.hl7.fhir.r5.model.StringType t : src.getVariable()) tgt.addVariable(t.asStringValue());
        return tgt;
    }

    public static org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleDependentComponent convertStructureMapGroupRuleDependentComponent(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleDependentComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleDependentComponent tgt = new org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleDependentComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_14_50.convertId(src.getNameElement()));
        for (org.hl7.fhir.dstu2016may.model.StringType t : src.getVariable()) tgt.addVariable(t.asStringValue());
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleSourceComponent convertStructureMapGroupRuleSourceComponent(org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleSourceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleSourceComponent tgt = new org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleSourceComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        tgt.setContextType(StructureMapContextType.TYPE);
        if (src.hasContextElement())
            tgt.setContextElement(VersionConvertor_14_50.convertId(src.getContextElement()));
        if (src.hasElement())
            tgt.setElementElement(VersionConvertor_14_50.convertString(src.getElementElement()));
        if (src.hasListMode())
            tgt.setListModeElement(convertStructureMapSourceListMode(src.getListModeElement()));
        if (src.hasVariable())
            tgt.setVariableElement(VersionConvertor_14_50.convertId(src.getVariableElement()));
        if (src.hasCondition())
            tgt.setConditionElement(VersionConvertor_14_50.convertString(src.getConditionElement()));
        if (src.hasCheck())
            tgt.setCheckElement(VersionConvertor_14_50.convertString(src.getCheckElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleSourceComponent convertStructureMapGroupRuleSourceComponent(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleSourceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleSourceComponent tgt = new org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleSourceComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        tgt.setMin(src.getRequired() ? 1 : 0);
        if (src.getContextType().equals(StructureMap.StructureMapContextType.TYPE))
            tgt.setType(src.getContext());
        if (src.hasElement())
            tgt.setElementElement(VersionConvertor_14_50.convertString(src.getElementElement()));
        if (src.hasListMode())
            tgt.setListModeElement(convertStructureMapSourceListMode(src.getListModeElement()));
        if (src.hasVariable())
            tgt.setVariableElement(VersionConvertor_14_50.convertId(src.getVariableElement()));
        if (src.hasCondition())
            tgt.setConditionElement(VersionConvertor_14_50.convertString(src.getConditionElement()));
        if (src.hasCheck())
            tgt.setCheckElement(VersionConvertor_14_50.convertString(src.getCheckElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleTargetComponent convertStructureMapGroupRuleTargetComponent(org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleTargetComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleTargetComponent tgt = new org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleTargetComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasContext())
            tgt.setContextElement(VersionConvertor_14_50.convertId(src.getContextElement()));
        if (src.hasContextType())
            tgt.setContextTypeElement(convertStructureMapContextType(src.getContextTypeElement()));
        if (src.hasElement())
            tgt.setElementElement(VersionConvertor_14_50.convertString(src.getElementElement()));
        if (src.hasVariable())
            tgt.setVariableElement(VersionConvertor_14_50.convertId(src.getVariableElement()));
        tgt.setListMode(src.getListMode().stream()
                .map(StructureMap14_50::convertStructureMapTargetListMode)
                .collect(Collectors.toList()));
        if (src.hasListRuleId())
            tgt.setListRuleIdElement(VersionConvertor_14_50.convertId(src.getListRuleIdElement()));
        if (src.hasTransform())
            tgt.setTransformElement(convertStructureMapTransform(src.getTransformElement()));
        for (org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleTargetParameterComponent t : src.getParameter()) tgt.addParameter(convertStructureMapGroupRuleTargetParameterComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleTargetComponent convertStructureMapGroupRuleTargetComponent(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleTargetComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleTargetComponent tgt = new org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleTargetComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasContext())
            tgt.setContextElement(VersionConvertor_14_50.convertId(src.getContextElement()));
        if (src.hasContextType())
            tgt.setContextTypeElement(convertStructureMapContextType(src.getContextTypeElement()));
        if (src.hasElement())
            tgt.setElementElement(VersionConvertor_14_50.convertString(src.getElementElement()));
        if (src.hasVariable())
            tgt.setVariableElement(VersionConvertor_14_50.convertId(src.getVariableElement()));
        tgt.setListMode(src.getListMode().stream()
                .map(StructureMap14_50::convertStructureMapTargetListMode)
                .collect(Collectors.toList()));
        if (src.hasListRuleId())
            tgt.setListRuleIdElement(VersionConvertor_14_50.convertId(src.getListRuleIdElement()));
        if (src.hasTransform())
            tgt.setTransformElement(convertStructureMapTransform(src.getTransformElement()));
        for (org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleTargetParameterComponent t : src.getParameter()) tgt.addParameter(convertStructureMapGroupRuleTargetParameterComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleTargetParameterComponent convertStructureMapGroupRuleTargetParameterComponent(org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleTargetParameterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleTargetParameterComponent tgt = new org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleTargetParameterComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValue(VersionConvertor_14_50.convertType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleTargetParameterComponent convertStructureMapGroupRuleTargetParameterComponent(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleTargetParameterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleTargetParameterComponent tgt = new org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleTargetParameterComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValue(VersionConvertor_14_50.convertType(src.getValue()));
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapInputMode> convertStructureMapInputMode(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.StructureMap.StructureMapInputMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapInputMode> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapInputModeEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case SOURCE:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapInputMode.SOURCE);
                break;
            case TARGET:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapInputMode.TARGET);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapInputMode.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.StructureMap.StructureMapInputMode> convertStructureMapInputMode(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapInputMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.StructureMap.StructureMapInputMode> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.StructureMap.StructureMapInputModeEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case SOURCE:
                tgt.setValue(org.hl7.fhir.r5.model.StructureMap.StructureMapInputMode.SOURCE);
                break;
            case TARGET:
                tgt.setValue(org.hl7.fhir.r5.model.StructureMap.StructureMapInputMode.TARGET);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.StructureMap.StructureMapInputMode.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapListMode> convertStructureMapSourceListMode(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.StructureMap.StructureMapSourceListMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapListMode> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapListModeEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case FIRST:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapListMode.FIRST);
                break;
            case LAST:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapListMode.LAST);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapListMode.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.StructureMap.StructureMapSourceListMode> convertStructureMapSourceListMode(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapListMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.StructureMap.StructureMapSourceListMode> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.StructureMap.StructureMapSourceListModeEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case FIRST:
                tgt.setValue(org.hl7.fhir.r5.model.StructureMap.StructureMapSourceListMode.FIRST);
                break;
            case LAST:
                tgt.setValue(org.hl7.fhir.r5.model.StructureMap.StructureMapSourceListMode.LAST);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.StructureMap.StructureMapSourceListMode.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapStructureComponent convertStructureMapStructureComponent(org.hl7.fhir.r5.model.StructureMap.StructureMapStructureComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapStructureComponent tgt = new org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapStructureComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasUrl())
            tgt.setUrl(src.getUrl());
        if (src.hasMode())
            tgt.setModeElement(convertStructureMapStructureMode(src.getModeElement()));
        if (src.hasDocumentation())
            tgt.setDocumentationElement(VersionConvertor_14_50.convertString(src.getDocumentationElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.StructureMap.StructureMapStructureComponent convertStructureMapStructureComponent(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapStructureComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.StructureMap.StructureMapStructureComponent tgt = new org.hl7.fhir.r5.model.StructureMap.StructureMapStructureComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasUrl())
            tgt.setUrl(src.getUrl());
        if (src.hasMode())
            tgt.setModeElement(convertStructureMapStructureMode(src.getModeElement()));
        if (src.hasDocumentation())
            tgt.setDocumentationElement(VersionConvertor_14_50.convertString(src.getDocumentationElement()));
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapModelMode> convertStructureMapStructureMode(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.StructureMap.StructureMapModelMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapModelMode> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapModelModeEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case PRODUCED:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapModelMode.PRODUCED);
                break;
            case QUERIED:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapModelMode.QUERIED);
                break;
            case SOURCE:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapModelMode.SOURCE);
                break;
            case TARGET:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapModelMode.TARGET);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapModelMode.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.StructureMap.StructureMapModelMode> convertStructureMapStructureMode(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapModelMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.StructureMap.StructureMapModelMode> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.StructureMap.StructureMapModelModeEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case PRODUCED:
                tgt.setValue(org.hl7.fhir.r5.model.StructureMap.StructureMapModelMode.PRODUCED);
                break;
            case QUERIED:
                tgt.setValue(org.hl7.fhir.r5.model.StructureMap.StructureMapModelMode.QUERIED);
                break;
            case SOURCE:
                tgt.setValue(org.hl7.fhir.r5.model.StructureMap.StructureMapModelMode.SOURCE);
                break;
            case TARGET:
                tgt.setValue(org.hl7.fhir.r5.model.StructureMap.StructureMapModelMode.TARGET);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.StructureMap.StructureMapModelMode.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapListMode> convertStructureMapTargetListMode(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.StructureMap.StructureMapTargetListMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapListMode> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapListModeEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case FIRST:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapListMode.FIRST);
                break;
            case LAST:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapListMode.LAST);
                break;
            case SHARE:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapListMode.SHARE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapListMode.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.StructureMap.StructureMapTargetListMode> convertStructureMapTargetListMode(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapListMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.StructureMap.StructureMapTargetListMode> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.StructureMap.StructureMapTargetListModeEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case FIRST:
                tgt.setValue(org.hl7.fhir.r5.model.StructureMap.StructureMapTargetListMode.FIRST);
                break;
            case LAST:
                tgt.setValue(org.hl7.fhir.r5.model.StructureMap.StructureMapTargetListMode.LAST);
                break;
            case SHARE:
                tgt.setValue(org.hl7.fhir.r5.model.StructureMap.StructureMapTargetListMode.SHARE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.StructureMap.StructureMapTargetListMode.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.StructureMap.StructureMapTransform> convertStructureMapTransform(org.hl7.fhir.dstu2016may.model.Enumeration<StructureMap.StructureMapTransform> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.StructureMap.StructureMapTransform> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.StructureMap.StructureMapTransformEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case APPEND:
                tgt.setValue(org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.APPEND);
            case CAST:
                tgt.setValue(org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.CAST);
            case COPY:
                tgt.setValue(org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.COPY);
            case CREATE:
                tgt.setValue(org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.CREATE);
            case DATEOP:
                tgt.setValue(org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.DATEOP);
            case ESCAPE:
                tgt.setValue(org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.ESCAPE);
            case EVALUATE:
                tgt.setValue(org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.EVALUATE);
            case POINTER:
                tgt.setValue(org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.POINTER);
            case REFERENCE:
                tgt.setValue(org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.REFERENCE);
            case TRANSLATE:
                tgt.setValue(org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.TRANSLATE);
            case TRUNCATE:
                tgt.setValue(org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.TRUNCATE);
            case UUID:
                tgt.setValue(org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.UUID);
            default:
                tgt.setValue(org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.NULL);
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapTransform> convertStructureMapTransform(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.StructureMap.StructureMapTransform> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapTransform> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapTransformEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case APPEND:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapTransform.APPEND);
                break;
            case CAST:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapTransform.CAST);
                break;
            case COPY:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapTransform.COPY);
                break;
            case CREATE:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapTransform.CREATE);
                break;
            case DATEOP:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapTransform.DATEOP);
                break;
            case ESCAPE:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapTransform.ESCAPE);
                break;
            case EVALUATE:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapTransform.EVALUATE);
                break;
            case POINTER:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapTransform.POINTER);
                break;
            case REFERENCE:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapTransform.REFERENCE);
                break;
            case TRANSLATE:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapTransform.TRANSLATE);
                break;
            case TRUNCATE:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapTransform.TRUNCATE);
                break;
            case UUID:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapTransform.UUID);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapTransform.NULL);
                break;
        }
        return tgt;
    }
}