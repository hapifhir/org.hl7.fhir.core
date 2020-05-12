package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Substance10_30 {

    public static org.hl7.fhir.dstu2.model.Substance convertSubstance(org.hl7.fhir.dstu3.model.Substance src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Substance tgt = new org.hl7.fhir.dstu2.model.Substance();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getCategory()) tgt.addCategory(VersionConvertor_10_30.convertCodeableConcept(t));
        if (src.hasCode())
            tgt.setCode(VersionConvertor_10_30.convertCodeableConcept(src.getCode()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement(VersionConvertor_10_30.convertString(src.getDescriptionElement()));
        for (org.hl7.fhir.dstu3.model.Substance.SubstanceInstanceComponent t : src.getInstance()) tgt.addInstance(convertSubstanceInstanceComponent(t));
        for (org.hl7.fhir.dstu3.model.Substance.SubstanceIngredientComponent t : src.getIngredient()) tgt.addIngredient(convertSubstanceIngredientComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Substance convertSubstance(org.hl7.fhir.dstu2.model.Substance src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Substance tgt = new org.hl7.fhir.dstu3.model.Substance();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getCategory()) tgt.addCategory(VersionConvertor_10_30.convertCodeableConcept(t));
        if (src.hasCode())
            tgt.setCode(VersionConvertor_10_30.convertCodeableConcept(src.getCode()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement(VersionConvertor_10_30.convertString(src.getDescriptionElement()));
        for (org.hl7.fhir.dstu2.model.Substance.SubstanceInstanceComponent t : src.getInstance()) tgt.addInstance(convertSubstanceInstanceComponent(t));
        for (org.hl7.fhir.dstu2.model.Substance.SubstanceIngredientComponent t : src.getIngredient()) tgt.addIngredient(convertSubstanceIngredientComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Substance.SubstanceIngredientComponent convertSubstanceIngredientComponent(org.hl7.fhir.dstu2.model.Substance.SubstanceIngredientComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Substance.SubstanceIngredientComponent tgt = new org.hl7.fhir.dstu3.model.Substance.SubstanceIngredientComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasQuantity())
            tgt.setQuantity(VersionConvertor_10_30.convertRatio(src.getQuantity()));
        if (src.hasSubstance())
            tgt.setSubstance(VersionConvertor_10_30.convertReference(src.getSubstance()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Substance.SubstanceIngredientComponent convertSubstanceIngredientComponent(org.hl7.fhir.dstu3.model.Substance.SubstanceIngredientComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Substance.SubstanceIngredientComponent tgt = new org.hl7.fhir.dstu2.model.Substance.SubstanceIngredientComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasQuantity())
            tgt.setQuantity(VersionConvertor_10_30.convertRatio(src.getQuantity()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Substance.SubstanceInstanceComponent convertSubstanceInstanceComponent(org.hl7.fhir.dstu2.model.Substance.SubstanceInstanceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Substance.SubstanceInstanceComponent tgt = new org.hl7.fhir.dstu3.model.Substance.SubstanceInstanceComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_10_30.convertIdentifier(src.getIdentifier()));
        if (src.hasExpiryElement())
            tgt.setExpiryElement(VersionConvertor_10_30.convertDateTime(src.getExpiryElement()));
        if (src.hasQuantity())
            tgt.setQuantity(VersionConvertor_10_30.convertSimpleQuantity(src.getQuantity()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Substance.SubstanceInstanceComponent convertSubstanceInstanceComponent(org.hl7.fhir.dstu3.model.Substance.SubstanceInstanceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Substance.SubstanceInstanceComponent tgt = new org.hl7.fhir.dstu2.model.Substance.SubstanceInstanceComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_10_30.convertIdentifier(src.getIdentifier()));
        if (src.hasExpiryElement())
            tgt.setExpiryElement(VersionConvertor_10_30.convertDateTime(src.getExpiryElement()));
        if (src.hasQuantity())
            tgt.setQuantity(VersionConvertor_10_30.convertSimpleQuantity(src.getQuantity()));
        return tgt;
    }
}