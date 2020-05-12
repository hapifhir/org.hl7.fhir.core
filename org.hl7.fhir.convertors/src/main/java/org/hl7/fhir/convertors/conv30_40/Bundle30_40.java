package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Bundle30_40 {

    public static org.hl7.fhir.r4.model.Bundle convertBundle(org.hl7.fhir.dstu3.model.Bundle src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Bundle tgt = new org.hl7.fhir.r4.model.Bundle();
        VersionConvertor_30_40.copyResource(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_30_40.convertIdentifier(src.getIdentifier()));
        if (src.hasType())
            tgt.setTypeElement(convertBundleType(src.getTypeElement()));
        if (src.hasTotal())
            tgt.setTotalElement(VersionConvertor_30_40.convertUnsignedInt(src.getTotalElement()));
        for (org.hl7.fhir.dstu3.model.Bundle.BundleLinkComponent t : src.getLink()) tgt.addLink(convertBundleLinkComponent(t));
        for (org.hl7.fhir.dstu3.model.Bundle.BundleEntryComponent t : src.getEntry()) tgt.addEntry(convertBundleEntryComponent(t));
        if (src.hasSignature())
            tgt.setSignature(VersionConvertor_30_40.convertSignature(src.getSignature()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Bundle convertBundle(org.hl7.fhir.r4.model.Bundle src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Bundle tgt = new org.hl7.fhir.dstu3.model.Bundle();
        VersionConvertor_30_40.copyResource(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_30_40.convertIdentifier(src.getIdentifier()));
        if (src.hasType())
            tgt.setTypeElement(convertBundleType(src.getTypeElement()));
        if (src.hasTotal())
            tgt.setTotalElement(VersionConvertor_30_40.convertUnsignedInt(src.getTotalElement()));
        for (org.hl7.fhir.r4.model.Bundle.BundleLinkComponent t : src.getLink()) tgt.addLink(convertBundleLinkComponent(t));
        for (org.hl7.fhir.r4.model.Bundle.BundleEntryComponent t : src.getEntry()) tgt.addEntry(convertBundleEntryComponent(t));
        if (src.hasSignature())
            tgt.setSignature(VersionConvertor_30_40.convertSignature(src.getSignature()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Bundle.BundleEntryComponent convertBundleEntryComponent(org.hl7.fhir.r4.model.Bundle.BundleEntryComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Bundle.BundleEntryComponent tgt = new org.hl7.fhir.dstu3.model.Bundle.BundleEntryComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.Bundle.BundleLinkComponent t : src.getLink()) tgt.addLink(convertBundleLinkComponent(t));
        if (src.hasFullUrl())
            tgt.setFullUrlElement(VersionConvertor_30_40.convertUri(src.getFullUrlElement()));
        if (src.hasResource())
            tgt.setResource(VersionConvertor_30_40.convertResource(src.getResource(), false));
        if (src.hasSearch())
            tgt.setSearch(convertBundleEntrySearchComponent(src.getSearch()));
        if (src.hasRequest())
            tgt.setRequest(convertBundleEntryRequestComponent(src.getRequest()));
        if (src.hasResponse())
            tgt.setResponse(convertBundleEntryResponseComponent(src.getResponse()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Bundle.BundleEntryComponent convertBundleEntryComponent(org.hl7.fhir.dstu3.model.Bundle.BundleEntryComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Bundle.BundleEntryComponent tgt = new org.hl7.fhir.r4.model.Bundle.BundleEntryComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        for (org.hl7.fhir.dstu3.model.Bundle.BundleLinkComponent t : src.getLink()) tgt.addLink(convertBundleLinkComponent(t));
        if (src.hasFullUrl())
            tgt.setFullUrlElement(VersionConvertor_30_40.convertUri(src.getFullUrlElement()));
        if (src.hasResource())
            tgt.setResource(VersionConvertor_30_40.convertResource(src.getResource(), false));
        if (src.hasSearch())
            tgt.setSearch(convertBundleEntrySearchComponent(src.getSearch()));
        if (src.hasRequest())
            tgt.setRequest(convertBundleEntryRequestComponent(src.getRequest()));
        if (src.hasResponse())
            tgt.setResponse(convertBundleEntryResponseComponent(src.getResponse()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Bundle.BundleEntryRequestComponent convertBundleEntryRequestComponent(org.hl7.fhir.dstu3.model.Bundle.BundleEntryRequestComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Bundle.BundleEntryRequestComponent tgt = new org.hl7.fhir.r4.model.Bundle.BundleEntryRequestComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasMethod())
            tgt.setMethodElement(convertHTTPVerb(src.getMethodElement()));
        if (src.hasUrl())
            tgt.setUrlElement(VersionConvertor_30_40.convertUri(src.getUrlElement()));
        if (src.hasIfNoneMatch())
            tgt.setIfNoneMatchElement(VersionConvertor_30_40.convertString(src.getIfNoneMatchElement()));
        if (src.hasIfModifiedSince())
            tgt.setIfModifiedSinceElement(VersionConvertor_30_40.convertInstant(src.getIfModifiedSinceElement()));
        if (src.hasIfMatch())
            tgt.setIfMatchElement(VersionConvertor_30_40.convertString(src.getIfMatchElement()));
        if (src.hasIfNoneExist())
            tgt.setIfNoneExistElement(VersionConvertor_30_40.convertString(src.getIfNoneExistElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Bundle.BundleEntryRequestComponent convertBundleEntryRequestComponent(org.hl7.fhir.r4.model.Bundle.BundleEntryRequestComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Bundle.BundleEntryRequestComponent tgt = new org.hl7.fhir.dstu3.model.Bundle.BundleEntryRequestComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasMethod())
            tgt.setMethodElement(convertHTTPVerb(src.getMethodElement()));
        if (src.hasUrl())
            tgt.setUrlElement(VersionConvertor_30_40.convertUri(src.getUrlElement()));
        if (src.hasIfNoneMatch())
            tgt.setIfNoneMatchElement(VersionConvertor_30_40.convertString(src.getIfNoneMatchElement()));
        if (src.hasIfModifiedSince())
            tgt.setIfModifiedSinceElement(VersionConvertor_30_40.convertInstant(src.getIfModifiedSinceElement()));
        if (src.hasIfMatch())
            tgt.setIfMatchElement(VersionConvertor_30_40.convertString(src.getIfMatchElement()));
        if (src.hasIfNoneExist())
            tgt.setIfNoneExistElement(VersionConvertor_30_40.convertString(src.getIfNoneExistElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Bundle.BundleEntryResponseComponent convertBundleEntryResponseComponent(org.hl7.fhir.dstu3.model.Bundle.BundleEntryResponseComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Bundle.BundleEntryResponseComponent tgt = new org.hl7.fhir.r4.model.Bundle.BundleEntryResponseComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasStatus())
            tgt.setStatusElement(VersionConvertor_30_40.convertString(src.getStatusElement()));
        if (src.hasLocation())
            tgt.setLocationElement(VersionConvertor_30_40.convertUri(src.getLocationElement()));
        if (src.hasEtag())
            tgt.setEtagElement(VersionConvertor_30_40.convertString(src.getEtagElement()));
        if (src.hasLastModified())
            tgt.setLastModifiedElement(VersionConvertor_30_40.convertInstant(src.getLastModifiedElement()));
        if (src.hasOutcome())
            tgt.setOutcome(VersionConvertor_30_40.convertResource(src.getOutcome(), false));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Bundle.BundleEntryResponseComponent convertBundleEntryResponseComponent(org.hl7.fhir.r4.model.Bundle.BundleEntryResponseComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Bundle.BundleEntryResponseComponent tgt = new org.hl7.fhir.dstu3.model.Bundle.BundleEntryResponseComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasStatus())
            tgt.setStatusElement(VersionConvertor_30_40.convertString(src.getStatusElement()));
        if (src.hasLocation())
            tgt.setLocationElement(VersionConvertor_30_40.convertUri(src.getLocationElement()));
        if (src.hasEtag())
            tgt.setEtagElement(VersionConvertor_30_40.convertString(src.getEtagElement()));
        if (src.hasLastModified())
            tgt.setLastModifiedElement(VersionConvertor_30_40.convertInstant(src.getLastModifiedElement()));
        if (src.hasOutcome())
            tgt.setOutcome(VersionConvertor_30_40.convertResource(src.getOutcome(), false));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Bundle.BundleEntrySearchComponent convertBundleEntrySearchComponent(org.hl7.fhir.dstu3.model.Bundle.BundleEntrySearchComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Bundle.BundleEntrySearchComponent tgt = new org.hl7.fhir.r4.model.Bundle.BundleEntrySearchComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasMode())
            tgt.setModeElement(convertSearchEntryMode(src.getModeElement()));
        if (src.hasScore())
            tgt.setScoreElement(VersionConvertor_30_40.convertDecimal(src.getScoreElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Bundle.BundleEntrySearchComponent convertBundleEntrySearchComponent(org.hl7.fhir.r4.model.Bundle.BundleEntrySearchComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Bundle.BundleEntrySearchComponent tgt = new org.hl7.fhir.dstu3.model.Bundle.BundleEntrySearchComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasMode())
            tgt.setModeElement(convertSearchEntryMode(src.getModeElement()));
        if (src.hasScore())
            tgt.setScoreElement(VersionConvertor_30_40.convertDecimal(src.getScoreElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Bundle.BundleLinkComponent convertBundleLinkComponent(org.hl7.fhir.r4.model.Bundle.BundleLinkComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Bundle.BundleLinkComponent tgt = new org.hl7.fhir.dstu3.model.Bundle.BundleLinkComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasRelation())
            tgt.setRelationElement(VersionConvertor_30_40.convertString(src.getRelationElement()));
        if (src.hasUrl())
            tgt.setUrlElement(VersionConvertor_30_40.convertUri(src.getUrlElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Bundle.BundleLinkComponent convertBundleLinkComponent(org.hl7.fhir.dstu3.model.Bundle.BundleLinkComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Bundle.BundleLinkComponent tgt = new org.hl7.fhir.r4.model.Bundle.BundleLinkComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasRelation())
            tgt.setRelationElement(VersionConvertor_30_40.convertString(src.getRelationElement()));
        if (src.hasUrl())
            tgt.setUrlElement(VersionConvertor_30_40.convertUri(src.getUrlElement()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Bundle.BundleType> convertBundleType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Bundle.BundleType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Bundle.BundleType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Bundle.BundleTypeEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case DOCUMENT:
                tgt.setValue(org.hl7.fhir.dstu3.model.Bundle.BundleType.DOCUMENT);
                break;
            case MESSAGE:
                tgt.setValue(org.hl7.fhir.dstu3.model.Bundle.BundleType.MESSAGE);
                break;
            case TRANSACTION:
                tgt.setValue(org.hl7.fhir.dstu3.model.Bundle.BundleType.TRANSACTION);
                break;
            case TRANSACTIONRESPONSE:
                tgt.setValue(org.hl7.fhir.dstu3.model.Bundle.BundleType.TRANSACTIONRESPONSE);
                break;
            case BATCH:
                tgt.setValue(org.hl7.fhir.dstu3.model.Bundle.BundleType.BATCH);
                break;
            case BATCHRESPONSE:
                tgt.setValue(org.hl7.fhir.dstu3.model.Bundle.BundleType.BATCHRESPONSE);
                break;
            case HISTORY:
                tgt.setValue(org.hl7.fhir.dstu3.model.Bundle.BundleType.HISTORY);
                break;
            case SEARCHSET:
                tgt.setValue(org.hl7.fhir.dstu3.model.Bundle.BundleType.SEARCHSET);
                break;
            case COLLECTION:
                tgt.setValue(org.hl7.fhir.dstu3.model.Bundle.BundleType.COLLECTION);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.Bundle.BundleType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Bundle.BundleType> convertBundleType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Bundle.BundleType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Bundle.BundleType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Bundle.BundleTypeEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch(src.getValue()) {
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

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Bundle.HTTPVerb> convertHTTPVerb(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Bundle.HTTPVerb> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Bundle.HTTPVerb> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Bundle.HTTPVerbEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case GET:
                tgt.setValue(org.hl7.fhir.dstu3.model.Bundle.HTTPVerb.GET);
                break;
            case POST:
                tgt.setValue(org.hl7.fhir.dstu3.model.Bundle.HTTPVerb.POST);
                break;
            case PUT:
                tgt.setValue(org.hl7.fhir.dstu3.model.Bundle.HTTPVerb.PUT);
                break;
            case DELETE:
                tgt.setValue(org.hl7.fhir.dstu3.model.Bundle.HTTPVerb.DELETE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.Bundle.HTTPVerb.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Bundle.HTTPVerb> convertHTTPVerb(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Bundle.HTTPVerb> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Bundle.HTTPVerb> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Bundle.HTTPVerbEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case GET:
                tgt.setValue(org.hl7.fhir.r4.model.Bundle.HTTPVerb.GET);
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
            default:
                tgt.setValue(org.hl7.fhir.r4.model.Bundle.HTTPVerb.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Bundle.SearchEntryMode> convertSearchEntryMode(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Bundle.SearchEntryMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Bundle.SearchEntryMode> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Bundle.SearchEntryModeEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch(src.getValue()) {
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

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Bundle.SearchEntryMode> convertSearchEntryMode(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Bundle.SearchEntryMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Bundle.SearchEntryMode> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Bundle.SearchEntryModeEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case MATCH:
                tgt.setValue(org.hl7.fhir.dstu3.model.Bundle.SearchEntryMode.MATCH);
                break;
            case INCLUDE:
                tgt.setValue(org.hl7.fhir.dstu3.model.Bundle.SearchEntryMode.INCLUDE);
                break;
            case OUTCOME:
                tgt.setValue(org.hl7.fhir.dstu3.model.Bundle.SearchEntryMode.OUTCOME);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.Bundle.SearchEntryMode.NULL);
                break;
        }
        return tgt;
    }
}