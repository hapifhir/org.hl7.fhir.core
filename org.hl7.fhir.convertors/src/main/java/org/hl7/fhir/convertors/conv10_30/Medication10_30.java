package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Medication10_30 {

    public static org.hl7.fhir.dstu2.model.Medication convertMedication(org.hl7.fhir.dstu3.model.Medication src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Medication tgt = new org.hl7.fhir.dstu2.model.Medication();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasCode())
            tgt.setCode(VersionConvertor_10_30.convertCodeableConcept(src.getCode()));
        if (src.hasIsBrandElement())
            tgt.setIsBrandElement(VersionConvertor_10_30.convertBoolean(src.getIsBrandElement()));
        if (src.hasManufacturer())
            tgt.setManufacturer(VersionConvertor_10_30.convertReference(src.getManufacturer()));
        if (src.hasPackage())
            tgt.setPackage(convertMedicationPackageComponent(src.getPackage()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Medication convertMedication(org.hl7.fhir.dstu2.model.Medication src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Medication tgt = new org.hl7.fhir.dstu3.model.Medication();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasCode())
            tgt.setCode(VersionConvertor_10_30.convertCodeableConcept(src.getCode()));
        if (src.hasIsBrandElement())
            tgt.setIsBrandElement(VersionConvertor_10_30.convertBoolean(src.getIsBrandElement()));
        if (src.hasManufacturer())
            tgt.setManufacturer(VersionConvertor_10_30.convertReference(src.getManufacturer()));
        if (src.hasPackage())
            tgt.setPackage(convertMedicationPackageComponent(src.getPackage()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Medication.MedicationPackageComponent convertMedicationPackageComponent(org.hl7.fhir.dstu3.model.Medication.MedicationPackageComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Medication.MedicationPackageComponent tgt = new org.hl7.fhir.dstu2.model.Medication.MedicationPackageComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasContainer())
            tgt.setContainer(VersionConvertor_10_30.convertCodeableConcept(src.getContainer()));
        for (org.hl7.fhir.dstu3.model.Medication.MedicationPackageContentComponent t : src.getContent()) tgt.addContent(convertMedicationPackageContentComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Medication.MedicationPackageComponent convertMedicationPackageComponent(org.hl7.fhir.dstu2.model.Medication.MedicationPackageComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Medication.MedicationPackageComponent tgt = new org.hl7.fhir.dstu3.model.Medication.MedicationPackageComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasContainer())
            tgt.setContainer(VersionConvertor_10_30.convertCodeableConcept(src.getContainer()));
        for (org.hl7.fhir.dstu2.model.Medication.MedicationPackageContentComponent t : src.getContent()) tgt.addContent(convertMedicationPackageContentComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Medication.MedicationPackageContentComponent convertMedicationPackageContentComponent(org.hl7.fhir.dstu3.model.Medication.MedicationPackageContentComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Medication.MedicationPackageContentComponent tgt = new org.hl7.fhir.dstu2.model.Medication.MedicationPackageContentComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasItemReference())
            tgt.setItem((org.hl7.fhir.dstu2.model.Reference) VersionConvertor_10_30.convertType(src.getItem()));
        if (src.hasAmount())
            tgt.setAmount(VersionConvertor_10_30.convertSimpleQuantity(src.getAmount()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Medication.MedicationPackageContentComponent convertMedicationPackageContentComponent(org.hl7.fhir.dstu2.model.Medication.MedicationPackageContentComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Medication.MedicationPackageContentComponent tgt = new org.hl7.fhir.dstu3.model.Medication.MedicationPackageContentComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasItem())
            tgt.setItem(VersionConvertor_10_30.convertType(src.getItem()));
        if (src.hasAmount())
            tgt.setAmount(VersionConvertor_10_30.convertSimpleQuantity(src.getAmount()));
        return tgt;
    }
}