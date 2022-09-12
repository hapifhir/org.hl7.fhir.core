package org.hl7.fhir.convertors.conv10_40.resources10_40;

import org.hl7.fhir.convertors.context.ConversionContext10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Reference10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.CodeableConcept10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Identifier10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Period10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class EpisodeOfCare10_40 {

  public static org.hl7.fhir.dstu2.model.EpisodeOfCare convertEpisodeOfCare(org.hl7.fhir.r4.model.EpisodeOfCare src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.EpisodeOfCare tgt = new org.hl7.fhir.dstu2.model.EpisodeOfCare();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_40.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertEpisodeOfCareStatus(src.getStatusElement()));
    for (org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent t : src.getStatusHistory())
      tgt.addStatusHistory(convertEpisodeOfCareStatusHistoryComponent(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept10_40.convertCodeableConcept(t));
    if (src.hasPatient())
      tgt.setPatient(Reference10_40.convertReference(src.getPatient()));
    if (src.hasManagingOrganization())
      tgt.setManagingOrganization(Reference10_40.convertReference(src.getManagingOrganization()));
    if (src.hasPeriod())
      tgt.setPeriod(Period10_40.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.r4.model.Reference t : src.getReferralRequest())
      tgt.addReferralRequest(Reference10_40.convertReference(t));
    if (src.hasCareManager())
      tgt.setCareManager(Reference10_40.convertReference(src.getCareManager()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.EpisodeOfCare convertEpisodeOfCare(org.hl7.fhir.dstu2.model.EpisodeOfCare src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.EpisodeOfCare tgt = new org.hl7.fhir.r4.model.EpisodeOfCare();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_40.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertEpisodeOfCareStatus(src.getStatusElement()));
    for (org.hl7.fhir.dstu2.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent t : src.getStatusHistory())
      tgt.addStatusHistory(convertEpisodeOfCareStatusHistoryComponent(t));
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept10_40.convertCodeableConcept(t));
    if (src.hasPatient())
      tgt.setPatient(Reference10_40.convertReference(src.getPatient()));
    if (src.hasManagingOrganization())
      tgt.setManagingOrganization(Reference10_40.convertReference(src.getManagingOrganization()));
    if (src.hasPeriod())
      tgt.setPeriod(Period10_40.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getReferralRequest())
      tgt.addReferralRequest(Reference10_40.convertReference(t));
    if (src.hasCareManager())
      tgt.setCareManager(Reference10_40.convertReference(src.getCareManager()));
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatus> convertEpisodeOfCareStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.EpisodeOfCare.EpisodeOfCareStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatusEnumFactory());
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case PLANNED:
        tgt.setValue(org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatus.PLANNED);
        break;
      case WAITLIST:
        tgt.setValue(org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatus.WAITLIST);
        break;
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatus.ACTIVE);
        break;
      case ONHOLD:
        tgt.setValue(org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatus.ONHOLD);
        break;
      case FINISHED:
        tgt.setValue(org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatus.FINISHED);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatus.CANCELLED);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.EpisodeOfCare.EpisodeOfCareStatus> convertEpisodeOfCareStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.EpisodeOfCare.EpisodeOfCareStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.EpisodeOfCare.EpisodeOfCareStatusEnumFactory());
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case PLANNED:
        tgt.setValue(org.hl7.fhir.dstu2.model.EpisodeOfCare.EpisodeOfCareStatus.PLANNED);
        break;
      case WAITLIST:
        tgt.setValue(org.hl7.fhir.dstu2.model.EpisodeOfCare.EpisodeOfCareStatus.WAITLIST);
        break;
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.dstu2.model.EpisodeOfCare.EpisodeOfCareStatus.ACTIVE);
        break;
      case ONHOLD:
        tgt.setValue(org.hl7.fhir.dstu2.model.EpisodeOfCare.EpisodeOfCareStatus.ONHOLD);
        break;
      case FINISHED:
        tgt.setValue(org.hl7.fhir.dstu2.model.EpisodeOfCare.EpisodeOfCareStatus.FINISHED);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.dstu2.model.EpisodeOfCare.EpisodeOfCareStatus.CANCELLED);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.EpisodeOfCare.EpisodeOfCareStatus.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent convertEpisodeOfCareStatusHistoryComponent(org.hl7.fhir.dstu2.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent tgt = new org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyBackboneElement(src,tgt);
    if (src.hasStatus())
      tgt.setStatusElement(convertEpisodeOfCareStatus(src.getStatusElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period10_40.convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent convertEpisodeOfCareStatusHistoryComponent(org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent tgt = new org.hl7.fhir.dstu2.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyBackboneElement(src,tgt);
    if (src.hasStatus())
      tgt.setStatusElement(convertEpisodeOfCareStatus(src.getStatusElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period10_40.convertPeriod(src.getPeriod()));
    return tgt;
  }
}