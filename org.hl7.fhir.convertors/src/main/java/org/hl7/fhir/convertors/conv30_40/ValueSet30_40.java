package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.BooleanType;
import java.util.Collections;

public class ValueSet30_40 {

    public static org.hl7.fhir.dstu3.model.ValueSet.ConceptReferenceComponent convertConceptReferenceComponent(org.hl7.fhir.r4.model.ValueSet.ConceptReferenceComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ValueSet.ConceptReferenceComponent tgt = new org.hl7.fhir.dstu3.model.ValueSet.ConceptReferenceComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement((org.hl7.fhir.dstu3.model.CodeType) VersionConvertor_30_40.convertType(src.getCodeElement()));
        if (src.hasDisplayElement())
            tgt.setDisplayElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getDisplayElement()));
        if (src.hasDesignation()) {
            for (org.hl7.fhir.r4.model.ValueSet.ConceptReferenceDesignationComponent t : src.getDesignation()) tgt.addDesignation(convertConceptReferenceDesignationComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ValueSet.ConceptReferenceComponent convertConceptReferenceComponent(org.hl7.fhir.dstu3.model.ValueSet.ConceptReferenceComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ValueSet.ConceptReferenceComponent tgt = new org.hl7.fhir.r4.model.ValueSet.ConceptReferenceComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement((org.hl7.fhir.r4.model.CodeType) VersionConvertor_30_40.convertType(src.getCodeElement()));
        if (src.hasDisplayElement())
            tgt.setDisplayElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getDisplayElement()));
        if (src.hasDesignation()) {
            for (org.hl7.fhir.dstu3.model.ValueSet.ConceptReferenceDesignationComponent t : src.getDesignation()) tgt.addDesignation(convertConceptReferenceDesignationComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ValueSet.ConceptReferenceDesignationComponent convertConceptReferenceDesignationComponent(org.hl7.fhir.r4.model.ValueSet.ConceptReferenceDesignationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ValueSet.ConceptReferenceDesignationComponent tgt = new org.hl7.fhir.dstu3.model.ValueSet.ConceptReferenceDesignationComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasLanguageElement())
            tgt.setLanguageElement((org.hl7.fhir.dstu3.model.CodeType) VersionConvertor_30_40.convertType(src.getLanguageElement()));
        if (src.hasUse())
            tgt.setUse(VersionConvertor_30_40.convertCoding(src.getUse()));
        if (src.hasValueElement())
            tgt.setValueElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ValueSet.ConceptReferenceDesignationComponent convertConceptReferenceDesignationComponent(org.hl7.fhir.dstu3.model.ValueSet.ConceptReferenceDesignationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ValueSet.ConceptReferenceDesignationComponent tgt = new org.hl7.fhir.r4.model.ValueSet.ConceptReferenceDesignationComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasLanguageElement())
            tgt.setLanguageElement((org.hl7.fhir.r4.model.CodeType) VersionConvertor_30_40.convertType(src.getLanguageElement()));
        if (src.hasUse())
            tgt.setUse(VersionConvertor_30_40.convertCoding(src.getUse()));
        if (src.hasValueElement())
            tgt.setValueElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ValueSet.ConceptSetComponent convertConceptSetComponent(org.hl7.fhir.r4.model.ValueSet.ConceptSetComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ValueSet.ConceptSetComponent tgt = new org.hl7.fhir.dstu3.model.ValueSet.ConceptSetComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasSystemElement())
            tgt.setSystemElement((org.hl7.fhir.dstu3.model.UriType) VersionConvertor_30_40.convertType(src.getSystemElement()));
        if (src.hasVersionElement())
            tgt.setVersionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getVersionElement()));
        if (src.hasConcept()) {
            for (org.hl7.fhir.r4.model.ValueSet.ConceptReferenceComponent t : src.getConcept()) tgt.addConcept(convertConceptReferenceComponent(t));
        }
        if (src.hasFilter()) {
            for (org.hl7.fhir.r4.model.ValueSet.ConceptSetFilterComponent t : src.getFilter()) tgt.addFilter(convertConceptSetFilterComponent(t));
        }
        if (src.hasValueSet()) {
            for (org.hl7.fhir.r4.model.UriType t : src.getValueSet()) tgt.addValueSet(t.getValue());
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ValueSet.ConceptSetComponent convertConceptSetComponent(org.hl7.fhir.dstu3.model.ValueSet.ConceptSetComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ValueSet.ConceptSetComponent tgt = new org.hl7.fhir.r4.model.ValueSet.ConceptSetComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasSystemElement())
            tgt.setSystemElement((org.hl7.fhir.r4.model.UriType) VersionConvertor_30_40.convertType(src.getSystemElement()));
        if (src.hasVersionElement())
            tgt.setVersionElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getVersionElement()));
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

    public static org.hl7.fhir.r4.model.ValueSet.ConceptSetFilterComponent convertConceptSetFilterComponent(org.hl7.fhir.dstu3.model.ValueSet.ConceptSetFilterComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ValueSet.ConceptSetFilterComponent tgt = new org.hl7.fhir.r4.model.ValueSet.ConceptSetFilterComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasPropertyElement())
            tgt.setPropertyElement((org.hl7.fhir.r4.model.CodeType) VersionConvertor_30_40.convertType(src.getPropertyElement()));
        if (src.hasOp())
            tgt.setOp(VersionConvertor_30_40.convertFilterOperator(src.getOp()));
        if (src.hasValueElement())
            tgt.setValueElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ValueSet.ConceptSetFilterComponent convertConceptSetFilterComponent(org.hl7.fhir.r4.model.ValueSet.ConceptSetFilterComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ValueSet.ConceptSetFilterComponent tgt = new org.hl7.fhir.dstu3.model.ValueSet.ConceptSetFilterComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasPropertyElement())
            tgt.setPropertyElement((org.hl7.fhir.dstu3.model.CodeType) VersionConvertor_30_40.convertType(src.getPropertyElement()));
        if (src.hasOp())
            tgt.setOp(VersionConvertor_30_40.convertFilterOperator(src.getOp()));
        if (src.hasValueElement())
            tgt.setValueElement((org.hl7.fhir.dstu3.model.CodeType) VersionConvertor_30_40.convertType(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ValueSet convertValueSet(org.hl7.fhir.r4.model.ValueSet src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ValueSet tgt = new org.hl7.fhir.dstu3.model.ValueSet();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.dstu3.model.UriType) VersionConvertor_30_40.convertType(src.getUrlElement()));
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        }
        if (src.hasVersionElement())
            tgt.setVersionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getNameElement()));
        if (src.hasTitleElement())
            tgt.setTitleElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getTitleElement()));
        if (src.hasStatus())
            tgt.setStatus(VersionConvertor_30_40.convertPublicationStatus(src.getStatus()));
        if (src.hasExperimentalElement())
            tgt.setExperimentalElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_30_40.convertType(src.getExperimentalElement()));
        if (src.hasDateElement())
            tgt.setDateElement(VersionConvertor_30_40.convertDateTime(src.getDateElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getPublisherElement()));
        if (src.hasContact()) {
            for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact()) tgt.addContact(VersionConvertor_30_40.convertContactDetail(t));
        }
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu3.model.MarkdownType) VersionConvertor_30_40.convertType(src.getDescriptionElement()));
        if (src.hasUseContext()) {
            for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_40.convertUsageContext(t));
        }
        if (src.hasJurisdiction()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasImmutableElement())
            tgt.setImmutableElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_30_40.convertType(src.getImmutableElement()));
        if (src.hasPurposeElement())
            tgt.setPurposeElement((org.hl7.fhir.dstu3.model.MarkdownType) VersionConvertor_30_40.convertType(src.getPurposeElement()));
        if (src.hasCopyrightElement())
            tgt.setCopyrightElement((org.hl7.fhir.dstu3.model.MarkdownType) VersionConvertor_30_40.convertType(src.getCopyrightElement()));
        if (src.hasExtension("http://hl7.org/fhir/StructureDefinition/valueset-extensible"))
            tgt.setExtensible(((BooleanType) src.getExtensionByUrl("http://hl7.org/fhir/StructureDefinition/valueset-extensible").getValue()).booleanValue());
        if (src.hasCompose())
            tgt.setCompose(convertValueSetComposeComponent(src.getCompose()));
        if (src.hasExpansion())
            tgt.setExpansion(convertValueSetExpansionComponent(src.getExpansion()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ValueSet convertValueSet(org.hl7.fhir.dstu3.model.ValueSet src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ValueSet tgt = new org.hl7.fhir.r4.model.ValueSet();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.r4.model.UriType) VersionConvertor_30_40.convertType(src.getUrlElement()));
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        }
        if (src.hasVersionElement())
            tgt.setVersionElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getNameElement()));
        if (src.hasTitleElement())
            tgt.setTitleElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getTitleElement()));
        if (src.hasStatus())
            tgt.setStatus(VersionConvertor_30_40.convertPublicationStatus(src.getStatus()));
        if (src.hasExperimentalElement())
            tgt.setExperimentalElement((org.hl7.fhir.r4.model.BooleanType) VersionConvertor_30_40.convertType(src.getExperimentalElement()));
        if (src.hasDateElement())
            tgt.setDateElement(VersionConvertor_30_40.convertDateTime(src.getDateElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getPublisherElement()));
        if (src.hasContact()) {
            for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(VersionConvertor_30_40.convertContactDetail(t));
        }
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.r4.model.MarkdownType) VersionConvertor_30_40.convertType(src.getDescriptionElement()));
        if (src.hasUseContext()) {
            for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_40.convertUsageContext(t));
        }
        if (src.hasJurisdiction()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasImmutableElement())
            tgt.setImmutableElement((org.hl7.fhir.r4.model.BooleanType) VersionConvertor_30_40.convertType(src.getImmutableElement()));
        if (src.hasPurposeElement())
            tgt.setPurposeElement((org.hl7.fhir.r4.model.MarkdownType) VersionConvertor_30_40.convertType(src.getPurposeElement()));
        if (src.hasCopyrightElement())
            tgt.setCopyrightElement((org.hl7.fhir.r4.model.MarkdownType) VersionConvertor_30_40.convertType(src.getCopyrightElement()));
        if (src.hasExtensible())
            tgt.addExtension("http://hl7.org/fhir/StructureDefinition/valueset-extensible", new BooleanType(src.getExtensible()));
        if (src.hasCompose())
            tgt.setCompose(convertValueSetComposeComponent(src.getCompose()));
        if (src.hasExpansion())
            tgt.setExpansion(convertValueSetExpansionComponent(src.getExpansion()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ValueSet.ValueSetComposeComponent convertValueSetComposeComponent(org.hl7.fhir.r4.model.ValueSet.ValueSetComposeComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ValueSet.ValueSetComposeComponent tgt = new org.hl7.fhir.dstu3.model.ValueSet.ValueSetComposeComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasLockedDate())
          tgt.setLockedDateElement(VersionConvertor_30_40.convertDate(src.getLockedDateElement()));
        if (src.hasInactiveElement())
            tgt.setInactiveElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_30_40.convertType(src.getInactiveElement()));
        if (src.hasInclude()) {
            for (org.hl7.fhir.r4.model.ValueSet.ConceptSetComponent t : src.getInclude()) tgt.addInclude(convertConceptSetComponent(t));
        }
        if (src.hasExclude()) {
            for (org.hl7.fhir.r4.model.ValueSet.ConceptSetComponent t : src.getExclude()) tgt.addExclude(convertConceptSetComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ValueSet.ValueSetComposeComponent convertValueSetComposeComponent(org.hl7.fhir.dstu3.model.ValueSet.ValueSetComposeComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ValueSet.ValueSetComposeComponent tgt = new org.hl7.fhir.r4.model.ValueSet.ValueSetComposeComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasLockedDate())
          tgt.setLockedDateElement(VersionConvertor_30_40.convertDate(src.getLockedDateElement()));
        if (src.hasInactiveElement())
            tgt.setInactiveElement((org.hl7.fhir.r4.model.BooleanType) VersionConvertor_30_40.convertType(src.getInactiveElement()));
        if (src.hasInclude()) {
            for (org.hl7.fhir.dstu3.model.ValueSet.ConceptSetComponent t : src.getInclude()) tgt.addInclude(convertConceptSetComponent(t));
        }
        if (src.hasExclude()) {
            for (org.hl7.fhir.dstu3.model.ValueSet.ConceptSetComponent t : src.getExclude()) tgt.addExclude(convertConceptSetComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionComponent convertValueSetExpansionComponent(org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionComponent tgt = new org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasIdentifierElement())
            tgt.setIdentifierElement((org.hl7.fhir.dstu3.model.UriType) VersionConvertor_30_40.convertType(src.getIdentifierElement()));
        if (src.hasTimestamp())
            tgt.setTimestampElement(VersionConvertor_30_40.convertDateTime(src.getTimestampElement()));
        if (src.hasTotalElement())
            tgt.setTotalElement((org.hl7.fhir.dstu3.model.IntegerType) VersionConvertor_30_40.convertType(src.getTotalElement()));
        if (src.hasOffsetElement())
            tgt.setOffsetElement((org.hl7.fhir.dstu3.model.IntegerType) VersionConvertor_30_40.convertType(src.getOffsetElement()));
        if (src.hasParameter()) {
            for (org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionParameterComponent t : src.getParameter()) tgt.addParameter(convertValueSetExpansionParameterComponent(t));
        }
        if (src.hasContains()) {
            for (org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionContainsComponent t : src.getContains()) tgt.addContains(convertValueSetExpansionContainsComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionComponent convertValueSetExpansionComponent(org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionComponent tgt = new org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasIdentifierElement())
            tgt.setIdentifierElement((org.hl7.fhir.r4.model.UriType) VersionConvertor_30_40.convertType(src.getIdentifierElement()));
        if (src.hasTimestamp())
            tgt.setTimestampElement(VersionConvertor_30_40.convertDateTime(src.getTimestampElement()));
        if (src.hasTotalElement())
            tgt.setTotalElement((org.hl7.fhir.r4.model.IntegerType) VersionConvertor_30_40.convertType(src.getTotalElement()));
        if (src.hasOffsetElement())
            tgt.setOffsetElement((org.hl7.fhir.r4.model.IntegerType) VersionConvertor_30_40.convertType(src.getOffsetElement()));
        if (src.hasParameter()) {
            for (org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionParameterComponent t : src.getParameter()) tgt.addParameter(convertValueSetExpansionParameterComponent(t));
        }
        if (src.hasContains()) {
            for (org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionContainsComponent t : src.getContains()) tgt.addContains(convertValueSetExpansionContainsComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionContainsComponent convertValueSetExpansionContainsComponent(org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionContainsComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionContainsComponent tgt = new org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionContainsComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasSystemElement())
            tgt.setSystemElement((org.hl7.fhir.dstu3.model.UriType) VersionConvertor_30_40.convertType(src.getSystemElement()));
        if (src.hasAbstractElement())
            tgt.setAbstractElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_30_40.convertType(src.getAbstractElement()));
        if (src.hasInactiveElement())
            tgt.setInactiveElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_30_40.convertType(src.getInactiveElement()));
        if (src.hasVersionElement())
            tgt.setVersionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getVersionElement()));
        if (src.hasCodeElement())
            tgt.setCodeElement((org.hl7.fhir.dstu3.model.CodeType) VersionConvertor_30_40.convertType(src.getCodeElement()));
        if (src.hasDisplayElement())
            tgt.setDisplayElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getDisplayElement()));
        if (src.hasDesignation()) {
            for (org.hl7.fhir.r4.model.ValueSet.ConceptReferenceDesignationComponent t : src.getDesignation()) tgt.addDesignation(convertConceptReferenceDesignationComponent(t));
        }
        if (src.hasContains()) {
            for (org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionContainsComponent t : src.getContains()) tgt.addContains(convertValueSetExpansionContainsComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionContainsComponent convertValueSetExpansionContainsComponent(org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionContainsComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionContainsComponent tgt = new org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionContainsComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasSystemElement())
            tgt.setSystemElement((org.hl7.fhir.r4.model.UriType) VersionConvertor_30_40.convertType(src.getSystemElement()));
        if (src.hasAbstractElement())
            tgt.setAbstractElement((org.hl7.fhir.r4.model.BooleanType) VersionConvertor_30_40.convertType(src.getAbstractElement()));
        if (src.hasInactiveElement())
            tgt.setInactiveElement((org.hl7.fhir.r4.model.BooleanType) VersionConvertor_30_40.convertType(src.getInactiveElement()));
        if (src.hasVersionElement())
            tgt.setVersionElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getVersionElement()));
        if (src.hasCodeElement())
            tgt.setCodeElement((org.hl7.fhir.r4.model.CodeType) VersionConvertor_30_40.convertType(src.getCodeElement()));
        if (src.hasDisplayElement())
            tgt.setDisplayElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getDisplayElement()));
        if (src.hasDesignation()) {
            for (org.hl7.fhir.dstu3.model.ValueSet.ConceptReferenceDesignationComponent t : src.getDesignation()) tgt.addDesignation(convertConceptReferenceDesignationComponent(t));
        }
        if (src.hasContains()) {
            for (org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionContainsComponent t : src.getContains()) tgt.addContains(convertValueSetExpansionContainsComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionParameterComponent convertValueSetExpansionParameterComponent(org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionParameterComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionParameterComponent tgt = new org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionParameterComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getNameElement()));
        if (src.hasValue())
            tgt.setValue(VersionConvertor_30_40.convertType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionParameterComponent convertValueSetExpansionParameterComponent(org.hl7.fhir.r4.model.ValueSet.ValueSetExpansionParameterComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionParameterComponent tgt = new org.hl7.fhir.dstu3.model.ValueSet.ValueSetExpansionParameterComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getNameElement()));
        if (src.hasValue())
            tgt.setValue(VersionConvertor_30_40.convertType(src.getValue()));
        return tgt;
    }
}
