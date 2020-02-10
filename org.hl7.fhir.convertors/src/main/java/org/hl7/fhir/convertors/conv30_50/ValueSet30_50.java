package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.BooleanType;
import java.util.Collections;

public class ValueSet30_50 {

    public static org.hl7.fhir.dstu3.model.ValueSet.ConceptReferenceComponent convertConceptReferenceComponent(org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ValueSet.ConceptReferenceComponent tgt = new org.hl7.fhir.dstu3.model.ValueSet.ConceptReferenceComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement((org.hl7.fhir.dstu3.model.CodeType) VersionConvertor_30_50.convertType(src.getCodeElement()));
        if (src.hasDisplayElement())
            tgt.setDisplayElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getDisplayElement()));
        if (src.hasDesignation()) {
            for (org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent t : src.getDesignation()) tgt.addDesignation(convertConceptReferenceDesignationComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent convertConceptReferenceComponent(org.hl7.fhir.dstu3.model.ValueSet.ConceptReferenceComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement((org.hl7.fhir.r5.model.CodeType) VersionConvertor_30_50.convertType(src.getCodeElement()));
        if (src.hasDisplayElement())
            tgt.setDisplayElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_30_50.convertType(src.getDisplayElement()));
        if (src.hasDesignation()) {
            for (org.hl7.fhir.dstu3.model.ValueSet.ConceptReferenceDesignationComponent t : src.getDesignation()) tgt.addDesignation(convertConceptReferenceDesignationComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent convertConceptReferenceDesignationComponent(org.hl7.fhir.dstu3.model.ValueSet.ConceptReferenceDesignationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasLanguageElement())
            tgt.setLanguageElement((org.hl7.fhir.r5.model.CodeType) VersionConvertor_30_50.convertType(src.getLanguageElement()));
        if (src.hasUse())
            tgt.setUse(VersionConvertor_30_50.convertCoding(src.getUse()));
        if (src.hasValueElement())
            tgt.setValueElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_30_50.convertType(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ValueSet.ConceptReferenceDesignationComponent convertConceptReferenceDesignationComponent(org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ValueSet.ConceptReferenceDesignationComponent tgt = new org.hl7.fhir.dstu3.model.ValueSet.ConceptReferenceDesignationComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasLanguageElement())
            tgt.setLanguageElement((org.hl7.fhir.dstu3.model.CodeType) VersionConvertor_30_50.convertType(src.getLanguageElement()));
        if (src.hasUse())
            tgt.setUse(VersionConvertor_30_50.convertCoding(src.getUse()));
        if (src.hasValueElement())
            tgt.setValueElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent convertConceptSetComponent(org.hl7.fhir.dstu3.model.ValueSet.ConceptSetComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasSystemElement())
            tgt.setSystemElement((org.hl7.fhir.r5.model.UriType) VersionConvertor_30_50.convertType(src.getSystemElement()));
        if (src.hasVersionElement())
            tgt.setVersionElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_30_50.convertType(src.getVersionElement()));
        if (src.hasConcept()) {
            for (org.hl7.fhir.dstu3.model.ValueSet.ConceptReferenceComponent t : src.getConcept()) tgt.addConcept(convertConceptReferenceComponent(t));
        }
        if (src.hasFilter()) {
            for (org.hl7.fhir.dstu3.model.ValueSet.ConceptSetFilterComponent t : src.getFilter()) tgt.addFilter(convertConceptSetFilterComponent(t));
        }
        if (src.hasValueSet()) {
            for (org.hl7.fhir.dstu3.model.UriType t : src.getValueSet()) tgt.addValueSet(t.getValue());
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ValueSet.ConceptSetComponent convertConceptSetComponent(org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ValueSet.ConceptSetComponent tgt = new org.hl7.fhir.dstu3.model.ValueSet.ConceptSetComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasSystemElement())
            tgt.setSystemElement((org.hl7.fhir.dstu3.model.UriType) VersionConvertor_30_50.convertType(src.getSystemElement()));
        if (src.hasVersionElement())
            tgt.setVersionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getVersionElement()));
        if (src.hasConcept()) {
            for (org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent t : src.getConcept()) tgt.addConcept(convertConceptReferenceComponent(t));
        }
        if (src.hasFilter()) {
            for (org.hl7.fhir.r5.model.ValueSet.ConceptSetFilterComponent t : src.getFilter()) tgt.addFilter(convertConceptSetFilterComponent(t));
        }
        if (src.hasValueSet()) {
            for (org.hl7.fhir.r5.model.UriType t : src.getValueSet()) tgt.addValueSet(t.getValue());
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ValueSet.ConceptSetFilterComponent convertConceptSetFilterComponent(org.hl7.fhir.r5.model.ValueSet.ConceptSetFilterComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ValueSet.ConceptSetFilterComponent tgt = new org.hl7.fhir.dstu3.model.ValueSet.ConceptSetFilterComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasPropertyElement())
            tgt.setPropertyElement((org.hl7.fhir.dstu3.model.CodeType) VersionConvertor_30_50.convertType(src.getPropertyElement()));
        if (src.hasOp())
            tgt.setOp(convertFilterOperator2(src.getOp()));
        if (src.hasValueElement())
            tgt.setValueElement((org.hl7.fhir.dstu3.model.CodeType) VersionConvertor_30_50.convertType(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ValueSet.ConceptSetFilterComponent convertConceptSetFilterComponent(org.hl7.fhir.dstu3.model.ValueSet.ConceptSetFilterComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ValueSet.ConceptSetFilterComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ConceptSetFilterComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasPropertyElement())
            tgt.setPropertyElement((org.hl7.fhir.r5.model.CodeType) VersionConvertor_30_50.convertType(src.getPropertyElement()));
        if (src.hasOp())
            tgt.setOp(VersionConvertor_30_50.convertFilterOperator(src.getOp()));
        if (src.hasValueElement())
            tgt.setValueElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_30_50.convertType(src.getValueElement()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.ValueSet.FilterOperator convertFilterOperator2(org.hl7.fhir.r5.model.Enumerations.FilterOperator src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case EQUAL:
                return org.hl7.fhir.dstu3.model.ValueSet.FilterOperator.EQUAL;
            case ISA:
                return org.hl7.fhir.dstu3.model.ValueSet.FilterOperator.ISA;
            case DESCENDENTOF:
                return org.hl7.fhir.dstu3.model.ValueSet.FilterOperator.DESCENDENTOF;
            case ISNOTA:
                return org.hl7.fhir.dstu3.model.ValueSet.FilterOperator.ISNOTA;
            case REGEX:
                return org.hl7.fhir.dstu3.model.ValueSet.FilterOperator.REGEX;
            case IN:
                return org.hl7.fhir.dstu3.model.ValueSet.FilterOperator.IN;
            case NOTIN:
                return org.hl7.fhir.dstu3.model.ValueSet.FilterOperator.NOTIN;
            case GENERALIZES:
                return org.hl7.fhir.dstu3.model.ValueSet.FilterOperator.GENERALIZES;
            case EXISTS:
                return org.hl7.fhir.dstu3.model.ValueSet.FilterOperator.EXISTS;
            default:
                return org.hl7.fhir.dstu3.model.ValueSet.FilterOperator.NULL;
        }
    }

    public static org.hl7.fhir.r5.model.ValueSet convertValueSet(org.hl7.fhir.dstu3.model.ValueSet src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ValueSet tgt = new org.hl7.fhir.r5.model.ValueSet();
        VersionConvertor_30_50.copyDomainResource(src, tgt, "http://hl7.org/fhir/StructureDefinition/valueset-extensible");
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.r5.model.UriType) VersionConvertor_30_50.convertType(src.getUrlElement()));
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        }
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
        if (src.hasImmutableElement())
            tgt.setImmutableElement((org.hl7.fhir.r5.model.BooleanType) VersionConvertor_30_50.convertType(src.getImmutableElement()));
        if (src.hasPurposeElement())
            tgt.setPurposeElement((org.hl7.fhir.r5.model.MarkdownType) VersionConvertor_30_50.convertType(src.getPurposeElement()));
        if (src.hasCopyrightElement())
            tgt.setCopyrightElement((org.hl7.fhir.r5.model.MarkdownType) VersionConvertor_30_50.convertType(src.getCopyrightElement()));
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
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.dstu3.model.UriType) VersionConvertor_30_50.convertType(src.getUrlElement()));
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        }
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
        if (src.hasImmutableElement())
            tgt.setImmutableElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_30_50.convertType(src.getImmutableElement()));
        if (src.hasPurposeElement())
            tgt.setPurposeElement((org.hl7.fhir.dstu3.model.MarkdownType) VersionConvertor_30_50.convertType(src.getPurposeElement()));
        if (src.hasCopyrightElement())
            tgt.setCopyrightElement((org.hl7.fhir.dstu3.model.MarkdownType) VersionConvertor_30_50.convertType(src.getCopyrightElement()));
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
        if (src.hasLockedDateElement())
            tgt.setLockedDateElement((org.hl7.fhir.r5.model.DateType) VersionConvertor_30_50.convertType(src.getLockedDateElement()));
        if (src.hasInactiveElement())
            tgt.setInactiveElement((org.hl7.fhir.r5.model.BooleanType) VersionConvertor_30_50.convertType(src.getInactiveElement()));
        if (src.hasInclude()) {
            for (org.hl7.fhir.dstu3.model.ValueSet.ConceptSetComponent t : src.getInclude()) tgt.addInclude(convertConceptSetComponent(t));
        }
        if (src.hasExclude()) {
            for (org.hl7.fhir.dstu3.model.ValueSet.ConceptSetComponent t : src.getExclude()) tgt.addExclude(convertConceptSetComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ValueSet.ValueSetComposeComponent convertValueSetComposeComponent(org.hl7.fhir.r5.model.ValueSet.ValueSetComposeComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ValueSet.ValueSetComposeComponent tgt = new org.hl7.fhir.dstu3.model.ValueSet.ValueSetComposeComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasLockedDateElement())
            tgt.setLockedDateElement((org.hl7.fhir.dstu3.model.DateType) VersionConvertor_30_50.convertType(src.getLockedDateElement()));
        if (src.hasInactiveElement())
            tgt.setInactiveElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_30_50.convertType(src.getInactiveElement()));
        if (src.hasInclude()) {
            for (org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent t : src.getInclude()) tgt.addInclude(convertConceptSetComponent(t));
        }
        if (src.hasExclude()) {
            for (org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent t : src.getExclude()) tgt.addExclude(convertConceptSetComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionComponent convertValueSetExpansionComponent(org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasIdentifierElement())
            tgt.setIdentifierElement((org.hl7.fhir.r5.model.UriType) VersionConvertor_30_50.convertType(src.getIdentifierElement()));
        if (src.hasTimestampElement())
            tgt.setTimestampElement((org.hl7.fhir.r5.model.DateTimeType) VersionConvertor_30_50.convertType(src.getTimestampElement()));
        if (src.hasTotalElement())
            tgt.setTotalElement((org.hl7.fhir.r5.model.IntegerType) VersionConvertor_30_50.convertType(src.getTotalElement()));
        if (src.hasOffsetElement())
            tgt.setOffsetElement((org.hl7.fhir.r5.model.IntegerType) VersionConvertor_30_50.convertType(src.getOffsetElement()));
        if (src.hasParameter()) {
            for (org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionParameterComponent t : src.getParameter()) tgt.addParameter(convertValueSetExpansionParameterComponent(t));
        }
        if (src.hasContains()) {
            for (org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionContainsComponent t : src.getContains()) tgt.addContains(convertValueSetExpansionContainsComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionComponent convertValueSetExpansionComponent(org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionComponent tgt = new org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasIdentifierElement())
            tgt.setIdentifierElement((org.hl7.fhir.dstu3.model.UriType) VersionConvertor_30_50.convertType(src.getIdentifierElement()));
        if (src.hasTimestampElement())
            tgt.setTimestampElement((org.hl7.fhir.dstu3.model.DateTimeType) VersionConvertor_30_50.convertType(src.getTimestampElement()));
        if (src.hasTotalElement())
            tgt.setTotalElement((org.hl7.fhir.dstu3.model.IntegerType) VersionConvertor_30_50.convertType(src.getTotalElement()));
        if (src.hasOffsetElement())
            tgt.setOffsetElement((org.hl7.fhir.dstu3.model.IntegerType) VersionConvertor_30_50.convertType(src.getOffsetElement()));
        if (src.hasParameter()) {
            for (org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionParameterComponent t : src.getParameter()) tgt.addParameter(convertValueSetExpansionParameterComponent(t));
        }
        if (src.hasContains()) {
            for (org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent t : src.getContains()) tgt.addContains(convertValueSetExpansionContainsComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent convertValueSetExpansionContainsComponent(org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionContainsComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasSystemElement())
            tgt.setSystemElement((org.hl7.fhir.r5.model.UriType) VersionConvertor_30_50.convertType(src.getSystemElement()));
        if (src.hasAbstractElement())
            tgt.setAbstractElement((org.hl7.fhir.r5.model.BooleanType) VersionConvertor_30_50.convertType(src.getAbstractElement()));
        if (src.hasInactiveElement())
            tgt.setInactiveElement((org.hl7.fhir.r5.model.BooleanType) VersionConvertor_30_50.convertType(src.getInactiveElement()));
        if (src.hasVersionElement())
            tgt.setVersionElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_30_50.convertType(src.getVersionElement()));
        if (src.hasCodeElement())
            tgt.setCodeElement((org.hl7.fhir.r5.model.CodeType) VersionConvertor_30_50.convertType(src.getCodeElement()));
        if (src.hasDisplayElement())
            tgt.setDisplayElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_30_50.convertType(src.getDisplayElement()));
        if (src.hasDesignation()) {
            for (org.hl7.fhir.dstu3.model.ValueSet.ConceptReferenceDesignationComponent t : src.getDesignation()) tgt.addDesignation(convertConceptReferenceDesignationComponent(t));
        }
        if (src.hasContains()) {
            for (org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionContainsComponent t : src.getContains()) tgt.addContains(convertValueSetExpansionContainsComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionContainsComponent convertValueSetExpansionContainsComponent(org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionContainsComponent tgt = new org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionContainsComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasSystemElement())
            tgt.setSystemElement((org.hl7.fhir.dstu3.model.UriType) VersionConvertor_30_50.convertType(src.getSystemElement()));
        if (src.hasAbstractElement())
            tgt.setAbstractElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_30_50.convertType(src.getAbstractElement()));
        if (src.hasInactiveElement())
            tgt.setInactiveElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_30_50.convertType(src.getInactiveElement()));
        if (src.hasVersionElement())
            tgt.setVersionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getVersionElement()));
        if (src.hasCodeElement())
            tgt.setCodeElement((org.hl7.fhir.dstu3.model.CodeType) VersionConvertor_30_50.convertType(src.getCodeElement()));
        if (src.hasDisplayElement())
            tgt.setDisplayElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getDisplayElement()));
        if (src.hasDesignation()) {
            for (org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent t : src.getDesignation()) tgt.addDesignation(convertConceptReferenceDesignationComponent(t));
        }
        if (src.hasContains()) {
            for (org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent t : src.getContains()) tgt.addContains(convertValueSetExpansionContainsComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionParameterComponent convertValueSetExpansionParameterComponent(org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionParameterComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionParameterComponent tgt = new org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionParameterComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getNameElement()));
        if (src.hasValue())
            tgt.setValue(VersionConvertor_30_50.convertType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionParameterComponent convertValueSetExpansionParameterComponent(org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionParameterComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionParameterComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionParameterComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_30_50.convertType(src.getNameElement()));
        if (src.hasValue())
            tgt.setValue(VersionConvertor_30_50.convertType(src.getValue()));
        return tgt;
    }
}
