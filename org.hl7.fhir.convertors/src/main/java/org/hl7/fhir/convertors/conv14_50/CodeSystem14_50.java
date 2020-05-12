package org.hl7.fhir.convertors.conv14_50;

import org.hl7.fhir.convertors.VersionConvertor_14_50;
import org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionPropertyComponent;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.Enumeration;
import org.hl7.fhir.r5.model.Enumerations;
import org.hl7.fhir.r5.model.Enumerations.FilterOperator;

public class CodeSystem14_50 {

    public static org.hl7.fhir.dstu2016may.model.CodeSystem convertCodeSystem(org.hl7.fhir.r5.model.CodeSystem src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.CodeSystem tgt = new org.hl7.fhir.dstu2016may.model.CodeSystem();
        VersionConvertor_14_50.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(VersionConvertor_14_50.convertUri(src.getUrlElement()));
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_14_50.convertIdentifier(src.getIdentifierFirstRep()));
        if (src.hasVersion())
            tgt.setVersionElement(VersionConvertor_14_50.convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_14_50.convertString(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatusElement(VersionConvertor_14_50.convertConformanceResourceStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(VersionConvertor_14_50.convertBoolean(src.getExperimentalElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(VersionConvertor_14_50.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact()) tgt.addContact(convertCodeSystemContactComponent(t));
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
        if (src.hasCaseSensitive())
            tgt.setCaseSensitiveElement(VersionConvertor_14_50.convertBoolean(src.getCaseSensitiveElement()));
        if (src.hasValueSet())
            tgt.setValueSet(src.getValueSet());
        if (src.hasCompositional())
            tgt.setCompositionalElement(VersionConvertor_14_50.convertBoolean(src.getCompositionalElement()));
        if (src.hasVersionNeeded())
            tgt.setVersionNeededElement(VersionConvertor_14_50.convertBoolean(src.getVersionNeededElement()));
        if (src.hasContent())
            tgt.setContentElement(convertCodeSystemContentMode(src.getContentElement()));
        if (src.hasCount())
            tgt.setCountElement(VersionConvertor_14_50.convertUnsignedInt(src.getCountElement()));
        for (org.hl7.fhir.r5.model.CodeSystem.CodeSystemFilterComponent t : src.getFilter()) tgt.addFilter(convertCodeSystemFilterComponent(t));
        for (org.hl7.fhir.r5.model.CodeSystem.PropertyComponent t : src.getProperty()) tgt.addProperty(convertPropertyComponent(t));
        for (org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent t : src.getConcept()) tgt.addConcept(convertConceptDefinitionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CodeSystem convertCodeSystem(org.hl7.fhir.dstu2016may.model.CodeSystem src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.CodeSystem tgt = new org.hl7.fhir.r5.model.CodeSystem();
        VersionConvertor_14_50.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(VersionConvertor_14_50.convertUri(src.getUrlElement()));
        if (src.hasIdentifier())
            tgt.addIdentifier(VersionConvertor_14_50.convertIdentifier(src.getIdentifier()));
        if (src.hasVersion())
            tgt.setVersionElement(VersionConvertor_14_50.convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_14_50.convertString(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatusElement(VersionConvertor_14_50.convertConformanceResourceStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(VersionConvertor_14_50.convertBoolean(src.getExperimentalElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(VersionConvertor_14_50.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemContactComponent t : src.getContact()) tgt.addContact(convertCodeSystemContactComponent(t));
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
        if (src.hasCaseSensitive())
            tgt.setCaseSensitiveElement(VersionConvertor_14_50.convertBoolean(src.getCaseSensitiveElement()));
        if (src.hasValueSet())
            tgt.setValueSet(src.getValueSet());
        if (src.hasCompositional())
            tgt.setCompositionalElement(VersionConvertor_14_50.convertBoolean(src.getCompositionalElement()));
        if (src.hasVersionNeeded())
            tgt.setVersionNeededElement(VersionConvertor_14_50.convertBoolean(src.getVersionNeededElement()));
        if (src.hasContent())
            tgt.setContentElement(convertCodeSystemContentMode(src.getContentElement()));
        if (src.hasCount())
            tgt.setCountElement(VersionConvertor_14_50.convertUnsignedInt(src.getCountElement()));
        for (org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemFilterComponent t : src.getFilter()) tgt.addFilter(convertCodeSystemFilterComponent(t));
        for (org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemPropertyComponent t : src.getProperty()) tgt.addProperty(convertPropertyComponent(t));
        for (org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionComponent t : src.getConcept()) tgt.addConcept(convertConceptDefinitionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemContactComponent convertCodeSystemContactComponent(org.hl7.fhir.r5.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemContactComponent tgt = new org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemContactComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_14_50.convertString(src.getNameElement()));
        for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_14_50.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ContactDetail convertCodeSystemContactComponent(org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ContactDetail tgt = new org.hl7.fhir.r5.model.ContactDetail();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_14_50.convertString(src.getNameElement()));
        for (org.hl7.fhir.dstu2016may.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_14_50.convertContactPoint(t));
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemContentMode> convertCodeSystemContentMode(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CodeSystem.CodeSystemContentMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemContentMode> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemContentModeEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case NOTPRESENT:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemContentMode.NOTPRESENT);
                break;
            case EXAMPLE:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemContentMode.EXAMPLAR);
                break;
            case FRAGMENT:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemContentMode.FRAGMENT);
                break;
            case COMPLETE:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemContentMode.COMPLETE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemContentMode.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CodeSystem.CodeSystemContentMode> convertCodeSystemContentMode(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemContentMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CodeSystem.CodeSystemContentMode> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.CodeSystem.CodeSystemContentModeEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case NOTPRESENT:
                tgt.setValue(org.hl7.fhir.r5.model.CodeSystem.CodeSystemContentMode.NOTPRESENT);
                break;
            case EXAMPLAR:
                tgt.setValue(org.hl7.fhir.r5.model.CodeSystem.CodeSystemContentMode.EXAMPLE);
                break;
            case FRAGMENT:
                tgt.setValue(org.hl7.fhir.r5.model.CodeSystem.CodeSystemContentMode.FRAGMENT);
                break;
            case COMPLETE:
                tgt.setValue(org.hl7.fhir.r5.model.CodeSystem.CodeSystemContentMode.COMPLETE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.CodeSystem.CodeSystemContentMode.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemFilterComponent convertCodeSystemFilterComponent(org.hl7.fhir.r5.model.CodeSystem.CodeSystemFilterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemFilterComponent tgt = new org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemFilterComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement(VersionConvertor_14_50.convertCode(src.getCodeElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_14_50.convertString(src.getDescriptionElement()));
        for (Enumeration<FilterOperator> t : src.getOperator()) tgt.addOperator(t.getValue().toCode());
        if (src.hasValueElement())
            tgt.setValueElement(VersionConvertor_14_50.convertString(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CodeSystem.CodeSystemFilterComponent convertCodeSystemFilterComponent(org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemFilterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.CodeSystem.CodeSystemFilterComponent tgt = new org.hl7.fhir.r5.model.CodeSystem.CodeSystemFilterComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement(VersionConvertor_14_50.convertCode(src.getCodeElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_14_50.convertString(src.getDescriptionElement()));
        for (org.hl7.fhir.dstu2016may.model.CodeType t : src.getOperator()) try {
            tgt.addOperator(Enumerations.FilterOperator.fromCode(t.getValue()));
        } catch (org.hl7.fhir.exceptions.FHIRException e) {
            throw new FHIRException(e);
        }
        if (src.hasValueElement())
            tgt.setValueElement(VersionConvertor_14_50.convertString(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent convertConceptDefinitionComponent(org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent tgt = new org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement(VersionConvertor_14_50.convertCode(src.getCodeElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(VersionConvertor_14_50.convertString(src.getDisplayElement()));
        if (src.hasDefinition())
            tgt.setDefinitionElement(VersionConvertor_14_50.convertString(src.getDefinitionElement()));
        for (org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionDesignationComponent t : src.getDesignation()) tgt.addDesignation(convertConceptDefinitionDesignationComponent(t));
        for (ConceptDefinitionPropertyComponent t : src.getProperty()) tgt.addProperty(convertConceptPropertyComponent(t));
        for (org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionComponent t : src.getConcept()) tgt.addConcept(convertConceptDefinitionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionComponent convertConceptDefinitionComponent(org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionComponent tgt = new org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement(VersionConvertor_14_50.convertCode(src.getCodeElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(VersionConvertor_14_50.convertString(src.getDisplayElement()));
        if (src.hasDefinition())
            tgt.setDefinitionElement(VersionConvertor_14_50.convertString(src.getDefinitionElement()));
        for (org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionDesignationComponent t : src.getDesignation()) tgt.addDesignation(convertConceptDefinitionDesignationComponent(t));
        for (org.hl7.fhir.r5.model.CodeSystem.ConceptPropertyComponent t : src.getProperty()) tgt.addProperty(convertConceptPropertyComponent(t));
        for (org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent t : src.getConcept()) tgt.addConcept(convertConceptDefinitionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionDesignationComponent convertConceptDefinitionDesignationComponent(org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionDesignationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionDesignationComponent tgt = new org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionDesignationComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasLanguage())
            tgt.setLanguageElement(VersionConvertor_14_50.convertCode(src.getLanguageElement()));
        if (src.hasUse())
            tgt.setUse(VersionConvertor_14_50.convertCoding(src.getUse()));
        if (src.hasValueElement())
            tgt.setValueElement(VersionConvertor_14_50.convertString(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionDesignationComponent convertConceptDefinitionDesignationComponent(org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionDesignationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionDesignationComponent tgt = new org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionDesignationComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasLanguage())
            tgt.setLanguageElement(VersionConvertor_14_50.convertCode(src.getLanguageElement()));
        if (src.hasUse())
            tgt.setUse(VersionConvertor_14_50.convertCoding(src.getUse()));
        if (src.hasValueElement())
            tgt.setValueElement(VersionConvertor_14_50.convertString(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionPropertyComponent convertConceptPropertyComponent(org.hl7.fhir.r5.model.CodeSystem.ConceptPropertyComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionPropertyComponent tgt = new org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionPropertyComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement(VersionConvertor_14_50.convertCode(src.getCodeElement()));
        if (src.hasValue())
            tgt.setValue(VersionConvertor_14_50.convertType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CodeSystem.ConceptPropertyComponent convertConceptPropertyComponent(org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionPropertyComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.CodeSystem.ConceptPropertyComponent tgt = new org.hl7.fhir.r5.model.CodeSystem.ConceptPropertyComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement(VersionConvertor_14_50.convertCode(src.getCodeElement()));
        if (src.hasValue())
            tgt.setValue(VersionConvertor_14_50.convertType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CodeSystem.PropertyComponent convertPropertyComponent(org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemPropertyComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.CodeSystem.PropertyComponent tgt = new org.hl7.fhir.r5.model.CodeSystem.PropertyComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement(VersionConvertor_14_50.convertCode(src.getCodeElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_14_50.convertString(src.getDescriptionElement()));
        if (src.hasType())
            tgt.setTypeElement(convertPropertyType(src.getTypeElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemPropertyComponent convertPropertyComponent(org.hl7.fhir.r5.model.CodeSystem.PropertyComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemPropertyComponent tgt = new org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemPropertyComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement(VersionConvertor_14_50.convertCode(src.getCodeElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_14_50.convertString(src.getDescriptionElement()));
        if (src.hasType())
            tgt.setTypeElement(convertPropertyType(src.getTypeElement()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CodeSystem.PropertyType> convertPropertyType(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.CodeSystem.PropertyType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CodeSystem.PropertyType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.CodeSystem.PropertyTypeEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case CODE:
                tgt.setValue(org.hl7.fhir.r5.model.CodeSystem.PropertyType.CODE);
                break;
            case CODING:
                tgt.setValue(org.hl7.fhir.r5.model.CodeSystem.PropertyType.CODING);
                break;
            case STRING:
                tgt.setValue(org.hl7.fhir.r5.model.CodeSystem.PropertyType.STRING);
                break;
            case INTEGER:
                tgt.setValue(org.hl7.fhir.r5.model.CodeSystem.PropertyType.INTEGER);
                break;
            case BOOLEAN:
                tgt.setValue(org.hl7.fhir.r5.model.CodeSystem.PropertyType.BOOLEAN);
                break;
            case DATETIME:
                tgt.setValue(org.hl7.fhir.r5.model.CodeSystem.PropertyType.DATETIME);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.CodeSystem.PropertyType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.CodeSystem.PropertyType> convertPropertyType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CodeSystem.PropertyType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.CodeSystem.PropertyType> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.CodeSystem.PropertyTypeEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case CODE:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.CodeSystem.PropertyType.CODE);
                break;
            case CODING:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.CodeSystem.PropertyType.CODING);
                break;
            case STRING:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.CodeSystem.PropertyType.STRING);
                break;
            case INTEGER:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.CodeSystem.PropertyType.INTEGER);
                break;
            case BOOLEAN:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.CodeSystem.PropertyType.BOOLEAN);
                break;
            case DATETIME:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.CodeSystem.PropertyType.DATETIME);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.CodeSystem.PropertyType.NULL);
                break;
        }
        return tgt;
    }
}