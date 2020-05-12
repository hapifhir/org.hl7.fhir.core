package org.hl7.fhir.convertors.conv10_40;

import org.hl7.fhir.convertors.VersionConvertor_10_40;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.Annotation;

public class DeviceUseStatement10_40 {

    public static org.hl7.fhir.dstu2.model.DeviceUseStatement convertDeviceUseStatement(org.hl7.fhir.r4.model.DeviceUseStatement src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.DeviceUseStatement tgt = new org.hl7.fhir.dstu2.model.DeviceUseStatement();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        if (src.hasBodySite())
            tgt.setBodySite(VersionConvertor_10_40.convertType(src.getBodySite()));
        if (src.hasDevice())
            tgt.setDevice(VersionConvertor_10_40.convertReference(src.getDevice()));
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_40.convertIdentifier(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode()) tgt.addIndication(VersionConvertor_10_40.convertCodeableConcept(t));
        for (Annotation t : src.getNote()) tgt.addNotes(t.getText());
        if (src.hasRecordedOnElement())
            tgt.setRecordedOnElement(VersionConvertor_10_40.convertDateTime(src.getRecordedOnElement()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_10_40.convertReference(src.getSubject()));
        if (src.hasTiming())
            tgt.setTiming(VersionConvertor_10_40.convertType(src.getTiming()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.DeviceUseStatement convertDeviceUseStatement(org.hl7.fhir.dstu2.model.DeviceUseStatement src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.DeviceUseStatement tgt = new org.hl7.fhir.r4.model.DeviceUseStatement();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        if (src.hasBodySiteCodeableConcept())
            tgt.setBodySite(VersionConvertor_10_40.convertCodeableConcept(src.getBodySiteCodeableConcept()));
        if (src.hasDevice())
            tgt.setDevice(VersionConvertor_10_40.convertReference(src.getDevice()));
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_40.convertIdentifier(t));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getIndication()) tgt.addReasonCode(VersionConvertor_10_40.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu2.model.StringType t : src.getNotes()) tgt.addNote().setText(t.getValue());
        if (src.hasRecordedOnElement())
            tgt.setRecordedOnElement(VersionConvertor_10_40.convertDateTime(src.getRecordedOnElement()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_10_40.convertReference(src.getSubject()));
        if (src.hasTiming())
            tgt.setTiming(VersionConvertor_10_40.convertType(src.getTiming()));
        return tgt;
    }
}