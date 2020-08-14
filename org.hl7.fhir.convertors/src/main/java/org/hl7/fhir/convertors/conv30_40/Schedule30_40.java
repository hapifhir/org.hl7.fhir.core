package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Schedule30_40 {

    public static org.hl7.fhir.dstu3.model.Schedule convertSchedule(org.hl7.fhir.r4.model.Schedule src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Schedule tgt = new org.hl7.fhir.dstu3.model.Schedule();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        if (src.hasActive())
            tgt.setActiveElement(VersionConvertor_30_40.convertBoolean(src.getActiveElement()));
        if (src.hasServiceCategory())
            tgt.setServiceCategory(VersionConvertor_30_40.convertCodeableConcept(src.getServiceCategoryFirstRep()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getServiceType()) tgt.addServiceType(VersionConvertor_30_40.convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSpecialty()) tgt.addSpecialty(VersionConvertor_30_40.convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getActor()) tgt.addActor(VersionConvertor_30_40.convertReference(t));
        if (src.hasPlanningHorizon())
            tgt.setPlanningHorizon(VersionConvertor_30_40.convertPeriod(src.getPlanningHorizon()));
        if (src.hasComment())
            tgt.setCommentElement(VersionConvertor_30_40.convertString(src.getCommentElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Schedule convertSchedule(org.hl7.fhir.dstu3.model.Schedule src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Schedule tgt = new org.hl7.fhir.r4.model.Schedule();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        if (src.hasActive())
            tgt.setActiveElement(VersionConvertor_30_40.convertBoolean(src.getActiveElement()));
        if (src.hasServiceCategory())
            tgt.addServiceCategory(VersionConvertor_30_40.convertCodeableConcept(src.getServiceCategory()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getServiceType()) tgt.addServiceType(VersionConvertor_30_40.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getSpecialty()) tgt.addSpecialty(VersionConvertor_30_40.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getActor()) tgt.addActor(VersionConvertor_30_40.convertReference(t));
        if (src.hasPlanningHorizon())
            tgt.setPlanningHorizon(VersionConvertor_30_40.convertPeriod(src.getPlanningHorizon()));
        if (src.hasComment())
            tgt.setCommentElement(VersionConvertor_30_40.convertString(src.getCommentElement()));
        return tgt;
    }
}