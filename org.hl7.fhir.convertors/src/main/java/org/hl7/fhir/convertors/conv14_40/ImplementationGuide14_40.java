package org.hl7.fhir.convertors.conv14_40;

import java.util.List;
import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.VersionConvertor_14_40;
import org.hl7.fhir.dstu2016may.model.ImplementationGuide;
import org.hl7.fhir.dstu2016may.model.ImplementationGuide.GuidePageKind;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.CanonicalType;
import org.hl7.fhir.r4.model.Enumeration;
import org.hl7.fhir.r4.model.ImplementationGuide.GuidePageGeneration;
import org.hl7.fhir.r4.model.Type;

public class ImplementationGuide14_40 {

    public static org.hl7.fhir.dstu2016may.model.ImplementationGuide convertImplementationGuide(org.hl7.fhir.r4.model.ImplementationGuide src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ImplementationGuide tgt = new org.hl7.fhir.dstu2016may.model.ImplementationGuide();
        VersionConvertor_14_40.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement(VersionConvertor_14_40.convertUri(src.getUrlElement()));
        if (src.hasVersion())
            tgt.setVersionElement(VersionConvertor_14_40.convertString(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_14_40.convertString(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatusElement(VersionConvertor_14_40.convertConformanceResourceStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(VersionConvertor_14_40.convertBoolean(src.getExperimentalElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(VersionConvertor_14_40.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact()) tgt.addContact(convertImplementationGuideContactComponent(t));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_14_40.convertDateTime(src.getDateElement()));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext()) if (t.hasValueCodeableConcept())
            tgt.addUseContext(VersionConvertor_14_40.convertCodeableConcept(t.getValueCodeableConcept()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction()) tgt.addUseContext(VersionConvertor_14_40.convertCodeableConcept(t));
        if (src.hasCopyright())
            tgt.setCopyright(src.getCopyright());
        if (src.hasFhirVersion())
            for (Enumeration<org.hl7.fhir.r4.model.Enumerations.FHIRVersion> v : src.getFhirVersion()) {
                tgt.setFhirVersion(v.asStringValue());
            }
        for (org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDependsOnComponent t : src.getDependsOn()) tgt.addDependency(convertImplementationGuideDependencyComponent(t));
        for (org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent t : src.getDefinition().getGrouping()) tgt.addPackage(convertImplementationGuidePackageComponent(t));
        for (org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent t : src.getDefinition().getResource()) findPackage(tgt.getPackage(), t.getGroupingId()).addResource(convertImplementationGuidePackageResourceComponent(t));
        for (org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideGlobalComponent t : src.getGlobal()) tgt.addGlobal(convertImplementationGuideGlobalComponent(t));
        tgt.setPage(convertImplementationGuidePageComponent(src.getDefinition().getPage()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ImplementationGuide convertImplementationGuide(org.hl7.fhir.dstu2016may.model.ImplementationGuide src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ImplementationGuide tgt = new org.hl7.fhir.r4.model.ImplementationGuide();
        VersionConvertor_14_40.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement(VersionConvertor_14_40.convertUri(src.getUrlElement()));
        if (src.hasVersion())
            tgt.setVersionElement(VersionConvertor_14_40.convertString(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_14_40.convertString(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatusElement(VersionConvertor_14_40.convertConformanceResourceStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(VersionConvertor_14_40.convertBoolean(src.getExperimentalElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(VersionConvertor_14_40.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideContactComponent t : src.getContact()) tgt.addContact(convertImplementationGuideContactComponent(t));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_14_40.convertDateTime(src.getDateElement()));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu2016may.model.CodeableConcept t : src.getUseContext()) if (VersionConvertor_14_40.isJurisdiction(t))
            tgt.addJurisdiction(VersionConvertor_14_40.convertCodeableConcept(t));
        else
            tgt.addUseContext(VersionConvertor_14_40.convertCodeableConceptToUsageContext(t));
        if (src.hasCopyright())
            tgt.setCopyright(src.getCopyright());
        if (src.hasFhirVersion())
            tgt.addFhirVersion(org.hl7.fhir.r4.model.Enumerations.FHIRVersion.fromCode(src.getFhirVersion()));
        for (org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideDependencyComponent t : src.getDependency()) tgt.addDependsOn(convertImplementationGuideDependencyComponent(t));
        for (org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePackageComponent t : src.getPackage()) tgt.getDefinition().addGrouping(convertImplementationGuidePackageComponent(tgt.getDefinition(), t));
        for (org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideGlobalComponent t : src.getGlobal()) tgt.addGlobal(convertImplementationGuideGlobalComponent(t));
        tgt.getDefinition().setPage(convertImplementationGuidePageComponent(src.getPage()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ContactDetail convertImplementationGuideContactComponent(org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ContactDetail tgt = new org.hl7.fhir.r4.model.ContactDetail();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_14_40.convertString(src.getNameElement()));
        for (org.hl7.fhir.dstu2016may.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_14_40.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideContactComponent convertImplementationGuideContactComponent(org.hl7.fhir.r4.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideContactComponent tgt = new org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideContactComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_14_40.convertString(src.getNameElement()));
        for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_14_40.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideDependencyComponent convertImplementationGuideDependencyComponent(org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDependsOnComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideDependencyComponent tgt = new org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideDependencyComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        tgt.setType(org.hl7.fhir.dstu2016may.model.ImplementationGuide.GuideDependencyType.REFERENCE);
        if (src.hasUri())
            tgt.setUri(src.getUri());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDependsOnComponent convertImplementationGuideDependencyComponent(org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideDependencyComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDependsOnComponent tgt = new org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDependsOnComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasUri())
            tgt.setUri(src.getUri());
        if (org.hl7.fhir.dstu2016may.utils.ToolingExtensions.hasExtension(src, VersionConvertorConstants.IG_DEPENDSON_PACKAGE_EXTENSION)) {
            tgt.setPackageId(org.hl7.fhir.dstu2016may.utils.ToolingExtensions.readStringExtension(src, VersionConvertorConstants.IG_DEPENDSON_PACKAGE_EXTENSION));
        }
        if (org.hl7.fhir.dstu2016may.utils.ToolingExtensions.hasExtension(src, VersionConvertorConstants.IG_DEPENDSON_VERSION_EXTENSION)) {
            tgt.setVersion(org.hl7.fhir.dstu2016may.utils.ToolingExtensions.readStringExtension(src, VersionConvertorConstants.IG_DEPENDSON_VERSION_EXTENSION));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideGlobalComponent convertImplementationGuideGlobalComponent(org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideGlobalComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideGlobalComponent tgt = new org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideGlobalComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasTypeElement())
            tgt.setTypeElement(VersionConvertor_14_40.convertCode(src.getTypeElement()));
        if (src.hasProfile())
            tgt.setProfileElement(VersionConvertor_14_40.convertReferenceToCanonical(src.getProfile()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideGlobalComponent convertImplementationGuideGlobalComponent(org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideGlobalComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideGlobalComponent tgt = new org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideGlobalComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasTypeElement())
            tgt.setTypeElement(VersionConvertor_14_40.convertCode(src.getTypeElement()));
        if (src.hasProfileElement())
            tgt.setProfile(VersionConvertor_14_40.convertCanonicalToReference(src.getProfileElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent convertImplementationGuidePackageComponent(org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionComponent context, org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePackageComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent tgt = new org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent();
        tgt.setId("p" + (context.getGrouping().size() + 1));
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_14_40.convertString(src.getNameElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_14_40.convertString(src.getDescriptionElement()));
        for (org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePackageResourceComponent t : src.getResource()) {
            org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent tn = convertImplementationGuidePackageResourceComponent(t);
            tn.setGroupingId(tgt.getId());
            context.addResource(tn);
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePackageComponent convertImplementationGuidePackageComponent(org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePackageComponent tgt = new org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePackageComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        tgt.setId(src.getId());
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_14_40.convertString(src.getNameElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_14_40.convertString(src.getDescriptionElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePackageResourceComponent convertImplementationGuidePackageResourceComponent(org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePackageResourceComponent tgt = new org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePackageResourceComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasExampleCanonicalType()) {
            if (src.hasExampleCanonicalType())
                tgt.setExampleFor(VersionConvertor_14_40.convertCanonicalToReference(src.getExampleCanonicalType()));
            tgt.setExample(true);
        } else if (src.hasExampleBooleanType())
            tgt.setExample(src.getExampleBooleanType().getValue());
        else
            tgt.setExample(false);
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_14_40.convertString(src.getNameElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_14_40.convertString(src.getDescriptionElement()));
        if (src.hasReference())
            tgt.setSource(VersionConvertor_14_40.convertReference(src.getReference()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent convertImplementationGuidePackageResourceComponent(org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePackageResourceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent tgt = new org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasExampleFor()) {
            Type t = VersionConvertor_14_40.convertType(src.getExampleFor());
            tgt.setExample(t instanceof org.hl7.fhir.r4.model.Reference ? new CanonicalType(((org.hl7.fhir.r4.model.Reference) t).getReference()) : t);
        } else if (src.hasExample())
            tgt.setExample(new org.hl7.fhir.r4.model.BooleanType(src.getExample()));
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_14_40.convertString(src.getNameElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_14_40.convertString(src.getDescriptionElement()));
        if (src.hasSourceReference())
            tgt.setReference(VersionConvertor_14_40.convertReference(src.getSourceReference()));
        else if (src.hasSourceUriType())
            tgt.setReference(new org.hl7.fhir.r4.model.Reference(src.getSourceUriType().getValue()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent convertImplementationGuidePageComponent(org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePageComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent tgt = new org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasSource())
            tgt.setName(convertUriToUrl(src.getSourceElement()));
        if (src.hasNameElement())
            tgt.setTitleElement(VersionConvertor_14_40.convertString(src.getNameElement()));
        if (src.hasKind())
            tgt.setGeneration(convertPageGeneration(src.getKind()));
        for (org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePageComponent t : src.getPage()) tgt.addPage(convertImplementationGuidePageComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePageComponent convertImplementationGuidePageComponent(org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePageComponent tgt = new org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePageComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasNameUrlType())
            tgt.setSource(src.getNameUrlType().getValue());
        if (src.hasTitleElement())
            tgt.setNameElement(VersionConvertor_14_40.convertString(src.getTitleElement()));
        if (src.hasGeneration())
            tgt.setKind(convertPageGeneration(src.getGeneration()));
        for (org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent t : src.getPage()) tgt.addPage(convertImplementationGuidePageComponent(t));
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

    public static org.hl7.fhir.r4.model.UrlType convertUriToUrl(org.hl7.fhir.dstu2016may.model.UriType src) throws FHIRException {
        org.hl7.fhir.r4.model.UrlType tgt = new org.hl7.fhir.r4.model.UrlType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        VersionConvertor_14_40.copyElement(src, tgt);
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePackageComponent findPackage(List<ImplementationGuide.ImplementationGuidePackageComponent> definition, String id) {
        for (org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePackageComponent t : definition) if (t.getId().equals(id))
            return t;
        org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePackageComponent t = new org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePackageComponent();
        t.setName("Default Package");
        t.setId(id);
        return t;
    }
}