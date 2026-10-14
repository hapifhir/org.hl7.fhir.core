package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Annotation40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.SimpleQuantity40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.DateTime40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Decimal40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Integer40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.VisionPrescription;
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

public class VisionPrescription40_N {

  public static org.hl7.fhir.model.core.VisionPrescription convertVisionPrescription(org.hl7.fhir.r4.model.VisionPrescription src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.VisionPrescription tgt = new org.hl7.fhir.model.core.VisionPrescription();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertVisionStatus(src.getStatusElement()));
    if (src.hasCreated())
      tgt.setCreatedElement(DateTime40_N.convertDateTime(src.getCreatedElement()));
    if (src.hasPatient())
      tgt.setPatient(Reference40_N.convertReference(src.getPatient()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_N.convertReference(src.getEncounter()));
    if (src.hasDateWritten())
      tgt.setDateWrittenElement(DateTime40_N.convertDateTime(src.getDateWrittenElement()));
    if (src.hasPrescriber())
      tgt.setPrescriber(Reference40_N.convertReference(src.getPrescriber()));
    for (org.hl7.fhir.r4.model.VisionPrescription.VisionPrescriptionLensSpecificationComponent t : src.getLensSpecification())
      tgt.addLensSpecification(convertVisionPrescriptionLensSpecificationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.VisionPrescription convertVisionPrescription(org.hl7.fhir.model.core.VisionPrescription src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.VisionPrescription tgt = new org.hl7.fhir.r4.model.VisionPrescription();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertVisionStatus(src.getStatusElement()));
    if (src.hasCreated())
      tgt.setCreatedElement(DateTime40_N.convertDateTime(src.getCreatedElement()));
    if (src.hasPatient())
      tgt.setPatient(Reference40_N.convertReference(src.getPatient()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_N.convertReference(src.getEncounter()));
    if (src.hasDateWritten())
      tgt.setDateWrittenElement(DateTime40_N.convertDateTime(src.getDateWrittenElement()));
    if (src.hasPrescriber())
      tgt.setPrescriber(Reference40_N.convertReference(src.getPrescriber()));
    for (org.hl7.fhir.model.core.VisionPrescription.VisionPrescriptionLensSpecificationComponent t : src.getLensSpecificationList())
      tgt.addLensSpecification(convertVisionPrescriptionLensSpecificationComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.FinancialResourceStatusCodes> convertVisionStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.VisionPrescription.VisionStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.FinancialResourceStatusCodes> tgt = new Enumeration<>(new Enumerations.FinancialResourceStatusCodesEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.VisionPrescription.VisionStatus> convertVisionStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.FinancialResourceStatusCodes> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<VisionPrescription.VisionStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new VisionPrescription.VisionStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ACTIVE:
                  tgt.setValue(VisionPrescription.VisionStatus.ACTIVE);
                  break;
              case CANCELLED:
                  tgt.setValue(VisionPrescription.VisionStatus.CANCELLED);
                  break;
              case DRAFT:
                  tgt.setValue(VisionPrescription.VisionStatus.DRAFT);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(VisionPrescription.VisionStatus.ENTEREDINERROR);
                  break;
              default:
                  tgt.setValue(VisionPrescription.VisionStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.VisionPrescription.VisionPrescriptionLensSpecificationComponent convertVisionPrescriptionLensSpecificationComponent(org.hl7.fhir.r4.model.VisionPrescription.VisionPrescriptionLensSpecificationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.VisionPrescription.VisionPrescriptionLensSpecificationComponent tgt = new org.hl7.fhir.model.core.VisionPrescription.VisionPrescriptionLensSpecificationComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasProduct())
      tgt.setProduct(CodeableConcept40_N.convertCodeableConcept(src.getProduct()));
    if (src.hasEye())
      tgt.setEyeElement(convertVisionEyes(src.getEyeElement()));
    if (src.hasSphere())
      tgt.setSphereElement(Decimal40_N.convertDecimal(src.getSphereElement()));
    if (src.hasCylinder())
      tgt.setCylinderElement(Decimal40_N.convertDecimal(src.getCylinderElement()));
    if (src.hasAxis())
      tgt.setAxisElement(Integer40_N.convertInteger(src.getAxisElement()));
    for (org.hl7.fhir.r4.model.VisionPrescription.PrismComponent t : src.getPrism())
      tgt.addPrism(convertPrismComponent(t));
    if (src.hasAdd())
      tgt.setAddElement(Decimal40_N.convertDecimal(src.getAddElement()));
    if (src.hasPower())
      tgt.setPowerElement(Decimal40_N.convertDecimal(src.getPowerElement()));
    if (src.hasBackCurve())
      tgt.setBackCurveElement(Decimal40_N.convertDecimal(src.getBackCurveElement()));
    if (src.hasDiameter())
      tgt.setDiameterElement(Decimal40_N.convertDecimal(src.getDiameterElement()));
    if (src.hasDuration())
      tgt.setDuration(SimpleQuantity40_N.convertSimpleQuantity(src.getDuration()));
    if (src.hasColor())
      tgt.setColorElement(String40_N.convertString(src.getColorElement()));
    if (src.hasBrand())
      tgt.setBrandElement(String40_N.convertString(src.getBrandElement()));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(Annotation40_N.convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.VisionPrescription.VisionPrescriptionLensSpecificationComponent convertVisionPrescriptionLensSpecificationComponent(org.hl7.fhir.model.core.VisionPrescription.VisionPrescriptionLensSpecificationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.VisionPrescription.VisionPrescriptionLensSpecificationComponent tgt = new org.hl7.fhir.r4.model.VisionPrescription.VisionPrescriptionLensSpecificationComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasProduct())
      tgt.setProduct(CodeableConcept40_N.convertCodeableConcept(src.getProduct()));
    if (src.hasEye())
      tgt.setEyeElement(convertVisionEyes(src.getEyeElement()));
    if (src.hasSphere())
      tgt.setSphereElement(Decimal40_N.convertDecimal(src.getSphereElement()));
    if (src.hasCylinder())
      tgt.setCylinderElement(Decimal40_N.convertDecimal(src.getCylinderElement()));
    if (src.hasAxis())
      tgt.setAxisElement(Integer40_N.convertInteger(src.getAxisElement()));
    for (org.hl7.fhir.model.core.VisionPrescription.PrismComponent t : src.getPrismList())
      tgt.addPrism(convertPrismComponent(t));
    if (src.hasAdd())
      tgt.setAddElement(Decimal40_N.convertDecimal(src.getAddElement()));
    if (src.hasPower())
      tgt.setPowerElement(Decimal40_N.convertDecimal(src.getPowerElement()));
    if (src.hasBackCurve())
      tgt.setBackCurveElement(Decimal40_N.convertDecimal(src.getBackCurveElement()));
    if (src.hasDiameter())
      tgt.setDiameterElement(Decimal40_N.convertDecimal(src.getDiameterElement()));
    if (src.hasDuration())
      tgt.setDuration(SimpleQuantity40_N.convertSimpleQuantity(src.getDuration()));
    if (src.hasColor())
      tgt.setColorElement(String40_N.convertString(src.getColorElement()));
    if (src.hasBrand())
      tgt.setBrandElement(String40_N.convertString(src.getBrandElement()));
    for (org.hl7.fhir.model.core.Annotation t : src.getNoteList()) tgt.addNote(Annotation40_N.convertAnnotation(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.VisionPrescription.VisionEyes> convertVisionEyes(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.VisionPrescription.VisionEyes> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<org.hl7.fhir.model.core.VisionPrescription.VisionEyes> tgt = new Enumeration<>(new org.hl7.fhir.model.core.VisionPrescription.VisionEyesEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.VisionPrescription.VisionEyes> convertVisionEyes(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.VisionPrescription.VisionEyes> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<VisionPrescription.VisionEyes> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new VisionPrescription.VisionEyesEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
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

  public static org.hl7.fhir.model.core.VisionPrescription.PrismComponent convertPrismComponent(org.hl7.fhir.r4.model.VisionPrescription.PrismComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.VisionPrescription.PrismComponent tgt = new org.hl7.fhir.model.core.VisionPrescription.PrismComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasAmount())
      tgt.setAmountElement(Decimal40_N.convertDecimal(src.getAmountElement()));
    if (src.hasBase())
      tgt.setBaseElement(convertVisionBase(src.getBaseElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.VisionPrescription.PrismComponent convertPrismComponent(org.hl7.fhir.model.core.VisionPrescription.PrismComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.VisionPrescription.PrismComponent tgt = new org.hl7.fhir.r4.model.VisionPrescription.PrismComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasAmount())
      tgt.setAmountElement(Decimal40_N.convertDecimal(src.getAmountElement()));
    if (src.hasBase())
      tgt.setBaseElement(convertVisionBase(src.getBaseElement()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.VisionPrescription.VisionBase> convertVisionBase(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.VisionPrescription.VisionBase> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<org.hl7.fhir.model.core.VisionPrescription.VisionBase> tgt = new Enumeration<>(new org.hl7.fhir.model.core.VisionPrescription.VisionBaseEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.VisionPrescription.VisionBase> convertVisionBase(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.VisionPrescription.VisionBase> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<VisionPrescription.VisionBase> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new VisionPrescription.VisionBaseEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
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