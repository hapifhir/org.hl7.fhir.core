package org.hl7.fhir.convertors.conv30_40;

import java.util.List;
import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.dstu3.model.Reference;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.CodeableConcept;

public class ImagingStudy30_40 {

    private static final String URN_DICOM_UID = "urn:dicom:uid";

    public static org.hl7.fhir.dstu3.model.ImagingStudy convertImagingStudy(org.hl7.fhir.r4.model.ImagingStudy src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ImagingStudy tgt = new org.hl7.fhir.dstu3.model.ImagingStudy();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) {
            if (URN_DICOM_UID.equals(t.getSystem())) {
                tgt.setUid(t.getValue());
            } else {
                tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
            }
        }
        if (src.hasStatus()) {
            org.hl7.fhir.r4.model.ImagingStudy.ImagingStudyStatus s = src.getStatus();
            switch(s) {
                case REGISTERED:
                    tgt.setAvailability(org.hl7.fhir.dstu3.model.ImagingStudy.InstanceAvailability.OFFLINE);
                    break;
                case AVAILABLE:
                    tgt.setAvailability(org.hl7.fhir.dstu3.model.ImagingStudy.InstanceAvailability.ONLINE);
                    break;
                case CANCELLED:
                    tgt.setAvailability(org.hl7.fhir.dstu3.model.ImagingStudy.InstanceAvailability.UNAVAILABLE);
                    break;
                default:
                    break;
            }
        }
        for (org.hl7.fhir.r4.model.Coding t : src.getModality()) {
            tgt.addModalityList(VersionConvertor_30_40.convertCoding(t));
        }
        if (src.hasSubject()) {
            if (src.hasSubject())
                tgt.setPatient(VersionConvertor_30_40.convertReference(src.getSubject()));
        }
        if (src.hasEncounter()) {
            if (src.hasEncounter())
                tgt.setContext(VersionConvertor_30_40.convertReference(src.getEncounter()));
        }
        if (src.hasStarted()) {
            if (src.hasStartedElement())
                tgt.setStartedElement(VersionConvertor_30_40.convertDateTime(src.getStartedElement()));
        }
        for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn()) {
            tgt.addBasedOn(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasReferrer()) {
            if (src.hasReferrer())
                tgt.setReferrer(VersionConvertor_30_40.convertReference(src.getReferrer()));
        }
        for (org.hl7.fhir.r4.model.Reference t : src.getInterpreter()) {
            tgt.addInterpreter(VersionConvertor_30_40.convertReference(t));
        }
        for (org.hl7.fhir.r4.model.Reference t : src.getEndpoint()) {
            tgt.addEndpoint(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasNumberOfSeries()) {
            if (src.hasNumberOfSeriesElement())
                tgt.setNumberOfSeriesElement(VersionConvertor_30_40.convertUnsignedInt(src.getNumberOfSeriesElement()));
        }
        if (src.hasNumberOfInstances()) {
            if (src.hasNumberOfInstancesElement())
                tgt.setNumberOfInstancesElement(VersionConvertor_30_40.convertUnsignedInt(src.getNumberOfInstancesElement()));
        }
        if (src.hasProcedureReference()) {
            if (src.hasProcedureReference())
                tgt.addProcedureReference(VersionConvertor_30_40.convertReference(src.getProcedureReference()));
        }
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getProcedureCode()) {
            tgt.addProcedureCode(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        List<CodeableConcept> reasonCodes = src.getReasonCode();
        if (reasonCodes.size() > 0) {
            tgt.setReason(VersionConvertor_30_40.convertCodeableConcept(reasonCodes.get(0)));
            if (reasonCodes.size() > 1) {
            }
        }
        if (src.hasDescription()) {
            if (src.hasDescriptionElement())
                tgt.setDescriptionElement(VersionConvertor_30_40.convertString(src.getDescriptionElement()));
        }
        for (org.hl7.fhir.r4.model.ImagingStudy.ImagingStudySeriesComponent t : src.getSeries()) {
            tgt.addSeries(convertImagingStudySeriesComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ImagingStudy convertImagingStudy(org.hl7.fhir.dstu3.model.ImagingStudy src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ImagingStudy tgt = new org.hl7.fhir.r4.model.ImagingStudy();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasUid()) {
            org.hl7.fhir.r4.model.Identifier i = new org.hl7.fhir.r4.model.Identifier();
            i.setSystem(URN_DICOM_UID);
            i.setValue(src.getUid());
            tgt.addIdentifier(i);
        }
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) {
            tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        }
        if (src.hasAccession())
            tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(src.getAccession()));
        if (src.hasAvailability()) {
            org.hl7.fhir.dstu3.model.ImagingStudy.InstanceAvailability availability = src.getAvailability();
            switch(availability) {
                case OFFLINE:
                    tgt.setStatus(org.hl7.fhir.r4.model.ImagingStudy.ImagingStudyStatus.REGISTERED);
                    break;
                case UNAVAILABLE:
                    tgt.setStatus(org.hl7.fhir.r4.model.ImagingStudy.ImagingStudyStatus.CANCELLED);
                    break;
                case ONLINE:
                case NEARLINE:
                    tgt.setStatus(org.hl7.fhir.r4.model.ImagingStudy.ImagingStudyStatus.AVAILABLE);
                    break;
                default:
                    break;
            }
        } else {
            tgt.setStatus(org.hl7.fhir.r4.model.ImagingStudy.ImagingStudyStatus.UNKNOWN);
        }
        for (org.hl7.fhir.dstu3.model.Coding t : src.getModalityList()) {
            tgt.addModality(VersionConvertor_30_40.convertCoding(t));
        }
        if (src.hasPatient())
            tgt.setSubject(VersionConvertor_30_40.convertReference(src.getPatient()));
        if (src.hasContext()) {
            if (src.hasContext())
                tgt.setEncounter(VersionConvertor_30_40.convertReference(src.getContext()));
        }
        if (src.hasStarted()) {
            if (src.hasStartedElement())
                tgt.setStartedElement(VersionConvertor_30_40.convertDateTime(src.getStartedElement()));
        }
        for (org.hl7.fhir.dstu3.model.Reference t : src.getBasedOn()) {
            tgt.addBasedOn(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasReferrer()) {
            if (src.hasReferrer())
                tgt.setReferrer(VersionConvertor_30_40.convertReference(src.getReferrer()));
        }
        for (org.hl7.fhir.dstu3.model.Reference t : src.getInterpreter()) {
            tgt.addInterpreter(VersionConvertor_30_40.convertReference(t));
        }
        for (org.hl7.fhir.dstu3.model.Reference t : src.getEndpoint()) {
            tgt.addEndpoint(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasNumberOfSeries()) {
            if (src.hasNumberOfSeriesElement())
                tgt.setNumberOfSeriesElement(VersionConvertor_30_40.convertUnsignedInt(src.getNumberOfSeriesElement()));
        }
        if (src.hasNumberOfInstances()) {
            if (src.hasNumberOfInstancesElement())
                tgt.setNumberOfInstancesElement(VersionConvertor_30_40.convertUnsignedInt(src.getNumberOfInstancesElement()));
        }
        List<Reference> procedureReferences = src.getProcedureReference();
        if (procedureReferences.size() > 0) {
            tgt.setProcedureReference(VersionConvertor_30_40.convertReference(procedureReferences.get(0)));
            if (procedureReferences.size() > 1) {
            }
        }
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getProcedureCode()) {
            tgt.addProcedureCode(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasReason()) {
            if (src.hasReason())
                tgt.addReasonCode(VersionConvertor_30_40.convertCodeableConcept(src.getReason()));
        }
        if (src.hasDescription()) {
            if (src.hasDescriptionElement())
                tgt.setDescriptionElement(VersionConvertor_30_40.convertString(src.getDescriptionElement()));
        }
        for (org.hl7.fhir.dstu3.model.ImagingStudy.ImagingStudySeriesComponent t : src.getSeries()) {
            tgt.addSeries(convertImagingStudySeriesComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ImagingStudy.ImagingStudySeriesComponent convertImagingStudySeriesComponent(org.hl7.fhir.dstu3.model.ImagingStudy.ImagingStudySeriesComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ImagingStudy.ImagingStudySeriesComponent tgt = new org.hl7.fhir.r4.model.ImagingStudy.ImagingStudySeriesComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasUid()) {
            if (src.hasUid())
                tgt.setUid(src.getUid());
        }
        if (src.hasNumber()) {
            if (src.hasNumberElement())
                tgt.setNumberElement(VersionConvertor_30_40.convertUnsignedInt(src.getNumberElement()));
        }
        if (src.hasModality()) {
            if (src.hasModality())
                tgt.setModality(VersionConvertor_30_40.convertCoding(src.getModality()));
        }
        if (src.hasDescription()) {
            if (src.hasDescriptionElement())
                tgt.setDescriptionElement(VersionConvertor_30_40.convertString(src.getDescriptionElement()));
        }
        if (src.hasNumberOfInstances()) {
            if (src.hasNumberOfInstancesElement())
                tgt.setNumberOfInstancesElement(VersionConvertor_30_40.convertUnsignedInt(src.getNumberOfInstancesElement()));
        }
        for (org.hl7.fhir.dstu3.model.Reference t : src.getEndpoint()) {
            tgt.addEndpoint(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasBodySite()) {
            if (src.hasBodySite())
                tgt.setBodySite(VersionConvertor_30_40.convertCoding(src.getBodySite()));
        }
        if (src.hasLaterality()) {
            if (src.hasLaterality())
                tgt.setLaterality(VersionConvertor_30_40.convertCoding(src.getLaterality()));
        }
        if (src.hasStarted()) {
            if (src.hasStartedElement())
                tgt.setStartedElement(VersionConvertor_30_40.convertDateTime(src.getStartedElement()));
        }
        for (org.hl7.fhir.dstu3.model.ImagingStudy.ImagingStudySeriesInstanceComponent t : src.getInstance()) {
            tgt.addInstance(convertImagingStudySeriesInstanceComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ImagingStudy.ImagingStudySeriesComponent convertImagingStudySeriesComponent(org.hl7.fhir.r4.model.ImagingStudy.ImagingStudySeriesComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ImagingStudy.ImagingStudySeriesComponent tgt = new org.hl7.fhir.dstu3.model.ImagingStudy.ImagingStudySeriesComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasUid()) {
            if (src.hasUid())
                tgt.setUid(src.getUid());
        }
        if (src.hasNumber()) {
            if (src.hasNumberElement())
                tgt.setNumberElement(VersionConvertor_30_40.convertUnsignedInt(src.getNumberElement()));
        }
        if (src.hasModality()) {
            if (src.hasModality())
                tgt.setModality(VersionConvertor_30_40.convertCoding(src.getModality()));
        }
        if (src.hasDescription()) {
            if (src.hasDescriptionElement())
                tgt.setDescriptionElement(VersionConvertor_30_40.convertString(src.getDescriptionElement()));
        }
        if (src.hasNumberOfInstances()) {
            if (src.hasNumberOfInstancesElement())
                tgt.setNumberOfInstancesElement(VersionConvertor_30_40.convertUnsignedInt(src.getNumberOfInstancesElement()));
        }
        for (org.hl7.fhir.r4.model.Reference t : src.getEndpoint()) {
            tgt.addEndpoint(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasBodySite()) {
            if (src.hasBodySite())
                tgt.setBodySite(VersionConvertor_30_40.convertCoding(src.getBodySite()));
        }
        if (src.hasLaterality()) {
            if (src.hasLaterality())
                tgt.setLaterality(VersionConvertor_30_40.convertCoding(src.getLaterality()));
        }
        if (src.hasStarted()) {
            if (src.hasStartedElement())
                tgt.setStartedElement(VersionConvertor_30_40.convertDateTime(src.getStartedElement()));
        }
        for (org.hl7.fhir.r4.model.ImagingStudy.ImagingStudySeriesInstanceComponent t : src.getInstance()) {
            tgt.addInstance(convertImagingStudySeriesInstanceComponent(t));
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.ImagingStudy.ImagingStudySeriesInstanceComponent convertImagingStudySeriesInstanceComponent(org.hl7.fhir.dstu3.model.ImagingStudy.ImagingStudySeriesInstanceComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ImagingStudy.ImagingStudySeriesInstanceComponent tgt = new org.hl7.fhir.r4.model.ImagingStudy.ImagingStudySeriesInstanceComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasUid()) {
            if (src.hasUid())
                tgt.setUid(src.getUid());
        }
        if (src.hasSopClass()) {
            org.hl7.fhir.r4.model.Coding c = new org.hl7.fhir.r4.model.Coding();
            c.setSystem(VersionConvertor_30_40.URN_IETF_RFC_3986);
            c.setCode(src.getSopClass());
            tgt.setSopClass(c);
        }
        if (src.hasNumber()) {
            if (src.hasNumberElement())
                tgt.setNumberElement(VersionConvertor_30_40.convertUnsignedInt(src.getNumberElement()));
        }
        if (src.hasTitle()) {
            if (src.hasTitleElement())
                tgt.setTitleElement(VersionConvertor_30_40.convertString(src.getTitleElement()));
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.ImagingStudy.ImagingStudySeriesInstanceComponent convertImagingStudySeriesInstanceComponent(org.hl7.fhir.r4.model.ImagingStudy.ImagingStudySeriesInstanceComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ImagingStudy.ImagingStudySeriesInstanceComponent tgt = new org.hl7.fhir.dstu3.model.ImagingStudy.ImagingStudySeriesInstanceComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasUid()) {
            if (src.hasUid())
                tgt.setUid(src.getUid());
        }
        org.hl7.fhir.r4.model.Coding sop = src.getSopClass();
        if (VersionConvertor_30_40.URN_IETF_RFC_3986.equals(sop.getSystem())) {
            tgt.setSopClass(sop.getCode());
        }
        if (src.hasNumber()) {
            if (src.hasNumberElement())
                tgt.setNumberElement(VersionConvertor_30_40.convertUnsignedInt(src.getNumberElement()));
        }
        if (src.hasTitle()) {
            if (src.hasTitleElement())
                tgt.setTitleElement(VersionConvertor_30_40.convertString(src.getTitleElement()));
        }
        return tgt;
    }
}