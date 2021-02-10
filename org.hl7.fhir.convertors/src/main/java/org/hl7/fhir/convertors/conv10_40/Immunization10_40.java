package org.hl7.fhir.convertors.conv10_40;

import org.hl7.fhir.convertors.VersionConvertor_10_40;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.Coding;

public class Immunization10_40 {

    public static String CODESYSTEM_PERFORMER_FUNCTION = "http://terminology.hl7.org/CodeSystem/v2-0443";

    public static org.hl7.fhir.r4.model.Immunization convertImmunization(org.hl7.fhir.dstu2.model.Immunization src)
            throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Immunization tgt = new org.hl7.fhir.r4.model.Immunization();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) {
            tgt.addIdentifier(VersionConvertor_10_40.convertIdentifier(t));
        }
        if (src.hasStatus()) {
            tgt.setStatus(org.hl7.fhir.r4.model.Immunization.ImmunizationStatus.fromCode(src.getStatus()));
        }
        if (src.hasDate()) {
            org.hl7.fhir.r4.model.DateTimeType retVal = new org.hl7.fhir.r4.model.DateTimeType();
            retVal.setValue(src.getDate());
            tgt.setOccurrence(retVal);
        }
        if (src.hasVaccineCode()) {
            tgt.setVaccineCode(VersionConvertor_10_40.convertCodeableConcept(src.getVaccineCode()));
        }
        if (src.hasPatient())
            tgt.setPatient(VersionConvertor_10_40.convertReference(src.getPatient()));
        if (src.hasManufacturer())
            tgt.setManufacturer(VersionConvertor_10_40.convertReference(src.getManufacturer()));
        if (src.hasEncounter())
            tgt.setEncounter(VersionConvertor_10_40.convertReference(src.getEncounter()));
        if (src.hasLocation())
            tgt.setLocation(VersionConvertor_10_40.convertReference(src.getLocation()));
        if (src.hasLotNumber())
            tgt.setLotNumber(src.getLotNumber());
        if (src.hasExpirationDate())
            tgt.setExpirationDate(src.getExpirationDate());
        if (src.hasSite())
            tgt.setSite(VersionConvertor_10_40.convertCodeableConcept(src.getSite()));
        if (src.hasRoute())
            tgt.setRoute(VersionConvertor_10_40.convertCodeableConcept(src.getRoute()));
        if (src.hasDoseQuantity())
            tgt.setDoseQuantity(VersionConvertor_10_40.convertQuantity(src.getDoseQuantity()));

        if (src.hasPerformer()) {
            tgt.addPerformer().setActor(VersionConvertor_10_40.convertReference(src.getPerformer()))
                    .setFunction(new org.hl7.fhir.r4.model.CodeableConcept()
                            .addCoding(new Coding().setSystem(CODESYSTEM_PERFORMER_FUNCTION).setCode("AP")));
        }
        if (src.hasRequester()) {
            tgt.addPerformer().setActor(VersionConvertor_10_40.convertReference(src.getRequester()))
                    .setFunction(new org.hl7.fhir.r4.model.CodeableConcept()
                            .addCoding(new Coding().setSystem(CODESYSTEM_PERFORMER_FUNCTION).setCode("OP")));
        }
        for (org.hl7.fhir.dstu2.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_10_40.convertAnnotation(t));
        if(src.hasExplanation()) {
            if(src.getExplanation().hasReason()) {
              for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getExplanation().getReason()) tgt.addReasonCode(VersionConvertor_10_40.convertCodeableConcept(t));
            }
            if(src.getExplanation().hasReasonNotGiven()) {
              for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getExplanation().getReasonNotGiven()) tgt.addReasonCode(VersionConvertor_10_40.convertCodeableConcept(t));
            }
        }
        for (org.hl7.fhir.dstu2.model.Immunization.ImmunizationReactionComponent t : src.getReaction()) tgt.addReaction(convertImmunizationReactionComponent(t));
        for (org.hl7.fhir.dstu2.model.Immunization.ImmunizationVaccinationProtocolComponent t : src.getVaccinationProtocol()) tgt.addProtocolApplied(convertImmunizationVaccinationProtocolComponent(t));

        return tgt;
    }
    
    public static org.hl7.fhir.r4.model.Immunization.ImmunizationReactionComponent convertImmunizationReactionComponent(
          org.hl7.fhir.dstu2.model.Immunization.ImmunizationReactionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Immunization.ImmunizationReactionComponent tgt = new org.hl7.fhir.r4.model.Immunization.ImmunizationReactionComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_10_40.convertDateTime(src.getDateElement()));
        if (src.hasDetail())
            tgt.setDetail(VersionConvertor_10_40.convertReference(src.getDetail()));
        if (src.hasReportedElement())
            tgt.setReportedElement(VersionConvertor_10_40.convertBoolean(src.getReportedElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Immunization.ImmunizationProtocolAppliedComponent convertImmunizationVaccinationProtocolComponent(
          org.hl7.fhir.dstu2.model.Immunization.ImmunizationVaccinationProtocolComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Immunization.ImmunizationProtocolAppliedComponent tgt = new org.hl7.fhir.r4.model.Immunization.ImmunizationProtocolAppliedComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasAuthority())
            tgt.setAuthority(VersionConvertor_10_40.convertReference(src.getAuthority()));
        if (src.hasSeriesElement())
            tgt.setSeriesElement(VersionConvertor_10_40.convertString(src.getSeriesElement()));
        if (src.hasSeriesDosesElement())
            tgt.setSeriesDoses(VersionConvertor_10_40.convertPositiveInt(src.getSeriesDosesElement()));
        if (src.hasDoseSequenceElement())
            tgt.setDoseNumber(VersionConvertor_10_40.convertPositiveInt(src.getDoseSequenceElement()));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getTargetDisease()) tgt.addTargetDisease(VersionConvertor_10_40.convertCodeableConcept(t));
        return tgt;
    }

}