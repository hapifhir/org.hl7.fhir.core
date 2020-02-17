package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class StructureMap30_50 {

    public static org.hl7.fhir.r5.model.StructureMap convertStructureMap(org.hl7.fhir.dstu3.model.StructureMap src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.StructureMap tgt = new org.hl7.fhir.r5.model.StructureMap();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(VersionConvertor_30_50.convertUri(src.getUrlElement()));
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        if (src.hasVersion())
            tgt.setVersionElement(VersionConvertor_30_50.convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_50.convertString(src.getNameElement()));
        if (src.hasTitle())
            tgt.setTitleElement(VersionConvertor_30_50.convertString(src.getTitleElement()));
        if (src.hasStatus())
            tgt.setStatus(VersionConvertor_30_50.convertPublicationStatus(src.getStatus()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(VersionConvertor_30_50.convertBoolean(src.getExperimentalElement()));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_30_50.convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(VersionConvertor_30_50.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(VersionConvertor_30_50.convertContactDetail(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_30_50.convertMarkdown(src.getDescriptionElement()));
        for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_50.convertUsageContext(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_50.convertCodeableConcept(t));
        if (src.hasPurpose())
            tgt.setPurposeElement(VersionConvertor_30_50.convertMarkdown(src.getPurposeElement()));
        if (src.hasCopyright())
            tgt.setCopyrightElement(VersionConvertor_30_50.convertMarkdown(src.getCopyrightElement()));
        for (org.hl7.fhir.dstu3.model.StructureMap.StructureMapStructureComponent t : src.getStructure()) tgt.addStructure(convertStructureMapStructureComponent(t));
        for (org.hl7.fhir.dstu3.model.UriType t : src.getImport()) tgt.addImport(t.getValue());
        for (org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupComponent t : src.getGroup()) tgt.addGroup(convertStructureMapGroupComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.StructureMap convertStructureMap(org.hl7.fhir.r5.model.StructureMap src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.StructureMap tgt = new org.hl7.fhir.dstu3.model.StructureMap();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(VersionConvertor_30_50.convertUri(src.getUrlElement()));
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        if (src.hasVersion())
            tgt.setVersionElement(VersionConvertor_30_50.convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_50.convertString(src.getNameElement()));
        if (src.hasTitle())
            tgt.setTitleElement(VersionConvertor_30_50.convertString(src.getTitleElement()));
        if (src.hasStatus())
            tgt.setStatus(VersionConvertor_30_50.convertPublicationStatus(src.getStatus()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(VersionConvertor_30_50.convertBoolean(src.getExperimentalElement()));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_30_50.convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(VersionConvertor_30_50.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact()) tgt.addContact(VersionConvertor_30_50.convertContactDetail(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_30_50.convertMarkdown(src.getDescriptionElement()));
        for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_50.convertUsageContext(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_50.convertCodeableConcept(t));
        if (src.hasPurpose())
            tgt.setPurposeElement(VersionConvertor_30_50.convertMarkdown(src.getPurposeElement()));
        if (src.hasCopyright())
            tgt.setCopyrightElement(VersionConvertor_30_50.convertMarkdown(src.getCopyrightElement()));
        for (org.hl7.fhir.r5.model.StructureMap.StructureMapStructureComponent t : src.getStructure()) tgt.addStructure(convertStructureMapStructureComponent(t));
        for (org.hl7.fhir.r5.model.UriType t : src.getImport()) tgt.addImport(t.getValue());
        for (org.hl7.fhir.r5.model.StructureMap.StructureMapGroupComponent t : src.getGroup()) tgt.addGroup(convertStructureMapGroupComponent(t));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.StructureMap.StructureMapContextType convertStructureMapContextType(org.hl7.fhir.dstu3.model.StructureMap.StructureMapContextType src) throws FHIRException {
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

    static public org.hl7.fhir.dstu3.model.StructureMap.StructureMapContextType convertStructureMapContextType(org.hl7.fhir.r5.model.StructureMap.StructureMapContextType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case TYPE:
                return org.hl7.fhir.dstu3.model.StructureMap.StructureMapContextType.TYPE;
            case VARIABLE:
                return org.hl7.fhir.dstu3.model.StructureMap.StructureMapContextType.VARIABLE;
            default:
                return org.hl7.fhir.dstu3.model.StructureMap.StructureMapContextType.NULL;
        }
    }

    public static org.hl7.fhir.r5.model.StructureMap.StructureMapGroupComponent convertStructureMapGroupComponent(org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.StructureMap.StructureMapGroupComponent tgt = new org.hl7.fhir.r5.model.StructureMap.StructureMapGroupComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_50.convertId(src.getNameElement()));
        if (src.hasExtends())
            tgt.setExtendsElement(VersionConvertor_30_50.convertId(src.getExtendsElement()));
        if (src.hasTypeMode())
            tgt.setTypeMode(convertStructureMapGroupTypeMode(src.getTypeMode()));
        if (src.hasDocumentation())
            tgt.setDocumentationElement(VersionConvertor_30_50.convertString(src.getDocumentationElement()));
        for (org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupInputComponent t : src.getInput()) tgt.addInput(convertStructureMapGroupInputComponent(t));
        for (org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupRuleComponent t : src.getRule()) tgt.addRule(convertStructureMapGroupRuleComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupComponent convertStructureMapGroupComponent(org.hl7.fhir.r5.model.StructureMap.StructureMapGroupComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupComponent tgt = new org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_50.convertId(src.getNameElement()));
        if (src.hasExtends())
            tgt.setExtendsElement(VersionConvertor_30_50.convertId(src.getExtendsElement()));
        if (src.hasTypeMode())
            tgt.setTypeMode(convertStructureMapGroupTypeMode(src.getTypeMode()));
        if (src.hasDocumentation())
            tgt.setDocumentationElement(VersionConvertor_30_50.convertString(src.getDocumentationElement()));
        for (org.hl7.fhir.r5.model.StructureMap.StructureMapGroupInputComponent t : src.getInput()) tgt.addInput(convertStructureMapGroupInputComponent(t));
        for (org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleComponent t : src.getRule()) tgt.addRule(convertStructureMapGroupRuleComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupInputComponent convertStructureMapGroupInputComponent(org.hl7.fhir.r5.model.StructureMap.StructureMapGroupInputComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupInputComponent tgt = new org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupInputComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_50.convertId(src.getNameElement()));
        if (src.hasType())
            tgt.setTypeElement(VersionConvertor_30_50.convertString(src.getTypeElement()));
        if (src.hasMode())
            tgt.setMode(convertStructureMapInputMode(src.getMode()));
        if (src.hasDocumentation())
            tgt.setDocumentationElement(VersionConvertor_30_50.convertString(src.getDocumentationElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.StructureMap.StructureMapGroupInputComponent convertStructureMapGroupInputComponent(org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupInputComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.StructureMap.StructureMapGroupInputComponent tgt = new org.hl7.fhir.r5.model.StructureMap.StructureMapGroupInputComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_50.convertId(src.getNameElement()));
        if (src.hasType())
            tgt.setTypeElement(VersionConvertor_30_50.convertString(src.getTypeElement()));
        if (src.hasMode())
            tgt.setMode(convertStructureMapInputMode(src.getMode()));
        if (src.hasDocumentation())
            tgt.setDocumentationElement(VersionConvertor_30_50.convertString(src.getDocumentationElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupRuleComponent convertStructureMapGroupRuleComponent(org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupRuleComponent tgt = new org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupRuleComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_50.convertId(src.getNameElement()));
        for (org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleSourceComponent t : src.getSource()) tgt.addSource(convertStructureMapGroupRuleSourceComponent(t));
        for (org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleTargetComponent t : src.getTarget()) tgt.addTarget(convertStructureMapGroupRuleTargetComponent(t));
        for (org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleComponent t : src.getRule()) tgt.addRule(convertStructureMapGroupRuleComponent(t));
        for (org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleDependentComponent t : src.getDependent()) tgt.addDependent(convertStructureMapGroupRuleDependentComponent(t));
        if (src.hasDocumentation())
            tgt.setDocumentationElement(VersionConvertor_30_50.convertString(src.getDocumentationElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleComponent convertStructureMapGroupRuleComponent(org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupRuleComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleComponent tgt = new org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_50.convertId(src.getNameElement()));
        for (org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupRuleSourceComponent t : src.getSource()) tgt.addSource(convertStructureMapGroupRuleSourceComponent(t));
        for (org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupRuleTargetComponent t : src.getTarget()) tgt.addTarget(convertStructureMapGroupRuleTargetComponent(t));
        for (org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupRuleComponent t : src.getRule()) tgt.addRule(convertStructureMapGroupRuleComponent(t));
        for (org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupRuleDependentComponent t : src.getDependent()) tgt.addDependent(convertStructureMapGroupRuleDependentComponent(t));
        if (src.hasDocumentation())
            tgt.setDocumentationElement(VersionConvertor_30_50.convertString(src.getDocumentationElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleDependentComponent convertStructureMapGroupRuleDependentComponent(org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupRuleDependentComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleDependentComponent tgt = new org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleDependentComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_50.convertId(src.getNameElement()));
        for (org.hl7.fhir.dstu3.model.StringType t : src.getVariable()) tgt.addVariable(t.getValue());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupRuleDependentComponent convertStructureMapGroupRuleDependentComponent(org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleDependentComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupRuleDependentComponent tgt = new org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupRuleDependentComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_50.convertId(src.getNameElement()));
        for (org.hl7.fhir.r5.model.StringType t : src.getVariable()) tgt.addVariable(t.getValue());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupRuleSourceComponent convertStructureMapGroupRuleSourceComponent(org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleSourceComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupRuleSourceComponent tgt = new org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupRuleSourceComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasContext())
            tgt.setContextElement(VersionConvertor_30_50.convertId(src.getContextElement()));
        if (src.hasMin())
            tgt.setMinElement(VersionConvertor_30_50.convertInteger(src.getMinElement()));
        if (src.hasMax())
            tgt.setMaxElement(VersionConvertor_30_50.convertString(src.getMaxElement()));
        if (src.hasType())
            tgt.setTypeElement(VersionConvertor_30_50.convertString(src.getTypeElement()));
        if (src.hasDefaultValue())
            tgt.setDefaultValue(VersionConvertor_30_50.convertType(src.getDefaultValue()));
        if (src.hasElement())
            tgt.setElementElement(VersionConvertor_30_50.convertString(src.getElementElement()));
        if (src.hasListMode())
            tgt.setListMode(convertStructureMapSourceListMode(src.getListMode()));
        if (src.hasVariable())
            tgt.setVariableElement(VersionConvertor_30_50.convertId(src.getVariableElement()));
        if (src.hasCondition())
            tgt.setConditionElement(VersionConvertor_30_50.convertString(src.getConditionElement()));
        if (src.hasCheck())
            tgt.setCheckElement(VersionConvertor_30_50.convertString(src.getCheckElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleSourceComponent convertStructureMapGroupRuleSourceComponent(org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupRuleSourceComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleSourceComponent tgt = new org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleSourceComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasContext())
            tgt.setContextElement(VersionConvertor_30_50.convertId(src.getContextElement()));
        if (src.hasMin())
            tgt.setMinElement(VersionConvertor_30_50.convertInteger(src.getMinElement()));
        if (src.hasMax())
            tgt.setMaxElement(VersionConvertor_30_50.convertString(src.getMaxElement()));
        if (src.hasType())
            tgt.setTypeElement(VersionConvertor_30_50.convertString(src.getTypeElement()));
        if (src.hasDefaultValue())
            tgt.setDefaultValue(VersionConvertor_30_50.convertType(src.getDefaultValue()));
        if (src.hasElement())
            tgt.setElementElement(VersionConvertor_30_50.convertString(src.getElementElement()));
        if (src.hasListMode())
            tgt.setListMode(convertStructureMapSourceListMode(src.getListMode()));
        if (src.hasVariable())
            tgt.setVariableElement(VersionConvertor_30_50.convertId(src.getVariableElement()));
        if (src.hasCondition())
            tgt.setConditionElement(VersionConvertor_30_50.convertString(src.getConditionElement()));
        if (src.hasCheck())
            tgt.setCheckElement(VersionConvertor_30_50.convertString(src.getCheckElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleTargetComponent convertStructureMapGroupRuleTargetComponent(org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupRuleTargetComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleTargetComponent tgt = new org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleTargetComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasContext())
            tgt.setContextElement(VersionConvertor_30_50.convertId(src.getContextElement()));
        if (src.hasContextType())
            tgt.setContextType(convertStructureMapContextType(src.getContextType()));
        if (src.hasElement())
            tgt.setElementElement(VersionConvertor_30_50.convertString(src.getElementElement()));
        if (src.hasVariable())
            tgt.setVariableElement(VersionConvertor_30_50.convertId(src.getVariableElement()));
        for (org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.StructureMap.StructureMapTargetListMode> t : src.getListMode()) VersionConvertor_30_50.copyElement(t, tgt.addListModeElement().setValue(convertStructureMapTargetListMode(t.getValue())));
        if (src.hasListRuleId())
            tgt.setListRuleIdElement(VersionConvertor_30_50.convertId(src.getListRuleIdElement()));
        if (src.hasTransform())
            tgt.setTransform(convertStructureMapTransform(src.getTransform()));
        for (org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupRuleTargetParameterComponent t : src.getParameter()) tgt.addParameter(convertStructureMapGroupRuleTargetParameterComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupRuleTargetComponent convertStructureMapGroupRuleTargetComponent(org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleTargetComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupRuleTargetComponent tgt = new org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupRuleTargetComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasContext())
            tgt.setContextElement(VersionConvertor_30_50.convertId(src.getContextElement()));
        if (src.hasContextType())
            tgt.setContextType(convertStructureMapContextType(src.getContextType()));
        if (src.hasElement())
            tgt.setElementElement(VersionConvertor_30_50.convertString(src.getElementElement()));
        if (src.hasVariable())
            tgt.setVariableElement(VersionConvertor_30_50.convertId(src.getVariableElement()));
        for (org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.StructureMap.StructureMapTargetListMode> t : src.getListMode()) VersionConvertor_30_50.copyElement(t, tgt.addListModeElement().setValue(convertStructureMapTargetListMode(t.getValue())));
        if (src.hasListRuleId())
            tgt.setListRuleIdElement(VersionConvertor_30_50.convertId(src.getListRuleIdElement()));
        if (src.hasTransform())
            tgt.setTransform(convertStructureMapTransform(src.getTransform()));
        for (org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleTargetParameterComponent t : src.getParameter()) tgt.addParameter(convertStructureMapGroupRuleTargetParameterComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupRuleTargetParameterComponent convertStructureMapGroupRuleTargetParameterComponent(org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleTargetParameterComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupRuleTargetParameterComponent tgt = new org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupRuleTargetParameterComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValue(VersionConvertor_30_50.convertType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleTargetParameterComponent convertStructureMapGroupRuleTargetParameterComponent(org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupRuleTargetParameterComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleTargetParameterComponent tgt = new org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleTargetParameterComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValue(VersionConvertor_30_50.convertType(src.getValue()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.StructureMap.StructureMapGroupTypeMode convertStructureMapGroupTypeMode(org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupTypeMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case NONE:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapGroupTypeMode.NONE;
            case TYPES:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapGroupTypeMode.TYPES;
            case TYPEANDTYPES:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapGroupTypeMode.TYPEANDTYPES;
            default:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapGroupTypeMode.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupTypeMode convertStructureMapGroupTypeMode(org.hl7.fhir.r5.model.StructureMap.StructureMapGroupTypeMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case NONE:
                return org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupTypeMode.NONE;
            case TYPES:
                return org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupTypeMode.TYPES;
            case TYPEANDTYPES:
                return org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupTypeMode.TYPEANDTYPES;
            default:
                return org.hl7.fhir.dstu3.model.StructureMap.StructureMapGroupTypeMode.NULL;
        }
    }

    static public org.hl7.fhir.r5.model.StructureMap.StructureMapInputMode convertStructureMapInputMode(org.hl7.fhir.dstu3.model.StructureMap.StructureMapInputMode src) throws FHIRException {
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

    static public org.hl7.fhir.dstu3.model.StructureMap.StructureMapInputMode convertStructureMapInputMode(org.hl7.fhir.r5.model.StructureMap.StructureMapInputMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case SOURCE:
                return org.hl7.fhir.dstu3.model.StructureMap.StructureMapInputMode.SOURCE;
            case TARGET:
                return org.hl7.fhir.dstu3.model.StructureMap.StructureMapInputMode.TARGET;
            default:
                return org.hl7.fhir.dstu3.model.StructureMap.StructureMapInputMode.NULL;
        }
    }

    static public org.hl7.fhir.r5.model.StructureMap.StructureMapModelMode convertStructureMapModelMode(org.hl7.fhir.dstu3.model.StructureMap.StructureMapModelMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case SOURCE:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapModelMode.SOURCE;
            case QUERIED:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapModelMode.QUERIED;
            case TARGET:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapModelMode.TARGET;
            case PRODUCED:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapModelMode.PRODUCED;
            default:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapModelMode.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.StructureMap.StructureMapModelMode convertStructureMapModelMode(org.hl7.fhir.r5.model.StructureMap.StructureMapModelMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case SOURCE:
                return org.hl7.fhir.dstu3.model.StructureMap.StructureMapModelMode.SOURCE;
            case QUERIED:
                return org.hl7.fhir.dstu3.model.StructureMap.StructureMapModelMode.QUERIED;
            case TARGET:
                return org.hl7.fhir.dstu3.model.StructureMap.StructureMapModelMode.TARGET;
            case PRODUCED:
                return org.hl7.fhir.dstu3.model.StructureMap.StructureMapModelMode.PRODUCED;
            default:
                return org.hl7.fhir.dstu3.model.StructureMap.StructureMapModelMode.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.StructureMap.StructureMapSourceListMode convertStructureMapSourceListMode(org.hl7.fhir.r5.model.StructureMap.StructureMapSourceListMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case FIRST:
                return org.hl7.fhir.dstu3.model.StructureMap.StructureMapSourceListMode.FIRST;
            case NOTFIRST:
                return org.hl7.fhir.dstu3.model.StructureMap.StructureMapSourceListMode.NOTFIRST;
            case LAST:
                return org.hl7.fhir.dstu3.model.StructureMap.StructureMapSourceListMode.LAST;
            case NOTLAST:
                return org.hl7.fhir.dstu3.model.StructureMap.StructureMapSourceListMode.NOTLAST;
            case ONLYONE:
                return org.hl7.fhir.dstu3.model.StructureMap.StructureMapSourceListMode.ONLYONE;
            default:
                return org.hl7.fhir.dstu3.model.StructureMap.StructureMapSourceListMode.NULL;
        }
    }

    static public org.hl7.fhir.r5.model.StructureMap.StructureMapSourceListMode convertStructureMapSourceListMode(org.hl7.fhir.dstu3.model.StructureMap.StructureMapSourceListMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case FIRST:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapSourceListMode.FIRST;
            case NOTFIRST:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapSourceListMode.NOTFIRST;
            case LAST:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapSourceListMode.LAST;
            case NOTLAST:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapSourceListMode.NOTLAST;
            case ONLYONE:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapSourceListMode.ONLYONE;
            default:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapSourceListMode.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.StructureMap.StructureMapStructureComponent convertStructureMapStructureComponent(org.hl7.fhir.r5.model.StructureMap.StructureMapStructureComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.StructureMap.StructureMapStructureComponent tgt = new org.hl7.fhir.dstu3.model.StructureMap.StructureMapStructureComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasUrl())
            tgt.setUrl(src.getUrl());
        if (src.hasMode())
            tgt.setMode(convertStructureMapModelMode(src.getMode()));
        if (src.hasAlias())
            tgt.setAliasElement(VersionConvertor_30_50.convertString(src.getAliasElement()));
        if (src.hasDocumentation())
            tgt.setDocumentationElement(VersionConvertor_30_50.convertString(src.getDocumentationElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.StructureMap.StructureMapStructureComponent convertStructureMapStructureComponent(org.hl7.fhir.dstu3.model.StructureMap.StructureMapStructureComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.StructureMap.StructureMapStructureComponent tgt = new org.hl7.fhir.r5.model.StructureMap.StructureMapStructureComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasUrl())
            tgt.setUrl(src.getUrl());
        if (src.hasMode())
            tgt.setMode(convertStructureMapModelMode(src.getMode()));
        if (src.hasAlias())
            tgt.setAliasElement(VersionConvertor_30_50.convertString(src.getAliasElement()));
        if (src.hasDocumentation())
            tgt.setDocumentationElement(VersionConvertor_30_50.convertString(src.getDocumentationElement()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.StructureMap.StructureMapTargetListMode convertStructureMapTargetListMode(org.hl7.fhir.dstu3.model.StructureMap.StructureMapTargetListMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case FIRST:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapTargetListMode.FIRST;
            case SHARE:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapTargetListMode.SHARE;
            case LAST:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapTargetListMode.LAST;
            case COLLATE:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapTargetListMode.COLLATE;
            default:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapTargetListMode.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.StructureMap.StructureMapTargetListMode convertStructureMapTargetListMode(org.hl7.fhir.r5.model.StructureMap.StructureMapTargetListMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case FIRST:
                return org.hl7.fhir.dstu3.model.StructureMap.StructureMapTargetListMode.FIRST;
            case SHARE:
                return org.hl7.fhir.dstu3.model.StructureMap.StructureMapTargetListMode.SHARE;
            case LAST:
                return org.hl7.fhir.dstu3.model.StructureMap.StructureMapTargetListMode.LAST;
            case COLLATE:
                return org.hl7.fhir.dstu3.model.StructureMap.StructureMapTargetListMode.COLLATE;
            default:
                return org.hl7.fhir.dstu3.model.StructureMap.StructureMapTargetListMode.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.StructureMap.StructureMapTransform convertStructureMapTransform(org.hl7.fhir.r5.model.StructureMap.StructureMapTransform src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case CREATE:
                return org.hl7.fhir.dstu3.model.StructureMap.StructureMapTransform.CREATE;
            case COPY:
                return org.hl7.fhir.dstu3.model.StructureMap.StructureMapTransform.COPY;
            case TRUNCATE:
                return org.hl7.fhir.dstu3.model.StructureMap.StructureMapTransform.TRUNCATE;
            case ESCAPE:
                return org.hl7.fhir.dstu3.model.StructureMap.StructureMapTransform.ESCAPE;
            case CAST:
                return org.hl7.fhir.dstu3.model.StructureMap.StructureMapTransform.CAST;
            case APPEND:
                return org.hl7.fhir.dstu3.model.StructureMap.StructureMapTransform.APPEND;
            case TRANSLATE:
                return org.hl7.fhir.dstu3.model.StructureMap.StructureMapTransform.TRANSLATE;
            case REFERENCE:
                return org.hl7.fhir.dstu3.model.StructureMap.StructureMapTransform.REFERENCE;
            case DATEOP:
                return org.hl7.fhir.dstu3.model.StructureMap.StructureMapTransform.DATEOP;
            case UUID:
                return org.hl7.fhir.dstu3.model.StructureMap.StructureMapTransform.UUID;
            case POINTER:
                return org.hl7.fhir.dstu3.model.StructureMap.StructureMapTransform.POINTER;
            case EVALUATE:
                return org.hl7.fhir.dstu3.model.StructureMap.StructureMapTransform.EVALUATE;
            case CC:
                return org.hl7.fhir.dstu3.model.StructureMap.StructureMapTransform.CC;
            case C:
                return org.hl7.fhir.dstu3.model.StructureMap.StructureMapTransform.C;
            case QTY:
                return org.hl7.fhir.dstu3.model.StructureMap.StructureMapTransform.QTY;
            case ID:
                return org.hl7.fhir.dstu3.model.StructureMap.StructureMapTransform.ID;
            case CP:
                return org.hl7.fhir.dstu3.model.StructureMap.StructureMapTransform.CP;
            default:
                return org.hl7.fhir.dstu3.model.StructureMap.StructureMapTransform.NULL;
        }
    }

    static public org.hl7.fhir.r5.model.StructureMap.StructureMapTransform convertStructureMapTransform(org.hl7.fhir.dstu3.model.StructureMap.StructureMapTransform src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case CREATE:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.CREATE;
            case COPY:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.COPY;
            case TRUNCATE:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.TRUNCATE;
            case ESCAPE:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.ESCAPE;
            case CAST:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.CAST;
            case APPEND:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.APPEND;
            case TRANSLATE:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.TRANSLATE;
            case REFERENCE:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.REFERENCE;
            case DATEOP:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.DATEOP;
            case UUID:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.UUID;
            case POINTER:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.POINTER;
            case EVALUATE:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.EVALUATE;
            case CC:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.CC;
            case C:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.C;
            case QTY:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.QTY;
            case ID:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.ID;
            case CP:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.CP;
            default:
                return org.hl7.fhir.r5.model.StructureMap.StructureMapTransform.NULL;
        }
    }
}
