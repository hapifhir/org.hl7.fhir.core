package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class DeviceUseStatement30_40 {

    public static org.hl7.fhir.r4.model.DeviceUseStatement convertDeviceUseStatement(org.hl7.fhir.dstu3.model.DeviceUseStatement src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.DeviceUseStatement tgt = new org.hl7.fhir.r4.model.DeviceUseStatement();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        }
        if (src.hasStatus())
            tgt.setStatus(convertDeviceUseStatementStatus(src.getStatus()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_40.convertReference(src.getSubject()));
        if (src.hasTiming())
            tgt.setTiming(VersionConvertor_30_40.convertType(src.getTiming()));
        if (src.hasRecordedOn())
            tgt.setRecordedOnElement(VersionConvertor_30_40.convertDateTime(src.getRecordedOnElement()));
        if (src.hasSource())
            tgt.setSource(VersionConvertor_30_40.convertReference(src.getSource()));
        if (src.hasDevice())
            tgt.setDevice(VersionConvertor_30_40.convertReference(src.getDevice()));
        if (src.hasIndication()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getIndication()) tgt.addReasonCode(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasBodySite())
            tgt.setBodySite(VersionConvertor_30_40.convertCodeableConcept(src.getBodySite()));
        if (src.hasNote()) {
            for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_40.convertAnnotation(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DeviceUseStatement convertDeviceUseStatement(org.hl7.fhir.r4.model.DeviceUseStatement src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.DeviceUseStatement tgt = new org.hl7.fhir.dstu3.model.DeviceUseStatement();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        }
        if (src.hasStatus())
            tgt.setStatus(convertDeviceUseStatementStatus(src.getStatus()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_40.convertReference(src.getSubject()));
        if (src.hasTiming())
            tgt.setTiming(VersionConvertor_30_40.convertType(src.getTiming()));
        if (src.hasRecordedOn())
            tgt.setRecordedOnElement(VersionConvertor_30_40.convertDateTime(src.getRecordedOnElement()));
        if (src.hasSource())
            tgt.setSource(VersionConvertor_30_40.convertReference(src.getSource()));
        if (src.hasDevice())
            tgt.setDevice(VersionConvertor_30_40.convertReference(src.getDevice()));
        if (src.hasReasonCode()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode()) tgt.addIndication(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasBodySite())
            tgt.setBodySite(VersionConvertor_30_40.convertCodeableConcept(src.getBodySite()));
        if (src.hasNote()) {
            for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_40.convertAnnotation(t));
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.DeviceUseStatement.DeviceUseStatementStatus convertDeviceUseStatementStatus(org.hl7.fhir.dstu3.model.DeviceUseStatement.DeviceUseStatementStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ACTIVE:
                return org.hl7.fhir.r4.model.DeviceUseStatement.DeviceUseStatementStatus.ACTIVE;
            case COMPLETED:
                return org.hl7.fhir.r4.model.DeviceUseStatement.DeviceUseStatementStatus.COMPLETED;
            case ENTEREDINERROR:
                return org.hl7.fhir.r4.model.DeviceUseStatement.DeviceUseStatementStatus.ENTEREDINERROR;
            case INTENDED:
                return org.hl7.fhir.r4.model.DeviceUseStatement.DeviceUseStatementStatus.INTENDED;
            case STOPPED:
                return org.hl7.fhir.r4.model.DeviceUseStatement.DeviceUseStatementStatus.STOPPED;
            case ONHOLD:
                return org.hl7.fhir.r4.model.DeviceUseStatement.DeviceUseStatementStatus.ONHOLD;
            default:
                return org.hl7.fhir.r4.model.DeviceUseStatement.DeviceUseStatementStatus.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.DeviceUseStatement.DeviceUseStatementStatus convertDeviceUseStatementStatus(org.hl7.fhir.r4.model.DeviceUseStatement.DeviceUseStatementStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ACTIVE:
                return org.hl7.fhir.dstu3.model.DeviceUseStatement.DeviceUseStatementStatus.ACTIVE;
            case COMPLETED:
                return org.hl7.fhir.dstu3.model.DeviceUseStatement.DeviceUseStatementStatus.COMPLETED;
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu3.model.DeviceUseStatement.DeviceUseStatementStatus.ENTEREDINERROR;
            case INTENDED:
                return org.hl7.fhir.dstu3.model.DeviceUseStatement.DeviceUseStatementStatus.INTENDED;
            case STOPPED:
                return org.hl7.fhir.dstu3.model.DeviceUseStatement.DeviceUseStatementStatus.STOPPED;
            case ONHOLD:
                return org.hl7.fhir.dstu3.model.DeviceUseStatement.DeviceUseStatementStatus.ONHOLD;
            default:
                return org.hl7.fhir.dstu3.model.DeviceUseStatement.DeviceUseStatementStatus.NULL;
        }
    }
}
