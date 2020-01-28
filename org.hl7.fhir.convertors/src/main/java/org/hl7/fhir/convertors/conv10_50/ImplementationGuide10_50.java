package org.hl7.fhir.convertors.conv10_50;

import org.hl7.fhir.convertors.VersionConvertor_10_50;
import org.hl7.fhir.dstu2.model.ImplementationGuide.GuidePageKind;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.Enumeration;
import org.hl7.fhir.r5.model.ImplementationGuide.GuidePageGeneration;

import java.util.List;

public class ImplementationGuide10_50 {

    public static org.hl7.fhir.r5.model.ImplementationGuide convertImplementationGuide(org.hl7.fhir.dstu2.model.ImplementationGuide src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ImplementationGuide tgt = new org.hl7.fhir.r5.model.ImplementationGuide();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        tgt.setUrl(src.getUrl());
        tgt.setVersion(src.getVersion());
        tgt.setName(src.getName());
        tgt.setStatus(VersionConvertor_10_50.convertConformanceResourceStatus(src.getStatus()));
        if (src.hasExperimental())
            tgt.setExperimental(src.getExperimental());
        tgt.setPublisher(src.getPublisher());
        for (org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuideContactComponent t : src.getContact()) tgt.addContact(convertImplementationGuideContactComponent(t));
        if (src.hasDate())
            tgt.setDate(src.getDate());
        tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getUseContext()) if (VersionConvertor_10_50.isJurisdiction(t))
            tgt.addJurisdiction(VersionConvertor_10_50.convertCodeableConcept(t));
        else
            tgt.addUseContext(VersionConvertor_10_50.convertCodeableConceptToUsageContext(t));
        tgt.setCopyright(src.getCopyright());
        if (src.hasFhirVersion()) {
            tgt.addFhirVersion(org.hl7.fhir.r5.model.Enumerations.FHIRVersion.fromCode(src.getFhirVersion()));
        }
        for (org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuideDependencyComponent t : src.getDependency()) tgt.addDependsOn(convertImplementationGuideDependencyComponent(t));
        for (org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuidePackageComponent t : src.getPackage()) tgt.getDefinition().addGrouping(convertImplementationGuidePackageComponent(tgt.getDefinition(), t));
        for (org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuideGlobalComponent t : src.getGlobal()) tgt.addGlobal(convertImplementationGuideGlobalComponent(t));
        tgt.getDefinition().setPage(convertImplementationGuidePageComponent(src.getPage()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ImplementationGuide convertImplementationGuide(org.hl7.fhir.r5.model.ImplementationGuide src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ImplementationGuide tgt = new org.hl7.fhir.dstu2.model.ImplementationGuide();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        tgt.setUrl(src.getUrl());
        tgt.setVersion(src.getVersion());
        tgt.setName(src.getName());
        tgt.setStatus(VersionConvertor_10_50.convertConformanceResourceStatus(src.getStatus()));
        if (src.hasExperimental())
            tgt.setExperimental(src.getExperimental());
        tgt.setPublisher(src.getPublisher());
        for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact()) tgt.addContact(convertImplementationGuideContactComponent(t));
        if (src.hasDate())
            tgt.setDate(src.getDate());
        tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext()) if (t.hasValueCodeableConcept())
            tgt.addUseContext(VersionConvertor_10_50.convertCodeableConcept(t.getValueCodeableConcept()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction()) tgt.addUseContext(VersionConvertor_10_50.convertCodeableConcept(t));
        tgt.setCopyright(src.getCopyright());
        for (Enumeration<org.hl7.fhir.r5.model.Enumerations.FHIRVersion> v : src.getFhirVersion()) {
            tgt.setFhirVersion(v.asStringValue());
        }
        for (org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDependsOnComponent t : src.getDependsOn()) tgt.addDependency(convertImplementationGuideDependencyComponent(t));
        for (org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent t : src.getDefinition().getGrouping()) tgt.addPackage(convertImplementationGuidePackageComponent(t));
        for (org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent t : src.getDefinition().getResource()) findPackage(tgt.getPackage(), t.getGroupingId()).addResource(convertImplementationGuidePackageResourceComponent(t));
        for (org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideGlobalComponent t : src.getGlobal()) tgt.addGlobal(convertImplementationGuideGlobalComponent(t));
        tgt.setPage(convertImplementationGuidePageComponent(src.getDefinition().getPage()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuideContactComponent convertImplementationGuideContactComponent(org.hl7.fhir.r5.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuideContactComponent tgt = new org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuideContactComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setName(src.getName());
        for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_50.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ContactDetail convertImplementationGuideContactComponent(org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuideContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ContactDetail tgt = new org.hl7.fhir.r5.model.ContactDetail();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setName(src.getName());
        for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_50.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuideDependencyComponent convertImplementationGuideDependencyComponent(org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDependsOnComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuideDependencyComponent tgt = new org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuideDependencyComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setType(org.hl7.fhir.dstu2.model.ImplementationGuide.GuideDependencyType.REFERENCE);
        tgt.setUri(src.getUri());
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDependsOnComponent convertImplementationGuideDependencyComponent(org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuideDependencyComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDependsOnComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDependsOnComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setUri(src.getUri());
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideGlobalComponent convertImplementationGuideGlobalComponent(org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuideGlobalComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideGlobalComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideGlobalComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setType(src.getType());
        tgt.setProfileElement(VersionConvertor_10_50.convertReferenceToCanonical(src.getProfile()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuideGlobalComponent convertImplementationGuideGlobalComponent(org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideGlobalComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuideGlobalComponent tgt = new org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuideGlobalComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasType()) {
            tgt.setType(src.getType());
        }
        tgt.setProfile(VersionConvertor_10_50.convertCanonicalToReference(src.getProfileElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuidePackageComponent convertImplementationGuidePackageComponent(org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuidePackageComponent tgt = new org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuidePackageComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setId(src.getId());
        tgt.setName(src.getName());
        tgt.setDescription(src.getDescription());
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent convertImplementationGuidePackageComponent(org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionComponent context, org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuidePackageComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent();
        tgt.setId("p" + (context.getGrouping().size() + 1));
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuidePackageResourceComponent t : src.getResource()) {
            org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent tn = convertImplementationGuidePackageResourceComponent(t);
            tn.setGroupingId(tgt.getId());
            context.addResource(tn);
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuidePackageResourceComponent convertImplementationGuidePackageResourceComponent(org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuidePackageResourceComponent tgt = new org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuidePackageResourceComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasExampleCanonicalType())
            tgt.setExampleFor(VersionConvertor_10_50.convertCanonicalToReference(src.getExampleCanonicalType()));
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        if (src.hasReference())
            tgt.setSource(VersionConvertor_10_50.convertReference(src.getReference()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent convertImplementationGuidePackageResourceComponent(org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuidePackageResourceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasExampleFor())
            tgt.setExample(VersionConvertor_10_50.convertReferenceToCanonical(src.getExampleFor()));
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        if (src.hasSourceReference())
            tgt.setReference(VersionConvertor_10_50.convertReference(src.getSourceReference()));
        else if (src.hasSourceUriType())
            tgt.setReference(new org.hl7.fhir.r5.model.Reference(src.getSourceUriType().getValue()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent convertImplementationGuidePageComponent(org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuidePageComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasSource()) {
            tgt.setName(convertUriToUrl(src.getSourceElement()));
        }
        tgt.setTitle(src.getName());
        if (src.hasKind())
            tgt.setGeneration(convertPageGeneration(src.getKind()));
        for (org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuidePageComponent t : src.getPage()) tgt.addPage(convertImplementationGuidePageComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuidePageComponent convertImplementationGuidePageComponent(org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuidePageComponent tgt = new org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuidePageComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasNameUrlType())
            tgt.setSource(src.getNameUrlType().getValue());
        tgt.setName(src.getTitle());
        if (src.hasGeneration())
            tgt.setKind(convertPageGeneration(src.getGeneration()));
        for (org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent t : src.getPage()) tgt.addPage(convertImplementationGuidePageComponent(t));
        return tgt;
    }

    static public GuidePageKind convertPageGeneration(GuidePageGeneration generation) {
        switch(generation) {
            case HTML:
                return GuidePageKind.PAGE;
            default:
                return GuidePageKind.RESOURCE;
        }
    }

    static public GuidePageGeneration convertPageGeneration(GuidePageKind kind) {
        switch(kind) {
            case PAGE:
                return GuidePageGeneration.HTML;
            default:
                return GuidePageGeneration.GENERATED;
        }
    }

    public static org.hl7.fhir.r5.model.UrlType convertUriToUrl(org.hl7.fhir.dstu2.model.UriType src) throws FHIRException {
        org.hl7.fhir.r5.model.UrlType tgt = new org.hl7.fhir.r5.model.UrlType(src.getValue());
        VersionConvertor_10_50.copyElement(src, tgt);
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuidePackageComponent findPackage(List<org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuidePackageComponent> definition, String id) {
        if (id != null)
            for (org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuidePackageComponent t : definition) if (id.equals(t.getId()))
                return t;
        org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuidePackageComponent t = new org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuidePackageComponent();
        t.setName("Default Package");
        t.setId(id);
        return t;
    }
}
