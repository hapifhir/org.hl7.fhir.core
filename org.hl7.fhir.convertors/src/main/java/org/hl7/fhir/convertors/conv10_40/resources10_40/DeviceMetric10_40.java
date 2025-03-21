package org.hl7.fhir.convertors.conv10_40.resources10_40;

import org.hl7.fhir.convertors.context.ConversionContext10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Reference10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.CodeableConcept10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Identifier10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Timing10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.Instant10_40;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.DeviceMetric;
import org.hl7.fhir.r4.model.Enumeration;

public class DeviceMetric10_40 {

  public static org.hl7.fhir.r4.model.DeviceMetric convertDeviceMetric(org.hl7.fhir.dstu2.model.DeviceMetric src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.DeviceMetric tgt = new org.hl7.fhir.r4.model.DeviceMetric();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyDomainResource(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept10_40.convertCodeableConcept(src.getType()));
    if (src.hasIdentifier())
      tgt.addIdentifier(Identifier10_40.convertIdentifier(src.getIdentifier()));
    if (src.hasUnit())
      tgt.setUnit(CodeableConcept10_40.convertCodeableConcept(src.getUnit()));
    if (src.hasSource())
      tgt.setSource(Reference10_40.convertReference(src.getSource()));
    if (src.hasParent())
      tgt.setParent(Reference10_40.convertReference(src.getParent()));
    if (src.hasOperationalStatus())
      tgt.setOperationalStatusElement(convertDeviceMetricOperationalStatus(src.getOperationalStatusElement()));
    if (src.hasColor())
      tgt.setColorElement(convertDeviceMetricColor(src.getColorElement()));
    if (src.hasCategory())
      tgt.setCategoryElement(convertDeviceMetricCategory(src.getCategoryElement()));
    if (src.hasMeasurementPeriod())
      tgt.setMeasurementPeriod(Timing10_40.convertTiming(src.getMeasurementPeriod()));
    for (org.hl7.fhir.dstu2.model.DeviceMetric.DeviceMetricCalibrationComponent t : src.getCalibration())
      tgt.addCalibration(convertDeviceMetricCalibrationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.DeviceMetric convertDeviceMetric(org.hl7.fhir.r4.model.DeviceMetric src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.DeviceMetric tgt = new org.hl7.fhir.dstu2.model.DeviceMetric();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyDomainResource(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept10_40.convertCodeableConcept(src.getType()));
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier10_40.convertIdentifier(src.getIdentifierFirstRep()));
    if (src.hasUnit())
      tgt.setUnit(CodeableConcept10_40.convertCodeableConcept(src.getUnit()));
    if (src.hasSource())
      tgt.setSource(Reference10_40.convertReference(src.getSource()));
    if (src.hasParent())
      tgt.setParent(Reference10_40.convertReference(src.getParent()));
    if (src.hasOperationalStatus())
      tgt.setOperationalStatusElement(convertDeviceMetricOperationalStatus(src.getOperationalStatusElement()));
    if (src.hasColor())
      tgt.setColorElement(convertDeviceMetricColor(src.getColorElement()));
    if (src.hasCategory())
      tgt.setCategoryElement(convertDeviceMetricCategory(src.getCategoryElement()));
    if (src.hasMeasurementPeriod())
      tgt.setMeasurementPeriod(Timing10_40.convertTiming(src.getMeasurementPeriod()));
    for (org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationComponent t : src.getCalibration())
      tgt.addCalibration(convertDeviceMetricCalibrationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.DeviceMetric.DeviceMetricCalibrationComponent convertDeviceMetricCalibrationComponent(org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.DeviceMetric.DeviceMetricCalibrationComponent tgt = new org.hl7.fhir.dstu2.model.DeviceMetric.DeviceMetricCalibrationComponent();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyBackboneElement(src,tgt);
    if (src.hasType())
      tgt.setTypeElement(convertDeviceMetricCalibrationType(src.getTypeElement()));
    if (src.hasState())
      tgt.setStateElement(convertDeviceMetricCalibrationState(src.getStateElement()));
    if (src.hasTimeElement())
      tgt.setTimeElement(Instant10_40.convertInstant(src.getTimeElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationComponent convertDeviceMetricCalibrationComponent(org.hl7.fhir.dstu2.model.DeviceMetric.DeviceMetricCalibrationComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationComponent tgt = new org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationComponent();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyBackboneElement(src,tgt);
    if (src.hasType())
      tgt.setTypeElement(convertDeviceMetricCalibrationType(src.getTypeElement()));
    if (src.hasState())
      tgt.setStateElement(convertDeviceMetricCalibrationState(src.getStateElement()));
    if (src.hasTimeElement())
      tgt.setTimeElement(Instant10_40.convertInstant(src.getTimeElement()));
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationState> convertDeviceMetricCalibrationState(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.DeviceMetric.DeviceMetricCalibrationState> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<DeviceMetric.DeviceMetricCalibrationState> tgt = new Enumeration<>(new DeviceMetric.DeviceMetricCalibrationStateEnumFactory());
      ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
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

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.DeviceMetric.DeviceMetricCalibrationState> convertDeviceMetricCalibrationState(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationState> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.DeviceMetric.DeviceMetricCalibrationState> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.DeviceMetric.DeviceMetricCalibrationStateEnumFactory());
      ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case NOTCALIBRATED:
                  tgt.setValue(org.hl7.fhir.dstu2.model.DeviceMetric.DeviceMetricCalibrationState.NOTCALIBRATED);
                  break;
              case CALIBRATIONREQUIRED:
                  tgt.setValue(org.hl7.fhir.dstu2.model.DeviceMetric.DeviceMetricCalibrationState.CALIBRATIONREQUIRED);
                  break;
              case CALIBRATED:
                  tgt.setValue(org.hl7.fhir.dstu2.model.DeviceMetric.DeviceMetricCalibrationState.CALIBRATED);
                  break;
              case UNSPECIFIED:
                  tgt.setValue(org.hl7.fhir.dstu2.model.DeviceMetric.DeviceMetricCalibrationState.UNSPECIFIED);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.dstu2.model.DeviceMetric.DeviceMetricCalibrationState.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationType> convertDeviceMetricCalibrationType(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.DeviceMetric.DeviceMetricCalibrationType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<DeviceMetric.DeviceMetricCalibrationType> tgt = new Enumeration<>(new DeviceMetric.DeviceMetricCalibrationTypeEnumFactory());
      ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
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

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.DeviceMetric.DeviceMetricCalibrationType> convertDeviceMetricCalibrationType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCalibrationType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.DeviceMetric.DeviceMetricCalibrationType> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.DeviceMetric.DeviceMetricCalibrationTypeEnumFactory());
      ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case UNSPECIFIED:
                  tgt.setValue(org.hl7.fhir.dstu2.model.DeviceMetric.DeviceMetricCalibrationType.UNSPECIFIED);
                  break;
              case OFFSET:
                  tgt.setValue(org.hl7.fhir.dstu2.model.DeviceMetric.DeviceMetricCalibrationType.OFFSET);
                  break;
              case GAIN:
                  tgt.setValue(org.hl7.fhir.dstu2.model.DeviceMetric.DeviceMetricCalibrationType.GAIN);
                  break;
              case TWOPOINT:
                  tgt.setValue(org.hl7.fhir.dstu2.model.DeviceMetric.DeviceMetricCalibrationType.TWOPOINT);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.dstu2.model.DeviceMetric.DeviceMetricCalibrationType.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCategory> convertDeviceMetricCategory(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.DeviceMetric.DeviceMetricCategory> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<DeviceMetric.DeviceMetricCategory> tgt = new Enumeration<>(new DeviceMetric.DeviceMetricCategoryEnumFactory());
      ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
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

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.DeviceMetric.DeviceMetricCategory> convertDeviceMetricCategory(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricCategory> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.DeviceMetric.DeviceMetricCategory> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.DeviceMetric.DeviceMetricCategoryEnumFactory());
      ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case MEASUREMENT:
                  tgt.setValue(org.hl7.fhir.dstu2.model.DeviceMetric.DeviceMetricCategory.MEASUREMENT);
                  break;
              case SETTING:
                  tgt.setValue(org.hl7.fhir.dstu2.model.DeviceMetric.DeviceMetricCategory.SETTING);
                  break;
              case CALCULATION:
                  tgt.setValue(org.hl7.fhir.dstu2.model.DeviceMetric.DeviceMetricCategory.CALCULATION);
                  break;
              case UNSPECIFIED:
                  tgt.setValue(org.hl7.fhir.dstu2.model.DeviceMetric.DeviceMetricCategory.UNSPECIFIED);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.dstu2.model.DeviceMetric.DeviceMetricCategory.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricColor> convertDeviceMetricColor(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.DeviceMetric.DeviceMetricColor> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<DeviceMetric.DeviceMetricColor> tgt = new Enumeration<>(new DeviceMetric.DeviceMetricColorEnumFactory());
      ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case BLACK:
                  tgt.setValue(DeviceMetric.DeviceMetricColor.BLACK);
                  break;
              case RED:
                  tgt.setValue(DeviceMetric.DeviceMetricColor.RED);
                  break;
              case GREEN:
                  tgt.setValue(DeviceMetric.DeviceMetricColor.GREEN);
                  break;
              case YELLOW:
                  tgt.setValue(DeviceMetric.DeviceMetricColor.YELLOW);
                  break;
              case BLUE:
                  tgt.setValue(DeviceMetric.DeviceMetricColor.BLUE);
                  break;
              case MAGENTA:
                  tgt.setValue(DeviceMetric.DeviceMetricColor.MAGENTA);
                  break;
              case CYAN:
                  tgt.setValue(DeviceMetric.DeviceMetricColor.CYAN);
                  break;
              case WHITE:
                  tgt.setValue(DeviceMetric.DeviceMetricColor.WHITE);
                  break;
              default:
                  tgt.setValue(DeviceMetric.DeviceMetricColor.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.DeviceMetric.DeviceMetricColor> convertDeviceMetricColor(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricColor> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.DeviceMetric.DeviceMetricColor> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.DeviceMetric.DeviceMetricColorEnumFactory());
      ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case BLACK:
                  tgt.setValue(org.hl7.fhir.dstu2.model.DeviceMetric.DeviceMetricColor.BLACK);
                  break;
              case RED:
                  tgt.setValue(org.hl7.fhir.dstu2.model.DeviceMetric.DeviceMetricColor.RED);
                  break;
              case GREEN:
                  tgt.setValue(org.hl7.fhir.dstu2.model.DeviceMetric.DeviceMetricColor.GREEN);
                  break;
              case YELLOW:
                  tgt.setValue(org.hl7.fhir.dstu2.model.DeviceMetric.DeviceMetricColor.YELLOW);
                  break;
              case BLUE:
                  tgt.setValue(org.hl7.fhir.dstu2.model.DeviceMetric.DeviceMetricColor.BLUE);
                  break;
              case MAGENTA:
                  tgt.setValue(org.hl7.fhir.dstu2.model.DeviceMetric.DeviceMetricColor.MAGENTA);
                  break;
              case CYAN:
                  tgt.setValue(org.hl7.fhir.dstu2.model.DeviceMetric.DeviceMetricColor.CYAN);
                  break;
              case WHITE:
                  tgt.setValue(org.hl7.fhir.dstu2.model.DeviceMetric.DeviceMetricColor.WHITE);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.dstu2.model.DeviceMetric.DeviceMetricColor.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricOperationalStatus> convertDeviceMetricOperationalStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.DeviceMetric.DeviceMetricOperationalStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<DeviceMetric.DeviceMetricOperationalStatus> tgt = new Enumeration<>(new DeviceMetric.DeviceMetricOperationalStatusEnumFactory());
      ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
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

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.DeviceMetric.DeviceMetricOperationalStatus> convertDeviceMetricOperationalStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceMetric.DeviceMetricOperationalStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.DeviceMetric.DeviceMetricOperationalStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.DeviceMetric.DeviceMetricOperationalStatusEnumFactory());
      ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ON:
                  tgt.setValue(org.hl7.fhir.dstu2.model.DeviceMetric.DeviceMetricOperationalStatus.ON);
                  break;
              case OFF:
                  tgt.setValue(org.hl7.fhir.dstu2.model.DeviceMetric.DeviceMetricOperationalStatus.OFF);
                  break;
              case STANDBY:
                  tgt.setValue(org.hl7.fhir.dstu2.model.DeviceMetric.DeviceMetricOperationalStatus.STANDBY);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.dstu2.model.DeviceMetric.DeviceMetricOperationalStatus.NULL);
                  break;
          }
      }
      return tgt;
  }
}