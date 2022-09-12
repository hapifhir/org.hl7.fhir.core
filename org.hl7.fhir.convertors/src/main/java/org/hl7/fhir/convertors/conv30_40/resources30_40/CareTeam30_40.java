package org.hl7.fhir.convertors.conv30_40.resources30_40;

import org.hl7.fhir.convertors.context.ConversionContext30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Reference30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Annotation30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.CodeableConcept30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Identifier30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Period30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.String30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class CareTeam30_40 {

  public static org.hl7.fhir.dstu3.model.CareTeam convertCareTeam(org.hl7.fhir.r4.model.CareTeam src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.CareTeam tgt = new org.hl7.fhir.dstu3.model.CareTeam();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertCareTeamStatus(src.getStatusElement()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept30_40.convertCodeableConcept(t));
    if (src.hasName())
      tgt.setNameElement(String30_40.convertString(src.getNameElement()));
    if (src.hasSubject())
      tgt.setSubject(Reference30_40.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setContext(Reference30_40.convertReference(src.getEncounter()));
    if (src.hasPeriod())
      tgt.setPeriod(Period30_40.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.r4.model.CareTeam.CareTeamParticipantComponent t : src.getParticipant())
      tgt.addParticipant(convertCareTeamParticipantComponent(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode())
      tgt.addReasonCode(CodeableConcept30_40.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference())
      tgt.addReasonReference(Reference30_40.convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getManagingOrganization())
      tgt.addManagingOrganization(Reference30_40.convertReference(t));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(Annotation30_40.convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CareTeam convertCareTeam(org.hl7.fhir.dstu3.model.CareTeam src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CareTeam tgt = new org.hl7.fhir.r4.model.CareTeam();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertCareTeamStatus(src.getStatusElement()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept30_40.convertCodeableConcept(t));
    if (src.hasName())
      tgt.setNameElement(String30_40.convertString(src.getNameElement()));
    if (src.hasSubject())
      tgt.setSubject(Reference30_40.convertReference(src.getSubject()));
    if (src.hasContext())
      tgt.setEncounter(Reference30_40.convertReference(src.getContext()));
    if (src.hasPeriod())
      tgt.setPeriod(Period30_40.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.dstu3.model.CareTeam.CareTeamParticipantComponent t : src.getParticipant())
      tgt.addParticipant(convertCareTeamParticipantComponent(t));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReasonCode())
      tgt.addReasonCode(CodeableConcept30_40.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getReasonReference())
      tgt.addReasonReference(Reference30_40.convertReference(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getManagingOrganization())
      tgt.addManagingOrganization(Reference30_40.convertReference(t));
    for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(Annotation30_40.convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.CareTeam.CareTeamParticipantComponent convertCareTeamParticipantComponent(org.hl7.fhir.r4.model.CareTeam.CareTeamParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.CareTeam.CareTeamParticipantComponent tgt = new org.hl7.fhir.dstu3.model.CareTeam.CareTeamParticipantComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasRole())
      tgt.setRole(CodeableConcept30_40.convertCodeableConcept(src.getRoleFirstRep()));
    if (src.hasMember())
      tgt.setMember(Reference30_40.convertReference(src.getMember()));
    if (src.hasOnBehalfOf())
      tgt.setOnBehalfOf(Reference30_40.convertReference(src.getOnBehalfOf()));
    if (src.hasPeriod())
      tgt.setPeriod(Period30_40.convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CareTeam.CareTeamParticipantComponent convertCareTeamParticipantComponent(org.hl7.fhir.dstu3.model.CareTeam.CareTeamParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CareTeam.CareTeamParticipantComponent tgt = new org.hl7.fhir.r4.model.CareTeam.CareTeamParticipantComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasRole())
      tgt.addRole(CodeableConcept30_40.convertCodeableConcept(src.getRole()));
    if (src.hasMember())
      tgt.setMember(Reference30_40.convertReference(src.getMember()));
    if (src.hasOnBehalfOf())
      tgt.setOnBehalfOf(Reference30_40.convertReference(src.getOnBehalfOf()));
    if (src.hasPeriod())
      tgt.setPeriod(Period30_40.convertPeriod(src.getPeriod()));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CareTeam.CareTeamStatus> convertCareTeamStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CareTeam.CareTeamStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CareTeam.CareTeamStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.CareTeam.CareTeamStatusEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case PROPOSED:
        tgt.setValue(org.hl7.fhir.dstu3.model.CareTeam.CareTeamStatus.PROPOSED);
        break;
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.dstu3.model.CareTeam.CareTeamStatus.ACTIVE);
        break;
      case SUSPENDED:
        tgt.setValue(org.hl7.fhir.dstu3.model.CareTeam.CareTeamStatus.SUSPENDED);
        break;
      case INACTIVE:
        tgt.setValue(org.hl7.fhir.dstu3.model.CareTeam.CareTeamStatus.INACTIVE);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.dstu3.model.CareTeam.CareTeamStatus.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.CareTeam.CareTeamStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CareTeam.CareTeamStatus> convertCareTeamStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CareTeam.CareTeamStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CareTeam.CareTeamStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.CareTeam.CareTeamStatusEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case PROPOSED:
        tgt.setValue(org.hl7.fhir.r4.model.CareTeam.CareTeamStatus.PROPOSED);
        break;
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r4.model.CareTeam.CareTeamStatus.ACTIVE);
        break;
      case SUSPENDED:
        tgt.setValue(org.hl7.fhir.r4.model.CareTeam.CareTeamStatus.SUSPENDED);
        break;
      case INACTIVE:
        tgt.setValue(org.hl7.fhir.r4.model.CareTeam.CareTeamStatus.INACTIVE);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4.model.CareTeam.CareTeamStatus.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.CareTeam.CareTeamStatus.NULL);
        break;
    }
    return tgt;
  }
}