package org.hl7.fhir.convertors.conv30_50.resources30_50;

import java.util.List;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.ContactDetail30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Reference30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.UsageContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.CodeableConcept30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Boolean30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Code30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.DateTime30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.MarkDown30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.String30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Uri30_50;
import org.hl7.fhir.dstu3.model.ImplementationGuide;
import org.hl7.fhir.dstu3.utils.ExtensionUtilities;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.Enumeration;
import org.hl7.fhir.utilities.VersionUtilities;

public class ImplementationGuide30_50 {

  static final String EXT_IG_DEFINITION_RESOURCE_PROFILE = "http://hl7.org/fhir/5.0/StructureDefinition/extension-ImplementationGuide.definition.resource.profile";

  public static org.hl7.fhir.dstu3.model.ImplementationGuide convertImplementationGuide(org.hl7.fhir.r5.model.ImplementationGuide src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.ImplementationGuide tgt = new org.hl7.fhir.dstu3.model.ImplementationGuide();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri30_50.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String30_50.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String30_50.convertString(src.getNameElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations30_50.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean30_50.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime30_50.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String30_50.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail30_50.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown30_50.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext30_50.convertUsageContext(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept30_50.convertCodeableConcept(t));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown30_50.convertMarkdown(src.getCopyrightElement()));
    if (src.hasFhirVersion())
      for (Enumeration<org.hl7.fhir.r5.model.Enumerations.FHIRVersion> v : src.getFhirVersion()) {
        tgt.setFhirVersion(v.asStringValue());
        break;
      }
    for (org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDependsOnComponent t : src.getDependsOn())
      tgt.addDependency(convertImplementationGuideDependencyComponent(t));
    for (org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent t : src.getDefinition().getGrouping())
      tgt.addPackage(convertImplementationGuidePackageComponent(t));
    for (org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent t : src.getDefinition().getResource()) {
      findPackage(tgt.getPackage(), t.getGroupingId()).addResource(convertImplementationGuidePackageResourceComponent(t));
    }
    for (org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideGlobalComponent t : src.getGlobal())
      tgt.addGlobal(convertImplementationGuideGlobalComponent(t));
    if (src.getDefinition().hasPage())
      tgt.setPage(convertImplementationGuidePageComponent(src.getDefinition().getPage()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ImplementationGuide convertImplementationGuide(org.hl7.fhir.dstu3.model.ImplementationGuide src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImplementationGuide tgt = new org.hl7.fhir.r5.model.ImplementationGuide();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri30_50.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String30_50.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String30_50.convertString(src.getNameElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations30_50.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean30_50.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime30_50.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String30_50.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail30_50.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown30_50.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext30_50.convertUsageContext(t));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept30_50.convertCodeableConcept(t));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown30_50.convertMarkdown(src.getCopyrightElement()));
    if (src.hasFhirVersion())
      tgt.addFhirVersion(org.hl7.fhir.r5.model.Enumerations.FHIRVersion.fromCode(
          VersionUtilities.getCurrentVersion(src.getFhirVersion())));
    for (org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideDependencyComponent t : src.getDependency())
      tgt.addDependsOn(convertImplementationGuideDependencyComponent(t));
    for (org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageComponent t : src.getPackage())
      tgt.getDefinition().addGrouping(convertImplementationGuidePackageComponent(tgt.getDefinition(), t));
    for (org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideGlobalComponent t : src.getGlobal())
      tgt.addGlobal(convertImplementationGuideGlobalComponent(t));
    if (src.hasPage())
      tgt.getDefinition().setPage(convertImplementationGuidePageComponent(src.getPage()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideDependencyComponent convertImplementationGuideDependencyComponent(org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDependsOnComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideDependencyComponent tgt = new org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideDependencyComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    tgt.setType(org.hl7.fhir.dstu3.model.ImplementationGuide.GuideDependencyType.REFERENCE);
    if (src.hasUri())
      tgt.setUri(src.getUri());
    if (src.hasPackageId())
      tgt.addExtension(new org.hl7.fhir.dstu3.model.Extension(VersionConvertorConstants.EXT_IG_DEPENDSON_PACKAGE_EXTENSION, new org.hl7.fhir.dstu3.model.IdType(src.getPackageId())));
    if (src.hasVersion())
      tgt.addExtension(new org.hl7.fhir.dstu3.model.Extension(VersionConvertorConstants.EXT_IG_DEPENDSON_VERSION_EXTENSION, new org.hl7.fhir.dstu3.model.StringType(src.getVersion())));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDependsOnComponent convertImplementationGuideDependencyComponent(org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideDependencyComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDependsOnComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDependsOnComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasUri())
      tgt.setUri(src.getUri());
    if (ExtensionUtilities.hasExtension(src, VersionConvertorConstants.EXT_IG_DEPENDSON_PACKAGE_EXTENSION)) {
      tgt.setPackageId(ExtensionUtilities.readStringExtension(src, VersionConvertorConstants.EXT_IG_DEPENDSON_PACKAGE_EXTENSION));
    }
    if (ExtensionUtilities.hasExtension(src, VersionConvertorConstants.EXT_IG_DEPENDSON_VERSION_EXTENSION)) {
      tgt.setVersion(ExtensionUtilities.readStringExtension(src, VersionConvertorConstants.EXT_IG_DEPENDSON_VERSION_EXTENSION));
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideGlobalComponent convertImplementationGuideGlobalComponent(org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideGlobalComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideGlobalComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideGlobalComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasType())
      tgt.setTypeElement(Code30_50.convertCode(src.getTypeElement()));
    if (src.hasProfile())
      tgt.setProfileElement(Reference30_50.convertReferenceToCanonical(src.getProfile()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideGlobalComponent convertImplementationGuideGlobalComponent(org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideGlobalComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideGlobalComponent tgt = new org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideGlobalComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasType())
      tgt.setTypeElement(Code30_50.convertCode(src.getTypeElement()));
    if (src.hasProfile())
      tgt.setProfile(Reference30_50.convertCanonicalToReference(src.getProfileElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageComponent convertImplementationGuidePackageComponent(org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageComponent tgt = new org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    tgt.setId(src.getId());
    if (src.hasName())
      tgt.setNameElement(String30_50.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String30_50.convertString(src.getDescriptionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent convertImplementationGuidePackageComponent(org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionComponent context, org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionGroupingComponent();
    tgt.setId("p" + (context.getGrouping().size() + 1));
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasName())
      tgt.setNameElement(String30_50.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String30_50.convertStringToMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageResourceComponent t : src.getResource()) {
      org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent tn = convertImplementationGuidePackageResourceComponent(t);
      tn.setGroupingId(tgt.getId());
      context.addResource(tn);
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageResourceComponent convertImplementationGuidePackageResourceComponent(org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageResourceComponent tgt = new org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageResourceComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasProfile()) {
      tgt.setExampleFor(Reference30_50.convertCanonicalToReference(src.getProfile().get(0)));
      tgt.setExample(true);
      if (src.getProfile().size() > 1) {
        for (CanonicalType p: src.getProfile().subList(1, src.getProfile().size())) {
          tgt.addExtension(EXT_IG_DEFINITION_RESOURCE_PROFILE, Uri30_50.convertUri(p));
        }
      }
    } else if (src.hasIsExample())
      tgt.setExample(src.getIsExample());
    else
      tgt.setExample(false);

    if (src.hasName())
      tgt.setNameElement(String30_50.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String30_50.convertString(src.getDescriptionElement()));
    if (src.hasReference())
      tgt.setSource(Reference30_50.convertReference(src.getReference()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent convertImplementationGuidePackageResourceComponent(org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageResourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionResourceComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    for (org.hl7.fhir.dstu3.model.Extension ext: src.getExtensionsByUrl(EXT_IG_DEFINITION_RESOURCE_PROFILE)) {
      tgt.getProfile().add(Uri30_50.convertCanonical((org.hl7.fhir.dstu3.model.UriType)ext.getValue()));
    }
    if (src.hasExampleFor()) {
      tgt.getProfile().add(Reference30_50.convertReferenceToCanonical(src.getExampleFor()));
    } else if (src.hasExample())
      tgt.setIsExampleElement(new org.hl7.fhir.r5.model.BooleanType(src.getExample()));
    if (src.hasName())
      tgt.setNameElement(String30_50.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String30_50.convertStringToMarkdown(src.getDescriptionElement()));
    if (src.hasSourceReference())
      tgt.setReference(Reference30_50.convertReference(src.getSourceReference()));
    else if (src.hasSourceUriType())
      tgt.setReference(new org.hl7.fhir.r5.model.Reference(src.getSourceUriType().getValue()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePageComponent convertImplementationGuidePageComponent(org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePageComponent tgt = new org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePageComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasName())
      tgt.setSource(src.getName());
    if (src.hasTitle())
      tgt.setTitleElement(String30_50.convertString(src.getTitleElement()));
    if (src.hasGeneration())
      tgt.setKind(convertPageGeneration(src.getGeneration()));
    for (org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent t : src.getPage())
      tgt.addPage(convertImplementationGuidePageComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent convertImplementationGuidePageComponent(org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent tgt = new org.hl7.fhir.r5.model.ImplementationGuide.ImplementationGuideDefinitionPageComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasSource())
      tgt.setNameElement(convertUriToUrl(src.getSourceElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String30_50.convertString(src.getTitleElement()));
    if (src.hasKind())
      tgt.setGeneration(convertPageGeneration(src.getKind()));
    for (org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePageComponent t : src.getPage())
      tgt.addPage(convertImplementationGuidePageComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.ImplementationGuide.GuidePageGeneration convertPageGeneration(org.hl7.fhir.dstu3.model.ImplementationGuide.GuidePageKind kind) {
    switch (kind) {
      case PAGE:
        return org.hl7.fhir.r5.model.ImplementationGuide.GuidePageGeneration.HTML;
      default:
        return org.hl7.fhir.r5.model.ImplementationGuide.GuidePageGeneration.GENERATED;
    }
  }

  static public org.hl7.fhir.dstu3.model.ImplementationGuide.GuidePageKind convertPageGeneration(org.hl7.fhir.r5.model.ImplementationGuide.GuidePageGeneration generation) {
    switch (generation) {
      case HTML:
        return org.hl7.fhir.dstu3.model.ImplementationGuide.GuidePageKind.PAGE;
      default:
        return org.hl7.fhir.dstu3.model.ImplementationGuide.GuidePageKind.RESOURCE;
    }
  }

  public static org.hl7.fhir.r5.model.UrlType convertUriToUrl(org.hl7.fhir.dstu3.model.UriType src) throws FHIRException {
    org.hl7.fhir.r5.model.UrlType tgt = new org.hl7.fhir.r5.model.UrlType(src.getValue());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageComponent findPackage(List<ImplementationGuide.ImplementationGuidePackageComponent> definition, String id) {
    for (org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageComponent t : definition)
      if (t.hasId() && t.getId().equals(id))
        return t;
    org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageComponent t1 = new org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageComponent();
    t1.setName("Default Package");
    t1.setId(id);
    return t1;
  }
}