package org.hl7.fhir.convertors.conv10_50.resources10_50;

import org.hl7.fhir.convertors.context.ConversionContext10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.Reference10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.CodeableConcept10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Duration10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Identifier10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Period10_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableReference;
import org.hl7.fhir.r5.model.Encounter.ReasonComponent;

public class Encounter10_50 {

  public static org.hl7.fhir.dstu2.model.Encounter convertEncounter(org.hl7.fhir.r5.model.Encounter src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Encounter tgt = new org.hl7.fhir.dstu2.model.Encounter();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertEncounterState(src.getStatusElement()));
    if (src.hasClass_())
      tgt.setClass_( convertEncounterClass(src.getClass_FirstRep().getCodingFirstRep()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept10_50.convertCodeableConcept(t));
    if (src.hasPriority())
      tgt.setPriority(CodeableConcept10_50.convertCodeableConcept(src.getPriority()));
    if (src.hasSubject())
      tgt.setPatient(Reference10_50.convertReference(src.getSubject()));
    for (org.hl7.fhir.r5.model.Reference t : src.getEpisodeOfCare())
      tgt.addEpisodeOfCare(Reference10_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn())
      tgt.addIncomingReferral(Reference10_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Encounter.EncounterParticipantComponent t : src.getParticipant())
      tgt.addParticipant(convertEncounterParticipantComponent(t));
    if (src.hasAppointment())
      tgt.setAppointment(Reference10_50.convertReference(src.getAppointmentFirstRep()));
    if (src.hasActualPeriod())
      tgt.setPeriod(Period10_50.convertPeriod(src.getActualPeriod()));
    if (src.hasLength())
      tgt.setLength(Duration10_50.convertDuration(src.getLength()));
    for (ReasonComponent t1 : src.getReason())
      for (CodeableReference t : t1.getValue())
        if (t.hasConcept())
          tgt.addReason(CodeableConcept10_50.convertCodeableConcept(t.getConcept()));
    if (src.hasAdmission() || src.hasDietPreference() || src.hasSpecialArrangement() || src.hasSpecialCourtesy())
      tgt.setHospitalization(convertEncounterHospitalizationComponent(src.getAdmission(), src));
    for (org.hl7.fhir.r5.model.Encounter.EncounterLocationComponent t : src.getLocation())
      tgt.addLocation(convertEncounterLocationComponent(t));
    if (src.hasServiceProvider())
      tgt.setServiceProvider(Reference10_50.convertReference(src.getServiceProvider()));
    if (src.hasPartOf())
      tgt.setPartOf(Reference10_50.convertReference(src.getPartOf()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Encounter convertEncounter(org.hl7.fhir.dstu2.model.Encounter src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Encounter tgt = new org.hl7.fhir.r5.model.Encounter();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertEncounterState(src.getStatusElement()));
    if (src.hasClass_())
      tgt.addClass_(new org.hl7.fhir.r5.model.CodeableConcept().addCoding(convertEncounterClass(src.getClass_())));
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept10_50.convertCodeableConcept(t));
    if (src.hasPriority())
      tgt.setPriority(CodeableConcept10_50.convertCodeableConcept(src.getPriority()));
    if (src.hasPatient())
      tgt.setSubject(Reference10_50.convertReference(src.getPatient()));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getEpisodeOfCare())
      tgt.addEpisodeOfCare(Reference10_50.convertReference(t));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getIncomingReferral())
      tgt.addBasedOn(Reference10_50.convertReference(t));
    for (org.hl7.fhir.dstu2.model.Encounter.EncounterParticipantComponent t : src.getParticipant())
      tgt.addParticipant(convertEncounterParticipantComponent(t));
    if (src.hasAppointment())
      tgt.addAppointment(Reference10_50.convertReference(src.getAppointment()));
    if (src.hasPeriod())
      tgt.setActualPeriod(Period10_50.convertPeriod(src.getPeriod()));
    if (src.hasLength())
      tgt.setLength(Duration10_50.convertDuration(src.getLength()));
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getReason())
      tgt.addReason().addValue(CodeableConcept10_50.convertCodeableConceptToCodableReference(t));
    if (src.hasHospitalization())
      tgt.setAdmission(convertEncounterHospitalizationComponent(src.getHospitalization(), tgt));
    for (org.hl7.fhir.dstu2.model.Encounter.EncounterLocationComponent t : src.getLocation())
      tgt.addLocation(convertEncounterLocationComponent(t));
    if (src.hasServiceProvider())
      tgt.setServiceProvider(Reference10_50.convertReference(src.getServiceProvider()));
    if (src.hasPartOf())
      tgt.setPartOf(Reference10_50.convertReference(src.getPartOf()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Encounter.EncounterClass convertEncounterClass(org.hl7.fhir.r5.model.Coding src) throws FHIRException {
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

  public static org.hl7.fhir.r5.model.Coding convertEncounterClass(org.hl7.fhir.dstu2.model.Encounter.EncounterClass src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
      case INPATIENT:
        return new org.hl7.fhir.r5.model.Coding().setSystem("http://terminology.hl7.org/v3/ActCode").setCode("IMP");
      case OUTPATIENT:
        return new org.hl7.fhir.r5.model.Coding().setSystem("http://terminology.hl7.org/v3/ActCode").setCode("AMB");
      case AMBULATORY:
        return new org.hl7.fhir.r5.model.Coding().setSystem("http://terminology.hl7.org/v3/ActCode").setCode("AMB");
      case EMERGENCY:
        return new org.hl7.fhir.r5.model.Coding().setSystem("http://terminology.hl7.org/v3/ActCode").setCode("EMER");
      case HOME:
        return new org.hl7.fhir.r5.model.Coding().setSystem("http://terminology.hl7.org/v3/ActCode").setCode("HH");
      case FIELD:
        return new org.hl7.fhir.r5.model.Coding().setSystem("http://terminology.hl7.org/v3/ActCode").setCode("FLD");
      case DAYTIME:
        return new org.hl7.fhir.r5.model.Coding().setSystem("http://terminology.hl7.org/v3/ActCode").setCode("SS");
      case VIRTUAL:
        return new org.hl7.fhir.r5.model.Coding().setSystem("http://terminology.hl7.org/v3/ActCode").setCode("VR");
      default:
        return null;
    }
  }

  public static org.hl7.fhir.r5.model.Encounter.EncounterAdmissionComponent convertEncounterHospitalizationComponent(org.hl7.fhir.dstu2.model.Encounter.EncounterHospitalizationComponent src, org.hl7.fhir.r5.model.Encounter tgte) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Encounter.EncounterAdmissionComponent tgt = new org.hl7.fhir.r5.model.Encounter.EncounterAdmissionComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasPreAdmissionIdentifier())
      tgt.setPreAdmissionIdentifier(Identifier10_50.convertIdentifier(src.getPreAdmissionIdentifier()));
    if (src.hasOrigin())
      tgt.setOrigin(Reference10_50.convertReference(src.getOrigin()));
    if (src.hasAdmitSource())
      tgt.setAdmitSource(CodeableConcept10_50.convertCodeableConcept(src.getAdmitSource()));
    if (src.hasReAdmission())
      tgt.setReAdmission(CodeableConcept10_50.convertCodeableConcept(src.getReAdmission()));
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getDietPreference())
      tgte.addDietPreference(CodeableConcept10_50.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getSpecialCourtesy())
      tgte.addSpecialCourtesy(CodeableConcept10_50.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getSpecialArrangement())
      tgte.addSpecialArrangement(CodeableConcept10_50.convertCodeableConcept(t));
    if (src.hasDestination())
      tgt.setDestination(Reference10_50.convertReference(src.getDestination()));
    if (src.hasDischargeDisposition())
      tgt.setDischargeDisposition(CodeableConcept10_50.convertCodeableConcept(src.getDischargeDisposition()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Encounter.EncounterHospitalizationComponent convertEncounterHospitalizationComponent(org.hl7.fhir.r5.model.Encounter.EncounterAdmissionComponent src, org.hl7.fhir.r5.model.Encounter srce) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Encounter.EncounterHospitalizationComponent tgt = new org.hl7.fhir.dstu2.model.Encounter.EncounterHospitalizationComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasPreAdmissionIdentifier())
      tgt.setPreAdmissionIdentifier(Identifier10_50.convertIdentifier(src.getPreAdmissionIdentifier()));
    if (src.hasOrigin())
      tgt.setOrigin(Reference10_50.convertReference(src.getOrigin()));
    if (src.hasAdmitSource())
      tgt.setAdmitSource(CodeableConcept10_50.convertCodeableConcept(src.getAdmitSource()));
    if (src.hasReAdmission())
      tgt.setReAdmission(CodeableConcept10_50.convertCodeableConcept(src.getReAdmission()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : srce.getDietPreference())
      tgt.addDietPreference(CodeableConcept10_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : srce.getSpecialCourtesy())
      tgt.addSpecialCourtesy(CodeableConcept10_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : srce.getSpecialArrangement())
      tgt.addSpecialArrangement(CodeableConcept10_50.convertCodeableConcept(t));
    if (src.hasDestination())
      tgt.setDestination(Reference10_50.convertReference(src.getDestination()));
    if (src.hasDischargeDisposition())
      tgt.setDischargeDisposition(CodeableConcept10_50.convertCodeableConcept(src.getDischargeDisposition()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Encounter.EncounterLocationComponent convertEncounterLocationComponent(org.hl7.fhir.dstu2.model.Encounter.EncounterLocationComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Encounter.EncounterLocationComponent tgt = new org.hl7.fhir.r5.model.Encounter.EncounterLocationComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasLocation())
      tgt.setLocation(Reference10_50.convertReference(src.getLocation()));
    if (src.hasStatus())
      tgt.setStatusElement(convertEncounterLocationStatus(src.getStatusElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period10_50.convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Encounter.EncounterLocationComponent convertEncounterLocationComponent(org.hl7.fhir.r5.model.Encounter.EncounterLocationComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Encounter.EncounterLocationComponent tgt = new org.hl7.fhir.dstu2.model.Encounter.EncounterLocationComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasLocation())
      tgt.setLocation(Reference10_50.convertReference(src.getLocation()));
    if (src.hasStatus())
      tgt.setStatusElement(convertEncounterLocationStatus(src.getStatusElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period10_50.convertPeriod(src.getPeriod()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Encounter.EncounterLocationStatus> convertEncounterLocationStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Encounter.EncounterLocationStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Encounter.EncounterLocationStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Encounter.EncounterLocationStatusEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Encounter.EncounterLocationStatus> convertEncounterLocationStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Encounter.EncounterLocationStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Encounter.EncounterLocationStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Encounter.EncounterLocationStatusEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
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

  public static org.hl7.fhir.r5.model.Encounter.EncounterParticipantComponent convertEncounterParticipantComponent(org.hl7.fhir.dstu2.model.Encounter.EncounterParticipantComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Encounter.EncounterParticipantComponent tgt = new org.hl7.fhir.r5.model.Encounter.EncounterParticipantComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept10_50.convertCodeableConcept(t));
    if (src.hasPeriod())
      tgt.setPeriod(Period10_50.convertPeriod(src.getPeriod()));
    if (src.hasIndividual())
      tgt.setActor(Reference10_50.convertReference(src.getIndividual()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Encounter.EncounterParticipantComponent convertEncounterParticipantComponent(org.hl7.fhir.r5.model.Encounter.EncounterParticipantComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Encounter.EncounterParticipantComponent tgt = new org.hl7.fhir.dstu2.model.Encounter.EncounterParticipantComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept10_50.convertCodeableConcept(t));
    if (src.hasPeriod())
      tgt.setPeriod(Period10_50.convertPeriod(src.getPeriod()));
    if (src.hasActor())
      tgt.setIndividual(Reference10_50.convertReference(src.getActor()));
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Encounter.EncounterState> convertEncounterState(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.EncounterStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Encounter.EncounterState> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Encounter.EncounterStateEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PLANNED:
        tgt.setValue(org.hl7.fhir.dstu2.model.Encounter.EncounterState.PLANNED);
        break;
      case INPROGRESS:
        tgt.setValue(org.hl7.fhir.dstu2.model.Encounter.EncounterState.INPROGRESS);
        break;
      case COMPLETED:
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

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.EncounterStatus> convertEncounterState(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Encounter.EncounterState> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.EncounterStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.EncounterStatusEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PLANNED:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.EncounterStatus.PLANNED);
        break;
      case ARRIVED:
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
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.EncounterStatus.NULL);
        break;
    }
    return tgt;
  }
}