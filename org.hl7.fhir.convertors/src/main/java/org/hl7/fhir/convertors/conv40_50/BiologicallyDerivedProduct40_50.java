package org.hl7.fhir.convertors.conv40_50;


import org.hl7.fhir.convertors.VersionConvertor_40_50;
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
public class BiologicallyDerivedProduct40_50 extends VersionConvertor_40_50 {

    public static org.hl7.fhir.r5.model.BiologicallyDerivedProduct convertBiologicallyDerivedProduct(org.hl7.fhir.r4.model.BiologicallyDerivedProduct src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.BiologicallyDerivedProduct tgt = new org.hl7.fhir.r5.model.BiologicallyDerivedProduct();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasProductCategory())
            tgt.setProductCategoryElement(convertBiologicallyDerivedProductCategory(src.getProductCategoryElement()));
        if (src.hasProductCode())
            tgt.setProductCode(convertCodeableConcept(src.getProductCode()));
        if (src.hasStatus())
            tgt.setStatusElement(convertBiologicallyDerivedProductStatus(src.getStatusElement()));
        for (org.hl7.fhir.r4.model.Reference t : src.getRequest()) tgt.addRequest(convertReference(t));
        if (src.hasQuantity())
            tgt.setQuantityElement(convertInteger(src.getQuantityElement()));
        for (org.hl7.fhir.r4.model.Reference t : src.getParent()) tgt.addParent(convertReference(t));
        if (src.hasCollection())
            tgt.setCollection(convertBiologicallyDerivedProductCollectionComponent(src.getCollection()));
        for (org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductProcessingComponent t : src.getProcessing()) tgt.addProcessing(convertBiologicallyDerivedProductProcessingComponent(t));
        if (src.hasManipulation())
            tgt.setManipulation(convertBiologicallyDerivedProductManipulationComponent(src.getManipulation()));
        for (org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageComponent t : src.getStorage()) tgt.addStorage(convertBiologicallyDerivedProductStorageComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.BiologicallyDerivedProduct convertBiologicallyDerivedProduct(org.hl7.fhir.r5.model.BiologicallyDerivedProduct src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.BiologicallyDerivedProduct tgt = new org.hl7.fhir.r4.model.BiologicallyDerivedProduct();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasProductCategory())
            tgt.setProductCategoryElement(convertBiologicallyDerivedProductCategory(src.getProductCategoryElement()));
        if (src.hasProductCode())
            tgt.setProductCode(convertCodeableConcept(src.getProductCode()));
        if (src.hasStatus())
            tgt.setStatusElement(convertBiologicallyDerivedProductStatus(src.getStatusElement()));
        for (org.hl7.fhir.r5.model.Reference t : src.getRequest()) tgt.addRequest(convertReference(t));
        if (src.hasQuantity())
            tgt.setQuantityElement(convertInteger(src.getQuantityElement()));
        for (org.hl7.fhir.r5.model.Reference t : src.getParent()) tgt.addParent(convertReference(t));
        if (src.hasCollection())
            tgt.setCollection(convertBiologicallyDerivedProductCollectionComponent(src.getCollection()));
        for (org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductProcessingComponent t : src.getProcessing()) tgt.addProcessing(convertBiologicallyDerivedProductProcessingComponent(t));
        if (src.hasManipulation())
            tgt.setManipulation(convertBiologicallyDerivedProductManipulationComponent(src.getManipulation()));
        for (org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageComponent t : src.getStorage()) tgt.addStorage(convertBiologicallyDerivedProductStorageComponent(t));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCategory> convertBiologicallyDerivedProductCategory(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCategory> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCategory> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCategoryEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case ORGAN:
                tgt.setValue(org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCategory.ORGAN);
                break;
            case TISSUE:
                tgt.setValue(org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCategory.TISSUE);
                break;
            case FLUID:
                tgt.setValue(org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCategory.FLUID);
                break;
            case CELLS:
                tgt.setValue(org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCategory.CELLS);
                break;
            case BIOLOGICALAGENT:
                tgt.setValue(org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCategory.BIOLOGICALAGENT);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCategory.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCategory> convertBiologicallyDerivedProductCategory(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCategory> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCategory> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCategoryEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case ORGAN:
                tgt.setValue(org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCategory.ORGAN);
                break;
            case TISSUE:
                tgt.setValue(org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCategory.TISSUE);
                break;
            case FLUID:
                tgt.setValue(org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCategory.FLUID);
                break;
            case CELLS:
                tgt.setValue(org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCategory.CELLS);
                break;
            case BIOLOGICALAGENT:
                tgt.setValue(org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCategory.BIOLOGICALAGENT);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCategory.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStatus> convertBiologicallyDerivedProductStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStatusEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case AVAILABLE:
                tgt.setValue(org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStatus.AVAILABLE);
                break;
            case UNAVAILABLE:
                tgt.setValue(org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStatus.UNAVAILABLE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStatus> convertBiologicallyDerivedProductStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStatusEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case AVAILABLE:
                tgt.setValue(org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStatus.AVAILABLE);
                break;
            case UNAVAILABLE:
                tgt.setValue(org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStatus.UNAVAILABLE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStatus.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCollectionComponent convertBiologicallyDerivedProductCollectionComponent(org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCollectionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCollectionComponent tgt = new org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCollectionComponent();
        copyElement(src, tgt);
        if (src.hasCollector())
            tgt.setCollector(convertReference(src.getCollector()));
        if (src.hasSource())
            tgt.setSource(convertReference(src.getSource()));
        if (src.hasCollected())
            tgt.setCollected(convertType(src.getCollected()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCollectionComponent convertBiologicallyDerivedProductCollectionComponent(org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCollectionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCollectionComponent tgt = new org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductCollectionComponent();
        copyElement(src, tgt);
        if (src.hasCollector())
            tgt.setCollector(convertReference(src.getCollector()));
        if (src.hasSource())
            tgt.setSource(convertReference(src.getSource()));
        if (src.hasCollected())
            tgt.setCollected(convertType(src.getCollected()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductProcessingComponent convertBiologicallyDerivedProductProcessingComponent(org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductProcessingComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductProcessingComponent tgt = new org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductProcessingComponent();
        copyElement(src, tgt);
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasProcedure())
            tgt.setProcedure(convertCodeableConcept(src.getProcedure()));
        if (src.hasAdditive())
            tgt.setAdditive(convertReference(src.getAdditive()));
        if (src.hasTime())
            tgt.setTime(convertType(src.getTime()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductProcessingComponent convertBiologicallyDerivedProductProcessingComponent(org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductProcessingComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductProcessingComponent tgt = new org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductProcessingComponent();
        copyElement(src, tgt);
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasProcedure())
            tgt.setProcedure(convertCodeableConcept(src.getProcedure()));
        if (src.hasAdditive())
            tgt.setAdditive(convertReference(src.getAdditive()));
        if (src.hasTime())
            tgt.setTime(convertType(src.getTime()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductManipulationComponent convertBiologicallyDerivedProductManipulationComponent(org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductManipulationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductManipulationComponent tgt = new org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductManipulationComponent();
        copyElement(src, tgt);
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasTime())
            tgt.setTime(convertType(src.getTime()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductManipulationComponent convertBiologicallyDerivedProductManipulationComponent(org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductManipulationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductManipulationComponent tgt = new org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductManipulationComponent();
        copyElement(src, tgt);
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasTime())
            tgt.setTime(convertType(src.getTime()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageComponent convertBiologicallyDerivedProductStorageComponent(org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageComponent tgt = new org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageComponent();
        copyElement(src, tgt);
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasTemperature())
            tgt.setTemperatureElement(convertDecimal(src.getTemperatureElement()));
        if (src.hasScale())
            tgt.setScaleElement(convertBiologicallyDerivedProductStorageScale(src.getScaleElement()));
        if (src.hasDuration())
            tgt.setDuration(convertPeriod(src.getDuration()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageComponent convertBiologicallyDerivedProductStorageComponent(org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageComponent tgt = new org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageComponent();
        copyElement(src, tgt);
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasTemperature())
            tgt.setTemperatureElement(convertDecimal(src.getTemperatureElement()));
        if (src.hasScale())
            tgt.setScaleElement(convertBiologicallyDerivedProductStorageScale(src.getScaleElement()));
        if (src.hasDuration())
            tgt.setDuration(convertPeriod(src.getDuration()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageScale> convertBiologicallyDerivedProductStorageScale(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageScale> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageScale> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageScaleEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case FARENHEIT:
                tgt.setValue(org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageScale.FARENHEIT);
                break;
            case CELSIUS:
                tgt.setValue(org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageScale.CELSIUS);
                break;
            case KELVIN:
                tgt.setValue(org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageScale.KELVIN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageScale.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageScale> convertBiologicallyDerivedProductStorageScale(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageScale> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageScale> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageScaleEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case FARENHEIT:
                tgt.setValue(org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageScale.FARENHEIT);
                break;
            case CELSIUS:
                tgt.setValue(org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageScale.CELSIUS);
                break;
            case KELVIN:
                tgt.setValue(org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageScale.KELVIN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.BiologicallyDerivedProduct.BiologicallyDerivedProductStorageScale.NULL);
                break;
        }
        return tgt;
    }
}