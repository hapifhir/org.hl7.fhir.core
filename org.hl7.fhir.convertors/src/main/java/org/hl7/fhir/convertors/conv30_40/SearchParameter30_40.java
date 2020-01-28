package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class SearchParameter30_40 {

    static public org.hl7.fhir.r4.model.SearchParameter.SearchComparator convertSearchComparator(org.hl7.fhir.dstu3.model.SearchParameter.SearchComparator src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case EQ:
                return org.hl7.fhir.r4.model.SearchParameter.SearchComparator.EQ;
            case NE:
                return org.hl7.fhir.r4.model.SearchParameter.SearchComparator.NE;
            case GT:
                return org.hl7.fhir.r4.model.SearchParameter.SearchComparator.GT;
            case LT:
                return org.hl7.fhir.r4.model.SearchParameter.SearchComparator.LT;
            case GE:
                return org.hl7.fhir.r4.model.SearchParameter.SearchComparator.GE;
            case LE:
                return org.hl7.fhir.r4.model.SearchParameter.SearchComparator.LE;
            case SA:
                return org.hl7.fhir.r4.model.SearchParameter.SearchComparator.SA;
            case EB:
                return org.hl7.fhir.r4.model.SearchParameter.SearchComparator.EB;
            case AP:
                return org.hl7.fhir.r4.model.SearchParameter.SearchComparator.AP;
            default:
                return org.hl7.fhir.r4.model.SearchParameter.SearchComparator.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.SearchParameter.SearchComparator convertSearchComparator(org.hl7.fhir.r4.model.SearchParameter.SearchComparator src) throws FHIRException {
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

    static public org.hl7.fhir.dstu3.model.SearchParameter.SearchModifierCode convertSearchModifierCode(org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode src) throws FHIRException {
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

    static public org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode convertSearchModifierCode(org.hl7.fhir.dstu3.model.SearchParameter.SearchModifierCode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case MISSING:
                return org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode.MISSING;
            case EXACT:
                return org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode.EXACT;
            case CONTAINS:
                return org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode.CONTAINS;
            case NOT:
                return org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode.NOT;
            case TEXT:
                return org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode.TEXT;
            case IN:
                return org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode.IN;
            case NOTIN:
                return org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode.NOTIN;
            case BELOW:
                return org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode.BELOW;
            case ABOVE:
                return org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode.ABOVE;
            case TYPE:
                return org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode.TYPE;
            default:
                return org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.SearchParameter convertSearchParameter(org.hl7.fhir.r4.model.SearchParameter src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.SearchParameter tgt = new org.hl7.fhir.dstu3.model.SearchParameter();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrl(src.getUrl());
        if (src.hasVersion())
            tgt.setVersion(src.getVersion());
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasStatus())
            tgt.setStatus(VersionConvertor_30_40.convertPublicationStatus(src.getStatus()));
        if (src.hasExperimental())
            tgt.setExperimental(src.getExperimental());
        if (src.hasDateElement())
            tgt.setDateElement(VersionConvertor_30_40.convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisher(src.getPublisher());
        for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact()) tgt.addContact(VersionConvertor_30_40.convertContactDetail(t));
        for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_40.convertUsageContext(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_40.convertCodeableConcept(t));
        if (src.hasPurpose())
            tgt.setPurpose(src.getPurpose());
        if (src.hasCode())
            tgt.setCode(src.getCode());
        for (org.hl7.fhir.r4.model.CodeType t : src.getBase()) tgt.addBase(t.getValue());
        if (src.hasType())
            tgt.setType(VersionConvertor_30_40.convertSearchParamType(src.getType()));
        if (src.hasDerivedFrom())
            tgt.setDerivedFrom(src.getDerivedFrom());
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        if (src.hasExpression())
            tgt.setExpression(src.getExpression());
        if (src.hasXpath())
            tgt.setXpath(src.getXpath());
        if (src.hasXpathUsage())
            tgt.setXpathUsage(convertXPathUsageType(src.getXpathUsage()));
        for (org.hl7.fhir.r4.model.CodeType t : src.getTarget()) tgt.addTarget(t.getValue());
        for (org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.SearchParameter.SearchComparator> t : src.getComparator()) VersionConvertor_30_40.copyElement(t, tgt.addComparatorElement().setValue(convertSearchComparator(t.getValue())));
        for (org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode> t : src.getModifier()) VersionConvertor_30_40.copyElement(t, tgt.addModifierElement().setValue(convertSearchModifierCode(t.getValue())));
        for (org.hl7.fhir.r4.model.StringType t : src.getChain()) tgt.addChain(t.getValue());
        for (org.hl7.fhir.r4.model.SearchParameter.SearchParameterComponentComponent t : src.getComponent()) tgt.addComponent(convertSearchParameterComponentComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.SearchParameter convertSearchParameter(org.hl7.fhir.dstu3.model.SearchParameter src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.SearchParameter tgt = new org.hl7.fhir.r4.model.SearchParameter();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrl(src.getUrl());
        if (src.hasVersion())
            tgt.setVersion(src.getVersion());
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasStatus())
            tgt.setStatus(VersionConvertor_30_40.convertPublicationStatus(src.getStatus()));
        if (src.hasExperimental())
            tgt.setExperimental(src.getExperimental());
        if (src.hasDateElement())
            tgt.setDateElement(VersionConvertor_30_40.convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisher(src.getPublisher());
        for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(VersionConvertor_30_40.convertContactDetail(t));
        for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_40.convertUsageContext(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_40.convertCodeableConcept(t));
        if (src.hasPurpose())
            tgt.setPurpose(src.getPurpose());
        if (src.hasCode())
            tgt.setCode(src.getCode());
        for (org.hl7.fhir.dstu3.model.CodeType t : src.getBase()) tgt.addBase(t.getValue());
        if (src.hasType())
            tgt.setType(VersionConvertor_30_40.convertSearchParamType(src.getType()));
        if (src.hasDerivedFrom())
            tgt.setDerivedFrom(src.getDerivedFrom());
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        if (src.hasExpression())
            tgt.setExpression(src.getExpression());
        if (src.hasXpath())
            tgt.setXpath(src.getXpath());
        if (src.hasXpathUsage())
            tgt.setXpathUsage(convertXPathUsageType(src.getXpathUsage()));
        for (org.hl7.fhir.dstu3.model.CodeType t : src.getTarget()) tgt.addTarget(t.getValue());
        for (org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.SearchParameter.SearchComparator> t : src.getComparator()) VersionConvertor_30_40.copyElement(t, tgt.addComparatorElement().setValue(convertSearchComparator(t.getValue())));
        for (org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.SearchParameter.SearchModifierCode> t : src.getModifier()) VersionConvertor_30_40.copyElement(t, tgt.addModifierElement().setValue(convertSearchModifierCode(t.getValue())));
        for (org.hl7.fhir.dstu3.model.StringType t : src.getChain()) tgt.addChain(t.getValue());
        for (org.hl7.fhir.dstu3.model.SearchParameter.SearchParameterComponentComponent t : src.getComponent()) tgt.addComponent(convertSearchParameterComponentComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.SearchParameter.SearchParameterComponentComponent convertSearchParameterComponentComponent(org.hl7.fhir.r4.model.SearchParameter.SearchParameterComponentComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.SearchParameter.SearchParameterComponentComponent tgt = new org.hl7.fhir.dstu3.model.SearchParameter.SearchParameterComponentComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasDefinition())
            tgt.setDefinition(VersionConvertor_30_40.convertCanonicalToReference(src.getDefinitionElement()));
        if (src.hasExpression())
            tgt.setExpression(src.getExpression());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.SearchParameter.SearchParameterComponentComponent convertSearchParameterComponentComponent(org.hl7.fhir.dstu3.model.SearchParameter.SearchParameterComponentComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.SearchParameter.SearchParameterComponentComponent tgt = new org.hl7.fhir.r4.model.SearchParameter.SearchParameterComponentComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasDefinition())
            tgt.setDefinitionElement(VersionConvertor_30_40.convertReferenceToCanonical(src.getDefinition()));
        if (src.hasExpression())
            tgt.setExpression(src.getExpression());
        return tgt;
    }

    static public org.hl7.fhir.r4.model.SearchParameter.XPathUsageType convertXPathUsageType(org.hl7.fhir.dstu3.model.SearchParameter.XPathUsageType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case NORMAL:
                return org.hl7.fhir.r4.model.SearchParameter.XPathUsageType.NORMAL;
            case PHONETIC:
                return org.hl7.fhir.r4.model.SearchParameter.XPathUsageType.PHONETIC;
            case NEARBY:
                return org.hl7.fhir.r4.model.SearchParameter.XPathUsageType.NEARBY;
            case DISTANCE:
                return org.hl7.fhir.r4.model.SearchParameter.XPathUsageType.DISTANCE;
            case OTHER:
                return org.hl7.fhir.r4.model.SearchParameter.XPathUsageType.OTHER;
            default:
                return org.hl7.fhir.r4.model.SearchParameter.XPathUsageType.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.SearchParameter.XPathUsageType convertXPathUsageType(org.hl7.fhir.r4.model.SearchParameter.XPathUsageType src) throws FHIRException {
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
