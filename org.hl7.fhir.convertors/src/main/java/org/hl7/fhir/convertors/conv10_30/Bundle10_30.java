package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertorAdvisor30;
import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Bundle10_30 {

    public static org.hl7.fhir.dstu3.model.Bundle convertBundle(org.hl7.fhir.dstu2.model.Bundle src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Bundle tgt = new org.hl7.fhir.dstu3.model.Bundle();
        VersionConvertor_10_30.copyResource(src, tgt);
        tgt.setType(convertBundleType(src.getType()));
        if (src.hasTotal())
            tgt.setTotal(src.getTotal());
        for (org.hl7.fhir.dstu2.model.Bundle.BundleLinkComponent t : src.getLink()) tgt.addLink(convertBundleLinkComponent(t));
        for (org.hl7.fhir.dstu2.model.Bundle.BundleEntryComponent t : src.getEntry()) tgt.addEntry(convertBundleEntryComponent(t));
        tgt.setSignature(VersionConvertor_10_30.convertSignature(src.getSignature()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Bundle convertBundle(org.hl7.fhir.dstu3.model.Bundle src, VersionConvertorAdvisor30 advisor) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Bundle tgt = new org.hl7.fhir.dstu2.model.Bundle();
        VersionConvertor_10_30.copyResource(src, tgt);
        tgt.setType(convertBundleType(src.getType()));
        if (src.hasTotal())
            tgt.setTotal(src.getTotal());
        for (org.hl7.fhir.dstu3.model.Bundle.BundleLinkComponent t : src.getLink()) tgt.addLink(convertBundleLinkComponent(t));
        for (org.hl7.fhir.dstu3.model.Bundle.BundleEntryComponent t : src.getEntry()) tgt.addEntry(convertBundleEntryComponent(t, advisor));
        if (src.hasSignature())
            tgt.setSignature(VersionConvertor_10_30.convertSignature(src.getSignature()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Bundle convertBundle(org.hl7.fhir.dstu3.model.Bundle src) throws FHIRException {
        return convertBundle(src, null);
    }

    public static org.hl7.fhir.dstu2.model.Bundle.BundleEntryComponent convertBundleEntryComponent(org.hl7.fhir.dstu3.model.Bundle.BundleEntryComponent src, VersionConvertorAdvisor30 advisor) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        if (advisor.ignoreEntry(src))
            return null;
        org.hl7.fhir.dstu2.model.Bundle.BundleEntryComponent tgt = new org.hl7.fhir.dstu2.model.Bundle.BundleEntryComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        for (org.hl7.fhir.dstu3.model.Bundle.BundleLinkComponent t : src.getLink()) tgt.addLink(convertBundleLinkComponent(t));
        tgt.setFullUrl(src.getFullUrl());
        org.hl7.fhir.dstu2.model.Resource res = advisor.convert(src.getResource());
        if (res == null)
            res = VersionConvertor_10_30.convertResource(src.getResource());
        tgt.setResource(res);
        if (src.hasSearch())
            tgt.setSearch(convertBundleEntrySearchComponent(src.getSearch()));
        if (src.hasRequest())
            tgt.setRequest(convertBundleEntryRequestComponent(src.getRequest()));
        if (src.hasResponse())
            tgt.setResponse(convertBundleEntryResponseComponent(src.getResponse()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Bundle.BundleEntryComponent convertBundleEntryComponent(org.hl7.fhir.dstu3.model.Bundle.BundleEntryComponent src) throws FHIRException {
        return convertBundleEntryComponent(src, null);
    }

    public static org.hl7.fhir.dstu3.model.Bundle.BundleEntryComponent convertBundleEntryComponent(org.hl7.fhir.dstu2.model.Bundle.BundleEntryComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Bundle.BundleEntryComponent tgt = new org.hl7.fhir.dstu3.model.Bundle.BundleEntryComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        for (org.hl7.fhir.dstu2.model.Bundle.BundleLinkComponent t : src.getLink()) tgt.addLink(convertBundleLinkComponent(t));
        tgt.setFullUrl(src.getFullUrl());
        tgt.setResource(VersionConvertor_10_30.convertResource(src.getResource()));
        tgt.setSearch(convertBundleEntrySearchComponent(src.getSearch()));
        tgt.setRequest(convertBundleEntryRequestComponent(src.getRequest()));
        tgt.setResponse(convertBundleEntryResponseComponent(src.getResponse()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Bundle.BundleEntryRequestComponent convertBundleEntryRequestComponent(org.hl7.fhir.dstu3.model.Bundle.BundleEntryRequestComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Bundle.BundleEntryRequestComponent tgt = new org.hl7.fhir.dstu2.model.Bundle.BundleEntryRequestComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setMethod(convertHTTPVerb(src.getMethod()));
        tgt.setUrl(src.getUrl());
        tgt.setIfNoneMatch(src.getIfNoneMatch());
        tgt.setIfModifiedSince(src.getIfModifiedSince());
        tgt.setIfMatch(src.getIfMatch());
        tgt.setIfNoneExist(src.getIfNoneExist());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Bundle.BundleEntryRequestComponent convertBundleEntryRequestComponent(org.hl7.fhir.dstu2.model.Bundle.BundleEntryRequestComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Bundle.BundleEntryRequestComponent tgt = new org.hl7.fhir.dstu3.model.Bundle.BundleEntryRequestComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setMethod(convertHTTPVerb(src.getMethod()));
        tgt.setUrl(src.getUrl());
        tgt.setIfNoneMatch(src.getIfNoneMatch());
        tgt.setIfModifiedSince(src.getIfModifiedSince());
        tgt.setIfMatch(src.getIfMatch());
        tgt.setIfNoneExist(src.getIfNoneExist());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Bundle.BundleEntryResponseComponent convertBundleEntryResponseComponent(org.hl7.fhir.dstu3.model.Bundle.BundleEntryResponseComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Bundle.BundleEntryResponseComponent tgt = new org.hl7.fhir.dstu2.model.Bundle.BundleEntryResponseComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setStatus(src.getStatus());
        tgt.setLocation(src.getLocation());
        tgt.setEtag(src.getEtag());
        tgt.setLastModified(src.getLastModified());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Bundle.BundleEntryResponseComponent convertBundleEntryResponseComponent(org.hl7.fhir.dstu2.model.Bundle.BundleEntryResponseComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Bundle.BundleEntryResponseComponent tgt = new org.hl7.fhir.dstu3.model.Bundle.BundleEntryResponseComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setStatus(src.getStatus());
        tgt.setLocation(src.getLocation());
        tgt.setEtag(src.getEtag());
        tgt.setLastModified(src.getLastModified());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Bundle.BundleEntrySearchComponent convertBundleEntrySearchComponent(org.hl7.fhir.dstu3.model.Bundle.BundleEntrySearchComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Bundle.BundleEntrySearchComponent tgt = new org.hl7.fhir.dstu2.model.Bundle.BundleEntrySearchComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setMode(convertSearchEntryMode(src.getMode()));
        tgt.setScore(src.getScore());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Bundle.BundleEntrySearchComponent convertBundleEntrySearchComponent(org.hl7.fhir.dstu2.model.Bundle.BundleEntrySearchComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Bundle.BundleEntrySearchComponent tgt = new org.hl7.fhir.dstu3.model.Bundle.BundleEntrySearchComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setMode(convertSearchEntryMode(src.getMode()));
        tgt.setScore(src.getScore());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Bundle.BundleLinkComponent convertBundleLinkComponent(org.hl7.fhir.dstu3.model.Bundle.BundleLinkComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Bundle.BundleLinkComponent tgt = new org.hl7.fhir.dstu2.model.Bundle.BundleLinkComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setRelation(src.getRelation());
        tgt.setUrl(src.getUrl());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Bundle.BundleLinkComponent convertBundleLinkComponent(org.hl7.fhir.dstu2.model.Bundle.BundleLinkComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Bundle.BundleLinkComponent tgt = new org.hl7.fhir.dstu3.model.Bundle.BundleLinkComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setRelation(src.getRelation());
        tgt.setUrl(src.getUrl());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Bundle.BundleType convertBundleType(org.hl7.fhir.dstu2.model.Bundle.BundleType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case DOCUMENT:
                return org.hl7.fhir.dstu3.model.Bundle.BundleType.DOCUMENT;
            case MESSAGE:
                return org.hl7.fhir.dstu3.model.Bundle.BundleType.MESSAGE;
            case TRANSACTION:
                return org.hl7.fhir.dstu3.model.Bundle.BundleType.TRANSACTION;
            case TRANSACTIONRESPONSE:
                return org.hl7.fhir.dstu3.model.Bundle.BundleType.TRANSACTIONRESPONSE;
            case BATCH:
                return org.hl7.fhir.dstu3.model.Bundle.BundleType.BATCH;
            case BATCHRESPONSE:
                return org.hl7.fhir.dstu3.model.Bundle.BundleType.BATCHRESPONSE;
            case HISTORY:
                return org.hl7.fhir.dstu3.model.Bundle.BundleType.HISTORY;
            case SEARCHSET:
                return org.hl7.fhir.dstu3.model.Bundle.BundleType.SEARCHSET;
            case COLLECTION:
                return org.hl7.fhir.dstu3.model.Bundle.BundleType.COLLECTION;
            default:
                return org.hl7.fhir.dstu3.model.Bundle.BundleType.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Bundle.BundleType convertBundleType(org.hl7.fhir.dstu3.model.Bundle.BundleType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case DOCUMENT:
                return org.hl7.fhir.dstu2.model.Bundle.BundleType.DOCUMENT;
            case MESSAGE:
                return org.hl7.fhir.dstu2.model.Bundle.BundleType.MESSAGE;
            case TRANSACTION:
                return org.hl7.fhir.dstu2.model.Bundle.BundleType.TRANSACTION;
            case TRANSACTIONRESPONSE:
                return org.hl7.fhir.dstu2.model.Bundle.BundleType.TRANSACTIONRESPONSE;
            case BATCH:
                return org.hl7.fhir.dstu2.model.Bundle.BundleType.BATCH;
            case BATCHRESPONSE:
                return org.hl7.fhir.dstu2.model.Bundle.BundleType.BATCHRESPONSE;
            case HISTORY:
                return org.hl7.fhir.dstu2.model.Bundle.BundleType.HISTORY;
            case SEARCHSET:
                return org.hl7.fhir.dstu2.model.Bundle.BundleType.SEARCHSET;
            case COLLECTION:
                return org.hl7.fhir.dstu2.model.Bundle.BundleType.COLLECTION;
            default:
                return org.hl7.fhir.dstu2.model.Bundle.BundleType.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.Bundle.HTTPVerb convertHTTPVerb(org.hl7.fhir.dstu2.model.Bundle.HTTPVerb src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case GET:
                return org.hl7.fhir.dstu3.model.Bundle.HTTPVerb.GET;
            case POST:
                return org.hl7.fhir.dstu3.model.Bundle.HTTPVerb.POST;
            case PUT:
                return org.hl7.fhir.dstu3.model.Bundle.HTTPVerb.PUT;
            case DELETE:
                return org.hl7.fhir.dstu3.model.Bundle.HTTPVerb.DELETE;
            default:
                return org.hl7.fhir.dstu3.model.Bundle.HTTPVerb.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Bundle.HTTPVerb convertHTTPVerb(org.hl7.fhir.dstu3.model.Bundle.HTTPVerb src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case GET:
                return org.hl7.fhir.dstu2.model.Bundle.HTTPVerb.GET;
            case POST:
                return org.hl7.fhir.dstu2.model.Bundle.HTTPVerb.POST;
            case PUT:
                return org.hl7.fhir.dstu2.model.Bundle.HTTPVerb.PUT;
            case DELETE:
                return org.hl7.fhir.dstu2.model.Bundle.HTTPVerb.DELETE;
            default:
                return org.hl7.fhir.dstu2.model.Bundle.HTTPVerb.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.Bundle.SearchEntryMode convertSearchEntryMode(org.hl7.fhir.dstu2.model.Bundle.SearchEntryMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case MATCH:
                return org.hl7.fhir.dstu3.model.Bundle.SearchEntryMode.MATCH;
            case INCLUDE:
                return org.hl7.fhir.dstu3.model.Bundle.SearchEntryMode.INCLUDE;
            case OUTCOME:
                return org.hl7.fhir.dstu3.model.Bundle.SearchEntryMode.OUTCOME;
            default:
                return org.hl7.fhir.dstu3.model.Bundle.SearchEntryMode.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Bundle.SearchEntryMode convertSearchEntryMode(org.hl7.fhir.dstu3.model.Bundle.SearchEntryMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case MATCH:
                return org.hl7.fhir.dstu2.model.Bundle.SearchEntryMode.MATCH;
            case INCLUDE:
                return org.hl7.fhir.dstu2.model.Bundle.SearchEntryMode.INCLUDE;
            case OUTCOME:
                return org.hl7.fhir.dstu2.model.Bundle.SearchEntryMode.OUTCOME;
            default:
                return org.hl7.fhir.dstu2.model.Bundle.SearchEntryMode.NULL;
        }
    }
}
