package org.hl7.fhir.convertors.conv40_50.resources40_50;

import org.hl7.fhir.convertors.conv40_50.datatypes40_50.BackboneElement40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Attachment40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.CodeableConcept40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Quantity40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.String40_50;
import org.hl7.fhir.exceptions.FHIRException;

public class ProdCharacteristic40_50 {
  public static org.hl7.fhir.r5.model.ProdCharacteristic convertProdCharacteristic(org.hl7.fhir.r4.model.ProdCharacteristic src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.ProdCharacteristic tgt = new org.hl7.fhir.r5.model.ProdCharacteristic();
    BackboneElement40_50.copyBackboneElement(src, tgt);
    if (src.hasHeight()) tgt.setHeight(Quantity40_50.convertQuantity(src.getHeight()));
    if (src.hasWidth()) tgt.setWidth(Quantity40_50.convertQuantity(src.getWidth()));
    if (src.hasDepth()) tgt.setDepth(Quantity40_50.convertQuantity(src.getDepth()));
    if (src.hasWeight()) tgt.setWeight(Quantity40_50.convertQuantity(src.getWeight()));
    if (src.hasNominalVolume()) tgt.setNominalVolume(Quantity40_50.convertQuantity(src.getNominalVolume()));
    if (src.hasExternalDiameter()) tgt.setExternalDiameter(Quantity40_50.convertQuantity(src.getExternalDiameter()));
    if (src.hasShape()) tgt.setShapeElement(String40_50.convertString(src.getShapeElement()));
    for (org.hl7.fhir.r4.model.StringType t : src.getColor()) tgt.getColor().add(String40_50.convertString(t));
    for (org.hl7.fhir.r4.model.StringType t : src.getImprint()) tgt.getImprint().add(String40_50.convertString(t));
    for (org.hl7.fhir.r4.model.Attachment t : src.getImage()) tgt.addImage(Attachment40_50.convertAttachment(t));
    if (src.hasScoring()) tgt.setScoring(CodeableConcept40_50.convertCodeableConcept(src.getScoring()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ProdCharacteristic convertProdCharacteristic(org.hl7.fhir.r5.model.ProdCharacteristic src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.ProdCharacteristic tgt = new org.hl7.fhir.r4.model.ProdCharacteristic();
    BackboneElement40_50.copyBackboneElement(src, tgt);
    if (src.hasHeight()) tgt.setHeight(Quantity40_50.convertQuantity(src.getHeight()));
    if (src.hasWidth()) tgt.setWidth(Quantity40_50.convertQuantity(src.getWidth()));
    if (src.hasDepth()) tgt.setDepth(Quantity40_50.convertQuantity(src.getDepth()));
    if (src.hasWeight()) tgt.setWeight(Quantity40_50.convertQuantity(src.getWeight()));
    if (src.hasNominalVolume()) tgt.setNominalVolume(Quantity40_50.convertQuantity(src.getNominalVolume()));
    if (src.hasExternalDiameter()) tgt.setExternalDiameter(Quantity40_50.convertQuantity(src.getExternalDiameter()));
    if (src.hasShape()) tgt.setShapeElement(String40_50.convertString(src.getShapeElement()));
    for (org.hl7.fhir.r5.model.StringType t : src.getColor()) tgt.getColor().add(String40_50.convertString(t));
    for (org.hl7.fhir.r5.model.StringType t : src.getImprint()) tgt.getImprint().add(String40_50.convertString(t));
    for (org.hl7.fhir.r5.model.Attachment t : src.getImage()) tgt.addImage(Attachment40_50.convertAttachment(t));
    if (src.hasScoring()) tgt.setScoring(CodeableConcept40_50.convertCodeableConcept(src.getScoring()));
    return tgt;
  }
}
