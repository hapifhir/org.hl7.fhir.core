package org.hl7.fhir.convertors.conv14_40;

import org.hl7.fhir.convertors.VersionConvertor_14_40;
import org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionPropertyComponent;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.CodeSystem;
import org.hl7.fhir.r4.model.CodeSystem.FilterOperator;
import org.hl7.fhir.r4.model.Enumeration;
import org.hl7.fhir.r4.model.StringType;

import java.util.Collections;

public class CodeSystem14_40 {

    public static org.hl7.fhir.r4.model.CodeSystem convertCodeSystem(org.hl7.fhir.dstu2016may.model.CodeSystem src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.CodeSystem tgt = new org.hl7.fhir.r4.model.CodeSystem();
        VersionConvertor_14_40.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.r4.model.UriType) VersionConvertor_14_40.convertType(src.getUrlElement()));
        if (src.hasIdentifier())
            tgt.addIdentifier(VersionConvertor_14_40.convertIdentifier(src.getIdentifier()));
        if (src.hasVersionElement())
            tgt.setVersionElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_14_40.convertType(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_14_40.convertType(src.getNameElement()));
        if (src.hasStatus()) {
            tgt.setStatus(VersionConvertor_14_40.convertConformanceResourceStatus(src.getStatus()));
        }
        if (src.hasExperimentalElement())
            tgt.setExperimentalElement((org.hl7.fhir.r4.model.BooleanType) VersionConvertor_14_40.convertType(src.getExperimentalElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_14_40.convertType(src.getPublisherElement()));
        if (src.hasContact()) {
            for (org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemContactComponent t : src.getContact()) tgt.addContact(convertCodeSystemContactComponent(t));
        }
        if (src.hasDateElement())
            tgt.setDateElement((org.hl7.fhir.r4.model.DateTimeType) VersionConvertor_14_40.convertType(src.getDateElement()));
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
        if (src.hasCaseSensitiveElement())
            tgt.setCaseSensitiveElement((org.hl7.fhir.r4.model.BooleanType) VersionConvertor_14_40.convertType(src.getCaseSensitiveElement()));
        if (src.hasValueSetElement())
            tgt.setValueSetElement((org.hl7.fhir.r4.model.CanonicalType) VersionConvertor_14_40.convertType(src.getValueSetElement()));
        if (src.hasCompositionalElement())
            tgt.setCompositionalElement((org.hl7.fhir.r4.model.BooleanType) VersionConvertor_14_40.convertType(src.getCompositionalElement()));
        if (src.hasVersionNeededElement())
            tgt.setVersionNeededElement((org.hl7.fhir.r4.model.BooleanType) VersionConvertor_14_40.convertType(src.getVersionNeededElement()));
        if (src.hasContent()) {
            tgt.setContent(convertCodeSystemContentMode(src.getContent()));
        }
        if (src.hasCountElement())
            tgt.setCountElement((org.hl7.fhir.r4.model.UnsignedIntType) VersionConvertor_14_40.convertType(src.getCountElement()));
        if (src.hasFilter()) {
            for (org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemFilterComponent t : src.getFilter()) tgt.addFilter(convertCodeSystemFilterComponent(t));
        }
        if (src.hasProperty()) {
            for (org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemPropertyComponent t : src.getProperty()) tgt.addProperty(convertPropertyComponent(t));
        }
        if (src.hasConcept()) {
            for (org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionComponent t : src.getConcept()) tgt.addConcept(convertConceptDefinitionComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.CodeSystem convertCodeSystem(org.hl7.fhir.r4.model.CodeSystem src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.CodeSystem tgt = new org.hl7.fhir.dstu2016may.model.CodeSystem();
        VersionConvertor_14_40.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.dstu2016may.model.UriType) VersionConvertor_14_40.convertType(src.getUrlElement()));
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_14_40.convertIdentifier(src.getIdentifierFirstRep()));
        if (src.hasVersionElement())
            tgt.setVersionElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_40.convertType(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_40.convertType(src.getNameElement()));
        if (src.hasStatus()) {
            tgt.setStatus(VersionConvertor_14_40.convertConformanceResourceStatus(src.getStatus()));
        }
        if (src.hasExperimentalElement())
            tgt.setExperimentalElement((org.hl7.fhir.dstu2016may.model.BooleanType) VersionConvertor_14_40.convertType(src.getExperimentalElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_40.convertType(src.getPublisherElement()));
        if (src.hasContact()) {
            for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact()) tgt.addContact(convertCodeSystemContactComponent(t));
        }
        if (src.hasDateElement())
            tgt.setDateElement((org.hl7.fhir.dstu2016may.model.DateTimeType) VersionConvertor_14_40.convertType(src.getDateElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_40.convertType(src.getDescriptionElement()));
        for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext()) if (t.hasValueCodeableConcept())
            tgt.addUseContext(VersionConvertor_14_40.convertCodeableConcept(t.getValueCodeableConcept()));
        if (src.hasJurisdiction()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction()) tgt.addUseContext(VersionConvertor_14_40.convertCodeableConcept(t));
        }
        if (src.hasPurpose())
            tgt.setRequirements(src.getPurpose());
        if (src.hasCopyrightElement())
            tgt.setCopyrightElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_40.convertType(src.getCopyrightElement()));
        if (src.hasCaseSensitiveElement())
            tgt.setCaseSensitiveElement((org.hl7.fhir.dstu2016may.model.BooleanType) VersionConvertor_14_40.convertType(src.getCaseSensitiveElement()));
        if (src.hasValueSetElement())
            tgt.setValueSetElement((org.hl7.fhir.dstu2016may.model.UriType) VersionConvertor_14_40.convertType(src.getValueSetElement()));
        if (src.hasCompositionalElement())
            tgt.setCompositionalElement((org.hl7.fhir.dstu2016may.model.BooleanType) VersionConvertor_14_40.convertType(src.getCompositionalElement()));
        if (src.hasVersionNeededElement())
            tgt.setVersionNeededElement((org.hl7.fhir.dstu2016may.model.BooleanType) VersionConvertor_14_40.convertType(src.getVersionNeededElement()));
        if (src.hasContent()) {
            tgt.setContent(convertCodeSystemContentMode(src.getContent()));
        }
        if (src.hasCountElement())
            tgt.setCountElement((org.hl7.fhir.dstu2016may.model.UnsignedIntType) VersionConvertor_14_40.convertType(src.getCountElement()));
        if (src.hasFilter()) {
            for (org.hl7.fhir.r4.model.CodeSystem.CodeSystemFilterComponent t : src.getFilter()) tgt.addFilter(convertCodeSystemFilterComponent(t));
        }
        if (src.hasProperty()) {
            for (org.hl7.fhir.r4.model.CodeSystem.PropertyComponent t : src.getProperty()) tgt.addProperty(convertPropertyComponent(t));
        }
        if (src.hasConcept()) {
            for (org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionComponent t : src.getConcept()) tgt.addConcept(convertConceptDefinitionComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ContactDetail convertCodeSystemContactComponent(org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ContactDetail tgt = new org.hl7.fhir.r4.model.ContactDetail();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_14_40.convertType(src.getNameElement()));
        if (src.hasTelecom()) {
            for (org.hl7.fhir.dstu2016may.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_14_40.convertContactPoint(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemContactComponent convertCodeSystemContactComponent(org.hl7.fhir.r4.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemContactComponent tgt = new org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemContactComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_40.convertType(src.getNameElement()));
        if (src.hasTelecom()) {
            for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_14_40.convertContactPoint(t));
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemContentMode convertCodeSystemContentMode(org.hl7.fhir.r4.model.CodeSystem.CodeSystemContentMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case NOTPRESENT:
                return org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemContentMode.NOTPRESENT;
            case EXAMPLE:
                return org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemContentMode.EXAMPLAR;
            case FRAGMENT:
                return org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemContentMode.FRAGMENT;
            case COMPLETE:
                return org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemContentMode.COMPLETE;
            default:
                return org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemContentMode.NULL;
        }
    }

    static public org.hl7.fhir.r4.model.CodeSystem.CodeSystemContentMode convertCodeSystemContentMode(org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemContentMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case NOTPRESENT:
                return org.hl7.fhir.r4.model.CodeSystem.CodeSystemContentMode.NOTPRESENT;
            case EXAMPLAR:
                return org.hl7.fhir.r4.model.CodeSystem.CodeSystemContentMode.EXAMPLE;
            case FRAGMENT:
                return org.hl7.fhir.r4.model.CodeSystem.CodeSystemContentMode.FRAGMENT;
            case COMPLETE:
                return org.hl7.fhir.r4.model.CodeSystem.CodeSystemContentMode.COMPLETE;
            default:
                return org.hl7.fhir.r4.model.CodeSystem.CodeSystemContentMode.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.CodeSystem.CodeSystemFilterComponent convertCodeSystemFilterComponent(org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemFilterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.CodeSystem.CodeSystemFilterComponent tgt = new org.hl7.fhir.r4.model.CodeSystem.CodeSystemFilterComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement((org.hl7.fhir.r4.model.CodeType) VersionConvertor_14_40.convertType(src.getCodeElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_14_40.convertType(src.getDescriptionElement()));
        for (org.hl7.fhir.dstu2016may.model.CodeType t : src.getOperator()) try {
            tgt.addOperator(CodeSystem.FilterOperator.fromCode(t.getValue()));
        } catch (org.hl7.fhir.exceptions.FHIRException e) {
            throw new FHIRException(e);
        }
        if (src.hasValueElement()) {
            tgt.setValueElement((StringType) VersionConvertor_14_40.convertType(src.getValueElement()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemFilterComponent convertCodeSystemFilterComponent(org.hl7.fhir.r4.model.CodeSystem.CodeSystemFilterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemFilterComponent tgt = new org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemFilterComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement((org.hl7.fhir.dstu2016may.model.CodeType) VersionConvertor_14_40.convertType(src.getCodeElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_40.convertType(src.getDescriptionElement()));
        if (src.hasValueElement())
            tgt.setValueElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_40.convertType(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionComponent convertConceptDefinitionComponent(org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionComponent tgt = new org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement((org.hl7.fhir.r4.model.CodeType) VersionConvertor_14_40.convertType(src.getCodeElement()));
        if (src.hasDisplayElement())
            tgt.setDisplayElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_14_40.convertType(src.getDisplayElement()));
        if (src.hasDefinitionElement())
            tgt.setDefinitionElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_14_40.convertType(src.getDefinitionElement()));
        if (src.hasDesignation()) {
            for (org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionDesignationComponent t : src.getDesignation()) tgt.addDesignation(convertConceptDefinitionDesignationComponent(t));
        }
        if (src.hasProperty()) {
            for (ConceptDefinitionPropertyComponent t : src.getProperty()) tgt.addProperty(convertConceptPropertyComponent(t));
        }
        if (src.hasConcept()) {
            for (org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionComponent t : src.getConcept()) tgt.addConcept(convertConceptDefinitionComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionComponent convertConceptDefinitionComponent(org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionComponent tgt = new org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement((org.hl7.fhir.dstu2016may.model.CodeType) VersionConvertor_14_40.convertType(src.getCodeElement()));
        if (src.hasDisplayElement())
            tgt.setDisplayElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_40.convertType(src.getDisplayElement()));
        if (src.hasDefinitionElement())
            tgt.setDefinitionElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_40.convertType(src.getDefinitionElement()));
        if (src.hasDesignation()) {
            for (org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionDesignationComponent t : src.getDesignation()) tgt.addDesignation(convertConceptDefinitionDesignationComponent(t));
        }
        if (src.hasProperty()) {
            for (org.hl7.fhir.r4.model.CodeSystem.ConceptPropertyComponent t : src.getProperty()) tgt.addProperty(convertConceptPropertyComponent(t));
        }
        if (src.hasConcept()) {
            for (org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionComponent t : src.getConcept()) tgt.addConcept(convertConceptDefinitionComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionDesignationComponent convertConceptDefinitionDesignationComponent(org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionDesignationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionDesignationComponent tgt = new org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionDesignationComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasLanguageElement())
            tgt.setLanguageElement((org.hl7.fhir.r4.model.CodeType) VersionConvertor_14_40.convertType(src.getLanguageElement()));
        if (src.hasUse()) {
            tgt.setUse(VersionConvertor_14_40.convertCoding(src.getUse()));
        }
        if (src.hasValueElement())
            tgt.setValueElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_14_40.convertType(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionDesignationComponent convertConceptDefinitionDesignationComponent(org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionDesignationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionDesignationComponent tgt = new org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionDesignationComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasLanguageElement())
            tgt.setLanguageElement((org.hl7.fhir.dstu2016may.model.CodeType) VersionConvertor_14_40.convertType(src.getLanguageElement()));
        if (src.hasUse()) {
            tgt.setUse(VersionConvertor_14_40.convertCoding(src.getUse()));
        }
        if (src.hasValueElement())
            tgt.setValueElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_40.convertType(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionPropertyComponent convertConceptPropertyComponent(org.hl7.fhir.r4.model.CodeSystem.ConceptPropertyComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionPropertyComponent tgt = new org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionPropertyComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement((org.hl7.fhir.dstu2016may.model.CodeType) VersionConvertor_14_40.convertType(src.getCodeElement()));
        if (src.hasValue()) {
            tgt.setValue(VersionConvertor_14_40.convertType(src.getValue()));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.CodeSystem.ConceptPropertyComponent convertConceptPropertyComponent(org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionPropertyComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.CodeSystem.ConceptPropertyComponent tgt = new org.hl7.fhir.r4.model.CodeSystem.ConceptPropertyComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement((org.hl7.fhir.r4.model.CodeType) VersionConvertor_14_40.convertType(src.getCodeElement()));
        if (src.hasValue()) {
            tgt.setValue(VersionConvertor_14_40.convertType(src.getValue()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemPropertyComponent convertPropertyComponent(org.hl7.fhir.r4.model.CodeSystem.PropertyComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemPropertyComponent tgt = new org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemPropertyComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement((org.hl7.fhir.dstu2016may.model.CodeType) VersionConvertor_14_40.convertType(src.getCodeElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_40.convertType(src.getDescriptionElement()));
        if (src.hasType()) {
            tgt.setType(convertPropertyType(src.getType()));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.CodeSystem.PropertyComponent convertPropertyComponent(org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemPropertyComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.CodeSystem.PropertyComponent tgt = new org.hl7.fhir.r4.model.CodeSystem.PropertyComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement((org.hl7.fhir.r4.model.CodeType) VersionConvertor_14_40.convertType(src.getCodeElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_14_40.convertType(src.getDescriptionElement()));
        if (src.hasType()) {
            tgt.setType(convertPropertyType(src.getType()));
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.CodeSystem.PropertyType convertPropertyType(org.hl7.fhir.dstu2016may.model.CodeSystem.PropertyType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case CODE:
                return org.hl7.fhir.r4.model.CodeSystem.PropertyType.CODE;
            case CODING:
                return org.hl7.fhir.r4.model.CodeSystem.PropertyType.CODING;
            case STRING:
                return org.hl7.fhir.r4.model.CodeSystem.PropertyType.STRING;
            case INTEGER:
                return org.hl7.fhir.r4.model.CodeSystem.PropertyType.INTEGER;
            case BOOLEAN:
                return org.hl7.fhir.r4.model.CodeSystem.PropertyType.BOOLEAN;
            case DATETIME:
                return org.hl7.fhir.r4.model.CodeSystem.PropertyType.DATETIME;
            default:
                return org.hl7.fhir.r4.model.CodeSystem.PropertyType.NULL;
        }
    }

    static public org.hl7.fhir.dstu2016may.model.CodeSystem.PropertyType convertPropertyType(org.hl7.fhir.r4.model.CodeSystem.PropertyType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case CODE:
                return org.hl7.fhir.dstu2016may.model.CodeSystem.PropertyType.CODE;
            case CODING:
                return org.hl7.fhir.dstu2016may.model.CodeSystem.PropertyType.CODING;
            case STRING:
                return org.hl7.fhir.dstu2016may.model.CodeSystem.PropertyType.STRING;
            case INTEGER:
                return org.hl7.fhir.dstu2016may.model.CodeSystem.PropertyType.INTEGER;
            case BOOLEAN:
                return org.hl7.fhir.dstu2016may.model.CodeSystem.PropertyType.BOOLEAN;
            case DATETIME:
                return org.hl7.fhir.dstu2016may.model.CodeSystem.PropertyType.DATETIME;
            default:
                return org.hl7.fhir.dstu2016may.model.CodeSystem.PropertyType.NULL;
        }
    }
}
