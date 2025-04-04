package org.hl7.fhir.convertors.conv40_50.resources40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.CodeableConcept40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Identifier40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Instant40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Reference40_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.DeviceMetric;
import org.hl7.fhir.r5.model.Enumeration;

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
public class DeviceMetric40_50 {

  public static org.hl7.fhir.r5.model.DeviceMetric convertDeviceMetric(org.hl7.fhir.r4.model.DeviceMetric src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.DeviceMetric tgt = new org.hl7.fhir.r5.model.DeviceMetric();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    if (src.hasType())
      tgt.setType(CodeableConcept40_50.convertCodeableConcept(src.getType()));
    if (src.hasUnit())
      tgt.setUnit(CodeableConcept40_50.convertCodeableConcept(src.getUnit()));
    if (src.hasParent())
      tgt.setDevice(Reference40_50.convertReference(src.getParent()));
    if (src.hasSource())
      tgt.setDevice(Reference40_50.convertReference(src.getSource()));
    if (src.hasOperationalStatus())
      tgt.setOperationalStatusElement(convertDeviceMetricOperationalStatus(src.getOperationalStatusElement()));
    if (src.hasColor())
      tgt.setColorElement(convertDeviceMetricColor(src.getColorElement()));
    if (src.hasCategory())
      tgt.setCategoryElement(convertDeviceMetricCategory(src.getCategoryElement()));
//    if (src.hasMeasurementPeriod())
//      tgt.setMeasurementPeriod(Timing40_50.convertTiming(src.getMeasurementPeriod()));
    for (org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationComponent t : src.getCalibration())
      tgt.addCalibration(convertDeviceMetricCalibrationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DeviceMetric convertDeviceMetric(org.hl7.fhir.r5.model.DeviceMetric src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.DeviceMetric tgt = new org.hl7.fhir.r4.model.DeviceMetric();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    if (src.hasType())
      tgt.setType(CodeableConcept40_50.convertCodeableConcept(src.getType()));
    if (src.hasUnit())
      tgt.setUnit(CodeableConcept40_50.convertCodeableConcept(src.getUnit()));
    if (src.hasDevice())
      tgt.setSource(Reference40_50.convertReference(src.getDevice()));
//    if (src.hasParent())
//      tgt.setParent(Reference40_50.convertReference(src.getParent()));
    if (src.hasOperationalStatus())
      tgt.setOperationalStatusElement(convertDeviceMetricOperationalStatus(src.getOperationalStatusElement()));
    if (src.hasColor())
      tgt.setColorElement(convertDeviceMetricColor(src.getColorElement()));
    if (src.hasCategory())
      tgt.setCategoryElement(convertDeviceMetricCategory(src.getCategoryElement()));
//    if (src.hasMeasurementPeriod())
//      tgt.setMeasurementPeriod(Timing40_50.convertTiming(src.getMeasurementPeriod()));
    for (org.hl7.fhir.r5.model.DeviceMetric.DeviceMetricCalibrationComponent t : src.getCalibration())
      tgt.addCalibration(convertDeviceMetricCalibrationComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.DeviceMetric.DeviceMetricOperationalStatus> convertDeviceMetricOperationalStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricOperationalStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<DeviceMetric.DeviceMetricOperationalStatus> tgt = new Enumeration<>(new DeviceMetric.DeviceMetricOperationalStatusEnumFactory());
      ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ON:
                  tgt.setValue(DeviceMetric.DeviceMetricOperationalStatus.ON);
                  break;
              case OFF:
                  tgt.setValue(DeviceMetric.DeviceMetricOperationalStatus.OFF);
                  break;
              case STANDBY:
                  tgt.setValue(DeviceMetric.DeviceMetricOperationalStatus.STANDBY);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(DeviceMetric.DeviceMetricOperationalStatus.ENTEREDINERROR);
                  break;
              default:
                  tgt.setValue(DeviceMetric.DeviceMetricOperationalStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricOperationalStatus> convertDeviceMetricOperationalStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.DeviceMetric.DeviceMetricOperationalStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricOperationalStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricOperationalStatusEnumFactory());
      ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ON:
                  tgt.setValue(org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricOperationalStatus.ON);
                  break;
              case OFF:
                  tgt.setValue(org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricOperationalStatus.OFF);
                  break;
              case STANDBY:
                  tgt.setValue(org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricOperationalStatus.STANDBY);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricOperationalStatus.ENTEREDINERROR);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricOperationalStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r5.model.CodeType convertDeviceMetricColor(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricColor> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.CodeType tgt = new org.hl7.fhir.r5.model.CodeType();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    tgt.setValue(src.getCode());
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricColor> convertDeviceMetricColor(org.hl7.fhir.r5.model.CodeType src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricColor> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricColorEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
    case "black":
      tgt.setValue(org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricColor.BLACK);
      break;
    case "red":
      tgt.setValue(org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricColor.RED);
      break;
    case "green":
      tgt.setValue(org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricColor.GREEN);
      break;
    case "yellow":
      tgt.setValue(org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricColor.YELLOW);
      break;
    case "blue":
      tgt.setValue(org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricColor.BLUE);
      break;
    case "magenta":
      tgt.setValue(org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricColor.MAGENTA);
      break;
    case "cyan":
      tgt.setValue(org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricColor.CYAN);
      break;
    case "white":
      tgt.setValue(org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricColor.WHITE);
      break;
    default:
      tgt.setValue(org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricColor.NULL);
      break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.DeviceMetric.DeviceMetricCategory> convertDeviceMetricCategory(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCategory> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<DeviceMetric.DeviceMetricCategory> tgt = new Enumeration<>(new DeviceMetric.DeviceMetricCategoryEnumFactory());
      ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case MEASUREMENT:
                  tgt.setValue(DeviceMetric.DeviceMetricCategory.MEASUREMENT);
                  break;
              case SETTING:
                  tgt.setValue(DeviceMetric.DeviceMetricCategory.SETTING);
                  break;
              case CALCULATION:
                  tgt.setValue(DeviceMetric.DeviceMetricCategory.CALCULATION);
                  break;
              case UNSPECIFIED:
                  tgt.setValue(DeviceMetric.DeviceMetricCategory.UNSPECIFIED);
                  break;
              default:
                  tgt.setValue(DeviceMetric.DeviceMetricCategory.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCategory> convertDeviceMetricCategory(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.DeviceMetric.DeviceMetricCategory> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCategory> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCategoryEnumFactory());
      ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case MEASUREMENT:
                  tgt.setValue(org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCategory.MEASUREMENT);
                  break;
              case SETTING:
                  tgt.setValue(org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCategory.SETTING);
                  break;
              case CALCULATION:
                  tgt.setValue(org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCategory.CALCULATION);
                  break;
              case UNSPECIFIED:
                  tgt.setValue(org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCategory.UNSPECIFIED);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCategory.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.r5.model.DeviceMetric.DeviceMetricCalibrationComponent convertDeviceMetricCalibrationComponent(org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.DeviceMetric.DeviceMetricCalibrationComponent tgt = new org.hl7.fhir.r5.model.DeviceMetric.DeviceMetricCalibrationComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(convertDeviceMetricCalibrationType(src.getTypeElement()));
    if (src.hasState())
      tgt.setStateElement(convertDeviceMetricCalibrationState(src.getStateElement()));
    if (src.hasTime())
      tgt.setTimeElement(Instant40_50.convertInstant(src.getTimeElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationComponent convertDeviceMetricCalibrationComponent(org.hl7.fhir.r5.model.DeviceMetric.DeviceMetricCalibrationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationComponent tgt = new org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(convertDeviceMetricCalibrationType(src.getTypeElement()));
    if (src.hasState())
      tgt.setStateElement(convertDeviceMetricCalibrationState(src.getStateElement()));
    if (src.hasTime())
      tgt.setTimeElement(Instant40_50.convertInstant(src.getTimeElement()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.DeviceMetric.DeviceMetricCalibrationType> convertDeviceMetricCalibrationType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<DeviceMetric.DeviceMetricCalibrationType> tgt = new Enumeration<>(new DeviceMetric.DeviceMetricCalibrationTypeEnumFactory());
      ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case UNSPECIFIED:
                  tgt.setValue(DeviceMetric.DeviceMetricCalibrationType.UNSPECIFIED);
                  break;
              case OFFSET:
                  tgt.setValue(DeviceMetric.DeviceMetricCalibrationType.OFFSET);
                  break;
              case GAIN:
                  tgt.setValue(DeviceMetric.DeviceMetricCalibrationType.GAIN);
                  break;
              case TWOPOINT:
                  tgt.setValue(DeviceMetric.DeviceMetricCalibrationType.TWOPOINT);
                  break;
              default:
                  tgt.setValue(DeviceMetric.DeviceMetricCalibrationType.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationType> convertDeviceMetricCalibrationType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.DeviceMetric.DeviceMetricCalibrationType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationTypeEnumFactory());
      ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case UNSPECIFIED:
                  tgt.setValue(org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationType.UNSPECIFIED);
                  break;
              case OFFSET:
                  tgt.setValue(org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationType.OFFSET);
                  break;
              case GAIN:
                  tgt.setValue(org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationType.GAIN);
                  break;
              case TWOPOINT:
                  tgt.setValue(org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationType.TWOPOINT);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationType.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.DeviceMetric.DeviceMetricCalibrationState> convertDeviceMetricCalibrationState(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationState> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<DeviceMetric.DeviceMetricCalibrationState> tgt = new Enumeration<>(new DeviceMetric.DeviceMetricCalibrationStateEnumFactory());
      ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case NOTCALIBRATED:
                  tgt.setValue(DeviceMetric.DeviceMetricCalibrationState.NOTCALIBRATED);
                  break;
              case CALIBRATIONREQUIRED:
                  tgt.setValue(DeviceMetric.DeviceMetricCalibrationState.CALIBRATIONREQUIRED);
                  break;
              case CALIBRATED:
                  tgt.setValue(DeviceMetric.DeviceMetricCalibrationState.CALIBRATED);
                  break;
              case UNSPECIFIED:
                  tgt.setValue(DeviceMetric.DeviceMetricCalibrationState.UNSPECIFIED);
                  break;
              default:
                  tgt.setValue(DeviceMetric.DeviceMetricCalibrationState.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationState> convertDeviceMetricCalibrationState(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.DeviceMetric.DeviceMetricCalibrationState> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationState> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationStateEnumFactory());
      ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case NOTCALIBRATED:
                  tgt.setValue(org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationState.NOTCALIBRATED);
                  break;
              case CALIBRATIONREQUIRED:
                  tgt.setValue(org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationState.CALIBRATIONREQUIRED);
                  break;
              case CALIBRATED:
                  tgt.setValue(org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationState.CALIBRATED);
                  break;
              case UNSPECIFIED:
                  tgt.setValue(org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationState.UNSPECIFIED);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationState.NULL);
                  break;
          }
      }
      return tgt;
  }
}