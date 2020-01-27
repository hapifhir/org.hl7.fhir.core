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
        tgt.setSchedule(VersionConvertor_10_50.convertReference(src.getSchedule()));
        tgt.setStart(src.getStart());
        tgt.setEnd(src.getEnd());
        tgt.setOverbooked(src.getOverbooked());
        tgt.setComment(src.getComment());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Slot convertSlot(org.hl7.fhir.r5.model.Slot src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Slot tgt = new org.hl7.fhir.dstu2.model.Slot();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_50.convertIdentifier(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getServiceType()) tgt.setType(VersionConvertor_10_50.convertCodeableConcept(t));
        tgt.setSchedule(VersionConvertor_10_50.convertReference(src.getSchedule()));
        tgt.setStart(src.getStart());
        tgt.setEnd(src.getEnd());
        tgt.setOverbooked(src.getOverbooked());
        tgt.setComment(src.getComment());
        return tgt;
    }
}
