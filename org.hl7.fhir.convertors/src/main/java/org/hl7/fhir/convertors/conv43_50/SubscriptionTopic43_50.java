package org.hl7.fhir.convertors.conv43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Period43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.metadata43_50.ContactDetail43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.metadata43_50.UsageContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.*;
import org.hl7.fhir.convertors.conv43_50.resources43_50.Enumerations43_50;
import org.hl7.fhir.r4b.model.Enumeration;
import org.hl7.fhir.r4b.model.Resource;



import java.util.ArrayList;
import java.util.List;

public class SubscriptionTopic43_50 {
  public static org.hl7.fhir.r4b.model.SubscriptionTopic convertSubscriptionTopic(org.hl7.fhir.r5.model.SubscriptionTopic src) {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.SubscriptionTopic tgt = new org.hl7.fhir.r4b.model.SubscriptionTopic();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri43_50.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasTitle())
      tgt.setTitleElement(String43_50.convertString(src.getTitleElement()));
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getDerivedFrom())
      tgt.getDerivedFrom().add(Canonical43_50.convertCanonical(t));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations43_50.convertPublicationStatus(src.getStatusElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String43_50.convertString(src.getVersionElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String43_50.convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations43_50.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean43_50.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime43_50.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String43_50.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail43_50.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown43_50.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext43_50.convertUsageContext(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown43_50.convertMarkdown(src.getPurposeElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown43_50.convertMarkdown(src.getCopyrightElement()));
    if (src.hasApprovalDate())
      tgt.setApprovalDateElement(Date43_50.convertDate(src.getApprovalDateElement()));
    if (src.hasLastReviewDate())
      tgt.setLastReviewDateElement(Date43_50.convertDate(src.getLastReviewDateElement()));
    if (src.hasEffectivePeriod())
      tgt.setEffectivePeriod(Period43_50.convertPeriod(src.getEffectivePeriod()));
    for(org.hl7.fhir.r5.model.SubscriptionTopic.SubscriptionTopicResourceTriggerComponent triggerComponent : src.getResourceTrigger()) {
     tgt.addResourceTrigger(convertResourceTrigger(triggerComponent));}
    return tgt;
  }

  private static org.hl7.fhir.r4b.model.SubscriptionTopic.SubscriptionTopicResourceTriggerComponent convertResourceTrigger(org.hl7.fhir.r5.model.SubscriptionTopic.SubscriptionTopicResourceTriggerComponent src) {
    org.hl7.fhir.r4b.model.SubscriptionTopic.SubscriptionTopicResourceTriggerComponent tgt = new org.hl7.fhir.r4b.model.SubscriptionTopic.SubscriptionTopicResourceTriggerComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
  if (src.hasDescription()) {
    tgt.setDescriptionElement(MarkDown43_50.convertMarkdown(src.getDescriptionElement()));
  }
    if (src.hasResource()) {
      tgt.setResource(src.getResource());
    }
    if (src.hasSupportedInteraction()) {
      for (org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SubscriptionTopic.InteractionTrigger> srcItem : src.getSupportedInteraction()) {
        tgt.addSupportedInteraction(convertInteractionTrigger(srcItem.getValue()));
      }
    }
    if (src.hasQueryCriteria()) {
      tgt.setQueryCriteria(convertResourceTriggerQueryCriteriaComponent(src.getQueryCriteria()));
    }
    if (src.hasFhirPathCriteria()) {
      tgt.setFhirPathCriteriaElement(String43_50.convertString(src.getFhirPathCriteriaElement()));
    }
    return tgt;
  }

  private static org.hl7.fhir.r4b.model.SubscriptionTopic.SubscriptionTopicResourceTriggerQueryCriteriaComponent convertResourceTriggerQueryCriteriaComponent(org.hl7.fhir.r5.model.SubscriptionTopic.SubscriptionTopicResourceTriggerQueryCriteriaComponent src) {
    org.hl7.fhir.r4b.model.SubscriptionTopic.SubscriptionTopicResourceTriggerQueryCriteriaComponent tgt = new org.hl7.fhir.r4b.model.SubscriptionTopic.SubscriptionTopicResourceTriggerQueryCriteriaComponent();
    if (src.hasPrevious()) {
      tgt.setPreviousElement(String43_50.convertString(src.getPreviousElement()));
    }
    if (src.hasCurrent()) {
      tgt.setCurrentElement(String43_50.convertString(src.getCurrentElement()));
    }
    return tgt;
  }

  private static org.hl7.fhir.r4b.model.SubscriptionTopic.InteractionTrigger convertInteractionTrigger(org.hl7.fhir.r5.model.SubscriptionTopic.InteractionTrigger value) {
    switch(value) {
      case CREATE : return org.hl7.fhir.r4b.model.SubscriptionTopic.InteractionTrigger.CREATE;
      case UPDATE: return org.hl7.fhir.r4b.model.SubscriptionTopic.InteractionTrigger.UPDATE;
      case DELETE: return org.hl7.fhir.r4b.model.SubscriptionTopic.InteractionTrigger.DELETE;
      case NULL: return org.hl7.fhir.r4b.model.SubscriptionTopic.InteractionTrigger.NULL;
    }
    return null;
  }



  public static org.hl7.fhir.r5.model.SubscriptionTopic convertSubscriptionTopic(org.hl7.fhir.r4b.model.SubscriptionTopic src) {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.SubscriptionTopic tgt = new org.hl7.fhir.r5.model.SubscriptionTopic();
    return tgt;
  }
}
