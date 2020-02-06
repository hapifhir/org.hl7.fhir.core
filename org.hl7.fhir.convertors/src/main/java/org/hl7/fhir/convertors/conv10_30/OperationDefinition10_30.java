package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.dstu2.model.BooleanType;
import org.hl7.fhir.dstu2.model.IntegerType;
import org.hl7.fhir.dstu2.model.StringType;
import org.hl7.fhir.dstu3.model.Enumerations.SearchParamType;
import org.hl7.fhir.dstu3.model.MarkdownType;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.Utilities;
import java.util.Collections;

public class OperationDefinition10_30 {

    public static org.hl7.fhir.dstu2.model.OperationDefinition convertOperationDefinition(org.hl7.fhir.dstu3.model.OperationDefinition src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.OperationDefinition tgt = new org.hl7.fhir.dstu2.model.OperationDefinition();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.dstu2.model.UriType) VersionConvertor_10_30.convertType(src.getUrlElement()));
        if (src.hasVersionElement())
            tgt.setVersionElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_30.convertType(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_30.convertType(src.getNameElement()));
        if (src.hasStatus()) {
            tgt.setStatus(VersionConvertor_10_30.convertConformanceResourceStatus(src.getStatus()));
        }
        if (src.hasKind()) {
            tgt.setKind(convertOperationKind(src.getKind()));
        }
        if (src.hasExperimentalElement())
            tgt.setExperimentalElement((BooleanType) VersionConvertor_10_30.convertType(src.getExperimentalElement()));
        if (src.hasDateElement())
            tgt.setDateElement((org.hl7.fhir.dstu2.model.DateTimeType) VersionConvertor_10_30.convertType(src.getDateElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_30.convertType(src.getPublisherElement()));
        if (src.hasContact()) {
            for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(convertOperationDefinitionContactComponent(t));
        }
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_30.convertType(src.getDescriptionElement()));
        if (src.hasPurpose()) {
            tgt.setRequirements(src.getPurpose());
        }
        if (src.hasIdempotentElement()) {
            tgt.setIdempotentElement((BooleanType) VersionConvertor_10_30.convertType(src.getIdempotentElement()));
        }
        if (src.hasCodeElement())
            tgt.setCodeElement((org.hl7.fhir.dstu2.model.CodeType) VersionConvertor_10_30.convertType(src.getCodeElement()));
        if (src.hasCommentElement()) {
            tgt.setNotesElement((StringType) VersionConvertor_10_30.convertType(src.getCommentElement()));
        }
        if (src.hasBase())
            tgt.setBase(VersionConvertor_10_30.convertReference(src.getBase()));
        if (src.hasSystem()) {
            tgt.setSystem(src.getSystem());
        }
        if (src.getType())
            if (src.hasResource()) {
                for (org.hl7.fhir.dstu3.model.CodeType t : src.getResource()) tgt.addType(t.getValue());
            }
        if (src.hasInstance()) {
            tgt.setInstance(src.getInstance());
        }
        if (src.hasParameter()) {
            for (org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterComponent t : src.getParameter()) tgt.addParameter(convertOperationDefinitionParameterComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.OperationDefinition convertOperationDefinition(org.hl7.fhir.dstu2.model.OperationDefinition src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.OperationDefinition tgt = new org.hl7.fhir.dstu3.model.OperationDefinition();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.dstu3.model.UriType) VersionConvertor_10_30.convertType(src.getUrlElement()));
        if (src.hasVersionElement())
            tgt.setVersionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_10_30.convertType(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_10_30.convertType(src.getNameElement()));
        if (src.hasStatus()) {
            tgt.setStatus(VersionConvertor_10_30.convertConformanceResourceStatus(src.getStatus()));
        }
        if (src.hasKind()) {
            tgt.setKind(convertOperationKind(src.getKind()));
        }
        if (src.hasExperimentalElement())
            tgt.setExperimentalElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_10_30.convertType(src.getExperimentalElement()));
        if (src.hasDateElement())
            tgt.setDateElement((org.hl7.fhir.dstu3.model.DateTimeType) VersionConvertor_10_30.convertType(src.getDateElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_10_30.convertType(src.getPublisherElement()));
        if (src.hasContact()) {
            for (org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionContactComponent t : src.getContact()) tgt.addContact(convertOperationDefinitionContactComponent(t));
        }
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu3.model.MarkdownType) VersionConvertor_10_30.convertType(src.getDescriptionElement()));
        if (src.hasRequirementsElement()) {
            tgt.setPurposeElement((MarkdownType) VersionConvertor_10_30.convertType(src.getRequirementsElement()));
        }
        if (src.hasIdempotentElement())
            tgt.setIdempotentElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_10_30.convertType(src.getIdempotentElement()));
        if (src.hasCodeElement())
            tgt.setCodeElement((org.hl7.fhir.dstu3.model.CodeType) VersionConvertor_10_30.convertType(src.getCodeElement()));
        if (src.hasNotesElement()) {
            tgt.setCommentElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_10_30.convertType(src.getNotesElement()));
        }
        if (src.hasBase()) {
            tgt.setBase(VersionConvertor_10_30.convertReference(src.getBase()));
        }
        if (src.hasSystem()) {
            tgt.setSystem(src.getSystem());
        }
        if (src.hasType()) {
            for (org.hl7.fhir.dstu2.model.CodeType t : src.getType()) tgt.addResource(t.getValue());
        }
        tgt.setType(tgt.hasResource());
        if (src.hasInstance()) {
            tgt.setInstance(src.getInstance());
        }
        if (src.hasParameter()) {
            for (org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionParameterComponent t : src.getParameter()) tgt.addParameter(convertOperationDefinitionParameterComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionContactComponent convertOperationDefinitionContactComponent(org.hl7.fhir.dstu3.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionContactComponent tgt = new org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionContactComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_30.convertType(src.getNameElement()));
        if (src.hasTelecom()) {
            for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_30.convertContactPoint(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ContactDetail convertOperationDefinitionContactComponent(org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ContactDetail tgt = new org.hl7.fhir.dstu3.model.ContactDetail();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_10_30.convertType(src.getNameElement()));
        if (src.hasTelecom()) {
            for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_30.convertContactPoint(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterBindingComponent convertOperationDefinitionParameterBindingComponent(org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionParameterBindingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterBindingComponent tgt = new org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterBindingComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasStrength()) {
            tgt.setStrength(VersionConvertor_10_30.convertBindingStrength(src.getStrength()));
        }
        if (src.hasValueSet()) {
            tgt.setValueSet(VersionConvertor_10_30.convertType(src.getValueSet()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionParameterBindingComponent convertOperationDefinitionParameterBindingComponent(org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterBindingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionParameterBindingComponent tgt = new org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionParameterBindingComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasStrength()) {
            tgt.setStrength(VersionConvertor_10_30.convertBindingStrength(src.getStrength()));
        }
        if (src.hasValueSet()) {
            tgt.setValueSet(VersionConvertor_10_30.convertType(src.getValueSet()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionParameterComponent convertOperationDefinitionParameterComponent(org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionParameterComponent tgt = new org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionParameterComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu2.model.CodeType) VersionConvertor_10_30.convertType(src.getNameElement()));
        if (src.hasUse()) {
            tgt.setUse(convertOperationParameterUse(src.getUse()));
        }
        if (src.hasMinElement()) {
            tgt.setMinElement((IntegerType) VersionConvertor_10_30.convertType(src.getMinElement()));
        }
        if (src.hasMaxElement())
            tgt.setMaxElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_30.convertType(src.getMaxElement()));
        if (src.hasDocumentationElement())
            tgt.setDocumentationElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_30.convertType(src.getDocumentationElement()));
        if (src.hasTypeElement())
            tgt.setTypeElement((org.hl7.fhir.dstu2.model.CodeType) VersionConvertor_10_30.convertType(src.getTypeElement()));
        if (src.hasProfile())
            tgt.setProfile(VersionConvertor_10_30.convertReference(src.getProfile()));
        if (src.hasBinding())
            tgt.setBinding(convertOperationDefinitionParameterBindingComponent(src.getBinding()));
        if (src.hasPart()) {
            for (org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterComponent t : src.getPart()) tgt.addPart(convertOperationDefinitionParameterComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterComponent convertOperationDefinitionParameterComponent(org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionParameterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterComponent tgt = new org.hl7.fhir.dstu3.model.OperationDefinition.OperationDefinitionParameterComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu3.model.CodeType) VersionConvertor_10_30.convertType(src.getNameElement()));
        if (src.hasUse()) {
            tgt.setUse(convertOperationParameterUse(src.getUse()));
        }
        if (src.hasMinElement()) {
            tgt.setMinElement((org.hl7.fhir.dstu3.model.IntegerType) VersionConvertor_10_30.convertType(src.getMinElement()));
        }
        if (src.hasMaxElement())
            tgt.setMaxElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_10_30.convertType(src.getMaxElement()));
        if (src.hasDocumentationElement())
            tgt.setDocumentationElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_10_30.convertType(src.getDocumentationElement()));
        if (Utilities.existsInList(src.getType(), "token", "reference", "composite", "number", "date", "quantity", "uri"))
            tgt.setTypeElement((org.hl7.fhir.dstu3.model.CodeType) VersionConvertor_10_30.convertType(src.getTypeElement()));
        if (src.hasProfile()) {
            tgt.setProfile(VersionConvertor_10_30.convertReference(src.getProfile()));
        }
        if (src.hasBinding()) {
            tgt.setBinding(convertOperationDefinitionParameterBindingComponent(src.getBinding()));
        }
        if (src.hasPart()) {
            for (org.hl7.fhir.dstu2.model.OperationDefinition.OperationDefinitionParameterComponent t : src.getPart()) tgt.addPart(convertOperationDefinitionParameterComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.OperationDefinition.OperationKind convertOperationKind(org.hl7.fhir.dstu3.model.OperationDefinition.OperationKind src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case OPERATION:
                return org.hl7.fhir.dstu2.model.OperationDefinition.OperationKind.OPERATION;
            case QUERY:
                return org.hl7.fhir.dstu2.model.OperationDefinition.OperationKind.QUERY;
            default:
                return org.hl7.fhir.dstu2.model.OperationDefinition.OperationKind.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.OperationDefinition.OperationKind convertOperationKind(org.hl7.fhir.dstu2.model.OperationDefinition.OperationKind src) throws FHIRException {
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

    public static org.hl7.fhir.dstu2.model.OperationDefinition.OperationParameterUse convertOperationParameterUse(org.hl7.fhir.dstu3.model.OperationDefinition.OperationParameterUse src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case IN:
                return org.hl7.fhir.dstu2.model.OperationDefinition.OperationParameterUse.IN;
            case OUT:
                return org.hl7.fhir.dstu2.model.OperationDefinition.OperationParameterUse.OUT;
            default:
                return org.hl7.fhir.dstu2.model.OperationDefinition.OperationParameterUse.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.OperationDefinition.OperationParameterUse convertOperationParameterUse(org.hl7.fhir.dstu2.model.OperationDefinition.OperationParameterUse src) throws FHIRException {
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
