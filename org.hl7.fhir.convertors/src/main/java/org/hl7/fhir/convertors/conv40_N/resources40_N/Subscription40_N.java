package org.hl7.fhir.convertors.conv40_N.resources40_N;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Coding40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.ContactPoint40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Instant40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionElements40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.Subscription;
import org.hl7.fhir.model.core.Subscription.SubscriptionFilterByComponent;
import org.hl7.fhir.model.core.Subscription.SubscriptionParameterComponent;

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
 * R4 Subscription <-> R6 Subscription, following the Subscriptions R5 Backport IG where it applies.
 *
 * R4 criteria is either
 *  - a topic canonical (the backport form: no '?'): R6 topic, with filterBy from the backport-filter-criteria
 *    extensions on criteria ("Type?param=value&...")
 *  - a search (the classic form): kept as is in a 4.0 extension; R6 topic is the 'everything' topic
 *    ({@link #EVERYTHING_TOPIC}), and filterBy is the search, decomposed
 *
 * channel.type is R6 channelType (the backport-channel-type extension when R4 doesn't have the code);
 * channel.endpoint is endpoint; channel.header ("Name: value") is parameter; channel.payload is contentType, with
 * content in the backport-payload-content extension; heartbeatPeriod, timeout and maxCount are the backport
 * extensions on channel. R4 error is a 4.0 extension; R6 identifier, name and managingEntity are 5.0 extensions.
 *
 * Where the R4 strings (filter criteria, headers) can't be made again from the R6 elements, the R4 form is kept, so
 * the round trip doesn't lose anything
 */
public class Subscription40_N {

  // there isn't one defined yet: this is the topic that classic (search based) R4 subscriptions are about
  public static final String EVERYTHING_TOPIC = "http://hl7.org/fhir/SubscriptionTopic/everything";

  private static final String BACKPORT = "http://hl7.org/fhir/uv/subscriptions-backport/StructureDefinition/";
  public static final String EXT_FILTER_CRITERIA = BACKPORT + "backport-filter-criteria";
  public static final String EXT_CHANNEL_TYPE = BACKPORT + "backport-channel-type";
  public static final String EXT_PAYLOAD_CONTENT = BACKPORT + "backport-payload-content";
  public static final String EXT_HEARTBEAT_PERIOD = BACKPORT + "backport-heartbeat-period";
  public static final String EXT_TIMEOUT = BACKPORT + "backport-timeout";
  public static final String EXT_MAX_COUNT = BACKPORT + "backport-max-count";
  private static final String CHANNEL_TYPE_SYSTEM = "http://terminology.hl7.org/CodeSystem/subscription-channel-type";
  private static final String SD_PREFIX = "http://hl7.org/fhir/StructureDefinition/";
  private static final String[] COMPARATORS = {"eq", "ne", "gt", "lt", "ge", "le", "sa", "eb", "ap"};

  private static final String SUB = "Subscription";
  private static final String CRITERIA_URL = CrossVersionElements40_N.url(SUB, "4.0", "criteria");
  private static final String ERROR_URL = CrossVersionElements40_N.url(SUB, "4.0", "error");
  private static final String HEADER_URL = CrossVersionElements40_N.url("Subscription.channel", "4.0", "header");
  private static final String STATUS_URL = CrossVersionElements40_N.url(SUB, "5.0", "status");
  private static final String TOPIC_URL = CrossVersionElements40_N.url(SUB, "5.0", "topic");
  private static final String[] V5 = {"identifier", "name", "managingEntity"};

  public static Subscription convertSubscription(org.hl7.fhir.r4.model.Subscription src) throws FHIRException {
    if (src == null)
      return null;
    Subscription tgt = new Subscription();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt,
      CrossVersionElements40_N.urls(SUB, "5.0", V5, CrossVersionElements40_N.url(SUB, "5.0", "filterBy"), TOPIC_URL));
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", V5);
    if (src.hasStatus()) {
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src.getStatusElement(), tgt.getStatusElement(), STATUS_URL);
      tgt.getStatusElement().setValueAsString(src.getStatusElement().hasExtension(STATUS_URL)
        ? src.getStatusElement().getExtensionString(STATUS_URL) : src.getStatusElement().getValueAsString());
    }
    for (org.hl7.fhir.r4.model.ContactPoint t : src.getContact())
      tgt.addContact(ContactPoint40_N.convertContactPoint(t));
    if (src.hasEnd())
      tgt.setEndElement(Instant40_N.convertInstant(src.getEndElement()));
    if (src.hasReason())
      tgt.setReasonElement(String40_N.convertString(src.getReasonElement()));
    CrossVersionElements40_N.r4ElementsToExtensions(src, SUB, tgt.getExtension(), "error");

    // criteria
    if (src.hasCriteria()) {
      String criteria = src.getCriteria();
      if (isTopic(criteria)) {
        ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src.getCriteriaElement(), tgt.getTopicElement(), EXT_FILTER_CRITERIA);
        tgt.setTopic(criteria);
        for (org.hl7.fhir.r4.model.Extension e : src.getCriteriaElement().getExtensionsByUrl(EXT_FILTER_CRITERIA)) {
          String fc = e.getValue().primitiveValue();
          List<SubscriptionFilterByComponent> filters = decompose(fc);
          tgt.getFilterByList().addAll(filters);
          if (!fc.equals(compose(filters)))
            // keep the R4 string; R6 -> R4 uses it rather than composing one
            tgt.getTopicElement().addExtension(EXT_FILTER_CRITERIA, new org.hl7.fhir.model.core.StringType(fc));
        }
      } else {
        tgt.addExtension(CrossVersionElements40_N.url(SUB, "4.0", "criteria"), String40_N.convertString(src.getCriteriaElement()));
        tgt.setTopic(EVERYTHING_TOPIC);
        tgt.getFilterByList().addAll(decompose(criteria));
      }
    }
    // a topic that the R4 criteria couldn't carry
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "topic");
    // filters that the R4 strings couldn't carry
    if (src.hasExtension(CrossVersionElements40_N.url(SUB, "5.0", "filterBy"))) {
      tgt.getFilterByList().clear();
      CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "filterBy");
    }

    // channel
    if (src.hasChannel()) {
      org.hl7.fhir.r4.model.Subscription.SubscriptionChannelComponent ch = src.getChannel();
      if (ch.getTypeElement().hasExtension(EXT_CHANNEL_TYPE))
        tgt.setChannelType(Coding40_N.convertCoding((org.hl7.fhir.r4.model.Coding) ch.getTypeElement().getExtensionByUrl(EXT_CHANNEL_TYPE).getValue()));
      else if (ch.hasType())
        tgt.setChannelType(new org.hl7.fhir.model.core.Coding(CHANNEL_TYPE_SYSTEM, ch.getTypeElement().getValueAsString(), null));
      if (ch.hasEndpoint())
        tgt.getEndpointElement().setValue(ch.getEndpoint());
      for (org.hl7.fhir.r4.model.StringType h : ch.getHeader()) {
        SubscriptionParameterComponent p = headerToParameter(h.getValue());
        if (p != null && h.getValue().equals(parameterToHeader(p)) && !h.hasExtension() && !h.hasId())
          tgt.getParameterList().add(p);
        else
          tgt.addExtension(HEADER_URL, String40_N.convertString(h));
      }
      if (ch.hasPayload())
        tgt.setContentType(ch.getPayload());
      if (ch.getPayloadElement().hasExtension(EXT_PAYLOAD_CONTENT))
        tgt.getContentElement().setValueAsString(ch.getPayloadElement().getExtensionString(EXT_PAYLOAD_CONTENT));
      if (ch.hasExtension(EXT_HEARTBEAT_PERIOD))
        tgt.getHeartbeatPeriodElement().setValueAsString(ch.getExtensionString(EXT_HEARTBEAT_PERIOD));
      if (ch.hasExtension(EXT_TIMEOUT))
        tgt.getTimeoutElement().setValueAsString(ch.getExtensionString(EXT_TIMEOUT));
      if (ch.hasExtension(EXT_MAX_COUNT))
        tgt.getMaxCountElement().setValueAsString(ch.getExtensionString(EXT_MAX_COUNT));
    }
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Subscription convertSubscription(Subscription src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Subscription tgt = new org.hl7.fhir.r4.model.Subscription();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, CRITERIA_URL, ERROR_URL, HEADER_URL);
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "5.0", V5);
    if (src.hasStatus()) {
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src.getStatusElement(), tgt.getStatusElement());
      if ("entered-in-error".equals(src.getStatusElement().getValueAsString())) {
        // R4 doesn't have entered-in-error
        tgt.getStatusElement().setValue(org.hl7.fhir.r4.model.Subscription.SubscriptionStatus.OFF);
        tgt.getStatusElement().addExtension(STATUS_URL, new org.hl7.fhir.r4.model.CodeType("entered-in-error"));
      } else
        tgt.getStatusElement().setValueAsString(src.getStatusElement().getValueAsString());
    }
    for (org.hl7.fhir.model.core.ContactPoint t : src.getContactList())
      tgt.addContact(ContactPoint40_N.convertContactPoint(t));
    if (src.hasEnd())
      tgt.setEndElement(Instant40_N.convertInstant(src.getEndElement()));
    if (src.hasReason())
      tgt.setReasonElement(String40_N.convertString(src.getReasonElement()));
    CrossVersionElements40_N.extensionsToR4Elements(src.getExtension(), tgt, SUB, "error");

    // criteria
    if (src.hasExtension(CRITERIA_URL)) {
      // classic: the search, as it was
      tgt.setCriteriaElement(String40_N.convertString((org.hl7.fhir.model.core.StringType) src.getExtensionByUrl(CRITERIA_URL).getValue()));
      if (src.hasTopic() && !EVERYTHING_TOPIC.equals(src.getTopic()))
        CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "5.0", "topic");
      if (!sameFilters(decompose(tgt.getCriteria()), src.getFilterByList()))
        CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "5.0", "filterBy");
    } else if (src.hasTopic()) {
      // backport: the topic, with the filters
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src.getTopicElement(), tgt.getCriteriaElement(), EXT_FILTER_CRITERIA);
      tgt.setCriteria(src.getTopic());
      List<String> kept = new ArrayList<>();
      for (org.hl7.fhir.model.core.Extension e : src.getTopicElement().getExtensionsByUrl(EXT_FILTER_CRITERIA))
        kept.add(e.getValue().primitiveValue());
      List<String> criteria = kept.isEmpty() ? composeAll(src.getFilterByList()) : kept;
      List<SubscriptionFilterByComponent> regenerated = new ArrayList<>();
      for (String c : criteria)
        regenerated.addAll(decompose(c));
      if (sameFilters(regenerated, src.getFilterByList())) {
        for (String c : criteria)
          tgt.getCriteriaElement().addExtension(EXT_FILTER_CRITERIA, new org.hl7.fhir.r4.model.StringType(c));
      } else
        CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "5.0", "filterBy");
    } else if (src.hasFilterBy())
      CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "5.0", "filterBy");

    // channel
    org.hl7.fhir.r4.model.Subscription.SubscriptionChannelComponent ch = tgt.getChannel();
    if (src.hasChannelType()) {
      org.hl7.fhir.model.core.Coding ct = src.getChannelType();
      boolean r4Code = (!ct.hasSystem() || CHANNEL_TYPE_SYSTEM.equals(ct.getSystem()))
        && org.hl7.fhir.utilities.Utilities.existsInList(ct.getCode(), "rest-hook", "websocket", "email", "sms", "message");
      if (r4Code)
        ch.getTypeElement().setValueAsString(ct.getCode());
      if (!r4Code || !ct.equalsDeep(new org.hl7.fhir.model.core.Coding(CHANNEL_TYPE_SYSTEM, ct.getCode(), null)))
        ch.getTypeElement().addExtension(EXT_CHANNEL_TYPE, Coding40_N.convertCoding(ct));
    }
    if (src.hasEndpoint())
      ch.setEndpoint(src.getEndpoint());
    for (SubscriptionParameterComponent p : src.getParameterList())
      ch.addHeader(parameterToHeader(p));
    for (org.hl7.fhir.model.core.Extension e : src.getExtensionsByUrl(HEADER_URL))
      ch.getHeader().add(String40_N.convertString((org.hl7.fhir.model.core.StringType) e.getValue()));
    if (src.hasContentType())
      ch.setPayload(src.getContentType());
    if (src.hasContent())
      ch.getPayloadElement().addExtension(EXT_PAYLOAD_CONTENT, new org.hl7.fhir.r4.model.CodeType(src.getContentElement().getValueAsString()));
    if (src.hasHeartbeatPeriod())
      ch.addExtension(EXT_HEARTBEAT_PERIOD, new org.hl7.fhir.r4.model.UnsignedIntType(src.getHeartbeatPeriod()));
    if (src.hasTimeout())
      ch.addExtension(EXT_TIMEOUT, new org.hl7.fhir.r4.model.UnsignedIntType(src.getTimeout()));
    if (src.hasMaxCount())
      ch.addExtension(EXT_MAX_COUNT, new org.hl7.fhir.r4.model.PositiveIntType(src.getMaxCount()));
    return tgt;
  }

  // a topic is a canonical; a search has a '?' in it
  private static boolean isTopic(String criteria) {
    return !criteria.contains("?") && (criteria.startsWith("http:") || criteria.startsWith("https:") || criteria.startsWith("urn:"));
  }

  /**
   * "Type?a=1&b:modifier=ge2" -> filterBy (resource = the type's StructureDefinition, filterParameter, modifier,
   * comparator - when the value is a comparator followed by a digit - and value)
   */
  public static List<SubscriptionFilterByComponent> decompose(String criteria) {
    List<SubscriptionFilterByComponent> res = new ArrayList<>();
    if (criteria == null)
      return res;
    int q = criteria.indexOf("?");
    String type = q < 0 ? null : criteria.substring(0, q);
    String query = q < 0 ? criteria : criteria.substring(q + 1);
    for (String part : org.hl7.fhir.utilities.Utilities.simpleSplit(query, "&")) {
      if (part.isEmpty())
        continue;
      SubscriptionFilterByComponent f = new SubscriptionFilterByComponent();
      if (type != null && !type.isEmpty())
        f.setResource(SD_PREFIX + type);
      int eq = part.indexOf("=");
      String name = eq < 0 ? part : part.substring(0, eq);
      String value = eq < 0 ? null : part.substring(eq + 1);
      int colon = name.indexOf(":");
      if (colon >= 0) {
        try {
          f.getModifierElement().setValueAsString(name.substring(colon + 1));
          name = name.substring(0, colon);
        } catch (Exception e) {
          // not a modifier R6 knows: it stays in the name
          f.setModifierElement(null);
        }
      }
      f.setFilterParameter(name);
      if (value != null) {
        for (String c : COMPARATORS) {
          if (value.length() > 2 && value.startsWith(c) && Character.isDigit(value.charAt(2))) {
            f.getComparatorElement().setValueAsString(c);
            value = value.substring(2);
            break;
          }
        }
        f.setValue(value);
      }
      res.add(f);
    }
    return res;
  }

  // the filters for one resource, as a search
  private static String compose(List<SubscriptionFilterByComponent> filters) {
    StringBuilder b = new StringBuilder();
    String resource = filters.isEmpty() || !filters.get(0).hasResource() ? "" : filters.get(0).getResource();
    b.append(resource.startsWith(SD_PREFIX) ? resource.substring(SD_PREFIX.length()) : resource);
    b.append("?");
    boolean first = true;
    for (SubscriptionFilterByComponent f : filters) {
      if (!first)
        b.append("&");
      first = false;
      b.append(f.getFilterParameter());
      if (f.hasModifier())
        b.append(":").append(f.getModifierElement().getValueAsString());
      if (f.hasValue() || f.hasComparator()) {
        b.append("=");
        if (f.hasComparator())
          b.append(f.getComparatorElement().getValueAsString());
        if (f.hasValue())
          b.append(f.getValue());
      }
    }
    return b.toString();
  }

  // one search per resource, in order
  private static List<String> composeAll(List<SubscriptionFilterByComponent> filters) {
    List<String> res = new ArrayList<>();
    List<SubscriptionFilterByComponent> group = new ArrayList<>();
    String current = null;
    for (SubscriptionFilterByComponent f : filters) {
      String r = f.hasResource() ? f.getResource() : "";
      if (!group.isEmpty() && !r.equals(current)) {
        res.add(compose(group));
        group = new ArrayList<>();
      }
      current = r;
      group.add(f);
    }
    if (!group.isEmpty())
      res.add(compose(group));
    return res;
  }

  private static boolean sameFilters(List<SubscriptionFilterByComponent> a, List<SubscriptionFilterByComponent> b) {
    if (a.size() != b.size())
      return false;
    for (int i = 0; i < a.size(); i++)
      if (!a.get(i).equalsDeep(b.get(i)))
        return false;
    return true;
  }

  // "Name: value"
  private static SubscriptionParameterComponent headerToParameter(String header) {
    int i = header == null ? -1 : header.indexOf(":");
    if (i <= 0)
      return null;
    SubscriptionParameterComponent p = new SubscriptionParameterComponent();
    p.setName(header.substring(0, i).trim());
    p.setValue(header.substring(i + 1).trim());
    return p;
  }

  private static String parameterToHeader(SubscriptionParameterComponent p) {
    return p.getName() + ": " + p.getValue();
  }
}
