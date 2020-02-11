package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.StringType;

import java.util.Collections;

public class CodeSystem30_50 {

    public static org.hl7.fhir.dstu3.model.CodeSystem convertCodeSystem(org.hl7.fhir.r5.model.CodeSystem src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.CodeSystem tgt = new org.hl7.fhir.dstu3.model.CodeSystem();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.dstu3.model.UriType) VersionConvertor_30_50.convertType(src.getUrlElement()));
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_30_50.convertIdentifier(src.getIdentifierFirstRep()));
        if (src.hasVersionElement())
            tgt.setVersionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getNameElement()));
        if (src.hasTitleElement())
            tgt.setTitleElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getTitleElement()));
        if (src.hasStatus())
            tgt.setStatus(VersionConvertor_30_50.convertPublicationStatus(src.getStatus()));
        if (src.hasExperimentalElement())
            tgt.setExperimentalElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_30_50.convertType(src.getExperimentalElement()));
        if (src.hasDateElement())
            tgt.setDateElement((org.hl7.fhir.dstu3.model.DateTimeType) VersionConvertor_30_50.convertType(src.getDateElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getPublisherElement()));
        if (src.hasContact()) {
            for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact()) tgt.addContact(VersionConvertor_30_50.convertContactDetail(t));
        }
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu3.model.MarkdownType) VersionConvertor_30_50.convertType(src.getDescriptionElement()));
        if (src.hasUseContext()) {
            for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_50.convertUsageContext(t));
        }
        if (src.hasJurisdiction()) {
            for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_50.convertCodeableConcept(t));
        }
        if (src.hasPurposeElement())
            tgt.setPurposeElement((org.hl7.fhir.dstu3.model.MarkdownType) VersionConvertor_30_50.convertType(src.getPurposeElement()));
        if (src.hasCopyrightElement())
            tgt.setCopyrightElement((org.hl7.fhir.dstu3.model.MarkdownType) VersionConvertor_30_50.convertType(src.getCopyrightElement()));
        if (src.hasCaseSensitiveElement())
            tgt.setCaseSensitiveElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_30_50.convertType(src.getCaseSensitiveElement()));
        if (src.hasValueSet())
            tgt.setValueSet(src.getValueSet());
        if (src.hasHierarchyMeaning())
            tgt.setHierarchyMeaning(convertCodeSystemHierarchyMeaning(src.getHierarchyMeaning()));
        if (src.hasCompositionalElement())
            tgt.setCompositionalElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_30_50.convertType(src.getCompositionalElement()));
        if (src.hasVersionNeededElement())
            tgt.setVersionNeededElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_30_50.convertType(src.getVersionNeededElement()));
        if (src.hasContent())
            tgt.setContent(convertCodeSystemContentMode(src.getContent()));
        if (src.hasCount())
            tgt.setCount(src.getCount());
        if (src.hasFilter()) {
            for (org.hl7.fhir.r5.model.CodeSystem.CodeSystemFilterComponent t : src.getFilter()) tgt.addFilter(convertCodeSystemFilterComponent(t));
        }
        if (src.hasProperty()) {
            for (org.hl7.fhir.r5.model.CodeSystem.PropertyComponent t : src.getProperty()) tgt.addProperty(convertPropertyComponent(t));
        }
        if (src.hasConcept()) {
            for (org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent t : src.getConcept()) tgt.addConcept(convertConceptDefinitionComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CodeSystem convertCodeSystem(org.hl7.fhir.dstu3.model.CodeSystem src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.CodeSystem tgt = new org.hl7.fhir.r5.model.CodeSystem();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.r5.model.UriType) VersionConvertor_30_50.convertType(src.getUrlElement()));
        if (src.hasIdentifier())
            tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(src.getIdentifier()));
        if (src.hasVersionElement())
            tgt.setVersionElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_30_50.convertType(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_30_50.convertType(src.getNameElement()));
        if (src.hasTitleElement())
            tgt.setTitleElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_30_50.convertType(src.getTitleElement()));
        if (src.hasStatus())
            tgt.setStatus(VersionConvertor_30_50.convertPublicationStatus(src.getStatus()));
        if (src.hasExperimentalElement())
            tgt.setExperimentalElement((org.hl7.fhir.r5.model.BooleanType) VersionConvertor_30_50.convertType(src.getExperimentalElement()));
        if (src.hasDateElement())
            tgt.setDateElement((org.hl7.fhir.r5.model.DateTimeType) VersionConvertor_30_50.convertType(src.getDateElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_30_50.convertType(src.getPublisherElement()));
        if (src.hasContact()) {
            for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(VersionConvertor_30_50.convertContactDetail(t));
        }
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.r5.model.MarkdownType) VersionConvertor_30_50.convertType(src.getDescriptionElement()));
        if (src.hasUseContext()) {
            for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_50.convertUsageContext(t));
        }
        if (src.hasJurisdiction()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_50.convertCodeableConcept(t));
        }
        if (src.hasPurposeElement())
            tgt.setPurposeElement((org.hl7.fhir.r5.model.MarkdownType) VersionConvertor_30_50.convertType(src.getPurposeElement()));
        if (src.hasCopyrightElement())
            tgt.setCopyrightElement((org.hl7.fhir.r5.model.MarkdownType) VersionConvertor_30_50.convertType(src.getCopyrightElement()));
        if (src.hasCaseSensitiveElement())
            tgt.setCaseSensitiveElement((org.hl7.fhir.r5.model.BooleanType) VersionConvertor_30_50.convertType(src.getCaseSensitiveElement()));
        if (src.hasValueSet())
            tgt.setValueSet(src.getValueSet());
        if (src.hasHierarchyMeaning())
            tgt.setHierarchyMeaning(convertCodeSystemHierarchyMeaning(src.getHierarchyMeaning()));
        if (src.hasCompositionalElement())
            tgt.setCompositionalElement((org.hl7.fhir.r5.model.BooleanType) VersionConvertor_30_50.convertType(src.getCompositionalElement()));
        if (src.hasVersionNeededElement())
            tgt.setVersionNeededElement((org.hl7.fhir.r5.model.BooleanType) VersionConvertor_30_50.convertType(src.getVersionNeededElement()));
        if (src.hasContent())
            tgt.setContent(convertCodeSystemContentMode(src.getContent()));
        if (src.hasCount())
            tgt.setCount(src.getCount());
        if (src.hasFilter()) {
            for (org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemFilterComponent t : src.getFilter()) tgt.addFilter(convertCodeSystemFilterComponent(t));
        }
        if (src.hasProperty()) {
            for (org.hl7.fhir.dstu3.model.CodeSystem.PropertyComponent t : src.getProperty()) tgt.addProperty(convertPropertyComponent(t));
        }
        if (src.hasConcept()) {
            for (org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionComponent t : src.getConcept()) tgt.addConcept(convertConceptDefinitionComponent(t));
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.CodeSystem.CodeSystemContentMode convertCodeSystemContentMode(org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemContentMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case NOTPRESENT:
                return org.hl7.fhir.r5.model.CodeSystem.CodeSystemContentMode.NOTPRESENT;
            case EXAMPLE:
                return org.hl7.fhir.r5.model.CodeSystem.CodeSystemContentMode.EXAMPLE;
            case FRAGMENT:
                return org.hl7.fhir.r5.model.CodeSystem.CodeSystemContentMode.FRAGMENT;
            case COMPLETE:
                return org.hl7.fhir.r5.model.CodeSystem.CodeSystemContentMode.COMPLETE;
            default:
                return org.hl7.fhir.r5.model.CodeSystem.CodeSystemContentMode.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemContentMode convertCodeSystemContentMode(org.hl7.fhir.r5.model.CodeSystem.CodeSystemContentMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case NOTPRESENT:
                return org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemContentMode.NOTPRESENT;
            case EXAMPLE:
                return org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemContentMode.EXAMPLE;
            case FRAGMENT:
                return org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemContentMode.FRAGMENT;
            case COMPLETE:
                return org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemContentMode.COMPLETE;
            default:
                return org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemContentMode.NULL;
        }
    }

    public static org.hl7.fhir.r5.model.CodeSystem.CodeSystemFilterComponent convertCodeSystemFilterComponent(org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemFilterComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.CodeSystem.CodeSystemFilterComponent tgt = new org.hl7.fhir.r5.model.CodeSystem.CodeSystemFilterComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement((org.hl7.fhir.r5.model.CodeType) VersionConvertor_30_50.convertType(src.getCodeElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_30_50.convertType(src.getDescriptionElement()));
        if (src.hasValueElement())
            tgt.setValueElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_30_50.convertType(src.getValueElement()));
        if (src.hasValueElement())
            tgt.setValueElement((StringType) VersionConvertor_30_50.convertType(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemFilterComponent convertCodeSystemFilterComponent(org.hl7.fhir.r5.model.CodeSystem.CodeSystemFilterComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemFilterComponent tgt = new org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemFilterComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement((org.hl7.fhir.dstu3.model.CodeType) VersionConvertor_30_50.convertType(src.getCodeElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getDescriptionElement()));
        if (src.hasValueElement())
            tgt.setValueElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getValueElement()));
        if (src.hasValueElement())
            tgt.setValueElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getValueElement()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemHierarchyMeaning convertCodeSystemHierarchyMeaning(org.hl7.fhir.r5.model.CodeSystem.CodeSystemHierarchyMeaning src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case GROUPEDBY:
                return org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemHierarchyMeaning.GROUPEDBY;
            case ISA:
                return org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemHierarchyMeaning.ISA;
            case PARTOF:
                return org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemHierarchyMeaning.PARTOF;
            case CLASSIFIEDWITH:
                return org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemHierarchyMeaning.CLASSIFIEDWITH;
            default:
                return org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemHierarchyMeaning.NULL;
        }
    }

    static public org.hl7.fhir.r5.model.CodeSystem.CodeSystemHierarchyMeaning convertCodeSystemHierarchyMeaning(org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemHierarchyMeaning src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case GROUPEDBY:
                return org.hl7.fhir.r5.model.CodeSystem.CodeSystemHierarchyMeaning.GROUPEDBY;
            case ISA:
                return org.hl7.fhir.r5.model.CodeSystem.CodeSystemHierarchyMeaning.ISA;
            case PARTOF:
                return org.hl7.fhir.r5.model.CodeSystem.CodeSystemHierarchyMeaning.PARTOF;
            case CLASSIFIEDWITH:
                return org.hl7.fhir.r5.model.CodeSystem.CodeSystemHierarchyMeaning.CLASSIFIEDWITH;
            default:
                return org.hl7.fhir.r5.model.CodeSystem.CodeSystemHierarchyMeaning.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionComponent convertConceptDefinitionComponent(org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionComponent tgt = new org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement((org.hl7.fhir.dstu3.model.CodeType) VersionConvertor_30_50.convertType(src.getCodeElement()));
        if (src.hasDisplayElement())
            tgt.setDisplayElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getDisplayElement()));
        if (src.hasDefinitionElement())
            tgt.setDefinitionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getDefinitionElement()));
        if (src.hasDesignation()) {
            for (org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionDesignationComponent t : src.getDesignation()) tgt.addDesignation(convertConceptDefinitionDesignationComponent(t));
        }
        if (src.hasProperty()) {
            for (org.hl7.fhir.r5.model.CodeSystem.ConceptPropertyComponent t : src.getProperty()) tgt.addProperty(convertConceptPropertyComponent(t));
        }
        if (src.hasConcept()) {
            for (org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent t : src.getConcept()) tgt.addConcept(convertConceptDefinitionComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent convertConceptDefinitionComponent(org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent tgt = new org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement((org.hl7.fhir.r5.model.CodeType) VersionConvertor_30_50.convertType(src.getCodeElement()));
        if (src.hasDisplayElement())
            tgt.setDisplayElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_30_50.convertType(src.getDisplayElement()));
        if (src.hasDefinitionElement())
            tgt.setDefinitionElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_30_50.convertType(src.getDefinitionElement()));
        if (src.hasDesignation()) {
            for (org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionDesignationComponent t : src.getDesignation()) tgt.addDesignation(convertConceptDefinitionDesignationComponent(t));
        }
        if (src.hasProperty()) {
            for (org.hl7.fhir.dstu3.model.CodeSystem.ConceptPropertyComponent t : src.getProperty()) tgt.addProperty(convertConceptPropertyComponent(t));
        }
        if (src.hasConcept()) {
            for (org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionComponent t : src.getConcept()) tgt.addConcept(convertConceptDefinitionComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionDesignationComponent convertConceptDefinitionDesignationComponent(org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionDesignationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionDesignationComponent tgt = new org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionDesignationComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasLanguageElement())
            tgt.setLanguageElement((org.hl7.fhir.dstu3.model.CodeType) VersionConvertor_30_50.convertType(src.getLanguageElement()));
        if (src.hasUse())
            tgt.setUse(VersionConvertor_30_50.convertCoding(src.getUse()));
        if (src.hasValueElement())
            tgt.setValueElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionDesignationComponent convertConceptDefinitionDesignationComponent(org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionDesignationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionDesignationComponent tgt = new org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionDesignationComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasLanguageElement())
            tgt.setLanguageElement((org.hl7.fhir.r5.model.CodeType) VersionConvertor_30_50.convertType(src.getLanguageElement()));
        if (src.hasUse())
            tgt.setUse(VersionConvertor_30_50.convertCoding(src.getUse()));
        if (src.hasValueElement())
            tgt.setValueElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_30_50.convertType(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CodeSystem.ConceptPropertyComponent convertConceptPropertyComponent(org.hl7.fhir.dstu3.model.CodeSystem.ConceptPropertyComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.CodeSystem.ConceptPropertyComponent tgt = new org.hl7.fhir.r5.model.CodeSystem.ConceptPropertyComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement((org.hl7.fhir.r5.model.CodeType) VersionConvertor_30_50.convertType(src.getCodeElement()));
        if (src.hasValue())
            tgt.setValue(VersionConvertor_30_50.convertType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CodeSystem.ConceptPropertyComponent convertConceptPropertyComponent(org.hl7.fhir.r5.model.CodeSystem.ConceptPropertyComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.CodeSystem.ConceptPropertyComponent tgt = new org.hl7.fhir.dstu3.model.CodeSystem.ConceptPropertyComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement((org.hl7.fhir.dstu3.model.CodeType) VersionConvertor_30_50.convertType(src.getCodeElement()));
        if (src.hasValue())
            tgt.setValue(VersionConvertor_30_50.convertType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CodeSystem.PropertyComponent convertPropertyComponent(org.hl7.fhir.dstu3.model.CodeSystem.PropertyComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.CodeSystem.PropertyComponent tgt = new org.hl7.fhir.r5.model.CodeSystem.PropertyComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement((org.hl7.fhir.r5.model.CodeType) VersionConvertor_30_50.convertType(src.getCodeElement()));
        if (src.hasUriElement())
            tgt.setUriElement((org.hl7.fhir.r5.model.UriType) VersionConvertor_30_50.convertType(src.getUriElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_30_50.convertType(src.getDescriptionElement()));
        if (src.hasType())
            tgt.setType(convertPropertyType(src.getType()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CodeSystem.PropertyComponent convertPropertyComponent(org.hl7.fhir.r5.model.CodeSystem.PropertyComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.CodeSystem.PropertyComponent tgt = new org.hl7.fhir.dstu3.model.CodeSystem.PropertyComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement((org.hl7.fhir.dstu3.model.CodeType) VersionConvertor_30_50.convertType(src.getCodeElement()));
        if (src.hasUriElement())
            tgt.setUriElement((org.hl7.fhir.dstu3.model.UriType) VersionConvertor_30_50.convertType(src.getUriElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getDescriptionElement()));
        if (src.hasType())
            tgt.setType(convertPropertyType(src.getType()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.CodeSystem.PropertyType convertPropertyType(org.hl7.fhir.r5.model.CodeSystem.PropertyType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case CODE:
                return org.hl7.fhir.dstu3.model.CodeSystem.PropertyType.CODE;
            case CODING:
                return org.hl7.fhir.dstu3.model.CodeSystem.PropertyType.CODING;
            case STRING:
                return org.hl7.fhir.dstu3.model.CodeSystem.PropertyType.STRING;
            case INTEGER:
                return org.hl7.fhir.dstu3.model.CodeSystem.PropertyType.INTEGER;
            case BOOLEAN:
                return org.hl7.fhir.dstu3.model.CodeSystem.PropertyType.BOOLEAN;
            case DATETIME:
                return org.hl7.fhir.dstu3.model.CodeSystem.PropertyType.DATETIME;
            default:
                return org.hl7.fhir.dstu3.model.CodeSystem.PropertyType.NULL;
        }
    }

    static public org.hl7.fhir.r5.model.CodeSystem.PropertyType convertPropertyType(org.hl7.fhir.dstu3.model.CodeSystem.PropertyType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case CODE:
                return org.hl7.fhir.r5.model.CodeSystem.PropertyType.CODE;
            case CODING:
                return org.hl7.fhir.r5.model.CodeSystem.PropertyType.CODING;
            case STRING:
                return org.hl7.fhir.r5.model.CodeSystem.PropertyType.STRING;
            case INTEGER:
                return org.hl7.fhir.r5.model.CodeSystem.PropertyType.INTEGER;
            case BOOLEAN:
                return org.hl7.fhir.r5.model.CodeSystem.PropertyType.BOOLEAN;
            case DATETIME:
                return org.hl7.fhir.r5.model.CodeSystem.PropertyType.DATETIME;
            default:
                return org.hl7.fhir.r5.model.CodeSystem.PropertyType.NULL;
        }
    }
}
