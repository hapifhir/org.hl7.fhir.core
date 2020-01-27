package org.hl7.fhir.convertors.conv10_50;

import org.hl7.fhir.convertors.VersionConvertorAdvisor50;
import org.hl7.fhir.convertors.VersionConvertor_10_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.BooleanType;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.CodeSystem.CodeSystemContentMode;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.terminologies.CodeSystemUtilities;

import java.util.List;

public class ValueSet10_50 {

    public static org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent convertConceptReferenceComponent(org.hl7.fhir.dstu2.model.ValueSet.ConceptReferenceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setCode(src.getCode());
        tgt.setDisplay(src.getDisplay());
        for (org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionDesignationComponent t : src.getDesignation()) tgt.addDesignation(convertConceptReferenceDesignationComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ValueSet.ConceptReferenceComponent convertConceptReferenceComponent(org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ValueSet.ConceptReferenceComponent tgt = new org.hl7.fhir.dstu2.model.ValueSet.ConceptReferenceComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setCode(src.getCode());
        tgt.setDisplay(src.getDisplay());
        for (org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent t : src.getDesignation()) tgt.addDesignation(convertConceptReferenceDesignationComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent convertConceptReferenceDesignationComponent(org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionDesignationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setLanguage(src.getLanguage());
        tgt.setUse(VersionConvertor_10_50.convertCoding(src.getUse()));
        tgt.setValue(src.getValue());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionDesignationComponent convertConceptReferenceDesignationComponent(org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionDesignationComponent tgt = new org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionDesignationComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setLanguage(src.getLanguage());
        tgt.setUse(VersionConvertor_10_50.convertCoding(src.getUse()));
        tgt.setValue(src.getValue());
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent convertConceptSetComponent(org.hl7.fhir.dstu2.model.ValueSet.ConceptSetComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setSystem(src.getSystem());
        tgt.setVersion(src.getVersion());
        for (org.hl7.fhir.dstu2.model.ValueSet.ConceptReferenceComponent t : src.getConcept()) tgt.addConcept(convertConceptReferenceComponent(t));
        for (org.hl7.fhir.dstu2.model.ValueSet.ConceptSetFilterComponent t : src.getFilter()) tgt.addFilter(convertConceptSetFilterComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ValueSet.ConceptSetComponent convertConceptSetComponent(org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ValueSet.ConceptSetComponent tgt = new org.hl7.fhir.dstu2.model.ValueSet.ConceptSetComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setSystem(src.getSystem());
        tgt.setVersion(src.getVersion());
        for (org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent t : src.getConcept()) tgt.addConcept(convertConceptReferenceComponent(t));
        for (org.hl7.fhir.r5.model.ValueSet.ConceptSetFilterComponent t : src.getFilter()) tgt.addFilter(convertConceptSetFilterComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ValueSet.ConceptSetFilterComponent convertConceptSetFilterComponent(org.hl7.fhir.r5.model.ValueSet.ConceptSetFilterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ValueSet.ConceptSetFilterComponent tgt = new org.hl7.fhir.dstu2.model.ValueSet.ConceptSetFilterComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setProperty(src.getProperty());
        tgt.setOp(convertFilterOperator(src.getOp()));
        tgt.setValue(src.getValue());
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ValueSet.ConceptSetFilterComponent convertConceptSetFilterComponent(org.hl7.fhir.dstu2.model.ValueSet.ConceptSetFilterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ValueSet.ConceptSetFilterComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ConceptSetFilterComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setProperty(src.getProperty());
        tgt.setOp(convertFilterOperator(src.getOp()));
        tgt.setValue(src.getValue());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ValueSet.FilterOperator convertFilterOperator(org.hl7.fhir.r5.model.Enumerations.FilterOperator src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case EQUAL:
                return org.hl7.fhir.dstu2.model.ValueSet.FilterOperator.EQUAL;
            case ISA:
                return org.hl7.fhir.dstu2.model.ValueSet.FilterOperator.ISA;
            case ISNOTA:
                return org.hl7.fhir.dstu2.model.ValueSet.FilterOperator.ISNOTA;
            case REGEX:
                return org.hl7.fhir.dstu2.model.ValueSet.FilterOperator.REGEX;
            case IN:
                return org.hl7.fhir.dstu2.model.ValueSet.FilterOperator.IN;
            case NOTIN:
                return org.hl7.fhir.dstu2.model.ValueSet.FilterOperator.NOTIN;
            default:
                return org.hl7.fhir.dstu2.model.ValueSet.FilterOperator.NULL;
        }
    }

    public static org.hl7.fhir.r5.model.Enumerations.FilterOperator convertFilterOperator(org.hl7.fhir.dstu2.model.ValueSet.FilterOperator src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case EQUAL:
                return org.hl7.fhir.r5.model.Enumerations.FilterOperator.EQUAL;
            case ISA:
                return org.hl7.fhir.r5.model.Enumerations.FilterOperator.ISA;
            case ISNOTA:
                return org.hl7.fhir.r5.model.Enumerations.FilterOperator.ISNOTA;
            case REGEX:
                return org.hl7.fhir.r5.model.Enumerations.FilterOperator.REGEX;
            case IN:
                return org.hl7.fhir.r5.model.Enumerations.FilterOperator.IN;
            case NOTIN:
                return org.hl7.fhir.r5.model.Enumerations.FilterOperator.NOTIN;
            default:
                return org.hl7.fhir.r5.model.Enumerations.FilterOperator.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.ValueSet convertValueSet(org.hl7.fhir.r5.model.ValueSet src, VersionConvertorAdvisor50 advisor) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ValueSet tgt = new org.hl7.fhir.dstu2.model.ValueSet();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        tgt.setUrl(src.getUrl());
        for (org.hl7.fhir.r5.model.Identifier i : src.getIdentifier()) tgt.setIdentifier(VersionConvertor_10_50.convertIdentifier(i));
        tgt.setVersion(src.getVersion());
        tgt.setName(src.getName());
        tgt.setStatus(VersionConvertor_10_50.convertConformanceResourceStatus(src.getStatus()));
        if (src.hasExperimental())
            tgt.setExperimental(src.getExperimental());
        tgt.setPublisher(src.getPublisher());
        for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact()) tgt.addContact(convertValueSetContactComponent(t));
        if (src.hasDate())
            tgt.setDate(src.getDate());
        tgt.setLockedDate(src.getCompose().getLockedDate());
        tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext()) if (t.hasValueCodeableConcept())
            tgt.addUseContext(VersionConvertor_10_50.convertCodeableConcept(t.getValueCodeableConcept()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction()) tgt.addUseContext(VersionConvertor_10_50.convertCodeableConcept(t));
        tgt.setImmutable(src.getImmutable());
        tgt.setRequirements(src.getPurpose());
        tgt.setCopyright(src.getCopyright());
        if (src.hasExtension("http://hl7.org/fhir/StructureDefinition/valueset-extensible"))
            tgt.setExtensible(((BooleanType) src.getExtensionByUrl("http://hl7.org/fhir/StructureDefinition/valueset-extensible").getValue()).booleanValue());
        org.hl7.fhir.r5.model.CodeSystem srcCS = (CodeSystem) src.getUserData("r2-cs");
        if (srcCS == null && advisor != null)
            srcCS = advisor.getCodeSystem(src);
        if (srcCS != null) {
            tgt.getCodeSystem().setSystem(srcCS.getUrl());
            tgt.getCodeSystem().setVersion(srcCS.getVersion());
            tgt.getCodeSystem().setCaseSensitive(srcCS.getCaseSensitive());
            for (org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent cs : srcCS.getConcept()) processConcept(tgt.getCodeSystem().getConcept(), cs, srcCS);
        }
        tgt.setCompose(convertValueSetComposeComponent(src.getCompose(), srcCS == null ? null : srcCS.getUrl()));
        tgt.setExpansion(convertValueSetExpansionComponent(src.getExpansion()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ValueSet convertValueSet(org.hl7.fhir.dstu2.model.ValueSet src) throws FHIRException {
        return convertValueSet(src, null);
    }

    public static org.hl7.fhir.r5.model.ValueSet convertValueSet(org.hl7.fhir.dstu2.model.ValueSet src, VersionConvertorAdvisor50 advisor) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ValueSet tgt = new org.hl7.fhir.r5.model.ValueSet();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        tgt.setUrl(src.getUrl());
        tgt.addIdentifier(VersionConvertor_10_50.convertIdentifier(src.getIdentifier()));
        tgt.setVersion(src.getVersion());
        tgt.setName(src.getName());
        tgt.setStatus(VersionConvertor_10_50.convertConformanceResourceStatus(src.getStatus()));
        if (src.hasExperimental())
            tgt.setExperimental(src.getExperimental());
        tgt.setPublisher(src.getPublisher());
        for (org.hl7.fhir.dstu2.model.ValueSet.ValueSetContactComponent t : src.getContact()) tgt.addContact(convertValueSetContactComponent(t));
        if (src.hasDate())
            tgt.setDate(src.getDate());
        tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getUseContext()) if (VersionConvertor_10_50.isJurisdiction(t))
            tgt.addJurisdiction(VersionConvertor_10_50.convertCodeableConcept(t));
        else
            tgt.addUseContext(VersionConvertor_10_50.convertCodeableConceptToUsageContext(t));
        tgt.setImmutable(src.getImmutable());
        tgt.setPurpose(src.getRequirements());
        tgt.setCopyright(src.getCopyright());
        if (src.hasExtensible())
            tgt.addExtension("http://hl7.org/fhir/StructureDefinition/valueset-extensible", new BooleanType(src.getExtensible()));
        if (src.hasCompose()) {
            tgt.setCompose(convertValueSetComposeComponent(src.getCompose()));
            tgt.getCompose().setLockedDate(src.getLockedDate());
        }
        if (src.hasCodeSystem() && advisor != null) {
            org.hl7.fhir.r5.model.CodeSystem tgtcs = new org.hl7.fhir.r5.model.CodeSystem();
            VersionConvertor_10_50.copyDomainResource(src, tgtcs);
            tgtcs.setUrl(src.getCodeSystem().getSystem());
            tgtcs.addIdentifier(VersionConvertor_10_50.convertIdentifier(src.getIdentifier()));
            tgtcs.setVersion(src.getCodeSystem().getVersion());
            tgtcs.setName(src.getName() + " Code System");
            tgtcs.setStatus(VersionConvertor_10_50.convertConformanceResourceStatus(src.getStatus()));
            if (src.hasExperimental())
                tgtcs.setExperimental(src.getExperimental());
            tgtcs.setPublisher(src.getPublisher());
            for (org.hl7.fhir.dstu2.model.ValueSet.ValueSetContactComponent t : src.getContact()) tgtcs.addContact(convertValueSetContactComponent(t));
            if (src.hasDate())
                tgtcs.setDate(src.getDate());
            tgtcs.setDescription(src.getDescription());
            for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getUseContext()) if (VersionConvertor_10_50.isJurisdiction(t))
                tgtcs.addJurisdiction(VersionConvertor_10_50.convertCodeableConcept(t));
            else
                tgtcs.addUseContext(VersionConvertor_10_50.convertCodeableConceptToUsageContext(t));
            tgtcs.setPurpose(src.getRequirements());
            tgtcs.setCopyright(src.getCopyright());
            tgtcs.setContent(CodeSystemContentMode.COMPLETE);
            tgtcs.setCaseSensitive(src.getCodeSystem().getCaseSensitive());
            for (org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionComponent cs : src.getCodeSystem().getConcept()) processConcept(tgtcs.getConcept(), cs, tgtcs);
            advisor.handleCodeSystem(tgtcs, tgt);
            tgt.setUserData("r2-cs", tgtcs);
            tgt.getCompose().addInclude().setSystem(tgtcs.getUrl());
        }
        tgt.setExpansion(convertValueSetExpansionComponent(src.getExpansion()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ValueSet convertValueSet(org.hl7.fhir.r5.model.ValueSet src) throws FHIRException {
        return convertValueSet(src, null);
    }

    public static org.hl7.fhir.r5.model.ValueSet.ValueSetComposeComponent convertValueSetComposeComponent(org.hl7.fhir.dstu2.model.ValueSet.ValueSetComposeComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ValueSet.ValueSetComposeComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ValueSetComposeComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        for (org.hl7.fhir.dstu2.model.UriType t : src.getImport()) tgt.addInclude().addValueSet(t.getValue());
        for (org.hl7.fhir.dstu2.model.ValueSet.ConceptSetComponent t : src.getInclude()) tgt.addInclude(convertConceptSetComponent(t));
        for (org.hl7.fhir.dstu2.model.ValueSet.ConceptSetComponent t : src.getExclude()) tgt.addExclude(convertConceptSetComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ValueSet.ValueSetComposeComponent convertValueSetComposeComponent(org.hl7.fhir.r5.model.ValueSet.ValueSetComposeComponent src, String noSystem) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ValueSet.ValueSetComposeComponent tgt = new org.hl7.fhir.dstu2.model.ValueSet.ValueSetComposeComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        for (org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent t : src.getInclude()) {
            for (org.hl7.fhir.r5.model.UriType ti : t.getValueSet()) tgt.addImport(ti.getValue());
            if (noSystem == null || !t.getSystem().equals(noSystem))
                tgt.addInclude(convertConceptSetComponent(t));
        }
        for (org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent t : src.getExclude()) tgt.addExclude(convertConceptSetComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ContactDetail convertValueSetContactComponent(org.hl7.fhir.dstu2.model.ValueSet.ValueSetContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ContactDetail tgt = new org.hl7.fhir.r5.model.ContactDetail();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setName(src.getName());
        for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_50.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ValueSet.ValueSetContactComponent convertValueSetContactComponent(org.hl7.fhir.r5.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ValueSet.ValueSetContactComponent tgt = new org.hl7.fhir.dstu2.model.ValueSet.ValueSetContactComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setName(src.getName());
        for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_50.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionComponent convertValueSetExpansionComponent(org.hl7.fhir.dstu2.model.ValueSet.ValueSetExpansionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setIdentifier(src.getIdentifier());
        tgt.setTimestamp(src.getTimestamp());
        tgt.setTotal(src.getTotal());
        tgt.setOffset(src.getOffset());
        for (org.hl7.fhir.dstu2.model.ValueSet.ValueSetExpansionParameterComponent t : src.getParameter()) tgt.addParameter(convertValueSetExpansionParameterComponent(t));
        for (org.hl7.fhir.dstu2.model.ValueSet.ValueSetExpansionContainsComponent t : src.getContains()) tgt.addContains(convertValueSetExpansionContainsComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ValueSet.ValueSetExpansionComponent convertValueSetExpansionComponent(org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ValueSet.ValueSetExpansionComponent tgt = new org.hl7.fhir.dstu2.model.ValueSet.ValueSetExpansionComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setIdentifier(src.getIdentifier());
        tgt.setTimestamp(src.getTimestamp());
        tgt.setTotal(src.getTotal());
        tgt.setOffset(src.getOffset());
        for (org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionParameterComponent t : src.getParameter()) tgt.addParameter(convertValueSetExpansionParameterComponent(t));
        for (org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent t : src.getContains()) tgt.addContains(convertValueSetExpansionContainsComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ValueSet.ValueSetExpansionContainsComponent convertValueSetExpansionContainsComponent(org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ValueSet.ValueSetExpansionContainsComponent tgt = new org.hl7.fhir.dstu2.model.ValueSet.ValueSetExpansionContainsComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setSystem(src.getSystem());
        tgt.setAbstract(src.getAbstract());
        tgt.setVersion(src.getVersion());
        tgt.setCode(src.getCode());
        tgt.setDisplay(src.getDisplay());
        for (org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent t : src.getContains()) tgt.addContains(convertValueSetExpansionContainsComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent convertValueSetExpansionContainsComponent(org.hl7.fhir.dstu2.model.ValueSet.ValueSetExpansionContainsComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setSystem(src.getSystem());
        tgt.setAbstract(src.getAbstract());
        tgt.setVersion(src.getVersion());
        tgt.setCode(src.getCode());
        tgt.setDisplay(src.getDisplay());
        for (org.hl7.fhir.dstu2.model.ValueSet.ValueSetExpansionContainsComponent t : src.getContains()) tgt.addContains(convertValueSetExpansionContainsComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ValueSet.ValueSetExpansionParameterComponent convertValueSetExpansionParameterComponent(org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionParameterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ValueSet.ValueSetExpansionParameterComponent tgt = new org.hl7.fhir.dstu2.model.ValueSet.ValueSetExpansionParameterComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setName(src.getName());
        tgt.setValue(VersionConvertor_10_50.convertType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionParameterComponent convertValueSetExpansionParameterComponent(org.hl7.fhir.dstu2.model.ValueSet.ValueSetExpansionParameterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionParameterComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionParameterComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setName(src.getName());
        tgt.setValue(VersionConvertor_10_50.convertType(src.getValue()));
        return tgt;
    }

    static public void processConcept(List<org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionComponent> concepts, ConceptDefinitionComponent cs, CodeSystem srcCS) throws FHIRException {
        org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionComponent ct = new org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionComponent();
        concepts.add(ct);
        ct.setCode(cs.getCode());
        ct.setDisplay(cs.getDisplay());
        ct.setDefinition(cs.getDefinition());
        if (CodeSystemUtilities.isNotSelectable(srcCS, cs))
            ct.setAbstract(true);
        for (org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionDesignationComponent csd : cs.getDesignation()) {
            org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionDesignationComponent cst = new org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionDesignationComponent();
            cst.setLanguage(csd.getLanguage());
            cst.setUse(VersionConvertor_10_50.convertCoding(csd.getUse()));
            cst.setValue(csd.getValue());
        }
        for (ConceptDefinitionComponent csc : cs.getConcept()) processConcept(ct.getConcept(), csc, srcCS);
    }

    static public void processConcept(List<ConceptDefinitionComponent> concepts, org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionComponent cs, CodeSystem tgtcs) throws FHIRException {
        org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent ct = new org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent();
        concepts.add(ct);
        ct.setCode(cs.getCode());
        ct.setDisplay(cs.getDisplay());
        ct.setDefinition(cs.getDefinition());
        if (cs.getAbstract())
            CodeSystemUtilities.setNotSelectable(tgtcs, ct);
        for (org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionDesignationComponent csd : cs.getDesignation()) {
            org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionDesignationComponent cst = new org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionDesignationComponent();
            cst.setLanguage(csd.getLanguage());
            cst.setUse(VersionConvertor_10_50.convertCoding(csd.getUse()));
            cst.setValue(csd.getValue());
        }
        for (org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionComponent csc : cs.getConcept()) processConcept(ct.getConcept(), csc, tgtcs);
    }
}
