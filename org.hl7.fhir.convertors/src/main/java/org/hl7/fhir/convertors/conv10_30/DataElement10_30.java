package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.dstu2.model.BooleanType;
import org.hl7.fhir.dstu2.model.StringType;
import org.hl7.fhir.exceptions.FHIRException;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class DataElement10_30 {

    public static org.hl7.fhir.dstu2.model.DataElement convertDataElement(org.hl7.fhir.dstu3.model.DataElement src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.DataElement tgt = new org.hl7.fhir.dstu2.model.DataElement();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.dstu2.model.UriType) VersionConvertor_10_30.convertType(src.getUrlElement()));
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        }
        if (src.hasVersionElement())
            tgt.setVersionElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_30.convertType(src.getVersionElement()));
        if (src.hasStatus()) {
            tgt.setStatus(VersionConvertor_10_30.convertConformanceResourceStatus(src.getStatus()));
        }
        if (src.hasExperimentalElement())
            tgt.setExperimentalElement((BooleanType) VersionConvertor_10_30.convertType(src.getExperimentalElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_30.convertType(src.getPublisherElement()));
        if (src.hasDateElement())
            tgt.setDateElement((org.hl7.fhir.dstu2.model.DateTimeType) VersionConvertor_10_30.convertType(src.getDateElement()));
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_30.convertType(src.getNameElement()));
        if (src.hasContact()) {
            for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(convertDataElementContactComponent(t));
        }
        for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext()) if (t.hasValueCodeableConcept())
            tgt.addUseContext(VersionConvertor_10_30.convertCodeableConcept(t.getValueCodeableConcept()));
        if (src.hasJurisdiction()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addUseContext(VersionConvertor_10_30.convertCodeableConcept(t));
        }
        if (src.hasCopyrightElement())
            tgt.setCopyrightElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_30.convertType(src.getCopyrightElement()));
        if (src.hasStringency()) {
            tgt.setStringency(convertDataElementStringency(src.getStringency()));
        }
        if (src.hasMapping()) {
            for (org.hl7.fhir.dstu3.model.DataElement.DataElementMappingComponent t : src.getMapping()) tgt.addMapping(convertDataElementMappingComponent(t));
        }
        if (src.hasElement()) {
            for (org.hl7.fhir.dstu3.model.ElementDefinition t : src.getElement()) tgt.addElement(VersionConvertor_10_30.convertElementDefinition(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DataElement convertDataElement(org.hl7.fhir.dstu2.model.DataElement src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.DataElement tgt = new org.hl7.fhir.dstu3.model.DataElement();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.dstu3.model.UriType) VersionConvertor_10_30.convertType(src.getUrlElement()));
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        }
        if (src.hasVersionElement())
            tgt.setVersionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_10_30.convertType(src.getVersionElement()));
        if (src.hasStatus()) {
            tgt.setStatus(VersionConvertor_10_30.convertConformanceResourceStatus(src.getStatus()));
        }
        if (src.hasExperimentalElement())
            tgt.setExperimentalElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_10_30.convertType(src.getExperimentalElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_10_30.convertType(src.getPublisherElement()));
        if (src.hasDateElement())
            tgt.setDateElement((org.hl7.fhir.dstu3.model.DateTimeType) VersionConvertor_10_30.convertType(src.getDateElement()));
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_10_30.convertType(src.getNameElement()));
        if (src.hasContact()) {
            for (org.hl7.fhir.dstu2.model.DataElement.DataElementContactComponent t : src.getContact()) tgt.addContact(convertDataElementContactComponent(t));
        }
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getUseContext()) if (VersionConvertor_10_30.isJurisdiction(t))
            tgt.addJurisdiction(VersionConvertor_10_30.convertCodeableConcept(t));
        else
            tgt.addUseContext(VersionConvertor_10_30.convertCodeableConceptToUsageContext(t));
        if (src.hasCopyrightElement())
            tgt.setCopyrightElement((org.hl7.fhir.dstu3.model.MarkdownType) VersionConvertor_10_30.convertType(src.getCopyrightElement()));
        if (src.hasStringency()) {
            tgt.setStringency(convertDataElementStringency(src.getStringency()));
        }
        if (src.hasMapping()) {
            for (org.hl7.fhir.dstu2.model.DataElement.DataElementMappingComponent t : src.getMapping()) tgt.addMapping(convertDataElementMappingComponent(t));
        }
        List<String> slicePaths = new ArrayList<String>();
        for (org.hl7.fhir.dstu2.model.ElementDefinition t : src.getElement()) {
            if (t.hasSlicing())
                slicePaths.add(t.getPath());
            tgt.addElement(VersionConvertor_10_30.convertElementDefinition(t, slicePaths));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ContactDetail convertDataElementContactComponent(org.hl7.fhir.dstu2.model.DataElement.DataElementContactComponent src) throws FHIRException {
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

    public static org.hl7.fhir.dstu2.model.DataElement.DataElementContactComponent convertDataElementContactComponent(org.hl7.fhir.dstu3.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.DataElement.DataElementContactComponent tgt = new org.hl7.fhir.dstu2.model.DataElement.DataElementContactComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_30.convertType(src.getNameElement()));
        if (src.hasTelecom()) {
            for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_30.convertContactPoint(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DataElement.DataElementMappingComponent convertDataElementMappingComponent(org.hl7.fhir.dstu2.model.DataElement.DataElementMappingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.DataElement.DataElementMappingComponent tgt = new org.hl7.fhir.dstu3.model.DataElement.DataElementMappingComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasIdentityElement())
            tgt.setIdentityElement((org.hl7.fhir.dstu3.model.IdType) VersionConvertor_10_30.convertType(src.getIdentityElement()));
        if (src.hasUriElement())
            tgt.setUriElement((org.hl7.fhir.dstu3.model.UriType) VersionConvertor_10_30.convertType(src.getUriElement()));
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_10_30.convertType(src.getNameElement()));
        if (src.hasComments()) {
            tgt.setComment(src.getComments());
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.DataElement.DataElementMappingComponent convertDataElementMappingComponent(org.hl7.fhir.dstu3.model.DataElement.DataElementMappingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.DataElement.DataElementMappingComponent tgt = new org.hl7.fhir.dstu2.model.DataElement.DataElementMappingComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasIdentityElement())
            tgt.setIdentityElement((org.hl7.fhir.dstu2.model.IdType) VersionConvertor_10_30.convertType(src.getIdentityElement()));
        if (src.hasUriElement())
            tgt.setUriElement((org.hl7.fhir.dstu2.model.UriType) VersionConvertor_10_30.convertType(src.getUriElement()));
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_30.convertType(src.getNameElement()));
        if (src.hasCommentElement()) {
            tgt.setCommentsElement((StringType) VersionConvertor_10_30.convertType(src.getCommentElement()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.DataElement.DataElementStringency convertDataElementStringency(org.hl7.fhir.dstu3.model.DataElement.DataElementStringency src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case COMPARABLE:
                return org.hl7.fhir.dstu2.model.DataElement.DataElementStringency.COMPARABLE;
            case FULLYSPECIFIED:
                return org.hl7.fhir.dstu2.model.DataElement.DataElementStringency.FULLYSPECIFIED;
            case EQUIVALENT:
                return org.hl7.fhir.dstu2.model.DataElement.DataElementStringency.EQUIVALENT;
            case CONVERTABLE:
                return org.hl7.fhir.dstu2.model.DataElement.DataElementStringency.CONVERTABLE;
            case SCALEABLE:
                return org.hl7.fhir.dstu2.model.DataElement.DataElementStringency.SCALEABLE;
            case FLEXIBLE:
                return org.hl7.fhir.dstu2.model.DataElement.DataElementStringency.FLEXIBLE;
            default:
                return org.hl7.fhir.dstu2.model.DataElement.DataElementStringency.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.DataElement.DataElementStringency convertDataElementStringency(org.hl7.fhir.dstu2.model.DataElement.DataElementStringency src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case COMPARABLE:
                return org.hl7.fhir.dstu3.model.DataElement.DataElementStringency.COMPARABLE;
            case FULLYSPECIFIED:
                return org.hl7.fhir.dstu3.model.DataElement.DataElementStringency.FULLYSPECIFIED;
            case EQUIVALENT:
                return org.hl7.fhir.dstu3.model.DataElement.DataElementStringency.EQUIVALENT;
            case CONVERTABLE:
                return org.hl7.fhir.dstu3.model.DataElement.DataElementStringency.CONVERTABLE;
            case SCALEABLE:
                return org.hl7.fhir.dstu3.model.DataElement.DataElementStringency.SCALEABLE;
            case FLEXIBLE:
                return org.hl7.fhir.dstu3.model.DataElement.DataElementStringency.FLEXIBLE;
            default:
                return org.hl7.fhir.dstu3.model.DataElement.DataElementStringency.NULL;
        }
    }
}
