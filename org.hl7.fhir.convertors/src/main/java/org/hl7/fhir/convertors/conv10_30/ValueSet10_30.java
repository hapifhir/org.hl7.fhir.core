package org.hl7.fhir.convertors.conv10_30;

import java.util.List;
import org.hl7.fhir.convertors.VersionConvertorAdvisor30;
import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.dstu2.model.ValueSet;
import org.hl7.fhir.dstu3.model.CodeSystem;
import org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemContentMode;
import org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.dstu3.terminologies.CodeSystemUtilities;
import org.hl7.fhir.exceptions.FHIRException;

public class ValueSet10_30 {

    public static org.hl7.fhir.dstu2.model.ValueSet.ConceptReferenceComponent convertConceptReferenceComponent(org.hl7.fhir.dstu3.model.ValueSet.ConceptReferenceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ValueSet.ConceptReferenceComponent tgt = new org.hl7.fhir.dstu2.model.ValueSet.ConceptReferenceComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement(VersionConvertor_10_30.convertCode(src.getCodeElement()));
        if (src.hasDisplayElement())
            tgt.setDisplayElement(VersionConvertor_10_30.convertString(src.getDisplayElement()));
        for (org.hl7.fhir.dstu3.model.ValueSet.ConceptReferenceDesignationComponent t : src.getDesignation()) tgt.addDesignation(convertConceptReferenceDesignationComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ValueSet.ConceptReferenceComponent convertConceptReferenceComponent(org.hl7.fhir.dstu2.model.ValueSet.ConceptReferenceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ValueSet.ConceptReferenceComponent tgt = new org.hl7.fhir.dstu3.model.ValueSet.ConceptReferenceComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement(VersionConvertor_10_30.convertCode(src.getCodeElement()));
        if (src.hasDisplayElement())
            tgt.setDisplayElement(VersionConvertor_10_30.convertString(src.getDisplayElement()));
        for (org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionDesignationComponent t : src.getDesignation()) tgt.addDesignation(convertConceptReferenceDesignationComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ValueSet.ConceptReferenceDesignationComponent convertConceptReferenceDesignationComponent(org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionDesignationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ValueSet.ConceptReferenceDesignationComponent tgt = new org.hl7.fhir.dstu3.model.ValueSet.ConceptReferenceDesignationComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasLanguageElement())
            tgt.setLanguageElement(VersionConvertor_10_30.convertCode(src.getLanguageElement()));
        if (src.hasUse())
            tgt.setUse(VersionConvertor_10_30.convertCoding(src.getUse()));
        if (src.hasValueElement())
            tgt.setValueElement(VersionConvertor_10_30.convertString(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionDesignationComponent convertConceptReferenceDesignationComponent(org.hl7.fhir.dstu3.model.ValueSet.ConceptReferenceDesignationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionDesignationComponent tgt = new org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionDesignationComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasLanguageElement())
            tgt.setLanguageElement(VersionConvertor_10_30.convertCode(src.getLanguageElement()));
        if (src.hasUse())
            tgt.setUse(VersionConvertor_10_30.convertCoding(src.getUse()));
        if (src.hasValueElement())
            tgt.setValueElement(VersionConvertor_10_30.convertString(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ValueSet.ConceptSetComponent convertConceptSetComponent(org.hl7.fhir.dstu3.model.ValueSet.ConceptSetComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ValueSet.ConceptSetComponent tgt = new org.hl7.fhir.dstu2.model.ValueSet.ConceptSetComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasSystemElement())
            tgt.setSystemElement(VersionConvertor_10_30.convertUri(src.getSystemElement()));
        if (src.hasVersionElement())
            tgt.setVersionElement(VersionConvertor_10_30.convertString(src.getVersionElement()));
        for (org.hl7.fhir.dstu3.model.ValueSet.ConceptReferenceComponent t : src.getConcept()) tgt.addConcept(convertConceptReferenceComponent(t));
        for (org.hl7.fhir.dstu3.model.ValueSet.ConceptSetFilterComponent t : src.getFilter()) tgt.addFilter(convertConceptSetFilterComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ValueSet.ConceptSetComponent convertConceptSetComponent(org.hl7.fhir.dstu2.model.ValueSet.ConceptSetComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ValueSet.ConceptSetComponent tgt = new org.hl7.fhir.dstu3.model.ValueSet.ConceptSetComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasSystemElement())
            tgt.setSystemElement(VersionConvertor_10_30.convertUri(src.getSystemElement()));
        if (src.hasVersionElement())
            tgt.setVersionElement(VersionConvertor_10_30.convertString(src.getVersionElement()));
        for (org.hl7.fhir.dstu2.model.ValueSet.ConceptReferenceComponent t : src.getConcept()) tgt.addConcept(convertConceptReferenceComponent(t));
        for (org.hl7.fhir.dstu2.model.ValueSet.ConceptSetFilterComponent t : src.getFilter()) tgt.addFilter(convertConceptSetFilterComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ValueSet.ConceptSetFilterComponent convertConceptSetFilterComponent(org.hl7.fhir.dstu2.model.ValueSet.ConceptSetFilterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ValueSet.ConceptSetFilterComponent tgt = new org.hl7.fhir.dstu3.model.ValueSet.ConceptSetFilterComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasPropertyElement())
            tgt.setPropertyElement(VersionConvertor_10_30.convertCode(src.getPropertyElement()));
        if (src.hasOp())
            tgt.setOpElement(convertFilterOperator(src.getOpElement()));
        if (src.hasValueElement())
            tgt.setValueElement(VersionConvertor_10_30.convertCode(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ValueSet.ConceptSetFilterComponent convertConceptSetFilterComponent(org.hl7.fhir.dstu3.model.ValueSet.ConceptSetFilterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ValueSet.ConceptSetFilterComponent tgt = new org.hl7.fhir.dstu2.model.ValueSet.ConceptSetFilterComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasPropertyElement())
            tgt.setPropertyElement(VersionConvertor_10_30.convertCode(src.getPropertyElement()));
        if (src.hasOp())
            tgt.setOpElement(convertFilterOperator(src.getOpElement()));
        if (src.hasValueElement())
            tgt.setValueElement(VersionConvertor_10_30.convertCode(src.getValueElement()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ValueSet.FilterOperator> convertFilterOperator(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ValueSet.FilterOperator> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ValueSet.FilterOperator> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.ValueSet.FilterOperatorEnumFactory());
        VersionConvertor_10_30.copyElement(src, tgt);
        switch(src.getValue()) {
            case EQUAL:
                tgt.setValue(org.hl7.fhir.dstu3.model.ValueSet.FilterOperator.EQUAL);
                break;
            case ISA:
                tgt.setValue(org.hl7.fhir.dstu3.model.ValueSet.FilterOperator.ISA);
                break;
            case ISNOTA:
                tgt.setValue(org.hl7.fhir.dstu3.model.ValueSet.FilterOperator.ISNOTA);
                break;
            case REGEX:
                tgt.setValue(org.hl7.fhir.dstu3.model.ValueSet.FilterOperator.REGEX);
                break;
            case IN:
                tgt.setValue(org.hl7.fhir.dstu3.model.ValueSet.FilterOperator.IN);
                break;
            case NOTIN:
                tgt.setValue(org.hl7.fhir.dstu3.model.ValueSet.FilterOperator.NOTIN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.ValueSet.FilterOperator.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ValueSet.FilterOperator> convertFilterOperator(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ValueSet.FilterOperator> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ValueSet.FilterOperator> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.ValueSet.FilterOperatorEnumFactory());
        VersionConvertor_10_30.copyElement(src, tgt);
        switch(src.getValue()) {
            case EQUAL:
                tgt.setValue(org.hl7.fhir.dstu2.model.ValueSet.FilterOperator.EQUAL);
                break;
            case ISA:
                tgt.setValue(org.hl7.fhir.dstu2.model.ValueSet.FilterOperator.ISA);
                break;
            case ISNOTA:
                tgt.setValue(org.hl7.fhir.dstu2.model.ValueSet.FilterOperator.ISNOTA);
                break;
            case REGEX:
                tgt.setValue(org.hl7.fhir.dstu2.model.ValueSet.FilterOperator.REGEX);
                break;
            case IN:
                tgt.setValue(org.hl7.fhir.dstu2.model.ValueSet.FilterOperator.IN);
                break;
            case NOTIN:
                tgt.setValue(org.hl7.fhir.dstu2.model.ValueSet.FilterOperator.NOTIN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.ValueSet.FilterOperator.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ValueSet convertValueSet(org.hl7.fhir.dstu2.model.ValueSet src, VersionConvertorAdvisor30 advisor) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ValueSet tgt = new org.hl7.fhir.dstu3.model.ValueSet();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement(VersionConvertor_10_30.convertUri(src.getUrlElement()));
        if (src.hasIdentifier())
            tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(src.getIdentifier()));
        if (src.hasVersionElement())
            tgt.setVersionElement(VersionConvertor_10_30.convertString(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_30.convertString(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatusElement(VersionConvertor_10_30.convertConformanceResourceStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(VersionConvertor_10_30.convertBoolean(src.getExperimentalElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement(VersionConvertor_10_30.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.dstu2.model.ValueSet.ValueSetContactComponent t : src.getContact()) tgt.addContact(convertValueSetContactComponent(t));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_10_30.convertDateTime(src.getDateElement()));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getUseContext()) if (VersionConvertor_10_30.isJurisdiction(t))
            tgt.addJurisdiction(VersionConvertor_10_30.convertCodeableConcept(t));
        else
            tgt.addUseContext(VersionConvertor_10_30.convertCodeableConceptToUsageContext(t));
        if (src.hasImmutableElement())
            tgt.setImmutableElement(VersionConvertor_10_30.convertBoolean(src.getImmutableElement()));
        if (src.hasRequirements())
            tgt.setPurpose(src.getRequirements());
        if (src.hasCopyright())
            tgt.setCopyright(src.getCopyright());
        if (src.hasExtensibleElement())
            tgt.setExtensibleElement(VersionConvertor_10_30.convertBoolean(src.getExtensibleElement()));
        if (src.hasCompose()) {
            if (src.hasCompose())
                tgt.setCompose(convertValueSetComposeComponent(src.getCompose()));
            tgt.getCompose().setLockedDate(src.getLockedDate());
        }
        if (src.hasCodeSystem() && advisor != null) {
            org.hl7.fhir.dstu3.model.CodeSystem tgtcs = new org.hl7.fhir.dstu3.model.CodeSystem();
            VersionConvertor_10_30.copyDomainResource(src, tgtcs);
            tgtcs.setUrl(src.getCodeSystem().getSystem());
            tgtcs.setIdentifier(VersionConvertor_10_30.convertIdentifier(src.getIdentifier()));
            tgtcs.setVersion(src.getCodeSystem().getVersion());
            tgtcs.setName(src.getName() + " Code System");
            tgtcs.setStatusElement(VersionConvertor_10_30.convertConformanceResourceStatus(src.getStatusElement()));
            if (src.hasExperimental())
                tgtcs.setExperimental(src.getExperimental());
            tgtcs.setPublisher(src.getPublisher());
            for (org.hl7.fhir.dstu2.model.ValueSet.ValueSetContactComponent t : src.getContact()) tgtcs.addContact(convertValueSetContactComponent(t));
            if (src.hasDate())
                tgtcs.setDate(src.getDate());
            tgtcs.setDescription(src.getDescription());
            for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getUseContext()) if (VersionConvertor_10_30.isJurisdiction(t))
                tgtcs.addJurisdiction(VersionConvertor_10_30.convertCodeableConcept(t));
            else
                tgtcs.addUseContext(VersionConvertor_10_30.convertCodeableConceptToUsageContext(t));
            tgtcs.setPurpose(src.getRequirements());
            tgtcs.setCopyright(src.getCopyright());
            tgtcs.setContent(CodeSystemContentMode.COMPLETE);
            tgtcs.setCaseSensitive(src.getCodeSystem().getCaseSensitive());
            for (org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionComponent cs : src.getCodeSystem().getConcept()) processConcept(tgtcs.getConcept(), cs, tgtcs);
            advisor.handleCodeSystem(tgtcs, tgt);
            tgt.setUserData("r2-cs", tgtcs);
            tgt.getCompose().addInclude().setSystem(tgtcs.getUrl());
        }
        if (src.hasExpansion())
            tgt.setExpansion(convertValueSetExpansionComponent(src.getExpansion()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ValueSet convertValueSet(org.hl7.fhir.dstu3.model.ValueSet src, VersionConvertorAdvisor30 advisor) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ValueSet tgt = new org.hl7.fhir.dstu2.model.ValueSet();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement(VersionConvertor_10_30.convertUri(src.getUrlElement()));
        for (org.hl7.fhir.dstu3.model.Identifier i : src.getIdentifier()) tgt.setIdentifier(VersionConvertor_10_30.convertIdentifier(i));
        if (src.hasVersionElement())
            tgt.setVersionElement(VersionConvertor_10_30.convertString(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_30.convertString(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatusElement(VersionConvertor_10_30.convertConformanceResourceStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(VersionConvertor_10_30.convertBoolean(src.getExperimentalElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement(VersionConvertor_10_30.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(convertValueSetContactComponent(t));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_10_30.convertDateTime(src.getDateElement()));
        tgt.setLockedDate(src.getCompose().getLockedDate());
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext()) if (t.hasValueCodeableConcept())
            tgt.addUseContext(VersionConvertor_10_30.convertCodeableConcept(t.getValueCodeableConcept()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addUseContext(VersionConvertor_10_30.convertCodeableConcept(t));
        if (src.hasImmutableElement())
            tgt.setImmutableElement(VersionConvertor_10_30.convertBoolean(src.getImmutableElement()));
        if (src.hasPurpose())
            tgt.setRequirements(src.getPurpose());
        if (src.hasCopyright())
            tgt.setCopyright(src.getCopyright());
        if (src.hasExtensibleElement())
            tgt.setExtensibleElement(VersionConvertor_10_30.convertBoolean(src.getExtensibleElement()));
        org.hl7.fhir.dstu3.model.CodeSystem srcCS = (CodeSystem) src.getUserData("r2-cs");
        if (srcCS == null)
            srcCS = advisor.getCodeSystem(src);
        if (srcCS != null) {
            tgt.getCodeSystem().setSystem(srcCS.getUrl());
            tgt.getCodeSystem().setVersion(srcCS.getVersion());
            tgt.getCodeSystem().setCaseSensitive(srcCS.getCaseSensitive());
            for (org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionComponent cs : srcCS.getConcept()) processConcept(tgt.getCodeSystem().getConcept(), cs, srcCS);
        }
        if (src.hasCompose())
            tgt.setCompose(convertValueSetComposeComponent(src.getCompose(), srcCS == null ? null : srcCS.getUrl()));
        if (src.hasExpansion())
            tgt.setExpansion(convertValueSetExpansionComponent(src.getExpansion()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ValueSet convertValueSet(org.hl7.fhir.dstu2.model.ValueSet src) throws FHIRException {
        return convertValueSet(src, null);
    }

    public static org.hl7.fhir.dstu2.model.ValueSet convertValueSet(org.hl7.fhir.dstu3.model.ValueSet src) throws FHIRException {
        return convertValueSet(src, null);
    }

    public static org.hl7.fhir.dstu3.model.ValueSet.ValueSetComposeComponent convertValueSetComposeComponent(org.hl7.fhir.dstu2.model.ValueSet.ValueSetComposeComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ValueSet.ValueSetComposeComponent tgt = new org.hl7.fhir.dstu3.model.ValueSet.ValueSetComposeComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        for (org.hl7.fhir.dstu2.model.UriType t : src.getImport()) tgt.addInclude().addValueSet(t.getValue());
        for (org.hl7.fhir.dstu2.model.ValueSet.ConceptSetComponent t : src.getInclude()) tgt.addInclude(convertConceptSetComponent(t));
        for (org.hl7.fhir.dstu2.model.ValueSet.ConceptSetComponent t : src.getExclude()) tgt.addExclude(convertConceptSetComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ValueSet.ValueSetComposeComponent convertValueSetComposeComponent(org.hl7.fhir.dstu3.model.ValueSet.ValueSetComposeComponent src, String noSystem) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ValueSet.ValueSetComposeComponent tgt = new org.hl7.fhir.dstu2.model.ValueSet.ValueSetComposeComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        for (org.hl7.fhir.dstu3.model.ValueSet.ConceptSetComponent t : src.getInclude()) {
            for (org.hl7.fhir.dstu3.model.UriType ti : t.getValueSet()) tgt.addImport(ti.getValue());
            if (noSystem == null || !t.getSystem().equals(noSystem))
                tgt.addInclude(convertConceptSetComponent(t));
        }
        for (org.hl7.fhir.dstu3.model.ValueSet.ConceptSetComponent t : src.getExclude()) tgt.addExclude(convertConceptSetComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ValueSet.ValueSetContactComponent convertValueSetContactComponent(org.hl7.fhir.dstu3.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ValueSet.ValueSetContactComponent tgt = new org.hl7.fhir.dstu2.model.ValueSet.ValueSetContactComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_30.convertString(src.getNameElement()));
        for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_30.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ContactDetail convertValueSetContactComponent(org.hl7.fhir.dstu2.model.ValueSet.ValueSetContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ContactDetail tgt = new org.hl7.fhir.dstu3.model.ContactDetail();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_30.convertString(src.getNameElement()));
        for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_30.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionComponent convertValueSetExpansionComponent(org.hl7.fhir.dstu2.model.ValueSet.ValueSetExpansionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionComponent tgt = new org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasIdentifierElement())
            tgt.setIdentifierElement(VersionConvertor_10_30.convertUri(src.getIdentifierElement()));
        if (src.hasTimestampElement())
            tgt.setTimestampElement(VersionConvertor_10_30.convertDateTime(src.getTimestampElement()));
        if (src.hasTotalElement())
            tgt.setTotalElement(VersionConvertor_10_30.convertInteger(src.getTotalElement()));
        if (src.hasOffsetElement())
            tgt.setOffsetElement(VersionConvertor_10_30.convertInteger(src.getOffsetElement()));
        for (org.hl7.fhir.dstu2.model.ValueSet.ValueSetExpansionParameterComponent t : src.getParameter()) tgt.addParameter(convertValueSetExpansionParameterComponent(t));
        for (org.hl7.fhir.dstu2.model.ValueSet.ValueSetExpansionContainsComponent t : src.getContains()) tgt.addContains(convertValueSetExpansionContainsComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ValueSet.ValueSetExpansionComponent convertValueSetExpansionComponent(org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ValueSet.ValueSetExpansionComponent tgt = new org.hl7.fhir.dstu2.model.ValueSet.ValueSetExpansionComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasIdentifierElement())
            tgt.setIdentifierElement(VersionConvertor_10_30.convertUri(src.getIdentifierElement()));
        if (src.hasTimestampElement())
            tgt.setTimestampElement(VersionConvertor_10_30.convertDateTime(src.getTimestampElement()));
        if (src.hasTotalElement())
            tgt.setTotalElement(VersionConvertor_10_30.convertInteger(src.getTotalElement()));
        if (src.hasOffsetElement())
            tgt.setOffsetElement(VersionConvertor_10_30.convertInteger(src.getOffsetElement()));
        for (org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionParameterComponent t : src.getParameter()) tgt.addParameter(convertValueSetExpansionParameterComponent(t));
        for (org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionContainsComponent t : src.getContains()) tgt.addContains(convertValueSetExpansionContainsComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ValueSet.ValueSetExpansionContainsComponent convertValueSetExpansionContainsComponent(org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionContainsComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ValueSet.ValueSetExpansionContainsComponent tgt = new org.hl7.fhir.dstu2.model.ValueSet.ValueSetExpansionContainsComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasSystemElement())
            tgt.setSystemElement(VersionConvertor_10_30.convertUri(src.getSystemElement()));
        if (src.hasAbstractElement())
            tgt.setAbstractElement(VersionConvertor_10_30.convertBoolean(src.getAbstractElement()));
        if (src.hasVersionElement())
            tgt.setVersionElement(VersionConvertor_10_30.convertString(src.getVersionElement()));
        if (src.hasCodeElement())
            tgt.setCodeElement(VersionConvertor_10_30.convertCode(src.getCodeElement()));
        if (src.hasDisplayElement())
            tgt.setDisplayElement(VersionConvertor_10_30.convertString(src.getDisplayElement()));
        for (org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionContainsComponent t : src.getContains()) tgt.addContains(convertValueSetExpansionContainsComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionContainsComponent convertValueSetExpansionContainsComponent(org.hl7.fhir.dstu2.model.ValueSet.ValueSetExpansionContainsComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionContainsComponent tgt = new org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionContainsComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasSystemElement())
            tgt.setSystemElement(VersionConvertor_10_30.convertUri(src.getSystemElement()));
        if (src.hasAbstractElement())
            tgt.setAbstractElement(VersionConvertor_10_30.convertBoolean(src.getAbstractElement()));
        if (src.hasVersionElement())
            tgt.setVersionElement(VersionConvertor_10_30.convertString(src.getVersionElement()));
        if (src.hasCodeElement())
            tgt.setCodeElement(VersionConvertor_10_30.convertCode(src.getCodeElement()));
        if (src.hasDisplayElement())
            tgt.setDisplayElement(VersionConvertor_10_30.convertString(src.getDisplayElement()));
        for (org.hl7.fhir.dstu2.model.ValueSet.ValueSetExpansionContainsComponent t : src.getContains()) tgt.addContains(convertValueSetExpansionContainsComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ValueSet.ValueSetExpansionParameterComponent convertValueSetExpansionParameterComponent(org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionParameterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ValueSet.ValueSetExpansionParameterComponent tgt = new org.hl7.fhir.dstu2.model.ValueSet.ValueSetExpansionParameterComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_30.convertString(src.getNameElement()));
        if (src.hasValue())
            tgt.setValue(VersionConvertor_10_30.convertType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionParameterComponent convertValueSetExpansionParameterComponent(org.hl7.fhir.dstu2.model.ValueSet.ValueSetExpansionParameterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionParameterComponent tgt = new org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionParameterComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_30.convertString(src.getNameElement()));
        if (src.hasValue())
            tgt.setValue(VersionConvertor_10_30.convertType(src.getValue()));
        return tgt;
    }

    static public void processConcept(List<ConceptDefinitionComponent> concepts, org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionComponent cs, CodeSystem tgtcs) throws FHIRException {
        org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionComponent ct = new org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionComponent();
        concepts.add(ct);
        ct.setCode(cs.getCode());
        ct.setDisplay(cs.getDisplay());
        ct.setDefinition(cs.getDefinition());
        if (cs.getAbstract())
            CodeSystemUtilities.setNotSelectable(tgtcs, ct);
        for (org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionDesignationComponent csd : cs.getDesignation()) {
            org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionDesignationComponent cst = new org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionDesignationComponent();
            cst.setLanguage(csd.getLanguage());
            cst.setUse(VersionConvertor_10_30.convertCoding(csd.getUse()));
            cst.setValue(csd.getValue());
        }
        for (org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionComponent csc : cs.getConcept()) processConcept(ct.getConcept(), csc, tgtcs);
    }

    static public void processConcept(List<ValueSet.ConceptDefinitionComponent> concepts, ConceptDefinitionComponent cs, CodeSystem srcCS) throws FHIRException {
        org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionComponent ct = new org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionComponent();
        concepts.add(ct);
        ct.setCode(cs.getCode());
        ct.setDisplay(cs.getDisplay());
        ct.setDefinition(cs.getDefinition());
        if (CodeSystemUtilities.isNotSelectable(srcCS, cs))
            ct.setAbstract(true);
        for (org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionDesignationComponent csd : cs.getDesignation()) {
            org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionDesignationComponent cst = new org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionDesignationComponent();
            cst.setLanguage(csd.getLanguage());
            cst.setUse(VersionConvertor_10_30.convertCoding(csd.getUse()));
            cst.setValue(csd.getValue());
        }
        for (ConceptDefinitionComponent csc : cs.getConcept()) processConcept(ct.getConcept(), csc, srcCS);
    }
}