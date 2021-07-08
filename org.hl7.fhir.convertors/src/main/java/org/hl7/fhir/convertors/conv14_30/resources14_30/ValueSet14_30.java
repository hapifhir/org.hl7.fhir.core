package org.hl7.fhir.convertors.conv14_30.resources14_30;

import org.hl7.fhir.convertors.conv14_30.VersionConvertor_14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.Element14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.Type14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.complextypes14_30.CodeableConcept14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.complextypes14_30.ContactPoint14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.complextypes14_30.Identifier14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30.*;
import org.hl7.fhir.exceptions.FHIRException;

public class ValueSet14_30 {

    public static org.hl7.fhir.dstu2016may.model.ValueSet.ConceptReferenceComponent convertConceptReferenceComponent(org.hl7.fhir.dstu3.model.ValueSet.ConceptReferenceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ValueSet.ConceptReferenceComponent tgt = new org.hl7.fhir.dstu2016may.model.ValueSet.ConceptReferenceComponent();
        Element14_30.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement(Code14_30.convertCode(src.getCodeElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(String14_30.convertString(src.getDisplayElement()));
        for (org.hl7.fhir.dstu3.model.ValueSet.ConceptReferenceDesignationComponent t : src.getDesignation()) tgt.addDesignation(convertConceptReferenceDesignationComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ValueSet.ConceptReferenceComponent convertConceptReferenceComponent(org.hl7.fhir.dstu2016may.model.ValueSet.ConceptReferenceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ValueSet.ConceptReferenceComponent tgt = new org.hl7.fhir.dstu3.model.ValueSet.ConceptReferenceComponent();
        Element14_30.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement(Code14_30.convertCode(src.getCodeElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(String14_30.convertString(src.getDisplayElement()));
        for (org.hl7.fhir.dstu2016may.model.ValueSet.ConceptReferenceDesignationComponent t : src.getDesignation()) tgt.addDesignation(convertConceptReferenceDesignationComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ValueSet.ConceptReferenceDesignationComponent convertConceptReferenceDesignationComponent(org.hl7.fhir.dstu2016may.model.ValueSet.ConceptReferenceDesignationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ValueSet.ConceptReferenceDesignationComponent tgt = new org.hl7.fhir.dstu3.model.ValueSet.ConceptReferenceDesignationComponent();
        Element14_30.copyElement(src, tgt);
        if (src.hasLanguage())
            tgt.setLanguageElement(Code14_30.convertCode(src.getLanguageElement()));
        if (src.hasUse())
            tgt.setUse(Code14_30.convertCoding(src.getUse()));
        if (src.hasValueElement())
            tgt.setValueElement(String14_30.convertString(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ValueSet.ConceptReferenceDesignationComponent convertConceptReferenceDesignationComponent(org.hl7.fhir.dstu3.model.ValueSet.ConceptReferenceDesignationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ValueSet.ConceptReferenceDesignationComponent tgt = new org.hl7.fhir.dstu2016may.model.ValueSet.ConceptReferenceDesignationComponent();
        Element14_30.copyElement(src, tgt);
        if (src.hasLanguage())
            tgt.setLanguageElement(Code14_30.convertCode(src.getLanguageElement()));
        if (src.hasUse())
            tgt.setUse(Code14_30.convertCoding(src.getUse()));
        if (src.hasValueElement())
            tgt.setValueElement(String14_30.convertString(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ValueSet.ConceptSetComponent convertConceptSetComponent(org.hl7.fhir.dstu2016may.model.ValueSet.ConceptSetComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ValueSet.ConceptSetComponent tgt = new org.hl7.fhir.dstu3.model.ValueSet.ConceptSetComponent();
        Element14_30.copyElement(src, tgt);
        if (src.hasSystemElement())
            tgt.setSystemElement(Uri14_30.convertUri(src.getSystemElement()));
        if (src.hasVersion())
            tgt.setVersionElement(String14_30.convertString(src.getVersionElement()));
        for (org.hl7.fhir.dstu2016may.model.ValueSet.ConceptReferenceComponent t : src.getConcept()) tgt.addConcept(convertConceptReferenceComponent(t));
        for (org.hl7.fhir.dstu2016may.model.ValueSet.ConceptSetFilterComponent t : src.getFilter()) tgt.addFilter(convertConceptSetFilterComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ValueSet.ConceptSetComponent convertConceptSetComponent(org.hl7.fhir.dstu3.model.ValueSet.ConceptSetComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ValueSet.ConceptSetComponent tgt = new org.hl7.fhir.dstu2016may.model.ValueSet.ConceptSetComponent();
        Element14_30.copyElement(src, tgt);
        if (src.hasSystemElement())
            tgt.setSystemElement(Uri14_30.convertUri(src.getSystemElement()));
        if (src.hasVersion())
            tgt.setVersionElement(String14_30.convertString(src.getVersionElement()));
        for (org.hl7.fhir.dstu3.model.ValueSet.ConceptReferenceComponent t : src.getConcept()) tgt.addConcept(convertConceptReferenceComponent(t));
        for (org.hl7.fhir.dstu3.model.ValueSet.ConceptSetFilterComponent t : src.getFilter()) tgt.addFilter(convertConceptSetFilterComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ValueSet.ConceptSetFilterComponent convertConceptSetFilterComponent(org.hl7.fhir.dstu2016may.model.ValueSet.ConceptSetFilterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ValueSet.ConceptSetFilterComponent tgt = new org.hl7.fhir.dstu3.model.ValueSet.ConceptSetFilterComponent();
        Element14_30.copyElement(src, tgt);
        if (src.hasPropertyElement())
            tgt.setPropertyElement(Code14_30.convertCode(src.getPropertyElement()));
        if (src.hasOp())
            tgt.setOpElement(convertFilterOperator(src.getOpElement()));
        if (src.hasValueElement())
            tgt.setValueElement(Code14_30.convertCode(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ValueSet.ConceptSetFilterComponent convertConceptSetFilterComponent(org.hl7.fhir.dstu3.model.ValueSet.ConceptSetFilterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ValueSet.ConceptSetFilterComponent tgt = new org.hl7.fhir.dstu2016may.model.ValueSet.ConceptSetFilterComponent();
        Element14_30.copyElement(src, tgt);
        if (src.hasPropertyElement())
            tgt.setPropertyElement(Code14_30.convertCode(src.getPropertyElement()));
        if (src.hasOp())
            tgt.setOpElement(convertFilterOperator(src.getOpElement()));
        if (src.hasValueElement())
            tgt.setValueElement(Code14_30.convertCode(src.getValueElement()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ValueSet.FilterOperator> convertFilterOperator(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.ValueSet.FilterOperator> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ValueSet.FilterOperator> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.ValueSet.FilterOperatorEnumFactory());
        Element14_30.copyElement(src, tgt);
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

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.ValueSet.FilterOperator> convertFilterOperator(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ValueSet.FilterOperator> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.ValueSet.FilterOperator> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.ValueSet.FilterOperatorEnumFactory());
        Element14_30.copyElement(src, tgt);
        switch(src.getValue()) {
            case EQUAL:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.ValueSet.FilterOperator.EQUAL);
                break;
            case ISA:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.ValueSet.FilterOperator.ISA);
                break;
            case ISNOTA:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.ValueSet.FilterOperator.ISNOTA);
                break;
            case REGEX:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.ValueSet.FilterOperator.REGEX);
                break;
            case IN:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.ValueSet.FilterOperator.IN);
                break;
            case NOTIN:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.ValueSet.FilterOperator.NOTIN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.ValueSet.FilterOperator.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ValueSet convertValueSet(org.hl7.fhir.dstu3.model.ValueSet src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ValueSet tgt = new org.hl7.fhir.dstu2016may.model.ValueSet();
        VersionConvertor_14_30.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(Uri14_30.convertUri(src.getUrlElement()));
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.setIdentifier(Identifier14_30.convertIdentifier(t));
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
        for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(convertValueSetContactComponent(t));
        if (src.hasDate())
            tgt.setDateElement(DateTime14_30.convertDateTime(src.getDateElement()));
        if (src.getCompose().hasLockedDate())
            tgt.setLockedDate(src.getCompose().getLockedDate());
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext()) if (t.hasValueCodeableConcept())
            tgt.addUseContext(CodeableConcept14_30.convertCodeableConcept(t.getValueCodeableConcept()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addUseContext(CodeableConcept14_30.convertCodeableConcept(t));
        if (src.hasImmutable())
            tgt.setImmutableElement(Boolean14_30.convertBoolean(src.getImmutableElement()));
        if (src.hasPurpose())
            tgt.setRequirements(src.getPurpose());
        if (src.hasCopyright())
            tgt.setCopyright(src.getCopyright());
        if (src.hasExtensible())
            tgt.setExtensibleElement(Boolean14_30.convertBoolean(src.getExtensibleElement()));
        if (src.hasCompose())
            tgt.setCompose(convertValueSetComposeComponent(src.getCompose()));
        if (src.hasExpansion())
            tgt.setExpansion(convertValueSetExpansionComponent(src.getExpansion()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ValueSet convertValueSet(org.hl7.fhir.dstu2016may.model.ValueSet src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ValueSet tgt = new org.hl7.fhir.dstu3.model.ValueSet();
        VersionConvertor_14_30.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(Uri14_30.convertUri(src.getUrlElement()));
        if (src.hasIdentifier())
            tgt.addIdentifier(Identifier14_30.convertIdentifier(src.getIdentifier()));
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
        for (org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetContactComponent t : src.getContact()) tgt.addContact(convertValueSetContactComponent(t));
        if (src.hasDate())
            tgt.setDateElement(DateTime14_30.convertDateTime(src.getDateElement()));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu2016may.model.CodeableConcept t : src.getUseContext()) if (VersionConvertor_14_30.isJurisdiction(t))
            tgt.addJurisdiction(CodeableConcept14_30.convertCodeableConcept(t));
        else
            tgt.addUseContext(CodeableConcept14_30.convertCodeableConceptToUsageContext(t));
        if (src.hasImmutable())
            tgt.setImmutableElement(Boolean14_30.convertBoolean(src.getImmutableElement()));
        if (src.hasRequirements())
            tgt.setPurpose(src.getRequirements());
        if (src.hasCopyright())
            tgt.setCopyright(src.getCopyright());
        if (src.hasExtensible())
            tgt.setExtensibleElement(Boolean14_30.convertBoolean(src.getExtensibleElement()));
        if (src.hasCompose())
            tgt.setCompose(convertValueSetComposeComponent(src.getCompose()));
        if (src.hasLockedDate())
            tgt.getCompose().setLockedDate(src.getLockedDate());
        if (src.hasExpansion())
            tgt.setExpansion(convertValueSetExpansionComponent(src.getExpansion()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetComposeComponent convertValueSetComposeComponent(org.hl7.fhir.dstu3.model.ValueSet.ValueSetComposeComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetComposeComponent tgt = new org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetComposeComponent();
        Element14_30.copyElement(src, tgt);
        for (org.hl7.fhir.dstu3.model.ValueSet.ConceptSetComponent t : src.getInclude()) {
            for (org.hl7.fhir.dstu3.model.UriType ti : t.getValueSet()) tgt.addImport(ti.getValue());
            tgt.addInclude(convertConceptSetComponent(t));
        }
        for (org.hl7.fhir.dstu3.model.ValueSet.ConceptSetComponent t : src.getExclude()) tgt.addExclude(convertConceptSetComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ValueSet.ValueSetComposeComponent convertValueSetComposeComponent(org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetComposeComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ValueSet.ValueSetComposeComponent tgt = new org.hl7.fhir.dstu3.model.ValueSet.ValueSetComposeComponent();
        Element14_30.copyElement(src, tgt);
        for (org.hl7.fhir.dstu2016may.model.UriType t : src.getImport()) tgt.addInclude().addValueSet(t.getValue());
        for (org.hl7.fhir.dstu2016may.model.ValueSet.ConceptSetComponent t : src.getInclude()) tgt.addInclude(convertConceptSetComponent(t));
        for (org.hl7.fhir.dstu2016may.model.ValueSet.ConceptSetComponent t : src.getExclude()) tgt.addExclude(convertConceptSetComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ContactDetail convertValueSetContactComponent(org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ContactDetail tgt = new org.hl7.fhir.dstu3.model.ContactDetail();
        Element14_30.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(String14_30.convertString(src.getNameElement()));
        for (org.hl7.fhir.dstu2016may.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(ContactPoint14_30.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetContactComponent convertValueSetContactComponent(org.hl7.fhir.dstu3.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetContactComponent tgt = new org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetContactComponent();
        Element14_30.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(String14_30.convertString(src.getNameElement()));
        for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(ContactPoint14_30.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionComponent convertValueSetExpansionComponent(org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionComponent tgt = new org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionComponent();
        Element14_30.copyElement(src, tgt);
        if (src.hasIdentifierElement())
            tgt.setIdentifierElement(Uri14_30.convertUri(src.getIdentifierElement()));
        if (src.hasTimestampElement())
            tgt.setTimestampElement(DateTime14_30.convertDateTime(src.getTimestampElement()));
        if (src.hasTotal())
            tgt.setTotalElement(Integer14_30.convertInteger(src.getTotalElement()));
        if (src.hasOffset())
            tgt.setOffsetElement(Integer14_30.convertInteger(src.getOffsetElement()));
        for (org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionParameterComponent t : src.getParameter()) tgt.addParameter(convertValueSetExpansionParameterComponent(t));
        for (org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionContainsComponent t : src.getContains()) tgt.addContains(convertValueSetExpansionContainsComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionComponent convertValueSetExpansionComponent(org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionComponent tgt = new org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionComponent();
        Element14_30.copyElement(src, tgt);
        if (src.hasIdentifierElement())
            tgt.setIdentifierElement(Uri14_30.convertUri(src.getIdentifierElement()));
        if (src.hasTimestampElement())
            tgt.setTimestampElement(DateTime14_30.convertDateTime(src.getTimestampElement()));
        if (src.hasTotal())
            tgt.setTotalElement(Integer14_30.convertInteger(src.getTotalElement()));
        if (src.hasOffset())
            tgt.setOffsetElement(Integer14_30.convertInteger(src.getOffsetElement()));
        for (org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionParameterComponent t : src.getParameter()) tgt.addParameter(convertValueSetExpansionParameterComponent(t));
        for (org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionContainsComponent t : src.getContains()) tgt.addContains(convertValueSetExpansionContainsComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionContainsComponent convertValueSetExpansionContainsComponent(org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionContainsComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionContainsComponent tgt = new org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionContainsComponent();
        Element14_30.copyElement(src, tgt);
        if (src.hasSystem())
            tgt.setSystemElement(Uri14_30.convertUri(src.getSystemElement()));
        if (src.hasAbstract())
            tgt.setAbstractElement(Boolean14_30.convertBoolean(src.getAbstractElement()));
        if (src.hasVersion())
            tgt.setVersionElement(String14_30.convertString(src.getVersionElement()));
        if (src.hasCode())
            tgt.setCodeElement(Code14_30.convertCode(src.getCodeElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(String14_30.convertString(src.getDisplayElement()));
        for (org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionContainsComponent t : src.getContains()) tgt.addContains(convertValueSetExpansionContainsComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionContainsComponent convertValueSetExpansionContainsComponent(org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionContainsComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionContainsComponent tgt = new org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionContainsComponent();
        Element14_30.copyElement(src, tgt);
        if (src.hasSystem())
            tgt.setSystemElement(Uri14_30.convertUri(src.getSystemElement()));
        if (src.hasAbstract())
            tgt.setAbstractElement(Boolean14_30.convertBoolean(src.getAbstractElement()));
        if (src.hasVersion())
            tgt.setVersionElement(String14_30.convertString(src.getVersionElement()));
        if (src.hasCode())
            tgt.setCodeElement(Code14_30.convertCode(src.getCodeElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(String14_30.convertString(src.getDisplayElement()));
        for (org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionContainsComponent t : src.getContains()) tgt.addContains(convertValueSetExpansionContainsComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionParameterComponent convertValueSetExpansionParameterComponent(org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionParameterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionParameterComponent tgt = new org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionParameterComponent();
        Element14_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(String14_30.convertString(src.getNameElement()));
        if (src.hasValue())
            tgt.setValue(Type14_30.convertType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionParameterComponent convertValueSetExpansionParameterComponent(org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionParameterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionParameterComponent tgt = new org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionParameterComponent();
        Element14_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(String14_30.convertString(src.getNameElement()));
        if (src.hasValue())
            tgt.setValue(Type14_30.convertType(src.getValue()));
        return tgt;
    }
}