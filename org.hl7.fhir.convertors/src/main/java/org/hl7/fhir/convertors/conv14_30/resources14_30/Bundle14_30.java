package org.hl7.fhir.convertors.conv14_30.resources14_30;

import org.hl7.fhir.convertors.context.ConversionContext14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.complextypes14_30.Signature14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30.Decimal14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30.Instant14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30.String14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30.UnsignedInt14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30.Uri14_30;
import org.hl7.fhir.dstu3.model.Bundle;
import org.hl7.fhir.dstu3.model.Enumeration;
import org.hl7.fhir.exceptions.FHIRException;

public class Bundle14_30 {

  public static org.hl7.fhir.dstu3.model.Bundle convertBundle(org.hl7.fhir.dstu2016may.model.Bundle src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Bundle tgt = new org.hl7.fhir.dstu3.model.Bundle();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyResource(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(convertBundleType(src.getTypeElement()));
    if (src.hasTotal())
      tgt.setTotalElement(UnsignedInt14_30.convertUnsignedInt(src.getTotalElement()));
    for (org.hl7.fhir.dstu2016may.model.Bundle.BundleLinkComponent t : src.getLink())
      tgt.addLink(convertBundleLinkComponent(t));
    for (org.hl7.fhir.dstu2016may.model.Bundle.BundleEntryComponent t : src.getEntry())
      tgt.addEntry(convertBundleEntryComponent(t));
    if (src.hasSignature())
      tgt.setSignature(Signature14_30.convertSignature(src.getSignature()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.Bundle convertBundle(org.hl7.fhir.dstu3.model.Bundle src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.Bundle tgt = new org.hl7.fhir.dstu2016may.model.Bundle();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyResource(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(convertBundleType(src.getTypeElement()));
    if (src.hasTotal())
      tgt.setTotalElement(UnsignedInt14_30.convertUnsignedInt(src.getTotalElement()));
    for (org.hl7.fhir.dstu3.model.Bundle.BundleLinkComponent t : src.getLink())
      tgt.addLink(convertBundleLinkComponent(t));
    for (org.hl7.fhir.dstu3.model.Bundle.BundleEntryComponent t : src.getEntry())
      tgt.addEntry(convertBundleEntryComponent(t));
    if (src.hasSignature())
      tgt.setSignature(Signature14_30.convertSignature(src.getSignature()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Bundle.BundleEntryComponent convertBundleEntryComponent(org.hl7.fhir.dstu2016may.model.Bundle.BundleEntryComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Bundle.BundleEntryComponent tgt = new org.hl7.fhir.dstu3.model.Bundle.BundleEntryComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyBackboneElement(src,tgt);
    for (org.hl7.fhir.dstu2016may.model.Bundle.BundleLinkComponent t : src.getLink())
      tgt.addLink(convertBundleLinkComponent(t));
    if (src.hasFullUrl())
      tgt.setFullUrlElement(Uri14_30.convertUri(src.getFullUrlElement()));
    if (src.hasResource())
      tgt.setResource(ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().convertResource(src.getResource()));
    if (src.hasSearch())
      tgt.setSearch(convertBundleEntrySearchComponent(src.getSearch()));
    if (src.hasRequest())
      tgt.setRequest(convertBundleEntryRequestComponent(src.getRequest()));
    if (src.hasResponse())
      tgt.setResponse(convertBundleEntryResponseComponent(src.getResponse()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.Bundle.BundleEntryComponent convertBundleEntryComponent(org.hl7.fhir.dstu3.model.Bundle.BundleEntryComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.Bundle.BundleEntryComponent tgt = new org.hl7.fhir.dstu2016may.model.Bundle.BundleEntryComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyBackboneElement(src,tgt);
    for (org.hl7.fhir.dstu3.model.Bundle.BundleLinkComponent t : src.getLink())
      tgt.addLink(convertBundleLinkComponent(t));
    if (src.hasFullUrl())
      tgt.setFullUrlElement(Uri14_30.convertUri(src.getFullUrlElement()));
    if (src.hasResource())
      tgt.setResource(ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().convertResource(src.getResource()));
    if (src.hasSearch())
      tgt.setSearch(convertBundleEntrySearchComponent(src.getSearch()));
    if (src.hasRequest())
      tgt.setRequest(convertBundleEntryRequestComponent(src.getRequest()));
    if (src.hasResponse())
      tgt.setResponse(convertBundleEntryResponseComponent(src.getResponse()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Bundle.BundleEntryRequestComponent convertBundleEntryRequestComponent(org.hl7.fhir.dstu2016may.model.Bundle.BundleEntryRequestComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Bundle.BundleEntryRequestComponent tgt = new org.hl7.fhir.dstu3.model.Bundle.BundleEntryRequestComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyBackboneElement(src,tgt);
    if (src.hasMethod())
      tgt.setMethodElement(convertHTTPVerb(src.getMethodElement()));
    if (src.hasUrlElement())
      tgt.setUrlElement(Uri14_30.convertUri(src.getUrlElement()));
    if (src.hasIfNoneMatch())
      tgt.setIfNoneMatchElement(String14_30.convertString(src.getIfNoneMatchElement()));
    if (src.hasIfModifiedSince())
      tgt.setIfModifiedSinceElement(Instant14_30.convertInstant(src.getIfModifiedSinceElement()));
    if (src.hasIfMatch())
      tgt.setIfMatchElement(String14_30.convertString(src.getIfMatchElement()));
    if (src.hasIfNoneExist())
      tgt.setIfNoneExistElement(String14_30.convertString(src.getIfNoneExistElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.Bundle.BundleEntryRequestComponent convertBundleEntryRequestComponent(org.hl7.fhir.dstu3.model.Bundle.BundleEntryRequestComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.Bundle.BundleEntryRequestComponent tgt = new org.hl7.fhir.dstu2016may.model.Bundle.BundleEntryRequestComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyBackboneElement(src,tgt);
    if (src.hasMethod())
      tgt.setMethodElement(convertHTTPVerb(src.getMethodElement()));
    if (src.hasUrlElement())
      tgt.setUrlElement(Uri14_30.convertUri(src.getUrlElement()));
    if (src.hasIfNoneMatch())
      tgt.setIfNoneMatchElement(String14_30.convertString(src.getIfNoneMatchElement()));
    if (src.hasIfModifiedSince())
      tgt.setIfModifiedSinceElement(Instant14_30.convertInstant(src.getIfModifiedSinceElement()));
    if (src.hasIfMatch())
      tgt.setIfMatchElement(String14_30.convertString(src.getIfMatchElement()));
    if (src.hasIfNoneExist())
      tgt.setIfNoneExistElement(String14_30.convertString(src.getIfNoneExistElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Bundle.BundleEntryResponseComponent convertBundleEntryResponseComponent(org.hl7.fhir.dstu2016may.model.Bundle.BundleEntryResponseComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Bundle.BundleEntryResponseComponent tgt = new org.hl7.fhir.dstu3.model.Bundle.BundleEntryResponseComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyBackboneElement(src,tgt);
    if (src.hasStatusElement())
      tgt.setStatusElement(String14_30.convertString(src.getStatusElement()));
    if (src.hasLocation())
      tgt.setLocationElement(Uri14_30.convertUri(src.getLocationElement()));
    if (src.hasEtag())
      tgt.setEtagElement(String14_30.convertString(src.getEtagElement()));
    if (src.hasLastModified())
      tgt.setLastModifiedElement(Instant14_30.convertInstant(src.getLastModifiedElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.Bundle.BundleEntryResponseComponent convertBundleEntryResponseComponent(org.hl7.fhir.dstu3.model.Bundle.BundleEntryResponseComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.Bundle.BundleEntryResponseComponent tgt = new org.hl7.fhir.dstu2016may.model.Bundle.BundleEntryResponseComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyBackboneElement(src,tgt);
    if (src.hasStatusElement())
      tgt.setStatusElement(String14_30.convertString(src.getStatusElement()));
    if (src.hasLocation())
      tgt.setLocationElement(Uri14_30.convertUri(src.getLocationElement()));
    if (src.hasEtag())
      tgt.setEtagElement(String14_30.convertString(src.getEtagElement()));
    if (src.hasLastModified())
      tgt.setLastModifiedElement(Instant14_30.convertInstant(src.getLastModifiedElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Bundle.BundleEntrySearchComponent convertBundleEntrySearchComponent(org.hl7.fhir.dstu2016may.model.Bundle.BundleEntrySearchComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Bundle.BundleEntrySearchComponent tgt = new org.hl7.fhir.dstu3.model.Bundle.BundleEntrySearchComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyBackboneElement(src,tgt);
    if (src.hasMode())
      tgt.setModeElement(convertSearchEntryMode(src.getModeElement()));
    if (src.hasScore())
      tgt.setScoreElement(Decimal14_30.convertDecimal(src.getScoreElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.Bundle.BundleEntrySearchComponent convertBundleEntrySearchComponent(org.hl7.fhir.dstu3.model.Bundle.BundleEntrySearchComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.Bundle.BundleEntrySearchComponent tgt = new org.hl7.fhir.dstu2016may.model.Bundle.BundleEntrySearchComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyBackboneElement(src,tgt);
    if (src.hasMode())
      tgt.setModeElement(convertSearchEntryMode(src.getModeElement()));
    if (src.hasScore())
      tgt.setScoreElement(Decimal14_30.convertDecimal(src.getScoreElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.Bundle.BundleLinkComponent convertBundleLinkComponent(org.hl7.fhir.dstu3.model.Bundle.BundleLinkComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.Bundle.BundleLinkComponent tgt = new org.hl7.fhir.dstu2016may.model.Bundle.BundleLinkComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyBackboneElement(src,tgt);
    if (src.hasRelationElement())
      tgt.setRelationElement(String14_30.convertString(src.getRelationElement()));
    if (src.hasUrlElement())
      tgt.setUrlElement(Uri14_30.convertUri(src.getUrlElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Bundle.BundleLinkComponent convertBundleLinkComponent(org.hl7.fhir.dstu2016may.model.Bundle.BundleLinkComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Bundle.BundleLinkComponent tgt = new org.hl7.fhir.dstu3.model.Bundle.BundleLinkComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyBackboneElement(src,tgt);
    if (src.hasRelationElement())
      tgt.setRelationElement(String14_30.convertString(src.getRelationElement()));
    if (src.hasUrlElement())
      tgt.setUrlElement(Uri14_30.convertUri(src.getUrlElement()));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Bundle.BundleType> convertBundleType(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Bundle.BundleType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Bundle.BundleType> tgt = new Enumeration<>(new Bundle.BundleTypeEnumFactory());
      ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
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

  static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Bundle.BundleType> convertBundleType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Bundle.BundleType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Bundle.BundleType> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.Bundle.BundleTypeEnumFactory());
      ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case DOCUMENT:
                  tgt.setValue(org.hl7.fhir.dstu2016may.model.Bundle.BundleType.DOCUMENT);
                  break;
              case MESSAGE:
                  tgt.setValue(org.hl7.fhir.dstu2016may.model.Bundle.BundleType.MESSAGE);
                  break;
              case TRANSACTION:
                  tgt.setValue(org.hl7.fhir.dstu2016may.model.Bundle.BundleType.TRANSACTION);
                  break;
              case TRANSACTIONRESPONSE:
                  tgt.setValue(org.hl7.fhir.dstu2016may.model.Bundle.BundleType.TRANSACTIONRESPONSE);
                  break;
              case BATCH:
                  tgt.setValue(org.hl7.fhir.dstu2016may.model.Bundle.BundleType.BATCH);
                  break;
              case BATCHRESPONSE:
                  tgt.setValue(org.hl7.fhir.dstu2016may.model.Bundle.BundleType.BATCHRESPONSE);
                  break;
              case HISTORY:
                  tgt.setValue(org.hl7.fhir.dstu2016may.model.Bundle.BundleType.HISTORY);
                  break;
              case SEARCHSET:
                  tgt.setValue(org.hl7.fhir.dstu2016may.model.Bundle.BundleType.SEARCHSET);
                  break;
              case COLLECTION:
                  tgt.setValue(org.hl7.fhir.dstu2016may.model.Bundle.BundleType.COLLECTION);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.dstu2016may.model.Bundle.BundleType.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Bundle.HTTPVerb> convertHTTPVerb(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Bundle.HTTPVerb> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Bundle.HTTPVerb> tgt = new Enumeration<>(new Bundle.HTTPVerbEnumFactory());
      ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case GET:
                  tgt.setValue(Bundle.HTTPVerb.GET);
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
              default:
                  tgt.setValue(Bundle.HTTPVerb.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Bundle.HTTPVerb> convertHTTPVerb(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Bundle.HTTPVerb> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Bundle.HTTPVerb> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.Bundle.HTTPVerbEnumFactory());
      ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case GET:
                  tgt.setValue(org.hl7.fhir.dstu2016may.model.Bundle.HTTPVerb.GET);
                  break;
              case POST:
                  tgt.setValue(org.hl7.fhir.dstu2016may.model.Bundle.HTTPVerb.POST);
                  break;
              case PUT:
                  tgt.setValue(org.hl7.fhir.dstu2016may.model.Bundle.HTTPVerb.PUT);
                  break;
              case DELETE:
                  tgt.setValue(org.hl7.fhir.dstu2016may.model.Bundle.HTTPVerb.DELETE);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.dstu2016may.model.Bundle.HTTPVerb.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Bundle.SearchEntryMode> convertSearchEntryMode(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Bundle.SearchEntryMode> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Bundle.SearchEntryMode> tgt = new Enumeration<>(new Bundle.SearchEntryModeEnumFactory());
      ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
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

  static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Bundle.SearchEntryMode> convertSearchEntryMode(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Bundle.SearchEntryMode> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Bundle.SearchEntryMode> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.Bundle.SearchEntryModeEnumFactory());
      ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case MATCH:
                  tgt.setValue(org.hl7.fhir.dstu2016may.model.Bundle.SearchEntryMode.MATCH);
                  break;
              case INCLUDE:
                  tgt.setValue(org.hl7.fhir.dstu2016may.model.Bundle.SearchEntryMode.INCLUDE);
                  break;
              case OUTCOME:
                  tgt.setValue(org.hl7.fhir.dstu2016may.model.Bundle.SearchEntryMode.OUTCOME);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.dstu2016may.model.Bundle.SearchEntryMode.NULL);
                  break;
          }
      }
      return tgt;
  }
}