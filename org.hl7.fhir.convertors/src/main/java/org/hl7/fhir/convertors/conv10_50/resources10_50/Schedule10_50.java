package org.hl7.fhir.convertors.conv10_50.resources10_50;

import org.hl7.fhir.convertors.context.ConversionContext10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.Reference10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.CodeableConcept10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Identifier10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Period10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.String10_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableReference;

public class Schedule10_50 {

  public static org.hl7.fhir.dstu2.model.Schedule convertSchedule(org.hl7.fhir.r5.model.Schedule src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Schedule tgt = new org.hl7.fhir.dstu2.model.Schedule();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_50.convertIdentifier(t));
    for (CodeableReference t : src.getServiceType())
      if (t.hasConcept())
        tgt.addType(CodeableConcept10_50.convertCodeableConcept(t.getConcept()));
    if (src.hasActor())
      tgt.setActor(Reference10_50.convertReference(src.getActorFirstRep()));
    if (src.hasPlanningHorizon())
      tgt.setPlanningHorizon(Period10_50.convertPeriod(src.getPlanningHorizon()));
    if (src.hasCommentElement())
      tgt.setCommentElement(String10_50.convertString(src.getCommentElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Schedule convertSchedule(org.hl7.fhir.dstu2.model.Schedule src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Schedule tgt = new org.hl7.fhir.r5.model.Schedule();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_50.convertIdentifier(t));
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getType())
      tgt.addServiceType(new CodeableReference().setConcept(CodeableConcept10_50.convertCodeableConcept(t)));
    if (src.hasActor())
      tgt.addActor(Reference10_50.convertReference(src.getActor()));
    if (src.hasPlanningHorizon())
      tgt.setPlanningHorizon(Period10_50.convertPeriod(src.getPlanningHorizon()));
    if (src.hasCommentElement())
      tgt.setCommentElement(String10_50.convertStringToMarkdown(src.getCommentElement()));
    return tgt;
  }
}