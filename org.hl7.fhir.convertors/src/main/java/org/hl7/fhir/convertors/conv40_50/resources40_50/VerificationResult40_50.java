package org.hl7.fhir.convertors.conv40_50.resources40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.CodeableConcept40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Signature40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Timing40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Date40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.DateTime40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.String40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Reference40_50;
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
public class VerificationResult40_50 {

  public static org.hl7.fhir.r5.model.VerificationResult convertVerificationResult(org.hl7.fhir.r4.model.VerificationResult src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.VerificationResult tgt = new org.hl7.fhir.r5.model.VerificationResult();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Reference t : src.getTarget()) tgt.addTarget(Reference40_50.convertReference(t));
    for (org.hl7.fhir.r4.model.StringType t : src.getTargetLocation())
      tgt.getTargetLocation().add(String40_50.convertString(t));
    if (src.hasNeed())
      tgt.setNeed(CodeableConcept40_50.convertCodeableConcept(src.getNeed()));
    if (src.hasStatus())
      tgt.setStatusElement(convertStatus(src.getStatusElement()));
    if (src.hasStatusDate())
      tgt.setStatusDateElement(DateTime40_50.convertDateTime(src.getStatusDateElement()));
    if (src.hasValidationType())
      tgt.setValidationType(CodeableConcept40_50.convertCodeableConcept(src.getValidationType()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getValidationProcess())
      tgt.addValidationProcess(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasFrequency())
      tgt.setFrequency(Timing40_50.convertTiming(src.getFrequency()));
    if (src.hasLastPerformed())
      tgt.setLastPerformedElement(DateTime40_50.convertDateTime(src.getLastPerformedElement()));
    if (src.hasNextScheduled())
      tgt.setNextScheduledElement(Date40_50.convertDate(src.getNextScheduledElement()));
    if (src.hasFailureAction())
      tgt.setFailureAction(CodeableConcept40_50.convertCodeableConcept(src.getFailureAction()));
    for (org.hl7.fhir.r4.model.VerificationResult.VerificationResultPrimarySourceComponent t : src.getPrimarySource())
      tgt.addPrimarySource(convertVerificationResultPrimarySourceComponent(t));
    if (src.hasAttestation())
      tgt.setAttestation(convertVerificationResultAttestationComponent(src.getAttestation()));
    for (org.hl7.fhir.r4.model.VerificationResult.VerificationResultValidatorComponent t : src.getValidator())
      tgt.addValidator(convertVerificationResultValidatorComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.VerificationResult convertVerificationResult(org.hl7.fhir.r5.model.VerificationResult src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.VerificationResult tgt = new org.hl7.fhir.r4.model.VerificationResult();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Reference t : src.getTarget()) tgt.addTarget(Reference40_50.convertReference(t));
    for (org.hl7.fhir.r5.model.StringType t : src.getTargetLocation())
      tgt.getTargetLocation().add(String40_50.convertString(t));
    if (src.hasNeed())
      tgt.setNeed(CodeableConcept40_50.convertCodeableConcept(src.getNeed()));
    if (src.hasStatus())
      tgt.setStatusElement(convertStatus(src.getStatusElement()));
    if (src.hasStatusDate())
      tgt.setStatusDateElement(DateTime40_50.convertDateTime(src.getStatusDateElement()));
    if (src.hasValidationType())
      tgt.setValidationType(CodeableConcept40_50.convertCodeableConcept(src.getValidationType()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getValidationProcess())
      tgt.addValidationProcess(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasFrequency())
      tgt.setFrequency(Timing40_50.convertTiming(src.getFrequency()));
    if (src.hasLastPerformed())
      tgt.setLastPerformedElement(DateTime40_50.convertDateTime(src.getLastPerformedElement()));
    if (src.hasNextScheduled())
      tgt.setNextScheduledElement(Date40_50.convertDate(src.getNextScheduledElement()));
    if (src.hasFailureAction())
      tgt.setFailureAction(CodeableConcept40_50.convertCodeableConcept(src.getFailureAction()));
    for (org.hl7.fhir.r5.model.VerificationResult.VerificationResultPrimarySourceComponent t : src.getPrimarySource())
      tgt.addPrimarySource(convertVerificationResultPrimarySourceComponent(t));
    if (src.hasAttestation())
      tgt.setAttestation(convertVerificationResultAttestationComponent(src.getAttestation()));
    for (org.hl7.fhir.r5.model.VerificationResult.VerificationResultValidatorComponent t : src.getValidator())
      tgt.addValidator(convertVerificationResultValidatorComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.VerificationResult.VerificationResultStatus> convertStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.VerificationResult.Status> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.VerificationResult.VerificationResultStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.VerificationResult.VerificationResultStatusEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ATTESTED:
        tgt.setValue(org.hl7.fhir.r5.model.VerificationResult.VerificationResultStatus.ATTESTED);
        break;
      case VALIDATED:
        tgt.setValue(org.hl7.fhir.r5.model.VerificationResult.VerificationResultStatus.VALIDATED);
        break;
      case INPROCESS:
        tgt.setValue(org.hl7.fhir.r5.model.VerificationResult.VerificationResultStatus.INPROCESS);
        break;
      case REQREVALID:
        tgt.setValue(org.hl7.fhir.r5.model.VerificationResult.VerificationResultStatus.REQREVALID);
        break;
      case VALFAIL:
        tgt.setValue(org.hl7.fhir.r5.model.VerificationResult.VerificationResultStatus.VALFAIL);
        break;
      case REVALFAIL:
        tgt.setValue(org.hl7.fhir.r5.model.VerificationResult.VerificationResultStatus.REVALFAIL);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.VerificationResult.VerificationResultStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.VerificationResult.Status> convertStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.VerificationResult.VerificationResultStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.VerificationResult.Status> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.VerificationResult.StatusEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ATTESTED:
        tgt.setValue(org.hl7.fhir.r4.model.VerificationResult.Status.ATTESTED);
        break;
      case VALIDATED:
        tgt.setValue(org.hl7.fhir.r4.model.VerificationResult.Status.VALIDATED);
        break;
      case INPROCESS:
        tgt.setValue(org.hl7.fhir.r4.model.VerificationResult.Status.INPROCESS);
        break;
      case REQREVALID:
        tgt.setValue(org.hl7.fhir.r4.model.VerificationResult.Status.REQREVALID);
        break;
      case VALFAIL:
        tgt.setValue(org.hl7.fhir.r4.model.VerificationResult.Status.VALFAIL);
        break;
      case REVALFAIL:
        tgt.setValue(org.hl7.fhir.r4.model.VerificationResult.Status.REVALFAIL);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.VerificationResult.Status.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.VerificationResult.VerificationResultPrimarySourceComponent convertVerificationResultPrimarySourceComponent(org.hl7.fhir.r4.model.VerificationResult.VerificationResultPrimarySourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.VerificationResult.VerificationResultPrimarySourceComponent tgt = new org.hl7.fhir.r5.model.VerificationResult.VerificationResultPrimarySourceComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasWho())
      tgt.setWho(Reference40_50.convertReference(src.getWho()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept40_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCommunicationMethod())
      tgt.addCommunicationMethod(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasValidationStatus())
      tgt.setValidationStatus(CodeableConcept40_50.convertCodeableConcept(src.getValidationStatus()));
    if (src.hasValidationDate())
      tgt.setValidationDateElement(DateTime40_50.convertDateTime(src.getValidationDateElement()));
    if (src.hasCanPushUpdates())
      tgt.setCanPushUpdates(CodeableConcept40_50.convertCodeableConcept(src.getCanPushUpdates()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getPushTypeAvailable())
      tgt.addPushTypeAvailable(CodeableConcept40_50.convertCodeableConcept(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.VerificationResult.VerificationResultPrimarySourceComponent convertVerificationResultPrimarySourceComponent(org.hl7.fhir.r5.model.VerificationResult.VerificationResultPrimarySourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.VerificationResult.VerificationResultPrimarySourceComponent tgt = new org.hl7.fhir.r4.model.VerificationResult.VerificationResultPrimarySourceComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasWho())
      tgt.setWho(Reference40_50.convertReference(src.getWho()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept40_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCommunicationMethod())
      tgt.addCommunicationMethod(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasValidationStatus())
      tgt.setValidationStatus(CodeableConcept40_50.convertCodeableConcept(src.getValidationStatus()));
    if (src.hasValidationDate())
      tgt.setValidationDateElement(DateTime40_50.convertDateTime(src.getValidationDateElement()));
    if (src.hasCanPushUpdates())
      tgt.setCanPushUpdates(CodeableConcept40_50.convertCodeableConcept(src.getCanPushUpdates()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getPushTypeAvailable())
      tgt.addPushTypeAvailable(CodeableConcept40_50.convertCodeableConcept(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.VerificationResult.VerificationResultAttestationComponent convertVerificationResultAttestationComponent(org.hl7.fhir.r4.model.VerificationResult.VerificationResultAttestationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.VerificationResult.VerificationResultAttestationComponent tgt = new org.hl7.fhir.r5.model.VerificationResult.VerificationResultAttestationComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasWho())
      tgt.setWho(Reference40_50.convertReference(src.getWho()));
    if (src.hasOnBehalfOf())
      tgt.setOnBehalfOf(Reference40_50.convertReference(src.getOnBehalfOf()));
    if (src.hasCommunicationMethod())
      tgt.setCommunicationMethod(CodeableConcept40_50.convertCodeableConcept(src.getCommunicationMethod()));
    if (src.hasDate())
      tgt.setDateElement(Date40_50.convertDate(src.getDateElement()));
    if (src.hasSourceIdentityCertificate())
      tgt.setSourceIdentityCertificateElement(String40_50.convertString(src.getSourceIdentityCertificateElement()));
    if (src.hasProxyIdentityCertificate())
      tgt.setProxyIdentityCertificateElement(String40_50.convertString(src.getProxyIdentityCertificateElement()));
    if (src.hasProxySignature())
      tgt.setProxySignature(Signature40_50.convertSignature(src.getProxySignature()));
    if (src.hasSourceSignature())
      tgt.setSourceSignature(Signature40_50.convertSignature(src.getSourceSignature()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.VerificationResult.VerificationResultAttestationComponent convertVerificationResultAttestationComponent(org.hl7.fhir.r5.model.VerificationResult.VerificationResultAttestationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.VerificationResult.VerificationResultAttestationComponent tgt = new org.hl7.fhir.r4.model.VerificationResult.VerificationResultAttestationComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasWho())
      tgt.setWho(Reference40_50.convertReference(src.getWho()));
    if (src.hasOnBehalfOf())
      tgt.setOnBehalfOf(Reference40_50.convertReference(src.getOnBehalfOf()));
    if (src.hasCommunicationMethod())
      tgt.setCommunicationMethod(CodeableConcept40_50.convertCodeableConcept(src.getCommunicationMethod()));
    if (src.hasDate())
      tgt.setDateElement(Date40_50.convertDate(src.getDateElement()));
    if (src.hasSourceIdentityCertificate())
      tgt.setSourceIdentityCertificateElement(String40_50.convertString(src.getSourceIdentityCertificateElement()));
    if (src.hasProxyIdentityCertificate())
      tgt.setProxyIdentityCertificateElement(String40_50.convertString(src.getProxyIdentityCertificateElement()));
    if (src.hasProxySignature())
      tgt.setProxySignature(Signature40_50.convertSignature(src.getProxySignature()));
    if (src.hasSourceSignature())
      tgt.setSourceSignature(Signature40_50.convertSignature(src.getSourceSignature()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.VerificationResult.VerificationResultValidatorComponent convertVerificationResultValidatorComponent(org.hl7.fhir.r4.model.VerificationResult.VerificationResultValidatorComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.VerificationResult.VerificationResultValidatorComponent tgt = new org.hl7.fhir.r5.model.VerificationResult.VerificationResultValidatorComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasOrganization())
      tgt.setOrganization(Reference40_50.convertReference(src.getOrganization()));
    if (src.hasIdentityCertificate())
      tgt.setIdentityCertificateElement(String40_50.convertString(src.getIdentityCertificateElement()));
    if (src.hasAttestationSignature())
      tgt.setAttestationSignature(Signature40_50.convertSignature(src.getAttestationSignature()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.VerificationResult.VerificationResultValidatorComponent convertVerificationResultValidatorComponent(org.hl7.fhir.r5.model.VerificationResult.VerificationResultValidatorComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.VerificationResult.VerificationResultValidatorComponent tgt = new org.hl7.fhir.r4.model.VerificationResult.VerificationResultValidatorComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasOrganization())
      tgt.setOrganization(Reference40_50.convertReference(src.getOrganization()));
    if (src.hasIdentityCertificate())
      tgt.setIdentityCertificateElement(String40_50.convertString(src.getIdentityCertificateElement()));
    if (src.hasAttestationSignature())
      tgt.setAttestationSignature(Signature40_50.convertSignature(src.getAttestationSignature()));
    return tgt;
  }
}