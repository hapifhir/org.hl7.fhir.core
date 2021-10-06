package org.hl7.fhir.convertors.conv30_50.resources30_50;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.String30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Parameters30_50 {

  public static org.hl7.fhir.r5.model.Parameters convertParameters(org.hl7.fhir.dstu3.model.Parameters src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Parameters tgt = new org.hl7.fhir.r5.model.Parameters();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Parameters.ParametersParameterComponent t : src.getParameter())
      tgt.addParameter(convertParametersParameterComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Parameters convertParameters(org.hl7.fhir.r5.model.Parameters src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Parameters tgt = new org.hl7.fhir.dstu3.model.Parameters();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyResource(src, tgt);
    for (org.hl7.fhir.r5.model.Parameters.ParametersParameterComponent t : src.getParameter())
      tgt.addParameter(convertParametersParameterComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Parameters.ParametersParameterComponent convertParametersParameterComponent(org.hl7.fhir.dstu3.model.Parameters.ParametersParameterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Parameters.ParametersParameterComponent tgt = new org.hl7.fhir.r5.model.Parameters.ParametersParameterComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String30_50.convertString(src.getNameElement()));
    if (src.hasValue())
      tgt.setValue(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getValue()));
    if (src.hasResource())
      tgt.setResource(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertResource(src.getResource()));
    for (org.hl7.fhir.dstu3.model.Parameters.ParametersParameterComponent t : src.getPart())
      tgt.addPart(convertParametersParameterComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Parameters.ParametersParameterComponent convertParametersParameterComponent(org.hl7.fhir.r5.model.Parameters.ParametersParameterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Parameters.ParametersParameterComponent tgt = new org.hl7.fhir.dstu3.model.Parameters.ParametersParameterComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String30_50.convertString(src.getNameElement()));
    if (src.hasValue())
      tgt.setValue(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getValue()));
    if (src.hasResource())
      tgt.setResource(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertResource(src.getResource()));
    for (org.hl7.fhir.r5.model.Parameters.ParametersParameterComponent t : src.getPart())
      tgt.addPart(convertParametersParameterComponent(t));
    return tgt;
  }
}