package org.hl7.fhir.convertors.conv10_50;

import org.hl7.fhir.convertors.VersionConvertor_10_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Schedule10_50 {

    public static org.hl7.fhir.dstu2.model.Schedule convertSchedule(org.hl7.fhir.r5.model.Schedule src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Schedule tgt = new org.hl7.fhir.dstu2.model.Schedule();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_50.convertIdentifier(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getServiceType()) tgt.addType(VersionConvertor_10_50.convertCodeableConcept(t));
        tgt.setActor(VersionConvertor_10_50.convertReference(src.getActorFirstRep()));
        tgt.setPlanningHorizon(VersionConvertor_10_50.convertPeriod(src.getPlanningHorizon()));
        tgt.setComment(src.getComment());
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Schedule convertSchedule(org.hl7.fhir.dstu2.model.Schedule src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Schedule tgt = new org.hl7.fhir.r5.model.Schedule();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_50.convertIdentifier(t));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getType()) tgt.addServiceType(VersionConvertor_10_50.convertCodeableConcept(t));
        tgt.addActor(VersionConvertor_10_50.convertReference(src.getActor()));
        tgt.setPlanningHorizon(VersionConvertor_10_50.convertPeriod(src.getPlanningHorizon()));
        tgt.setComment(src.getComment());
        return tgt;
    }
}
