package org.hl7.fhir.convertors.conv43_N.resources43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.CodeableConcept43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Identifier43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.metadata43_N.ContactDetail43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.metadata43_N.UsageContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Boolean43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Canonical43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.DateTime43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.MarkDown43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Uri43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.*;
import org.hl7.fhir.r4b.model.BooleanType;
import org.hl7.fhir.r4b.model.Extension;
import org.hl7.fhir.r4b.model.MarkdownType;
import org.hl7.fhir.r4b.model.UriType;
import org.hl7.fhir.model.core.Enumerations.PublicationStatus;
import org.hl7.fhir.model.core.Enumerations.SearchComparator;
import org.hl7.fhir.model.core.Enumerations.SearchModifierCode;
import org.hl7.fhir.model.core.SubscriptionTopic.InteractionTrigger;

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

public class SubscriptionTopic43_N {

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

  public static org.hl7.fhir.model.core.SubscriptionTopic convertSubscriptionTopic(org.hl7.fhir.r4b.model.Basic src) throws FHIRException {
    if (src == null)
      return null;
    if (!src.getCode().hasCoding("http://hl7.org/fhir/fhir-types", "SubscriptionTopic")) {
      throw new FHIRException("Error in logic: this basic resource is not an SubscriptionTopic");
    }
    org.hl7.fhir.model.core.SubscriptionTopic tgt = new org.hl7.fhir.model.core.SubscriptionTopic();

    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt, IGNORED_EXTENSION_URLS);
    
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));

    if (src.hasExtension(URL_EXTENSION_URL)) {
      tgt.setUrlElement(Uri43_N.convertUri((org.hl7.fhir.r4b.model.UriType) src.getExtensionByUrl(URL_EXTENSION_URL).getValue()));
    }
    if (src.hasExtension(VERSION_EXTENSION_URL)) {
      tgt.setVersionElement(String43_N.convertString((org.hl7.fhir.r4b.model.StringType) src.getExtensionByUrl(VERSION_EXTENSION_URL).getValue()));
    }
    if (src.hasExtension(NAME_EXTENSION_URL)) {
      tgt.setNameElement(String43_N.convertString((org.hl7.fhir.r4b.model.StringType) src.getExtensionByUrl(NAME_EXTENSION_URL).getValue()));
    }
    if (src.hasExtension(TITLE_EXTENSION_URL)) {
      tgt.setTitleElement(String43_N.convertString((org.hl7.fhir.r4b.model.StringType) src.getExtensionByUrl(TITLE_EXTENSION_URL).getValue()));
    }
    if (src.hasExtension(STATUS_EXTENSION_URL)) {
      tgt.setStatus(PublicationStatus.fromCode(src.getExtensionByUrl(STATUS_EXTENSION_URL).getValue().primitiveValue()));
    }
    if (src.hasExtension(EXPERIMENTAL_EXTENSION_URL)) {
      tgt.setExperimentalElement(Boolean43_N.convertBoolean((org.hl7.fhir.r4b.model.BooleanType) src.getExtensionByUrl(EXPERIMENTAL_EXTENSION_URL).getValue()));
    }
    if (src.hasExtension(DATE_EXTENSION_URL)) {
      tgt.setDateElement(DateTime43_N.convertDateTime((org.hl7.fhir.r4b.model.DateTimeType) src.getExtensionByUrl(DATE_EXTENSION_URL).getValue()));
    }
    if (src.hasExtension(PUBLISHER_EXTENSION_URL)) {
      tgt.setPublisherElement(String43_N.convertString((org.hl7.fhir.r4b.model.StringType) src.getExtensionByUrl(PUBLISHER_EXTENSION_URL).getValue()));
    }
    for (org.hl7.fhir.r4b.model.Extension ext : src.getExtensionsByUrl(CONTACT_EXTENSION_URL)) {
      tgt.addContact(ContactDetail43_N.convertContactDetail((org.hl7.fhir.r4b.model.ContactDetail) ext.getValue()));
    }
    if (src.hasExtension(DESCRIPTION_EXTENSION_URL)) {
      tgt.setDescriptionElement(MarkDown43_N.convertMarkdown((org.hl7.fhir.r4b.model.MarkdownType) src.getExtensionByUrl(DESCRIPTION_EXTENSION_URL).getValue()));
    }
    for (org.hl7.fhir.r4b.model.Extension ext : src.getExtensionsByUrl(USE_CONTEXT_EXTENSION_URL)) {
      tgt.addUseContext(UsageContext43_N.convertUsageContext((org.hl7.fhir.r4b.model.UsageContext) ext.getValue()));
    }
    for (org.hl7.fhir.r4b.model.Extension ext : src.getExtensionsByUrl(JURISDICTION_EXTENSION_URL)) {
      tgt.addJurisdiction(CodeableConcept43_N.convertCodeableConcept((org.hl7.fhir.r4b.model.CodeableConcept) ext.getValue()));
    }
    if (src.hasExtension(PURPOSE_EXTENSION_URL)) {
      tgt.setPurposeElement(MarkDown43_N.convertMarkdown((org.hl7.fhir.r4b.model.MarkdownType) src.getExtensionByUrl(PURPOSE_EXTENSION_URL).getValue()));
    }
    if (src.hasExtension(COPYRIGHT_EXTENSION_URL)) {
      tgt.setCopyrightElement(MarkDown43_N.convertMarkdown((org.hl7.fhir.r4b.model.MarkdownType) src.getExtensionByUrl(COPYRIGHT_EXTENSION_URL).getValue()));
    }
    if (src.hasExtension(COPYRIGHT_LABEL_EXTENSION_URL)) {
      tgt.setCopyrightLabelElement(String43_N.convertString((org.hl7.fhir.r4b.model.StringType) src.getExtensionByUrl(COPYRIGHT_LABEL_EXTENSION_URL).getValue()));
    }
    return tgt;
  }


  public static org.hl7.fhir.r4b.model.Basic convertSubscriptionTopic(org.hl7.fhir.model.core.SubscriptionTopic src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Basic tgt = new org.hl7.fhir.r4b.model.Basic();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    tgt.getCode().getCodingFirstRep().setSystem("http://hl7.org/fhir/fhir-types").setCode("SubscriptionTopic"); // note use of R5 type system
    
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasUrl()) {
      tgt.addExtension(URL_EXTENSION_URL, Uri43_N.convertUri(src.getUrlElement()));
    }
    if (src.hasVersion()) {
      tgt.addExtension(VERSION_EXTENSION_URL, String43_N.convertString(src.getVersionElement()));
    }
    if (src.hasName()) {
      tgt.addExtension(NAME_EXTENSION_URL, String43_N.convertString(src.getNameElement()));
    }
    if (src.hasTitle()) {
      tgt.addExtension(TITLE_EXTENSION_URL, String43_N.convertString(src.getTitleElement()));
    }
    if (src.hasStatus()) {
      tgt.addExtension(STATUS_EXTENSION_URL, new org.hl7.fhir.r4b.model.CodeType(src.getStatus().toCode()));
    }
    if (src.hasExperimental()) {
      tgt.addExtension(EXPERIMENTAL_EXTENSION_URL, Boolean43_N.convertBoolean(src.getExperimentalElement()));
    }
    if (src.hasDate()) {
      tgt.addExtension(DATE_EXTENSION_URL, DateTime43_N.convertDateTime(src.getDateElement()));
    }
    if (src.hasPublisher()) {
      tgt.addExtension(PUBLISHER_EXTENSION_URL, String43_N.convertString(src.getPublisherElement()));
    }
    for (ContactDetail cd : src.getContactList()) {
      tgt.addExtension(CONTACT_EXTENSION_URL, ContactDetail43_N.convertContactDetail(cd));
    }
    if (src.hasDescription()) {
      tgt.addExtension(DESCRIPTION_EXTENSION_URL, MarkDown43_N.convertMarkdown(src.getDescriptionElement()));
    }
    for (UsageContext cd : src.getUseContextList()) {
      tgt.addExtension(USE_CONTEXT_EXTENSION_URL, UsageContext43_N.convertUsageContext(cd));
    }
    for (CodeableConcept cd : src.getJurisdictionList()) {
      tgt.addExtension(JURISDICTION_EXTENSION_URL, CodeableConcept43_N.convertCodeableConcept(cd));
    }
    if (src.hasPurpose()) {
      tgt.addExtension(PURPOSE_EXTENSION_URL, MarkDown43_N.convertMarkdown(src.getPurposeElement()));
    }
    if (src.hasCopyright()) {
      tgt.addExtension(COPYRIGHT_EXTENSION_URL, MarkDown43_N.convertMarkdown(src.getCopyrightElement()));
    }
    if (src.hasCopyrightLabel()) {
      tgt.addExtension(COPYRIGHT_LABEL_EXTENSION_URL, String43_N.convertString(src.getCopyrightLabelElement()));
    }
    for (CanonicalType ref : src.getDerivedFromList()) {
      tgt.addExtension(DERIVED_FROM_EXTENSION_URL, Canonical43_N.convertCanonical(ref));
    }

    return tgt;
  }

  private static void convertSubscriptionResourceTrigger(SubscriptionTopic.SubscriptionTopicTriggerComponent src, Extension tgt) {
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasDescription()) {
      tgt.addExtension(RESOURCE_TRIGGER_DESCRIPTION_EXTENSION_URL, MarkDown43_N.convertMarkdown(src.getDescriptionElement()));
    }
    if (src.hasResource()) {
      tgt.addExtension(RESOURCE_TRIGGER_RESOURCE_EXTENSION_URL, Uri43_N.convertUri(src.getResourceElement()));
    }
    for (Enumeration<InteractionTrigger> t : src.getSupportedInteractionList()) {
      tgt.addExtension(RESOURCE_TRIGGER_SUPPORTED_INTERACTION_EXTENSION_URL, new org.hl7.fhir.r4b.model.CodeType(t.getCode()));
    }
    if (src.hasQueryCriteria()) {
      Extension tgtQF = new Extension(RESOURCE_TRIGGER_QUERY_CRITERIA_EXTENSION_URL);
      tgt.addExtension(tgtQF);
      if (src.getQueryCriteria().hasPrevious()) {
        tgtQF.addExtension(RESOURCE_TRIGGER_QUERY_CRITERIA_PREVIOUS_EXTENSION_URL, String43_N.convertString(src.getQueryCriteria().getPreviousElement()));
      }
      if (src.getQueryCriteria().hasResultForCreate()) {
        tgtQF.addExtension(RESOURCE_TRIGGER_QUERY_CRITERIA_RESULT_FOR_CREATE_EXTENSION_URL, new org.hl7.fhir.r4b.model.CodeType(src.getQueryCriteria().getResultForCreate().toCode()));
      }
      if (src.getQueryCriteria().hasCurrent()) {
        tgtQF.addExtension(RESOURCE_TRIGGER_QUERY_CRITERIA_CURRENT_EXTENSION_URL, String43_N.convertString(src.getQueryCriteria().getCurrentElement()));
      }
      if (src.getQueryCriteria().hasResultForDelete()) {
        tgtQF.addExtension(RESOURCE_TRIGGER_QUERY_CRITERIA_RESULT_FOR_DELETE_EXTENSION_URL, new org.hl7.fhir.r4b.model.CodeType(src.getQueryCriteria().getResultForDelete().toCode()));
      }
      if (src.getQueryCriteria().hasRequireBoth()) {
        tgtQF.addExtension(RESOURCE_TRIGGER_QUERY_CRITERIA_REQUIRE_BOTH_EXTENSION_URL, Boolean43_N.convertBoolean(src.getQueryCriteria().getRequireBothElement()));
      }
    }
    if (src.hasFhirPathCriteria()) {
      tgt.addExtension(RESOURCE_TRIGGER_FHIRPATH_CRITERIA_EXTENSION_URL, String43_N.convertString(src.getFhirPathCriteriaElement()));
    }
  }

  private static void convertSubscriptionResourceTrigger(Extension src, SubscriptionTopic.SubscriptionTopicTriggerComponent tgt) {
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt, 
        RESOURCE_TRIGGER_DESCRIPTION_EXTENSION_URL, RESOURCE_TRIGGER_RESOURCE_EXTENSION_URL, RESOURCE_TRIGGER_QUERY_CRITERIA_EXTENSION_URL,
        RESOURCE_TRIGGER_SUPPORTED_INTERACTION_EXTENSION_URL, RESOURCE_TRIGGER_FHIRPATH_CRITERIA_EXTENSION_URL);
    if (src.hasExtension(RESOURCE_TRIGGER_DESCRIPTION_EXTENSION_URL)) {
      tgt.setDescriptionElement(MarkDown43_N.convertMarkdown((MarkdownType) src.getExtensionByUrl(RESOURCE_TRIGGER_DESCRIPTION_EXTENSION_URL).getValue()));
    }
    if (src.hasExtension(RESOURCE_TRIGGER_RESOURCE_EXTENSION_URL)) {
      tgt.setResourceElement(Uri43_N.convertUri((UriType) src.getExtensionByUrl(RESOURCE_TRIGGER_RESOURCE_EXTENSION_URL).getValue()));
    }
    for (Extension ext : src.getExtensionsByUrl(RESOURCE_TRIGGER_SUPPORTED_INTERACTION_EXTENSION_URL)) {
      tgt.addSupportedInteractionElement().setValueAsString(ext.getValue().primitiveValue());
    }
    if (src.hasExtension(RESOURCE_TRIGGER_QUERY_CRITERIA_EXTENSION_URL)) {
      Extension srcQF = src.getExtensionByUrl(RESOURCE_TRIGGER_QUERY_CRITERIA_EXTENSION_URL); 
      SubscriptionTopic.SubscriptionTopicTriggerQueryCriteriaComponent tgtQF = tgt.getQueryCriteria();
      if (srcQF.hasExtension(RESOURCE_TRIGGER_QUERY_CRITERIA_PREVIOUS_EXTENSION_URL)) {
        tgtQF.setPreviousElement(String43_N.convertString((org.hl7.fhir.r4b.model.StringType) srcQF.getExtensionByUrl(RESOURCE_TRIGGER_QUERY_CRITERIA_PREVIOUS_EXTENSION_URL).getValue()));
      }
      if (srcQF.hasExtension(RESOURCE_TRIGGER_QUERY_CRITERIA_RESULT_FOR_CREATE_EXTENSION_URL)) {
        tgtQF.getResultForCreateElement().setValueAsString(srcQF.getExtensionByUrl(RESOURCE_TRIGGER_QUERY_CRITERIA_RESULT_FOR_CREATE_EXTENSION_URL).getValue().primitiveValue());
      }
      if (srcQF.hasExtension(RESOURCE_TRIGGER_QUERY_CRITERIA_CURRENT_EXTENSION_URL)) {
        tgtQF.setCurrentElement(String43_N.convertString((org.hl7.fhir.r4b.model.StringType) srcQF.getExtensionByUrl(RESOURCE_TRIGGER_QUERY_CRITERIA_CURRENT_EXTENSION_URL).getValue()));
      }
      if (srcQF.hasExtension(RESOURCE_TRIGGER_QUERY_CRITERIA_RESULT_FOR_DELETE_EXTENSION_URL)) {
        tgtQF.getResultForDeleteElement().setValueAsString(srcQF.getExtensionByUrl(RESOURCE_TRIGGER_QUERY_CRITERIA_RESULT_FOR_DELETE_EXTENSION_URL).getValue().primitiveValue());
      }
      if (srcQF.hasExtension(RESOURCE_TRIGGER_QUERY_CRITERIA_REQUIRE_BOTH_EXTENSION_URL)) {
        tgtQF.setRequireBothElement(Boolean43_N.convertBoolean((BooleanType) srcQF.getExtensionByUrl(RESOURCE_TRIGGER_QUERY_CRITERIA_REQUIRE_BOTH_EXTENSION_URL).getValue()));
      }
    }
    if (src.hasExtension(RESOURCE_TRIGGER_FHIRPATH_CRITERIA_EXTENSION_URL)) {
      tgt.setFhirPathCriteriaElement(String43_N.convertString((org.hl7.fhir.r4b.model.StringType) src.getExtensionByUrl(RESOURCE_TRIGGER_FHIRPATH_CRITERIA_EXTENSION_URL).getValue()));
    }
  }

}