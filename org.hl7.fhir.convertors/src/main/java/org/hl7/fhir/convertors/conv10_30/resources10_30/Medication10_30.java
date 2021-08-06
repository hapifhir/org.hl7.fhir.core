package org.hl7.fhir.convertors.conv10_30.resources10_30;

import org.hl7.fhir.convertors.context.ConversionContext10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Reference10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.CodeableConcept10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.SimpleQuantity10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.Boolean10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Medication10_30 {

  public static org.hl7.fhir.dstu2.model.Medication convertMedication(org.hl7.fhir.dstu3.model.Medication src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Medication tgt = new org.hl7.fhir.dstu2.model.Medication();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyDomainResource(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept10_30.convertCodeableConcept(src.getCode()));
    if (src.hasIsBrandElement())
      tgt.setIsBrandElement(Boolean10_30.convertBoolean(src.getIsBrandElement()));
    if (src.hasManufacturer())
      tgt.setManufacturer(Reference10_30.convertReference(src.getManufacturer()));
    if (src.hasPackage())
      tgt.setPackage(convertMedicationPackageComponent(src.getPackage()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Medication convertMedication(org.hl7.fhir.dstu2.model.Medication src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Medication tgt = new org.hl7.fhir.dstu3.model.Medication();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyDomainResource(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept10_30.convertCodeableConcept(src.getCode()));
    if (src.hasIsBrandElement())
      tgt.setIsBrandElement(Boolean10_30.convertBoolean(src.getIsBrandElement()));
    if (src.hasManufacturer())
      tgt.setManufacturer(Reference10_30.convertReference(src.getManufacturer()));
    if (src.hasPackage())
      tgt.setPackage(convertMedicationPackageComponent(src.getPackage()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Medication.MedicationPackageComponent convertMedicationPackageComponent(org.hl7.fhir.dstu3.model.Medication.MedicationPackageComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Medication.MedicationPackageComponent tgt = new org.hl7.fhir.dstu2.model.Medication.MedicationPackageComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.hasContainer())
      tgt.setContainer(CodeableConcept10_30.convertCodeableConcept(src.getContainer()));
    for (org.hl7.fhir.dstu3.model.Medication.MedicationPackageContentComponent t : src.getContent())
      tgt.addContent(convertMedicationPackageContentComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Medication.MedicationPackageComponent convertMedicationPackageComponent(org.hl7.fhir.dstu2.model.Medication.MedicationPackageComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Medication.MedicationPackageComponent tgt = new org.hl7.fhir.dstu3.model.Medication.MedicationPackageComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.hasContainer())
      tgt.setContainer(CodeableConcept10_30.convertCodeableConcept(src.getContainer()));
    for (org.hl7.fhir.dstu2.model.Medication.MedicationPackageContentComponent t : src.getContent())
      tgt.addContent(convertMedicationPackageContentComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Medication.MedicationPackageContentComponent convertMedicationPackageContentComponent(org.hl7.fhir.dstu3.model.Medication.MedicationPackageContentComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Medication.MedicationPackageContentComponent tgt = new org.hl7.fhir.dstu2.model.Medication.MedicationPackageContentComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.hasItemReference())
      tgt.setItem((org.hl7.fhir.dstu2.model.Reference) ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().convertType(src.getItem()));
    if (src.hasAmount())
      tgt.setAmount(SimpleQuantity10_30.convertSimpleQuantity(src.getAmount()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Medication.MedicationPackageContentComponent convertMedicationPackageContentComponent(org.hl7.fhir.dstu2.model.Medication.MedicationPackageContentComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Medication.MedicationPackageContentComponent tgt = new org.hl7.fhir.dstu3.model.Medication.MedicationPackageContentComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.hasItem())
      tgt.setItem(ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().convertType(src.getItem()));
    if (src.hasAmount())
      tgt.setAmount(SimpleQuantity10_30.convertSimpleQuantity(src.getAmount()));
    return tgt;
  }
}