package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Annotation43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Period43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.SimpleQuantity43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Boolean43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Canonical43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.DateTime43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Uri43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50.Reference43_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableReference;

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
public class CarePlan43_50 {

  public static org.hl7.fhir.r5.model.CarePlan convertCarePlan(org.hl7.fhir.r4b.model.CarePlan src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CarePlan tgt = new org.hl7.fhir.r5.model.CarePlan();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    for (org.hl7.fhir.r4b.model.CanonicalType t : src.getInstantiatesCanonical())
      tgt.getInstantiatesCanonical().add(Canonical43_50.convertCanonical(t));
    for (org.hl7.fhir.r4b.model.UriType t : src.getInstantiatesUri())
      tgt.getInstantiatesUri().add(Uri43_50.convertUri(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getReplaces()) tgt.addReplaces(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getPartOf()) tgt.addPartOf(Reference43_50.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertCarePlanStatus(src.getStatusElement()));
    if (src.hasIntent())
      tgt.setIntentElement(convertCarePlanIntent(src.getIntentElement()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasTitle())
      tgt.setTitleElement(String43_50.convertString(src.getTitleElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_50.convertString(src.getDescriptionElement()));
    if (src.hasSubject())
      tgt.setSubject(Reference43_50.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference43_50.convertReference(src.getEncounter()));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_50.convertPeriod(src.getPeriod()));
    if (src.hasCreated())
      tgt.setCreatedElement(DateTime43_50.convertDateTime(src.getCreatedElement()));
    if (src.hasAuthor())
      tgt.setCustodian(Reference43_50.convertReference(src.getAuthor()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getContributor())
      tgt.addContributor(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getCareTeam()) tgt.addCareTeam(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getAddresses())
      tgt.addAddresses(Reference43_50.convertReferenceToCodeableReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getSupportingInfo())
      tgt.addSupportingInfo(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getGoal()) tgt.addGoal(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r4b.model.CarePlan.CarePlanActivityComponent t : src.getActivity())
      tgt.addActivity(convertCarePlanActivityComponent(t));
    for (org.hl7.fhir.r4b.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_50.convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.CarePlan convertCarePlan(org.hl7.fhir.r5.model.CarePlan src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.CarePlan tgt = new org.hl7.fhir.r4b.model.CarePlan();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getInstantiatesCanonical())
      tgt.getInstantiatesCanonical().add(Canonical43_50.convertCanonical(t));
    for (org.hl7.fhir.r5.model.UriType t : src.getInstantiatesUri())
      tgt.getInstantiatesUri().add(Uri43_50.convertUri(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getReplaces()) tgt.addReplaces(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getPartOf()) tgt.addPartOf(Reference43_50.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertCarePlanStatus(src.getStatusElement()));
    if (src.hasIntent())
      tgt.setIntentElement(convertCarePlanIntent(src.getIntentElement()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasTitle())
      tgt.setTitleElement(String43_50.convertString(src.getTitleElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_50.convertString(src.getDescriptionElement()));
    if (src.hasSubject())
      tgt.setSubject(Reference43_50.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference43_50.convertReference(src.getEncounter()));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_50.convertPeriod(src.getPeriod()));
    if (src.hasCreated())
      tgt.setCreatedElement(DateTime43_50.convertDateTime(src.getCreatedElement()));
    if (src.hasCustodian())
      tgt.setAuthor(Reference43_50.convertReference(src.getCustodian()));
    for (org.hl7.fhir.r5.model.Reference t : src.getContributor())
      tgt.addContributor(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getCareTeam()) tgt.addCareTeam(Reference43_50.convertReference(t));
    for (CodeableReference t : src.getAddresses())
      if (t.hasReference())
        tgt.addAddresses(Reference43_50.convertReference(t.getReference()));
    for (org.hl7.fhir.r5.model.Reference t : src.getSupportingInfo())
      tgt.addSupportingInfo(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getGoal()) tgt.addGoal(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r5.model.CarePlan.CarePlanActivityComponent t : src.getActivity())
      tgt.addActivity(convertCarePlanActivityComponent(t));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_50.convertAnnotation(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestStatus> convertCarePlanStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.RequestStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case DRAFT:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.DRAFT);
        break;
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.ACTIVE);
        break;
      case ONHOLD:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.ONHOLD);
        break;
      case REVOKED:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.REVOKED);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.COMPLETED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.ENTEREDINERROR);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestStatus> convertCarePlanStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.RequestStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case DRAFT:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestStatus.DRAFT);
        break;
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestStatus.ACTIVE);
        break;
      case ONHOLD:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestStatus.ONHOLD);
        break;
      case REVOKED:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestStatus.REVOKED);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestStatus.COMPLETED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestStatus.ENTEREDINERROR);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestStatus.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CarePlan.CarePlanIntent> convertCarePlanIntent(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.CarePlan.CarePlanIntent> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CarePlan.CarePlanIntent> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.CarePlan.CarePlanIntentEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PROPOSAL:
        tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanIntent.PROPOSAL);
        break;
      case PLAN:
        tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanIntent.PLAN);
        break;
      case ORDER:
        tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanIntent.ORDER);
        break;
      case OPTION:
        tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanIntent.OPTION);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanIntent.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.CarePlan.CarePlanIntent> convertCarePlanIntent(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CarePlan.CarePlanIntent> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.CarePlan.CarePlanIntent> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.CarePlan.CarePlanIntentEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PROPOSAL:
        tgt.setValue(org.hl7.fhir.r4b.model.CarePlan.CarePlanIntent.PROPOSAL);
        break;
      case PLAN:
        tgt.setValue(org.hl7.fhir.r4b.model.CarePlan.CarePlanIntent.PLAN);
        break;
      case ORDER:
        tgt.setValue(org.hl7.fhir.r4b.model.CarePlan.CarePlanIntent.ORDER);
        break;
      case OPTION:
        tgt.setValue(org.hl7.fhir.r4b.model.CarePlan.CarePlanIntent.OPTION);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.CarePlan.CarePlanIntent.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CarePlan.CarePlanActivityComponent convertCarePlanActivityComponent(org.hl7.fhir.r4b.model.CarePlan.CarePlanActivityComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CarePlan.CarePlanActivityComponent tgt = new org.hl7.fhir.r5.model.CarePlan.CarePlanActivityComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getOutcomeCodeableConcept())
      tgt.addPerformedActivity(CodeableConcept43_50.convertCodeableConceptToCodeableReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getOutcomeReference())
      tgt.addPerformedActivity(Reference43_50.convertReferenceToCodeableReference(t));
    for (org.hl7.fhir.r4b.model.Annotation t : src.getProgress()) tgt.addProgress(Annotation43_50.convertAnnotation(t));
    if (src.hasReference())
      tgt.setPlannedActivityReference(Reference43_50.convertReference(src.getReference()));
//    if (src.hasDetail())
//      tgt.setPlannedActivityDetail(convertCarePlanActivityDetailComponent(src.getDetail()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.CarePlan.CarePlanActivityComponent convertCarePlanActivityComponent(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.CarePlan.CarePlanActivityComponent tgt = new org.hl7.fhir.r4b.model.CarePlan.CarePlanActivityComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    for (CodeableReference t : src.getPerformedActivity())
      if (t.hasConcept())
        tgt.addOutcomeCodeableConcept(CodeableConcept43_50.convertCodeableConcept(t.getConcept()));
    for (CodeableReference t : src.getPerformedActivity())
      if (t.hasReference())
        tgt.addOutcomeReference(Reference43_50.convertReference(t.getReference()));
    for (org.hl7.fhir.r5.model.Annotation t : src.getProgress()) tgt.addProgress(Annotation43_50.convertAnnotation(t));
    if (src.hasPlannedActivityReference())
      tgt.setReference(Reference43_50.convertReference(src.getPlannedActivityReference()));
//    if (src.hasPlannedActivityDetail())
//      tgt.setDetail(convertCarePlanActivityDetailComponent(src.getPlannedActivityDetail()));
    return tgt;
  }

//  public static org.hl7.fhir.r5.model.CarePlan.CarePlanActivityPlannedActivityDetailComponent convertCarePlanActivityDetailComponent(org.hl7.fhir.r4b.model.CarePlan.CarePlanActivityDetailComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r5.model.CarePlan.CarePlanActivityPlannedActivityDetailComponent tgt = new org.hl7.fhir.r5.model.CarePlan.CarePlanActivityPlannedActivityDetailComponent();
//    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
//    if (src.hasKind())
//      tgt.setKindElement(convertCarePlanActivityKind(src.getKindElement()));
//    for (org.hl7.fhir.r4b.model.CanonicalType t : src.getInstantiatesCanonical())
//      tgt.getInstantiatesCanonical().add(Canonical43_50.convertCanonical(t));
//    for (org.hl7.fhir.r4b.model.UriType t : src.getInstantiatesUri())
//      tgt.getInstantiatesUri().add(Uri43_50.convertUri(t));
//    if (src.hasCode())
//      tgt.setCode(CodeableConcept43_50.convertCodeableConcept(src.getCode()));
//    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getReasonCode())
//      tgt.addReason(CodeableConcept43_50.convertCodeableConceptToCodeableReference(t));
//    for (org.hl7.fhir.r4b.model.Reference t : src.getReasonReference())
//      tgt.addReason(Reference43_50.convertReferenceToCodeableReference(t));
//    for (org.hl7.fhir.r4b.model.Reference t : src.getGoal()) tgt.addGoal(Reference43_50.convertReference(t));
//    if (src.hasStatus())
//      tgt.setStatusElement(convertCarePlanActivityStatus(src.getStatusElement()));
//    if (src.hasStatusReason())
//      tgt.setStatusReason(CodeableConcept43_50.convertCodeableConcept(src.getStatusReason()));
//    if (src.hasDoNotPerform())
//      tgt.setDoNotPerformElement(Boolean43_50.convertBoolean(src.getDoNotPerformElement()));
//    if (src.hasScheduled())
//      tgt.setScheduled(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getScheduled()));
//    if (src.hasLocation())
//      tgt.getLocation().setReference(Reference43_50.convertReference(src.getLocation()));
//    for (org.hl7.fhir.r4b.model.Reference t : src.getPerformer()) tgt.addPerformer(Reference43_50.convertReference(t));
//    if (src.hasProduct())
//      tgt.setProduct(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getProduct()));
//    if (src.hasDailyAmount())
//      tgt.setDailyAmount(SimpleQuantity43_50.convertSimpleQuantity(src.getDailyAmount()));
//    if (src.hasQuantity())
//      tgt.setQuantity(SimpleQuantity43_50.convertSimpleQuantity(src.getQuantity()));
//    if (src.hasDescription())
//      tgt.setDescriptionElement(String43_50.convertString(src.getDescriptionElement()));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r4b.model.CarePlan.CarePlanActivityDetailComponent convertCarePlanActivityDetailComponent(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityPlannedActivityDetailComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r4b.model.CarePlan.CarePlanActivityDetailComponent tgt = new org.hl7.fhir.r4b.model.CarePlan.CarePlanActivityDetailComponent();
//    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
//    if (src.hasKind())
//      tgt.setKindElement(convertCarePlanActivityKind(src.getKindElement()));
//    for (org.hl7.fhir.r5.model.CanonicalType t : src.getInstantiatesCanonical())
//      tgt.getInstantiatesCanonical().add(Canonical43_50.convertCanonical(t));
//    for (org.hl7.fhir.r5.model.UriType t : src.getInstantiatesUri())
//      tgt.getInstantiatesUri().add(Uri43_50.convertUri(t));
//    if (src.hasCode())
//      tgt.setCode(CodeableConcept43_50.convertCodeableConcept(src.getCode()));
//    for (CodeableReference t : src.getReason())
//      if (t.hasConcept())
//        tgt.addReasonCode(CodeableConcept43_50.convertCodeableConcept(t.getConcept()));
//    for (CodeableReference t : src.getReason())
//      if (t.hasReference())
//        tgt.addReasonReference(Reference43_50.convertReference(t.getReference()));
//    for (org.hl7.fhir.r5.model.Reference t : src.getGoal()) tgt.addGoal(Reference43_50.convertReference(t));
//    if (src.hasStatus())
//      tgt.setStatusElement(convertCarePlanActivityStatus(src.getStatusElement()));
//    if (src.hasStatusReason())
//      tgt.setStatusReason(CodeableConcept43_50.convertCodeableConcept(src.getStatusReason()));
//    if (src.hasDoNotPerform())
//      tgt.setDoNotPerformElement(Boolean43_50.convertBoolean(src.getDoNotPerformElement()));
//    if (src.hasScheduled())
//      tgt.setScheduled(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getScheduled()));
//    if (src.getLocation().hasReference())
//      tgt.setLocation(Reference43_50.convertReference(src.getLocation().getReference()));
//    for (org.hl7.fhir.r5.model.Reference t : src.getPerformer()) tgt.addPerformer(Reference43_50.convertReference(t));
//    if (src.hasProduct())
//      tgt.setProduct(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getProduct()));
//    if (src.hasDailyAmount())
//      tgt.setDailyAmount(SimpleQuantity43_50.convertSimpleQuantity(src.getDailyAmount()));
//    if (src.hasQuantity())
//      tgt.setQuantity(SimpleQuantity43_50.convertSimpleQuantity(src.getQuantity()));
//    if (src.hasDescription())
//      tgt.setDescriptionElement(String43_50.convertString(src.getDescriptionElement()));
//    return tgt;
//  }
//
//  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CarePlan.CarePlanActivityKind> convertCarePlanActivityKind(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.CarePlan.CarePlanActivityKind> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CarePlan.CarePlanActivityKind> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.CarePlan.CarePlanActivityKindEnumFactory());
//    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
//    switch (src.getValue()) {
//      case APPOINTMENT:
//        tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityKind.APPOINTMENT);
//        break;
//      case COMMUNICATIONREQUEST:
//        tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityKind.COMMUNICATIONREQUEST);
//        break;
//      case DEVICEREQUEST:
//        tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityKind.DEVICEREQUEST);
//        break;
//      case MEDICATIONREQUEST:
//        tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityKind.MEDICATIONREQUEST);
//        break;
//      case NUTRITIONORDER:
//        tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityKind.NUTRITIONORDER);
//        break;
//      case TASK:
//        tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityKind.TASK);
//        break;
//      case SERVICEREQUEST:
//        tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityKind.SERVICEREQUEST);
//        break;
//      case VISIONPRESCRIPTION:
//        tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityKind.VISIONPRESCRIPTION);
//        break;
//      default:
//        tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityKind.NULL);
//        break;
//    }
//    return tgt;
//  }
//
//  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.CarePlan.CarePlanActivityKind> convertCarePlanActivityKind(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CarePlan.CarePlanActivityKind> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.CarePlan.CarePlanActivityKind> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.CarePlan.CarePlanActivityKindEnumFactory());
//    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
//    switch (src.getValue()) {
//      case APPOINTMENT:
//        tgt.setValue(org.hl7.fhir.r4b.model.CarePlan.CarePlanActivityKind.APPOINTMENT);
//        break;
//      case COMMUNICATIONREQUEST:
//        tgt.setValue(org.hl7.fhir.r4b.model.CarePlan.CarePlanActivityKind.COMMUNICATIONREQUEST);
//        break;
//      case DEVICEREQUEST:
//        tgt.setValue(org.hl7.fhir.r4b.model.CarePlan.CarePlanActivityKind.DEVICEREQUEST);
//        break;
//      case MEDICATIONREQUEST:
//        tgt.setValue(org.hl7.fhir.r4b.model.CarePlan.CarePlanActivityKind.MEDICATIONREQUEST);
//        break;
//      case NUTRITIONORDER:
//        tgt.setValue(org.hl7.fhir.r4b.model.CarePlan.CarePlanActivityKind.NUTRITIONORDER);
//        break;
//      case TASK:
//        tgt.setValue(org.hl7.fhir.r4b.model.CarePlan.CarePlanActivityKind.TASK);
//        break;
//      case SERVICEREQUEST:
//        tgt.setValue(org.hl7.fhir.r4b.model.CarePlan.CarePlanActivityKind.SERVICEREQUEST);
//        break;
//      case VISIONPRESCRIPTION:
//        tgt.setValue(org.hl7.fhir.r4b.model.CarePlan.CarePlanActivityKind.VISIONPRESCRIPTION);
//        break;
//      default:
//        tgt.setValue(org.hl7.fhir.r4b.model.CarePlan.CarePlanActivityKind.NULL);
//        break;
//    }
//    return tgt;
//  }
//
//  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus> convertCarePlanActivityStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.CarePlan.CarePlanActivityStatus> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatusEnumFactory());
//    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
//    switch (src.getValue()) {
//      case NOTSTARTED:
//        tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.NOTSTARTED);
//        break;
//      case SCHEDULED:
//        tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.SCHEDULED);
//        break;
//      case INPROGRESS:
//        tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.INPROGRESS);
//        break;
//      case ONHOLD:
//        tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.ONHOLD);
//        break;
//      case COMPLETED:
//        tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.COMPLETED);
//        break;
//      case CANCELLED:
//        tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.CANCELLED);
//        break;
//      case STOPPED:
//        tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.STOPPED);
//        break;
//      case UNKNOWN:
//        tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.UNKNOWN);
//        break;
//      case ENTEREDINERROR:
//        tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.ENTEREDINERROR);
//        break;
//      default:
//        tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.NULL);
//        break;
//    }
//    return tgt;
//  }
//
//  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.CarePlan.CarePlanActivityStatus> convertCarePlanActivityStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.CarePlan.CarePlanActivityStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.CarePlan.CarePlanActivityStatusEnumFactory());
//    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
//    switch (src.getValue()) {
//      case NOTSTARTED:
//        tgt.setValue(org.hl7.fhir.r4b.model.CarePlan.CarePlanActivityStatus.NOTSTARTED);
//        break;
//      case SCHEDULED:
//        tgt.setValue(org.hl7.fhir.r4b.model.CarePlan.CarePlanActivityStatus.SCHEDULED);
//        break;
//      case INPROGRESS:
//        tgt.setValue(org.hl7.fhir.r4b.model.CarePlan.CarePlanActivityStatus.INPROGRESS);
//        break;
//      case ONHOLD:
//        tgt.setValue(org.hl7.fhir.r4b.model.CarePlan.CarePlanActivityStatus.ONHOLD);
//        break;
//      case COMPLETED:
//        tgt.setValue(org.hl7.fhir.r4b.model.CarePlan.CarePlanActivityStatus.COMPLETED);
//        break;
//      case CANCELLED:
//        tgt.setValue(org.hl7.fhir.r4b.model.CarePlan.CarePlanActivityStatus.CANCELLED);
//        break;
//      case STOPPED:
//        tgt.setValue(org.hl7.fhir.r4b.model.CarePlan.CarePlanActivityStatus.STOPPED);
//        break;
//      case UNKNOWN:
//        tgt.setValue(org.hl7.fhir.r4b.model.CarePlan.CarePlanActivityStatus.UNKNOWN);
//        break;
//      case ENTEREDINERROR:
//        tgt.setValue(org.hl7.fhir.r4b.model.CarePlan.CarePlanActivityStatus.ENTEREDINERROR);
//        break;
//      default:
//        tgt.setValue(org.hl7.fhir.r4b.model.CarePlan.CarePlanActivityStatus.NULL);
//        break;
//    }
//    return tgt;
//  }
}