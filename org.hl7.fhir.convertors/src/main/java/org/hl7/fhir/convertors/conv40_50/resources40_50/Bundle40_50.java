package org.hl7.fhir.convertors.conv40_50.resources40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Identifier40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Signature40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Decimal40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Instant40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.String40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.UnsignedInt40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Uri40_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.Bundle.LinkRelationTypes;

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
public class Bundle40_50 {

  public static org.hl7.fhir.r5.model.Bundle convertBundle(org.hl7.fhir.r4.model.Bundle src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Bundle tgt = new org.hl7.fhir.r5.model.Bundle();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyResource(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier40_50.convertIdentifier(src.getIdentifier()));
    if (src.hasType())
      tgt.setTypeElement(convertBundleType(src.getTypeElement()));
    if (src.hasTimestamp())
      tgt.setTimestampElement(Instant40_50.convertInstant(src.getTimestampElement()));
    if (src.hasTotal())
      tgt.setTotalElement(UnsignedInt40_50.convertUnsignedInt(src.getTotalElement()));
    for (org.hl7.fhir.r4.model.Bundle.BundleLinkComponent t : src.getLink()) tgt.addLink(convertBundleLinkComponent(t));
    for (org.hl7.fhir.r4.model.Bundle.BundleEntryComponent t : src.getEntry())
      tgt.addEntry(convertBundleEntryComponent(t));
    if (src.hasSignature())
      tgt.setSignature(Signature40_50.convertSignature(src.getSignature()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Bundle convertBundle(org.hl7.fhir.r5.model.Bundle src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Bundle tgt = new org.hl7.fhir.r4.model.Bundle();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyResource(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier40_50.convertIdentifier(src.getIdentifier()));
    if (src.hasType())
      tgt.setTypeElement(convertBundleType(src.getTypeElement()));
    if (src.hasTimestamp())
      tgt.setTimestampElement(Instant40_50.convertInstant(src.getTimestampElement()));
    if (src.hasTotal())
      tgt.setTotalElement(UnsignedInt40_50.convertUnsignedInt(src.getTotalElement()));
    for (org.hl7.fhir.r5.model.Bundle.BundleLinkComponent t : src.getLink()) tgt.addLink(convertBundleLinkComponent(t));
    for (org.hl7.fhir.r5.model.Bundle.BundleEntryComponent t : src.getEntry())
      tgt.addEntry(convertBundleEntryComponent(t));
    if (src.hasSignature())
      tgt.setSignature(Signature40_50.convertSignature(src.getSignature()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Bundle.BundleType> convertBundleType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Bundle.BundleType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Bundle.BundleType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Bundle.BundleTypeEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case DOCUMENT:
        tgt.setValue(org.hl7.fhir.r5.model.Bundle.BundleType.DOCUMENT);
        break;
      case MESSAGE:
        tgt.setValue(org.hl7.fhir.r5.model.Bundle.BundleType.MESSAGE);
        break;
      case TRANSACTION:
        tgt.setValue(org.hl7.fhir.r5.model.Bundle.BundleType.TRANSACTION);
        break;
      case TRANSACTIONRESPONSE:
        tgt.setValue(org.hl7.fhir.r5.model.Bundle.BundleType.TRANSACTIONRESPONSE);
        break;
      case BATCH:
        tgt.setValue(org.hl7.fhir.r5.model.Bundle.BundleType.BATCH);
        break;
      case BATCHRESPONSE:
        tgt.setValue(org.hl7.fhir.r5.model.Bundle.BundleType.BATCHRESPONSE);
        break;
      case HISTORY:
        tgt.setValue(org.hl7.fhir.r5.model.Bundle.BundleType.HISTORY);
        break;
      case SEARCHSET:
        tgt.setValue(org.hl7.fhir.r5.model.Bundle.BundleType.SEARCHSET);
        break;
      case COLLECTION:
        tgt.setValue(org.hl7.fhir.r5.model.Bundle.BundleType.COLLECTION);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Bundle.BundleType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Bundle.BundleType> convertBundleType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Bundle.BundleType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Bundle.BundleType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Bundle.BundleTypeEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case DOCUMENT:
        tgt.setValue(org.hl7.fhir.r4.model.Bundle.BundleType.DOCUMENT);
        break;
      case MESSAGE:
        tgt.setValue(org.hl7.fhir.r4.model.Bundle.BundleType.MESSAGE);
        break;
      case TRANSACTION:
        tgt.setValue(org.hl7.fhir.r4.model.Bundle.BundleType.TRANSACTION);
        break;
      case TRANSACTIONRESPONSE:
        tgt.setValue(org.hl7.fhir.r4.model.Bundle.BundleType.TRANSACTIONRESPONSE);
        break;
      case BATCH:
        tgt.setValue(org.hl7.fhir.r4.model.Bundle.BundleType.BATCH);
        break;
      case BATCHRESPONSE:
        tgt.setValue(org.hl7.fhir.r4.model.Bundle.BundleType.BATCHRESPONSE);
        break;
      case HISTORY:
        tgt.setValue(org.hl7.fhir.r4.model.Bundle.BundleType.HISTORY);
        break;
      case SEARCHSET:
        tgt.setValue(org.hl7.fhir.r4.model.Bundle.BundleType.SEARCHSET);
        break;
      case COLLECTION:
        tgt.setValue(org.hl7.fhir.r4.model.Bundle.BundleType.COLLECTION);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.Bundle.BundleType.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Bundle.BundleLinkComponent convertBundleLinkComponent(org.hl7.fhir.r4.model.Bundle.BundleLinkComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Bundle.BundleLinkComponent tgt = new org.hl7.fhir.r5.model.Bundle.BundleLinkComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasRelation())
      tgt.setRelation(LinkRelationTypes.fromCode(src.getRelation()));
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_50.convertUri(src.getUrlElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Bundle.BundleLinkComponent convertBundleLinkComponent(org.hl7.fhir.r5.model.Bundle.BundleLinkComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Bundle.BundleLinkComponent tgt = new org.hl7.fhir.r4.model.Bundle.BundleLinkComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasRelation())
      tgt.setRelation((src.getRelation().toCode()));
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_50.convertUri(src.getUrlElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Bundle.BundleEntryComponent convertBundleEntryComponent(org.hl7.fhir.r4.model.Bundle.BundleEntryComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Bundle.BundleEntryComponent tgt = new org.hl7.fhir.r5.model.Bundle.BundleEntryComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4.model.Bundle.BundleLinkComponent t : src.getLink()) tgt.addLink(convertBundleLinkComponent(t));
    if (src.hasFullUrl())
      tgt.setFullUrlElement(Uri40_50.convertUri(src.getFullUrlElement()));
    if (src.hasResource())
      tgt.setResource(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertResource(src.getResource()));
    if (src.hasSearch())
      tgt.setSearch(convertBundleEntrySearchComponent(src.getSearch()));
    if (src.hasRequest())
      tgt.setRequest(convertBundleEntryRequestComponent(src.getRequest()));
    if (src.hasResponse())
      tgt.setResponse(convertBundleEntryResponseComponent(src.getResponse()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Bundle.BundleEntryComponent convertBundleEntryComponent(org.hl7.fhir.r5.model.Bundle.BundleEntryComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Bundle.BundleEntryComponent tgt = new org.hl7.fhir.r4.model.Bundle.BundleEntryComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r5.model.Bundle.BundleLinkComponent t : src.getLink()) tgt.addLink(convertBundleLinkComponent(t));
    if (src.hasFullUrl())
      tgt.setFullUrlElement(Uri40_50.convertUri(src.getFullUrlElement()));
    if (src.hasResource())
      tgt.setResource(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertResource(src.getResource()));
    if (src.hasSearch())
      tgt.setSearch(convertBundleEntrySearchComponent(src.getSearch()));
    if (src.hasRequest())
      tgt.setRequest(convertBundleEntryRequestComponent(src.getRequest()));
    if (src.hasResponse())
      tgt.setResponse(convertBundleEntryResponseComponent(src.getResponse()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Bundle.BundleEntrySearchComponent convertBundleEntrySearchComponent(org.hl7.fhir.r4.model.Bundle.BundleEntrySearchComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Bundle.BundleEntrySearchComponent tgt = new org.hl7.fhir.r5.model.Bundle.BundleEntrySearchComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasMode())
      tgt.setModeElement(convertSearchEntryMode(src.getModeElement()));
    if (src.hasScore())
      tgt.setScoreElement(Decimal40_50.convertDecimal(src.getScoreElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Bundle.BundleEntrySearchComponent convertBundleEntrySearchComponent(org.hl7.fhir.r5.model.Bundle.BundleEntrySearchComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Bundle.BundleEntrySearchComponent tgt = new org.hl7.fhir.r4.model.Bundle.BundleEntrySearchComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasMode())
      tgt.setModeElement(convertSearchEntryMode(src.getModeElement()));
    if (src.hasScore())
      tgt.setScoreElement(Decimal40_50.convertDecimal(src.getScoreElement()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Bundle.SearchEntryMode> convertSearchEntryMode(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Bundle.SearchEntryMode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Bundle.SearchEntryMode> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Bundle.SearchEntryModeEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case MATCH:
        tgt.setValue(org.hl7.fhir.r5.model.Bundle.SearchEntryMode.MATCH);
        break;
      case INCLUDE:
        tgt.setValue(org.hl7.fhir.r5.model.Bundle.SearchEntryMode.INCLUDE);
        break;
      case OUTCOME:
        tgt.setValue(org.hl7.fhir.r5.model.Bundle.SearchEntryMode.OUTCOME);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Bundle.SearchEntryMode.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Bundle.SearchEntryMode> convertSearchEntryMode(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Bundle.SearchEntryMode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Bundle.SearchEntryMode> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Bundle.SearchEntryModeEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case MATCH:
        tgt.setValue(org.hl7.fhir.r4.model.Bundle.SearchEntryMode.MATCH);
        break;
      case INCLUDE:
        tgt.setValue(org.hl7.fhir.r4.model.Bundle.SearchEntryMode.INCLUDE);
        break;
      case OUTCOME:
        tgt.setValue(org.hl7.fhir.r4.model.Bundle.SearchEntryMode.OUTCOME);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.Bundle.SearchEntryMode.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Bundle.BundleEntryRequestComponent convertBundleEntryRequestComponent(org.hl7.fhir.r4.model.Bundle.BundleEntryRequestComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Bundle.BundleEntryRequestComponent tgt = new org.hl7.fhir.r5.model.Bundle.BundleEntryRequestComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasMethod())
      tgt.setMethodElement(convertHTTPVerb(src.getMethodElement()));
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_50.convertUri(src.getUrlElement()));
    if (src.hasIfNoneMatch())
      tgt.setIfNoneMatchElement(String40_50.convertString(src.getIfNoneMatchElement()));
    if (src.hasIfModifiedSince())
      tgt.setIfModifiedSinceElement(Instant40_50.convertInstant(src.getIfModifiedSinceElement()));
    if (src.hasIfMatch())
      tgt.setIfMatchElement(String40_50.convertString(src.getIfMatchElement()));
    if (src.hasIfNoneExist())
      tgt.setIfNoneExistElement(String40_50.convertString(src.getIfNoneExistElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Bundle.BundleEntryRequestComponent convertBundleEntryRequestComponent(org.hl7.fhir.r5.model.Bundle.BundleEntryRequestComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Bundle.BundleEntryRequestComponent tgt = new org.hl7.fhir.r4.model.Bundle.BundleEntryRequestComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasMethod())
      tgt.setMethodElement(convertHTTPVerb(src.getMethodElement()));
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_50.convertUri(src.getUrlElement()));
    if (src.hasIfNoneMatch())
      tgt.setIfNoneMatchElement(String40_50.convertString(src.getIfNoneMatchElement()));
    if (src.hasIfModifiedSince())
      tgt.setIfModifiedSinceElement(Instant40_50.convertInstant(src.getIfModifiedSinceElement()));
    if (src.hasIfMatch())
      tgt.setIfMatchElement(String40_50.convertString(src.getIfMatchElement()));
    if (src.hasIfNoneExist())
      tgt.setIfNoneExistElement(String40_50.convertString(src.getIfNoneExistElement()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Bundle.HTTPVerb> convertHTTPVerb(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Bundle.HTTPVerb> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Bundle.HTTPVerb> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Bundle.HTTPVerbEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case GET:
        tgt.setValue(org.hl7.fhir.r5.model.Bundle.HTTPVerb.GET);
        break;
      case HEAD:
        tgt.setValue(org.hl7.fhir.r5.model.Bundle.HTTPVerb.HEAD);
        break;
      case POST:
        tgt.setValue(org.hl7.fhir.r5.model.Bundle.HTTPVerb.POST);
        break;
      case PUT:
        tgt.setValue(org.hl7.fhir.r5.model.Bundle.HTTPVerb.PUT);
        break;
      case DELETE:
        tgt.setValue(org.hl7.fhir.r5.model.Bundle.HTTPVerb.DELETE);
        break;
      case PATCH:
        tgt.setValue(org.hl7.fhir.r5.model.Bundle.HTTPVerb.PATCH);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Bundle.HTTPVerb.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Bundle.HTTPVerb> convertHTTPVerb(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Bundle.HTTPVerb> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Bundle.HTTPVerb> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Bundle.HTTPVerbEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case GET:
        tgt.setValue(org.hl7.fhir.r4.model.Bundle.HTTPVerb.GET);
        break;
      case HEAD:
        tgt.setValue(org.hl7.fhir.r4.model.Bundle.HTTPVerb.HEAD);
        break;
      case POST:
        tgt.setValue(org.hl7.fhir.r4.model.Bundle.HTTPVerb.POST);
        break;
      case PUT:
        tgt.setValue(org.hl7.fhir.r4.model.Bundle.HTTPVerb.PUT);
        break;
      case DELETE:
        tgt.setValue(org.hl7.fhir.r4.model.Bundle.HTTPVerb.DELETE);
        break;
      case PATCH:
        tgt.setValue(org.hl7.fhir.r4.model.Bundle.HTTPVerb.PATCH);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.Bundle.HTTPVerb.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Bundle.BundleEntryResponseComponent convertBundleEntryResponseComponent(org.hl7.fhir.r4.model.Bundle.BundleEntryResponseComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Bundle.BundleEntryResponseComponent tgt = new org.hl7.fhir.r5.model.Bundle.BundleEntryResponseComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasStatus())
      tgt.setStatusElement(String40_50.convertString(src.getStatusElement()));
    if (src.hasLocation())
      tgt.setLocationElement(Uri40_50.convertUri(src.getLocationElement()));
    if (src.hasEtag())
      tgt.setEtagElement(String40_50.convertString(src.getEtagElement()));
    if (src.hasLastModified())
      tgt.setLastModifiedElement(Instant40_50.convertInstant(src.getLastModifiedElement()));
    if (src.hasOutcome())
      tgt.setOutcome(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertResource(src.getOutcome()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Bundle.BundleEntryResponseComponent convertBundleEntryResponseComponent(org.hl7.fhir.r5.model.Bundle.BundleEntryResponseComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Bundle.BundleEntryResponseComponent tgt = new org.hl7.fhir.r4.model.Bundle.BundleEntryResponseComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasStatus())
      tgt.setStatusElement(String40_50.convertString(src.getStatusElement()));
    if (src.hasLocation())
      tgt.setLocationElement(Uri40_50.convertUri(src.getLocationElement()));
    if (src.hasEtag())
      tgt.setEtagElement(String40_50.convertString(src.getEtagElement()));
    if (src.hasLastModified())
      tgt.setLastModifiedElement(Instant40_50.convertInstant(src.getLastModifiedElement()));
    if (src.hasOutcome())
      tgt.setOutcome(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertResource(src.getOutcome()));
    return tgt;
  }
}