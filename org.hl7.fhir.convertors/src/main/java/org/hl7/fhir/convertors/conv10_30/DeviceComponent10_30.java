package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class DeviceComponent10_30 {

    public static org.hl7.fhir.dstu2.model.DeviceComponent convertDeviceComponent(org.hl7.fhir.dstu3.model.DeviceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.DeviceComponent tgt = new org.hl7.fhir.dstu2.model.DeviceComponent();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasType())
            tgt.setType(VersionConvertor_10_30.convertCodeableConcept(src.getType()));
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_10_30.convertIdentifier(src.getIdentifier()));
        if (src.hasLastSystemChangeElement())
            tgt.setLastSystemChangeElement(VersionConvertor_10_30.convertInstant(src.getLastSystemChangeElement()));
        if (src.hasSource())
            tgt.setSource(VersionConvertor_10_30.convertReference(src.getSource()));
        if (src.hasParent())
            tgt.setParent(VersionConvertor_10_30.convertReference(src.getParent()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getOperationalStatus()) tgt.addOperationalStatus(VersionConvertor_10_30.convertCodeableConcept(t));
        if (src.hasParameterGroup())
            tgt.setParameterGroup(VersionConvertor_10_30.convertCodeableConcept(src.getParameterGroup()));
        if (src.hasMeasurementPrinciple())
            tgt.setMeasurementPrincipleElement(convertMeasmntPrinciple(src.getMeasurementPrincipleElement()));
        for (org.hl7.fhir.dstu3.model.DeviceComponent.DeviceComponentProductionSpecificationComponent t : src.getProductionSpecification()) tgt.addProductionSpecification(convertDeviceComponentProductionSpecificationComponent(t));
        if (src.hasLanguageCode())
            tgt.setLanguageCode(VersionConvertor_10_30.convertCodeableConcept(src.getLanguageCode()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DeviceComponent convertDeviceComponent(org.hl7.fhir.dstu2.model.DeviceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.DeviceComponent tgt = new org.hl7.fhir.dstu3.model.DeviceComponent();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasType())
            tgt.setType(VersionConvertor_10_30.convertCodeableConcept(src.getType()));
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_10_30.convertIdentifier(src.getIdentifier()));
        if (src.hasLastSystemChangeElement())
            tgt.setLastSystemChangeElement(VersionConvertor_10_30.convertInstant(src.getLastSystemChangeElement()));
        if (src.hasSource())
            tgt.setSource(VersionConvertor_10_30.convertReference(src.getSource()));
        if (src.hasParent())
            tgt.setParent(VersionConvertor_10_30.convertReference(src.getParent()));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getOperationalStatus()) tgt.addOperationalStatus(VersionConvertor_10_30.convertCodeableConcept(t));
        if (src.hasParameterGroup())
            tgt.setParameterGroup(VersionConvertor_10_30.convertCodeableConcept(src.getParameterGroup()));
        if (src.hasMeasurementPrinciple())
            tgt.setMeasurementPrincipleElement(convertMeasmntPrinciple(src.getMeasurementPrincipleElement()));
        for (org.hl7.fhir.dstu2.model.DeviceComponent.DeviceComponentProductionSpecificationComponent t : src.getProductionSpecification()) tgt.addProductionSpecification(convertDeviceComponentProductionSpecificationComponent(t));
        if (src.hasLanguageCode())
            tgt.setLanguageCode(VersionConvertor_10_30.convertCodeableConcept(src.getLanguageCode()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DeviceComponent.DeviceComponentProductionSpecificationComponent convertDeviceComponentProductionSpecificationComponent(org.hl7.fhir.dstu2.model.DeviceComponent.DeviceComponentProductionSpecificationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.DeviceComponent.DeviceComponentProductionSpecificationComponent tgt = new org.hl7.fhir.dstu3.model.DeviceComponent.DeviceComponentProductionSpecificationComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasSpecType())
            tgt.setSpecType(VersionConvertor_10_30.convertCodeableConcept(src.getSpecType()));
        if (src.hasComponentId())
            tgt.setComponentId(VersionConvertor_10_30.convertIdentifier(src.getComponentId()));
        if (src.hasProductionSpecElement())
            tgt.setProductionSpecElement(VersionConvertor_10_30.convertString(src.getProductionSpecElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.DeviceComponent.DeviceComponentProductionSpecificationComponent convertDeviceComponentProductionSpecificationComponent(org.hl7.fhir.dstu3.model.DeviceComponent.DeviceComponentProductionSpecificationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.DeviceComponent.DeviceComponentProductionSpecificationComponent tgt = new org.hl7.fhir.dstu2.model.DeviceComponent.DeviceComponentProductionSpecificationComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasSpecType())
            tgt.setSpecType(VersionConvertor_10_30.convertCodeableConcept(src.getSpecType()));
        if (src.hasComponentId())
            tgt.setComponentId(VersionConvertor_10_30.convertIdentifier(src.getComponentId()));
        if (src.hasProductionSpecElement())
            tgt.setProductionSpecElement(VersionConvertor_10_30.convertString(src.getProductionSpecElement()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.DeviceComponent.MeasmntPrinciple> convertMeasmntPrinciple(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.DeviceComponent.MeasmntPrinciple> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.DeviceComponent.MeasmntPrinciple> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.DeviceComponent.MeasmntPrincipleEnumFactory());
        VersionConvertor_10_30.copyElement(src, tgt);
        switch(src.getValue()) {
            case OTHER:
                tgt.setValue(org.hl7.fhir.dstu3.model.DeviceComponent.MeasmntPrinciple.OTHER);
                break;
            case CHEMICAL:
                tgt.setValue(org.hl7.fhir.dstu3.model.DeviceComponent.MeasmntPrinciple.CHEMICAL);
                break;
            case ELECTRICAL:
                tgt.setValue(org.hl7.fhir.dstu3.model.DeviceComponent.MeasmntPrinciple.ELECTRICAL);
                break;
            case IMPEDANCE:
                tgt.setValue(org.hl7.fhir.dstu3.model.DeviceComponent.MeasmntPrinciple.IMPEDANCE);
                break;
            case NUCLEAR:
                tgt.setValue(org.hl7.fhir.dstu3.model.DeviceComponent.MeasmntPrinciple.NUCLEAR);
                break;
            case OPTICAL:
                tgt.setValue(org.hl7.fhir.dstu3.model.DeviceComponent.MeasmntPrinciple.OPTICAL);
                break;
            case THERMAL:
                tgt.setValue(org.hl7.fhir.dstu3.model.DeviceComponent.MeasmntPrinciple.THERMAL);
                break;
            case BIOLOGICAL:
                tgt.setValue(org.hl7.fhir.dstu3.model.DeviceComponent.MeasmntPrinciple.BIOLOGICAL);
                break;
            case MECHANICAL:
                tgt.setValue(org.hl7.fhir.dstu3.model.DeviceComponent.MeasmntPrinciple.MECHANICAL);
                break;
            case ACOUSTICAL:
                tgt.setValue(org.hl7.fhir.dstu3.model.DeviceComponent.MeasmntPrinciple.ACOUSTICAL);
                break;
            case MANUAL:
                tgt.setValue(org.hl7.fhir.dstu3.model.DeviceComponent.MeasmntPrinciple.MANUAL);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.DeviceComponent.MeasmntPrinciple.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.DeviceComponent.MeasmntPrinciple> convertMeasmntPrinciple(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.DeviceComponent.MeasmntPrinciple> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.DeviceComponent.MeasmntPrinciple> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.DeviceComponent.MeasmntPrincipleEnumFactory());
        VersionConvertor_10_30.copyElement(src, tgt);
        switch(src.getValue()) {
            case OTHER:
                tgt.setValue(org.hl7.fhir.dstu2.model.DeviceComponent.MeasmntPrinciple.OTHER);
                break;
            case CHEMICAL:
                tgt.setValue(org.hl7.fhir.dstu2.model.DeviceComponent.MeasmntPrinciple.CHEMICAL);
                break;
            case ELECTRICAL:
                tgt.setValue(org.hl7.fhir.dstu2.model.DeviceComponent.MeasmntPrinciple.ELECTRICAL);
                break;
            case IMPEDANCE:
                tgt.setValue(org.hl7.fhir.dstu2.model.DeviceComponent.MeasmntPrinciple.IMPEDANCE);
                break;
            case NUCLEAR:
                tgt.setValue(org.hl7.fhir.dstu2.model.DeviceComponent.MeasmntPrinciple.NUCLEAR);
                break;
            case OPTICAL:
                tgt.setValue(org.hl7.fhir.dstu2.model.DeviceComponent.MeasmntPrinciple.OPTICAL);
                break;
            case THERMAL:
                tgt.setValue(org.hl7.fhir.dstu2.model.DeviceComponent.MeasmntPrinciple.THERMAL);
                break;
            case BIOLOGICAL:
                tgt.setValue(org.hl7.fhir.dstu2.model.DeviceComponent.MeasmntPrinciple.BIOLOGICAL);
                break;
            case MECHANICAL:
                tgt.setValue(org.hl7.fhir.dstu2.model.DeviceComponent.MeasmntPrinciple.MECHANICAL);
                break;
            case ACOUSTICAL:
                tgt.setValue(org.hl7.fhir.dstu2.model.DeviceComponent.MeasmntPrinciple.ACOUSTICAL);
                break;
            case MANUAL:
                tgt.setValue(org.hl7.fhir.dstu2.model.DeviceComponent.MeasmntPrinciple.MANUAL);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.DeviceComponent.MeasmntPrinciple.NULL);
                break;
        }
        return tgt;
    }
}