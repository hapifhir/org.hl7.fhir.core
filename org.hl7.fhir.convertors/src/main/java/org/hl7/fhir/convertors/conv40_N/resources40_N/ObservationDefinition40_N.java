package org.hl7.fhir.convertors.conv40_N.resources40_N;

import java.util.stream.Collectors;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionElements40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Range40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Coding40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Boolean40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.ObservationDefinition;

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

public class ObservationDefinition40_N {

  public static org.hl7.fhir.model.core.ObservationDefinition convertObservationDefinition(org.hl7.fhir.r4.model.ObservationDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ObservationDefinition tgt = new org.hl7.fhir.model.core.ObservationDefinition();
    // R6 dropped these
    CrossVersionElements40_N.r4ElementsToExtensions(src, "ObservationDefinition", tgt.getExtension(), "validCodedValueSet", "normalCodedValueSet", "abnormalCodedValueSet", "criticalCodedValueSet");
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, CrossVersionElements40_N.urls("ObservationDefinition", "5.0", new String[] {"url", "version", "versionAlgorithm", "name", "title", "status", "experimental", "date", "publisher", "contact", "description", "useContext", "jurisdiction", "purpose", "copyright", "copyrightLabel", "approvalDate", "lastReviewDate", "effectivePeriod", "derivedFromCanonical", "derivedFromUri", "subject", "performerType", "specimen", "device", "hasMember", "component"}, CrossVersionElements40_N.urls("ObservationDefinition", "6.0", new String[] {"bodyStructure", "supportingDevice"})));
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "url", "version", "versionAlgorithm", "name", "title", "status", "experimental", "date", "publisher", "contact", "description", "useContext", "jurisdiction", "purpose", "copyright", "copyrightLabel", "approvalDate", "lastReviewDate", "effectivePeriod", "derivedFromCanonical", "derivedFromUri", "subject", "performerType", "specimen", "device", "hasMember", "component");
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "6.0", "bodyStructure", "supportingDevice");
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    tgt.setPermittedDataTypeList(src.getPermittedDataType().stream()
      .map(ObservationDefinition40_N::convertObservationDataType)
      .collect(Collectors.toList()));
    if (src.hasMultipleResultsAllowed())
      tgt.setMultipleResultsAllowedElement(Boolean40_N.convertBoolean(src.getMultipleResultsAllowedElement()));
    if (src.hasMethod())
      tgt.setMethod(CodeableConcept40_N.convertCodeableConcept(src.getMethod()));
    if (src.hasPreferredReportName())
      tgt.setPreferredReportNameElement(String40_N.convertString(src.getPreferredReportNameElement()));
    if (src.hasQuantitativeDetails()) {
      for (org.hl7.fhir.r4.model.Coding c : src.getQuantitativeDetails().getUnit().getCoding()) {
        tgt.addPermittedUnit(Coding40_N.convertCoding(c));
      }
      // R6 has only the unit codings (permittedUnit): the rest of quantitativeDetails is 4.0 extensions
      CrossVersionElements40_N.r4ElementsToExtensions(src.getQuantitativeDetails(), QD, tgt.getExtension(), "customaryUnit", "conversionFactor", "decimalPrecision");
      org.hl7.fhir.r4.model.CodeableConcept unit = src.getQuantitativeDetails().getUnit();
      if (unit.hasText() || unit.hasId() || unit.hasExtension())
        CrossVersionElements40_N.r4ElementsToExtensions(src.getQuantitativeDetails(), QD, tgt.getExtension(), "unit");
    }

    for (org.hl7.fhir.r4.model.ObservationDefinition.ObservationDefinitionQualifiedIntervalComponent t : src.getQualifiedInterval())
      tgt.addQualifiedValue(convertQualifiedInterval(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ObservationDefinition convertObservationDefinition(org.hl7.fhir.model.core.ObservationDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ObservationDefinition tgt = new org.hl7.fhir.r4.model.ObservationDefinition();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, CrossVersionElements40_N.urls("ObservationDefinition", "4.0", new String[] {"validCodedValueSet", "normalCodedValueSet", "abnormalCodedValueSet", "criticalCodedValueSet"}));
    CrossVersionElements40_N.extensionsToR4Elements(src.getExtension(), tgt, "ObservationDefinition", "validCodedValueSet", "normalCodedValueSet", "abnormalCodedValueSet", "criticalCodedValueSet");
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "5.0", "url", "version", "versionAlgorithm", "name", "title", "status", "experimental", "date", "publisher", "contact", "description", "useContext", "jurisdiction", "purpose", "copyright", "copyrightLabel", "approvalDate", "lastReviewDate", "effectivePeriod", "derivedFromCanonical", "derivedFromUri", "subject", "performerType", "specimen", "device", "hasMember", "component");
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "6.0", "bodyStructure", "supportingDevice");
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getCategoryList())
      tgt.addCategory(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    tgt.setPermittedDataType(src.getPermittedDataTypeList().stream()
      .map(ObservationDefinition40_N::convertObservationDataType)
      .collect(Collectors.toList()));
    if (src.hasMultipleResultsAllowed())
      tgt.setMultipleResultsAllowedElement(Boolean40_N.convertBoolean(src.getMultipleResultsAllowedElement()));
    if (src.hasMethod())
      tgt.setMethod(CodeableConcept40_N.convertCodeableConcept(src.getMethod()));
    if (src.hasPreferredReportName())
      tgt.setPreferredReportNameElement(String40_N.convertString(src.getPreferredReportNameElement()));
    String unitUrl = CrossVersionElements40_N.url(QD, "4.0", "unit");
    if (!src.hasExtension(unitUrl)) {
      for (org.hl7.fhir.model.core.Coding c : src.getPermittedUnitList()) {
        tgt.getQuantitativeDetails().getUnit().addCoding(Coding40_N.convertCoding(c));
      }
    }
    for (String n : new String[] {"customaryUnit", "conversionFactor", "decimalPrecision", "unit"}) {
      String u = CrossVersionElements40_N.url(QD, "4.0", n);
      tgt.getExtension().removeIf(e -> u.equals(e.getUrl()));
    }
    CrossVersionElements40_N.extensionsToR4Elements(src.getExtension(), tgt.getQuantitativeDetails(), QD, "customaryUnit", "conversionFactor", "decimalPrecision", "unit");
    for (org.hl7.fhir.model.core.ObservationDefinition.ObservationDefinitionQualifiedValueComponent t : src.getQualifiedValueList())
      tgt.addQualifiedInterval(convertQualifiedValue(t));
    return tgt;
  }

  private static final String QV = "ObservationDefinition.qualifiedValue";
  private static final String QD = "ObservationDefinition.quantitativeDetails";
  // R6 moved the coded value sets from the resource into qualifiedValue; interpretation is new in R6
  private static final String[] QV_V5 = {"validCodedValueSet", "normalCodedValueSet", "abnormalCodedValueSet", "criticalCodedValueSet"};
  private static final String[] QV_V6 = {"interpretation"};

  /**
   * R4 qualifiedInterval -> R6 qualifiedValue (renamed in R5; category -> rangeCategory, gender -> sexParameterForClinicalUse)
   */
  public static org.hl7.fhir.model.core.ObservationDefinition.ObservationDefinitionQualifiedValueComponent convertQualifiedInterval(org.hl7.fhir.r4.model.ObservationDefinition.ObservationDefinitionQualifiedIntervalComponent src) throws FHIRException {
    org.hl7.fhir.model.core.ObservationDefinition.ObservationDefinitionQualifiedValueComponent tgt = new org.hl7.fhir.model.core.ObservationDefinition.ObservationDefinitionQualifiedValueComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, CrossVersionElements40_N.urls(QV, "5.0", QV_V5, CrossVersionElements40_N.urls(QV, "6.0", QV_V6)));
    CrossVersionElements40_N.extensionsToElementsForPath(src.getExtension(), tgt, QV, "5.0", QV_V5);
    CrossVersionElements40_N.extensionsToElementsForPath(src.getExtension(), tgt, QV, "6.0", QV_V6);
    if (src.hasContext())
      tgt.setContext(CodeableConcept40_N.convertCodeableConcept(src.getContext()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getAppliesTo())
      tgt.addAppliesTo(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasGender()) {
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src.getGenderElement(), tgt.getSexParameterForClinicalUseElement());
      tgt.getSexParameterForClinicalUseElement().setValueAsString(src.getGenderElement().getValueAsString());
    }
    if (src.hasAge())
      tgt.setAge(Range40_N.convertRange(src.getAge()));
    if (src.hasGestationalAge())
      tgt.setGestationalAge(Range40_N.convertRange(src.getGestationalAge()));
    if (src.hasCondition())
      tgt.setConditionElement(String40_N.convertString(src.getConditionElement()));
    if (src.hasCategory()) {
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src.getCategoryElement(), tgt.getRangeCategoryElement());
      tgt.getRangeCategoryElement().setValueAsString(src.getCategoryElement().getValueAsString());
    }
    if (src.hasRange())
      tgt.setRange(Range40_N.convertRange(src.getRange()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ObservationDefinition.ObservationDefinitionQualifiedIntervalComponent convertQualifiedValue(org.hl7.fhir.model.core.ObservationDefinition.ObservationDefinitionQualifiedValueComponent src) throws FHIRException {
    org.hl7.fhir.r4.model.ObservationDefinition.ObservationDefinitionQualifiedIntervalComponent tgt = new org.hl7.fhir.r4.model.ObservationDefinition.ObservationDefinitionQualifiedIntervalComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    CrossVersionElements40_N.elementsToExtensionsForPath(src, QV, tgt.getExtension(), "5.0", QV_V5);
    CrossVersionElements40_N.elementsToExtensionsForPath(src, QV, tgt.getExtension(), "6.0", QV_V6);
    if (src.hasRangeCategory()) {
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src.getRangeCategoryElement(), tgt.getCategoryElement());
      tgt.getCategoryElement().setValueAsString(src.getRangeCategoryElement().getValueAsString());
    }
    if (src.hasRange())
      tgt.setRange(Range40_N.convertRange(src.getRange()));
    if (src.hasContext())
      tgt.setContext(CodeableConcept40_N.convertCodeableConcept(src.getContext()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getAppliesToList())
      tgt.addAppliesTo(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasSexParameterForClinicalUse()) {
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src.getSexParameterForClinicalUseElement(), tgt.getGenderElement());
      tgt.getGenderElement().setValueAsString(src.getSexParameterForClinicalUseElement().getValueAsString());
    }
    if (src.hasAge())
      tgt.setAge(Range40_N.convertRange(src.getAge()));
    if (src.hasGestationalAge())
      tgt.setGestationalAge(Range40_N.convertRange(src.getGestationalAge()));
    if (src.hasCondition())
      tgt.setConditionElement(String40_N.convertString(src.getConditionElement()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ObservationDefinition.ObservationDataType> convertObservationDataType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ObservationDefinition.ObservationDataType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<ObservationDefinition.ObservationDataType> tgt = new Enumeration<>(new ObservationDefinition.ObservationDataTypeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case QUANTITY:
                  tgt.setValue(ObservationDefinition.ObservationDataType.QUANTITY);
                  break;
              case CODEABLECONCEPT:
                  tgt.setValue(ObservationDefinition.ObservationDataType.CODEABLECONCEPT);
                  break;
              case STRING:
                  tgt.setValue(ObservationDefinition.ObservationDataType.STRING);
                  break;
              case BOOLEAN:
                  tgt.setValue(ObservationDefinition.ObservationDataType.BOOLEAN);
                  break;
              case INTEGER:
                  tgt.setValue(ObservationDefinition.ObservationDataType.INTEGER);
                  break;
              case RANGE:
                  tgt.setValue(ObservationDefinition.ObservationDataType.RANGE);
                  break;
              case RATIO:
                  tgt.setValue(ObservationDefinition.ObservationDataType.RATIO);
                  break;
              case SAMPLEDDATA:
                  tgt.setValue(ObservationDefinition.ObservationDataType.SAMPLEDDATA);
                  break;
              case TIME:
                  tgt.setValue(ObservationDefinition.ObservationDataType.TIME);
                  break;
              case DATETIME:
                  tgt.setValue(ObservationDefinition.ObservationDataType.DATETIME);
                  break;
              case PERIOD:
                  tgt.setValue(ObservationDefinition.ObservationDataType.PERIOD);
                  break;
              default:
                  tgt.setValue(ObservationDefinition.ObservationDataType.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ObservationDefinition.ObservationDataType> convertObservationDataType(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ObservationDefinition.ObservationDataType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ObservationDefinition.ObservationDataType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ObservationDefinition.ObservationDataTypeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case QUANTITY:
                  tgt.setValue(org.hl7.fhir.r4.model.ObservationDefinition.ObservationDataType.QUANTITY);
                  break;
              case CODEABLECONCEPT:
                  tgt.setValue(org.hl7.fhir.r4.model.ObservationDefinition.ObservationDataType.CODEABLECONCEPT);
                  break;
              case STRING:
                  tgt.setValue(org.hl7.fhir.r4.model.ObservationDefinition.ObservationDataType.STRING);
                  break;
              case BOOLEAN:
                  tgt.setValue(org.hl7.fhir.r4.model.ObservationDefinition.ObservationDataType.BOOLEAN);
                  break;
              case INTEGER:
                  tgt.setValue(org.hl7.fhir.r4.model.ObservationDefinition.ObservationDataType.INTEGER);
                  break;
              case RANGE:
                  tgt.setValue(org.hl7.fhir.r4.model.ObservationDefinition.ObservationDataType.RANGE);
                  break;
              case RATIO:
                  tgt.setValue(org.hl7.fhir.r4.model.ObservationDefinition.ObservationDataType.RATIO);
                  break;
              case SAMPLEDDATA:
                  tgt.setValue(org.hl7.fhir.r4.model.ObservationDefinition.ObservationDataType.SAMPLEDDATA);
                  break;
              case TIME:
                  tgt.setValue(org.hl7.fhir.r4.model.ObservationDefinition.ObservationDataType.TIME);
                  break;
              case DATETIME:
                  tgt.setValue(org.hl7.fhir.r4.model.ObservationDefinition.ObservationDataType.DATETIME);
                  break;
              case PERIOD:
                  tgt.setValue(org.hl7.fhir.r4.model.ObservationDefinition.ObservationDataType.PERIOD);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4.model.ObservationDefinition.ObservationDataType.NULL);
                  break;
          }
      }
      return tgt;
  }


//    public static org.hl7.fhir.model.core.ObservationDefinition.ObservationDefinitionQualifiedIntervalComponent convertObservationDefinitionQualifiedIntervalComponent(org.hl7.fhir.r4.model.ObservationDefinition.ObservationDefinitionQualifiedIntervalComponent src) throws FHIRException {
//        if (src == null)
//            return null;
//        org.hl7.fhir.model.core.ObservationDefinition.ObservationDefinitionQualifiedIntervalComponent tgt = new org.hl7.fhir.model.core.ObservationDefinition.ObservationDefinitionQualifiedIntervalComponent();
//        copyElement(src, tgt);
//        if (src.hasCategory())
//            tgt.setCategoryElement(CrossVersionElements40_N.toR6Code(src.getCategoryElement(), convertObservationRangeCategory(src.getCategoryElement()), src.fhirType(), "category"));
//        if (src.hasRange())
//            tgt.setRange(convertRange(src.getRange()));
//        if (src.hasContext())
//            tgt.setContext(convertCodeableConcept(src.getContext()));
//        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getAppliesTo()) tgt.addAppliesTo(convertCodeableConcept(t));
//        if (src.hasGender())
//            tgt.setGenderElement(Enumerations40_N.convertAdministrativeGender(src.getGenderElement()));
//        if (src.hasAge())
//            tgt.setAge(convertRange(src.getAge()));
//        if (src.hasGestationalAge())
//            tgt.setGestationalAge(convertRange(src.getGestationalAge()));
//        if (src.hasCondition())
//            tgt.setConditionElement(convertString(src.getConditionElement()));
//        return tgt;
//    }
//
//    public static org.hl7.fhir.r4.model.ObservationDefinition.ObservationDefinitionQualifiedIntervalComponent convertObservationDefinitionQualifiedIntervalComponent(org.hl7.fhir.model.core.ObservationDefinition.ObservationDefinitionQualifiedIntervalComponent src) throws FHIRException {
//        if (src == null)
//            return null;
//        org.hl7.fhir.r4.model.ObservationDefinition.ObservationDefinitionQualifiedIntervalComponent tgt = new org.hl7.fhir.r4.model.ObservationDefinition.ObservationDefinitionQualifiedIntervalComponent();
//        copyElement(src, tgt);
//        if (src.hasCategory())
//            tgt.setCategoryElement(CrossVersionElements40_N.toR4Code(src.getCategoryElement(), convertObservationRangeCategory(src.getCategoryElement()), src.fhirType(), "category"));
//        if (src.hasRange())
//            tgt.setRange(convertRange(src.getRange()));
//        if (src.hasContext())
//            tgt.setContext(convertCodeableConcept(src.getContext()));
//        for (org.hl7.fhir.model.core.CodeableConcept t : src.getAppliesToList()) tgt.addAppliesTo(convertCodeableConcept(t));
//        if (src.hasGender())
//            tgt.setGenderElement(Enumerations40_N.convertAdministrativeGender(src.getGenderElement()));
//        if (src.hasAge())
//            tgt.setAge(convertRange(src.getAge()));
//        if (src.hasGestationalAge())
//            tgt.setGestationalAge(convertRange(src.getGestationalAge()));
//        if (src.hasCondition())
//            tgt.setConditionElement(convertString(src.getConditionElement()));
//        return tgt;
//    }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ObservationDefinition.ObservationRangeCategory> convertObservationRangeCategory(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ObservationDefinition.ObservationRangeCategory> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<ObservationDefinition.ObservationRangeCategory> tgt = new Enumeration<>(new ObservationDefinition.ObservationRangeCategoryEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case REFERENCE:
                  tgt.setValue(ObservationDefinition.ObservationRangeCategory.REFERENCE);
                  break;
              case CRITICAL:
                  tgt.setValue(ObservationDefinition.ObservationRangeCategory.CRITICAL);
                  break;
              case ABSOLUTE:
                  tgt.setValue(ObservationDefinition.ObservationRangeCategory.ABSOLUTE);
                  break;
              default:
                  tgt.setValue(ObservationDefinition.ObservationRangeCategory.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ObservationDefinition.ObservationRangeCategory> convertObservationRangeCategory(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ObservationDefinition.ObservationRangeCategory> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ObservationDefinition.ObservationRangeCategory> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ObservationDefinition.ObservationRangeCategoryEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case REFERENCE:
                  tgt.setValue(org.hl7.fhir.r4.model.ObservationDefinition.ObservationRangeCategory.REFERENCE);
                  break;
              case CRITICAL:
                  tgt.setValue(org.hl7.fhir.r4.model.ObservationDefinition.ObservationRangeCategory.CRITICAL);
                  break;
              case ABSOLUTE:
                  tgt.setValue(org.hl7.fhir.r4.model.ObservationDefinition.ObservationRangeCategory.ABSOLUTE);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4.model.ObservationDefinition.ObservationRangeCategory.NULL);
                  break;
          }
      }
      return tgt;
  }
}