package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Instant40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.DeviceMetric;
import org.hl7.fhir.model.core.Enumeration;

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

public class DeviceMetric40_N {

  public static org.hl7.fhir.model.core.DeviceMetric convertDeviceMetric(org.hl7.fhir.r4.model.DeviceMetric src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.DeviceMetric tgt = new org.hl7.fhir.model.core.DeviceMetric();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasUnit())
      tgt.setUnit(CodeableConcept40_N.convertCodeableConcept(src.getUnit()));
    if (src.hasParent())
      tgt.setDevice(Reference40_N.convertReference(src.getParent()));
    if (src.hasSource())
      tgt.setDevice(Reference40_N.convertReference(src.getSource()));
    if (src.hasOperationalStatus())
      tgt.setOperationalStatusElement(convertDeviceMetricOperationalStatus(src.getOperationalStatusElement()));
    if (src.hasColor())
      tgt.setColor(convertDeviceMetricColor(src.getColorElement()));
//    if (src.hasMeasurementPeriod())
//      tgt.setMeasurementPeriod(Timing40_N.convertTiming(src.getMeasurementPeriod()));
    for (org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationComponent t : src.getCalibration())
      tgt.addCalibration(convertDeviceMetricCalibrationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DeviceMetric convertDeviceMetric(org.hl7.fhir.model.core.DeviceMetric src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.DeviceMetric tgt = new org.hl7.fhir.r4.model.DeviceMetric();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasUnit())
      tgt.setUnit(CodeableConcept40_N.convertCodeableConcept(src.getUnit()));
    if (src.hasDevice())
      tgt.setSource(Reference40_N.convertReference(src.getDevice()));
//    if (src.hasParent())
//      tgt.setParent(Reference40_N.convertReference(src.getParent()));
    if (src.hasOperationalStatus())
      tgt.setOperationalStatusElement(convertDeviceMetricOperationalStatus(src.getOperationalStatusElement()));
    if (src.hasColor())
      tgt.setColorElement(convertDeviceMetricColor(src.getColor()));
//    if (src.hasMeasurementPeriod())
//      tgt.setMeasurementPeriod(Timing40_N.convertTiming(src.getMeasurementPeriod()));
    for (org.hl7.fhir.model.core.DeviceMetric.DeviceMetricCalibrationComponent t : src.getCalibrationList())
      tgt.addCalibration(convertDeviceMetricCalibrationComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.DeviceMetric.DeviceMetricOperationalStatus> convertDeviceMetricOperationalStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricOperationalStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<DeviceMetric.DeviceMetricOperationalStatus> tgt = new Enumeration<>(new DeviceMetric.DeviceMetricOperationalStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
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
              default:
                  tgt.setValue(DeviceMetric.DeviceMetricOperationalStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricOperationalStatus> convertDeviceMetricOperationalStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.DeviceMetric.DeviceMetricOperationalStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricOperationalStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricOperationalStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
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
              default:
                  tgt.setValue(org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricOperationalStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.model.core.CodeableConcept convertDeviceMetricColor(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricColor> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.model.core.CodeableConcept tgt = new org.hl7.fhir.model.core.CodeableConcept();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    tgt.addCoding("http://terminology.hl7.org/ValueSet/color-codes", src.getCode(), null);
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricColor> convertDeviceMetricColor(org.hl7.fhir.model.core.CodeableConcept src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricColor> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricColorEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    try {
      tgt.setValue(org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricColor.fromCode(src.getCodingFirstRep().getCode()));
    } catch (Exception e) {
      tgt.setValue(org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricColor.NULL);
    }
    return tgt;
  }

  static public org.hl7.fhir.model.core.CodeableConcept convertDeviceMetricCategory(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCategory> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
    org.hl7.fhir.model.core.CodeableConcept tgt = new org.hl7.fhir.model.core.CodeableConcept();
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() != null) {
          switch (src.getValue()) {
              case MEASUREMENT:
                tgt.addCoding("http://terminology.hl7.org/CodeSystem/metric-category", "measurement", "Measurement");
                  break;
              case SETTING:
                tgt.addCoding("http://terminology.hl7.org/CodeSystem/metric-category", "setting", "Setting");
                  break;
              case CALCULATION:
                tgt.addCoding("http://terminology.hl7.org/CodeSystem/metric-category", "calculation", "Calculation");
                  break;
              case UNSPECIFIED:
                tgt.addCoding("http://terminology.hl7.org/CodeSystem/metric-category", "unspecified", "Unspecified");
                  break;
              default:
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCategory> convertDeviceMetricCategory(org.hl7.fhir.model.core.CodeableConcept src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCategory> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCategoryEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);

    if (src.hasCoding("http://terminology.hl7.org/CodeSystem/metric-category", "measurement")) {
      tgt.setValue(org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCategory.MEASUREMENT);
    } else if (src.hasCoding("http://terminology.hl7.org/CodeSystem/metric-category", "setting")) {
      tgt.setValue(org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCategory.SETTING);
    } else if (src.hasCoding("http://terminology.hl7.org/CodeSystem/metric-category", "calculation")) {
      tgt.setValue(org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCategory.CALCULATION);
    } else if (src.hasCoding("http://terminology.hl7.org/CodeSystem/metric-category", "unspecified")) {
      tgt.setValue(org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCategory.UNSPECIFIED);
    }
    return tgt;
  }

  public static org.hl7.fhir.model.core.DeviceMetric.DeviceMetricCalibrationComponent convertDeviceMetricCalibrationComponent(org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.DeviceMetric.DeviceMetricCalibrationComponent tgt = new org.hl7.fhir.model.core.DeviceMetric.DeviceMetricCalibrationComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(convertDeviceMetricCalibrationType(src.getTypeElement()));
    if (src.hasState())
      tgt.setState(convertDeviceMetricCalibrationState(src.getStateElement()));
    if (src.hasTime())
      tgt.setTimeElement(Instant40_N.convertInstant(src.getTimeElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationComponent convertDeviceMetricCalibrationComponent(org.hl7.fhir.model.core.DeviceMetric.DeviceMetricCalibrationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationComponent tgt = new org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(convertDeviceMetricCalibrationType(src.getType()));
    if (src.hasState())
      tgt.setStateElement(convertDeviceMetricCalibrationState(src.getState()));
    if (src.hasTime())
      tgt.setTimeElement(Instant40_N.convertInstant(src.getTimeElement()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.CodeableConcept convertDeviceMetricCalibrationType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
    org.hl7.fhir.model.core.CodeableConcept tgt = new org.hl7.fhir.model.core.CodeableConcept();
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() != null) {
          switch (src.getValue()) {
              case UNSPECIFIED:
                tgt.addCoding("http://terminology.hl7.org/CodeSystem/metric-calibration-type", "unspecified", "Unspecified");
                  break;
              case OFFSET:
                tgt.addCoding("http://terminology.hl7.org/CodeSystem/metric-calibration-type", "offset", "Offset");
                  break;
              case GAIN:
                tgt.addCoding("http://terminology.hl7.org/CodeSystem/metric-calibration-type", "gain", "Gain");
                  break;
              case TWOPOINT:
                tgt.addCoding("http://terminology.hl7.org/CodeSystem/metric-calibration-type", "two-point", "Two Point");
                  break;
              default:
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationType> convertDeviceMetricCalibrationType(org.hl7.fhir.model.core.CodeableConcept src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationTypeEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasCoding("http://terminology.hl7.org/CodeSystem/metric-calibration-type", "unspecified")) {
      tgt.setValue(org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationType.UNSPECIFIED);
    } else if (src.hasCoding("http://terminology.hl7.org/CodeSystem/metric-calibration-type", "offset")) {
      tgt.setValue(org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationType.OFFSET);
    } else if (src.hasCoding("http://terminology.hl7.org/CodeSystem/metric-calibration-type", "gain")) {
      tgt.setValue(org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationType.GAIN);
    } else if (src.hasCoding("http://terminology.hl7.org/CodeSystem/metric-calibration-type", "two-point")) {
      tgt.setValue(org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationType.TWOPOINT);
    }
    return tgt;
  }

  static public org.hl7.fhir.model.core.CodeableConcept convertDeviceMetricCalibrationState(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationState> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.model.core.CodeableConcept tgt = new org.hl7.fhir.model.core.CodeableConcept();
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() != null) {
          switch (src.getValue()) {
              case NOTCALIBRATED:
                tgt.addCoding("http://terminology.hl7.org/CodeSystem/metric-calibration-state", "not-calibrated", "Not Calibrated");
                  break;
              case CALIBRATIONREQUIRED:
                tgt.addCoding("http://terminology.hl7.org/CodeSystem/metric-calibration-state", "calibration-required", "Calibration Required");
                  break;
              case CALIBRATED:
                tgt.addCoding("http://terminology.hl7.org/CodeSystem/metric-calibration-state", "calibrated", "Calibrated");
                  break;
              case UNSPECIFIED:
                tgt.addCoding("http://terminology.hl7.org/CodeSystem/metric-calibration-state", "unknown", "Unknown");
                  break;
              default:
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationState> convertDeviceMetricCalibrationState(org.hl7.fhir.model.core.CodeableConcept src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationState> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationStateEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.hasCoding("http://terminology.hl7.org/CodeSystem/metric-calibration-state", "not-calibrated")) {
        tgt.setValue(org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationState.NOTCALIBRATED);
      } else if (src.hasCoding("http://terminology.hl7.org/CodeSystem/metric-calibration-state", "calibration-required")) {
        tgt.setValue(org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationState.CALIBRATIONREQUIRED);
      } else if (src.hasCoding("http://terminology.hl7.org/CodeSystem/metric-calibration-state", "calibrated")) {
        tgt.setValue(org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationState.CALIBRATED);
      } else if (src.hasCoding("http://terminology.hl7.org/CodeSystem/metric-calibration-state", "unknown")) {
        tgt.setValue(org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationState.UNSPECIFIED);
      }
      return tgt;
  }
}