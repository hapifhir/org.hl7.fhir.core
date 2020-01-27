package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class ImplementationGuide10_30 {

    public static org.hl7.fhir.dstu3.model.ImplementationGuide.GuideDependencyType convertGuideDependencyType(org.hl7.fhir.dstu2.model.ImplementationGuide.GuideDependencyType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case REFERENCE:
                return org.hl7.fhir.dstu3.model.ImplementationGuide.GuideDependencyType.REFERENCE;
            case INCLUSION:
                return org.hl7.fhir.dstu3.model.ImplementationGuide.GuideDependencyType.INCLUSION;
            default:
                return org.hl7.fhir.dstu3.model.ImplementationGuide.GuideDependencyType.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.ImplementationGuide.GuideDependencyType convertGuideDependencyType(org.hl7.fhir.dstu3.model.ImplementationGuide.GuideDependencyType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case REFERENCE:
                return org.hl7.fhir.dstu2.model.ImplementationGuide.GuideDependencyType.REFERENCE;
            case INCLUSION:
                return org.hl7.fhir.dstu2.model.ImplementationGuide.GuideDependencyType.INCLUSION;
            default:
                return org.hl7.fhir.dstu2.model.ImplementationGuide.GuideDependencyType.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.ImplementationGuide.GuidePageKind convertGuidePageKind(org.hl7.fhir.dstu2.model.ImplementationGuide.GuidePageKind src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PAGE:
                return org.hl7.fhir.dstu3.model.ImplementationGuide.GuidePageKind.PAGE;
            case EXAMPLE:
                return org.hl7.fhir.dstu3.model.ImplementationGuide.GuidePageKind.EXAMPLE;
            case LIST:
                return org.hl7.fhir.dstu3.model.ImplementationGuide.GuidePageKind.LIST;
            case INCLUDE:
                return org.hl7.fhir.dstu3.model.ImplementationGuide.GuidePageKind.INCLUDE;
            case DIRECTORY:
                return org.hl7.fhir.dstu3.model.ImplementationGuide.GuidePageKind.DIRECTORY;
            case DICTIONARY:
                return org.hl7.fhir.dstu3.model.ImplementationGuide.GuidePageKind.DICTIONARY;
            case TOC:
                return org.hl7.fhir.dstu3.model.ImplementationGuide.GuidePageKind.TOC;
            case RESOURCE:
                return org.hl7.fhir.dstu3.model.ImplementationGuide.GuidePageKind.RESOURCE;
            default:
                return org.hl7.fhir.dstu3.model.ImplementationGuide.GuidePageKind.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.ImplementationGuide.GuidePageKind convertGuidePageKind(org.hl7.fhir.dstu3.model.ImplementationGuide.GuidePageKind src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PAGE:
                return org.hl7.fhir.dstu2.model.ImplementationGuide.GuidePageKind.PAGE;
            case EXAMPLE:
                return org.hl7.fhir.dstu2.model.ImplementationGuide.GuidePageKind.EXAMPLE;
            case LIST:
                return org.hl7.fhir.dstu2.model.ImplementationGuide.GuidePageKind.LIST;
            case INCLUDE:
                return org.hl7.fhir.dstu2.model.ImplementationGuide.GuidePageKind.INCLUDE;
            case DIRECTORY:
                return org.hl7.fhir.dstu2.model.ImplementationGuide.GuidePageKind.DIRECTORY;
            case DICTIONARY:
                return org.hl7.fhir.dstu2.model.ImplementationGuide.GuidePageKind.DICTIONARY;
            case TOC:
                return org.hl7.fhir.dstu2.model.ImplementationGuide.GuidePageKind.TOC;
            case RESOURCE:
                return org.hl7.fhir.dstu2.model.ImplementationGuide.GuidePageKind.RESOURCE;
            default:
                return org.hl7.fhir.dstu2.model.ImplementationGuide.GuidePageKind.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.ImplementationGuide convertImplementationGuide(org.hl7.fhir.dstu2.model.ImplementationGuide src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ImplementationGuide tgt = new org.hl7.fhir.dstu3.model.ImplementationGuide();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        tgt.setUrl(src.getUrl());
        tgt.setVersion(src.getVersion());
        tgt.setName(src.getName());
        tgt.setStatus(VersionConvertor_10_30.convertConformanceResourceStatus(src.getStatus()));
        if (src.hasExperimental())
            tgt.setExperimental(src.getExperimental());
        tgt.setPublisher(src.getPublisher());
        for (org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuideContactComponent t : src.getContact()) tgt.addContact(convertImplementationGuideContactComponent(t));
        if (src.hasDate())
            tgt.setDate(src.getDate());
        tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getUseContext()) if (VersionConvertor_10_30.isJurisdiction(t))
            tgt.addJurisdiction(VersionConvertor_10_30.convertCodeableConcept(t));
        else
            tgt.addUseContext(VersionConvertor_10_30.convertCodeableConceptToUsageContext(t));
        tgt.setCopyright(src.getCopyright());
        tgt.setFhirVersion(src.getFhirVersion());
        for (org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuideDependencyComponent t : src.getDependency()) tgt.addDependency(convertImplementationGuideDependencyComponent(t));
        for (org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuidePackageComponent t : src.getPackage()) tgt.addPackage(convertImplementationGuidePackageComponent(t));
        for (org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuideGlobalComponent t : src.getGlobal()) tgt.addGlobal(convertImplementationGuideGlobalComponent(t));
        for (org.hl7.fhir.dstu2.model.UriType t : src.getBinary()) tgt.addBinary(t.getValue());
        tgt.setPage(convertImplementationGuidePageComponent(src.getPage()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ImplementationGuide convertImplementationGuide(org.hl7.fhir.dstu3.model.ImplementationGuide src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ImplementationGuide tgt = new org.hl7.fhir.dstu2.model.ImplementationGuide();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        tgt.setUrl(src.getUrl());
        tgt.setVersion(src.getVersion());
        tgt.setName(src.getName());
        tgt.setStatus(VersionConvertor_10_30.convertConformanceResourceStatus(src.getStatus()));
        if (src.hasExperimental())
            tgt.setExperimental(src.getExperimental());
        tgt.setPublisher(src.getPublisher());
        for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(convertImplementationGuideContactComponent(t));
        if (src.hasDate())
            tgt.setDate(src.getDate());
        tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext()) if (t.hasValueCodeableConcept())
            tgt.addUseContext(VersionConvertor_10_30.convertCodeableConcept(t.getValueCodeableConcept()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addUseContext(VersionConvertor_10_30.convertCodeableConcept(t));
        tgt.setCopyright(src.getCopyright());
        tgt.setFhirVersion(src.getFhirVersion());
        for (org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideDependencyComponent t : src.getDependency()) tgt.addDependency(convertImplementationGuideDependencyComponent(t));
        for (org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageComponent t : src.getPackage()) tgt.addPackage(convertImplementationGuidePackageComponent(t));
        for (org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideGlobalComponent t : src.getGlobal()) tgt.addGlobal(convertImplementationGuideGlobalComponent(t));
        for (org.hl7.fhir.dstu3.model.UriType t : src.getBinary()) tgt.addBinary(t.getValue());
        tgt.setPage(convertImplementationGuidePageComponent(src.getPage()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuideContactComponent convertImplementationGuideContactComponent(org.hl7.fhir.dstu3.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuideContactComponent tgt = new org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuideContactComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setName(src.getName());
        for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_30.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ContactDetail convertImplementationGuideContactComponent(org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuideContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ContactDetail tgt = new org.hl7.fhir.dstu3.model.ContactDetail();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setName(src.getName());
        for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_30.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuideDependencyComponent convertImplementationGuideDependencyComponent(org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideDependencyComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuideDependencyComponent tgt = new org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuideDependencyComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setType(convertGuideDependencyType(src.getType()));
        tgt.setUri(src.getUri());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideDependencyComponent convertImplementationGuideDependencyComponent(org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuideDependencyComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideDependencyComponent tgt = new org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideDependencyComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setType(convertGuideDependencyType(src.getType()));
        tgt.setUri(src.getUri());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuideGlobalComponent convertImplementationGuideGlobalComponent(org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideGlobalComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuideGlobalComponent tgt = new org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuideGlobalComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setType(src.getType());
        tgt.setProfile(VersionConvertor_10_30.convertReference(src.getProfile()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideGlobalComponent convertImplementationGuideGlobalComponent(org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuideGlobalComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideGlobalComponent tgt = new org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideGlobalComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setType(src.getType());
        tgt.setProfile(VersionConvertor_10_30.convertReference(src.getProfile()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuidePackageComponent convertImplementationGuidePackageComponent(org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuidePackageComponent tgt = new org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuidePackageComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setName(src.getName());
        tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageResourceComponent t : src.getResource()) tgt.addResource(convertImplementationGuidePackageResourceComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageComponent convertImplementationGuidePackageComponent(org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuidePackageComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageComponent tgt = new org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setName(src.getName());
        tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuidePackageResourceComponent t : src.getResource()) tgt.addResource(convertImplementationGuidePackageResourceComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageResourceComponent convertImplementationGuidePackageResourceComponent(org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuidePackageResourceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageResourceComponent tgt = new org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageResourceComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setExample(src.getPurpose() == org.hl7.fhir.dstu2.model.ImplementationGuide.GuideResourcePurpose.EXAMPLE);
        tgt.setName(src.getName());
        tgt.setDescription(src.getDescription());
        tgt.setAcronym(src.getAcronym());
        tgt.setSource(VersionConvertor_10_30.convertType(src.getSource()));
        tgt.setExampleFor(VersionConvertor_10_30.convertReference(src.getExampleFor()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuidePackageResourceComponent convertImplementationGuidePackageResourceComponent(org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageResourceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuidePackageResourceComponent tgt = new org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuidePackageResourceComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.getExample())
            tgt.setPurpose(org.hl7.fhir.dstu2.model.ImplementationGuide.GuideResourcePurpose.EXAMPLE);
        else
            tgt.setPurpose(org.hl7.fhir.dstu2.model.ImplementationGuide.GuideResourcePurpose.PROFILE);
        tgt.setName(src.getName());
        tgt.setDescription(src.getDescription());
        tgt.setAcronym(src.getAcronym());
        tgt.setSource(VersionConvertor_10_30.convertType(src.getSource()));
        tgt.setExampleFor(VersionConvertor_10_30.convertReference(src.getExampleFor()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuidePageComponent convertImplementationGuidePageComponent(org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePageComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuidePageComponent tgt = new org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuidePageComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setSource(src.getSource());
        tgt.setName(src.getTitle());
        tgt.setKind(convertGuidePageKind(src.getKind()));
        for (org.hl7.fhir.dstu3.model.CodeType t : src.getType()) tgt.addType(t.getValue());
        for (org.hl7.fhir.dstu3.model.StringType t : src.getPackage()) tgt.addPackage(t.getValue());
        tgt.setFormat(src.getFormat());
        for (org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePageComponent t : src.getPage()) tgt.addPage(convertImplementationGuidePageComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePageComponent convertImplementationGuidePageComponent(org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuidePageComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePageComponent tgt = new org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePageComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setSource(src.getSource());
        tgt.setTitle(src.getName());
        tgt.setKind(convertGuidePageKind(src.getKind()));
        for (org.hl7.fhir.dstu2.model.CodeType t : src.getType()) tgt.addType(t.getValue());
        for (org.hl7.fhir.dstu2.model.StringType t : src.getPackage()) tgt.addPackage(t.getValue());
        tgt.setFormat(src.getFormat());
        for (org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuidePageComponent t : src.getPage()) tgt.addPage(convertImplementationGuidePageComponent(t));
        return tgt;
    }
}
