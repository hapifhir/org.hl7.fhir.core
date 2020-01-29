package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.Enumeration;
import java.util.List;

public class ImplementationGuide30_40 {

    public static org.hl7.fhir.dstu3.model.ImplementationGuide convertImplementationGuide(org.hl7.fhir.r4.model.ImplementationGuide src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ImplementationGuide tgt = new org.hl7.fhir.dstu3.model.ImplementationGuide();
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
        if (src.hasContact()) {
            for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact()) tgt.addContact(VersionConvertor_30_40.convertContactDetail(t));
        }
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        if (src.hasUseContext()) {
            for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_40.convertUsageContext(t));
        }
        if (src.hasJurisdiction()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasCopyright())
            tgt.setCopyright(src.getCopyright());
        if (src.hasFhirVersion())
            for (Enumeration<org.hl7.fhir.r4.model.Enumerations.FHIRVersion> v : src.getFhirVersion()) {
                tgt.setFhirVersion(v.asStringValue());
                break;
            }
        if (src.hasDependsOn()) {
            for (org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDependsOnComponent t : src.getDependsOn()) tgt.addDependency(convertImplementationGuideDependencyComponent(t));
        }
        if (src.hasDefinition()) {
            for (org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent t : src.getDefinition().getGrouping()) tgt.addPackage(convertImplementationGuidePackageComponent(t));
        }
        for (org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent t : src.getDefinition().getResource()) {
            findPackage(tgt.getPackage(), t.getGroupingId()).addResource(convertImplementationGuidePackageResourceComponent(t));
        }
        if (src.hasGlobal()) {
            for (org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideGlobalComponent t : src.getGlobal()) tgt.addGlobal(convertImplementationGuideGlobalComponent(t));
        }
        if (src.getDefinition().hasPage())
            tgt.setPage(convertImplementationGuidePageComponent(src.getDefinition().getPage()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ImplementationGuide convertImplementationGuide(org.hl7.fhir.dstu3.model.ImplementationGuide src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ImplementationGuide tgt = new org.hl7.fhir.r4.model.ImplementationGuide();
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
        if (src.hasContact()) {
            for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(VersionConvertor_30_40.convertContactDetail(t));
        }
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        if (src.hasUseContext()) {
            for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_40.convertUsageContext(t));
        }
        if (src.hasJurisdiction()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasCopyright())
            tgt.setCopyright(src.getCopyright());
        if (src.hasFhirVersion())
            tgt.addFhirVersion(org.hl7.fhir.r4.model.Enumerations.FHIRVersion.fromCode(src.getFhirVersion()));
        if (src.hasDependency()) {
            for (org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideDependencyComponent t : src.getDependency()) tgt.addDependsOn(convertImplementationGuideDependencyComponent(t));
        }
        if (src.hasPackage()) {
            for (org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageComponent t : src.getPackage()) tgt.getDefinition().addGrouping(convertImplementationGuidePackageComponent(tgt.getDefinition(), t));
        }
        if (src.hasGlobal()) {
            for (org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideGlobalComponent t : src.getGlobal()) tgt.addGlobal(convertImplementationGuideGlobalComponent(t));
        }
        if (src.hasPage())
            tgt.getDefinition().setPage(convertImplementationGuidePageComponent(src.getPage()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideDependencyComponent convertImplementationGuideDependencyComponent(org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDependsOnComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideDependencyComponent tgt = new org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideDependencyComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        tgt.setType(org.hl7.fhir.dstu3.model.ImplementationGuide.GuideDependencyType.REFERENCE);
        if (src.hasUri())
            tgt.setUri(src.getUri());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDependsOnComponent convertImplementationGuideDependencyComponent(org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideDependencyComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDependsOnComponent tgt = new org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDependsOnComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasUri())
            tgt.setUri(src.getUri());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideGlobalComponent convertImplementationGuideGlobalComponent(org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideGlobalComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideGlobalComponent tgt = new org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideGlobalComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(src.getType());
        if (src.hasProfile())
            tgt.setProfile(VersionConvertor_30_40.convertCanonicalToReference(src.getProfileElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideGlobalComponent convertImplementationGuideGlobalComponent(org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideGlobalComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideGlobalComponent tgt = new org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideGlobalComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(src.getType());
        if (src.hasProfile())
            tgt.setProfileElement(VersionConvertor_30_40.convertReferenceToCanonical(src.getProfile()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageComponent convertImplementationGuidePackageComponent(org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageComponent tgt = new org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasId()) {
            tgt.setId(src.getId());
        }
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent convertImplementationGuidePackageComponent(org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionComponent context, org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent tgt = new org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent();
        tgt.setId("p" + (context.getGrouping().size() + 1));
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageResourceComponent t : src.getResource()) {
            org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent tn = convertImplementationGuidePackageResourceComponent(t);
            tn.setGroupingId(tgt.getId());
            context.addResource(tn);
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent convertImplementationGuidePackageResourceComponent(org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageResourceComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent tgt = new org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasExampleFor()) {
            org.hl7.fhir.r4.model.Type t = VersionConvertor_30_40.convertType(src.getExampleFor());
            tgt.setExample(t instanceof org.hl7.fhir.r4.model.Reference ? new org.hl7.fhir.r4.model.CanonicalType(((org.hl7.fhir.r4.model.Reference) t).getReference()) : t);
        } else if (src.hasExample())
            tgt.setExample(new org.hl7.fhir.r4.model.BooleanType(src.getExample()));
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        if (src.hasSourceReference())
            tgt.setReference(VersionConvertor_30_40.convertReference(src.getSourceReference()));
        else if (src.hasSourceUriType())
            tgt.setReference(new org.hl7.fhir.r4.model.Reference(src.getSourceUriType().getValue()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageResourceComponent convertImplementationGuidePackageResourceComponent(org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageResourceComponent tgt = new org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageResourceComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasExampleCanonicalType()) {
            if (src.hasExampleCanonicalType()) {
                tgt.setExampleFor(VersionConvertor_30_40.convertCanonicalToReference(src.getExampleCanonicalType()));
            }
            tgt.setExample(true);
        } else if (src.hasExampleBooleanType())
            tgt.setExample(src.getExampleBooleanType().getValue());
        else
            tgt.setExample(false);
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        if (src.hasReference())
            tgt.setSource(VersionConvertor_30_40.convertReference(src.getReference()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePageComponent convertImplementationGuidePageComponent(org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePageComponent tgt = new org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePageComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasNameUrlType())
            tgt.setSource(src.getNameUrlType().getValue());
        if (src.hasTitle())
            tgt.setTitle(src.getTitle());
        if (src.hasGeneration())
            tgt.setKind(convertPageGeneration(src.getGeneration()));
        if (src.hasPage()) {
            for (org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent t : src.getPage()) tgt.addPage(convertImplementationGuidePageComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent convertImplementationGuidePageComponent(org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePageComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent tgt = new org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasSource())
            tgt.setName(convertUriToUrl(src.getSourceElement()));
        if (src.hasTitle())
            tgt.setTitle(src.getTitle());
        if (src.hasKind())
            tgt.setGeneration(convertPageGeneration(src.getKind()));
        if (src.hasPage()) {
            for (org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePageComponent t : src.getPage()) tgt.addPage(convertImplementationGuidePageComponent(t));
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.ImplementationGuide.GuidePageGeneration convertPageGeneration(org.hl7.fhir.dstu3.model.ImplementationGuide.GuidePageKind kind) {
        switch(kind) {
            case PAGE:
                return org.hl7.fhir.r4.model.ImplementationGuide.GuidePageGeneration.HTML;
            default:
                return org.hl7.fhir.r4.model.ImplementationGuide.GuidePageGeneration.GENERATED;
        }
    }

    static public org.hl7.fhir.dstu3.model.ImplementationGuide.GuidePageKind convertPageGeneration(org.hl7.fhir.r4.model.ImplementationGuide.GuidePageGeneration generation) {
        switch(generation) {
            case HTML:
                return org.hl7.fhir.dstu3.model.ImplementationGuide.GuidePageKind.PAGE;
            default:
                return org.hl7.fhir.dstu3.model.ImplementationGuide.GuidePageKind.RESOURCE;
        }
    }

    public static org.hl7.fhir.r4.model.UrlType convertUriToUrl(org.hl7.fhir.dstu3.model.UriType src) throws FHIRException {
        org.hl7.fhir.r4.model.UrlType tgt = new org.hl7.fhir.r4.model.UrlType(src.getValue());
        VersionConvertor_30_40.copyElement(src, tgt);
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageComponent findPackage(List<org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageComponent> definition, String id) {
        for (org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageComponent t : definition) if (t.getId().equals(id))
            return t;
        org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageComponent t1 = new org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageComponent();
        t1.setName("Default Package");
        t1.setId(id);
        return t1;
    }
}
