package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.dstu2.model.PositiveIntType;
import org.hl7.fhir.dstu2.model.UnsignedIntType;
import org.hl7.fhir.exceptions.FHIRException;
import java.util.Collections;

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
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        }
        if (src.hasType()) {
            tgt.setType(convertDigitalMediaType(src.getType()));
        }
        if (src.hasSubtype()) {
            tgt.setSubtype(VersionConvertor_10_30.convertCodeableConcept(src.getSubtype()));
        }
        if (src.hasView()) {
            tgt.setView(VersionConvertor_10_30.convertCodeableConcept(src.getView()));
        }
        if (src.hasSubject()) {
            tgt.setSubject(VersionConvertor_10_30.convertReference(src.getSubject()));
        }
        if (src.hasOperator()) {
            tgt.setOperator(VersionConvertor_10_30.convertReference(src.getOperator()));
        }
        if (src.hasDevice()) {
            tgt.setDeviceName(src.getDevice().getDisplay());
        }
        if (src.hasHeightElement()) {
            tgt.setHeightElement((PositiveIntType) VersionConvertor_10_30.convertType(src.getHeightElement()));
        }
        if (src.hasWidthElement()) {
            tgt.setWidthElement((PositiveIntType) VersionConvertor_10_30.convertType(src.getWidthElement()));
        }
        if (src.hasFramesElement()) {
            tgt.setFramesElement((PositiveIntType) VersionConvertor_10_30.convertType(src.getFramesElement()));
        }
        if (src.hasDurationElement()) {
            tgt.setDurationElement((UnsignedIntType) VersionConvertor_10_30.convertType(src.getDurationElement()));
        }
        if (src.hasContent()) {
            tgt.setContent(VersionConvertor_10_30.convertAttachment(src.getContent()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Media convertMedia(org.hl7.fhir.dstu2.model.Media src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Media tgt = new org.hl7.fhir.dstu3.model.Media();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        }
        if (src.hasType()) {
            tgt.setType(convertDigitalMediaType(src.getType()));
        }
        if (src.hasSubtype()) {
            tgt.setSubtype(VersionConvertor_10_30.convertCodeableConcept(src.getSubtype()));
        }
        if (src.hasView()) {
            tgt.setView(VersionConvertor_10_30.convertCodeableConcept(src.getView()));
        }
        if (src.hasSubject()) {
            tgt.setSubject(VersionConvertor_10_30.convertReference(src.getSubject()));
        }
        if (src.hasOperator()) {
            tgt.setOperator(VersionConvertor_10_30.convertReference(src.getOperator()));
        }
        if (src.hasDeviceName()) {
            tgt.getDevice().setDisplay(src.getDeviceName());
        }
        if (src.hasHeightElement()) {
            tgt.setHeightElement((org.hl7.fhir.dstu3.model.PositiveIntType) VersionConvertor_10_30.convertType(src.getHeightElement()));
        }
        if (src.hasWidthElement()) {
            tgt.setWidthElement((org.hl7.fhir.dstu3.model.PositiveIntType) VersionConvertor_10_30.convertType(src.getWidthElement()));
        }
        if (src.hasFramesElement()) {
            tgt.setFramesElement((org.hl7.fhir.dstu3.model.PositiveIntType) VersionConvertor_10_30.convertType(src.getFramesElement()));
        }
        if (src.hasDurationElement()) {
            tgt.setDurationElement((org.hl7.fhir.dstu3.model.UnsignedIntType) VersionConvertor_10_30.convertType(src.getDurationElement()));
        }
        if (src.hasContent()) {
            tgt.setContent(VersionConvertor_10_30.convertAttachment(src.getContent()));
        }
        return tgt;
    }
}
