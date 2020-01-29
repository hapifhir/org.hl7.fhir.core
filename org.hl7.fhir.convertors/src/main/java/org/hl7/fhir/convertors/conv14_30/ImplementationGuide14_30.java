package org.hl7.fhir.convertors.conv14_30;

import org.hl7.fhir.convertors.VersionConvertor_14_30;
import org.hl7.fhir.exceptions.FHIRException;

public class ImplementationGuide14_30 {

    static public org.hl7.fhir.dstu3.model.ImplementationGuide.GuideDependencyType convertGuideDependencyType(org.hl7.fhir.dstu2016may.model.ImplementationGuide.GuideDependencyType src) throws FHIRException {
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

    static public org.hl7.fhir.dstu2016may.model.ImplementationGuide.GuideDependencyType convertGuideDependencyType(org.hl7.fhir.dstu3.model.ImplementationGuide.GuideDependencyType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case REFERENCE:
                return org.hl7.fhir.dstu2016may.model.ImplementationGuide.GuideDependencyType.REFERENCE;
            case INCLUSION:
                return org.hl7.fhir.dstu2016may.model.ImplementationGuide.GuideDependencyType.INCLUSION;
            default:
                return org.hl7.fhir.dstu2016may.model.ImplementationGuide.GuideDependencyType.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.ImplementationGuide.GuidePageKind convertGuidePageKind(org.hl7.fhir.dstu2016may.model.ImplementationGuide.GuidePageKind src) throws FHIRException {
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

    static public org.hl7.fhir.dstu2016may.model.ImplementationGuide.GuidePageKind convertGuidePageKind(org.hl7.fhir.dstu3.model.ImplementationGuide.GuidePageKind src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PAGE:
                return org.hl7.fhir.dstu2016may.model.ImplementationGuide.GuidePageKind.PAGE;
            case EXAMPLE:
                return org.hl7.fhir.dstu2016may.model.ImplementationGuide.GuidePageKind.EXAMPLE;
            case LIST:
                return org.hl7.fhir.dstu2016may.model.ImplementationGuide.GuidePageKind.LIST;
            case INCLUDE:
                return org.hl7.fhir.dstu2016may.model.ImplementationGuide.GuidePageKind.INCLUDE;
            case DIRECTORY:
                return org.hl7.fhir.dstu2016may.model.ImplementationGuide.GuidePageKind.DIRECTORY;
            case DICTIONARY:
                return org.hl7.fhir.dstu2016may.model.ImplementationGuide.GuidePageKind.DICTIONARY;
            case TOC:
                return org.hl7.fhir.dstu2016may.model.ImplementationGuide.GuidePageKind.TOC;
            case RESOURCE:
                return org.hl7.fhir.dstu2016may.model.ImplementationGuide.GuidePageKind.RESOURCE;
            default:
                return org.hl7.fhir.dstu2016may.model.ImplementationGuide.GuidePageKind.NULL;
        }
    }

    public static org.hl7.fhir.dstu2016may.model.ImplementationGuide convertImplementationGuide(org.hl7.fhir.dstu3.model.ImplementationGuide src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ImplementationGuide tgt = new org.hl7.fhir.dstu2016may.model.ImplementationGuide();
        VersionConvertor_14_30.copyDomainResource(src, tgt);
        if (src.hasUrl()) {
            tgt.setUrl(src.getUrl());
        }
        if (src.hasVersion())
            tgt.setVersion(src.getVersion());
        if (src.hasName()) {
            tgt.setName(src.getName());
        }
        if (src.hasStatus()) {
            tgt.setStatus(VersionConvertor_14_30.convertConformanceResourceStatus(src.getStatus()));
        }
        if (src.hasExperimental())
            tgt.setExperimental(src.getExperimental());
        if (src.hasPublisher())
            tgt.setPublisher(src.getPublisher());
        if (src.hasContact()) {
            for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(convertImplementationGuideContactComponent(t));
        }
        if (src.hasDate())
            tgt.setDate(src.getDate());
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext()) if (t.hasValueCodeableConcept())
            tgt.addUseContext(VersionConvertor_14_30.convertCodeableConcept(t.getValueCodeableConcept()));
        if (src.hasJurisdiction()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addUseContext(VersionConvertor_14_30.convertCodeableConcept(t));
        }
        if (src.hasCopyright())
            tgt.setCopyright(src.getCopyright());
        if (src.hasFhirVersion())
            tgt.setFhirVersion(src.getFhirVersion());
        if (src.hasDependency()) {
            for (org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideDependencyComponent t : src.getDependency()) tgt.addDependency(convertImplementationGuideDependencyComponent(t));
        }
        if (src.hasPackage()) {
            for (org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageComponent t : src.getPackage()) tgt.addPackage(convertImplementationGuidePackageComponent(t));
        }
        if (src.hasGlobal()) {
            for (org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideGlobalComponent t : src.getGlobal()) tgt.addGlobal(convertImplementationGuideGlobalComponent(t));
        }
        if (src.hasBinary()) {
            for (org.hl7.fhir.dstu3.model.UriType t : src.getBinary()) tgt.addBinary(t.getValue());
        }
        if (src.hasPage()) {
            tgt.setPage(convertImplementationGuidePageComponent(src.getPage()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ImplementationGuide convertImplementationGuide(org.hl7.fhir.dstu2016may.model.ImplementationGuide src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ImplementationGuide tgt = new org.hl7.fhir.dstu3.model.ImplementationGuide();
        VersionConvertor_14_30.copyDomainResource(src, tgt);
        if (src.hasUrl()) {
            tgt.setUrl(src.getUrl());
        }
        if (src.hasVersion())
            tgt.setVersion(src.getVersion());
        if (src.hasName()) {
            tgt.setName(src.getName());
        }
        if (src.hasStatus()) {
            tgt.setStatus(VersionConvertor_14_30.convertConformanceResourceStatus(src.getStatus()));
        }
        if (src.hasExperimental())
            tgt.setExperimental(src.getExperimental());
        if (src.hasPublisher())
            tgt.setPublisher(src.getPublisher());
        if (src.hasContact()) {
            for (org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideContactComponent t : src.getContact()) tgt.addContact(convertImplementationGuideContactComponent(t));
        }
        if (src.hasDate())
            tgt.setDate(src.getDate());
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu2016may.model.CodeableConcept t : src.getUseContext()) if (VersionConvertor_14_30.isJurisdiction(t))
            tgt.addJurisdiction(VersionConvertor_14_30.convertCodeableConcept(t));
        else
            tgt.addUseContext(VersionConvertor_14_30.convertCodeableConceptToUsageContext(t));
        if (src.hasCopyright())
            tgt.setCopyright(src.getCopyright());
        if (src.hasFhirVersion())
            tgt.setFhirVersion(src.getFhirVersion());
        if (src.hasDependency()) {
            for (org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideDependencyComponent t : src.getDependency()) tgt.addDependency(convertImplementationGuideDependencyComponent(t));
        }
        if (src.hasPackage()) {
            for (org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePackageComponent t : src.getPackage()) tgt.addPackage(convertImplementationGuidePackageComponent(t));
        }
        if (src.hasGlobal()) {
            for (org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideGlobalComponent t : src.getGlobal()) tgt.addGlobal(convertImplementationGuideGlobalComponent(t));
        }
        if (src.hasBinary()) {
            for (org.hl7.fhir.dstu2016may.model.UriType t : src.getBinary()) tgt.addBinary(t.getValue());
        }
        if (src.hasPage()) {
            tgt.setPage(convertImplementationGuidePageComponent(src.getPage()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideContactComponent convertImplementationGuideContactComponent(org.hl7.fhir.dstu3.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideContactComponent tgt = new org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideContactComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasTelecom()) {
            for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_14_30.convertContactPoint(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ContactDetail convertImplementationGuideContactComponent(org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ContactDetail tgt = new org.hl7.fhir.dstu3.model.ContactDetail();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasTelecom()) {
            for (org.hl7.fhir.dstu2016may.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_14_30.convertContactPoint(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideDependencyComponent convertImplementationGuideDependencyComponent(org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideDependencyComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideDependencyComponent tgt = new org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideDependencyComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasType()) {
            tgt.setType(convertGuideDependencyType(src.getType()));
        }
        if (src.hasUri()) {
            tgt.setUri(src.getUri());
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideDependencyComponent convertImplementationGuideDependencyComponent(org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideDependencyComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideDependencyComponent tgt = new org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideDependencyComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasType()) {
            tgt.setType(convertGuideDependencyType(src.getType()));
        }
        if (src.hasUri()) {
            tgt.setUri(src.getUri());
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideGlobalComponent convertImplementationGuideGlobalComponent(org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideGlobalComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideGlobalComponent tgt = new org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideGlobalComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasType()) {
            tgt.setType(src.getType());
        }
        if (src.hasProfile()) {
            tgt.setProfile(VersionConvertor_14_30.convertReference(src.getProfile()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideGlobalComponent convertImplementationGuideGlobalComponent(org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideGlobalComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideGlobalComponent tgt = new org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideGlobalComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasType()) {
            tgt.setType(src.getType());
        }
        if (src.hasProfile()) {
            tgt.setProfile(VersionConvertor_14_30.convertReference(src.getProfile()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePackageComponent convertImplementationGuidePackageComponent(org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePackageComponent tgt = new org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePackageComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasName()) {
            tgt.setName(src.getName());
        }
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        if (src.hasResource()) {
            for (org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageResourceComponent t : src.getResource()) tgt.addResource(convertImplementationGuidePackageResourceComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageComponent convertImplementationGuidePackageComponent(org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePackageComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageComponent tgt = new org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasName()) {
            tgt.setName(src.getName());
        }
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        if (src.hasResource()) {
            for (org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePackageResourceComponent t : src.getResource()) tgt.addResource(convertImplementationGuidePackageResourceComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePackageResourceComponent convertImplementationGuidePackageResourceComponent(org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageResourceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePackageResourceComponent tgt = new org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePackageResourceComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasExample()) {
            tgt.setExample(src.getExample());
        }
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        if (src.hasAcronym())
            tgt.setAcronym(src.getAcronym());
        if (src.hasSource()) {
            tgt.setSource(VersionConvertor_14_30.convertType(src.getSource()));
        }
        if (src.hasExampleFor())
            tgt.setExampleFor(VersionConvertor_14_30.convertReference(src.getExampleFor()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageResourceComponent convertImplementationGuidePackageResourceComponent(org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePackageResourceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageResourceComponent tgt = new org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageResourceComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasExample()) {
            tgt.setExample(src.getExample());
        }
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        if (src.hasAcronym())
            tgt.setAcronym(src.getAcronym());
        if (src.hasSource()) {
            tgt.setSource(VersionConvertor_14_30.convertType(src.getSource()));
        }
        if (src.hasExampleFor())
            tgt.setExampleFor(VersionConvertor_14_30.convertReference(src.getExampleFor()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePageComponent convertImplementationGuidePageComponent(org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePageComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePageComponent tgt = new org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePageComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasSource()) {
            tgt.setSource(src.getSource());
        }
        if (src.hasName()) {
            tgt.setTitle(src.getName());
        }
        if (src.hasKind()) {
            tgt.setKind(convertGuidePageKind(src.getKind()));
        }
        if (src.hasType()) {
            for (org.hl7.fhir.dstu2016may.model.CodeType t : src.getType()) tgt.addType(t.getValue());
        }
        if (src.hasPackage()) {
            for (org.hl7.fhir.dstu2016may.model.StringType t : src.getPackage()) tgt.addPackage(t.getValue());
        }
        if (src.hasFormat())
            tgt.setFormat(src.getFormat());
        if (src.hasPage()) {
            for (org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePageComponent t : src.getPage()) tgt.addPage(convertImplementationGuidePageComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePageComponent convertImplementationGuidePageComponent(org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePageComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePageComponent tgt = new org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePageComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasSource()) {
            tgt.setSource(src.getSource());
        }
        if (src.hasTitle()) {
            tgt.setName(src.getTitle());
        }
        if (src.hasKind()) {
            tgt.setKind(convertGuidePageKind(src.getKind()));
        }
        if (src.hasType()) {
            for (org.hl7.fhir.dstu3.model.CodeType t : src.getType()) tgt.addType(t.getValue());
        }
        if (src.hasPackage()) {
            for (org.hl7.fhir.dstu3.model.StringType t : src.getPackage()) tgt.addPackage(t.getValue());
        }
        if (src.hasFormat())
            tgt.setFormat(src.getFormat());
        if (src.hasPage()) {
            for (org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePageComponent t : src.getPage()) tgt.addPage(convertImplementationGuidePageComponent(t));
        }
        return tgt;
    }
}
