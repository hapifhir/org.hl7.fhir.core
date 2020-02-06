package org.hl7.fhir.convertors.conv10_40;

import org.hl7.fhir.convertors.VersionConvertor_10_40;
import org.hl7.fhir.exceptions.FHIRException;
import java.util.Collections;

public class Slot10_40 {

    public static org.hl7.fhir.r4.model.Slot convertSlot(org.hl7.fhir.dstu2.model.Slot src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Slot tgt = new org.hl7.fhir.r4.model.Slot();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_40.convertIdentifier(t));
        }
        if (src.hasType())
            tgt.addServiceType(VersionConvertor_10_40.convertCodeableConcept(src.getType()));
        if (src.hasSchedule()) {
            tgt.setSchedule(VersionConvertor_10_40.convertReference(src.getSchedule()));
        }
        if (src.hasStartElement())
            tgt.setStartElement((org.hl7.fhir.r4.model.InstantType) VersionConvertor_10_40.convertType(src.getStartElement()));
        if (src.hasEndElement())
            tgt.setEndElement((org.hl7.fhir.r4.model.InstantType) VersionConvertor_10_40.convertType(src.getEndElement()));
        if (src.hasOverbookedElement())
            tgt.setOverbookedElement((org.hl7.fhir.r4.model.BooleanType) VersionConvertor_10_40.convertType(src.getOverbookedElement()));
        if (src.hasCommentElement())
            tgt.setCommentElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_10_40.convertType(src.getCommentElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Slot convertSlot(org.hl7.fhir.r4.model.Slot src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Slot tgt = new org.hl7.fhir.dstu2.model.Slot();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_40.convertIdentifier(t));
        }
        if (src.hasServiceType()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getServiceType()) tgt.setType(VersionConvertor_10_40.convertCodeableConcept(t));
        }
        if (src.hasSchedule()) {
            tgt.setSchedule(VersionConvertor_10_40.convertReference(src.getSchedule()));
        }
        if (src.hasStartElement())
            tgt.setStartElement((org.hl7.fhir.dstu2.model.InstantType) VersionConvertor_10_40.convertType(src.getStartElement()));
        if (src.hasEndElement())
            tgt.setEndElement((org.hl7.fhir.dstu2.model.InstantType) VersionConvertor_10_40.convertType(src.getEndElement()));
        if (src.hasOverbookedElement())
            tgt.setOverbookedElement((org.hl7.fhir.dstu2.model.BooleanType) VersionConvertor_10_40.convertType(src.getOverbookedElement()));
        if (src.hasCommentElement())
            tgt.setCommentElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_40.convertType(src.getCommentElement()));
        return tgt;
    }
}
