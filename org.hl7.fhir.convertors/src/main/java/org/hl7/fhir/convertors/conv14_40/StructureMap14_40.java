package org.hl7.fhir.convertors.conv14_40;

import org.hl7.fhir.convertors.VersionConvertor_14_40;
import org.hl7.fhir.dstu2016may.model.StructureMap;
import org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapContextType;
import org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapListMode;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.Enumeration;

public class StructureMap14_40 {

    public static org.hl7.fhir.dstu2016may.model.StructureMap convertStructureMap(org.hl7.fhir.r4.model.StructureMap src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.StructureMap tgt = new org.hl7.fhir.dstu2016may.model.StructureMap();
        VersionConvertor_14_40.copyDomainResource(src, tgt);
        tgt.setUrl(src.getUrl());
        if (src.hasVersion())
            tgt.setVersion(src.getVersion());
        tgt.setName(src.getName());
        tgt.setStatus(VersionConvertor_14_40.convertConformanceResourceStatus(src.getStatus()));
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_14_40.convertIdentifier(t));
        if (src.hasExperimental())
            tgt.setExperimental(src.getExperimental());
        if (src.hasPublisher())
            tgt.setPublisher(src.getPublisher());
        for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact()) tgt.addContact(convertStructureMapContactComponent(t));
        if (src.hasDate())
            tgt.setDate(src.getDate());
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext()) if (t.hasValueCodeableConcept())
            tgt.addUseContext(VersionConvertor_14_40.convertCodeableConcept(t.getValueCodeableConcept()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction()) tgt.addUseContext(VersionConvertor_14_40.convertCodeableConcept(t));
        if (src.hasPurpose())
            tgt.setRequirements(src.getPurpose());
        if (src.hasCopyright())
            tgt.setCopyright(src.getCopyright());
        for (org.hl7.fhir.r4.model.StructureMap.StructureMapStructureComponent t : src.getStructure()) tgt.addStructure(convertStructureMapStructureComponent(t));
        for (org.hl7.fhir.r4.model.UriType t : src.getImport()) tgt.addImport(t.getValue());
        for (org.hl7.fhir.r4.model.StructureMap.StructureMapGroupComponent t : src.getGroup()) tgt.addGroup(convertStructureMapGroupComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.StructureMap convertStructureMap(org.hl7.fhir.dstu2016may.model.StructureMap src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.StructureMap tgt = new org.hl7.fhir.r4.model.StructureMap();
        VersionConvertor_14_40.copyDomainResource(src, tgt);
        tgt.setUrl(src.getUrl());
        if (src.hasVersion())
            tgt.setVersion(src.getVersion());
        tgt.setName(src.getName());
        tgt.setStatus(VersionConvertor_14_40.convertConformanceResourceStatus(src.getStatus()));
        for (org.hl7.fhir.dstu2016may.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_14_40.convertIdentifier(t));
        if (src.hasExperimental())
            tgt.setExperimental(src.getExperimental());
        if (src.hasPublisher())
            tgt.setPublisher(src.getPublisher());
        for (org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapContactComponent t : src.getContact()) tgt.addContact(convertStructureMapContactComponent(t));
        if (src.hasDate())
            tgt.setDate(src.getDate());
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
        for (org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapStructureComponent t : src.getStructure()) tgt.addStructure(convertStructureMapStructureComponent(t));
        for (org.hl7.fhir.dstu2016may.model.UriType t : src.getImport()) tgt.addImport(t.getValue());
        for (org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupComponent t : src.getGroup()) tgt.addGroup(convertStructureMapGroupComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapContactComponent convertStructureMapContactComponent(org.hl7.fhir.r4.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapContactComponent tgt = new org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapContactComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasName())
            tgt.setName(src.getName());
        for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_14_40.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ContactDetail convertStructureMapContactComponent(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ContactDetail tgt = new org.hl7.fhir.r4.model.ContactDetail();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasName())
            tgt.setName(src.getName());
        for (org.hl7.fhir.dstu2016may.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_14_40.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.StructureMap.StructureMapContextType convertStructureMapContextType(StructureMapContextType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case TYPE:
                return org.hl7.fhir.r4.model.StructureMap.StructureMapContextType.TYPE;
            case VARIABLE:
                return org.hl7.fhir.r4.model.StructureMap.StructureMapContextType.VARIABLE;
            default:
                return org.hl7.fhir.r4.model.StructureMap.StructureMapContextType.NULL;
        }
    }

    public static org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapContextType convertStructureMapContextType(org.hl7.fhir.r4.model.StructureMap.StructureMapContextType src) throws FHIRException {
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

    public static org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupComponent convertStructureMapGroupComponent(org.hl7.fhir.r4.model.StructureMap.StructureMapGroupComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupComponent tgt = new org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        tgt.setName(src.getName());
        if (src.hasExtends())
            tgt.setExtends(src.getExtends());
        if (!src.getTypeMode().equals(org.hl7.fhir.r4.model.StructureMap.StructureMapGroupTypeMode.NONE))
            throw new FHIRException("Unable to downgrade structure map with group.typeMode other than 'None': " + src.getTypeMode().getDisplay());
        if (src.hasDocumentation())
            tgt.setDocumentation(src.getDocumentation());
        for (org.hl7.fhir.r4.model.StructureMap.StructureMapGroupInputComponent t : src.getInput()) tgt.addInput(convertStructureMapGroupInputComponent(t));
        for (org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleComponent t : src.getRule()) tgt.addRule(convertStructureMapGroupRuleComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.StructureMap.StructureMapGroupComponent convertStructureMapGroupComponent(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.StructureMap.StructureMapGroupComponent tgt = new org.hl7.fhir.r4.model.StructureMap.StructureMapGroupComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        tgt.setName(src.getName());
        if (src.hasExtends())
            tgt.setExtends(src.getExtends());
        tgt.setTypeMode(org.hl7.fhir.r4.model.StructureMap.StructureMapGroupTypeMode.NONE);
        if (src.hasDocumentation())
            tgt.setDocumentation(src.getDocumentation());
        for (org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupInputComponent t : src.getInput()) tgt.addInput(convertStructureMapGroupInputComponent(t));
        for (org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleComponent t : src.getRule()) tgt.addRule(convertStructureMapGroupRuleComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupInputComponent convertStructureMapGroupInputComponent(org.hl7.fhir.r4.model.StructureMap.StructureMapGroupInputComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupInputComponent tgt = new org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupInputComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        tgt.setName(src.getName());
        if (src.hasType())
            tgt.setType(src.getType());
        tgt.setMode(convertStructureMapInputMode(src.getMode()));
        if (src.hasDocumentation())
            tgt.setDocumentation(src.getDocumentation());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.StructureMap.StructureMapGroupInputComponent convertStructureMapGroupInputComponent(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupInputComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.StructureMap.StructureMapGroupInputComponent tgt = new org.hl7.fhir.r4.model.StructureMap.StructureMapGroupInputComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        tgt.setName(src.getName());
        if (src.hasType())
            tgt.setType(src.getType());
        tgt.setMode(convertStructureMapInputMode(src.getMode()));
        if (src.hasDocumentation())
            tgt.setDocumentation(src.getDocumentation());
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleComponent convertStructureMapGroupRuleComponent(org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleComponent tgt = new org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        tgt.setName(src.getName());
        for (org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleSourceComponent t : src.getSource()) tgt.addSource(convertStructureMapGroupRuleSourceComponent(t));
        for (org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleTargetComponent t : src.getTarget()) tgt.addTarget(convertStructureMapGroupRuleTargetComponent(t));
        for (org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleComponent t : src.getRule()) tgt.addRule(convertStructureMapGroupRuleComponent(t));
        for (org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleDependentComponent t : src.getDependent()) tgt.addDependent(convertStructureMapGroupRuleDependentComponent(t));
        if (src.hasDocumentation())
            tgt.setDocumentation(src.getDocumentation());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleComponent convertStructureMapGroupRuleComponent(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleComponent tgt = new org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        tgt.setName(src.getName());
        for (org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleSourceComponent t : src.getSource()) tgt.addSource(convertStructureMapGroupRuleSourceComponent(t));
        for (org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleTargetComponent t : src.getTarget()) tgt.addTarget(convertStructureMapGroupRuleTargetComponent(t));
        for (org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleComponent t : src.getRule()) tgt.addRule(convertStructureMapGroupRuleComponent(t));
        for (org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleDependentComponent t : src.getDependent()) tgt.addDependent(convertStructureMapGroupRuleDependentComponent(t));
        if (src.hasDocumentation())
            tgt.setDocumentation(src.getDocumentation());
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleDependentComponent convertStructureMapGroupRuleDependentComponent(org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleDependentComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleDependentComponent tgt = new org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleDependentComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        tgt.setName(src.getName());
        for (org.hl7.fhir.r4.model.StringType t : src.getVariable()) tgt.addVariable(t.asStringValue());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleDependentComponent convertStructureMapGroupRuleDependentComponent(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleDependentComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleDependentComponent tgt = new org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleDependentComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        tgt.setName(src.getName());
        for (org.hl7.fhir.dstu2016may.model.StringType t : src.getVariable()) tgt.addVariable(t.asStringValue());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleSourceComponent convertStructureMapGroupRuleSourceComponent(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleSourceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleSourceComponent tgt = new org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleSourceComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        tgt.setMin(src.getRequired() ? 1 : 0);
        if (src.getContextType().equals(StructureMap.StructureMapContextType.TYPE))
            tgt.setType(src.getContext());
        if (src.hasElement())
            tgt.setElement(src.getElement());
        if (src.hasListMode())
            tgt.setListMode(convertStructureMapSourceListMode(src.getListMode()));
        if (src.hasVariable())
            tgt.setVariable(src.getVariable());
        if (src.hasCondition())
            tgt.setCondition(src.getCondition());
        if (src.hasCheck())
            tgt.setCheck(src.getCheck());
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleSourceComponent convertStructureMapGroupRuleSourceComponent(org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleSourceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleSourceComponent tgt = new org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleSourceComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        tgt.setContextType(StructureMapContextType.TYPE);
        tgt.setContext(src.getContext());
        if (src.hasElement())
            tgt.setElement(src.getElement());
        if (src.hasListMode())
            tgt.setListMode(convertStructureMapSourceListMode(src.getListMode()));
        if (src.hasVariable())
            tgt.setVariable(src.getVariable());
        if (src.hasCondition())
            tgt.setCondition(src.getCondition());
        if (src.hasCheck())
            tgt.setCheck(src.getCheck());
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleTargetComponent convertStructureMapGroupRuleTargetComponent(org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleTargetComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleTargetComponent tgt = new org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleTargetComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasContext())
            tgt.setContext(src.getContext());
        if (src.hasContextType())
            tgt.setContextType(convertStructureMapContextType(src.getContextType()));
        if (src.hasElement())
            tgt.setElement(src.getElement());
        if (src.hasVariable())
            tgt.setVariable(src.getVariable());
        for (Enumeration<org.hl7.fhir.r4.model.StructureMap.StructureMapTargetListMode> t : src.getListMode()) tgt.addListMode(convertStructureMapTargetListMode(t.getValue()));
        if (src.hasListRuleId())
            tgt.setListRuleId(src.getListRuleId());
        if (src.hasTransform())
            tgt.setTransform(convertStructureMapTransform(src.getTransform()));
        for (org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleTargetParameterComponent t : src.getParameter()) tgt.addParameter(convertStructureMapGroupRuleTargetParameterComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleTargetComponent convertStructureMapGroupRuleTargetComponent(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleTargetComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleTargetComponent tgt = new org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleTargetComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasContext())
            tgt.setContext(src.getContext());
        if (src.hasContextType())
            tgt.setContextType(convertStructureMapContextType(src.getContextType()));
        if (src.hasElement())
            tgt.setElement(src.getElement());
        if (src.hasVariable())
            tgt.setVariable(src.getVariable());
        for (org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapListMode> t : src.getListMode()) VersionConvertor_14_40.copyElement(t, tgt.addListModeElement().setValue(convertStructureMapTargetListMode(t.getValue())));
        if (src.hasListRuleId())
            tgt.setListRuleId(src.getListRuleId());
        if (src.hasTransform())
            tgt.setTransform(convertStructureMapTransform(src.getTransform()));
        for (org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleTargetParameterComponent t : src.getParameter()) tgt.addParameter(convertStructureMapGroupRuleTargetParameterComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleTargetParameterComponent convertStructureMapGroupRuleTargetParameterComponent(org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleTargetParameterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleTargetParameterComponent tgt = new org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleTargetParameterComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        tgt.setValue(VersionConvertor_14_40.convertType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleTargetParameterComponent convertStructureMapGroupRuleTargetParameterComponent(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapGroupRuleTargetParameterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleTargetParameterComponent tgt = new org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleTargetParameterComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        tgt.setValue(VersionConvertor_14_40.convertType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapInputMode convertStructureMapInputMode(org.hl7.fhir.r4.model.StructureMap.StructureMapInputMode src) throws FHIRException {
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

    public static org.hl7.fhir.r4.model.StructureMap.StructureMapInputMode convertStructureMapInputMode(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapInputMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case SOURCE:
                return org.hl7.fhir.r4.model.StructureMap.StructureMapInputMode.SOURCE;
            case TARGET:
                return org.hl7.fhir.r4.model.StructureMap.StructureMapInputMode.TARGET;
            default:
                return org.hl7.fhir.r4.model.StructureMap.StructureMapInputMode.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.StructureMap.StructureMapSourceListMode convertStructureMapSourceListMode(StructureMapListMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case FIRST:
                return org.hl7.fhir.r4.model.StructureMap.StructureMapSourceListMode.FIRST;
            case LAST:
                return org.hl7.fhir.r4.model.StructureMap.StructureMapSourceListMode.LAST;
            default:
                return org.hl7.fhir.r4.model.StructureMap.StructureMapSourceListMode.NULL;
        }
    }

    public static org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapListMode convertStructureMapSourceListMode(org.hl7.fhir.r4.model.StructureMap.StructureMapSourceListMode src) throws FHIRException {
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

    public static org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapStructureComponent convertStructureMapStructureComponent(org.hl7.fhir.r4.model.StructureMap.StructureMapStructureComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapStructureComponent tgt = new org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapStructureComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        tgt.setUrl(src.getUrl());
        tgt.setMode(convertStructureMapStructureMode(src.getMode()));
        if (src.hasDocumentation())
            tgt.setDocumentation(src.getDocumentation());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.StructureMap.StructureMapStructureComponent convertStructureMapStructureComponent(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapStructureComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.StructureMap.StructureMapStructureComponent tgt = new org.hl7.fhir.r4.model.StructureMap.StructureMapStructureComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        tgt.setUrl(src.getUrl());
        tgt.setMode(convertStructureMapStructureMode(src.getMode()));
        if (src.hasDocumentation())
            tgt.setDocumentation(src.getDocumentation());
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapModelMode convertStructureMapStructureMode(org.hl7.fhir.r4.model.StructureMap.StructureMapModelMode src) throws FHIRException {
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

    public static org.hl7.fhir.r4.model.StructureMap.StructureMapModelMode convertStructureMapStructureMode(org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapModelMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PRODUCED:
                return org.hl7.fhir.r4.model.StructureMap.StructureMapModelMode.PRODUCED;
            case QUERIED:
                return org.hl7.fhir.r4.model.StructureMap.StructureMapModelMode.QUERIED;
            case SOURCE:
                return org.hl7.fhir.r4.model.StructureMap.StructureMapModelMode.SOURCE;
            case TARGET:
                return org.hl7.fhir.r4.model.StructureMap.StructureMapModelMode.TARGET;
            default:
                return org.hl7.fhir.r4.model.StructureMap.StructureMapModelMode.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.StructureMap.StructureMapTargetListMode convertStructureMapTargetListMode(StructureMapListMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case FIRST:
                return org.hl7.fhir.r4.model.StructureMap.StructureMapTargetListMode.FIRST;
            case LAST:
                return org.hl7.fhir.r4.model.StructureMap.StructureMapTargetListMode.LAST;
            case SHARE:
                return org.hl7.fhir.r4.model.StructureMap.StructureMapTargetListMode.SHARE;
            default:
                return org.hl7.fhir.r4.model.StructureMap.StructureMapTargetListMode.NULL;
        }
    }

    public static org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapListMode convertStructureMapTargetListMode(org.hl7.fhir.r4.model.StructureMap.StructureMapTargetListMode src) throws FHIRException {
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

    public static org.hl7.fhir.dstu2016may.model.StructureMap.StructureMapTransform convertStructureMapTransform(org.hl7.fhir.r4.model.StructureMap.StructureMapTransform src) throws FHIRException {
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

    public static org.hl7.fhir.r4.model.StructureMap.StructureMapTransform convertStructureMapTransform(StructureMap.StructureMapTransform src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case APPEND:
                return org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.APPEND;
            case CAST:
                return org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.CAST;
            case COPY:
                return org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.COPY;
            case CREATE:
                return org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.CREATE;
            case DATEOP:
                return org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.DATEOP;
            case ESCAPE:
                return org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.ESCAPE;
            case EVALUATE:
                return org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.EVALUATE;
            case POINTER:
                return org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.POINTER;
            case REFERENCE:
                return org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.REFERENCE;
            case TRANSLATE:
                return org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.TRANSLATE;
            case TRUNCATE:
                return org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.TRUNCATE;
            case UUID:
                return org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.UUID;
            default:
                return org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.NULL;
        }
    }
}
