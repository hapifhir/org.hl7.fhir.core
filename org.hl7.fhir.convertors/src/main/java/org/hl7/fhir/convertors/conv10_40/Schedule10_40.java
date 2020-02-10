package org.hl7.fhir.convertors.conv10_40;

import org.hl7.fhir.convertors.VersionConvertor_10_40;
import org.hl7.fhir.exceptions.FHIRException;
import java.util.Collections;

public class Schedule10_40 {

    public static org.hl7.fhir.r4.model.Schedule convertSchedule(org.hl7.fhir.dstu2.model.Schedule src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Schedule tgt = new org.hl7.fhir.r4.model.Schedule();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_40.convertIdentifier(t));
        }
        if (src.hasType()) {
            for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getType()) tgt.addServiceType(VersionConvertor_10_40.convertCodeableConcept(t));
        }
        if (src.hasActor()) {
            tgt.addActor(VersionConvertor_10_40.convertReference(src.getActor()));
        }
        if (src.hasPlanningHorizon()) {
            tgt.setPlanningHorizon(VersionConvertor_10_40.convertPeriod(src.getPlanningHorizon()));
        }
        if (src.hasCommentElement())
            tgt.setCommentElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_10_40.convertType(src.getCommentElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Schedule convertSchedule(org.hl7.fhir.r4.model.Schedule src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Schedule tgt = new org.hl7.fhir.dstu2.model.Schedule();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_40.convertIdentifier(t));
        }
        if (src.hasServiceType()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getServiceType()) tgt.addType(VersionConvertor_10_40.convertCodeableConcept(t));
        }
        if (src.hasActor()) {
            tgt.setActor(VersionConvertor_10_40.convertReference(src.getActorFirstRep()));
        }
        if (src.hasPlanningHorizon()) {
            tgt.setPlanningHorizon(VersionConvertor_10_40.convertPeriod(src.getPlanningHorizon()));
        }
        if (src.hasCommentElement())
            tgt.setCommentElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_40.convertType(src.getCommentElement()));
        return tgt;
    }
}
