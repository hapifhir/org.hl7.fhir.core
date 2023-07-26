package org.hl7.fhir.convertors.conv30_50.resources30_50;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Reference30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.CodeableConcept30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Coding30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Duration30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Identifier30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Period30_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableReference;
import org.hl7.fhir.r5.model.Encounter.ReasonComponent;

public class Encounter30_50 {

//  public static org.hl7.fhir.dstu3.model.Encounter.ClassHistoryComponent convertClassHistoryComponent(org.hl7.fhir.r5.model.Encounter.ClassHistoryComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.dstu3.model.Encounter.ClassHistoryComponent tgt = new org.hl7.fhir.dstu3.model.Encounter.ClassHistoryComponent();
//    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
//    if (src.hasClass_())
//      tgt.setClass_(Coding30_50.convertCoding(src.getClass_()));
//    if (src.hasPeriod())
//      tgt.setPeriod(Period30_50.convertPeriod(src.getPeriod()));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r5.model.Encounter.ClassHistoryComponent convertClassHistoryComponent(org.hl7.fhir.dstu3.model.Encounter.ClassHistoryComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r5.model.Encounter.ClassHistoryComponent tgt = new org.hl7.fhir.r5.model.Encounter.ClassHistoryComponent();
//    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
//    if (src.hasClass_())
//      tgt.setClass_(Coding30_50.convertCoding(src.getClass_()));
//    if (src.hasPeriod())
//      tgt.setPeriod(Period30_50.convertPeriod(src.getPeriod()));
//    return tgt;
//  }

  public static org.hl7.fhir.r5.model.Encounter convertEncounter(org.hl7.fhir.dstu3.model.Encounter src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Encounter tgt = new org.hl7.fhir.r5.model.Encounter();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertEncounterStatus(src.getStatusElement()));
//    for (org.hl7.fhir.dstu3.model.Encounter.StatusHistoryComponent t : src.getStatusHistory())
//      tgt.addStatusHistory(convertStatusHistoryComponent(t));
    if (src.hasClass_())
      tgt.addClass_(new org.hl7.fhir.r5.model.CodeableConcept().addCoding(Coding30_50.convertCoding(src.getClass_())));
//    for (org.hl7.fhir.dstu3.model.Encounter.ClassHistoryComponent t : src.getClassHistory())
//      tgt.addClassHistory(convertClassHistoryComponent(t));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept30_50.convertCodeableConcept(t));
    if (src.hasPriority())
      tgt.setPriority(CodeableConcept30_50.convertCodeableConcept(src.getPriority()));
    if (src.hasSubject())
      tgt.setSubject(Reference30_50.convertReference(src.getSubject()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getEpisodeOfCare())
      tgt.addEpisodeOfCare(Reference30_50.convertReference(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getIncomingReferral())
      tgt.addBasedOn(Reference30_50.convertReference(t));
    for (org.hl7.fhir.dstu3.model.Encounter.EncounterParticipantComponent t : src.getParticipant())
      tgt.addParticipant(convertEncounterParticipantComponent(t));
    if (src.hasAppointment())
      tgt.addAppointment(Reference30_50.convertReference(src.getAppointment()));
    if (src.hasPeriod())
      tgt.setActualPeriod(Period30_50.convertPeriod(src.getPeriod()));
    if (src.hasLength())
      tgt.setLength(Duration30_50.convertDuration(src.getLength()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReason())
      tgt.addReason().addValue(Reference30_50.convertCodeableConceptToCodableReference(t));
    for (org.hl7.fhir.dstu3.model.Encounter.DiagnosisComponent t : src.getDiagnosis())
      tgt.addDiagnosis(convertDiagnosisComponent(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getAccount()) tgt.addAccount(Reference30_50.convertReference(t));
    if (src.hasHospitalization())
      tgt.setAdmission(convertEncounterHospitalizationComponent(src.getHospitalization(), tgt));
    for (org.hl7.fhir.dstu3.model.Encounter.EncounterLocationComponent t : src.getLocation())
      tgt.addLocation(convertEncounterLocationComponent(t));
    if (src.hasServiceProvider())
      tgt.setServiceProvider(Reference30_50.convertReference(src.getServiceProvider()));
    if (src.hasPartOf())
      tgt.setPartOf(Reference30_50.convertReference(src.getPartOf()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Encounter convertEncounter(org.hl7.fhir.r5.model.Encounter src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Encounter tgt = new org.hl7.fhir.dstu3.model.Encounter();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertEncounterStatus(src.getStatusElement()));
//    for (org.hl7.fhir.r5.model.Encounter.StatusHistoryComponent t : src.getStatusHistory())
//      tgt.addStatusHistory(convertStatusHistoryComponent(t));
    if (src.hasClass_())
      tgt.setClass_(Coding30_50.convertCoding(src.getClass_FirstRep()));
//    for (org.hl7.fhir.r5.model.Encounter.ClassHistoryComponent t : src.getClassHistory())
//      tgt.addClassHistory(convertClassHistoryComponent(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept30_50.convertCodeableConcept(t));
    if (src.hasPriority())
      tgt.setPriority(CodeableConcept30_50.convertCodeableConcept(src.getPriority()));
    if (src.hasSubject())
      tgt.setSubject(Reference30_50.convertReference(src.getSubject()));
    for (org.hl7.fhir.r5.model.Reference t : src.getEpisodeOfCare())
      tgt.addEpisodeOfCare(Reference30_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn())
      tgt.addIncomingReferral(Reference30_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Encounter.EncounterParticipantComponent t : src.getParticipant())
      tgt.addParticipant(convertEncounterParticipantComponent(t));
    if (src.hasAppointment())
      tgt.setAppointment(Reference30_50.convertReference(src.getAppointmentFirstRep()));
    if (src.hasActualPeriod())
      tgt.setPeriod(Period30_50.convertPeriod(src.getActualPeriod()));
    if (src.hasLength())
      tgt.setLength(Duration30_50.convertDuration(src.getLength()));
    for (ReasonComponent t1 : src.getReason())
      for (CodeableReference t : t1.getValue())
        if (t.hasConcept())
          tgt.addReason(CodeableConcept30_50.convertCodeableConcept(t.getConcept()));
    for (org.hl7.fhir.r5.model.Encounter.DiagnosisComponent t : src.getDiagnosis())
      tgt.addDiagnosis(convertDiagnosisComponent(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getAccount()) tgt.addAccount(Reference30_50.convertReference(t));
    if (src.hasAdmission() || src.hasDietPreference() || src.hasSpecialArrangement() || src.hasSpecialCourtesy())
      tgt.setHospitalization(convertEncounterHospitalizationComponent(src.getAdmission(), src));
    for (org.hl7.fhir.r5.model.Encounter.EncounterLocationComponent t : src.getLocation())
      tgt.addLocation(convertEncounterLocationComponent(t));
    if (src.hasServiceProvider())
      tgt.setServiceProvider(Reference30_50.convertReference(src.getServiceProvider()));
    if (src.hasPartOf())
      tgt.setPartOf(Reference30_50.convertReference(src.getPartOf()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Encounter.EncounterHospitalizationComponent convertEncounterHospitalizationComponent(org.hl7.fhir.r5.model.Encounter.EncounterAdmissionComponent src, org.hl7.fhir.r5.model.Encounter srce) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Encounter.EncounterHospitalizationComponent tgt = new org.hl7.fhir.dstu3.model.Encounter.EncounterHospitalizationComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasPreAdmissionIdentifier())
      tgt.setPreAdmissionIdentifier(Identifier30_50.convertIdentifier(src.getPreAdmissionIdentifier()));
    if (src.hasOrigin())
      tgt.setOrigin(Reference30_50.convertReference(src.getOrigin()));
    if (src.hasAdmitSource())
      tgt.setAdmitSource(CodeableConcept30_50.convertCodeableConcept(src.getAdmitSource()));
    if (src.hasReAdmission())
      tgt.setReAdmission(CodeableConcept30_50.convertCodeableConcept(src.getReAdmission()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : srce.getDietPreference())
      tgt.addDietPreference(CodeableConcept30_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : srce.getSpecialCourtesy())
      tgt.addSpecialCourtesy(CodeableConcept30_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : srce.getSpecialArrangement())
      tgt.addSpecialArrangement(CodeableConcept30_50.convertCodeableConcept(t));
    if (src.hasDestination())
      tgt.setDestination(Reference30_50.convertReference(src.getDestination()));
    if (src.hasDischargeDisposition())
      tgt.setDischargeDisposition(CodeableConcept30_50.convertCodeableConcept(src.getDischargeDisposition()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Encounter.EncounterAdmissionComponent convertEncounterHospitalizationComponent(org.hl7.fhir.dstu3.model.Encounter.EncounterHospitalizationComponent src, org.hl7.fhir.r5.model.Encounter tgte) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Encounter.EncounterAdmissionComponent tgt = new org.hl7.fhir.r5.model.Encounter.EncounterAdmissionComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasPreAdmissionIdentifier())
      tgt.setPreAdmissionIdentifier(Identifier30_50.convertIdentifier(src.getPreAdmissionIdentifier()));
    if (src.hasOrigin())
      tgt.setOrigin(Reference30_50.convertReference(src.getOrigin()));
    if (src.hasAdmitSource())
      tgt.setAdmitSource(CodeableConcept30_50.convertCodeableConcept(src.getAdmitSource()));
    if (src.hasReAdmission())
      tgt.setReAdmission(CodeableConcept30_50.convertCodeableConcept(src.getReAdmission()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getDietPreference())
      tgte.addDietPreference(CodeableConcept30_50.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getSpecialCourtesy())
      tgte.addSpecialCourtesy(CodeableConcept30_50.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getSpecialArrangement())
      tgte.addSpecialArrangement(CodeableConcept30_50.convertCodeableConcept(t));
    if (src.hasDestination())
      tgt.setDestination(Reference30_50.convertReference(src.getDestination()));
    if (src.hasDischargeDisposition())
      tgt.setDischargeDisposition(CodeableConcept30_50.convertCodeableConcept(src.getDischargeDisposition()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Encounter.EncounterLocationComponent convertEncounterLocationComponent(org.hl7.fhir.r5.model.Encounter.EncounterLocationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Encounter.EncounterLocationComponent tgt = new org.hl7.fhir.dstu3.model.Encounter.EncounterLocationComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasLocation())
      tgt.setLocation(Reference30_50.convertReference(src.getLocation()));
    if (src.hasStatus())
      tgt.setStatusElement(convertEncounterLocationStatus(src.getStatusElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period30_50.convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Encounter.EncounterLocationComponent convertEncounterLocationComponent(org.hl7.fhir.dstu3.model.Encounter.EncounterLocationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Encounter.EncounterLocationComponent tgt = new org.hl7.fhir.r5.model.Encounter.EncounterLocationComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasLocation())
      tgt.setLocation(Reference30_50.convertReference(src.getLocation()));
    if (src.hasStatus())
      tgt.setStatusElement(convertEncounterLocationStatus(src.getStatusElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period30_50.convertPeriod(src.getPeriod()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Encounter.EncounterLocationStatus> convertEncounterLocationStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Encounter.EncounterLocationStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Encounter.EncounterLocationStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Encounter.EncounterLocationStatusEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PLANNED:
        tgt.setValue(org.hl7.fhir.r5.model.Encounter.EncounterLocationStatus.PLANNED);
        break;
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r5.model.Encounter.EncounterLocationStatus.ACTIVE);
        break;
      case RESERVED:
        tgt.setValue(org.hl7.fhir.r5.model.Encounter.EncounterLocationStatus.RESERVED);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.r5.model.Encounter.EncounterLocationStatus.COMPLETED);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Encounter.EncounterLocationStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Encounter.EncounterLocationStatus> convertEncounterLocationStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Encounter.EncounterLocationStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Encounter.EncounterLocationStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Encounter.EncounterLocationStatusEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PLANNED:
        tgt.setValue(org.hl7.fhir.dstu3.model.Encounter.EncounterLocationStatus.PLANNED);
        break;
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.dstu3.model.Encounter.EncounterLocationStatus.ACTIVE);
        break;
      case RESERVED:
        tgt.setValue(org.hl7.fhir.dstu3.model.Encounter.EncounterLocationStatus.RESERVED);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.dstu3.model.Encounter.EncounterLocationStatus.COMPLETED);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.Encounter.EncounterLocationStatus.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Encounter.EncounterParticipantComponent convertEncounterParticipantComponent(org.hl7.fhir.r5.model.Encounter.EncounterParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Encounter.EncounterParticipantComponent tgt = new org.hl7.fhir.dstu3.model.Encounter.EncounterParticipantComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept30_50.convertCodeableConcept(t));
    if (src.hasPeriod())
      tgt.setPeriod(Period30_50.convertPeriod(src.getPeriod()));
    if (src.hasActor())
      tgt.setIndividual(Reference30_50.convertReference(src.getActor()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Encounter.EncounterParticipantComponent convertEncounterParticipantComponent(org.hl7.fhir.dstu3.model.Encounter.EncounterParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Encounter.EncounterParticipantComponent tgt = new org.hl7.fhir.r5.model.Encounter.EncounterParticipantComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept30_50.convertCodeableConcept(t));
    if (src.hasPeriod())
      tgt.setPeriod(Period30_50.convertPeriod(src.getPeriod()));
    if (src.hasIndividual())
      tgt.setActor(Reference30_50.convertReference(src.getIndividual()));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Encounter.EncounterStatus> convertEncounterStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.EncounterStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Encounter.EncounterStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Encounter.EncounterStatusEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PLANNED:
        tgt.setValue(org.hl7.fhir.dstu3.model.Encounter.EncounterStatus.PLANNED);
        break;
      case INPROGRESS:
        tgt.setValue(org.hl7.fhir.dstu3.model.Encounter.EncounterStatus.INPROGRESS);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.dstu3.model.Encounter.EncounterStatus.FINISHED);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.dstu3.model.Encounter.EncounterStatus.CANCELLED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.dstu3.model.Encounter.EncounterStatus.ENTEREDINERROR);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.dstu3.model.Encounter.EncounterStatus.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.Encounter.EncounterStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.EncounterStatus> convertEncounterStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Encounter.EncounterStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.EncounterStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.EncounterStatusEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PLANNED:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.EncounterStatus.PLANNED);
        break;
      case ARRIVED:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.EncounterStatus.INPROGRESS);
        break;
      case TRIAGED:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.EncounterStatus.INPROGRESS);
        break;
      case INPROGRESS:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.EncounterStatus.INPROGRESS);
        break;
      case ONLEAVE:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.EncounterStatus.INPROGRESS);
        break;
      case FINISHED:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.EncounterStatus.COMPLETED);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.EncounterStatus.CANCELLED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.EncounterStatus.ENTEREDINERROR);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.EncounterStatus.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.EncounterStatus.NULL);
        break;
    }
    return tgt;
  }

//  public static org.hl7.fhir.r5.model.Encounter.StatusHistoryComponent convertStatusHistoryComponent(org.hl7.fhir.dstu3.model.Encounter.StatusHistoryComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r5.model.Encounter.StatusHistoryComponent tgt = new org.hl7.fhir.r5.model.Encounter.StatusHistoryComponent();
//    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
//    if (src.hasStatus())
//      tgt.setStatusElement(convertEncounterStatus(src.getStatusElement()));
//    if (src.hasPeriod())
//      tgt.setPeriod(Period30_50.convertPeriod(src.getPeriod()));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.dstu3.model.Encounter.StatusHistoryComponent convertStatusHistoryComponent(org.hl7.fhir.r5.model.Encounter.StatusHistoryComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.dstu3.model.Encounter.StatusHistoryComponent tgt = new org.hl7.fhir.dstu3.model.Encounter.StatusHistoryComponent();
//    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
//    if (src.hasStatus())
//      tgt.setStatusElement(convertEncounterStatus(src.getStatusElement()));
//    if (src.hasPeriod())
//      tgt.setPeriod(Period30_50.convertPeriod(src.getPeriod()));
//    return tgt;
//  }

  public static org.hl7.fhir.r5.model.Encounter.DiagnosisComponent convertDiagnosisComponent(org.hl7.fhir.dstu3.model.Encounter.DiagnosisComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Encounter.DiagnosisComponent tgt = new org.hl7.fhir.r5.model.Encounter.DiagnosisComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasCondition()) tgt.addCondition(Reference30_50.convertReferenceToCodableReference(src.getCondition()));
    if (src.hasRole()) tgt.addUse(CodeableConcept30_50.convertCodeableConcept(src.getRole()));
//    if (src.hasRank()) tgt.setRankElement(PositiveInt30_50.convertPositiveInt(src.getRankElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Encounter.DiagnosisComponent convertDiagnosisComponent(org.hl7.fhir.r5.model.Encounter.DiagnosisComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.dstu3.model.Encounter.DiagnosisComponent tgt = new org.hl7.fhir.dstu3.model.Encounter.DiagnosisComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasCondition() && src.getConditionFirstRep().hasReference()) tgt.setCondition(Reference30_50.convertReference(src.getConditionFirstRep().getReference()));
    if (src.hasUse()) tgt.setRole(CodeableConcept30_50.convertCodeableConcept(src.getUseFirstRep()));
//    if (src.hasRank()) tgt.setRankElement(PositiveInt30_50.convertPositiveInt(src.getRankElement()));
    return tgt;
  }
}