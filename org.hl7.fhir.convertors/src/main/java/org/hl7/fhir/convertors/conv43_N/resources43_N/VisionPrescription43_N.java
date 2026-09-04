package org.hl7.fhir.convertors.conv43_N.resources43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Annotation43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.CodeableConcept43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Identifier43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.SimpleQuantity43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.DateTime43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Decimal43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Integer43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Reference43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4b.model.VisionPrescription;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.Enumerations;

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

public class VisionPrescription43_N {

  public static org.hl7.fhir.model.core.VisionPrescription convertVisionPrescription(org.hl7.fhir.r4b.model.VisionPrescription src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.VisionPrescription tgt = new org.hl7.fhir.model.core.VisionPrescription();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertVisionStatus(src.getStatusElement()));
    if (src.hasCreated())
      tgt.setCreatedElement(DateTime43_N.convertDateTime(src.getCreatedElement()));
    if (src.hasPatient())
      tgt.setPatient(Reference43_N.convertReference(src.getPatient()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference43_N.convertReference(src.getEncounter()));
    if (src.hasDateWritten())
      tgt.setDateWrittenElement(DateTime43_N.convertDateTime(src.getDateWrittenElement()));
    if (src.hasPrescriber())
      tgt.setPrescriber(Reference43_N.convertReference(src.getPrescriber()));
    for (org.hl7.fhir.r4b.model.VisionPrescription.VisionPrescriptionLensSpecificationComponent t : src.getLensSpecification())
      tgt.addLensSpecification(convertVisionPrescriptionLensSpecificationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.VisionPrescription convertVisionPrescription(org.hl7.fhir.model.core.VisionPrescription src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.VisionPrescription tgt = new org.hl7.fhir.r4b.model.VisionPrescription();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertVisionStatus(src.getStatusElement()));
    if (src.hasCreated())
      tgt.setCreatedElement(DateTime43_N.convertDateTime(src.getCreatedElement()));
    if (src.hasPatient())
      tgt.setPatient(Reference43_N.convertReference(src.getPatient()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference43_N.convertReference(src.getEncounter()));
    if (src.hasDateWritten())
      tgt.setDateWrittenElement(DateTime43_N.convertDateTime(src.getDateWrittenElement()));
    if (src.hasPrescriber())
      tgt.setPrescriber(Reference43_N.convertReference(src.getPrescriber()));
    for (org.hl7.fhir.model.core.VisionPrescription.VisionPrescriptionLensSpecificationComponent t : src.getLensSpecificationList())
      tgt.addLensSpecification(convertVisionPrescriptionLensSpecificationComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.FinancialResourceStatusCodes> convertVisionStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodes> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.FinancialResourceStatusCodes> tgt = new Enumeration<>(new Enumerations.FinancialResourceStatusCodesEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ACTIVE:
                  tgt.setValue(Enumerations.FinancialResourceStatusCodes.ACTIVE);
                  break;
              case CANCELLED:
                  tgt.setValue(Enumerations.FinancialResourceStatusCodes.CANCELLED);
                  break;
              case DRAFT:
                  tgt.setValue(Enumerations.FinancialResourceStatusCodes.DRAFT);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(Enumerations.FinancialResourceStatusCodes.ENTEREDINERROR);
                  break;
              default:
                  tgt.setValue(Enumerations.FinancialResourceStatusCodes.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodes> convertVisionStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.FinancialResourceStatusCodes> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodes> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodesEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.VisionPrescription.VisionPrescriptionLensSpecificationComponent convertVisionPrescriptionLensSpecificationComponent(org.hl7.fhir.r4b.model.VisionPrescription.VisionPrescriptionLensSpecificationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.VisionPrescription.VisionPrescriptionLensSpecificationComponent tgt = new org.hl7.fhir.model.core.VisionPrescription.VisionPrescriptionLensSpecificationComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasProduct())
      tgt.setProduct(CodeableConcept43_N.convertCodeableConcept(src.getProduct()));
    if (src.hasEye())
      tgt.setEyeElement(convertVisionEyes(src.getEyeElement()));
    if (src.hasSphere())
      tgt.setSphereElement(Decimal43_N.convertDecimal(src.getSphereElement()));
    if (src.hasCylinder())
      tgt.setCylinderElement(Decimal43_N.convertDecimal(src.getCylinderElement()));
    if (src.hasAxis())
      tgt.setAxisElement(Integer43_N.convertInteger(src.getAxisElement()));
    for (org.hl7.fhir.r4b.model.VisionPrescription.PrismComponent t : src.getPrism())
      tgt.addPrism(convertPrismComponent(t));
    if (src.hasAdd())
      tgt.setAddElement(Decimal43_N.convertDecimal(src.getAddElement()));
    if (src.hasPower())
      tgt.setPowerElement(Decimal43_N.convertDecimal(src.getPowerElement()));
    if (src.hasBackCurve())
      tgt.setBackCurveElement(Decimal43_N.convertDecimal(src.getBackCurveElement()));
    if (src.hasDiameter())
      tgt.setDiameterElement(Decimal43_N.convertDecimal(src.getDiameterElement()));
    if (src.hasDuration())
      tgt.setDuration(SimpleQuantity43_N.convertSimpleQuantity(src.getDuration()));
    if (src.hasColor())
      tgt.setColorElement(String43_N.convertString(src.getColorElement()));
    if (src.hasBrand())
      tgt.setBrandElement(String43_N.convertString(src.getBrandElement()));
    for (org.hl7.fhir.r4b.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_N.convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.VisionPrescription.VisionPrescriptionLensSpecificationComponent convertVisionPrescriptionLensSpecificationComponent(org.hl7.fhir.model.core.VisionPrescription.VisionPrescriptionLensSpecificationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.VisionPrescription.VisionPrescriptionLensSpecificationComponent tgt = new org.hl7.fhir.r4b.model.VisionPrescription.VisionPrescriptionLensSpecificationComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasProduct())
      tgt.setProduct(CodeableConcept43_N.convertCodeableConcept(src.getProduct()));
    if (src.hasEye())
      tgt.setEyeElement(convertVisionEyes(src.getEyeElement()));
    if (src.hasSphere())
      tgt.setSphereElement(Decimal43_N.convertDecimal(src.getSphereElement()));
    if (src.hasCylinder())
      tgt.setCylinderElement(Decimal43_N.convertDecimal(src.getCylinderElement()));
    if (src.hasAxis())
      tgt.setAxisElement(Integer43_N.convertInteger(src.getAxisElement()));
    for (org.hl7.fhir.model.core.VisionPrescription.PrismComponent t : src.getPrismList())
      tgt.addPrism(convertPrismComponent(t));
    if (src.hasAdd())
      tgt.setAddElement(Decimal43_N.convertDecimal(src.getAddElement()));
    if (src.hasPower())
      tgt.setPowerElement(Decimal43_N.convertDecimal(src.getPowerElement()));
    if (src.hasBackCurve())
      tgt.setBackCurveElement(Decimal43_N.convertDecimal(src.getBackCurveElement()));
    if (src.hasDiameter())
      tgt.setDiameterElement(Decimal43_N.convertDecimal(src.getDiameterElement()));
    if (src.hasDuration())
      tgt.setDuration(SimpleQuantity43_N.convertSimpleQuantity(src.getDuration()));
    if (src.hasColor())
      tgt.setColorElement(String43_N.convertString(src.getColorElement()));
    if (src.hasBrand())
      tgt.setBrandElement(String43_N.convertString(src.getBrandElement()));
    for (org.hl7.fhir.model.core.Annotation t : src.getNoteList()) tgt.addNote(Annotation43_N.convertAnnotation(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.VisionPrescription.VisionEyes> convertVisionEyes(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.VisionPrescription.VisionEyes> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<org.hl7.fhir.model.core.VisionPrescription.VisionEyes> tgt = new Enumeration<>(new org.hl7.fhir.model.core.VisionPrescription.VisionEyesEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case RIGHT:
                  tgt.setValue(org.hl7.fhir.model.core.VisionPrescription.VisionEyes.RIGHT);
                  break;
              case LEFT:
                  tgt.setValue(org.hl7.fhir.model.core.VisionPrescription.VisionEyes.LEFT);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.model.core.VisionPrescription.VisionEyes.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.VisionPrescription.VisionEyes> convertVisionEyes(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.VisionPrescription.VisionEyes> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<VisionPrescription.VisionEyes> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new VisionPrescription.VisionEyesEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case RIGHT:
                  tgt.setValue(VisionPrescription.VisionEyes.RIGHT);
                  break;
              case LEFT:
                  tgt.setValue(VisionPrescription.VisionEyes.LEFT);
                  break;
              default:
                  tgt.setValue(VisionPrescription.VisionEyes.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.VisionPrescription.PrismComponent convertPrismComponent(org.hl7.fhir.r4b.model.VisionPrescription.PrismComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.VisionPrescription.PrismComponent tgt = new org.hl7.fhir.model.core.VisionPrescription.PrismComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasAmount())
      tgt.setAmountElement(Decimal43_N.convertDecimal(src.getAmountElement()));
    if (src.hasBase())
      tgt.setBaseElement(convertVisionBase(src.getBaseElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.VisionPrescription.PrismComponent convertPrismComponent(org.hl7.fhir.model.core.VisionPrescription.PrismComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.VisionPrescription.PrismComponent tgt = new org.hl7.fhir.r4b.model.VisionPrescription.PrismComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasAmount())
      tgt.setAmountElement(Decimal43_N.convertDecimal(src.getAmountElement()));
    if (src.hasBase())
      tgt.setBaseElement(convertVisionBase(src.getBaseElement()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.VisionPrescription.VisionBase> convertVisionBase(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.VisionPrescription.VisionBase> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<org.hl7.fhir.model.core.VisionPrescription.VisionBase> tgt = new Enumeration<>(new org.hl7.fhir.model.core.VisionPrescription.VisionBaseEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case UP:
                  tgt.setValue(org.hl7.fhir.model.core.VisionPrescription.VisionBase.UP);
                  break;
              case DOWN:
                  tgt.setValue(org.hl7.fhir.model.core.VisionPrescription.VisionBase.DOWN);
                  break;
              case IN:
                  tgt.setValue(org.hl7.fhir.model.core.VisionPrescription.VisionBase.IN);
                  break;
              case OUT:
                  tgt.setValue(org.hl7.fhir.model.core.VisionPrescription.VisionBase.OUT);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.model.core.VisionPrescription.VisionBase.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.VisionPrescription.VisionBase> convertVisionBase(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.VisionPrescription.VisionBase> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<VisionPrescription.VisionBase> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new VisionPrescription.VisionBaseEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case UP:
                  tgt.setValue(VisionPrescription.VisionBase.UP);
                  break;
              case DOWN:
                  tgt.setValue(VisionPrescription.VisionBase.DOWN);
                  break;
              case IN:
                  tgt.setValue(VisionPrescription.VisionBase.IN);
                  break;
              case OUT:
                  tgt.setValue(VisionPrescription.VisionBase.OUT);
                  break;
              default:
                  tgt.setValue(VisionPrescription.VisionBase.NULL);
                  break;
          }
      }
      return tgt;
  }
}