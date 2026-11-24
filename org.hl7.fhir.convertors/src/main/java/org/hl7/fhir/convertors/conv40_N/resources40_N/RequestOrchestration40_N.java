package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Annotation40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N.Expression40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N.RelatedArtifact40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Canonical40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.DateTime40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Id40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.MarkDown40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Uri40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionDatatype40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionElements40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.RequestOrchestration;
import org.hl7.fhir.r4.model.RequestGroup;

/**
 * R4 RequestGroup <-> R6 RequestOrchestration (renamed in R5).
 *
 * Elements R6 added are carried in R4 as cross-version extensions. R4 action.participant is a Reference;
 * R6 action.participant is a backbone element. A participant that is just an actor reference goes to the
 * R4 Reference; anything more goes, whole, into a 5.0 participant extension on the action.
 */
public class RequestOrchestration40_N {

  private static final String RO = "RequestOrchestration";
  private static final String ACTION = "RequestOrchestration.action";
  private static final String RELATED = "RequestOrchestration.action.relatedAction";
  private static final String[] RO_V5 = {"goal"};
  private static final String[] ACTION_V5 = {"linkId", "goal", "input", "output", "location", "definition", "transform", "dynamicValue"};
  private static final String[] ACTION_V6 = {"applicabilityBehavior"};
  private static final String[] RELATED_V5 = {"endRelationship"};
  private static final String PARTICIPANT_URL = CrossVersionElements40_N.url(ACTION, "5.0", "participant");

  public static RequestOrchestration convertRequestOrchestration(RequestGroup src) throws FHIRException {
    if (src == null)
      return null;
    RequestOrchestration tgt = new RequestOrchestration();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, CrossVersionElements40_N.urls(RO, "5.0", RO_V5));
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", RO_V5);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getInstantiatesCanonical())
      tgt.getInstantiatesCanonicalList().add(Canonical40_N.convertCanonical(t));
    for (org.hl7.fhir.r4.model.UriType t : src.getInstantiatesUri())
      tgt.getInstantiatesUriList().add(Uri40_N.convertUri(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn())
      tgt.addBasedOn(Reference40_N.convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getReplaces())
      tgt.addReplaces(Reference40_N.convertReference(t));
    if (src.hasGroupIdentifier())
      tgt.setGroupIdentifier(Identifier40_N.convertIdentifier(src.getGroupIdentifier()));
    if (src.hasStatus())
      toR6(src.getStatusElement(), tgt.getStatusElement(), src.fhirType(), "status");
    if (src.hasIntent())
      toR6(src.getIntentElement(), tgt.getIntentElement(), src.fhirType(), "intent");
    if (src.hasPriority())
      toR6(src.getPriorityElement(), tgt.getPriorityElement(), src.fhirType(), "priority");
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    if (src.hasSubject())
      tgt.setSubject(Reference40_N.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_N.convertReference(src.getEncounter()));
    if (src.hasAuthoredOn())
      tgt.setAuthoredOnElement(DateTime40_N.convertDateTime(src.getAuthoredOnElement()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference40_N.convertReference(src.getAuthor()));
    CodeableConcept40_N.convertReasonsToR6(src.getReasonCode(), src.getReasonReference(), tgt.getReasonList());
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote())
      tgt.addNote(Annotation40_N.convertAnnotation(t));
    for (RequestGroup.RequestGroupActionComponent t : src.getAction())
      tgt.addAction(convertAction(t));
    return tgt;
  }

  public static RequestGroup convertRequestOrchestration(RequestOrchestration src) throws FHIRException {
    if (src == null)
      return null;
    RequestGroup tgt = new RequestGroup();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "5.0", RO_V5);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    for (org.hl7.fhir.model.core.CanonicalType t : src.getInstantiatesCanonicalList())
      tgt.getInstantiatesCanonical().add(Canonical40_N.convertCanonical(t));
    for (org.hl7.fhir.model.core.UriType t : src.getInstantiatesUriList())
      tgt.getInstantiatesUri().add(Uri40_N.convertUri(t));
    for (org.hl7.fhir.model.core.Reference t : src.getBasedOnList())
      tgt.addBasedOn(Reference40_N.convertReference(t));
    for (org.hl7.fhir.model.core.Reference t : src.getReplacesList())
      tgt.addReplaces(Reference40_N.convertReference(t));
    if (src.hasGroupIdentifier())
      tgt.setGroupIdentifier(Identifier40_N.convertIdentifier(src.getGroupIdentifier()));
    if (src.hasStatus())
      toR4(src.getStatusElement(), tgt.getStatusElement(), src.fhirType(), "status");
    if (src.hasIntent())
      toR4(src.getIntentElement(), tgt.getIntentElement(), src.fhirType(), "intent");
    if (src.hasPriority())
      toR4(src.getPriorityElement(), tgt.getPriorityElement(), src.fhirType(), "priority");
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    if (src.hasSubject())
      tgt.setSubject(Reference40_N.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_N.convertReference(src.getEncounter()));
    if (src.hasAuthoredOn())
      tgt.setAuthoredOnElement(DateTime40_N.convertDateTime(src.getAuthoredOnElement()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference40_N.convertReference(src.getAuthor()));
    CodeableConcept40_N.convertReasonsToR4(src.getReasonList(), tgt.getReasonCode(), tgt.getReasonReference());
    for (org.hl7.fhir.model.core.Annotation t : src.getNoteList())
      tgt.addNote(Annotation40_N.convertAnnotation(t));
    for (RequestOrchestration.RequestOrchestrationActionComponent t : src.getActionList())
      tgt.addAction(convertAction(t));
    return tgt;
  }

  public static RequestOrchestration.RequestOrchestrationActionComponent convertAction(RequestGroup.RequestGroupActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    RequestOrchestration.RequestOrchestrationActionComponent tgt = new RequestOrchestration.RequestOrchestrationActionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt,
      CrossVersionElements40_N.urls(ACTION, "5.0", ACTION_V5, CrossVersionElements40_N.urls(ACTION, "6.0", ACTION_V6, PARTICIPANT_URL)));
    CrossVersionElements40_N.extensionsToElementsForPath(src.getExtension(), tgt, ACTION, "5.0", ACTION_V5);
    CrossVersionElements40_N.extensionsToElementsForPath(src.getExtension(), tgt, ACTION, "6.0", ACTION_V6);
    if (src.hasPrefix())
      tgt.setPrefixElement(String40_N.convertString(src.getPrefixElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String40_N.convertString(src.getTitleElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_N.convertStringToMarkdown(src.getDescriptionElement()));
    if (src.hasTextEquivalent())
      tgt.setTextEquivalentElement(MarkDown40_N.convertStringToMarkdown(src.getTextEquivalentElement()));
    if (src.hasPriority())
      toR6(src.getPriorityElement(), tgt.getPriorityElement(), src.fhirType(), "priority");
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCode())
      tgt.addCode(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.RelatedArtifact t : src.getDocumentation())
      tgt.addDocumentation(RelatedArtifact40_N.convertRelatedArtifact(t));
    for (RequestGroup.RequestGroupActionConditionComponent t : src.getCondition()) {
      RequestOrchestration.RequestOrchestrationActionConditionComponent c = tgt.addCondition();
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(t, c);
      if (t.hasKind())
        toR6(t.getKindElement(), c.getKindElement(), t.fhirType(), "kind");
      if (t.hasExpression())
        c.setExpression(Expression40_N.convertExpression(t.getExpression()));
    }
    for (RequestGroup.RequestGroupActionRelatedActionComponent t : src.getRelatedAction())
      tgt.addRelatedAction(convertRelatedAction(t));
    if (src.hasTiming())
      tgt.setTiming(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getTiming()));
    for (org.hl7.fhir.r4.model.Reference t : src.getParticipant())
      tgt.addParticipant().setActor(Reference40_N.convertReference(t));
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtension())
      if (PARTICIPANT_URL.equals(ext.getUrl()))
        CrossVersionDatatype40_N.populateDatatype(ext, tgt.addParticipant());
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasGroupingBehavior())
      toR6(src.getGroupingBehaviorElement(), tgt.getGroupingBehaviorElement(), src.fhirType(), "groupingBehavior");
    if (src.hasSelectionBehavior())
      toR6(src.getSelectionBehaviorElement(), tgt.getSelectionBehaviorElement(), src.fhirType(), "selectionBehavior");
    if (src.hasRequiredBehavior())
      toR6(src.getRequiredBehaviorElement(), tgt.getRequiredBehaviorElement(), src.fhirType(), "requiredBehavior");
    if (src.hasPrecheckBehavior())
      toR6(src.getPrecheckBehaviorElement(), tgt.getPrecheckBehaviorElement(), src.fhirType(), "precheckBehavior");
    if (src.hasCardinalityBehavior())
      toR6(src.getCardinalityBehaviorElement(), tgt.getCardinalityBehaviorElement(), src.fhirType(), "cardinalityBehavior");
    if (src.hasResource())
      tgt.setResource(Reference40_N.convertReference(src.getResource()));
    for (RequestGroup.RequestGroupActionComponent t : src.getAction())
      tgt.addAction(convertAction(t));
    return tgt;
  }

  public static RequestGroup.RequestGroupActionComponent convertAction(RequestOrchestration.RequestOrchestrationActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    RequestGroup.RequestGroupActionComponent tgt = new RequestGroup.RequestGroupActionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    CrossVersionElements40_N.elementsToExtensionsForPath(src, ACTION, tgt.getExtension(), "5.0", ACTION_V5);
    CrossVersionElements40_N.elementsToExtensionsForPath(src, ACTION, tgt.getExtension(), "6.0", ACTION_V6);
    if (src.hasPrefix())
      tgt.setPrefixElement(String40_N.convertString(src.getPrefixElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String40_N.convertString(src.getTitleElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(markdownToString(src.getDescriptionElement()));
    if (src.hasTextEquivalent())
      tgt.setTextEquivalentElement(markdownToString(src.getTextEquivalentElement()));
    if (src.hasPriority())
      toR4(src.getPriorityElement(), tgt.getPriorityElement(), src.fhirType(), "priority");
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getCodeList())
      tgt.addCode(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.RelatedArtifact t : src.getDocumentationList())
      tgt.addDocumentation(RelatedArtifact40_N.convertRelatedArtifact(t));
    for (RequestOrchestration.RequestOrchestrationActionConditionComponent t : src.getConditionList()) {
      RequestGroup.RequestGroupActionConditionComponent c = tgt.addCondition();
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(t, c);
      if (t.hasKind())
        toR4(t.getKindElement(), c.getKindElement(), t.fhirType(), "kind");
      if (t.hasExpression())
        c.setExpression(Expression40_N.convertExpression(t.getExpression()));
    }
    for (RequestOrchestration.RequestOrchestrationActionRelatedActionComponent t : src.getRelatedActionList())
      tgt.addRelatedAction(convertRelatedAction(t));
    if (src.hasTiming())
      tgt.setTiming(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getTiming()));
    for (RequestOrchestration.RequestOrchestrationActionParticipantComponent t : src.getParticipantList()) {
      if (isJustAnActorReference(t))
        tgt.addParticipant(Reference40_N.convertReference(t.getActorReference()));
      else
        tgt.addExtension(CrossVersionDatatype40_N.convertToExtension(PARTICIPANT_URL, t));
    }
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasGroupingBehavior())
      toR4(src.getGroupingBehaviorElement(), tgt.getGroupingBehaviorElement(), src.fhirType(), "groupingBehavior");
    if (src.hasSelectionBehavior())
      toR4(src.getSelectionBehaviorElement(), tgt.getSelectionBehaviorElement(), src.fhirType(), "selectionBehavior");
    if (src.hasRequiredBehavior())
      toR4(src.getRequiredBehaviorElement(), tgt.getRequiredBehaviorElement(), src.fhirType(), "requiredBehavior");
    if (src.hasPrecheckBehavior())
      toR4(src.getPrecheckBehaviorElement(), tgt.getPrecheckBehaviorElement(), src.fhirType(), "precheckBehavior");
    if (src.hasCardinalityBehavior())
      toR4(src.getCardinalityBehaviorElement(), tgt.getCardinalityBehaviorElement(), src.fhirType(), "cardinalityBehavior");
    if (src.hasResource())
      tgt.setResource(Reference40_N.convertReference(src.getResource()));
    for (RequestOrchestration.RequestOrchestrationActionComponent t : src.getActionList())
      tgt.addAction(convertAction(t));
    return tgt;
  }

  private static boolean isJustAnActorReference(RequestOrchestration.RequestOrchestrationActionParticipantComponent p) {
    return p.hasActor() && p.getActor() instanceof org.hl7.fhir.model.core.Reference && !p.hasId() && !p.hasExtension() && !p.hasModifierExtension()
      && !p.hasType() && !p.hasTypeCanonical() && !p.hasTypeReference() && !p.hasRole() && !p.hasFunction();
  }

  public static RequestOrchestration.RequestOrchestrationActionRelatedActionComponent convertRelatedAction(RequestGroup.RequestGroupActionRelatedActionComponent src) throws FHIRException {
    RequestOrchestration.RequestOrchestrationActionRelatedActionComponent tgt = new RequestOrchestration.RequestOrchestrationActionRelatedActionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, CrossVersionElements40_N.urls(RELATED, "5.0", RELATED_V5));
    CrossVersionElements40_N.extensionsToElementsForPath(src.getExtension(), tgt, RELATED, "5.0", RELATED_V5);
    if (src.hasActionId())
      tgt.setTargetIdElement(Id40_N.convertId(src.getActionIdElement()));
    if (src.hasRelationship())
      toR6(src.getRelationshipElement(), tgt.getRelationshipElement(), src.fhirType(), "relationship");
    if (src.hasOffset())
      tgt.setOffset(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getOffset()));
    return tgt;
  }

  public static RequestGroup.RequestGroupActionRelatedActionComponent convertRelatedAction(RequestOrchestration.RequestOrchestrationActionRelatedActionComponent src) throws FHIRException {
    RequestGroup.RequestGroupActionRelatedActionComponent tgt = new RequestGroup.RequestGroupActionRelatedActionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    CrossVersionElements40_N.elementsToExtensionsForPath(src, RELATED, tgt.getExtension(), "5.0", RELATED_V5);
    if (src.hasTargetId())
      tgt.setActionIdElement(Id40_N.convertId(src.getTargetIdElement()));
    if (src.hasRelationship())
      toR4(src.getRelationshipElement(), tgt.getRelationshipElement(), src.fhirType(), "relationship");
    if (src.hasOffset())
      tgt.setOffset(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getOffset()));
    return tgt;
  }

  private static org.hl7.fhir.r4.model.StringType markdownToString(org.hl7.fhir.model.core.MarkdownType src) throws FHIRException {
    org.hl7.fhir.r4.model.StringType tgt = new org.hl7.fhir.r4.model.StringType(src.getValue());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }

  // the code lists are the same in R4 and R6 (R6 added some relationship types - those can't go to R4)
  private static void toR6(org.hl7.fhir.r4.model.Enumeration<?> src, org.hl7.fhir.model.core.Enumeration<?> tgt, String path, String name) throws FHIRException {
    CrossVersionElements40_N.copyCodeToR6(src, tgt, path.replace("RequestGroup", "RequestOrchestration"), name);
  }

  private static void toR4(org.hl7.fhir.model.core.Enumeration<?> src, org.hl7.fhir.r4.model.Enumeration<?> tgt, String path, String name) throws FHIRException {
    CrossVersionElements40_N.copyCodeToR4(src, tgt, path, name);
  }
}
