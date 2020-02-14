package org.hl7.fhir.convertors.conv14_50;

import org.hl7.fhir.convertors.VersionConvertor_14_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Bundle14_50 {

    public static org.hl7.fhir.r5.model.Bundle convertBundle(org.hl7.fhir.dstu2016may.model.Bundle src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Bundle tgt = new org.hl7.fhir.r5.model.Bundle();
        VersionConvertor_14_50.copyResource(src, tgt);
        if (src.hasType())
            tgt.setType(convertBundleType(src.getType()));
        if (src.hasTotal())
            tgt.setTotalElement(VersionConvertor_14_50.convertUnsignedInt(src.getTotalElement()));
        for (org.hl7.fhir.dstu2016may.model.Bundle.BundleLinkComponent t : src.getLink()) tgt.addLink(convertBundleLinkComponent(t));
        for (org.hl7.fhir.dstu2016may.model.Bundle.BundleEntryComponent t : src.getEntry()) tgt.addEntry(convertBundleEntryComponent(t));
        if (src.hasSignature())
            tgt.setSignature(VersionConvertor_14_50.convertSignature(src.getSignature()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Bundle convertBundle(org.hl7.fhir.r5.model.Bundle src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Bundle tgt = new org.hl7.fhir.dstu2016may.model.Bundle();
        VersionConvertor_14_50.copyResource(src, tgt);
        if (src.hasType())
            tgt.setType(convertBundleType(src.getType()));
        if (src.hasTotal())
            tgt.setTotalElement(VersionConvertor_14_50.convertUnsignedInt(src.getTotalElement()));
        for (org.hl7.fhir.r5.model.Bundle.BundleLinkComponent t : src.getLink()) tgt.addLink(convertBundleLinkComponent(t));
        for (org.hl7.fhir.r5.model.Bundle.BundleEntryComponent t : src.getEntry()) tgt.addEntry(convertBundleEntryComponent(t));
        if (src.hasSignature())
            tgt.setSignature(VersionConvertor_14_50.convertSignature(src.getSignature()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Bundle.BundleEntryComponent convertBundleEntryComponent(org.hl7.fhir.r5.model.Bundle.BundleEntryComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Bundle.BundleEntryComponent tgt = new org.hl7.fhir.dstu2016may.model.Bundle.BundleEntryComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        for (org.hl7.fhir.r5.model.Bundle.BundleLinkComponent t : src.getLink()) tgt.addLink(convertBundleLinkComponent(t));
        if (src.hasFullUrl())
            tgt.setFullUrlElement(VersionConvertor_14_50.convertUri(src.getFullUrlElement()));
        if (src.hasResource())
            tgt.setResource(VersionConvertor_14_50.convertResource(src.getResource()));
        if (src.hasSearch())
            tgt.setSearch(convertBundleEntrySearchComponent(src.getSearch()));
        if (src.hasRequest())
            tgt.setRequest(convertBundleEntryRequestComponent(src.getRequest()));
        if (src.hasResponse())
            tgt.setResponse(convertBundleEntryResponseComponent(src.getResponse()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Bundle.BundleEntryComponent convertBundleEntryComponent(org.hl7.fhir.dstu2016may.model.Bundle.BundleEntryComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Bundle.BundleEntryComponent tgt = new org.hl7.fhir.r5.model.Bundle.BundleEntryComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        for (org.hl7.fhir.dstu2016may.model.Bundle.BundleLinkComponent t : src.getLink()) tgt.addLink(convertBundleLinkComponent(t));
        if (src.hasFullUrl())
            tgt.setFullUrlElement(VersionConvertor_14_50.convertUri(src.getFullUrlElement()));
        if (src.hasResource())
            tgt.setResource(VersionConvertor_14_50.convertResource(src.getResource()));
        if (src.hasSearch())
            tgt.setSearch(convertBundleEntrySearchComponent(src.getSearch()));
        if (src.hasRequest())
            tgt.setRequest(convertBundleEntryRequestComponent(src.getRequest()));
        if (src.hasResponse())
            tgt.setResponse(convertBundleEntryResponseComponent(src.getResponse()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Bundle.BundleEntryRequestComponent convertBundleEntryRequestComponent(org.hl7.fhir.r5.model.Bundle.BundleEntryRequestComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Bundle.BundleEntryRequestComponent tgt = new org.hl7.fhir.dstu2016may.model.Bundle.BundleEntryRequestComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasMethod())
            tgt.setMethod(convertHTTPVerb(src.getMethod()));
        if (src.hasUrlElement())
            tgt.setUrlElement(VersionConvertor_14_50.convertUri(src.getUrlElement()));
        if (src.hasIfNoneMatch())
            tgt.setIfNoneMatchElement(VersionConvertor_14_50.convertString(src.getIfNoneMatchElement()));
        if (src.hasIfModifiedSince())
            tgt.setIfModifiedSinceElement(VersionConvertor_14_50.convertInstant(src.getIfModifiedSinceElement()));
        if (src.hasIfMatch())
            tgt.setIfMatchElement(VersionConvertor_14_50.convertString(src.getIfMatchElement()));
        if (src.hasIfNoneExist())
            tgt.setIfNoneExistElement(VersionConvertor_14_50.convertString(src.getIfNoneExistElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Bundle.BundleEntryRequestComponent convertBundleEntryRequestComponent(org.hl7.fhir.dstu2016may.model.Bundle.BundleEntryRequestComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Bundle.BundleEntryRequestComponent tgt = new org.hl7.fhir.r5.model.Bundle.BundleEntryRequestComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasMethod())
            tgt.setMethod(convertHTTPVerb(src.getMethod()));
        if (src.hasUrlElement())
            tgt.setUrlElement(VersionConvertor_14_50.convertUri(src.getUrlElement()));
        if (src.hasIfNoneMatch())
            tgt.setIfNoneMatchElement(VersionConvertor_14_50.convertString(src.getIfNoneMatchElement()));
        if (src.hasIfModifiedSince())
            tgt.setIfModifiedSinceElement(VersionConvertor_14_50.convertInstant(src.getIfModifiedSinceElement()));
        if (src.hasIfMatch())
            tgt.setIfMatchElement(VersionConvertor_14_50.convertString(src.getIfMatchElement()));
        if (src.hasIfNoneExist())
            tgt.setIfNoneExistElement(VersionConvertor_14_50.convertString(src.getIfNoneExistElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Bundle.BundleEntryResponseComponent convertBundleEntryResponseComponent(org.hl7.fhir.r5.model.Bundle.BundleEntryResponseComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Bundle.BundleEntryResponseComponent tgt = new org.hl7.fhir.dstu2016may.model.Bundle.BundleEntryResponseComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasStatusElement())
            tgt.setStatusElement(VersionConvertor_14_50.convertString(src.getStatusElement()));
        if (src.hasLocation())
            tgt.setLocationElement(VersionConvertor_14_50.convertUri(src.getLocationElement()));
        if (src.hasEtag())
            tgt.setEtagElement(VersionConvertor_14_50.convertString(src.getEtagElement()));
        if (src.hasLastModified())
            tgt.setLastModifiedElement(VersionConvertor_14_50.convertInstant(src.getLastModifiedElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Bundle.BundleEntryResponseComponent convertBundleEntryResponseComponent(org.hl7.fhir.dstu2016may.model.Bundle.BundleEntryResponseComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Bundle.BundleEntryResponseComponent tgt = new org.hl7.fhir.r5.model.Bundle.BundleEntryResponseComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasStatusElement())
            tgt.setStatusElement(VersionConvertor_14_50.convertString(src.getStatusElement()));
        if (src.hasLocation())
            tgt.setLocationElement(VersionConvertor_14_50.convertUri(src.getLocationElement()));
        if (src.hasEtag())
            tgt.setEtagElement(VersionConvertor_14_50.convertString(src.getEtagElement()));
        if (src.hasLastModified())
            tgt.setLastModifiedElement(VersionConvertor_14_50.convertInstant(src.getLastModifiedElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Bundle.BundleEntrySearchComponent convertBundleEntrySearchComponent(org.hl7.fhir.r5.model.Bundle.BundleEntrySearchComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Bundle.BundleEntrySearchComponent tgt = new org.hl7.fhir.dstu2016may.model.Bundle.BundleEntrySearchComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasMode())
            tgt.setMode(convertSearchEntryMode(src.getMode()));
        if (src.hasScore())
            tgt.setScoreElement(VersionConvertor_14_50.convertDecimal(src.getScoreElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Bundle.BundleEntrySearchComponent convertBundleEntrySearchComponent(org.hl7.fhir.dstu2016may.model.Bundle.BundleEntrySearchComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Bundle.BundleEntrySearchComponent tgt = new org.hl7.fhir.r5.model.Bundle.BundleEntrySearchComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasMode())
            tgt.setMode(convertSearchEntryMode(src.getMode()));
        if (src.hasScore())
            tgt.setScoreElement(VersionConvertor_14_50.convertDecimal(src.getScoreElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Bundle.BundleLinkComponent convertBundleLinkComponent(org.hl7.fhir.r5.model.Bundle.BundleLinkComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Bundle.BundleLinkComponent tgt = new org.hl7.fhir.dstu2016may.model.Bundle.BundleLinkComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasRelationElement())
            tgt.setRelationElement(VersionConvertor_14_50.convertString(src.getRelationElement()));
        if (src.hasUrlElement())
            tgt.setUrlElement(VersionConvertor_14_50.convertUri(src.getUrlElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Bundle.BundleLinkComponent convertBundleLinkComponent(org.hl7.fhir.dstu2016may.model.Bundle.BundleLinkComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Bundle.BundleLinkComponent tgt = new org.hl7.fhir.r5.model.Bundle.BundleLinkComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasRelationElement())
            tgt.setRelationElement(VersionConvertor_14_50.convertString(src.getRelationElement()));
        if (src.hasUrlElement())
            tgt.setUrlElement(VersionConvertor_14_50.convertUri(src.getUrlElement()));
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Bundle.BundleType convertBundleType(org.hl7.fhir.r5.model.Bundle.BundleType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case DOCUMENT:
                return org.hl7.fhir.dstu2016may.model.Bundle.BundleType.DOCUMENT;
            case MESSAGE:
                return org.hl7.fhir.dstu2016may.model.Bundle.BundleType.MESSAGE;
            case TRANSACTION:
                return org.hl7.fhir.dstu2016may.model.Bundle.BundleType.TRANSACTION;
            case TRANSACTIONRESPONSE:
                return org.hl7.fhir.dstu2016may.model.Bundle.BundleType.TRANSACTIONRESPONSE;
            case BATCH:
                return org.hl7.fhir.dstu2016may.model.Bundle.BundleType.BATCH;
            case BATCHRESPONSE:
                return org.hl7.fhir.dstu2016may.model.Bundle.BundleType.BATCHRESPONSE;
            case HISTORY:
                return org.hl7.fhir.dstu2016may.model.Bundle.BundleType.HISTORY;
            case SEARCHSET:
                return org.hl7.fhir.dstu2016may.model.Bundle.BundleType.SEARCHSET;
            case COLLECTION:
                return org.hl7.fhir.dstu2016may.model.Bundle.BundleType.COLLECTION;
            default:
                return org.hl7.fhir.dstu2016may.model.Bundle.BundleType.NULL;
        }
    }

    static public org.hl7.fhir.r5.model.Bundle.BundleType convertBundleType(org.hl7.fhir.dstu2016may.model.Bundle.BundleType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case DOCUMENT:
                return org.hl7.fhir.r5.model.Bundle.BundleType.DOCUMENT;
            case MESSAGE:
                return org.hl7.fhir.r5.model.Bundle.BundleType.MESSAGE;
            case TRANSACTION:
                return org.hl7.fhir.r5.model.Bundle.BundleType.TRANSACTION;
            case TRANSACTIONRESPONSE:
                return org.hl7.fhir.r5.model.Bundle.BundleType.TRANSACTIONRESPONSE;
            case BATCH:
                return org.hl7.fhir.r5.model.Bundle.BundleType.BATCH;
            case BATCHRESPONSE:
                return org.hl7.fhir.r5.model.Bundle.BundleType.BATCHRESPONSE;
            case HISTORY:
                return org.hl7.fhir.r5.model.Bundle.BundleType.HISTORY;
            case SEARCHSET:
                return org.hl7.fhir.r5.model.Bundle.BundleType.SEARCHSET;
            case COLLECTION:
                return org.hl7.fhir.r5.model.Bundle.BundleType.COLLECTION;
            default:
                return org.hl7.fhir.r5.model.Bundle.BundleType.NULL;
        }
    }

    static public org.hl7.fhir.dstu2016may.model.Bundle.HTTPVerb convertHTTPVerb(org.hl7.fhir.r5.model.Bundle.HTTPVerb src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case GET:
                return org.hl7.fhir.dstu2016may.model.Bundle.HTTPVerb.GET;
            case POST:
                return org.hl7.fhir.dstu2016may.model.Bundle.HTTPVerb.POST;
            case PUT:
                return org.hl7.fhir.dstu2016may.model.Bundle.HTTPVerb.PUT;
            case DELETE:
                return org.hl7.fhir.dstu2016may.model.Bundle.HTTPVerb.DELETE;
            default:
                return org.hl7.fhir.dstu2016may.model.Bundle.HTTPVerb.NULL;
        }
    }

    static public org.hl7.fhir.r5.model.Bundle.HTTPVerb convertHTTPVerb(org.hl7.fhir.dstu2016may.model.Bundle.HTTPVerb src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case GET:
                return org.hl7.fhir.r5.model.Bundle.HTTPVerb.GET;
            case POST:
                return org.hl7.fhir.r5.model.Bundle.HTTPVerb.POST;
            case PUT:
                return org.hl7.fhir.r5.model.Bundle.HTTPVerb.PUT;
            case DELETE:
                return org.hl7.fhir.r5.model.Bundle.HTTPVerb.DELETE;
            default:
                return org.hl7.fhir.r5.model.Bundle.HTTPVerb.NULL;
        }
    }

    static public org.hl7.fhir.dstu2016may.model.Bundle.SearchEntryMode convertSearchEntryMode(org.hl7.fhir.r5.model.Bundle.SearchEntryMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case MATCH:
                return org.hl7.fhir.dstu2016may.model.Bundle.SearchEntryMode.MATCH;
            case INCLUDE:
                return org.hl7.fhir.dstu2016may.model.Bundle.SearchEntryMode.INCLUDE;
            case OUTCOME:
                return org.hl7.fhir.dstu2016may.model.Bundle.SearchEntryMode.OUTCOME;
            default:
                return org.hl7.fhir.dstu2016may.model.Bundle.SearchEntryMode.NULL;
        }
    }

    static public org.hl7.fhir.r5.model.Bundle.SearchEntryMode convertSearchEntryMode(org.hl7.fhir.dstu2016may.model.Bundle.SearchEntryMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case MATCH:
                return org.hl7.fhir.r5.model.Bundle.SearchEntryMode.MATCH;
            case INCLUDE:
                return org.hl7.fhir.r5.model.Bundle.SearchEntryMode.INCLUDE;
            case OUTCOME:
                return org.hl7.fhir.r5.model.Bundle.SearchEntryMode.OUTCOME;
            default:
                return org.hl7.fhir.r5.model.Bundle.SearchEntryMode.NULL;
        }
    }
}
