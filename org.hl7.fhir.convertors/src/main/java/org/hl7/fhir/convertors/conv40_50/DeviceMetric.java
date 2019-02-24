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


public class DeviceMetric extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.DeviceMetric convertDeviceMetric(org.hl7.fhir.r4.model.DeviceMetric src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.DeviceMetric tgt = new org.hl7.fhir.r5.model.DeviceMetric();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    if (src.hasUnit())
      tgt.setUnit(convertCodeableConcept(src.getUnit()));
    if (src.hasSource())
      tgt.setSource(convertReference(src.getSource()));
    if (src.hasParent())
      tgt.setParent(convertReference(src.getParent()));
    if (src.hasOperationalStatus())
      tgt.setOperationalStatus(convertDeviceMetricOperationalStatus(src.getOperationalStatus()));
    if (src.hasColor())
      tgt.setColor(convertDeviceMetricColor(src.getColor()));
    if (src.hasCategory())
      tgt.setCategory(convertDeviceMetricCategory(src.getCategory()));
    if (src.hasMeasurementPeriod())
      tgt.setMeasurementPeriod(convertTiming(src.getMeasurementPeriod()));
    for (org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationComponent t : src.getCalibration())
      tgt.addCalibration(convertDeviceMetricCalibrationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DeviceMetric convertDeviceMetric(org.hl7.fhir.r5.model.DeviceMetric src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.DeviceMetric tgt = new org.hl7.fhir.r4.model.DeviceMetric();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    if (src.hasUnit())
      tgt.setUnit(convertCodeableConcept(src.getUnit()));
    if (src.hasSource())
      tgt.setSource(convertReference(src.getSource()));
    if (src.hasParent())
      tgt.setParent(convertReference(src.getParent()));
    if (src.hasOperationalStatus())
      tgt.setOperationalStatus(convertDeviceMetricOperationalStatus(src.getOperationalStatus()));
    if (src.hasColor())
      tgt.setColor(convertDeviceMetricColor(src.getColor()));
    if (src.hasCategory())
      tgt.setCategory(convertDeviceMetricCategory(src.getCategory()));
    if (src.hasMeasurementPeriod())
      tgt.setMeasurementPeriod(convertTiming(src.getMeasurementPeriod()));
    for (org.hl7.fhir.r5.model.DeviceMetric.DeviceMetricCalibrationComponent t : src.getCalibration())
      tgt.addCalibration(convertDeviceMetricCalibrationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.DeviceMetric.DeviceMetricOperationalStatus convertDeviceMetricOperationalStatus(org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricOperationalStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case ON: return org.hl7.fhir.r5.model.DeviceMetric.DeviceMetricOperationalStatus.ON;
    case OFF: return org.hl7.fhir.r5.model.DeviceMetric.DeviceMetricOperationalStatus.OFF;
    case STANDBY: return org.hl7.fhir.r5.model.DeviceMetric.DeviceMetricOperationalStatus.STANDBY;
    case ENTEREDINERROR: return org.hl7.fhir.r5.model.DeviceMetric.DeviceMetricOperationalStatus.ENTEREDINERROR;
    default: return org.hl7.fhir.r5.model.DeviceMetric.DeviceMetricOperationalStatus.NULL;
  }
}

  public static org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricOperationalStatus convertDeviceMetricOperationalStatus(org.hl7.fhir.r5.model.DeviceMetric.DeviceMetricOperationalStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case ON: return org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricOperationalStatus.ON;
    case OFF: return org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricOperationalStatus.OFF;
    case STANDBY: return org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricOperationalStatus.STANDBY;
    case ENTEREDINERROR: return org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricOperationalStatus.ENTEREDINERROR;
    default: return org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricOperationalStatus.NULL;
  }
}

  public static org.hl7.fhir.r5.model.DeviceMetric.DeviceMetricColor convertDeviceMetricColor(org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricColor src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case BLACK: return org.hl7.fhir.r5.model.DeviceMetric.DeviceMetricColor.BLACK;
    case RED: return org.hl7.fhir.r5.model.DeviceMetric.DeviceMetricColor.RED;
    case GREEN: return org.hl7.fhir.r5.model.DeviceMetric.DeviceMetricColor.GREEN;
    case YELLOW: return org.hl7.fhir.r5.model.DeviceMetric.DeviceMetricColor.YELLOW;
    case BLUE: return org.hl7.fhir.r5.model.DeviceMetric.DeviceMetricColor.BLUE;
    case MAGENTA: return org.hl7.fhir.r5.model.DeviceMetric.DeviceMetricColor.MAGENTA;
    case CYAN: return org.hl7.fhir.r5.model.DeviceMetric.DeviceMetricColor.CYAN;
    case WHITE: return org.hl7.fhir.r5.model.DeviceMetric.DeviceMetricColor.WHITE;
    default: return org.hl7.fhir.r5.model.DeviceMetric.DeviceMetricColor.NULL;
  }
}

  public static org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricColor convertDeviceMetricColor(org.hl7.fhir.r5.model.DeviceMetric.DeviceMetricColor src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case BLACK: return org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricColor.BLACK;
    case RED: return org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricColor.RED;
    case GREEN: return org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricColor.GREEN;
    case YELLOW: return org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricColor.YELLOW;
    case BLUE: return org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricColor.BLUE;
    case MAGENTA: return org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricColor.MAGENTA;
    case CYAN: return org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricColor.CYAN;
    case WHITE: return org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricColor.WHITE;
    default: return org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricColor.NULL;
  }
}

  public static org.hl7.fhir.r5.model.DeviceMetric.DeviceMetricCategory convertDeviceMetricCategory(org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCategory src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case MEASUREMENT: return org.hl7.fhir.r5.model.DeviceMetric.DeviceMetricCategory.MEASUREMENT;
    case SETTING: return org.hl7.fhir.r5.model.DeviceMetric.DeviceMetricCategory.SETTING;
    case CALCULATION: return org.hl7.fhir.r5.model.DeviceMetric.DeviceMetricCategory.CALCULATION;
    case UNSPECIFIED: return org.hl7.fhir.r5.model.DeviceMetric.DeviceMetricCategory.UNSPECIFIED;
    default: return org.hl7.fhir.r5.model.DeviceMetric.DeviceMetricCategory.NULL;
  }
}

  public static org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCategory convertDeviceMetricCategory(org.hl7.fhir.r5.model.DeviceMetric.DeviceMetricCategory src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case MEASUREMENT: return org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCategory.MEASUREMENT;
    case SETTING: return org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCategory.SETTING;
    case CALCULATION: return org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCategory.CALCULATION;
    case UNSPECIFIED: return org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCategory.UNSPECIFIED;
    default: return org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCategory.NULL;
  }
}

  public static org.hl7.fhir.r5.model.DeviceMetric.DeviceMetricCalibrationComponent convertDeviceMetricCalibrationComponent(org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.DeviceMetric.DeviceMetricCalibrationComponent tgt = new org.hl7.fhir.r5.model.DeviceMetric.DeviceMetricCalibrationComponent();
    copyElement(src, tgt);
    if (src.hasType())
      tgt.setType(convertDeviceMetricCalibrationType(src.getType()));
    if (src.hasState())
      tgt.setState(convertDeviceMetricCalibrationState(src.getState()));
    if (src.hasTime())
      tgt.setTimeElement(convertInstant(src.getTimeElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationComponent convertDeviceMetricCalibrationComponent(org.hl7.fhir.r5.model.DeviceMetric.DeviceMetricCalibrationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationComponent tgt = new org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationComponent();
    copyElement(src, tgt);
    if (src.hasType())
      tgt.setType(convertDeviceMetricCalibrationType(src.getType()));
    if (src.hasState())
      tgt.setState(convertDeviceMetricCalibrationState(src.getState()));
    if (src.hasTime())
      tgt.setTimeElement(convertInstant(src.getTimeElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.DeviceMetric.DeviceMetricCalibrationType convertDeviceMetricCalibrationType(org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case UNSPECIFIED: return org.hl7.fhir.r5.model.DeviceMetric.DeviceMetricCalibrationType.UNSPECIFIED;
    case OFFSET: return org.hl7.fhir.r5.model.DeviceMetric.DeviceMetricCalibrationType.OFFSET;
    case GAIN: return org.hl7.fhir.r5.model.DeviceMetric.DeviceMetricCalibrationType.GAIN;
    case TWOPOINT: return org.hl7.fhir.r5.model.DeviceMetric.DeviceMetricCalibrationType.TWOPOINT;
    default: return org.hl7.fhir.r5.model.DeviceMetric.DeviceMetricCalibrationType.NULL;
  }
}

  public static org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationType convertDeviceMetricCalibrationType(org.hl7.fhir.r5.model.DeviceMetric.DeviceMetricCalibrationType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case UNSPECIFIED: return org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationType.UNSPECIFIED;
    case OFFSET: return org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationType.OFFSET;
    case GAIN: return org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationType.GAIN;
    case TWOPOINT: return org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationType.TWOPOINT;
    default: return org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationType.NULL;
  }
}

  public static org.hl7.fhir.r5.model.DeviceMetric.DeviceMetricCalibrationState convertDeviceMetricCalibrationState(org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationState src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case NOTCALIBRATED: return org.hl7.fhir.r5.model.DeviceMetric.DeviceMetricCalibrationState.NOTCALIBRATED;
    case CALIBRATIONREQUIRED: return org.hl7.fhir.r5.model.DeviceMetric.DeviceMetricCalibrationState.CALIBRATIONREQUIRED;
    case CALIBRATED: return org.hl7.fhir.r5.model.DeviceMetric.DeviceMetricCalibrationState.CALIBRATED;
    case UNSPECIFIED: return org.hl7.fhir.r5.model.DeviceMetric.DeviceMetricCalibrationState.UNSPECIFIED;
    default: return org.hl7.fhir.r5.model.DeviceMetric.DeviceMetricCalibrationState.NULL;
  }
}

  public static org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationState convertDeviceMetricCalibrationState(org.hl7.fhir.r5.model.DeviceMetric.DeviceMetricCalibrationState src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case NOTCALIBRATED: return org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationState.NOTCALIBRATED;
    case CALIBRATIONREQUIRED: return org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationState.CALIBRATIONREQUIRED;
    case CALIBRATED: return org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationState.CALIBRATED;
    case UNSPECIFIED: return org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationState.UNSPECIFIED;
    default: return org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationState.NULL;
  }
}


}
