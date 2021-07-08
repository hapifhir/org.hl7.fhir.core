package org.hl7.fhir.convertors.conv30_40.resources30_40;

import org.hl7.fhir.convertors.conv30_40.VersionConvertor_30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Element30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Type30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.CodeableConcept30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Ratio30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Boolean30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.DateTime30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.String30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Reference30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Medication30_40 {

    public static org.hl7.fhir.r4.model.Medication convertMedication(org.hl7.fhir.dstu3.model.Medication src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Medication tgt = new org.hl7.fhir.r4.model.Medication();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasCode())
            tgt.setCode(CodeableConcept30_40.convertCodeableConcept(src.getCode()));
        if (src.hasStatus())
            tgt.setStatusElement(convertMedicationStatus(src.getStatusElement()));
        if (src.hasManufacturer())
            tgt.setManufacturer(Reference30_40.convertReference(src.getManufacturer()));
        if (src.hasForm())
            tgt.setForm(CodeableConcept30_40.convertCodeableConcept(src.getForm()));
        for (org.hl7.fhir.dstu3.model.Medication.MedicationIngredientComponent t : src.getIngredient()) tgt.addIngredient(convertMedicationIngredientComponent(t));
        if (src.hasPackage())
            tgt.setBatch(convertMedicationPackageBatchComponent(src.getPackage().getBatchFirstRep()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Medication convertMedication(org.hl7.fhir.r4.model.Medication src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Medication tgt = new org.hl7.fhir.dstu3.model.Medication();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasCode())
            tgt.setCode(CodeableConcept30_40.convertCodeableConcept(src.getCode()));
        if (src.hasStatus())
            tgt.setStatusElement(convertMedicationStatus(src.getStatusElement()));
        if (src.hasManufacturer())
            tgt.setManufacturer(Reference30_40.convertReference(src.getManufacturer()));
        if (src.hasForm())
            tgt.setForm(CodeableConcept30_40.convertCodeableConcept(src.getForm()));
        for (org.hl7.fhir.r4.model.Medication.MedicationIngredientComponent t : src.getIngredient()) tgt.addIngredient(convertMedicationIngredientComponent(t));
        if (src.hasBatch())
            tgt.getPackage().addBatch(convertMedicationPackageBatchComponent(src.getBatch()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Medication.MedicationIngredientComponent convertMedicationIngredientComponent(org.hl7.fhir.r4.model.Medication.MedicationIngredientComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Medication.MedicationIngredientComponent tgt = new org.hl7.fhir.dstu3.model.Medication.MedicationIngredientComponent();
        Element30_40.copyElement(src, tgt);
        if (src.hasItem())
            tgt.setItem(Type30_40.convertType(src.getItem()));
        if (src.hasIsActive())
            tgt.setIsActiveElement(Boolean30_40.convertBoolean(src.getIsActiveElement()));
        if (src.hasStrength())
            tgt.setAmount(Ratio30_40.convertRatio(src.getStrength()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Medication.MedicationIngredientComponent convertMedicationIngredientComponent(org.hl7.fhir.dstu3.model.Medication.MedicationIngredientComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Medication.MedicationIngredientComponent tgt = new org.hl7.fhir.r4.model.Medication.MedicationIngredientComponent();
        Element30_40.copyElement(src, tgt);
        if (src.hasItem())
            tgt.setItem(Type30_40.convertType(src.getItem()));
        if (src.hasIsActive())
            tgt.setIsActiveElement(Boolean30_40.convertBoolean(src.getIsActiveElement()));
        if (src.hasAmount())
            tgt.setStrength(Ratio30_40.convertRatio(src.getAmount()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Medication.MedicationPackageBatchComponent convertMedicationPackageBatchComponent(org.hl7.fhir.r4.model.Medication.MedicationBatchComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Medication.MedicationPackageBatchComponent tgt = new org.hl7.fhir.dstu3.model.Medication.MedicationPackageBatchComponent();
        Element30_40.copyElement(src, tgt);
        if (src.hasLotNumber())
            tgt.setLotNumberElement(String30_40.convertString(src.getLotNumberElement()));
        if (src.hasExpirationDate())
            tgt.setExpirationDateElement(DateTime30_40.convertDateTime(src.getExpirationDateElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Medication.MedicationBatchComponent convertMedicationPackageBatchComponent(org.hl7.fhir.dstu3.model.Medication.MedicationPackageBatchComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Medication.MedicationBatchComponent tgt = new org.hl7.fhir.r4.model.Medication.MedicationBatchComponent();
        Element30_40.copyElement(src, tgt);
        if (src.hasLotNumber())
            tgt.setLotNumberElement(String30_40.convertString(src.getLotNumberElement()));
        if (src.hasExpirationDate())
            tgt.setExpirationDateElement(DateTime30_40.convertDateTime(src.getExpirationDateElement()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Medication.MedicationStatus> convertMedicationStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Medication.MedicationStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Medication.MedicationStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Medication.MedicationStatusEnumFactory());
        Element30_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.dstu3.model.Medication.MedicationStatus.ACTIVE);
                break;
            case INACTIVE:
                tgt.setValue(org.hl7.fhir.dstu3.model.Medication.MedicationStatus.INACTIVE);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.dstu3.model.Medication.MedicationStatus.ENTEREDINERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.Medication.MedicationStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Medication.MedicationStatus> convertMedicationStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Medication.MedicationStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Medication.MedicationStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Medication.MedicationStatusEnumFactory());
        Element30_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.r4.model.Medication.MedicationStatus.ACTIVE);
                break;
            case INACTIVE:
                tgt.setValue(org.hl7.fhir.r4.model.Medication.MedicationStatus.INACTIVE);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r4.model.Medication.MedicationStatus.ENTEREDINERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.Medication.MedicationStatus.NULL);
                break;
        }
        return tgt;
    }
}