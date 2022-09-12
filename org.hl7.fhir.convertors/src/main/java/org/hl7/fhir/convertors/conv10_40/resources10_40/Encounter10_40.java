package org.hl7.fhir.convertors.conv10_40.resources10_40;

import org.hl7.fhir.convertors.context.ConversionContext10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Reference10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.CodeableConcept10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Duration10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Identifier10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Period10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Encounter10_40 {

  public static org.hl7.fhir.dstu2.model.Encounter convertEncounter(org.hl7.fhir.r4.model.Encounter src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Encounter tgt = new org.hl7.fhir.dstu2.model.Encounter();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_40.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertEncounterState(src.getStatusElement()));
    if (src.hasClass_())
      tgt.setClass_(convertEncounterClass(src.getClass_()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept10_40.convertCodeableConcept(t));
    if (src.hasPriority())
      tgt.setPriority(CodeableConcept10_40.convertCodeableConcept(src.getPriority()));
    if (src.hasSubject())
      tgt.setPatient(Reference10_40.convertReference(src.getSubject()));
    for (org.hl7.fhir.r4.model.Reference t : src.getEpisodeOfCare())
      tgt.addEpisodeOfCare(Reference10_40.convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn())
      tgt.addIncomingReferral(Reference10_40.convertReference(t));
    for (org.hl7.fhir.r4.model.Encounter.EncounterParticipantComponent t : src.getParticipant())
      tgt.addParticipant(convertEncounterParticipantComponent(t));
    if (src.hasAppointment())
      tgt.setAppointment(Reference10_40.convertReference(src.getAppointmentFirstRep()));
    if (src.hasPeriod())
      tgt.setPeriod(Period10_40.convertPeriod(src.getPeriod()));
    if (src.hasLength())
      tgt.setLength(Duration10_40.convertDuration(src.getLength()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode())
      tgt.addReason(CodeableConcept10_40.convertCodeableConcept(t));
    if (src.hasHospitalization())
      tgt.setHospitalization(convertEncounterHospitalizationComponent(src.getHospitalization()));
    for (org.hl7.fhir.r4.model.Encounter.EncounterLocationComponent t : src.getLocation())
      tgt.addLocation(convertEncounterLocationComponent(t));
    if (src.hasServiceProvider())
      tgt.setServiceProvider(Reference10_40.convertReference(src.getServiceProvider()));
    if (src.hasPartOf())
      tgt.setPartOf(Reference10_40.convertReference(src.getPartOf()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Encounter convertEncounter(org.hl7.fhir.dstu2.model.Encounter src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Encounter tgt = new org.hl7.fhir.r4.model.Encounter();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_40.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertEncounterState(src.getStatusElement()));
    if (src.hasClass_())
      tgt.setClass_(convertEncounterClass(src.getClass_()));
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept10_40.convertCodeableConcept(t));
    if (src.hasPriority())
      tgt.setPriority(CodeableConcept10_40.convertCodeableConcept(src.getPriority()));
    if (src.hasPatient())
      tgt.setSubject(Reference10_40.convertReference(src.getPatient()));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getEpisodeOfCare())
      tgt.addEpisodeOfCare(Reference10_40.convertReference(t));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getIncomingReferral())
      tgt.addBasedOn(Reference10_40.convertReference(t));
    for (org.hl7.fhir.dstu2.model.Encounter.EncounterParticipantComponent t : src.getParticipant())
      tgt.addParticipant(convertEncounterParticipantComponent(t));
    if (src.hasAppointment())
      tgt.addAppointment(Reference10_40.convertReference(src.getAppointment()));
    if (src.hasPeriod())
      tgt.setPeriod(Period10_40.convertPeriod(src.getPeriod()));
    if (src.hasLength())
      tgt.setLength(Duration10_40.convertDuration(src.getLength()));
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getReason())
      tgt.addReasonCode(CodeableConcept10_40.convertCodeableConcept(t));
    if (src.hasHospitalization())
      tgt.setHospitalization(convertEncounterHospitalizationComponent(src.getHospitalization()));
    for (org.hl7.fhir.dstu2.model.Encounter.EncounterLocationComponent t : src.getLocation())
      tgt.addLocation(convertEncounterLocationComponent(t));
    if (src.hasServiceProvider())
      tgt.setServiceProvider(Reference10_40.convertReference(src.getServiceProvider()));
    if (src.hasPartOf())
      tgt.setPartOf(Reference10_40.convertReference(src.getPartOf()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Coding convertEncounterClass(org.hl7.fhir.dstu2.model.Encounter.EncounterClass src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
      case INPATIENT:
        return new org.hl7.fhir.r4.model.Coding().setSystem("http://terminology.hl7.org/v3/ActCode").setCode("IMP");
      case OUTPATIENT:
        return new org.hl7.fhir.r4.model.Coding().setSystem("http://terminology.hl7.org/v3/ActCode").setCode("AMB");
      case AMBULATORY:
        return new org.hl7.fhir.r4.model.Coding().setSystem("http://terminology.hl7.org/v3/ActCode").setCode("AMB");
      case EMERGENCY:
        return new org.hl7.fhir.r4.model.Coding().setSystem("http://terminology.hl7.org/v3/ActCode").setCode("EMER");
      case HOME:
        return new org.hl7.fhir.r4.model.Coding().setSystem("http://terminology.hl7.org/v3/ActCode").setCode("HH");
      case FIELD:
        return new org.hl7.fhir.r4.model.Coding().setSystem("http://terminology.hl7.org/v3/ActCode").setCode("FLD");
      case DAYTIME:
        return new org.hl7.fhir.r4.model.Coding().setSystem("http://terminology.hl7.org/v3/ActCode").setCode("SS");
      case VIRTUAL:
        return new org.hl7.fhir.r4.model.Coding().setSystem("http://terminology.hl7.org/v3/ActCode").setCode("VR");
      default:
        return null;
    }
  }

  public static org.hl7.fhir.dstu2.model.Encounter.EncounterClass convertEncounterClass(org.hl7.fhir.r4.model.Coding src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    if (src.getSystem().equals("http://terminology.hl7.org/v3/ActCode")) {
      if (src.getCode().equals("IMP"))
        return org.hl7.fhir.dstu2.model.Encounter.EncounterClass.INPATIENT;
      if (src.getCode().equals("AMB"))
        return org.hl7.fhir.dstu2.model.Encounter.EncounterClass.AMBULATORY;
      if (src.getCode().equals("EMER"))
        return org.hl7.fhir.dstu2.model.Encounter.EncounterClass.EMERGENCY;
      if (src.getCode().equals("HH"))
        return org.hl7.fhir.dstu2.model.Encounter.EncounterClass.HOME;
      if (src.getCode().equals("FLD"))
        return org.hl7.fhir.dstu2.model.Encounter.EncounterClass.FIELD;
      if (src.getCode().equals(""))
        return org.hl7.fhir.dstu2.model.Encounter.EncounterClass.DAYTIME;
      if (src.getCode().equals("VR"))
        return org.hl7.fhir.dstu2.model.Encounter.EncounterClass.VIRTUAL;
    }
    return org.hl7.fhir.dstu2.model.Encounter.EncounterClass.NULL;
  }

  public static org.hl7.fhir.r4.model.Encounter.EncounterHospitalizationComponent convertEncounterHospitalizationComponent(org.hl7.fhir.dstu2.model.Encounter.EncounterHospitalizationComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Encounter.EncounterHospitalizationComponent tgt = new org.hl7.fhir.r4.model.Encounter.EncounterHospitalizationComponent();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyBackboneElement(src,tgt);
    if (src.hasPreAdmissionIdentifier())
      tgt.setPreAdmissionIdentifier(Identifier10_40.convertIdentifier(src.getPreAdmissionIdentifier()));
    if (src.hasOrigin())
      tgt.setOrigin(Reference10_40.convertReference(src.getOrigin()));
    if (src.hasAdmitSource())
      tgt.setAdmitSource(CodeableConcept10_40.convertCodeableConcept(src.getAdmitSource()));
    if (src.hasReAdmission())
      tgt.setReAdmission(CodeableConcept10_40.convertCodeableConcept(src.getReAdmission()));
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getDietPreference())
      tgt.addDietPreference(CodeableConcept10_40.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getSpecialCourtesy())
      tgt.addSpecialCourtesy(CodeableConcept10_40.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getSpecialArrangement())
      tgt.addSpecialArrangement(CodeableConcept10_40.convertCodeableConcept(t));
    if (src.hasDestination())
      tgt.setDestination(Reference10_40.convertReference(src.getDestination()));
    if (src.hasDischargeDisposition())
      tgt.setDischargeDisposition(CodeableConcept10_40.convertCodeableConcept(src.getDischargeDisposition()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Encounter.EncounterHospitalizationComponent convertEncounterHospitalizationComponent(org.hl7.fhir.r4.model.Encounter.EncounterHospitalizationComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Encounter.EncounterHospitalizationComponent tgt = new org.hl7.fhir.dstu2.model.Encounter.EncounterHospitalizationComponent();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyBackboneElement(src,tgt);
    if (src.hasPreAdmissionIdentifier())
      tgt.setPreAdmissionIdentifier(Identifier10_40.convertIdentifier(src.getPreAdmissionIdentifier()));
    if (src.hasOrigin())
      tgt.setOrigin(Reference10_40.convertReference(src.getOrigin()));
    if (src.hasAdmitSource())
      tgt.setAdmitSource(CodeableConcept10_40.convertCodeableConcept(src.getAdmitSource()));
    if (src.hasReAdmission())
      tgt.setReAdmission(CodeableConcept10_40.convertCodeableConcept(src.getReAdmission()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getDietPreference())
      tgt.addDietPreference(CodeableConcept10_40.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSpecialCourtesy())
      tgt.addSpecialCourtesy(CodeableConcept10_40.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSpecialArrangement())
      tgt.addSpecialArrangement(CodeableConcept10_40.convertCodeableConcept(t));
    if (src.hasDestination())
      tgt.setDestination(Reference10_40.convertReference(src.getDestination()));
    if (src.hasDischargeDisposition())
      tgt.setDischargeDisposition(CodeableConcept10_40.convertCodeableConcept(src.getDischargeDisposition()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Encounter.EncounterLocationComponent convertEncounterLocationComponent(org.hl7.fhir.dstu2.model.Encounter.EncounterLocationComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Encounter.EncounterLocationComponent tgt = new org.hl7.fhir.r4.model.Encounter.EncounterLocationComponent();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyBackboneElement(src,tgt);
    if (src.hasLocation())
      tgt.setLocation(Reference10_40.convertReference(src.getLocation()));
    if (src.hasStatus())
      tgt.setStatusElement(convertEncounterLocationStatus(src.getStatusElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period10_40.convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Encounter.EncounterLocationComponent convertEncounterLocationComponent(org.hl7.fhir.r4.model.Encounter.EncounterLocationComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Encounter.EncounterLocationComponent tgt = new org.hl7.fhir.dstu2.model.Encounter.EncounterLocationComponent();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyBackboneElement(src,tgt);
    if (src.hasLocation())
      tgt.setLocation(Reference10_40.convertReference(src.getLocation()));
    if (src.hasStatus())
      tgt.setStatusElement(convertEncounterLocationStatus(src.getStatusElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period10_40.convertPeriod(src.getPeriod()));
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Encounter.EncounterLocationStatus> convertEncounterLocationStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Encounter.EncounterLocationStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Encounter.EncounterLocationStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Encounter.EncounterLocationStatusEnumFactory());
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case PLANNED:
        tgt.setValue(org.hl7.fhir.dstu2.model.Encounter.EncounterLocationStatus.PLANNED);
        break;
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.dstu2.model.Encounter.EncounterLocationStatus.ACTIVE);
        break;
      case RESERVED:
        tgt.setValue(org.hl7.fhir.dstu2.model.Encounter.EncounterLocationStatus.RESERVED);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.dstu2.model.Encounter.EncounterLocationStatus.COMPLETED);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.Encounter.EncounterLocationStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Encounter.EncounterLocationStatus> convertEncounterLocationStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Encounter.EncounterLocationStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Encounter.EncounterLocationStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Encounter.EncounterLocationStatusEnumFactory());
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
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

  public static org.hl7.fhir.r4.model.Encounter.EncounterParticipantComponent convertEncounterParticipantComponent(org.hl7.fhir.dstu2.model.Encounter.EncounterParticipantComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Encounter.EncounterParticipantComponent tgt = new org.hl7.fhir.r4.model.Encounter.EncounterParticipantComponent();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyBackboneElement(src,tgt);
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept10_40.convertCodeableConcept(t));
    if (src.hasPeriod())
      tgt.setPeriod(Period10_40.convertPeriod(src.getPeriod()));
    if (src.hasIndividual())
      tgt.setIndividual(Reference10_40.convertReference(src.getIndividual()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Encounter.EncounterParticipantComponent convertEncounterParticipantComponent(org.hl7.fhir.r4.model.Encounter.EncounterParticipantComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Encounter.EncounterParticipantComponent tgt = new org.hl7.fhir.dstu2.model.Encounter.EncounterParticipantComponent();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyBackboneElement(src,tgt);
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept10_40.convertCodeableConcept(t));
    if (src.hasPeriod())
      tgt.setPeriod(Period10_40.convertPeriod(src.getPeriod()));
    if (src.hasIndividual())
      tgt.setIndividual(Reference10_40.convertReference(src.getIndividual()));
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Encounter.EncounterState> convertEncounterState(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Encounter.EncounterStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Encounter.EncounterState> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Encounter.EncounterStateEnumFactory());
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case PLANNED:
        tgt.setValue(org.hl7.fhir.dstu2.model.Encounter.EncounterState.PLANNED);
        break;
      case ARRIVED:
        tgt.setValue(org.hl7.fhir.dstu2.model.Encounter.EncounterState.ARRIVED);
        break;
      case INPROGRESS:
        tgt.setValue(org.hl7.fhir.dstu2.model.Encounter.EncounterState.INPROGRESS);
        break;
      case ONLEAVE:
        tgt.setValue(org.hl7.fhir.dstu2.model.Encounter.EncounterState.ONLEAVE);
        break;
      case FINISHED:
        tgt.setValue(org.hl7.fhir.dstu2.model.Encounter.EncounterState.FINISHED);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.dstu2.model.Encounter.EncounterState.CANCELLED);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.Encounter.EncounterState.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Encounter.EncounterStatus> convertEncounterState(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Encounter.EncounterState> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Encounter.EncounterStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Encounter.EncounterStatusEnumFactory());
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case PLANNED:
        tgt.setValue(org.hl7.fhir.r4.model.Encounter.EncounterStatus.PLANNED);
        break;
      case ARRIVED:
        tgt.setValue(org.hl7.fhir.r4.model.Encounter.EncounterStatus.ARRIVED);
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
      default:
        tgt.setValue(org.hl7.fhir.r4.model.Encounter.EncounterStatus.NULL);
        break;
    }
    return tgt;
  }
}