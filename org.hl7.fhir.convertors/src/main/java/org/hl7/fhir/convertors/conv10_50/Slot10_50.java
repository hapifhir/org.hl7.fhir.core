package org.hl7.fhir.convertors.conv10_50;

import org.hl7.fhir.convertors.VersionConvertor_10_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Slot10_50 {

    public static org.hl7.fhir.r5.model.Slot convertSlot(org.hl7.fhir.dstu2.model.Slot src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Slot tgt = new org.hl7.fhir.r5.model.Slot();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_50.convertIdentifier(t));
        if (src.hasType())
            tgt.addServiceType(VersionConvertor_10_50.convertCodeableConcept(src.getType()));
        if (src.hasSchedule())
            tgt.setSchedule(VersionConvertor_10_50.convertReference(src.getSchedule()));
        if (src.hasStartElement())
            tgt.setStartElement(VersionConvertor_10_50.convertInstant(src.getStartElement()));
        if (src.hasEndElement())
            tgt.setEndElement(VersionConvertor_10_50.convertInstant(src.getEndElement()));
        if (src.hasOverbookedElement())
            tgt.setOverbookedElement(VersionConvertor_10_50.convertBoolean(src.getOverbookedElement()));
        if (src.hasCommentElement())
            tgt.setCommentElement(VersionConvertor_10_50.convertString(src.getCommentElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Slot convertSlot(org.hl7.fhir.r5.model.Slot src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Slot tgt = new org.hl7.fhir.dstu2.model.Slot();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_50.convertIdentifier(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getServiceType()) tgt.setType(VersionConvertor_10_50.convertCodeableConcept(t));
        if (src.hasSchedule())
            tgt.setSchedule(VersionConvertor_10_50.convertReference(src.getSchedule()));
        if (src.hasStartElement())
            tgt.setStartElement(VersionConvertor_10_50.convertInstant(src.getStartElement()));
        if (src.hasEndElement())
            tgt.setEndElement(VersionConvertor_10_50.convertInstant(src.getEndElement()));
        if (src.hasOverbookedElement())
            tgt.setOverbookedElement(VersionConvertor_10_50.convertBoolean(src.getOverbookedElement()));
        if (src.hasCommentElement())
            tgt.setCommentElement(VersionConvertor_10_50.convertString(src.getCommentElement()));
        return tgt;
    }
}