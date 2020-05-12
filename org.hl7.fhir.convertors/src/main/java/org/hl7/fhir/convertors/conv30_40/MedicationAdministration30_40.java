package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.convertors.VersionConvertor_40_50;
import org.hl7.fhir.exceptions.FHIRException;

public class MedicationAdministration30_40 {

    public static org.hl7.fhir.dstu3.model.MedicationAdministration convertMedicationAdministration(org.hl7.fhir.r4.model.MedicationAdministration src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.MedicationAdministration tgt = new org.hl7.fhir.dstu3.model.MedicationAdministration();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        for (org.hl7.fhir.r4.model.UriType t : src.getInstantiates()) tgt.addDefinition().setReference(t.getValue());
        for (org.hl7.fhir.r4.model.Reference t : src.getPartOf()) tgt.addPartOf(VersionConvertor_30_40.convertReference(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertMedicationAdministrationStatus(src.getStatusElement()));
        if (src.hasCategory())
            tgt.setCategory(VersionConvertor_30_40.convertCodeableConcept(src.getCategory()));
        if (src.hasMedication())
            tgt.setMedication(VersionConvertor_30_40.convertType(src.getMedication()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_40.convertReference(src.getSubject()));
        if (src.hasContext())
            tgt.setContext(VersionConvertor_30_40.convertReference(src.getContext()));
        for (org.hl7.fhir.r4.model.Reference t : src.getSupportingInformation()) tgt.addSupportingInformation(VersionConvertor_30_40.convertReference(t));
        if (src.hasEffective())
            tgt.setEffective(VersionConvertor_30_40.convertType(src.getEffective()));
        for (org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationPerformerComponent t : src.getPerformer()) tgt.addPerformer(convertMedicationAdministrationPerformerComponent(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode()) tgt.addReasonCode(VersionConvertor_30_40.convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference()) tgt.addReasonReference(VersionConvertor_30_40.convertReference(t));
        if (src.hasRequest())
            tgt.setPrescription(VersionConvertor_30_40.convertReference(src.getRequest()));
        for (org.hl7.fhir.r4.model.Reference t : src.getDevice()) tgt.addDevice(VersionConvertor_30_40.convertReference(t));
        for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_40.convertAnnotation(t));
        if (src.hasDosage())
            tgt.setDosage(convertMedicationAdministrationDosageComponent(src.getDosage()));
        for (org.hl7.fhir.r4.model.Reference t : src.getEventHistory()) tgt.addEventHistory(VersionConvertor_30_40.convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MedicationAdministration convertMedicationAdministration(org.hl7.fhir.dstu3.model.MedicationAdministration src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MedicationAdministration tgt = new org.hl7.fhir.r4.model.MedicationAdministration();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getDefinition()) tgt.addInstantiates(t.getReference());
        for (org.hl7.fhir.dstu3.model.Reference t : src.getPartOf()) tgt.addPartOf(VersionConvertor_30_40.convertReference(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertMedicationAdministrationStatus(src.getStatusElement()));
        if (src.hasCategory())
            tgt.setCategory(VersionConvertor_30_40.convertCodeableConcept(src.getCategory()));
        if (src.hasMedication())
            tgt.setMedication(VersionConvertor_30_40.convertType(src.getMedication()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_40.convertReference(src.getSubject()));
        if (src.hasContext())
            tgt.setContext(VersionConvertor_30_40.convertReference(src.getContext()));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getSupportingInformation()) tgt.addSupportingInformation(VersionConvertor_30_40.convertReference(t));
        if (src.hasEffective())
            tgt.setEffective(VersionConvertor_30_40.convertType(src.getEffective()));
        for (org.hl7.fhir.dstu3.model.MedicationAdministration.MedicationAdministrationPerformerComponent t : src.getPerformer()) tgt.addPerformer(convertMedicationAdministrationPerformerComponent(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReasonCode()) tgt.addReasonCode(VersionConvertor_30_40.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getReasonReference()) tgt.addReasonReference(VersionConvertor_30_40.convertReference(t));
        if (src.hasPrescription())
            tgt.setRequest(VersionConvertor_30_40.convertReference(src.getPrescription()));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getDevice()) tgt.addDevice(VersionConvertor_30_40.convertReference(t));
        for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_40.convertAnnotation(t));
        if (src.hasDosage())
            tgt.setDosage(convertMedicationAdministrationDosageComponent(src.getDosage()));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getEventHistory()) tgt.addEventHistory(VersionConvertor_30_40.convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationDosageComponent convertMedicationAdministrationDosageComponent(org.hl7.fhir.dstu3.model.MedicationAdministration.MedicationAdministrationDosageComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationDosageComponent tgt = new org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationDosageComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasText())
            tgt.setTextElement(VersionConvertor_30_40.convertString(src.getTextElement()));
        if (src.hasSite())
            tgt.setSite(VersionConvertor_30_40.convertCodeableConcept(src.getSite()));
        if (src.hasRoute())
            tgt.setRoute(VersionConvertor_30_40.convertCodeableConcept(src.getRoute()));
        if (src.hasMethod())
            tgt.setMethod(VersionConvertor_30_40.convertCodeableConcept(src.getMethod()));
        if (src.hasDose())
            tgt.setDose(VersionConvertor_30_40.convertSimpleQuantity(src.getDose()));
        if (src.hasRate())
            tgt.setRate(VersionConvertor_30_40.convertType(src.getRate()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.MedicationAdministration.MedicationAdministrationDosageComponent convertMedicationAdministrationDosageComponent(org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationDosageComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.MedicationAdministration.MedicationAdministrationDosageComponent tgt = new org.hl7.fhir.dstu3.model.MedicationAdministration.MedicationAdministrationDosageComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasText())
            tgt.setTextElement(VersionConvertor_30_40.convertString(src.getTextElement()));
        if (src.hasSite())
            tgt.setSite(VersionConvertor_30_40.convertCodeableConcept(src.getSite()));
        if (src.hasRoute())
            tgt.setRoute(VersionConvertor_30_40.convertCodeableConcept(src.getRoute()));
        if (src.hasMethod())
            tgt.setMethod(VersionConvertor_30_40.convertCodeableConcept(src.getMethod()));
        if (src.hasDose())
            tgt.setDose(VersionConvertor_30_40.convertSimpleQuantity(src.getDose()));
        if (src.hasRate())
            tgt.setRate(VersionConvertor_30_40.convertType(src.getRate()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationPerformerComponent convertMedicationAdministrationPerformerComponent(org.hl7.fhir.dstu3.model.MedicationAdministration.MedicationAdministrationPerformerComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationPerformerComponent tgt = new org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationPerformerComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasActor())
            tgt.setActor(VersionConvertor_30_40.convertReference(src.getActor()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.MedicationAdministration.MedicationAdministrationPerformerComponent convertMedicationAdministrationPerformerComponent(org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationPerformerComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.MedicationAdministration.MedicationAdministrationPerformerComponent tgt = new org.hl7.fhir.dstu3.model.MedicationAdministration.MedicationAdministrationPerformerComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasActor())
            tgt.setActor(VersionConvertor_30_40.convertReference(src.getActor()));
        return tgt;
    }

    private static org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MedicationAdministration.MedicationAdministrationStatus> convertMedicationAdministrationStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationStatus> src) {
      if (src == null)
        return null;
      org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MedicationAdministration.MedicationAdministrationStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.MedicationAdministration.MedicationAdministrationStatusEnumFactory());
      VersionConvertor_30_40.copyElement(src, tgt);
      // 
      switch(src.getValue()) {
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.dstu3.model.MedicationAdministration.MedicationAdministrationStatus.COMPLETED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.dstu3.model.MedicationAdministration.MedicationAdministrationStatus.ENTEREDINERROR);
        break;
      case INPROGRESS:
        tgt.setValue(org.hl7.fhir.dstu3.model.MedicationAdministration.MedicationAdministrationStatus.INPROGRESS);
        break;
      case NOTDONE:
        tgt.setValue(org.hl7.fhir.dstu3.model.MedicationAdministration.MedicationAdministrationStatus.STOPPED);
        break;
      case NULL:
        tgt.setValue(org.hl7.fhir.dstu3.model.MedicationAdministration.MedicationAdministrationStatus.NULL);
        break;
      case ONHOLD:
        tgt.setValue(org.hl7.fhir.dstu3.model.MedicationAdministration.MedicationAdministrationStatus.ONHOLD);
        break;
      case STOPPED:
        tgt.setValue(org.hl7.fhir.dstu3.model.MedicationAdministration.MedicationAdministrationStatus.STOPPED);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.dstu3.model.MedicationAdministration.MedicationAdministrationStatus.UNKNOWN);
        break;
      }
      return tgt;
    }

    private static org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationStatus> convertMedicationAdministrationStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MedicationAdministration.MedicationAdministrationStatus> src) {
      if (src == null)
        return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationStatusEnumFactory());
      VersionConvertor_30_40.copyElement(src, tgt);
      // 
      switch(src.getValue()) {
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationStatus.COMPLETED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationStatus.ENTEREDINERROR);
        break;
      case INPROGRESS:
        tgt.setValue(org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationStatus.INPROGRESS);
        break;
      case NULL:
        tgt.setValue(org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationStatus.NULL);
        break;
      case ONHOLD:
        tgt.setValue(org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationStatus.ONHOLD);
        break;
      case STOPPED:
        tgt.setValue(org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationStatus.STOPPED);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationStatus.UNKNOWN);
        break;
      }
      return tgt;
    }
}