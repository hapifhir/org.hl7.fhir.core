package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Linkage30_50 {

    public static org.hl7.fhir.r5.model.Linkage convertLinkage(org.hl7.fhir.dstu3.model.Linkage src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Linkage tgt = new org.hl7.fhir.r5.model.Linkage();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasActive())
            tgt.setActiveElement(VersionConvertor_30_50.convertBoolean(src.getActiveElement()));
        if (src.hasAuthor())
            tgt.setAuthor(VersionConvertor_30_50.convertReference(src.getAuthor()));
        for (org.hl7.fhir.dstu3.model.Linkage.LinkageItemComponent t : src.getItem()) tgt.addItem(convertLinkageItemComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Linkage convertLinkage(org.hl7.fhir.r5.model.Linkage src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Linkage tgt = new org.hl7.fhir.dstu3.model.Linkage();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasActive())
            tgt.setActiveElement(VersionConvertor_30_50.convertBoolean(src.getActiveElement()));
        if (src.hasAuthor())
            tgt.setAuthor(VersionConvertor_30_50.convertReference(src.getAuthor()));
        for (org.hl7.fhir.r5.model.Linkage.LinkageItemComponent t : src.getItem()) tgt.addItem(convertLinkageItemComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Linkage.LinkageItemComponent convertLinkageItemComponent(org.hl7.fhir.r5.model.Linkage.LinkageItemComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Linkage.LinkageItemComponent tgt = new org.hl7.fhir.dstu3.model.Linkage.LinkageItemComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertLinkageType(src.getType()));
        if (src.hasResource())
            tgt.setResource(VersionConvertor_30_50.convertReference(src.getResource()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Linkage.LinkageItemComponent convertLinkageItemComponent(org.hl7.fhir.dstu3.model.Linkage.LinkageItemComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Linkage.LinkageItemComponent tgt = new org.hl7.fhir.r5.model.Linkage.LinkageItemComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertLinkageType(src.getType()));
        if (src.hasResource())
            tgt.setResource(VersionConvertor_30_50.convertReference(src.getResource()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Linkage.LinkageType convertLinkageType(org.hl7.fhir.dstu3.model.Linkage.LinkageType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case SOURCE:
                return org.hl7.fhir.r5.model.Linkage.LinkageType.SOURCE;
            case ALTERNATE:
                return org.hl7.fhir.r5.model.Linkage.LinkageType.ALTERNATE;
            case HISTORICAL:
                return org.hl7.fhir.r5.model.Linkage.LinkageType.HISTORICAL;
            default:
                return org.hl7.fhir.r5.model.Linkage.LinkageType.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.Linkage.LinkageType convertLinkageType(org.hl7.fhir.r5.model.Linkage.LinkageType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case SOURCE:
                return org.hl7.fhir.dstu3.model.Linkage.LinkageType.SOURCE;
            case ALTERNATE:
                return org.hl7.fhir.dstu3.model.Linkage.LinkageType.ALTERNATE;
            case HISTORICAL:
                return org.hl7.fhir.dstu3.model.Linkage.LinkageType.HISTORICAL;
            default:
                return org.hl7.fhir.dstu3.model.Linkage.LinkageType.NULL;
        }
    }
}
