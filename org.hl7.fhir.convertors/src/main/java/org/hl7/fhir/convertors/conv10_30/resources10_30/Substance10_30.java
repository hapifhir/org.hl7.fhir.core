package org.hl7.fhir.convertors.conv10_30.resources10_30;

import org.hl7.fhir.convertors.context.ConversionContext10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Reference10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.CodeableConcept10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Identifier10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Ratio10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.SimpleQuantity10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.DateTime10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.String10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Substance10_30 {

  public static org.hl7.fhir.dstu2.model.Substance convertSubstance(org.hl7.fhir.dstu3.model.Substance src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Substance tgt = new org.hl7.fhir.dstu2.model.Substance();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_30.convertIdentifier(t));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept10_30.convertCodeableConcept(t));
    if (src.hasCode())
      tgt.setCode(CodeableConcept10_30.convertCodeableConcept(src.getCode()));
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(String10_30.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.dstu3.model.Substance.SubstanceInstanceComponent t : src.getInstance())
      tgt.addInstance(convertSubstanceInstanceComponent(t));
    for (org.hl7.fhir.dstu3.model.Substance.SubstanceIngredientComponent t : src.getIngredient())
      tgt.addIngredient(convertSubstanceIngredientComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Substance convertSubstance(org.hl7.fhir.dstu2.model.Substance src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Substance tgt = new org.hl7.fhir.dstu3.model.Substance();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_30.convertIdentifier(t));
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept10_30.convertCodeableConcept(t));
    if (src.hasCode())
      tgt.setCode(CodeableConcept10_30.convertCodeableConcept(src.getCode()));
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(String10_30.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.dstu2.model.Substance.SubstanceInstanceComponent t : src.getInstance())
      tgt.addInstance(convertSubstanceInstanceComponent(t));
    for (org.hl7.fhir.dstu2.model.Substance.SubstanceIngredientComponent t : src.getIngredient())
      tgt.addIngredient(convertSubstanceIngredientComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Substance.SubstanceIngredientComponent convertSubstanceIngredientComponent(org.hl7.fhir.dstu2.model.Substance.SubstanceIngredientComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Substance.SubstanceIngredientComponent tgt = new org.hl7.fhir.dstu3.model.Substance.SubstanceIngredientComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyBackboneElement(src,tgt);
    if (src.hasQuantity())
      tgt.setQuantity(Ratio10_30.convertRatio(src.getQuantity()));
    if (src.hasSubstance())
      tgt.setSubstance(Reference10_30.convertReference(src.getSubstance()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Substance.SubstanceIngredientComponent convertSubstanceIngredientComponent(org.hl7.fhir.dstu3.model.Substance.SubstanceIngredientComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Substance.SubstanceIngredientComponent tgt = new org.hl7.fhir.dstu2.model.Substance.SubstanceIngredientComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyBackboneElement(src,tgt);
    if (src.hasQuantity())
      tgt.setQuantity(Ratio10_30.convertRatio(src.getQuantity()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Substance.SubstanceInstanceComponent convertSubstanceInstanceComponent(org.hl7.fhir.dstu2.model.Substance.SubstanceInstanceComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Substance.SubstanceInstanceComponent tgt = new org.hl7.fhir.dstu3.model.Substance.SubstanceInstanceComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyBackboneElement(src,tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier10_30.convertIdentifier(src.getIdentifier()));
    if (src.hasExpiryElement())
      tgt.setExpiryElement(DateTime10_30.convertDateTime(src.getExpiryElement()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity10_30.convertSimpleQuantity(src.getQuantity()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Substance.SubstanceInstanceComponent convertSubstanceInstanceComponent(org.hl7.fhir.dstu3.model.Substance.SubstanceInstanceComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Substance.SubstanceInstanceComponent tgt = new org.hl7.fhir.dstu2.model.Substance.SubstanceInstanceComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyBackboneElement(src,tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier10_30.convertIdentifier(src.getIdentifier()));
    if (src.hasExpiryElement())
      tgt.setExpiryElement(DateTime10_30.convertDateTime(src.getExpiryElement()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity10_30.convertSimpleQuantity(src.getQuantity()));
    return tgt;
  }
}