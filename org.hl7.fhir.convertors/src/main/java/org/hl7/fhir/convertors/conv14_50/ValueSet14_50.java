package org.hl7.fhir.convertors.conv14_50;

import org.hl7.fhir.convertors.VersionConvertor_14_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.BooleanType;

public class ValueSet14_50 {

    public static org.hl7.fhir.dstu2016may.model.ValueSet.ConceptReferenceComponent convertConceptReferenceComponent(org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ValueSet.ConceptReferenceComponent tgt = new org.hl7.fhir.dstu2016may.model.ValueSet.ConceptReferenceComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement(VersionConvertor_14_50.convertCode(src.getCodeElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(VersionConvertor_14_50.convertString(src.getDisplayElement()));
        for (org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent t : src.getDesignation()) tgt.addDesignation(convertConceptReferenceDesignationComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent convertConceptReferenceComponent(org.hl7.fhir.dstu2016may.model.ValueSet.ConceptReferenceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement(VersionConvertor_14_50.convertCode(src.getCodeElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(VersionConvertor_14_50.convertString(src.getDisplayElement()));
        for (org.hl7.fhir.dstu2016may.model.ValueSet.ConceptReferenceDesignationComponent t : src.getDesignation()) tgt.addDesignation(convertConceptReferenceDesignationComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent convertConceptReferenceDesignationComponent(org.hl7.fhir.dstu2016may.model.ValueSet.ConceptReferenceDesignationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasLanguage())
            tgt.setLanguageElement(VersionConvertor_14_50.convertCode(src.getLanguageElement()));
        if (src.hasUse())
            tgt.setUse(VersionConvertor_14_50.convertCoding(src.getUse()));
        if (src.hasValueElement())
            tgt.setValueElement(VersionConvertor_14_50.convertString(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ValueSet.ConceptReferenceDesignationComponent convertConceptReferenceDesignationComponent(org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ValueSet.ConceptReferenceDesignationComponent tgt = new org.hl7.fhir.dstu2016may.model.ValueSet.ConceptReferenceDesignationComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasLanguage())
            tgt.setLanguageElement(VersionConvertor_14_50.convertCode(src.getLanguageElement()));
        if (src.hasUse())
            tgt.setUse(VersionConvertor_14_50.convertCoding(src.getUse()));
        if (src.hasValueElement())
            tgt.setValueElement(VersionConvertor_14_50.convertString(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent convertConceptSetComponent(org.hl7.fhir.dstu2016may.model.ValueSet.ConceptSetComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasSystemElement())
            tgt.setSystemElement(VersionConvertor_14_50.convertUri(src.getSystemElement()));
        if (src.hasVersion())
            tgt.setVersionElement(VersionConvertor_14_50.convertString(src.getVersionElement()));
        for (org.hl7.fhir.dstu2016may.model.ValueSet.ConceptReferenceComponent t : src.getConcept()) tgt.addConcept(convertConceptReferenceComponent(t));
        for (org.hl7.fhir.dstu2016may.model.ValueSet.ConceptSetFilterComponent t : src.getFilter()) tgt.addFilter(convertConceptSetFilterComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ValueSet.ConceptSetComponent convertConceptSetComponent(org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ValueSet.ConceptSetComponent tgt = new org.hl7.fhir.dstu2016may.model.ValueSet.ConceptSetComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasSystemElement())
            tgt.setSystemElement(VersionConvertor_14_50.convertUri(src.getSystemElement()));
        if (src.hasVersion())
            tgt.setVersionElement(VersionConvertor_14_50.convertString(src.getVersionElement()));
        for (org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent t : src.getConcept()) tgt.addConcept(convertConceptReferenceComponent(t));
        for (org.hl7.fhir.r5.model.ValueSet.ConceptSetFilterComponent t : src.getFilter()) tgt.addFilter(convertConceptSetFilterComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ValueSet.ConceptSetFilterComponent convertConceptSetFilterComponent(org.hl7.fhir.r5.model.ValueSet.ConceptSetFilterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ValueSet.ConceptSetFilterComponent tgt = new org.hl7.fhir.dstu2016may.model.ValueSet.ConceptSetFilterComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasPropertyElement())
            tgt.setPropertyElement(VersionConvertor_14_50.convertCode(src.getPropertyElement()));
        if (src.hasOp())
            tgt.setOpElement(convertFilterOperator(src.getOpElement()));
        if (src.hasValue())
            tgt.setValue(src.getValue());
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ValueSet.ConceptSetFilterComponent convertConceptSetFilterComponent(org.hl7.fhir.dstu2016may.model.ValueSet.ConceptSetFilterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ValueSet.ConceptSetFilterComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ConceptSetFilterComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasPropertyElement())
            tgt.setPropertyElement(VersionConvertor_14_50.convertCode(src.getPropertyElement()));
        if (src.hasOp())
            tgt.setOpElement(convertFilterOperator(src.getOpElement()));
        if (src.hasValue())
            tgt.setValue(src.getValue());
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FilterOperator> convertFilterOperator(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.ValueSet.FilterOperator> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FilterOperator> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.FilterOperatorEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case EQUAL:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FilterOperator.EQUAL);
                break;
            case ISA:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FilterOperator.ISA);
                break;
            case ISNOTA:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FilterOperator.ISNOTA);
                break;
            case REGEX:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FilterOperator.REGEX);
                break;
            case IN:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FilterOperator.IN);
                break;
            case NOTIN:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FilterOperator.NOTIN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FilterOperator.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.ValueSet.FilterOperator> convertFilterOperator(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FilterOperator> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.ValueSet.FilterOperator> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.ValueSet.FilterOperatorEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
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

    public static org.hl7.fhir.r5.model.ValueSet convertValueSet(org.hl7.fhir.dstu2016may.model.ValueSet src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ValueSet tgt = new org.hl7.fhir.r5.model.ValueSet();
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
        for (org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetContactComponent t : src.getContact()) tgt.addContact(convertValueSetContactComponent(t));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_14_50.convertDateTime(src.getDateElement()));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu2016may.model.CodeableConcept t : src.getUseContext()) if (VersionConvertor_14_50.isJurisdiction(t))
            tgt.addJurisdiction(VersionConvertor_14_50.convertCodeableConcept(t));
        else
            tgt.addUseContext(VersionConvertor_14_50.convertCodeableConceptToUsageContext(t));
        if (src.hasImmutable())
            tgt.setImmutableElement(VersionConvertor_14_50.convertBoolean(src.getImmutableElement()));
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

    public static org.hl7.fhir.dstu2016may.model.ValueSet convertValueSet(org.hl7.fhir.r5.model.ValueSet src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ValueSet tgt = new org.hl7.fhir.dstu2016may.model.ValueSet();
        VersionConvertor_14_50.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(VersionConvertor_14_50.convertUri(src.getUrlElement()));
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.setIdentifier(VersionConvertor_14_50.convertIdentifier(t));
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
        for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact()) tgt.addContact(convertValueSetContactComponent(t));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_14_50.convertDateTime(src.getDateElement()));
        if (src.getCompose().hasLockedDate())
            tgt.setLockedDate(src.getCompose().getLockedDate());
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext()) if (t.hasValueCodeableConcept())
            tgt.addUseContext(VersionConvertor_14_50.convertCodeableConcept(t.getValueCodeableConcept()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction()) tgt.addUseContext(VersionConvertor_14_50.convertCodeableConcept(t));
        if (src.hasImmutable())
            tgt.setImmutableElement(VersionConvertor_14_50.convertBoolean(src.getImmutableElement()));
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

    public static org.hl7.fhir.r5.model.ValueSet.ValueSetComposeComponent convertValueSetComposeComponent(org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetComposeComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ValueSet.ValueSetComposeComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ValueSetComposeComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        for (org.hl7.fhir.dstu2016may.model.UriType t : src.getImport()) tgt.addInclude().addValueSet(t.getValue());
        for (org.hl7.fhir.dstu2016may.model.ValueSet.ConceptSetComponent t : src.getInclude()) tgt.addInclude(convertConceptSetComponent(t));
        for (org.hl7.fhir.dstu2016may.model.ValueSet.ConceptSetComponent t : src.getExclude()) tgt.addExclude(convertConceptSetComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetComposeComponent convertValueSetComposeComponent(org.hl7.fhir.r5.model.ValueSet.ValueSetComposeComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetComposeComponent tgt = new org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetComposeComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        for (org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent t : src.getInclude()) {
            for (org.hl7.fhir.r5.model.UriType ti : t.getValueSet()) tgt.addImport(ti.getValue());
            tgt.addInclude(convertConceptSetComponent(t));
        }
        for (org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent t : src.getExclude()) tgt.addExclude(convertConceptSetComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetContactComponent convertValueSetContactComponent(org.hl7.fhir.r5.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetContactComponent tgt = new org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetContactComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_14_50.convertString(src.getNameElement()));
        for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_14_50.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ContactDetail convertValueSetContactComponent(org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ContactDetail tgt = new org.hl7.fhir.r5.model.ContactDetail();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_14_50.convertString(src.getNameElement()));
        for (org.hl7.fhir.dstu2016may.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_14_50.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionComponent convertValueSetExpansionComponent(org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasIdentifierElement())
            tgt.setIdentifierElement(VersionConvertor_14_50.convertUri(src.getIdentifierElement()));
        if (src.hasTimestampElement())
            tgt.setTimestampElement(VersionConvertor_14_50.convertDateTime(src.getTimestampElement()));
        if (src.hasTotal())
            tgt.setTotalElement(VersionConvertor_14_50.convertInteger(src.getTotalElement()));
        if (src.hasOffset())
            tgt.setOffsetElement(VersionConvertor_14_50.convertInteger(src.getOffsetElement()));
        for (org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionParameterComponent t : src.getParameter()) tgt.addParameter(convertValueSetExpansionParameterComponent(t));
        for (org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionContainsComponent t : src.getContains()) tgt.addContains(convertValueSetExpansionContainsComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionComponent convertValueSetExpansionComponent(org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionComponent tgt = new org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasIdentifierElement())
            tgt.setIdentifierElement(VersionConvertor_14_50.convertUri(src.getIdentifierElement()));
        if (src.hasTimestampElement())
            tgt.setTimestampElement(VersionConvertor_14_50.convertDateTime(src.getTimestampElement()));
        if (src.hasTotal())
            tgt.setTotalElement(VersionConvertor_14_50.convertInteger(src.getTotalElement()));
        if (src.hasOffset())
            tgt.setOffsetElement(VersionConvertor_14_50.convertInteger(src.getOffsetElement()));
        for (org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionParameterComponent t : src.getParameter()) tgt.addParameter(convertValueSetExpansionParameterComponent(t));
        for (org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent t : src.getContains()) tgt.addContains(convertValueSetExpansionContainsComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent convertValueSetExpansionContainsComponent(org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionContainsComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasSystem())
            tgt.setSystemElement(VersionConvertor_14_50.convertUri(src.getSystemElement()));
        if (src.hasAbstract())
            tgt.setAbstractElement(VersionConvertor_14_50.convertBoolean(src.getAbstractElement()));
        if (src.hasVersion())
            tgt.setVersionElement(VersionConvertor_14_50.convertString(src.getVersionElement()));
        if (src.hasCode())
            tgt.setCodeElement(VersionConvertor_14_50.convertCode(src.getCodeElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(VersionConvertor_14_50.convertString(src.getDisplayElement()));
        for (org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionContainsComponent t : src.getContains()) tgt.addContains(convertValueSetExpansionContainsComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionContainsComponent convertValueSetExpansionContainsComponent(org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionContainsComponent tgt = new org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionContainsComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasSystem())
            tgt.setSystemElement(VersionConvertor_14_50.convertUri(src.getSystemElement()));
        if (src.hasAbstract())
            tgt.setAbstractElement(VersionConvertor_14_50.convertBoolean(src.getAbstractElement()));
        if (src.hasVersion())
            tgt.setVersionElement(VersionConvertor_14_50.convertString(src.getVersionElement()));
        if (src.hasCode())
            tgt.setCodeElement(VersionConvertor_14_50.convertCode(src.getCodeElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(VersionConvertor_14_50.convertString(src.getDisplayElement()));
        for (org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent t : src.getContains()) tgt.addContains(convertValueSetExpansionContainsComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionParameterComponent convertValueSetExpansionParameterComponent(org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionParameterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionParameterComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionParameterComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_14_50.convertString(src.getNameElement()));
        if (src.hasValue())
            tgt.setValue(VersionConvertor_14_50.convertType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionParameterComponent convertValueSetExpansionParameterComponent(org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionParameterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionParameterComponent tgt = new org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionParameterComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_14_50.convertString(src.getNameElement()));
        if (src.hasValue())
            tgt.setValue(VersionConvertor_14_50.convertType(src.getValue()));
        return tgt;
    }
}