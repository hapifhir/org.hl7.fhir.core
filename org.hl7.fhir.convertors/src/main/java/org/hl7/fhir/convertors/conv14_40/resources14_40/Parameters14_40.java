package org.hl7.fhir.convertors.conv14_40.resources14_40;

import org.hl7.fhir.convertors.conv14_40.VersionConvertor_14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.Element14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.Type14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.String14_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Parameters14_40 {

    public static org.hl7.fhir.dstu2016may.model.Parameters convertParameters(org.hl7.fhir.r4.model.Parameters src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Parameters tgt = new org.hl7.fhir.dstu2016may.model.Parameters();
        VersionConvertor_14_40.copyResource(src, tgt);
        for (org.hl7.fhir.r4.model.Parameters.ParametersParameterComponent t : src.getParameter()) tgt.addParameter(convertParametersParameterComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Parameters convertParameters(org.hl7.fhir.dstu2016may.model.Parameters src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Parameters tgt = new org.hl7.fhir.r4.model.Parameters();
        VersionConvertor_14_40.copyResource(src, tgt);
        for (org.hl7.fhir.dstu2016may.model.Parameters.ParametersParameterComponent t : src.getParameter()) tgt.addParameter(convertParametersParameterComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Parameters.ParametersParameterComponent convertParametersParameterComponent(org.hl7.fhir.dstu2016may.model.Parameters.ParametersParameterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Parameters.ParametersParameterComponent tgt = new org.hl7.fhir.r4.model.Parameters.ParametersParameterComponent();
        Element14_40.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(String14_40.convertString(src.getNameElement()));
        if (src.hasValue())
            tgt.setValue(Type14_40.convertType(src.getValue()));
        if (src.hasResource())
            tgt.setResource(VersionConvertor_14_40.convertResource(src.getResource()));
        for (org.hl7.fhir.dstu2016may.model.Parameters.ParametersParameterComponent t : src.getPart()) tgt.addPart(convertParametersParameterComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Parameters.ParametersParameterComponent convertParametersParameterComponent(org.hl7.fhir.r4.model.Parameters.ParametersParameterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Parameters.ParametersParameterComponent tgt = new org.hl7.fhir.dstu2016may.model.Parameters.ParametersParameterComponent();
        Element14_40.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(String14_40.convertString(src.getNameElement()));
        if (src.hasValue())
            tgt.setValue(Type14_40.convertType(src.getValue()));
        if (src.hasResource())
            tgt.setResource(VersionConvertor_14_40.convertResource(src.getResource()));
        for (org.hl7.fhir.r4.model.Parameters.ParametersParameterComponent t : src.getPart()) tgt.addPart(convertParametersParameterComponent(t));
        return tgt;
    }
}