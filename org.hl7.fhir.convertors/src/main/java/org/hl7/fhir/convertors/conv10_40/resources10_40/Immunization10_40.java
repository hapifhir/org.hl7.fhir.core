package org.hl7.fhir.convertors.conv10_40.resources10_40;

import org.hl7.fhir.convertors.context.ConversionContext10_40;
import org.hl7.fhir.convertors.conv10_40.VersionConvertor_10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Reference10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Annotation10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.CodeableConcept10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Identifier10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Quantity10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.Boolean10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.DateTime10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.PositiveInt10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.String10_40;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.Coding;

public class Immunization10_40 {

    public static String CODESYSTEM_PERFORMER_FUNCTION = "http://terminology.hl7.org/CodeSystem/v2-0443";

    public static org.hl7.fhir.r4.model.Immunization convertImmunization(org.hl7.fhir.dstu2.model.Immunization src)
            throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Immunization tgt = new org.hl7.fhir.r4.model.Immunization();
        ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) {
            tgt.addIdentifier(Identifier10_40.convertIdentifier(t));
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
            tgt.setVaccineCode(CodeableConcept10_40.convertCodeableConcept(src.getVaccineCode()));
        }
        if (src.hasPatient())
            tgt.setPatient(Reference10_40.convertReference(src.getPatient()));
        if (src.hasManufacturer())
            tgt.setManufacturer(Reference10_40.convertReference(src.getManufacturer()));
        if (src.hasEncounter())
            tgt.setEncounter(Reference10_40.convertReference(src.getEncounter()));
        if (src.hasLocation())
            tgt.setLocation(Reference10_40.convertReference(src.getLocation()));
        if (src.hasLotNumber())
            tgt.setLotNumber(src.getLotNumber());
        if (src.hasExpirationDate())
            tgt.setExpirationDate(src.getExpirationDate());
        if (src.hasSite())
            tgt.setSite(CodeableConcept10_40.convertCodeableConcept(src.getSite()));
        if (src.hasRoute())
            tgt.setRoute(CodeableConcept10_40.convertCodeableConcept(src.getRoute()));
        if (src.hasDoseQuantity())
            tgt.setDoseQuantity(Quantity10_40.convertQuantity(src.getDoseQuantity()));

        if (src.hasPerformer()) {
            tgt.addPerformer().setActor(Reference10_40.convertReference(src.getPerformer()))
                    .setFunction(new org.hl7.fhir.r4.model.CodeableConcept()
                            .addCoding(new Coding().setSystem(CODESYSTEM_PERFORMER_FUNCTION).setCode("AP")));
        }
        if (src.hasRequester()) {
            tgt.addPerformer().setActor(Reference10_40.convertReference(src.getRequester()))
                    .setFunction(new org.hl7.fhir.r4.model.CodeableConcept()
                            .addCoding(new Coding().setSystem(CODESYSTEM_PERFORMER_FUNCTION).setCode("OP")));
        }
        for (org.hl7.fhir.dstu2.model.Annotation t : src.getNote()) tgt.addNote(Annotation10_40.convertAnnotation(t));
        if(src.hasExplanation()) {
            if(src.getExplanation().hasReason()) {
              for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getExplanation().getReason()) tgt.addReasonCode(CodeableConcept10_40.convertCodeableConcept(t));
            }
            if(src.getExplanation().hasReasonNotGiven()) {
              for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getExplanation().getReasonNotGiven()) tgt.addReasonCode(CodeableConcept10_40.convertCodeableConcept(t));
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
        ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
        if (src.hasDate())
            tgt.setDateElement(DateTime10_40.convertDateTime(src.getDateElement()));
        if (src.hasDetail())
            tgt.setDetail(Reference10_40.convertReference(src.getDetail()));
        if (src.hasReportedElement())
            tgt.setReportedElement(Boolean10_40.convertBoolean(src.getReportedElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Immunization.ImmunizationProtocolAppliedComponent convertImmunizationVaccinationProtocolComponent(
          org.hl7.fhir.dstu2.model.Immunization.ImmunizationVaccinationProtocolComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Immunization.ImmunizationProtocolAppliedComponent tgt = new org.hl7.fhir.r4.model.Immunization.ImmunizationProtocolAppliedComponent();
        ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
        if (src.hasAuthority())
            tgt.setAuthority(Reference10_40.convertReference(src.getAuthority()));
        if (src.hasSeriesElement())
            tgt.setSeriesElement(String10_40.convertString(src.getSeriesElement()));
        if (src.hasSeriesDosesElement())
            tgt.setSeriesDoses(PositiveInt10_40.convertPositiveInt(src.getSeriesDosesElement()));
        if (src.hasDoseSequenceElement())
            tgt.setDoseNumber(PositiveInt10_40.convertPositiveInt(src.getDoseSequenceElement()));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getTargetDisease()) tgt.addTargetDisease(CodeableConcept10_40.convertCodeableConcept(t));
        return tgt;
    }

}