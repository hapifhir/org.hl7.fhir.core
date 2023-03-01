package org.hl7.fhir.convertors.conv30_50.resources30_50;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Reference30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.CodeableConcept30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Identifier30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Period30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Boolean30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.String30_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableReference;

public class Schedule30_50 {

  public static org.hl7.fhir.dstu3.model.Schedule convertSchedule(org.hl7.fhir.r5.model.Schedule src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Schedule tgt = new org.hl7.fhir.dstu3.model.Schedule();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
    if (src.hasActive())
      tgt.setActiveElement(Boolean30_50.convertBoolean(src.getActiveElement()));
    if (src.hasServiceCategory())
      tgt.setServiceCategory(CodeableConcept30_50.convertCodeableConcept(src.getServiceCategoryFirstRep()));
    for (CodeableReference t : src.getServiceType())
      if (t.hasConcept())
        tgt.addServiceType(CodeableConcept30_50.convertCodeableConcept(t.getConcept() ));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getSpecialty())
      tgt.addSpecialty(CodeableConcept30_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getActor()) tgt.addActor(Reference30_50.convertReference(t));
    if (src.hasPlanningHorizon())
      tgt.setPlanningHorizon(Period30_50.convertPeriod(src.getPlanningHorizon()));
    if (src.hasComment())
      tgt.setCommentElement(String30_50.convertString(src.getCommentElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Schedule convertSchedule(org.hl7.fhir.dstu3.model.Schedule src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Schedule tgt = new org.hl7.fhir.r5.model.Schedule();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
    if (src.hasActive())
      tgt.setActiveElement(Boolean30_50.convertBoolean(src.getActiveElement()));
    if (src.hasServiceCategory())
      tgt.addServiceCategory(CodeableConcept30_50.convertCodeableConcept(src.getServiceCategory()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getServiceType())
      tgt.addServiceType(new CodeableReference().setConcept(CodeableConcept30_50.convertCodeableConcept(t)));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getSpecialty())
      tgt.addSpecialty(CodeableConcept30_50.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getActor()) tgt.addActor(Reference30_50.convertReference(t));
    if (src.hasPlanningHorizon())
      tgt.setPlanningHorizon(Period30_50.convertPeriod(src.getPlanningHorizon()));
    if (src.hasComment())
      tgt.setCommentElement(String30_50.convertStringToMarkdown(src.getCommentElement()));
    return tgt;
  }
}