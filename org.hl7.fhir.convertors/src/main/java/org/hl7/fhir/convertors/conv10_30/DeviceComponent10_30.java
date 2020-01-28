package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class DeviceComponent10_30 {

    public static org.hl7.fhir.dstu2.model.DeviceComponent convertDeviceComponent(org.hl7.fhir.dstu3.model.DeviceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.DeviceComponent tgt = new org.hl7.fhir.dstu2.model.DeviceComponent();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        tgt.setType(VersionConvertor_10_30.convertCodeableConcept(src.getType()));
        tgt.setIdentifier(VersionConvertor_10_30.convertIdentifier(src.getIdentifier()));
        tgt.setLastSystemChange(src.getLastSystemChange());
        tgt.setSource(VersionConvertor_10_30.convertReference(src.getSource()));
        tgt.setParent(VersionConvertor_10_30.convertReference(src.getParent()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getOperationalStatus()) tgt.addOperationalStatus(VersionConvertor_10_30.convertCodeableConcept(t));
        tgt.setParameterGroup(VersionConvertor_10_30.convertCodeableConcept(src.getParameterGroup()));
        tgt.setMeasurementPrinciple(convertMeasmntPrinciple(src.getMeasurementPrinciple()));
        for (org.hl7.fhir.dstu3.model.DeviceComponent.DeviceComponentProductionSpecificationComponent t : src.getProductionSpecification()) tgt.addProductionSpecification(convertDeviceComponentProductionSpecificationComponent(t));
        tgt.setLanguageCode(VersionConvertor_10_30.convertCodeableConcept(src.getLanguageCode()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DeviceComponent convertDeviceComponent(org.hl7.fhir.dstu2.model.DeviceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.DeviceComponent tgt = new org.hl7.fhir.dstu3.model.DeviceComponent();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        tgt.setType(VersionConvertor_10_30.convertCodeableConcept(src.getType()));
        tgt.setIdentifier(VersionConvertor_10_30.convertIdentifier(src.getIdentifier()));
        tgt.setLastSystemChange(src.getLastSystemChange());
        tgt.setSource(VersionConvertor_10_30.convertReference(src.getSource()));
        tgt.setParent(VersionConvertor_10_30.convertReference(src.getParent()));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getOperationalStatus()) tgt.addOperationalStatus(VersionConvertor_10_30.convertCodeableConcept(t));
        tgt.setParameterGroup(VersionConvertor_10_30.convertCodeableConcept(src.getParameterGroup()));
        tgt.setMeasurementPrinciple(convertMeasmntPrinciple(src.getMeasurementPrinciple()));
        for (org.hl7.fhir.dstu2.model.DeviceComponent.DeviceComponentProductionSpecificationComponent t : src.getProductionSpecification()) tgt.addProductionSpecification(convertDeviceComponentProductionSpecificationComponent(t));
        tgt.setLanguageCode(VersionConvertor_10_30.convertCodeableConcept(src.getLanguageCode()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DeviceComponent.DeviceComponentProductionSpecificationComponent convertDeviceComponentProductionSpecificationComponent(org.hl7.fhir.dstu2.model.DeviceComponent.DeviceComponentProductionSpecificationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.DeviceComponent.DeviceComponentProductionSpecificationComponent tgt = new org.hl7.fhir.dstu3.model.DeviceComponent.DeviceComponentProductionSpecificationComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setSpecType(VersionConvertor_10_30.convertCodeableConcept(src.getSpecType()));
        tgt.setComponentId(VersionConvertor_10_30.convertIdentifier(src.getComponentId()));
        tgt.setProductionSpec(src.getProductionSpec());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.DeviceComponent.DeviceComponentProductionSpecificationComponent convertDeviceComponentProductionSpecificationComponent(org.hl7.fhir.dstu3.model.DeviceComponent.DeviceComponentProductionSpecificationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.DeviceComponent.DeviceComponentProductionSpecificationComponent tgt = new org.hl7.fhir.dstu2.model.DeviceComponent.DeviceComponentProductionSpecificationComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setSpecType(VersionConvertor_10_30.convertCodeableConcept(src.getSpecType()));
        tgt.setComponentId(VersionConvertor_10_30.convertIdentifier(src.getComponentId()));
        tgt.setProductionSpec(src.getProductionSpec());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DeviceComponent.MeasmntPrinciple convertMeasmntPrinciple(org.hl7.fhir.dstu2.model.DeviceComponent.MeasmntPrinciple src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case OTHER:
                return org.hl7.fhir.dstu3.model.DeviceComponent.MeasmntPrinciple.OTHER;
            case CHEMICAL:
                return org.hl7.fhir.dstu3.model.DeviceComponent.MeasmntPrinciple.CHEMICAL;
            case ELECTRICAL:
                return org.hl7.fhir.dstu3.model.DeviceComponent.MeasmntPrinciple.ELECTRICAL;
            case IMPEDANCE:
                return org.hl7.fhir.dstu3.model.DeviceComponent.MeasmntPrinciple.IMPEDANCE;
            case NUCLEAR:
                return org.hl7.fhir.dstu3.model.DeviceComponent.MeasmntPrinciple.NUCLEAR;
            case OPTICAL:
                return org.hl7.fhir.dstu3.model.DeviceComponent.MeasmntPrinciple.OPTICAL;
            case THERMAL:
                return org.hl7.fhir.dstu3.model.DeviceComponent.MeasmntPrinciple.THERMAL;
            case BIOLOGICAL:
                return org.hl7.fhir.dstu3.model.DeviceComponent.MeasmntPrinciple.BIOLOGICAL;
            case MECHANICAL:
                return org.hl7.fhir.dstu3.model.DeviceComponent.MeasmntPrinciple.MECHANICAL;
            case ACOUSTICAL:
                return org.hl7.fhir.dstu3.model.DeviceComponent.MeasmntPrinciple.ACOUSTICAL;
            case MANUAL:
                return org.hl7.fhir.dstu3.model.DeviceComponent.MeasmntPrinciple.MANUAL;
            default:
                return org.hl7.fhir.dstu3.model.DeviceComponent.MeasmntPrinciple.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.DeviceComponent.MeasmntPrinciple convertMeasmntPrinciple(org.hl7.fhir.dstu3.model.DeviceComponent.MeasmntPrinciple src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case OTHER:
                return org.hl7.fhir.dstu2.model.DeviceComponent.MeasmntPrinciple.OTHER;
            case CHEMICAL:
                return org.hl7.fhir.dstu2.model.DeviceComponent.MeasmntPrinciple.CHEMICAL;
            case ELECTRICAL:
                return org.hl7.fhir.dstu2.model.DeviceComponent.MeasmntPrinciple.ELECTRICAL;
            case IMPEDANCE:
                return org.hl7.fhir.dstu2.model.DeviceComponent.MeasmntPrinciple.IMPEDANCE;
            case NUCLEAR:
                return org.hl7.fhir.dstu2.model.DeviceComponent.MeasmntPrinciple.NUCLEAR;
            case OPTICAL:
                return org.hl7.fhir.dstu2.model.DeviceComponent.MeasmntPrinciple.OPTICAL;
            case THERMAL:
                return org.hl7.fhir.dstu2.model.DeviceComponent.MeasmntPrinciple.THERMAL;
            case BIOLOGICAL:
                return org.hl7.fhir.dstu2.model.DeviceComponent.MeasmntPrinciple.BIOLOGICAL;
            case MECHANICAL:
                return org.hl7.fhir.dstu2.model.DeviceComponent.MeasmntPrinciple.MECHANICAL;
            case ACOUSTICAL:
                return org.hl7.fhir.dstu2.model.DeviceComponent.MeasmntPrinciple.ACOUSTICAL;
            case MANUAL:
                return org.hl7.fhir.dstu2.model.DeviceComponent.MeasmntPrinciple.MANUAL;
            default:
                return org.hl7.fhir.dstu2.model.DeviceComponent.MeasmntPrinciple.NULL;
        }
    }
}
