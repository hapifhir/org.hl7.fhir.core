package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Schedule30_50 {

    public static org.hl7.fhir.dstu3.model.Schedule convertSchedule(org.hl7.fhir.r5.model.Schedule src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Schedule tgt = new org.hl7.fhir.dstu3.model.Schedule();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        }
        if (src.hasActive())
            tgt.setActive(src.getActive());
        if (src.hasServiceCategory())
            tgt.setServiceCategory(VersionConvertor_30_50.convertCodeableConcept(src.getServiceCategoryFirstRep()));
        if (src.hasServiceType()) {
            for (org.hl7.fhir.r5.model.CodeableConcept t : src.getServiceType()) tgt.addServiceType(VersionConvertor_30_50.convertCodeableConcept(t));
        }
        if (src.hasSpecialty()) {
            for (org.hl7.fhir.r5.model.CodeableConcept t : src.getSpecialty()) tgt.addSpecialty(VersionConvertor_30_50.convertCodeableConcept(t));
        }
        if (src.hasActor()) {
            for (org.hl7.fhir.r5.model.Reference t : src.getActor()) tgt.addActor(VersionConvertor_30_50.convertReference(t));
        }
        if (src.hasPlanningHorizon())
            tgt.setPlanningHorizon(VersionConvertor_30_50.convertPeriod(src.getPlanningHorizon()));
        if (src.hasComment())
            tgt.setComment(src.getComment());
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Schedule convertSchedule(org.hl7.fhir.dstu3.model.Schedule src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Schedule tgt = new org.hl7.fhir.r5.model.Schedule();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        }
        if (src.hasActive())
            tgt.setActive(src.getActive());
        if (src.hasServiceCategory())
            tgt.addServiceCategory(VersionConvertor_30_50.convertCodeableConcept(src.getServiceCategory()));
        if (src.hasServiceType()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getServiceType()) tgt.addServiceType(VersionConvertor_30_50.convertCodeableConcept(t));
        }
        if (src.hasSpecialty()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getSpecialty()) tgt.addSpecialty(VersionConvertor_30_50.convertCodeableConcept(t));
        }
        if (src.hasActor()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getActor()) tgt.addActor(VersionConvertor_30_50.convertReference(t));
        }
        if (src.hasPlanningHorizon())
            tgt.setPlanningHorizon(VersionConvertor_30_50.convertPeriod(src.getPlanningHorizon()));
        if (src.hasComment())
            tgt.setComment(src.getComment());
        return tgt;
    }
}
