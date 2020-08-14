package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;

import java.util.stream.Collectors;

public class StructureMap30_40 {

    public static org.hl7.fhir.dstu3.model.StructureMap convertStructureMap(org.hl7.fhir.r4.model.StructureMap src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.StructureMap tgt = new org.hl7.fhir.dstu3.model.StructureMap();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(VersionConvertor_30_40.convertUri(src.getUrlElement()));
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
            tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        if (src.hasVersion())
            tgt.setVersionElement(VersionConvertor_30_40.convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_40.convertString(src.getNameElement()));
        if (src.hasTitle())
            tgt.setTitleElement(VersionConvertor_30_40.convertString(src.getTitleElement()));
        if (src.hasStatus())
            tgt.setStatusElement(VersionConvertor_30_40.convertPublicationStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(VersionConvertor_30_40.convertBoolean(src.getExperimentalElement()));
        if (src.hasDateElement())
            tgt.setDateElement(VersionConvertor_30_40.convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(VersionConvertor_30_40.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact())
            tgt.addContact(VersionConvertor_30_40.convertContactDetail(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_30_40.convertMarkdown(src.getDescriptionElement()));
        for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext())
            tgt.addUseContext(VersionConvertor_30_40.convertUsageContext(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction())
            tgt.addJurisdiction(VersionConvertor_30_40.convertCodeableConcept(t));
        if (src.hasPurpose())
            tgt.setPurposeElement(VersionConvertor_30_40.convertMarkdown(src.getPurposeElement()));
        if (src.hasCopyright())
            tgt.setCopyrightElement(VersionConvertor_30_40.convertMarkdown(src.getCopyrightElement()));
        for (org.hl7.fhir.r4.model.StructureMap.StructureMapStructureComponent t : src.getStructure())
            tgt.addStructure(convertStructureMapStructureComponent(t));
        for (org.hl7.fhir.r4.model.UriType t : src.getImport()) tgt.addImport(t.getValue());
        for (org.hl7.fhir.r4.model.StructureMap.StructureMapGroupComponent t : src.getGroup())
            tgt.addGroup(convertStructureMapGroupComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.StructureMap convertStructureMap(org.hl7.fhir.dstu3.model.StructureMap src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.StructureMap tgt = new org.hl7.fhir.r4.model.StructureMap();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(VersionConvertor_30_40.convertUri(src.getUrlElement()));
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
            tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        if (src.hasVersion())
            tgt.setVersionElement(VersionConvertor_30_40.convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_40.convertString(src.getNameElement()));
        if (src.hasTitle())
            tgt.setTitleElement(VersionConvertor_30_40.convertString(src.getTitleElement()));
        if (src.hasStatus())
            tgt.setStatusElement(VersionConvertor_30_40.convertPublicationStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(VersionConvertor_30_40.convertBoolean(src.getExperimentalElement()));
        if (src.hasDateElement())
            tgt.setDateElement(VersionConvertor_30_40.convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(VersionConvertor_30_40.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact())
            tgt.addContact(VersionConvertor_30_40.convertContactDetail(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_30_40.convertMarkdown(src.getDescriptionElement()));
        for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext())
            tgt.addUseContext(VersionConvertor_30_40.convertUsageContext(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction())
            tgt.addJurisdiction(VersionConvertor_30_40.convertCodeableConcept(t));
        if (src.hasPurpose())
            tgt.setPurposeElement(VersionConvertor_30_40.convertMarkdown(src.getPurposeElement()));
        if (src.hasCopyright())
            tgt.setCopyrightElement(VersionConvertor_30_40.convertMarkdown(src.getCopyrightElement()));
        for (org.hl7.fhir.dstu3.model.StructureMap.StructureMapStructureComponent t : src.getStructure())
            tgt.addStructure(convertStructureMapStructureComponent(t));
        for (org.hl7.fhir.dstu3.model.UriType t : src.getImport()) tgt.addImport(t.getValue());
        for (org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupComponent t : src.getGroup())
            tgt.addGroup(convertStructureMapGroupComponent(t));
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureMap.StructureMapContextType> convertStructureMapContextType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.StructureMap.StructureMapContextType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureMap.StructureMapContextType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.StructureMap.StructureMapContextTypeEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch (src.getValue()) {
            case TYPE:
                tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapContextType.TYPE);
                break;
            case VARIABLE:
                tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapContextType.VARIABLE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapContextType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.StructureMap.StructureMapContextType> convertStructureMapContextType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureMap.StructureMapContextType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.StructureMap.StructureMapContextType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.StructureMap.StructureMapContextTypeEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch (src.getValue()) {
            case TYPE:
                tgt.setValue(org.hl7.fhir.dstu3.model.StructureMap.StructureMapContextType.TYPE);
                break;
            case VARIABLE:
                tgt.setValue(org.hl7.fhir.dstu3.model.StructureMap.StructureMapContextType.VARIABLE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.StructureMap.StructureMapContextType.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupComponent convertStructureMapGroupComponent(org.hl7.fhir.r4.model.StructureMap.StructureMapGroupComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupComponent tgt = new org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_40.convertId(src.getNameElement()));
        if (src.hasExtends())
            tgt.setExtendsElement(VersionConvertor_30_40.convertId(src.getExtendsElement()));
        if (src.hasTypeMode())
            tgt.setTypeModeElement(convertStructureMapGroupTypeMode(src.getTypeModeElement()));
        if (src.hasDocumentation())
            tgt.setDocumentationElement(VersionConvertor_30_40.convertString(src.getDocumentationElement()));
        for (org.hl7.fhir.r4.model.StructureMap.StructureMapGroupInputComponent t : src.getInput())
            tgt.addInput(convertStructureMapGroupInputComponent(t));
        for (org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleComponent t : src.getRule())
            tgt.addRule(convertStructureMapGroupRuleComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.StructureMap.StructureMapGroupComponent convertStructureMapGroupComponent(org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.StructureMap.StructureMapGroupComponent tgt = new org.hl7.fhir.r4.model.StructureMap.StructureMapGroupComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_40.convertId(src.getNameElement()));
        if (src.hasExtends())
            tgt.setExtendsElement(VersionConvertor_30_40.convertId(src.getExtendsElement()));
        if (src.hasTypeMode())
            tgt.setTypeModeElement(convertStructureMapGroupTypeMode(src.getTypeModeElement()));
        if (src.hasDocumentation())
            tgt.setDocumentationElement(VersionConvertor_30_40.convertString(src.getDocumentationElement()));
        for (org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupInputComponent t : src.getInput())
            tgt.addInput(convertStructureMapGroupInputComponent(t));
        for (org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupRuleComponent t : src.getRule())
            tgt.addRule(convertStructureMapGroupRuleComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupInputComponent convertStructureMapGroupInputComponent(org.hl7.fhir.r4.model.StructureMap.StructureMapGroupInputComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupInputComponent tgt = new org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupInputComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_40.convertId(src.getNameElement()));
        if (src.hasType())
            tgt.setTypeElement(VersionConvertor_30_40.convertString(src.getTypeElement()));
        if (src.hasMode())
            tgt.setModeElement(convertStructureMapInputMode(src.getModeElement()));
        if (src.hasDocumentation())
            tgt.setDocumentationElement(VersionConvertor_30_40.convertString(src.getDocumentationElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.StructureMap.StructureMapGroupInputComponent convertStructureMapGroupInputComponent(org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupInputComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.StructureMap.StructureMapGroupInputComponent tgt = new org.hl7.fhir.r4.model.StructureMap.StructureMapGroupInputComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_40.convertId(src.getNameElement()));
        if (src.hasType())
            tgt.setTypeElement(VersionConvertor_30_40.convertString(src.getTypeElement()));
        if (src.hasMode())
            tgt.setModeElement(convertStructureMapInputMode(src.getModeElement()));
        if (src.hasDocumentation())
            tgt.setDocumentationElement(VersionConvertor_30_40.convertString(src.getDocumentationElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleComponent convertStructureMapGroupRuleComponent(org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupRuleComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleComponent tgt = new org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_40.convertId(src.getNameElement()));
        for (org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupRuleSourceComponent t : src.getSource())
            tgt.addSource(convertStructureMapGroupRuleSourceComponent(t));
        for (org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupRuleTargetComponent t : src.getTarget())
            tgt.addTarget(convertStructureMapGroupRuleTargetComponent(t));
        for (org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupRuleComponent t : src.getRule())
            tgt.addRule(convertStructureMapGroupRuleComponent(t));
        for (org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupRuleDependentComponent t : src.getDependent())
            tgt.addDependent(convertStructureMapGroupRuleDependentComponent(t));
        if (src.hasDocumentation())
            tgt.setDocumentationElement(VersionConvertor_30_40.convertString(src.getDocumentationElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupRuleComponent convertStructureMapGroupRuleComponent(org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupRuleComponent tgt = new org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupRuleComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_40.convertId(src.getNameElement()));
        for (org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleSourceComponent t : src.getSource())
            tgt.addSource(convertStructureMapGroupRuleSourceComponent(t));
        for (org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleTargetComponent t : src.getTarget())
            tgt.addTarget(convertStructureMapGroupRuleTargetComponent(t));
        for (org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleComponent t : src.getRule())
            tgt.addRule(convertStructureMapGroupRuleComponent(t));
        for (org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleDependentComponent t : src.getDependent())
            tgt.addDependent(convertStructureMapGroupRuleDependentComponent(t));
        if (src.hasDocumentation())
            tgt.setDocumentationElement(VersionConvertor_30_40.convertString(src.getDocumentationElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleDependentComponent convertStructureMapGroupRuleDependentComponent(org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupRuleDependentComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleDependentComponent tgt = new org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleDependentComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_40.convertId(src.getNameElement()));
        for (org.hl7.fhir.dstu3.model.StringType t : src.getVariable()) tgt.addVariable(t.getValue());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupRuleDependentComponent convertStructureMapGroupRuleDependentComponent(org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleDependentComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupRuleDependentComponent tgt = new org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupRuleDependentComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_40.convertId(src.getNameElement()));
        for (org.hl7.fhir.r4.model.StringType t : src.getVariable()) tgt.addVariable(t.getValue());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleSourceComponent convertStructureMapGroupRuleSourceComponent(org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupRuleSourceComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleSourceComponent tgt = new org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleSourceComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasContext())
            tgt.setContextElement(VersionConvertor_30_40.convertId(src.getContextElement()));
        if (src.hasMin())
            tgt.setMinElement(VersionConvertor_30_40.convertInteger(src.getMinElement()));
        if (src.hasMax())
            tgt.setMaxElement(VersionConvertor_30_40.convertString(src.getMaxElement()));
        if (src.hasType())
            tgt.setTypeElement(VersionConvertor_30_40.convertString(src.getTypeElement()));
        if (src.hasDefaultValue())
            tgt.setDefaultValue(VersionConvertor_30_40.convertType(src.getDefaultValue()));
        if (src.hasElement())
            tgt.setElementElement(VersionConvertor_30_40.convertString(src.getElementElement()));
        if (src.hasListMode())
            tgt.setListModeElement(convertStructureMapSourceListMode(src.getListModeElement()));
        if (src.hasVariable())
            tgt.setVariableElement(VersionConvertor_30_40.convertId(src.getVariableElement()));
        if (src.hasCondition())
            tgt.setConditionElement(VersionConvertor_30_40.convertString(src.getConditionElement()));
        if (src.hasCheck())
            tgt.setCheckElement(VersionConvertor_30_40.convertString(src.getCheckElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupRuleSourceComponent convertStructureMapGroupRuleSourceComponent(org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleSourceComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupRuleSourceComponent tgt = new org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupRuleSourceComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasContext())
            tgt.setContextElement(VersionConvertor_30_40.convertId(src.getContextElement()));
        if (src.hasMin())
            tgt.setMinElement(VersionConvertor_30_40.convertInteger(src.getMinElement()));
        if (src.hasMax())
            tgt.setMaxElement(VersionConvertor_30_40.convertString(src.getMaxElement()));
        if (src.hasType())
            tgt.setTypeElement(VersionConvertor_30_40.convertString(src.getTypeElement()));
        if (src.hasDefaultValue())
            tgt.setDefaultValue(VersionConvertor_30_40.convertType(src.getDefaultValue()));
        if (src.hasElement())
            tgt.setElementElement(VersionConvertor_30_40.convertString(src.getElementElement()));
        if (src.hasListMode())
            tgt.setListModeElement(convertStructureMapSourceListMode(src.getListModeElement()));
        if (src.hasVariable())
            tgt.setVariableElement(VersionConvertor_30_40.convertId(src.getVariableElement()));
        if (src.hasCondition())
            tgt.setConditionElement(VersionConvertor_30_40.convertString(src.getConditionElement()));
        if (src.hasCheck())
            tgt.setCheckElement(VersionConvertor_30_40.convertString(src.getCheckElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleTargetComponent convertStructureMapGroupRuleTargetComponent(org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupRuleTargetComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleTargetComponent tgt = new org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleTargetComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasContext())
            tgt.setContextElement(VersionConvertor_30_40.convertId(src.getContextElement()));
        if (src.hasContextType())
            tgt.setContextTypeElement(convertStructureMapContextType(src.getContextTypeElement()));
        if (src.hasElement())
            tgt.setElementElement(VersionConvertor_30_40.convertString(src.getElementElement()));
        if (src.hasVariable())
            tgt.setVariableElement(VersionConvertor_30_40.convertId(src.getVariableElement()));
        tgt.setListMode(src.getListMode().stream()
                .map(StructureMap30_40::convertStructureMapTargetListMode)
                .collect(Collectors.toList()));
        if (src.hasListRuleId())
            tgt.setListRuleIdElement(VersionConvertor_30_40.convertId(src.getListRuleIdElement()));
        if (src.hasTransform())
            tgt.setTransformElement(convertStructureMapTransform(src.getTransformElement()));
        for (org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupRuleTargetParameterComponent t : src.getParameter())
            tgt.addParameter(convertStructureMapGroupRuleTargetParameterComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupRuleTargetComponent convertStructureMapGroupRuleTargetComponent(org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleTargetComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupRuleTargetComponent tgt = new org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupRuleTargetComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasContext())
            tgt.setContextElement(VersionConvertor_30_40.convertId(src.getContextElement()));
        if (src.hasContextType())
            tgt.setContextTypeElement(convertStructureMapContextType(src.getContextTypeElement()));
        if (src.hasElement())
            tgt.setElementElement(VersionConvertor_30_40.convertString(src.getElementElement()));
        if (src.hasVariable())
            tgt.setVariableElement(VersionConvertor_30_40.convertId(src.getVariableElement()));
        tgt.setListMode(src.getListMode().stream()
                .map(StructureMap30_40::convertStructureMapTargetListMode)
                .collect(Collectors.toList()));
        if (src.hasListRuleId())
            tgt.setListRuleIdElement(VersionConvertor_30_40.convertId(src.getListRuleIdElement()));
        if (src.hasTransform())
            tgt.setTransformElement(convertStructureMapTransform(src.getTransformElement()));
        for (org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleTargetParameterComponent t : src.getParameter())
            tgt.addParameter(convertStructureMapGroupRuleTargetParameterComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleTargetParameterComponent convertStructureMapGroupRuleTargetParameterComponent(org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupRuleTargetParameterComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleTargetParameterComponent tgt = new org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleTargetParameterComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValue(VersionConvertor_30_40.convertType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupRuleTargetParameterComponent convertStructureMapGroupRuleTargetParameterComponent(org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleTargetParameterComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupRuleTargetParameterComponent tgt = new org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupRuleTargetParameterComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValue(VersionConvertor_30_40.convertType(src.getValue()));
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureMap.StructureMapGroupTypeMode> convertStructureMapGroupTypeMode(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupTypeMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureMap.StructureMapGroupTypeMode> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.StructureMap.StructureMapGroupTypeModeEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch (src.getValue()) {
            case NONE:
                tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapGroupTypeMode.NONE);
                break;
            case TYPES:
                tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapGroupTypeMode.TYPES);
                break;
            case TYPEANDTYPES:
                tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapGroupTypeMode.TYPEANDTYPES);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapGroupTypeMode.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupTypeMode> convertStructureMapGroupTypeMode(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureMap.StructureMapGroupTypeMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupTypeMode> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupTypeModeEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch (src.getValue()) {
            case NONE:
                tgt.setValue(org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupTypeMode.NONE);
                break;
            case TYPES:
                tgt.setValue(org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupTypeMode.TYPES);
                break;
            case TYPEANDTYPES:
                tgt.setValue(org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupTypeMode.TYPEANDTYPES);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupTypeMode.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.StructureMap.StructureMapInputMode> convertStructureMapInputMode(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureMap.StructureMapInputMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.StructureMap.StructureMapInputMode> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.StructureMap.StructureMapInputModeEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch (src.getValue()) {
            case SOURCE:
                tgt.setValue(org.hl7.fhir.dstu3.model.StructureMap.StructureMapInputMode.SOURCE);
                break;
            case TARGET:
                tgt.setValue(org.hl7.fhir.dstu3.model.StructureMap.StructureMapInputMode.TARGET);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.StructureMap.StructureMapInputMode.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureMap.StructureMapInputMode> convertStructureMapInputMode(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.StructureMap.StructureMapInputMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureMap.StructureMapInputMode> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.StructureMap.StructureMapInputModeEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch (src.getValue()) {
            case SOURCE:
                tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapInputMode.SOURCE);
                break;
            case TARGET:
                tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapInputMode.TARGET);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapInputMode.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.StructureMap.StructureMapModelMode> convertStructureMapModelMode(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureMap.StructureMapModelMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.StructureMap.StructureMapModelMode> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.StructureMap.StructureMapModelModeEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch (src.getValue()) {
            case SOURCE:
                tgt.setValue(org.hl7.fhir.dstu3.model.StructureMap.StructureMapModelMode.SOURCE);
                break;
            case QUERIED:
                tgt.setValue(org.hl7.fhir.dstu3.model.StructureMap.StructureMapModelMode.QUERIED);
                break;
            case TARGET:
                tgt.setValue(org.hl7.fhir.dstu3.model.StructureMap.StructureMapModelMode.TARGET);
                break;
            case PRODUCED:
                tgt.setValue(org.hl7.fhir.dstu3.model.StructureMap.StructureMapModelMode.PRODUCED);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.StructureMap.StructureMapModelMode.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureMap.StructureMapModelMode> convertStructureMapModelMode(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.StructureMap.StructureMapModelMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureMap.StructureMapModelMode> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.StructureMap.StructureMapModelModeEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch (src.getValue()) {
            case SOURCE:
                tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapModelMode.SOURCE);
                break;
            case QUERIED:
                tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapModelMode.QUERIED);
                break;
            case TARGET:
                tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapModelMode.TARGET);
                break;
            case PRODUCED:
                tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapModelMode.PRODUCED);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapModelMode.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.StructureMap.StructureMapSourceListMode> convertStructureMapSourceListMode(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureMap.StructureMapSourceListMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.StructureMap.StructureMapSourceListMode> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.StructureMap.StructureMapSourceListModeEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch (src.getValue()) {
            case FIRST:
                tgt.setValue(org.hl7.fhir.dstu3.model.StructureMap.StructureMapSourceListMode.FIRST);
                break;
            case NOTFIRST:
                tgt.setValue(org.hl7.fhir.dstu3.model.StructureMap.StructureMapSourceListMode.NOTFIRST);
                break;
            case LAST:
                tgt.setValue(org.hl7.fhir.dstu3.model.StructureMap.StructureMapSourceListMode.LAST);
                break;
            case NOTLAST:
                tgt.setValue(org.hl7.fhir.dstu3.model.StructureMap.StructureMapSourceListMode.NOTLAST);
                break;
            case ONLYONE:
                tgt.setValue(org.hl7.fhir.dstu3.model.StructureMap.StructureMapSourceListMode.ONLYONE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.StructureMap.StructureMapSourceListMode.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureMap.StructureMapSourceListMode> convertStructureMapSourceListMode(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.StructureMap.StructureMapSourceListMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureMap.StructureMapSourceListMode> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.StructureMap.StructureMapSourceListModeEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch (src.getValue()) {
            case FIRST:
                tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapSourceListMode.FIRST);
                break;
            case NOTFIRST:
                tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapSourceListMode.NOTFIRST);
                break;
            case LAST:
                tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapSourceListMode.LAST);
                break;
            case NOTLAST:
                tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapSourceListMode.NOTLAST);
                break;
            case ONLYONE:
                tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapSourceListMode.ONLYONE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapSourceListMode.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.StructureMap.StructureMapStructureComponent convertStructureMapStructureComponent(org.hl7.fhir.r4.model.StructureMap.StructureMapStructureComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.StructureMap.StructureMapStructureComponent tgt = new org.hl7.fhir.dstu3.model.StructureMap.StructureMapStructureComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasUrl())
            tgt.setUrl(src.getUrl());
        if (src.hasMode())
            tgt.setModeElement(convertStructureMapModelMode(src.getModeElement()));
        if (src.hasAlias())
            tgt.setAliasElement(VersionConvertor_30_40.convertString(src.getAliasElement()));
        if (src.hasDocumentation())
            tgt.setDocumentationElement(VersionConvertor_30_40.convertString(src.getDocumentationElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.StructureMap.StructureMapStructureComponent convertStructureMapStructureComponent(org.hl7.fhir.dstu3.model.StructureMap.StructureMapStructureComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.StructureMap.StructureMapStructureComponent tgt = new org.hl7.fhir.r4.model.StructureMap.StructureMapStructureComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasUrl())
            tgt.setUrl(src.getUrl());
        if (src.hasMode())
            tgt.setModeElement(convertStructureMapModelMode(src.getModeElement()));
        if (src.hasAlias())
            tgt.setAliasElement(VersionConvertor_30_40.convertString(src.getAliasElement()));
        if (src.hasDocumentation())
            tgt.setDocumentationElement(VersionConvertor_30_40.convertString(src.getDocumentationElement()));
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureMap.StructureMapTargetListMode> convertStructureMapTargetListMode(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.StructureMap.StructureMapTargetListMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureMap.StructureMapTargetListMode> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.StructureMap.StructureMapTargetListModeEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch (src.getValue()) {
            case FIRST:
                tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapTargetListMode.FIRST);
                break;
            case SHARE:
                tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapTargetListMode.SHARE);
                break;
            case LAST:
                tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapTargetListMode.LAST);
                break;
            case COLLATE:
                tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapTargetListMode.COLLATE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapTargetListMode.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.StructureMap.StructureMapTargetListMode> convertStructureMapTargetListMode(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureMap.StructureMapTargetListMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.StructureMap.StructureMapTargetListMode> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.StructureMap.StructureMapTargetListModeEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch (src.getValue()) {
            case FIRST:
                tgt.setValue(org.hl7.fhir.dstu3.model.StructureMap.StructureMapTargetListMode.FIRST);
                break;
            case SHARE:
                tgt.setValue(org.hl7.fhir.dstu3.model.StructureMap.StructureMapTargetListMode.SHARE);
                break;
            case LAST:
                tgt.setValue(org.hl7.fhir.dstu3.model.StructureMap.StructureMapTargetListMode.LAST);
                break;
            case COLLATE:
                tgt.setValue(org.hl7.fhir.dstu3.model.StructureMap.StructureMapTargetListMode.COLLATE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.StructureMap.StructureMapTargetListMode.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureMap.StructureMapTransform> convertStructureMapTransform(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.StructureMap.StructureMapTransform> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureMap.StructureMapTransform> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.StructureMap.StructureMapTransformEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch (src.getValue()) {
            case CREATE:
                tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.CREATE);
                break;
            case COPY:
                tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.COPY);
                break;
            case TRUNCATE:
                tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.TRUNCATE);
                break;
            case ESCAPE:
                tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.ESCAPE);
                break;
            case CAST:
                tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.CAST);
                break;
            case APPEND:
                tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.APPEND);
                break;
            case TRANSLATE:
                tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.TRANSLATE);
                break;
            case REFERENCE:
                tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.REFERENCE);
                break;
            case DATEOP:
                tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.DATEOP);
                break;
            case UUID:
                tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.UUID);
                break;
            case POINTER:
                tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.POINTER);
                break;
            case EVALUATE:
                tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.EVALUATE);
                break;
            case CC:
                tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.CC);
                break;
            case C:
                tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.C);
                break;
            case QTY:
                tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.QTY);
                break;
            case ID:
                tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.ID);
                break;
            case CP:
                tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.CP);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.StructureMap.StructureMapTransform> convertStructureMapTransform(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureMap.StructureMapTransform> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.StructureMap.StructureMapTransform> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.StructureMap.StructureMapTransformEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch (src.getValue()) {
            case CREATE:
                tgt.setValue(org.hl7.fhir.dstu3.model.StructureMap.StructureMapTransform.CREATE);
                break;
            case COPY:
                tgt.setValue(org.hl7.fhir.dstu3.model.StructureMap.StructureMapTransform.COPY);
                break;
            case TRUNCATE:
                tgt.setValue(org.hl7.fhir.dstu3.model.StructureMap.StructureMapTransform.TRUNCATE);
                break;
            case ESCAPE:
                tgt.setValue(org.hl7.fhir.dstu3.model.StructureMap.StructureMapTransform.ESCAPE);
                break;
            case CAST:
                tgt.setValue(org.hl7.fhir.dstu3.model.StructureMap.StructureMapTransform.CAST);
                break;
            case APPEND:
                tgt.setValue(org.hl7.fhir.dstu3.model.StructureMap.StructureMapTransform.APPEND);
                break;
            case TRANSLATE:
                tgt.setValue(org.hl7.fhir.dstu3.model.StructureMap.StructureMapTransform.TRANSLATE);
                break;
            case REFERENCE:
                tgt.setValue(org.hl7.fhir.dstu3.model.StructureMap.StructureMapTransform.REFERENCE);
                break;
            case DATEOP:
                tgt.setValue(org.hl7.fhir.dstu3.model.StructureMap.StructureMapTransform.DATEOP);
                break;
            case UUID:
                tgt.setValue(org.hl7.fhir.dstu3.model.StructureMap.StructureMapTransform.UUID);
                break;
            case POINTER:
                tgt.setValue(org.hl7.fhir.dstu3.model.StructureMap.StructureMapTransform.POINTER);
                break;
            case EVALUATE:
                tgt.setValue(org.hl7.fhir.dstu3.model.StructureMap.StructureMapTransform.EVALUATE);
                break;
            case CC:
                tgt.setValue(org.hl7.fhir.dstu3.model.StructureMap.StructureMapTransform.CC);
                break;
            case C:
                tgt.setValue(org.hl7.fhir.dstu3.model.StructureMap.StructureMapTransform.C);
                break;
            case QTY:
                tgt.setValue(org.hl7.fhir.dstu3.model.StructureMap.StructureMapTransform.QTY);
                break;
            case ID:
                tgt.setValue(org.hl7.fhir.dstu3.model.StructureMap.StructureMapTransform.ID);
                break;
            case CP:
                tgt.setValue(org.hl7.fhir.dstu3.model.StructureMap.StructureMapTransform.CP);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.StructureMap.StructureMapTransform.NULL);
                break;
        }
        return tgt;
    }
}