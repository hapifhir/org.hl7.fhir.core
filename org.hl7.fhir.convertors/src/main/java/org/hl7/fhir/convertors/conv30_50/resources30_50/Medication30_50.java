package org.hl7.fhir.convertors.conv30_50.resources30_50;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Reference30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.CodeableConcept30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Ratio30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Boolean30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.DateTime30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.String30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Medication30_50 {

  public static org.hl7.fhir.r5.model.Medication convertMedication(org.hl7.fhir.dstu3.model.Medication src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Medication tgt = new org.hl7.fhir.r5.model.Medication();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept30_50.convertCodeableConcept(src.getCode()));
    if (src.hasStatus())
      tgt.setStatusElement(convertMedicationStatus(src.getStatusElement()));
    if (src.hasManufacturer())
      tgt.setMarketingAuthorizationHolder(Reference30_50.convertReference(src.getManufacturer()));
    if (src.hasForm())
      tgt.setDoseForm(CodeableConcept30_50.convertCodeableConcept(src.getForm()));
    for (org.hl7.fhir.dstu3.model.Medication.MedicationIngredientComponent t : src.getIngredient())
      tgt.addIngredient(convertMedicationIngredientComponent(t));
    if (src.hasPackage())
      tgt.setBatch(convertMedicationPackageBatchComponent(src.getPackage().getBatchFirstRep()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Medication convertMedication(org.hl7.fhir.r5.model.Medication src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Medication tgt = new org.hl7.fhir.dstu3.model.Medication();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept30_50.convertCodeableConcept(src.getCode()));
    if (src.hasStatus())
      tgt.setStatusElement(convertMedicationStatus(src.getStatusElement()));
    if (src.hasMarketingAuthorizationHolder())
      tgt.setManufacturer(Reference30_50.convertReference(src.getMarketingAuthorizationHolder()));
    if (src.hasDoseForm())
      tgt.setForm(CodeableConcept30_50.convertCodeableConcept(src.getDoseForm()));
    for (org.hl7.fhir.r5.model.Medication.MedicationIngredientComponent t : src.getIngredient())
      tgt.addIngredient(convertMedicationIngredientComponent(t));
    if (src.hasBatch())
      tgt.getPackage().addBatch(convertMedicationPackageBatchComponent(src.getBatch()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Medication.MedicationIngredientComponent convertMedicationIngredientComponent(org.hl7.fhir.r5.model.Medication.MedicationIngredientComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Medication.MedicationIngredientComponent tgt = new org.hl7.fhir.dstu3.model.Medication.MedicationIngredientComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.getItem().hasConcept())
      tgt.setItem(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getItem().getConcept()));
    if (src.getItem().hasReference())
      tgt.setItem(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getItem().getReference()));
    if (src.hasIsActive())
      tgt.setIsActiveElement(Boolean30_50.convertBoolean(src.getIsActiveElement()));
    if (src.hasStrengthRatio())
      tgt.setAmount(Ratio30_50.convertRatio(src.getStrengthRatio()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Medication.MedicationIngredientComponent convertMedicationIngredientComponent(org.hl7.fhir.dstu3.model.Medication.MedicationIngredientComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Medication.MedicationIngredientComponent tgt = new org.hl7.fhir.r5.model.Medication.MedicationIngredientComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasItemCodeableConcept())
      tgt.getItem().setConcept(CodeableConcept30_50.convertCodeableConcept(src.getItemCodeableConcept()));
    if (src.hasItemReference())
      tgt.getItem().setReference(Reference30_50.convertReference(src.getItemReference()));
    if (src.hasIsActive())
      tgt.setIsActiveElement(Boolean30_50.convertBoolean(src.getIsActiveElement()));
    if (src.hasAmount())
      tgt.setStrength(Ratio30_50.convertRatio(src.getAmount()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Medication.MedicationPackageBatchComponent convertMedicationPackageBatchComponent(org.hl7.fhir.r5.model.Medication.MedicationBatchComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Medication.MedicationPackageBatchComponent tgt = new org.hl7.fhir.dstu3.model.Medication.MedicationPackageBatchComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasLotNumber())
      tgt.setLotNumberElement(String30_50.convertString(src.getLotNumberElement()));
    if (src.hasExpirationDate())
      tgt.setExpirationDateElement(DateTime30_50.convertDateTime(src.getExpirationDateElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Medication.MedicationBatchComponent convertMedicationPackageBatchComponent(org.hl7.fhir.dstu3.model.Medication.MedicationPackageBatchComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Medication.MedicationBatchComponent tgt = new org.hl7.fhir.r5.model.Medication.MedicationBatchComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasLotNumber())
      tgt.setLotNumberElement(String30_50.convertString(src.getLotNumberElement()));
    if (src.hasExpirationDate())
      tgt.setExpirationDateElement(DateTime30_50.convertDateTime(src.getExpirationDateElement()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Medication.MedicationStatusCodes> convertMedicationStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Medication.MedicationStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Medication.MedicationStatusCodes> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Medication.MedicationStatusCodesEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r5.model.Medication.MedicationStatusCodes.ACTIVE);
        break;
      case INACTIVE:
        tgt.setValue(org.hl7.fhir.r5.model.Medication.MedicationStatusCodes.INACTIVE);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r5.model.Medication.MedicationStatusCodes.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Medication.MedicationStatusCodes.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Medication.MedicationStatus> convertMedicationStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Medication.MedicationStatusCodes> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Medication.MedicationStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Medication.MedicationStatusEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
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
}