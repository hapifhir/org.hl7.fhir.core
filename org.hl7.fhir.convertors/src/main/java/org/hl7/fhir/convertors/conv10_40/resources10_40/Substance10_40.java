package org.hl7.fhir.convertors.conv10_40.resources10_40;

import org.hl7.fhir.convertors.conv10_40.VersionConvertor_10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Element10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Reference10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.CodeableConcept10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Identifier10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Ratio10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.SimpleQuantity10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.DateTime10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.String10_40;
import org.hl7.fhir.exceptions.FHIRException; import org.hl7.fhir.convertors.context.ConversionContext10_40;

public class Substance10_40 {

  public static org.hl7.fhir.r4.model.Substance convertSubstance(org.hl7.fhir.dstu2.model.Substance src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Substance tgt = new org.hl7.fhir.r4.model.Substance();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_40.convertIdentifier(t));
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept10_40.convertCodeableConcept(t));
    if (src.hasCode())
      tgt.setCode(CodeableConcept10_40.convertCodeableConcept(src.getCode()));
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(String10_40.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.dstu2.model.Substance.SubstanceInstanceComponent t : src.getInstance())
      tgt.addInstance(convertSubstanceInstanceComponent(t));
    for (org.hl7.fhir.dstu2.model.Substance.SubstanceIngredientComponent t : src.getIngredient())
      tgt.addIngredient(convertSubstanceIngredientComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Substance convertSubstance(org.hl7.fhir.r4.model.Substance src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Substance tgt = new org.hl7.fhir.dstu2.model.Substance();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_40.convertIdentifier(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept10_40.convertCodeableConcept(t));
    if (src.hasCode())
      tgt.setCode(CodeableConcept10_40.convertCodeableConcept(src.getCode()));
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(String10_40.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.r4.model.Substance.SubstanceInstanceComponent t : src.getInstance())
      tgt.addInstance(convertSubstanceInstanceComponent(t));
    for (org.hl7.fhir.r4.model.Substance.SubstanceIngredientComponent t : src.getIngredient())
      tgt.addIngredient(convertSubstanceIngredientComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Substance.SubstanceIngredientComponent convertSubstanceIngredientComponent(org.hl7.fhir.r4.model.Substance.SubstanceIngredientComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Substance.SubstanceIngredientComponent tgt = new org.hl7.fhir.dstu2.model.Substance.SubstanceIngredientComponent();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    if (src.hasQuantity())
      tgt.setQuantity(Ratio10_40.convertRatio(src.getQuantity()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Substance.SubstanceIngredientComponent convertSubstanceIngredientComponent(org.hl7.fhir.dstu2.model.Substance.SubstanceIngredientComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Substance.SubstanceIngredientComponent tgt = new org.hl7.fhir.r4.model.Substance.SubstanceIngredientComponent();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    if (src.hasQuantity())
      tgt.setQuantity(Ratio10_40.convertRatio(src.getQuantity()));
    if (src.hasSubstance())
      tgt.setSubstance(Reference10_40.convertReference(src.getSubstance()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Substance.SubstanceInstanceComponent convertSubstanceInstanceComponent(org.hl7.fhir.dstu2.model.Substance.SubstanceInstanceComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Substance.SubstanceInstanceComponent tgt = new org.hl7.fhir.r4.model.Substance.SubstanceInstanceComponent();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier10_40.convertIdentifier(src.getIdentifier()));
    if (src.hasExpiryElement())
      tgt.setExpiryElement(DateTime10_40.convertDateTime(src.getExpiryElement()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity10_40.convertSimpleQuantity(src.getQuantity()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Substance.SubstanceInstanceComponent convertSubstanceInstanceComponent(org.hl7.fhir.r4.model.Substance.SubstanceInstanceComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Substance.SubstanceInstanceComponent tgt = new org.hl7.fhir.dstu2.model.Substance.SubstanceInstanceComponent();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier10_40.convertIdentifier(src.getIdentifier()));
    if (src.hasExpiryElement())
      tgt.setExpiryElement(DateTime10_40.convertDateTime(src.getExpiryElement()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity10_40.convertSimpleQuantity(src.getQuantity()));
    return tgt;
  }
}