package org.hl7.fhir.convertors.conv14_40.resources14_40;

import org.hl7.fhir.convertors.conv14_40.VersionConvertor_14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.Element14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.Type14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.complextypes14_40.CodeableConcept14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.complextypes14_40.Coding14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.complextypes14_40.ContactPoint14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.complextypes14_40.Identifier14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.*;
import org.hl7.fhir.exceptions.FHIRException;  import org.hl7.fhir.convertors.context.ConversionContext14_40;
import org.hl7.fhir.r4.model.BooleanType;

public class ValueSet14_40 {

    public static org.hl7.fhir.r4.model.ValueSet.ConceptReferenceComponent convertConceptReferenceComponent(org.hl7.fhir.dstu2016may.model.ValueSet.ConceptReferenceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ValueSet.ConceptReferenceComponent tgt = new org.hl7.fhir.r4.model.ValueSet.ConceptReferenceComponent();
        ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement(Code14_40.convertCode(src.getCodeElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(String14_40.convertString(src.getDisplayElement()));
        for (org.hl7.fhir.dstu2016may.model.ValueSet.ConceptReferenceDesignationComponent t : src.getDesignation()) tgt.addDesignation(convertConceptReferenceDesignationComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ValueSet.ConceptReferenceComponent convertConceptReferenceComponent(org.hl7.fhir.r4.model.ValueSet.ConceptReferenceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ValueSet.ConceptReferenceComponent tgt = new org.hl7.fhir.dstu2016may.model.ValueSet.ConceptReferenceComponent();
        ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement(Code14_40.convertCode(src.getCodeElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(String14_40.convertString(src.getDisplayElement()));
        for (org.hl7.fhir.r4.model.ValueSet.ConceptReferenceDesignationComponent t : src.getDesignation()) tgt.addDesignation(convertConceptReferenceDesignationComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ValueSet.ConceptReferenceDesignationComponent convertConceptReferenceDesignationComponent(org.hl7.fhir.r4.model.ValueSet.ConceptReferenceDesignationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ValueSet.ConceptReferenceDesignationComponent tgt = new org.hl7.fhir.dstu2016may.model.ValueSet.ConceptReferenceDesignationComponent();
        ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
        if (src.hasLanguage())
            tgt.setLanguageElement(Code14_40.convertCode(src.getLanguageElement()));
        if (src.hasUse())
            tgt.setUse(Coding14_40.convertCoding(src.getUse()));
        if (src.hasValueElement())
            tgt.setValueElement(String14_40.convertString(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ValueSet.ConceptReferenceDesignationComponent convertConceptReferenceDesignationComponent(org.hl7.fhir.dstu2016may.model.ValueSet.ConceptReferenceDesignationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ValueSet.ConceptReferenceDesignationComponent tgt = new org.hl7.fhir.r4.model.ValueSet.ConceptReferenceDesignationComponent();
        ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
        if (src.hasLanguage())
            tgt.setLanguageElement(Code14_40.convertCode(src.getLanguageElement()));
        if (src.hasUse())
            tgt.setUse(Coding14_40.convertCoding(src.getUse()));
        if (src.hasValueElement())
            tgt.setValueElement(String14_40.convertString(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ValueSet.ConceptSetComponent convertConceptSetComponent(org.hl7.fhir.dstu2016may.model.ValueSet.ConceptSetComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ValueSet.ConceptSetComponent tgt = new org.hl7.fhir.r4.model.ValueSet.ConceptSetComponent();
        ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
        if (src.hasSystemElement())
            tgt.setSystemElement(Uri14_40.convertUri(src.getSystemElement()));
        if (src.hasVersion())
            tgt.setVersionElement(String14_40.convertString(src.getVersionElement()));
        for (org.hl7.fhir.dstu2016may.model.ValueSet.ConceptReferenceComponent t : src.getConcept()) tgt.addConcept(convertConceptReferenceComponent(t));
        for (org.hl7.fhir.dstu2016may.model.ValueSet.ConceptSetFilterComponent t : src.getFilter()) tgt.addFilter(convertConceptSetFilterComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ValueSet.ConceptSetComponent convertConceptSetComponent(org.hl7.fhir.r4.model.ValueSet.ConceptSetComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ValueSet.ConceptSetComponent tgt = new org.hl7.fhir.dstu2016may.model.ValueSet.ConceptSetComponent();
        ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
        if (src.hasSystemElement())
            tgt.setSystemElement(Uri14_40.convertUri(src.getSystemElement()));
        if (src.hasVersion())
            tgt.setVersionElement(String14_40.convertString(src.getVersionElement()));
        for (org.hl7.fhir.r4.model.ValueSet.ConceptReferenceComponent t : src.getConcept()) tgt.addConcept(convertConceptReferenceComponent(t));
        for (org.hl7.fhir.r4.model.ValueSet.ConceptSetFilterComponent t : src.getFilter()) tgt.addFilter(convertConceptSetFilterComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ValueSet.ConceptSetFilterComponent convertConceptSetFilterComponent(org.hl7.fhir.dstu2016may.model.ValueSet.ConceptSetFilterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ValueSet.ConceptSetFilterComponent tgt = new org.hl7.fhir.r4.model.ValueSet.ConceptSetFilterComponent();
        ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
        if (src.hasPropertyElement())
            tgt.setPropertyElement(Code14_40.convertCode(src.getPropertyElement()));
        if (src.hasOp())
            tgt.setOpElement(convertFilterOperator(src.getOpElement()));
        if (src.hasValue())
            tgt.setValue(src.getValue());
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ValueSet.ConceptSetFilterComponent convertConceptSetFilterComponent(org.hl7.fhir.r4.model.ValueSet.ConceptSetFilterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ValueSet.ConceptSetFilterComponent tgt = new org.hl7.fhir.dstu2016may.model.ValueSet.ConceptSetFilterComponent();
        ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
        if (src.hasPropertyElement())
            tgt.setPropertyElement(Code14_40.convertCode(src.getPropertyElement()));
        if (src.hasOp())
            tgt.setOpElement(convertFilterOperator(src.getOpElement()));
        if (src.hasValue())
            tgt.setValue(src.getValue());
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ValueSet.FilterOperator> convertFilterOperator(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.ValueSet.FilterOperator> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ValueSet.FilterOperator> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ValueSet.FilterOperatorEnumFactory());
        ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
        switch(src.getValue()) {
            case EQUAL:
                tgt.setValue(org.hl7.fhir.r4.model.ValueSet.FilterOperator.EQUAL);
                break;
            case ISA:
                tgt.setValue(org.hl7.fhir.r4.model.ValueSet.FilterOperator.ISA);
                break;
            case ISNOTA:
                tgt.setValue(org.hl7.fhir.r4.model.ValueSet.FilterOperator.ISNOTA);
                break;
            case REGEX:
                tgt.setValue(org.hl7.fhir.r4.model.ValueSet.FilterOperator.REGEX);
                break;
            case IN:
                tgt.setValue(org.hl7.fhir.r4.model.ValueSet.FilterOperator.IN);
                break;
            case NOTIN:
                tgt.setValue(org.hl7.fhir.r4.model.ValueSet.FilterOperator.NOTIN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.ValueSet.FilterOperator.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.ValueSet.FilterOperator> convertFilterOperator(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ValueSet.FilterOperator> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.ValueSet.FilterOperator> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.ValueSet.FilterOperatorEnumFactory());
        ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
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

    public static org.hl7.fhir.r4.model.ValueSet convertValueSet(org.hl7.fhir.dstu2016may.model.ValueSet src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ValueSet tgt = new org.hl7.fhir.r4.model.ValueSet();
        ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyDomainResource(src, tgt);
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
        for (org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetContactComponent t : src.getContact()) tgt.addContact(convertValueSetContactComponent(t));
        if (src.hasDate())
            tgt.setDateElement(DateTime14_40.convertDateTime(src.getDateElement()));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu2016may.model.CodeableConcept t : src.getUseContext()) if (VersionConvertor_14_40.isJurisdiction(t))
            tgt.addJurisdiction(CodeableConcept14_40.convertCodeableConcept(t));
        else
            tgt.addUseContext(CodeableConcept14_40.convertCodeableConceptToUsageContext(t));
        if (src.hasImmutable())
            tgt.setImmutableElement(Boolean14_40.convertBoolean(src.getImmutableElement()));
        if (src.hasRequirements())
            tgt.setPurpose(src.getRequirements());
        if (src.hasCopyright())
            tgt.setCopyright(src.getCopyright());
        if (src.hasExtensible())
            tgt.addExtension("http://hl7.org/fhir/StructureDefinition/valueset-extensible", new BooleanType(src.getExtensible()));
        if (src.hasCompose())
            tgt.setCompose(convertValueSetComposeComponent(src.getCompose()));
        if (src.hasLockedDate())
            tgt.getCompose().setLockedDate(src.getLockedDate());
        if (src.hasExpansion())
            tgt.setExpansion(convertValueSetExpansionComponent(src.getExpansion()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ValueSet convertValueSet(org.hl7.fhir.r4.model.ValueSet src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ValueSet tgt = new org.hl7.fhir.dstu2016may.model.ValueSet();
        ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(Uri14_40.convertUri(src.getUrlElement()));
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.setIdentifier(Identifier14_40.convertIdentifier(t));
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
        for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact()) tgt.addContact(convertValueSetContactComponent(t));
        if (src.hasDate())
            tgt.setDateElement(DateTime14_40.convertDateTime(src.getDateElement()));
        if (src.getCompose().hasLockedDate())
            tgt.setLockedDate(src.getCompose().getLockedDate());
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext()) if (t.hasValueCodeableConcept())
            tgt.addUseContext(CodeableConcept14_40.convertCodeableConcept(t.getValueCodeableConcept()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction()) tgt.addUseContext(CodeableConcept14_40.convertCodeableConcept(t));
        if (src.hasImmutable())
            tgt.setImmutableElement(Boolean14_40.convertBoolean(src.getImmutableElement()));
        if (src.hasPurpose())
            tgt.setRequirements(src.getPurpose());
        if (src.hasCopyright())
            tgt.setCopyright(src.getCopyright());
        if (src.hasExtension("http://hl7.org/fhir/StructureDefinition/valueset-extensible"))
            tgt.setExtensible(((BooleanType) src.getExtensionByUrl("http://hl7.org/fhir/StructureDefinition/valueset-extensible").getValue()).booleanValue());
        if (src.hasCompose())
            tgt.setCompose(convertValueSetComposeComponent(src.getCompose()));
        if (src.hasExpansion())
            tgt.setExpansion(convertValueSetExpansionComponent(src.getExpansion()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ValueSet.ValueSetComposeComponent convertValueSetComposeComponent(org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetComposeComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ValueSet.ValueSetComposeComponent tgt = new org.hl7.fhir.r4.model.ValueSet.ValueSetComposeComponent();
        ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
        for (org.hl7.fhir.dstu2016may.model.UriType t : src.getImport()) tgt.addInclude().addValueSet(t.getValue());
        for (org.hl7.fhir.dstu2016may.model.ValueSet.ConceptSetComponent t : src.getInclude()) tgt.addInclude(convertConceptSetComponent(t));
        for (org.hl7.fhir.dstu2016may.model.ValueSet.ConceptSetComponent t : src.getExclude()) tgt.addExclude(convertConceptSetComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetComposeComponent convertValueSetComposeComponent(org.hl7.fhir.r4.model.ValueSet.ValueSetComposeComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetComposeComponent tgt = new org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetComposeComponent();
        ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.ValueSet.ConceptSetComponent t : src.getInclude()) {
            for (org.hl7.fhir.r4.model.UriType ti : t.getValueSet()) tgt.addImport(ti.getValue());
            tgt.addInclude(convertConceptSetComponent(t));
        }
        for (org.hl7.fhir.r4.model.ValueSet.ConceptSetComponent t : src.getExclude()) tgt.addExclude(convertConceptSetComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetContactComponent convertValueSetContactComponent(org.hl7.fhir.r4.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetContactComponent tgt = new org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetContactComponent();
        ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(String14_40.convertString(src.getNameElement()));
        for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(ContactPoint14_40.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ContactDetail convertValueSetContactComponent(org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ContactDetail tgt = new org.hl7.fhir.r4.model.ContactDetail();
        ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(String14_40.convertString(src.getNameElement()));
        for (org.hl7.fhir.dstu2016may.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(ContactPoint14_40.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionComponent convertValueSetExpansionComponent(org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionComponent tgt = new org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionComponent();
        ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
        if (src.hasIdentifierElement())
            tgt.setIdentifierElement(Uri14_40.convertUri(src.getIdentifierElement()));
        if (src.hasTimestampElement())
            tgt.setTimestampElement(DateTime14_40.convertDateTime(src.getTimestampElement()));
        if (src.hasTotal())
            tgt.setTotalElement(Integer14_40.convertInteger(src.getTotalElement()));
        if (src.hasOffset())
            tgt.setOffsetElement(Integer14_40.convertInteger(src.getOffsetElement()));
        for (org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionParameterComponent t : src.getParameter()) tgt.addParameter(convertValueSetExpansionParameterComponent(t));
        for (org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionContainsComponent t : src.getContains()) tgt.addContains(convertValueSetExpansionContainsComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionComponent convertValueSetExpansionComponent(org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionComponent tgt = new org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionComponent();
        ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
        if (src.hasIdentifierElement())
            tgt.setIdentifierElement(Uri14_40.convertUri(src.getIdentifierElement()));
        if (src.hasTimestampElement())
            tgt.setTimestampElement(DateTime14_40.convertDateTime(src.getTimestampElement()));
        if (src.hasTotal())
            tgt.setTotalElement(Integer14_40.convertInteger(src.getTotalElement()));
        if (src.hasOffset())
            tgt.setOffsetElement(Integer14_40.convertInteger(src.getOffsetElement()));
        for (org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionParameterComponent t : src.getParameter()) tgt.addParameter(convertValueSetExpansionParameterComponent(t));
        for (org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionContainsComponent t : src.getContains()) tgt.addContains(convertValueSetExpansionContainsComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionContainsComponent convertValueSetExpansionContainsComponent(org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionContainsComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionContainsComponent tgt = new org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionContainsComponent();
        ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
        if (src.hasSystem())
            tgt.setSystemElement(Uri14_40.convertUri(src.getSystemElement()));
        if (src.hasAbstract())
            tgt.setAbstractElement(Boolean14_40.convertBoolean(src.getAbstractElement()));
        if (src.hasVersion())
            tgt.setVersionElement(String14_40.convertString(src.getVersionElement()));
        if (src.hasCode())
            tgt.setCodeElement(Code14_40.convertCode(src.getCodeElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(String14_40.convertString(src.getDisplayElement()));
        for (org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionContainsComponent t : src.getContains()) tgt.addContains(convertValueSetExpansionContainsComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionContainsComponent convertValueSetExpansionContainsComponent(org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionContainsComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionContainsComponent tgt = new org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionContainsComponent();
        ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
        if (src.hasSystem())
            tgt.setSystemElement(Uri14_40.convertUri(src.getSystemElement()));
        if (src.hasAbstract())
            tgt.setAbstractElement(Boolean14_40.convertBoolean(src.getAbstractElement()));
        if (src.hasVersion())
            tgt.setVersionElement(String14_40.convertString(src.getVersionElement()));
        if (src.hasCode())
            tgt.setCodeElement(Code14_40.convertCode(src.getCodeElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(String14_40.convertString(src.getDisplayElement()));
        for (org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionContainsComponent t : src.getContains()) tgt.addContains(convertValueSetExpansionContainsComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionParameterComponent convertValueSetExpansionParameterComponent(org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionParameterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionParameterComponent tgt = new org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionParameterComponent();
        ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(String14_40.convertString(src.getNameElement()));
        if (src.hasValue())
            tgt.setValue(ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().convertType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionParameterComponent convertValueSetExpansionParameterComponent(org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionParameterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionParameterComponent tgt = new org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionParameterComponent();
        ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(String14_40.convertString(src.getNameElement()));
        if (src.hasValue())
            tgt.setValue(ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().convertType(src.getValue()));
        return tgt;
    }
}