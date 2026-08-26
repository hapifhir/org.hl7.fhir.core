package org.hl7.fhir.convertors.conv43_N.resources43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Annotation43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.CodeableConcept43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Identifier43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Period43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Canonical43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.DateTime43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Uri43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Reference43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4b.model.CarePlan;
import org.hl7.fhir.model.core.CodeableReference;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.Enumerations;

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

public class CarePlan43_N {

  public static org.hl7.fhir.model.core.CarePlan convertCarePlan(org.hl7.fhir.r4b.model.CarePlan src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.CarePlan tgt = new org.hl7.fhir.model.core.CarePlan();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference43_N.convertReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getReplaces()) tgt.addReplaces(Reference43_N.convertReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getPartOf()) tgt.addPartOf(Reference43_N.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertCarePlanStatus(src.getStatusElement()));
    if (src.hasIntent())
      tgt.setIntentElement(convertCarePlanIntent(src.getIntentElement()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasTitle())
      tgt.setTitleElement(String43_N.convertString(src.getTitleElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_N.convertString(src.getDescriptionElement()));
    if (src.hasSubject())
      tgt.setSubject(Reference43_N.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference43_N.convertReference(src.getEncounter()));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_N.convertPeriod(src.getPeriod()));
    if (src.hasCreated())
      tgt.setCreatedElement(DateTime43_N.convertDateTime(src.getCreatedElement()));
    if (src.hasAuthor())
      tgt.setCustodian(Reference43_N.convertReference(src.getAuthor()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getContributor())
      tgt.addContributor(Reference43_N.convertReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getCareTeam()) tgt.addCareTeam(Reference43_N.convertReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getAddresses())
      tgt.addAddresses(Reference43_N.convertReferenceToCodeableReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getSupportingInfo())
      tgt.addSupportingInfo(Reference43_N.convertReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getGoal()) tgt.addGoal(Reference43_N.convertReference(t));
    for (org.hl7.fhir.r4b.model.CarePlan.CarePlanActivityComponent t : src.getActivity())
      tgt.addActivity(convertCarePlanActivityComponent(t));
    for (org.hl7.fhir.r4b.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_N.convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.CarePlan convertCarePlan(org.hl7.fhir.model.core.CarePlan src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.CarePlan tgt = new org.hl7.fhir.r4b.model.CarePlan();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    for (org.hl7.fhir.model.core.Reference t : src.getBasedOnList()) tgt.addBasedOn(Reference43_N.convertReference(t));
    for (org.hl7.fhir.model.core.Reference t : src.getReplacesList()) tgt.addReplaces(Reference43_N.convertReference(t));
    for (org.hl7.fhir.model.core.Reference t : src.getPartOfList()) tgt.addPartOf(Reference43_N.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertCarePlanStatus(src.getStatusElement()));
    if (src.hasIntent())
      tgt.setIntentElement(convertCarePlanIntent(src.getIntentElement()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getCategoryList())
      tgt.addCategory(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasTitle())
      tgt.setTitleElement(String43_N.convertString(src.getTitleElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_N.convertString(src.getDescriptionElement()));
    if (src.hasSubject())
      tgt.setSubject(Reference43_N.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference43_N.convertReference(src.getEncounter()));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_N.convertPeriod(src.getPeriod()));
    if (src.hasCreated())
      tgt.setCreatedElement(DateTime43_N.convertDateTime(src.getCreatedElement()));
    if (src.hasCustodian())
      tgt.setAuthor(Reference43_N.convertReference(src.getCustodian()));
    for (org.hl7.fhir.model.core.Reference t : src.getContributorList())
      tgt.addContributor(Reference43_N.convertReference(t));
    for (org.hl7.fhir.model.core.Reference t : src.getCareTeamList()) tgt.addCareTeam(Reference43_N.convertReference(t));
    for (CodeableReference t : src.getAddressesList())
      if (t.hasReference())
        tgt.addAddresses(Reference43_N.convertReference(t.getReference()));
    for (org.hl7.fhir.model.core.Reference t : src.getSupportingInfoList())
      tgt.addSupportingInfo(Reference43_N.convertReference(t));
    for (org.hl7.fhir.model.core.Reference t : src.getGoalList()) tgt.addGoal(Reference43_N.convertReference(t));
    for (org.hl7.fhir.model.core.CarePlan.CarePlanActivityComponent t : src.getActivityList())
      tgt.addActivity(convertCarePlanActivityComponent(t));
    for (org.hl7.fhir.model.core.Annotation t : src.getNoteList()) tgt.addNote(Annotation43_N.convertAnnotation(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.RequestStatus> convertCarePlanStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.RequestStatus> tgt = new Enumeration<>(new Enumerations.RequestStatusEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case DRAFT:
                  tgt.setValue(Enumerations.RequestStatus.DRAFT);
                  break;
              case ACTIVE:
                  tgt.setValue(Enumerations.RequestStatus.ACTIVE);
                  break;
              case ONHOLD:
                  tgt.setValue(Enumerations.RequestStatus.ONHOLD);
                  break;
              case REVOKED:
                  tgt.setValue(Enumerations.RequestStatus.REVOKED);
                  break;
              case COMPLETED:
                  tgt.setValue(Enumerations.RequestStatus.COMPLETED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(Enumerations.RequestStatus.ENTEREDINERROR);
                  break;
              case UNKNOWN:
                  tgt.setValue(Enumerations.RequestStatus.UNKNOWN);
                  break;
              default:
                  tgt.setValue(Enumerations.RequestStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestStatus> convertCarePlanStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.RequestStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.RequestStatusEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CarePlan.CarePlanIntent> convertCarePlanIntent(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.CarePlan.CarePlanIntent> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<org.hl7.fhir.model.core.CarePlan.CarePlanIntent> tgt = new Enumeration<>(new org.hl7.fhir.model.core.CarePlan.CarePlanIntentEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PROPOSAL:
                  tgt.setValue(org.hl7.fhir.model.core.CarePlan.CarePlanIntent.PROPOSAL);
                  break;
              case PLAN:
                  tgt.setValue(org.hl7.fhir.model.core.CarePlan.CarePlanIntent.PLAN);
                  break;
              case ORDER:
                  tgt.setValue(org.hl7.fhir.model.core.CarePlan.CarePlanIntent.ORDER);
                  break;
              case OPTION:
                  tgt.setValue(org.hl7.fhir.model.core.CarePlan.CarePlanIntent.OPTION);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.model.core.CarePlan.CarePlanIntent.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.CarePlan.CarePlanIntent> convertCarePlanIntent(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CarePlan.CarePlanIntent> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<CarePlan.CarePlanIntent> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new CarePlan.CarePlanIntentEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PROPOSAL:
                  tgt.setValue(CarePlan.CarePlanIntent.PROPOSAL);
                  break;
              case PLAN:
                  tgt.setValue(CarePlan.CarePlanIntent.PLAN);
                  break;
              case ORDER:
                  tgt.setValue(CarePlan.CarePlanIntent.ORDER);
                  break;
              case OPTION:
                  tgt.setValue(CarePlan.CarePlanIntent.OPTION);
                  break;
              default:
                  tgt.setValue(CarePlan.CarePlanIntent.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.CarePlan.CarePlanActivityComponent convertCarePlanActivityComponent(org.hl7.fhir.r4b.model.CarePlan.CarePlanActivityComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.CarePlan.CarePlanActivityComponent tgt = new org.hl7.fhir.model.core.CarePlan.CarePlanActivityComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getOutcomeCodeableConcept())
      tgt.addPerformedActivity(CodeableConcept43_N.convertCodeableConceptToCodeableReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getOutcomeReference())
      tgt.addPerformedActivity(Reference43_N.convertReferenceToCodeableReference(t));
    for (org.hl7.fhir.r4b.model.Annotation t : src.getProgress()) tgt.addProgress(Annotation43_N.convertAnnotation(t));
    if (src.hasReference())
      tgt.setPlannedActivityReference(Reference43_N.convertReference(src.getReference()));
//    if (src.hasDetail())
//      tgt.setPlannedActivityDetail(convertCarePlanActivityDetailComponent(src.getDetail()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.CarePlan.CarePlanActivityComponent convertCarePlanActivityComponent(org.hl7.fhir.model.core.CarePlan.CarePlanActivityComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.CarePlan.CarePlanActivityComponent tgt = new org.hl7.fhir.r4b.model.CarePlan.CarePlanActivityComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    for (CodeableReference t : src.getPerformedActivityList())
      if (t.hasConcept())
        tgt.addOutcomeCodeableConcept(CodeableConcept43_N.convertCodeableConcept(t.getConcept()));
    for (CodeableReference t : src.getPerformedActivityList())
      if (t.hasReference())
        tgt.addOutcomeReference(Reference43_N.convertReference(t.getReference()));
    for (org.hl7.fhir.model.core.Annotation t : src.getProgressList()) tgt.addProgress(Annotation43_N.convertAnnotation(t));
    if (src.hasPlannedActivityReference())
      tgt.setReference(Reference43_N.convertReference(src.getPlannedActivityReference()));
//    if (src.hasPlannedActivityDetail())
//      tgt.setDetail(convertCarePlanActivityDetailComponent(src.getPlannedActivityDetail()));
    return tgt;
  }
//
//  public static org.hl7.fhir.model.core.CarePlan.CarePlanActivityPlannedActivityDetailComponent convertCarePlanActivityDetailComponent(org.hl7.fhir.r4b.model.CarePlan.CarePlanActivityDetailComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.model.core.CarePlan.CarePlanActivityPlannedActivityDetailComponent tgt = new org.hl7.fhir.model.core.CarePlan.CarePlanActivityPlannedActivityDetailComponent();
//    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
//    if (src.hasKind())
//      tgt.setKindElement(convertCarePlanActivityKind(src.getKindElement()));
//    for (org.hl7.fhir.r4b.model.CanonicalType t : src.getInstantiatesCanonical())
//      tgt.getInstantiatesCanonical().add(Canonical43_N.convertCanonical(t));
//    for (org.hl7.fhir.r4b.model.UriType t : src.getInstantiatesUri())
//      tgt.getInstantiatesUri().add(Uri43_N.convertUri(t));
//    if (src.hasCode())
//      tgt.setCode(CodeableConcept43_N.convertCodeableConcept(src.getCode()));
//    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getReasonCode())
//      tgt.addReason(CodeableConcept43_N.convertCodeableConceptToCodeableReference(t));
//    for (org.hl7.fhir.r4b.model.Reference t : src.getReasonReference())
//      tgt.addReason(Reference43_N.convertReferenceToCodeableReference(t));
//    for (org.hl7.fhir.r4b.model.Reference t : src.getGoal()) tgt.addGoal(Reference43_N.convertReference(t));
//    if (src.hasStatus())
//      tgt.setStatusElement(convertCarePlanActivityStatus(src.getStatusElement()));
//    if (src.hasStatusReason())
//      tgt.setStatusReason(CodeableConcept43_N.convertCodeableConcept(src.getStatusReason()));
//    if (src.hasDoNotPerform())
//      tgt.setDoNotPerformElement(Boolean43_N.convertBoolean(src.getDoNotPerformElement()));
//    if (src.hasScheduled())
//      tgt.setScheduled(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getScheduled()));
//    if (src.hasLocation())
//      tgt.getLocation().setReference(Reference43_N.convertReference(src.getLocation()));
//    for (org.hl7.fhir.r4b.model.Reference t : src.getPerformer()) tgt.addPerformer(Reference43_N.convertReference(t));
//    if (src.hasProduct())
//      tgt.setProduct(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getProduct()));
//    if (src.hasDailyAmount())
//      tgt.setDailyAmount(SimpleQuantity43_N.convertSimpleQuantity(src.getDailyAmount()));
//    if (src.hasQuantity())
//      tgt.setQuantity(SimpleQuantity43_N.convertSimpleQuantity(src.getQuantity()));
//    if (src.hasDescription())
//      tgt.setDescriptionElement(String43_N.convertString(src.getDescriptionElement()));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r4b.model.CarePlan.CarePlanActivityDetailComponent convertCarePlanActivityDetailComponent(org.hl7.fhir.model.core.CarePlan.CarePlanActivityPlannedActivityDetailComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r4b.model.CarePlan.CarePlanActivityDetailComponent tgt = new org.hl7.fhir.r4b.model.CarePlan.CarePlanActivityDetailComponent();
//    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
//    if (src.hasKind())
//      tgt.setKindElement(convertCarePlanActivityKind(src.getKindElement()));
//    for (org.hl7.fhir.model.core.CanonicalType t : src.getInstantiatesCanonicalList())
//      tgt.getInstantiatesCanonical().add(Canonical43_N.convertCanonical(t));
//    for (org.hl7.fhir.model.core.UriType t : src.getInstantiatesUriList())
//      tgt.getInstantiatesUri().add(Uri43_N.convertUri(t));
//    if (src.hasCode())
//      tgt.setCode(CodeableConcept43_N.convertCodeableConcept(src.getCode()));
//    for (CodeableReference t : src.getReasonList())
//      if (t.hasConcept())
//        tgt.addReasonCode(CodeableConcept43_N.convertCodeableConcept(t.getConcept()));
//    for (CodeableReference t : src.getReasonList())
//      if (t.hasReference())
//        tgt.addReasonReference(Reference43_N.convertReference(t.getReference()));
//    for (org.hl7.fhir.model.core.Reference t : src.getGoalList()) tgt.addGoal(Reference43_N.convertReference(t));
//    if (src.hasStatus())
//      tgt.setStatusElement(convertCarePlanActivityStatus(src.getStatusElement()));
//    if (src.hasStatusReason())
//      tgt.setStatusReason(CodeableConcept43_N.convertCodeableConcept(src.getStatusReason()));
//    if (src.hasDoNotPerform())
//      tgt.setDoNotPerformElement(Boolean43_N.convertBoolean(src.getDoNotPerformElement()));
//    if (src.hasScheduled())
//      tgt.setScheduled(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getScheduled()));
//    if (src.getLocation().hasReference())
//      tgt.setLocation(Reference43_N.convertReference(src.getLocation().getReference()));
//    for (org.hl7.fhir.model.core.Reference t : src.getPerformerList()) tgt.addPerformer(Reference43_N.convertReference(t));
//    if (src.hasProduct())
//      tgt.setProduct(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getProduct()));
//    if (src.hasDailyAmount())
//      tgt.setDailyAmount(SimpleQuantity43_N.convertSimpleQuantity(src.getDailyAmount()));
//    if (src.hasQuantity())
//      tgt.setQuantity(SimpleQuantity43_N.convertSimpleQuantity(src.getQuantity()));
//    if (src.hasDescription())
//      tgt.setDescriptionElement(String43_N.convertString(src.getDescriptionElement()));
//    return tgt;
//  }
//
//  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CarePlan.CarePlanActivityKind> convertCarePlanActivityKind(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.CarePlan.CarePlanActivityKind> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CarePlan.CarePlanActivityKind> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.CarePlan.CarePlanActivityKindEnumFactory());
//    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
//    switch (src.getValue()) {
//      case APPOINTMENT:
//        tgt.setValue(org.hl7.fhir.model.core.CarePlan.CarePlanActivityKind.APPOINTMENT);
//        break;
//      case COMMUNICATIONREQUEST:
//        tgt.setValue(org.hl7.fhir.model.core.CarePlan.CarePlanActivityKind.COMMUNICATIONREQUEST);
//        break;
//      case DEVICEREQUEST:
//        tgt.setValue(org.hl7.fhir.model.core.CarePlan.CarePlanActivityKind.DEVICEREQUEST);
//        break;
//      case MEDICATIONREQUEST:
//        tgt.setValue(org.hl7.fhir.model.core.CarePlan.CarePlanActivityKind.MEDICATIONREQUEST);
//        break;
//      case NUTRITIONORDER:
//        tgt.setValue(org.hl7.fhir.model.core.CarePlan.CarePlanActivityKind.NUTRITIONORDER);
//        break;
//      case TASK:
//        tgt.setValue(org.hl7.fhir.model.core.CarePlan.CarePlanActivityKind.TASK);
//        break;
//      case SERVICEREQUEST:
//        tgt.setValue(org.hl7.fhir.model.core.CarePlan.CarePlanActivityKind.SERVICEREQUEST);
//        break;
//      case VISIONPRESCRIPTION:
//        tgt.setValue(org.hl7.fhir.model.core.CarePlan.CarePlanActivityKind.VISIONPRESCRIPTION);
//        break;
//      default:
//        tgt.setValue(org.hl7.fhir.model.core.CarePlan.CarePlanActivityKind.NULL);
//        break;
//    }
//    return tgt;
//  }
//
//  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.CarePlan.CarePlanActivityKind> convertCarePlanActivityKind(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CarePlan.CarePlanActivityKind> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.CarePlan.CarePlanActivityKind> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.CarePlan.CarePlanActivityKindEnumFactory());
//    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
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
//  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CarePlan.CarePlanActivityStatus> convertCarePlanActivityStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.CarePlan.CarePlanActivityStatus> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CarePlan.CarePlanActivityStatus> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.CarePlan.CarePlanActivityStatusEnumFactory());
//    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
//    switch (src.getValue()) {
//      case NOTSTARTED:
//        tgt.setValue(org.hl7.fhir.model.core.CarePlan.CarePlanActivityStatus.NOTSTARTED);
//        break;
//      case SCHEDULED:
//        tgt.setValue(org.hl7.fhir.model.core.CarePlan.CarePlanActivityStatus.SCHEDULED);
//        break;
//      case INPROGRESS:
//        tgt.setValue(org.hl7.fhir.model.core.CarePlan.CarePlanActivityStatus.INPROGRESS);
//        break;
//      case ONHOLD:
//        tgt.setValue(org.hl7.fhir.model.core.CarePlan.CarePlanActivityStatus.ONHOLD);
//        break;
//      case COMPLETED:
//        tgt.setValue(org.hl7.fhir.model.core.CarePlan.CarePlanActivityStatus.COMPLETED);
//        break;
//      case CANCELLED:
//        tgt.setValue(org.hl7.fhir.model.core.CarePlan.CarePlanActivityStatus.CANCELLED);
//        break;
//      case STOPPED:
//        tgt.setValue(org.hl7.fhir.model.core.CarePlan.CarePlanActivityStatus.STOPPED);
//        break;
//      case UNKNOWN:
//        tgt.setValue(org.hl7.fhir.model.core.CarePlan.CarePlanActivityStatus.UNKNOWN);
//        break;
//      case ENTEREDINERROR:
//        tgt.setValue(org.hl7.fhir.model.core.CarePlan.CarePlanActivityStatus.ENTEREDINERROR);
//        break;
//      default:
//        tgt.setValue(org.hl7.fhir.model.core.CarePlan.CarePlanActivityStatus.NULL);
//        break;
//    }
//    return tgt;
//  }
//
//  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.CarePlan.CarePlanActivityStatus> convertCarePlanActivityStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CarePlan.CarePlanActivityStatus> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.CarePlan.CarePlanActivityStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.CarePlan.CarePlanActivityStatusEnumFactory());
//    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
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