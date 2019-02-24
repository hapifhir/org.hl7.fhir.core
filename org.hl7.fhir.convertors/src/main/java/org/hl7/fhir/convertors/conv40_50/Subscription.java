package org.hl7.fhir.convertors.conv40_50;

import org.hl7.fhir.exceptions.FHIRException;

import org.hl7.fhir.convertors.VersionConvertor_40_50;


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


public class Subscription extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.Subscription convertSubscription(org.hl7.fhir.r4.model.Subscription src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Subscription tgt = new org.hl7.fhir.r5.model.Subscription();
    copyDomainResource(src, tgt);
    if (src.hasStatus())
      tgt.setStatus(convertSubscriptionStatus(src.getStatus()));
    for (org.hl7.fhir.r4.model.ContactPoint t : src.getContact())
      tgt.addContact(convertContactPoint(t));
    if (src.hasEnd())
      tgt.setEndElement(convertInstant(src.getEndElement()));
    if (src.hasReason())
      tgt.setReasonElement(convertString(src.getReasonElement()));
    if (src.hasCriteria())
      tgt.setCriteriaElement(convertString(src.getCriteriaElement()));
    if (src.hasError())
      tgt.setErrorElement(convertString(src.getErrorElement()));
    if (src.hasChannel())
      tgt.setChannel(convertSubscriptionChannelComponent(src.getChannel()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Subscription convertSubscription(org.hl7.fhir.r5.model.Subscription src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Subscription tgt = new org.hl7.fhir.r4.model.Subscription();
    copyDomainResource(src, tgt);
    if (src.hasStatus())
      tgt.setStatus(convertSubscriptionStatus(src.getStatus()));
    for (org.hl7.fhir.r5.model.ContactPoint t : src.getContact())
      tgt.addContact(convertContactPoint(t));
    if (src.hasEnd())
      tgt.setEndElement(convertInstant(src.getEndElement()));
    if (src.hasReason())
      tgt.setReasonElement(convertString(src.getReasonElement()));
    if (src.hasCriteria())
      tgt.setCriteriaElement(convertString(src.getCriteriaElement()));
    if (src.hasError())
      tgt.setErrorElement(convertString(src.getErrorElement()));
    if (src.hasChannel())
      tgt.setChannel(convertSubscriptionChannelComponent(src.getChannel()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Subscription.SubscriptionStatus convertSubscriptionStatus(org.hl7.fhir.r4.model.Subscription.SubscriptionStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case REQUESTED: return org.hl7.fhir.r5.model.Subscription.SubscriptionStatus.REQUESTED;
    case ACTIVE: return org.hl7.fhir.r5.model.Subscription.SubscriptionStatus.ACTIVE;
    case ERROR: return org.hl7.fhir.r5.model.Subscription.SubscriptionStatus.ERROR;
    case OFF: return org.hl7.fhir.r5.model.Subscription.SubscriptionStatus.OFF;
    default: return org.hl7.fhir.r5.model.Subscription.SubscriptionStatus.NULL;
  }
}

  public static org.hl7.fhir.r4.model.Subscription.SubscriptionStatus convertSubscriptionStatus(org.hl7.fhir.r5.model.Subscription.SubscriptionStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case REQUESTED: return org.hl7.fhir.r4.model.Subscription.SubscriptionStatus.REQUESTED;
    case ACTIVE: return org.hl7.fhir.r4.model.Subscription.SubscriptionStatus.ACTIVE;
    case ERROR: return org.hl7.fhir.r4.model.Subscription.SubscriptionStatus.ERROR;
    case OFF: return org.hl7.fhir.r4.model.Subscription.SubscriptionStatus.OFF;
    default: return org.hl7.fhir.r4.model.Subscription.SubscriptionStatus.NULL;
  }
}

  public static org.hl7.fhir.r5.model.Subscription.SubscriptionChannelComponent convertSubscriptionChannelComponent(org.hl7.fhir.r4.model.Subscription.SubscriptionChannelComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Subscription.SubscriptionChannelComponent tgt = new org.hl7.fhir.r5.model.Subscription.SubscriptionChannelComponent();
    copyElement(src, tgt);
    if (src.hasType())
      tgt.setType(convertSubscriptionChannelType(src.getType()));
    if (src.hasEndpoint())
      tgt.setEndpointElement(convertUrl(src.getEndpointElement()));
    if (src.hasPayload())
      tgt.setPayloadElement(convertCode(src.getPayloadElement()));
    for (org.hl7.fhir.r4.model.StringType t : src.getHeader())
      tgt.getHeader().add(convertString(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Subscription.SubscriptionChannelComponent convertSubscriptionChannelComponent(org.hl7.fhir.r5.model.Subscription.SubscriptionChannelComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Subscription.SubscriptionChannelComponent tgt = new org.hl7.fhir.r4.model.Subscription.SubscriptionChannelComponent();
    copyElement(src, tgt);
    if (src.hasType())
      tgt.setType(convertSubscriptionChannelType(src.getType()));
    if (src.hasEndpoint())
      tgt.setEndpointElement(convertUrl(src.getEndpointElement()));
    if (src.hasPayload())
      tgt.setPayloadElement(convertCode(src.getPayloadElement()));
    for (org.hl7.fhir.r5.model.StringType t : src.getHeader())
      tgt.getHeader().add(convertString(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Subscription.SubscriptionChannelType convertSubscriptionChannelType(org.hl7.fhir.r4.model.Subscription.SubscriptionChannelType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case RESTHOOK: return org.hl7.fhir.r5.model.Subscription.SubscriptionChannelType.RESTHOOK;
    case WEBSOCKET: return org.hl7.fhir.r5.model.Subscription.SubscriptionChannelType.WEBSOCKET;
    case EMAIL: return org.hl7.fhir.r5.model.Subscription.SubscriptionChannelType.EMAIL;
    case SMS: return org.hl7.fhir.r5.model.Subscription.SubscriptionChannelType.SMS;
    case MESSAGE: return org.hl7.fhir.r5.model.Subscription.SubscriptionChannelType.MESSAGE;
    default: return org.hl7.fhir.r5.model.Subscription.SubscriptionChannelType.NULL;
  }
}

  public static org.hl7.fhir.r4.model.Subscription.SubscriptionChannelType convertSubscriptionChannelType(org.hl7.fhir.r5.model.Subscription.SubscriptionChannelType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case RESTHOOK: return org.hl7.fhir.r4.model.Subscription.SubscriptionChannelType.RESTHOOK;
    case WEBSOCKET: return org.hl7.fhir.r4.model.Subscription.SubscriptionChannelType.WEBSOCKET;
    case EMAIL: return org.hl7.fhir.r4.model.Subscription.SubscriptionChannelType.EMAIL;
    case SMS: return org.hl7.fhir.r4.model.Subscription.SubscriptionChannelType.SMS;
    case MESSAGE: return org.hl7.fhir.r4.model.Subscription.SubscriptionChannelType.MESSAGE;
    default: return org.hl7.fhir.r4.model.Subscription.SubscriptionChannelType.NULL;
  }
}


}
