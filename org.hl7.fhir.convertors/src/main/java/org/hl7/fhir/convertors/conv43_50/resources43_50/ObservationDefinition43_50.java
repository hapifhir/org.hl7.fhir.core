package org.hl7.fhir.convertors.conv43_50.resources43_50;

import java.util.stream.Collectors;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Coding43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Boolean43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
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
public class ObservationDefinition43_50 {

  public static org.hl7.fhir.r5.model.ObservationDefinition convertObservationDefinition(org.hl7.fhir.r4b.model.ObservationDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ObservationDefinition tgt = new org.hl7.fhir.r5.model.ObservationDefinition();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_50.convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.setIdentifier(Identifier43_50.convertIdentifier(t));
    tgt.setPermittedDataType(src.getPermittedDataType().stream()
      .map(ObservationDefinition43_50::convertObservationDataType)
      .collect(Collectors.toList()));
    if (src.hasMultipleResultsAllowed())
      tgt.setMultipleResultsAllowedElement(Boolean43_50.convertBoolean(src.getMultipleResultsAllowedElement()));
    if (src.hasMethod())
      tgt.setMethod(CodeableConcept43_50.convertCodeableConcept(src.getMethod()));
    if (src.hasPreferredReportName())
      tgt.setPreferredReportNameElement(String43_50.convertString(src.getPreferredReportNameElement()));
    if (src.hasQuantitativeDetails()) {
      for (org.hl7.fhir.r4b.model.Coding c : src.getQuantitativeDetails().getUnit().getCoding()) {
        tgt.addPermittedUnit(Coding43_50.convertCoding(c));
      }
    }
//        for (org.hl7.fhir.r4b.model.ObservationDefinition.ObservationDefinitionQualifiedIntervalComponent t : src.getQualifiedInterval()) tgt.addQualifiedInterval(convertObservationDefinitionQualifiedIntervalComponent(t));
//        if (src.hasValidCodedValueSet())
//            tgt.setValidCodedValueSet(convertReference(src.getValidCodedValueSet()));
//        if (src.hasNormalCodedValueSet())
//            tgt.setNormalCodedValueSet(convertReference(src.getNormalCodedValueSet()));
//        if (src.hasAbnormalCodedValueSet())
//            tgt.setAbnormalCodedValueSet(convertReference(src.getAbnormalCodedValueSet()));
//        if (src.hasCriticalCodedValueSet())
//            tgt.setCriticalCodedValueSet(convertReference(src.getCriticalCodedValueSet()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ObservationDefinition convertObservationDefinition(org.hl7.fhir.r5.model.ObservationDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ObservationDefinition tgt = new org.hl7.fhir.r4b.model.ObservationDefinition();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_50.convertCodeableConcept(src.getCode()));
    if (src.hasIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(src.getIdentifier()));
    tgt.setPermittedDataType(src.getPermittedDataType().stream()
      .map(ObservationDefinition43_50::convertObservationDataType)
      .collect(Collectors.toList()));
    if (src.hasMultipleResultsAllowed())
      tgt.setMultipleResultsAllowedElement(Boolean43_50.convertBoolean(src.getMultipleResultsAllowedElement()));
    if (src.hasMethod())
      tgt.setMethod(CodeableConcept43_50.convertCodeableConcept(src.getMethod()));
    if (src.hasPreferredReportName())
      tgt.setPreferredReportNameElement(String43_50.convertString(src.getPreferredReportNameElement()));
    for (org.hl7.fhir.r5.model.Coding c : src.getPermittedUnit()) {
      tgt.getQuantitativeDetails().getUnit().addCoding(Coding43_50.convertCoding(c));
    }
//        for (org.hl7.fhir.r5.model.ObservationDefinition.ObservationDefinitionQualifiedIntervalComponent t : src.getQualifiedInterval()) tgt.addQualifiedInterval(convertObservationDefinitionQualifiedIntervalComponent(t));
//        if (src.hasValidCodedValueSet())
//            tgt.setValidCodedValueSet(convertReference(src.getValidCodedValueSet()));
//        if (src.hasNormalCodedValueSet())
//            tgt.setNormalCodedValueSet(convertReference(src.getNormalCodedValueSet()));
//        if (src.hasAbnormalCodedValueSet())
//            tgt.setAbnormalCodedValueSet(convertReference(src.getAbnormalCodedValueSet()));
//        if (src.hasCriticalCodedValueSet())
//            tgt.setCriticalCodedValueSet(convertReference(src.getCriticalCodedValueSet()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ObservationDefinition.ObservationDataType> convertObservationDataType(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ObservationDefinition.ObservationDataType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ObservationDefinition.ObservationDataType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ObservationDefinition.ObservationDataTypeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case QUANTITY:
        tgt.setValue(org.hl7.fhir.r5.model.ObservationDefinition.ObservationDataType.QUANTITY);
        break;
      case CODEABLECONCEPT:
        tgt.setValue(org.hl7.fhir.r5.model.ObservationDefinition.ObservationDataType.CODEABLECONCEPT);
        break;
      case STRING:
        tgt.setValue(org.hl7.fhir.r5.model.ObservationDefinition.ObservationDataType.STRING);
        break;
      case BOOLEAN:
        tgt.setValue(org.hl7.fhir.r5.model.ObservationDefinition.ObservationDataType.BOOLEAN);
        break;
      case INTEGER:
        tgt.setValue(org.hl7.fhir.r5.model.ObservationDefinition.ObservationDataType.INTEGER);
        break;
      case RANGE:
        tgt.setValue(org.hl7.fhir.r5.model.ObservationDefinition.ObservationDataType.RANGE);
        break;
      case RATIO:
        tgt.setValue(org.hl7.fhir.r5.model.ObservationDefinition.ObservationDataType.RATIO);
        break;
      case SAMPLEDDATA:
        tgt.setValue(org.hl7.fhir.r5.model.ObservationDefinition.ObservationDataType.SAMPLEDDATA);
        break;
      case TIME:
        tgt.setValue(org.hl7.fhir.r5.model.ObservationDefinition.ObservationDataType.TIME);
        break;
      case DATETIME:
        tgt.setValue(org.hl7.fhir.r5.model.ObservationDefinition.ObservationDataType.DATETIME);
        break;
      case PERIOD:
        tgt.setValue(org.hl7.fhir.r5.model.ObservationDefinition.ObservationDataType.PERIOD);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.ObservationDefinition.ObservationDataType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ObservationDefinition.ObservationDataType> convertObservationDataType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ObservationDefinition.ObservationDataType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ObservationDefinition.ObservationDataType> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.ObservationDefinition.ObservationDataTypeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case QUANTITY:
        tgt.setValue(org.hl7.fhir.r4b.model.ObservationDefinition.ObservationDataType.QUANTITY);
        break;
      case CODEABLECONCEPT:
        tgt.setValue(org.hl7.fhir.r4b.model.ObservationDefinition.ObservationDataType.CODEABLECONCEPT);
        break;
      case STRING:
        tgt.setValue(org.hl7.fhir.r4b.model.ObservationDefinition.ObservationDataType.STRING);
        break;
      case BOOLEAN:
        tgt.setValue(org.hl7.fhir.r4b.model.ObservationDefinition.ObservationDataType.BOOLEAN);
        break;
      case INTEGER:
        tgt.setValue(org.hl7.fhir.r4b.model.ObservationDefinition.ObservationDataType.INTEGER);
        break;
      case RANGE:
        tgt.setValue(org.hl7.fhir.r4b.model.ObservationDefinition.ObservationDataType.RANGE);
        break;
      case RATIO:
        tgt.setValue(org.hl7.fhir.r4b.model.ObservationDefinition.ObservationDataType.RATIO);
        break;
      case SAMPLEDDATA:
        tgt.setValue(org.hl7.fhir.r4b.model.ObservationDefinition.ObservationDataType.SAMPLEDDATA);
        break;
      case TIME:
        tgt.setValue(org.hl7.fhir.r4b.model.ObservationDefinition.ObservationDataType.TIME);
        break;
      case DATETIME:
        tgt.setValue(org.hl7.fhir.r4b.model.ObservationDefinition.ObservationDataType.DATETIME);
        break;
      case PERIOD:
        tgt.setValue(org.hl7.fhir.r4b.model.ObservationDefinition.ObservationDataType.PERIOD);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.ObservationDefinition.ObservationDataType.NULL);
        break;
    }
    return tgt;
  }


//    public static org.hl7.fhir.r5.model.ObservationDefinition.ObservationDefinitionQualifiedIntervalComponent convertObservationDefinitionQualifiedIntervalComponent(org.hl7.fhir.r4b.model.ObservationDefinition.ObservationDefinitionQualifiedIntervalComponent src) throws FHIRException {
//        if (src == null)
//            return null;
//        org.hl7.fhir.r5.model.ObservationDefinition.ObservationDefinitionQualifiedIntervalComponent tgt = new org.hl7.fhir.r5.model.ObservationDefinition.ObservationDefinitionQualifiedIntervalComponent();
//        copyElement(src, tgt);
//        if (src.hasCategory())
//            tgt.setCategoryElement(convertObservationRangeCategory(src.getCategoryElement()));
//        if (src.hasRange())
//            tgt.setRange(convertRange(src.getRange()));
//        if (src.hasContext())
//            tgt.setContext(convertCodeableConcept(src.getContext()));
//        for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getAppliesTo()) tgt.addAppliesTo(convertCodeableConcept(t));
//        if (src.hasGender())
//            tgt.setGenderElement(Enumerations43_50.convertAdministrativeGender(src.getGenderElement()));
//        if (src.hasAge())
//            tgt.setAge(convertRange(src.getAge()));
//        if (src.hasGestationalAge())
//            tgt.setGestationalAge(convertRange(src.getGestationalAge()));
//        if (src.hasCondition())
//            tgt.setConditionElement(convertString(src.getConditionElement()));
//        return tgt;
//    }
//
//    public static org.hl7.fhir.r4b.model.ObservationDefinition.ObservationDefinitionQualifiedIntervalComponent convertObservationDefinitionQualifiedIntervalComponent(org.hl7.fhir.r5.model.ObservationDefinition.ObservationDefinitionQualifiedIntervalComponent src) throws FHIRException {
//        if (src == null)
//            return null;
//        org.hl7.fhir.r4b.model.ObservationDefinition.ObservationDefinitionQualifiedIntervalComponent tgt = new org.hl7.fhir.r4b.model.ObservationDefinition.ObservationDefinitionQualifiedIntervalComponent();
//        copyElement(src, tgt);
//        if (src.hasCategory())
//            tgt.setCategoryElement(convertObservationRangeCategory(src.getCategoryElement()));
//        if (src.hasRange())
//            tgt.setRange(convertRange(src.getRange()));
//        if (src.hasContext())
//            tgt.setContext(convertCodeableConcept(src.getContext()));
//        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getAppliesTo()) tgt.addAppliesTo(convertCodeableConcept(t));
//        if (src.hasGender())
//            tgt.setGenderElement(Enumerations43_50.convertAdministrativeGender(src.getGenderElement()));
//        if (src.hasAge())
//            tgt.setAge(convertRange(src.getAge()));
//        if (src.hasGestationalAge())
//            tgt.setGestationalAge(convertRange(src.getGestationalAge()));
//        if (src.hasCondition())
//            tgt.setConditionElement(convertString(src.getConditionElement()));
//        return tgt;
//    }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ObservationDefinition.ObservationRangeCategory> convertObservationRangeCategory(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ObservationDefinition.ObservationRangeCategory> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ObservationDefinition.ObservationRangeCategory> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ObservationDefinition.ObservationRangeCategoryEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case REFERENCE:
        tgt.setValue(org.hl7.fhir.r5.model.ObservationDefinition.ObservationRangeCategory.REFERENCE);
        break;
      case CRITICAL:
        tgt.setValue(org.hl7.fhir.r5.model.ObservationDefinition.ObservationRangeCategory.CRITICAL);
        break;
      case ABSOLUTE:
        tgt.setValue(org.hl7.fhir.r5.model.ObservationDefinition.ObservationRangeCategory.ABSOLUTE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.ObservationDefinition.ObservationRangeCategory.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ObservationDefinition.ObservationRangeCategory> convertObservationRangeCategory(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ObservationDefinition.ObservationRangeCategory> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ObservationDefinition.ObservationRangeCategory> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.ObservationDefinition.ObservationRangeCategoryEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case REFERENCE:
        tgt.setValue(org.hl7.fhir.r4b.model.ObservationDefinition.ObservationRangeCategory.REFERENCE);
        break;
      case CRITICAL:
        tgt.setValue(org.hl7.fhir.r4b.model.ObservationDefinition.ObservationRangeCategory.CRITICAL);
        break;
      case ABSOLUTE:
        tgt.setValue(org.hl7.fhir.r4b.model.ObservationDefinition.ObservationRangeCategory.ABSOLUTE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.ObservationDefinition.ObservationRangeCategory.NULL);
        break;
    }
    return tgt;
  }
}