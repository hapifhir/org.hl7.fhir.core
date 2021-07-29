package org.hl7.fhir.convertors.conv14_50.resources14_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv14_50.VersionConvertor_14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.Element14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.Type14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.String14_50;
import org.hl7.fhir.exceptions.FHIRException; import org.hl7.fhir.convertors.context.ConversionContext14_50;

public class Parameters14_50 {

    public static org.hl7.fhir.dstu2016may.model.Parameters convertParameters(org.hl7.fhir.r5.model.Parameters src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Parameters tgt = new org.hl7.fhir.dstu2016may.model.Parameters();
      ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyResource(src, tgt);
        for (org.hl7.fhir.r5.model.Parameters.ParametersParameterComponent t : src.getParameter()) tgt.addParameter(convertParametersParameterComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Parameters convertParameters(org.hl7.fhir.dstu2016may.model.Parameters src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Parameters tgt = new org.hl7.fhir.r5.model.Parameters();
      ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyResource(src, tgt);
        for (org.hl7.fhir.dstu2016may.model.Parameters.ParametersParameterComponent t : src.getParameter()) tgt.addParameter(convertParametersParameterComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Parameters.ParametersParameterComponent convertParametersParameterComponent(org.hl7.fhir.dstu2016may.model.Parameters.ParametersParameterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Parameters.ParametersParameterComponent tgt = new org.hl7.fhir.r5.model.Parameters.ParametersParameterComponent();
        ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(String14_50.convertString(src.getNameElement()));
        if (src.hasValue())
            tgt.setValue(ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().convertType(src.getValue()));
        if (src.hasResource())
            tgt.setResource(ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().convertResource(src.getResource()));
        for (org.hl7.fhir.dstu2016may.model.Parameters.ParametersParameterComponent t : src.getPart()) tgt.addPart(convertParametersParameterComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Parameters.ParametersParameterComponent convertParametersParameterComponent(org.hl7.fhir.r5.model.Parameters.ParametersParameterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Parameters.ParametersParameterComponent tgt = new org.hl7.fhir.dstu2016may.model.Parameters.ParametersParameterComponent();
        ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(String14_50.convertString(src.getNameElement()));
        if (src.hasValue())
            tgt.setValue(ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().convertType(src.getValue()));
        if (src.hasResource())
            tgt.setResource(ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().convertResource(src.getResource()));
        for (org.hl7.fhir.r5.model.Parameters.ParametersParameterComponent t : src.getPart()) tgt.addPart(convertParametersParameterComponent(t));
        return tgt;
    }
}