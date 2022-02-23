package org.hl7.fhir.convertors.conv30_40.resources30_40;

import org.hl7.fhir.convertors.context.ConversionContext30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.CodeableConcept30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Identifier30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Ratio30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.SimpleQuantity30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.DateTime30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.String30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Substance30_40 {

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Substance.FHIRSubstanceStatus> convertFHIRSubstanceStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Substance.FHIRSubstanceStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Substance.FHIRSubstanceStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Substance.FHIRSubstanceStatusEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r4.model.Substance.FHIRSubstanceStatus.ACTIVE);
        break;
      case INACTIVE:
        tgt.setValue(org.hl7.fhir.r4.model.Substance.FHIRSubstanceStatus.INACTIVE);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4.model.Substance.FHIRSubstanceStatus.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.Substance.FHIRSubstanceStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Substance.FHIRSubstanceStatus> convertFHIRSubstanceStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Substance.FHIRSubstanceStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Substance.FHIRSubstanceStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Substance.FHIRSubstanceStatusEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
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

  public static org.hl7.fhir.r4.model.Substance convertSubstance(org.hl7.fhir.dstu3.model.Substance src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Substance tgt = new org.hl7.fhir.r4.model.Substance();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertFHIRSubstanceStatus(src.getStatusElement()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept30_40.convertCodeableConcept(t));
    if (src.hasCode())
      tgt.setCode(CodeableConcept30_40.convertCodeableConcept(src.getCode()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String30_40.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.dstu3.model.Substance.SubstanceInstanceComponent t : src.getInstance())
      tgt.addInstance(convertSubstanceInstanceComponent(t));
    for (org.hl7.fhir.dstu3.model.Substance.SubstanceIngredientComponent t : src.getIngredient())
      tgt.addIngredient(convertSubstanceIngredientComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Substance convertSubstance(org.hl7.fhir.r4.model.Substance src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Substance tgt = new org.hl7.fhir.dstu3.model.Substance();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertFHIRSubstanceStatus(src.getStatusElement()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept30_40.convertCodeableConcept(t));
    if (src.hasCode())
      tgt.setCode(CodeableConcept30_40.convertCodeableConcept(src.getCode()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String30_40.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.r4.model.Substance.SubstanceInstanceComponent t : src.getInstance())
      tgt.addInstance(convertSubstanceInstanceComponent(t));
    for (org.hl7.fhir.r4.model.Substance.SubstanceIngredientComponent t : src.getIngredient())
      tgt.addIngredient(convertSubstanceIngredientComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Substance.SubstanceIngredientComponent convertSubstanceIngredientComponent(org.hl7.fhir.r4.model.Substance.SubstanceIngredientComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Substance.SubstanceIngredientComponent tgt = new org.hl7.fhir.dstu3.model.Substance.SubstanceIngredientComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasQuantity())
      tgt.setQuantity(Ratio30_40.convertRatio(src.getQuantity()));
    if (src.hasSubstance())
      tgt.setSubstance(ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertType(src.getSubstance()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Substance.SubstanceIngredientComponent convertSubstanceIngredientComponent(org.hl7.fhir.dstu3.model.Substance.SubstanceIngredientComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Substance.SubstanceIngredientComponent tgt = new org.hl7.fhir.r4.model.Substance.SubstanceIngredientComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasQuantity())
      tgt.setQuantity(Ratio30_40.convertRatio(src.getQuantity()));
    if (src.hasSubstance())
      tgt.setSubstance(ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertType(src.getSubstance()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Substance.SubstanceInstanceComponent convertSubstanceInstanceComponent(org.hl7.fhir.r4.model.Substance.SubstanceInstanceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Substance.SubstanceInstanceComponent tgt = new org.hl7.fhir.dstu3.model.Substance.SubstanceInstanceComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier30_40.convertIdentifier(src.getIdentifier()));
    if (src.hasExpiry())
      tgt.setExpiryElement(DateTime30_40.convertDateTime(src.getExpiryElement()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity30_40.convertSimpleQuantity(src.getQuantity()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Substance.SubstanceInstanceComponent convertSubstanceInstanceComponent(org.hl7.fhir.dstu3.model.Substance.SubstanceInstanceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Substance.SubstanceInstanceComponent tgt = new org.hl7.fhir.r4.model.Substance.SubstanceInstanceComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier30_40.convertIdentifier(src.getIdentifier()));
    if (src.hasExpiry())
      tgt.setExpiryElement(DateTime30_40.convertDateTime(src.getExpiryElement()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity30_40.convertSimpleQuantity(src.getQuantity()));
    return tgt;
  }
}