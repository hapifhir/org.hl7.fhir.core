package org.hl7.fhir.convertors.conv40_50.resources40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.CodeableConcept40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Identifier40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.metadata40_50.ContactDetail40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.metadata40_50.UsageContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Boolean40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Canonical40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.DateTime40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.MarkDown40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.String40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Uri40_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.BooleanType;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.MarkdownType;
import org.hl7.fhir.r4.model.UriType;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.ContactDetail;
import org.hl7.fhir.r5.model.Enumeration;
import org.hl7.fhir.r5.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r5.model.Enumerations.SearchComparator;
import org.hl7.fhir.r5.model.Enumerations.SearchModifierCode;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.model.SubscriptionTopic.InteractionTrigger;
import org.hl7.fhir.r5.model.SubscriptionTopic.SubscriptionTopicCanFilterByComponent;
import org.hl7.fhir.r5.model.SubscriptionTopic.SubscriptionTopicEventTriggerComponent;
import org.hl7.fhir.r5.model.SubscriptionTopic.SubscriptionTopicNotificationShapeComponent;
import org.hl7.fhir.r5.model.SubscriptionTopic.SubscriptionTopicResourceTriggerComponent;
import org.hl7.fhir.r5.model.SubscriptionTopic.SubscriptionTopicResourceTriggerQueryCriteriaComponent;
import org.hl7.fhir.r5.model.UsageContext;

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
// Generated on Sun, Feb 24, 2019 11:37+1100 for FHIR v4.0.0
public class SubscriptionTopic40_50 {

  public static final String URL_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-SubscriptionTopic.url";
  public static final String VERSION_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-SubscriptionTopic.version";
  public static final String NAME_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-SubscriptionTopic.name";
  public static final String TITLE_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-SubscriptionTopic.title";
  public static final String STATUS_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-SubscriptionTopic.status";
  public static final String EXPERIMENTAL_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-SubscriptionTopic.experimental";
  public static final String DATE_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-SubscriptionTopic.date";
  public static final String PUBLISHER_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-SubscriptionTopic.publisher";
  public static final String CONTACT_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-SubscriptionTopic.contact";
  public static final String DESCRIPTION_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-SubscriptionTopic.description";
  public static final String USE_CONTEXT_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-SubscriptionTopic.useContext";
  public static final String JURISDICTION_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-SubscriptionTopic.jurisdiction";
  public static final String PURPOSE_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-SubscriptionTopic.purpose";
  public static final String COPYRIGHT_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-SubscriptionTopic.copyright";
  public static final String COPYRIGHT_LABEL_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-SubscriptionTopic.copyrightLabel";
  public static final String APPROVAL_DATE_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-SubscriptionTopic.approvalDate";
  public static final String LAST_REVIEW_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-SubscriptionTopic.lastReviewDate";
  public static final String EFFECTIVE_PERIOD_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-SubscriptionTopic.effectivePeriod";
  public static final String DERIVED_FROM_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-SubscriptionTopic.derivedFrom";
  
  public static final String RESOURCE_TRIGGER_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-SubscriptionTopic.resourceTrigger";
  public static final String RESOURCE_TRIGGER_DESCRIPTION_EXTENSION_URL = /*http://hl7.org/fhir/5.0/StructureDefinition/extension-SubscriptionTopic.resourceTrigger.*/"description";
  public static final String RESOURCE_TRIGGER_RESOURCE_EXTENSION_URL = /*http://hl7.org/fhir/5.0/StructureDefinition/extension-SubscriptionTopic.resourceTrigger.*/"resource";
  public static final String RESOURCE_TRIGGER_SUPPORTED_INTERACTION_EXTENSION_URL = /*http://hl7.org/fhir/5.0/StructureDefinition/extension-SubscriptionTopic.resourceTrigger.*/"supportedInteraction";
  public static final String RESOURCE_TRIGGER_QUERY_CRITERIA_EXTENSION_URL = /*http://hl7.org/fhir/5.0/StructureDefinition/extension-SubscriptionTopic.resourceTrigger.*/"queryCriteria";
  public static final String RESOURCE_TRIGGER_QUERY_CRITERIA_PREVIOUS_EXTENSION_URL = /*http://hl7.org/fhir/5.0/StructureDefinition/extension-SubscriptionTopic.resourceTrigger.queryCriteria.*/"previous";
  public static final String RESOURCE_TRIGGER_QUERY_CRITERIA_RESULT_FOR_CREATE_EXTENSION_URL = /*http://hl7.org/fhir/5.0/StructureDefinition/extension-SubscriptionTopic.resourceTrigger.queryCriteria.*/"resultForCreate";
  public static final String RESOURCE_TRIGGER_QUERY_CRITERIA_CURRENT_EXTENSION_URL = /*http://hl7.org/fhir/5.0/StructureDefinition/extension-SubscriptionTopic.resourceTrigger.queryCriteria.*/"current";
  public static final String RESOURCE_TRIGGER_QUERY_CRITERIA_RESULT_FOR_DELETE_EXTENSION_URL = /*http://hl7.org/fhir/5.0/StructureDefinition/extension-SubscriptionTopic.resourceTrigger.queryCriteria.*/"resultForDelete";
  public static final String RESOURCE_TRIGGER_QUERY_CRITERIA_REQUIRE_BOTH_EXTENSION_URL = /*http://hl7.org/fhir/5.0/StructureDefinition/extension-SubscriptionTopic.resourceTrigger.queryCriteria.*/"requireBoth";
  public static final String RESOURCE_TRIGGER_FHIRPATH_CRITERIA_EXTENSION_URL = /*http://hl7.org/fhir/5.0/StructureDefinition/extension-SubscriptionTopic.resourceTrigger.*/"fhirPathCriteria";
  
  public static final String EVENT_TRIGGER_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-SubscriptionTopic.eventTrigger";
  public static final String EVENT_TRIGGER_DESCRIPTION_EXTENSION_URL = /*"http://hl7.org/fhir/5.0/StructureDefinition/extension-SubscriptionTopic.eventTrigger.*/"description";
  public static final String EVENT_TRIGGER_EVENT_EXTENSION_URL = /*"http://hl7.org/fhir/5.0/StructureDefinition/extension-SubscriptionTopic.eventTrigger.*/"event";
  public static final String EVENT_TRIGGER_RESOURCE_EXTENSION_URL = /*"http://hl7.org/fhir/5.0/StructureDefinition/extension-SubscriptionTopic.eventTrigger.*/"resource";
  
  public static final String CAN_FILTER_BY_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-SubscriptionTopic.canFilterBy";
  public static final String CAN_FILTER_BY_DESCRIPTION_EXTENSION_URL = /*http://hl7.org/fhir/5.0/StructureDefinition/extension-SubscriptionTopic.canFilterBy.*/"description";
  public static final String CAN_FILTER_BY_RESOURCE_EXTENSION_URL = /*http://hl7.org/fhir/5.0/StructureDefinition/extension-SubscriptionTopic.canFilterBy.*/"resource";
  public static final String CAN_FILTER_BY_FILTER_PARMETER_EXTENSION_URL = /*http://hl7.org/fhir/5.0/StructureDefinition/extension-SubscriptionTopic.canFilterBy.*/"filterParameter";
  public static final String CAN_FILTER_BY_FILTER_DEFINITION_EXTENSION_URL = /*http://hl7.org/fhir/5.0/StructureDefinition/extension-SubscriptionTopic.canFilterBy.*/"filterDefinition";
  public static final String CAN_FILTER_BY_COMPARATOR_EXTENSION_URL = /*http://hl7.org/fhir/5.0/StructureDefinition/extension-SubscriptionTopic.canFilterBy.*/"comparator";
  public static final String CAN_FILTER_BY_MODIFIER_EXTENSION_URL = /*http://hl7.org/fhir/5.0/StructureDefinition/extension-SubscriptionTopic.canFilterBy.*/"modifier";
  
  public static final String NOTIFICATION_SHAPE_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-SubscriptionTopic.notificationShape";
  public static final String NOTIFICATION_SHAPE_RESOURCE_EXTENSION_URL = /*http://hl7.org/fhir/5.0/StructureDefinition/extension-SubscriptionTopic.notificationShape.*/"resource";
  public static final String NOTIFICATION_SHAPE_INCLUDE_EXTENSION_URL = /*http://hl7.org/fhir/5.0/StructureDefinition/extension-SubscriptionTopic.notificationShape.*/"include";
  public static final String NOTIFICATION_SHAPE_REV_INCLUDE_EXTENSION_URL = /*http://hl7.org/fhir/5.0/StructureDefinition/extension-SubscriptionTopic.notificationShape.*/"revInclude";
  

  private static final String[] IGNORED_EXTENSION_URLS = new String[]{
    URL_EXTENSION_URL,
    VERSION_EXTENSION_URL,
    NAME_EXTENSION_URL,
    TITLE_EXTENSION_URL,
    STATUS_EXTENSION_URL,
    EXPERIMENTAL_EXTENSION_URL,
    DATE_EXTENSION_URL,
    PUBLISHER_EXTENSION_URL,
    CONTACT_EXTENSION_URL,
    DESCRIPTION_EXTENSION_URL,
    USE_CONTEXT_EXTENSION_URL,
    JURISDICTION_EXTENSION_URL,
    PURPOSE_EXTENSION_URL,
    COPYRIGHT_EXTENSION_URL,
    COPYRIGHT_LABEL_EXTENSION_URL,
    RESOURCE_TRIGGER_EXTENSION_URL,
    EVENT_TRIGGER_EXTENSION_URL,
    CAN_FILTER_BY_EXTENSION_URL,
    NOTIFICATION_SHAPE_EXTENSION_URL
  };

  public static org.hl7.fhir.r5.model.SubscriptionTopic convertSubscriptionTopic(org.hl7.fhir.r4.model.Basic src) throws FHIRException {
    if (src == null)
      return null;
    if (!src.getCode().hasCoding("http://hl7.org/fhir/fhir-types", "SubscriptionTopic")) {
      throw new FHIRException("Error in logic: this basic resource is not an SubscriptionTopic");
    }
    org.hl7.fhir.r5.model.SubscriptionTopic tgt = new org.hl7.fhir.r5.model.SubscriptionTopic();

    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt, IGNORED_EXTENSION_URLS);
    
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));

    if (src.hasExtension(URL_EXTENSION_URL)) {
      tgt.setUrlElement(Uri40_50.convertUri((org.hl7.fhir.r4.model.UriType) src.getExtensionByUrl(URL_EXTENSION_URL).getValue()));
    }
    if (src.hasExtension(VERSION_EXTENSION_URL)) {
      tgt.setVersionElement(String40_50.convertString((org.hl7.fhir.r4.model.StringType) src.getExtensionByUrl(VERSION_EXTENSION_URL).getValue()));
    }
    if (src.hasExtension(NAME_EXTENSION_URL)) {
      tgt.setNameElement(String40_50.convertString((org.hl7.fhir.r4.model.StringType) src.getExtensionByUrl(NAME_EXTENSION_URL).getValue()));
    }
    if (src.hasExtension(TITLE_EXTENSION_URL)) {
      tgt.setTitleElement(String40_50.convertString((org.hl7.fhir.r4.model.StringType) src.getExtensionByUrl(TITLE_EXTENSION_URL).getValue()));
    }
    if (src.hasExtension(STATUS_EXTENSION_URL)) {
      tgt.setStatus(PublicationStatus.fromCode(src.getExtensionByUrl(STATUS_EXTENSION_URL).getValue().primitiveValue()));
    }
    if (src.hasExtension(EXPERIMENTAL_EXTENSION_URL)) {
      tgt.setExperimentalElement(Boolean40_50.convertBoolean((org.hl7.fhir.r4.model.BooleanType) src.getExtensionByUrl(EXPERIMENTAL_EXTENSION_URL).getValue()));
    }
    if (src.hasExtension(DATE_EXTENSION_URL)) {
      tgt.setDateElement(DateTime40_50.convertDateTime((org.hl7.fhir.r4.model.DateTimeType) src.getExtensionByUrl(DATE_EXTENSION_URL).getValue()));
    }
    if (src.hasExtension(PUBLISHER_EXTENSION_URL)) {
      tgt.setPublisherElement(String40_50.convertString((org.hl7.fhir.r4.model.StringType) src.getExtensionByUrl(PUBLISHER_EXTENSION_URL).getValue()));
    }
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl(CONTACT_EXTENSION_URL)) {
      tgt.addContact(ContactDetail40_50.convertContactDetail((org.hl7.fhir.r4.model.ContactDetail) ext.getValue()));
    }
    if (src.hasExtension(DESCRIPTION_EXTENSION_URL)) {
      tgt.setDescriptionElement(MarkDown40_50.convertMarkdown((org.hl7.fhir.r4.model.MarkdownType) src.getExtensionByUrl(DESCRIPTION_EXTENSION_URL).getValue()));
    }
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl(USE_CONTEXT_EXTENSION_URL)) {
      tgt.addUseContext(UsageContext40_50.convertUsageContext((org.hl7.fhir.r4.model.UsageContext) ext.getValue()));
    }
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl(JURISDICTION_EXTENSION_URL)) {
      tgt.addJurisdiction(CodeableConcept40_50.convertCodeableConcept((org.hl7.fhir.r4.model.CodeableConcept) ext.getValue()));
    }
    if (src.hasExtension(PURPOSE_EXTENSION_URL)) {
      tgt.setPurposeElement(MarkDown40_50.convertMarkdown((org.hl7.fhir.r4.model.MarkdownType) src.getExtensionByUrl(PURPOSE_EXTENSION_URL).getValue()));
    }
    if (src.hasExtension(COPYRIGHT_EXTENSION_URL)) {
      tgt.setCopyrightElement(MarkDown40_50.convertMarkdown((org.hl7.fhir.r4.model.MarkdownType) src.getExtensionByUrl(COPYRIGHT_EXTENSION_URL).getValue()));
    }
    if (src.hasExtension(COPYRIGHT_LABEL_EXTENSION_URL)) {
      tgt.setCopyrightLabelElement(String40_50.convertString((org.hl7.fhir.r4.model.StringType) src.getExtensionByUrl(COPYRIGHT_LABEL_EXTENSION_URL).getValue()));
    }
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl(DERIVED_FROM_EXTENSION_URL)) {
      tgt.getDerivedFrom().add(Canonical40_50.convertCanonical((org.hl7.fhir.r4.model.CanonicalType) ext.getValue()));
    }
    
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl(RESOURCE_TRIGGER_EXTENSION_URL)) {
      convertSubscriptionResourceTrigger(ext, tgt.addResourceTrigger());
    }
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl(EVENT_TRIGGER_EXTENSION_URL)) {
      convertSubscriptionEventTrigger(ext, tgt.addEventTrigger());
    }
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl(CAN_FILTER_BY_EXTENSION_URL)) {
      convertSubscriptionCanFilterBy(ext, tgt.addCanFilterBy());
    }    
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl(NOTIFICATION_SHAPE_EXTENSION_URL)) {
      convertSubscriptionNotificationShape(ext, tgt.addNotificationShape());
    }
    
    return tgt;
  }


  public static org.hl7.fhir.r4.model.Basic convertSubscriptionTopic(org.hl7.fhir.r5.model.SubscriptionTopic src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Basic tgt = new org.hl7.fhir.r4.model.Basic();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    tgt.getCode().getCodingFirstRep().setSystem("http://hl7.org/fhir/fhir-types").setCode("SubscriptionTopic"); // note use of R5 type system
    
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    if (src.hasUrl()) {
      tgt.addExtension(URL_EXTENSION_URL, Uri40_50.convertUri(src.getUrlElement()));
    }
    if (src.hasVersion()) {
      tgt.addExtension(VERSION_EXTENSION_URL, String40_50.convertString(src.getVersionElement()));
    }
    if (src.hasName()) {
      tgt.addExtension(NAME_EXTENSION_URL, String40_50.convertString(src.getNameElement()));
    }
    if (src.hasTitle()) {
      tgt.addExtension(TITLE_EXTENSION_URL, String40_50.convertString(src.getTitleElement()));
    }
    if (src.hasStatus()) {
      tgt.addExtension(STATUS_EXTENSION_URL, new org.hl7.fhir.r4.model.CodeType(src.getStatus().toCode()));
    }
    if (src.hasExperimental()) {
      tgt.addExtension(EXPERIMENTAL_EXTENSION_URL, Boolean40_50.convertBoolean(src.getExperimentalElement()));
    }
    if (src.hasDate()) {
      tgt.addExtension(DATE_EXTENSION_URL, DateTime40_50.convertDateTime(src.getDateElement()));
    }
    if (src.hasPublisher()) {
      tgt.addExtension(PUBLISHER_EXTENSION_URL, String40_50.convertString(src.getPublisherElement()));
    }
    for (ContactDetail cd : src.getContact()) {
      tgt.addExtension(CONTACT_EXTENSION_URL, ContactDetail40_50.convertContactDetail(cd));
    }
    if (src.hasDescription()) {
      tgt.addExtension(DESCRIPTION_EXTENSION_URL, MarkDown40_50.convertMarkdown(src.getDescriptionElement()));
    }
    for (UsageContext cd : src.getUseContext()) {
      tgt.addExtension(USE_CONTEXT_EXTENSION_URL, UsageContext40_50.convertUsageContext(cd));
    }
    for (CodeableConcept cd : src.getJurisdiction()) {
      tgt.addExtension(JURISDICTION_EXTENSION_URL, CodeableConcept40_50.convertCodeableConcept(cd));
    }
    if (src.hasPurpose()) {
      tgt.addExtension(PURPOSE_EXTENSION_URL, MarkDown40_50.convertMarkdown(src.getPurposeElement()));
    }
    if (src.hasCopyright()) {
      tgt.addExtension(COPYRIGHT_EXTENSION_URL, MarkDown40_50.convertMarkdown(src.getCopyrightElement()));
    }
    if (src.hasCopyrightLabel()) {
      tgt.addExtension(COPYRIGHT_LABEL_EXTENSION_URL, String40_50.convertString(src.getCopyrightLabelElement()));
    }
    for (CanonicalType ref : src.getDerivedFrom()) {
      tgt.addExtension(DERIVED_FROM_EXTENSION_URL, Canonical40_50.convertCanonical(ref));
    }

    for (SubscriptionTopicResourceTriggerComponent ref : src.getResourceTrigger()) {
      org.hl7.fhir.r4.model.Extension tgte = new org.hl7.fhir.r4.model.Extension(RESOURCE_TRIGGER_EXTENSION_URL);
      tgt.addExtension(tgte);
      convertSubscriptionResourceTrigger(ref, tgte);
    }
    for (SubscriptionTopicEventTriggerComponent ref : src.getEventTrigger()) {
      org.hl7.fhir.r4.model.Extension tgte = new org.hl7.fhir.r4.model.Extension(EVENT_TRIGGER_EXTENSION_URL);
      tgt.addExtension(tgte);
      convertSubscriptionEventTrigger(ref, tgte);
    }
    for (SubscriptionTopicCanFilterByComponent ref : src.getCanFilterBy()) {
      org.hl7.fhir.r4.model.Extension tgte = new org.hl7.fhir.r4.model.Extension(CAN_FILTER_BY_EXTENSION_URL);
      tgt.addExtension(tgte);
      convertSubscriptionCanFilterBy(ref, tgte);
    }
    for (SubscriptionTopicNotificationShapeComponent ref : src.getNotificationShape()) {
      org.hl7.fhir.r4.model.Extension tgte = new org.hl7.fhir.r4.model.Extension(NOTIFICATION_SHAPE_EXTENSION_URL);
      tgt.addExtension(tgte);
      convertSubscriptionNotificationShape(ref, tgte);
    }

    return tgt;
  }

  private static void convertSubscriptionResourceTrigger(SubscriptionTopicResourceTriggerComponent src, Extension tgt) {
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasDescription()) {
      tgt.addExtension(RESOURCE_TRIGGER_DESCRIPTION_EXTENSION_URL, MarkDown40_50.convertMarkdown(src.getDescriptionElement()));
    }
    if (src.hasResource()) {
      tgt.addExtension(RESOURCE_TRIGGER_RESOURCE_EXTENSION_URL, Uri40_50.convertUri(src.getResourceElement()));
    }
    for (Enumeration<InteractionTrigger> t : src.getSupportedInteraction()) {
      tgt.addExtension(RESOURCE_TRIGGER_SUPPORTED_INTERACTION_EXTENSION_URL, new org.hl7.fhir.r4.model.CodeType(t.getCode()));
    }
    if (src.hasQueryCriteria()) {
      Extension tgtQF = new Extension(RESOURCE_TRIGGER_QUERY_CRITERIA_EXTENSION_URL);
      tgt.addExtension(tgtQF);
      if (src.getQueryCriteria().hasPrevious()) {
        tgtQF.addExtension(RESOURCE_TRIGGER_QUERY_CRITERIA_PREVIOUS_EXTENSION_URL, String40_50.convertString(src.getQueryCriteria().getPreviousElement()));
      }
      if (src.getQueryCriteria().hasResultForCreate()) {
        tgtQF.addExtension(RESOURCE_TRIGGER_QUERY_CRITERIA_RESULT_FOR_CREATE_EXTENSION_URL, new org.hl7.fhir.r4.model.CodeType(src.getQueryCriteria().getResultForCreate().toCode()));
      }
      if (src.getQueryCriteria().hasCurrent()) {
        tgtQF.addExtension(RESOURCE_TRIGGER_QUERY_CRITERIA_CURRENT_EXTENSION_URL, String40_50.convertString(src.getQueryCriteria().getCurrentElement()));
      }
      if (src.getQueryCriteria().hasResultForDelete()) {
        tgtQF.addExtension(RESOURCE_TRIGGER_QUERY_CRITERIA_RESULT_FOR_DELETE_EXTENSION_URL, new org.hl7.fhir.r4.model.CodeType(src.getQueryCriteria().getResultForDelete().toCode()));
      }
      if (src.getQueryCriteria().hasRequireBoth()) {
        tgtQF.addExtension(RESOURCE_TRIGGER_QUERY_CRITERIA_REQUIRE_BOTH_EXTENSION_URL, Boolean40_50.convertBoolean(src.getQueryCriteria().getRequireBothElement()));
      }
    }
    if (src.hasFhirPathCriteria()) {
      tgt.addExtension(RESOURCE_TRIGGER_FHIRPATH_CRITERIA_EXTENSION_URL, String40_50.convertString(src.getFhirPathCriteriaElement()));
    }
  }

  private static void convertSubscriptionResourceTrigger(Extension src, SubscriptionTopicResourceTriggerComponent tgt) {
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt, 
        RESOURCE_TRIGGER_DESCRIPTION_EXTENSION_URL, RESOURCE_TRIGGER_RESOURCE_EXTENSION_URL, RESOURCE_TRIGGER_QUERY_CRITERIA_EXTENSION_URL,
        RESOURCE_TRIGGER_SUPPORTED_INTERACTION_EXTENSION_URL, RESOURCE_TRIGGER_FHIRPATH_CRITERIA_EXTENSION_URL);
    if (src.hasExtension(RESOURCE_TRIGGER_DESCRIPTION_EXTENSION_URL)) {
      tgt.setDescriptionElement(MarkDown40_50.convertMarkdown((MarkdownType) src.getExtensionByUrl(RESOURCE_TRIGGER_DESCRIPTION_EXTENSION_URL).getValue()));
    }
    if (src.hasExtension(RESOURCE_TRIGGER_RESOURCE_EXTENSION_URL)) {
      tgt.setResourceElement(Uri40_50.convertUri((UriType) src.getExtensionByUrl(RESOURCE_TRIGGER_RESOURCE_EXTENSION_URL).getValue()));
    }
    for (Extension ext : src.getExtensionsByUrl(RESOURCE_TRIGGER_SUPPORTED_INTERACTION_EXTENSION_URL)) {
      tgt.addSupportedInteractionElement().setValueAsString(ext.getValue().primitiveValue());
    }
    if (src.hasExtension(RESOURCE_TRIGGER_QUERY_CRITERIA_EXTENSION_URL)) {
      Extension srcQF = src.getExtensionByUrl(RESOURCE_TRIGGER_QUERY_CRITERIA_EXTENSION_URL); 
      SubscriptionTopicResourceTriggerQueryCriteriaComponent tgtQF = tgt.getQueryCriteria();
      if (srcQF.hasExtension(RESOURCE_TRIGGER_QUERY_CRITERIA_PREVIOUS_EXTENSION_URL)) {
        tgtQF.setPreviousElement(String40_50.convertString((org.hl7.fhir.r4.model.StringType) srcQF.getExtensionByUrl(RESOURCE_TRIGGER_QUERY_CRITERIA_PREVIOUS_EXTENSION_URL).getValue()));
      }
      if (srcQF.hasExtension(RESOURCE_TRIGGER_QUERY_CRITERIA_RESULT_FOR_CREATE_EXTENSION_URL)) {
        tgtQF.getResultForCreateElement().setValueAsString(srcQF.getExtensionByUrl(RESOURCE_TRIGGER_QUERY_CRITERIA_RESULT_FOR_CREATE_EXTENSION_URL).getValue().primitiveValue());
      }
      if (srcQF.hasExtension(RESOURCE_TRIGGER_QUERY_CRITERIA_CURRENT_EXTENSION_URL)) {
        tgtQF.setCurrentElement(String40_50.convertString((org.hl7.fhir.r4.model.StringType) srcQF.getExtensionByUrl(RESOURCE_TRIGGER_QUERY_CRITERIA_CURRENT_EXTENSION_URL).getValue()));
      }
      if (srcQF.hasExtension(RESOURCE_TRIGGER_QUERY_CRITERIA_RESULT_FOR_DELETE_EXTENSION_URL)) {
        tgtQF.getResultForDeleteElement().setValueAsString(srcQF.getExtensionByUrl(RESOURCE_TRIGGER_QUERY_CRITERIA_RESULT_FOR_DELETE_EXTENSION_URL).getValue().primitiveValue());
      }
      if (srcQF.hasExtension(RESOURCE_TRIGGER_QUERY_CRITERIA_REQUIRE_BOTH_EXTENSION_URL)) {
        tgtQF.setRequireBothElement(Boolean40_50.convertBoolean((BooleanType) srcQF.getExtensionByUrl(RESOURCE_TRIGGER_QUERY_CRITERIA_REQUIRE_BOTH_EXTENSION_URL).getValue()));
      }
    }
    if (src.hasExtension(RESOURCE_TRIGGER_FHIRPATH_CRITERIA_EXTENSION_URL)) {
      tgt.setFhirPathCriteriaElement(String40_50.convertString((org.hl7.fhir.r4.model.StringType) src.getExtensionByUrl(RESOURCE_TRIGGER_FHIRPATH_CRITERIA_EXTENSION_URL).getValue()));
    }
  }

  private static void convertSubscriptionEventTrigger(SubscriptionTopicEventTriggerComponent src, Extension tgt) {
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasDescription()) {
      tgt.addExtension(EVENT_TRIGGER_DESCRIPTION_EXTENSION_URL, MarkDown40_50.convertMarkdown(src.getDescriptionElement()));
    }
    if (src.hasResource()) {
      tgt.addExtension(EVENT_TRIGGER_RESOURCE_EXTENSION_URL, Uri40_50.convertUri(src.getResourceElement()));
    }
    if (src.hasEvent()) {
      tgt.addExtension(EVENT_TRIGGER_EVENT_EXTENSION_URL, CodeableConcept40_50.convertCodeableConcept(src.getEvent()));
    }
  }
  
  private static void convertSubscriptionEventTrigger(Extension src, SubscriptionTopicEventTriggerComponent tgt) {
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt, EVENT_TRIGGER_DESCRIPTION_EXTENSION_URL, EVENT_TRIGGER_RESOURCE_EXTENSION_URL, EVENT_TRIGGER_EVENT_EXTENSION_URL);
    if (src.hasExtension(EVENT_TRIGGER_DESCRIPTION_EXTENSION_URL)) {
      tgt.setDescriptionElement(MarkDown40_50.convertMarkdown((MarkdownType) src.getExtensionByUrl(EVENT_TRIGGER_DESCRIPTION_EXTENSION_URL).getValue()));
    }
    if (src.hasExtension(EVENT_TRIGGER_RESOURCE_EXTENSION_URL)) {
      tgt.setResourceElement(Uri40_50.convertUri((UriType) src.getExtensionByUrl(EVENT_TRIGGER_RESOURCE_EXTENSION_URL).getValue()));
    }
    if (src.hasExtension(EVENT_TRIGGER_EVENT_EXTENSION_URL)) {
      tgt.setEvent(CodeableConcept40_50.convertCodeableConcept((org.hl7.fhir.r4.model.CodeableConcept) src.getExtensionByUrl(EVENT_TRIGGER_EVENT_EXTENSION_URL).getValue()));
    }
  }

  private static void convertSubscriptionCanFilterBy(SubscriptionTopicCanFilterByComponent src, Extension tgt) {
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasDescription()) {
      tgt.addExtension(CAN_FILTER_BY_DESCRIPTION_EXTENSION_URL, MarkDown40_50.convertMarkdown(src.getDescriptionElement()));
    }
    if (src.hasResource()) {
      tgt.addExtension(CAN_FILTER_BY_RESOURCE_EXTENSION_URL, Uri40_50.convertUri(src.getResourceElement()));
    }
    if (src.hasFilterParameter()) {
      tgt.addExtension(CAN_FILTER_BY_FILTER_PARMETER_EXTENSION_URL, String40_50.convertString(src.getFilterParameterElement()));
    }
    if (src.hasFilterDefinition()) {
      tgt.addExtension(CAN_FILTER_BY_FILTER_DEFINITION_EXTENSION_URL, Uri40_50.convertUri(src.getFilterDefinitionElement()));
    }

    for (Enumeration<SearchComparator> t : src.getComparator()) {
      tgt.addExtension(CAN_FILTER_BY_COMPARATOR_EXTENSION_URL, new org.hl7.fhir.r4.model.CodeType(t.getCode()));
    }
    for (Enumeration<SearchModifierCode> t : src.getModifier()) {
      tgt.addExtension(CAN_FILTER_BY_MODIFIER_EXTENSION_URL, new org.hl7.fhir.r4.model.CodeType(t.getCode()));
    }
  }

  private static void convertSubscriptionCanFilterBy(Extension src, SubscriptionTopicCanFilterByComponent tgt) {
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt,
        CAN_FILTER_BY_DESCRIPTION_EXTENSION_URL, CAN_FILTER_BY_RESOURCE_EXTENSION_URL, CAN_FILTER_BY_FILTER_PARMETER_EXTENSION_URL, 
        CAN_FILTER_BY_FILTER_DEFINITION_EXTENSION_URL, CAN_FILTER_BY_COMPARATOR_EXTENSION_URL, CAN_FILTER_BY_MODIFIER_EXTENSION_URL);
    
    if (src.hasExtension(CAN_FILTER_BY_DESCRIPTION_EXTENSION_URL)) {
      tgt.setDescriptionElement(MarkDown40_50.convertMarkdown((MarkdownType) src.getExtensionByUrl(CAN_FILTER_BY_DESCRIPTION_EXTENSION_URL).getValue()));
    }
    if (src.hasExtension(CAN_FILTER_BY_RESOURCE_EXTENSION_URL)) {
      tgt.setResourceElement(Uri40_50.convertUri((UriType) src.getExtensionByUrl(CAN_FILTER_BY_RESOURCE_EXTENSION_URL).getValue()));
    }
    if (src.hasExtension(CAN_FILTER_BY_FILTER_PARMETER_EXTENSION_URL)) {
      tgt.setFilterParameterElement(String40_50.convertString((org.hl7.fhir.r4.model.StringType) src.getExtensionByUrl(CAN_FILTER_BY_FILTER_PARMETER_EXTENSION_URL).getValue()));
    }
    if (src.hasExtension(CAN_FILTER_BY_FILTER_DEFINITION_EXTENSION_URL)) {
      tgt.setFilterDefinitionElement(Uri40_50.convertUri((UriType) src.getExtensionByUrl(CAN_FILTER_BY_FILTER_DEFINITION_EXTENSION_URL).getValue()));
    }

    for (Extension ext : src.getExtensionsByUrl(CAN_FILTER_BY_COMPARATOR_EXTENSION_URL)) {
      tgt.addComparatorElement().setValueAsString(ext.getValue().primitiveValue());
    }
    for (Extension ext : src.getExtensionsByUrl(CAN_FILTER_BY_MODIFIER_EXTENSION_URL)) {
      tgt.addModifierElement().setValueAsString(ext.getValue().primitiveValue());
    }
  }

  
  private static void convertSubscriptionNotificationShape(SubscriptionTopicNotificationShapeComponent src, Extension tgt) {
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasResource()) {
      tgt.addExtension(NOTIFICATION_SHAPE_RESOURCE_EXTENSION_URL, Uri40_50.convertUri(src.getResourceElement()));
    }

    for (StringType t : src.getInclude()) {
      tgt.addExtension(NOTIFICATION_SHAPE_INCLUDE_EXTENSION_URL, String40_50.convertString(t));
    }
    for (StringType t : src.getRevInclude()) {
      tgt.addExtension(NOTIFICATION_SHAPE_REV_INCLUDE_EXTENSION_URL, String40_50.convertString(t));
    }
  }


  private static void convertSubscriptionNotificationShape(Extension src, SubscriptionTopicNotificationShapeComponent tgt) {
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt, NOTIFICATION_SHAPE_RESOURCE_EXTENSION_URL, NOTIFICATION_SHAPE_INCLUDE_EXTENSION_URL, NOTIFICATION_SHAPE_REV_INCLUDE_EXTENSION_URL);
    if (src.hasExtension(NOTIFICATION_SHAPE_RESOURCE_EXTENSION_URL)) {
      tgt.setResourceElement(Uri40_50.convertUri((UriType) src.getExtensionByUrl(NOTIFICATION_SHAPE_RESOURCE_EXTENSION_URL).getValue()));
    }
    for (Extension ext : src.getExtensionsByUrl(NOTIFICATION_SHAPE_INCLUDE_EXTENSION_URL)) {
      tgt.addIncludeElement().setValueAsString(ext.getValue().primitiveValue());
    }
    for (Extension ext : src.getExtensionsByUrl(NOTIFICATION_SHAPE_REV_INCLUDE_EXTENSION_URL)) {
      tgt.addRevIncludeElement().setValueAsString(ext.getValue().primitiveValue());
    }
  }

}