package org.hl7.fhir.convertors.conv10_30.resources10_30;

import org.hl7.fhir.convertors.conv10_30.VersionConvertor_10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Element10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Type10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.CodeableConcept10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.ContactPoint10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.*;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Reference10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class ImplementationGuide10_30 {

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ImplementationGuide.GuideDependencyType> convertGuideDependencyType(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ImplementationGuide.GuideDependencyType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ImplementationGuide.GuideDependencyType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.ImplementationGuide.GuideDependencyTypeEnumFactory());
        Element10_30.copyElement(src, tgt);
        switch(src.getValue()) {
            case REFERENCE:
                tgt.setValue(org.hl7.fhir.dstu3.model.ImplementationGuide.GuideDependencyType.REFERENCE);
                break;
            case INCLUSION:
                tgt.setValue(org.hl7.fhir.dstu3.model.ImplementationGuide.GuideDependencyType.INCLUSION);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.ImplementationGuide.GuideDependencyType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ImplementationGuide.GuideDependencyType> convertGuideDependencyType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ImplementationGuide.GuideDependencyType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ImplementationGuide.GuideDependencyType> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.ImplementationGuide.GuideDependencyTypeEnumFactory());
        Element10_30.copyElement(src, tgt);
        switch(src.getValue()) {
            case REFERENCE:
                tgt.setValue(org.hl7.fhir.dstu2.model.ImplementationGuide.GuideDependencyType.REFERENCE);
                break;
            case INCLUSION:
                tgt.setValue(org.hl7.fhir.dstu2.model.ImplementationGuide.GuideDependencyType.INCLUSION);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.ImplementationGuide.GuideDependencyType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ImplementationGuide.GuidePageKind> convertGuidePageKind(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ImplementationGuide.GuidePageKind> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ImplementationGuide.GuidePageKind> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.ImplementationGuide.GuidePageKindEnumFactory());
        Element10_30.copyElement(src, tgt);
        switch(src.getValue()) {
            case PAGE:
                tgt.setValue(org.hl7.fhir.dstu3.model.ImplementationGuide.GuidePageKind.PAGE);
                break;
            case EXAMPLE:
                tgt.setValue(org.hl7.fhir.dstu3.model.ImplementationGuide.GuidePageKind.EXAMPLE);
                break;
            case LIST:
                tgt.setValue(org.hl7.fhir.dstu3.model.ImplementationGuide.GuidePageKind.LIST);
                break;
            case INCLUDE:
                tgt.setValue(org.hl7.fhir.dstu3.model.ImplementationGuide.GuidePageKind.INCLUDE);
                break;
            case DIRECTORY:
                tgt.setValue(org.hl7.fhir.dstu3.model.ImplementationGuide.GuidePageKind.DIRECTORY);
                break;
            case DICTIONARY:
                tgt.setValue(org.hl7.fhir.dstu3.model.ImplementationGuide.GuidePageKind.DICTIONARY);
                break;
            case TOC:
                tgt.setValue(org.hl7.fhir.dstu3.model.ImplementationGuide.GuidePageKind.TOC);
                break;
            case RESOURCE:
                tgt.setValue(org.hl7.fhir.dstu3.model.ImplementationGuide.GuidePageKind.RESOURCE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.ImplementationGuide.GuidePageKind.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ImplementationGuide.GuidePageKind> convertGuidePageKind(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ImplementationGuide.GuidePageKind> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ImplementationGuide.GuidePageKind> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.ImplementationGuide.GuidePageKindEnumFactory());
        Element10_30.copyElement(src, tgt);
        switch(src.getValue()) {
            case PAGE:
                tgt.setValue(org.hl7.fhir.dstu2.model.ImplementationGuide.GuidePageKind.PAGE);
                break;
            case EXAMPLE:
                tgt.setValue(org.hl7.fhir.dstu2.model.ImplementationGuide.GuidePageKind.EXAMPLE);
                break;
            case LIST:
                tgt.setValue(org.hl7.fhir.dstu2.model.ImplementationGuide.GuidePageKind.LIST);
                break;
            case INCLUDE:
                tgt.setValue(org.hl7.fhir.dstu2.model.ImplementationGuide.GuidePageKind.INCLUDE);
                break;
            case DIRECTORY:
                tgt.setValue(org.hl7.fhir.dstu2.model.ImplementationGuide.GuidePageKind.DIRECTORY);
                break;
            case DICTIONARY:
                tgt.setValue(org.hl7.fhir.dstu2.model.ImplementationGuide.GuidePageKind.DICTIONARY);
                break;
            case TOC:
                tgt.setValue(org.hl7.fhir.dstu2.model.ImplementationGuide.GuidePageKind.TOC);
                break;
            case RESOURCE:
                tgt.setValue(org.hl7.fhir.dstu2.model.ImplementationGuide.GuidePageKind.RESOURCE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.ImplementationGuide.GuidePageKind.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ImplementationGuide convertImplementationGuide(org.hl7.fhir.dstu2.model.ImplementationGuide src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ImplementationGuide tgt = new org.hl7.fhir.dstu3.model.ImplementationGuide();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement(Uri10_30.convertUri(src.getUrlElement()));
        if (src.hasVersionElement())
            tgt.setVersionElement(String10_30.convertString(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement(String10_30.convertString(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatusElement(Enumerations10_30.convertConformanceResourceStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(Boolean10_30.convertBoolean(src.getExperimentalElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement(String10_30.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuideContactComponent t : src.getContact()) tgt.addContact(convertImplementationGuideContactComponent(t));
        if (src.hasDate())
            tgt.setDateElement(DateTime10_30.convertDateTime(src.getDateElement()));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getUseContext()) if (VersionConvertor_10_30.isJurisdiction(t))
            tgt.addJurisdiction(CodeableConcept10_30.convertCodeableConcept(t));
        else
            tgt.addUseContext(CodeableConcept10_30.convertCodeableConceptToUsageContext(t));
        if (src.hasCopyright())
            tgt.setCopyright(src.getCopyright());
        if (src.hasFhirVersionElement())
            tgt.setFhirVersionElement(Id10_30.convertId(src.getFhirVersionElement()));
        for (org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuideDependencyComponent t : src.getDependency()) tgt.addDependency(convertImplementationGuideDependencyComponent(t));
        for (org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuidePackageComponent t : src.getPackage()) tgt.addPackage(convertImplementationGuidePackageComponent(t));
        for (org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuideGlobalComponent t : src.getGlobal()) tgt.addGlobal(convertImplementationGuideGlobalComponent(t));
        for (org.hl7.fhir.dstu2.model.UriType t : src.getBinary()) tgt.addBinary(t.getValue());
        if (src.hasPage())
            tgt.setPage(convertImplementationGuidePageComponent(src.getPage()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ImplementationGuide convertImplementationGuide(org.hl7.fhir.dstu3.model.ImplementationGuide src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ImplementationGuide tgt = new org.hl7.fhir.dstu2.model.ImplementationGuide();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement(Uri10_30.convertUri(src.getUrlElement()));
        if (src.hasVersionElement())
            tgt.setVersionElement(String10_30.convertString(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement(String10_30.convertString(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatusElement(Enumerations10_30.convertConformanceResourceStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(Boolean10_30.convertBoolean(src.getExperimentalElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement(String10_30.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(convertImplementationGuideContactComponent(t));
        if (src.hasDate())
            tgt.setDateElement(DateTime10_30.convertDateTime(src.getDateElement()));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext()) if (t.hasValueCodeableConcept())
            tgt.addUseContext(CodeableConcept10_30.convertCodeableConcept(t.getValueCodeableConcept()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addUseContext(CodeableConcept10_30.convertCodeableConcept(t));
        if (src.hasCopyright())
            tgt.setCopyright(src.getCopyright());
        if (src.hasFhirVersionElement())
            tgt.setFhirVersionElement(Id10_30.convertId(src.getFhirVersionElement()));
        for (org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideDependencyComponent t : src.getDependency()) tgt.addDependency(convertImplementationGuideDependencyComponent(t));
        for (org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageComponent t : src.getPackage()) tgt.addPackage(convertImplementationGuidePackageComponent(t));
        for (org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideGlobalComponent t : src.getGlobal()) tgt.addGlobal(convertImplementationGuideGlobalComponent(t));
        for (org.hl7.fhir.dstu3.model.UriType t : src.getBinary()) tgt.addBinary(t.getValue());
        if (src.hasPage())
            tgt.setPage(convertImplementationGuidePageComponent(src.getPage()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuideContactComponent convertImplementationGuideContactComponent(org.hl7.fhir.dstu3.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuideContactComponent tgt = new org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuideContactComponent();
        Element10_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(String10_30.convertString(src.getNameElement()));
        for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(ContactPoint10_30.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ContactDetail convertImplementationGuideContactComponent(org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuideContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ContactDetail tgt = new org.hl7.fhir.dstu3.model.ContactDetail();
        Element10_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(String10_30.convertString(src.getNameElement()));
        for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(ContactPoint10_30.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuideDependencyComponent convertImplementationGuideDependencyComponent(org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideDependencyComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuideDependencyComponent tgt = new org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuideDependencyComponent();
        Element10_30.copyElement(src, tgt);
        if (src.hasType())
            tgt.setTypeElement(convertGuideDependencyType(src.getTypeElement()));
        if (src.hasUriElement())
            tgt.setUriElement(Uri10_30.convertUri(src.getUriElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideDependencyComponent convertImplementationGuideDependencyComponent(org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuideDependencyComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideDependencyComponent tgt = new org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideDependencyComponent();
        Element10_30.copyElement(src, tgt);
        if (src.hasType())
            tgt.setTypeElement(convertGuideDependencyType(src.getTypeElement()));
        if (src.hasUriElement())
            tgt.setUriElement(Uri10_30.convertUri(src.getUriElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuideGlobalComponent convertImplementationGuideGlobalComponent(org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideGlobalComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuideGlobalComponent tgt = new org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuideGlobalComponent();
        Element10_30.copyElement(src, tgt);
        if (src.hasTypeElement())
            tgt.setTypeElement(Code10_30.convertCode(src.getTypeElement()));
        if (src.hasProfile())
            tgt.setProfile(Reference10_30.convertReference(src.getProfile()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideGlobalComponent convertImplementationGuideGlobalComponent(org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuideGlobalComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideGlobalComponent tgt = new org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuideGlobalComponent();
        Element10_30.copyElement(src, tgt);
        if (src.hasTypeElement())
            tgt.setTypeElement(Code10_30.convertCode(src.getTypeElement()));
        if (src.hasProfile())
            tgt.setProfile(Reference10_30.convertReference(src.getProfile()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuidePackageComponent convertImplementationGuidePackageComponent(org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuidePackageComponent tgt = new org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuidePackageComponent();
        Element10_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(String10_30.convertString(src.getNameElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement(String10_30.convertString(src.getDescriptionElement()));
        for (org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageResourceComponent t : src.getResource()) tgt.addResource(convertImplementationGuidePackageResourceComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageComponent convertImplementationGuidePackageComponent(org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuidePackageComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageComponent tgt = new org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageComponent();
        Element10_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(String10_30.convertString(src.getNameElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement(String10_30.convertString(src.getDescriptionElement()));
        for (org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuidePackageResourceComponent t : src.getResource()) tgt.addResource(convertImplementationGuidePackageResourceComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageResourceComponent convertImplementationGuidePackageResourceComponent(org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuidePackageResourceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageResourceComponent tgt = new org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageResourceComponent();
        Element10_30.copyElement(src, tgt);
        tgt.setExample(src.getPurpose() == org.hl7.fhir.dstu2.model.ImplementationGuide.GuideResourcePurpose.EXAMPLE);
        if (src.hasNameElement())
            tgt.setNameElement(String10_30.convertString(src.getNameElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement(String10_30.convertString(src.getDescriptionElement()));
        if (src.hasAcronymElement())
            tgt.setAcronymElement(String10_30.convertString(src.getAcronymElement()));
        if (src.hasSource())
            tgt.setSource(Type10_30.convertType(src.getSource()));
        if (src.hasExampleFor())
            tgt.setExampleFor(Reference10_30.convertReference(src.getExampleFor()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuidePackageResourceComponent convertImplementationGuidePackageResourceComponent(org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePackageResourceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuidePackageResourceComponent tgt = new org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuidePackageResourceComponent();
        Element10_30.copyElement(src, tgt);
        if (src.getExample())
            tgt.setPurpose(org.hl7.fhir.dstu2.model.ImplementationGuide.GuideResourcePurpose.EXAMPLE);
        else
            tgt.setPurpose(org.hl7.fhir.dstu2.model.ImplementationGuide.GuideResourcePurpose.PROFILE);
        if (src.hasNameElement())
            tgt.setNameElement(String10_30.convertString(src.getNameElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement(String10_30.convertString(src.getDescriptionElement()));
        if (src.hasAcronymElement())
            tgt.setAcronymElement(String10_30.convertString(src.getAcronymElement()));
        if (src.hasSource())
            tgt.setSource(Type10_30.convertType(src.getSource()));
        if (src.hasExampleFor())
            tgt.setExampleFor(Reference10_30.convertReference(src.getExampleFor()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuidePageComponent convertImplementationGuidePageComponent(org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePageComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuidePageComponent tgt = new org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuidePageComponent();
        Element10_30.copyElement(src, tgt);
        if (src.hasSourceElement())
            tgt.setSourceElement(Uri10_30.convertUri(src.getSourceElement()));
        if (src.hasTitleElement())
            tgt.setNameElement(String10_30.convertString(src.getTitleElement()));
        if (src.hasKind())
            tgt.setKindElement(convertGuidePageKind(src.getKindElement()));
        for (org.hl7.fhir.dstu3.model.CodeType t : src.getType()) tgt.addType(t.getValue());
        for (org.hl7.fhir.dstu3.model.StringType t : src.getPackage()) tgt.addPackage(t.getValue());
        if (src.hasFormatElement())
            tgt.setFormatElement(Code10_30.convertCode(src.getFormatElement()));
        for (org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePageComponent t : src.getPage()) tgt.addPage(convertImplementationGuidePageComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePageComponent convertImplementationGuidePageComponent(org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuidePageComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePageComponent tgt = new org.hl7.fhir.dstu3.model.ImplementationGuide.ImplementationGuidePageComponent();
        Element10_30.copyElement(src, tgt);
        if (src.hasSourceElement())
            tgt.setSourceElement(Uri10_30.convertUri(src.getSourceElement()));
        if (src.hasNameElement())
            tgt.setTitleElement(String10_30.convertString(src.getNameElement()));
        if (src.hasKind())
            tgt.setKindElement(convertGuidePageKind(src.getKindElement()));
        for (org.hl7.fhir.dstu2.model.CodeType t : src.getType()) tgt.addType(t.getValue());
        for (org.hl7.fhir.dstu2.model.StringType t : src.getPackage()) tgt.addPackage(t.getValue());
        if (src.hasFormatElement())
            tgt.setFormatElement(Code10_30.convertCode(src.getFormatElement()));
        for (org.hl7.fhir.dstu2.model.ImplementationGuide.ImplementationGuidePageComponent t : src.getPage()) tgt.addPage(convertImplementationGuidePageComponent(t));
        return tgt;
    }
}