package org.hl7.fhir.convertors.conv30_40.resources30_40;

import org.hl7.fhir.convertors.context.ConversionContext30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Reference30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Annotation30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.CodeableConcept30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Identifier30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.DateTime30_40;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.DeviceUseStatement;
import org.hl7.fhir.r4.model.Enumeration;

public class DeviceUseStatement30_40 {

  public static org.hl7.fhir.r4.model.DeviceUseStatement convertDeviceUseStatement(org.hl7.fhir.dstu3.model.DeviceUseStatement src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.DeviceUseStatement tgt = new org.hl7.fhir.r4.model.DeviceUseStatement();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertDeviceUseStatementStatus(src.getStatusElement()));
    if (src.hasSubject())
      tgt.setSubject(Reference30_40.convertReference(src.getSubject()));
    if (src.hasTiming())
      tgt.setTiming(ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertType(src.getTiming()));
    if (src.hasRecordedOn())
      tgt.setRecordedOnElement(DateTime30_40.convertDateTime(src.getRecordedOnElement()));
    if (src.hasSource())
      tgt.setSource(Reference30_40.convertReference(src.getSource()));
    if (src.hasDevice())
      tgt.setDevice(Reference30_40.convertReference(src.getDevice()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getIndication())
      tgt.addReasonCode(CodeableConcept30_40.convertCodeableConcept(t));
    if (src.hasBodySite())
      tgt.setBodySite(CodeableConcept30_40.convertCodeableConcept(src.getBodySite()));
    for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(Annotation30_40.convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.DeviceUseStatement convertDeviceUseStatement(org.hl7.fhir.r4.model.DeviceUseStatement src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.DeviceUseStatement tgt = new org.hl7.fhir.dstu3.model.DeviceUseStatement();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertDeviceUseStatementStatus(src.getStatusElement()));
    if (src.hasSubject())
      tgt.setSubject(Reference30_40.convertReference(src.getSubject()));
    if (src.hasTiming())
      tgt.setTiming(ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertType(src.getTiming()));
    if (src.hasRecordedOn())
      tgt.setRecordedOnElement(DateTime30_40.convertDateTime(src.getRecordedOnElement()));
    if (src.hasSource())
      tgt.setSource(Reference30_40.convertReference(src.getSource()));
    if (src.hasDevice())
      tgt.setDevice(Reference30_40.convertReference(src.getDevice()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode())
      tgt.addIndication(CodeableConcept30_40.convertCodeableConcept(t));
    if (src.hasBodySite())
      tgt.setBodySite(CodeableConcept30_40.convertCodeableConcept(src.getBodySite()));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(Annotation30_40.convertAnnotation(t));
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceUseStatement.DeviceUseStatementStatus> convertDeviceUseStatementStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.DeviceUseStatement.DeviceUseStatementStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<DeviceUseStatement.DeviceUseStatementStatus> tgt = new Enumeration<>(new DeviceUseStatement.DeviceUseStatementStatusEnumFactory());
      ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ACTIVE:
                  tgt.setValue(DeviceUseStatement.DeviceUseStatementStatus.ACTIVE);
                  break;
              case COMPLETED:
                  tgt.setValue(DeviceUseStatement.DeviceUseStatementStatus.COMPLETED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(DeviceUseStatement.DeviceUseStatementStatus.ENTEREDINERROR);
                  break;
              case INTENDED:
                  tgt.setValue(DeviceUseStatement.DeviceUseStatementStatus.INTENDED);
                  break;
              case STOPPED:
                  tgt.setValue(DeviceUseStatement.DeviceUseStatementStatus.STOPPED);
                  break;
              case ONHOLD:
                  tgt.setValue(DeviceUseStatement.DeviceUseStatementStatus.ONHOLD);
                  break;
              default:
                  tgt.setValue(DeviceUseStatement.DeviceUseStatementStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.DeviceUseStatement.DeviceUseStatementStatus> convertDeviceUseStatementStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceUseStatement.DeviceUseStatementStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.DeviceUseStatement.DeviceUseStatementStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.DeviceUseStatement.DeviceUseStatementStatusEnumFactory());
      ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ACTIVE:
                  tgt.setValue(org.hl7.fhir.dstu3.model.DeviceUseStatement.DeviceUseStatementStatus.ACTIVE);
                  break;
              case COMPLETED:
                  tgt.setValue(org.hl7.fhir.dstu3.model.DeviceUseStatement.DeviceUseStatementStatus.COMPLETED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(org.hl7.fhir.dstu3.model.DeviceUseStatement.DeviceUseStatementStatus.ENTEREDINERROR);
                  break;
              case INTENDED:
                  tgt.setValue(org.hl7.fhir.dstu3.model.DeviceUseStatement.DeviceUseStatementStatus.INTENDED);
                  break;
              case STOPPED:
                  tgt.setValue(org.hl7.fhir.dstu3.model.DeviceUseStatement.DeviceUseStatementStatus.STOPPED);
                  break;
              case ONHOLD:
                  tgt.setValue(org.hl7.fhir.dstu3.model.DeviceUseStatement.DeviceUseStatementStatus.ONHOLD);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.dstu3.model.DeviceUseStatement.DeviceUseStatementStatus.NULL);
                  break;
          }
      }
      return tgt;
  }
}