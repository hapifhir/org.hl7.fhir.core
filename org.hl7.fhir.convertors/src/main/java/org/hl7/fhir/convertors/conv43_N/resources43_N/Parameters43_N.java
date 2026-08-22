package org.hl7.fhir.convertors.conv43_N.resources43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
import org.hl7.fhir.exceptions.FHIRException;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
  
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
*/

public class Parameters43_N {

  public static org.hl7.fhir.model.core.Parameters convertParameters(org.hl7.fhir.r4b.model.Parameters src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Parameters tgt = new org.hl7.fhir.model.core.Parameters();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Parameters.ParametersParameterComponent t : src.getParameter())
      tgt.addParameter(convertParametersParameterComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Parameters convertParameters(org.hl7.fhir.model.core.Parameters src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Parameters tgt = new org.hl7.fhir.r4b.model.Parameters();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyResource(src, tgt);
    for (org.hl7.fhir.model.core.Parameters.ParametersParameterComponent t : src.getParameterList())
      tgt.addParameter(convertParametersParameterComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Parameters.ParametersParameterComponent convertParametersParameterComponent(org.hl7.fhir.r4b.model.Parameters.ParametersParameterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Parameters.ParametersParameterComponent tgt = new org.hl7.fhir.model.core.Parameters.ParametersParameterComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String43_N.convertString(src.getNameElement()));
    if (src.hasValue())
      tgt.setValue(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getValue()));
    if (src.hasResource())
      tgt.setResource(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertResource(src.getResource()));
    for (org.hl7.fhir.r4b.model.Parameters.ParametersParameterComponent t : src.getPart())
      tgt.addPart(convertParametersParameterComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Parameters.ParametersParameterComponent convertParametersParameterComponent(org.hl7.fhir.model.core.Parameters.ParametersParameterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Parameters.ParametersParameterComponent tgt = new org.hl7.fhir.r4b.model.Parameters.ParametersParameterComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String43_N.convertString(src.getNameElement()));
    if (src.hasValue())
      tgt.setValue(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getValue()));
    if (src.hasResource())
      tgt.setResource(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertResource(src.getResource()));
    for (org.hl7.fhir.model.core.Parameters.ParametersParameterComponent t : src.getPartList())
      tgt.addPart(convertParametersParameterComponent(t));
    return tgt;
  }
}