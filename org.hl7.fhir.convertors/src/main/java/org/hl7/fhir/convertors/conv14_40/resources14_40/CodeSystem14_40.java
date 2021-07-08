package org.hl7.fhir.convertors.conv14_40.resources14_40;

import org.hl7.fhir.convertors.conv14_40.VersionConvertor_14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.Element14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.Type14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.complextypes14_40.CodeableConcept14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.complextypes14_40.Coding14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.complextypes14_40.ContactPoint14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.complextypes14_40.Identifier14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.*;
import org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionPropertyComponent;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.CodeSystem;
import org.hl7.fhir.r4.model.CodeSystem.FilterOperator;
import org.hl7.fhir.r4.model.Enumeration;

public class CodeSystem14_40 {

    public static org.hl7.fhir.r4.model.CodeSystem convertCodeSystem(org.hl7.fhir.dstu2016may.model.CodeSystem src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.CodeSystem tgt = new org.hl7.fhir.r4.model.CodeSystem();
        VersionConvertor_14_40.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(Uri14_40.convertUri(src.getUrlElement()));
        if (src.hasIdentifier())
            tgt.addIdentifier(Identifier14_40.convertIdentifier(src.getIdentifier()));
        if (src.hasVersion())
            tgt.setVersionElement(String14_40.convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(String14_40.convertString(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatusElement(Enumerations14_40.convertConformanceResourceStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(Boolean14_40.convertBoolean(src.getExperimentalElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(String14_40.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemContactComponent t : src.getContact()) tgt.addContact(convertCodeSystemContactComponent(t));
        if (src.hasDate())
            tgt.setDateElement(DateTime14_40.convertDateTime(src.getDateElement()));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu2016may.model.CodeableConcept t : src.getUseContext()) if (VersionConvertor_14_40.isJurisdiction(t))
            tgt.addJurisdiction(CodeableConcept14_40.convertCodeableConcept(t));
        else
            tgt.addUseContext(CodeableConcept14_40.convertCodeableConceptToUsageContext(t));
        if (src.hasRequirements())
            tgt.setPurpose(src.getRequirements());
        if (src.hasCopyright())
            tgt.setCopyright(src.getCopyright());
        if (src.hasCaseSensitive())
            tgt.setCaseSensitiveElement(Boolean14_40.convertBoolean(src.getCaseSensitiveElement()));
        if (src.hasValueSet())
            tgt.setValueSet(src.getValueSet());
        if (src.hasCompositional())
            tgt.setCompositionalElement(Boolean14_40.convertBoolean(src.getCompositionalElement()));
        if (src.hasVersionNeeded())
            tgt.setVersionNeededElement(Boolean14_40.convertBoolean(src.getVersionNeededElement()));
        if (src.hasContent())
            tgt.setContentElement(convertCodeSystemContentMode(src.getContentElement()));
        if (src.hasCount())
            tgt.setCountElement(UnsignedInt14_40.convertUnsignedInt(src.getCountElement()));
        for (org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemFilterComponent t : src.getFilter()) tgt.addFilter(convertCodeSystemFilterComponent(t));
        for (org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemPropertyComponent t : src.getProperty()) tgt.addProperty(convertPropertyComponent(t));
        for (org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionComponent t : src.getConcept()) tgt.addConcept(convertConceptDefinitionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.CodeSystem convertCodeSystem(org.hl7.fhir.r4.model.CodeSystem src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.CodeSystem tgt = new org.hl7.fhir.dstu2016may.model.CodeSystem();
        VersionConvertor_14_40.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(Uri14_40.convertUri(src.getUrlElement()));
        if (src.hasIdentifier())
            tgt.setIdentifier(Identifier14_40.convertIdentifier(src.getIdentifierFirstRep()));
        if (src.hasVersion())
            tgt.setVersionElement(String14_40.convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(String14_40.convertString(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatusElement(Enumerations14_40.convertConformanceResourceStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(Boolean14_40.convertBoolean(src.getExperimentalElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(String14_40.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact()) tgt.addContact(convertCodeSystemContactComponent(t));
        if (src.hasDate())
            tgt.setDateElement(DateTime14_40.convertDateTime(src.getDateElement()));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext()) if (t.hasValueCodeableConcept())
            tgt.addUseContext(CodeableConcept14_40.convertCodeableConcept(t.getValueCodeableConcept()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction()) tgt.addUseContext(CodeableConcept14_40.convertCodeableConcept(t));
        if (src.hasPurpose())
            tgt.setRequirements(src.getPurpose());
        if (src.hasCopyright())
            tgt.setCopyright(src.getCopyright());
        if (src.hasCaseSensitive())
            tgt.setCaseSensitiveElement(Boolean14_40.convertBoolean(src.getCaseSensitiveElement()));
        if (src.hasValueSet())
            tgt.setValueSet(src.getValueSet());
        if (src.hasCompositional())
            tgt.setCompositionalElement(Boolean14_40.convertBoolean(src.getCompositionalElement()));
        if (src.hasVersionNeeded())
            tgt.setVersionNeededElement(Boolean14_40.convertBoolean(src.getVersionNeededElement()));
        if (src.hasContent())
            tgt.setContentElement(convertCodeSystemContentMode(src.getContentElement()));
        if (src.hasCount())
            tgt.setCountElement(UnsignedInt14_40.convertUnsignedInt(src.getCountElement()));
        for (org.hl7.fhir.r4.model.CodeSystem.CodeSystemFilterComponent t : src.getFilter()) tgt.addFilter(convertCodeSystemFilterComponent(t));
        for (org.hl7.fhir.r4.model.CodeSystem.PropertyComponent t : src.getProperty()) tgt.addProperty(convertPropertyComponent(t));
        for (org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionComponent t : src.getConcept()) tgt.addConcept(convertConceptDefinitionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ContactDetail convertCodeSystemContactComponent(org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ContactDetail tgt = new org.hl7.fhir.r4.model.ContactDetail();
        Element14_40.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(String14_40.convertString(src.getNameElement()));
        for (org.hl7.fhir.dstu2016may.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(ContactPoint14_40.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemContactComponent convertCodeSystemContactComponent(org.hl7.fhir.r4.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemContactComponent tgt = new org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemContactComponent();
        Element14_40.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(String14_40.convertString(src.getNameElement()));
        for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(ContactPoint14_40.convertContactPoint(t));
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemContentMode> convertCodeSystemContentMode(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CodeSystem.CodeSystemContentMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemContentMode> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemContentModeEnumFactory());
        Element14_40.copyElement(src, tgt);
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

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CodeSystem.CodeSystemContentMode> convertCodeSystemContentMode(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemContentMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CodeSystem.CodeSystemContentMode> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.CodeSystem.CodeSystemContentModeEnumFactory());
        Element14_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case NOTPRESENT:
                tgt.setValue(org.hl7.fhir.r4.model.CodeSystem.CodeSystemContentMode.NOTPRESENT);
                break;
            case EXAMPLAR:
                tgt.setValue(org.hl7.fhir.r4.model.CodeSystem.CodeSystemContentMode.EXAMPLE);
                break;
            case FRAGMENT:
                tgt.setValue(org.hl7.fhir.r4.model.CodeSystem.CodeSystemContentMode.FRAGMENT);
                break;
            case COMPLETE:
                tgt.setValue(org.hl7.fhir.r4.model.CodeSystem.CodeSystemContentMode.COMPLETE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.CodeSystem.CodeSystemContentMode.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.CodeSystem.CodeSystemFilterComponent convertCodeSystemFilterComponent(org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemFilterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.CodeSystem.CodeSystemFilterComponent tgt = new org.hl7.fhir.r4.model.CodeSystem.CodeSystemFilterComponent();
        Element14_40.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement(Code14_40.convertCode(src.getCodeElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(String14_40.convertString(src.getDescriptionElement()));
        for (org.hl7.fhir.dstu2016may.model.CodeType t : src.getOperator()) try {
            tgt.addOperator(CodeSystem.FilterOperator.fromCode(t.getValue()));
        } catch (org.hl7.fhir.exceptions.FHIRException e) {
            throw new FHIRException(e);
        }
        if (src.hasValueElement())
            tgt.setValueElement(String14_40.convertString(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemFilterComponent convertCodeSystemFilterComponent(org.hl7.fhir.r4.model.CodeSystem.CodeSystemFilterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemFilterComponent tgt = new org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemFilterComponent();
        Element14_40.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement(Code14_40.convertCode(src.getCodeElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(String14_40.convertString(src.getDescriptionElement()));
        for (Enumeration<FilterOperator> t : src.getOperator()) tgt.addOperator(t.getValue().toCode());
        if (src.hasValueElement())
            tgt.setValueElement(String14_40.convertString(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionComponent convertConceptDefinitionComponent(org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionComponent tgt = new org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionComponent();
        Element14_40.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement(Code14_40.convertCode(src.getCodeElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(String14_40.convertString(src.getDisplayElement()));
        if (src.hasDefinition())
            tgt.setDefinitionElement(String14_40.convertString(src.getDefinitionElement()));
        for (org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionDesignationComponent t : src.getDesignation()) tgt.addDesignation(convertConceptDefinitionDesignationComponent(t));
        for (ConceptDefinitionPropertyComponent t : src.getProperty()) tgt.addProperty(convertConceptPropertyComponent(t));
        for (org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionComponent t : src.getConcept()) tgt.addConcept(convertConceptDefinitionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionComponent convertConceptDefinitionComponent(org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionComponent tgt = new org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionComponent();
        Element14_40.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement(Code14_40.convertCode(src.getCodeElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(String14_40.convertString(src.getDisplayElement()));
        if (src.hasDefinition())
            tgt.setDefinitionElement(String14_40.convertString(src.getDefinitionElement()));
        for (org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionDesignationComponent t : src.getDesignation()) tgt.addDesignation(convertConceptDefinitionDesignationComponent(t));
        for (org.hl7.fhir.r4.model.CodeSystem.ConceptPropertyComponent t : src.getProperty()) tgt.addProperty(convertConceptPropertyComponent(t));
        for (org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionComponent t : src.getConcept()) tgt.addConcept(convertConceptDefinitionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionDesignationComponent convertConceptDefinitionDesignationComponent(org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionDesignationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionDesignationComponent tgt = new org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionDesignationComponent();
        Element14_40.copyElement(src, tgt);
        if (src.hasLanguage())
            tgt.setLanguageElement(Code14_40.convertCode(src.getLanguageElement()));
        if (src.hasUse())
            tgt.setUse(Coding14_40.convertCoding(src.getUse()));
        if (src.hasValueElement())
            tgt.setValueElement(String14_40.convertString(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionDesignationComponent convertConceptDefinitionDesignationComponent(org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionDesignationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionDesignationComponent tgt = new org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionDesignationComponent();
        Element14_40.copyElement(src, tgt);
        if (src.hasLanguage())
            tgt.setLanguageElement(Code14_40.convertCode(src.getLanguageElement()));
        if (src.hasUse())
            tgt.setUse(Coding14_40.convertCoding(src.getUse()));
        if (src.hasValueElement())
            tgt.setValueElement(String14_40.convertString(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionPropertyComponent convertConceptPropertyComponent(org.hl7.fhir.r4.model.CodeSystem.ConceptPropertyComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionPropertyComponent tgt = new org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionPropertyComponent();
        Element14_40.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement(Code14_40.convertCode(src.getCodeElement()));
        if (src.hasValue())
            tgt.setValue(Type14_40.convertType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.CodeSystem.ConceptPropertyComponent convertConceptPropertyComponent(org.hl7.fhir.dstu2016may.model.CodeSystem.ConceptDefinitionPropertyComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.CodeSystem.ConceptPropertyComponent tgt = new org.hl7.fhir.r4.model.CodeSystem.ConceptPropertyComponent();
        Element14_40.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement(Code14_40.convertCode(src.getCodeElement()));
        if (src.hasValue())
            tgt.setValue(Type14_40.convertType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemPropertyComponent convertPropertyComponent(org.hl7.fhir.r4.model.CodeSystem.PropertyComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemPropertyComponent tgt = new org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemPropertyComponent();
        Element14_40.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement(Code14_40.convertCode(src.getCodeElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(String14_40.convertString(src.getDescriptionElement()));
        if (src.hasType())
            tgt.setTypeElement(convertPropertyType(src.getTypeElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.CodeSystem.PropertyComponent convertPropertyComponent(org.hl7.fhir.dstu2016may.model.CodeSystem.CodeSystemPropertyComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.CodeSystem.PropertyComponent tgt = new org.hl7.fhir.r4.model.CodeSystem.PropertyComponent();
        Element14_40.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement(Code14_40.convertCode(src.getCodeElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(String14_40.convertString(src.getDescriptionElement()));
        if (src.hasType())
            tgt.setTypeElement(convertPropertyType(src.getTypeElement()));
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CodeSystem.PropertyType> convertPropertyType(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.CodeSystem.PropertyType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CodeSystem.PropertyType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.CodeSystem.PropertyTypeEnumFactory());
        Element14_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case CODE:
                tgt.setValue(org.hl7.fhir.r4.model.CodeSystem.PropertyType.CODE);
                break;
            case CODING:
                tgt.setValue(org.hl7.fhir.r4.model.CodeSystem.PropertyType.CODING);
                break;
            case STRING:
                tgt.setValue(org.hl7.fhir.r4.model.CodeSystem.PropertyType.STRING);
                break;
            case INTEGER:
                tgt.setValue(org.hl7.fhir.r4.model.CodeSystem.PropertyType.INTEGER);
                break;
            case BOOLEAN:
                tgt.setValue(org.hl7.fhir.r4.model.CodeSystem.PropertyType.BOOLEAN);
                break;
            case DATETIME:
                tgt.setValue(org.hl7.fhir.r4.model.CodeSystem.PropertyType.DATETIME);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.CodeSystem.PropertyType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.CodeSystem.PropertyType> convertPropertyType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CodeSystem.PropertyType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.CodeSystem.PropertyType> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.CodeSystem.PropertyTypeEnumFactory());
        Element14_40.copyElement(src, tgt);
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