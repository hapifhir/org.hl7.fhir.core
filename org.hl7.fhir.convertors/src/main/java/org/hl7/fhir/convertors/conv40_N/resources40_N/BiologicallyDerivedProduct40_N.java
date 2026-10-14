package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
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

public class BiologicallyDerivedProduct40_N {

  public static org.hl7.fhir.model.core.BiologicallyDerivedProduct convertBiologicallyDerivedProduct(org.hl7.fhir.r4.model.BiologicallyDerivedProduct src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.BiologicallyDerivedProduct tgt = new org.hl7.fhir.model.core.BiologicallyDerivedProduct();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
//    if (src.hasProductCategory())
//      tgt.setProductCategoryElement(convertBiologicallyDerivedProductCategory(src.getProductCategoryElement()));
//    if (src.hasProductCode())
//      tgt.setProductCode(CodeableConcept40_N.convertCodeableConcept(src.getProductCode()));
//    if (src.hasStatus())
//      tgt.setStatusElement(convertBiologicallyDerivedProductStatus(src.getStatusElement()));
    for (org.hl7.fhir.r4.model.Reference t : src.getRequest()) tgt.addRequest(Reference40_N.convertReference(t));
//    if (src.hasQuantity())
//      tgt.setQuantityElement(Integer40_N.convertInteger(src.getQuantityElement()));
    for (org.hl7.fhir.r4.model.Reference t : src.getParent()) tgt.addParent(Reference40_N.convertReference(t));
    if (src.hasCollection())
      tgt.setCollection(convertBiologicallyDerivedProductCollectionComponent(src.getCollection()));
//    for (org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductProcessingComponent t : src.getProcessing())
//      tgt.addProcessing(convertBiologicallyDerivedProductProcessingComponent(t));
//    if (src.hasManipulation())
//      tgt.setManipulation(convertBiologicallyDerivedProductManipulationComponent(src.getManipulation()));
//    for (org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageComponent t : src.getStorage())
//      tgt.addStorage(convertBiologicallyDerivedProductStorageComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.BiologicallyDerivedProduct convertBiologicallyDerivedProduct(org.hl7.fhir.model.core.BiologicallyDerivedProduct src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.BiologicallyDerivedProduct tgt = new org.hl7.fhir.r4.model.BiologicallyDerivedProduct();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
//    if (src.hasProductCategory())
//      tgt.setProductCategoryElement(convertBiologicallyDerivedProductCategory(src.getProductCategoryElement()));
//    if (src.hasProductCode())
//      tgt.setProductCode(CodeableConcept40_N.convertCodeableConcept(src.getProductCode()));
//    if (src.hasStatus())
//      tgt.setStatusElement(convertBiologicallyDerivedProductStatus(src.getStatusElement()));
    for (org.hl7.fhir.model.core.Reference t : src.getRequestList()) tgt.addRequest(Reference40_N.convertReference(t));
//    if (src.hasQuantity())
//      tgt.setQuantityElement(Integer40_N.convertInteger(src.getQuantityElement()));
    for (org.hl7.fhir.model.core.Reference t : src.getParentList()) tgt.addParent(Reference40_N.convertReference(t));
    if (src.hasCollection())
      tgt.setCollection(convertBiologicallyDerivedProductCollectionComponent(src.getCollection()));
//    for (org.hl7.fhir.model.core.BiologicallyDerivedProduct.BiologicallyDerivedProductProcessingComponent t : src.getProcessingList())
//      tgt.addProcessing(convertBiologicallyDerivedProductProcessingComponent(t));
//    if (src.hasManipulation())
//      tgt.setManipulation(convertBiologicallyDerivedProductManipulationComponent(src.getManipulation()));
//    for (org.hl7.fhir.model.core.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageComponent t : src.getStorageList())
//      tgt.addStorage(convertBiologicallyDerivedProductStorageComponent(t));
    return tgt;
  }
//
//  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.BiologicallyDerivedProduct.BiologicallyDerivedProductCategory> convertBiologicallyDerivedProductCategory(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCategory> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.BiologicallyDerivedProduct.BiologicallyDerivedProductCategory> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.BiologicallyDerivedProduct.BiologicallyDerivedProductCategoryEnumFactory());
//    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
//    switch (src.getValue()) {
//      case ORGAN:
//        tgt.setValue(org.hl7.fhir.model.core.BiologicallyDerivedProduct.BiologicallyDerivedProductCategory.ORGAN);
//        break;
//      case TISSUE:
//        tgt.setValue(org.hl7.fhir.model.core.BiologicallyDerivedProduct.BiologicallyDerivedProductCategory.TISSUE);
//        break;
//      case FLUID:
//        tgt.setValue(org.hl7.fhir.model.core.BiologicallyDerivedProduct.BiologicallyDerivedProductCategory.FLUID);
//        break;
//      case CELLS:
//        tgt.setValue(org.hl7.fhir.model.core.BiologicallyDerivedProduct.BiologicallyDerivedProductCategory.CELLS);
//        break;
//      case BIOLOGICALAGENT:
//        tgt.setValue(org.hl7.fhir.model.core.BiologicallyDerivedProduct.BiologicallyDerivedProductCategory.BIOLOGICALAGENT);
//        break;
//      default:
//        tgt.setValue(org.hl7.fhir.model.core.BiologicallyDerivedProduct.BiologicallyDerivedProductCategory.NULL);
//        break;
//    }
//    return tgt;
//  }
//
//  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCategory> convertBiologicallyDerivedProductCategory(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.BiologicallyDerivedProduct.BiologicallyDerivedProductCategory> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCategory> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCategoryEnumFactory());
//    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
//    switch (src.getValue()) {
//      case ORGAN:
//        tgt.setValue(org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCategory.ORGAN);
//        break;
//      case TISSUE:
//        tgt.setValue(org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCategory.TISSUE);
//        break;
//      case FLUID:
//        tgt.setValue(org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCategory.FLUID);
//        break;
//      case CELLS:
//        tgt.setValue(org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCategory.CELLS);
//        break;
//      case BIOLOGICALAGENT:
//        tgt.setValue(org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCategory.BIOLOGICALAGENT);
//        break;
//      default:
//        tgt.setValue(org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCategory.NULL);
//        break;
//    }
//    return tgt;
//  }
//
//  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.BiologicallyDerivedProduct.BiologicallyDerivedProductStatus> convertBiologicallyDerivedProductStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStatus> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.BiologicallyDerivedProduct.BiologicallyDerivedProductStatus> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.BiologicallyDerivedProduct.BiologicallyDerivedProductStatusEnumFactory());
//    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
//    switch (src.getValue()) {
//      case AVAILABLE:
//        tgt.setValue(org.hl7.fhir.model.core.BiologicallyDerivedProduct.BiologicallyDerivedProductStatus.AVAILABLE);
//        break;
//      case UNAVAILABLE:
//        tgt.setValue(org.hl7.fhir.model.core.BiologicallyDerivedProduct.BiologicallyDerivedProductStatus.UNAVAILABLE);
//        break;
//      default:
//        tgt.setValue(org.hl7.fhir.model.core.BiologicallyDerivedProduct.BiologicallyDerivedProductStatus.NULL);
//        break;
//    }
//    return tgt;
//  }
//
//  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStatus> convertBiologicallyDerivedProductStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.BiologicallyDerivedProduct.BiologicallyDerivedProductStatus> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStatusEnumFactory());
//    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
//    switch (src.getValue()) {
//      case AVAILABLE:
//        tgt.setValue(org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStatus.AVAILABLE);
//        break;
//      case UNAVAILABLE:
//        tgt.setValue(org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStatus.UNAVAILABLE);
//        break;
//      default:
//        tgt.setValue(org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStatus.NULL);
//        break;
//    }
//    return tgt;
//  }

  public static org.hl7.fhir.model.core.BiologicallyDerivedProduct.BiologicallyDerivedProductCollectionComponent convertBiologicallyDerivedProductCollectionComponent(org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCollectionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.BiologicallyDerivedProduct.BiologicallyDerivedProductCollectionComponent tgt = new org.hl7.fhir.model.core.BiologicallyDerivedProduct.BiologicallyDerivedProductCollectionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasCollector())
      tgt.setCollector(Reference40_N.convertReference(src.getCollector()));
    if (src.hasSource())
      tgt.setSourcePatient(Reference40_N.convertReference(src.getSource()));
    if (src.hasCollected())
      tgt.setCollected(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getCollected()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCollectionComponent convertBiologicallyDerivedProductCollectionComponent(org.hl7.fhir.model.core.BiologicallyDerivedProduct.BiologicallyDerivedProductCollectionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCollectionComponent tgt = new org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCollectionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasCollector())
      tgt.setCollector(Reference40_N.convertReference(src.getCollector()));
    if (src.hasSourcePatient())
      tgt.setSource(Reference40_N.convertReference(src.getSourcePatient()));
    if (src.hasCollected())
      tgt.setCollected(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getCollected()));
    return tgt;
  }

//  public static org.hl7.fhir.model.core.BiologicallyDerivedProduct.BiologicallyDerivedProductProcessingComponent convertBiologicallyDerivedProductProcessingComponent(org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductProcessingComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.model.core.BiologicallyDerivedProduct.BiologicallyDerivedProductProcessingComponent tgt = new org.hl7.fhir.model.core.BiologicallyDerivedProduct.BiologicallyDerivedProductProcessingComponent();
//    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
//    if (src.hasDescription())
//      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
//    if (src.hasProcedure())
//      tgt.setProcedure(CodeableConcept40_N.convertCodeableConcept(src.getProcedure()));
//    if (src.hasAdditive())
//      tgt.setAdditive(Reference40_N.convertReference(src.getAdditive()));
//    if (src.hasTime())
//      tgt.setTime(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getTime()));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductProcessingComponent convertBiologicallyDerivedProductProcessingComponent(org.hl7.fhir.model.core.BiologicallyDerivedProduct.BiologicallyDerivedProductProcessingComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductProcessingComponent tgt = new org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductProcessingComponent();
//    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
//    if (src.hasDescription())
//      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
//    if (src.hasProcedure())
//      tgt.setProcedure(CodeableConcept40_N.convertCodeableConcept(src.getProcedure()));
//    if (src.hasAdditive())
//      tgt.setAdditive(Reference40_N.convertReference(src.getAdditive()));
//    if (src.hasTime())
//      tgt.setTime(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getTime()));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.model.core.BiologicallyDerivedProduct.BiologicallyDerivedProductManipulationComponent convertBiologicallyDerivedProductManipulationComponent(org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductManipulationComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.model.core.BiologicallyDerivedProduct.BiologicallyDerivedProductManipulationComponent tgt = new org.hl7.fhir.model.core.BiologicallyDerivedProduct.BiologicallyDerivedProductManipulationComponent();
//    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
//    if (src.hasDescription())
//      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
//    if (src.hasTime())
//      tgt.setTime(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getTime()));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductManipulationComponent convertBiologicallyDerivedProductManipulationComponent(org.hl7.fhir.model.core.BiologicallyDerivedProduct.BiologicallyDerivedProductManipulationComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductManipulationComponent tgt = new org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductManipulationComponent();
//    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
//    if (src.hasDescription())
//      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
//    if (src.hasTime())
//      tgt.setTime(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getTime()));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.model.core.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageComponent convertBiologicallyDerivedProductStorageComponent(org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.model.core.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageComponent tgt = new org.hl7.fhir.model.core.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageComponent();
//    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
//    if (src.hasDescription())
//      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
//    if (src.hasTemperature())
//      tgt.setTemperatureElement(Decimal40_N.convertDecimal(src.getTemperatureElement()));
//    if (src.hasScale())
//      tgt.setScaleElement(convertBiologicallyDerivedProductStorageScale(src.getScaleElement()));
//    if (src.hasDuration())
//      tgt.setDuration(Period40_N.convertPeriod(src.getDuration()));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageComponent convertBiologicallyDerivedProductStorageComponent(org.hl7.fhir.model.core.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageComponent tgt = new org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageComponent();
//    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
//    if (src.hasDescription())
//      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
//    if (src.hasTemperature())
//      tgt.setTemperatureElement(Decimal40_N.convertDecimal(src.getTemperatureElement()));
//    if (src.hasScale())
//      tgt.setScaleElement(convertBiologicallyDerivedProductStorageScale(src.getScaleElement()));
//    if (src.hasDuration())
//      tgt.setDuration(Period40_N.convertPeriod(src.getDuration()));
//    return tgt;
//  }
//
//  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageScale> convertBiologicallyDerivedProductStorageScale(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageScale> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageScale> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageScaleEnumFactory());
//    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
//    switch (src.getValue()) {
//      case FARENHEIT:
//        tgt.setValue(org.hl7.fhir.model.core.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageScale.FARENHEIT);
//        break;
//      case CELSIUS:
//        tgt.setValue(org.hl7.fhir.model.core.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageScale.CELSIUS);
//        break;
//      case KELVIN:
//        tgt.setValue(org.hl7.fhir.model.core.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageScale.KELVIN);
//        break;
//      default:
//        tgt.setValue(org.hl7.fhir.model.core.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageScale.NULL);
//        break;
//    }
//    return tgt;
//  }
//
//  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageScale> convertBiologicallyDerivedProductStorageScale(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageScale> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageScale> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageScaleEnumFactory());
//    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
//    switch (src.getValue()) {
//      case FARENHEIT:
//        tgt.setValue(org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageScale.FARENHEIT);
//        break;
//      case CELSIUS:
//        tgt.setValue(org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageScale.CELSIUS);
//        break;
//      case KELVIN:
//        tgt.setValue(org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageScale.KELVIN);
//        break;
//      default:
//        tgt.setValue(org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageScale.NULL);
//        break;
//    }
//    return tgt;
//  }
}
