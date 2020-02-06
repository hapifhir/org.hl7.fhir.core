package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Slot10_30 {

    public static org.hl7.fhir.dstu3.model.Slot convertSlot(org.hl7.fhir.dstu2.model.Slot src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Slot tgt = new org.hl7.fhir.dstu3.model.Slot();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        }
        if (src.hasType())
            tgt.addServiceType(VersionConvertor_10_30.convertCodeableConcept(src.getType()));
        if (src.hasSchedule()) {
            tgt.setSchedule(VersionConvertor_10_30.convertReference(src.getSchedule()));
        }
        if (src.hasStart()) {
            tgt.setStart(src.getStart());
        }
        if (src.hasEnd()) {
            tgt.setEnd(src.getEnd());
        }
        if (src.hasOverbooked()) {
            tgt.setOverbooked(src.getOverbooked());
        }
        if (src.hasComment()) {
            tgt.setComment(src.getComment());
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Slot convertSlot(org.hl7.fhir.dstu3.model.Slot src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Slot tgt = new org.hl7.fhir.dstu2.model.Slot();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        }
        if (src.hasServiceType()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getServiceType()) tgt.setType(VersionConvertor_10_30.convertCodeableConcept(t));
        }
        if (src.hasSchedule()) {
            tgt.setSchedule(VersionConvertor_10_30.convertReference(src.getSchedule()));
        }
        if (src.hasStart()) {
            tgt.setStart(src.getStart());
        }
        if (src.hasEnd()) {
            tgt.setEnd(src.getEnd());
        }
        if (src.hasOverbooked()) {
            tgt.setOverbooked(src.getOverbooked());
        }
        if (src.hasComment()) {
            tgt.setComment(src.getComment());
        }
        return tgt;
    }
}
