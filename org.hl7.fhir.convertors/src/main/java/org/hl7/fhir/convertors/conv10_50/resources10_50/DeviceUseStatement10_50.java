package org.hl7.fhir.convertors.conv10_50.resources10_50;

import org.hl7.fhir.convertors.conv10_50.VersionConvertor_10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.Type10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.CodeableConcept10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Identifier10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.DateTime10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.Reference10_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.Annotation;
import org.hl7.fhir.r5.model.CodeableReference;

public class DeviceUseStatement10_50 {

    public static org.hl7.fhir.r5.model.DeviceUsage convertDeviceUseStatement(org.hl7.fhir.dstu2.model.DeviceUseStatement src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.DeviceUsage tgt = new org.hl7.fhir.r5.model.DeviceUsage();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        if (src.hasBodySiteCodeableConcept())
            tgt.getBodySite().setConcept(CodeableConcept10_50.convertCodeableConcept(src.getBodySiteCodeableConcept()));
        if (src.hasDevice())
            tgt.getDevice().setReference(Reference10_50.convertReference(src.getDevice()));
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier10_50.convertIdentifier(t));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getIndication()) tgt.addReason(CodeableConcept10_50.convertCodeableConceptToCodableReference(t));
        for (org.hl7.fhir.dstu2.model.StringType t : src.getNotes()) tgt.addNote().setText(t.getValue());
        if (src.hasRecordedOnElement())
            tgt.setDateAssertedElement(DateTime10_50.convertDateTime(src.getRecordedOnElement()));
        if (src.hasSubject())
            tgt.setSubject(Reference10_50.convertReference(src.getSubject()));
        if (src.hasTiming())
            tgt.setTiming(Type10_50.convertType(src.getTiming()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.DeviceUseStatement convertDeviceUseStatement(org.hl7.fhir.r5.model.DeviceUsage src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.DeviceUseStatement tgt = new org.hl7.fhir.dstu2.model.DeviceUseStatement();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        if (src.getBodySite().hasConcept())
            tgt.setBodySite(Type10_50.convertType(src.getBodySite().getConcept()));
        if (src.getDevice().hasReference())
            tgt.setDevice(Reference10_50.convertReference(src.getDevice().getReference()));
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier10_50.convertIdentifier(t));
        for (CodeableReference t : src.getReason()) if (t.hasConcept())
            tgt.addIndication(CodeableConcept10_50.convertCodeableConcept(t.getConcept()));
        for (Annotation t : src.getNote()) tgt.addNotes(t.getText());
        if (src.hasDateAssertedElement())
            tgt.setRecordedOnElement(DateTime10_50.convertDateTime(src.getDateAssertedElement()));
        if (src.hasSubject())
            tgt.setSubject(Reference10_50.convertReference(src.getSubject()));
        if (src.hasTiming())
            tgt.setTiming(Type10_50.convertType(src.getTiming()));
        return tgt;
    }
}