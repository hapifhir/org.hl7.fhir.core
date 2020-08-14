package org.hl7.fhir.convertors.conv10_40;

import org.hl7.fhir.convertors.VersionConvertor_10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Parameters10_40 {

    public static org.hl7.fhir.dstu2.model.Parameters convertParameters(org.hl7.fhir.r4.model.Parameters src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Parameters tgt = new org.hl7.fhir.dstu2.model.Parameters();
        VersionConvertor_10_40.copyResource(src, tgt);
        for (org.hl7.fhir.r4.model.Parameters.ParametersParameterComponent t : src.getParameter()) tgt.addParameter(convertParametersParameterComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Parameters convertParameters(org.hl7.fhir.dstu2.model.Parameters src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Parameters tgt = new org.hl7.fhir.r4.model.Parameters();
        VersionConvertor_10_40.copyResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Parameters.ParametersParameterComponent t : src.getParameter()) tgt.addParameter(convertParametersParameterComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Parameters.ParametersParameterComponent convertParametersParameterComponent(org.hl7.fhir.r4.model.Parameters.ParametersParameterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Parameters.ParametersParameterComponent tgt = new org.hl7.fhir.dstu2.model.Parameters.ParametersParameterComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_40.convertString(src.getNameElement()));
        if (src.hasValue())
            tgt.setValue(VersionConvertor_10_40.convertType(src.getValue()));
        if (src.hasResource())
            tgt.setResource(VersionConvertor_10_40.convertResource(src.getResource()));
        for (org.hl7.fhir.r4.model.Parameters.ParametersParameterComponent t : src.getPart()) tgt.addPart(convertParametersParameterComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Parameters.ParametersParameterComponent convertParametersParameterComponent(org.hl7.fhir.dstu2.model.Parameters.ParametersParameterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Parameters.ParametersParameterComponent tgt = new org.hl7.fhir.r4.model.Parameters.ParametersParameterComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_40.convertString(src.getNameElement()));
        if (src.hasValue())
            tgt.setValue(VersionConvertor_10_40.convertType(src.getValue()));
        if (src.hasResource())
            tgt.setResource(VersionConvertor_10_40.convertResource(src.getResource()));
        for (org.hl7.fhir.dstu2.model.Parameters.ParametersParameterComponent t : src.getPart()) tgt.addPart(convertParametersParameterComponent(t));
        return tgt;
    }
}