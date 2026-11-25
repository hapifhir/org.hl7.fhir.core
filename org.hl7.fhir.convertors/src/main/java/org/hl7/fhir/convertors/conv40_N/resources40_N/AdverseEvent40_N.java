package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.DateTime40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionDatatype40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionElements40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.AdverseEvent;
import org.hl7.fhir.model.core.CodeableReference;
import org.hl7.fhir.model.core.DateTimeType;
import org.hl7.fhir.model.core.Enumeration;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
  
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
*/

/**
 * R4 AdverseEvent <-> R6 AdverseEvent. R6 added a lot (mostly in R5), and dropped a few things:
 *
 *   status                               R6 only, and required: R4 to R6 defaults to unknown; anything but a plain unknown is a 5.0 extension in R4
 *   identifier (R4 0..1, R6 0..*)        first, the rest in 5.0 extensions
 *   event <-> code
 *   date <-> effectDateTime              an R6 effectPeriod is a 6.0 extension
 *   resultingCondition <-> resultingEffect   reference only CodeableReferences; the rest in 5.0 extensions
 *   outcome (R4 0..1, R6 0..*)           first, the rest in 5.0 extensions
 *   contributor <-> participant.actor    participants with more than an actor in 5.0 extensions
 *   subjectMedicalHistory <-> supportingInfo   reference only CodeableReferences; the rest in 5.0 extensions
 *   severity, referenceDocument          R6 dropped them: 4.0 extensions
 *   suspectEntity.instance               Reference <-> CodeableReference; if there's a concept, the whole thing in a 5.0 extension
 *   suspectEntity.causality (R4 0..*, R6 0..1)  first, the rest in 4.0 extensions
 *   causality.assessment <-> entityRelatedness, causality.method <-> assessmentMethod, productRelatedness 4.0 extension
 */
public class AdverseEvent40_N {

  private static final String[] V5 = {"expectedInResearchStudy", "contributingFactor", "preventiveAction", "mitigatingAction", "note"};
  private static final String[] V5_LISTS = {"identifier", "resultingEffect", "outcome", "participant", "supportingInfo"};
  private static final String[] R4_ONLY = {"severity", "referenceDocument"};

  public static org.hl7.fhir.model.core.AdverseEvent convertAdverseEvent(org.hl7.fhir.r4.model.AdverseEvent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.AdverseEvent tgt = new org.hl7.fhir.model.core.AdverseEvent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, CrossVersionElements40_N.urls("AdverseEvent", "5.0", V5,
      CrossVersionElements40_N.urls("AdverseEvent", "5.0", V5_LISTS, CrossVersionElements40_N.url("AdverseEvent", "6.0", "effect"), url("status"))));
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", V5);
    // R6 status is required, and R4 doesn't have one: unknown, unless the extension says otherwise
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "status");
    if (!tgt.hasStatus())
      tgt.setStatus(AdverseEvent.AdverseEventStatus.UNKNOWN);
    // R6 dropped these
    CrossVersionElements40_N.r4ElementsToExtensions(src, "AdverseEvent", tgt.getExtension(), R4_ONLY);
    if (src.hasIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(src.getIdentifier()));
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "identifier");
    if (src.hasActuality()) {
      tgt.setActualityElement(new Enumeration<>(new AdverseEvent.AdverseEventActualityEnumFactory()));
      CrossVersionElements40_N.copyCodeToR6(src.getActualityElement(), tgt.getActualityElement(), src.fhirType(), "actuality");
    }
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasEvent())
      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getEvent()));
    if (src.hasSubject())
      tgt.setSubject(Reference40_N.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_N.convertReference(src.getEncounter()));
    if (src.hasDate())
      tgt.setEffect(DateTime40_N.convertDateTime(src.getDateElement()));
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "6.0", "effect");
    if (src.hasDetected())
      tgt.setDetectedElement(DateTime40_N.convertDateTime(src.getDetectedElement()));
    if (src.hasRecordedDate())
      tgt.setRecordedDateElement(DateTime40_N.convertDateTime(src.getRecordedDateElement()));
    for (org.hl7.fhir.r4.model.Reference t : src.getResultingCondition())
      tgt.addResultingEffect(Reference40_N.convertReferenceToCodeableReference(t));
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "resultingEffect");
    if (src.hasLocation())
      tgt.setLocation(Reference40_N.convertReference(src.getLocation()));
    if (src.hasSeriousness())
      tgt.setSeriousness(CodeableConcept40_N.convertCodeableConcept(src.getSeriousness()));
    if (src.hasOutcome())
      tgt.addOutcome(CodeableConcept40_N.convertCodeableConcept(src.getOutcome()));
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "outcome");
    if (src.hasRecorder())
      tgt.setRecorder(Reference40_N.convertReference(src.getRecorder()));
    for (org.hl7.fhir.r4.model.Reference t : src.getContributor())
      tgt.addParticipant().setActor(Reference40_N.convertReference(t));
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "participant");
    for (org.hl7.fhir.r4.model.Reference t : src.getStudy())
      tgt.addStudy(Reference40_N.convertReference(t));
    for (org.hl7.fhir.r4.model.AdverseEvent.AdverseEventSuspectEntityComponent t : src.getSuspectEntity())
      tgt.addSuspectEntity(convertAdverseEventSuspectEntityComponent(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getSubjectMedicalHistory())
      tgt.addSupportingInfo(Reference40_N.convertReferenceToCodeableReference(t));
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "supportingInfo");
    return tgt;
  }

  public static org.hl7.fhir.r4.model.AdverseEvent convertAdverseEvent(org.hl7.fhir.model.core.AdverseEvent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.AdverseEvent tgt = new org.hl7.fhir.r4.model.AdverseEvent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, CrossVersionElements40_N.urls("AdverseEvent", "4.0", R4_ONLY));
    CrossVersionElements40_N.extensionsToR4Elements(src.getExtension(), tgt, "AdverseEvent", R4_ONLY);
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "5.0", V5);
    // unknown is the default, when there's no extension
    if (src.hasStatus() && (src.getStatus() != AdverseEvent.AdverseEventStatus.UNKNOWN || src.getStatusElement().hasExtension() || src.getStatusElement().hasId()))
      CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "5.0", "status");
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList()) {
      if (!tgt.hasIdentifier())
        tgt.setIdentifier(Identifier40_N.convertIdentifier(t));
      else
        tgt.addExtension(url("identifier"), Identifier40_N.convertIdentifier(t));
    }
    if (src.hasActuality()) {
      tgt.setActualityElement(new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.AdverseEvent.AdverseEventActualityEnumFactory()));
      CrossVersionElements40_N.copyCodeToR4(src.getActualityElement(), tgt.getActualityElement(), src.fhirType(), "actuality");
    }
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getCategoryList())
      tgt.addCategory(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasCode())
      tgt.setEvent(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    if (src.hasSubject())
      tgt.setSubject(Reference40_N.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_N.convertReference(src.getEncounter()));
    if (src.getEffect() instanceof DateTimeType)
      tgt.setDateElement(DateTime40_N.convertDateTime((DateTimeType) src.getEffect()));
    else if (src.hasEffect())
      tgt.addExtension(CrossVersionElements40_N.url("AdverseEvent", "6.0", "effect"), ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getEffect()));
    if (src.hasDetected())
      tgt.setDetectedElement(DateTime40_N.convertDateTime(src.getDetectedElement()));
    if (src.hasRecordedDate())
      tgt.setRecordedDateElement(DateTime40_N.convertDateTime(src.getRecordedDateElement()));
    for (CodeableReference t : src.getResultingEffectList()) {
      if (isReferenceOnly(t))
        tgt.addResultingCondition(Reference40_N.convertReference(t.getReference()));
      else
        tgt.addExtension(CrossVersionDatatype40_N.convertToExtension(url("resultingEffect"), t));
    }
    if (src.hasLocation())
      tgt.setLocation(Reference40_N.convertReference(src.getLocation()));
    if (src.hasSeriousness())
      tgt.setSeriousness(CodeableConcept40_N.convertCodeableConcept(src.getSeriousness()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getOutcomeList()) {
      if (!tgt.hasOutcome())
        tgt.setOutcome(CodeableConcept40_N.convertCodeableConcept(t));
      else
        tgt.addExtension(url("outcome"), CodeableConcept40_N.convertCodeableConcept(t));
    }
    if (src.hasRecorder())
      tgt.setRecorder(Reference40_N.convertReference(src.getRecorder()));
    for (AdverseEvent.AdverseEventParticipantComponent t : src.getParticipantList()) {
      if (t.hasActor() && !t.hasFunction() && !t.hasId() && !t.hasExtension() && !t.hasModifierExtension())
        tgt.addContributor(Reference40_N.convertReference(t.getActor()));
      else
        tgt.addExtension(CrossVersionDatatype40_N.convertToExtension(url("participant"), t));
    }
    for (org.hl7.fhir.model.core.Reference t : src.getStudyList())
      tgt.addStudy(Reference40_N.convertReference(t));
    for (AdverseEvent.AdverseEventSuspectEntityComponent t : src.getSuspectEntityList())
      tgt.addSuspectEntity(convertAdverseEventSuspectEntityComponent(t));
    for (CodeableReference t : src.getSupportingInfoList()) {
      if (isReferenceOnly(t))
        tgt.addSubjectMedicalHistory(Reference40_N.convertReference(t.getReference()));
      else
        tgt.addExtension(CrossVersionDatatype40_N.convertToExtension(url("supportingInfo"), t));
    }
    return tgt;
  }

  private static String url(String name) {
    return CrossVersionElements40_N.url("AdverseEvent", "5.0", name);
  }

  private static boolean isReferenceOnly(CodeableReference t) {
    return t.hasReference() && !t.hasConcept() && !t.hasId() && !t.hasExtension();
  }

  public static org.hl7.fhir.model.core.AdverseEvent.AdverseEventSuspectEntityComponent convertAdverseEventSuspectEntityComponent(org.hl7.fhir.r4.model.AdverseEvent.AdverseEventSuspectEntityComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.AdverseEvent.AdverseEventSuspectEntityComponent tgt = new org.hl7.fhir.model.core.AdverseEvent.AdverseEventSuspectEntityComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt,
      CrossVersionElements40_N.url("AdverseEvent.suspectEntity", "5.0", "instance"), CrossVersionElements40_N.url("AdverseEvent.suspectEntity", "6.0", "occurrence"));
    // the whole instance, if there was more than a reference
    CrossVersionElements40_N.extensionsToElementsForPath(src.getExtension(), tgt, "AdverseEvent.suspectEntity", "5.0", "instance");
    if (!tgt.hasInstance() && src.hasInstance())
      tgt.setInstance(Reference40_N.convertReferenceToCodeableReference(src.getInstance()));
    CrossVersionElements40_N.extensionsToElementsForPath(src.getExtension(), tgt, "AdverseEvent.suspectEntity", "6.0", "occurrence");
    // R6 has a single causality
    if (src.hasCausality())
      tgt.setCausality(convertAdverseEventSuspectEntityCausalityComponent(src.getCausalityFirstRep()));
    for (int i = 1; i < src.getCausality().size(); i++)
      tgt.addExtension(CrossVersionDatatype40_N.convertR4ElementToExtension(CrossVersionElements40_N.url("AdverseEvent.suspectEntity", "4.0", "causality"), src.getCausality().get(i)));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.AdverseEvent.AdverseEventSuspectEntityComponent convertAdverseEventSuspectEntityComponent(org.hl7.fhir.model.core.AdverseEvent.AdverseEventSuspectEntityComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.AdverseEvent.AdverseEventSuspectEntityComponent tgt = new org.hl7.fhir.r4.model.AdverseEvent.AdverseEventSuspectEntityComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, CrossVersionElements40_N.url("AdverseEvent.suspectEntity", "4.0", "causality"));
    // R4 instance is only a Reference
    if (src.hasInstance()) {
      if (src.getInstance().hasReference())
        tgt.setInstance(Reference40_N.convertReference(src.getInstance().getReference()));
      if (!isReferenceOnly(src.getInstance()))
        tgt.addExtension(CrossVersionDatatype40_N.convertToExtension(CrossVersionElements40_N.url("AdverseEvent.suspectEntity", "5.0", "instance"), src.getInstance()));
    }
    CrossVersionElements40_N.elementsToExtensionsForPath(src, "AdverseEvent.suspectEntity", tgt.getExtension(), "6.0", "occurrence");
    if (src.hasCausality())
      tgt.addCausality(convertAdverseEventSuspectEntityCausalityComponent(src.getCausality()));
    CrossVersionElements40_N.extensionsToR4Elements(src.getExtension(), tgt, "AdverseEvent.suspectEntity", "causality");
    return tgt;
  }

  public static org.hl7.fhir.model.core.AdverseEvent.AdverseEventSuspectEntityCausalityComponent convertAdverseEventSuspectEntityCausalityComponent(org.hl7.fhir.r4.model.AdverseEvent.AdverseEventSuspectEntityCausalityComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.AdverseEvent.AdverseEventSuspectEntityCausalityComponent tgt = new org.hl7.fhir.model.core.AdverseEvent.AdverseEventSuspectEntityCausalityComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    // R6 dropped productRelatedness
    CrossVersionElements40_N.r4ElementsToExtensions(src, "AdverseEvent.suspectEntity.causality", tgt.getExtension(), "productRelatedness");
    if (src.hasAssessment())
      tgt.setEntityRelatedness(CodeableConcept40_N.convertCodeableConcept(src.getAssessment()));
    if (src.hasMethod())
      tgt.setAssessmentMethod(CodeableConcept40_N.convertCodeableConcept(src.getMethod()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference40_N.convertReference(src.getAuthor()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.AdverseEvent.AdverseEventSuspectEntityCausalityComponent convertAdverseEventSuspectEntityCausalityComponent(org.hl7.fhir.model.core.AdverseEvent.AdverseEventSuspectEntityCausalityComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.AdverseEvent.AdverseEventSuspectEntityCausalityComponent tgt = new org.hl7.fhir.r4.model.AdverseEvent.AdverseEventSuspectEntityCausalityComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, CrossVersionElements40_N.url("AdverseEvent.suspectEntity.causality", "4.0", "productRelatedness"));
    CrossVersionElements40_N.extensionsToR4Elements(src.getExtension(), tgt, "AdverseEvent.suspectEntity.causality", "productRelatedness");
    if (src.hasEntityRelatedness())
      tgt.setAssessment(CodeableConcept40_N.convertCodeableConcept(src.getEntityRelatedness()));
    if (src.hasAssessmentMethod())
      tgt.setMethod(CodeableConcept40_N.convertCodeableConcept(src.getAssessmentMethod()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference40_N.convertReference(src.getAuthor()));
    return tgt;
  }
}
