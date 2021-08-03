package org.hl7.fhir.convertors.conv10_40.resources10_40;

import org.hl7.fhir.convertors.conv10_40.VersionConvertor_10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Reference10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.CodeableConcept10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Identifier10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Period10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.String10_40;
import org.hl7.fhir.exceptions.FHIRException; import org.hl7.fhir.convertors.context.ConversionContext10_40;

public class Schedule10_40 {

  public static org.hl7.fhir.r4.model.Schedule convertSchedule(org.hl7.fhir.dstu2.model.Schedule src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Schedule tgt = new org.hl7.fhir.r4.model.Schedule();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_40.convertIdentifier(t));
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getType())
      tgt.addServiceType(CodeableConcept10_40.convertCodeableConcept(t));
    if (src.hasActor())
      tgt.addActor(Reference10_40.convertReference(src.getActor()));
    if (src.hasPlanningHorizon())
      tgt.setPlanningHorizon(Period10_40.convertPeriod(src.getPlanningHorizon()));
    if (src.hasCommentElement())
      tgt.setCommentElement(String10_40.convertString(src.getCommentElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Schedule convertSchedule(org.hl7.fhir.r4.model.Schedule src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Schedule tgt = new org.hl7.fhir.dstu2.model.Schedule();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_40.convertIdentifier(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getServiceType())
      tgt.addType(CodeableConcept10_40.convertCodeableConcept(t));
    if (src.hasActor())
      tgt.setActor(Reference10_40.convertReference(src.getActorFirstRep()));
    if (src.hasPlanningHorizon())
      tgt.setPlanningHorizon(Period10_40.convertPeriod(src.getPlanningHorizon()));
    if (src.hasCommentElement())
      tgt.setCommentElement(String10_40.convertString(src.getCommentElement()));
    return tgt;
  }
}