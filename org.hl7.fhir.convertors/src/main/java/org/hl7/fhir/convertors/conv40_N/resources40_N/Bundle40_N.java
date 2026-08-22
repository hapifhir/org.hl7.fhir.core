package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Signature40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Decimal40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Instant40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.UnsignedInt40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Uri40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.Bundle;
import org.hl7.fhir.model.core.Bundle.LinkRelationTypes;
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

public class Bundle40_N {

  public static org.hl7.fhir.model.core.Bundle convertBundle(org.hl7.fhir.r4.model.Bundle src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Bundle tgt = new org.hl7.fhir.model.core.Bundle();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyResource(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier40_N.convertIdentifier(src.getIdentifier()));
    if (src.hasType())
      tgt.setTypeElement(convertBundleType(src.getTypeElement()));
    if (src.hasTimestamp())
      tgt.setTimestampElement(Instant40_N.convertInstant(src.getTimestampElement()));
    if (src.hasTotal())
      tgt.setTotalElement(UnsignedInt40_N.convertUnsignedInt(src.getTotalElement()));
    for (org.hl7.fhir.r4.model.Bundle.BundleLinkComponent t : src.getLink()) tgt.addLink(convertBundleLinkComponent(t));
    for (org.hl7.fhir.r4.model.Bundle.BundleEntryComponent t : src.getEntry())
      tgt.addEntry(convertBundleEntryComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Bundle convertBundle(org.hl7.fhir.model.core.Bundle src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Bundle tgt = new org.hl7.fhir.r4.model.Bundle();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyResource(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier40_N.convertIdentifier(src.getIdentifier()));
    if (src.hasType())
      tgt.setTypeElement(convertBundleType(src.getTypeElement()));
    if (src.hasTimestamp())
      tgt.setTimestampElement(Instant40_N.convertInstant(src.getTimestampElement()));
    if (src.hasTotal())
      tgt.setTotalElement(UnsignedInt40_N.convertUnsignedInt(src.getTotalElement()));
    for (org.hl7.fhir.model.core.Bundle.BundleLinkComponent t : src.getLinkList()) tgt.addLink(convertBundleLinkComponent(t));
    for (org.hl7.fhir.model.core.Bundle.BundleEntryComponent t : src.getEntryList())
      tgt.addEntry(convertBundleEntryComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Bundle.BundleType> convertBundleType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Bundle.BundleType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Bundle.BundleType> tgt = new Enumeration<>(new Bundle.BundleTypeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case DOCUMENT:
                  tgt.setValue(Bundle.BundleType.DOCUMENT);
                  break;
              case MESSAGE:
                  tgt.setValue(Bundle.BundleType.MESSAGE);
                  break;
              case TRANSACTION:
                  tgt.setValue(Bundle.BundleType.TRANSACTION);
                  break;
              case TRANSACTIONRESPONSE:
                  tgt.setValue(Bundle.BundleType.TRANSACTIONRESPONSE);
                  break;
              case BATCH:
                  tgt.setValue(Bundle.BundleType.BATCH);
                  break;
              case BATCHRESPONSE:
                  tgt.setValue(Bundle.BundleType.BATCHRESPONSE);
                  break;
              case HISTORY:
                  tgt.setValue(Bundle.BundleType.HISTORY);
                  break;
              case SEARCHSET:
                  tgt.setValue(Bundle.BundleType.SEARCHSET);
                  break;
              case COLLECTION:
                  tgt.setValue(Bundle.BundleType.COLLECTION);
                  break;
              default:
                  tgt.setValue(Bundle.BundleType.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Bundle.BundleType> convertBundleType(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Bundle.BundleType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Bundle.BundleType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Bundle.BundleTypeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.Bundle.BundleLinkComponent convertBundleLinkComponent(org.hl7.fhir.r4.model.Bundle.BundleLinkComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Bundle.BundleLinkComponent tgt = new org.hl7.fhir.model.core.Bundle.BundleLinkComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasRelation())
      tgt.setRelation(LinkRelationTypes.fromCode(src.getRelation()));
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_N.convertUri(src.getUrlElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Bundle.BundleLinkComponent convertBundleLinkComponent(org.hl7.fhir.model.core.Bundle.BundleLinkComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Bundle.BundleLinkComponent tgt = new org.hl7.fhir.r4.model.Bundle.BundleLinkComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasRelation())
      tgt.setRelation((src.getRelation().toCode()));
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_N.convertUri(src.getUrlElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Bundle.BundleEntryComponent convertBundleEntryComponent(org.hl7.fhir.r4.model.Bundle.BundleEntryComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Bundle.BundleEntryComponent tgt = new org.hl7.fhir.model.core.Bundle.BundleEntryComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4.model.Bundle.BundleLinkComponent t : src.getLink()) tgt.addLink(convertBundleLinkComponent(t));
    if (src.hasFullUrl())
      tgt.setFullUrlElement(Uri40_N.convertUri(src.getFullUrlElement()));
    if (src.hasResource())
      tgt.setResource(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertResource(src.getResource()));
    if (src.hasSearch())
      tgt.setSearch(convertBundleEntrySearchComponent(src.getSearch()));
    if (src.hasRequest())
      tgt.setRequest(convertBundleEntryRequestComponent(src.getRequest()));
    if (src.hasResponse())
      tgt.setResponse(convertBundleEntryResponseComponent(src.getResponse()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Bundle.BundleEntryComponent convertBundleEntryComponent(org.hl7.fhir.model.core.Bundle.BundleEntryComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Bundle.BundleEntryComponent tgt = new org.hl7.fhir.r4.model.Bundle.BundleEntryComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.model.core.Bundle.BundleLinkComponent t : src.getLinkList()) tgt.addLink(convertBundleLinkComponent(t));
    if (src.hasFullUrl())
      tgt.setFullUrlElement(Uri40_N.convertUri(src.getFullUrlElement()));
    if (src.hasResource())
      tgt.setResource(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertResource(src.getResource()));
    if (src.hasSearch())
      tgt.setSearch(convertBundleEntrySearchComponent(src.getSearch()));
    if (src.hasRequest())
      tgt.setRequest(convertBundleEntryRequestComponent(src.getRequest()));
    if (src.hasResponse())
      tgt.setResponse(convertBundleEntryResponseComponent(src.getResponse()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Bundle.BundleEntrySearchComponent convertBundleEntrySearchComponent(org.hl7.fhir.r4.model.Bundle.BundleEntrySearchComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Bundle.BundleEntrySearchComponent tgt = new org.hl7.fhir.model.core.Bundle.BundleEntrySearchComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasMode())
      tgt.setModeElement(convertSearchEntryMode(src.getModeElement()));
    if (src.hasScore())
      tgt.setScoreElement(Decimal40_N.convertDecimal(src.getScoreElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Bundle.BundleEntrySearchComponent convertBundleEntrySearchComponent(org.hl7.fhir.model.core.Bundle.BundleEntrySearchComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Bundle.BundleEntrySearchComponent tgt = new org.hl7.fhir.r4.model.Bundle.BundleEntrySearchComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasMode())
      tgt.setModeElement(convertSearchEntryMode(src.getModeElement()));
    if (src.hasScore())
      tgt.setScoreElement(Decimal40_N.convertDecimal(src.getScoreElement()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Bundle.SearchEntryMode> convertSearchEntryMode(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Bundle.SearchEntryMode> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Bundle.SearchEntryMode> tgt = new Enumeration<>(new Bundle.SearchEntryModeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case MATCH:
                  tgt.setValue(Bundle.SearchEntryMode.MATCH);
                  break;
              case INCLUDE:
                  tgt.setValue(Bundle.SearchEntryMode.INCLUDE);
                  break;
              case OUTCOME:
                  tgt.setValue(Bundle.SearchEntryMode.OUTCOME);
                  break;
              default:
                  tgt.setValue(Bundle.SearchEntryMode.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Bundle.SearchEntryMode> convertSearchEntryMode(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Bundle.SearchEntryMode> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Bundle.SearchEntryMode> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Bundle.SearchEntryModeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.Bundle.BundleEntryRequestComponent convertBundleEntryRequestComponent(org.hl7.fhir.r4.model.Bundle.BundleEntryRequestComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Bundle.BundleEntryRequestComponent tgt = new org.hl7.fhir.model.core.Bundle.BundleEntryRequestComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasMethod())
      tgt.setMethodElement(convertHTTPVerb(src.getMethodElement()));
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_N.convertUri(src.getUrlElement()));
    if (src.hasIfNoneMatch())
      tgt.setIfNoneMatchElement(String40_N.convertString(src.getIfNoneMatchElement()));
    if (src.hasIfModifiedSince())
      tgt.setIfModifiedSinceElement(Instant40_N.convertInstant(src.getIfModifiedSinceElement()));
    if (src.hasIfMatch())
      tgt.setIfMatchElement(String40_N.convertString(src.getIfMatchElement()));
    if (src.hasIfNoneExist())
      tgt.setIfNoneExistElement(String40_N.convertString(src.getIfNoneExistElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Bundle.BundleEntryRequestComponent convertBundleEntryRequestComponent(org.hl7.fhir.model.core.Bundle.BundleEntryRequestComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Bundle.BundleEntryRequestComponent tgt = new org.hl7.fhir.r4.model.Bundle.BundleEntryRequestComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasMethod())
      tgt.setMethodElement(convertHTTPVerb(src.getMethodElement()));
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_N.convertUri(src.getUrlElement()));
    if (src.hasIfNoneMatch())
      tgt.setIfNoneMatchElement(String40_N.convertString(src.getIfNoneMatchElement()));
    if (src.hasIfModifiedSince())
      tgt.setIfModifiedSinceElement(Instant40_N.convertInstant(src.getIfModifiedSinceElement()));
    if (src.hasIfMatch())
      tgt.setIfMatchElement(String40_N.convertString(src.getIfMatchElement()));
    if (src.hasIfNoneExist())
      tgt.setIfNoneExistElement(String40_N.convertString(src.getIfNoneExistElement()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Bundle.HTTPVerb> convertHTTPVerb(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Bundle.HTTPVerb> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Bundle.HTTPVerb> tgt = new Enumeration<>(new Bundle.HTTPVerbEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case GET:
                  tgt.setValue(Bundle.HTTPVerb.GET);
                  break;
              case HEAD:
                  tgt.setValue(Bundle.HTTPVerb.HEAD);
                  break;
              case POST:
                  tgt.setValue(Bundle.HTTPVerb.POST);
                  break;
              case PUT:
                  tgt.setValue(Bundle.HTTPVerb.PUT);
                  break;
              case DELETE:
                  tgt.setValue(Bundle.HTTPVerb.DELETE);
                  break;
              case PATCH:
                  tgt.setValue(Bundle.HTTPVerb.PATCH);
                  break;
              default:
                  tgt.setValue(Bundle.HTTPVerb.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Bundle.HTTPVerb> convertHTTPVerb(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Bundle.HTTPVerb> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Bundle.HTTPVerb> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Bundle.HTTPVerbEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.Bundle.BundleEntryResponseComponent convertBundleEntryResponseComponent(org.hl7.fhir.r4.model.Bundle.BundleEntryResponseComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Bundle.BundleEntryResponseComponent tgt = new org.hl7.fhir.model.core.Bundle.BundleEntryResponseComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasStatus())
      tgt.setStatusElement(String40_N.convertString(src.getStatusElement()));
    if (src.hasLocation())
      tgt.setLocationElement(Uri40_N.convertUri(src.getLocationElement()));
    if (src.hasEtag())
      tgt.setEtagElement(String40_N.convertString(src.getEtagElement()));
    if (src.hasLastModified())
      tgt.setLastModifiedElement(Instant40_N.convertInstant(src.getLastModifiedElement()));
    if (src.hasOutcome())
      tgt.setOutcome(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertResource(src.getOutcome()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Bundle.BundleEntryResponseComponent convertBundleEntryResponseComponent(org.hl7.fhir.model.core.Bundle.BundleEntryResponseComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Bundle.BundleEntryResponseComponent tgt = new org.hl7.fhir.r4.model.Bundle.BundleEntryResponseComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasStatus())
      tgt.setStatusElement(String40_N.convertString(src.getStatusElement()));
    if (src.hasLocation())
      tgt.setLocationElement(Uri40_N.convertUri(src.getLocationElement()));
    if (src.hasEtag())
      tgt.setEtagElement(String40_N.convertString(src.getEtagElement()));
    if (src.hasLastModified())
      tgt.setLastModifiedElement(Instant40_N.convertInstant(src.getLastModifiedElement()));
    if (src.hasOutcome())
      tgt.setOutcome(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertResource(src.getOutcome()));
    return tgt;
  }
}