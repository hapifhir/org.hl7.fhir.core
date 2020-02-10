package org.hl7.fhir.convertors.conv14_40;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.VersionConvertor_14_40;
import org.hl7.fhir.dstu2016may.model.IdType;
import org.hl7.fhir.dstu2016may.model.ImplementationGuide.GuidePageKind;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.CanonicalType;
import org.hl7.fhir.r4.model.Enumeration;
import org.hl7.fhir.r4.model.ImplementationGuide.GuidePageGeneration;
import org.hl7.fhir.r4.model.StringType;
import org.hl7.fhir.r4.model.Type;
import java.util.List;
import java.util.Collections;

public class ImplementationGuide14_40 {

    public static org.hl7.fhir.dstu2016may.model.ImplementationGuide convertImplementationGuide(org.hl7.fhir.r4.model.ImplementationGuide src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ImplementationGuide tgt = new org.hl7.fhir.dstu2016may.model.ImplementationGuide();
        VersionConvertor_14_40.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.dstu2016may.model.UriType) VersionConvertor_14_40.convertType(src.getUrlElement()));
        if (src.hasVersionElement())
            tgt.setVersionElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_40.convertType(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_40.convertType(src.getNameElement()));
        if (src.hasStatus()) {
            tgt.setStatus(VersionConvertor_14_40.convertConformanceResourceStatus(src.getStatus()));
        }
        if (src.hasExperimentalElement())
            tgt.setExperimentalElement((org.hl7.fhir.dstu2016may.model.BooleanType) VersionConvertor_14_40.convertType(src.getExperimentalElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_40.convertType(src.getPublisherElement()));
        if (src.hasContact()) {
            for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact()) tgt.addContact(convertImplementationGuideContactComponent(t));
        }
        if (src.hasDateElement())
            tgt.setDateElement((org.hl7.fhir.dstu2016may.model.DateTimeType) VersionConvertor_14_40.convertType(src.getDateElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_40.convertType(src.getDescriptionElement()));
        for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext()) if (t.hasValueCodeableConcept())
            tgt.addUseContext(VersionConvertor_14_40.convertCodeableConcept(t.getValueCodeableConcept()));
        if (src.hasJurisdiction()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction()) tgt.addUseContext(VersionConvertor_14_40.convertCodeableConcept(t));
        }
        if (src.hasCopyrightElement())
            tgt.setCopyrightElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_40.convertType(src.getCopyrightElement()));
        if (src.hasFhirVersion())
            for (Enumeration<org.hl7.fhir.r4.model.Enumerations.FHIRVersion> v : src.getFhirVersion()) {
                tgt.setFhirVersion(v.asStringValue());
            }
        if (src.hasDependsOn()) {
            for (org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDependsOnComponent t : src.getDependsOn()) tgt.addDependency(convertImplementationGuideDependencyComponent(t));
        }
        if (src.hasDefinition()) {
            for (org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent t : src.getDefinition().getGrouping()) tgt.addPackage(convertImplementationGuidePackageComponent(t));
        }
        if (src.hasDefinition()) {
            for (org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent t : src.getDefinition().getResource()) findPackage(tgt.getPackage(), t.getGroupingId()).addResource(convertImplementationGuidePackageResourceComponent(t));
        }
        if (src.hasGlobal()) {
            for (org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideGlobalComponent t : src.getGlobal()) tgt.addGlobal(convertImplementationGuideGlobalComponent(t));
        }
        if (src.hasDefinition()) {
            tgt.setPage(convertImplementationGuidePageComponent(src.getDefinition().getPage()));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ImplementationGuide convertImplementationGuide(org.hl7.fhir.dstu2016may.model.ImplementationGuide src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ImplementationGuide tgt = new org.hl7.fhir.r4.model.ImplementationGuide();
        VersionConvertor_14_40.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.r4.model.UriType) VersionConvertor_14_40.convertType(src.getUrlElement()));
        if (src.hasVersionElement())
            tgt.setVersionElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_14_40.convertType(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_14_40.convertType(src.getNameElement()));
        if (src.hasStatus()) {
            tgt.setStatus(VersionConvertor_14_40.convertConformanceResourceStatus(src.getStatus()));
        }
        if (src.hasExperimentalElement())
            tgt.setExperimentalElement((org.hl7.fhir.r4.model.BooleanType) VersionConvertor_14_40.convertType(src.getExperimentalElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_14_40.convertType(src.getPublisherElement()));
        if (src.hasContact()) {
            for (org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideContactComponent t : src.getContact()) tgt.addContact(convertImplementationGuideContactComponent(t));
        }
        if (src.hasDateElement())
            tgt.setDateElement((org.hl7.fhir.r4.model.DateTimeType) VersionConvertor_14_40.convertType(src.getDateElement()));
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
        if (src.hasDependency()) {
            for (org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideDependencyComponent t : src.getDependency()) tgt.addDependsOn(convertImplementationGuideDependencyComponent(t));
        }
        if (src.hasPackage()) {
            for (org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePackageComponent t : src.getPackage()) tgt.getDefinition().addGrouping(convertImplementationGuidePackageComponent(tgt.getDefinition(), t));
        }
        if (src.hasGlobal()) {
            for (org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideGlobalComponent t : src.getGlobal()) tgt.addGlobal(convertImplementationGuideGlobalComponent(t));
        }
        if (src.hasPage()) {
            tgt.getDefinition().setPage(convertImplementationGuidePageComponent(src.getPage()));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ContactDetail convertImplementationGuideContactComponent(org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ContactDetail tgt = new org.hl7.fhir.r4.model.ContactDetail();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((StringType) VersionConvertor_14_40.convertType(src.getNameElement()));
        if (src.hasTelecom()) {
            for (org.hl7.fhir.dstu2016may.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_14_40.convertContactPoint(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideContactComponent convertImplementationGuideContactComponent(org.hl7.fhir.r4.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideContactComponent tgt = new org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideContactComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_40.convertType(src.getNameElement()));
        if (src.hasTelecom()) {
            for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_14_40.convertContactPoint(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideDependencyComponent convertImplementationGuideDependencyComponent(org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDependsOnComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideDependencyComponent tgt = new org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideDependencyComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        tgt.setType(org.hl7.fhir.dstu2016may.model.ImplementationGuide.GuideDependencyType.REFERENCE);
        if (src.hasUriElement())
            tgt.setUriElement((org.hl7.fhir.dstu2016may.model.UriType) VersionConvertor_14_40.convertType(src.getUriElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDependsOnComponent convertImplementationGuideDependencyComponent(org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideDependencyComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDependsOnComponent tgt = new org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDependsOnComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasUriElement())
            tgt.setUriElement((org.hl7.fhir.r4.model.CanonicalType) VersionConvertor_14_40.convertType(src.getUriElement()));
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
            tgt.setTypeElement((org.hl7.fhir.r4.model.CodeType) VersionConvertor_14_40.convertType(src.getTypeElement()));
        if (src.hasProfile()) {
            tgt.setProfileElement(VersionConvertor_14_40.convertReferenceToCanonical(src.getProfile()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideGlobalComponent convertImplementationGuideGlobalComponent(org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideGlobalComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideGlobalComponent tgt = new org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideGlobalComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasTypeElement())
            tgt.setTypeElement((org.hl7.fhir.dstu2016may.model.CodeType) VersionConvertor_14_40.convertType(src.getTypeElement()));
        if (src.hasProfileElement()) {
            tgt.setProfile(VersionConvertor_14_40.convertCanonicalToReference(src.getProfileElement()));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent convertImplementationGuidePackageComponent(org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionComponent context, org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePackageComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent tgt = new org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent();
        tgt.setId("p" + (context.getGrouping().size() + 1));
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((StringType) VersionConvertor_14_40.convertType(src.getDescriptionElement()));
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
        if (src.hasIdElement()) {
            tgt.setIdElement((IdType) VersionConvertor_14_40.convertType(src.getIdElement()));
        }
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_40.convertType(src.getNameElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_40.convertType(src.getDescriptionElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePackageResourceComponent convertImplementationGuidePackageResourceComponent(org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePackageResourceComponent tgt = new org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePackageResourceComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasExampleCanonicalType()) {
            if (src.hasExampleCanonicalType()) {
                tgt.setExampleFor(VersionConvertor_14_40.convertCanonicalToReference(src.getExampleCanonicalType()));
            }
            tgt.setExample(true);
        } else if (src.hasExampleBooleanType())
            tgt.setExample(src.getExampleBooleanType().getValue());
        else
            tgt.setExample(false);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_40.convertType(src.getNameElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_40.convertType(src.getDescriptionElement()));
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
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_14_40.convertType(src.getNameElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_14_40.convertType(src.getDescriptionElement()));
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
        if (src.hasNameElement()) {
            tgt.setTitleElement((StringType) VersionConvertor_14_40.convertType(src.getNameElement()));
        }
        if (src.hasKind())
            tgt.setGeneration(convertPageGeneration(src.getKind()));
        if (src.hasPage()) {
            for (org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePageComponent t : src.getPage()) tgt.addPage(convertImplementationGuidePageComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePageComponent convertImplementationGuidePageComponent(org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePageComponent tgt = new org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePageComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasNameUrlType())
            tgt.setSource(src.getNameUrlType().getValue());
        if (src.hasTitleElement()) {
            tgt.setNameElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_40.convertType(src.getTitleElement()));
        }
        if (src.hasGeneration())
            tgt.setKind(convertPageGeneration(src.getGeneration()));
        if (src.hasPage()) {
            for (org.hl7.fhir.r4.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent t : src.getPage()) tgt.addPage(convertImplementationGuidePageComponent(t));
        }
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

    static public org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePackageComponent findPackage(List<org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePackageComponent> definition, String id) {
        for (org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePackageComponent t : definition) if (t.getId().equals(id))
            return t;
        org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePackageComponent t = new org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePackageComponent();
        t.setName("Default Package");
        t.setId(id);
        return t;
    }
}
