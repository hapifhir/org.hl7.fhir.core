package org.hl7.fhir.convertors.conv10_50;

import org.hl7.fhir.convertors.VersionConvertor_10_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableReference;

public class Encounter10_50 {

    public static org.hl7.fhir.dstu2.model.Encounter convertEncounter(org.hl7.fhir.r5.model.Encounter src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Encounter tgt = new org.hl7.fhir.dstu2.model.Encounter();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_50.convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertEncounterState(src.getStatusElement()));
        if (src.hasClass_())
            tgt.setClass_(convertEncounterClass(src.getClass_()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getType()) tgt.addType(VersionConvertor_10_50.convertCodeableConcept(t));
        if (src.hasPriority())
            tgt.setPriority(VersionConvertor_10_50.convertCodeableConcept(src.getPriority()));
        if (src.hasSubject())
            tgt.setPatient(VersionConvertor_10_50.convertReference(src.getSubject()));
        for (org.hl7.fhir.r5.model.Reference t : src.getEpisodeOfCare()) tgt.addEpisodeOfCare(VersionConvertor_10_50.convertReference(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn()) tgt.addIncomingReferral(VersionConvertor_10_50.convertReference(t));
        for (org.hl7.fhir.r5.model.Encounter.EncounterParticipantComponent t : src.getParticipant()) tgt.addParticipant(convertEncounterParticipantComponent(t));
        if (src.hasAppointment())
            tgt.setAppointment(VersionConvertor_10_50.convertReference(src.getAppointmentFirstRep()));
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_10_50.convertPeriod(src.getPeriod()));
        if (src.hasLength())
            tgt.setLength(VersionConvertor_10_50.convertDuration(src.getLength()));
        for (CodeableReference t : src.getReason()) if (t.hasConcept())
            tgt.addReason(VersionConvertor_10_50.convertCodeableConcept(t.getConcept()));
        if (src.hasHospitalization())
            tgt.setHospitalization(convertEncounterHospitalizationComponent(src.getHospitalization()));
        for (org.hl7.fhir.r5.model.Encounter.EncounterLocationComponent t : src.getLocation()) tgt.addLocation(convertEncounterLocationComponent(t));
        if (src.hasServiceProvider())
            tgt.setServiceProvider(VersionConvertor_10_50.convertReference(src.getServiceProvider()));
        if (src.hasPartOf())
            tgt.setPartOf(VersionConvertor_10_50.convertReference(src.getPartOf()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Encounter convertEncounter(org.hl7.fhir.dstu2.model.Encounter src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Encounter tgt = new org.hl7.fhir.r5.model.Encounter();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_50.convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertEncounterState(src.getStatusElement()));
        if (src.hasClass_())
            tgt.setClass_(convertEncounterClass(src.getClass_()));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getType()) tgt.addType(VersionConvertor_10_50.convertCodeableConcept(t));
        if (src.hasPriority())
            tgt.setPriority(VersionConvertor_10_50.convertCodeableConcept(src.getPriority()));
        if (src.hasPatient())
            tgt.setSubject(VersionConvertor_10_50.convertReference(src.getPatient()));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getEpisodeOfCare()) tgt.addEpisodeOfCare(VersionConvertor_10_50.convertReference(t));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getIncomingReferral()) tgt.addBasedOn(VersionConvertor_10_50.convertReference(t));
        for (org.hl7.fhir.dstu2.model.Encounter.EncounterParticipantComponent t : src.getParticipant()) tgt.addParticipant(convertEncounterParticipantComponent(t));
        if (src.hasAppointment())
            tgt.addAppointment(VersionConvertor_10_50.convertReference(src.getAppointment()));
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_10_50.convertPeriod(src.getPeriod()));
        if (src.hasLength())
            tgt.setLength(VersionConvertor_10_50.convertDuration(src.getLength()));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getReason()) tgt.addReason(VersionConvertor_10_50.convertCodeableConceptToCodableReference(t));
        if (src.hasHospitalization())
            tgt.setHospitalization(convertEncounterHospitalizationComponent(src.getHospitalization()));
        for (org.hl7.fhir.dstu2.model.Encounter.EncounterLocationComponent t : src.getLocation()) tgt.addLocation(convertEncounterLocationComponent(t));
        if (src.hasServiceProvider())
            tgt.setServiceProvider(VersionConvertor_10_50.convertReference(src.getServiceProvider()));
        if (src.hasPartOf())
            tgt.setPartOf(VersionConvertor_10_50.convertReference(src.getPartOf()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Encounter.EncounterClass convertEncounterClass(org.hl7.fhir.r5.model.Coding src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        if (src.getSystem().equals("http://terminology.hl7.org/v3/ActCode")) {
            if (src.getCode().equals("IMP"))
                return org.hl7.fhir.dstu2.model.Encounter.EncounterClass.INPATIENT;
            if (src.getCode().equals("AMB"))
                return org.hl7.fhir.dstu2.model.Encounter.EncounterClass.AMBULATORY;
            if (src.getCode().equals("EMER"))
                return org.hl7.fhir.dstu2.model.Encounter.EncounterClass.EMERGENCY;
            if (src.getCode().equals("HH"))
                return org.hl7.fhir.dstu2.model.Encounter.EncounterClass.HOME;
            if (src.getCode().equals("FLD"))
                return org.hl7.fhir.dstu2.model.Encounter.EncounterClass.FIELD;
            if (src.getCode().equals(""))
                return org.hl7.fhir.dstu2.model.Encounter.EncounterClass.DAYTIME;
            if (src.getCode().equals("VR"))
                return org.hl7.fhir.dstu2.model.Encounter.EncounterClass.VIRTUAL;
        }
        return org.hl7.fhir.dstu2.model.Encounter.EncounterClass.NULL;
    }

    public static org.hl7.fhir.r5.model.Coding convertEncounterClass(org.hl7.fhir.dstu2.model.Encounter.EncounterClass src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case INPATIENT:
                return new org.hl7.fhir.r5.model.Coding().setSystem("http://terminology.hl7.org/v3/ActCode").setCode("IMP");
            case OUTPATIENT:
                return new org.hl7.fhir.r5.model.Coding().setSystem("http://terminology.hl7.org/v3/ActCode").setCode("AMB");
            case AMBULATORY:
                return new org.hl7.fhir.r5.model.Coding().setSystem("http://terminology.hl7.org/v3/ActCode").setCode("AMB");
            case EMERGENCY:
                return new org.hl7.fhir.r5.model.Coding().setSystem("http://terminology.hl7.org/v3/ActCode").setCode("EMER");
            case HOME:
                return new org.hl7.fhir.r5.model.Coding().setSystem("http://terminology.hl7.org/v3/ActCode").setCode("HH");
            case FIELD:
                return new org.hl7.fhir.r5.model.Coding().setSystem("http://terminology.hl7.org/v3/ActCode").setCode("FLD");
            case DAYTIME:
                return new org.hl7.fhir.r5.model.Coding().setSystem("http://terminology.hl7.org/v3/ActCode").setCode("SS");
            case VIRTUAL:
                return new org.hl7.fhir.r5.model.Coding().setSystem("http://terminology.hl7.org/v3/ActCode").setCode("VR");
            default:
                return null;
        }
    }

    public static org.hl7.fhir.r5.model.Encounter.EncounterHospitalizationComponent convertEncounterHospitalizationComponent(org.hl7.fhir.dstu2.model.Encounter.EncounterHospitalizationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Encounter.EncounterHospitalizationComponent tgt = new org.hl7.fhir.r5.model.Encounter.EncounterHospitalizationComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasPreAdmissionIdentifier())
            tgt.setPreAdmissionIdentifier(VersionConvertor_10_50.convertIdentifier(src.getPreAdmissionIdentifier()));
        if (src.hasOrigin())
            tgt.setOrigin(VersionConvertor_10_50.convertReference(src.getOrigin()));
        if (src.hasAdmitSource())
            tgt.setAdmitSource(VersionConvertor_10_50.convertCodeableConcept(src.getAdmitSource()));
        if (src.hasReAdmission())
            tgt.setReAdmission(VersionConvertor_10_50.convertCodeableConcept(src.getReAdmission()));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getDietPreference()) tgt.addDietPreference(VersionConvertor_10_50.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getSpecialCourtesy()) tgt.addSpecialCourtesy(VersionConvertor_10_50.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getSpecialArrangement()) tgt.addSpecialArrangement(VersionConvertor_10_50.convertCodeableConcept(t));
        if (src.hasDestination())
            tgt.setDestination(VersionConvertor_10_50.convertReference(src.getDestination()));
        if (src.hasDischargeDisposition())
            tgt.setDischargeDisposition(VersionConvertor_10_50.convertCodeableConcept(src.getDischargeDisposition()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Encounter.EncounterHospitalizationComponent convertEncounterHospitalizationComponent(org.hl7.fhir.r5.model.Encounter.EncounterHospitalizationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Encounter.EncounterHospitalizationComponent tgt = new org.hl7.fhir.dstu2.model.Encounter.EncounterHospitalizationComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasPreAdmissionIdentifier())
            tgt.setPreAdmissionIdentifier(VersionConvertor_10_50.convertIdentifier(src.getPreAdmissionIdentifier()));
        if (src.hasOrigin())
            tgt.setOrigin(VersionConvertor_10_50.convertReference(src.getOrigin()));
        if (src.hasAdmitSource())
            tgt.setAdmitSource(VersionConvertor_10_50.convertCodeableConcept(src.getAdmitSource()));
        if (src.hasReAdmission())
            tgt.setReAdmission(VersionConvertor_10_50.convertCodeableConcept(src.getReAdmission()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getDietPreference()) tgt.addDietPreference(VersionConvertor_10_50.convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getSpecialCourtesy()) tgt.addSpecialCourtesy(VersionConvertor_10_50.convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getSpecialArrangement()) tgt.addSpecialArrangement(VersionConvertor_10_50.convertCodeableConcept(t));
        if (src.hasDestination())
            tgt.setDestination(VersionConvertor_10_50.convertReference(src.getDestination()));
        if (src.hasDischargeDisposition())
            tgt.setDischargeDisposition(VersionConvertor_10_50.convertCodeableConcept(src.getDischargeDisposition()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Encounter.EncounterLocationComponent convertEncounterLocationComponent(org.hl7.fhir.dstu2.model.Encounter.EncounterLocationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Encounter.EncounterLocationComponent tgt = new org.hl7.fhir.r5.model.Encounter.EncounterLocationComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasLocation())
            tgt.setLocation(VersionConvertor_10_50.convertReference(src.getLocation()));
        if (src.hasStatus())
            tgt.setStatusElement(convertEncounterLocationStatus(src.getStatusElement()));
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_10_50.convertPeriod(src.getPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Encounter.EncounterLocationComponent convertEncounterLocationComponent(org.hl7.fhir.r5.model.Encounter.EncounterLocationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Encounter.EncounterLocationComponent tgt = new org.hl7.fhir.dstu2.model.Encounter.EncounterLocationComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasLocation())
            tgt.setLocation(VersionConvertor_10_50.convertReference(src.getLocation()));
        if (src.hasStatus())
            tgt.setStatusElement(convertEncounterLocationStatus(src.getStatusElement()));
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_10_50.convertPeriod(src.getPeriod()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Encounter.EncounterLocationStatus> convertEncounterLocationStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Encounter.EncounterLocationStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Encounter.EncounterLocationStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Encounter.EncounterLocationStatusEnumFactory());
        VersionConvertor_10_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case PLANNED:
                tgt.setValue(org.hl7.fhir.r5.model.Encounter.EncounterLocationStatus.PLANNED);
                break;
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.r5.model.Encounter.EncounterLocationStatus.ACTIVE);
                break;
            case RESERVED:
                tgt.setValue(org.hl7.fhir.r5.model.Encounter.EncounterLocationStatus.RESERVED);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.r5.model.Encounter.EncounterLocationStatus.COMPLETED);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Encounter.EncounterLocationStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Encounter.EncounterLocationStatus> convertEncounterLocationStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Encounter.EncounterLocationStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Encounter.EncounterLocationStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Encounter.EncounterLocationStatusEnumFactory());
        VersionConvertor_10_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case PLANNED:
                tgt.setValue(org.hl7.fhir.dstu2.model.Encounter.EncounterLocationStatus.PLANNED);
                break;
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.dstu2.model.Encounter.EncounterLocationStatus.ACTIVE);
                break;
            case RESERVED:
                tgt.setValue(org.hl7.fhir.dstu2.model.Encounter.EncounterLocationStatus.RESERVED);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.dstu2.model.Encounter.EncounterLocationStatus.COMPLETED);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.Encounter.EncounterLocationStatus.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Encounter.EncounterParticipantComponent convertEncounterParticipantComponent(org.hl7.fhir.dstu2.model.Encounter.EncounterParticipantComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Encounter.EncounterParticipantComponent tgt = new org.hl7.fhir.r5.model.Encounter.EncounterParticipantComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getType()) tgt.addType(VersionConvertor_10_50.convertCodeableConcept(t));
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_10_50.convertPeriod(src.getPeriod()));
        if (src.hasIndividual())
            tgt.setIndividual(VersionConvertor_10_50.convertReference(src.getIndividual()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Encounter.EncounterParticipantComponent convertEncounterParticipantComponent(org.hl7.fhir.r5.model.Encounter.EncounterParticipantComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Encounter.EncounterParticipantComponent tgt = new org.hl7.fhir.dstu2.model.Encounter.EncounterParticipantComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getType()) tgt.addType(VersionConvertor_10_50.convertCodeableConcept(t));
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_10_50.convertPeriod(src.getPeriod()));
        if (src.hasIndividual())
            tgt.setIndividual(VersionConvertor_10_50.convertReference(src.getIndividual()));
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Encounter.EncounterState> convertEncounterState(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Encounter.EncounterStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Encounter.EncounterState> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Encounter.EncounterStateEnumFactory());
        VersionConvertor_10_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case PLANNED:
                tgt.setValue(org.hl7.fhir.dstu2.model.Encounter.EncounterState.PLANNED);
                break;
            case INPROGRESS:
                tgt.setValue(org.hl7.fhir.dstu2.model.Encounter.EncounterState.INPROGRESS);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.dstu2.model.Encounter.EncounterState.FINISHED);
                break;
            case CANCELLED:
                tgt.setValue(org.hl7.fhir.dstu2.model.Encounter.EncounterState.CANCELLED);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.Encounter.EncounterState.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Encounter.EncounterStatus> convertEncounterState(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Encounter.EncounterState> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Encounter.EncounterStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Encounter.EncounterStatusEnumFactory());
        VersionConvertor_10_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case PLANNED:
                tgt.setValue(org.hl7.fhir.r5.model.Encounter.EncounterStatus.PLANNED);
                break;
            case ARRIVED:
                tgt.setValue(org.hl7.fhir.r5.model.Encounter.EncounterStatus.INPROGRESS);
                break;
            case INPROGRESS:
                tgt.setValue(org.hl7.fhir.r5.model.Encounter.EncounterStatus.INPROGRESS);
                break;
            case ONLEAVE:
                tgt.setValue(org.hl7.fhir.r5.model.Encounter.EncounterStatus.INPROGRESS);
                break;
            case FINISHED:
                tgt.setValue(org.hl7.fhir.r5.model.Encounter.EncounterStatus.COMPLETED);
                break;
            case CANCELLED:
                tgt.setValue(org.hl7.fhir.r5.model.Encounter.EncounterStatus.CANCELLED);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Encounter.EncounterStatus.NULL);
                break;
        }
        return tgt;
    }
}