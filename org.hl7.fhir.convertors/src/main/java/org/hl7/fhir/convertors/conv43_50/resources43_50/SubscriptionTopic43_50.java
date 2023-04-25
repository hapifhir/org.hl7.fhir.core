package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Period43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.metadata43_50.ContactDetail43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.metadata43_50.UsageContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SubscriptionTopic43_50 {
  public static org.hl7.fhir.r4b.model.SubscriptionTopic convertSubscriptionTopic(org.hl7.fhir.r5.model.SubscriptionTopic src) {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.SubscriptionTopic tgt = new org.hl7.fhir.r4b.model.SubscriptionTopic();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyResource(src, tgt);
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
    for (org.hl7.fhir.r5.model.SubscriptionTopic.SubscriptionTopicCanFilterByComponent canFilterByComponent : src.getCanFilterBy()) {
      tgt.addCanFilterBy(convertCanFilterBy(canFilterByComponent));
    }
    for (org.hl7.fhir.r5.model.SubscriptionTopic.SubscriptionTopicNotificationShapeComponent notificationShape : src.getNotificationShape()) {
      tgt.addNotificationShape(convertNotificationShape(notificationShape));
    }
    return tgt;
  }

  private static org.hl7.fhir.r4b.model.SubscriptionTopic.SubscriptionTopicNotificationShapeComponent convertNotificationShape(org.hl7.fhir.r5.model.SubscriptionTopic.SubscriptionTopicNotificationShapeComponent src) {
    org.hl7.fhir.r4b.model.SubscriptionTopic.SubscriptionTopicNotificationShapeComponent tgt = new org.hl7.fhir.r4b.model.SubscriptionTopic.SubscriptionTopicNotificationShapeComponent();
    if (src.hasResource()) {
      tgt.setResourceElement(Uri43_50.convertUri(src.getResourceElement()));
    }
    if (src.hasInclude()) {
      tgt.setInclude(src.getInclude().stream().map(String43_50::convertString).collect(Collectors.toList()));
    }
    return tgt;
  }

  private static org.hl7.fhir.r4b.model.SubscriptionTopic.SubscriptionTopicCanFilterByComponent convertCanFilterBy(org.hl7.fhir.r5.model.SubscriptionTopic.SubscriptionTopicCanFilterByComponent src) {
    org.hl7.fhir.r4b.model.SubscriptionTopic.SubscriptionTopicCanFilterByComponent tgt = new org.hl7.fhir.r4b.model.SubscriptionTopic.SubscriptionTopicCanFilterByComponent();
    if (src.hasDescription()) {
      tgt.setDescriptionElement(MarkDown43_50.convertMarkdown(src.getDescriptionElement()));
    }
    if (src.hasResource()) {
      tgt.setResourceElement(Uri43_50.convertUri(src.getResourceElement()));
    }
    if (src.hasFilterParameter()) {
      tgt.setFilterParameterElement(String43_50.convertString(src.getFilterParameterElement()));
    }
    if (src.hasModifier() || src.hasComparator()) {
      List<org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.SubscriptionTopic.SubscriptionSearchModifier>> tgtModifiers = convertR5ModifierToR4BModifier(src.getModifier());

      List<org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.SubscriptionTopic.SubscriptionSearchModifier>> tgtComparatorModifiers = convertR5ComparatorToR4BModifier(src.getComparator());

      tgt.setModifier(Stream.concat(tgtModifiers.stream(), tgtComparatorModifiers.stream())
        .collect(Collectors.toList()));
    }

    return tgt;
  }

  private static List<org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.SubscriptionTopic.SubscriptionSearchModifier>> convertR5ComparatorToR4BModifier(List<org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.SearchComparator>> srcList) {
    return srcList.stream().map(SubscriptionTopic43_50::convertR5ComparatorToR4BModifier).filter(x -> x != null).collect(Collectors.toList());
  }

  private static org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.SubscriptionTopic.SubscriptionSearchModifier> convertR5ComparatorToR4BModifier(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.SearchComparator> src){
    org.hl7.fhir.r4b.model.SubscriptionTopic.SubscriptionSearchModifierEnumFactory enumFactory = new org.hl7.fhir.r4b.model.SubscriptionTopic.SubscriptionSearchModifierEnumFactory();
    switch(src.getValue()) {
      case NULL: return new org.hl7.fhir.r4b.model.Enumeration<>(enumFactory, org.hl7.fhir.r4b.model.SubscriptionTopic.SubscriptionSearchModifier.NULL);
      case EQ: return new org.hl7.fhir.r4b.model.Enumeration<>(enumFactory, org.hl7.fhir.r4b.model.SubscriptionTopic.SubscriptionSearchModifier.EQ);
      case NE: return new org.hl7.fhir.r4b.model.Enumeration<>(enumFactory, org.hl7.fhir.r4b.model.SubscriptionTopic.SubscriptionSearchModifier.NE);
      case GT: return new org.hl7.fhir.r4b.model.Enumeration<>(enumFactory, org.hl7.fhir.r4b.model.SubscriptionTopic.SubscriptionSearchModifier.GT);
      case LT: return new org.hl7.fhir.r4b.model.Enumeration<>(enumFactory, org.hl7.fhir.r4b.model.SubscriptionTopic.SubscriptionSearchModifier.LT);
      case GE: return new org.hl7.fhir.r4b.model.Enumeration<>(enumFactory, org.hl7.fhir.r4b.model.SubscriptionTopic.SubscriptionSearchModifier.GE);
      case LE: return new org.hl7.fhir.r4b.model.Enumeration<>(enumFactory, org.hl7.fhir.r4b.model.SubscriptionTopic.SubscriptionSearchModifier.LE);
      case SA: return new org.hl7.fhir.r4b.model.Enumeration<>(enumFactory, org.hl7.fhir.r4b.model.SubscriptionTopic.SubscriptionSearchModifier.SA);
      case EB: return new org.hl7.fhir.r4b.model.Enumeration<>(enumFactory, org.hl7.fhir.r4b.model.SubscriptionTopic.SubscriptionSearchModifier.EB);
      case AP: return new org.hl7.fhir.r4b.model.Enumeration<>(enumFactory, org.hl7.fhir.r4b.model.SubscriptionTopic.SubscriptionSearchModifier.AP);
    }
    return null;
  }

  private static List<org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.SubscriptionTopic.SubscriptionSearchModifier>> convertR5ModifierToR4BModifier(List<org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.SearchModifierCode>> srcList) {
    return srcList.stream().map(SubscriptionTopic43_50::convertR5ModifierToR4BModifier).filter(x -> x != null).collect(Collectors.toList());
  }

  private static org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.SubscriptionTopic.SubscriptionSearchModifier> convertR5ModifierToR4BModifier(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.SearchModifierCode> src){
    org.hl7.fhir.r4b.model.SubscriptionTopic.SubscriptionSearchModifierEnumFactory enumFactory = new org.hl7.fhir.r4b.model.SubscriptionTopic.SubscriptionSearchModifierEnumFactory();
    switch(src.getValue()) {
      case NULL: return new org.hl7.fhir.r4b.model.Enumeration<>(enumFactory, org.hl7.fhir.r4b.model.SubscriptionTopic.SubscriptionSearchModifier.NULL);
      case IN: return new org.hl7.fhir.r4b.model.Enumeration<>(enumFactory, org.hl7.fhir.r4b.model.SubscriptionTopic.SubscriptionSearchModifier.IN);
      case NOTIN: return new org.hl7.fhir.r4b.model.Enumeration<>(enumFactory, org.hl7.fhir.r4b.model.SubscriptionTopic.SubscriptionSearchModifier.NOTIN);
      case BELOW: return new org.hl7.fhir.r4b.model.Enumeration<>(enumFactory, org.hl7.fhir.r4b.model.SubscriptionTopic.SubscriptionSearchModifier.BELOW);
      case ABOVE: return new org.hl7.fhir.r4b.model.Enumeration<>(enumFactory, org.hl7.fhir.r4b.model.SubscriptionTopic.SubscriptionSearchModifier.ABOVE);
      case OFTYPE: return new org.hl7.fhir.r4b.model.Enumeration<>(enumFactory, org.hl7.fhir.r4b.model.SubscriptionTopic.SubscriptionSearchModifier.OFTYPE);
    }
    return null;
  }
  private static org.hl7.fhir.r4b.model.SubscriptionTopic.SubscriptionTopicResourceTriggerComponent convertResourceTrigger(org.hl7.fhir.r5.model.SubscriptionTopic.SubscriptionTopicResourceTriggerComponent src) {
    org.hl7.fhir.r4b.model.SubscriptionTopic.SubscriptionTopicResourceTriggerComponent tgt = new org.hl7.fhir.r4b.model.SubscriptionTopic.SubscriptionTopicResourceTriggerComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
  if (src.hasDescription()) {
    tgt.setDescriptionElement(MarkDown43_50.convertMarkdown(src.getDescriptionElement()));
  }
    if (src.hasResource()) {
      tgt.setResourceElement(Uri43_50.convertUri(src.getResourceElement()));
    }
    if (src.hasSupportedInteraction()) {
      for (org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SubscriptionTopic.InteractionTrigger> srcItem : src.getSupportedInteraction()) {
        org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.SubscriptionTopic.InteractionTrigger> newElement = tgt.addSupportedInteractionElement();
        newElement.setValue(convertInteractionTrigger(srcItem.getValue()));
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
    if (src.hasResultForCreate()) {
      tgt.setResultForCreateElement(convertCriteriaNotExistsBehavior(src.getResultForCreateElement()));
    }
    if (src.hasCurrent()) {
      tgt.setCurrentElement(String43_50.convertString(src.getCurrentElement()));
    }
    if (src.hasResultForDelete()) {
      tgt.setResultForDeleteElement(convertCriteriaNotExistsBehavior(src.getResultForDeleteElement()));
    }
    if (src.hasRequireBoth()) {
      tgt.setRequireBothElement(Boolean43_50.convertBoolean(src.getRequireBothElement()));
    }
    return tgt;
  }

  private static org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.SubscriptionTopic.CriteriaNotExistsBehavior> convertCriteriaNotExistsBehavior(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SubscriptionTopic.CriteriaNotExistsBehavior> src) {
    org.hl7.fhir.r4b.model.SubscriptionTopic.CriteriaNotExistsBehaviorEnumFactory enumFactory = new org.hl7.fhir.r4b.model.SubscriptionTopic.CriteriaNotExistsBehaviorEnumFactory();
    switch(src.getValue()) {
      case TESTFAILS: return new org.hl7.fhir.r4b.model.Enumeration<>(enumFactory, org.hl7.fhir.r4b.model.SubscriptionTopic.CriteriaNotExistsBehavior.TESTFAILS);
      case TESTPASSES: return new org.hl7.fhir.r4b.model.Enumeration<>(enumFactory, org.hl7.fhir.r4b.model.SubscriptionTopic.CriteriaNotExistsBehavior.TESTPASSES);
      case NULL: return new org.hl7.fhir.r4b.model.Enumeration<>(enumFactory, org.hl7.fhir.r4b.model.SubscriptionTopic.CriteriaNotExistsBehavior.NULL);
    }
    return null;
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
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyResource(src, tgt);
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri43_50.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasTitle())
      tgt.setTitleElement(String43_50.convertString(src.getTitleElement()));
    for (org.hl7.fhir.r4b.model.CanonicalType t : src.getDerivedFrom())
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
    for (org.hl7.fhir.r4b.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail43_50.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown43_50.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r4b.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext43_50.convertUsageContext(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getJurisdiction())
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
    for(org.hl7.fhir.r4b.model.SubscriptionTopic.SubscriptionTopicResourceTriggerComponent triggerComponent : src.getResourceTrigger()) {
      tgt.addResourceTrigger(convertResourceTrigger(triggerComponent));
    }
    for (org.hl7.fhir.r4b.model.SubscriptionTopic.SubscriptionTopicCanFilterByComponent canFilterByComponent : src.getCanFilterBy()) {
      tgt.addCanFilterBy(convertCanFilterBy(canFilterByComponent));
    }
    for (org.hl7.fhir.r4b.model.SubscriptionTopic.SubscriptionTopicNotificationShapeComponent notificationShape : src.getNotificationShape()) {
      tgt.addNotificationShape(convertNotificationShape(notificationShape));
    }
    return tgt;
  }

  private static org.hl7.fhir.r5.model.SubscriptionTopic.SubscriptionTopicNotificationShapeComponent convertNotificationShape(org.hl7.fhir.r4b.model.SubscriptionTopic.SubscriptionTopicNotificationShapeComponent src) {
    org.hl7.fhir.r5.model.SubscriptionTopic.SubscriptionTopicNotificationShapeComponent tgt = new org.hl7.fhir.r5.model.SubscriptionTopic.SubscriptionTopicNotificationShapeComponent();
    if (src.hasResource()) {
      tgt.setResourceElement(Uri43_50.convertUri(src.getResourceElement()));
    }
    if (src.hasInclude()) {
      tgt.setInclude(src.getInclude().stream().map(String43_50::convertString).collect(Collectors.toList()));
    }
    return tgt;

  }

  private static org.hl7.fhir.r5.model.SubscriptionTopic.SubscriptionTopicCanFilterByComponent convertCanFilterBy(org.hl7.fhir.r4b.model.SubscriptionTopic.SubscriptionTopicCanFilterByComponent src) {
    org.hl7.fhir.r5.model.SubscriptionTopic.SubscriptionTopicCanFilterByComponent tgt = new org.hl7.fhir.r5.model.SubscriptionTopic.SubscriptionTopicCanFilterByComponent();
    if (src.hasDescription()) {
      tgt.setDescriptionElement(MarkDown43_50.convertMarkdown(src.getDescriptionElement()));
    }
    if (src.hasResource()) {
      tgt.setResourceElement(Uri43_50.convertUri(src.getResourceElement()));
    }
    if (src.hasFilterParameter()) {
      tgt.setFilterParameterElement(String43_50.convertString(src.getFilterParameterElement()));
    }

    if (src.hasModifier()) {
      List<org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.SearchModifierCode>> tgtModifiers = convertR4BModifierToR5Modifier(src.getModifier());
      tgt.setModifier(tgtModifiers);

      List<org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.SearchComparator>> tgtComparators = covertR4BModifierToR5Comparator(src.getModifier());
      tgt.setComparator(tgtComparators);
    }

    return tgt;
  }

  private static List<org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.SearchComparator>> covertR4BModifierToR5Comparator(List<org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.SubscriptionTopic.SubscriptionSearchModifier>> srcList) {
    return srcList.stream().map(SubscriptionTopic43_50::convertR4BModifierToR5Comparator).filter(x -> x != null).collect(Collectors.toList());
  }


  private static org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.SearchComparator> convertR4BModifierToR5Comparator(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.SubscriptionTopic.SubscriptionSearchModifier> src) {
    org.hl7.fhir.r5.model.Enumerations.SearchComparatorEnumFactory enumFactory = new org.hl7.fhir.r5.model.Enumerations.SearchComparatorEnumFactory();
    switch(src.getValue()) {
      case NULL: return new org.hl7.fhir.r5.model.Enumeration<>(enumFactory, org.hl7.fhir.r5.model.Enumerations.SearchComparator.NULL);
      case EQ: return new org.hl7.fhir.r5.model.Enumeration<>(enumFactory, org.hl7.fhir.r5.model.Enumerations.SearchComparator.EQ);
      case NE: return new org.hl7.fhir.r5.model.Enumeration<>(enumFactory, org.hl7.fhir.r5.model.Enumerations.SearchComparator.NE);
      case GT: return new org.hl7.fhir.r5.model.Enumeration<>(enumFactory, org.hl7.fhir.r5.model.Enumerations.SearchComparator.GT);
      case LT: return new org.hl7.fhir.r5.model.Enumeration<>(enumFactory, org.hl7.fhir.r5.model.Enumerations.SearchComparator.LT);
      case GE: return new org.hl7.fhir.r5.model.Enumeration<>(enumFactory, org.hl7.fhir.r5.model.Enumerations.SearchComparator.GE);
      case LE: return new org.hl7.fhir.r5.model.Enumeration<>(enumFactory, org.hl7.fhir.r5.model.Enumerations.SearchComparator.LE);
      case SA: return new org.hl7.fhir.r5.model.Enumeration<>(enumFactory, org.hl7.fhir.r5.model.Enumerations.SearchComparator.SA);
      case EB: return new org.hl7.fhir.r5.model.Enumeration<>(enumFactory, org.hl7.fhir.r5.model.Enumerations.SearchComparator.EB);
      case AP: return new org.hl7.fhir.r5.model.Enumeration<>(enumFactory, org.hl7.fhir.r5.model.Enumerations.SearchComparator.AP);
    }
    return null;
  }

  private static List<org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.SearchModifierCode>> convertR4BModifierToR5Modifier(
    List
      <org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.SubscriptionTopic.SubscriptionSearchModifier>> srcList) {
    return srcList.stream().map(SubscriptionTopic43_50::convertR4BModifierToR5Modifier).filter(x -> x != null).collect(Collectors.toList());
  }
  private static org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.SearchModifierCode> convertR4BModifierToR5Modifier(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.SubscriptionTopic.SubscriptionSearchModifier> src) {
    org.hl7.fhir.r5.model.Enumerations.SearchModifierCodeEnumFactory enumFactory = new org.hl7.fhir.r5.model.Enumerations.SearchModifierCodeEnumFactory();
    switch(src.getValue()) {
      case NULL:
        return new org.hl7.fhir.r5.model.Enumeration<>(enumFactory, org.hl7.fhir.r5.model.Enumerations.SearchModifierCode.NULL);
      case IN:
        return new org.hl7.fhir.r5.model.Enumeration<>(enumFactory, org.hl7.fhir.r5.model.Enumerations.SearchModifierCode.IN);
      case NOTIN:
        return new org.hl7.fhir.r5.model.Enumeration<>(enumFactory, org.hl7.fhir.r5.model.Enumerations.SearchModifierCode.NOTIN);
      case BELOW:
        return new org.hl7.fhir.r5.model.Enumeration<>(enumFactory, org.hl7.fhir.r5.model.Enumerations.SearchModifierCode.BELOW);
      case ABOVE:
        return new org.hl7.fhir.r5.model.Enumeration<>(enumFactory, org.hl7.fhir.r5.model.Enumerations.SearchModifierCode.ABOVE);
      case OFTYPE:
        return new org.hl7.fhir.r5.model.Enumeration<>(enumFactory, org.hl7.fhir.r5.model.Enumerations.SearchModifierCode.OFTYPE);
    }
    return null;
  }

  private static org.hl7.fhir.r5.model.SubscriptionTopic.SubscriptionTopicResourceTriggerComponent convertResourceTrigger(org.hl7.fhir.r4b.model.SubscriptionTopic.SubscriptionTopicResourceTriggerComponent src) {
    org.hl7.fhir.r5.model.SubscriptionTopic.SubscriptionTopicResourceTriggerComponent tgt = new org.hl7.fhir.r5.model.SubscriptionTopic.SubscriptionTopicResourceTriggerComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasDescription()) {
      tgt.setDescriptionElement(MarkDown43_50.convertMarkdown(src.getDescriptionElement()));
    }
    if (src.hasResource()) {
      tgt.setResourceElement(Uri43_50.convertUri(src.getResourceElement()));
    }
    if (src.hasSupportedInteraction()) {
      for (org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.SubscriptionTopic.InteractionTrigger> srcItem : src.getSupportedInteraction()) {
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SubscriptionTopic.InteractionTrigger> tgtElement = tgt.addSupportedInteractionElement();
        tgtElement.setValue(convertInteractionTrigger(srcItem.getValue()));
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

  private static org.hl7.fhir.r5.model.SubscriptionTopic.SubscriptionTopicResourceTriggerQueryCriteriaComponent convertResourceTriggerQueryCriteriaComponent(org.hl7.fhir.r4b.model.SubscriptionTopic.SubscriptionTopicResourceTriggerQueryCriteriaComponent src) {
    org.hl7.fhir.r5.model.SubscriptionTopic.SubscriptionTopicResourceTriggerQueryCriteriaComponent tgt = new org.hl7.fhir.r5.model.SubscriptionTopic.SubscriptionTopicResourceTriggerQueryCriteriaComponent();
    if (src.hasPrevious()) {
      tgt.setPreviousElement(String43_50.convertString(src.getPreviousElement()));
    }
    if (src.hasResultForCreate()) {
      tgt.setResultForCreateElement(convertCriteriaNotExistsBehavior(src.getResultForCreateElement()));
    }
    if (src.hasCurrent()) {
      tgt.setCurrentElement(String43_50.convertString(src.getCurrentElement()));
    }
    if (src.hasResultForDelete()) {
      tgt.setResultForDeleteElement(convertCriteriaNotExistsBehavior(src.getResultForDeleteElement()));
    }
    if (src.hasRequireBoth()) {
      tgt.setRequireBothElement(Boolean43_50.convertBoolean(src.getRequireBothElement()));
    }
    return tgt;
  }

  private static org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SubscriptionTopic.CriteriaNotExistsBehavior> convertCriteriaNotExistsBehavior(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.SubscriptionTopic.CriteriaNotExistsBehavior> src) {
    org.hl7.fhir.r5.model.SubscriptionTopic.CriteriaNotExistsBehaviorEnumFactory enumFactory = new org.hl7.fhir.r5.model.SubscriptionTopic.CriteriaNotExistsBehaviorEnumFactory();
    switch(src.getValue()) {

      case TESTFAILS: return new org.hl7.fhir.r5.model.Enumeration<>(enumFactory, org.hl7.fhir.r5.model.SubscriptionTopic.CriteriaNotExistsBehavior.TESTFAILS);
      case TESTPASSES: return new org.hl7.fhir.r5.model.Enumeration<>(enumFactory, org.hl7.fhir.r5.model.SubscriptionTopic.CriteriaNotExistsBehavior.TESTPASSES);
      case NULL: return new org.hl7.fhir.r5.model.Enumeration<>(enumFactory, org.hl7.fhir.r5.model.SubscriptionTopic.CriteriaNotExistsBehavior.NULL);
    }
    return null;
  }

  private static org.hl7.fhir.r5.model.SubscriptionTopic.InteractionTrigger convertInteractionTrigger(org.hl7.fhir.r4b.model.SubscriptionTopic.InteractionTrigger value) {
    switch(value) {
      case CREATE : return org.hl7.fhir.r5.model.SubscriptionTopic.InteractionTrigger.CREATE;
      case UPDATE: return org.hl7.fhir.r5.model.SubscriptionTopic.InteractionTrigger.UPDATE;
      case DELETE: return org.hl7.fhir.r5.model.SubscriptionTopic.InteractionTrigger.DELETE;
      case NULL: return org.hl7.fhir.r5.model.SubscriptionTopic.InteractionTrigger.NULL;
    }
    return null;

  }
}
