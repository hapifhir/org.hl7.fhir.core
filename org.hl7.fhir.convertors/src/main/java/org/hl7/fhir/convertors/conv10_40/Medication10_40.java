package org.hl7.fhir.convertors.conv10_40;

import org.hl7.fhir.convertors.VersionConvertor_10_40;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.Medication;
import org.hl7.fhir.r4.model.Type;

import java.util.List;

public class Medication10_40 {

    public static org.hl7.fhir.r4.model.Medication convertMedication(org.hl7.fhir.dstu2.model.Medication src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Medication tgt = new org.hl7.fhir.r4.model.Medication();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        if (src.hasCode())
            tgt.setCode(VersionConvertor_10_40.convertCodeableConcept(src.getCode()));
        if (src.hasIsBrandElement())
            tgt.addExtension(
                "http://hl7.org/fhir/3.0/StructureDefinition/extension-Medication.isBrand",
                VersionConvertor_10_40.convertBoolean(src.getIsBrandElement())
            );
        if (src.hasManufacturer())
            tgt.setManufacturer(VersionConvertor_10_40.convertReference(src.getManufacturer()));
        if (src.hasProduct()) {
            if (src.getProduct().hasForm())
                tgt.setForm(VersionConvertor_10_40.convertCodeableConcept(src.getProduct().getForm()));
            for (org.hl7.fhir.dstu2.model.Medication.MedicationProductIngredientComponent ingridient : src.getProduct().getIngredient())
                tgt.addIngredient(convertMedicationIngridient(ingridient));
            if (src.getProduct().hasBatch())
                tgt.setBatch(batch(src.getProduct().getBatch().get(0)));
        }
        if (src.hasPackage()) {
            org.hl7.fhir.dstu2.model.Medication.MedicationPackageComponent package_ = src.getPackage();
            if (package_.hasContainer())
                tgt.addExtension(
                    "http://hl7.org/fhir/3.0/StructureDefinition/extension-Medication.package.container",
                    VersionConvertor_10_40.convertCodeableConcept(package_.getContainer())
                );
            for (org.hl7.fhir.dstu2.model.Medication.MedicationPackageContentComponent c : package_.getContent())
                tgt.addExtension(
                        "http://hl7.org/fhir/3.0/StructureDefinition/extension-Medication.package.content",
                        content(c)
                );
        }
        return tgt;
    }

    private static org.hl7.fhir.r4.model.Medication.MedicationBatchComponent batch(org.hl7.fhir.dstu2.model.Medication.MedicationProductBatchComponent src) {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Medication.MedicationBatchComponent tgt = new org.hl7.fhir.r4.model.Medication.MedicationBatchComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasLotNumber())
            tgt.setLotNumber(src.getLotNumber());
        if (src.hasExpirationDate())
            tgt.setExpirationDate(src.getExpirationDate());
        return tgt;
    }

    private static org.hl7.fhir.r4.model.Extension content(org.hl7.fhir.dstu2.model.Medication.MedicationPackageContentComponent src) {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Extension tgt = new org.hl7.fhir.r4.model.Extension();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasItem())
            tgt.addExtension(
                    "http://hl7.org/fhir/3.0/StructureDefinition/extension-Medication.package.content",
                    VersionConvertor_10_40.convertReference(src.getItem())
            );
        if (src.hasAmount())
            tgt.addExtension(
                    "http://hl7.org/fhir/3.0/StructureDefinition/extension-Medication.package.content.amount",
                    VersionConvertor_10_40.convertSimpleQuantity(src.getAmount())
            );
        return tgt;
    }

    private static org.hl7.fhir.r4.model.Medication.MedicationIngredientComponent convertMedicationIngridient(org.hl7.fhir.dstu2.model.Medication.MedicationProductIngredientComponent src) {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Medication.MedicationIngredientComponent tgt = new org.hl7.fhir.r4.model.Medication.MedicationIngredientComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasItem())
            tgt.setItem(VersionConvertor_10_40.convertReference(src.getItem()));
        if (src.hasAmount())
            tgt.setStrength(VersionConvertor_10_40.convertRatio(src.getAmount()));
        return tgt;
    }
}