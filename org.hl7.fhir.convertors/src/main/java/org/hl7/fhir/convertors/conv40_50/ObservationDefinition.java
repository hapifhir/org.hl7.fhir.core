package org.hl7.fhir.convertors.conv40_50;

import org.hl7.fhir.exceptions.FHIRException;

import org.hl7.fhir.convertors.VersionConvertor_40_50;


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


public class ObservationDefinition extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.ObservationDefinition convertObservationDefinition(org.hl7.fhir.r4.model.ObservationDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ObservationDefinition tgt = new org.hl7.fhir.r5.model.ObservationDefinition();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(convertCodeableConcept(t));
    if (src.hasCode())
      tgt.setCode(convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    for (org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ObservationDefinition.ObservationDataType> t : src.getPermittedDataType())
      tgt.addPermittedDataType(convertObservationDataType(t.getValue()));
    if (src.hasMultipleResultsAllowed())
      tgt.setMultipleResultsAllowedElement(convertBoolean(src.getMultipleResultsAllowedElement()));
    if (src.hasMethod())
      tgt.setMethod(convertCodeableConcept(src.getMethod()));
    if (src.hasPreferredReportName())
      tgt.setPreferredReportNameElement(convertString(src.getPreferredReportNameElement()));
    if (src.hasQuantitativeDetails())
      tgt.setQuantitativeDetails(convertObservationDefinitionQuantitativeDetailsComponent(src.getQuantitativeDetails()));
    for (org.hl7.fhir.r4.model.ObservationDefinition.ObservationDefinitionQualifiedIntervalComponent t : src.getQualifiedInterval())
      tgt.addQualifiedInterval(convertObservationDefinitionQualifiedIntervalComponent(t));
    if (src.hasValidCodedValueSet())
      tgt.setValidCodedValueSet(convertReference(src.getValidCodedValueSet()));
    if (src.hasNormalCodedValueSet())
      tgt.setNormalCodedValueSet(convertReference(src.getNormalCodedValueSet()));
    if (src.hasAbnormalCodedValueSet())
      tgt.setAbnormalCodedValueSet(convertReference(src.getAbnormalCodedValueSet()));
    if (src.hasCriticalCodedValueSet())
      tgt.setCriticalCodedValueSet(convertReference(src.getCriticalCodedValueSet()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ObservationDefinition convertObservationDefinition(org.hl7.fhir.r5.model.ObservationDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ObservationDefinition tgt = new org.hl7.fhir.r4.model.ObservationDefinition();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(convertCodeableConcept(t));
    if (src.hasCode())
      tgt.setCode(convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    for (org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ObservationDefinition.ObservationDataType> t : src.getPermittedDataType())
      tgt.addPermittedDataType(convertObservationDataType(t.getValue()));
    if (src.hasMultipleResultsAllowed())
      tgt.setMultipleResultsAllowedElement(convertBoolean(src.getMultipleResultsAllowedElement()));
    if (src.hasMethod())
      tgt.setMethod(convertCodeableConcept(src.getMethod()));
    if (src.hasPreferredReportName())
      tgt.setPreferredReportNameElement(convertString(src.getPreferredReportNameElement()));
    if (src.hasQuantitativeDetails())
      tgt.setQuantitativeDetails(convertObservationDefinitionQuantitativeDetailsComponent(src.getQuantitativeDetails()));
    for (org.hl7.fhir.r5.model.ObservationDefinition.ObservationDefinitionQualifiedIntervalComponent t : src.getQualifiedInterval())
      tgt.addQualifiedInterval(convertObservationDefinitionQualifiedIntervalComponent(t));
    if (src.hasValidCodedValueSet())
      tgt.setValidCodedValueSet(convertReference(src.getValidCodedValueSet()));
    if (src.hasNormalCodedValueSet())
      tgt.setNormalCodedValueSet(convertReference(src.getNormalCodedValueSet()));
    if (src.hasAbnormalCodedValueSet())
      tgt.setAbnormalCodedValueSet(convertReference(src.getAbnormalCodedValueSet()));
    if (src.hasCriticalCodedValueSet())
      tgt.setCriticalCodedValueSet(convertReference(src.getCriticalCodedValueSet()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ObservationDefinition.ObservationDataType convertObservationDataType(org.hl7.fhir.r4.model.ObservationDefinition.ObservationDataType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case QUANTITY: return org.hl7.fhir.r5.model.ObservationDefinition.ObservationDataType.QUANTITY;
    case CODEABLECONCEPT: return org.hl7.fhir.r5.model.ObservationDefinition.ObservationDataType.CODEABLECONCEPT;
    case STRING: return org.hl7.fhir.r5.model.ObservationDefinition.ObservationDataType.STRING;
    case BOOLEAN: return org.hl7.fhir.r5.model.ObservationDefinition.ObservationDataType.BOOLEAN;
    case INTEGER: return org.hl7.fhir.r5.model.ObservationDefinition.ObservationDataType.INTEGER;
    case RANGE: return org.hl7.fhir.r5.model.ObservationDefinition.ObservationDataType.RANGE;
    case RATIO: return org.hl7.fhir.r5.model.ObservationDefinition.ObservationDataType.RATIO;
    case SAMPLEDDATA: return org.hl7.fhir.r5.model.ObservationDefinition.ObservationDataType.SAMPLEDDATA;
    case TIME: return org.hl7.fhir.r5.model.ObservationDefinition.ObservationDataType.TIME;
    case DATETIME: return org.hl7.fhir.r5.model.ObservationDefinition.ObservationDataType.DATETIME;
    case PERIOD: return org.hl7.fhir.r5.model.ObservationDefinition.ObservationDataType.PERIOD;
    default: return org.hl7.fhir.r5.model.ObservationDefinition.ObservationDataType.NULL;
  }
}

  public static org.hl7.fhir.r4.model.ObservationDefinition.ObservationDataType convertObservationDataType(org.hl7.fhir.r5.model.ObservationDefinition.ObservationDataType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case QUANTITY: return org.hl7.fhir.r4.model.ObservationDefinition.ObservationDataType.QUANTITY;
    case CODEABLECONCEPT: return org.hl7.fhir.r4.model.ObservationDefinition.ObservationDataType.CODEABLECONCEPT;
    case STRING: return org.hl7.fhir.r4.model.ObservationDefinition.ObservationDataType.STRING;
    case BOOLEAN: return org.hl7.fhir.r4.model.ObservationDefinition.ObservationDataType.BOOLEAN;
    case INTEGER: return org.hl7.fhir.r4.model.ObservationDefinition.ObservationDataType.INTEGER;
    case RANGE: return org.hl7.fhir.r4.model.ObservationDefinition.ObservationDataType.RANGE;
    case RATIO: return org.hl7.fhir.r4.model.ObservationDefinition.ObservationDataType.RATIO;
    case SAMPLEDDATA: return org.hl7.fhir.r4.model.ObservationDefinition.ObservationDataType.SAMPLEDDATA;
    case TIME: return org.hl7.fhir.r4.model.ObservationDefinition.ObservationDataType.TIME;
    case DATETIME: return org.hl7.fhir.r4.model.ObservationDefinition.ObservationDataType.DATETIME;
    case PERIOD: return org.hl7.fhir.r4.model.ObservationDefinition.ObservationDataType.PERIOD;
    default: return org.hl7.fhir.r4.model.ObservationDefinition.ObservationDataType.NULL;
  }
}

  public static org.hl7.fhir.r5.model.ObservationDefinition.ObservationDefinitionQuantitativeDetailsComponent convertObservationDefinitionQuantitativeDetailsComponent(org.hl7.fhir.r4.model.ObservationDefinition.ObservationDefinitionQuantitativeDetailsComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ObservationDefinition.ObservationDefinitionQuantitativeDetailsComponent tgt = new org.hl7.fhir.r5.model.ObservationDefinition.ObservationDefinitionQuantitativeDetailsComponent();
    copyElement(src, tgt);
    if (src.hasCustomaryUnit())
      tgt.setCustomaryUnit(convertCodeableConcept(src.getCustomaryUnit()));
    if (src.hasUnit())
      tgt.setUnit(convertCodeableConcept(src.getUnit()));
    if (src.hasConversionFactor())
      tgt.setConversionFactorElement(convertDecimal(src.getConversionFactorElement()));
    if (src.hasDecimalPrecision())
      tgt.setDecimalPrecisionElement(convertInteger(src.getDecimalPrecisionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ObservationDefinition.ObservationDefinitionQuantitativeDetailsComponent convertObservationDefinitionQuantitativeDetailsComponent(org.hl7.fhir.r5.model.ObservationDefinition.ObservationDefinitionQuantitativeDetailsComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ObservationDefinition.ObservationDefinitionQuantitativeDetailsComponent tgt = new org.hl7.fhir.r4.model.ObservationDefinition.ObservationDefinitionQuantitativeDetailsComponent();
    copyElement(src, tgt);
    if (src.hasCustomaryUnit())
      tgt.setCustomaryUnit(convertCodeableConcept(src.getCustomaryUnit()));
    if (src.hasUnit())
      tgt.setUnit(convertCodeableConcept(src.getUnit()));
    if (src.hasConversionFactor())
      tgt.setConversionFactorElement(convertDecimal(src.getConversionFactorElement()));
    if (src.hasDecimalPrecision())
      tgt.setDecimalPrecisionElement(convertInteger(src.getDecimalPrecisionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ObservationDefinition.ObservationDefinitionQualifiedIntervalComponent convertObservationDefinitionQualifiedIntervalComponent(org.hl7.fhir.r4.model.ObservationDefinition.ObservationDefinitionQualifiedIntervalComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ObservationDefinition.ObservationDefinitionQualifiedIntervalComponent tgt = new org.hl7.fhir.r5.model.ObservationDefinition.ObservationDefinitionQualifiedIntervalComponent();
    copyElement(src, tgt);
    if (src.hasCategory())
      tgt.setCategory(convertObservationRangeCategory(src.getCategory()));
    if (src.hasRange())
      tgt.setRange(convertRange(src.getRange()));
    if (src.hasContext())
      tgt.setContext(convertCodeableConcept(src.getContext()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getAppliesTo())
      tgt.addAppliesTo(convertCodeableConcept(t));
    if (src.hasGender())
      tgt.setGender(Enumerations.convertAdministrativeGender(src.getGender()));
    if (src.hasAge())
      tgt.setAge(convertRange(src.getAge()));
    if (src.hasGestationalAge())
      tgt.setGestationalAge(convertRange(src.getGestationalAge()));
    if (src.hasCondition())
      tgt.setConditionElement(convertString(src.getConditionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ObservationDefinition.ObservationDefinitionQualifiedIntervalComponent convertObservationDefinitionQualifiedIntervalComponent(org.hl7.fhir.r5.model.ObservationDefinition.ObservationDefinitionQualifiedIntervalComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ObservationDefinition.ObservationDefinitionQualifiedIntervalComponent tgt = new org.hl7.fhir.r4.model.ObservationDefinition.ObservationDefinitionQualifiedIntervalComponent();
    copyElement(src, tgt);
    if (src.hasCategory())
      tgt.setCategory(convertObservationRangeCategory(src.getCategory()));
    if (src.hasRange())
      tgt.setRange(convertRange(src.getRange()));
    if (src.hasContext())
      tgt.setContext(convertCodeableConcept(src.getContext()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getAppliesTo())
      tgt.addAppliesTo(convertCodeableConcept(t));
    if (src.hasGender())
      tgt.setGender(Enumerations.convertAdministrativeGender(src.getGender()));
    if (src.hasAge())
      tgt.setAge(convertRange(src.getAge()));
    if (src.hasGestationalAge())
      tgt.setGestationalAge(convertRange(src.getGestationalAge()));
    if (src.hasCondition())
      tgt.setConditionElement(convertString(src.getConditionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ObservationDefinition.ObservationRangeCategory convertObservationRangeCategory(org.hl7.fhir.r4.model.ObservationDefinition.ObservationRangeCategory src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case REFERENCE: return org.hl7.fhir.r5.model.ObservationDefinition.ObservationRangeCategory.REFERENCE;
    case CRITICAL: return org.hl7.fhir.r5.model.ObservationDefinition.ObservationRangeCategory.CRITICAL;
    case ABSOLUTE: return org.hl7.fhir.r5.model.ObservationDefinition.ObservationRangeCategory.ABSOLUTE;
    default: return org.hl7.fhir.r5.model.ObservationDefinition.ObservationRangeCategory.NULL;
  }
}

  public static org.hl7.fhir.r4.model.ObservationDefinition.ObservationRangeCategory convertObservationRangeCategory(org.hl7.fhir.r5.model.ObservationDefinition.ObservationRangeCategory src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case REFERENCE: return org.hl7.fhir.r4.model.ObservationDefinition.ObservationRangeCategory.REFERENCE;
    case CRITICAL: return org.hl7.fhir.r4.model.ObservationDefinition.ObservationRangeCategory.CRITICAL;
    case ABSOLUTE: return org.hl7.fhir.r4.model.ObservationDefinition.ObservationRangeCategory.ABSOLUTE;
    default: return org.hl7.fhir.r4.model.ObservationDefinition.ObservationRangeCategory.NULL;
  }
}


}
