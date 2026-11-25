package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionElements40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionDatatype40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Annotation40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Period40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Canonical40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.DateTime40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Uri40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.CarePlan;
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

public class CarePlan40_N {

  public static org.hl7.fhir.model.core.CarePlan convertCarePlan(org.hl7.fhir.r4.model.CarePlan src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.CarePlan tgt = new org.hl7.fhir.model.core.CarePlan();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, CrossVersionElements40_N.url("CarePlan", "5.0", "addresses"));
    // R6 dropped these
    CrossVersionElements40_N.r4ElementsToExtensions(src, "CarePlan", tgt.getExtension(), "instantiatesCanonical", "instantiatesUri");
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference40_N.convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getReplaces()) tgt.addReplaces(Reference40_N.convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getPartOf()) tgt.addPartOf(Reference40_N.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(CrossVersionElements40_N.toR6Code(src.getStatusElement(), convertCarePlanStatus(src.getStatusElement()), src.fhirType(), "status"));
    if (src.hasIntent())
      tgt.setIntentElement(CrossVersionElements40_N.toR6Code(src.getIntentElement(), convertCarePlanIntent(src.getIntentElement()), src.fhirType(), "intent"));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasTitle())
      tgt.setTitleElement(String40_N.convertString(src.getTitleElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
    if (src.hasSubject())
      tgt.setSubject(Reference40_N.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_N.convertReference(src.getEncounter()));
    if (src.hasPeriod())
      tgt.setPeriod(Period40_N.convertPeriod(src.getPeriod()));
    if (src.hasCreated())
      tgt.setCreatedElement(DateTime40_N.convertDateTime(src.getCreatedElement()));
    if (src.hasAuthor())
      tgt.setCustodian(Reference40_N.convertReference(src.getAuthor()));
    for (org.hl7.fhir.r4.model.Reference t : src.getContributor())
      tgt.addContributor(Reference40_N.convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getCareTeam()) tgt.addCareTeam(Reference40_N.convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getAddresses())
      tgt.addAddresses(Reference40_N.convertReferenceToCodeableReference(t));
    // the ones that were more than a reference
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "addresses");
    for (org.hl7.fhir.r4.model.Reference t : src.getSupportingInfo())
      tgt.addSupportingInfo(Reference40_N.convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getGoal()) tgt.addGoal(Reference40_N.convertReference(t));
    for (org.hl7.fhir.r4.model.CarePlan.CarePlanActivityComponent t : src.getActivity())
      tgt.addActivity(convertCarePlanActivityComponent(t));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(Annotation40_N.convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CarePlan convertCarePlan(org.hl7.fhir.model.core.CarePlan src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CarePlan tgt = new org.hl7.fhir.r4.model.CarePlan();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, CrossVersionElements40_N.urls("CarePlan", "4.0", new String[] {"instantiatesCanonical", "instantiatesUri"}));
    CrossVersionElements40_N.extensionsToR4Elements(src.getExtension(), tgt, "CarePlan", "instantiatesCanonical", "instantiatesUri");
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    for (org.hl7.fhir.model.core.Reference t : src.getBasedOnList()) tgt.addBasedOn(Reference40_N.convertReference(t));
    for (org.hl7.fhir.model.core.Reference t : src.getReplacesList()) tgt.addReplaces(Reference40_N.convertReference(t));
    for (org.hl7.fhir.model.core.Reference t : src.getPartOfList()) tgt.addPartOf(Reference40_N.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(CrossVersionElements40_N.toR4Code(src.getStatusElement(), convertCarePlanStatus(src.getStatusElement()), src.fhirType(), "status"));
    if (src.hasIntent())
      tgt.setIntentElement(CrossVersionElements40_N.toR4Code(src.getIntentElement(), convertCarePlanIntent(src.getIntentElement()), src.fhirType(), "intent"));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getCategoryList())
      tgt.addCategory(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasTitle())
      tgt.setTitleElement(String40_N.convertString(src.getTitleElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
    if (src.hasSubject())
      tgt.setSubject(Reference40_N.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_N.convertReference(src.getEncounter()));
    if (src.hasPeriod())
      tgt.setPeriod(Period40_N.convertPeriod(src.getPeriod()));
    if (src.hasCreated())
      tgt.setCreatedElement(DateTime40_N.convertDateTime(src.getCreatedElement()));
    if (src.hasCustodian())
      tgt.setAuthor(Reference40_N.convertReference(src.getCustodian()));
    for (org.hl7.fhir.model.core.Reference t : src.getContributorList())
      tgt.addContributor(Reference40_N.convertReference(t));
    for (org.hl7.fhir.model.core.Reference t : src.getCareTeamList()) tgt.addCareTeam(Reference40_N.convertReference(t));
    // R4 addresses is only a Reference: anything more goes whole in a 5.0 extension
    for (CodeableReference t : src.getAddressesList()) {
      if (t.hasReference() && !t.hasConcept() && !t.hasId() && !t.hasExtension())
        tgt.addAddresses(Reference40_N.convertReference(t.getReference()));
      else
        tgt.addExtension(CrossVersionDatatype40_N.convertToExtension(CrossVersionElements40_N.url("CarePlan", "5.0", "addresses"), t));
    }
    for (org.hl7.fhir.model.core.Reference t : src.getSupportingInfoList())
      tgt.addSupportingInfo(Reference40_N.convertReference(t));
    for (org.hl7.fhir.model.core.Reference t : src.getGoalList()) tgt.addGoal(Reference40_N.convertReference(t));
    for (org.hl7.fhir.model.core.CarePlan.CarePlanActivityComponent t : src.getActivityList())
      tgt.addActivity(convertCarePlanActivityComponent(t));
    for (org.hl7.fhir.model.core.Annotation t : src.getNoteList()) tgt.addNote(Annotation40_N.convertAnnotation(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.RequestStatus> convertCarePlanStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CarePlan.CarePlanStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.RequestStatus> tgt = new Enumeration<>(new Enumerations.RequestStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CarePlan.CarePlanStatus> convertCarePlanStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.RequestStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<CarePlan.CarePlanStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new CarePlan.CarePlanStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case DRAFT:
                  tgt.setValue(CarePlan.CarePlanStatus.DRAFT);
                  break;
              case ACTIVE:
                  tgt.setValue(CarePlan.CarePlanStatus.ACTIVE);
                  break;
              case ONHOLD:
                  tgt.setValue(CarePlan.CarePlanStatus.ONHOLD);
                  break;
              case REVOKED:
                  tgt.setValue(CarePlan.CarePlanStatus.REVOKED);
                  break;
              case COMPLETED:
                  tgt.setValue(CarePlan.CarePlanStatus.COMPLETED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(CarePlan.CarePlanStatus.ENTEREDINERROR);
                  break;
              case UNKNOWN:
                  tgt.setValue(CarePlan.CarePlanStatus.UNKNOWN);
                  break;
              default:
                  tgt.setValue(CarePlan.CarePlanStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CarePlan.CarePlanIntent> convertCarePlanIntent(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CarePlan.CarePlanIntent> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<org.hl7.fhir.model.core.CarePlan.CarePlanIntent> tgt = new Enumeration<>(new org.hl7.fhir.model.core.CarePlan.CarePlanIntentEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CarePlan.CarePlanIntent> convertCarePlanIntent(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CarePlan.CarePlanIntent> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<CarePlan.CarePlanIntent> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new CarePlan.CarePlanIntentEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
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

  public static org.hl7.fhir.model.core.CarePlan.CarePlanActivityComponent convertCarePlanActivityComponent(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.CarePlan.CarePlanActivityComponent tgt = new org.hl7.fhir.model.core.CarePlan.CarePlanActivityComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    CodeableConcept40_N.convertReasonsToR6(src.getOutcomeCodeableConcept(), src.getOutcomeReference(), tgt.getPerformedActivityList());
    for (org.hl7.fhir.r4.model.Annotation t : src.getProgress()) tgt.addProgress(Annotation40_N.convertAnnotation(t));
    if (src.hasReference())
      tgt.setPlannedActivityReference(Reference40_N.convertReference(src.getReference()));
    // R6 dropped detail (it's meant to be a request resource now): it's kept whole in a 4.0 extension
    CrossVersionElements40_N.r4ElementsToExtensions(src, "CarePlan.activity", tgt.getExtension(), "detail");
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CarePlan.CarePlanActivityComponent convertCarePlanActivityComponent(org.hl7.fhir.model.core.CarePlan.CarePlanActivityComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CarePlan.CarePlanActivityComponent tgt = new org.hl7.fhir.r4.model.CarePlan.CarePlanActivityComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, CrossVersionElements40_N.url("CarePlan.activity", "4.0", "detail"));
    CrossVersionElements40_N.extensionsToR4Elements(src.getExtension(), tgt, "CarePlan.activity", "detail");
    CodeableConcept40_N.convertReasonsToR4(src.getPerformedActivityList(), tgt.getOutcomeCodeableConcept(), tgt.getOutcomeReference());
    for (org.hl7.fhir.model.core.Annotation t : src.getProgressList()) tgt.addProgress(Annotation40_N.convertAnnotation(t));
    if (src.hasPlannedActivityReference())
      tgt.setReference(Reference40_N.convertReference(src.getPlannedActivityReference()));
    return tgt;
  }
//
//  public static org.hl7.fhir.model.core.CarePlan.CarePlanActivityPlannedActivityDetailComponent convertCarePlanActivityDetailComponent(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityDetailComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.model.core.CarePlan.CarePlanActivityPlannedActivityDetailComponent tgt = new org.hl7.fhir.model.core.CarePlan.CarePlanActivityPlannedActivityDetailComponent();
//    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
//    if (src.hasKind())
//      tgt.setKindElement(CrossVersionElements40_N.toR6Code(src.getKindElement(), convertCarePlanActivityKind(src.getKindElement()), src.fhirType(), "kind"));
//    for (org.hl7.fhir.r4.model.CanonicalType t : src.getInstantiatesCanonical())
//      tgt.getInstantiatesCanonical().add(Canonical40_N.convertCanonical(t));
//    for (org.hl7.fhir.r4.model.UriType t : src.getInstantiatesUri())
//      tgt.getInstantiatesUri().add(Uri40_N.convertUri(t));
//    if (src.hasCode())
//      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
//    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode())
//      tgt.addReason(CodeableConcept40_N.convertCodeableConceptToCodeableReference(t));
//    for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference())
//      tgt.addReason(Reference40_N.convertReferenceToCodeableReference(t));
//    for (org.hl7.fhir.r4.model.Reference t : src.getGoal()) tgt.addGoal(Reference40_N.convertReference(t));
//    if (src.hasStatus())
//      tgt.setStatusElement(CrossVersionElements40_N.toR6Code(src.getStatusElement(), convertCarePlanActivityStatus(src.getStatusElement()), src.fhirType(), "status"));
//    if (src.hasStatusReason())
//      tgt.setStatusReason(CodeableConcept40_N.convertCodeableConcept(src.getStatusReason()));
//    if (src.hasDoNotPerform())
//      tgt.setDoNotPerformElement(Boolean40_N.convertBoolean(src.getDoNotPerformElement()));
//    if (src.hasScheduled())
//      tgt.setScheduled(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getScheduled()));
//    if (src.hasLocation())
//      tgt.getLocation().setReference(Reference40_N.convertReference(src.getLocation()));
//    for (org.hl7.fhir.r4.model.Reference t : src.getPerformer()) tgt.addPerformer(Reference40_N.convertReference(t));
//    if (src.hasProduct())
//      tgt.setProduct(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getProduct()));
//    if (src.hasDailyAmount())
//      tgt.setDailyAmount(SimpleQuantity40_N.convertSimpleQuantity(src.getDailyAmount()));
//    if (src.hasQuantity())
//      tgt.setQuantity(SimpleQuantity40_N.convertSimpleQuantity(src.getQuantity()));
//    if (src.hasDescription())
//      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r4.model.CarePlan.CarePlanActivityDetailComponent convertCarePlanActivityDetailComponent(org.hl7.fhir.model.core.CarePlan.CarePlanActivityPlannedActivityDetailComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r4.model.CarePlan.CarePlanActivityDetailComponent tgt = new org.hl7.fhir.r4.model.CarePlan.CarePlanActivityDetailComponent();
//    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
//    if (src.hasKind())
//      tgt.setKindElement(CrossVersionElements40_N.toR4Code(src.getKindElement(), convertCarePlanActivityKind(src.getKindElement()), src.fhirType(), "kind"));
//    for (org.hl7.fhir.model.core.CanonicalType t : src.getInstantiatesCanonicalList())
//      tgt.getInstantiatesCanonical().add(Canonical40_N.convertCanonical(t));
//    for (org.hl7.fhir.model.core.UriType t : src.getInstantiatesUriList())
//      tgt.getInstantiatesUri().add(Uri40_N.convertUri(t));
//    if (src.hasCode())
//      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
//    for (CodeableReference t : src.getReasonList())
//      if (t.hasConcept())
//        tgt.addReasonCode(CodeableConcept40_N.convertCodeableConcept(t.getConcept()));
//    for (CodeableReference t : src.getReasonList())
//      if (t.hasReference())
//        tgt.addReasonReference(Reference40_N.convertReference(t.getReference()));
//    for (org.hl7.fhir.model.core.Reference t : src.getGoalList()) tgt.addGoal(Reference40_N.convertReference(t));
//    if (src.hasStatus())
//      tgt.setStatusElement(CrossVersionElements40_N.toR4Code(src.getStatusElement(), convertCarePlanActivityStatus(src.getStatusElement()), src.fhirType(), "status"));
//    if (src.hasStatusReason())
//      tgt.setStatusReason(CodeableConcept40_N.convertCodeableConcept(src.getStatusReason()));
//    if (src.hasDoNotPerform())
//      tgt.setDoNotPerformElement(Boolean40_N.convertBoolean(src.getDoNotPerformElement()));
//    if (src.hasScheduled())
//      tgt.setScheduled(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getScheduled()));
//    if (src.getLocation().hasReference())
//      tgt.setLocation(Reference40_N.convertReference(src.getLocation().getReference()));
//    for (org.hl7.fhir.model.core.Reference t : src.getPerformerList()) tgt.addPerformer(Reference40_N.convertReference(t));
//    if (src.hasProduct())
//      tgt.setProduct(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getProduct()));
//    if (src.hasDailyAmount())
//      tgt.setDailyAmount(SimpleQuantity40_N.convertSimpleQuantity(src.getDailyAmount()));
//    if (src.hasQuantity())
//      tgt.setQuantity(SimpleQuantity40_N.convertSimpleQuantity(src.getQuantity()));
//    if (src.hasDescription())
//      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
//    return tgt;
//  }
//
//  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CarePlan.CarePlanActivityKind> convertCarePlanActivityKind(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CarePlan.CarePlanActivityKind> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CarePlan.CarePlanActivityKind> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.CarePlan.CarePlanActivityKindEnumFactory());
//    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
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
//  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CarePlan.CarePlanActivityKind> convertCarePlanActivityKind(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CarePlan.CarePlanActivityKind> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CarePlan.CarePlanActivityKind> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.CarePlan.CarePlanActivityKindEnumFactory());
//    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
//    switch (src.getValue()) {
//      case APPOINTMENT:
//        tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityKind.APPOINTMENT);
//        break;
//      case COMMUNICATIONREQUEST:
//        tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityKind.COMMUNICATIONREQUEST);
//        break;
//      case DEVICEREQUEST:
//        tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityKind.DEVICEREQUEST);
//        break;
//      case MEDICATIONREQUEST:
//        tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityKind.MEDICATIONREQUEST);
//        break;
//      case NUTRITIONORDER:
//        tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityKind.NUTRITIONORDER);
//        break;
//      case TASK:
//        tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityKind.TASK);
//        break;
//      case SERVICEREQUEST:
//        tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityKind.SERVICEREQUEST);
//        break;
//      case VISIONPRESCRIPTION:
//        tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityKind.VISIONPRESCRIPTION);
//        break;
//      default:
//        tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityKind.NULL);
//        break;
//    }
//    return tgt;
//  }
//
//  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CarePlan.CarePlanActivityStatus> convertCarePlanActivityStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CarePlan.CarePlanActivityStatus> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.CarePlan.CarePlanActivityStatusEnumFactory());
//    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
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
//  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus> convertCarePlanActivityStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CarePlan.CarePlanActivityStatus> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatusEnumFactory());
//    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
//    switch (src.getValue()) {
//      case NOTSTARTED:
//        tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus.NOTSTARTED);
//        break;
//      case SCHEDULED:
//        tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus.SCHEDULED);
//        break;
//      case INPROGRESS:
//        tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus.INPROGRESS);
//        break;
//      case ONHOLD:
//        tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus.ONHOLD);
//        break;
//      case COMPLETED:
//        tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus.COMPLETED);
//        break;
//      case CANCELLED:
//        tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus.CANCELLED);
//        break;
//      case STOPPED:
//        tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus.STOPPED);
//        break;
//      case UNKNOWN:
//        tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus.UNKNOWN);
//        break;
//      case ENTEREDINERROR:
//        tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus.ENTEREDINERROR);
//        break;
//      default:
//        tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus.NULL);
//        break;
//    }
//    return tgt;
//  }
}