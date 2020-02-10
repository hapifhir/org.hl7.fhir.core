package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;
import java.util.Collections;

public class Substance30_40 {

    static public org.hl7.fhir.r4.model.Substance.FHIRSubstanceStatus convertFHIRSubstanceStatus(org.hl7.fhir.dstu3.model.Substance.FHIRSubstanceStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ACTIVE:
                return org.hl7.fhir.r4.model.Substance.FHIRSubstanceStatus.ACTIVE;
            case INACTIVE:
                return org.hl7.fhir.r4.model.Substance.FHIRSubstanceStatus.INACTIVE;
            case ENTEREDINERROR:
                return org.hl7.fhir.r4.model.Substance.FHIRSubstanceStatus.ENTEREDINERROR;
            default:
                return org.hl7.fhir.r4.model.Substance.FHIRSubstanceStatus.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.Substance.FHIRSubstanceStatus convertFHIRSubstanceStatus(org.hl7.fhir.r4.model.Substance.FHIRSubstanceStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ACTIVE:
                return org.hl7.fhir.dstu3.model.Substance.FHIRSubstanceStatus.ACTIVE;
            case INACTIVE:
                return org.hl7.fhir.dstu3.model.Substance.FHIRSubstanceStatus.INACTIVE;
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu3.model.Substance.FHIRSubstanceStatus.ENTEREDINERROR;
            default:
                return org.hl7.fhir.dstu3.model.Substance.FHIRSubstanceStatus.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.Substance convertSubstance(org.hl7.fhir.dstu3.model.Substance src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Substance tgt = new org.hl7.fhir.r4.model.Substance();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        }
        if (src.hasStatus())
            tgt.setStatus(convertFHIRSubstanceStatus(src.getStatus()));
        if (src.hasCategory()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getCategory()) tgt.addCategory(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasCode())
            tgt.setCode(VersionConvertor_30_40.convertCodeableConcept(src.getCode()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getDescriptionElement()));
        if (src.hasInstance()) {
            for (org.hl7.fhir.dstu3.model.Substance.SubstanceInstanceComponent t : src.getInstance()) tgt.addInstance(convertSubstanceInstanceComponent(t));
        }
        if (src.hasIngredient()) {
            for (org.hl7.fhir.dstu3.model.Substance.SubstanceIngredientComponent t : src.getIngredient()) tgt.addIngredient(convertSubstanceIngredientComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Substance convertSubstance(org.hl7.fhir.r4.model.Substance src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Substance tgt = new org.hl7.fhir.dstu3.model.Substance();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        }
        if (src.hasStatus())
            tgt.setStatus(convertFHIRSubstanceStatus(src.getStatus()));
        if (src.hasCategory()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory()) tgt.addCategory(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasCode())
            tgt.setCode(VersionConvertor_30_40.convertCodeableConcept(src.getCode()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getDescriptionElement()));
        if (src.hasInstance()) {
            for (org.hl7.fhir.r4.model.Substance.SubstanceInstanceComponent t : src.getInstance()) tgt.addInstance(convertSubstanceInstanceComponent(t));
        }
        if (src.hasIngredient()) {
            for (org.hl7.fhir.r4.model.Substance.SubstanceIngredientComponent t : src.getIngredient()) tgt.addIngredient(convertSubstanceIngredientComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Substance.SubstanceIngredientComponent convertSubstanceIngredientComponent(org.hl7.fhir.r4.model.Substance.SubstanceIngredientComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Substance.SubstanceIngredientComponent tgt = new org.hl7.fhir.dstu3.model.Substance.SubstanceIngredientComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasQuantity())
            tgt.setQuantity(VersionConvertor_30_40.convertRatio(src.getQuantity()));
        if (src.hasSubstance())
            tgt.setSubstance(VersionConvertor_30_40.convertType(src.getSubstance()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Substance.SubstanceIngredientComponent convertSubstanceIngredientComponent(org.hl7.fhir.dstu3.model.Substance.SubstanceIngredientComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Substance.SubstanceIngredientComponent tgt = new org.hl7.fhir.r4.model.Substance.SubstanceIngredientComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasQuantity())
            tgt.setQuantity(VersionConvertor_30_40.convertRatio(src.getQuantity()));
        if (src.hasSubstance())
            tgt.setSubstance(VersionConvertor_30_40.convertType(src.getSubstance()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Substance.SubstanceInstanceComponent convertSubstanceInstanceComponent(org.hl7.fhir.r4.model.Substance.SubstanceInstanceComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Substance.SubstanceInstanceComponent tgt = new org.hl7.fhir.dstu3.model.Substance.SubstanceInstanceComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_30_40.convertIdentifier(src.getIdentifier()));
        if (src.hasExpiry())
            tgt.setExpiryElement(VersionConvertor_30_40.convertDateTime(src.getExpiryElement()));
        if (src.hasQuantity())
            tgt.setQuantity(VersionConvertor_30_40.convertSimpleQuantity(src.getQuantity()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Substance.SubstanceInstanceComponent convertSubstanceInstanceComponent(org.hl7.fhir.dstu3.model.Substance.SubstanceInstanceComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Substance.SubstanceInstanceComponent tgt = new org.hl7.fhir.r4.model.Substance.SubstanceInstanceComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_30_40.convertIdentifier(src.getIdentifier()));
        if (src.hasExpiry())
            tgt.setExpiryElement(VersionConvertor_30_40.convertDateTime(src.getExpiryElement()));
        if (src.hasQuantity())
            tgt.setQuantity(VersionConvertor_30_40.convertSimpleQuantity(src.getQuantity()));
        return tgt;
    }
}
