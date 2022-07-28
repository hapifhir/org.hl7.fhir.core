package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Annotation43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.SimpleQuantity43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.DateTime43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Decimal43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Integer43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50.Reference43_50;
import org.hl7.fhir.exceptions.FHIRException;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
  
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
*/
// Generated on Sun, Feb 24, 2019 11:37+1100 for FHIR v4.0.0
public class VisionPrescription43_50 {

  public static org.hl7.fhir.r5.model.VisionPrescription convertVisionPrescription(org.hl7.fhir.r4b.model.VisionPrescription src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.VisionPrescription tgt = new org.hl7.fhir.r5.model.VisionPrescription();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertVisionStatus(src.getStatusElement()));
    if (src.hasCreated())
      tgt.setCreatedElement(DateTime43_50.convertDateTime(src.getCreatedElement()));
    if (src.hasPatient())
      tgt.setPatient(Reference43_50.convertReference(src.getPatient()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference43_50.convertReference(src.getEncounter()));
    if (src.hasDateWritten())
      tgt.setDateWrittenElement(DateTime43_50.convertDateTime(src.getDateWrittenElement()));
    if (src.hasPrescriber())
      tgt.setPrescriber(Reference43_50.convertReference(src.getPrescriber()));
    for (org.hl7.fhir.r4b.model.VisionPrescription.VisionPrescriptionLensSpecificationComponent t : src.getLensSpecification())
      tgt.addLensSpecification(convertVisionPrescriptionLensSpecificationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.VisionPrescription convertVisionPrescription(org.hl7.fhir.r5.model.VisionPrescription src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.VisionPrescription tgt = new org.hl7.fhir.r4b.model.VisionPrescription();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertVisionStatus(src.getStatusElement()));
    if (src.hasCreated())
      tgt.setCreatedElement(DateTime43_50.convertDateTime(src.getCreatedElement()));
    if (src.hasPatient())
      tgt.setPatient(Reference43_50.convertReference(src.getPatient()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference43_50.convertReference(src.getEncounter()));
    if (src.hasDateWritten())
      tgt.setDateWrittenElement(DateTime43_50.convertDateTime(src.getDateWrittenElement()));
    if (src.hasPrescriber())
      tgt.setPrescriber(Reference43_50.convertReference(src.getPrescriber()));
    for (org.hl7.fhir.r5.model.VisionPrescription.VisionPrescriptionLensSpecificationComponent t : src.getLensSpecification())
      tgt.addLensSpecification(convertVisionPrescriptionLensSpecificationComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes> convertVisionStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodes> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodesEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes.ACTIVE);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes.CANCELLED);
        break;
      case DRAFT:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes.DRAFT);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodes> convertVisionStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodes> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodesEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodes.ACTIVE);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodes.CANCELLED);
        break;
      case DRAFT:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodes.DRAFT);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodes.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodes.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.VisionPrescription.VisionPrescriptionLensSpecificationComponent convertVisionPrescriptionLensSpecificationComponent(org.hl7.fhir.r4b.model.VisionPrescription.VisionPrescriptionLensSpecificationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.VisionPrescription.VisionPrescriptionLensSpecificationComponent tgt = new org.hl7.fhir.r5.model.VisionPrescription.VisionPrescriptionLensSpecificationComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasProduct())
      tgt.setProduct(CodeableConcept43_50.convertCodeableConcept(src.getProduct()));
    if (src.hasEye())
      tgt.setEyeElement(convertVisionEyes(src.getEyeElement()));
    if (src.hasSphere())
      tgt.setSphereElement(Decimal43_50.convertDecimal(src.getSphereElement()));
    if (src.hasCylinder())
      tgt.setCylinderElement(Decimal43_50.convertDecimal(src.getCylinderElement()));
    if (src.hasAxis())
      tgt.setAxisElement(Integer43_50.convertInteger(src.getAxisElement()));
    for (org.hl7.fhir.r4b.model.VisionPrescription.PrismComponent t : src.getPrism())
      tgt.addPrism(convertPrismComponent(t));
    if (src.hasAdd())
      tgt.setAddElement(Decimal43_50.convertDecimal(src.getAddElement()));
    if (src.hasPower())
      tgt.setPowerElement(Decimal43_50.convertDecimal(src.getPowerElement()));
    if (src.hasBackCurve())
      tgt.setBackCurveElement(Decimal43_50.convertDecimal(src.getBackCurveElement()));
    if (src.hasDiameter())
      tgt.setDiameterElement(Decimal43_50.convertDecimal(src.getDiameterElement()));
    if (src.hasDuration())
      tgt.setDuration(SimpleQuantity43_50.convertSimpleQuantity(src.getDuration()));
    if (src.hasColor())
      tgt.setColorElement(String43_50.convertString(src.getColorElement()));
    if (src.hasBrand())
      tgt.setBrandElement(String43_50.convertString(src.getBrandElement()));
    for (org.hl7.fhir.r4b.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_50.convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.VisionPrescription.VisionPrescriptionLensSpecificationComponent convertVisionPrescriptionLensSpecificationComponent(org.hl7.fhir.r5.model.VisionPrescription.VisionPrescriptionLensSpecificationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.VisionPrescription.VisionPrescriptionLensSpecificationComponent tgt = new org.hl7.fhir.r4b.model.VisionPrescription.VisionPrescriptionLensSpecificationComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasProduct())
      tgt.setProduct(CodeableConcept43_50.convertCodeableConcept(src.getProduct()));
    if (src.hasEye())
      tgt.setEyeElement(convertVisionEyes(src.getEyeElement()));
    if (src.hasSphere())
      tgt.setSphereElement(Decimal43_50.convertDecimal(src.getSphereElement()));
    if (src.hasCylinder())
      tgt.setCylinderElement(Decimal43_50.convertDecimal(src.getCylinderElement()));
    if (src.hasAxis())
      tgt.setAxisElement(Integer43_50.convertInteger(src.getAxisElement()));
    for (org.hl7.fhir.r5.model.VisionPrescription.PrismComponent t : src.getPrism())
      tgt.addPrism(convertPrismComponent(t));
    if (src.hasAdd())
      tgt.setAddElement(Decimal43_50.convertDecimal(src.getAddElement()));
    if (src.hasPower())
      tgt.setPowerElement(Decimal43_50.convertDecimal(src.getPowerElement()));
    if (src.hasBackCurve())
      tgt.setBackCurveElement(Decimal43_50.convertDecimal(src.getBackCurveElement()));
    if (src.hasDiameter())
      tgt.setDiameterElement(Decimal43_50.convertDecimal(src.getDiameterElement()));
    if (src.hasDuration())
      tgt.setDuration(SimpleQuantity43_50.convertSimpleQuantity(src.getDuration()));
    if (src.hasColor())
      tgt.setColorElement(String43_50.convertString(src.getColorElement()));
    if (src.hasBrand())
      tgt.setBrandElement(String43_50.convertString(src.getBrandElement()));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_50.convertAnnotation(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.VisionPrescription.VisionEyes> convertVisionEyes(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.VisionPrescription.VisionEyes> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.VisionPrescription.VisionEyes> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.VisionPrescription.VisionEyesEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case RIGHT:
        tgt.setValue(org.hl7.fhir.r5.model.VisionPrescription.VisionEyes.RIGHT);
        break;
      case LEFT:
        tgt.setValue(org.hl7.fhir.r5.model.VisionPrescription.VisionEyes.LEFT);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.VisionPrescription.VisionEyes.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.VisionPrescription.VisionEyes> convertVisionEyes(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.VisionPrescription.VisionEyes> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.VisionPrescription.VisionEyes> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.VisionPrescription.VisionEyesEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case RIGHT:
        tgt.setValue(org.hl7.fhir.r4b.model.VisionPrescription.VisionEyes.RIGHT);
        break;
      case LEFT:
        tgt.setValue(org.hl7.fhir.r4b.model.VisionPrescription.VisionEyes.LEFT);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.VisionPrescription.VisionEyes.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.VisionPrescription.PrismComponent convertPrismComponent(org.hl7.fhir.r4b.model.VisionPrescription.PrismComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.VisionPrescription.PrismComponent tgt = new org.hl7.fhir.r5.model.VisionPrescription.PrismComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasAmount())
      tgt.setAmountElement(Decimal43_50.convertDecimal(src.getAmountElement()));
    if (src.hasBase())
      tgt.setBaseElement(convertVisionBase(src.getBaseElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.VisionPrescription.PrismComponent convertPrismComponent(org.hl7.fhir.r5.model.VisionPrescription.PrismComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.VisionPrescription.PrismComponent tgt = new org.hl7.fhir.r4b.model.VisionPrescription.PrismComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasAmount())
      tgt.setAmountElement(Decimal43_50.convertDecimal(src.getAmountElement()));
    if (src.hasBase())
      tgt.setBaseElement(convertVisionBase(src.getBaseElement()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.VisionPrescription.VisionBase> convertVisionBase(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.VisionPrescription.VisionBase> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.VisionPrescription.VisionBase> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.VisionPrescription.VisionBaseEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case UP:
        tgt.setValue(org.hl7.fhir.r5.model.VisionPrescription.VisionBase.UP);
        break;
      case DOWN:
        tgt.setValue(org.hl7.fhir.r5.model.VisionPrescription.VisionBase.DOWN);
        break;
      case IN:
        tgt.setValue(org.hl7.fhir.r5.model.VisionPrescription.VisionBase.IN);
        break;
      case OUT:
        tgt.setValue(org.hl7.fhir.r5.model.VisionPrescription.VisionBase.OUT);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.VisionPrescription.VisionBase.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.VisionPrescription.VisionBase> convertVisionBase(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.VisionPrescription.VisionBase> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.VisionPrescription.VisionBase> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.VisionPrescription.VisionBaseEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case UP:
        tgt.setValue(org.hl7.fhir.r4b.model.VisionPrescription.VisionBase.UP);
        break;
      case DOWN:
        tgt.setValue(org.hl7.fhir.r4b.model.VisionPrescription.VisionBase.DOWN);
        break;
      case IN:
        tgt.setValue(org.hl7.fhir.r4b.model.VisionPrescription.VisionBase.IN);
        break;
      case OUT:
        tgt.setValue(org.hl7.fhir.r4b.model.VisionPrescription.VisionBase.OUT);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.VisionPrescription.VisionBase.NULL);
        break;
    }
    return tgt;
  }
}