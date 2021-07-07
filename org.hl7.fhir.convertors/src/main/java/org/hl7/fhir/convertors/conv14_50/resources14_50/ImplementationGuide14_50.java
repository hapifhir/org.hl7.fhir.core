package org.hl7.fhir.convertors.conv14_50.resources14_50;

import java.util.List;
import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.conv14_50.VersionConvertor_14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.Element14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.Type14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.complextypes14_50.CodeableConcept14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.complextypes14_50.ContactPoint14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.*;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.Reference14_50;
import org.hl7.fhir.dstu2016may.model.ImplementationGuide;
import org.hl7.fhir.dstu2016may.model.ImplementationGuide.GuidePageKind;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.Enumeration;
import org.hl7.fhir.r5.model.ImplementationGuide.GuidePageGeneration;

public class ImplementationGuide14_50 {

    public static org.hl7.fhir.dstu2016may.model.ImplementationGuide convertImplementationGuide(org.hl7.fhir.r5.model.ImplementationGuide src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ImplementationGuide tgt = new org.hl7.fhir.dstu2016may.model.ImplementationGuide();
        VersionConvertor_14_50.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement(Uri14_50.convertUri(src.getUrlElement()));
        if (src.hasVersion())
            tgt.setVersionElement(String14_50.convertString(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement(String14_50.convertString(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatusElement(Enumerations14_50.convertConformanceResourceStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(Boolean14_50.convertBoolean(src.getExperimentalElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(String14_50.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact()) tgt.addContact(convertImplementationGuideContactComponent(t));
        if (src.hasDate())
            tgt.setDateElement(DateTime14_50.convertDateTime(src.getDateElement()));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext()) if (t.hasValueCodeableConcept())
            tgt.addUseContext(CodeableConcept14_50.convertCodeableConcept(t.getValueCodeableConcept()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction()) tgt.addUseContext(CodeableConcept14_50.convertCodeableConcept(t));
        if (src.hasCopyright())
            tgt.setCopyright(src.getCopyright());
        if (src.hasFhirVersion())
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

    public static org.hl7.fhir.r5.model.ImplementationGuide convertImplementationGuide(org.hl7.fhir.dstu2016may.model.ImplementationGuide src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ImplementationGuide tgt = new org.hl7.fhir.r5.model.ImplementationGuide();
        VersionConvertor_14_50.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement(Uri14_50.convertUri(src.getUrlElement()));
        if (src.hasVersion())
            tgt.setVersionElement(String14_50.convertString(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement(String14_50.convertString(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatusElement(Enumerations14_50.convertConformanceResourceStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(Boolean14_50.convertBoolean(src.getExperimentalElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(String14_50.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideContactComponent t : src.getContact()) tgt.addContact(convertImplementationGuideContactComponent(t));
        if (src.hasDate())
            tgt.setDateElement(DateTime14_50.convertDateTime(src.getDateElement()));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu2016may.model.CodeableConcept t : src.getUseContext()) if (CodeableConcept14_50.isJurisdiction(t))
            tgt.addJurisdiction(CodeableConcept14_50.convertCodeableConcept(t));
        else
            tgt.addUseContext(CodeableConcept14_50.convertCodeableConceptToUsageContext(t));
        if (src.hasCopyright())
            tgt.setCopyright(src.getCopyright());
        if (src.hasFhirVersion())
            tgt.addFhirVersion(org.hl7.fhir.r5.model.Enumerations.FHIRVersion.fromCode(src.getFhirVersion()));
        for (org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideDependencyComponent t : src.getDependency()) tgt.addDependsOn(convertImplementationGuideDependencyComponent(t));
        for (org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePackageComponent t : src.getPackage()) tgt.getDefinition().addGrouping(convertImplementationGuidePackageComponent(tgt.getDefinition(), t));
        for (org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideGlobalComponent t : src.getGlobal()) tgt.addGlobal(convertImplementationGuideGlobalComponent(t));
        tgt.getDefinition().setPage(convertImplementationGuidePageComponent(src.getPage()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideContactComponent convertImplementationGuideContactComponent(org.hl7.fhir.r5.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideContactComponent tgt = new org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideContactComponent();
        Element14_50.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(String14_50.convertString(src.getNameElement()));
        for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(ContactPoint14_50.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ContactDetail convertImplementationGuideContactComponent(org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ContactDetail tgt = new org.hl7.fhir.r5.model.ContactDetail();
        Element14_50.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(String14_50.convertString(src.getNameElement()));
        for (org.hl7.fhir.dstu2016may.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(ContactPoint14_50.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDependsOnComponent convertImplementationGuideDependencyComponent(org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideDependencyComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDependsOnComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDependsOnComponent();
        Element14_50.copyElement(src, tgt);
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

    public static org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideDependencyComponent convertImplementationGuideDependencyComponent(org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDependsOnComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideDependencyComponent tgt = new org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideDependencyComponent();
        Element14_50.copyElement(src, tgt);
        tgt.setType(org.hl7.fhir.dstu2016may.model.ImplementationGuide.GuideDependencyType.REFERENCE);
        if (src.hasUri())
            tgt.setUri(src.getUri());
        if (src.hasPackageId())
            tgt.addExtension(new org.hl7.fhir.dstu2016may.model.Extension(VersionConvertorConstants.IG_DEPENDSON_PACKAGE_EXTENSION, new org.hl7.fhir.dstu2016may.model.IdType(src.getPackageId())));
        if (src.hasVersion())
            tgt.addExtension(new org.hl7.fhir.dstu2016may.model.Extension(VersionConvertorConstants.IG_DEPENDSON_VERSION_EXTENSION, new org.hl7.fhir.dstu2016may.model.StringType(src.getVersion())));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideGlobalComponent convertImplementationGuideGlobalComponent(org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideGlobalComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideGlobalComponent tgt = new org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideGlobalComponent();
        Element14_50.copyElement(src, tgt);
        if (tgt.hasType()) {
            if (src.hasTypeElement())
                tgt.setTypeElement(Code14_50.convertCode(src.getTypeElement()));
        }
        if (src.hasProfileElement())
            tgt.setProfile(Reference14_50.convertCanonicalToReference(src.getProfileElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideGlobalComponent convertImplementationGuideGlobalComponent(org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuideGlobalComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideGlobalComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideGlobalComponent();
        Element14_50.copyElement(src, tgt);
        if (src.hasTypeElement())
            tgt.setTypeElement(Code14_50.convertCode(src.getTypeElement()));
        if (src.hasProfile())
            tgt.setProfileElement(Reference14_50.convertReferenceToCanonical(src.getProfile()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePackageComponent convertImplementationGuidePackageComponent(org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePackageComponent tgt = new org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePackageComponent();
        Element14_50.copyElement(src, tgt);
        tgt.setId(src.getId());
        if (src.hasNameElement())
            tgt.setNameElement(String14_50.convertString(src.getNameElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(String14_50.convertString(src.getDescriptionElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent convertImplementationGuidePackageComponent(org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionComponent context, org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePackageComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent();
        tgt.setId("p" + (context.getGrouping().size() + 1));
        Element14_50.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(String14_50.convertString(src.getNameElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(String14_50.convertString(src.getDescriptionElement()));
        for (org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePackageResourceComponent t : src.getResource()) {
            org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent tn = convertImplementationGuidePackageResourceComponent(t);
            tn.setGroupingId(tgt.getId());
            context.addResource(tn);
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePackageResourceComponent convertImplementationGuidePackageResourceComponent(org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePackageResourceComponent tgt = new org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePackageResourceComponent();
        Element14_50.copyElement(src, tgt);
        if (src.hasExampleCanonicalType()) {
            if (src.hasExampleCanonicalType())
                tgt.setExampleFor(Reference14_50.convertCanonicalToReference(src.getExampleCanonicalType()));
            tgt.setExample(true);
        } else if (src.hasExampleBooleanType())
            tgt.setExample(src.getExampleBooleanType().getValue());
        else
            tgt.setExample(false);
        if (src.hasName())
            tgt.setNameElement(String14_50.convertString(src.getNameElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(String14_50.convertString(src.getDescriptionElement()));
        if (src.hasReference())
            tgt.setSource(Reference14_50.convertReference(src.getReference()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent convertImplementationGuidePackageResourceComponent(org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePackageResourceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent();
        Element14_50.copyElement(src, tgt);
        if (src.hasExampleFor()) {
            DataType t = Type14_50.convertType(src.getExampleFor());
            tgt.setExample(t instanceof org.hl7.fhir.r5.model.Reference ? new CanonicalType(((org.hl7.fhir.r5.model.Reference) t).getReference()) : t);
        } else if (src.hasExample())
            tgt.setExample(new org.hl7.fhir.r5.model.BooleanType(src.getExample()));
        if (src.hasName())
            tgt.setNameElement(String14_50.convertString(src.getNameElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(String14_50.convertString(src.getDescriptionElement()));
        if (src.hasSourceReference())
            tgt.setReference(Reference14_50.convertReference(src.getSourceReference()));
        else if (src.hasSourceUriType())
            tgt.setReference(new org.hl7.fhir.r5.model.Reference(src.getSourceUriType().getValue()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePageComponent convertImplementationGuidePageComponent(org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePageComponent tgt = new org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePageComponent();
        Element14_50.copyElement(src, tgt);
        if (src.hasNameUrlType())
            tgt.setSource(src.getNameUrlType().getValue());
        if (src.hasTitleElement())
            tgt.setNameElement(String14_50.convertString(src.getTitleElement()));
        if (src.hasGeneration())
            tgt.setKind(convertPageGeneration(src.getGeneration()));
        for (org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent t : src.getPage()) tgt.addPage(convertImplementationGuidePageComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent convertImplementationGuidePageComponent(org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePageComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent();
        Element14_50.copyElement(src, tgt);
        if (src.hasSource())
            tgt.setName(convertUriToUrl(src.getSourceElement()));
        if (src.hasNameElement())
            tgt.setTitleElement(String14_50.convertString(src.getNameElement()));
        if (src.hasKind())
            tgt.setGeneration(convertPageGeneration(src.getKind()));
        for (org.hl7.fhir.dstu2016may.model.ImplementationGuide.ImplementationGuidePageComponent t : src.getPage()) tgt.addPage(convertImplementationGuidePageComponent(t));
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

    public static org.hl7.fhir.r5.model.UrlType convertUriToUrl(org.hl7.fhir.dstu2016may.model.UriType src) throws FHIRException {
        org.hl7.fhir.r5.model.UrlType tgt = new org.hl7.fhir.r5.model.UrlType();
        if (src.hasValue())
            tgt.setValue(src.getValue());
        Element14_50.copyElement(src, tgt);
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