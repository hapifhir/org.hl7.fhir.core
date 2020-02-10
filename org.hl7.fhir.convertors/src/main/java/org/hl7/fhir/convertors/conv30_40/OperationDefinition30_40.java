package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.Type;
import java.util.Collections;

public class OperationDefinition30_40 {

    public static org.hl7.fhir.r4.model.OperationDefinition convertOperationDefinition(org.hl7.fhir.dstu3.model.OperationDefinition src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.OperationDefinition tgt = new org.hl7.fhir.r4.model.OperationDefinition();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.r4.model.UriType) VersionConvertor_30_40.convertType(src.getUrlElement()));
        if (src.hasVersionElement())
            tgt.setVersionElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatus(VersionConvertor_30_40.convertPublicationStatus(src.getStatus()));
        if (src.hasKind())
            tgt.setKind(convertOperationKind(src.getKind()));
        if (src.hasExperimentalElement())
            tgt.setExperimentalElement((org.hl7.fhir.r4.model.BooleanType) VersionConvertor_30_40.convertType(src.getExperimentalElement()));
        if (src.hasDateElement())
            tgt.setDateElement(VersionConvertor_30_40.convertDateTime(src.getDateElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getPublisherElement()));
        if (src.hasContact()) {
            for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(VersionConvertor_30_40.convertContactDetail(t));
        }
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.r4.model.MarkdownType) VersionConvertor_30_40.convertType(src.getDescriptionElement()));
        if (src.hasUseContext()) {
            for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_40.convertUsageContext(t));
        }
        if (src.hasJurisdiction()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasPurposeElement())
            tgt.setPurposeElement((org.hl7.fhir.r4.model.MarkdownType) VersionConvertor_30_40.convertType(src.getPurposeElement()));
        if (src.hasIdempotent())
            tgt.setAffectsState(!src.getIdempotent());
        if (src.hasCodeElement())
            tgt.setCodeElement((org.hl7.fhir.r4.model.CodeType) VersionConvertor_30_40.convertType(src.getCodeElement()));
        if (src.hasCommentElement())
            tgt.setCommentElement((org.hl7.fhir.r4.model.MarkdownType) VersionConvertor_30_40.convertType(src.getCommentElement()));
        if (src.hasBase())
            tgt.setBaseElement(VersionConvertor_30_40.convertReferenceToCanonical(src.getBase()));
        if (src.hasResource()) {
            for (org.hl7.fhir.dstu3.model.CodeType t : src.getResource()) tgt.addResource(t.getValue());
        }
        if (src.hasSystemElement())
            tgt.setSystemElement((org.hl7.fhir.r4.model.BooleanType) VersionConvertor_30_40.convertType(src.getSystemElement()));
        if (src.hasTypeElement())
            tgt.setTypeElement((org.hl7.fhir.r4.model.BooleanType) VersionConvertor_30_40.convertType(src.getTypeElement()));
        if (src.hasInstanceElement())
            tgt.setInstanceElement((org.hl7.fhir.r4.model.BooleanType) VersionConvertor_30_40.convertType(src.getInstanceElement()));
        if (src.hasParameter()) {
            for (org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterComponent t : src.getParameter()) tgt.addParameter(convertOperationDefinitionParameterComponent(t));
        }
        if (src.hasOverload()) {
            for (org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionOverloadComponent t : src.getOverload()) tgt.addOverload(convertOperationDefinitionOverloadComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.OperationDefinition convertOperationDefinition(org.hl7.fhir.r4.model.OperationDefinition src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.OperationDefinition tgt = new org.hl7.fhir.dstu3.model.OperationDefinition();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.dstu3.model.UriType) VersionConvertor_30_40.convertType(src.getUrlElement()));
        if (src.hasVersionElement())
            tgt.setVersionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatus(VersionConvertor_30_40.convertPublicationStatus(src.getStatus()));
        if (src.hasKind())
            tgt.setKind(convertOperationKind(src.getKind()));
        if (src.hasExperimentalElement())
            tgt.setExperimentalElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_30_40.convertType(src.getExperimentalElement()));
        if (src.hasDateElement())
            tgt.setDateElement(VersionConvertor_30_40.convertDateTime(src.getDateElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getPublisherElement()));
        if (src.hasContact()) {
            for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact()) tgt.addContact(VersionConvertor_30_40.convertContactDetail(t));
        }
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu3.model.MarkdownType) VersionConvertor_30_40.convertType(src.getDescriptionElement()));
        if (src.hasUseContext()) {
            for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_40.convertUsageContext(t));
        }
        if (src.hasJurisdiction()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasPurposeElement())
            tgt.setPurposeElement((org.hl7.fhir.dstu3.model.MarkdownType) VersionConvertor_30_40.convertType(src.getPurposeElement()));
        if (src.hasAffectsState())
            tgt.setIdempotent(!src.getAffectsState());
        if (src.hasCodeElement())
            tgt.setCodeElement((org.hl7.fhir.dstu3.model.CodeType) VersionConvertor_30_40.convertType(src.getCodeElement()));
        if (src.hasCommentElement())
            tgt.setCommentElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getCommentElement()));
        if (src.hasBase())
            tgt.setBase(VersionConvertor_30_40.convertCanonicalToReference(src.getBaseElement()));
        if (src.hasResource()) {
            for (org.hl7.fhir.r4.model.CodeType t : src.getResource()) tgt.addResource(t.getValue());
        }
        if (src.hasSystemElement())
            tgt.setSystemElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_30_40.convertType(src.getSystemElement()));
        if (src.hasTypeElement())
            tgt.setTypeElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_30_40.convertType(src.getTypeElement()));
        if (src.hasInstanceElement())
            tgt.setInstanceElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_30_40.convertType(src.getInstanceElement()));
        if (src.hasParameter()) {
            for (org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterComponent t : src.getParameter()) tgt.addParameter(convertOperationDefinitionParameterComponent(t));
        }
        if (src.hasOverload()) {
            for (org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionOverloadComponent t : src.getOverload()) tgt.addOverload(convertOperationDefinitionOverloadComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionOverloadComponent convertOperationDefinitionOverloadComponent(org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionOverloadComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionOverloadComponent tgt = new org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionOverloadComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasParameterName()) {
            for (org.hl7.fhir.r4.model.StringType t : src.getParameterName()) tgt.addParameterName(t.getValue());
        }
        if (src.hasCommentElement())
            tgt.setCommentElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getCommentElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionOverloadComponent convertOperationDefinitionOverloadComponent(org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionOverloadComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionOverloadComponent tgt = new org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionOverloadComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasParameterName()) {
            for (org.hl7.fhir.dstu3.model.StringType t : src.getParameterName()) tgt.addParameterName(t.getValue());
        }
        if (src.hasCommentElement())
            tgt.setCommentElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getCommentElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterBindingComponent convertOperationDefinitionParameterBindingComponent(org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterBindingComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterBindingComponent tgt = new org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterBindingComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasStrength())
            tgt.setStrength(VersionConvertor_30_40.convertBindingStrength(src.getStrength()));
        if (src.hasValueSet()) {
            String vsr = VersionConvertorConstants.vsToRef(src.getValueSet());
            if (vsr != null)
                tgt.setValueSet(new org.hl7.fhir.dstu3.model.UriType(vsr));
            else
                tgt.setValueSet(new org.hl7.fhir.dstu3.model.Reference(src.getValueSet()));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterBindingComponent convertOperationDefinitionParameterBindingComponent(org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterBindingComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterBindingComponent tgt = new org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterBindingComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasStrength())
            tgt.setStrength(VersionConvertor_30_40.convertBindingStrength(src.getStrength()));
        if (src.hasValueSet()) {
            Type t = VersionConvertor_30_40.convertType(src.getValueSet());
            if (t instanceof org.hl7.fhir.r4.model.Reference)
                tgt.setValueSet(((org.hl7.fhir.r4.model.Reference) t).getReference());
            else
                tgt.setValueSet(t.primitiveValue());
            tgt.setValueSet(VersionConvertorConstants.refToVS(tgt.getValueSet()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterComponent convertOperationDefinitionParameterComponent(org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterComponent tgt = new org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu3.model.CodeType) VersionConvertor_30_40.convertType(src.getNameElement()));
        if (src.hasUse())
            tgt.setUse(convertOperationParameterUse(src.getUse()));
        if (src.hasMinElement())
            tgt.setMinElement((org.hl7.fhir.dstu3.model.IntegerType) VersionConvertor_30_40.convertType(src.getMinElement()));
        if (src.hasMaxElement())
            tgt.setMaxElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getMaxElement()));
        if (src.hasDocumentationElement())
            tgt.setDocumentationElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getDocumentationElement()));
        if (src.hasTypeElement())
            tgt.setTypeElement((org.hl7.fhir.dstu3.model.CodeType) VersionConvertor_30_40.convertType(src.getTypeElement()));
        if (src.hasSearchType())
            tgt.setSearchType(VersionConvertor_30_40.convertSearchParamType(src.getSearchType()));
        if (src.hasTargetProfile()) {
            for (org.hl7.fhir.r4.model.UriType t : src.getTargetProfile()) tgt.setProfile(new org.hl7.fhir.dstu3.model.Reference(t.getValue()));
        }
        if (src.hasBinding())
            tgt.setBinding(convertOperationDefinitionParameterBindingComponent(src.getBinding()));
        if (src.hasPart()) {
            for (org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterComponent t : src.getPart()) tgt.addPart(convertOperationDefinitionParameterComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterComponent convertOperationDefinitionParameterComponent(org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterComponent tgt = new org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.r4.model.CodeType) VersionConvertor_30_40.convertType(src.getNameElement()));
        if (src.hasUse())
            tgt.setUse(convertOperationParameterUse(src.getUse()));
        if (src.hasMinElement())
            tgt.setMinElement((org.hl7.fhir.r4.model.IntegerType) VersionConvertor_30_40.convertType(src.getMinElement()));
        if (src.hasMaxElement())
            tgt.setMaxElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getMaxElement()));
        if (src.hasDocumentationElement())
            tgt.setDocumentationElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getDocumentationElement()));
        if (src.hasTypeElement())
            tgt.setTypeElement((org.hl7.fhir.r4.model.CodeType) VersionConvertor_30_40.convertType(src.getTypeElement()));
        if (src.hasSearchType())
            tgt.setSearchType(VersionConvertor_30_40.convertSearchParamType(src.getSearchType()));
        if (src.hasProfile())
            tgt.addTargetProfile(src.getProfile().getReference());
        if (src.hasBinding())
            tgt.setBinding(convertOperationDefinitionParameterBindingComponent(src.getBinding()));
        if (src.hasPart()) {
            for (org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterComponent t : src.getPart()) tgt.addPart(convertOperationDefinitionParameterComponent(t));
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.OperationDefinition.OperationKind convertOperationKind(org.hl7.fhir.r4.model.OperationDefinition.OperationKind src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case OPERATION:
                return org.hl7.fhir.dstu3.model.OperationDefinition.OperationKind.OPERATION;
            case QUERY:
                return org.hl7.fhir.dstu3.model.OperationDefinition.OperationKind.QUERY;
            default:
                return org.hl7.fhir.dstu3.model.OperationDefinition.OperationKind.NULL;
        }
    }

    static public org.hl7.fhir.r4.model.OperationDefinition.OperationKind convertOperationKind(org.hl7.fhir.dstu3.model.OperationDefinition.OperationKind src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case OPERATION:
                return org.hl7.fhir.r4.model.OperationDefinition.OperationKind.OPERATION;
            case QUERY:
                return org.hl7.fhir.r4.model.OperationDefinition.OperationKind.QUERY;
            default:
                return org.hl7.fhir.r4.model.OperationDefinition.OperationKind.NULL;
        }
    }

    static public org.hl7.fhir.r4.model.OperationDefinition.OperationParameterUse convertOperationParameterUse(org.hl7.fhir.dstu3.model.OperationDefinition.OperationParameterUse src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case IN:
                return org.hl7.fhir.r4.model.OperationDefinition.OperationParameterUse.IN;
            case OUT:
                return org.hl7.fhir.r4.model.OperationDefinition.OperationParameterUse.OUT;
            default:
                return org.hl7.fhir.r4.model.OperationDefinition.OperationParameterUse.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.OperationDefinition.OperationParameterUse convertOperationParameterUse(org.hl7.fhir.r4.model.OperationDefinition.OperationParameterUse src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case IN:
                return org.hl7.fhir.dstu3.model.OperationDefinition.OperationParameterUse.IN;
            case OUT:
                return org.hl7.fhir.dstu3.model.OperationDefinition.OperationParameterUse.OUT;
            default:
                return org.hl7.fhir.dstu3.model.OperationDefinition.OperationParameterUse.NULL;
        }
    }
}
