package org.hl7.fhir.convertors.conv30_40.resources30_40;

import org.hl7.fhir.convertors.context.ConversionContext30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.String30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Parameters30_40 {

  public static org.hl7.fhir.dstu3.model.Parameters convertParameters(org.hl7.fhir.r4.model.Parameters src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Parameters tgt = new org.hl7.fhir.dstu3.model.Parameters();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyResource(src, tgt);
    for (org.hl7.fhir.r4.model.Parameters.ParametersParameterComponent t : src.getParameter())
      tgt.addParameter(convertParametersParameterComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Parameters convertParameters(org.hl7.fhir.dstu3.model.Parameters src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Parameters tgt = new org.hl7.fhir.r4.model.Parameters();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Parameters.ParametersParameterComponent t : src.getParameter())
      tgt.addParameter(convertParametersParameterComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Parameters.ParametersParameterComponent convertParametersParameterComponent(org.hl7.fhir.r4.model.Parameters.ParametersParameterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Parameters.ParametersParameterComponent tgt = new org.hl7.fhir.dstu3.model.Parameters.ParametersParameterComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasName())
      tgt.setNameElement(String30_40.convertString(src.getNameElement()));
    if (src.hasValue())
      tgt.setValue(ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertType(src.getValue()));
    if (src.hasResource())
      tgt.setResource(ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertResource(src.getResource()));
    for (org.hl7.fhir.r4.model.Parameters.ParametersParameterComponent t : src.getPart())
      tgt.addPart(convertParametersParameterComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Parameters.ParametersParameterComponent convertParametersParameterComponent(org.hl7.fhir.dstu3.model.Parameters.ParametersParameterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Parameters.ParametersParameterComponent tgt = new org.hl7.fhir.r4.model.Parameters.ParametersParameterComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasName())
      tgt.setNameElement(String30_40.convertString(src.getNameElement()));
    if (src.hasValue())
      tgt.setValue(ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertType(src.getValue()));
    if (src.hasResource())
      tgt.setResource(ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertResource(src.getResource()));
    for (org.hl7.fhir.dstu3.model.Parameters.ParametersParameterComponent t : src.getPart())
      tgt.addPart(convertParametersParameterComponent(t));
    return tgt;
  }
}