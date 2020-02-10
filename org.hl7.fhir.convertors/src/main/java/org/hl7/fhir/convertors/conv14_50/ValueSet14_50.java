package org.hl7.fhir.convertors.conv14_50;

import org.hl7.fhir.convertors.VersionConvertor_14_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.BooleanType;
import java.util.Collections;

public class ValueSet14_50 {

    public static org.hl7.fhir.dstu2016may.model.ValueSet.ConceptReferenceComponent convertConceptReferenceComponent(org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ValueSet.ConceptReferenceComponent tgt = new org.hl7.fhir.dstu2016may.model.ValueSet.ConceptReferenceComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement((org.hl7.fhir.dstu2016may.model.CodeType) VersionConvertor_14_50.convertType(src.getCodeElement()));
        if (src.hasDisplayElement())
            tgt.setDisplayElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_50.convertType(src.getDisplayElement()));
        if (src.hasDesignation()) {
            for (org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent t : src.getDesignation()) tgt.addDesignation(convertConceptReferenceDesignationComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent convertConceptReferenceComponent(org.hl7.fhir.dstu2016may.model.ValueSet.ConceptReferenceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement((org.hl7.fhir.r5.model.CodeType) VersionConvertor_14_50.convertType(src.getCodeElement()));
        if (src.hasDisplayElement())
            tgt.setDisplayElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_14_50.convertType(src.getDisplayElement()));
        if (src.hasDesignation()) {
            for (org.hl7.fhir.dstu2016may.model.ValueSet.ConceptReferenceDesignationComponent t : src.getDesignation()) tgt.addDesignation(convertConceptReferenceDesignationComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent convertConceptReferenceDesignationComponent(org.hl7.fhir.dstu2016may.model.ValueSet.ConceptReferenceDesignationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasLanguageElement())
            tgt.setLanguageElement((org.hl7.fhir.r5.model.CodeType) VersionConvertor_14_50.convertType(src.getLanguageElement()));
        if (src.hasUse()) {
            tgt.setUse(VersionConvertor_14_50.convertCoding(src.getUse()));
        }
        if (src.hasValueElement())
            tgt.setValueElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_14_50.convertType(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ValueSet.ConceptReferenceDesignationComponent convertConceptReferenceDesignationComponent(org.hl7.fhir.r5.model.ValueSet.ConceptReferenceDesignationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ValueSet.ConceptReferenceDesignationComponent tgt = new org.hl7.fhir.dstu2016may.model.ValueSet.ConceptReferenceDesignationComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasLanguageElement())
            tgt.setLanguageElement((org.hl7.fhir.dstu2016may.model.CodeType) VersionConvertor_14_50.convertType(src.getLanguageElement()));
        if (src.hasUse()) {
            tgt.setUse(VersionConvertor_14_50.convertCoding(src.getUse()));
        }
        if (src.hasValueElement())
            tgt.setValueElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_50.convertType(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent convertConceptSetComponent(org.hl7.fhir.dstu2016may.model.ValueSet.ConceptSetComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasSystemElement())
            tgt.setSystemElement((org.hl7.fhir.r5.model.UriType) VersionConvertor_14_50.convertType(src.getSystemElement()));
        if (src.hasVersionElement())
            tgt.setVersionElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_14_50.convertType(src.getVersionElement()));
        if (src.hasConcept()) {
            for (org.hl7.fhir.dstu2016may.model.ValueSet.ConceptReferenceComponent t : src.getConcept()) tgt.addConcept(convertConceptReferenceComponent(t));
        }
        if (src.hasFilter()) {
            for (org.hl7.fhir.dstu2016may.model.ValueSet.ConceptSetFilterComponent t : src.getFilter()) tgt.addFilter(convertConceptSetFilterComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ValueSet.ConceptSetComponent convertConceptSetComponent(org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ValueSet.ConceptSetComponent tgt = new org.hl7.fhir.dstu2016may.model.ValueSet.ConceptSetComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasSystemElement())
            tgt.setSystemElement((org.hl7.fhir.dstu2016may.model.UriType) VersionConvertor_14_50.convertType(src.getSystemElement()));
        if (src.hasVersionElement())
            tgt.setVersionElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_50.convertType(src.getVersionElement()));
        if (src.hasConcept()) {
            for (org.hl7.fhir.r5.model.ValueSet.ConceptReferenceComponent t : src.getConcept()) tgt.addConcept(convertConceptReferenceComponent(t));
        }
        if (src.hasFilter()) {
            for (org.hl7.fhir.r5.model.ValueSet.ConceptSetFilterComponent t : src.getFilter()) tgt.addFilter(convertConceptSetFilterComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ValueSet.ConceptSetFilterComponent convertConceptSetFilterComponent(org.hl7.fhir.r5.model.ValueSet.ConceptSetFilterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ValueSet.ConceptSetFilterComponent tgt = new org.hl7.fhir.dstu2016may.model.ValueSet.ConceptSetFilterComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasPropertyElement())
            tgt.setPropertyElement((org.hl7.fhir.dstu2016may.model.CodeType) VersionConvertor_14_50.convertType(src.getPropertyElement()));
        if (src.hasOp()) {
            tgt.setOp(convertFilterOperator(src.getOp()));
        }
        if (src.hasValueElement())
            tgt.setValueElement((org.hl7.fhir.dstu2016may.model.CodeType) VersionConvertor_14_50.convertType(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ValueSet.ConceptSetFilterComponent convertConceptSetFilterComponent(org.hl7.fhir.dstu2016may.model.ValueSet.ConceptSetFilterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ValueSet.ConceptSetFilterComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ConceptSetFilterComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasPropertyElement())
            tgt.setPropertyElement((org.hl7.fhir.r5.model.CodeType) VersionConvertor_14_50.convertType(src.getPropertyElement()));
        if (src.hasOp()) {
            tgt.setOp(convertFilterOperator(src.getOp()));
        }
        if (src.hasValueElement())
            tgt.setValueElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_14_50.convertType(src.getValueElement()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumerations.FilterOperator convertFilterOperator(org.hl7.fhir.dstu2016may.model.ValueSet.FilterOperator src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case EQUAL:
                return org.hl7.fhir.r5.model.Enumerations.FilterOperator.EQUAL;
            case ISA:
                return org.hl7.fhir.r5.model.Enumerations.FilterOperator.ISA;
            case ISNOTA:
                return org.hl7.fhir.r5.model.Enumerations.FilterOperator.ISNOTA;
            case REGEX:
                return org.hl7.fhir.r5.model.Enumerations.FilterOperator.REGEX;
            case IN:
                return org.hl7.fhir.r5.model.Enumerations.FilterOperator.IN;
            case NOTIN:
                return org.hl7.fhir.r5.model.Enumerations.FilterOperator.NOTIN;
            default:
                return org.hl7.fhir.r5.model.Enumerations.FilterOperator.NULL;
        }
    }

    static public org.hl7.fhir.dstu2016may.model.ValueSet.FilterOperator convertFilterOperator(org.hl7.fhir.r5.model.Enumerations.FilterOperator src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case EQUAL:
                return org.hl7.fhir.dstu2016may.model.ValueSet.FilterOperator.EQUAL;
            case ISA:
                return org.hl7.fhir.dstu2016may.model.ValueSet.FilterOperator.ISA;
            case ISNOTA:
                return org.hl7.fhir.dstu2016may.model.ValueSet.FilterOperator.ISNOTA;
            case REGEX:
                return org.hl7.fhir.dstu2016may.model.ValueSet.FilterOperator.REGEX;
            case IN:
                return org.hl7.fhir.dstu2016may.model.ValueSet.FilterOperator.IN;
            case NOTIN:
                return org.hl7.fhir.dstu2016may.model.ValueSet.FilterOperator.NOTIN;
            default:
                return org.hl7.fhir.dstu2016may.model.ValueSet.FilterOperator.NULL;
        }
    }

    public static org.hl7.fhir.r5.model.ValueSet convertValueSet(org.hl7.fhir.dstu2016may.model.ValueSet src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ValueSet tgt = new org.hl7.fhir.r5.model.ValueSet();
        VersionConvertor_14_50.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.r5.model.UriType) VersionConvertor_14_50.convertType(src.getUrlElement()));
        if (src.hasIdentifier())
            tgt.addIdentifier(VersionConvertor_14_50.convertIdentifier(src.getIdentifier()));
        if (src.hasVersionElement())
            tgt.setVersionElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_14_50.convertType(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_14_50.convertType(src.getNameElement()));
        if (src.hasStatus()) {
            tgt.setStatus(VersionConvertor_14_50.convertConformanceResourceStatus(src.getStatus()));
        }
        if (src.hasExperimentalElement())
            tgt.setExperimentalElement((org.hl7.fhir.r5.model.BooleanType) VersionConvertor_14_50.convertType(src.getExperimentalElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_14_50.convertType(src.getPublisherElement()));
        if (src.hasContact()) {
            for (org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetContactComponent t : src.getContact()) tgt.addContact(convertValueSetContactComponent(t));
        }
        if (src.hasDateElement())
            tgt.setDateElement((org.hl7.fhir.r5.model.DateTimeType) VersionConvertor_14_50.convertType(src.getDateElement()));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu2016may.model.CodeableConcept t : src.getUseContext()) if (VersionConvertor_14_50.isJurisdiction(t))
            tgt.addJurisdiction(VersionConvertor_14_50.convertCodeableConcept(t));
        else
            tgt.addUseContext(VersionConvertor_14_50.convertCodeableConceptToUsageContext(t));
        if (src.hasImmutableElement())
            tgt.setImmutableElement((org.hl7.fhir.r5.model.BooleanType) VersionConvertor_14_50.convertType(src.getImmutableElement()));
        if (src.hasRequirements())
            tgt.setPurpose(src.getRequirements());
        if (src.hasCopyright())
            tgt.setCopyright(src.getCopyright());
        if (src.hasExtensible())
            tgt.addExtension("http://hl7.org/fhir/StructureDefinition/valueset-extensible", new BooleanType(src.getExtensible()));
        if (src.hasCompose()) {
            tgt.setCompose(convertValueSetComposeComponent(src.getCompose()));
        }
        if (src.hasLockedDate())
            tgt.getCompose().setLockedDate(src.getLockedDate());
        if (src.hasExpansion()) {
            tgt.setExpansion(convertValueSetExpansionComponent(src.getExpansion()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ValueSet convertValueSet(org.hl7.fhir.r5.model.ValueSet src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ValueSet tgt = new org.hl7.fhir.dstu2016may.model.ValueSet();
        VersionConvertor_14_50.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.dstu2016may.model.UriType) VersionConvertor_14_50.convertType(src.getUrlElement()));
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.setIdentifier(VersionConvertor_14_50.convertIdentifier(t));
        }
        if (src.hasVersionElement())
            tgt.setVersionElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_50.convertType(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_50.convertType(src.getNameElement()));
        if (src.hasStatus()) {
            tgt.setStatus(VersionConvertor_14_50.convertConformanceResourceStatus(src.getStatus()));
        }
        if (src.hasExperimentalElement())
            tgt.setExperimentalElement((org.hl7.fhir.dstu2016may.model.BooleanType) VersionConvertor_14_50.convertType(src.getExperimentalElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_50.convertType(src.getPublisherElement()));
        if (src.hasContact()) {
            for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact()) tgt.addContact(convertValueSetContactComponent(t));
        }
        if (src.hasDateElement())
            tgt.setDateElement((org.hl7.fhir.dstu2016may.model.DateTimeType) VersionConvertor_14_50.convertType(src.getDateElement()));
        if (src.getCompose().hasLockedDate())
            tgt.setLockedDate(src.getCompose().getLockedDate());
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_50.convertType(src.getDescriptionElement()));
        for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext()) if (t.hasValueCodeableConcept())
            tgt.addUseContext(VersionConvertor_14_50.convertCodeableConcept(t.getValueCodeableConcept()));
        if (src.hasJurisdiction()) {
            for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction()) tgt.addUseContext(VersionConvertor_14_50.convertCodeableConcept(t));
        }
        if (src.hasImmutableElement())
            tgt.setImmutableElement((org.hl7.fhir.dstu2016may.model.BooleanType) VersionConvertor_14_50.convertType(src.getImmutableElement()));
        if (src.hasPurpose())
            tgt.setRequirements(src.getPurpose());
        if (src.hasCopyrightElement())
            tgt.setCopyrightElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_50.convertType(src.getCopyrightElement()));
        if (src.hasExtension("http://hl7.org/fhir/StructureDefinition/valueset-extensible"))
            tgt.setExtensible(((BooleanType) src.getExtensionByUrl("http://hl7.org/fhir/StructureDefinition/valueset-extensible").getValue()).booleanValue());
        if (src.hasCompose()) {
            tgt.setCompose(convertValueSetComposeComponent(src.getCompose()));
        }
        if (src.hasExpansion())
            tgt.setExpansion(convertValueSetExpansionComponent(src.getExpansion()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ValueSet.ValueSetComposeComponent convertValueSetComposeComponent(org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetComposeComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ValueSet.ValueSetComposeComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ValueSetComposeComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasImport()) {
            for (org.hl7.fhir.dstu2016may.model.UriType t : src.getImport()) tgt.addInclude().addValueSet(t.getValue());
        }
        if (src.hasInclude()) {
            for (org.hl7.fhir.dstu2016may.model.ValueSet.ConceptSetComponent t : src.getInclude()) tgt.addInclude(convertConceptSetComponent(t));
        }
        if (src.hasExclude()) {
            for (org.hl7.fhir.dstu2016may.model.ValueSet.ConceptSetComponent t : src.getExclude()) tgt.addExclude(convertConceptSetComponent(t));
        }
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
        if (src.hasExclude()) {
            for (org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent t : src.getExclude()) tgt.addExclude(convertConceptSetComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetContactComponent convertValueSetContactComponent(org.hl7.fhir.r5.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetContactComponent tgt = new org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetContactComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_50.convertType(src.getNameElement()));
        if (src.hasTelecom()) {
            for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_14_50.convertContactPoint(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ContactDetail convertValueSetContactComponent(org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ContactDetail tgt = new org.hl7.fhir.r5.model.ContactDetail();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_14_50.convertType(src.getNameElement()));
        if (src.hasTelecom()) {
            for (org.hl7.fhir.dstu2016may.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_14_50.convertContactPoint(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionComponent convertValueSetExpansionComponent(org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasIdentifierElement())
            tgt.setIdentifierElement((org.hl7.fhir.r5.model.UriType) VersionConvertor_14_50.convertType(src.getIdentifierElement()));
        if (src.hasTimestampElement())
            tgt.setTimestampElement((org.hl7.fhir.r5.model.DateTimeType) VersionConvertor_14_50.convertType(src.getTimestampElement()));
        if (src.hasTotalElement())
            tgt.setTotalElement((org.hl7.fhir.r5.model.IntegerType) VersionConvertor_14_50.convertType(src.getTotalElement()));
        if (src.hasOffsetElement())
            tgt.setOffsetElement((org.hl7.fhir.r5.model.IntegerType) VersionConvertor_14_50.convertType(src.getOffsetElement()));
        if (src.hasParameter()) {
            for (org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionParameterComponent t : src.getParameter()) tgt.addParameter(convertValueSetExpansionParameterComponent(t));
        }
        if (src.hasContains()) {
            for (org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionContainsComponent t : src.getContains()) tgt.addContains(convertValueSetExpansionContainsComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionComponent convertValueSetExpansionComponent(org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionComponent tgt = new org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasIdentifierElement())
            tgt.setIdentifierElement((org.hl7.fhir.dstu2016may.model.UriType) VersionConvertor_14_50.convertType(src.getIdentifierElement()));
        if (src.hasTimestampElement())
            tgt.setTimestampElement((org.hl7.fhir.dstu2016may.model.DateTimeType) VersionConvertor_14_50.convertType(src.getTimestampElement()));
        if (src.hasTotalElement())
            tgt.setTotalElement((org.hl7.fhir.dstu2016may.model.IntegerType) VersionConvertor_14_50.convertType(src.getTotalElement()));
        if (src.hasOffsetElement())
            tgt.setOffsetElement((org.hl7.fhir.dstu2016may.model.IntegerType) VersionConvertor_14_50.convertType(src.getOffsetElement()));
        if (src.hasParameter()) {
            for (org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionParameterComponent t : src.getParameter()) tgt.addParameter(convertValueSetExpansionParameterComponent(t));
        }
        if (src.hasContains()) {
            for (org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent t : src.getContains()) tgt.addContains(convertValueSetExpansionContainsComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent convertValueSetExpansionContainsComponent(org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionContainsComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasSystemElement())
            tgt.setSystemElement((org.hl7.fhir.r5.model.UriType) VersionConvertor_14_50.convertType(src.getSystemElement()));
        if (src.hasAbstractElement())
            tgt.setAbstractElement((org.hl7.fhir.r5.model.BooleanType) VersionConvertor_14_50.convertType(src.getAbstractElement()));
        if (src.hasVersionElement())
            tgt.setVersionElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_14_50.convertType(src.getVersionElement()));
        if (src.hasCodeElement())
            tgt.setCodeElement((org.hl7.fhir.r5.model.CodeType) VersionConvertor_14_50.convertType(src.getCodeElement()));
        if (src.hasDisplayElement())
            tgt.setDisplayElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_14_50.convertType(src.getDisplayElement()));
        if (src.hasContains()) {
            for (org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionContainsComponent t : src.getContains()) tgt.addContains(convertValueSetExpansionContainsComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionContainsComponent convertValueSetExpansionContainsComponent(org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionContainsComponent tgt = new org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionContainsComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasSystemElement())
            tgt.setSystemElement((org.hl7.fhir.dstu2016may.model.UriType) VersionConvertor_14_50.convertType(src.getSystemElement()));
        if (src.hasAbstractElement())
            tgt.setAbstractElement((org.hl7.fhir.dstu2016may.model.BooleanType) VersionConvertor_14_50.convertType(src.getAbstractElement()));
        if (src.hasVersionElement())
            tgt.setVersionElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_50.convertType(src.getVersionElement()));
        if (src.hasCodeElement())
            tgt.setCodeElement((org.hl7.fhir.dstu2016may.model.CodeType) VersionConvertor_14_50.convertType(src.getCodeElement()));
        if (src.hasDisplayElement())
            tgt.setDisplayElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_50.convertType(src.getDisplayElement()));
        if (src.hasContains()) {
            for (org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent t : src.getContains()) tgt.addContains(convertValueSetExpansionContainsComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionParameterComponent convertValueSetExpansionParameterComponent(org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionParameterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionParameterComponent tgt = new org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionParameterComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_14_50.convertType(src.getNameElement()));
        if (src.hasValue()) {
            tgt.setValue(VersionConvertor_14_50.convertType(src.getValue()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionParameterComponent convertValueSetExpansionParameterComponent(org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionParameterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionParameterComponent tgt = new org.hl7.fhir.dstu2016may.model.ValueSet.ValueSetExpansionParameterComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_50.convertType(src.getNameElement()));
        if (src.hasValue()) {
            tgt.setValue(VersionConvertor_14_50.convertType(src.getValue()));
        }
        return tgt;
    }
}
