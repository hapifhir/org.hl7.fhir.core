package org.hl7.fhir.convertors.conv10_30.resources10_30;

import org.hl7.fhir.convertors.context.ConversionContext10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.String10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Parameters10_30 {

  public static org.hl7.fhir.dstu3.model.Parameters convertParameters(org.hl7.fhir.dstu2.model.Parameters src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Parameters tgt = new org.hl7.fhir.dstu3.model.Parameters();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyResource(src, tgt);
    for (org.hl7.fhir.dstu2.model.Parameters.ParametersParameterComponent t : src.getParameter())
      tgt.addParameter(convertParametersParameterComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Parameters convertParameters(org.hl7.fhir.dstu3.model.Parameters src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Parameters tgt = new org.hl7.fhir.dstu2.model.Parameters();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Parameters.ParametersParameterComponent t : src.getParameter())
      tgt.addParameter(convertParametersParameterComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Parameters.ParametersParameterComponent convertParametersParameterComponent(org.hl7.fhir.dstu2.model.Parameters.ParametersParameterComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Parameters.ParametersParameterComponent tgt = new org.hl7.fhir.dstu3.model.Parameters.ParametersParameterComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyBackboneElement(src,tgt);
    if (src.hasNameElement())
      tgt.setNameElement(String10_30.convertString(src.getNameElement()));
    if (src.hasValue())
      tgt.setValue(ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().convertType(src.getValue()));
    if (src.hasResource())
      tgt.setResource(ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().convertResource(src.getResource()));
    for (org.hl7.fhir.dstu2.model.Parameters.ParametersParameterComponent t : src.getPart())
      tgt.addPart(convertParametersParameterComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Parameters.ParametersParameterComponent convertParametersParameterComponent(org.hl7.fhir.dstu3.model.Parameters.ParametersParameterComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Parameters.ParametersParameterComponent tgt = new org.hl7.fhir.dstu2.model.Parameters.ParametersParameterComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyBackboneElement(src,tgt);
    if (src.hasNameElement())
      tgt.setNameElement(String10_30.convertString(src.getNameElement()));
    if (src.hasValue())
      tgt.setValue(ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().convertType(src.getValue()));
    if (src.hasResource())
      tgt.setResource(ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().convertResource(src.getResource()));
    for (org.hl7.fhir.dstu3.model.Parameters.ParametersParameterComponent t : src.getPart())
      tgt.addPart(convertParametersParameterComponent(t));
    return tgt;
  }
}