package org.hl7.fhir.convertors.conv10_50.resources10_50;

import org.hl7.fhir.convertors.context.ConversionContext10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.Reference10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.CodeableConcept10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Identifier10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Ratio10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Timing10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Boolean10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.DateTime10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.String10_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.Dosage.DosageDoseAndRateComponent;

public class MedicationStatement10_50 {

  public static org.hl7.fhir.dstu2.model.MedicationStatement convertMedicationStatement(org.hl7.fhir.r5.model.MedicationStatement src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.MedicationStatement tgt = new org.hl7.fhir.dstu2.model.MedicationStatement();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertMedicationStatementStatus(src.getStatusElement()));
    if (src.getMedication().hasConcept()) {
      tgt.setMedication(ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().convertType(src.getMedication().getConcept()));
    }
    if (src.getMedication().hasReference()) {
      tgt.setMedication(ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().convertType(src.getMedication().getReference()));
    }
    if (src.hasSubject())
      tgt.setPatient(Reference10_50.convertReference(src.getSubject()));
    if (src.hasEffective())
      tgt.setEffective(ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().convertType(src.getEffective()));
    if (src.hasInformationSource())
      tgt.setInformationSource(Reference10_50.convertReference(src.getInformationSourceFirstRep()));
    for (org.hl7.fhir.r5.model.Reference t : src.getDerivedFrom())
      tgt.addSupportingInformation(Reference10_50.convertReference(t));
    if (src.hasDateAsserted())
      tgt.setDateAssertedElement(DateTime10_50.convertDateTime(src.getDateAssertedElement()));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.setNote(t.getText());
    for (org.hl7.fhir.r5.model.Dosage t : src.getDosage()) tgt.addDosage(convertMedicationStatementDosageComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MedicationStatement convertMedicationStatement(org.hl7.fhir.dstu2.model.MedicationStatement src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.MedicationStatement tgt = new org.hl7.fhir.r5.model.MedicationStatement();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertMedicationStatementStatus(src.getStatusElement()));
    if (src.hasMedicationCodeableConcept()) {
      tgt.getMedication().setConcept(CodeableConcept10_50.convertCodeableConcept(src.getMedicationCodeableConcept()));
    }
    if (src.hasMedicationReference()) {
      tgt.getMedication().setReference(Reference10_50.convertReference(src.getMedicationReference()));
    }
    if (src.hasPatient())
      tgt.setSubject(Reference10_50.convertReference(src.getPatient()));
    if (src.hasEffective())
      tgt.setEffective(ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().convertType(src.getEffective()));
    if (src.hasInformationSource())
      tgt.addInformationSource(Reference10_50.convertReference(src.getInformationSource()));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getSupportingInformation())
      tgt.addDerivedFrom(Reference10_50.convertReference(t));
    if (src.hasDateAsserted())
      tgt.setDateAssertedElement(DateTime10_50.convertDateTime(src.getDateAssertedElement()));
    if (src.hasNote())
      tgt.addNote().setText(src.getNote());
    for (org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementDosageComponent t : src.getDosage())
      tgt.addDosage(convertMedicationStatementDosageComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Dosage convertMedicationStatementDosageComponent(org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementDosageComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Dosage tgt = new org.hl7.fhir.r5.model.Dosage();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    if (src.hasTextElement())
      tgt.setTextElement(String10_50.convertString(src.getTextElement()));
    if (src.hasTiming())
      tgt.setTiming(Timing10_50.convertTiming(src.getTiming()));
    if (src.hasAsNeededBooleanType())
      tgt.setAsNeededElement(Boolean10_50.convertBoolean(src.getAsNeededBooleanType()));
    if (src.hasSiteCodeableConcept())
      tgt.setSite(CodeableConcept10_50.convertCodeableConcept(src.getSiteCodeableConcept()));
    if (src.hasRoute())
      tgt.setRoute(CodeableConcept10_50.convertCodeableConcept(src.getRoute()));
    if (src.hasMethod())
      tgt.setMethod(CodeableConcept10_50.convertCodeableConcept(src.getMethod()));
    if (src.hasRate()) {
      DosageDoseAndRateComponent dr = tgt.addDoseAndRate();
      if (src.hasRate())
        dr.setRate(ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().convertType(src.getRate()));
    }
    if (src.hasMaxDosePerPeriod())
      tgt.addMaxDosePerPeriod(Ratio10_50.convertRatio(src.getMaxDosePerPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementDosageComponent convertMedicationStatementDosageComponent(org.hl7.fhir.r5.model.Dosage src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementDosageComponent tgt = new org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementDosageComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    if (src.hasTextElement())
      tgt.setTextElement(String10_50.convertString(src.getTextElement()));
    if (src.hasTiming())
      tgt.setTiming(Timing10_50.convertTiming(src.getTiming()));
    if (src.hasAsNeeded())
      tgt.setAsNeeded(Boolean10_50.convertBoolean(src.getAsNeededElement()));
    if (src.hasSite())
      tgt.setSite(ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().convertType(src.getSite()));
    if (src.hasRoute())
      tgt.setRoute(CodeableConcept10_50.convertCodeableConcept(src.getRoute()));
    if (src.hasMethod())
      tgt.setMethod(CodeableConcept10_50.convertCodeableConcept(src.getMethod()));
    if (src.hasDoseAndRate() && src.getDoseAndRate().get(0).hasRate())
      tgt.setRate(ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().convertType(src.getDoseAndRate().get(0).getRate()));
    if (src.hasMaxDosePerPeriod())
      tgt.setMaxDosePerPeriod(Ratio10_50.convertRatio(src.getMaxDosePerPeriodFirstRep()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationStatement.MedicationStatementStatusCodes> convertMedicationStatementStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationStatement.MedicationStatementStatusCodes> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.MedicationStatement.MedicationStatementStatusCodesEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationStatement.MedicationStatementStatusCodes.RECORDED);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationStatement.MedicationStatementStatusCodes.RECORDED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationStatement.MedicationStatementStatusCodes.ENTEREDINERROR);
        break;
      case INTENDED:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationStatement.MedicationStatementStatusCodes.RECORDED);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationStatement.MedicationStatementStatusCodes.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementStatus> convertMedicationStatementStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationStatement.MedicationStatementStatusCodes> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementStatusEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    switch (src.getValue()) {
//            case ACTIVE:
//                tgt.setValue(org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementStatus.ACTIVE);
//                break;
      case RECORDED:
        tgt.setValue(org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementStatus.COMPLETED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementStatus.ENTEREDINERROR);
        break;
      case DRAFT:
        tgt.setValue(org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementStatus.ACTIVE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementStatus.NULL);
        break;
    }
    return tgt;
  }
}