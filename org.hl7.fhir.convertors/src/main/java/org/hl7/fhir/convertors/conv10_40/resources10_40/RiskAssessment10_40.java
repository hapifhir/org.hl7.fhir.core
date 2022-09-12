package org.hl7.fhir.convertors.conv10_40.resources10_40;

import org.hl7.fhir.convertors.context.ConversionContext10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Reference10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.CodeableConcept10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Identifier10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.Decimal10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.String10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class RiskAssessment10_40 {

  public static org.hl7.fhir.dstu2.model.RiskAssessment convertRiskAssessment(org.hl7.fhir.r4.model.RiskAssessment src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.RiskAssessment tgt = new org.hl7.fhir.dstu2.model.RiskAssessment();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyDomainResource(src, tgt);
    if (src.hasSubject())
      tgt.setSubject(Reference10_40.convertReference(src.getSubject()));
    if (src.hasCondition())
      tgt.setCondition(Reference10_40.convertReference(src.getCondition()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference10_40.convertReference(src.getEncounter()));
    if (src.hasPerformer())
      tgt.setPerformer(Reference10_40.convertReference(src.getPerformer()));
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier10_40.convertIdentifier(src.getIdentifierFirstRep()));
    if (src.hasMethod())
      tgt.setMethod(CodeableConcept10_40.convertCodeableConcept(src.getMethod()));
    for (org.hl7.fhir.r4.model.Reference t : src.getBasis()) tgt.addBasis(Reference10_40.convertReference(t));
    for (org.hl7.fhir.r4.model.RiskAssessment.RiskAssessmentPredictionComponent t : src.getPrediction())
      tgt.addPrediction(convertRiskAssessmentPredictionComponent(t));
    if (src.hasMitigationElement())
      tgt.setMitigationElement(String10_40.convertString(src.getMitigationElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.RiskAssessment convertRiskAssessment(org.hl7.fhir.dstu2.model.RiskAssessment src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.RiskAssessment tgt = new org.hl7.fhir.r4.model.RiskAssessment();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyDomainResource(src, tgt);
    if (src.hasSubject())
      tgt.setSubject(Reference10_40.convertReference(src.getSubject()));
    if (src.hasCondition())
      tgt.setCondition(Reference10_40.convertReference(src.getCondition()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference10_40.convertReference(src.getEncounter()));
    if (src.hasPerformer())
      tgt.setPerformer(Reference10_40.convertReference(src.getPerformer()));
    if (src.hasIdentifier())
      tgt.addIdentifier(Identifier10_40.convertIdentifier(src.getIdentifier()));
    if (src.hasMethod())
      tgt.setMethod(CodeableConcept10_40.convertCodeableConcept(src.getMethod()));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getBasis()) tgt.addBasis(Reference10_40.convertReference(t));
    for (org.hl7.fhir.dstu2.model.RiskAssessment.RiskAssessmentPredictionComponent t : src.getPrediction())
      tgt.addPrediction(convertRiskAssessmentPredictionComponent(t));
    if (src.hasMitigationElement())
      tgt.setMitigationElement(String10_40.convertString(src.getMitigationElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.RiskAssessment.RiskAssessmentPredictionComponent convertRiskAssessmentPredictionComponent(org.hl7.fhir.r4.model.RiskAssessment.RiskAssessmentPredictionComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.RiskAssessment.RiskAssessmentPredictionComponent tgt = new org.hl7.fhir.dstu2.model.RiskAssessment.RiskAssessmentPredictionComponent();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyBackboneElement(src,tgt);
    if (src.hasOutcome())
      tgt.setOutcome(CodeableConcept10_40.convertCodeableConcept(src.getOutcome()));
    if (src.hasProbability())
      tgt.setProbability(ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().convertType(src.getProbability()));
    if (src.hasRelativeRiskElement())
      tgt.setRelativeRiskElement(Decimal10_40.convertDecimal(src.getRelativeRiskElement()));
    if (src.hasWhen())
      tgt.setWhen(ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().convertType(src.getWhen()));
    if (src.hasRationaleElement())
      tgt.setRationaleElement(String10_40.convertString(src.getRationaleElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.RiskAssessment.RiskAssessmentPredictionComponent convertRiskAssessmentPredictionComponent(org.hl7.fhir.dstu2.model.RiskAssessment.RiskAssessmentPredictionComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.RiskAssessment.RiskAssessmentPredictionComponent tgt = new org.hl7.fhir.r4.model.RiskAssessment.RiskAssessmentPredictionComponent();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyBackboneElement(src,tgt);
    if (src.hasOutcome())
      tgt.setOutcome(CodeableConcept10_40.convertCodeableConcept(src.getOutcome()));
    if (src.hasProbability())
      tgt.setProbability(ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().convertType(src.getProbability()));
    if (src.hasRelativeRiskElement())
      tgt.setRelativeRiskElement(Decimal10_40.convertDecimal(src.getRelativeRiskElement()));
    if (src.hasWhen())
      tgt.setWhen(ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().convertType(src.getWhen()));
    if (src.hasRationaleElement())
      tgt.setRationaleElement(String10_40.convertString(src.getRationaleElement()));
    return tgt;
  }
}