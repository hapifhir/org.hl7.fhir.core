package org.hl7.fhir.convertors.conv30_40.resources30_40;

import org.hl7.fhir.convertors.conv30_40.VersionConvertor_30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Attachment30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Identifier30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Boolean30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.String30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Reference30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class BodySite30_40 {

    public static org.hl7.fhir.dstu3.model.BodySite convertBodySite(org.hl7.fhir.r4.model.BodyStructure src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.BodySite tgt = new org.hl7.fhir.dstu3.model.BodySite();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
        if (src.hasActive())
            tgt.setActiveElement(Boolean30_40.convertBoolean(src.getActiveElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(String30_40.convertString(src.getDescriptionElement()));
        for (org.hl7.fhir.r4.model.Attachment t : src.getImage()) tgt.addImage(Attachment30_40.convertAttachment(t));
        if (src.hasPatient())
            tgt.setPatient(Reference30_40.convertReference(src.getPatient()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.BodyStructure convertBodySite(org.hl7.fhir.dstu3.model.BodySite src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.BodyStructure tgt = new org.hl7.fhir.r4.model.BodyStructure();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
        if (src.hasActive())
            tgt.setActiveElement(Boolean30_40.convertBoolean(src.getActiveElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(String30_40.convertString(src.getDescriptionElement()));
        for (org.hl7.fhir.dstu3.model.Attachment t : src.getImage()) tgt.addImage(Attachment30_40.convertAttachment(t));
        if (src.hasPatient())
            tgt.setPatient(Reference30_40.convertReference(src.getPatient()));
        return tgt;
    }
}