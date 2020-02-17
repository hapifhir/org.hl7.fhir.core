package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Media10_30 {

    public static org.hl7.fhir.dstu2.model.Media.DigitalMediaType convertDigitalMediaType(org.hl7.fhir.dstu3.model.Media.DigitalMediaType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PHOTO:
                return org.hl7.fhir.dstu2.model.Media.DigitalMediaType.PHOTO;
            case VIDEO:
                return org.hl7.fhir.dstu2.model.Media.DigitalMediaType.VIDEO;
            case AUDIO:
                return org.hl7.fhir.dstu2.model.Media.DigitalMediaType.AUDIO;
            default:
                return org.hl7.fhir.dstu2.model.Media.DigitalMediaType.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.Media.DigitalMediaType convertDigitalMediaType(org.hl7.fhir.dstu2.model.Media.DigitalMediaType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PHOTO:
                return org.hl7.fhir.dstu3.model.Media.DigitalMediaType.PHOTO;
            case VIDEO:
                return org.hl7.fhir.dstu3.model.Media.DigitalMediaType.VIDEO;
            case AUDIO:
                return org.hl7.fhir.dstu3.model.Media.DigitalMediaType.AUDIO;
            default:
                return org.hl7.fhir.dstu3.model.Media.DigitalMediaType.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Media convertMedia(org.hl7.fhir.dstu3.model.Media src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Media tgt = new org.hl7.fhir.dstu2.model.Media();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        if (src.hasType())
            tgt.setType(convertDigitalMediaType(src.getType()));
        if (src.hasSubtype())
            tgt.setSubtype(VersionConvertor_10_30.convertCodeableConcept(src.getSubtype()));
        if (src.hasView())
            tgt.setView(VersionConvertor_10_30.convertCodeableConcept(src.getView()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_10_30.convertReference(src.getSubject()));
        if (src.hasOperator())
            tgt.setOperator(VersionConvertor_10_30.convertReference(src.getOperator()));
        tgt.setDeviceName(src.getDevice().getDisplay());
        if (src.hasHeightElement())
            tgt.setHeightElement(VersionConvertor_10_30.convertPositiveInt(src.getHeightElement()));
        if (src.hasWidthElement())
            tgt.setWidthElement(VersionConvertor_10_30.convertPositiveInt(src.getWidthElement()));
        if (src.hasFramesElement())
            tgt.setFramesElement(VersionConvertor_10_30.convertPositiveInt(src.getFramesElement()));
        if (src.hasDurationElement())
            tgt.setDurationElement(VersionConvertor_10_30.convertUnsignedInt(src.getDurationElement()));
        if (src.hasContent())
            tgt.setContent(VersionConvertor_10_30.convertAttachment(src.getContent()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Media convertMedia(org.hl7.fhir.dstu2.model.Media src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Media tgt = new org.hl7.fhir.dstu3.model.Media();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        if (src.hasType())
            tgt.setType(convertDigitalMediaType(src.getType()));
        if (src.hasSubtype())
            tgt.setSubtype(VersionConvertor_10_30.convertCodeableConcept(src.getSubtype()));
        if (src.hasView())
            tgt.setView(VersionConvertor_10_30.convertCodeableConcept(src.getView()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_10_30.convertReference(src.getSubject()));
        if (src.hasOperator())
            tgt.setOperator(VersionConvertor_10_30.convertReference(src.getOperator()));
        tgt.getDevice().setDisplay(src.getDeviceName());
        if (src.hasHeightElement())
            tgt.setHeightElement(VersionConvertor_10_30.convertPositiveInt(src.getHeightElement()));
        if (src.hasWidthElement())
            tgt.setWidthElement(VersionConvertor_10_30.convertPositiveInt(src.getWidthElement()));
        if (src.hasFramesElement())
            tgt.setFramesElement(VersionConvertor_10_30.convertPositiveInt(src.getFramesElement()));
        if (src.hasDurationElement())
            tgt.setDurationElement(VersionConvertor_10_30.convertUnsignedInt(src.getDurationElement()));
        if (src.hasContent())
            tgt.setContent(VersionConvertor_10_30.convertAttachment(src.getContent()));
        return tgt;
    }
}
