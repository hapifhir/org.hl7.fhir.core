package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Signature43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Timing43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Date43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.DateTime43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50.Reference43_50;
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
public class VerificationResult43_50 {

  public static org.hl7.fhir.r5.model.VerificationResult convertVerificationResult(org.hl7.fhir.r4b.model.VerificationResult src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.VerificationResult tgt = new org.hl7.fhir.r5.model.VerificationResult();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Reference t : src.getTarget()) tgt.addTarget(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r4b.model.StringType t : src.getTargetLocation())
      tgt.getTargetLocation().add(String43_50.convertString(t));
    if (src.hasNeed())
      tgt.setNeed(CodeableConcept43_50.convertCodeableConcept(src.getNeed()));
    if (src.hasStatus())
      tgt.setStatusElement(convertStatus(src.getStatusElement()));
    if (src.hasStatusDate())
      tgt.setStatusDateElement(DateTime43_50.convertDateTime(src.getStatusDateElement()));
    if (src.hasValidationType())
      tgt.setValidationType(CodeableConcept43_50.convertCodeableConcept(src.getValidationType()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getValidationProcess())
      tgt.addValidationProcess(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasFrequency())
      tgt.setFrequency(Timing43_50.convertTiming(src.getFrequency()));
    if (src.hasLastPerformed())
      tgt.setLastPerformedElement(DateTime43_50.convertDateTime(src.getLastPerformedElement()));
    if (src.hasNextScheduled())
      tgt.setNextScheduledElement(Date43_50.convertDate(src.getNextScheduledElement()));
    if (src.hasFailureAction())
      tgt.setFailureAction(CodeableConcept43_50.convertCodeableConcept(src.getFailureAction()));
    for (org.hl7.fhir.r4b.model.VerificationResult.VerificationResultPrimarySourceComponent t : src.getPrimarySource())
      tgt.addPrimarySource(convertVerificationResultPrimarySourceComponent(t));
    if (src.hasAttestation())
      tgt.setAttestation(convertVerificationResultAttestationComponent(src.getAttestation()));
    for (org.hl7.fhir.r4b.model.VerificationResult.VerificationResultValidatorComponent t : src.getValidator())
      tgt.addValidator(convertVerificationResultValidatorComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.VerificationResult convertVerificationResult(org.hl7.fhir.r5.model.VerificationResult src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.VerificationResult tgt = new org.hl7.fhir.r4b.model.VerificationResult();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Reference t : src.getTarget()) tgt.addTarget(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r5.model.StringType t : src.getTargetLocation())
      tgt.getTargetLocation().add(String43_50.convertString(t));
    if (src.hasNeed())
      tgt.setNeed(CodeableConcept43_50.convertCodeableConcept(src.getNeed()));
    if (src.hasStatus())
      tgt.setStatusElement(convertStatus(src.getStatusElement()));
    if (src.hasStatusDate())
      tgt.setStatusDateElement(DateTime43_50.convertDateTime(src.getStatusDateElement()));
    if (src.hasValidationType())
      tgt.setValidationType(CodeableConcept43_50.convertCodeableConcept(src.getValidationType()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getValidationProcess())
      tgt.addValidationProcess(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasFrequency())
      tgt.setFrequency(Timing43_50.convertTiming(src.getFrequency()));
    if (src.hasLastPerformed())
      tgt.setLastPerformedElement(DateTime43_50.convertDateTime(src.getLastPerformedElement()));
    if (src.hasNextScheduled())
      tgt.setNextScheduledElement(Date43_50.convertDate(src.getNextScheduledElement()));
    if (src.hasFailureAction())
      tgt.setFailureAction(CodeableConcept43_50.convertCodeableConcept(src.getFailureAction()));
    for (org.hl7.fhir.r5.model.VerificationResult.VerificationResultPrimarySourceComponent t : src.getPrimarySource())
      tgt.addPrimarySource(convertVerificationResultPrimarySourceComponent(t));
    if (src.hasAttestation())
      tgt.setAttestation(convertVerificationResultAttestationComponent(src.getAttestation()));
    for (org.hl7.fhir.r5.model.VerificationResult.VerificationResultValidatorComponent t : src.getValidator())
      tgt.addValidator(convertVerificationResultValidatorComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.VerificationResult.VerificationResultStatus> convertStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.VerificationResult.Status> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.VerificationResult.VerificationResultStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.VerificationResult.VerificationResultStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.VerificationResult.Status> convertStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.VerificationResult.VerificationResultStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.VerificationResult.Status> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.VerificationResult.StatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ATTESTED:
        tgt.setValue(org.hl7.fhir.r4b.model.VerificationResult.Status.ATTESTED);
        break;
      case VALIDATED:
        tgt.setValue(org.hl7.fhir.r4b.model.VerificationResult.Status.VALIDATED);
        break;
      case INPROCESS:
        tgt.setValue(org.hl7.fhir.r4b.model.VerificationResult.Status.INPROCESS);
        break;
      case REQREVALID:
        tgt.setValue(org.hl7.fhir.r4b.model.VerificationResult.Status.REQREVALID);
        break;
      case VALFAIL:
        tgt.setValue(org.hl7.fhir.r4b.model.VerificationResult.Status.VALFAIL);
        break;
      case REVALFAIL:
        tgt.setValue(org.hl7.fhir.r4b.model.VerificationResult.Status.REVALFAIL);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.VerificationResult.Status.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.VerificationResult.VerificationResultPrimarySourceComponent convertVerificationResultPrimarySourceComponent(org.hl7.fhir.r4b.model.VerificationResult.VerificationResultPrimarySourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.VerificationResult.VerificationResultPrimarySourceComponent tgt = new org.hl7.fhir.r5.model.VerificationResult.VerificationResultPrimarySourceComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasWho())
      tgt.setWho(Reference43_50.convertReference(src.getWho()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getCommunicationMethod())
      tgt.addCommunicationMethod(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasValidationStatus())
      tgt.setValidationStatus(CodeableConcept43_50.convertCodeableConcept(src.getValidationStatus()));
    if (src.hasValidationDate())
      tgt.setValidationDateElement(DateTime43_50.convertDateTime(src.getValidationDateElement()));
    if (src.hasCanPushUpdates())
      tgt.setCanPushUpdates(CodeableConcept43_50.convertCodeableConcept(src.getCanPushUpdates()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getPushTypeAvailable())
      tgt.addPushTypeAvailable(CodeableConcept43_50.convertCodeableConcept(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.VerificationResult.VerificationResultPrimarySourceComponent convertVerificationResultPrimarySourceComponent(org.hl7.fhir.r5.model.VerificationResult.VerificationResultPrimarySourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.VerificationResult.VerificationResultPrimarySourceComponent tgt = new org.hl7.fhir.r4b.model.VerificationResult.VerificationResultPrimarySourceComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasWho())
      tgt.setWho(Reference43_50.convertReference(src.getWho()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCommunicationMethod())
      tgt.addCommunicationMethod(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasValidationStatus())
      tgt.setValidationStatus(CodeableConcept43_50.convertCodeableConcept(src.getValidationStatus()));
    if (src.hasValidationDate())
      tgt.setValidationDateElement(DateTime43_50.convertDateTime(src.getValidationDateElement()));
    if (src.hasCanPushUpdates())
      tgt.setCanPushUpdates(CodeableConcept43_50.convertCodeableConcept(src.getCanPushUpdates()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getPushTypeAvailable())
      tgt.addPushTypeAvailable(CodeableConcept43_50.convertCodeableConcept(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.VerificationResult.VerificationResultAttestationComponent convertVerificationResultAttestationComponent(org.hl7.fhir.r4b.model.VerificationResult.VerificationResultAttestationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.VerificationResult.VerificationResultAttestationComponent tgt = new org.hl7.fhir.r5.model.VerificationResult.VerificationResultAttestationComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasWho())
      tgt.setWho(Reference43_50.convertReference(src.getWho()));
    if (src.hasOnBehalfOf())
      tgt.setOnBehalfOf(Reference43_50.convertReference(src.getOnBehalfOf()));
    if (src.hasCommunicationMethod())
      tgt.setCommunicationMethod(CodeableConcept43_50.convertCodeableConcept(src.getCommunicationMethod()));
    if (src.hasDate())
      tgt.setDateElement(Date43_50.convertDate(src.getDateElement()));
    if (src.hasSourceIdentityCertificate())
      tgt.setSourceIdentityCertificateElement(String43_50.convertString(src.getSourceIdentityCertificateElement()));
    if (src.hasProxyIdentityCertificate())
      tgt.setProxyIdentityCertificateElement(String43_50.convertString(src.getProxyIdentityCertificateElement()));
    if (src.hasProxySignature())
      tgt.setProxySignature(Signature43_50.convertSignature(src.getProxySignature()));
    if (src.hasSourceSignature())
      tgt.setSourceSignature(Signature43_50.convertSignature(src.getSourceSignature()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.VerificationResult.VerificationResultAttestationComponent convertVerificationResultAttestationComponent(org.hl7.fhir.r5.model.VerificationResult.VerificationResultAttestationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.VerificationResult.VerificationResultAttestationComponent tgt = new org.hl7.fhir.r4b.model.VerificationResult.VerificationResultAttestationComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasWho())
      tgt.setWho(Reference43_50.convertReference(src.getWho()));
    if (src.hasOnBehalfOf())
      tgt.setOnBehalfOf(Reference43_50.convertReference(src.getOnBehalfOf()));
    if (src.hasCommunicationMethod())
      tgt.setCommunicationMethod(CodeableConcept43_50.convertCodeableConcept(src.getCommunicationMethod()));
    if (src.hasDate())
      tgt.setDateElement(Date43_50.convertDate(src.getDateElement()));
    if (src.hasSourceIdentityCertificate())
      tgt.setSourceIdentityCertificateElement(String43_50.convertString(src.getSourceIdentityCertificateElement()));
    if (src.hasProxyIdentityCertificate())
      tgt.setProxyIdentityCertificateElement(String43_50.convertString(src.getProxyIdentityCertificateElement()));
    if (src.hasProxySignature())
      tgt.setProxySignature(Signature43_50.convertSignature(src.getProxySignature()));
    if (src.hasSourceSignature())
      tgt.setSourceSignature(Signature43_50.convertSignature(src.getSourceSignature()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.VerificationResult.VerificationResultValidatorComponent convertVerificationResultValidatorComponent(org.hl7.fhir.r4b.model.VerificationResult.VerificationResultValidatorComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.VerificationResult.VerificationResultValidatorComponent tgt = new org.hl7.fhir.r5.model.VerificationResult.VerificationResultValidatorComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasOrganization())
      tgt.setOrganization(Reference43_50.convertReference(src.getOrganization()));
    if (src.hasIdentityCertificate())
      tgt.setIdentityCertificateElement(String43_50.convertString(src.getIdentityCertificateElement()));
    if (src.hasAttestationSignature())
      tgt.setAttestationSignature(Signature43_50.convertSignature(src.getAttestationSignature()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.VerificationResult.VerificationResultValidatorComponent convertVerificationResultValidatorComponent(org.hl7.fhir.r5.model.VerificationResult.VerificationResultValidatorComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.VerificationResult.VerificationResultValidatorComponent tgt = new org.hl7.fhir.r4b.model.VerificationResult.VerificationResultValidatorComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasOrganization())
      tgt.setOrganization(Reference43_50.convertReference(src.getOrganization()));
    if (src.hasIdentityCertificate())
      tgt.setIdentityCertificateElement(String43_50.convertString(src.getIdentityCertificateElement()));
    if (src.hasAttestationSignature())
      tgt.setAttestationSignature(Signature43_50.convertSignature(src.getAttestationSignature()));
    return tgt;
  }
}