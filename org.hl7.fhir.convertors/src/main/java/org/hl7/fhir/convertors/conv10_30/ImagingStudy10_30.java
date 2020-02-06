package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class ImagingStudy10_30 {

    public static org.hl7.fhir.dstu3.model.ImagingStudy convertImagingStudy(org.hl7.fhir.dstu2.model.ImagingStudy src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ImagingStudy tgt = new org.hl7.fhir.dstu3.model.ImagingStudy();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasUid()) {
            tgt.setUid(src.getUid());
        }
        if (src.hasAccession()) {
            tgt.setAccession(VersionConvertor_10_30.convertIdentifier(src.getAccession()));
        }
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        }
        if (src.hasAvailability()) {
            tgt.setAvailability(convertInstanceAvailability(src.getAvailability()));
        }
        if (src.hasModalityList()) {
            for (org.hl7.fhir.dstu2.model.Coding t : src.getModalityList()) tgt.addModalityList(VersionConvertor_10_30.convertCoding(t));
        }
        if (src.hasPatient()) {
            tgt.setPatient(VersionConvertor_10_30.convertReference(src.getPatient()));
        }
        if (src.hasStarted()) {
            tgt.setStarted(src.getStarted());
        }
        if (src.hasReferrer()) {
            tgt.setReferrer(VersionConvertor_10_30.convertReference(src.getReferrer()));
        }
        if (src.hasInterpreter()) {
            tgt.addInterpreter(VersionConvertor_10_30.convertReference(src.getInterpreter()));
        }
        if (src.hasNumberOfSeries()) {
            tgt.setNumberOfSeries(src.getNumberOfSeries());
        }
        if (src.hasNumberOfInstances()) {
            tgt.setNumberOfInstances(src.getNumberOfInstances());
        }
        if (src.hasProcedure()) {
            for (org.hl7.fhir.dstu2.model.Reference t : src.getProcedure()) tgt.addProcedureReference(VersionConvertor_10_30.convertReference(t));
        }
        if (src.hasDescription()) {
            tgt.setDescription(src.getDescription());
        }
        if (src.hasSeries()) {
            for (org.hl7.fhir.dstu2.model.ImagingStudy.ImagingStudySeriesComponent t : src.getSeries()) tgt.addSeries(convertImagingStudySeriesComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ImagingStudy convertImagingStudy(org.hl7.fhir.dstu3.model.ImagingStudy src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ImagingStudy tgt = new org.hl7.fhir.dstu2.model.ImagingStudy();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasUid()) {
            tgt.setUid(src.getUid());
        }
        if (src.hasAccession()) {
            tgt.setAccession(VersionConvertor_10_30.convertIdentifier(src.getAccession()));
        }
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        }
        if (src.hasAvailability()) {
            tgt.setAvailability(convertInstanceAvailability(src.getAvailability()));
        }
        if (src.hasModalityList()) {
            for (org.hl7.fhir.dstu3.model.Coding t : src.getModalityList()) tgt.addModalityList(VersionConvertor_10_30.convertCoding(t));
        }
        if (src.hasPatient()) {
            tgt.setPatient(VersionConvertor_10_30.convertReference(src.getPatient()));
        }
        if (src.hasStarted()) {
            tgt.setStarted(src.getStarted());
        }
        if (src.hasReferrer()) {
            tgt.setReferrer(VersionConvertor_10_30.convertReference(src.getReferrer()));
        }
        if (src.hasInterpreter()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getInterpreter()) tgt.setInterpreter(VersionConvertor_10_30.convertReference(t));
        }
        if (src.hasNumberOfSeries()) {
            tgt.setNumberOfSeries(src.getNumberOfSeries());
        }
        if (src.hasNumberOfInstances()) {
            tgt.setNumberOfInstances(src.getNumberOfInstances());
        }
        if (src.hasProcedureReference()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getProcedureReference()) tgt.addProcedure(VersionConvertor_10_30.convertReference(t));
        }
        if (src.hasDescription()) {
            tgt.setDescription(src.getDescription());
        }
        if (src.hasSeries()) {
            for (org.hl7.fhir.dstu3.model.ImagingStudy.ImagingStudySeriesComponent t : src.getSeries()) tgt.addSeries(convertImagingStudySeriesComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ImagingStudy.ImagingStudySeriesComponent convertImagingStudySeriesComponent(org.hl7.fhir.dstu3.model.ImagingStudy.ImagingStudySeriesComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ImagingStudy.ImagingStudySeriesComponent tgt = new org.hl7.fhir.dstu2.model.ImagingStudy.ImagingStudySeriesComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasUid()) {
            tgt.setUid(src.getUid());
        }
        if (src.hasNumber()) {
            tgt.setNumber(src.getNumber());
        }
        if (src.hasModality()) {
            tgt.setModality(VersionConvertor_10_30.convertCoding(src.getModality()));
        }
        if (src.hasDescription()) {
            tgt.setDescription(src.getDescription());
        }
        if (src.hasNumberOfInstances()) {
            tgt.setNumberOfInstances(src.getNumberOfInstances());
        }
        if (src.hasAvailability()) {
            tgt.setAvailability(convertInstanceAvailability(src.getAvailability()));
        }
        if (src.hasBodySite()) {
            tgt.setBodySite(VersionConvertor_10_30.convertCoding(src.getBodySite()));
        }
        if (src.hasLaterality()) {
            tgt.setLaterality(VersionConvertor_10_30.convertCoding(src.getLaterality()));
        }
        if (src.hasStarted()) {
            tgt.setStarted(src.getStarted());
        }
        if (src.hasInstance()) {
            for (org.hl7.fhir.dstu3.model.ImagingStudy.ImagingStudySeriesInstanceComponent t : src.getInstance()) tgt.addInstance(convertImagingStudySeriesInstanceComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ImagingStudy.ImagingStudySeriesComponent convertImagingStudySeriesComponent(org.hl7.fhir.dstu2.model.ImagingStudy.ImagingStudySeriesComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ImagingStudy.ImagingStudySeriesComponent tgt = new org.hl7.fhir.dstu3.model.ImagingStudy.ImagingStudySeriesComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasUid()) {
            tgt.setUid(src.getUid());
        }
        if (src.hasNumber()) {
            tgt.setNumber(src.getNumber());
        }
        if (src.hasModality()) {
            tgt.setModality(VersionConvertor_10_30.convertCoding(src.getModality()));
        }
        if (src.hasDescription()) {
            tgt.setDescription(src.getDescription());
        }
        if (src.hasNumberOfInstances()) {
            tgt.setNumberOfInstances(src.getNumberOfInstances());
        }
        if (src.hasAvailability()) {
            tgt.setAvailability(convertInstanceAvailability(src.getAvailability()));
        }
        if (src.hasBodySite()) {
            tgt.setBodySite(VersionConvertor_10_30.convertCoding(src.getBodySite()));
        }
        if (src.hasLaterality()) {
            tgt.setLaterality(VersionConvertor_10_30.convertCoding(src.getLaterality()));
        }
        if (src.hasStarted()) {
            tgt.setStarted(src.getStarted());
        }
        if (src.hasInstance()) {
            for (org.hl7.fhir.dstu2.model.ImagingStudy.ImagingStudySeriesInstanceComponent t : src.getInstance()) tgt.addInstance(convertImagingStudySeriesInstanceComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ImagingStudy.ImagingStudySeriesInstanceComponent convertImagingStudySeriesInstanceComponent(org.hl7.fhir.dstu2.model.ImagingStudy.ImagingStudySeriesInstanceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ImagingStudy.ImagingStudySeriesInstanceComponent tgt = new org.hl7.fhir.dstu3.model.ImagingStudy.ImagingStudySeriesInstanceComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasUid()) {
            tgt.setUid(src.getUid());
        }
        if (src.hasNumber()) {
            tgt.setNumber(src.getNumber());
        }
        if (src.hasSopClass()) {
            tgt.setSopClass(src.getSopClass());
        }
        if (src.hasTitle()) {
            tgt.setTitle(src.getTitle());
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ImagingStudy.ImagingStudySeriesInstanceComponent convertImagingStudySeriesInstanceComponent(org.hl7.fhir.dstu3.model.ImagingStudy.ImagingStudySeriesInstanceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ImagingStudy.ImagingStudySeriesInstanceComponent tgt = new org.hl7.fhir.dstu2.model.ImagingStudy.ImagingStudySeriesInstanceComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasUid()) {
            tgt.setUid(src.getUid());
        }
        if (src.hasNumber()) {
            tgt.setNumber(src.getNumber());
        }
        if (src.hasSopClass()) {
            tgt.setSopClass(src.getSopClass());
        }
        if (src.hasTitle()) {
            tgt.setTitle(src.getTitle());
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ImagingStudy.InstanceAvailability convertInstanceAvailability(org.hl7.fhir.dstu3.model.ImagingStudy.InstanceAvailability src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ONLINE:
                return org.hl7.fhir.dstu2.model.ImagingStudy.InstanceAvailability.ONLINE;
            case OFFLINE:
                return org.hl7.fhir.dstu2.model.ImagingStudy.InstanceAvailability.OFFLINE;
            case NEARLINE:
                return org.hl7.fhir.dstu2.model.ImagingStudy.InstanceAvailability.NEARLINE;
            case UNAVAILABLE:
                return org.hl7.fhir.dstu2.model.ImagingStudy.InstanceAvailability.UNAVAILABLE;
            default:
                return org.hl7.fhir.dstu2.model.ImagingStudy.InstanceAvailability.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.ImagingStudy.InstanceAvailability convertInstanceAvailability(org.hl7.fhir.dstu2.model.ImagingStudy.InstanceAvailability src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ONLINE:
                return org.hl7.fhir.dstu3.model.ImagingStudy.InstanceAvailability.ONLINE;
            case OFFLINE:
                return org.hl7.fhir.dstu3.model.ImagingStudy.InstanceAvailability.OFFLINE;
            case NEARLINE:
                return org.hl7.fhir.dstu3.model.ImagingStudy.InstanceAvailability.NEARLINE;
            case UNAVAILABLE:
                return org.hl7.fhir.dstu3.model.ImagingStudy.InstanceAvailability.UNAVAILABLE;
            default:
                return org.hl7.fhir.dstu3.model.ImagingStudy.InstanceAvailability.NULL;
        }
    }
}
