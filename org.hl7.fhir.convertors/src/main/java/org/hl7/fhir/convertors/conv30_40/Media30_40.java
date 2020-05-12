package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.CodeableConcept;

public class Media30_40 {

    private static final String CODE_SYSTEM_MEDIA_TYPE = "http://terminology.hl7.org/CodeSystem/media-type";

    public static org.hl7.fhir.dstu3.model.Media convertMedia(org.hl7.fhir.r4.model.Media src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Media tgt = new org.hl7.fhir.dstu3.model.Media();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) {
            tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        }
        for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn()) {
            tgt.addBasedOn(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasType()) {
            CodeableConcept type = src.getType();
            for (org.hl7.fhir.r4.model.Coding c : type.getCoding()) {
                if (CODE_SYSTEM_MEDIA_TYPE.equals(c.getSystem())) {
                    tgt.setType(org.hl7.fhir.dstu3.model.Media.DigitalMediaType.fromCode(c.getCode().replace("image", "photo")));
                    break;
                }
            }
        }
        if (src.hasModality()) {
            if (src.hasModality())
                tgt.setSubtype(VersionConvertor_30_40.convertCodeableConcept(src.getModality()));
        }
        if (src.hasView()) {
            if (src.hasView())
                tgt.setView(VersionConvertor_30_40.convertCodeableConcept(src.getView()));
        }
        if (src.hasSubject()) {
            if (src.hasSubject())
                tgt.setSubject(VersionConvertor_30_40.convertReference(src.getSubject()));
        }
        if (src.hasEncounter()) {
            if (src.hasEncounter())
                tgt.setContext(VersionConvertor_30_40.convertReference(src.getEncounter()));
        }
        if (src.hasCreated()) {
            if (src.hasCreated())
                tgt.setOccurrence(VersionConvertor_30_40.convertType(src.getCreated()));
        }
        if (src.hasOperator()) {
            if (src.hasOperator())
                tgt.setOperator(VersionConvertor_30_40.convertReference(src.getOperator()));
        }
        for (CodeableConcept t : src.getReasonCode()) {
            tgt.addReasonCode(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasBodySite()) {
            if (src.hasBodySite())
                tgt.setBodySite(VersionConvertor_30_40.convertCodeableConcept(src.getBodySite()));
        }
        if (src.hasDevice()) {
            if (src.hasDevice())
                tgt.setDevice(VersionConvertor_30_40.convertReference(src.getDevice()));
        }
        if (src.hasHeight()) {
            if (src.hasHeightElement())
                tgt.setHeightElement(VersionConvertor_30_40.convertPositiveInt(src.getHeightElement()));
        }
        if (src.hasWidth()) {
            if (src.hasWidthElement())
                tgt.setWidthElement(VersionConvertor_30_40.convertPositiveInt(src.getWidthElement()));
        }
        if (src.hasFrames()) {
            if (src.hasFramesElement())
                tgt.setFramesElement(VersionConvertor_30_40.convertPositiveInt(src.getFramesElement()));
        }
        if (src.hasDuration()) {
            tgt.setDuration(src.getDuration().intValue());
        }
        if (src.hasContent()) {
            if (src.hasContent())
                tgt.setContent(VersionConvertor_30_40.convertAttachment(src.getContent()));
        }
        for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) {
            tgt.addNote(VersionConvertor_30_40.convertAnnotation(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Media convertMedia(org.hl7.fhir.dstu3.model.Media src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Media tgt = new org.hl7.fhir.r4.model.Media();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) {
            tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        }
        for (org.hl7.fhir.dstu3.model.Reference t : src.getBasedOn()) {
            tgt.addBasedOn(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasType()) {
            org.hl7.fhir.r4.model.Coding coding = new org.hl7.fhir.r4.model.Coding();
            coding.setSystem(CODE_SYSTEM_MEDIA_TYPE);
            coding.setCode(src.getType().toCode().replace("photo", "image"));
            CodeableConcept codeableConcept = new CodeableConcept(coding);
            tgt.setType(codeableConcept);
        }
        if (src.hasSubtype()) {
            if (src.hasSubtype())
                tgt.setModality(VersionConvertor_30_40.convertCodeableConcept(src.getSubtype()));
        }
        if (src.hasView()) {
            if (src.hasView())
                tgt.setView(VersionConvertor_30_40.convertCodeableConcept(src.getView()));
        }
        if (src.hasSubject()) {
            if (src.hasSubject())
                tgt.setSubject(VersionConvertor_30_40.convertReference(src.getSubject()));
        }
        if (src.hasContext()) {
            if (src.hasContext())
                tgt.setEncounter(VersionConvertor_30_40.convertReference(src.getContext()));
        }
        if (src.hasOccurrence()) {
            if (src.hasOccurrence())
                tgt.setCreated(VersionConvertor_30_40.convertType(src.getOccurrence()));
        }
        if (src.hasOperator()) {
            if (src.hasOperator())
                tgt.setOperator(VersionConvertor_30_40.convertReference(src.getOperator()));
        }
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReasonCode()) {
            tgt.addReasonCode(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasBodySite()) {
            if (src.hasBodySite())
                tgt.setBodySite(VersionConvertor_30_40.convertCodeableConcept(src.getBodySite()));
        }
        if (src.hasDevice()) {
            if (src.hasDevice())
                tgt.setDevice(VersionConvertor_30_40.convertReference(src.getDevice()));
        }
        if (src.hasHeight()) {
            if (src.hasHeightElement())
                tgt.setHeightElement(VersionConvertor_30_40.convertPositiveInt(src.getHeightElement()));
        }
        if (src.hasWidth()) {
            if (src.hasWidthElement())
                tgt.setWidthElement(VersionConvertor_30_40.convertPositiveInt(src.getWidthElement()));
        }
        if (src.hasFrames()) {
            if (src.hasFramesElement())
                tgt.setFramesElement(VersionConvertor_30_40.convertPositiveInt(src.getFramesElement()));
        }
        if (src.hasDuration()) {
            if (src.hasDuration())
                tgt.setDuration(src.getDuration());
        }
        if (src.hasContent()) {
            if (src.hasContent())
                tgt.setContent(VersionConvertor_30_40.convertAttachment(src.getContent()));
        }
        for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) {
            tgt.addNote(VersionConvertor_30_40.convertAnnotation(t));
        }
        tgt.setStatus(org.hl7.fhir.r4.model.Media.MediaStatus.COMPLETED);
        return tgt;
    }
}