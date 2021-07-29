package org.hl7.fhir.convertors.conv30_50.resources30_50;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Reference30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Annotation30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.CodeableConcept30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Identifier30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.DateTime30_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableReference;

public class DeviceUseStatement30_50 {

  public static org.hl7.fhir.dstu3.model.DeviceUseStatement convertDeviceUseStatement(org.hl7.fhir.r5.model.DeviceUsage src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.DeviceUseStatement tgt = new org.hl7.fhir.dstu3.model.DeviceUseStatement();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertDeviceUseStatementStatus(src.getStatusElement()));
    if (src.hasSubject())
      tgt.setSubject(Reference30_50.convertReference(src.getSubject()));
    if (src.hasTiming())
      tgt.setTiming(VersionConvertorFactory_30_50.convertType(src.getTiming()));
    if (src.hasDateAsserted())
      tgt.setRecordedOnElement(DateTime30_50.convertDateTime(src.getDateAssertedElement()));
    if (src.hasInformationSource())
      tgt.setSource(Reference30_50.convertReference(src.getInformationSource()));
    if (src.getDevice().hasReference())
      tgt.setDevice(Reference30_50.convertReference(src.getDevice().getReference()));
    for (CodeableReference t : src.getReason())
      if (t.hasConcept())
        tgt.addIndication(CodeableConcept30_50.convertCodeableConcept(t.getConcept()));
    if (src.getBodySite().hasConcept())
      tgt.setBodySite(CodeableConcept30_50.convertCodeableConcept(src.getBodySite().getConcept()));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(Annotation30_50.convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.DeviceUsage convertDeviceUseStatement(org.hl7.fhir.dstu3.model.DeviceUseStatement src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.DeviceUsage tgt = new org.hl7.fhir.r5.model.DeviceUsage();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertDeviceUseStatementStatus(src.getStatusElement()));
    if (src.hasSubject())
      tgt.setSubject(Reference30_50.convertReference(src.getSubject()));
    if (src.hasTiming())
      tgt.setTiming(VersionConvertorFactory_30_50.convertType(src.getTiming()));
    if (src.hasRecordedOn())
      tgt.setDateAssertedElement(DateTime30_50.convertDateTime(src.getRecordedOnElement()));
    if (src.hasSource())
      tgt.setInformationSource(Reference30_50.convertReference(src.getSource()));
    if (src.hasDevice())
      tgt.getDevice().setReference(Reference30_50.convertReference(src.getDevice()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getIndication())
      tgt.addReason(Reference30_50.convertCodeableConceptToCodableReference(t));
    if (src.hasBodySite())
      tgt.getBodySite().setConcept(CodeableConcept30_50.convertCodeableConcept(src.getBodySite()));
    for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(Annotation30_50.convertAnnotation(t));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.DeviceUseStatement.DeviceUseStatementStatus> convertDeviceUseStatementStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.DeviceUsage.DeviceUsageStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.DeviceUseStatement.DeviceUseStatementStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.DeviceUseStatement.DeviceUseStatementStatusEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
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
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.DeviceUsage.DeviceUsageStatus> convertDeviceUseStatementStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.DeviceUseStatement.DeviceUseStatementStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.DeviceUsage.DeviceUsageStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.DeviceUsage.DeviceUsageStatusEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r5.model.DeviceUsage.DeviceUsageStatus.ACTIVE);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.r5.model.DeviceUsage.DeviceUsageStatus.COMPLETED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r5.model.DeviceUsage.DeviceUsageStatus.ENTEREDINERROR);
        break;
      case INTENDED:
        tgt.setValue(org.hl7.fhir.r5.model.DeviceUsage.DeviceUsageStatus.INTENDED);
        break;
      case STOPPED:
        tgt.setValue(org.hl7.fhir.r5.model.DeviceUsage.DeviceUsageStatus.STOPPED);
        break;
      case ONHOLD:
        tgt.setValue(org.hl7.fhir.r5.model.DeviceUsage.DeviceUsageStatus.ONHOLD);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.DeviceUsage.DeviceUsageStatus.NULL);
        break;
    }
    return tgt;
  }
}