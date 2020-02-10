package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.exceptions.FHIRException;
import java.util.Collections;

public class SearchParameter30_50 {

    static public org.hl7.fhir.r5.model.SearchParameter.SearchComparator convertSearchComparator(org.hl7.fhir.dstu3.model.SearchParameter.SearchComparator src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case EQ:
                return org.hl7.fhir.r5.model.SearchParameter.SearchComparator.EQ;
            case NE:
                return org.hl7.fhir.r5.model.SearchParameter.SearchComparator.NE;
            case GT:
                return org.hl7.fhir.r5.model.SearchParameter.SearchComparator.GT;
            case LT:
                return org.hl7.fhir.r5.model.SearchParameter.SearchComparator.LT;
            case GE:
                return org.hl7.fhir.r5.model.SearchParameter.SearchComparator.GE;
            case LE:
                return org.hl7.fhir.r5.model.SearchParameter.SearchComparator.LE;
            case SA:
                return org.hl7.fhir.r5.model.SearchParameter.SearchComparator.SA;
            case EB:
                return org.hl7.fhir.r5.model.SearchParameter.SearchComparator.EB;
            case AP:
                return org.hl7.fhir.r5.model.SearchParameter.SearchComparator.AP;
            default:
                return org.hl7.fhir.r5.model.SearchParameter.SearchComparator.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.SearchParameter.SearchComparator convertSearchComparator(org.hl7.fhir.r5.model.SearchParameter.SearchComparator src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case EQ:
                return org.hl7.fhir.dstu3.model.SearchParameter.SearchComparator.EQ;
            case NE:
                return org.hl7.fhir.dstu3.model.SearchParameter.SearchComparator.NE;
            case GT:
                return org.hl7.fhir.dstu3.model.SearchParameter.SearchComparator.GT;
            case LT:
                return org.hl7.fhir.dstu3.model.SearchParameter.SearchComparator.LT;
            case GE:
                return org.hl7.fhir.dstu3.model.SearchParameter.SearchComparator.GE;
            case LE:
                return org.hl7.fhir.dstu3.model.SearchParameter.SearchComparator.LE;
            case SA:
                return org.hl7.fhir.dstu3.model.SearchParameter.SearchComparator.SA;
            case EB:
                return org.hl7.fhir.dstu3.model.SearchParameter.SearchComparator.EB;
            case AP:
                return org.hl7.fhir.dstu3.model.SearchParameter.SearchComparator.AP;
            default:
                return org.hl7.fhir.dstu3.model.SearchParameter.SearchComparator.NULL;
        }
    }

    static public org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode convertSearchModifierCode(org.hl7.fhir.dstu3.model.SearchParameter.SearchModifierCode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case MISSING:
                return org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode.MISSING;
            case EXACT:
                return org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode.EXACT;
            case CONTAINS:
                return org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode.CONTAINS;
            case NOT:
                return org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode.NOT;
            case TEXT:
                return org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode.TEXT;
            case IN:
                return org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode.IN;
            case NOTIN:
                return org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode.NOTIN;
            case BELOW:
                return org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode.BELOW;
            case ABOVE:
                return org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode.ABOVE;
            case TYPE:
                return org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode.TYPE;
            default:
                return org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.SearchParameter.SearchModifierCode convertSearchModifierCode(org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case MISSING:
                return org.hl7.fhir.dstu3.model.SearchParameter.SearchModifierCode.MISSING;
            case EXACT:
                return org.hl7.fhir.dstu3.model.SearchParameter.SearchModifierCode.EXACT;
            case CONTAINS:
                return org.hl7.fhir.dstu3.model.SearchParameter.SearchModifierCode.CONTAINS;
            case NOT:
                return org.hl7.fhir.dstu3.model.SearchParameter.SearchModifierCode.NOT;
            case TEXT:
                return org.hl7.fhir.dstu3.model.SearchParameter.SearchModifierCode.TEXT;
            case IN:
                return org.hl7.fhir.dstu3.model.SearchParameter.SearchModifierCode.IN;
            case NOTIN:
                return org.hl7.fhir.dstu3.model.SearchParameter.SearchModifierCode.NOTIN;
            case BELOW:
                return org.hl7.fhir.dstu3.model.SearchParameter.SearchModifierCode.BELOW;
            case ABOVE:
                return org.hl7.fhir.dstu3.model.SearchParameter.SearchModifierCode.ABOVE;
            case TYPE:
                return org.hl7.fhir.dstu3.model.SearchParameter.SearchModifierCode.TYPE;
            default:
                return org.hl7.fhir.dstu3.model.SearchParameter.SearchModifierCode.NULL;
        }
    }

    public static org.hl7.fhir.r5.model.SearchParameter convertSearchParameter(org.hl7.fhir.dstu3.model.SearchParameter src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.SearchParameter tgt = new org.hl7.fhir.r5.model.SearchParameter();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.r5.model.UriType) VersionConvertor_30_50.convertType(src.getUrlElement()));
        if (src.hasVersionElement())
            tgt.setVersionElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_30_50.convertType(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_30_50.convertType(src.getNameElement()));
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
        if (src.hasUseContext()) {
            for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_50.convertUsageContext(t));
        }
        if (src.hasJurisdiction()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_50.convertCodeableConcept(t));
        }
        if (src.hasPurposeElement())
            tgt.setPurposeElement((org.hl7.fhir.r5.model.MarkdownType) VersionConvertor_30_50.convertType(src.getPurposeElement()));
        if (src.hasCodeElement())
            tgt.setCodeElement((org.hl7.fhir.r5.model.CodeType) VersionConvertor_30_50.convertType(src.getCodeElement()));
        if (src.hasBase()) {
            for (org.hl7.fhir.dstu3.model.CodeType t : src.getBase()) tgt.addBase(t.getValue());
        }
        if (src.hasType())
            tgt.setType(VersionConvertor_30_50.convertSearchParamType(src.getType()));
        if (src.hasDerivedFrom())
            tgt.setDerivedFrom(src.getDerivedFrom());
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.r5.model.MarkdownType) VersionConvertor_30_50.convertType(src.getDescriptionElement()));
        if (src.hasExpressionElement())
            tgt.setExpressionElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_30_50.convertType(src.getExpressionElement()));
        if (src.hasXpathElement())
            tgt.setXpathElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_30_50.convertType(src.getXpathElement()));
        if (src.hasXpathUsage())
            tgt.setXpathUsage(convertXPathUsageType(src.getXpathUsage()));
        if (src.hasTarget()) {
            for (org.hl7.fhir.dstu3.model.CodeType t : src.getTarget()) tgt.addTarget(t.getValue());
        }
        if (src.hasComparator()) {
            for (org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.SearchParameter.SearchComparator> t : src.getComparator()) VersionConvertor_30_50.copyElement(t, tgt.addComparatorElement().setValue(convertSearchComparator(t.getValue())));
        }
        if (src.hasModifier()) {
            for (org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.SearchParameter.SearchModifierCode> t : src.getModifier()) VersionConvertor_30_50.copyElement(t, tgt.addModifierElement().setValue(convertSearchModifierCode(t.getValue())));
        }
        if (src.hasChain()) {
            for (org.hl7.fhir.dstu3.model.StringType t : src.getChain()) tgt.addChain(t.getValue());
        }
        if (src.hasComponent()) {
            for (org.hl7.fhir.dstu3.model.SearchParameter.SearchParameterComponentComponent t : src.getComponent()) tgt.addComponent(convertSearchParameterComponentComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.SearchParameter convertSearchParameter(org.hl7.fhir.r5.model.SearchParameter src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.SearchParameter tgt = new org.hl7.fhir.dstu3.model.SearchParameter();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.dstu3.model.UriType) VersionConvertor_30_50.convertType(src.getUrlElement()));
        if (src.hasVersionElement())
            tgt.setVersionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getNameElement()));
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
        if (src.hasUseContext()) {
            for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_50.convertUsageContext(t));
        }
        if (src.hasJurisdiction()) {
            for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_50.convertCodeableConcept(t));
        }
        if (src.hasPurposeElement())
            tgt.setPurposeElement((org.hl7.fhir.dstu3.model.MarkdownType) VersionConvertor_30_50.convertType(src.getPurposeElement()));
        if (src.hasCodeElement())
            tgt.setCodeElement((org.hl7.fhir.dstu3.model.CodeType) VersionConvertor_30_50.convertType(src.getCodeElement()));
        if (src.hasBase()) {
            for (org.hl7.fhir.r5.model.CodeType t : src.getBase()) tgt.addBase(t.getValue());
        }
        if (src.hasType())
            tgt.setType(VersionConvertor_30_50.convertSearchParamType(src.getType()));
        if (src.hasDerivedFrom())
            tgt.setDerivedFrom(src.getDerivedFrom());
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu3.model.MarkdownType) VersionConvertor_30_50.convertType(src.getDescriptionElement()));
        if (src.hasExpressionElement())
            tgt.setExpressionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getExpressionElement()));
        if (src.hasXpathElement())
            tgt.setXpathElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getXpathElement()));
        if (src.hasXpathUsage())
            tgt.setXpathUsage(convertXPathUsageType(src.getXpathUsage()));
        if (src.hasTarget()) {
            for (org.hl7.fhir.r5.model.CodeType t : src.getTarget()) tgt.addTarget(t.getValue());
        }
        if (src.hasComparator()) {
            for (org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SearchParameter.SearchComparator> t : src.getComparator()) VersionConvertor_30_50.copyElement(t, tgt.addComparatorElement().setValue(convertSearchComparator(t.getValue())));
        }
        if (src.hasModifier()) {
            for (org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode> t : src.getModifier()) VersionConvertor_30_50.copyElement(t, tgt.addModifierElement().setValue(convertSearchModifierCode(t.getValue())));
        }
        if (src.hasChain()) {
            for (org.hl7.fhir.r5.model.StringType t : src.getChain()) tgt.addChain(t.getValue());
        }
        if (src.hasComponent()) {
            for (org.hl7.fhir.r5.model.SearchParameter.SearchParameterComponentComponent t : src.getComponent()) tgt.addComponent(convertSearchParameterComponentComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.SearchParameter.SearchParameterComponentComponent convertSearchParameterComponentComponent(org.hl7.fhir.dstu3.model.SearchParameter.SearchParameterComponentComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.SearchParameter.SearchParameterComponentComponent tgt = new org.hl7.fhir.r5.model.SearchParameter.SearchParameterComponentComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasDefinition())
            tgt.setDefinitionElement(VersionConvertor_30_50.convertReferenceToCanonical(src.getDefinition()));
        if (src.hasExpressionElement())
            tgt.setExpressionElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_30_50.convertType(src.getExpressionElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.SearchParameter.SearchParameterComponentComponent convertSearchParameterComponentComponent(org.hl7.fhir.r5.model.SearchParameter.SearchParameterComponentComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.SearchParameter.SearchParameterComponentComponent tgt = new org.hl7.fhir.dstu3.model.SearchParameter.SearchParameterComponentComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasDefinition())
            tgt.setDefinition(VersionConvertor_30_50.convertCanonicalToReference(src.getDefinitionElement()));
        if (src.hasExpressionElement())
            tgt.setExpressionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getExpressionElement()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.SearchParameter.XPathUsageType convertXPathUsageType(org.hl7.fhir.dstu3.model.SearchParameter.XPathUsageType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case NORMAL:
                return org.hl7.fhir.r5.model.SearchParameter.XPathUsageType.NORMAL;
            case PHONETIC:
                return org.hl7.fhir.r5.model.SearchParameter.XPathUsageType.PHONETIC;
            case NEARBY:
                return org.hl7.fhir.r5.model.SearchParameter.XPathUsageType.NEARBY;
            case DISTANCE:
                return org.hl7.fhir.r5.model.SearchParameter.XPathUsageType.DISTANCE;
            case OTHER:
                return org.hl7.fhir.r5.model.SearchParameter.XPathUsageType.OTHER;
            default:
                return org.hl7.fhir.r5.model.SearchParameter.XPathUsageType.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.SearchParameter.XPathUsageType convertXPathUsageType(org.hl7.fhir.r5.model.SearchParameter.XPathUsageType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case NORMAL:
                return org.hl7.fhir.dstu3.model.SearchParameter.XPathUsageType.NORMAL;
            case PHONETIC:
                return org.hl7.fhir.dstu3.model.SearchParameter.XPathUsageType.PHONETIC;
            case NEARBY:
                return org.hl7.fhir.dstu3.model.SearchParameter.XPathUsageType.NEARBY;
            case DISTANCE:
                return org.hl7.fhir.dstu3.model.SearchParameter.XPathUsageType.DISTANCE;
            case OTHER:
                return org.hl7.fhir.dstu3.model.SearchParameter.XPathUsageType.OTHER;
            default:
                return org.hl7.fhir.dstu3.model.SearchParameter.XPathUsageType.NULL;
        }
    }
}
