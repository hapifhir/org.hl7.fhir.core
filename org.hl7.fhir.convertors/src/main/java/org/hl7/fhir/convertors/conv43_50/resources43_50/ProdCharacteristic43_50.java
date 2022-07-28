package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.conv43_50.datatypes43_50.BackboneElement43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Attachment43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Quantity43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
import org.hl7.fhir.exceptions.FHIRException;

public class ProdCharacteristic43_50 {
  public static org.hl7.fhir.r5.model.ProdCharacteristic convertProdCharacteristic(org.hl7.fhir.r4b.model.ProdCharacteristic src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.ProdCharacteristic tgt = new org.hl7.fhir.r5.model.ProdCharacteristic();
    BackboneElement43_50.copyBackboneElement(src, tgt);
    if (src.hasHeight()) tgt.setHeight(Quantity43_50.convertQuantity(src.getHeight()));
    if (src.hasWidth()) tgt.setWidth(Quantity43_50.convertQuantity(src.getWidth()));
    if (src.hasDepth()) tgt.setDepth(Quantity43_50.convertQuantity(src.getDepth()));
    if (src.hasWeight()) tgt.setWeight(Quantity43_50.convertQuantity(src.getWeight()));
    if (src.hasNominalVolume()) tgt.setNominalVolume(Quantity43_50.convertQuantity(src.getNominalVolume()));
    if (src.hasExternalDiameter()) tgt.setExternalDiameter(Quantity43_50.convertQuantity(src.getExternalDiameter()));
    if (src.hasShape()) tgt.setShapeElement(String43_50.convertString(src.getShapeElement()));
    for (org.hl7.fhir.r4b.model.StringType t : src.getColor()) tgt.getColor().add(String43_50.convertString(t));
    for (org.hl7.fhir.r4b.model.StringType t : src.getImprint()) tgt.getImprint().add(String43_50.convertString(t));
    for (org.hl7.fhir.r4b.model.Attachment t : src.getImage()) tgt.addImage(Attachment43_50.convertAttachment(t));
    if (src.hasScoring()) tgt.setScoring(CodeableConcept43_50.convertCodeableConcept(src.getScoring()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ProdCharacteristic convertProdCharacteristic(org.hl7.fhir.r5.model.ProdCharacteristic src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.ProdCharacteristic tgt = new org.hl7.fhir.r4b.model.ProdCharacteristic();
    BackboneElement43_50.copyBackboneElement(src, tgt);
    if (src.hasHeight()) tgt.setHeight(Quantity43_50.convertQuantity(src.getHeight()));
    if (src.hasWidth()) tgt.setWidth(Quantity43_50.convertQuantity(src.getWidth()));
    if (src.hasDepth()) tgt.setDepth(Quantity43_50.convertQuantity(src.getDepth()));
    if (src.hasWeight()) tgt.setWeight(Quantity43_50.convertQuantity(src.getWeight()));
    if (src.hasNominalVolume()) tgt.setNominalVolume(Quantity43_50.convertQuantity(src.getNominalVolume()));
    if (src.hasExternalDiameter()) tgt.setExternalDiameter(Quantity43_50.convertQuantity(src.getExternalDiameter()));
    if (src.hasShape()) tgt.setShapeElement(String43_50.convertString(src.getShapeElement()));
    for (org.hl7.fhir.r5.model.StringType t : src.getColor()) tgt.getColor().add(String43_50.convertString(t));
    for (org.hl7.fhir.r5.model.StringType t : src.getImprint()) tgt.getImprint().add(String43_50.convertString(t));
    for (org.hl7.fhir.r5.model.Attachment t : src.getImage()) tgt.addImage(Attachment43_50.convertAttachment(t));
    if (src.hasScoring()) tgt.setScoring(CodeableConcept43_50.convertCodeableConcept(src.getScoring()));
    return tgt;
  }
}
