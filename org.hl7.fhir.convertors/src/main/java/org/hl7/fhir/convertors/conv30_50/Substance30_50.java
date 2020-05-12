package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Substance30_50 {

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Substance.FHIRSubstanceStatus> convertFHIRSubstanceStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Substance.FHIRSubstanceStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Substance.FHIRSubstanceStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Substance.FHIRSubstanceStatusEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.r5.model.Substance.FHIRSubstanceStatus.ACTIVE);
                break;
            case INACTIVE:
                tgt.setValue(org.hl7.fhir.r5.model.Substance.FHIRSubstanceStatus.INACTIVE);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r5.model.Substance.FHIRSubstanceStatus.ENTEREDINERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Substance.FHIRSubstanceStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Substance.FHIRSubstanceStatus> convertFHIRSubstanceStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Substance.FHIRSubstanceStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Substance.FHIRSubstanceStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Substance.FHIRSubstanceStatusEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.dstu3.model.Substance.FHIRSubstanceStatus.ACTIVE);
                break;
            case INACTIVE:
                tgt.setValue(org.hl7.fhir.dstu3.model.Substance.FHIRSubstanceStatus.INACTIVE);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.dstu3.model.Substance.FHIRSubstanceStatus.ENTEREDINERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.Substance.FHIRSubstanceStatus.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Substance convertSubstance(org.hl7.fhir.dstu3.model.Substance src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Substance tgt = new org.hl7.fhir.r5.model.Substance();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertFHIRSubstanceStatus(src.getStatusElement()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getCategory()) tgt.addCategory(VersionConvertor_30_50.convertCodeableConcept(t));
        if (src.hasCode())
            tgt.setCode(VersionConvertor_30_50.convertCodeableConcept(src.getCode()));
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_30_50.convertString(src.getDescriptionElement()));
        for (org.hl7.fhir.dstu3.model.Substance.SubstanceInstanceComponent t : src.getInstance()) tgt.addInstance(convertSubstanceInstanceComponent(t));
        for (org.hl7.fhir.dstu3.model.Substance.SubstanceIngredientComponent t : src.getIngredient()) tgt.addIngredient(convertSubstanceIngredientComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Substance convertSubstance(org.hl7.fhir.r5.model.Substance src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Substance tgt = new org.hl7.fhir.dstu3.model.Substance();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertFHIRSubstanceStatus(src.getStatusElement()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCategory()) tgt.addCategory(VersionConvertor_30_50.convertCodeableConcept(t));
        if (src.hasCode())
            tgt.setCode(VersionConvertor_30_50.convertCodeableConcept(src.getCode()));
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_30_50.convertString(src.getDescriptionElement()));
        for (org.hl7.fhir.r5.model.Substance.SubstanceInstanceComponent t : src.getInstance()) tgt.addInstance(convertSubstanceInstanceComponent(t));
        for (org.hl7.fhir.r5.model.Substance.SubstanceIngredientComponent t : src.getIngredient()) tgt.addIngredient(convertSubstanceIngredientComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Substance.SubstanceIngredientComponent convertSubstanceIngredientComponent(org.hl7.fhir.r5.model.Substance.SubstanceIngredientComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Substance.SubstanceIngredientComponent tgt = new org.hl7.fhir.dstu3.model.Substance.SubstanceIngredientComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasQuantity())
            tgt.setQuantity(VersionConvertor_30_50.convertRatio(src.getQuantity()));
        if (src.hasSubstance())
            tgt.setSubstance(VersionConvertor_30_50.convertType(src.getSubstance()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Substance.SubstanceIngredientComponent convertSubstanceIngredientComponent(org.hl7.fhir.dstu3.model.Substance.SubstanceIngredientComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Substance.SubstanceIngredientComponent tgt = new org.hl7.fhir.r5.model.Substance.SubstanceIngredientComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasQuantity())
            tgt.setQuantity(VersionConvertor_30_50.convertRatio(src.getQuantity()));
        if (src.hasSubstance())
            tgt.setSubstance(VersionConvertor_30_50.convertType(src.getSubstance()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Substance.SubstanceInstanceComponent convertSubstanceInstanceComponent(org.hl7.fhir.dstu3.model.Substance.SubstanceInstanceComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Substance.SubstanceInstanceComponent tgt = new org.hl7.fhir.r5.model.Substance.SubstanceInstanceComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_30_50.convertIdentifier(src.getIdentifier()));
        if (src.hasExpiry())
            tgt.setExpiryElement(VersionConvertor_30_50.convertDateTime(src.getExpiryElement()));
        if (src.hasQuantity())
            tgt.setQuantity(VersionConvertor_30_50.convertSimpleQuantity(src.getQuantity()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Substance.SubstanceInstanceComponent convertSubstanceInstanceComponent(org.hl7.fhir.r5.model.Substance.SubstanceInstanceComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Substance.SubstanceInstanceComponent tgt = new org.hl7.fhir.dstu3.model.Substance.SubstanceInstanceComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_30_50.convertIdentifier(src.getIdentifier()));
        if (src.hasExpiry())
            tgt.setExpiryElement(VersionConvertor_30_50.convertDateTime(src.getExpiryElement()));
        if (src.hasQuantity())
            tgt.setQuantity(VersionConvertor_30_50.convertSimpleQuantity(src.getQuantity()));
        return tgt;
    }
}