package org.hl7.fhir.convertors.conv14_30.resources14_30;

import org.hl7.fhir.convertors.conv14_30.VersionConvertor_14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.Element14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.Type14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.complextypes14_30.CodeableConcept14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.complextypes14_30.ContactPoint14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.complextypes14_30.Identifier14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30.*;
import org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionPropertyComponent;
import org.hl7.fhir.dstu3.model.CodeSystem;
import org.hl7.fhir.dstu3.model.CodeSystem.FilterOperator;
import org.hl7.fhir.dstu3.model.Enumeration;
import org.hl7.fhir.exceptions.FHIRException;

public class CodeSystem14_30 {

    public static org.hl7.fhir.dstu3.model.CodeSystem convertCodeSystem(org.hl7.fhir.dstu2016may.model.CodeSystem src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.CodeSystem tgt = new org.hl7.fhir.dstu3.model.CodeSystem();
        VersionConvertor_14_30.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(Uri14_30.convertUri(src.getUrlElement()));
        if (src.hasIdentifier())
            tgt.setIdentifier(Identifier14_30.convertIdentifier(src.getIdentifier()));
        if (src.hasVersion())
            tgt.setVersionElement(String14_30.convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(String14_30.convertString(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatusElement(Enumerations14_30.convertConformanceResourceStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(Boolean14_30.convertBoolean(src.getExperimentalElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(String14_30.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemContactComponent t : src.getContact()) tgt.addContact(convertCodeSystemContactComponent(t));
        if (src.hasDate())
            tgt.setDateElement(DateTime14_30.convertDateTime(src.getDateElement()));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu2016may.model.CodeableConcept t : src.getUseContext()) if (VersionConvertor_14_30.isJurisdiction(t))
            tgt.addJurisdiction(CodeableConcept14_30.convertCodeableConcept(t));
        else
            tgt.addUseContext(CodeableConcept14_30.convertCodeableConceptToUsageContext(t));
        if (src.hasRequirements())
            tgt.setPurpose(src.getRequirements());
        if (src.hasCopyright())
            tgt.setCopyright(src.getCopyright());
        if (src.hasCaseSensitive())
            tgt.setCaseSensitiveElement(Boolean14_30.convertBoolean(src.getCaseSensitiveElement()));
        if (src.hasValueSet())
            tgt.setValueSetElement(Uri14_30.convertUri(src.getValueSetElement()));
        if (src.hasCompositional())
            tgt.setCompositionalElement(Boolean14_30.convertBoolean(src.getCompositionalElement()));
        if (src.hasVersionNeeded())
            tgt.setVersionNeededElement(Boolean14_30.convertBoolean(src.getVersionNeededElement()));
        if (src.hasContent())
            tgt.setContentElement(convertCodeSystemContentMode(src.getContentElement()));
        if (src.hasCount())
            tgt.setCountElement(UnsignedInt14_30.convertUnsignedInt(src.getCountElement()));
        for (org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemFilterComponent t : src.getFilter()) tgt.addFilter(convertCodeSystemFilterComponent(t));
        for (org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemPropertyComponent t : src.getProperty()) tgt.addProperty(convertPropertyComponent(t));
        for (org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionComponent t : src.getConcept()) tgt.addConcept(convertConceptDefinitionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.CodeSystem convertCodeSystem(org.hl7.fhir.dstu3.model.CodeSystem src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.CodeSystem tgt = new org.hl7.fhir.dstu2016may.model.CodeSystem();
        VersionConvertor_14_30.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(Uri14_30.convertUri(src.getUrlElement()));
        if (src.hasIdentifier())
            tgt.setIdentifier(Identifier14_30.convertIdentifier(src.getIdentifier()));
        if (src.hasVersion())
            tgt.setVersionElement(String14_30.convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(String14_30.convertString(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatusElement(Enumerations14_30.convertConformanceResourceStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(Boolean14_30.convertBoolean(src.getExperimentalElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(String14_30.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(convertCodeSystemContactComponent(t));
        if (src.hasDate())
            tgt.setDateElement(DateTime14_30.convertDateTime(src.getDateElement()));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext()) if (t.hasValueCodeableConcept())
            tgt.addUseContext(CodeableConcept14_30.convertCodeableConcept(t.getValueCodeableConcept()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addUseContext(CodeableConcept14_30.convertCodeableConcept(t));
        if (src.hasPurpose())
            tgt.setRequirements(src.getPurpose());
        if (src.hasCopyright())
            tgt.setCopyright(src.getCopyright());
        if (src.hasCaseSensitive())
            tgt.setCaseSensitiveElement(Boolean14_30.convertBoolean(src.getCaseSensitiveElement()));
        if (src.hasValueSet())
            tgt.setValueSetElement(Uri14_30.convertUri(src.getValueSetElement()));
        if (src.hasCompositional())
            tgt.setCompositionalElement(Boolean14_30.convertBoolean(src.getCompositionalElement()));
        if (src.hasVersionNeeded())
            tgt.setVersionNeededElement(Boolean14_30.convertBoolean(src.getVersionNeededElement()));
        if (src.hasContent())
            tgt.setContentElement(convertCodeSystemContentMode(src.getContentElement()));
        if (src.hasCount())
            tgt.setCountElement(UnsignedInt14_30.convertUnsignedInt(src.getCountElement()));
        for (org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemFilterComponent t : src.getFilter()) tgt.addFilter(convertCodeSystemFilterComponent(t));
        for (org.hl7.fhir.dstu3.model.CodeSystem.PropertyComponent t : src.getProperty()) tgt.addProperty(convertPropertyComponent(t));
        for (org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionComponent t : src.getConcept()) tgt.addConcept(convertConceptDefinitionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemContactComponent convertCodeSystemContactComponent(org.hl7.fhir.dstu3.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemContactComponent tgt = new org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemContactComponent();
        Element14_30.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(String14_30.convertString(src.getNameElement()));
        for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(ContactPoint14_30.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ContactDetail convertCodeSystemContactComponent(org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ContactDetail tgt = new org.hl7.fhir.dstu3.model.ContactDetail();
        Element14_30.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(String14_30.convertString(src.getNameElement()));
        for (org.hl7.fhir.dstu2016may.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(ContactPoint14_30.convertContactPoint(t));
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemContentMode> convertCodeSystemContentMode(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemContentMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemContentMode> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemContentModeEnumFactory());
        Element14_30.copyElement(src, tgt);
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

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemContentMode> convertCodeSystemContentMode(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemContentMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemContentMode> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemContentModeEnumFactory());
        Element14_30.copyElement(src, tgt);
        switch(src.getValue()) {
            case NOTPRESENT:
                tgt.setValue(org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemContentMode.NOTPRESENT);
                break;
            case EXAMPLAR:
                tgt.setValue(org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemContentMode.EXAMPLE);
                break;
            case FRAGMENT:
                tgt.setValue(org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemContentMode.FRAGMENT);
                break;
            case COMPLETE:
                tgt.setValue(org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemContentMode.COMPLETE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemContentMode.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemFilterComponent convertCodeSystemFilterComponent(org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemFilterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemFilterComponent tgt = new org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemFilterComponent();
        Element14_30.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement(Code14_30.convertCode(src.getCodeElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(String14_30.convertString(src.getDescriptionElement()));
        for (org.hl7.fhir.dstu2016may.model.CodeType t : src.getOperator()) try {
            tgt.addOperator(CodeSystem.FilterOperator.fromCode(t.getValue()));
        } catch (org.hl7.fhir.exceptions.FHIRException e) {
            throw new FHIRException(e);
        }
        if (src.hasValueElement())
            tgt.setValueElement(String14_30.convertString(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemFilterComponent convertCodeSystemFilterComponent(org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemFilterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemFilterComponent tgt = new org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemFilterComponent();
        Element14_30.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement(Code14_30.convertCode(src.getCodeElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(String14_30.convertString(src.getDescriptionElement()));
        for (Enumeration<FilterOperator> t : src.getOperator()) tgt.addOperator(t.getValue().toCode());
        if (src.hasValueElement())
            tgt.setValueElement(String14_30.convertString(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionComponent convertConceptDefinitionComponent(org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionComponent tgt = new org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionComponent();
        Element14_30.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement(Code14_30.convertCode(src.getCodeElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(String14_30.convertString(src.getDisplayElement()));
        if (src.hasDefinition())
            tgt.setDefinitionElement(String14_30.convertString(src.getDefinitionElement()));
        for (org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionDesignationComponent t : src.getDesignation()) tgt.addDesignation(convertConceptDefinitionDesignationComponent(t));
        for (org.hl7.fhir.dstu3.model.CodeSystem.ConceptPropertyComponent t : src.getProperty()) tgt.addProperty(convertConceptPropertyComponent(t));
        for (org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionComponent t : src.getConcept()) tgt.addConcept(convertConceptDefinitionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionComponent convertConceptDefinitionComponent(org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionComponent tgt = new org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionComponent();
        Element14_30.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement(Code14_30.convertCode(src.getCodeElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(String14_30.convertString(src.getDisplayElement()));
        if (src.hasDefinition())
            tgt.setDefinitionElement(String14_30.convertString(src.getDefinitionElement()));
        for (org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionDesignationComponent t : src.getDesignation()) tgt.addDesignation(convertConceptDefinitionDesignationComponent(t));
        for (ConceptDefinitionPropertyComponent t : src.getProperty()) tgt.addProperty(convertConceptPropertyComponent(t));
        for (org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionComponent t : src.getConcept()) tgt.addConcept(convertConceptDefinitionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionDesignationComponent convertConceptDefinitionDesignationComponent(org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionDesignationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionDesignationComponent tgt = new org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionDesignationComponent();
        Element14_30.copyElement(src, tgt);
        if (src.hasLanguage())
            tgt.setLanguageElement(Code14_30.convertCode(src.getLanguageElement()));
        if (src.hasUse())
            tgt.setUse(Code14_30.convertCoding(src.getUse()));
        if (src.hasValueElement())
            tgt.setValueElement(String14_30.convertString(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionDesignationComponent convertConceptDefinitionDesignationComponent(org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionDesignationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionDesignationComponent tgt = new org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionDesignationComponent();
        Element14_30.copyElement(src, tgt);
        if (src.hasLanguage())
            tgt.setLanguageElement(Code14_30.convertCode(src.getLanguageElement()));
        if (src.hasUse())
            tgt.setUse(Code14_30.convertCoding(src.getUse()));
        if (src.hasValueElement())
            tgt.setValueElement(String14_30.convertString(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionPropertyComponent convertConceptPropertyComponent(org.hl7.fhir.dstu3.model.CodeSystem.ConceptPropertyComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionPropertyComponent tgt = new org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionPropertyComponent();
        Element14_30.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement(Code14_30.convertCode(src.getCodeElement()));
        if (src.hasValue())
            tgt.setValue(Type14_30.convertType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CodeSystem.ConceptPropertyComponent convertConceptPropertyComponent(org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionPropertyComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.CodeSystem.ConceptPropertyComponent tgt = new org.hl7.fhir.dstu3.model.CodeSystem.ConceptPropertyComponent();
        Element14_30.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement(Code14_30.convertCode(src.getCodeElement()));
        if (src.hasValue())
            tgt.setValue(Type14_30.convertType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CodeSystem.PropertyComponent convertPropertyComponent(org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemPropertyComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.CodeSystem.PropertyComponent tgt = new org.hl7.fhir.dstu3.model.CodeSystem.PropertyComponent();
        Element14_30.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement(Code14_30.convertCode(src.getCodeElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(String14_30.convertString(src.getDescriptionElement()));
        if (src.hasType())
            tgt.setTypeElement(convertPropertyType(src.getTypeElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemPropertyComponent convertPropertyComponent(org.hl7.fhir.dstu3.model.CodeSystem.PropertyComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemPropertyComponent tgt = new org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemPropertyComponent();
        Element14_30.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement(Code14_30.convertCode(src.getCodeElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(String14_30.convertString(src.getDescriptionElement()));
        if (src.hasType())
            tgt.setTypeElement(convertPropertyType(src.getTypeElement()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CodeSystem.PropertyType> convertPropertyType(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.CodeSystem.PropertyType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CodeSystem.PropertyType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.CodeSystem.PropertyTypeEnumFactory());
        Element14_30.copyElement(src, tgt);
        switch(src.getValue()) {
            case CODE:
                tgt.setValue(org.hl7.fhir.dstu3.model.CodeSystem.PropertyType.CODE);
                break;
            case CODING:
                tgt.setValue(org.hl7.fhir.dstu3.model.CodeSystem.PropertyType.CODING);
                break;
            case STRING:
                tgt.setValue(org.hl7.fhir.dstu3.model.CodeSystem.PropertyType.STRING);
                break;
            case INTEGER:
                tgt.setValue(org.hl7.fhir.dstu3.model.CodeSystem.PropertyType.INTEGER);
                break;
            case BOOLEAN:
                tgt.setValue(org.hl7.fhir.dstu3.model.CodeSystem.PropertyType.BOOLEAN);
                break;
            case DATETIME:
                tgt.setValue(org.hl7.fhir.dstu3.model.CodeSystem.PropertyType.DATETIME);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.CodeSystem.PropertyType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.CodeSystem.PropertyType> convertPropertyType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CodeSystem.PropertyType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.CodeSystem.PropertyType> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.CodeSystem.PropertyTypeEnumFactory());
        Element14_30.copyElement(src, tgt);
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