package org.hl7.fhir.convertors.conv30_40.resources30_40;

import org.hl7.fhir.convertors.conv30_40.VersionConvertor_30_40; import org.hl7.fhir.convertors.context.ConversionContext30_40; import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Element30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Type30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.CodeableConcept30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Coding30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Identifier30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Timing30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.ContactDetail30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.*;
import org.hl7.fhir.exceptions.FHIRException; import org.hl7.fhir.convertors.context.ConversionContext30_40;

import java.util.stream.Collectors;

public class CodeSystem30_40 {

    public static org.hl7.fhir.r4.model.CodeSystem convertCodeSystem(org.hl7.fhir.dstu3.model.CodeSystem src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.CodeSystem tgt = new org.hl7.fhir.r4.model.CodeSystem();
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(Uri30_40.convertUri(src.getUrlElement()));
        if (src.hasIdentifier())
            tgt.addIdentifier(Identifier30_40.convertIdentifier(src.getIdentifier()));
        if (src.hasVersion())
            tgt.setVersionElement(String30_40.convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(String30_40.convertString(src.getNameElement()));
        if (src.hasTitle())
            tgt.setTitleElement(String30_40.convertString(src.getTitleElement()));
        if (src.hasStatus())
            tgt.setStatusElement(Enumerations30_40.convertPublicationStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(Boolean30_40.convertBoolean(src.getExperimentalElement()));
        if (src.hasDateElement())
            tgt.setDateElement(DateTime30_40.convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(String30_40.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(ContactDetail30_40.convertContactDetail(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(MarkDown30_40.convertMarkdown(src.getDescriptionElement()));
        for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext()) tgt.addUseContext(Timing30_40.convertUsageContext(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(CodeableConcept30_40.convertCodeableConcept(t));
        if (src.hasPurpose())
            tgt.setPurposeElement(MarkDown30_40.convertMarkdown(src.getPurposeElement()));
        if (src.hasCopyright())
            tgt.setCopyrightElement(MarkDown30_40.convertMarkdown(src.getCopyrightElement()));
        if (src.hasCaseSensitive())
            tgt.setCaseSensitiveElement(Boolean30_40.convertBoolean(src.getCaseSensitiveElement()));
        if (src.hasValueSet())
            tgt.setValueSet(src.getValueSet());
        if (src.hasHierarchyMeaning())
            tgt.setHierarchyMeaningElement(convertCodeSystemHierarchyMeaning(src.getHierarchyMeaningElement()));
        if (src.hasCompositional())
            tgt.setCompositionalElement(Boolean30_40.convertBoolean(src.getCompositionalElement()));
        if (src.hasVersionNeeded())
            tgt.setVersionNeededElement(Boolean30_40.convertBoolean(src.getVersionNeededElement()));
        if (src.hasContent())
            tgt.setContentElement(convertCodeSystemContentMode(src.getContentElement()));
        if (src.hasCount())
            tgt.setCountElement(UnsignedInt30_40.convertUnsignedInt(src.getCountElement()));
        for (org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemFilterComponent t : src.getFilter()) tgt.addFilter(convertCodeSystemFilterComponent(t));
        for (org.hl7.fhir.dstu3.model.CodeSystem.PropertyComponent t : src.getProperty()) tgt.addProperty(convertPropertyComponent(t));
        for (org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionComponent t : src.getConcept()) tgt.addConcept(convertConceptDefinitionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CodeSystem convertCodeSystem(org.hl7.fhir.r4.model.CodeSystem src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.CodeSystem tgt = new org.hl7.fhir.dstu3.model.CodeSystem();
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(Uri30_40.convertUri(src.getUrlElement()));
        if (src.hasIdentifier())
            tgt.setIdentifier(Identifier30_40.convertIdentifier(src.getIdentifierFirstRep()));
        if (src.hasVersion())
            tgt.setVersionElement(String30_40.convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(String30_40.convertString(src.getNameElement()));
        if (src.hasTitle())
            tgt.setTitleElement(String30_40.convertString(src.getTitleElement()));
        if (src.hasStatus())
            tgt.setStatusElement(Enumerations30_40.convertPublicationStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(Boolean30_40.convertBoolean(src.getExperimentalElement()));
        if (src.hasDateElement())
            tgt.setDateElement(DateTime30_40.convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(String30_40.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact()) tgt.addContact(ContactDetail30_40.convertContactDetail(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(MarkDown30_40.convertMarkdown(src.getDescriptionElement()));
        for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext()) tgt.addUseContext(Timing30_40.convertUsageContext(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(CodeableConcept30_40.convertCodeableConcept(t));
        if (src.hasPurpose())
            tgt.setPurposeElement(MarkDown30_40.convertMarkdown(src.getPurposeElement()));
        if (src.hasCopyright())
            tgt.setCopyrightElement(MarkDown30_40.convertMarkdown(src.getCopyrightElement()));
        if (src.hasCaseSensitive())
            tgt.setCaseSensitiveElement(Boolean30_40.convertBoolean(src.getCaseSensitiveElement()));
        if (src.hasValueSet())
            tgt.setValueSet(src.getValueSet());
        if (src.hasHierarchyMeaning())
            tgt.setHierarchyMeaningElement(convertCodeSystemHierarchyMeaning(src.getHierarchyMeaningElement()));
        if (src.hasCompositional())
            tgt.setCompositionalElement(Boolean30_40.convertBoolean(src.getCompositionalElement()));
        if (src.hasVersionNeeded())
            tgt.setVersionNeededElement(Boolean30_40.convertBoolean(src.getVersionNeededElement()));
        if (src.hasContent())
            tgt.setContentElement(convertCodeSystemContentMode(src.getContentElement()));
        if (src.hasCount())
            tgt.setCountElement(UnsignedInt30_40.convertUnsignedInt(src.getCountElement()));
        for (org.hl7.fhir.r4.model.CodeSystem.CodeSystemFilterComponent t : src.getFilter()) tgt.addFilter(convertCodeSystemFilterComponent(t));
        for (org.hl7.fhir.r4.model.CodeSystem.PropertyComponent t : src.getProperty()) tgt.addProperty(convertPropertyComponent(t));
        for (org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionComponent t : src.getConcept()) tgt.addConcept(convertConceptDefinitionComponent(t));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemContentMode> convertCodeSystemContentMode(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CodeSystem.CodeSystemContentMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemContentMode> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemContentModeEnumFactory());
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
        switch(src.getValue()) {
            case NOTPRESENT:
                tgt.setValue(org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemContentMode.NOTPRESENT);
                break;
            case EXAMPLE:
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

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CodeSystem.CodeSystemContentMode> convertCodeSystemContentMode(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemContentMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CodeSystem.CodeSystemContentMode> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.CodeSystem.CodeSystemContentModeEnumFactory());
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
        switch(src.getValue()) {
            case NOTPRESENT:
                tgt.setValue(org.hl7.fhir.r4.model.CodeSystem.CodeSystemContentMode.NOTPRESENT);
                break;
            case EXAMPLE:
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

    public static org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemFilterComponent convertCodeSystemFilterComponent(org.hl7.fhir.r4.model.CodeSystem.CodeSystemFilterComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemFilterComponent tgt = new org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemFilterComponent();
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCodeElement(Code30_40.convertCode(src.getCodeElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(String30_40.convertString(src.getDescriptionElement()));
        tgt.setOperator(src.getOperator().stream()
                .map(CodeSystem30_40::convertFilterOperator)
                .collect(Collectors.toList()));
        if (src.hasValue())
            tgt.setValueElement(String30_40.convertString(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.CodeSystem.CodeSystemFilterComponent convertCodeSystemFilterComponent(org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemFilterComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.CodeSystem.CodeSystemFilterComponent tgt = new org.hl7.fhir.r4.model.CodeSystem.CodeSystemFilterComponent();
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCodeElement(Code30_40.convertCode(src.getCodeElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(String30_40.convertString(src.getDescriptionElement()));
        tgt.setOperator(src.getOperator().stream()
                .map(CodeSystem30_40::convertFilterOperator)
                .collect(Collectors.toList()));
        if (src.hasValue())
            tgt.setValueElement(String30_40.convertString(src.getValueElement()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemHierarchyMeaning> convertCodeSystemHierarchyMeaning(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CodeSystem.CodeSystemHierarchyMeaning> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemHierarchyMeaning> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemHierarchyMeaningEnumFactory());
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
        switch(src.getValue()) {
            case GROUPEDBY:
                tgt.setValue(org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemHierarchyMeaning.GROUPEDBY);
                break;
            case ISA:
                tgt.setValue(org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemHierarchyMeaning.ISA);
                break;
            case PARTOF:
                tgt.setValue(org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemHierarchyMeaning.PARTOF);
                break;
            case CLASSIFIEDWITH:
                tgt.setValue(org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemHierarchyMeaning.CLASSIFIEDWITH);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemHierarchyMeaning.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CodeSystem.CodeSystemHierarchyMeaning> convertCodeSystemHierarchyMeaning(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemHierarchyMeaning> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CodeSystem.CodeSystemHierarchyMeaning> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.CodeSystem.CodeSystemHierarchyMeaningEnumFactory());
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
        switch(src.getValue()) {
            case GROUPEDBY:
                tgt.setValue(org.hl7.fhir.r4.model.CodeSystem.CodeSystemHierarchyMeaning.GROUPEDBY);
                break;
            case ISA:
                tgt.setValue(org.hl7.fhir.r4.model.CodeSystem.CodeSystemHierarchyMeaning.ISA);
                break;
            case PARTOF:
                tgt.setValue(org.hl7.fhir.r4.model.CodeSystem.CodeSystemHierarchyMeaning.PARTOF);
                break;
            case CLASSIFIEDWITH:
                tgt.setValue(org.hl7.fhir.r4.model.CodeSystem.CodeSystemHierarchyMeaning.CLASSIFIEDWITH);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.CodeSystem.CodeSystemHierarchyMeaning.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionComponent convertConceptDefinitionComponent(org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionComponent tgt = new org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionComponent();
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCodeElement(Code30_40.convertCode(src.getCodeElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(String30_40.convertString(src.getDisplayElement()));
        if (src.hasDefinition())
            tgt.setDefinitionElement(String30_40.convertString(src.getDefinitionElement()));
        for (org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionDesignationComponent t : src.getDesignation()) tgt.addDesignation(convertConceptDefinitionDesignationComponent(t));
        for (org.hl7.fhir.r4.model.CodeSystem.ConceptPropertyComponent t : src.getProperty()) tgt.addProperty(convertConceptPropertyComponent(t));
        for (org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionComponent t : src.getConcept()) tgt.addConcept(convertConceptDefinitionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionComponent convertConceptDefinitionComponent(org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionComponent tgt = new org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionComponent();
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCodeElement(Code30_40.convertCode(src.getCodeElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(String30_40.convertString(src.getDisplayElement()));
        if (src.hasDefinition())
            tgt.setDefinitionElement(String30_40.convertString(src.getDefinitionElement()));
        for (org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionDesignationComponent t : src.getDesignation()) tgt.addDesignation(convertConceptDefinitionDesignationComponent(t));
        for (org.hl7.fhir.dstu3.model.CodeSystem.ConceptPropertyComponent t : src.getProperty()) tgt.addProperty(convertConceptPropertyComponent(t));
        for (org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionComponent t : src.getConcept()) tgt.addConcept(convertConceptDefinitionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionDesignationComponent convertConceptDefinitionDesignationComponent(org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionDesignationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionDesignationComponent tgt = new org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionDesignationComponent();
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
        if (src.hasLanguage())
            tgt.setLanguageElement(Code30_40.convertCode(src.getLanguageElement()));
        if (src.hasUse())
            tgt.setUse(Coding30_40.convertCoding(src.getUse()));
        if (src.hasValue())
            tgt.setValueElement(String30_40.convertString(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionDesignationComponent convertConceptDefinitionDesignationComponent(org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionDesignationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionDesignationComponent tgt = new org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionDesignationComponent();
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
        if (src.hasLanguage())
            tgt.setLanguageElement(Code30_40.convertCode(src.getLanguageElement()));
        if (src.hasUse())
            tgt.setUse(Coding30_40.convertCoding(src.getUse()));
        if (src.hasValue())
            tgt.setValueElement(String30_40.convertString(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CodeSystem.ConceptPropertyComponent convertConceptPropertyComponent(org.hl7.fhir.r4.model.CodeSystem.ConceptPropertyComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.CodeSystem.ConceptPropertyComponent tgt = new org.hl7.fhir.dstu3.model.CodeSystem.ConceptPropertyComponent();
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCodeElement(Code30_40.convertCode(src.getCodeElement()));
        if (src.hasValue())
            tgt.setValue(VersionConvertorFactory_30_40.convertType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.CodeSystem.ConceptPropertyComponent convertConceptPropertyComponent(org.hl7.fhir.dstu3.model.CodeSystem.ConceptPropertyComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.CodeSystem.ConceptPropertyComponent tgt = new org.hl7.fhir.r4.model.CodeSystem.ConceptPropertyComponent();
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCodeElement(Code30_40.convertCode(src.getCodeElement()));
        if (src.hasValue())
            tgt.setValue(VersionConvertorFactory_30_40.convertType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.CodeSystem.PropertyComponent convertPropertyComponent(org.hl7.fhir.dstu3.model.CodeSystem.PropertyComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.CodeSystem.PropertyComponent tgt = new org.hl7.fhir.r4.model.CodeSystem.PropertyComponent();
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCodeElement(Code30_40.convertCode(src.getCodeElement()));
        if (src.hasUri())
            tgt.setUriElement(Uri30_40.convertUri(src.getUriElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(String30_40.convertString(src.getDescriptionElement()));
        if (src.hasType())
            tgt.setTypeElement(convertPropertyType(src.getTypeElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CodeSystem.PropertyComponent convertPropertyComponent(org.hl7.fhir.r4.model.CodeSystem.PropertyComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.CodeSystem.PropertyComponent tgt = new org.hl7.fhir.dstu3.model.CodeSystem.PropertyComponent();
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCodeElement(Code30_40.convertCode(src.getCodeElement()));
        if (src.hasUri())
            tgt.setUriElement(Uri30_40.convertUri(src.getUriElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(String30_40.convertString(src.getDescriptionElement()));
        if (src.hasType())
            tgt.setTypeElement(convertPropertyType(src.getTypeElement()));
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CodeSystem.PropertyType> convertPropertyType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CodeSystem.PropertyType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CodeSystem.PropertyType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.CodeSystem.PropertyTypeEnumFactory());
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
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

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CodeSystem.PropertyType> convertPropertyType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CodeSystem.PropertyType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CodeSystem.PropertyType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.CodeSystem.PropertyTypeEnumFactory());
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
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

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CodeSystem.FilterOperator> convertFilterOperator(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CodeSystem.FilterOperator> src) {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CodeSystem.FilterOperator> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.CodeSystem.FilterOperatorEnumFactory());
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
        switch (src.getValue()) {
            case EQUAL:
                tgt.setValue(org.hl7.fhir.r4.model.CodeSystem.FilterOperator.EQUAL);
                break;
            case ISA:
                tgt.setValue(org.hl7.fhir.r4.model.CodeSystem.FilterOperator.ISA);
                break;
            case DESCENDENTOF:
                tgt.setValue(org.hl7.fhir.r4.model.CodeSystem.FilterOperator.DESCENDENTOF);
                break;
            case ISNOTA:
                tgt.setValue(org.hl7.fhir.r4.model.CodeSystem.FilterOperator.ISNOTA);
                break;
            case REGEX:
                tgt.setValue(org.hl7.fhir.r4.model.CodeSystem.FilterOperator.REGEX);
                break;
            case IN:
                tgt.setValue(org.hl7.fhir.r4.model.CodeSystem.FilterOperator.IN);
                break;
            case NOTIN:
                tgt.setValue(org.hl7.fhir.r4.model.CodeSystem.FilterOperator.NOTIN);
                break;
            case GENERALIZES:
                tgt.setValue(org.hl7.fhir.r4.model.CodeSystem.FilterOperator.GENERALIZES);
                break;
            case EXISTS:
                tgt.setValue(org.hl7.fhir.r4.model.CodeSystem.FilterOperator.EXISTS);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.CodeSystem.FilterOperator.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CodeSystem.FilterOperator> convertFilterOperator(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CodeSystem.FilterOperator> src) {
            if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CodeSystem.FilterOperator> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.CodeSystem.FilterOperatorEnumFactory());
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
        switch (src.getValue()) {
            case EQUAL:
                tgt.setValue(org.hl7.fhir.dstu3.model.CodeSystem.FilterOperator.EQUAL);
                break;
            case ISA:
                tgt.setValue(org.hl7.fhir.dstu3.model.CodeSystem.FilterOperator.ISA);
                break;
            case DESCENDENTOF:
                tgt.setValue(org.hl7.fhir.dstu3.model.CodeSystem.FilterOperator.DESCENDENTOF);
                break;
            case ISNOTA:
                tgt.setValue(org.hl7.fhir.dstu3.model.CodeSystem.FilterOperator.ISNOTA);
                break;
            case REGEX:
                tgt.setValue(org.hl7.fhir.dstu3.model.CodeSystem.FilterOperator.REGEX);
                break;
            case IN:
                tgt.setValue(org.hl7.fhir.dstu3.model.CodeSystem.FilterOperator.IN);
                break;
            case NOTIN:
                tgt.setValue(org.hl7.fhir.dstu3.model.CodeSystem.FilterOperator.NOTIN);
                break;
            case GENERALIZES:
                tgt.setValue(org.hl7.fhir.dstu3.model.CodeSystem.FilterOperator.GENERALIZES);
                break;
            case EXISTS:
                tgt.setValue(org.hl7.fhir.dstu3.model.CodeSystem.FilterOperator.EXISTS);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.CodeSystem.FilterOperator.NULL);
                break;
        }
        return tgt;
    }
}