package org.hl7.fhir.convertors.conv10_30.resources10_30;

import org.hl7.fhir.convertors.conv10_30.VersionConvertor_10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.CodeableConcept10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Identifier10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Period10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.String10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Reference10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Schedule10_30 {

    public static org.hl7.fhir.dstu2.model.Schedule convertSchedule(org.hl7.fhir.dstu3.model.Schedule src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Schedule tgt = new org.hl7.fhir.dstu2.model.Schedule();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier10_30.convertIdentifier(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getServiceType()) tgt.addType(CodeableConcept10_30.convertCodeableConcept(t));
        if (src.hasActor())
            tgt.setActor(Reference10_30.convertReference(src.getActorFirstRep()));
        if (src.hasPlanningHorizon())
            tgt.setPlanningHorizon(Period10_30.convertPeriod(src.getPlanningHorizon()));
        if (src.hasCommentElement())
            tgt.setCommentElement(String10_30.convertString(src.getCommentElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Schedule convertSchedule(org.hl7.fhir.dstu2.model.Schedule src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Schedule tgt = new org.hl7.fhir.dstu3.model.Schedule();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier10_30.convertIdentifier(t));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getType()) tgt.addServiceType(CodeableConcept10_30.convertCodeableConcept(t));
        if (src.hasActor())
            tgt.addActor(Reference10_30.convertReference(src.getActor()));
        if (src.hasPlanningHorizon())
            tgt.setPlanningHorizon(Period10_30.convertPeriod(src.getPlanningHorizon()));
        if (src.hasCommentElement())
            tgt.setCommentElement(String10_30.convertString(src.getCommentElement()));
        return tgt;
    }
}