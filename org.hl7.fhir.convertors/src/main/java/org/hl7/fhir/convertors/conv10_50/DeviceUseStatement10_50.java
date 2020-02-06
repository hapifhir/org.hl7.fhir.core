package org.hl7.fhir.convertors.conv10_50;

import org.hl7.fhir.convertors.VersionConvertor_10_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.Annotation;
import org.hl7.fhir.r5.model.CodeableReference;

public class DeviceUseStatement10_50 {

    public static org.hl7.fhir.r5.model.DeviceUseStatement convertDeviceUseStatement(org.hl7.fhir.dstu2.model.DeviceUseStatement src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.DeviceUseStatement tgt = new org.hl7.fhir.r5.model.DeviceUseStatement();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        if (src.hasBodySiteCodeableConcept())
            tgt.setBodySite(VersionConvertor_10_50.convertCodeableConcept(src.getBodySiteCodeableConcept()));
        if (src.hasDevice()) {
            tgt.setDevice(VersionConvertor_10_50.convertReference(src.getDevice()));
        }
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_50.convertIdentifier(t));
        }
        if (src.hasIndication()) {
            for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getIndication()) tgt.addReason(VersionConvertor_10_50.convertCodeableConceptToCodableReference(t));
        }
        if (src.hasNotes()) {
            for (org.hl7.fhir.dstu2.model.StringType t : src.getNotes()) tgt.addNote().setText(t.getValue());
        }
        if (src.hasRecordedOn()) {
            tgt.setRecordedOn(src.getRecordedOn());
        }
        if (src.hasSubject()) {
            tgt.setSubject(VersionConvertor_10_50.convertReference(src.getSubject()));
        }
        if (src.hasTiming()) {
            tgt.setTiming(VersionConvertor_10_50.convertType(src.getTiming()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.DeviceUseStatement convertDeviceUseStatement(org.hl7.fhir.r5.model.DeviceUseStatement src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.DeviceUseStatement tgt = new org.hl7.fhir.dstu2.model.DeviceUseStatement();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        if (src.hasBodySite()) {
            tgt.setBodySite(VersionConvertor_10_50.convertType(src.getBodySite()));
        }
        if (src.hasDevice()) {
            tgt.setDevice(VersionConvertor_10_50.convertReference(src.getDevice()));
        }
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_50.convertIdentifier(t));
        }
        for (CodeableReference t : src.getReason()) if (t.hasConcept())
            tgt.addIndication(VersionConvertor_10_50.convertCodeableConcept(t.getConcept()));
        if (src.hasNote()) {
            for (Annotation t : src.getNote()) tgt.addNotes(t.getText());
        }
        if (src.hasRecordedOn()) {
            tgt.setRecordedOn(src.getRecordedOn());
        }
        if (src.hasSubject()) {
            tgt.setSubject(VersionConvertor_10_50.convertReference(src.getSubject()));
        }
        if (src.hasTiming()) {
            tgt.setTiming(VersionConvertor_10_50.convertType(src.getTiming()));
        }
        return tgt;
    }
}
