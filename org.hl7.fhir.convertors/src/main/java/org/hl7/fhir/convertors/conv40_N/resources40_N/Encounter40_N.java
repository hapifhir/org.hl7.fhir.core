package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionDatatype40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionElements40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Coding40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Duration40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Period40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.Encounter;
import org.hl7.fhir.model.core.CodeableReference;
import org.hl7.fhir.model.core.Encounter.ReasonComponent;
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

public class Encounter40_N {

  // R6 reason.use, on each R4 reasonCode / reasonReference that came from that reason
  public static final String REASON_USE_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-Encounter.reason.use";

  /**
   * R6 reason is a list of (use, values). Each value becomes an R4 reasonCode (a concept, with any reference on it in
   * the CodeableReference extension) or reasonReference, carrying the reason's uses as extensions
   */
  private static void convertReasons(org.hl7.fhir.model.core.Encounter src, org.hl7.fhir.r4.model.Encounter tgt) throws FHIRException {
    for (ReasonComponent r : src.getReasonList()) {
      for (CodeableReference v : r.getValueList()) {
        org.hl7.fhir.r4.model.Element e;
        if (v.hasConcept()) {
          e = CodeableConcept40_N.convertCodeableReferenceToCodeableConcept(v);
          tgt.addReasonCode((org.hl7.fhir.r4.model.CodeableConcept) e);
        } else {
          e = Reference40_N.convertReference(v.getReference());
          tgt.addReasonReference((org.hl7.fhir.r4.model.Reference) e);
        }
        for (org.hl7.fhir.model.core.CodeableConcept u : r.getUseList())
          e.addExtension(REASON_USE_EXTENSION_URL, CodeableConcept40_N.convertCodeableConcept(u));
      }
    }
  }

  /**
   * The reverse: the R4 reasons are grouped by their set of uses, one R6 reason for each set (in the order they
   * first appear, codes before references)
   */
  private static void convertReasons(org.hl7.fhir.r4.model.Encounter src, org.hl7.fhir.model.core.Encounter tgt) throws FHIRException {
    java.util.List<org.hl7.fhir.r4.model.Element> values = new java.util.ArrayList<>();
    values.addAll(src.getReasonCode());
    values.addAll(src.getReasonReference());
    java.util.Map<String, ReasonComponent> groups = new java.util.HashMap<>();
    for (org.hl7.fhir.r4.model.Element e : values) {
      java.util.List<org.hl7.fhir.r4.model.CodeableConcept> uses = new java.util.ArrayList<>();
      StringBuilder key = new StringBuilder();
      for (org.hl7.fhir.r4.model.Extension ext : e.getExtensionsByUrl(REASON_USE_EXTENSION_URL)) {
        org.hl7.fhir.r4.model.CodeableConcept u = (org.hl7.fhir.r4.model.CodeableConcept) ext.getValue();
        uses.add(u);
        for (org.hl7.fhir.r4.model.Coding c : u.getCoding())
          key.append(c.getSystem()).append("#").append(c.getVersion()).append("#").append(c.getCode()).append("#").append(c.getDisplay()).append(";");
        key.append(u.getText()).append("|");
      }
      ReasonComponent r = groups.get(key.toString());
      if (r == null) {
        r = tgt.addReason();
        for (org.hl7.fhir.r4.model.CodeableConcept u : uses)
          r.addUse(CodeableConcept40_N.convertCodeableConcept(u));
        groups.put(key.toString(), r);
      }
      CodeableReference v;
      if (e instanceof org.hl7.fhir.r4.model.CodeableConcept) {
        v = CodeableConcept40_N.convertCodeableConceptToCodeableReference((org.hl7.fhir.r4.model.CodeableConcept) e);
        if (v.hasConcept())
          v.getConcept().removeExtension(REASON_USE_EXTENSION_URL);
      } else {
        v = Reference40_N.convertReferenceToCodeableReference((org.hl7.fhir.r4.model.Reference) e);
        v.getReference().removeExtension(REASON_USE_EXTENSION_URL);
      }
      r.addValue(v);
    }
  }

  // the R6 classes R4's single Coding can't hold
  public static final String CLASS_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-Encounter.class";

  public static org.hl7.fhir.model.core.Encounter convertEncounter(org.hl7.fhir.r4.model.Encounter src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Encounter tgt = new org.hl7.fhir.model.core.Encounter();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, CrossVersionElements40_N.urls("Encounter", "5.0", new String[] {"subjectStatus", "careTeam", "virtualService", "plannedStartDate", "plannedEndDate", "class", "serviceType"}, CrossVersionElements40_N.urls("Encounter", "6.0", new String[] {"businessStatus"})));
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "subjectStatus", "careTeam", "virtualService", "plannedStartDate", "plannedEndDate");
    // R6 dropped statusHistory and classHistory
    CrossVersionElements40_N.r4ElementsToExtensions(src, "Encounter", tgt.getExtension(), "statusHistory", "classHistory");
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "6.0", "businessStatus");
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(CrossVersionElements40_N.toR6Code(src.getStatusElement(), convertEncounterStatus(src.getStatusElement()), src.fhirType(), "status"));
    CrossVersionElements40_N.keepR4Code(src.getStatusElement(), tgt.getStatusElement(), convertEncounterStatus(tgt.getStatusElement()), CrossVersionElements40_N.url("Encounter", "4.0", "status"));
    if (src.hasClass_())
      tgt.addClass_(CodeableConcept40_N.convertCodingToCodeableConcept(src.getClass_(), CLASS_EXTENSION_URL));
    // the other classes (R4 has only one)
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "class");
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasServiceType())
      tgt.addServiceType(CodeableConcept40_N.convertCodeableConceptToCodeableReference(src.getServiceType()));
    // the other service types (R4 has only one)
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "serviceType");
    if (src.hasPriority())
      tgt.setPriority(CodeableConcept40_N.convertCodeableConcept(src.getPriority()));
    if (src.hasSubject())
      tgt.setSubject(Reference40_N.convertReference(src.getSubject()));
    for (org.hl7.fhir.r4.model.Reference t : src.getEpisodeOfCare())
      tgt.addEpisodeOfCare(Reference40_N.convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference40_N.convertReference(t));
    for (org.hl7.fhir.r4.model.Encounter.EncounterParticipantComponent t : src.getParticipant())
      tgt.addParticipant(convertEncounterParticipantComponent(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getAppointment())
      tgt.addAppointment(Reference40_N.convertReference(t));
    if (src.hasPeriod())
      tgt.setActualPeriod(Period40_N.convertPeriod(src.getPeriod()));
    if (src.hasLength())
      tgt.setLength(Duration40_N.convertDuration(src.getLength()));
    convertReasons(src, tgt);
    for (org.hl7.fhir.r4.model.Encounter.DiagnosisComponent t : src.getDiagnosis())
      tgt.addDiagnosis(convertDiagnosisComponent(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getAccount()) tgt.addAccount(Reference40_N.convertReference(t));
    if (src.hasHospitalization())
      tgt.setAdmission(convertEncounterHospitalizationComponent(src.getHospitalization(), tgt));
    for (org.hl7.fhir.r4.model.Encounter.EncounterLocationComponent t : src.getLocation())
      tgt.addLocation(convertEncounterLocationComponent(t));
    if (src.hasServiceProvider())
      tgt.setServiceProvider(Reference40_N.convertReference(src.getServiceProvider()));
    if (src.hasPartOf())
      tgt.setPartOf(Reference40_N.convertReference(src.getPartOf()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Encounter convertEncounter(org.hl7.fhir.model.core.Encounter src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Encounter tgt = new org.hl7.fhir.r4.model.Encounter();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, CrossVersionElements40_N.urls("Encounter", "4.0", new String[] {"statusHistory", "classHistory"}));
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "5.0", "subjectStatus", "careTeam", "virtualService", "plannedStartDate", "plannedEndDate");
    CrossVersionElements40_N.extensionsToR4Elements(src.getExtension(), tgt, "Encounter", "statusHistory", "classHistory");
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "6.0", "businessStatus");
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(CrossVersionElements40_N.toR4Code(src.getStatusElement(), convertEncounterStatus(src.getStatusElement()), src.fhirType(), "status"));
    CrossVersionElements40_N.restoreR4Code(tgt.getStatusElement(), CrossVersionElements40_N.url("Encounter", "4.0", "status"));
    // R4 class is a single Coding: the first class (all of it, if it's more than a coding), and the rest in the extension
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getClass_List()) {
      if (!tgt.hasClass_())
        tgt.setClass_(CodeableConcept40_N.convertCodeableConceptToCoding(t, CLASS_EXTENSION_URL));
      else
        tgt.addExtension(CLASS_EXTENSION_URL, CodeableConcept40_N.convertCodeableConcept(t));
    }
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getTypeList())
      tgt.addType(CodeableConcept40_N.convertCodeableConcept(t));
    for (CodeableReference t : src.getServiceTypeList()) {
      if (!tgt.hasServiceType())
        tgt.setServiceType(CodeableConcept40_N.convertCodeableReferenceToCodeableConcept(t));
      else
        tgt.addExtension(CrossVersionDatatype40_N.convertToExtension(CrossVersionElements40_N.url("Encounter", "5.0", "serviceType"), t));
    }
    if (src.hasPriority())
      tgt.setPriority(CodeableConcept40_N.convertCodeableConcept(src.getPriority()));
    if (src.hasSubject())
      tgt.setSubject(Reference40_N.convertReference(src.getSubject()));
    for (org.hl7.fhir.model.core.Reference t : src.getEpisodeOfCareList())
      tgt.addEpisodeOfCare(Reference40_N.convertReference(t));
    for (org.hl7.fhir.model.core.Reference t : src.getBasedOnList()) tgt.addBasedOn(Reference40_N.convertReference(t));
    for (org.hl7.fhir.model.core.Encounter.EncounterParticipantComponent t : src.getParticipantList())
      tgt.addParticipant(convertEncounterParticipantComponent(t));
    for (org.hl7.fhir.model.core.Reference t : src.getAppointmentList())
      tgt.addAppointment(Reference40_N.convertReference(t));
    if (src.hasActualPeriod())
      tgt.setPeriod(Period40_N.convertPeriod(src.getActualPeriod()));
    if (src.hasLength())
      tgt.setLength(Duration40_N.convertDuration(src.getLength()));
    convertReasons(src, tgt);
    for (org.hl7.fhir.model.core.Encounter.DiagnosisComponent t : src.getDiagnosisList())
      tgt.addDiagnosis(convertDiagnosisComponent(t));
    for (org.hl7.fhir.model.core.Reference t : src.getAccountList()) tgt.addAccount(Reference40_N.convertReference(t));
    if (src.hasAdmission() || src.hasDietPreference() || src.hasSpecialArrangement() || src.hasSpecialCourtesy())
      tgt.setHospitalization(convertEncounterHospitalizationComponent(src.getAdmission(), src));
    for (org.hl7.fhir.model.core.Encounter.EncounterLocationComponent t : src.getLocationList())
      tgt.addLocation(convertEncounterLocationComponent(t));
    if (src.hasServiceProvider())
      tgt.setServiceProvider(Reference40_N.convertReference(src.getServiceProvider()));
    if (src.hasPartOf())
      tgt.setPartOf(Reference40_N.convertReference(src.getPartOf()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Encounter.EncounterStatus> convertEncounterStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Encounter.EncounterStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
     Enumeration<org.hl7.fhir.model.core.Encounter.EncounterStatus> tgt = new Enumeration<>(new org.hl7.fhir.model.core.Encounter.EncounterStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PLANNED:
                  tgt.setValue(org.hl7.fhir.model.core.Encounter.EncounterStatus.PLANNED);
                  break;
              case ARRIVED:
                  tgt.setValue(org.hl7.fhir.model.core.Encounter.EncounterStatus.INPROGRESS);
                  break;
              case TRIAGED:
                  tgt.setValue(org.hl7.fhir.model.core.Encounter.EncounterStatus.INPROGRESS);
                  break;
              case INPROGRESS:
                  tgt.setValue(org.hl7.fhir.model.core.Encounter.EncounterStatus.INPROGRESS);
                  break;
              case ONLEAVE:
                  tgt.setValue(org.hl7.fhir.model.core.Encounter.EncounterStatus.INPROGRESS);
                  break;
              case FINISHED:
                  tgt.setValue(org.hl7.fhir.model.core.Encounter.EncounterStatus.COMPLETED);
                  break;
              case CANCELLED:
                  tgt.setValue(org.hl7.fhir.model.core.Encounter.EncounterStatus.CANCELLED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(org.hl7.fhir.model.core.Encounter.EncounterStatus.ENTEREDINERROR);
                  break;
              case UNKNOWN:
                  tgt.setValue(org.hl7.fhir.model.core.Encounter.EncounterStatus.UNKNOWN);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.model.core.Encounter.EncounterStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Encounter.EncounterStatus> convertEncounterStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Encounter.EncounterStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<Encounter.EncounterStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new Encounter.EncounterStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PLANNED:
                  tgt.setValue(Encounter.EncounterStatus.PLANNED);
                  break;
              case INPROGRESS:
                  tgt.setValue(Encounter.EncounterStatus.INPROGRESS);
                  break;
              case CANCELLED:
                  tgt.setValue(Encounter.EncounterStatus.CANCELLED);
                  break;
              case COMPLETED:
                  tgt.setValue(Encounter.EncounterStatus.FINISHED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(Encounter.EncounterStatus.ENTEREDINERROR);
                  break;
              case UNKNOWN:
                  tgt.setValue(Encounter.EncounterStatus.UNKNOWN);
                  break;
              default:
                  tgt.setValue(Encounter.EncounterStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

//  public static org.hl7.fhir.model.core.Encounter.StatusHistoryComponent convertStatusHistoryComponent(org.hl7.fhir.r4.model.Encounter.StatusHistoryComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.model.core.Encounter.StatusHistoryComponent tgt = new org.hl7.fhir.model.core.Encounter.StatusHistoryComponent();
//    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
//    if (src.hasStatus())
//      tgt.setStatusElement(CrossVersionElements40_N.toR6Code(src.getStatusElement(), convertEncounterStatus(src.getStatusElement()), src.fhirType(), "status"));
//    if (src.hasPeriod())
//      tgt.setPeriod(Period40_N.convertPeriod(src.getPeriod()));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r4.model.Encounter.StatusHistoryComponent convertStatusHistoryComponent(org.hl7.fhir.model.core.Encounter.StatusHistoryComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r4.model.Encounter.StatusHistoryComponent tgt = new org.hl7.fhir.r4.model.Encounter.StatusHistoryComponent();
//    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
//    if (src.hasStatus())
//      tgt.setStatusElement(CrossVersionElements40_N.toR4Code(src.getStatusElement(), convertEncounterStatus(src.getStatusElement()), src.fhirType(), "status"));
//    if (src.hasPeriod())
//      tgt.setPeriod(Period40_N.convertPeriod(src.getPeriod()));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.model.core.Encounter.ClassHistoryComponent convertClassHistoryComponent(org.hl7.fhir.r4.model.Encounter.ClassHistoryComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.model.core.Encounter.ClassHistoryComponent tgt = new org.hl7.fhir.model.core.Encounter.ClassHistoryComponent();
//    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
//    if (src.hasClass_())
//      tgt.setClass_(Coding40_N.convertCoding(src.getClass_()));
//    if (src.hasPeriod())
//      tgt.setPeriod(Period40_N.convertPeriod(src.getPeriod()));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r4.model.Encounter.ClassHistoryComponent convertClassHistoryComponent(org.hl7.fhir.model.core.Encounter.ClassHistoryComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r4.model.Encounter.ClassHistoryComponent tgt = new org.hl7.fhir.r4.model.Encounter.ClassHistoryComponent();
//    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
//    if (src.hasClass_())
//      tgt.setClass_(Coding40_N.convertCoding(src.getClass_()));
//    if (src.hasPeriod())
//      tgt.setPeriod(Period40_N.convertPeriod(src.getPeriod()));
//    return tgt;
//  }

  public static org.hl7.fhir.model.core.Encounter.EncounterParticipantComponent convertEncounterParticipantComponent(org.hl7.fhir.r4.model.Encounter.EncounterParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Encounter.EncounterParticipantComponent tgt = new org.hl7.fhir.model.core.Encounter.EncounterParticipantComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasPeriod())
      tgt.setPeriod(Period40_N.convertPeriod(src.getPeriod()));
    if (src.hasIndividual())
      tgt.setActor(Reference40_N.convertReference(src.getIndividual()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Encounter.EncounterParticipantComponent convertEncounterParticipantComponent(org.hl7.fhir.model.core.Encounter.EncounterParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Encounter.EncounterParticipantComponent tgt = new org.hl7.fhir.r4.model.Encounter.EncounterParticipantComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getTypeList())
      tgt.addType(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasPeriod())
      tgt.setPeriod(Period40_N.convertPeriod(src.getPeriod()));
    if (src.hasActor())
      tgt.setIndividual(Reference40_N.convertReference(src.getActor()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Encounter.DiagnosisComponent convertDiagnosisComponent(org.hl7.fhir.r4.model.Encounter.DiagnosisComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Encounter.DiagnosisComponent tgt = new org.hl7.fhir.model.core.Encounter.DiagnosisComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, CrossVersionElements40_N.urls("Encounter.diagnosis", "5.0", new String[] {"condition", "use"}));
    if (src.hasCondition())
      tgt.addCondition(Reference40_N.convertReferenceToCodeableReference(src.getCondition()));
    if (src.hasUse())
      tgt.addUse(CodeableConcept40_N.convertCodeableConcept(src.getUse()));
    // the conditions and uses R4 had no room for
    CrossVersionElements40_N.extensionsToElementsForPath(src.getExtension(), tgt, "Encounter.diagnosis", "5.0", "condition", "use");
    // R6 dropped rank
    CrossVersionElements40_N.r4ElementsToExtensions(src, "Encounter.diagnosis", tgt.getExtension(), "rank");
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Encounter.DiagnosisComponent convertDiagnosisComponent(org.hl7.fhir.model.core.Encounter.DiagnosisComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Encounter.DiagnosisComponent tgt = new org.hl7.fhir.r4.model.Encounter.DiagnosisComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, CrossVersionElements40_N.url("Encounter.diagnosis", "4.0", "rank"));
    CrossVersionElements40_N.extensionsToR4Elements(src.getExtension(), tgt, "Encounter.diagnosis", "rank");
    // R4 condition is a single reference: the first condition that's just a reference, and the rest in the extension
    for (CodeableReference t : src.getConditionList()) {
      if (!tgt.hasCondition() && t.hasReference() && !t.hasConcept() && !t.hasId() && !t.hasExtension())
        tgt.setCondition(Reference40_N.convertReference(t.getReference()));
      else
        tgt.addExtension(CrossVersionDatatype40_N.convertToExtension(CrossVersionElements40_N.url("Encounter.diagnosis", "5.0", "condition"), t));
    }
    // R4 has one use: the first, and the rest in the extension
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getUseList()) {
      if (!tgt.hasUse())
        tgt.setUse(CodeableConcept40_N.convertCodeableConcept(t));
      else
        tgt.addExtension(CrossVersionElements40_N.url("Encounter.diagnosis", "5.0", "use"), CodeableConcept40_N.convertCodeableConcept(t));
    }
    return tgt;
  }

  public static org.hl7.fhir.model.core.Encounter.EncounterAdmissionComponent convertEncounterHospitalizationComponent(org.hl7.fhir.r4.model.Encounter.EncounterHospitalizationComponent src, org.hl7.fhir.model.core.Encounter tgte) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Encounter.EncounterAdmissionComponent tgt = new org.hl7.fhir.model.core.Encounter.EncounterAdmissionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasPreAdmissionIdentifier())
      tgt.setPreAdmissionIdentifier(Identifier40_N.convertIdentifier(src.getPreAdmissionIdentifier()));
    if (src.hasOrigin())
      tgt.setOrigin(Reference40_N.convertReference(src.getOrigin()));
    if (src.hasAdmitSource())
      tgt.setAdmitSource(CodeableConcept40_N.convertCodeableConcept(src.getAdmitSource()));
    if (src.hasReAdmission())
      tgt.setReAdmission(CodeableConcept40_N.convertCodeableConcept(src.getReAdmission()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getDietPreference())
      tgte.addDietPreference(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSpecialCourtesy())
      tgte.addSpecialCourtesy(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSpecialArrangement())
      tgte.addSpecialArrangement(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasDestination())
      tgt.setDestination(Reference40_N.convertReference(src.getDestination()));
    if (src.hasDischargeDisposition())
      tgt.setDischargeDisposition(CodeableConcept40_N.convertCodeableConcept(src.getDischargeDisposition()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Encounter.EncounterHospitalizationComponent convertEncounterHospitalizationComponent(org.hl7.fhir.model.core.Encounter.EncounterAdmissionComponent src, org.hl7.fhir.model.core.Encounter srce) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Encounter.EncounterHospitalizationComponent tgt = new org.hl7.fhir.r4.model.Encounter.EncounterHospitalizationComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasPreAdmissionIdentifier())
      tgt.setPreAdmissionIdentifier(Identifier40_N.convertIdentifier(src.getPreAdmissionIdentifier()));
    if (src.hasOrigin())
      tgt.setOrigin(Reference40_N.convertReference(src.getOrigin()));
    if (src.hasAdmitSource())
      tgt.setAdmitSource(CodeableConcept40_N.convertCodeableConcept(src.getAdmitSource()));
    if (src.hasReAdmission())
      tgt.setReAdmission(CodeableConcept40_N.convertCodeableConcept(src.getReAdmission()));
    for (org.hl7.fhir.model.core.CodeableConcept t : srce.getDietPreferenceList())
      tgt.addDietPreference(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : srce.getSpecialCourtesyList())
      tgt.addSpecialCourtesy(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : srce.getSpecialArrangementList())
      tgt.addSpecialArrangement(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasDestination())
      tgt.setDestination(Reference40_N.convertReference(src.getDestination()));
    if (src.hasDischargeDisposition())
      tgt.setDischargeDisposition(CodeableConcept40_N.convertCodeableConcept(src.getDischargeDisposition()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Encounter.EncounterLocationComponent convertEncounterLocationComponent(org.hl7.fhir.r4.model.Encounter.EncounterLocationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Encounter.EncounterLocationComponent tgt = new org.hl7.fhir.model.core.Encounter.EncounterLocationComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasLocation())
      tgt.setLocation(Reference40_N.convertReference(src.getLocation()));
    if (src.hasStatus())
      tgt.setStatusElement(CrossVersionElements40_N.toR6Code(src.getStatusElement(), convertEncounterLocationStatus(src.getStatusElement()), src.fhirType(), "status"));
    if (src.hasPhysicalType())
      tgt.setForm(CodeableConcept40_N.convertCodeableConcept(src.getPhysicalType()));
    if (src.hasPeriod())
      tgt.setPeriod(Period40_N.convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Encounter.EncounterLocationComponent convertEncounterLocationComponent(org.hl7.fhir.model.core.Encounter.EncounterLocationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Encounter.EncounterLocationComponent tgt = new org.hl7.fhir.r4.model.Encounter.EncounterLocationComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasLocation())
      tgt.setLocation(Reference40_N.convertReference(src.getLocation()));
    if (src.hasStatus())
      tgt.setStatusElement(CrossVersionElements40_N.toR4Code(src.getStatusElement(), convertEncounterLocationStatus(src.getStatusElement()), src.fhirType(), "status"));
    if (src.hasForm())
      tgt.setPhysicalType(CodeableConcept40_N.convertCodeableConcept(src.getForm()));
    if (src.hasPeriod())
      tgt.setPeriod(Period40_N.convertPeriod(src.getPeriod()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Encounter.EncounterLocationStatus> convertEncounterLocationStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Encounter.EncounterLocationStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<org.hl7.fhir.model.core.Encounter.EncounterLocationStatus> tgt = new Enumeration<>(new org.hl7.fhir.model.core.Encounter.EncounterLocationStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PLANNED:
                  tgt.setValue(org.hl7.fhir.model.core.Encounter.EncounterLocationStatus.PLANNED);
                  break;
              case ACTIVE:
                  tgt.setValue(org.hl7.fhir.model.core.Encounter.EncounterLocationStatus.ACTIVE);
                  break;
              case RESERVED:
                  tgt.setValue(org.hl7.fhir.model.core.Encounter.EncounterLocationStatus.RESERVED);
                  break;
              case COMPLETED:
                  tgt.setValue(org.hl7.fhir.model.core.Encounter.EncounterLocationStatus.COMPLETED);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.model.core.Encounter.EncounterLocationStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Encounter.EncounterLocationStatus> convertEncounterLocationStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Encounter.EncounterLocationStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<Encounter.EncounterLocationStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new Encounter.EncounterLocationStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PLANNED:
                  tgt.setValue(Encounter.EncounterLocationStatus.PLANNED);
                  break;
              case ACTIVE:
                  tgt.setValue(Encounter.EncounterLocationStatus.ACTIVE);
                  break;
              case RESERVED:
                  tgt.setValue(Encounter.EncounterLocationStatus.RESERVED);
                  break;
              case COMPLETED:
                  tgt.setValue(Encounter.EncounterLocationStatus.COMPLETED);
                  break;
              default:
                  tgt.setValue(Encounter.EncounterLocationStatus.NULL);
                  break;
          }
      }
      return tgt;
  }
}