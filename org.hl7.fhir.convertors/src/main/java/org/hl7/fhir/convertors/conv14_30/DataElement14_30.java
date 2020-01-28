package org.hl7.fhir.convertors.conv14_30;

import org.hl7.fhir.convertors.VersionConvertor_14_30;
import org.hl7.fhir.exceptions.FHIRException;

public class DataElement14_30 {

    public static org.hl7.fhir.dstu3.model.DataElement convertDataElement(org.hl7.fhir.dstu2016may.model.DataElement src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.DataElement tgt = new org.hl7.fhir.dstu3.model.DataElement();
        VersionConvertor_14_30.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrl(src.getUrl());
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu2016may.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_14_30.convertIdentifier(t));
        }
        if (src.hasVersion())
            tgt.setVersion(src.getVersion());
        if (src.hasStatus()) {
            tgt.setStatus(VersionConvertor_14_30.convertConformanceResourceStatus(src.getStatus()));
        }
        if (src.hasExperimental())
            tgt.setExperimental(src.getExperimental());
        if (src.hasPublisher())
            tgt.setPublisher(src.getPublisher());
        if (src.hasDate())
            tgt.setDate(src.getDate());
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasContact()) {
            for (org.hl7.fhir.dstu2016may.model.DataElement.DataElementContactComponent t : src.getContact()) tgt.addContact(convertDataElementContactComponent(t));
        }
        for (org.hl7.fhir.dstu2016may.model.CodeableConcept t : src.getUseContext()) if (VersionConvertor_14_30.isJurisdiction(t))
            tgt.addJurisdiction(VersionConvertor_14_30.convertCodeableConcept(t));
        else
            tgt.addUseContext(VersionConvertor_14_30.convertCodeableConceptToUsageContext(t));
        if (src.hasCopyright())
            tgt.setCopyright(src.getCopyright());
        if (src.hasStringency()) {
            tgt.setStringency(convertDataElementStringency(src.getStringency()));
        }
        if (src.hasMapping()) {
            for (org.hl7.fhir.dstu2016may.model.DataElement.DataElementMappingComponent t : src.getMapping()) tgt.addMapping(convertDataElementMappingComponent(t));
        }
        if (src.hasElement()) {
            for (org.hl7.fhir.dstu2016may.model.ElementDefinition t : src.getElement()) tgt.addElement(VersionConvertor_14_30.convertElementDefinition(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.DataElement convertDataElement(org.hl7.fhir.dstu3.model.DataElement src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.DataElement tgt = new org.hl7.fhir.dstu2016may.model.DataElement();
        VersionConvertor_14_30.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrl(src.getUrl());
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_14_30.convertIdentifier(t));
        }
        if (src.hasVersion())
            tgt.setVersion(src.getVersion());
        if (src.hasStatus()) {
            tgt.setStatus(VersionConvertor_14_30.convertConformanceResourceStatus(src.getStatus()));
        }
        if (src.hasExperimental())
            tgt.setExperimental(src.getExperimental());
        if (src.hasPublisher())
            tgt.setPublisher(src.getPublisher());
        if (src.hasDate())
            tgt.setDate(src.getDate());
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasContact()) {
            for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(convertDataElementContactComponent(t));
        }
        for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext()) if (t.hasValueCodeableConcept())
            tgt.addUseContext(VersionConvertor_14_30.convertCodeableConcept(t.getValueCodeableConcept()));
        if (src.hasJurisdiction()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addUseContext(VersionConvertor_14_30.convertCodeableConcept(t));
        }
        if (src.hasCopyright())
            tgt.setCopyright(src.getCopyright());
        if (src.hasStringency()) {
            tgt.setStringency(convertDataElementStringency(src.getStringency()));
        }
        if (src.hasMapping()) {
            for (org.hl7.fhir.dstu3.model.DataElement.DataElementMappingComponent t : src.getMapping()) tgt.addMapping(convertDataElementMappingComponent(t));
        }
        if (src.hasElement()) {
            for (org.hl7.fhir.dstu3.model.ElementDefinition t : src.getElement()) tgt.addElement(VersionConvertor_14_30.convertElementDefinition(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ContactDetail convertDataElementContactComponent(org.hl7.fhir.dstu2016may.model.DataElement.DataElementContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ContactDetail tgt = new org.hl7.fhir.dstu3.model.ContactDetail();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasTelecom()) {
            for (org.hl7.fhir.dstu2016may.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_14_30.convertContactPoint(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.DataElement.DataElementContactComponent convertDataElementContactComponent(org.hl7.fhir.dstu3.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.DataElement.DataElementContactComponent tgt = new org.hl7.fhir.dstu2016may.model.DataElement.DataElementContactComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasTelecom()) {
            for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_14_30.convertContactPoint(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DataElement.DataElementMappingComponent convertDataElementMappingComponent(org.hl7.fhir.dstu2016may.model.DataElement.DataElementMappingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.DataElement.DataElementMappingComponent tgt = new org.hl7.fhir.dstu3.model.DataElement.DataElementMappingComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasIdentity()) {
            tgt.setIdentity(src.getIdentity());
        }
        if (src.hasUri())
            tgt.setUri(src.getUri());
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasComment())
            tgt.setComment(src.getComment());
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.DataElement.DataElementMappingComponent convertDataElementMappingComponent(org.hl7.fhir.dstu3.model.DataElement.DataElementMappingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.DataElement.DataElementMappingComponent tgt = new org.hl7.fhir.dstu2016may.model.DataElement.DataElementMappingComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasIdentity()) {
            tgt.setIdentity(src.getIdentity());
        }
        if (src.hasUri())
            tgt.setUri(src.getUri());
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasComment())
            tgt.setComment(src.getComment());
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.DataElement.DataElementStringency convertDataElementStringency(org.hl7.fhir.dstu2016may.model.DataElement.DataElementStringency src) throws FHIRException {
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

    static public org.hl7.fhir.dstu2016may.model.DataElement.DataElementStringency convertDataElementStringency(org.hl7.fhir.dstu3.model.DataElement.DataElementStringency src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case COMPARABLE:
                return org.hl7.fhir.dstu2016may.model.DataElement.DataElementStringency.COMPARABLE;
            case FULLYSPECIFIED:
                return org.hl7.fhir.dstu2016may.model.DataElement.DataElementStringency.FULLYSPECIFIED;
            case EQUIVALENT:
                return org.hl7.fhir.dstu2016may.model.DataElement.DataElementStringency.EQUIVALENT;
            case CONVERTABLE:
                return org.hl7.fhir.dstu2016may.model.DataElement.DataElementStringency.CONVERTABLE;
            case SCALEABLE:
                return org.hl7.fhir.dstu2016may.model.DataElement.DataElementStringency.SCALEABLE;
            case FLEXIBLE:
                return org.hl7.fhir.dstu2016may.model.DataElement.DataElementStringency.FLEXIBLE;
            default:
                return org.hl7.fhir.dstu2016may.model.DataElement.DataElementStringency.NULL;
        }
    }
}
