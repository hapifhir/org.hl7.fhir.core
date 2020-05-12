package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.BooleanType;

public class ValueSet30_50 {

    public static org.hl7.fhir.dstu3.model.ValueSet.ConceptReferenceComponent convertConceptReferenceComponent(org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ValueSet.ConceptReferenceComponent tgt = new org.hl7.fhir.dstu3.model.ValueSet.ConceptReferenceComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCodeElement(VersionConvertor_30_50.convertCode(src.getCodeElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(VersionConvertor_30_50.convertString(src.getDisplayElement()));
        for (org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent t : src.getDesignation()) tgt.addDesignation(convertConceptReferenceDesignationComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent convertConceptReferenceComponent(org.hl7.fhir.dstu3.model.ValueSet.ConceptReferenceComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCodeElement(VersionConvertor_30_50.convertCode(src.getCodeElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(VersionConvertor_30_50.convertString(src.getDisplayElement()));
        for (org.hl7.fhir.dstu3.model.ValueSet.ConceptReferenceDesignationComponent t : src.getDesignation()) tgt.addDesignation(convertConceptReferenceDesignationComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent convertConceptReferenceDesignationComponent(org.hl7.fhir.dstu3.model.ValueSet.ConceptReferenceDesignationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasLanguage())
            tgt.setLanguageElement(VersionConvertor_30_50.convertCode(src.getLanguageElement()));
        if (src.hasUse())
            tgt.setUse(VersionConvertor_30_50.convertCoding(src.getUse()));
        if (src.hasValue())
            tgt.setValueElement(VersionConvertor_30_50.convertString(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ValueSet.ConceptReferenceDesignationComponent convertConceptReferenceDesignationComponent(org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ValueSet.ConceptReferenceDesignationComponent tgt = new org.hl7.fhir.dstu3.model.ValueSet.ConceptReferenceDesignationComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasLanguage())
            tgt.setLanguageElement(VersionConvertor_30_50.convertCode(src.getLanguageElement()));
        if (src.hasUse())
            tgt.setUse(VersionConvertor_30_50.convertCoding(src.getUse()));
        if (src.hasValue())
            tgt.setValueElement(VersionConvertor_30_50.convertString(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent convertConceptSetComponent(org.hl7.fhir.dstu3.model.ValueSet.ConceptSetComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasSystem())
            tgt.setSystemElement(VersionConvertor_30_50.convertUri(src.getSystemElement()));
        if (src.hasVersion())
            tgt.setVersionElement(VersionConvertor_30_50.convertString(src.getVersionElement()));
        for (org.hl7.fhir.dstu3.model.ValueSet.ConceptReferenceComponent t : src.getConcept()) tgt.addConcept(convertConceptReferenceComponent(t));
        for (org.hl7.fhir.dstu3.model.ValueSet.ConceptSetFilterComponent t : src.getFilter()) tgt.addFilter(convertConceptSetFilterComponent(t));
        for (org.hl7.fhir.dstu3.model.UriType t : src.getValueSet()) tgt.addValueSet(t.getValue());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ValueSet.ConceptSetComponent convertConceptSetComponent(org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ValueSet.ConceptSetComponent tgt = new org.hl7.fhir.dstu3.model.ValueSet.ConceptSetComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasSystem())
            tgt.setSystemElement(VersionConvertor_30_50.convertUri(src.getSystemElement()));
        if (src.hasVersion())
            tgt.setVersionElement(VersionConvertor_30_50.convertString(src.getVersionElement()));
        for (org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent t : src.getConcept()) tgt.addConcept(convertConceptReferenceComponent(t));
        for (org.hl7.fhir.r5.model.ValueSet.ConceptSetFilterComponent t : src.getFilter()) tgt.addFilter(convertConceptSetFilterComponent(t));
        for (org.hl7.fhir.r5.model.UriType t : src.getValueSet()) tgt.addValueSet(t.getValue());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ValueSet.ConceptSetFilterComponent convertConceptSetFilterComponent(org.hl7.fhir.r5.model.ValueSet.ConceptSetFilterComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ValueSet.ConceptSetFilterComponent tgt = new org.hl7.fhir.dstu3.model.ValueSet.ConceptSetFilterComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasProperty())
            tgt.setPropertyElement(VersionConvertor_30_50.convertCode(src.getPropertyElement()));
        if (src.hasOp())
            tgt.setOpElement(convertFilterOperator2(src.getOpElement()));
        if (src.hasValue())
            tgt.setValue(src.getValue());
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ValueSet.ConceptSetFilterComponent convertConceptSetFilterComponent(org.hl7.fhir.dstu3.model.ValueSet.ConceptSetFilterComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ValueSet.ConceptSetFilterComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ConceptSetFilterComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasProperty())
            tgt.setPropertyElement(VersionConvertor_30_50.convertCode(src.getPropertyElement()));
        if (src.hasOp())
            tgt.setOpElement(VersionConvertor_30_50.convertFilterOperator(src.getOpElement()));
        if (src.hasValue())
            tgt.setValue(src.getValue());
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ValueSet.FilterOperator> convertFilterOperator2(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FilterOperator> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ValueSet.FilterOperator> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.ValueSet.FilterOperatorEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case EQUAL:
                tgt.setValue(org.hl7.fhir.dstu3.model.ValueSet.FilterOperator.EQUAL);
                break;
            case ISA:
                tgt.setValue(org.hl7.fhir.dstu3.model.ValueSet.FilterOperator.ISA);
                break;
            case DESCENDENTOF:
                tgt.setValue(org.hl7.fhir.dstu3.model.ValueSet.FilterOperator.DESCENDENTOF);
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
            case GENERALIZES:
                tgt.setValue(org.hl7.fhir.dstu3.model.ValueSet.FilterOperator.GENERALIZES);
                break;
            case EXISTS:
                tgt.setValue(org.hl7.fhir.dstu3.model.ValueSet.FilterOperator.EXISTS);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.ValueSet.FilterOperator.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ValueSet convertValueSet(org.hl7.fhir.dstu3.model.ValueSet src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ValueSet tgt = new org.hl7.fhir.r5.model.ValueSet();
        VersionConvertor_30_50.copyDomainResource(src, tgt, "http://hl7.org/fhir/StructureDefinition/valueset-extensible");
        if (src.hasUrl())
            tgt.setUrlElement(VersionConvertor_30_50.convertUri(src.getUrlElement()));
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        if (src.hasVersion())
            tgt.setVersionElement(VersionConvertor_30_50.convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_50.convertString(src.getNameElement()));
        if (src.hasTitle())
            tgt.setTitleElement(VersionConvertor_30_50.convertString(src.getTitleElement()));
        if (src.hasStatus())
            tgt.setStatusElement(VersionConvertor_30_50.convertPublicationStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(VersionConvertor_30_50.convertBoolean(src.getExperimentalElement()));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_30_50.convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(VersionConvertor_30_50.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(VersionConvertor_30_50.convertContactDetail(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_30_50.convertMarkdown(src.getDescriptionElement()));
        for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_50.convertUsageContext(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_50.convertCodeableConcept(t));
        if (src.hasImmutable())
            tgt.setImmutableElement(VersionConvertor_30_50.convertBoolean(src.getImmutableElement()));
        if (src.hasPurpose())
            tgt.setPurposeElement(VersionConvertor_30_50.convertMarkdown(src.getPurposeElement()));
        if (src.hasCopyright())
            tgt.setCopyrightElement(VersionConvertor_30_50.convertMarkdown(src.getCopyrightElement()));
        if (src.hasExtensible())
            tgt.addExtension("http://hl7.org/fhir/StructureDefinition/valueset-extensible", new BooleanType(src.getExtensible()));
        if (src.hasCompose())
            tgt.setCompose(convertValueSetComposeComponent(src.getCompose()));
        if (src.hasExpansion())
            tgt.setExpansion(convertValueSetExpansionComponent(src.getExpansion()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ValueSet convertValueSet(org.hl7.fhir.r5.model.ValueSet src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ValueSet tgt = new org.hl7.fhir.dstu3.model.ValueSet();
        VersionConvertor_30_50.copyDomainResource(src, tgt, "http://hl7.org/fhir/StructureDefinition/valueset-extensible");
        if (src.hasUrl())
            tgt.setUrlElement(VersionConvertor_30_50.convertUri(src.getUrlElement()));
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        if (src.hasVersion())
            tgt.setVersionElement(VersionConvertor_30_50.convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_50.convertString(src.getNameElement()));
        if (src.hasTitle())
            tgt.setTitleElement(VersionConvertor_30_50.convertString(src.getTitleElement()));
        if (src.hasStatus())
            tgt.setStatusElement(VersionConvertor_30_50.convertPublicationStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(VersionConvertor_30_50.convertBoolean(src.getExperimentalElement()));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_30_50.convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(VersionConvertor_30_50.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact()) tgt.addContact(VersionConvertor_30_50.convertContactDetail(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_30_50.convertMarkdown(src.getDescriptionElement()));
        for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_50.convertUsageContext(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_50.convertCodeableConcept(t));
        if (src.hasImmutable())
            tgt.setImmutableElement(VersionConvertor_30_50.convertBoolean(src.getImmutableElement()));
        if (src.hasPurpose())
            tgt.setPurposeElement(VersionConvertor_30_50.convertMarkdown(src.getPurposeElement()));
        if (src.hasCopyright())
            tgt.setCopyrightElement(VersionConvertor_30_50.convertMarkdown(src.getCopyrightElement()));
        if (src.hasExtension("http://hl7.org/fhir/StructureDefinition/valueset-extensible"))
            tgt.setExtensible(((BooleanType) src.getExtensionByUrl("http://hl7.org/fhir/StructureDefinition/valueset-extensible").getValue()).booleanValue());
        if (src.hasCompose())
            tgt.setCompose(convertValueSetComposeComponent(src.getCompose()));
        if (src.hasExpansion())
            tgt.setExpansion(convertValueSetExpansionComponent(src.getExpansion()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ValueSet.ValueSetComposeComponent convertValueSetComposeComponent(org.hl7.fhir.dstu3.model.ValueSet.ValueSetComposeComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ValueSet.ValueSetComposeComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ValueSetComposeComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasLockedDate())
            tgt.setLockedDateElement(VersionConvertor_30_50.convertDate(src.getLockedDateElement()));
        if (src.hasInactive())
            tgt.setInactiveElement(VersionConvertor_30_50.convertBoolean(src.getInactiveElement()));
        for (org.hl7.fhir.dstu3.model.ValueSet.ConceptSetComponent t : src.getInclude()) tgt.addInclude(convertConceptSetComponent(t));
        for (org.hl7.fhir.dstu3.model.ValueSet.ConceptSetComponent t : src.getExclude()) tgt.addExclude(convertConceptSetComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ValueSet.ValueSetComposeComponent convertValueSetComposeComponent(org.hl7.fhir.r5.model.ValueSet.ValueSetComposeComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ValueSet.ValueSetComposeComponent tgt = new org.hl7.fhir.dstu3.model.ValueSet.ValueSetComposeComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasLockedDate())
            tgt.setLockedDateElement(VersionConvertor_30_50.convertDate(src.getLockedDateElement()));
        if (src.hasInactive())
            tgt.setInactiveElement(VersionConvertor_30_50.convertBoolean(src.getInactiveElement()));
        for (org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent t : src.getInclude()) tgt.addInclude(convertConceptSetComponent(t));
        for (org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent t : src.getExclude()) tgt.addExclude(convertConceptSetComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionComponent convertValueSetExpansionComponent(org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifierElement(VersionConvertor_30_50.convertUri(src.getIdentifierElement()));
        if (src.hasTimestamp())
            tgt.setTimestampElement(VersionConvertor_30_50.convertDateTime(src.getTimestampElement()));
        if (src.hasTotal())
            tgt.setTotalElement(VersionConvertor_30_50.convertInteger(src.getTotalElement()));
        if (src.hasOffset())
            tgt.setOffsetElement(VersionConvertor_30_50.convertInteger(src.getOffsetElement()));
        for (org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionParameterComponent t : src.getParameter()) tgt.addParameter(convertValueSetExpansionParameterComponent(t));
        for (org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionContainsComponent t : src.getContains()) tgt.addContains(convertValueSetExpansionContainsComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionComponent convertValueSetExpansionComponent(org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionComponent tgt = new org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifierElement(VersionConvertor_30_50.convertUri(src.getIdentifierElement()));
        if (src.hasTimestamp())
            tgt.setTimestampElement(VersionConvertor_30_50.convertDateTime(src.getTimestampElement()));
        if (src.hasTotal())
            tgt.setTotalElement(VersionConvertor_30_50.convertInteger(src.getTotalElement()));
        if (src.hasOffset())
            tgt.setOffsetElement(VersionConvertor_30_50.convertInteger(src.getOffsetElement()));
        for (org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionParameterComponent t : src.getParameter()) tgt.addParameter(convertValueSetExpansionParameterComponent(t));
        for (org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent t : src.getContains()) tgt.addContains(convertValueSetExpansionContainsComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent convertValueSetExpansionContainsComponent(org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionContainsComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasSystem())
            tgt.setSystemElement(VersionConvertor_30_50.convertUri(src.getSystemElement()));
        if (src.hasAbstract())
            tgt.setAbstractElement(VersionConvertor_30_50.convertBoolean(src.getAbstractElement()));
        if (src.hasInactive())
            tgt.setInactiveElement(VersionConvertor_30_50.convertBoolean(src.getInactiveElement()));
        if (src.hasVersion())
            tgt.setVersionElement(VersionConvertor_30_50.convertString(src.getVersionElement()));
        if (src.hasCode())
            tgt.setCodeElement(VersionConvertor_30_50.convertCode(src.getCodeElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(VersionConvertor_30_50.convertString(src.getDisplayElement()));
        for (org.hl7.fhir.dstu3.model.ValueSet.ConceptReferenceDesignationComponent t : src.getDesignation()) tgt.addDesignation(convertConceptReferenceDesignationComponent(t));
        for (org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionContainsComponent t : src.getContains()) tgt.addContains(convertValueSetExpansionContainsComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionContainsComponent convertValueSetExpansionContainsComponent(org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionContainsComponent tgt = new org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionContainsComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasSystem())
            tgt.setSystemElement(VersionConvertor_30_50.convertUri(src.getSystemElement()));
        if (src.hasAbstract())
            tgt.setAbstractElement(VersionConvertor_30_50.convertBoolean(src.getAbstractElement()));
        if (src.hasInactive())
            tgt.setInactiveElement(VersionConvertor_30_50.convertBoolean(src.getInactiveElement()));
        if (src.hasVersion())
            tgt.setVersionElement(VersionConvertor_30_50.convertString(src.getVersionElement()));
        if (src.hasCode())
            tgt.setCodeElement(VersionConvertor_30_50.convertCode(src.getCodeElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(VersionConvertor_30_50.convertString(src.getDisplayElement()));
        for (org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent t : src.getDesignation()) tgt.addDesignation(convertConceptReferenceDesignationComponent(t));
        for (org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent t : src.getContains()) tgt.addContains(convertValueSetExpansionContainsComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionParameterComponent convertValueSetExpansionParameterComponent(org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionParameterComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionParameterComponent tgt = new org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionParameterComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_50.convertString(src.getNameElement()));
        if (src.hasValue())
            tgt.setValue(VersionConvertor_30_50.convertType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionParameterComponent convertValueSetExpansionParameterComponent(org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionParameterComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionParameterComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionParameterComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_50.convertString(src.getNameElement()));
        if (src.hasValue())
            tgt.setValue(VersionConvertor_30_50.convertType(src.getValue()));
        return tgt;
    }
}