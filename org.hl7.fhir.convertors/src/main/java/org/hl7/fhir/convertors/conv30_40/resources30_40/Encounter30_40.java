package org.hl7.fhir.convertors.conv30_40.resources30_40;

import org.hl7.fhir.convertors.context.ConversionContext30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Reference30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.*;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.PositiveInt30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Encounter30_40 {

  public static org.hl7.fhir.r4.model.Encounter.ClassHistoryComponent convertClassHistoryComponent(org.hl7.fhir.dstu3.model.Encounter.ClassHistoryComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Encounter.ClassHistoryComponent tgt = new org.hl7.fhir.r4.model.Encounter.ClassHistoryComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasClass_())
      tgt.setClass_(Coding30_40.convertCoding(src.getClass_()));
    if (src.hasPeriod())
      tgt.setPeriod(Period30_40.convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Encounter.ClassHistoryComponent convertClassHistoryComponent(org.hl7.fhir.r4.model.Encounter.ClassHistoryComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Encounter.ClassHistoryComponent tgt = new org.hl7.fhir.dstu3.model.Encounter.ClassHistoryComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasClass_())
      tgt.setClass_(Coding30_40.convertCoding(src.getClass_()));
    if (src.hasPeriod())
      tgt.setPeriod(Period30_40.convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Encounter convertEncounter(org.hl7.fhir.r4.model.Encounter src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Encounter tgt = new org.hl7.fhir.dstu3.model.Encounter();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertEncounterStatus(src.getStatusElement()));
    for (org.hl7.fhir.r4.model.Encounter.StatusHistoryComponent t : src.getStatusHistory())
      tgt.addStatusHistory(convertStatusHistoryComponent(t));
    if (src.hasClass_())
      tgt.setClass_(Coding30_40.convertCoding(src.getClass_()));
    for (org.hl7.fhir.r4.model.Encounter.ClassHistoryComponent t : src.getClassHistory())
      tgt.addClassHistory(convertClassHistoryComponent(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept30_40.convertCodeableConcept(t));
    if (src.hasPriority())
      tgt.setPriority(CodeableConcept30_40.convertCodeableConcept(src.getPriority()));
    if (src.hasSubject())
      tgt.setSubject(Reference30_40.convertReference(src.getSubject()));
    for (org.hl7.fhir.r4.model.Reference t : src.getEpisodeOfCare())
      tgt.addEpisodeOfCare(Reference30_40.convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn())
      tgt.addIncomingReferral(Reference30_40.convertReference(t));
    for (org.hl7.fhir.r4.model.Encounter.EncounterParticipantComponent t : src.getParticipant())
      tgt.addParticipant(convertEncounterParticipantComponent(t));
    if (src.hasAppointment())
      tgt.setAppointment(Reference30_40.convertReference(src.getAppointmentFirstRep()));
    if (src.hasPeriod())
      tgt.setPeriod(Period30_40.convertPeriod(src.getPeriod()));
    if (src.hasLength())
      tgt.setLength(Duration30_40.convertDuration(src.getLength()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode())
      tgt.addReason(CodeableConcept30_40.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.Encounter.DiagnosisComponent t : src.getDiagnosis())
      tgt.addDiagnosis(convertDiagnosisComponent(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getAccount()) tgt.addAccount(Reference30_40.convertReference(t));
    if (src.hasHospitalization())
      tgt.setHospitalization(convertEncounterHospitalizationComponent(src.getHospitalization()));
    for (org.hl7.fhir.r4.model.Encounter.EncounterLocationComponent t : src.getLocation())
      tgt.addLocation(convertEncounterLocationComponent(t));
    if (src.hasServiceProvider())
      tgt.setServiceProvider(Reference30_40.convertReference(src.getServiceProvider()));
    if (src.hasPartOf())
      tgt.setPartOf(Reference30_40.convertReference(src.getPartOf()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Encounter convertEncounter(org.hl7.fhir.dstu3.model.Encounter src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Encounter tgt = new org.hl7.fhir.r4.model.Encounter();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertEncounterStatus(src.getStatusElement()));
    for (org.hl7.fhir.dstu3.model.Encounter.StatusHistoryComponent t : src.getStatusHistory())
      tgt.addStatusHistory(convertStatusHistoryComponent(t));
    if (src.hasClass_())
      tgt.setClass_(Coding30_40.convertCoding(src.getClass_()));
    for (org.hl7.fhir.dstu3.model.Encounter.ClassHistoryComponent t : src.getClassHistory())
      tgt.addClassHistory(convertClassHistoryComponent(t));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept30_40.convertCodeableConcept(t));
    if (src.hasPriority())
      tgt.setPriority(CodeableConcept30_40.convertCodeableConcept(src.getPriority()));
    if (src.hasSubject())
      tgt.setSubject(Reference30_40.convertReference(src.getSubject()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getEpisodeOfCare())
      tgt.addEpisodeOfCare(Reference30_40.convertReference(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getIncomingReferral())
      tgt.addBasedOn(Reference30_40.convertReference(t));
    for (org.hl7.fhir.dstu3.model.Encounter.EncounterParticipantComponent t : src.getParticipant())
      tgt.addParticipant(convertEncounterParticipantComponent(t));
    if (src.hasAppointment())
      tgt.addAppointment(Reference30_40.convertReference(src.getAppointment()));
    if (src.hasPeriod())
      tgt.setPeriod(Period30_40.convertPeriod(src.getPeriod()));
    if (src.hasLength())
      tgt.setLength(Duration30_40.convertDuration(src.getLength()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReason())
      tgt.addReasonCode(CodeableConcept30_40.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu3.model.Encounter.DiagnosisComponent t : src.getDiagnosis())
      tgt.addDiagnosis(convertDiagnosisComponent(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getAccount()) tgt.addAccount(Reference30_40.convertReference(t));
    if (src.hasHospitalization())
      tgt.setHospitalization(convertEncounterHospitalizationComponent(src.getHospitalization()));
    for (org.hl7.fhir.dstu3.model.Encounter.EncounterLocationComponent t : src.getLocation())
      tgt.addLocation(convertEncounterLocationComponent(t));
    if (src.hasServiceProvider())
      tgt.setServiceProvider(Reference30_40.convertReference(src.getServiceProvider()));
    if (src.hasPartOf())
      tgt.setPartOf(Reference30_40.convertReference(src.getPartOf()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Encounter.EncounterHospitalizationComponent convertEncounterHospitalizationComponent(org.hl7.fhir.dstu3.model.Encounter.EncounterHospitalizationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Encounter.EncounterHospitalizationComponent tgt = new org.hl7.fhir.r4.model.Encounter.EncounterHospitalizationComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasPreAdmissionIdentifier())
      tgt.setPreAdmissionIdentifier(Identifier30_40.convertIdentifier(src.getPreAdmissionIdentifier()));
    if (src.hasOrigin())
      tgt.setOrigin(Reference30_40.convertReference(src.getOrigin()));
    if (src.hasAdmitSource())
      tgt.setAdmitSource(CodeableConcept30_40.convertCodeableConcept(src.getAdmitSource()));
    if (src.hasReAdmission())
      tgt.setReAdmission(CodeableConcept30_40.convertCodeableConcept(src.getReAdmission()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getDietPreference())
      tgt.addDietPreference(CodeableConcept30_40.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getSpecialCourtesy())
      tgt.addSpecialCourtesy(CodeableConcept30_40.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getSpecialArrangement())
      tgt.addSpecialArrangement(CodeableConcept30_40.convertCodeableConcept(t));
    if (src.hasDestination())
      tgt.setDestination(Reference30_40.convertReference(src.getDestination()));
    if (src.hasDischargeDisposition())
      tgt.setDischargeDisposition(CodeableConcept30_40.convertCodeableConcept(src.getDischargeDisposition()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Encounter.EncounterHospitalizationComponent convertEncounterHospitalizationComponent(org.hl7.fhir.r4.model.Encounter.EncounterHospitalizationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Encounter.EncounterHospitalizationComponent tgt = new org.hl7.fhir.dstu3.model.Encounter.EncounterHospitalizationComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasPreAdmissionIdentifier())
      tgt.setPreAdmissionIdentifier(Identifier30_40.convertIdentifier(src.getPreAdmissionIdentifier()));
    if (src.hasOrigin())
      tgt.setOrigin(Reference30_40.convertReference(src.getOrigin()));
    if (src.hasAdmitSource())
      tgt.setAdmitSource(CodeableConcept30_40.convertCodeableConcept(src.getAdmitSource()));
    if (src.hasReAdmission())
      tgt.setReAdmission(CodeableConcept30_40.convertCodeableConcept(src.getReAdmission()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getDietPreference())
      tgt.addDietPreference(CodeableConcept30_40.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSpecialCourtesy())
      tgt.addSpecialCourtesy(CodeableConcept30_40.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSpecialArrangement())
      tgt.addSpecialArrangement(CodeableConcept30_40.convertCodeableConcept(t));
    if (src.hasDestination())
      tgt.setDestination(Reference30_40.convertReference(src.getDestination()));
    if (src.hasDischargeDisposition())
      tgt.setDischargeDisposition(CodeableConcept30_40.convertCodeableConcept(src.getDischargeDisposition()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Encounter.EncounterLocationComponent convertEncounterLocationComponent(org.hl7.fhir.dstu3.model.Encounter.EncounterLocationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Encounter.EncounterLocationComponent tgt = new org.hl7.fhir.r4.model.Encounter.EncounterLocationComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasLocation())
      tgt.setLocation(Reference30_40.convertReference(src.getLocation()));
    if (src.hasStatus())
      tgt.setStatusElement(convertEncounterLocationStatus(src.getStatusElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period30_40.convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Encounter.EncounterLocationComponent convertEncounterLocationComponent(org.hl7.fhir.r4.model.Encounter.EncounterLocationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Encounter.EncounterLocationComponent tgt = new org.hl7.fhir.dstu3.model.Encounter.EncounterLocationComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasLocation())
      tgt.setLocation(Reference30_40.convertReference(src.getLocation()));
    if (src.hasStatus())
      tgt.setStatusElement(convertEncounterLocationStatus(src.getStatusElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period30_40.convertPeriod(src.getPeriod()));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Encounter.EncounterLocationStatus> convertEncounterLocationStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Encounter.EncounterLocationStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Encounter.EncounterLocationStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Encounter.EncounterLocationStatusEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Encounter.EncounterLocationStatus> convertEncounterLocationStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Encounter.EncounterLocationStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Encounter.EncounterLocationStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Encounter.EncounterLocationStatusEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case PLANNED:
        tgt.setValue(org.hl7.fhir.r4.model.Encounter.EncounterLocationStatus.PLANNED);
        break;
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r4.model.Encounter.EncounterLocationStatus.ACTIVE);
        break;
      case RESERVED:
        tgt.setValue(org.hl7.fhir.r4.model.Encounter.EncounterLocationStatus.RESERVED);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.r4.model.Encounter.EncounterLocationStatus.COMPLETED);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.Encounter.EncounterLocationStatus.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Encounter.EncounterParticipantComponent convertEncounterParticipantComponent(org.hl7.fhir.r4.model.Encounter.EncounterParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Encounter.EncounterParticipantComponent tgt = new org.hl7.fhir.dstu3.model.Encounter.EncounterParticipantComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept30_40.convertCodeableConcept(t));
    if (src.hasPeriod())
      tgt.setPeriod(Period30_40.convertPeriod(src.getPeriod()));
    if (src.hasIndividual())
      tgt.setIndividual(Reference30_40.convertReference(src.getIndividual()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Encounter.EncounterParticipantComponent convertEncounterParticipantComponent(org.hl7.fhir.dstu3.model.Encounter.EncounterParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Encounter.EncounterParticipantComponent tgt = new org.hl7.fhir.r4.model.Encounter.EncounterParticipantComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept30_40.convertCodeableConcept(t));
    if (src.hasPeriod())
      tgt.setPeriod(Period30_40.convertPeriod(src.getPeriod()));
    if (src.hasIndividual())
      tgt.setIndividual(Reference30_40.convertReference(src.getIndividual()));
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Encounter.EncounterStatus> convertEncounterStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Encounter.EncounterStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Encounter.EncounterStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Encounter.EncounterStatusEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case PLANNED:
        tgt.setValue(org.hl7.fhir.r4.model.Encounter.EncounterStatus.PLANNED);
        break;
      case ARRIVED:
        tgt.setValue(org.hl7.fhir.r4.model.Encounter.EncounterStatus.ARRIVED);
        break;
      case TRIAGED:
        tgt.setValue(org.hl7.fhir.r4.model.Encounter.EncounterStatus.TRIAGED);
        break;
      case INPROGRESS:
        tgt.setValue(org.hl7.fhir.r4.model.Encounter.EncounterStatus.INPROGRESS);
        break;
      case ONLEAVE:
        tgt.setValue(org.hl7.fhir.r4.model.Encounter.EncounterStatus.ONLEAVE);
        break;
      case FINISHED:
        tgt.setValue(org.hl7.fhir.r4.model.Encounter.EncounterStatus.FINISHED);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.r4.model.Encounter.EncounterStatus.CANCELLED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4.model.Encounter.EncounterStatus.ENTEREDINERROR);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.r4.model.Encounter.EncounterStatus.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.Encounter.EncounterStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Encounter.EncounterStatus> convertEncounterStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Encounter.EncounterStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Encounter.EncounterStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Encounter.EncounterStatusEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case PLANNED:
        tgt.setValue(org.hl7.fhir.dstu3.model.Encounter.EncounterStatus.PLANNED);
        break;
      case ARRIVED:
        tgt.setValue(org.hl7.fhir.dstu3.model.Encounter.EncounterStatus.ARRIVED);
        break;
      case TRIAGED:
        tgt.setValue(org.hl7.fhir.dstu3.model.Encounter.EncounterStatus.TRIAGED);
        break;
      case INPROGRESS:
        tgt.setValue(org.hl7.fhir.dstu3.model.Encounter.EncounterStatus.INPROGRESS);
        break;
      case ONLEAVE:
        tgt.setValue(org.hl7.fhir.dstu3.model.Encounter.EncounterStatus.ONLEAVE);
        break;
      case FINISHED:
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

  public static org.hl7.fhir.r4.model.Encounter.StatusHistoryComponent convertStatusHistoryComponent(org.hl7.fhir.dstu3.model.Encounter.StatusHistoryComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Encounter.StatusHistoryComponent tgt = new org.hl7.fhir.r4.model.Encounter.StatusHistoryComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasStatus())
      tgt.setStatusElement(convertEncounterStatus(src.getStatusElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period30_40.convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Encounter.StatusHistoryComponent convertStatusHistoryComponent(org.hl7.fhir.r4.model.Encounter.StatusHistoryComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Encounter.StatusHistoryComponent tgt = new org.hl7.fhir.dstu3.model.Encounter.StatusHistoryComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasStatus())
      tgt.setStatusElement(convertEncounterStatus(src.getStatusElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period30_40.convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Encounter.DiagnosisComponent convertDiagnosisComponent(org.hl7.fhir.dstu3.model.Encounter.DiagnosisComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Encounter.DiagnosisComponent tgt = new org.hl7.fhir.r4.model.Encounter.DiagnosisComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasCondition()) tgt.setCondition(Reference30_40.convertReference(src.getCondition()));
    if (src.hasRole()) tgt.setUse(CodeableConcept30_40.convertCodeableConcept(src.getRole()));
    if (src.hasRank()) tgt.setRankElement(PositiveInt30_40.convertPositiveInt(src.getRankElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Encounter.DiagnosisComponent convertDiagnosisComponent(org.hl7.fhir.r4.model.Encounter.DiagnosisComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.dstu3.model.Encounter.DiagnosisComponent tgt = new org.hl7.fhir.dstu3.model.Encounter.DiagnosisComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasCondition()) tgt.setCondition(Reference30_40.convertReference(src.getCondition()));
    if (src.hasUse()) tgt.setRole(CodeableConcept30_40.convertCodeableConcept(src.getUse()));
    if (src.hasRank()) tgt.setRankElement(PositiveInt30_40.convertPositiveInt(src.getRankElement()));
    return tgt;
  }
}